package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaGradoinstruccion;

public interface SaGradoinstruccionService {
	public SaGradoinstruccion obtenerPorID(Integer id);
	public List<SaGradoinstruccion> listarElementos(SaGradoinstruccion objDao);	
	public List<SaGradoinstruccion> listarElementosPag(SaGradoinstruccion objDao);	
	public long guardar(SaGradoinstruccion objDao);	
	public int eliminar(SaGradoinstruccion objDao);
	public int actualizar(SaGradoinstruccion objDao);	
		
	public int contadorlistarElementos(SaGradoinstruccion objDao);
}
