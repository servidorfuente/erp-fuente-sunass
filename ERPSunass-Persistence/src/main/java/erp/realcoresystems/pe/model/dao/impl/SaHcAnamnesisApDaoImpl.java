package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaHcAnamnesisApDao;
import erp.realcoresystems.pe.model.domain.SaHcAnamnesisAp;
import erp.realcoresystems.pe.model.domain.SaHcAnamnesisApPK;

@Repository
public class SaHcAnamnesisApDaoImpl extends AbstractDaoImpl<SaHcAnamnesisAp, SaHcAnamnesisApPK> implements SaHcAnamnesisApDao {

	protected SaHcAnamnesisApDaoImpl() {
		super(SaHcAnamnesisAp.class);		
	}

	@Override
	public SaHcAnamnesisAp obtenerPorID(SaHcAnamnesisApPK id) {		
		return findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaHcAnamnesisAp> listarElementos(SaHcAnamnesisAp objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaHcAnamnesisAp.class);
		
		if (UtilesCommons.noEsVacio(objDao.getId().getPersona())) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}
		if (UtilesCommons.noEsVacio(objDao.getEstado())) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if(paginable){
			criteria.setFirstResult(objDao.getInicio());
			criteria.setMaxResults(objDao.getNumeroFilas());
			criteria.setFetchSize(objDao.getNumeroFilas());		
		}
		
		return criteria.list();
	}

	@Override
	public int contarElementos(SaHcAnamnesisAp objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaHcAnamnesisAp.class);
		
		if (UtilesCommons.noEsVacio(objDao.getId().getPersona())) {
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
		}
		if (UtilesCommons.noEsVacio(objDao.getEstado())) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);	
	}

	@Override
	public int guardar(SaHcAnamnesisAp objDao) {
		/*Obtener MAX insertado**/
		int valorMax=0;
		if(UtilesCommons.noEsVacio(objDao.getId().getPersona())	){
			Criteria criteria = getCurrentSession().createCriteria(SaHcAnamnesisAp.class);
			criteria.add(Restrictions.eq("id.persona", objDao.getId().getPersona()));
			
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("id.episodioclinicoid"));																
			criteria.setProjection(proj);		
			Object result = criteria.uniqueResult();
					
			if(result!=null){		
				valorMax = Integer.parseInt(result.toString());	
			}		
			valorMax++;
			objDao.getId().setEpisodioclinicoid(valorMax);		
			save(objDao);
		}

		return  (valorMax);
	}

	@Override
	public int eliminar(SaHcAnamnesisAp objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaHcAnamnesisAp objDao) {
		update(objDao);
		return 1;
	}

}
