package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipoaula;

public interface SaTipoaulaDao extends AbstractDao<SaTipoaula, String> {
	
	
	// validate
	public List<SaTipoaula> validate(SaTipoaula saTipoclase);
	
	// Load
	public SaTipoaula obtenerPorID(SaTipoaula saTipoclase);

	// List
	public List<SaTipoaula> listar(SaTipoaula saTipoclase);
	
	// List
	public List<SaTipoaula> listarCombo(SaTipoaula saTipoclase);

	// Save / Update
	public int guardar(SaTipoaula saTipoclase);

	// Delete
	public int eliminar(SaTipoaula saTipoclase);

	// Count
	public int contador(SaTipoaula saTipoclase);
	
	public List<SaTipoaula> listarTodos(SaTipoaula saTipoclase);
}
