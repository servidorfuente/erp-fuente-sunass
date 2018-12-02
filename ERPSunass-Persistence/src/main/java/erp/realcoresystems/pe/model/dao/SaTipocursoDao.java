package erp.realcoresystems.pe.model.dao;

 

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipocurso;

public interface SaTipocursoDao extends AbstractDao<SaTipocurso, String>  {
	// Load
	public SaTipocurso obtenerPorID(SaTipocurso saTipocurso);
	// List
	public List<SaTipocurso> listar(SaTipocurso saTipocurso);
	
	// Count
	public int contador(SaTipocurso saTipocurso);
		
	// Listar Combo
	public List<SaTipocurso> listarCombo(SaTipocurso saTipocurso);

	public int guardar(SaTipocurso saTipocurso);
	public int actualizar(SaTipocurso saTipocurso);
	public int eliminar(SaTipocurso saTipocurso);
	
	public List<SaTipocurso> listar(SaTipocurso saTipocurso, boolean paginable);
	
	
}
