package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaProfesionDao;
import erp.realcoresystems.pe.model.domain.SaProfesion;
import erp.realcoresystems.pe.service.SaProfesionService;
import erp.realcoresystems.pe.util.Log;


@Service("saProfesionService")
@Transactional(readOnly = true)
public class SaProfesionServiceImpl  implements SaProfesionService{

	@Autowired
	private SaProfesionDao saProfesionDao;
	
	@Override
	public SaProfesion obtenerPorID(Long id) {
		try {
			return saProfesionDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaProfesion> listarElementos(SaProfesion objDao) {
		try {
			return saProfesionDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaProfesion> listarElementosPag(SaProfesion objDao) {
		try {
			return saProfesionDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaProfesion objDao) {
		try {
			long idSec = saProfesionDao.guardar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaProfesion objDao) {
		try {
			int idSec = saProfesionDao.eliminar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaProfesion objDao) {
		try {
			int idSec = saProfesionDao.actualizar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorlistarElementos(SaProfesion objDao) {
		try {
			return saProfesionDao.contadorlistarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

}
