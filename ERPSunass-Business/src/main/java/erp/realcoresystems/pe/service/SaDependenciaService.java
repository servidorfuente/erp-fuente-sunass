package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaDependencias;

public interface SaDependenciaService {

	// Load
	public SaDependencias obtenerPorID(int nidedep);

	// List
	public List<SaDependencias> listar(SaDependencias SaDependencias);

	// List Dependencias
	public List<SaDependencias> listarDetalles(SaDependencias SaDependencias);

	// Save / Update
	public int guardar(SaDependencias SaDependencias);

	public int guardar(List<SaDependencias> SaDependencias);

	// Delete
	public int eliminar(SaDependencias SaDependencias);

	// Count
	public int contador(SaDependencias SaDependencias);

}
