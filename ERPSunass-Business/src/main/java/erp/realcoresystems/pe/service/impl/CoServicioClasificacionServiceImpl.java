package erp.realcoresystems.pe.service.impl;

import java.util.List;

import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.CoServicioClasificacionDao;
import erp.realcoresystems.pe.model.domain.CoServicioClasificacion;
import erp.realcoresystems.pe.service.CoServicioClasificacionService;


@Service("coServicioClasificacionService")
public class CoServicioClasificacionServiceImpl implements CoServicioClasificacionService {

	@Autowired
	private CoServicioClasificacionDao coServicioClasificacion;

	@Override
	@Transactional(readOnly = true)
	public List<CoServicioClasificacion> listar(CoServicioClasificacion clasificacion) {
		try {
			return coServicioClasificacion.listar(clasificacion);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(CoServicioClasificacion clasificacion) {
		try {
			return coServicioClasificacion.guardar(clasificacion);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(CoServicioClasificacion clasificacion) {
		try {
			return coServicioClasificacion.actualizar(clasificacion);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CoServicioClasificacion buscarPorId(String servicioclasificacion) {
		try {
			return coServicioClasificacion.buscarPorId(servicioclasificacion);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public int contarTotal(CoServicioClasificacion clasificacion) {
		try {
			return coServicioClasificacion.contarTotal(clasificacion);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

}
