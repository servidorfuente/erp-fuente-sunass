package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SsControlperiodo;

import java.util.List;

public interface SsControlperiodoDao extends AbstractDao<SsControlperiodo, String>{
	public SsControlperiodo buscar(SsControlperiodo filtro);
	public List<SsControlperiodo> listar(SsControlperiodo filtro, boolean pagina);
	public int guardar(SsControlperiodo objDao);
	public int actualizar(SsControlperiodo objDao);
	public int eliminar(SsControlperiodo objDao);
	public int contar(SsControlperiodo filtro);

}
