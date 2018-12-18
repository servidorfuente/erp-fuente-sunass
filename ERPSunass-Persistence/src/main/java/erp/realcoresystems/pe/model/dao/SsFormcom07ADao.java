package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.SsFormcom07A;
import erp.realcoresystems.pe.model.domain.SsFormcom07APK;

import java.util.List;

public interface SsFormcom07ADao extends AbstractDao<SsFormcom07A, SsFormcom07APK>{

    SsFormcom07A buscar(SsFormcom07A objSsFormcom07A);

    List<SsFormcom07A> listar(SsFormcom07A objSsFormcom07A, boolean pagina);

    int contar(SsFormcom07A objSsFormcom07A);

    int guardar(SsFormcom07A objSsFormcom07A);

    int actualizar(SsFormcom07A objSsFormcom07A);

    int eliminar(SsFormcom07A objSsFormcom07A);
}
