package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SsControlperiodo;
import erp.realcoresystems.pe.model.domain.SsPeriodoformulario;
import erp.realcoresystems.pe.model.domain.SsPeriodoformulariodetalle;
import erp.realcoresystems.pe.model.domain.vista.VwSsperiodoformulario;

import java.util.List;

public interface SsControlperiodoService {
    public SsPeriodoformulario buscarCab(SsPeriodoformulario filtro);

    public SsPeriodoformulariodetalle buscar(SsPeriodoformulariodetalle filtro);

    public List<SsPeriodoformulariodetalle> listar(SsPeriodoformulariodetalle filtro, boolean pagina);
    public int contar(SsPeriodoformulariodetalle filtro);

    public List<VwSsperiodoformulario> listarVista(VwSsperiodoformulario filtro, boolean pagina);
    public int contar(VwSsperiodoformulario filtro);

    public int guardarCab(SsPeriodoformulario objDao);
    public int actualizarCab(SsPeriodoformulario objDao);
    public int eliminarCab(SsPeriodoformulario objDao);


    public int guardar(SsPeriodoformulariodetalle objDao);
    public int actualizar(SsPeriodoformulariodetalle objDao);
    public int eliminar(SsPeriodoformulariodetalle objDao);

}
