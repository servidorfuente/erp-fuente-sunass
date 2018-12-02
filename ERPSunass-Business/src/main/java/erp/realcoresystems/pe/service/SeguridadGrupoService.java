package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadgrupo;

public interface SeguridadGrupoService {

	public Seguridadgrupo obtenerPorId(Integer id);
	public List<Seguridadgrupo> listar(Seguridadgrupo seguridadgrupo);
	public int contarTotal(Seguridadgrupo seguridadgrupo);
	public List<Seguridadgrupo> listarCombo(Seguridadgrupo saTipopProcReglamentoId);
	public int guardar(Seguridadgrupo seguridadgrupo);
	public int eliminar(Seguridadgrupo seguridadgrupo);
	public int actualizar(Seguridadgrupo seguridadgrupo);
	
	
	public List<Seguridadgrupo> listarTodos(Seguridadgrupo seguridadgrupo, Boolean paginable);
	public int contarTodos(Seguridadgrupo seguridadgrupo);
	public List<Seguridadgrupo> validate(Seguridadgrupo seguridadgrupo);

	
}
