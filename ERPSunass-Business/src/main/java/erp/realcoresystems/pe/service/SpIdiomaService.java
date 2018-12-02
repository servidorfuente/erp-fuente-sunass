package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SpIdioma;

public interface SpIdiomaService {
	public SpIdioma obtenerPorID(Long id);
	public List<SpIdioma> listarElementos(SpIdioma objDao);	
	public List<SpIdioma> listarElementosPag(SpIdioma objDao);
	
	public long guardar(SpIdioma objDao);	
	public int eliminar(SpIdioma objDao);
	public int actualizar(SpIdioma objDao);			
	
	public int contadorlistarElementos(SpIdioma objDao);
	public boolean verificarDuplicidad(SpIdioma registro);

}
