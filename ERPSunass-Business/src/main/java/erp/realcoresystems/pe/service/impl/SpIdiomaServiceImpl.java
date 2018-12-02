package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SpIdiomaDao;
import erp.realcoresystems.pe.model.domain.SpIdioma;
import erp.realcoresystems.pe.service.SpIdiomaService;
import erp.realcoresystems.pe.util.Log;

@Service("spIdiomaService")
@Transactional(readOnly = true)
public class SpIdiomaServiceImpl implements SpIdiomaService{

	@Autowired
	private SpIdiomaDao spIdiomaDao;
	
	@Override
	public SpIdioma obtenerPorID(Long id) {
		try {
			return spIdiomaDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SpIdioma> listarElementos(SpIdioma objDao) {
		try {
			return spIdiomaDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SpIdioma> listarElementosPag(SpIdioma objDao) {
		try {
			return spIdiomaDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	@Transactional
	public long guardar(SpIdioma objDao) {
		try {
			long idSec = spIdiomaDao.guardar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SpIdioma objDao) {
		try {
			int idSec = spIdiomaDao.eliminar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SpIdioma objDao) {
		try {
			int idSec = spIdiomaDao.actualizar(objDao);						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorlistarElementos(SpIdioma objDao) {
		try {
			return spIdiomaDao.contadorlistarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	public boolean verificarDuplicidad(SpIdioma filtro) {
		try {
			int result = 0;
			List<SpIdioma> busqueda = spIdiomaDao.listarElementos(filtro);
			if(UtilesCommons.noEsVacio(busqueda)){
				for (SpIdioma value : busqueda) {
					if(UtilesCommons.sonCadenasIguales(value.getIdidescripcion(), filtro.getIdidescripcion())){
						result = 1;
						break;
					}				
				}
			}

			return (result == 1) ?  true : false;		
			 
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			
		}
		return false;
	}

}
