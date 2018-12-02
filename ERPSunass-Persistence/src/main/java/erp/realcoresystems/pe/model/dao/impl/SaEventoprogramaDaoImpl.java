package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaEventoprogramaDao;
import erp.realcoresystems.pe.model.domain.SaEventoprograma;

@Repository
public class SaEventoprogramaDaoImpl  extends AbstractDaoImpl<SaEventoprograma, Integer> implements SaEventoprogramaDao {

	protected SaEventoprogramaDaoImpl() {
		super(SaEventoprograma.class);		
	}

	@Override
	public SaEventoprograma obtenerPorID(Integer id) {
		Object resull = findById(id);
		return resull!=null?(SaEventoprograma)resull:null;	
	}

	@Override
	public List<SaEventoprograma> listarElementos(SaEventoprograma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaEventoprograma.class);		
		if (objDao.getEveestado()!= null  && !(objDao.getEveestado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("eveestado", objDao.getEveestado()));
		}				
		if (objDao.getEvedescripcion()!= null ) {
			criteria.add(Restrictions.like("evedescripcion", objDao.getEvedescripcion(),MatchMode.ANYWHERE).ignoreCase());			
		}			
		return criteria.list();
	}

	@Override
	public List<SaEventoprograma> listarElementosPag(SaEventoprograma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaEventoprograma.class);		
		if (objDao.getEveestado()!= null  && !(objDao.getEveestado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("eveestado", objDao.getEveestado()));
		}				
		if (objDao.getEvedescripcion()!= null ) {
			criteria.add(Restrictions.like("evedescripcion", objDao.getEvedescripcion(),MatchMode.ANYWHERE).ignoreCase());			
		}
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());
		return criteria.list();
	}

	@Override
	public int guardar(SaEventoprograma objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaEventoprograma.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("eveeventoid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		int valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.setEveeventoid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaEventoprograma objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaEventoprograma objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaEventoprograma objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaEventoprograma.class);		
		if (objDao.getEveestado()!= null  && !(objDao.getEveestado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("eveestado", objDao.getEveestado()));
		}				
		if (objDao.getEvedescripcion()!= null ) {
			criteria.add(Restrictions.like("evedescripcion", objDao.getEvedescripcion(),MatchMode.ANYWHERE).ignoreCase());			
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
