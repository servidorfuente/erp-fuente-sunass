package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTurnoDao;
import erp.realcoresystems.pe.model.domain.SaTurno;
import erp.realcoresystems.pe.service.SaTurnoService;
import erp.realcoresystems.pe.util.Log;

@Service("saTurnoService")
@Transactional(readOnly = true)
public class SaTurnoServiceImpl implements SaTurnoService {

	@Autowired
	private SaTurnoDao turnoDao;

	@Override
	public List<SaTurno> listarTodos(SaTurno filtro) {
		try {
			return turnoDao.listarTodos(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public SaTurno obtenerTurno(SaTurno filtro) {
		try {
			return turnoDao.obtenerTurno(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}
	
	@Override
	@Transactional(readOnly = false)
	public int guardar(SaTurno objSave) {
		try{			
			return turnoDao.guardar(objSave);
		}catch(Exception e){
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}	
	}
	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaTurno objSave) {
		try {
			return turnoDao.actualizar(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
		
	}

	@Transactional(readOnly = false)
	public int eliminar(SaTurno objSave) {
		try {
			return turnoDao.eliminar(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public List<SaTurno> validate(SaTurno objSave) {
		try {
			return turnoDao.validate(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
		
		
	}

	@Override
	public List<SaTurno> listar(SaTurno filtro) {
		try {
			return turnoDao.listar(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int contador(SaTurno filtro) {
		try {
			return turnoDao.contador(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
		
	}
	
	
}
