package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaFamiliarDao;
import erp.realcoresystems.pe.model.domain.SaPersonaFamiliar;
import erp.realcoresystems.pe.model.domain.SaPersonaFamiliarPK;

@Repository
public class SaPersonaFamiliarDaoImpl  extends AbstractDaoImpl<SaPersonaFamiliar, SaPersonaFamiliarPK> implements SaPersonaFamiliarDao{

	protected SaPersonaFamiliarDaoImpl( ) {
		super(SaPersonaFamiliar.class);	
	}

	@Override
	public SaPersonaFamiliar obtenerPorID(SaPersonaFamiliarPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaFamiliar)resull:null;	
	}

	@Override
	public List<SaPersonaFamiliar> listarElementos(SaPersonaFamiliar objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaFamiliar.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}			
		if (objDao.getId().getSecuencia() != null ) {
			criteria.add(Restrictions.eq("id.secuencia", objDao.getId().getSecuencia() ));
		}			
		return criteria.list();
	}

	@Override
	public List<SaPersonaFamiliar> listarElementosPag(SaPersonaFamiliar objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaFamiliar.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
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
	public long guardar(SaPersonaFamiliar objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaFamiliar.class);
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
	public int eliminar(SaPersonaFamiliar objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaFamiliar objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaPersonaFamiliar objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaFamiliar.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}			
		if (objDao.getId().getSecuencia() != null ) {
			criteria.add(Restrictions.eq("id.secuencia", objDao.getId().getSecuencia() ));
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
