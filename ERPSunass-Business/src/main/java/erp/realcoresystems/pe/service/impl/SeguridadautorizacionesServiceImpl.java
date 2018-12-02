package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadConceptoVistaDao;
import erp.realcoresystems.pe.model.dao.SeguridadPerfilUsuarioDao;
import erp.realcoresystems.pe.model.dao.SeguridadautorizacionesDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;
import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;
import erp.realcoresystems.pe.service.SeguridadConceptoVistaService;
import erp.realcoresystems.pe.service.SeguridadautorizacionesService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("seguridadautorizacionesService")
@Transactional(readOnly = true)
public class SeguridadautorizacionesServiceImpl implements SeguridadautorizacionesService {

	@Autowired
	private SeguridadautorizacionesDao seguridadautorizacionesDao;
	
 	@Autowired
	private SeguridadPerfilUsuarioDao seguridadPerfilUsuarioDao;
	
 	@Autowired
	private SeguridadConceptoVistaService seguridadConceptoVistaService;
 	
 	@Autowired
 	private SeguridadConceptoVistaDao seguridadConceptoVistaDao;

	@Override
	public Seguridadautorizaciones obtenerPorID(Seguridadautorizaciones objDao) {
		try {
			return seguridadautorizacionesDao.obtenerPorID(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public List<Seguridadautorizaciones> listarElementos(Seguridadautorizaciones objDao) {
		try {
			return seguridadautorizacionesDao.listarElementos(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public int guardar(Seguridadautorizaciones objDao) {
		try {
			return seguridadautorizacionesDao.guardar(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(Seguridadautorizaciones objDao) {
		try {
			return seguridadautorizacionesDao.eliminar(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorTotaleslistarElementos(Seguridadautorizaciones objDao) {
		try {
			return seguridadautorizacionesDao.contadorTotaleslistarElementos(objDao);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardarMasivo(List<Seguridadautorizaciones> listaDao) {
		try {
			int result = 1;
			for (Seguridadautorizaciones objDao : listaDao) {
				if (Constant.DELETE_db.equals(objDao.getAccion())) {
					result = seguridadautorizacionesDao.eliminar(objDao);
				} else if (Constant.UPDATE_db.equals(objDao.getAccion())) {
					result = seguridadautorizacionesDao.actualizar(objDao);
				} else {
					result = seguridadautorizacionesDao.guardar(objDao);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public List<Vistaconceptoautoriza> listarPermisosUsuario(Vistaconceptoautoriza objDao) {
		try {
			List<Vistaconceptoautoriza> listaPermisos = new ArrayList<Vistaconceptoautoriza>();
			if (objDao.getUsuario() != null) {
				// AGREGAR PERMISOS DE USAURIO
				List<Vistaconceptoautoriza> listaPermisosTemp = seguridadConceptoVistaDao.listarElementos(objDao);
				if (listaPermisosTemp != null) {
					listaPermisos.addAll(listaPermisosTemp);
				}
				// LISTAR PERFILES
//				List<SeguridadPerfilUsuario> listaPerfilUsuario = new ArrayList<SeguridadPerfilUsuario>();
				Seguridadperfilusuario objPerfiles = new Seguridadperfilusuario();
				objPerfiles.setUsuario(objDao.getUsuario());
				objPerfiles.setEstado(Constant.ACTIVO);
				List<Seguridadperfilusuario> listaPerfilesUser = seguridadPerfilUsuarioDao.SeguridadperfilusuarioListar(objPerfiles);

				// AGREGAR PERMISOS DE PERFILES
				if (listaPerfilesUser != null) {
					if (listaPerfilesUser.size() > 0) {
						for (Seguridadperfilusuario objPerfil : listaPerfilesUser) {
							Vistaconceptoautoriza objFiltro = new Vistaconceptoautoriza();
							objFiltro.setAplicacioncodigo(objDao.getAplicacioncodigo());
							objFiltro.setGrupo(objDao.getGrupo());
							objFiltro.setEstado(objDao.getEstado());
							objFiltro.setConceptopadre(objDao.getConceptopadre());
							// objFiltro.setEstadoSegConcepto(Constant.ACTIVO);
							objFiltro.setVisibleflag(objDao.getVisibleflag());
							objFiltro.setTipodeobjeto(objDao.getTipodeobjeto());
							objFiltro.setDescripcion(objDao.getDescripcion());
							objFiltro.setListaAtributoOrdenacion(objDao.getListaAtributoOrdenacion());
							objFiltro.setTipoOrdenacion(objDao.getTipoOrdenacion());
							objFiltro.setFlagConsultaEntGlobal(objDao.getFlagConsultaEntGlobal());
							objFiltro.setOrdernable(objDao.isOrdernable());
							objFiltro.setAtributoOrdenacion(objDao.getAtributoOrdenacion());
							/////////							
							objFiltro.setUsuario(objPerfil.getPerfil());
							
							//***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION ANTERIOR QUE ERA DE TIPO TREE		
							objFiltro.setTipodeacceso(objDao.getTipodeacceso());							
							List<Vistaconceptoautoriza> listaPermisosPerfTemp = seguridadConceptoVistaDao
									.listarElementos(objFiltro);
							if (listaPermisosPerfTemp != null) {
								listaPermisos.addAll(listaPermisosPerfTemp);
							}
						}
					}
				}

			}

			return listaPermisos;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}
}
