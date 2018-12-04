package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaPersonaFamiliarDao;
import erp.realcoresystems.pe.model.domain.SaPersonaFamiliar;
import erp.realcoresystems.pe.model.domain.SaPersonaFamiliarPK;
import erp.realcoresystems.pe.service.SaPersonaFamiliarService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saPersonaFamiliarService")
@Transactional(readOnly = true)
public class SaPersonaFamiliarServiceImpl implements SaPersonaFamiliarService {

	@Autowired
	private SaPersonaFamiliarDao saPersonaFamiliarDao;
	
	@Override
	public SaPersonaFamiliar obtenerPorID(SaPersonaFamiliarPK id) {
		try {
			return saPersonaFamiliarDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;	
	}

	@Override
	public List<SaPersonaFamiliar> listarElementos(SaPersonaFamiliar objDao) {
		try {
			return saPersonaFamiliarDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;	
	}

	@Override
	public List<SaPersonaFamiliar> listarElementosPag(SaPersonaFamiliar filtro) {
		try {
			return saPersonaFamiliarDao.listarElementos(filtro);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaFamiliar objDao) {
		try {
			long idSec = saPersonaFamiliarDao.guardar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaFamiliar objDao) {
		try {
			int idSec = saPersonaFamiliarDao.eliminar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaFamiliar objDao) {
		try {
			int idSec = saPersonaFamiliarDao.actualizar(objDao);					
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public long guardar(List<SaPersonaFamiliar> listaDao) {
		try {
			long idSec = 0; 
			if(listaDao!=null){
				for(SaPersonaFamiliar objSave : listaDao){
					if(Constant.INSERT_db.equals(objSave.getAccion()+"")){
						saPersonaFamiliarDao.guardar(objSave);	
					}else if(Constant.DELETE_db.equals(objSave.getAccion()+"")){
						saPersonaFamiliarDao.eliminar(objSave);
					}else{
						saPersonaFamiliarDao.actualizar(objSave);
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

	@Override
	public int contarElementos(SaPersonaFamiliar objDao) {
		try {
			return saPersonaFamiliarDao.contarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

}
