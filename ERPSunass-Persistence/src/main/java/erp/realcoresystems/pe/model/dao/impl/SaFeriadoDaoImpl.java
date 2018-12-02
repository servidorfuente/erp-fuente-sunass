package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaFeriadoDao;
import erp.realcoresystems.pe.model.domain.SaFeriado;

@Repository
public class SaFeriadoDaoImpl extends AbstractDaoImpl<SaFeriado, Integer>implements SaFeriadoDao {

	protected SaFeriadoDaoImpl() {
		super(SaFeriado.class);
	}

	@Override
	public SaFeriado obtenerPorID(Integer id) {
		Object result = findById(id);
		return UtilesCommons.esNulo(result) ? null : (SaFeriado) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaFeriado> listar(SaFeriado filtro, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaFeriado.class);
		filtrarEntidad(criteria, filtro);
		if (paginable) {
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}

		return criteria.list();
	}

	@Override
	public int contarTotal(SaFeriado filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaFeriado.class);
		filtrarEntidad(criteria, filtro);
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}

	@Override
	public int obtenerMaxId() {
		Criteria criteria = getCurrentSession().createCriteria(SaFeriado.class);
		criteria.setProjection(Projections.max("fdoferiodoid"));
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}

	@Override
	public int guardar(SaFeriado objSave) {
		save(objSave);
		return 1;
	}

	@Override
	public int actualizar(SaFeriado objSave) {
		update(objSave);
		return 1;
	}

	@Override
	public int eliminar(SaFeriado objSave) {
		delete(objSave);
		return 1;
	}

	public <V> void filtrarEntidad(Criteria criteria, V entidad) {
		if (UtilesCommons.esInstancia(entidad, SaFeriado.class)) {
			SaFeriado filtro = (SaFeriado) entidad;
			if (UtilesCommons.noEsVacio(filtro.getFdoferiodoid())) {
				criteria.add(Restrictions.eq("fdoferiodoid", filtro.getFdoferiodoid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getFdodescripcion())) {
				criteria.add(Restrictions.like("fdodescripcion", filtro.getFdodescripcion(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (UtilesCommons.noEsVacio(filtro.getFdoflagdiacompleto())) {
				criteria.add(Restrictions.eq("fdoflagdiacompleto", filtro.getFdoflagdiacompleto()));
			}
			if (UtilesCommons.noEsVacio(filtro.getFdotipoferiado())) {
				criteria.add(Restrictions.eq("fdotipoferiado", filtro.getFdotipoferiado()));
			}
			if (UtilesCommons.noEsVacio(filtro.getFdofecha())) {
				criteria.add(Restrictions.eq("fdofecha", filtro.getFdofecha()));
			}
			if (UtilesCommons.noEsVacio(filtro.getFdoestado())) {
				criteria.add(Restrictions.eq("fdoestado", filtro.getFdoestado()));
			}
		}
	}

}
