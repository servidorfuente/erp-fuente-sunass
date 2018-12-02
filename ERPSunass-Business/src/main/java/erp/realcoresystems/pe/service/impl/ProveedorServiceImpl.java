package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.ProveedormastDao;
import erp.realcoresystems.pe.model.domain.Proveedormast;
import erp.realcoresystems.pe.service.ProveedormastService;
import erp.realcoresystems.pe.util.Log;

@Service("proveedorService")
@Transactional(readOnly = true)
public class ProveedorServiceImpl implements ProveedormastService {

	@Autowired
	private ProveedormastDao dao;

	@Override
	public Proveedormast obtenerPorID(Proveedormast proveedormast) {
		try {
			return dao.obtenerPorID(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Proveedormast> validate(Proveedormast proveedormast) {
		try {
			return dao.validate(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Proveedormast> listar(Proveedormast proveedormast) {
		try {
			return dao.listar(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}
	
	@Override
	public List<Proveedormast> listarCombo(Proveedormast proveedormast) {
		try {
			return dao.listarCombo(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}


	@Override
	@Transactional(readOnly = false)
	public int guardar(Proveedormast proveedormast) {
		try {
			return dao.guardar(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	public int eliminar(Proveedormast proveedormast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contador(Proveedormast proveedormast) {
		try {
			return dao.contador(proveedormast);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	

}
