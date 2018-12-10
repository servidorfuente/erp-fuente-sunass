package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.dao.AbstractDao;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.SsCargainicialPK;
import erp.realcoresystems.pe.model.domain.vista.VwCargainicial;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;

import java.util.List;

public interface SsCargainicialService  {
	public SsCargainicial buscar(SsCargainicial filtro);
	public SsCargainicial verificar(SsCargainicial filtro);
	public List<SsCargainicial> listar(SsCargainicial filtro, boolean pagina);
	public int contar(SsCargainicial filtro);
	public int guardar(SsCargainicial objDao);
	public int guardarMasivo(List<VwControlperiodo> filtroRegistro, VwControlperiodo filtro, SsCargainicial objDao);
	public int actualizar(SsCargainicial objDao);
	public int eliminar(SsCargainicial objDao);
	public List<VwCargainicial> listarVista(VwCargainicial vista, SsCargainicial entidad, boolean pagina);
	public int contarVista(VwCargainicial filtro);
}

