package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.commons.model.PaginaModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.SyAutorizacionSeguridadDao;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;

@Repository
public class SySeguridadAutorizacionDaoImpl extends AbstractDaoImpl<SySeguridadautorizaciones, String> implements SyAutorizacionSeguridadDao {

	protected SySeguridadAutorizacionDaoImpl() {
		super(SySeguridadautorizaciones.class);
	}

	@Override
	public int guardarSeguridadAutorizaciones(List<SySeguridadautorizaciones> listadoSySeguridad) {
		for(SySeguridadautorizaciones bean: listadoSySeguridad){
			saveOrUpdate(bean);	
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SySeguridadautorizaciones> listadoSySeguridad(SySeguridadautorizaciones seguridadautorizaciones) {
		Criteria criteria = getCurrentSession().createCriteria(SySeguridadautorizaciones.class);
		if (seguridadautorizaciones.getAplicacioncodigo()!=null && !"".equals(seguridadautorizaciones.getAplicacioncodigo())) {
			criteria.add(Restrictions.like("aplicacioncodigo", seguridadautorizaciones.getAplicacioncodigo()));
		}
		if (seguridadautorizaciones.getUsuario()!=null && !"".equals(seguridadautorizaciones.getUsuario())) {
			criteria.add(Restrictions.like("usuario", seguridadautorizaciones.getUsuario()));
		}
		if (seguridadautorizaciones.getGrupo()!=null && !"".equals(seguridadautorizaciones.getGrupo())) {
			criteria.add(Restrictions.like("grupo", seguridadautorizaciones.getGrupo()));
		}
		if (seguridadautorizaciones.getEstado()!=null && !"".equals(seguridadautorizaciones.getEstado())) {
			criteria.add(Restrictions.eq("estado", seguridadautorizaciones.getEstado()).ignoreCase());
		}
		return (List<SySeguridadautorizaciones>) criteria.list();
	}

	@Override
	public int eliminarSeguridadAutorizaciones(SySeguridadautorizaciones sySeguridadautorizaciones) {
		String query = "update SySeguridadautorizaciones set estado = 'E' "
				+ "where aplicacioncodigo =:aplicacioncodigo "
				+ "and usuario =:usuario";
		return 	getCurrentSession().createQuery(query)
				.setString("aplicacioncodigo",sySeguridadautorizaciones.getAplicacioncodigo())
				.setString("usuario", sySeguridadautorizaciones.getUsuario()) 
				.executeUpdate();
	}
	@Override
	public PaginaModel<SySeguridadautorizaciones> listarPaginado(SySeguridadautorizaciones filtro) {
		Criteria criteria = createCriteria();
		filtro.setPaginable(true);
		setPaginable(filtro, criteria);

		if(!UtilesCommons.esVacio(filtro.getAplicacioncodigo())){
			criteria.add(Restrictions.eq("aplicacionCodigo",filtro.getAplicacioncodigo()));
		}
		if(!UtilesCommons.esVacio(filtro.getGrupo())){
			criteria.add(Restrictions.eq("grupo",filtro.getGrupo()));
		}
		if(!UtilesCommons.esVacio(filtro.getConcepto())){
			criteria.add(Restrictions.eq("concepto",filtro.getConcepto()));
		}
		if(!UtilesCommons.esVacio(filtro.getUsuario())){
			criteria.add(Restrictions.eq("usuario",filtro.getUsuario()));
		}
		if(!UtilesCommons.esVacio(filtro.getEstado())){
			criteria.add(Restrictions.eq("estado",filtro.getEstado()));
		}

		return PaginaModel.crearPagina(criteria.list(), contar(filtro));
	}

	@Override
	public List<SySeguridadautorizaciones> listar(SySeguridadautorizaciones filtro) {
		Criteria criteria = createCriteria();

		if(!UtilesCommons.esVacio(filtro.getAplicacioncodigo())){
			criteria.add(Restrictions.eq("aplicacioncodigo",filtro.getAplicacioncodigo()));
		}
		if(!UtilesCommons.esVacio(filtro.getGrupo())){
			criteria.add(Restrictions.eq("grupo",filtro.getGrupo()));
		}
		if(!UtilesCommons.esVacio(filtro.getConcepto())){
			criteria.add(Restrictions.eq("concepto",filtro.getConcepto()));
		}
		if(!UtilesCommons.esVacio(filtro.getUsuario())){
			criteria.add(Restrictions.eq("usuario",filtro.getUsuario()));
		}
		if(!UtilesCommons.esVacio(filtro.getEstado())){
			criteria.add(Restrictions.eq("estado",filtro.getEstado()));
		}
		return criteria.list();
	}

	@Override
	public int contar(SySeguridadautorizaciones filtro) {
		Criteria criteria = createCriteria();
		if(!UtilesCommons.esVacio(filtro.getAplicacioncodigo())){
			criteria.add(Restrictions.eq("aplicacionCodigo",filtro.getAplicacioncodigo()));
		}
		if(!UtilesCommons.esVacio(filtro.getGrupo())){
			criteria.add(Restrictions.eq("grupo",filtro.getGrupo()));
		}
		if(!UtilesCommons.esVacio(filtro.getConcepto())){
			criteria.add(Restrictions.eq("concepto",filtro.getConcepto()));
		}
		if(!UtilesCommons.esVacio(filtro.getUsuario())){
			criteria.add(Restrictions.eq("usuario",filtro.getUsuario()));
		}
		if(!UtilesCommons.esVacio(filtro.getEstado())){
			criteria.add(Restrictions.eq("estado",filtro.getEstado()));
		}

		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}

	@Override
	public int guardar(SySeguridadautorizaciones objDao) {
		save(objDao);
		return 1;
	}

	@Override
	public int actualizar(SySeguridadautorizaciones objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(SySeguridadautorizaciones objDao) {
		delete(objDao);
		return 1;
	}



}
