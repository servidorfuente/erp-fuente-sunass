package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadautorizacioncompania;


public interface SeguridadAutorizacionCompaniaDao {

	public Seguridadautorizacioncompania obtenerPorId(Seguridadautorizacioncompania primaryKey);
	public List<Seguridadautorizacioncompania> listarElementos(Seguridadautorizacioncompania objDao,
															   boolean paginable);
	public int contarTotal(Seguridadautorizacioncompania objDao);
	
	public int guardar(Seguridadautorizacioncompania objDao);
	public int actualizar(Seguridadautorizacioncompania objDao);
	public int eliminar(Seguridadautorizacioncompania objDao);

}
