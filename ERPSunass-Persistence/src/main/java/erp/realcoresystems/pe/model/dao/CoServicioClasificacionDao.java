package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.CoServicioClasificacion;

public interface CoServicioClasificacionDao extends AbstractDao<CoServicioClasificacion, String>{
	public List<CoServicioClasificacion> listar(CoServicioClasificacion clasificacion);
	public int guardar(CoServicioClasificacion clasificacion);
	public int actualizar(CoServicioClasificacion clasificacion);
	public int contarTotal(CoServicioClasificacion clasificacion);
	public CoServicioClasificacion buscarPorId(String servicioclasificacion);
	public CoServicioClasificacion buscarPorId(Integer servicioclasificacionid);
	public List<CoServicioClasificacion> buscarPorCodigo(String codigoServicio);
	public int obtenerMaximoId();
}
