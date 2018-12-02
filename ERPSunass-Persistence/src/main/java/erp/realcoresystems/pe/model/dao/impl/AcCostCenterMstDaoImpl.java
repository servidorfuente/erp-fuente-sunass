package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.AcCostCenterMstDao;
import erp.realcoresystems.pe.model.domain.AcCostCenterMst;
import erp.realcoresystems.pe.model.domain.Entidad;

@Repository
public class AcCostCenterMstDaoImpl extends AbstractDaoImpl<AcCostCenterMst, String>implements AcCostCenterMstDao {

	protected AcCostCenterMstDaoImpl() {
		super(AcCostCenterMst.class);
	}

	@Override
	public AcCostCenterMst obtenerPorID(String id) {
		Object result = findById(id);
		return UtilesCommons.esNulo(result) ? null : (AcCostCenterMst) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcCostCenterMst> listar(AcCostCenterMst filtro, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(AcCostCenterMst.class);
		filtrarEntidad(criteria, filtro);
		filtro.setPaginable(paginable);
		setPaginable(filtro, criteria);
		return criteria.list();
	}

	@Override
	public int contar(AcCostCenterMst filtro) {
		Criteria criteria = getCurrentSession().createCriteria(AcCostCenterMst.class);
		filtrarEntidad(criteria, filtro);
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}

	@Override
	public int guardar(AcCostCenterMst objSave) {
		save(objSave);
		return 1;
	}

	@Override
	public int actualizar(AcCostCenterMst objSave) {
		update(objSave);
		return 1;
	}

	@Override
	public int eliminar(AcCostCenterMst objSave) {
		delete(objSave);
		return 1;
	}

	public <V extends Entidad> void filtrarEntidad(Criteria criteria, V entidad) {
		if (UtilesCommons.esInstancia(entidad, AcCostCenterMst.class)) {
			AcCostCenterMst filtro = (AcCostCenterMst) entidad;

			if (UtilesCommons.noEsVacio(filtro.getCostcenter())) {
				criteria.add(Restrictions.eq("costcenter", filtro.getCostcenter()));
			}
			if (UtilesCommons.noEsVacio(filtro.getLocalname())) {
				criteria.add(Restrictions.eq("localname", filtro.getLocalname()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCostcenterclasification())) {
				criteria.add(Restrictions.eq("costcenterclasification", filtro.getCostcenterclasification()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCostcentergroup())) {
				criteria.add(Restrictions.eq("costcentergroup", filtro.getCostcentergroup()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCostcentersubgroup())) {
				criteria.add(Restrictions.eq("costcentersubgroup", filtro.getCostcentersubgroup()));
			}
			if (UtilesCommons.noEsVacio(filtro.getStatus())) {
				criteria.add(Restrictions.eq("status", filtro.getStatus()));
			}
		}
	}

}
