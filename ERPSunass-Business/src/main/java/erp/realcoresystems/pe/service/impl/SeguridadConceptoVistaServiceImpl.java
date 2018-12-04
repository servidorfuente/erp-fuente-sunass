package erp.realcoresystems.pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.SeguridadConceptoVistaDao;
import erp.realcoresystems.pe.model.dao.SeguridadGrupoDao;
import erp.realcoresystems.pe.model.dao.SeguridadPerfilUsuarioDao;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.service.SeguridadConceptoVistaService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

import java.util.ArrayList;
import java.util.List;

@Service("seguridadConceptoVistaService")
@Transactional(readOnly = true)
public class SeguridadConceptoVistaServiceImpl implements SeguridadConceptoVistaService {

	@Autowired
	private SeguridadConceptoVistaDao seguridadConceptoVistaDao;
	@Autowired
	private SeguridadGrupoDao seguridadGrupoDao;
	@Autowired
	private SeguridadPerfilUsuarioDao seguridadPerfilUsuarioDao;

	@Override
	public List<Vistaconceptoautoriza> SeguridadConceptoVistaLista(Vistaconceptoautoriza seguridadAutorizaciones) {
		try {
			String[] inEstados;
			ArrayList<String> elemIn = new ArrayList<String>();
			Seguridadperfilusuario spusuario = new Seguridadperfilusuario();
			spusuario.setUsuario(seguridadAutorizaciones.getUsuario());
			spusuario.setEstado(Constant.ACTIVO);//PARA NO TRAER LOS ELIMINADOS LOGICAMENTE
			List<Seguridadperfilusuario> listSpusuario = seguridadPerfilUsuarioDao
					.SeguridadperfilusuarioListar(spusuario);
			elemIn.add(seguridadAutorizaciones.getUsuario());
			for (Seguridadperfilusuario subDoc : listSpusuario) {
				elemIn.add(subDoc.getPerfil());
			}
			List<Vistaconceptoautoriza> listObj = new ArrayList<Vistaconceptoautoriza>();
			if (seguridadAutorizaciones.getGrupo() != null) {
				listObj = seguridadConceptoVistaDao.SeguridadConceptoVistaLista(seguridadAutorizaciones, elemIn);
			} else if ("T".equals(seguridadAutorizaciones.getOpcionagregarflag())) {
				listObj = seguridadConceptoVistaDao.SeguridadConceptoVistaLista(seguridadAutorizaciones, elemIn);
			} else {

				Vistaconceptoautoriza entObj;
				Seguridadgrupo obj = new Seguridadgrupo();
				obj.setAplicacioncodigo(seguridadAutorizaciones.getAplicacioncodigo());
				List<Seguridadgrupo> objLista = seguridadGrupoDao.SeguridadGrupoLista(obj);
				for (Seguridadgrupo subDoc : objLista) {
					entObj = new Vistaconceptoautoriza();
					entObj.setAplicacioncodigo(subDoc.getAplicacioncodigo());
					entObj.setGrupo(subDoc.getGrupo());
					entObj.setConcepto(subDoc.getGrupo());
					entObj.setDescripcion(subDoc.getDescripcion());
					Vistaconceptoautoriza verificarAutoModulo = new Vistaconceptoautoriza();
					verificarAutoModulo.setAplicacioncodigo(subDoc.getAplicacioncodigo());
					verificarAutoModulo.setGrupo(subDoc.getGrupo());
					verificarAutoModulo.setUsuario(seguridadAutorizaciones.getUsuario());
					verificarAutoModulo.setXestado(seguridadAutorizaciones.getXestado());
					
					//***OBS TIPO DE ACCESO: DE TIPO TREE, EN CONTRAPOSICION CON LA VERSION POSTERIOR QUE ESE DE TIPO MENU		
					verificarAutoModulo.setTipodeacceso(seguridadAutorizaciones.getTipodeacceso());					
					Vistaconceptoautoriza objs = seguridadConceptoVistaDao
							.SeguridadConceptoVistaBuscar(verificarAutoModulo, elemIn);
					if (objs != null) {
						entObj.setUsuario(objs.getUsuario());
						entObj.setOpcionopcion1Flag(objs.getOpcionopcion1Flag());
						listObj.add(entObj);
					}
				}
			}
			return listObj;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public Vistaconceptoautoriza SeguridadConceptoVistaBuscar(Vistaconceptoautoriza seguridadConcepto) {
		try {
			return seguridadConceptoVistaDao.SeguridadConceptoVistaBuscar(seguridadConcepto, null);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}
}