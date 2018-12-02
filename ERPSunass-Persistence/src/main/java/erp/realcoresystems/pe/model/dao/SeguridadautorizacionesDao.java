package erp.realcoresystems.pe.model.dao;

import java.util.List;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;


public interface SeguridadautorizacionesDao   extends AbstractDao<Seguridadautorizaciones, String>{
	
	public Seguridadautorizaciones obtenerPorID(Seguridadautorizaciones objDao);
	public List<Seguridadautorizaciones> listarElementos(Seguridadautorizaciones objDao);
	public int guardar(Seguridadautorizaciones objDao);
	public int actualizar(Seguridadautorizaciones objDao);
	public int eliminar(Seguridadautorizaciones objDao);
	
	public int contadorTotaleslistarElementos(Seguridadautorizaciones objDao);
}
