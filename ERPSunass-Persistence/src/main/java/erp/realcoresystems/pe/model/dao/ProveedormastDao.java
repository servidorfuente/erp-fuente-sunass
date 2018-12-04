package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Proveedormast;

public interface ProveedormastDao extends AbstractDao<Proveedormast, Long> {

	public Proveedormast obtenerPorID(Proveedormast proveedormast);

	// Load
	public List<Proveedormast> validate(Proveedormast proveedormast);

	// List
	public List<Proveedormast> listar(Proveedormast proveedormast);

	// List
	public List<Proveedormast> listarCombo(Proveedormast proveedormast);

	// Save / Update
	public int guardar(Proveedormast proveedormast);

	// Delete
	public int eliminar(Proveedormast proveedormast);

	// Count
	public int contador(Proveedormast proveedormast);
	
	public int actualizar(Proveedormast proveedormast);
}
