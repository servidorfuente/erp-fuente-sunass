package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablas;


public interface SaTablasService {
	public SaTablas obtenerPorID(SaTablas objService);
	public List<SaTablas> listarElementos(SaTablas objService);
		
	public int guardar(SaTablas objService);
	public int eliminar(SaTablas objService);
	public int actualizar(SaTablas objService);
	
	public int guardarMasivo(List<SaTablas> listaService);
	
	public int contadorTotaleslistarElementos(SaTablas objService);
}
