package erp.realcoresystems.pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SeguridadConceptoDao;
import erp.realcoresystems.pe.model.dao.SeguridadPerfilUsuarioDao;
import erp.realcoresystems.pe.model.dao.UsuarioDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.service.SeguridadConceptoService;
import erp.realcoresystems.pe.service.SeguridadPerfilUsuarioService;
import erp.realcoresystems.pe.util.Log;

import java.util.ArrayList;
import java.util.List;

@Service("seguridadPerfilUsuarioService")
@Transactional(readOnly = true)
public class SeguridadPerfilUsuarioServiceImpl implements SeguridadPerfilUsuarioService {
	@Autowired
	SeguridadPerfilUsuarioDao seguridadPerfilDao;

	@Override
	public List<Seguridadperfilusuario> SeguridadPerfilLista(Seguridadperfilusuario seguridadAutorizaciones) {
		return seguridadPerfilDao.SeguridadperfilusuarioListar(seguridadAutorizaciones);
	}

	@Override
	public Seguridadperfilusuario SeguridadPerfilBuscar(Seguridadperfilusuario objPersonaMast) {
		return null;
	}

	@Transactional(readOnly = false)
	public int guardar(List<Seguridadperfilusuario> agregar) {
		try {
			if (agregar != null) {
				if (agregar.size() > 0) {
					for (Seguridadperfilusuario x : agregar) {
						seguridadPerfilDao.guardar(x);
					}
				}
			}
			// if (eliminar!=null) {
			// if (eliminar.size() > 0) {
			// for (Seguridadperfilusuario y : eliminar) {
			// seguridadPerfilDao.eliminar(y);
			// }
			// }
			// }
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Transactional(readOnly = false)
	public int guardar(Seguridadperfilusuario seguridadperfilusuario) {
		try {
			seguridadPerfilDao.guardar(seguridadperfilusuario);
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	public void guardarCopiarPerfiles(Usuario usuarioCopia, Usuario usuarioPega) {

		//System.out.println("Se copiara de " + usuarioCopia.getNombre() + " A " + usuarioPega.getNombre());
		// 1 . asignar perfiles de usuario copia a usuario pega
		// 2 . buscar opciones "NO PERFILES " del usuario copia ---> Where
		// usuario = usaurioCopia.getNombre; <---
		// 3 . guardar las opcione "NO PERFILES" del usuario copia como usuario
		// pega

	}

}