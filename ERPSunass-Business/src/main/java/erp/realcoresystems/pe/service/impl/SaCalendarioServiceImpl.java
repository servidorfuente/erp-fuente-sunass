package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaCalendarioDao;
import erp.realcoresystems.pe.model.domain.SaCalendario;
import erp.realcoresystems.pe.model.domain.vista.VwCalendario;
import erp.realcoresystems.pe.service.SaCalendarioService;
import erp.realcoresystems.pe.util.Log;

@Service("saCalendarioService")
@Transactional(readOnly = true)
public class SaCalendarioServiceImpl implements SaCalendarioService {

	private SaCalendarioDao saCalendariodao;

	@Autowired
	public void setSaCalendariodao(SaCalendarioDao saCalendariodao) {
		this.saCalendariodao = saCalendariodao;
	}

	@Override
	public SaCalendario obtenerPorID(Integer id) {
		try {
			return saCalendariodao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public SaCalendario obtenerPorCodigoCalendario(String codigoelemento, SaCalendario calendario) {
		try {
			return saCalendariodao.obtenerPorCodigoCalendario(codigoelemento, calendario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwCalendario> listar(VwCalendario objDao, boolean paginable) {
		try {
			return saCalendariodao.listar(objDao, paginable);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public int contarTotal(VwCalendario objDao) {
		try {
			return saCalendariodao.contarTotal(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SaCalendario objDao) {
		try {
			if (UtilesCommons.esVacio(objDao.getCalcalendarioid())) {
				int nextId = saCalendariodao.obtenerMaxId() + 1;
				objDao.setCalcalendarioid(nextId);
			}
			return saCalendariodao.guardar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaCalendario objDao) {
		try {
			return saCalendariodao.actualizar(objDao);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SaCalendario objDao) {
		try {
			int idSec = saCalendariodao.eliminar(objDao);
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}
