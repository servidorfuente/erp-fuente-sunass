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
import erp.realcoresystems.pe.model.dao.SaMensajeObjetoDao;
import erp.realcoresystems.pe.model.domain.SaMensajeObjeto;
import erp.realcoresystems.pe.model.domain.vista.VwMensajeObjetoEmisor;

@Repository
public class SaMensajeObjetoDaoImpl  extends AbstractDaoImpl<SaMensajeObjeto, Long> implements SaMensajeObjetoDao{

	protected SaMensajeObjetoDaoImpl() {
		super(SaMensajeObjeto.class);		
	}

	@Override
	public SaMensajeObjeto obtenerPorID(Long id) {
		Object resull = findById(id);
		return resull!=null?(SaMensajeObjeto)resull:null;	
	}

	@Override
	public List<SaMensajeObjeto> listarElementos(SaMensajeObjeto objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeObjeto.class);		
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
		if (objDao.getMemiEmisionid()!= null  && objDao.getMemiEmisionid() > 0) {
			criteria.add(Restrictions.eq("memiEmisionid", objDao.getMemiEmisionid()));
		}
		return criteria.list();
	}

	@Override
	public long guardar(SaMensajeObjeto objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeObjeto.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("mensMensajeid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.setMensMensajeid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaMensajeObjeto objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaMensajeObjeto objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaMensajeObjeto objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeObjeto.class);		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}		
		if (objDao.getMemiEmisionid()!= null  && objDao.getMemiEmisionid() > 0) {
			criteria.add(Restrictions.eq("memiEmisionid", objDao.getMemiEmisionid()));
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

	@Override
	public List<VwMensajeObjetoEmisor> listarElementos(VwMensajeObjetoEmisor objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(VwMensajeObjetoEmisor.class);		
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
		if (objDao.getPersonaEmisor()!= null  && objDao.getPersonaEmisor() > 0) {
			criteria.add(Restrictions.eq("personaEmisor", objDao.getPersonaEmisor()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiUsuario())) {
			criteria.add(Restrictions.eq("memiUsuario", objDao.getMemiUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiTipoemisor())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTipoemisor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMemiTiposesion())) {
			criteria.add(Restrictions.eq("memiTiposesion", objDao.getMemiTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMemiEstado()!= null  && objDao.getMemiEstado() > 0) {
			criteria.add(Restrictions.eq("memiEstado", objDao.getMemiEstado()));
		}	
	
		if ( UtilesCommons.noEsVacio(objDao.getMensAsunto())) {			
			criteria.add(Restrictions.like("mensAsunto", objDao.getMensAsunto(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}		
				
		if(UtilesCommons.noEsVacio(objDao.getAtributoOrdenacion())){
			criteria.addOrder(Order.desc(objDao.getAtributoOrdenacion()));	
		}										
		
		return criteria.list();
	}

	@Override
	public int contarElementos(VwMensajeObjetoEmisor objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwMensajeObjetoEmisor.class);		
		
		if (objDao.getUneunegocioid()!= null  && objDao.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));
		}		
		if (objDao.getMoemestudioid()!= null  && objDao.getMoemestudioid() > 0) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));
		}	
		if (objDao.getPersonaEmisor()!= null  && objDao.getPersonaEmisor() > 0) {
			criteria.add(Restrictions.eq("personaEmisor", objDao.getPersonaEmisor()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiUsuario())) {
			criteria.add(Restrictions.eq("memiUsuario", objDao.getMemiUsuario()));
		}	
		if ( UtilesCommons.noEsVacio(objDao.getMemiTipoemisor())) {
			criteria.add(Restrictions.eq("memiTipoemisor", objDao.getMemiTipoemisor()));
		}
		if ( UtilesCommons.noEsVacio(objDao.getMemiTiposesion())) {
			criteria.add(Restrictions.eq("memiTiposesion", objDao.getMemiTiposesion()));
		}
		if (objDao.getMrecRecepcionidOrigen()!= null  && objDao.getMrecRecepcionidOrigen() > 0) {
			criteria.add(Restrictions.eq("mrecRecepcionidOrigen", objDao.getMrecRecepcionidOrigen()));
		}	
		if (objDao.getMemiEstado()!= null  && objDao.getMemiEstado() > 0) {
			criteria.add(Restrictions.eq("memiEstado", objDao.getMemiEstado()));
		}	
	
		if ( UtilesCommons.noEsVacio(objDao.getMensAsunto())) {			
			criteria.add(Restrictions.like("mensAsunto", objDao.getMensAsunto(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getMensMensajeid()!= null  && objDao.getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("mensMensajeid", objDao.getMensMensajeid()));
		}			
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
