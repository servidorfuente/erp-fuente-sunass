package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.dao.AbstractDao;
import erp.realcoresystems.pe.model.domain.SsProyecto;

import java.util.List;

 public interface SsProyectoService {
	public SsProyecto buscar(SsProyecto filtro);
	public List<SsProyecto> listar(SsProyecto filtro, boolean pagina);
	public int contar(SsProyecto filtro);
	public int guardar(SsProyecto objDao);
	public int actualizar(SsProyecto objDao);
	public int eliminar(SsProyecto objDao);
}

