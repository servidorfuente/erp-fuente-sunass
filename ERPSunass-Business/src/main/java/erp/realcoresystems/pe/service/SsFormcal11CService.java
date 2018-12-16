package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SsFormcal11C;

import java.util.List;

public interface SsFormcal11CService {
    public SsFormcal11C buscar(SsFormcal11C filtro);
    public List<SsFormcal11C> listar(SsFormcal11C filtro, boolean pagina);
    public int contar(SsFormcal11C filtro);
    public int guardar(SsFormcal11C objDao);
    public int actualizar(SsFormcal11C objDao);
    public int eliminar(SsFormcal11C objDao);
}
