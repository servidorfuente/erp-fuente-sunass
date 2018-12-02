package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SaCompendio;
import erp.realcoresystems.pe.model.domain.SaCompendioDetalle;

import java.util.List;

public interface SaCompendioService {

	public SaCompendio obtenerPorId(SaCompendio saCompendio);
	public List<SaCompendio> listar(SaCompendio saCompendio);
	public int guardar(SaCompendio saCompendio);
	public int actualizar(SaCompendio saCompendio);
	public int contarTotal(SaCompendio saCompendio);
	
	/** DETALLE **/
	public SaCompendioDetalle obtenerPorId(SaCompendioDetalle saCompendioDetalle);
	public List<SaCompendioDetalle> listar(SaCompendioDetalle saCompendiodetalle);
	public List<SaCompendioDetalle> listarCombo(int compendioId);
	public int guardar(SaCompendioDetalle saCompendiodetalle);
	public int actualizar(SaCompendioDetalle saCompendiodetalle);
	public int contarTotal(SaCompendioDetalle saCompendiodetalle);
}
