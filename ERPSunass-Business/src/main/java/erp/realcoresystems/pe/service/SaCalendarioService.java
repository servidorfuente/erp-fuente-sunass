package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaCalendario;
import erp.realcoresystems.pe.model.domain.vista.VwCalendario;

public interface SaCalendarioService {
	
	/** Metodo para buscar u obtener **/
	public SaCalendario obtenerPorID(Integer id);
	public SaCalendario obtenerPorCodigoCalendario(String codigoelemento, SaCalendario objDao);
	
	/** Metodo para listar **/
	public List<VwCalendario> listar(VwCalendario objDao, boolean paginable);	
	public int contarTotal(VwCalendario objDao);
	
	
	/** Metodo transaccionales **/	
	public int guardar(SaCalendario objDao);
	public int actualizar(SaCalendario objDao);
	public int eliminar(SaCalendario objDao);
	
	 
}
