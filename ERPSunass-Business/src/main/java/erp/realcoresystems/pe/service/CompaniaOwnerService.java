package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Companyowner;

public interface CompaniaOwnerService {

	public Companyowner obtenerPorId(String companyowner);
	public List<Companyowner> listarCompanias(Companyowner companyowner);
	public List<Companyowner> listarCompaniasPorAutorizacion(Companyowner companyowner);

	public List<Companyowner> listarSeguridad(Companyowner filtro,String usuario);
	public List<Companyowner> listarSeguridadAutozacionCompania(Companyowner filtro,String usuario);

}
