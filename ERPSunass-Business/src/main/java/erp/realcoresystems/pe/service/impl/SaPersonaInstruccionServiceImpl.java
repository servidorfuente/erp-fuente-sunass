package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import erp.realcoresystems.pe.model.dao.SaPersonaInstruccionDao;
import erp.realcoresystems.pe.model.domain.SaPersonaInstruccion;
import erp.realcoresystems.pe.model.domain.SaPersonaInstruccionPK;
import erp.realcoresystems.pe.service.SaPersonaInstruccionService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;


@Service("saPersonaInstruccionService")
@Transactional(readOnly = true)
public class SaPersonaInstruccionServiceImpl implements SaPersonaInstruccionService {

	
	@Autowired
	private SaPersonaInstruccionDao saPersonaInstruccionDao;
	
	@Override
	public SaPersonaInstruccion obtenerPorID(SaPersonaInstruccionPK id) {
		try {
			return saPersonaInstruccionDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaInstruccion> listarElementos(SaPersonaInstruccion objDao) {
		try {
			return saPersonaInstruccionDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaInstruccion> listarElementosPag(SaPersonaInstruccion objDao) {
		try {
			return saPersonaInstruccionDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaInstruccion objDao) {
		try {
			long idSec = saPersonaInstruccionDao.guardar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaInstruccion objDao) {
		try {
			int idSec = saPersonaInstruccionDao.eliminar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaInstruccion objDao) {
		try {
			int idSec = saPersonaInstruccionDao.actualizar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorlistarElementos(SaPersonaInstruccion objDao) {
		try {
			return saPersonaInstruccionDao.contadorlistarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional
	public long guardar(List<SaPersonaInstruccion> listaDao) {
		try {
			long idSec = 0; 
			if(listaDao!=null){
				for(SaPersonaInstruccion objSave : listaDao){
					if(Constant.INSERT_db.equals(objSave.getAccion()+"")){
						saPersonaInstruccionDao.guardar(objSave);	
					}else if(Constant.DELETE_db.equals(objSave.getAccion()+"")){
						saPersonaInstruccionDao.eliminar(objSave);
					}else{
						saPersonaInstruccionDao.actualizar(objSave);
					}					
				}
			}	
			idSec=1;
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}
