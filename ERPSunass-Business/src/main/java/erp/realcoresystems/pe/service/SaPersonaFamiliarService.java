package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaFamiliar;
import erp.realcoresystems.pe.model.domain.SaPersonaFamiliarPK;

public interface SaPersonaFamiliarService {
	public  SaPersonaFamiliar obtenerPorID(SaPersonaFamiliarPK id);
	public List<SaPersonaFamiliar> listarElementos(SaPersonaFamiliar objDao);	
	public List<SaPersonaFamiliar> listarElementosPag(SaPersonaFamiliar filtro);
	
	public long guardar(SaPersonaFamiliar objDao);	
	public int eliminar(SaPersonaFamiliar objDao);
	public int actualizar(SaPersonaFamiliar objDao);	
	public long guardar(List<SaPersonaFamiliar> listaDao);
	
	public int contarElementos(SaPersonaFamiliar objDao);
}
