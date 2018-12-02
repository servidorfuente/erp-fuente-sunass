package erp.realcoresystems.pe.model.dao;

import java.util.List;
import erp.realcoresystems.pe.model.domain.SaDepartamento;
import erp.realcoresystems.pe.model.domain.SaProvincia;
import erp.realcoresystems.pe.model.domain.SaUbigeo;
import erp.realcoresystems.pe.model.domain.SaZonaPostal;

public interface SaUbigeoDao extends AbstractDao<SaUbigeo, String>{

	public SaUbigeo obtenerUbigeoPorId(int id);
	public SaUbigeo obtenerPorCodigo(String ubigeo);
	public List<SaUbigeo> listar(SaUbigeo objeto);
	
	public List<SaDepartamento> listarDepartamento(String codigoPais);
	public List<SaProvincia> listarProvinciaPorDepartamento(String codigoPais, String codigoDepartamento);
	public List<SaZonaPostal> listarDistritoPorProvincia(String codigoPais, String codigoDepartamento, String codigoProvincia);
	
	public List<SaUbigeo> listarComboDepartamento(String codigoPais);
	public List<SaUbigeo> listarComboProvincia(String codigoPais, String codigoDepartamento);
	public List<SaUbigeo> listarComboDistrito(String codigoPais, String codigoDepartamento, String codigoProvincia);
	
	public List<String> listarComboDepartamentos(SaUbigeo ubigeo);
	public List<String> listarComboProvincias(SaUbigeo ubigeo);
	public List<String> listarComboDistritos(SaUbigeo ubigeo);
	
	public SaUbigeo localizarDepProvDis(SaUbigeo ubigeo);
}
