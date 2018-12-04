package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaExperienciaDao;
import erp.realcoresystems.pe.model.domain.SaPersonaExperiencia;
import erp.realcoresystems.pe.model.domain.SaPersonaExperienciaPK;

@Repository
public class SaPersonaExperienciaDaoImpl  extends AbstractDaoImpl<SaPersonaExperiencia, SaPersonaExperienciaPK> implements SaPersonaExperienciaDao {

	
	
	protected SaPersonaExperienciaDaoImpl() {
		super(SaPersonaExperiencia.class);		
	}

	@Override
	public SaPersonaExperiencia obtenerPorID(SaPersonaExperienciaPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaExperiencia)resull:null;		
		
	}

	@Override
	public List<SaPersonaExperiencia> listarElementos(SaPersonaExperiencia objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaExperiencia.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}	
		if (objDao.getTipoexperiencia()	!= null && !(objDao.getTipoexperiencia()+"").isEmpty() ) {
			criteria.add(Restrictions.eq("tipoexperiencia", objDao.getTipoexperiencia()));
		}	
		if (objDao.getId().getSecuencia() != null ) {
			criteria.add(Restrictions.eq("id.secuencia", objDao.getId().getSecuencia() ));
		}	
		criteria.addOrder(Order.asc("fechadesde").ignoreCase());
		return criteria.list();
	}

	@Override
	public List<SaPersonaExperiencia> listarElementosPag(SaPersonaExperiencia objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaExperiencia.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}	
		if (objDao.getTipoexperiencia()	!= null && !(objDao.getTipoexperiencia()+"").isEmpty() ) {
			criteria.add(Restrictions.eq("tipoexperiencia", objDao.getTipoexperiencia()));
		}	
		if (objDao.getId().getSecuencia() != null ) {
			criteria.add(Restrictions.eq("id.secuencia", objDao.getId().getSecuencia() ));
		}	
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());	
		return criteria.list();
	}

	@Override
	public long guardar(SaPersonaExperiencia objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaExperiencia.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("id.secuencia"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.getId().setSecuencia(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaPersonaExperiencia objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaExperiencia objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaPersonaExperiencia objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaExperiencia.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}	
		if (objDao.getTipoexperiencia()	!= null && !(objDao.getTipoexperiencia()+"").isEmpty() ) {
			criteria.add(Restrictions.eq("tipoexperiencia", objDao.getTipoexperiencia()));
		}	
		if (objDao.getId().getSecuencia() != null ) {
			criteria.add(Restrictions.eq("id.secuencia", objDao.getId().getSecuencia() ));
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
