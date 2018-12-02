package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;

public interface SeguridadPerfilUsuarioDao extends AbstractDao<Seguridadperfilusuario, String> {
	public List<Seguridadperfilusuario> SeguridadperfilusuarioListar(Seguridadperfilusuario seguridadAutorizaciones);

	public Seguridadperfilusuario SeguridadGrupoBuscar(Seguridadperfilusuario objPersonaMast);

	public void guardar(Seguridadperfilusuario seguridadperfilusuario);

	public void eliminar(Seguridadperfilusuario seguridadperfilusuario);

	public void actualizar(Seguridadperfilusuario seguridadperfilusuario);
	
	public List<Seguridadperfilusuario> obtenerTodosPerfiles(Seguridadperfilusuario perfilUsuario);
}
