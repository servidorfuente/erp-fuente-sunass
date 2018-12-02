package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaUnegocio;

public interface SaUnegocioDao extends AbstractDao<SaUnegocio, Integer>{
	
	
	public SaUnegocio obtenerPorId(Integer id);

	public List<SaUnegocio> listarUNegocio(SaUnegocio saUnegocio) throws Exception;
	public List<SaUnegocio> listarTodos(SaUnegocio filtro, boolean paginable);
	public List<SaUnegocio> listar(SaUnegocio filtro, boolean paginable);
	public int contarElementos(SaUnegocio objDao);	
	public int actualizar(SaUnegocio objDao);
	public int eliminar(SaUnegocio objDao);
	public int guardar(SaUnegocio saUnegocio);
	public List<SaUnegocio> validate(SaUnegocio saUnegocio);
}
