package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTipocursoDao;
import erp.realcoresystems.pe.model.domain.SaTipocurso;
import erp.realcoresystems.pe.model.domain.SaTipopProcReglamento;
import erp.realcoresystems.pe.model.util.Utiles;

import java.util.List;

@Repository
public class SaTipocursoDaoImpl extends AbstractDaoImpl<SaTipocurso, String> implements SaTipocursoDao {

	protected SaTipocursoDaoImpl() {
		super(SaTipocurso.class);
	}

	@Override
	public SaTipocurso obtenerPorID(SaTipocurso saTipocurso) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipocurso.class);
		criteria.add(Restrictions.eq("tcutipocursoid", saTipocurso.getTcutipocursoid()));
		Object o = criteria.uniqueResult();
		return o == null ? null : (SaTipocurso) o;
		// return(SaTipocurso) criteria.uniqueResult();
	}

	@Override
	public List<SaTipocurso> listar(SaTipocurso filtro, boolean paginable) {
		Criteria criteria = createCriteria();

		if (UtilesCommons.sonCadenasIguales("CONSULTA_TIPO_CURSO_IDS", filtro.getString10())
				&& UtilesCommons.noEsVacio(filtro.getListaInteger())) {
			criteria.add(Restrictions.in("tcutipocursoid", filtro.getListaInteger()));
		} else {
			if (UtilesCommons.noEsVacio(filtro.getTcutipocursoid())) {
				criteria.add(Restrictions.eq("tcutipocursoid", filtro.getTcutipocursoid()));
			}
		}
		if (UtilesCommons.noEsVacio(filtro.getTcudescripcion())) {
			criteria.add(Restrictions.eq("tcudescripcion", filtro.getTcudescripcion()));
		}
		if (UtilesCommons.noEsVacio(filtro.getTcuestado())) {
			criteria.add(Restrictions.eq("tcuestado", filtro.getTcuestado()));
		}

		if (paginable) {
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}

		return (List<SaTipocurso>) criteria.list();
	}

	@Override
	public List<SaTipocurso> listar(SaTipocurso saTipocurso) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipocurso.class);

		if (saTipocurso.getTcucodigo() != null && !saTipocurso.getTcucodigo().trim().isEmpty()) {
			criteria.add(Restrictions.ilike("tcucodigo", saTipocurso.getTcucodigo(), MatchMode.ANYWHERE));
		}

		if (saTipocurso.getTcudescripcion() != null && !saTipocurso.getTcudescripcion().trim().isEmpty()) {
			criteria.add(Restrictions.ilike("tcudescripcion", saTipocurso.getTcudescripcion(), MatchMode.ANYWHERE));
		}

		if (saTipocurso.getTcuestado() != null && saTipocurso.getTcuestado() != 0) {
			criteria.add(Restrictions.eq("tcuestado", saTipocurso.getTcuestado()));
		}
		criteria.setFirstResult(saTipocurso.getInicio());
		criteria.setMaxResults(saTipocurso.getNumeroFilas());
		criteria.setFetchSize(saTipocurso.getNumeroFilas());
		return (List<SaTipocurso>) criteria.list();
	}

	@Override
	public int contador(SaTipocurso saTipocurso) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipocurso.class);
		// criteria.setProjection(Projections.rowCount());

		if (saTipocurso.getTcucodigo() != null && !saTipocurso.getTcucodigo().trim().isEmpty()) {
			criteria.add(Restrictions.ilike("tcucodigo", saTipocurso.getTcucodigo(), MatchMode.ANYWHERE));
		}

		if (saTipocurso.getTcudescripcion() != null && !saTipocurso.getTcudescripcion().trim().isEmpty()) {
			criteria.add(Restrictions.ilike("tcudescripcion", saTipocurso.getTcudescripcion(), MatchMode.ANYWHERE));
		}
		if (saTipocurso.getTcuestado() != null && saTipocurso.getTcuestado() != 0) {
			criteria.add(Restrictions.eq("tcuestado", saTipocurso.getTcuestado()));
		}
		// return Integer.parseInt(criteria.uniqueResult().toString());
		Long rows = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return rows.intValue();

	}

	@Override
	public int guardar(SaTipocurso saTipocurso) {
		if (saTipocurso.getTcutipocursoid() == null) {
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("tcutipocursoid"));
			Criteria criteria = getCurrentSession().createCriteria(SaTipocurso.class);
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();

			// GENERAR EL ID
			int valorMax = 1;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			saTipocurso.setTcutipocursoid(valorMax + 1);
			saTipocurso.setTcucodigo(Utiles.obtenerCodigoString(valorMax + 1, 3));
		}

		saveOrUpdate(saTipocurso);
		return saTipocurso.getTcutipocursoid();

		// Criteria criteria =
		// getCurrentSession().createCriteria(SaTipocurso.class).setProjection(Projections.max("tcutipocursoid"));
		// int id = criteria.uniqueResult() == null ? 1 : 1 +
		// (int)criteria.uniqueResult();
		// saTipocurso.setTcutipocursoid(id);
		// saTipocurso.setTcucodigo(Utiles.obtenerCodigoString(id, 3));
		// saveOrUpdate(saTipocurso);
		// return id;

	}

	@Override
	public int actualizar(SaTipocurso objSave) {
		update(objSave);
		return 1;
	}

	@Override
	public int eliminar(SaTipocurso objSave) {
		delete(objSave);
		return 1;
	}

	@Override
	public List<SaTipocurso> listarCombo(SaTipocurso saTipocurso) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipocurso.class);
		if (saTipocurso.getTcuestado() != null) {
			criteria.add(Restrictions.eq("tcuestado", saTipocurso.getTcuestado()));
		}

		return (List<SaTipocurso>) criteria.list();
	}
}
