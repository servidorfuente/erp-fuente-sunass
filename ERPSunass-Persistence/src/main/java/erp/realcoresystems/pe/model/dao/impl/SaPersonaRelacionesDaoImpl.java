package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaPersonaRelacionesDao;
import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;

@Repository
public class SaPersonaRelacionesDaoImpl extends AbstractDaoImpl<SaPersonaRelaciones,Long> implements SaPersonaRelacionesDao {

	protected SaPersonaRelacionesDaoImpl() {
		super(SaPersonaRelaciones.class);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPersonaRelaciones> listarElementos(SaPersonaRelaciones objDao,boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaRelaciones.class);
		
		if (UtilesCommons.noEsVacio(objDao.getPreltipoRelacionDe())) {
			criteria.add(Restrictions.eq("preltipoRelacionDe", objDao.getPreltipoRelacionDe()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelpersonaRelacionDe())) {
			criteria.add(Restrictions.eq("prelpersonaRelacionDe", objDao.getPrelpersonaRelacionDe()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelpersonaRelacionSecund())) {
			criteria.add(Restrictions.eq("prelpersonaRelacionSecund", objDao.getPrelpersonaRelacionSecund()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelestado())) {
			criteria.add(Restrictions.eq("prelestado", objDao.getPrelestado()));
		}
		if(paginable){
			criteria.setFirstResult(objDao.getInicio());
			criteria.setMaxResults(objDao.getNumeroFilas());
			criteria.setFetchSize(objDao.getNumeroFilas());		
		}
		return criteria.list();
	}

	@Override
	public int contarElementos(SaPersonaRelaciones objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaRelaciones.class);
		
		if (UtilesCommons.noEsVacio(objDao.getPreltipoRelacionDe())) {
			criteria.add(Restrictions.eq("preltipoRelacionDe", objDao.getPreltipoRelacionDe()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelpersonaRelacionDe())) {
			criteria.add(Restrictions.eq("prelpersonaRelacionDe", objDao.getPrelpersonaRelacionDe()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelpersonaRelacionSecund())) {
			criteria.add(Restrictions.eq("prelpersonaRelacionSecund", objDao.getPrelpersonaRelacionSecund()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getPrelestado())) {
			criteria.add(Restrictions.eq("prelestado", objDao.getPrelestado()));
		}		
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);		
	}

	@Override
	public long guardar(SaPersonaRelaciones objDao) {
		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SaPersonaRelaciones.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("prelsecuencia"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}		
		valorMax++;
		objDao.setPrelsecuencia(valorMax);		
		save(objDao);
		return  (valorMax);
	}

	@Override
	public int eliminar(SaPersonaRelaciones objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaPersonaRelaciones objDao) {
		update(objDao);
		return 1;
	}

}
