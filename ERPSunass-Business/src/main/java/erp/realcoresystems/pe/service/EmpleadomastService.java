package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.SaDependencias;
import erp.realcoresystems.pe.model.domain.vista.VwEmpleado;

import java.util.List;

public interface EmpleadomastService {
	// Load
	public Empleadomast obtenerPorId(int empleadoId);
	// List
	public List<Empleadomast> listar(Empleadomast empleado);
	// Save / Update
	public int guardar(Empleadomast empleado);

	public int actualizar(Empleadomast empleado);
	// Delete
	public int eliminar(Empleadomast empleado);
	// Count
	public int contarTotal(Empleadomast empleado);
	// List
	
	public List<Empleadomast> obtenerPorDependencia(SaDependencias dependencia);
	
	public List<VwEmpleado> listar(VwEmpleado filtro, boolean paginable);
	
	public List<VwEmpleado> listarParaEnviarTramite(VwEmpleado filtro, boolean paginable);
}
