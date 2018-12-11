package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SsControlperiodo;
import erp.realcoresystems.pe.model.domain.SsPeriodoformulario;
import erp.realcoresystems.pe.model.domain.SsPeriodoformulariodetalle;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import erp.realcoresystems.pe.model.domain.vista.VwSsperiodoformulario;

import java.util.List;

public interface SsControlperiodoService {
    public SsControlperiodo buscar(SsControlperiodo filtro);
    public List<SsControlperiodo> listar(SsControlperiodo filtro, boolean pagina);
    public List<VwControlperiodo> listarVista(VwControlperiodo filtroRegistro, boolean pagina);
    public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo objDao, boolean pagina);
    public int registrarVista(List<VwControlperiodo> filtroRegistro,  VwControlperiodo filtro, boolean pagina);
    public int guardar(SsControlperiodo objDao);
    public int actualizar(SsControlperiodo objDao);
    public int eliminar(SsControlperiodo objDao);
    public int contar(SsControlperiodo filtro);
    public int contarVista(VwControlperiodo filtro);
    public int contarVistaGrupo(VwControlperiodo filtro);

}
