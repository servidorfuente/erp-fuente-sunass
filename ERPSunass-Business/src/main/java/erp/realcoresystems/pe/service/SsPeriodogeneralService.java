package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;

import java.util.List;

public interface SsPeriodogeneralService {
    public SsPeriodogeneral buscar(SsPeriodogeneral filtro);
    public List<SsPeriodogeneral> listar(SsPeriodogeneral filtro, boolean pagina);
    public List<VwControlperiodo> listarVista(VwControlperiodo filtroRegistro, boolean pagina);
    public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo objDao, boolean pagina);
    public int registrarVista(List<VwControlperiodo> filtroRegistro, VwControlperiodo filtro, boolean pagina);
    public int guardar(SsPeriodogeneral objDao);
    public int actualizar(SsPeriodogeneral objDao);
    public int eliminar(SsPeriodogeneral objDao);
    public int contar(SsPeriodogeneral filtro);
    public int contarVista(VwControlperiodo filtro);
    public int contarVistaGrupo(VwControlperiodo filtro);

}
