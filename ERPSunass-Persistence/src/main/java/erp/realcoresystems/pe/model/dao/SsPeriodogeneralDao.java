package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;

import java.util.List;

public interface SsPeriodogeneralDao extends AbstractDao<SsPeriodogeneral, String>{
	public SsPeriodogeneral buscar(SsPeriodogeneral filtro);
	public List<SsPeriodogeneral> listar(SsPeriodogeneral filtro, boolean pagina);
	public List<VwControlperiodo> listarVista(VwControlperiodo filtro, boolean pagina);
	public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo filtro, boolean pagina);
	public int guardar(SsPeriodogeneral objDao);
	public int actualizar(SsPeriodogeneral objDao);
	public int eliminar(SsPeriodogeneral objDao);
	public int contar(SsPeriodogeneral filtro);
	public int contarVista(VwControlperiodo filtro);
	public int contarVistaGrupo(VwControlperiodo filtro);
}
