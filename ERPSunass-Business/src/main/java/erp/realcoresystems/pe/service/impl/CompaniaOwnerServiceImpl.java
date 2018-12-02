package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadAutorizacionCompaniaDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizacioncompania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import erp.realcoresystems.pe.model.dao.CompaniaOwnerDao;
import erp.realcoresystems.pe.model.dao.SyAutorizacionSeguridadDao;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("companiaOwnerService")
@Transactional(readOnly = true)
public class CompaniaOwnerServiceImpl implements CompaniaOwnerService {

	@Autowired
	private CompaniaOwnerDao companiaOwnerDao;

	@Autowired
	private SyAutorizacionSeguridadDao syAutorizacionSeguridadDao;

	@Autowired
	SeguridadAutorizacionCompaniaDao seguridadAutorizacionCompaniaDao;

	@Override
	public Companyowner obtenerPorId(String companyowner) {
		List<Companyowner> objList =new  ArrayList<Companyowner>();
		Companyowner objEntite = new Companyowner();
		objEntite.setCompanyowner(companyowner);
		try {
			objList = companiaOwnerDao.listarCompanias(objEntite);
			if (objList!=null)
			return objList.get(0);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Companyowner> listarCompanias(Companyowner companyowner) {
		try {
			return companiaOwnerDao.listarCompanias(companyowner);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Companyowner> listarCompaniasPorAutorizacion(Companyowner companyowner) {
		SySeguridadautorizaciones sySeguridadautorizaciones = new SySeguridadautorizaciones();
		sySeguridadautorizaciones.setUsuario(companyowner.getUsuarioEntGlobal());
		sySeguridadautorizaciones.setGrupo(Constant.COMPANIA);
		List<SySeguridadautorizaciones> listaAutorizaciones = syAutorizacionSeguridadDao
				.listadoSySeguridad(sySeguridadautorizaciones);
		List<Companyowner> listaCompania;
		try {
			listaCompania = companiaOwnerDao.listarCompanias(companyowner);
			List<Companyowner> lista = new ArrayList<Companyowner>();
			for (SySeguridadautorizaciones a : listaAutorizaciones) {
				for (Companyowner c : listaCompania) {
					if (a.getConcepto().equals(c.getCompanyowner())) {
						lista.add(c);
					}
				}
			}
			return lista;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));

			e.printStackTrace();
		}

		return null;
	}


	@Override
	public List<Companyowner> listarSeguridad(Companyowner filtro, String usuario) {
		try {
			//FILTRAR POR LOS CONCEPTOS DE  SEGURIDAD
			SySeguridadautorizaciones objSySeguridad = new SySeguridadautorizaciones();
			objSySeguridad.setAplicacioncodigo(Constant.APLICACION_CODIGO);///***obs: SE USA LA APLICACI-N GENERAL
			objSySeguridad.setGrupo(Constant.GRUPO_COMPANIA);
			objSySeguridad.setUsuario(usuario);
			objSySeguridad.setEstado(UtilesCommons.ACTIVO_db);

			List<SySeguridadautorizaciones> listaSySeguridad = syAutorizacionSeguridadDao.listar(objSySeguridad);
			//TRAER SOLO LOS PERMITIDOS
			if(listaSySeguridad!=null){
				List<String> listaFiltroIn = new ArrayList<String>();
				for(SySeguridadautorizaciones objseguridad: listaSySeguridad){
					listaFiltroIn.add(objseguridad.getConcepto().trim());
				}
				if(listaFiltroIn.size()>0){
					filtro.setNombreConsulta("MULTI_COMPANIASOCIO");
					filtro.setAtributoList("companyowner");
					filtro.setListString(listaFiltroIn);
					filtro.setListaAtributoOrdenacion(Arrays.asList("companyowner"));
					return companiaOwnerDao.listar(filtro);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<Companyowner> listarSeguridadAutozacionCompania(Companyowner filtro, String usuario) {
		try {
			//FILTRAR POR LOS CONCEPTOS DE  SEGURIDAD
			Seguridadautorizacioncompania objSySeguridad = new Seguridadautorizacioncompania();
			objSySeguridad.setUsuario(usuario);
			objSySeguridad.setEstado(UtilesCommons.ACTIVO_db);

			List<Seguridadautorizacioncompania> listaSySeguridad = seguridadAutorizacionCompaniaDao.
					listarElementos(objSySeguridad, false);
			//TRAER SOLO LOS PERMITIDOS
			if(listaSySeguridad!=null){
				List<String> listaFiltroIn = new ArrayList<String>();
				for(Seguridadautorizacioncompania objseguridad: listaSySeguridad){
					listaFiltroIn.add(objseguridad.getCompanyowner().trim());
				}
				if(listaFiltroIn.size()>0){
					filtro.setNombreConsulta("MULTI_COMPANIASOCIO");
					filtro.setAtributoList("companyowner");
					filtro.setListString(listaFiltroIn);
					return companiaOwnerDao.listar(filtro);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}


}
