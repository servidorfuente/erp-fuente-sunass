package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.SsFormcom07A;

import java.util.List;

public interface SsFormcom07AService {

    SsFormcom07A buscar(SsFormcom07A objSsFormcom07A);

    List<SsFormcom07A> listar(SsFormcom07A objSsFormcom07A, boolean pagina);

    int contar(SsFormcom07A objSsFormcom07A);

    int guardar(SsFormcom07A objSsFormcom07A);

    int actualizar(SsFormcom07A objSsFormcom07A);

    int eliminar(SsFormcom07A objSsFormcom07A);
}
