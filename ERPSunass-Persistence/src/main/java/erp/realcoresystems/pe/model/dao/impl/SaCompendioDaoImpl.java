package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.SaCompendioDao;
import erp.realcoresystems.pe.model.domain.SaCompendio;
import java.util.List;

@Repository
public class SaCompendioDaoImpl extends AbstractDaoImpl<SaCompendio, String>  implements SaCompendioDao {

	protected SaCompendioDaoImpl() {
		super(SaCompendio.class);
	}

	@Override
	public SaCompendio obtenerEntidad(SaCompendio saCompendio) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendio.class);
		criteria.add(Restrictions.eq("NIDECOMPENDIO", saCompendio.getNidecompendio()));
		return (SaCompendio) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaCompendio> listar(SaCompendio saCompendio) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendio.class);
		criteria.add(Restrictions.eq("NIDECOMPENDIO", saCompendio.getNidecompendio()));
		criteria.setFirstResult(saCompendio.getInicio());
		criteria.setMaxResults(saCompendio.getNumeroFilas());
		criteria.setFetchSize(saCompendio.getNumeroFilas());
		return (List<SaCompendio>) criteria.list();
	}

	@Override
	public int guardar(SaCompendio saCompendio) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendio.class).setProjection(Projections.max("NIDECOMPENDIO"));
		int id = criteria.uniqueResult() == null ? 1 : 1 + (int)criteria.uniqueResult();
		saCompendio.setNidecompendio(id);
		save(saCompendio);
		return id;
	}

	@Override
	public int actualizar(SaCompendio saCompendio) {
		update(saCompendio);
		return 1;
	}

	@Override
	public int contarTotal(SaCompendio saCompendio) {
		Criteria criteria = getCurrentSession().createCriteria(SaCompendio.class);
		criteria.add(Restrictions.eq("NIDECOMPENDIO", saCompendio.getNidecompendio()));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
}
