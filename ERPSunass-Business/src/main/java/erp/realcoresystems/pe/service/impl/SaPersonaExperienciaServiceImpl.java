package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaPersonaExperienciaDao;
import erp.realcoresystems.pe.model.domain.SaPersonaExperiencia;
import erp.realcoresystems.pe.model.domain.SaPersonaExperienciaPK;
import erp.realcoresystems.pe.service.SaPersonaExperienciaService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saPersonaExperienciaService")
@Transactional(readOnly = true)
public class SaPersonaExperienciaServiceImpl implements SaPersonaExperienciaService{

	@Autowired
	private SaPersonaExperienciaDao saPersonaExperienciaDao;
	
	@Override
	public SaPersonaExperiencia obtenerPorID(SaPersonaExperienciaPK id) {
		try {
			return saPersonaExperienciaDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;				
	}

	@Override
	public List<SaPersonaExperiencia> listarElementos(SaPersonaExperiencia objDao) {
		try {
			return saPersonaExperienciaDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;	
	}

	@Override
	public List<SaPersonaExperiencia> listarElementosPag(SaPersonaExperiencia filtro) {
		try {
			return saPersonaExperienciaDao.listarElementosPag(filtro);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaExperiencia objDao) {
		try {
			long idSec = saPersonaExperienciaDao.guardar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaExperiencia objDao) {
		try {
			int idSec = saPersonaExperienciaDao.eliminar(objDao);					
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaExperiencia objDao) {
		try {
			int idSec = saPersonaExperienciaDao.actualizar(objDao);					
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contarElementos(SaPersonaExperiencia objDao) {
		try {
			return saPersonaExperienciaDao.contarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional
	public long guardarMasivo(List<SaPersonaExperiencia> listaDao) {
		try {
			long idSec = 0; 
			if(listaDao!=null){
				for(SaPersonaExperiencia objSave : listaDao){
					if(Constant.INSERT_db.equals(objSave.getAccion()+"")){
						saPersonaExperienciaDao.guardar(objSave);	
					}else if(Constant.DELETE_db.equals(objSave.getAccion()+"")){
						saPersonaExperienciaDao.eliminar(objSave);
					}else{
						saPersonaExperienciaDao.actualizar(objSave);
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
