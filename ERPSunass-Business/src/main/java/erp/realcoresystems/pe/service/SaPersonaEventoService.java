package erp.realcoresystems.pe.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import erp.realcoresystems.pe.model.domain.SaPersonaEvento;
import erp.realcoresystems.pe.model.domain.SaPersonaEventoPK;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaEvento;

public interface SaPersonaEventoService {
	public  SaPersonaEvento obtenerPorID(SaPersonaEventoPK id);
	public List<SaPersonaEvento> listarElementos(SaPersonaEvento objDao);	
	public List<SaPersonaEvento> listarElementosPag(SaPersonaEvento filtro);
	
	public List<VwPersonaEvento> listarVwElementosPag(VwPersonaEvento filtro);
	
	public long guardar(SaPersonaEvento objDao);	
	
	public long guardarMasivo(List<VwPersonaEvento> listaDao);
	
	public int eliminar(SaPersonaEvento objDao);
	public int actualizar(SaPersonaEvento objDao);	
	
	public int contarElementos(SaPersonaEvento objDao);
	public int contarVwElementos(VwPersonaEvento objDao);
	

}
