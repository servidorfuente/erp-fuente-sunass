package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SsFormcal11CDao;
import erp.realcoresystems.pe.model.domain.SsFormcal11C;
import erp.realcoresystems.pe.service.SsFormcal11CService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssFormcal11CService")
@Transactional(readOnly = true)
public class SsFormcal11CServiceImpl extends AbstractServiceImpl implements SsFormcal11CService {
	@Autowired
	private SsFormcal11CDao ssFormcom01ADao;

	@Override
	public SsFormcal11C buscar(SsFormcal11C filtro) {
		try {
			return ssFormcom01ADao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsCargainicialServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SsFormcal11C> listar(SsFormcal11C filtro, boolean pagina) {
		try {
			return ssFormcom01ADao.listar(filtro, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public int contar(SsFormcal11C filtro) {
		return ssFormcom01ADao.contar(filtro);
	}

	@Override
	@Transactional
	public int guardar(SsFormcal11C objDao) {
		try {
			return ssFormcom01ADao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional
	public int actualizar(SsFormcal11C objDao) {
		try {
			return ssFormcom01ADao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public int eliminar(SsFormcal11C objDao) {
		try {
			return ssFormcom01ADao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}
}
