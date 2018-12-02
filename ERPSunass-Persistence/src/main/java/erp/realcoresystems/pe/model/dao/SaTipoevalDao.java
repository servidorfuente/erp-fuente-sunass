package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipoeval;

public interface SaTipoevalDao extends AbstractDao<SaTipoeval, String> {
	// Load
	public SaTipoeval obtenerPorID(SaTipoeval saTipoeval);
	
	public SaTipoeval obtenerPorPrefijo(String prefijo);

	// List
	public List<SaTipoeval> listar(SaTipoeval saTipoeval);

	// List Combo
	public List<SaTipoeval> listarCombo(SaTipoeval saTipoeval);

	// validate
	public List<SaTipoeval> validate(SaTipoeval saTipoeval);

	// Save / Update
	public int guardar(SaTipoeval saTipoeval);
	public int actualizar(SaTipoeval saTipoeval);
	
	// Delete
	public int eliminar(SaTipoeval saTipoeval);

	// Count
	public int contador(SaTipoeval saTipoeval);

	
}
