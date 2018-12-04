package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.SeguridadGrupoDao;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;
import erp.realcoresystems.pe.service.SeguridadGrupoService;
import erp.realcoresystems.pe.util.Log;


@Service("seguridadGrupoService")
@Transactional(readOnly = true)
public class SeguridadGrupoServiceImpl implements SeguridadGrupoService {

	@Autowired
	private SeguridadGrupoDao seguridadGrupoDao;

	@Override
	public Seguridadgrupo obtenerPorId(Integer id) {
		try {
			return seguridadGrupoDao.obtenerTipoPorId(id);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Seguridadgrupo> listar(Seguridadgrupo seguridadGrupo) {
		try {
			return seguridadGrupoDao.listarTipo(seguridadGrupo);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int contarTotal(Seguridadgrupo seguridadGrupo) {
		try {
			return seguridadGrupoDao.contarTipo(seguridadGrupo);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}	
	
	
	@Override
	public List<Seguridadgrupo> listarCombo(Seguridadgrupo saTipopProcReglamento) {
		try {
			return seguridadGrupoDao.listarCombo(saTipopProcReglamento);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
	
	
	
	
	@Override
	@Transactional(readOnly = false)
	public int guardar(Seguridadgrupo seguridadGrupo) {
		try {
			return seguridadGrupoDao.guardarTipo(seguridadGrupo);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int actualizar(Seguridadgrupo seguridadGrupo) {
		try {
			return seguridadGrupoDao.actualizarTipo(seguridadGrupo);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public int eliminar(Seguridadgrupo seguridadGrupo) {
		try {
			return seguridadGrupoDao.eliminarTipo(seguridadGrupo);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public List<Seguridadgrupo> listarTodos(Seguridadgrupo seguridadgrupo, Boolean paginable) {
		try {
			return seguridadGrupoDao.listarTodos(seguridadgrupo,paginable);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int contarTodos(Seguridadgrupo seguridadgrupo) {
		try {
			return seguridadGrupoDao.contarTodos(seguridadgrupo);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public List<Seguridadgrupo> validate(Seguridadgrupo seguridadgrupo) {
		try {
			return seguridadGrupoDao.validate(seguridadgrupo);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
		
}
