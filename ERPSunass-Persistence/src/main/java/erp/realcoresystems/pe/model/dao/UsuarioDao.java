package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;

import java.util.List;
import java.util.Map;

public interface UsuarioDao extends AbstractDao<Usuario, String> {

	public Usuario ValidarUsuario(Usuario usuario);

	public List<Usuario> UsuarioPerfilListar(Usuario usuario);

	public List<Usuario> UsuarioListar(Usuario usuario);

	public Usuario UsuarioBuscar(Usuario usuario);

	public List<Usuario> listarPaginacionUsuario(Usuario objUsuario);

	public int contadorTotalesUsuario(Usuario objUsuario);
	
	public int guardarUsuario(Usuario objUsuario);
	
	public int eliminarUsuario(Usuario objUsuario);
	
	public Usuario obtenerUsuarioID(Usuario objUsuario);
	
	public List<Usuario> listarPaginacionSeleccionadorUsuario(Usuario objUsuario);
	
	public int contadorTotalesSeleccionadorUsuario(Usuario objUsuario);
	
	public List<Usuario> listarComboUsuarioSupervisor(Usuario objUsuario);
	
	public List<VwUsuarioseguridad> listarVwUsuarioseguridad(Usuario objUsuario);
	
	public Map<String, String> obtenerUsuarioCreacionModificacion(Integer creacion, Integer modificacion);

	public int actualizar(Usuario objUsuario);
}
