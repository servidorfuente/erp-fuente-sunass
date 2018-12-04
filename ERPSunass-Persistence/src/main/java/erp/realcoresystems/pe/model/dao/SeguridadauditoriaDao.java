package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaAuditoria;
import erp.realcoresystems.pe.model.domain.VwAuditoriageneral;

public interface SeguridadauditoriaDao  extends AbstractDao<SaAuditoria, String>  {
	
	public SaAuditoria obtenerPorID(SaAuditoria objDao);
	public List<VwAuditoriageneral> listarElementos(VwAuditoriageneral objDao);
	public int guardar(SaAuditoria objDao);
	public int eliminar(SaAuditoria objDao);
	
	public int contadorTotaleslistarElementos(VwAuditoriageneral objUsuario);
}
