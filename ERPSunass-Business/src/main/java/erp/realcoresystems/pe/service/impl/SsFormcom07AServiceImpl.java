package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SsFormcom07ADao;
import erp.realcoresystems.pe.model.domain.SsFormcom07A;
import erp.realcoresystems.pe.service.SsFormcom07AService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssFormcom07AService")
@Transactional(readOnly = true)
public class SsFormcom07AServiceImpl extends AbstractServiceImpl implements SsFormcom07AService {

    @Autowired
    private SsFormcom07ADao ssFormcom07ADao;

    @Override
    public SsFormcom07A buscar(SsFormcom07A objSsFormcom07A) {
        try {
            return ssFormcom07ADao.buscar(objSsFormcom07A);
        } catch (Exception e) {
            Log.error(e,"SsCargainicialServiceImpl : buscar : ");
            return null;
        }
    }

    @Override
    public List<SsFormcom07A> listar(SsFormcom07A objSsFormcom07A, boolean pagina) {
        try {
            return ssFormcom07ADao.listar(objSsFormcom07A, pagina);
        } catch (Exception e) {
            e.printStackTrace();
            Log.logger.error(Log.getStackTrace(e));
        }
        return null;
    }

    @Override
    public int contar(SsFormcom07A objSsFormcom07A) {
        return ssFormcom07ADao.contar(objSsFormcom07A);
    }

    @Override
    @Transactional
    public int guardar(SsFormcom07A objSsFormcom07A) {
        try {
            return ssFormcom07ADao.guardar(objSsFormcom07A);
        } catch (Exception ex) {
            rollback(ex);
            Log.logger.error(Log.getStackTrace(ex));
        }
        return 1;
    }

    @Override
    @Transactional
    public int actualizar(SsFormcom07A objSsFormcom07A) {
        try {
            return ssFormcom07ADao.actualizar(objSsFormcom07A);
        } catch (Exception ex) {
            rollback(ex);
            Log.logger.error(Log.getStackTrace(ex));
        }
        return 1;
    }

    @Override
    @Transactional
    public int eliminar(SsFormcom07A objSsFormcom07A) {
        try {
            return ssFormcom07ADao.eliminar(objSsFormcom07A);
        } catch (Exception ex) {
            rollback(ex);
            Log.logger.error(Log.getStackTrace(ex));
        }
        return 1;
    }
}
