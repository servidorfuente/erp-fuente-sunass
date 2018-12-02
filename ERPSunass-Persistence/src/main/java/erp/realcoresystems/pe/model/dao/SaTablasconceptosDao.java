package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablasconceptos;


public interface SaTablasconceptosDao {
	public SaTablasconceptos obtenerPorID(SaTablasconceptos objDao);
	public List<SaTablasconceptos> listarElementos(SaTablasconceptos objDao);
	public int guardar(SaTablasconceptos objDao);
	public int eliminar(SaTablasconceptos objDao);
	public int actualizar(SaTablasconceptos objDao);
	public int contadorTotaleslistarElementos(SaTablasconceptos objDao);
}
