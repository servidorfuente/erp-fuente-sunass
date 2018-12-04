package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaDependenciasDao;
import erp.realcoresystems.pe.model.domain.SaDependencias;
import erp.realcoresystems.pe.service.SaDependenciaService;
import erp.realcoresystems.pe.util.Log;

@Service("saDependenciaService")
@Transactional(readOnly = true)
public class SaDependenciaServiceImpl implements SaDependenciaService {

	@Autowired
	private SaDependenciasDao SaDependenciasDao;

	@Override
	public SaDependencias obtenerPorID(int nidedep) {
		try {
			return SaDependenciasDao.obtenerPorID(nidedep);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return null;
	}

	@Override
	public List<SaDependencias> listar(SaDependencias SaDependencias) {
		try {
			return SaDependenciasDao.listar(SaDependencias);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return null;
	}

	@Override
	public List<SaDependencias> listarDetalles(SaDependencias SaDependencias) {
		try {
			return SaDependenciasDao.listarDetalles(SaDependencias);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SaDependencias SaDependencias) {
		try {
			return SaDependenciasDao.guardar(SaDependencias);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(List<SaDependencias> SaDependencias) {
		try {

			for (int i = 0; i < SaDependencias.size(); i++) {
				if (SaDependencias.get(i).getNidedeppadre() == null) {
					int idAntiguo = SaDependencias.get(i).getNidedep();
					int id = SaDependenciasDao.guardar(SaDependencias.get(i));
					int j = i;
					while (j < SaDependencias.size()) {
						if (SaDependencias.get(j).getNidedeppadre() != null
								&& SaDependencias.get(j).getNidedeppadre().equals(idAntiguo)) {
							guardarHijos(SaDependencias.get(j), SaDependencias, id);
						}
						j++;
					}
				}
			}

			// return SaDependenciasDao.guardar(SaDependencias.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

		}
		return 0;
	}

	public void guardarHijos(SaDependencias dep, List<SaDependencias> list, int idNuevo) {
		int idAntiguo = dep.getNidedep();
		// id de su padre
		dep.setNidedeppadre(idNuevo);

		int id = SaDependenciasDao.guardar(dep);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNidedeppadre() != null && list.get(i).getNidedeppadre() == idAntiguo) {

				guardarHijos(list.get(i), list, id);

			}
		}

	}

	@Transactional(readOnly = false)
	public int eliminar(SaDependencias SaDependencias) {
		try {
			return SaDependenciasDao.eliminar(SaDependencias);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return 0;
	}

	@Override
	public int contador(SaDependencias SaDependencias) {
		try {
			return SaDependenciasDao.contador(SaDependencias);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));

		}
		return 0;
	}
}
