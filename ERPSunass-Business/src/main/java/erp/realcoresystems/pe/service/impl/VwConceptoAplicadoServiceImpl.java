package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.VwConceptoAplicadoDao;
import erp.realcoresystems.pe.model.domain.vista.VwConceptoAplicado;
import erp.realcoresystems.pe.service.VwConceptoAplicadoService;
import erp.realcoresystems.pe.util.Log;

@Service("vwConceptoaplicadoService")
@Transactional(readOnly = true)
public class VwConceptoAplicadoServiceImpl implements VwConceptoAplicadoService {

	@Autowired
	private VwConceptoAplicadoDao accionDao;

	@Override
	public int contador(VwConceptoAplicado filtro) {

		try {
			return accionDao.contador(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
		
	
	}


	@Override
	public List<VwConceptoAplicado> validate(VwConceptoAplicado filtro) {
		try {
			return accionDao.validate(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<VwConceptoAplicado> listarElementos(VwConceptoAplicado filtro, boolean paginable) {
		try {
			return accionDao.listarElementos(filtro,paginable);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
	

	@Override
	public VwConceptoAplicado obtenerPorId(VwConceptoAplicado filtro) {
		try {
			return accionDao.obtenerPorId(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}


	

}
