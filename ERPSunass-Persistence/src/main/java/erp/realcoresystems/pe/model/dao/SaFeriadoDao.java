package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaFeriado;

public interface SaFeriadoDao {

	/** Metodo para buscar u obtener **/
	public SaFeriado obtenerPorID(Integer id);
	public int obtenerMaxId();
	  
	/** Metodo para listar **/
	public List<SaFeriado> listar(SaFeriado objDao, boolean paginable);
	public int contarTotal(SaFeriado objDao);
		
	/** Metodo transaccionales **/	
	public int guardar(SaFeriado objDao);	
	public int eliminar(SaFeriado objDao);
	public int actualizar(SaFeriado objDao);
}
