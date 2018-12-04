package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaMensajeRecAdjuntoDao;
import erp.realcoresystems.pe.model.domain.SaMensajeRecAdjunto;
import erp.realcoresystems.pe.model.domain.SaMensajeRecAdjuntoPK;

@Repository
public class SaMensajeRecAdjuntoDaoImpl  extends AbstractDaoImpl<SaMensajeRecAdjunto, SaMensajeRecAdjuntoPK> implements SaMensajeRecAdjuntoDao{

	protected SaMensajeRecAdjuntoDaoImpl() {
		super(SaMensajeRecAdjunto.class);		
	}

	@Override
	public SaMensajeRecAdjunto obtenerPorID(SaMensajeRecAdjuntoPK id) {
		Object resull = findById(id);
		return resull!=null?(SaMensajeRecAdjunto)resull:null;	
	}

	@Override
	public List<SaMensajeRecAdjunto> listarElementos(SaMensajeRecAdjunto objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeRecAdjunto.class);		
		if(paginable){
			objDao.setPaginable(true);
			criteria.setFirstResult(objDao.getInicio());
			criteria.setMaxResults(objDao.getNumeroFilas());
			criteria.setFetchSize(objDao.getNumeroFilas());				
		}		
		
		if (UtilesCommons.noEsVacio(objDao.getMeaduuid())) {
			criteria.add(Restrictions.eq("meaduuid", objDao.getMeaduuid()));
		}	
		
		if (objDao.getMeadestado()!= null  && objDao.getMeadestado() > 0) {
			criteria.add(Restrictions.eq("meadestado", objDao.getMeadestado()));
		}		
		
		if (objDao.getId().getMensMensajeid()!= null  && objDao.getId().getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("id.mensMensajeid", objDao.getId().getMensMensajeid()));
		}		
				
		
		return criteria.list();
	}

	@Override
	public int guardar(SaMensajeRecAdjunto objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeRecAdjunto.class);
		ProjectionList proj = Projections.projectionList();
		criteria.add(Restrictions.eq("id.mensMensajeid", objDao.getId().getMensMensajeid()));																		
		proj.add(Projections.max("id.meadAdjuntoid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		int valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		objDao.getId().setMeadAdjuntoid(valorMax+1);		
		save(objDao);
		return  (valorMax+1);
	}

	@Override
	public int eliminar(SaMensajeRecAdjunto objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaMensajeRecAdjunto objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contarElementos(SaMensajeRecAdjunto objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaMensajeRecAdjunto.class);		
		if (UtilesCommons.noEsVacio(objDao.getMeaduuid())) {
			criteria.add(Restrictions.eq("meaduuid", objDao.getMeaduuid()));
		}	
		
		if (objDao.getMeadestado()!= null  && objDao.getMeadestado() > 0) {
			criteria.add(Restrictions.eq("meadestado", objDao.getMeadestado()));
		}		
		
		if (objDao.getId().getMensMensajeid()!= null  && objDao.getId().getMensMensajeid() > 0) {
			criteria.add(Restrictions.eq("id.mensMensajeid", objDao.getId().getMensMensajeid()));
		}		
												
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

}
