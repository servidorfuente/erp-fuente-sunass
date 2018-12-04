package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SeguridadauditoriaDao;
import erp.realcoresystems.pe.model.domain.SaAuditoria;
import erp.realcoresystems.pe.model.domain.VwAuditoriageneral;
import erp.realcoresystems.pe.service.SeguridadauditoriaService;
import erp.realcoresystems.pe.util.Log;

@Service("seguridadauditoriaService")
@Transactional(readOnly = true)
public class SeguridadauditoriaServiceImpl implements SeguridadauditoriaService {

	@Autowired
	private SeguridadauditoriaDao seguridadauditoriaDao;

	@Override
	public SaAuditoria obtenerPorID(SaAuditoria objDao) {
		try {
			return seguridadauditoriaDao.obtenerPorID(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwAuditoriageneral> listarElementos(VwAuditoriageneral objDao) {
		try {
			return seguridadauditoriaDao.listarElementos(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public int guardar(SaAuditoria objDao) {
		try {
			return seguridadauditoriaDao.guardar(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaAuditoria objDao) {
		try {
			return seguridadauditoriaDao.eliminar(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorTotaleslistarElementos(VwAuditoriageneral objDao) {
		try {
			return seguridadauditoriaDao.contadorTotaleslistarElementos(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

}
