package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaFeriadoDao;
import erp.realcoresystems.pe.model.domain.SaFeriado;
import erp.realcoresystems.pe.service.SaFeriadoService;
import erp.realcoresystems.pe.util.Log;

@Service("saFeriadoService")
@Transactional(readOnly = true)
public class SaFeriadoServiceImpl implements SaFeriadoService {

	private SaFeriadoDao saFeriadodao;

	@Autowired
	public void setSaFeriadodao(SaFeriadoDao saFeriadodao) {
		this.saFeriadodao = saFeriadodao;
	}

	@Override
	public SaFeriado obtenerPorID(Integer id) {
		try {
			return saFeriadodao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaFeriado> listar(SaFeriado objDao, boolean paginable) {
		try {
			return saFeriadodao.listar(objDao, paginable);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public int contarTotal(SaFeriado objDao) {
		try {
			return saFeriadodao.contarTotal(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SaFeriado objDao) {
		try {
			if (UtilesCommons.esVacio(objDao.getFdoferiodoid())) {
				int nextId = saFeriadodao.obtenerMaxId() + 1;
				objDao.setFdoferiodoid(nextId);
			}
			return saFeriadodao.guardar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaFeriado objDao) {
		try {
			return saFeriadodao.actualizar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SaFeriado objDao) {
		try {
			int idSec = saFeriadodao.eliminar(objDao);
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}
