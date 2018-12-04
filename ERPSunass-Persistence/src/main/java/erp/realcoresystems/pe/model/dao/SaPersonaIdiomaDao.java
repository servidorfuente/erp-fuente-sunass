package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaIdioma;
import erp.realcoresystems.pe.model.domain.SaPersonaIdiomaPK;

public interface SaPersonaIdiomaDao {
	public SaPersonaIdioma obtenerPorID(SaPersonaIdiomaPK id);
	public List<SaPersonaIdioma> listarElementos(SaPersonaIdioma objDao);	
	public List<SaPersonaIdioma> listarElementosPag(SaPersonaIdioma objDao);
	
	public long guardar(SaPersonaIdioma objDao);	
	public int eliminar(SaPersonaIdioma objDao);
	public int actualizar(SaPersonaIdioma objDao);			
	
	public int contadorlistarElementos(SaPersonaIdioma objDao);
}
