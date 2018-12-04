package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaCursoDao;
import erp.realcoresystems.pe.model.domain.SaPersonaCurso;
import erp.realcoresystems.pe.model.domain.SaPersonaCursoPK;

@Repository
public class SaPersonaCursoDaoImpl extends AbstractDaoImpl<SaPersonaCurso, SaPersonaCursoPK> implements SaPersonaCursoDao {

	protected SaPersonaCursoDaoImpl() {
		super(SaPersonaCurso.class);		
	}

	@Override
	public SaPersonaCurso obtenerPorID(SaPersonaCursoPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaCurso)resull:null;	
	}

	@Override
	public List<SaPersonaCurso> listarElementos(SaPersonaCurso objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaCurso.class);		
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
	public List<SaPersonaCurso> listarElementosPag(SaPersonaCurso objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaCurso.class);		
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
	public long guardar(SaPersonaCurso objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaCurso.class);
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
	public int eliminar(SaPersonaCurso objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaCurso objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaPersonaCurso objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaCurso.class);		
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
