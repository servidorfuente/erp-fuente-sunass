package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadConceptoDao;
import erp.realcoresystems.pe.model.dao.SeguridadConceptoVistaDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamania on 22/12/2015.
 */
@Repository
public class SeguridadConceptoVistaDaoImpl extends AbstractDaoImpl<Vistaconceptoautoriza, String> implements SeguridadConceptoVistaDao {
    protected SeguridadConceptoVistaDaoImpl() {
        super(Vistaconceptoautoriza.class);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Vistaconceptoautoriza> SeguridadConceptoVistaLista(Vistaconceptoautoriza vistaconceptoautoriza, ArrayList<String> elemIn) {
        String[] inEstados = { "S", "O" };
        Criteria criteria = getCurrentSession().createCriteria(Vistaconceptoautoriza.class);
        criteria.add(Restrictions.in("usuario", elemIn));
        criteria.add(Restrictions.eq("aplicacioncodigo", vistaconceptoautoriza.getAplicacioncodigo()));
        
        if (UtilesCommons.noEsVacio(vistaconceptoautoriza.getTipodeacceso())){
        	criteria.add(Restrictions.eq("tipodeacceso", vistaconceptoautoriza.getTipodeacceso()));	
        } 
        
        if (!"T".equals(vistaconceptoautoriza.getOpcionagregarflag())){
        	criteria.add(Restrictions.eq("grupo", vistaconceptoautoriza.getGrupo()));	
        }        
        if (vistaconceptoautoriza.getXestado().equals("P")){
            criteria.add(Restrictions.in("visibleflag", inEstados));
        }else{
            criteria.add(Restrictions.eq("visibleflag", "S"));
        }
        if (!"T".equals(vistaconceptoautoriza.getOpcionagregarflag())){
            if (vistaconceptoautoriza.getConceptopadre()!=null) {
                criteria.add(Restrictions.eq("conceptopadre", vistaconceptoautoriza.getConceptopadre()));
            }else{
                criteria.add(Restrictions.isNull("conceptopadre"));
            }        	
        }

        return (List<Vistaconceptoautoriza>) criteria.list();
    }

    @Override
    public Vistaconceptoautoriza SeguridadConceptoVistaBuscar(Vistaconceptoautoriza vistaconceptoautoriza, ArrayList<String> elemIn) {

        String[] inEstados = { "S", "O" };
        Criteria criteria = getCurrentSession().createCriteria(Vistaconceptoautoriza.class);
        
        if (UtilesCommons.noEsVacio(vistaconceptoautoriza.getTipodeacceso())){
        	criteria.add(Restrictions.eq("tipodeacceso", vistaconceptoautoriza.getTipodeacceso()));	
        }          
        criteria.add(Restrictions.eq("visibleflag", "S"));
        criteria.add(Restrictions.eq("conceptopadre",vistaconceptoautoriza.getGrupo()));
        criteria.add(Restrictions.in("usuario", elemIn));
      
        criteria.setMaxResults(1);
        return (Vistaconceptoautoriza) criteria.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Vistaconceptoautoriza> listarElementos(Vistaconceptoautoriza objDao) {        
        Criteria criteria = getCurrentSession().createCriteria(Vistaconceptoautoriza.class);
		if (objDao.getEstado() != null && !objDao.getEstado().isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		
        if (UtilesCommons.noEsVacio(objDao.getTipodeacceso())){
        	criteria.add(Restrictions.eq("tipodeacceso", objDao.getTipodeacceso()));	
        } 
        
		if (objDao.getAplicacioncodigo() != null && !"".equals(objDao.getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}
		if (objDao.getGrupo() != null && !"".equals(objDao.getGrupo())) {
			criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		}
		if (objDao.getConcepto() != null && !"".equals(objDao.getConcepto())) {
			criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		}
		if (objDao.getUsuario() != null && !"".equals(objDao.getUsuario())) {
			criteria.add(Restrictions.eq("usuario", objDao.getUsuario()));
		}
		if (objDao.getConceptopadre() != null && !"".equals(objDao.getConceptopadre())) {
			criteria.add(Restrictions.eq("conceptopadre", objDao.getConceptopadre()));
		}
		if (objDao.getVisibleflag() != null && !"".equals(objDao.getVisibleflag())) {
			criteria.add(Restrictions.eq("visibleflag", objDao.getVisibleflag()));
		}
		
		if (UtilesCommons.noEsVacio(objDao.getDescripcion())) {
			criteria.add(
					Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE)
							.ignoreCase());
		}
		
		if (UtilesCommons.noEsVacio(objDao.getTipodeobjeto())) {
			if ("NO_IN_TIPODEOBJETO".equals(objDao.getFlagConsultaEntGlobal())) {
				criteria.add(Restrictions.ne("tipodeobjeto", objDao.getTipodeobjeto()));
			}else{
				criteria.add(Restrictions.eq("tipodeobjeto", objDao.getTipodeobjeto()));
			}
		}		
		
		
		if (objDao.isOrdernable()) {
			if (UtilesCommons.noEsVacio(objDao.getAtributoOrdenacion())) {
				criteria.addOrder(Property.forName(objDao.getAtributoOrdenacion()).asc());
			}	
		}
						
		
        return (List<Vistaconceptoautoriza>) criteria.list();
	}
}
