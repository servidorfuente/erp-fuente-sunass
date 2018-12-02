package erp.realcoresystems.pe.service;

import java.util.List;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;

public interface SySeguridadAutorizacionService {

	public int guardarSeguridadAutorizaciones(List<SySeguridadautorizaciones> listadoSySeguridad,
                                              SySeguridadautorizaciones sySeguridadautorizaciones);
	public List<SySeguridadautorizaciones> listadoSySeguridadPorGrupo(SySeguridadautorizaciones sySeguridadautorizaciones);
}
