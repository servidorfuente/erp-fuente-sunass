package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaExperiencia;
import erp.realcoresystems.pe.model.domain.SaPersonaExperienciaPK;




public interface SaPersonaExperienciaDao {
	public SaPersonaExperiencia obtenerPorID(SaPersonaExperienciaPK id);
	public List<SaPersonaExperiencia> listarElementos(SaPersonaExperiencia objDao);	
	public List<SaPersonaExperiencia> listarElementosPag(SaPersonaExperiencia filtro);
	
	public long guardar(SaPersonaExperiencia objDao);	
	public int eliminar(SaPersonaExperiencia objDao);
	public int actualizar(SaPersonaExperiencia objDao);	
	
	public int contarElementos(SaPersonaExperiencia objDao);
	
}
