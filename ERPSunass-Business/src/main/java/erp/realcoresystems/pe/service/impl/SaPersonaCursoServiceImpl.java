package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaPersonaCursoDao;
import erp.realcoresystems.pe.model.domain.SaPersonaCurso;
import erp.realcoresystems.pe.model.domain.SaPersonaCursoPK;
import erp.realcoresystems.pe.service.SaPersonaCursoService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saPersonaCursoService")
@Transactional(readOnly = true)
public class SaPersonaCursoServiceImpl implements SaPersonaCursoService {

	@Autowired
	SaPersonaCursoDao saPersonaCursoDao;
	
	@Override
	public SaPersonaCurso obtenerPorID(SaPersonaCursoPK id) {
		try {
			return saPersonaCursoDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;	
	}

	@Override
	public List<SaPersonaCurso> listarElementos(SaPersonaCurso objDao) {
		try {
			return saPersonaCursoDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaCurso> listarElementosPag(SaPersonaCurso objDao) {
		try {
			return saPersonaCursoDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaCurso objDao) {
		try {
			long idSec = saPersonaCursoDao.guardar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaCurso objDao) {
		try {
			int idSec = saPersonaCursoDao.eliminar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaCurso objDao) {
		try {
			int idSec = saPersonaCursoDao.actualizar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public long guardar(List<SaPersonaCurso> listaDao) {
		try {
			long idSec = 0; 
			if(listaDao!=null){
				for(SaPersonaCurso objSave : listaDao){
					if(Constant.INSERT_db.equals(objSave.getAccion()+"")){
						saPersonaCursoDao.guardar(objSave);	
					}else if(Constant.DELETE_db.equals(objSave.getAccion()+"")){
						saPersonaCursoDao.eliminar(objSave);
					}else{
						saPersonaCursoDao.actualizar(objSave);
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
	public int contarElementos(SaPersonaCurso objDao) {
		try {
			return saPersonaCursoDao.contarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

}
