package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.ParametrosMastPK;
import java.util.List;
import java.util.Map;

import erp.realcoresystems.pe.model.domain.ParametrosMast;

public interface ParametrosMastService {

	public ParametrosMast buscarPorID(ParametrosMastPK id);
	
	public List<ParametrosMast> listarPorPag(ParametrosMast filter);
	
	public int contarPorPag(ParametrosMast filter);
	
	public void registrarNuevoParametro(ParametrosMast parametrosMast);
	
	public void modificarParametro(ParametrosMast parametrosMast);
	
	public void eliminarParametroLogicamente(ParametrosMast parametrosMast);
	
	public Map<String, String> listarParametroPorNegocio(String appCodigo, String companiaCodigo);

	
	
	public int guardar(ParametrosMast objSave); 
	public int actualizar(ParametrosMast objSave); 
	public int eliminar(ParametrosMast objSave); 
}
