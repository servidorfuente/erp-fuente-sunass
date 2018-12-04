package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SaDependencias;

import java.util.List;

public interface SaDependenciasDao extends AbstractDao<SaDependencias, String> {
	// Load
	public SaDependencias obtenerPorID(int nidedep);

	// List
	public List<SaDependencias> listar(SaDependencias SaDependencias);

	// List Dependencias
	public List<SaDependencias> listarDetalles(SaDependencias SaDependencias);

	// Save / Update
	public int guardar(SaDependencias SaDependencias);

	// Delete
	public int eliminar(SaDependencias SaDependencias);

	// Count
	public int contador(SaDependencias SaDependencias);
}
