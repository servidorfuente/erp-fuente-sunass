package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaEventoprograma;

public interface SaEventoprogramaDao {
	public  SaEventoprograma obtenerPorID(Integer id);
	public List<SaEventoprograma> listarElementos(SaEventoprograma objDao);	
	public List<SaEventoprograma> listarElementosPag(SaEventoprograma filtro);
	
	
	public int guardar(SaEventoprograma objDao);	
	public int eliminar(SaEventoprograma objDao);
	public int actualizar(SaEventoprograma objDao);	
	
	public int contarElementos(SaEventoprograma objDao);	
}
