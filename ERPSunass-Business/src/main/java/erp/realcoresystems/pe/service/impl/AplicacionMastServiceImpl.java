package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.AplicacionMastDao;
import erp.realcoresystems.pe.model.domain.Aplicacionesmast;
import erp.realcoresystems.pe.service.AplicacionMastService;
import erp.realcoresystems.pe.util.Log;

@Service("aplicacionMastService")
@Transactional(readOnly = true)
public class AplicacionMastServiceImpl implements AplicacionMastService {

	private AplicacionMastDao aplicacionDao;

	@Autowired
	public void setAplicacionDao(AplicacionMastDao aplicacionDao) {
		this.aplicacionDao = aplicacionDao;
	}

	@Override
	public List<Aplicacionesmast> listarPorEstado(String estado) {
		try {

			return aplicacionDao.listarPorEstado(estado);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

	@Override
	public Aplicacionesmast buscarPorID(String id) {
		try {
			return aplicacionDao.buscarPorID(id);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Aplicacionesmast> listarTodos(Aplicacionesmast objDao) {
		try {
			return aplicacionDao.listarTodos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

}
