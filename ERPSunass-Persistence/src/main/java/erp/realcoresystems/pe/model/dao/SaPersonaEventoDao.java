package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaEvento;
import erp.realcoresystems.pe.model.domain.SaPersonaEventoPK;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaEvento;



public interface SaPersonaEventoDao {
	public  SaPersonaEvento obtenerPorID(SaPersonaEventoPK id);
	public List<SaPersonaEvento> listarElementos(SaPersonaEvento objDao);	
	public List<SaPersonaEvento> listarElementosPag(SaPersonaEvento filtro);
	
	public List<VwPersonaEvento> listarVwElementosPag(VwPersonaEvento filtro);
	
	public long guardar(SaPersonaEvento objDao);	
	public int eliminar(SaPersonaEvento objDao);
	public int actualizar(SaPersonaEvento objDao);	
	
	public int contarElementos(SaPersonaEvento objDao);
	public int contarVwElementos(VwPersonaEvento objDao);
}
