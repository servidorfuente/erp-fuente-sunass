package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaProfesionDao;
import erp.realcoresystems.pe.model.domain.SaProfesion;

@Repository
public class SaProfesionDaoImpl  extends AbstractDaoImpl<SaProfesion, Long> implements SaProfesionDao{

	protected SaProfesionDaoImpl() {
		super(SaProfesion.class);
	
	}

	@Override
	public SaProfesion obtenerPorID(Long id) {
		Object resull = findById(id);
		return resull!=null?(SaProfesion)resull:null;	
	}

	@Override
	public List<SaProfesion> listarElementos(SaProfesion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaProfesion.class);
		if (objDao.getArea()!= null && !(objDao.getArea()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("area", objDao.getArea()));
		}	
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}		
		if (objDao.getDescripcion()!= null && !(objDao.getDescripcion()+"").isEmpty() ) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}			
		return criteria.list();
	}

	@Override
	public List<SaProfesion> listarElementosPag(SaProfesion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaProfesion.class);
		if (objDao.getArea()!= null && !(objDao.getArea()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("area", objDao.getArea()));
		}	
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}		
		if (objDao.getDescripcion()!= null && !(objDao.getDescripcion()+"").isEmpty() ) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}	
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());	
		return criteria.list();
	}

	@Override
	public long guardar(SaProfesion objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaProfesion.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("profesion"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.setProfesion(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaProfesion objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaProfesion objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorlistarElementos(SaProfesion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaProfesion.class);
		if (objDao.getArea()!= null && !(objDao.getArea()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("area", objDao.getArea()));
		}	
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}		
		if (objDao.getDescripcion()!= null && !(objDao.getDescripcion()+"").isEmpty() ) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
