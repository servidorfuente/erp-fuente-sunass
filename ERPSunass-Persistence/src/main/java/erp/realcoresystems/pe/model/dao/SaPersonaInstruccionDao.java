package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaInstruccion;
import erp.realcoresystems.pe.model.domain.SaPersonaInstruccionPK;

public interface SaPersonaInstruccionDao {
	public SaPersonaInstruccion obtenerPorID(SaPersonaInstruccionPK id);
	public List<SaPersonaInstruccion> listarElementos(SaPersonaInstruccion objDao);	
	public List<SaPersonaInstruccion> listarElementosPag(SaPersonaInstruccion objDao);
	
	public long guardar(SaPersonaInstruccion objDao);	
	public int eliminar(SaPersonaInstruccion objDao);
	public int actualizar(SaPersonaInstruccion objDao);			
	
	public int contadorlistarElementos(SaPersonaInstruccion objDao);
}
