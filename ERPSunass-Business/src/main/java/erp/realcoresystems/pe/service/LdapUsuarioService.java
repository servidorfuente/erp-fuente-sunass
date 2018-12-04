package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;

import java.util.List;

public interface LdapUsuarioService {
	public Usuario ValidarUsuarioLdap(Usuario usuario);
	public Usuario UsuarioBuscarLdap(Usuario usuario)  ;
	public List<Usuario> listarPaginacionUsuarioLdap(Usuario objUsuario);
}
