package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.CompaniaMastDao;
import erp.realcoresystems.pe.model.dao.SyAutorizacionSeguridadDao;
import erp.realcoresystems.pe.model.domain.CompaniaMast;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.service.CompaniaMastService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("companiaMastService")
@Transactional(readOnly = true)
public class CompaniaMastServiceImpl implements CompaniaMastService {

	@Autowired
	private CompaniaMastDao companiaMastDao;

	@Autowired
	private SyAutorizacionSeguridadDao syAutorizacionSeguridadDao;

	@Override
	public CompaniaMast buscarPorID(String id) {
		try {
			return companiaMastDao.findById(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<CompaniaMast> companiaListar(CompaniaMast companiamast) {
		try {
			return companiaMastDao.companiaListar(companiamast);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

	@Override
	public List<CompaniaMast> companiaListarPorAutorizacion(CompaniaMast companiamast) {
		try {
			SySeguridadautorizaciones sySeguridadautorizaciones = new SySeguridadautorizaciones();
			sySeguridadautorizaciones.setUsuario(companiamast.getUsuarioEntGlobal());
			sySeguridadautorizaciones.setGrupo(Constant.COMPANIA);
			List<SySeguridadautorizaciones> listaAutorizaciones = syAutorizacionSeguridadDao
					.listadoSySeguridad(sySeguridadautorizaciones);
			List<CompaniaMast> listaCompania = companiaMastDao.companiaListar(companiamast);
			List<CompaniaMast> lista = new ArrayList<CompaniaMast>();
			for (SySeguridadautorizaciones a : listaAutorizaciones) {
				for (CompaniaMast c : listaCompania) {
					if (a.getConcepto().equals(c.getCompaniacodigo())) {
						lista.add(c);
					}
				}
			}
			return lista;

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

}
