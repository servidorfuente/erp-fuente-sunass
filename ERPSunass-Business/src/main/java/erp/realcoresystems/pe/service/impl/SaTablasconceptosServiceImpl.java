package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaTablasconceptosDao;
import erp.realcoresystems.pe.model.domain.SaTablasconceptos;
import erp.realcoresystems.pe.service.SaTablasconceptosService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saTablasconceptosService")
@Transactional(readOnly = true)
public class SaTablasconceptosServiceImpl implements SaTablasconceptosService {

	@Autowired
	private SaTablasconceptosDao saTablasconceptosDao;

	@Override
	public SaTablasconceptos obtenerPorID(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.obtenerPorID(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaTablasconceptos> listarElementos(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.listarElementos(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public int guardar(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.guardar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.actualizar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.eliminar(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablasconceptos objService) {
		try {
			return saTablasconceptosDao.contadorTotaleslistarElementos(objService);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional
	public int guardarMasivo(List<SaTablasconceptos> listaService) {
		try {
			int result = 1;
			for (SaTablasconceptos objService : listaService) {
				if (Constant.DELETE_db.equals(objService.getAccion())) {
					result = saTablasconceptosDao.eliminar(objService);
				} else {
					result = saTablasconceptosDao.guardar(objService);
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
