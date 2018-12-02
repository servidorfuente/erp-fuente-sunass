package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.CompaniaOwnerDao;
import erp.realcoresystems.pe.model.dao.SsControlperiodoDao;
import erp.realcoresystems.pe.model.domain.SsControlperiodo;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsControlperiodoDaoImpl extends AbstractDaoImpl<SsControlperiodo, String> implements SsControlperiodoDao {

	protected SsControlperiodoDaoImpl() {
		super(SsControlperiodo.class);
	}


	@Override
	public SsControlperiodo buscar(SsControlperiodo objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsControlperiodo.class);
		filtrarCritera(criteria, objDao);
		setOrdenable(criteria, ORDER_ASC, objDao.getListaAtributoOrdenacion());
		return (SsControlperiodo) criteria.uniqueResult();
	}

	@Override
	public List<SsControlperiodo> listar(SsControlperiodo objDao, boolean pagina) {
		Criteria criteria = getCurrentSession().createCriteria(SsControlperiodo.class);
		if (pagina){
			objDao.setPaginable(true);
			setPaginable(objDao, criteria);
		}
		filtrarCritera(criteria, objDao);
		setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
		return criteria.list();
	}

	@Override
	public int guardar(SsControlperiodo objDao) {
		save(objDao);
		return 1;
	}

	@Override
	public int actualizar(SsControlperiodo objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(SsControlperiodo objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int contar(SsControlperiodo objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsControlperiodo.class);
		filtrarCritera(criteria, objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}
	public void filtrarCritera(Criteria criteria, Object objFiltro){
		if(objFiltro instanceof SsControlperiodo){
			SsControlperiodo  objDao = (SsControlperiodo)objFiltro;
			if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
				criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
			}
			if(UtilesCommons.noEsVacio(objDao.getPeriodo())){
				criteria.add(Restrictions.eq("periodo",objDao.getPeriodo()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipofrecuencia())){
				criteria.add(Restrictions.eq("tipofrecuencia",objDao.getTipofrecuencia()));
			}

		}else {
		}
	}
}
