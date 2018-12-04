package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SaCompendioDetalle;
import java.util.List;

public interface SaCompendioDetalleDao extends AbstractDao<SaCompendioDetalle, String>  {

	public SaCompendioDetalle obtenerPorId(int nidecompendio, int nidedetalle);
	public List<SaCompendioDetalle> listar(SaCompendioDetalle saCompendioDetalle);
	public int guardar(SaCompendioDetalle saCompendioDetalle);
	public int actualizar(SaCompendioDetalle saCompendioDetalle);
	public int contarTotal(SaCompendioDetalle saCompendioDetalle);
	public List<SaCompendioDetalle> listarCombo(int compendioId);

}
