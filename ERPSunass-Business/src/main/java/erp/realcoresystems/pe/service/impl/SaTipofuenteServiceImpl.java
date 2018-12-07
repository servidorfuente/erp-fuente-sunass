package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsFormcom01ADao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsFormcom01AService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("saTipofuenteService")
@Transactional(readOnly = true)
public class SaTipofuenteServiceImpl extends AbstractServiceImpl implements SaTipofuenteService {

	@Autowired
	private SaTipofuenteDao saTipofuenteDao;

	@Override
	public SaTipofuente buscar(SaTipofuente filtro) {
		try {
			return saTipofuenteDao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SaTipofuenteServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SaTipofuente> listar(SaTipofuente objDao, boolean pagina) {
		try {
			return saTipofuenteDao.listar(objDao, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public int contar(SaTipofuente filtro) {
		return saTipofuenteDao.contar(filtro);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SaTipofuente objDao) {
		try {
			return saTipofuenteDao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaTipofuente objDao) {
		try {
			return saTipofuenteDao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SaTipofuente objDao) {
		try {
			return saTipofuenteDao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

}
