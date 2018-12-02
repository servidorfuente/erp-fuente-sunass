package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaIdiomaDao;
import erp.realcoresystems.pe.model.domain.SaPersonaIdioma;
import erp.realcoresystems.pe.model.domain.SaPersonaIdiomaPK;

@Repository
public class SaPersonaIdiomaDaoImpl extends AbstractDaoImpl<SaPersonaIdioma, SaPersonaIdiomaPK> implements SaPersonaIdiomaDao{

	protected SaPersonaIdiomaDaoImpl() {
		super(SaPersonaIdioma.class);		
	}

	@Override
	public SaPersonaIdioma obtenerPorID(SaPersonaIdiomaPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaIdioma)resull:null;	
	}

	@Override
	public List<SaPersonaIdioma> listarElementos(SaPersonaIdioma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaIdioma.class);
		if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}		
		if (objDao.getIdiidiomaid()!= null) {
			criteria.add(Restrictions.eq("idiidiomaid", objDao.getIdiidiomaid()));
		}
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}							
		return criteria.list();
	}

	@Override
	public List<SaPersonaIdioma> listarElementosPag(SaPersonaIdioma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaIdioma.class);
		if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}		
		if (objDao.getIdiidiomaid()!= null) {
			criteria.add(Restrictions.eq("idiidiomaid", objDao.getIdiidiomaid()));
		}
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}	
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());		
		return criteria.list();
	}

	@Override
	public long guardar(SaPersonaIdioma objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaIdioma.class);
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
	public int eliminar(SaPersonaIdioma objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaIdioma objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorlistarElementos(SaPersonaIdioma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaIdioma.class);
		if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}		
		if (objDao.getIdiidiomaid()!= null) {
			criteria.add(Restrictions.eq("idiidiomaid", objDao.getIdiidiomaid()));
		}
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}			
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
