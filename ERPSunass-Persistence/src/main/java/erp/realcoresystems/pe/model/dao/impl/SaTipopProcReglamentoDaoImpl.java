package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.domain.SaTipopProcReglamento;
import erp.realcoresystems.pe.model.dao.SaTipopProcReglamentoDao;



	@Repository
	public class SaTipopProcReglamentoDaoImpl extends AbstractDaoImpl<SaTipopProcReglamento, Integer>  implements SaTipopProcReglamentoDao {

	protected SaTipopProcReglamentoDaoImpl() {
		super(SaTipopProcReglamento.class);
	}

	@Override
	public SaTipopProcReglamento obtenerTipoPorId(Integer id) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipopProcReglamento.class);
		criteria.add(Restrictions.eq("tregid", id));
		return (SaTipopProcReglamento) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaTipopProcReglamento> listarTipo(SaTipopProcReglamento saTipopProcReglamento) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipopProcReglamento.class);
		criteria.setFirstResult(saTipopProcReglamento.getInicio());
		criteria.setMaxResults(saTipopProcReglamento.getNumeroFilas());
		criteria.setFetchSize(saTipopProcReglamento.getNumeroFilas());
		
//		if (saTipopProcReglamento.getReglacodigo() != null) {
//			criteria.add(Restrictions.like("reglacodigo", saTipopProcReglamento.getReglacodigo(), MatchMode.ANYWHERE).ignoreCase());
//		}
//		if (saTipopProcReglamento.getRegladescripcion() != null) {
//			criteria.add(Restrictions.eq("regladescripcion", saTipopProcReglamento.getRegladescripcion()));
//		}
//		if (saTipopProcReglamento.getProcesoaplica() != null) {
//			criteria.add(Restrictions.eq("procesoaplica", saTipopProcReglamento.getProcesoaplica()));
//		}
//		if (saTipopProcReglamento.getEstado() != null) {
//			criteria.add(Restrictions.eq("estado", saTipopProcReglamento.getEstado()));
//		}
		return (List<SaTipopProcReglamento>) criteria.list();
	}

	
	@Override
	public int contarTipo(SaTipopProcReglamento saTipopProcReglamento) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipopProcReglamento.class);
		criteria.setProjection(Projections.rowCount());
//		if (saTipopProcReglamento.getReglacodigo() != null) {
//			criteria.add(Restrictions.like("reglacodigo", saTipopProcReglamento.getReglacodigo(), MatchMode.ANYWHERE).ignoreCase());
//		}
//
//		if (saTipopProcReglamento.getRegladescripcion() != null) {
//			criteria.add(Restrictions.eq("regladescripcion", saTipopProcReglamento.getRegladescripcion()));
//		}
//
//		if (saTipopProcReglamento.getProcesoaplica() != null) {
//			criteria.add(Restrictions.eq("procesoaplica", saTipopProcReglamento.getProcesoaplica()));
//		}
//		if (saTipopProcReglamento.getEstado() != null && saTipopProcReglamento.getEstado() != 0) {
//			criteria.add(Restrictions.eq("estado", saTipopProcReglamento.getEstado()));
//		}
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaTipopProcReglamento> listarCombo(SaTipopProcReglamento saTipopProcReglamentoId) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipopProcReglamento.class);		
		if (saTipopProcReglamentoId.getTregcodigo() != null  &&  !(""+saTipopProcReglamentoId.getTregcodigo()).isEmpty()) {
			criteria.add(Restrictions.eq("tregcodigo", saTipopProcReglamentoId.getTregcodigo()));
		}
		if (saTipopProcReglamentoId.getTregid() != null) {
			criteria.add(Restrictions.eq("tregid", saTipopProcReglamentoId.getTregid()));
		}		
		return (List<SaTipopProcReglamento>) criteria.list();
	}
	
	@Override
	public int guardarTipo(SaTipopProcReglamento saTipopProcReglamento) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipopProcReglamento.class).setProjection(Projections.max("tregid"));
		int id = criteria.uniqueResult() == null ? 1 : 1 + (int)criteria.uniqueResult();
		saTipopProcReglamento.setTregid(id);
		save(saTipopProcReglamento);
		return id;
	}
	
	
	@Override
	public int actualizarTipo(SaTipopProcReglamento saTipopProcReglamento) {
		update(saTipopProcReglamento);
		//saveOrUpdate(saTipopProcReglamento);
		return 1;
	}

	@Override
	public int eliminarTipo(SaTipopProcReglamento saTipopProcReglamento) {

		delete(saTipopProcReglamento);
		return 1;
	}
	
}
