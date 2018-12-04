package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.AcCostCenterMstDao;
import erp.realcoresystems.pe.model.domain.AcCostCenterMst;
import erp.realcoresystems.pe.service.AcCostCenterMstService;
import erp.realcoresystems.pe.util.Log;

@Service("acCostCenterMstService")
@Transactional(readOnly = true)
public class AcCostCenterMstServiceImpl implements AcCostCenterMstService {

	private AcCostCenterMstDao acCostCenterMstDao;

	@Autowired
	public void setAcCostCenterMstdao(AcCostCenterMstDao acCostCenterMstDao) {
		this.acCostCenterMstDao = acCostCenterMstDao;
	}

	@Override
	public AcCostCenterMst obtenerPorID(String id) {
		try {
			return acCostCenterMstDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}


	@Override
	public List<AcCostCenterMst> listar(AcCostCenterMst objDao, boolean paginable) {
		try {
			return acCostCenterMstDao.listar(objDao, paginable);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public int contar(AcCostCenterMst objDao) {
		try {
			return acCostCenterMstDao.contar(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(AcCostCenterMst objDao) {
		try {			
			return acCostCenterMstDao.guardar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(AcCostCenterMst objDao) {
		try {
			return acCostCenterMstDao.actualizar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(AcCostCenterMst objDao) {
		try {
			int idSec = acCostCenterMstDao.eliminar(objDao);
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}
