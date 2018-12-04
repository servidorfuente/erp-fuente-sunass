package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaPersonaInstruccionDao;
import erp.realcoresystems.pe.model.domain.SaPersonaInstruccion;
import erp.realcoresystems.pe.model.domain.SaPersonaInstruccionPK;

@Repository
public class SaPersonaInstruccionDaoImpl extends AbstractDaoImpl<SaPersonaInstruccion, SaPersonaInstruccionPK> implements SaPersonaInstruccionDao{

	protected SaPersonaInstruccionDaoImpl() {
		super(SaPersonaInstruccion.class);		
	}

	@Override
	public SaPersonaInstruccion obtenerPorID(SaPersonaInstruccionPK id) {
		Object resull = findById(id);
		return resull!=null?(SaPersonaInstruccion)resull:null;	
	}

	@Override
	public List<SaPersonaInstruccion> listarElementos(SaPersonaInstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaInstruccion.class);
		/*if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}*/
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()))
				;
				//criteria.add(Restrictions.eq("eplantId", objDao.getEplantId())
				//.setFetchMode("centroestudiosObj", FetchMode.JOIN);
						
		}		
		if (objDao.getGradoinstruccion()!= null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
		}
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		
									
		return criteria.list();
	}

	@Override
	public List<SaPersonaInstruccion> listarElementosPag(SaPersonaInstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaInstruccion.class);
		/*if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}*/
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}		
		if (objDao.getGradoinstruccion()!= null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
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
	public long guardar(SaPersonaInstruccion objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaInstruccion.class);
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
	public int eliminar(SaPersonaInstruccion objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaInstruccion objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorlistarElementos(SaPersonaInstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaInstruccion.class);
		/*if (objDao.getCentroestudios()!= null) {
			criteria.add(Restrictions.eq("centroestudios", objDao.getCentroestudios()));
		}*/
		if (objDao.getId().getPersona()!= null) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}		
		if (objDao.getGradoinstruccion()!= null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
		}
		if (objDao.getEstado()!= null && !(objDao.getEstado()+"").isEmpty()  ) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}			
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
