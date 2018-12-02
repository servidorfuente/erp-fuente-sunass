package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipoclase;

public interface SaTipoclaseDao extends AbstractDao<SaTipoclase, String> {

	
	// Validate
	public List<SaTipoclase> validate(SaTipoclase saTipoclase);

	// Load
	public SaTipoclase obtenerPorID(SaTipoclase saTipoclase);

	// List
	public List<SaTipoclase> listar(SaTipoclase saTipoclase);

	// Save / Update
	public int guardar(SaTipoclase saTipoclase);

	// Delete
	public int eliminar(SaTipoclase saTipoclase);

	// Count
	public int contador(SaTipoclase saTipoclase);
	
	public List<SaTipoclase> listarTodos(SaTipoclase saTipoclase);
}
