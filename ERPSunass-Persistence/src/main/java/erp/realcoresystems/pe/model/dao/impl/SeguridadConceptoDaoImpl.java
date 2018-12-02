package erp.realcoresystems.pe.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadConceptoDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;

/**
 * Created by mamania on 22/12/2015.
 */
@Repository
public class SeguridadConceptoDaoImpl extends AbstractDaoImpl<Seguridadconcepto, String> implements SeguridadConceptoDao {
    protected SeguridadConceptoDaoImpl() {
        super(Seguridadconcepto.class);
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Seguridadconcepto obtenerPorId(Seguridadconcepto seguridadconcepto) {
    	Criteria criteria = getCurrentSession().createCriteria(Seguridadconcepto.class);
		criteria.add(Restrictions.eq("concepto", seguridadconcepto.getConcepto()));
		criteria.add(Restrictions.eq("aplicacioncodigo", seguridadconcepto.getAplicacioncodigo()));
		criteria.add(Restrictions.eq("grupo", seguridadconcepto.getGrupo()));
		return (Seguridadconcepto) criteria.uniqueResult();
	}
    
    @Override
	public List<Seguridadconcepto> listar(Seguridadconcepto seguridadconcepto) {
    	Criteria criteria = getCurrentSession().createCriteria(Seguridadconcepto.class);
		criteria.setFirstResult(seguridadconcepto.getInicio());
		criteria.setMaxResults(seguridadconcepto.getNumeroFilas());
		criteria.setFetchSize(seguridadconcepto.getNumeroFilas());

		if (seguridadconcepto.getAplicacioncodigo() != null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", seguridadconcepto.getAplicacioncodigo()));
		}

		return (List<Seguridadconcepto>) criteria.list();
	}
    
    @Override
	public int contar(Seguridadconcepto seguridadconcepto) {
    	Criteria criteria = getCurrentSession().createCriteria(Seguridadconcepto.class);
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
    
    @Override
	public int guardar(Seguridadconcepto seguridad) {    	
		Criteria criteria = getCurrentSession().createCriteria(Seguridadconcepto.class)
				.setProjection(Projections.max("concepto"));
		criteria.add(Restrictions.eq("grupo", seguridad.getGrupo()));
		criteria.add(Restrictions.eq("aplicacioncodigo", seguridad.getAplicacioncodigo()));
		
		Object o = criteria.uniqueResult();
		String id = o == null ? "" : (String) o;
		seguridad.setConcepto(id);
		save(seguridad);
    	return 0;
	}
    
	@Override
	public int actualizar(Seguridadconcepto seguridad) {
		update(seguridad);
		return 0;
	}
	
    @Override
    public List<Seguridadconcepto> SeguridadConceptoLista(Seguridadautorizaciones seguridadAutorizaciones) {
        Query query;
        if (seguridadAutorizaciones.getConceptoPadreEntGlobal()!=null){
            query = getCurrentSession().createSQLQuery("select   SeguridadConcepto.aplicacioncodigo,SeguridadConcepto.grupo,\n" +
                    "        SeguridadConcepto.concepto, SeguridadConcepto.conceptopadre, \n" +
                    "        SeguridadConcepto.descripcion, SeguridadConcepto.visibleflag,\n" +
                    "        SeguridadConcepto.tipodeobjeto,SeguridadConcepto.objeto  " +
                    "from SeguridadConcepto inner join SeguridadAutorizaciones " +
                    " on SeguridadConcepto.Concepto= SeguridadAutorizaciones.Concepto " +
                    " and  SeguridadConcepto.aplicacionCodigo = SeguridadAutorizaciones.aplicacionCodigo "+
                    " and SeguridadConcepto.grupo = SeguridadAutorizaciones.grupo "+
                    "where SeguridadAutorizaciones.Usuario = :usuario " +
                    "and SeguridadConcepto.visibleFlag = 'S' "+
                    "and SeguridadConcepto.ConceptoPadre = :conceptoPadre "+
                    "and SeguridadConcepto.aplicacionCodigo = :aplicacionCodigo "+
                    "and SeguridadConcepto.grupo = :grupo ");

            query.setParameter("usuario", seguridadAutorizaciones.getUsuario());
            query.setParameter("aplicacionCodigo", "RM");
            query.setParameter("grupo", "GRUPO2");
            query.setParameter("conceptoPadre", seguridadAutorizaciones.getConceptoPadreEntGlobal());

        }else{
            query = getCurrentSession().createSQLQuery("select   SeguridadConcepto.aplicacioncodigo,SeguridadConcepto.grupo,\n" +
                    "        SeguridadConcepto.concepto, SeguridadConcepto.conceptopadre, \n" +
                    "        SeguridadConcepto.descripcion, SeguridadConcepto.visibleflag,\n" +
                    "        SeguridadConcepto.tipodeobjeto,SeguridadConcepto.objeto  " +
                    " from SeguridadConcepto inner join SeguridadAutorizaciones " +
                    " on SeguridadConcepto.Concepto= SeguridadAutorizaciones.Concepto " +
                    " and  SeguridadConcepto.aplicacionCodigo = SeguridadAutorizaciones.aplicacionCodigo "+
                    " and SeguridadConcepto.grupo = SeguridadAutorizaciones.grupo "+
                    "where SeguridadAutorizaciones.Usuario = :usuario " +
                    "and SeguridadConcepto.ConceptoPadre IS NULL "+
                    "and SeguridadConcepto.visibleFlag = 'S' "+
                    "and SeguridadConcepto.aplicacionCodigo = :aplicacionCodigo "+
                    "and SeguridadConcepto.grupo = :grupo ");
            query.setParameter("aplicacionCodigo", "RM");
            query.setParameter("grupo", "GRUPO2");
            query.setParameter("usuario", seguridadAutorizaciones.getUsuario());
        }

        Seguridadconcepto seguridadConcepto = new  Seguridadconcepto();
        List<Object> result = (List<Object>) query.list();
        List<Seguridadconcepto> resulEnvio =  new ArrayList<Seguridadconcepto>();
        for (Object ojb : result){
            Object[] objs = (Object[]) ojb;
            seguridadConcepto = new  Seguridadconcepto();
            if (objs[0] != null)seguridadConcepto.setAplicacioncodigo(objs[0].toString());
            if (objs[1] != null)seguridadConcepto.setGrupo(objs[1].toString());
            if (objs[2] != null)seguridadConcepto.setConcepto(objs[2].toString());
            if (objs[3] != null) seguridadConcepto.setConceptopadre(objs[3].toString());
            if (objs[4] != null)seguridadConcepto.setDescripcion(objs[4].toString());
            if (objs[5] != null)seguridadConcepto.setVisibleflag(objs[5].toString());
            if (objs[6] != null)seguridadConcepto.setTipodeobjeto(objs[6].toString());
            if (objs[7] != null)seguridadConcepto.setObjeto(objs[7].toString());
            resulEnvio.add(seguridadConcepto);
        }
        //System.out.println("--"+result.size());
        /*
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            //now you have one array of Object for each row
            String client = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String
            //System.out.println(" --" + client);
            Integer service = Integer.parseInt(String.valueOf(obj[1])); //SERVICE assumed as int
            //same way for all obj[2], obj[3], obj[4]
        }
        */
        return resulEnvio;
    }

    @Override
    public Seguridadconcepto SeguridadConceptoBuscar(Seguridadconcepto objPersonaMast) {
        return null;
    }

	@Override
	public List<Seguridadconcepto> listarElementos(Seguridadconcepto seguridadconcepto, boolean paginable) {
    	Criteria criteria = getCurrentSession().createCriteria(Seguridadconcepto.class);
		if (UtilesCommons.noEsVacio(seguridadconcepto.getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("aplicacioncodigo", seguridadconcepto.getAplicacioncodigo()));
		}		
		if (UtilesCommons.noEsVacio(seguridadconcepto.getGrupo())) {
			criteria.add(Restrictions.eq("grupo", seguridadconcepto.getGrupo()));
		}		
		if (UtilesCommons.noEsVacio(seguridadconcepto.getConcepto())) {
			criteria.add(Restrictions.eq("concepto", seguridadconcepto.getConcepto()));
		}
		
		if (UtilesCommons.noEsVacio(seguridadconcepto.getConceptopadre())) {
			criteria.add(Restrictions.eq("conceptopadre", seguridadconcepto.getConceptopadre()));
		}		
		if (UtilesCommons.noEsVacio(seguridadconcepto.getVisibleflag())) {
			criteria.add(Restrictions.eq("visibleflag", seguridadconcepto.getVisibleflag()));
		}
		if(paginable){
			criteria.setFirstResult(seguridadconcepto.getInicio());
			criteria.setMaxResults(seguridadconcepto.getNumeroFilas());
			criteria.setFetchSize(seguridadconcepto.getNumeroFilas());
		}
		return (List<Seguridadconcepto>) criteria.list();
	}		
	
}
