package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsControlperiodoDao;
import erp.realcoresystems.pe.model.domain.SsControlperiodo;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
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
	public List<VwControlperiodo> listarVista(VwControlperiodo objDao, boolean pagina) {
		Criteria criteria = getCurrentSession().createCriteria(VwControlperiodo.class);
		if (pagina){
			objDao.setPaginable(true);
			setPaginable(objDao, criteria);
		}
		filtrarCriteraVista(criteria, objDao);
		setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
		return criteria.list();
	}

	@Override
	public int guardar(SsControlperiodo objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsControlperiodo.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("secuencia"));
		criteria.setProjection(proj);
		Object result = criteria.uniqueResult();
		Integer valorMax=0;
		if(result!=null){
			valorMax = Integer.parseInt(result.toString());
		}
		objDao.setSecuencia(valorMax+1);
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

	@Override
	public int contarVista(VwControlperiodo objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwControlperiodo.class);
		filtrarCriteraVista(criteria, objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

	public void filtrarCriteraVista(Criteria criteria, Object objFiltro){
		if(objFiltro instanceof VwControlperiodo){
			VwControlperiodo  objDao = (VwControlperiodo)objFiltro;
			if(UtilesCommons.noEsVacio(objDao.getString1())){
				criteria.add(Restrictions.ne("companyowner",objDao.getString1()));
			}
			if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
				criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
			}
			if(UtilesCommons.noEsVacio(objDao.getSucursal())){
				criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipooperacion())){
				criteria.add(Restrictions.eq("tipooperacion",objDao.getTipooperacion()));
			}
			if(UtilesCommons.noEsVacio(objDao.getFlagmodocargainicial())){
				criteria.add(Restrictions.eq("flagmodocargainicial",objDao.getFlagmodocargainicial()));
			}
			if(UtilesCommons.noEsVacio(objDao.getEstadodocumento())){
				criteria.add(Restrictions.eq("estadodocumento",objDao.getEstadodocumento()));
			}
			if(UtilesCommons.noEsVacio(objDao.getAnno())){
				criteria.add(Restrictions.eq("anno",objDao.getAnno()));
			}
			if(UtilesCommons.noEsVacio(objDao.getInteger3())){
				criteria.add(Restrictions.isNull("anno"));
			}
			if(UtilesCommons.noEsVacio(objDao.getPeriodo())){
				criteria.add(Restrictions.eq("periodo",objDao.getPeriodo()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipofrecuencia())){
				criteria.add(Restrictions.eq("tipofrecuencia",objDao.getTipofrecuencia()));
			}
			if(UtilesCommons.noEsVacio(objDao.getFormularioid())){
				criteria.add(Restrictions.eq("formularioid",objDao.getFormularioid()));
			}

		}else {
		}
	}
	public void filtrarCritera(Criteria criteria, Object objFiltro){
		if(objFiltro instanceof SsControlperiodo){
			SsControlperiodo  objDao = (SsControlperiodo)objFiltro;
			if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
				criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
			}
			if(UtilesCommons.noEsVacio(objDao.getSucursal())){
				criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipooperacion())){
				criteria.add(Restrictions.eq("tipooperacion",objDao.getTipooperacion()));
			}
			if(UtilesCommons.noEsVacio(objDao.getAnno())){
				criteria.add(Restrictions.eq("anno",objDao.getAnno()));
			}
			if(UtilesCommons.noEsVacio(objDao.getPeriodo())){
				criteria.add(Restrictions.eq("periodo",objDao.getPeriodo()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipofrecuencia())){
				criteria.add(Restrictions.eq("tipofrecuencia",objDao.getTipofrecuencia()));
			}
			if(UtilesCommons.noEsVacio(objDao.getFormularioid())){
				criteria.add(Restrictions.eq("formularioid",objDao.getFormularioid()));
			}

		}else {
		}
	}
}
