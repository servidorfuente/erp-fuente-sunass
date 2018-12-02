package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.SaDependencias;
import erp.realcoresystems.pe.model.domain.vista.VwEmpleado;

import java.util.List;

public interface EmpleadomastDao extends AbstractDao<Empleadomast, Integer>  {
	// Load
	public Empleadomast obtenerPorId(int empleadoId);
	// List
	public List<Empleadomast> listar(Empleadomast empleadomast);
	// Save / Update
	public int guardar(Empleadomast empleadomast);

	public int actualizar(Empleadomast empleadomast);
	// Delete
	public int eliminar(Empleadomast empleadomast);
	// Count
	public int contador(Empleadomast empleadomast);
	// List
	
	public List<Empleadomast> obtenerPorDependencia(SaDependencias dependencia);

	public List<VwEmpleado> listar(VwEmpleado filtro, boolean paginable);
}
