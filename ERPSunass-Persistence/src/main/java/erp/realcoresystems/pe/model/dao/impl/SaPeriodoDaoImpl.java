package erp.realcoresystems.pe.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaPeriodoDao;
import erp.realcoresystems.pe.model.domain.SaPeriodo;
import erp.realcoresystems.pe.model.util.Utiles;

@Repository
public class SaPeriodoDaoImpl extends AbstractDaoImpl<SaPeriodo, Integer> implements SaPeriodoDao {

	protected SaPeriodoDaoImpl() {
		super(SaPeriodo.class);
	}
	
	@Override
	public SaPeriodo obtenerPorId(Integer unidadNegocioId, Integer modalidadEstudioId, Integer periodoId){
		Criteria cq = getCurrentSession().createCriteria(SaPeriodo.class);
		cq.add(Restrictions.eq("uneunegocioid", unidadNegocioId));
		cq.add(Restrictions.eq("moemestudioid", modalidadEstudioId));
		cq.add(Restrictions.eq("perperiodoid", periodoId));
		return (SaPeriodo) cq.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPeriodo> validate(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getUneunegocioid() != null && saPeriodo.getUneunegocioid() != 0) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null && saPeriodo.getMoemestudioid() != 0) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		if (saPeriodo.getPerperiodoid() != null) {
			criteria.add(Restrictions.ne("perperiodoid", saPeriodo.getPerperiodoid()));
		}
		if (saPeriodo.getPerperiodo() != null && saPeriodo.getPerdescripcion() != null) {
			Criterion rest1 = Restrictions.like("perperiodo", saPeriodo.getPerperiodo(), MatchMode.ANYWHERE)
					.ignoreCase();
			Criterion rest2 = Restrictions.like("perdescripcion", saPeriodo.getPerdescripcion(), MatchMode.ANYWHERE)
					.ignoreCase();

			criteria.add(Restrictions.or(rest1, rest2));
		}
		return (List<SaPeriodo>) criteria.list();
	}

	@Override
	public SaPeriodo periodoActivo(SaPeriodo saPeriodo) {
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("perperiodoid"));
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getPerestado() != null) {
			criteria.add(Restrictions.ne("perestado", saPeriodo.getPerestado()));
		}
		criteria.setProjection(proj);
		Object result = criteria.uniqueResult();
		// Genera el ID
		Integer valorMax = null;
		if (result != null) {
			valorMax = Integer.parseInt(result.toString());
		}
		Criteria criterias = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getPerestado() != null) {
			criterias.add(Restrictions.ne("perestado", saPeriodo.getPerestado()));
		}
		if (valorMax != null) {
			criterias.add(Restrictions.ne("perperiodoid", valorMax));
		}
		return (SaPeriodo) criterias.uniqueResult();
	}

	@Override
	public SaPeriodo obtenerPorID(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		criteria.add(Restrictions.eq("perperiodoid", saPeriodo.getPerperiodoid()));
		return (SaPeriodo) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPeriodo> listar(SaPeriodo saPeriodo,boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		
		if(paginable){
			criteria.setFirstResult(saPeriodo.getInicio());
			criteria.setMaxResults(saPeriodo.getNumeroFilas());
			criteria.setFetchSize(saPeriodo.getNumeroFilas());	
		}
		
		if (UtilesCommons.noEsVacio(saPeriodo.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (UtilesCommons.noEsVacio(saPeriodo.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		if (UtilesCommons.noEsVacio(saPeriodo.getPerperiodo())) {
			criteria.add(Restrictions.like("perperiodo", saPeriodo.getPerperiodo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(saPeriodo.getPerdescripcion())) {
			criteria.add(Restrictions.like("perdescripcion", saPeriodo.getPerdescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (UtilesCommons.noEsVacio(saPeriodo.getPerestado())) {
			criteria.add(Restrictions.eq("perestado", saPeriodo.getPerestado()));
		}
		if ("FECHA_EN_RANGO_PERIODO".equals(saPeriodo.getFlagConsultaEntGlobal())) {
			if (UtilesCommons.noEsVacio(saPeriodo.getPerfechainicio())) {
				criteria.add(Restrictions.le("perfechainicio", saPeriodo.getPerfechainicio()));	
				criteria.add(Restrictions.ge("perfechafin", saPeriodo.getPerfechainicio()));
			}			
		}
		
		return (List<SaPeriodo>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPeriodo> listarCombo(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getUneunegocioid() != null && saPeriodo.getUneunegocioid() != 0) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null && saPeriodo.getMoemestudioid() != 0) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		criteria.add(Restrictions.eq("perestado", 1));
		// es ordenado en forma descendente para mostrar en el combo de anio y que se seleccione por defecto el anio actual
		criteria.addOrder(Order.desc("perfechacreacion"));
		return (List<SaPeriodo>) criteria.list();
	}

	@Override
	public int guardar(SaPeriodo saPeriodo) {
		if(saPeriodo.getPerperiodoid() == null || saPeriodo.getPerperiodoid() == 0){
			Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class).setProjection(Projections.max("perperiodoid"));
			Object o = criteria.uniqueResult();
			int id = o == null ? 1 : 1 + (int) o;
			saPeriodo.setPerperiodoid(id);
			save(saPeriodo);
		}else{
			update(saPeriodo);
		}
		return 1;
	}

	@Override
	public int actualizar(SaPeriodo objDao){
		update(objDao);
		return 1;
	}
	
	@Override
	public int eliminar(SaPeriodo objDao){
		delete(objDao);
		return 1;
	}
	
	@Override
	public int contador(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		
		if (saPeriodo.getUneunegocioid() != null && saPeriodo.getUneunegocioid() != 0) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null && saPeriodo.getMoemestudioid() != 0) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		if (!Utiles.vacio(saPeriodo.getPerperiodo())) {
			criteria.add(Restrictions.like("perperiodo", saPeriodo.getPerperiodo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (!Utiles.vacio(saPeriodo.getPerdescripcion())) {
			criteria.add(Restrictions.like("perdescripcion", saPeriodo.getPerdescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (saPeriodo.getPerestado() != null && saPeriodo.getPerestado() > 0) {
			criteria.add(Restrictions.eq("perestado", saPeriodo.getPerestado()));
		}
		if ("FECHA_EN_RANGO_PERIODO".equals(saPeriodo.getFlagConsultaEntGlobal())) {
			if (UtilesCommons.noEsVacio(saPeriodo.getPerfechainicio())) {
				criteria.add(Restrictions.le("perfechainicio", saPeriodo.getPerfechainicio()));	
				criteria.add(Restrictions.ge("perfechafin", saPeriodo.getPerfechainicio()));
			}			
		}
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPeriodo> listarPorNegocio(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getUneunegocioid() != null) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		if (saPeriodo.getPerestado() != null) {
			criteria.add(Restrictions.eq("perestado",saPeriodo.getPerestado()));
		}				
		// es ordenado en forma descendente para mostrar en el combo de anio y que se seleccione por defecto el anio actual
		criteria.addOrder(Order.desc("perfechacreacion"));		
		return (List<SaPeriodo>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaPeriodo> obtenerPorFecha(SaPeriodo saPeriodo, Date fecha) {
		Criteria cq = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getUneunegocioid() != null) {
			cq.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null) {
			cq.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		cq.add(Restrictions.ge("perfechafin", fecha));
		cq.add(Restrictions.le("perfechainicio", fecha));
		return (List<SaPeriodo>) cq.list();
	}

	@Override
	public Integer obtenerPeriodoActual(SaPeriodo saPeriodo) {
		Criteria criteria = getCurrentSession().createCriteria(SaPeriodo.class);
		if (saPeriodo.getUneunegocioid() != null && saPeriodo.getUneunegocioid() != 0) {
			criteria.add(Restrictions.eq("uneunegocioid", saPeriodo.getUneunegocioid()));
		}
		if (saPeriodo.getMoemestudioid() != null && saPeriodo.getMoemestudioid() != 0) {
			criteria.add(Restrictions.eq("moemestudioid", saPeriodo.getMoemestudioid()));
		}
		criteria.setProjection(Projections.max("perperiodoid"));
		Object o = criteria.uniqueResult();
		return o == null ? null : (Integer) o ;
	}

}
