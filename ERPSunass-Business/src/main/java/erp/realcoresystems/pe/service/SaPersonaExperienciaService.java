package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaExperiencia;
import erp.realcoresystems.pe.model.domain.SaPersonaExperienciaPK;

public interface SaPersonaExperienciaService {
	public SaPersonaExperiencia obtenerPorID(SaPersonaExperienciaPK id);
	public List<SaPersonaExperiencia> listarElementos(SaPersonaExperiencia objDao);	
	public List<SaPersonaExperiencia> listarElementosPag(SaPersonaExperiencia filtro);
	
	public long guardar(SaPersonaExperiencia objDao);	
	public long guardarMasivo(List<SaPersonaExperiencia> listaDao);
	public int eliminar(SaPersonaExperiencia objDao);
	public int actualizar(SaPersonaExperiencia objDao);	
	
	public int contarElementos(SaPersonaExperiencia objDao);
}
