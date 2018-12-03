package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaMiscelaneosdetalleDao;
import erp.realcoresystems.pe.model.dao.SaMiscelaneosHeaderDao;
import erp.realcoresystems.pe.model.dao.SsFormcom01ADao;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosheader;
import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.service.SaMiscelaneosHeaderService;
import erp.realcoresystems.pe.service.SsFormcom01AService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service("ssFormcom01AService")
@Transactional(readOnly = true)
public class SsFormcom01AServiceImpl extends AbstractServiceImpl implements SsFormcom01AService {

	private SsFormcom01ADao ssFormcom01ADao;

	@Override
	public SsFormcom01A buscar(SsFormcom01A filtro) {
		return null;
	}

	@Override
	public List<SsFormcom01A> listar(SsFormcom01A filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(SsFormcom01A filtro) {
		return 0;
	}

	@Override
	@Transactional
	public int guardar(SsFormcom01A objDao) {
		try {
			return ssFormcom01ADao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public int actualizar(SsFormcom01A objDao) {
		try {
			return ssFormcom01ADao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public int eliminar(SsFormcom01A objDao) {
		try {
			return ssFormcom01ADao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}
}
