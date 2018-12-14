package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsPeriodogeneralDao;
import erp.realcoresystems.pe.model.dao.SsPeriodogeneralDao;
import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsPeriodogeneralDaoImpl extends AbstractDaoImpl<SsPeriodogeneral, String> implements SsPeriodogeneralDao {

	protected SsPeriodogeneralDaoImpl() {
		super(SsPeriodogeneral.class);
	}


	@Override
	public SsPeriodogeneral buscar(SsPeriodogeneral objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsPeriodogeneral.class);
		filtrarCritera(criteria, objDao);
		setOrdenable(criteria, ORDER_ASC, objDao.getListaAtributoOrdenacion());
		SsPeriodogeneral obj = (SsPeriodogeneral) criteria.uniqueResult();
		return (SsPeriodogeneral) criteria.uniqueResult();
	}

	@Override
	public List<SsPeriodogeneral> listar(SsPeriodogeneral objDao, boolean pagina) {
		Criteria criteria = getCurrentSession().createCriteria(SsPeriodogeneral.class);
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
		if (objDao.getString10().equals("NULL")){
			filtrarCriteraVistaNull(criteria, objDao);
		}else {
			filtrarCriteraVista(criteria, objDao);
		}

		setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
		return criteria.list();
	}

	public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo objDao, boolean pagina) {
		Criteria criteria = getCurrentSession().createCriteria(VwControlperiodo.class);
		criteria.setProjection(Projections.projectionList()//.add(Projections.count("idcontador").as("idcontador"))
				.add(Projections.groupProperty("companyowner").as("companyowner"))
				.add(Projections.groupProperty("description").as("description"))
		 );
		if (pagina){
			objDao.setPaginable(true);
			setPaginable(objDao, criteria);
		}
		if (objDao.getString10().equals("NULL")){
			filtrarCriteraVistaNull(criteria, objDao);
		}else {
			filtrarCriteraVista(criteria, objDao);
		}
		setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
		criteria.setResultTransformer(Transformers.aliasToBean(VwControlperiodo.class));
		List<VwControlperiodo> result = criteria.list();
		return criteria.list();
	}

	@Override
	public int contarVista(VwControlperiodo objDao) {
		Criteria criteria = getCurrentSession().createCriteria(VwControlperiodo.class);
		if (objDao.getString10().equals("NULL")){
			filtrarCriteraVistaNull(criteria, objDao);
		}else {
			filtrarCriteraVista(criteria, objDao);
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

	@Override
	public int contarVistaGrupo(VwControlperiodo filtro) {
		Criteria criteria = getCurrentSession().createCriteria(VwControlperiodo.class);
		criteria.setProjection(Projections.projectionList()//.add(Projections.count("idcontador").as("idcontador"))
				.add(Projections.groupProperty("companyowner").as("companyowner"))
				.add(Projections.groupProperty("description").as("description"))
		);
		if (filtro.getString10().equals("NULL")){
			filtrarCriteraVistaNull(criteria, filtro);
		}else {
			filtrarCriteraVista(criteria, filtro);
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

	@Override
	public int guardar(SsPeriodogeneral objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsPeriodogeneral.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("periodoid"));
		criteria.setProjection(proj);
		Object result = criteria.uniqueResult();
		Integer valorMax=0;
		if(result!=null){
			valorMax = Integer.parseInt(result.toString());
		}
		objDao.setPeriodoid(valorMax+1);
		save(objDao);
		return 1;
	}

	@Override
	public int actualizar(SsPeriodogeneral objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(SsPeriodogeneral objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int contar(SsPeriodogeneral objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SsPeriodogeneral.class);
		filtrarCritera(criteria, objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}



	public void filtrarCriteraVistaNull(Criteria criteria, Object objFiltro){
		if(objFiltro instanceof VwControlperiodo){
			VwControlperiodo  objDao = (VwControlperiodo)objFiltro;
			//criteria.add(Restrictions.isNull("anno"));
		}else {
		}
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
		if(objFiltro instanceof SsPeriodogeneral){
			SsPeriodogeneral  objDao = (SsPeriodogeneral)objFiltro;
			if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
				criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
			}
			if(UtilesCommons.noEsVacio(objDao.getSucursal())){
				criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
			}
			if(UtilesCommons.noEsVacio(objDao.getTipooperacion())){
				criteria.add(Restrictions.eq("tipooperacion",objDao.getTipooperacion()));
			}
			if(UtilesCommons.noEsVacio(objDao.getInteger1())){
				criteria.add(Restrictions.eq("anno",objDao.getInteger1()));
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
			if(UtilesCommons.noEsVacio(objDao.getFlagmodocargainicial())){
				criteria.add(Restrictions.eq("flagmodocargainicial",objDao.getFlagmodocargainicial()));
			}
			if(UtilesCommons.noEsVacio(objDao.getEstadodocumento())){
				criteria.add(Restrictions.eq("estadodocumento",objDao.getEstadodocumento()));
			}
			if(UtilesCommons.noEsVacio(objDao.getFormularioid())){
				criteria.add(Restrictions.eq("formularioid",objDao.getFormularioid()));
			}

		}else {
		}
	}
}
