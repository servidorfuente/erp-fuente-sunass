package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaCalendario;
import erp.realcoresystems.pe.model.domain.vista.VwCalendario;

public interface SaCalendarioDao {

	/** Metodo para buscar u obtener **/
	public SaCalendario obtenerPorCodigoCalendario(String codigo, SaCalendario calendario);
	public SaCalendario obtenerPorID(Integer id);
	public int obtenerMaxId();
	  
	/** Metodo para listar **/
	public List<VwCalendario> listar(VwCalendario objDao, boolean paginable);
	public int contarTotal(VwCalendario objDao);
		
	/** Metodo transaccionales **/	
	public int guardar(SaCalendario objDao);	
	public int eliminar(SaCalendario objDao);
	public int actualizar(SaCalendario objDao);
		
	 
}
