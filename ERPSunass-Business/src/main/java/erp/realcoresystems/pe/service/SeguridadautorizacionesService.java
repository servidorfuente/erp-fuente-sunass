package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;

public interface SeguridadautorizacionesService {
	public Seguridadautorizaciones obtenerPorID(Seguridadautorizaciones objDao);
	public List<Seguridadautorizaciones> listarElementos(Seguridadautorizaciones objDao);
	public int guardar(Seguridadautorizaciones objDao);
	
	public int guardarMasivo(List<Seguridadautorizaciones> listaDao);
	
	public int eliminar(Seguridadautorizaciones objDao);
	
	public int contadorTotaleslistarElementos(Seguridadautorizaciones objDao);
	
	public List<Vistaconceptoautoriza> listarPermisosUsuario(Vistaconceptoautoriza objDao);
}
