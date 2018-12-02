package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Aplicacionesmast;

public interface AplicacionMastDao extends AbstractDao<Aplicacionesmast, String> {

	public Aplicacionesmast buscarPorID(String id);
	
	public List<Aplicacionesmast> listarPorEstado(String estado);
	
	public List<Aplicacionesmast> listarTodos(Aplicacionesmast objDao);
}
