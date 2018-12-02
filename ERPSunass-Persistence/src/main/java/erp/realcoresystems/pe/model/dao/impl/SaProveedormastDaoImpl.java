package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.ProveedormastDao;
import erp.realcoresystems.pe.model.domain.Proveedormast;

@Repository
public class SaProveedormastDaoImpl extends AbstractDaoImpl<Proveedormast, Long>implements ProveedormastDao {

	protected SaProveedormastDaoImpl() {
		super(Proveedormast.class);
	}

	@Override
	public Proveedormast obtenerPorID(Proveedormast proveedormast) {
		Criteria criteria = getCurrentSession().createCriteria(Proveedormast.class);
		criteria.add(Restrictions.eq("proveedor", proveedormast.getProveedor()));
		return (Proveedormast) criteria.uniqueResult();
	}

	@Override
	public List<Proveedormast> validate(Proveedormast proveedormast) {
		Criteria criteria = getCurrentSession().createCriteria(Proveedormast.class);

		// if (proveedormast.getAulaulaid() != null) {
		// criteria.add(Restrictions.ne("aulaulaid",
		// proveedormast.getAulaulaid()));
		// }
		//
		// Criterion rest1 = Restrictions.eq("aulcodigo",
		// proveedormast.getAulcodigo()).ignoreCase();
		// Criterion rest2 = Restrictions.eq("auldescripcion",
		// proveedormast.getAuldescripcion()).ignoreCase();
		// criteria.add(Restrictions.or(rest1, rest2));

		return (List<Proveedormast>) criteria.list();
	}

	@Override
	public List<Proveedormast> listar(Proveedormast proveedormast) {
		Criteria criteria = getCurrentSession().createCriteria(Proveedormast.class);
		criteria.setFirstResult(proveedormast.getInicio());
		criteria.setMaxResults(proveedormast.getNumeroFilas());
		criteria.setFetchSize(proveedormast.getNumeroFilas());

		if (proveedormast.getSaPersona() != null) {

			criteria.createCriteria("saPersona", "persona");
			if (proveedormast.getSaPersona().getDocumento() != null) {
				criteria.add(Restrictions.ilike("persona.documento", proveedormast.getSaPersona().getDocumento(),
						MatchMode.ANYWHERE));
			}

			if (proveedormast.getSaPersona().getNombrecompleto() != null) {
				criteria.add(Restrictions.ilike("persona.nombrecompleto",
						proveedormast.getSaPersona().getNombrecompleto(), MatchMode.ANYWHERE));
			}

			if (proveedormast.getSaPersona().getEstado() != null && !"".equals(proveedormast.getSaPersona().getEstado())) {
				criteria.add(Restrictions.eq("persona.estado", proveedormast.getSaPersona().getEstado()));
			}
		}
		// if (proveedormast.getAuldescripcion() != null &&
		// !("").equals(proveedormast.getAuldescripcion())) {
		// criteria.add(
		// Restrictions.like("auldescripcion",
		// proveedormast.getAuldescripcion(), MatchMode.ANYWHERE).ignoreCase());
		// }
		// if (proveedormast.getSedsedeid() != null &&
		// proveedormast.getSedsedeid() != 0) {
		// criteria.add(Restrictions.eq("sedsedeid",
		// proveedormast.getSedsedeid()));
		// }
		// if (proveedormast.getAulestado() != null &&
		// proveedormast.getAulestado() != 0) {
		// criteria.add(Restrictions.eq("aulestado",
		// proveedormast.getAulestado()));
		// }
		// criteria.addOrder(Order.asc("aulcodigo"));
		return (List<Proveedormast>) criteria.list();
	}

	@Override
	public List<Proveedormast> listarCombo(Proveedormast proveedormast) {
		Criteria criteria = getCurrentSession().createCriteria(Proveedormast.class);

		// if (proveedormast.getSaPersona() != null) {
		//
		// criteria.createCriteria("saPersona", "persona");
		// if (proveedormast.getSaPersona().getDocumento() != null) {
		// criteria.add(Restrictions.ilike("persona.documento",
		// proveedormast.getSaPersona().getDocumento(),MatchMode.ANYWHERE));
		// }
		//
		// if (proveedormast.getSaPersona().getNombrecompleto() != null) {
		// criteria.add(
		// Restrictions.ilike("persona.nombrecompleto",
		// proveedormast.getSaPersona().getNombrecompleto(),MatchMode.ANYWHERE));
		// }
		//
		// if (proveedormast.getSaPersona().getEstado() != null) {
		// criteria.add(
		// Restrictions.like("persona.estado",
		// proveedormast.getSaPersona().getEstado()));
		// }
		// }
		criteria.createCriteria("saPersona", "persona");
		criteria.add(Restrictions.like("persona.estado", "A"));

		return (List<Proveedormast>) criteria.list();
	}

	@Override
	public int guardar(Proveedormast proveedormast) {

		saveOrUpdate(proveedormast);
		return 1;
	}

	@Override
	public int eliminar(Proveedormast proveedormast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contador(Proveedormast proveedormast) {
		Criteria criteria = getCurrentSession().createCriteria(Proveedormast.class);
		criteria.setProjection(Projections.rowCount());
		if (proveedormast.getSaPersona() != null) {

			criteria.createCriteria("saPersona", "persona");
			if (proveedormast.getSaPersona().getDocumento() != null) {
				criteria.add(Restrictions.ilike("persona.documento", proveedormast.getSaPersona().getDocumento(),
						MatchMode.ANYWHERE));
			}

			if (proveedormast.getSaPersona().getNombrecompleto() != null) {
				criteria.add(Restrictions.ilike("persona.nombrecompleto",
						proveedormast.getSaPersona().getNombrecompleto(), MatchMode.ANYWHERE));
			}

			if (proveedormast.getSaPersona().getEstado() != null && !"".equals(proveedormast.getSaPersona().getEstado())) {
				criteria.add(Restrictions.eq("persona.estado", proveedormast.getSaPersona().getEstado()));
			}
		}
		
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public int actualizar(Proveedormast proveedormast) {
		merge(proveedormast);
		//getCurrentSession().merge(proveedormast);
		return 1;
	}
}
