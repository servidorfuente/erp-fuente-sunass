package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaProfesion;

public interface SaProfesionService {
	public SaProfesion obtenerPorID(Long id);
	public List<SaProfesion> listarElementos(SaProfesion objDao);	
	public List<SaProfesion> listarElementosPag(SaProfesion objDao);
	
	public long guardar(SaProfesion objDao);	
	public int eliminar(SaProfesion objDao);
	public int actualizar(SaProfesion objDao);	
		
	public int contadorlistarElementos(SaProfesion objDao);
}
