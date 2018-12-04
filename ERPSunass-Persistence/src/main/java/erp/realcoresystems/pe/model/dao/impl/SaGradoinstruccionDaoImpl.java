package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaGradoinstruccionDao;
import erp.realcoresystems.pe.model.domain.SaGradoinstruccion;
import erp.realcoresystems.pe.model.util.Utiles;

@Repository
public class SaGradoinstruccionDaoImpl extends AbstractDaoImpl<SaGradoinstruccion, Integer>
		implements SaGradoinstruccionDao {

	protected SaGradoinstruccionDaoImpl() {
		super(SaGradoinstruccion.class);

	}

	@Override
	public SaGradoinstruccion obtenerPorID(Integer id) {
		Object resull = findById(id);
		return resull != null ? (SaGradoinstruccion) resull : null;
	}

	@Override
	public List<SaGradoinstruccion> listarElementos(SaGradoinstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaGradoinstruccion.class);
		if (objDao.getGradoinstruccion() != null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
		}
		if (objDao.getEstado() != null && !(objDao.getEstado() + "").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if (objDao.getDescripcion() != null && !(objDao.getDescripcion() + "").isEmpty()) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}
		return criteria.list();
	}

	@Override
	public List<SaGradoinstruccion> listarElementosPag(SaGradoinstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaGradoinstruccion.class);
		if (objDao.getGradoinstruccion() != null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
		}
		if (objDao.getEstado() != null && !(objDao.getEstado() + "").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if (objDao.getDescripcion() != null && !(objDao.getDescripcion() + "").isEmpty()) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());
		return criteria.list();
	}

	@Override
	public long guardar(SaGradoinstruccion objDao) {
		/* Obtener MAX insertado **/
		if (objDao.getGradoinstruccion() == null) {
			Criteria criteria = getCurrentSession().createCriteria(SaGradoinstruccion.class);
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("gradoinstruccion"));
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();

			// GENERAR EL ID
			Integer valorMax = 0;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			objDao.setGradoinstruccion(valorMax + 1);
		}
		saveOrUpdate(objDao);
		return objDao.getGradoinstruccion();
	}

	@Override
	public int eliminar(SaGradoinstruccion objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaGradoinstruccion objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorlistarElementos(SaGradoinstruccion objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaGradoinstruccion.class);
		if (objDao.getGradoinstruccion() != null) {
			criteria.add(Restrictions.eq("gradoinstruccion", objDao.getGradoinstruccion()));
		}
		if (objDao.getEstado() != null && !(objDao.getEstado() + "").isEmpty()) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if (objDao.getDescripcion() != null && !(objDao.getDescripcion() + "").isEmpty()) {
			criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

}
