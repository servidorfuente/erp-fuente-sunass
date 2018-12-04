package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.CompaniaMast;

public interface CompaniaMastService {
	
	public CompaniaMast buscarPorID(String id);
	public List<CompaniaMast> companiaListar(CompaniaMast companiamast);
	public List<CompaniaMast> companiaListarPorAutorizacion(CompaniaMast companiamast);
}
