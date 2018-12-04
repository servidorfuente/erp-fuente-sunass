package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaPersonaCurso;
import erp.realcoresystems.pe.model.domain.SaPersonaCursoPK;

public interface SaPersonaCursoService {
	public  SaPersonaCurso obtenerPorID(SaPersonaCursoPK id);
	public List<SaPersonaCurso> listarElementos(SaPersonaCurso objDao);	
	public List<SaPersonaCurso> listarElementosPag(SaPersonaCurso filtro);
	
	public long guardar(SaPersonaCurso objDao);	
	public int eliminar(SaPersonaCurso objDao);
	public int actualizar(SaPersonaCurso objDao);	
	public long guardar(List<SaPersonaCurso> listaDao);
	
	public int contarElementos(SaPersonaCurso objDao);
}
