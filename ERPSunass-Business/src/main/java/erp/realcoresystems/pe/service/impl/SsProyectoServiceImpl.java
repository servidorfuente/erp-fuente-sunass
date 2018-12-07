package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsProyectoDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsProyecto;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsProyectoService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssProyectoService")
@Transactional(readOnly = true)
public class SsProyectoServiceImpl extends AbstractServiceImpl implements SsProyectoService {

	@Autowired
	private SsProyectoDao ssProyectoDao;

	@Override
	public SsProyecto buscar(SsProyecto filtro) {
		try {
			return ssProyectoDao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsProyectoServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SsProyecto> listar(SsProyecto objDao, boolean pagina) {
		try {
			return ssProyectoDao.listar(objDao, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public int contar(SsProyecto filtro) {
		return ssProyectoDao.contar(filtro);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SsProyecto objDao) {
		try {
			return ssProyectoDao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SsProyecto objDao) {
		try {
			return ssProyectoDao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SsProyecto objDao) {
		try {
			return ssProyectoDao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

}
