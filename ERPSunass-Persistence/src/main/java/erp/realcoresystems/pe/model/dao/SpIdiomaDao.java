package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SpIdioma;



public interface SpIdiomaDao {
	public SpIdioma obtenerPorID(Long id);
	public List<SpIdioma> listarElementos(SpIdioma objDao);	
	public List<SpIdioma> listarElementosPag(SpIdioma objDao);
	
	public long guardar(SpIdioma objDao);	
	public int eliminar(SpIdioma objDao);
	public int actualizar(SpIdioma objDao);			
	
	public int contadorlistarElementos(SpIdioma objDao);
}
