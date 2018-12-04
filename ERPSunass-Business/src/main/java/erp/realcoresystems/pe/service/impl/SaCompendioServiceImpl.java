package erp.realcoresystems.pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.SaCompendioDao;
import erp.realcoresystems.pe.model.dao.SaCompendioDetalleDao;
import erp.realcoresystems.pe.model.domain.SaCompendio;
import erp.realcoresystems.pe.model.domain.SaCompendioDetalle;
import erp.realcoresystems.pe.service.SaCompendioService;
import erp.realcoresystems.pe.util.Log;

import java.util.List;

@Service("SaCompendioService")
@Transactional(readOnly = true)
public class SaCompendioServiceImpl implements SaCompendioService {

	@Autowired
	private SaCompendioDao SaCompendioDao;

	@Autowired
	private SaCompendioDetalleDao saCompendioDetalleDao;

	@Override
	public SaCompendio obtenerPorId(SaCompendio SaCompendio) {
		try {
			return SaCompendioDao.obtenerEntidad(SaCompendio);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<SaCompendio> listar(SaCompendio SaCompendio) {
		try {
			return SaCompendioDao.listar(SaCompendio);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int guardar(SaCompendio SaCompendio) {
		try {
			return SaCompendioDao.guardar(SaCompendio);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int actualizar(SaCompendio SaCompendio) {
		try {
			return SaCompendioDao.actualizar(SaCompendio);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int contarTotal(SaCompendio SaCompendio) {
		try {
			return SaCompendioDao.contarTotal(SaCompendio);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public SaCompendioDetalle obtenerPorId(SaCompendioDetalle saCompendioDetalle){
		try {
			return saCompendioDetalleDao.obtenerPorId(saCompendioDetalle.getNidecompendio(), saCompendioDetalle.getNidedetalle());
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
	
	/** DETALLE **/
	@Override
	public List<SaCompendioDetalle> listar(SaCompendioDetalle saCompendiodetalle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int guardar(SaCompendioDetalle saCompendiodetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(SaCompendioDetalle saCompendiodetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contarTotal(SaCompendioDetalle saCompendiodetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SaCompendioDetalle> listarCombo(int compendioId) {
		try {
			return saCompendioDetalleDao.listarCombo(compendioId);

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
}
