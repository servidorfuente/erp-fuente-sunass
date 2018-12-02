package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.SaCompendioDetalleDao;
import erp.realcoresystems.pe.model.domain.SaCompendioDetalle;
import java.util.List;

@Repository
public class SaCompendioDetalleDaoImpl extends AbstractDaoImpl<SaCompendioDetalle, String>  implements SaCompendioDetalleDao {


	protected SaCompendioDetalleDaoImpl() {
		super(SaCompendioDetalle.class);
	}


	@Override
	public SaCompendioDetalle obtenerPorId(int nidecompendio, int nidedetalle) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendioDetalle.class);
		criteria.add(Restrictions.eq("nidecompendio", nidecompendio));
		criteria.add(Restrictions.eq("nidedetalle", nidedetalle));
		return (SaCompendioDetalle) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaCompendioDetalle> listar(SaCompendioDetalle saCompendioDetalle) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendioDetalle.class);
		criteria.add(Restrictions.eq("nidecompendio", saCompendioDetalle.getNidecompendio()));
		criteria.setFirstResult(saCompendioDetalle.getInicio());
		criteria.setMaxResults(saCompendioDetalle.getNumeroFilas());
		criteria.setFetchSize(saCompendioDetalle.getNumeroFilas());
		return (List<SaCompendioDetalle>) criteria.list();
	}

	@Override
	public int guardar(SaCompendioDetalle saCompendioDetalle) {
		return 0;
	}

	@Override
	public int actualizar(SaCompendioDetalle saCompendioDetalle) {
		return 0;
	}

	@Override
	public int contarTotal(SaCompendioDetalle saCompendioDetalle) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaCompendioDetalle> listarCombo(int compendioId) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendioDetalle.class);
		criteria.add(Restrictions.eq("nidecompendio", compendioId));
		return (List<SaCompendioDetalle>)criteria.list();
	}
}
