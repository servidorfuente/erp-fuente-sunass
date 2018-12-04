package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;

public interface SaPersonaRelacionesService {

	public SaPersonaRelaciones obtenerPorId(Long id);
	public List<SaPersonaRelaciones> listarElementos(SaPersonaRelaciones objDao, boolean paginable);
	public int contarElementos(SaPersonaRelaciones objDao);
	
	public long guardar(SaPersonaRelaciones objDao);		
	public int actualizar(SaPersonaRelaciones objDao);
	public int eliminar(SaPersonaRelaciones objDao);
}
