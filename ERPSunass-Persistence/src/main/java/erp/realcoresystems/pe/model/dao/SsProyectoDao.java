package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SsProyecto;

import java.util.List;

public interface SsProyectoDao extends AbstractDao<SsProyecto, String>{
	public SsProyecto buscar(SsProyecto filtro);
	public List<SsProyecto> listar(SsProyecto filtro, boolean pagina);
	public int contar(SsProyecto filtro);
	public int guardar(SsProyecto objDao);
	public int actualizar(SsProyecto objDao);
	public int eliminar(SsProyecto objDao);
}

