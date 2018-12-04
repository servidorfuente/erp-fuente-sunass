package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.dao.AbstractDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;

import java.util.List;

public interface SaTipofuenteService {
	public SaTipofuente buscar(SaTipofuente filtro);
	public List<SaTipofuente> listar(SaTipofuente filtro, boolean pagina);
	public int contar(SaTipofuente filtro);
	public int guardar(SaTipofuente objDao);
	public int actualizar(SaTipofuente objDao);
	public int eliminar(SaTipofuente objDao);
}

