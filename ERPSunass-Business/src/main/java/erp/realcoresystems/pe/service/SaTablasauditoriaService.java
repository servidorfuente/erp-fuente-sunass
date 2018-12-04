package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablas;
import erp.realcoresystems.pe.model.domain.SaTablasauditoria;


public interface SaTablasauditoriaService {
	
	public SaTablasauditoria obtenerPorID(SaTablasauditoria objService);
	public List<SaTablasauditoria> listarElementos(SaTablasauditoria objService);
	public List<SaTablasauditoria> listarElementosPag(SaTablasauditoria objDao);
	public int guardar(SaTablasauditoria objService);
	public int eliminar(SaTablasauditoria objService);
	public int actualizar(SaTablasauditoria objService);
	public int guardarMasivo(List<SaTablasauditoria> listaService);
	public int contadorTotaleslistarElementos(SaTablasauditoria objService);
	public List<SaTablas> listarElementos_SaTablas(SaTablasauditoria objDao);
}
