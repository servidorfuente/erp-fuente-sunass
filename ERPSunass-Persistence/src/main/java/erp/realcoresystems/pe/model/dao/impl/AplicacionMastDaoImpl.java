package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.AplicacionMastDao;
import erp.realcoresystems.pe.model.domain.Aplicacionesmast;

@Repository
public class AplicacionMastDaoImpl extends AbstractDaoImpl<Aplicacionesmast, String>implements AplicacionMastDao {


	protected AplicacionMastDaoImpl() {
		super(Aplicacionesmast.class);
	}
	
	@Override
	public Aplicacionesmast buscarPorID(String id) {
		Criteria cq = getCurrentSession().createCriteria(Aplicacionesmast.class);
		cq.add(Restrictions.eq("aplicacioncodigo", id));
		return (Aplicacionesmast) cq.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aplicacionesmast> listarPorEstado(String estado) {
		Criteria cq = getCurrentSession().createCriteria(Aplicacionesmast.class);
		if(estado != null && "".equals(estado)){
			cq.add(Restrictions.eq("estado", estado));
		}
		return (List<Aplicacionesmast>) cq.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aplicacionesmast> listarTodos(Aplicacionesmast aplicacionesMast) {
		Criteria cq = getCurrentSession().createCriteria(Aplicacionesmast.class);
		if (UtilesCommons.sonCadenasIguales(aplicacionesMast.getEstado(), "ACTIVO")) {
			cq.add(Restrictions.eq("estado", "ACTIVO"));
		}
		return (List<Aplicacionesmast>) cq.list();
	}

}
