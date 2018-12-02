package erp.realcoresystems.pe.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.ParametrosMastDao;
import erp.realcoresystems.pe.model.domain.ParametrosMast;
import erp.realcoresystems.pe.model.domain.ParametrosMastPK;
import erp.realcoresystems.pe.service.ParametrosMastService;
import erp.realcoresystems.pe.util.Log;

@Service("parametrosMastService")
@Transactional(readOnly = true)
public class ParametrosMastServiceImpl implements ParametrosMastService {

	@Autowired
	private ParametrosMastDao parametrosDao;

	@Override
	public ParametrosMast buscarPorID(ParametrosMastPK id) {
		try {
			return parametrosDao.buscarPorID(id);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<ParametrosMast> listarPorPag(ParametrosMast filter) {
		try {
			return parametrosDao.listarPorPag(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

	@Override
	public int contarPorPag(ParametrosMast filter) {
		try {
			return parametrosDao.contadorPag(filter);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public int guardar(ParametrosMast objSave){
		try {
			return parametrosDao.guardar(objSave);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public int actualizar(ParametrosMast objSave){
		try {
			return parametrosDao.actualizar(objSave);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public int eliminar(ParametrosMast objSave){
		try {
			return parametrosDao.eliminar(objSave);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void registrarNuevoParametro(ParametrosMast parametrosMast) {
		// parametrosDao.save(parametrosMast);
		try {
			parametrosDao.registrarParametro(parametrosMast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void modificarParametro(ParametrosMast parametrosMast) {
		try {
			parametrosDao.actualizarParametro(parametrosMast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void eliminarParametroLogicamente(ParametrosMast parametrosMast) {
		try {
			parametrosDao.actualizarParametro(parametrosMast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
	}

	@Override
	public Map<String, String> listarParametroPorNegocio(String appCodigo, String companiaCodigo) {
		try {
			return parametrosDao.listarParametroPorNegocio(appCodigo, companiaCodigo);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

}
