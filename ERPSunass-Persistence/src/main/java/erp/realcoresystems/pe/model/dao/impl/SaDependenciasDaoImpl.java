package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.SaDependenciasDao;
import erp.realcoresystems.pe.model.domain.SaDependencias;

import java.util.List;

@Repository
public class SaDependenciasDaoImpl extends AbstractDaoImpl<SaDependencias, String>implements SaDependenciasDao {

	protected SaDependenciasDaoImpl() {
		super(SaDependencias.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaDependencias obtenerPorID(int nidedep) {
		Criteria criteria = getCurrentSession().createCriteria(SaDependencias.class);
		criteria.add(Restrictions.eq("nidedep", nidedep));
		return (SaDependencias) criteria.uniqueResult();
	}

	@Override
	public List<SaDependencias> listar(SaDependencias SaDependencias) {

		Criteria criteria = getCurrentSession().createCriteria(SaDependencias.class);
		criteria.setFirstResult(SaDependencias.getInicio());
		criteria.setMaxResults(SaDependencias.getNumeroFilas());
		criteria.setFetchSize(SaDependencias.getNumeroFilas());

		if (SaDependencias.getUneunegocioid() != null) {
			criteria.add(Restrictions.eq("uneunegocioid", SaDependencias.getUneunegocioid()));
		}
		// al insertar -1 como nidedeppadre buscara solo los padres
		if (SaDependencias.getNidedeppadre() != null && SaDependencias.getNidedeppadre() == -1) {
			criteria.add(Restrictions.isNull("nidedeppadre"));
		}
		if (SaDependencias.getVdescripcion() != null) {
			criteria.add(Restrictions.ilike("vdescripcion", SaDependencias.getVdescripcion(), MatchMode.ANYWHERE));
		}
		if (SaDependencias.getNestado() != null && SaDependencias.getNestado() != 0) {
			criteria.add(Restrictions.eq("nestado", SaDependencias.getNestado()));
		}

		return (List<SaDependencias>) criteria.list();
	}

	@Override
	public List<SaDependencias> listarDetalles(SaDependencias SaDependencias) {

		Criteria criteria = getCurrentSession().createCriteria(SaDependencias.class);
		// // lista el papa con todos sus hijos
		// criteria.add(Restrictions.eq("nidedep",
		// SaDependencias.getNidedep()));
		// criteria.add(Restrictions.eq("nidedeppadre",
		// SaDependencias.getNidedep()));
		return (List<SaDependencias>) criteria.list();
	}

	@Override
	public int guardar(SaDependencias SaDependencias) {

		if (SaDependencias.getNidedep() == null || SaDependencias.getNidedep() < 0) {
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("nidedep"));
			Criteria criteria = getCurrentSession().createCriteria(SaDependencias.class);
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();
			// Genera el ID
			int valorMax = 0;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			String codigo = "000".concat(Integer.toString(valorMax + 1));
			codigo = codigo.substring(Integer.toString(valorMax + 1).length());
			SaDependencias.setNcoddep(codigo);
			SaDependencias.setNidedep(valorMax + 1);
			// TEMPORAL
			SaDependencias.setNidetipodep(1);
		}
		saveOrUpdate(SaDependencias);
		return SaDependencias.getNidedep();
	}

	@Override
	public int eliminar(SaDependencias SaDependencias) {
		return 0;
	}

	@Override
	public int contador(SaDependencias SaDependencias) {
		Criteria criteria = getCurrentSession().createCriteria(SaDependencias.class);
		criteria.setProjection(Projections.rowCount());

		if (SaDependencias.getUneunegocioid() != null) {
			criteria.add(Restrictions.eq("uneunegocioid", SaDependencias.getUneunegocioid()));
		}
		// al insertar -1 como nidedeppadre buscara solo los padres
		if (SaDependencias.getNidedeppadre() != null && SaDependencias.getNidedeppadre() == -1) {
			criteria.add(Restrictions.isNull("nidedeppadre"));
		}
		if (SaDependencias.getVdescripcion() != null) {
			criteria.add(Restrictions.ilike("vdescripcion", SaDependencias.getVdescripcion(), MatchMode.ANYWHERE));
		}
		if (SaDependencias.getNestado() != null && SaDependencias.getNestado() != 0) {
			criteria.add(Restrictions.eq("nestado", SaDependencias.getNestado()));
		}

		return Integer.parseInt(criteria.uniqueResult().toString());

	}
}
