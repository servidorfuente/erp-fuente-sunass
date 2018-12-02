package erp.realcoresystems.pe.model.dao;

 

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipofalta;

public interface SaTipofaltaDao extends AbstractDao<SaTipofalta, Integer>  {
	// Load
	public SaTipofalta obtenerPorID(Integer id);
	// List
	public List<SaTipofalta> listar(SaTipofalta saTipofalta,boolean paginable);
	// Save / Update
	public int guardar(SaTipofalta saTipofalta);
	// Delete
	public int eliminar(SaTipofalta saTipofalta);
	// Count
	public int contador(SaTipofalta saTipofalta);
}
