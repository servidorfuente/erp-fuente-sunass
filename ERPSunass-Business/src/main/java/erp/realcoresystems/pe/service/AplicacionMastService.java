package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Aplicacionesmast;

public interface AplicacionMastService {

	public List<Aplicacionesmast> listarPorEstado(String estado);
	
	public Aplicacionesmast buscarPorID(String id);
	public List<Aplicacionesmast> listarTodos(Aplicacionesmast objDao);
}
