package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaTablasDao;
import erp.realcoresystems.pe.model.domain.SaTablas;
import erp.realcoresystems.pe.service.SaTablasService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saTablasService")
@Transactional(readOnly = true)
public class SaTablasServiceImpl implements SaTablasService {

	@Autowired
	private SaTablasDao SaTablasDao;

	@Override
	public SaTablas obtenerPorID(SaTablas objService) {
		try {
			return SaTablasDao.obtenerPorID(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaTablas> listarElementos(SaTablas objService) {
		try {
			return SaTablasDao.listarElementos(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public int guardar(SaTablas objService) {
		try {
			return SaTablasDao.guardar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaTablas objService) {
		try {
			return SaTablasDao.actualizar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaTablas objService) {
		try {
			return SaTablasDao.eliminar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablas objService) {
		try {
			return SaTablasDao.contadorTotaleslistarElementos(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional
	public int guardarMasivo(List<SaTablas> listaService) {
		try {
			int result = 1;
			for (SaTablas objService : listaService) {
				if (Constant.DELETE_db.equals(objService.getAccion())) {
					result = SaTablasDao.eliminar(objService);
				} else {
					result = SaTablasDao.guardar(objService);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}
