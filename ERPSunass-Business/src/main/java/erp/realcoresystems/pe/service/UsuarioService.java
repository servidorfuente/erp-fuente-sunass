package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;
import java.util.List;
import java.util.Map;

public interface UsuarioService {

	public Usuario obtenerPorId(String primaryKey);
	
	public Usuario ValidarUsuario(Usuario objUsuario);

	public Usuario validarLogin(String usurio, String clave);
	
	
	public List<Usuario> UsuarioPerfilListar(Usuario usuario);

	public List<Usuario> UsuarioListar(Usuario usuario);

	public Usuario UsuarioBuscar(Usuario usuario);

	public List<Usuario> listarPaginacionUsuario(Usuario objUsuario);

	public int contadorTotalesUsuario(Usuario objUsuario);

	public int guardarUsuario(Usuario objUsuario);
	
	public int guardarUsuarioGeneral(Usuario objUsuario, boolean flagLR);

	public int eliminarUsuario(Usuario objUsuario);

	public Usuario obtenerUsuarioID(Usuario objUsuario);

	public List<Usuario> listarPaginacionSeleccionadorUsuario(Usuario objUsuario);

	public int contadorTotalesSeleccionadorUsuario(Usuario objUsuario);

	public List<Usuario> listarComboUsuarioSupervisor(Usuario objUsuario);

	public List<VwUsuarioseguridad> listarVwUsuarioseguridad(Usuario usuario);

	public Map<String, String> obtenerUsuarioCreacionModificacion(Integer creacion, Integer modificacion);

	public int actualizar(Usuario objSave);

	
}
