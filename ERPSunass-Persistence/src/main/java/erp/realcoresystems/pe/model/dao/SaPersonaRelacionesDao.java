package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;

public interface SaPersonaRelacionesDao extends AbstractDao<SaPersonaRelaciones,Long> {
	
	public List<SaPersonaRelaciones> listarElementos(SaPersonaRelaciones objDao,boolean paginable);		
	public int contarElementos(SaPersonaRelaciones objDao);
	
	public long guardar(SaPersonaRelaciones objDao);		
	public int actualizar(SaPersonaRelaciones objDao);
	public int eliminar(SaPersonaRelaciones objDao);
}
