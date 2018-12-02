package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadAutorizacionCompaniaDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizacioncompania;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class SeguridadAutorizacionCompaniaDaoImpl extends AbstractDaoImpl<Seguridadautorizacioncompania, String>
implements SeguridadAutorizacionCompaniaDao {

	protected SeguridadAutorizacionCompaniaDaoImpl() {
		super(Seguridadautorizacioncompania.class);
	}

	@Override
	public Seguridadautorizacioncompania obtenerPorId(Seguridadautorizacioncompania primaryKey) {
		return   null; // findById(primaryKey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seguridadautorizacioncompania> listarElementos(Seguridadautorizacioncompania objDao,
			boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadautorizacioncompania.class);
		filtrarCritera(criteria, objDao);
		if(paginable){
			objDao.setPaginable(paginable);
			setPaginable(objDao, criteria);
		}
		setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
		return criteria.list();
	}

	@Override
	public int contarTotal(Seguridadautorizacioncompania objDao) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadautorizacioncompania.class);
		filtrarCritera(criteria, objDao);
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

	@Override
	public int guardar(Seguridadautorizacioncompania objDao) {
		save(objDao);
		return 1;
	}

	@Override
	public int actualizar(Seguridadautorizacioncompania objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(Seguridadautorizacioncompania objDao) {
		delete(objDao);
		return 1;
	}

	/** Metodo general para todo tipo de Filtrado de la Dao Impl
	 * @param criteria
	 * @param objFiltro
	 */
	public void filtrarCritera(Criteria criteria, Object objFiltro){
		if(objFiltro instanceof Seguridadautorizacioncompania){
			Seguridadautorizacioncompania  filtro = (Seguridadautorizacioncompania)objFiltro;
			if ( UtilesCommons.noEsVacio(filtro.getUsuario())) {
				criteria.add(Restrictions.eq("usuario", filtro.getUsuario()));
			}
			if ( UtilesCommons.noEsVacio(filtro.getCompanyowner())) {			
				criteria.add(Restrictions.eq("companyowner", filtro.getCompanyowner()));
			}
			if ( UtilesCommons.noEsVacio(filtro.getEstado())) {
				criteria.add(Restrictions.eq("estado", filtro.getEstado()));
			}
		}else{
			
		}
	}
	
	
	
}
