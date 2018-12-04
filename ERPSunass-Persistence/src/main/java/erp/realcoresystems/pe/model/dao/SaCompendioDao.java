package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SaCompendio;

import java.util.List;

public interface SaCompendioDao extends AbstractDao<SaCompendio, String>  {
	// Load
	public SaCompendio obtenerEntidad(SaCompendio saCompendio);
	// List
	public List<SaCompendio> listar(SaCompendio saCompendio);
	// Save / Update
	public int guardar(SaCompendio saCompendio);

	public int actualizar(SaCompendio saCompendio);
	// Delete
	public int contarTotal(SaCompendio saCompendio);
	// List

}
