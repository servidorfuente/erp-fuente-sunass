package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablas;
import erp.realcoresystems.pe.model.domain.SaTablasauditoria;



public interface SaTablasauditoriaDao {
	public SaTablasauditoria obtenerPorID(SaTablasauditoria objDao);
	public List<SaTablasauditoria> listarElementos(SaTablasauditoria objDao);
	public List<SaTablasauditoria> listarElementosPag(SaTablasauditoria objDao);	
	public int guardar(SaTablasauditoria objDao);
	public int eliminar(SaTablasauditoria objDao);
	public int actualizar(SaTablasauditoria objDao);
	public int contadorTotaleslistarElementos(SaTablasauditoria objDao);
	
}
