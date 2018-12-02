package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.commons.model.PaginaModel;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;

public interface SyAutorizacionSeguridadDao extends AbstractDao<SySeguridadautorizaciones, String>{

	public int guardarSeguridadAutorizaciones(List<SySeguridadautorizaciones> listadoSySeguridad);
	public int eliminarSeguridadAutorizaciones(SySeguridadautorizaciones sySeguridadautorizaciones);
	public List<SySeguridadautorizaciones> listadoSySeguridad(SySeguridadautorizaciones sySeguridadautorizaciones);

	public PaginaModel<SySeguridadautorizaciones> listarPaginado(SySeguridadautorizaciones filtro);
	public List<SySeguridadautorizaciones> listar(SySeguridadautorizaciones filtro);
	public int contar(SySeguridadautorizaciones filtro);

	public int guardar(SySeguridadautorizaciones objDao);
	public int actualizar(SySeguridadautorizaciones objDao);
	public int eliminar(SySeguridadautorizaciones objDao);

}
