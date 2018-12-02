package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaMensajeEmisorDao;
import erp.realcoresystems.pe.model.domain.SaMensajeEmisor;

@Repository
public class SaMensajeEmisorDaoImpl  extends AbstractDaoImpl<SaMensajeEmisor, Long> implements SaMensajeEmisorDao{

	protected SaMensajeEmisorDaoImpl() {
		super(SaMensajeEmisor.class);		
	}

	@Override
	public SaMensajeEmisor obtenerPorID(Long id) {
		Object resull = findById(id);
		return resull!=null?(SaMensajeEmisor)resull:null;	
	}

	@Override
	public List<SaMensajeEmisor> listarElementos(SaMensajeEmisor objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeEmisor.class);		
		if(paginable){
			objDao.setPaginable(true);
			criteria.setFirstResult(objDao.getInicio());
			criteria.setMaxResults(objDao.getNumeroFilas());
			criteria.setFetchSize(objDao.getNumeroFilas());				
		}		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}	
		if (objDao.getPersona()!= null  && objDao.getPersona() > 0) {
			criteria.add(Restrictions.eq("persona", objDao.getPersona()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiUsuario())) {
			criteria.add(Restrictions.eq("memiUsuario", objDao.getMemiUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiTipoemisor())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTipoemisor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMemiTiposesion())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMemiEstado()!= null  && objDao.getMemiEstado() > 0) {
			criteria.add(Restrictions.eq("memiEstado", objDao.getMemiEstado()));
		}		
		
		return criteria.list();
	}

	@Override
	public long guardar(SaMensajeEmisor objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeEmisor.class);
		ProjectionList proj = Projections.projectionList();																			
		proj.add(Projections.max("memiEmisionid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.setMemiEmisionid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaMensajeEmisor objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaMensajeEmisor objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaMensajeEmisor objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeEmisor.class);		
		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}	
		if (objDao.getPersona()!= null  && objDao.getPersona() > 0) {
			criteria.add(Restrictions.eq("persona", objDao.getPersona()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiUsuario())) {
			criteria.add(Restrictions.eq("memiUsuario", objDao.getMemiUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiTipoemisor())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTipoemisor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMemiTiposesion())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMemiEstado()!= null  && objDao.getMemiEstado() > 0) {
			criteria.add(Restrictions.eq("memiEstado", objDao.getMemiEstado()));
		}		
		
												
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
