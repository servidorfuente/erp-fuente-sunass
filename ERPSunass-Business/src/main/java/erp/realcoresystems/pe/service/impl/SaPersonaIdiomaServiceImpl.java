package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaPersonaIdiomaDao;
import erp.realcoresystems.pe.model.domain.SaPersonaIdioma;
import erp.realcoresystems.pe.model.domain.SaPersonaIdiomaPK;
import erp.realcoresystems.pe.service.SaPersonaIdiomaService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saPersonaIdiomaService")
@Transactional(readOnly = true)
public class SaPersonaIdiomaServiceImpl implements SaPersonaIdiomaService{

	@Autowired
	private SaPersonaIdiomaDao saPersonaIdiomaDao;
	
	@Override
	public SaPersonaIdioma obtenerPorID(SaPersonaIdiomaPK id) {
		try {
			return saPersonaIdiomaDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaIdioma> listarElementos(SaPersonaIdioma objDao) {
		try {
			return saPersonaIdiomaDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaIdioma> listarElementosPag(SaPersonaIdioma objDao) {
		try {
			return saPersonaIdiomaDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaIdioma objDao) {
		try {
			long idSec = saPersonaIdiomaDao.guardar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaIdioma objDao) {
		try {
			int idSec = saPersonaIdiomaDao.eliminar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaIdioma objDao) {
		try {
			int idSec = saPersonaIdiomaDao.actualizar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public long guardar(List<SaPersonaIdioma> listaDao) {
		try {
			long idSec = 0; 
			if(listaDao!=null){
				for(SaPersonaIdioma objSave : listaDao){
					if(Constant.INSERT_db.equals(objSave.getAccion()+"")){
						saPersonaIdiomaDao.guardar(objSave);	
					}else if(Constant.DELETE_db.equals(objSave.getAccion()+"")){
						saPersonaIdiomaDao.eliminar(objSave);
					}else{
						saPersonaIdiomaDao.actualizar(objSave);
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
	public int contadorlistarElementos(SaPersonaIdioma objDao) {
		try {
			return saPersonaIdiomaDao.contadorlistarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;		
	}

}
