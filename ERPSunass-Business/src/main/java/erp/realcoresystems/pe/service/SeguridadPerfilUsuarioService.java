package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;

public interface SeguridadPerfilUsuarioService {

	public List<Seguridadperfilusuario> SeguridadPerfilLista(Seguridadperfilusuario seguridadAutorizaciones);

	public Seguridadperfilusuario SeguridadPerfilBuscar(Seguridadperfilusuario objPersonaMast);

	public int guardar(Seguridadperfilusuario seguridadperfilusuario);

	public int guardar(List<Seguridadperfilusuario> agregar);

}
