package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaEventoDao;
import erp.realcoresystems.pe.model.domain.SaPersonaEvento;
import erp.realcoresystems.pe.model.domain.SaPersonaEventoPK;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaEvento;

@Repository
public class SaPersonaEventoDaoImpl extends AbstractDaoImpl<SaPersonaEvento, SaPersonaEventoPK>  implements SaPersonaEventoDao{

	protected SaPersonaEventoDaoImpl() {
		super(SaPersonaEvento.class);
	}

	@Override
	public SaPersonaEvento obtenerPorID(SaPersonaEventoPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaEvento)resull:null;	
	}

	@Override
	public List<SaPersonaEvento> listarElementos(SaPersonaEvento objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaEvento.class);	
		if (objDao.getUneunegocioid()!= null  && !(objDao.getUneunegocioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}
		if (objDao.getMoemestudioid()!= null  && !(objDao.getMoemestudioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getMoemestudioid()));
		}		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}			
		if (objDao.getEveeventoid()!= null ) {
			criteria.add(Restrictions.eq("eveeventoid", objDao.getEveeventoid() ));
		}	
		if (objDao.getHrhhorheaderid()!= null  && !(objDao.getHrhhorheaderid()+"").equals("0")) {
			criteria.add(Restrictions.eq("hrhhorheaderid", objDao.getHrhhorheaderid()));
		}		
		return criteria.list();
	}

	@Override
	public List<SaPersonaEvento> listarElementosPag(SaPersonaEvento objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaEvento.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}			
		if (objDao.getEveeventoid()!= null ) {
			criteria.add(Restrictions.eq("eveeventoid", objDao.getEveeventoid() ));
		}			
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());	
		return criteria.list();
	}

	@Override
	public List<VwPersonaEvento> listarVwElementosPag(VwPersonaEvento objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwPersonaEvento.class);		
		if (objDao.getUneunegocioid()!= null  && !(objDao.getUneunegocioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}
		if (objDao.getMoemestudioid()!= null  && !(objDao.getMoemestudioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getMoemestudioid()));
		}		
		if (objDao.getPersonaeveEstado()!= null  && !(objDao.getPersonaeveEstado()+"").equals("0")) {
			criteria.add(Restrictions.eq("personaeveEstado", objDao.getPersonaeveEstado()));
		}				
		if (objDao.getEveestadoproceso() != null  && !(objDao.getPersonaeveEstado()+"").equals("0") ) {
			criteria.add(Restrictions.eq("eveestadoproceso", objDao.getEveestadoproceso() ));
		}
		if (objDao.getEstadoAsistente()!= null  && !(objDao.getEstadoAsistente()+"").equals("0") ) {
			criteria.add(Restrictions.eq("estadoAsistente", objDao.getEstadoAsistente()));
		}
		
		if (objDao.getEveeventoid()!= null && !(objDao.getEveeventoid()+"").equals("0")) {
			criteria.add(Restrictions.eq("eveeventoid", objDao.getEveeventoid()));
		}
		if (objDao.getEvedescripcion()!= null ) {
			criteria.add(Restrictions.like("evedescripcion", objDao.getEvedescripcion(),MatchMode.ANYWHERE).ignoreCase());			
		}	
		if (objDao.getNombrecompleto()!= null ) {
			criteria.add(Restrictions.like("nombrecompleto", objDao.getNombrecompleto(),MatchMode.ANYWHERE).ignoreCase());			
		}
		if (objDao.getInstitucionDesc()!= null ) {
			criteria.add(Restrictions.like("institucionDesc", objDao.getInstitucionDesc(),MatchMode.ANYWHERE).ignoreCase());			
		}		
		if (objDao.getCargoDesc()!= null ) {
			criteria.add(Restrictions.like("cargoDesc", objDao.getCargoDesc(),MatchMode.ANYWHERE).ignoreCase());			
		}		
		if (objDao.getDocumento()!= null ) {
			criteria.add(Restrictions.like("documento", objDao.getDocumento(),MatchMode.ANYWHERE).ignoreCase());			
		}
		if (objDao.getSexo() != null) {
			criteria.add(Restrictions.eq("sexo", objDao.getSexo()));
		}		
		if (objDao.getHrhhorheaderid()!= null && !(objDao.getHrhhorheaderid()+"").equals("0")) {
			criteria.add(Restrictions.eq("hrhhorheaderid", objDao.getHrhhorheaderid()));
		}
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());	
		return criteria.list();
	}

	@Override
	public long guardar(SaPersonaEvento objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaEvento.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("id.personaeventoid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.getId().setPersonaeventoid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaPersonaEvento objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaEvento objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaPersonaEvento objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaEvento.class);		
		if (objDao.getEstado()!= null  && !(objDao.getEstado()+"").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}				
		if (objDao.getId().getPersona() != null ) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona() ));
		}			
		if (objDao.getEveeventoid()!= null ) {
			criteria.add(Restrictions.eq("eveeventoid", objDao.getEveeventoid() ));
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

	@Override
	public int contarVwElementos(VwPersonaEvento objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwPersonaEvento.class);
		if (objDao.getUneunegocioid()!= null  && !(objDao.getUneunegocioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}
		if (objDao.getMoemestudioid()!= null  && !(objDao.getMoemestudioid()+"").equals("0")) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getMoemestudioid()));
		}		
		if (objDao.getPersonaeveEstado()!= null  && !(objDao.getPersonaeveEstado()+"").equals("0")) {
			criteria.add(Restrictions.eq("personaeveEstado", objDao.getPersonaeveEstado()));
		}				
		if (objDao.getEveestadoproceso() != null  && !(objDao.getPersonaeveEstado()+"").equals("0") ) {
			criteria.add(Restrictions.eq("eveestadoproceso", objDao.getEveestadoproceso() ));
		}
		if (objDao.getEstadoAsistente()!= null  && !(objDao.getEstadoAsistente()+"").equals("0") ) {
			criteria.add(Restrictions.eq("estadoAsistente", objDao.getEstadoAsistente()));
		}
		
		if (objDao.getEveeventoid()!= null && !(objDao.getEveeventoid()+"").equals("0")) {
			criteria.add(Restrictions.eq("eveeventoid", objDao.getEveeventoid()));
		}
		if (objDao.getEvedescripcion()!= null ) {
			criteria.add(Restrictions.like("evedescripcion", objDao.getEvedescripcion(),MatchMode.ANYWHERE).ignoreCase());			
		}	
		if (objDao.getNombrecompleto()!= null ) {
			criteria.add(Restrictions.like("nombrecompleto", objDao.getNombrecompleto(),MatchMode.ANYWHERE).ignoreCase());			
		}	
		if (objDao.getInstitucionDesc()!= null ) {
			criteria.add(Restrictions.like("institucionDesc", objDao.getInstitucionDesc(),MatchMode.ANYWHERE).ignoreCase());			
		}		
		if (objDao.getCargoDesc()!= null ) {
			criteria.add(Restrictions.like("cargoDesc", objDao.getCargoDesc(),MatchMode.ANYWHERE).ignoreCase());			
		}		
		if (objDao.getDocumento()!= null ) {
			criteria.add(Restrictions.like("documento", objDao.getDocumento(),MatchMode.ANYWHERE).ignoreCase());			
		}
		if (objDao.getSexo() != null) {
			criteria.add(Restrictions.eq("sexo", objDao.getSexo()));
		}		
		if (objDao.getHrhhorheaderid()!= null && !(objDao.getHrhhorheaderid()+"").equals("0")) {
			criteria.add(Restrictions.eq("hrhhorheaderid", objDao.getHrhhorheaderid()));
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
