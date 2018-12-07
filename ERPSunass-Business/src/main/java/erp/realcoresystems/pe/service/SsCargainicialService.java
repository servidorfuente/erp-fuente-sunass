package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.dao.AbstractDao;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.SsCargainicialPK;

import java.util.List;

public interface SsCargainicialService  {
	public SsCargainicial buscar(SsCargainicial filtro);
	public List<SsCargainicial> listar(SsCargainicial filtro, boolean pagina);
	public int contar(SsCargainicial filtro);
	public int guardar(SsCargainicial objDao);
	public int actualizar(SsCargainicial objDao);
	public int eliminar(SsCargainicial objDao);
}
