package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablasconceptos;


public interface SaTablasconceptosService {
	public SaTablasconceptos obtenerPorID(SaTablasconceptos objService);
	public List<SaTablasconceptos> listarElementos(SaTablasconceptos objService);
		
	public int guardar(SaTablasconceptos objService);
	public int eliminar(SaTablasconceptos objService);
	public int actualizar(SaTablasconceptos objService);
	
	public int guardarMasivo(List<SaTablasconceptos> listaService);
	
	public int contadorTotaleslistarElementos(SaTablasconceptos objService);
}
