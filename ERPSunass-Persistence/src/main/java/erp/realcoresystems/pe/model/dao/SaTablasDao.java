package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablas;



public interface SaTablasDao {
	public SaTablas obtenerPorID(SaTablas objDao);
	public List<SaTablas> listarElementos(SaTablas objDao);
	public List<SaTablas> listarElementosPag(SaTablas objDao);
	
	public int guardar(SaTablas objDao);
	public int eliminar(SaTablas objDao);
	public int actualizar(SaTablas objDao);
	public int contadorTotaleslistarElementos(SaTablas objDao);
}
