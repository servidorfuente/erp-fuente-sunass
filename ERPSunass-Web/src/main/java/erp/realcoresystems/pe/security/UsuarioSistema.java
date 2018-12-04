package erp.realcoresystems.pe.security;

import erp.realcoresystems.pe.model.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

public class UsuarioSistema extends User{

	private static final long serialVersionUID = 1L;
	private Usuario login;

	public UsuarioSistema(Usuario login, Collection<? extends GrantedAuthority> authorities) {
		super(login.getUsuario(), login.getClave(), authorities);
		this.login = login;
	}

	public Usuario getLogin() {
		return login;
	}

	public void setLogin(Usuario login) {
		this.login = login;
	}




}
