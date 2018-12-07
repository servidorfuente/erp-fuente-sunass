package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsCargainicialDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.vista.VwCargainicial;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsCargainicialService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssCargainicialService")
@Transactional(readOnly = true)
public class SsCargainicialServiceImpl extends AbstractServiceImpl implements SsCargainicialService {

	@Autowired
	private SsCargainicialDao ssCargainicialDao;

	@Override
	public SsCargainicial buscar(SsCargainicial filtro) {
		try {
			return ssCargainicialDao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsCargainicialServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public SsCargainicial verificar(SsCargainicial filtro) {
		try {
			return ssCargainicialDao.verificar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsCargainicialServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SsCargainicial> listar(SsCargainicial objDao, boolean pagina) {
		try {
			return ssCargainicialDao.listar(objDao, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public int contar(SsCargainicial filtro) {
		return ssCargainicialDao.contar(filtro);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SsCargainicial objDao) {
		try {

			return ssCargainicialDao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SsCargainicial objDao) {
		try {
			return ssCargainicialDao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SsCargainicial objDao) {
		try {
			return ssCargainicialDao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public List<VwCargainicial> listarVista(VwCargainicial vista, SsCargainicial entidad, boolean pagina) {
		try {
			return ssCargainicialDao.listarVista(vista,entidad, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public int contarVista(VwCargainicial filtro) {
		return ssCargainicialDao.contarVista(filtro);
	}
}
