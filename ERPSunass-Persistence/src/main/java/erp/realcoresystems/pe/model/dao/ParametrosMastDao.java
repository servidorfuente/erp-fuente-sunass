package erp.realcoresystems.pe.model.dao;

import java.util.List;
import java.util.Map;
import erp.realcoresystems.pe.model.domain.ParametrosMast;
import erp.realcoresystems.pe.model.domain.ParametrosMastPK;

public interface ParametrosMastDao extends AbstractDao<ParametrosMast, ParametrosMastPK> {
	
	public ParametrosMast buscarPorID(ParametrosMastPK id);
	
	public List<ParametrosMast> listarPorPag(ParametrosMast filter);

	public int contadorPag(ParametrosMast filter);
	
	public void registrarParametro(ParametrosMast parametrosMast);
	
	public void actualizarParametro(ParametrosMast parametrosMast);
	
	public Map<String, String> listarParametroPorNegocio(String appCodigo, String companiaCodigo);

	public int guardar(ParametrosMast objSave);
	public int actualizar(ParametrosMast objSave);
	public int eliminar(ParametrosMast objSave); 
}
