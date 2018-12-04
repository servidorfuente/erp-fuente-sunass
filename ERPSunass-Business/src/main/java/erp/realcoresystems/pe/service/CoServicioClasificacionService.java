package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.CoServicioClasificacion;

public interface CoServicioClasificacionService {
	public List<CoServicioClasificacion> listar(CoServicioClasificacion clasificacion);
	public int guardar(CoServicioClasificacion clasificacion);
	public int actualizar(CoServicioClasificacion clasificacion);
	public int contarTotal(CoServicioClasificacion clasificacion);
	public CoServicioClasificacion buscarPorId(String servicioclasificacion);
}
