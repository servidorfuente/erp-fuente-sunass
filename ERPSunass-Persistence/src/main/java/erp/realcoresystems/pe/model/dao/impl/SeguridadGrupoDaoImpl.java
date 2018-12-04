package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadGrupoDao;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mamania on 22/12/2015.
 */
@Repository
public class SeguridadGrupoDaoImpl extends AbstractDaoImpl<Seguridadgrupo, String> implements SeguridadGrupoDao {
    protected SeguridadGrupoDaoImpl() {
        super(Seguridadgrupo.class);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Seguridadgrupo> SeguridadGrupoLista(Seguridadgrupo seguridadgrupo) {
        seguridadgrupo.setOrden(new BigDecimal(0));
        Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
        criteria.add(Restrictions.eq("aplicacioncodigo", seguridadgrupo.getAplicacioncodigo()));
        criteria.add(Restrictions.gt("orden", seguridadgrupo.getOrden()));
        return (List<Seguridadgrupo>) criteria.list();
    }

    @Override
    public Seguridadgrupo SeguridadGrupoBuscar(Seguridadgrupo objPersonaMast) {
        return null;
    }

	@Override
	public Seguridadgrupo obtenerTipoPorId(Integer id) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		criteria.add(Restrictions.eq("tregid", id));
		return (Seguridadgrupo) criteria.uniqueResult();
	}

	@Override
	public List<Seguridadgrupo> listarTipo(Seguridadgrupo seguridadgrupo) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		criteria.setFirstResult(seguridadgrupo.getInicio());
		criteria.setMaxResults(seguridadgrupo.getNumeroFilas());
		criteria.setFetchSize(seguridadgrupo.getNumeroFilas());
		
		return (List<Seguridadgrupo>) criteria.list();
	}

	@Override
	public int contarTipo(Seguridadgrupo seguridadgrupo) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seguridadgrupo> listarCombo(Seguridadgrupo seguridadgrupo) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", seguridadgrupo.getAplicacioncodigo()));
		return (List<Seguridadgrupo>) criteria.list();
	}
	

	@Override
	public int guardarTipo(Seguridadgrupo seguridadgrupo) {
		saveOrUpdate(seguridadgrupo);
		return 1;
	}

	@Override
	public int actualizarTipo(Seguridadgrupo seguridadgrupo) {
		return 0;
	}

	@Override
	public int eliminarTipo(Seguridadgrupo seguridadgrupo) {
		delete(seguridadgrupo);
		return 1;
	}

	@Override
	public List<Seguridadgrupo> listarTodos(Seguridadgrupo seguridadgrupo, Boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		if (UtilesCommons.noEsVacio(seguridadgrupo.getAplicacioncodigo())){
			criteria.add(Restrictions.eq("aplicacioncodigo", seguridadgrupo.getAplicacioncodigo()));
		}
		if (UtilesCommons.noEsVacio(seguridadgrupo.getGrupo())){
			criteria.add(Restrictions.like("grupo", seguridadgrupo.getGrupo(),MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(seguridadgrupo.getDescripcion())) {
			criteria.add(Restrictions.like("descripcion", seguridadgrupo.getDescripcion(),MatchMode.ANYWHERE).ignoreCase());
		}
		
		if (paginable) {
			criteria.setFirstResult(seguridadgrupo.getInicio());
			criteria.setMaxResults(seguridadgrupo.getNumeroFilas());
			criteria.setFetchSize(seguridadgrupo.getNumeroFilas());
		}
		return (List<Seguridadgrupo>)criteria.list();
	}

	@Override
	public int contarTodos(Seguridadgrupo seguridadgrupo) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		if (UtilesCommons.noEsVacio(seguridadgrupo.getAplicacioncodigo())){
			criteria.add(Restrictions.eq("aplicacioncodigo", seguridadgrupo.getAplicacioncodigo()));
		}
		if (UtilesCommons.noEsVacio(seguridadgrupo.getGrupo())){
			criteria.add(Restrictions.like("grupo", seguridadgrupo.getGrupo(),MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(seguridadgrupo.getDescripcion())) {
			criteria.add(Restrictions.like("descripcion", seguridadgrupo.getDescripcion(),MatchMode.ANYWHERE).ignoreCase());
		}
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public List<Seguridadgrupo> validate(Seguridadgrupo seguridadgrupo) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadgrupo.class);
		if (UtilesCommons.noEsVacio(seguridadgrupo.getDescripcion()) && UtilesCommons.noEsVacio(seguridadgrupo.getGrupo())){
			criteria.add(Restrictions.eq("grupo", seguridadgrupo.getGrupo()));
			criteria.add(Restrictions.eq("descripcion", seguridadgrupo.getDescripcion()));
		}

		return (List<Seguridadgrupo>)criteria.list();
	}
}
