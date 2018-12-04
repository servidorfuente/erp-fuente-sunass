package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaMensajeReceptorDao;
import erp.realcoresystems.pe.model.domain.SaMensajeReceptor;
import erp.realcoresystems.pe.model.domain.vista.VwMensajeReceptor;

@Repository
public class SaMensajeReceptorDaoImpl  extends AbstractDaoImpl<SaMensajeReceptor, Long> implements SaMensajeReceptorDao{

	protected SaMensajeReceptorDaoImpl() {
		super(SaMensajeReceptor.class);		
	}

	@Override
	public SaMensajeReceptor obtenerPorID(Long id) {
		Object resull = findById(id);
		return resull!=null?(SaMensajeReceptor)resull:null;	
	}

	@Override
	public List<SaMensajeReceptor> listarElementos(SaMensajeReceptor objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeReceptor.class);		
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
		if ( UtilesCommons.noEsVacio(objDao.getMrecUsuario())) {
			criteria.add(Restrictions.eq("mrecUsuario", objDao.getMrecUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiporeceptor())) {
			criteria.add(Restrictions.eq("mrecTiporeceptor", objDao.getMrecTiporeceptor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiposesion())) {
			criteria.add(Restrictions.eq("mrecTiposesion", objDao.getMrecTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMrecEstado()!= null  && objDao.getMrecEstado() > 0) {
			criteria.add(Restrictions.eq("mrecEstado", objDao.getMrecEstado()));
		}		
		
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}		
		
		return criteria.list();
	}

	@Override
	public long guardar(SaMensajeReceptor objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeReceptor.class);
		ProjectionList proj = Projections.projectionList();																			
		proj.add(Projections.max("mrecRecepcionid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.setMrecRecepcionid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaMensajeReceptor objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaMensajeReceptor objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaMensajeReceptor objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeReceptor.class);		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}	
		if (objDao.getPersona()!= null  && objDao.getPersona() > 0) {
			criteria.add(Restrictions.eq("persona", objDao.getPersona()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecUsuario())) {
			criteria.add(Restrictions.eq("mrecUsuario", objDao.getMrecUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiporeceptor())) {
			criteria.add(Restrictions.eq("mrecTiporeceptor", objDao.getMrecTiporeceptor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiposesion())) {
			criteria.add(Restrictions.eq("mrecTiposesion", objDao.getMrecTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMrecEstado()!= null  && objDao.getMrecEstado() > 0) {
			criteria.add(Restrictions.eq("mrecEstado", objDao.getMrecEstado()));
		}		
		
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}										
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

	@Override
	public List<VwMensajeReceptor> listarElementos(VwMensajeReceptor objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(VwMensajeReceptor.class);		
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
		if ( UtilesCommons.noEsVacio(objDao.getMrecUsuario())) {
			criteria.add(Restrictions.eq("mrecUsuario", objDao.getMrecUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiporeceptor())) {
			criteria.add(Restrictions.eq("mrecTiporeceptor", objDao.getMrecTiporeceptor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiposesion())) {
			criteria.add(Restrictions.eq("mrecTiposesion", objDao.getMrecTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMrecEstado()!= null  && objDao.getMrecEstado() > 0) {
			criteria.add(Restrictions.eq("mrecEstado", objDao.getMrecEstado()));
		}	
		if (objDao.getPersonaEmision()!= null  && objDao.getPersonaEmision() > 0) {
			criteria.add(Restrictions.eq("personaEmision", objDao.getPersonaEmision()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMensAsunto())) {			
			criteria.add(Restrictions.like("mensAsunto", objDao.getMensAsunto(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}		
		if (objDao.getMrecRecepcionid()!= null  && objDao.getMrecRecepcionid() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionid", objDao.getMrecRecepcionid()));
		}		
		
		if(UtilesCommons.noEsVacio(objDao.getAtributoOrdenacion())){
			criteria.addOrder(Order.desc(objDao.getAtributoOrdenacion()));	
		}										
		
		return criteria.list();
	}

	@Override
	public int contarElementos(VwMensajeReceptor objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwMensajeReceptor.class);		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}	
		if (objDao.getPersona()!= null  && objDao.getPersona() > 0) {
			criteria.add(Restrictions.eq("persona", objDao.getPersona()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecUsuario())) {
			criteria.add(Restrictions.eq("mrecUsuario", objDao.getMrecUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiporeceptor())) {
			criteria.add(Restrictions.eq("mrecTiporeceptor", objDao.getMrecTiporeceptor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMrecTiposesion())) {
			criteria.add(Restrictions.eq("mrecTiposesion", objDao.getMrecTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMrecEstado()!= null  && objDao.getMrecEstado() > 0) {
			criteria.add(Restrictions.eq("mrecEstado", objDao.getMrecEstado()));
		}		
		
		if (objDao.getPersonaEmision()!= null  && objDao.getPersonaEmision() > 0) {
			criteria.add(Restrictions.eq("personaEmision", objDao.getPersonaEmision()));
		}		
		if ( UtilesCommons.noEsVacio(objDao.getMensAsunto())) {
			criteria.add(Restrictions.like("mensAsunto", objDao.getMensAsunto(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}		
		if (objDao.getMrecRecepcionid()!= null  && objDao.getMrecRecepcionid() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionid", objDao.getMrecRecepcionid()));
		}										
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
