package erp.realcoresystems.pe.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;

import erp.realcoresystems.pe.model.dao.ParametrosMastDao;
import erp.realcoresystems.pe.model.dao.UsuarioDao;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;


@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private ParametrosMastDao parametrosMastDao;
	
	//@Autowired
	//private LiferayService liferayService;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario ValidarUsuario(Usuario objUsuario) {
		try {			
			return usuarioDao.ValidarUsuario(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));			
			return null;
		}
	}

	@Override
	public Usuario validarLogin(String usuario, String clave) {	
			try {
				
				
				Usuario userValidar  = new Usuario();
				userValidar.setUsuario(usuario);
				userValidar.setClave(clave);
				///NUSCAR POR ID, NECESITA EL IGNORE CASE .....
				Usuario obj = ValidarUsuario(userValidar);
				///retornar
				return obj;
			} catch (Exception e) {
				e.printStackTrace();
				Log.logger.error(Log.getStackTrace(e));			
			}
			return null;	
	}
	
	@Override
	@Transactional
	public List<Usuario> UsuarioPerfilListar(Usuario usuario) {
		try {
			return usuarioDao.UsuarioPerfilListar(usuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	public List<Usuario> UsuarioListar(Usuario usuario) {
		try{
			return usuarioDao.UsuarioListar(usuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return UtilesCommons.getNewList();
		}
	}

	@Override	
	public Usuario UsuarioBuscar(Usuario usuario) {
		try{
			return usuarioDao.UsuarioBuscar(usuario);
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override	
	@Transactional
	public List<Usuario> listarPaginacionUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.listarPaginacionUsuario(objUsuario);
		} catch (Exception e) {					
			Log.logger.error(Log.getStackTrace(e));						
			return null;
		}
	}



	@Override
	@Transactional(readOnly = true)
	public int contadorTotalesUsuario(Usuario objUsuario) {		
		try {
			return usuarioDao.contadorTotalesUsuario(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return 0;
		}
	}

	@Override
	@Transactional
	public int guardarUsuario(Usuario objUsuario) {
		try{		
			int result =usuarioDao.guardarUsuario(objUsuario); 				
			/**REGISTRO DE LA SEGURIDAD LIFERAY*/
			//Liferay AQUILES
			
			String valorDef = Constant.getPropertyServ("PAR_ACCESO_LIFERAY_VALOR_DEF");	//POR DEFECTO SÃ_
			/*
			ParametrosMastPK ParamId = new ParametrosMastPK();
			ParamId.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			ParamId.setCompaniacodigo(Constant.COMPANIA_VARIABLE);												
			ParamId.setParametroclave(Constant.getPropertyServ("PAR_ACCESO_LIFERAY"));			
			ParametrosMast param1  = parametrosMastDao.buscarPorID(ParamId);
			if(param1!=null){
				if(Constant.ACTIVO.equals(param1.getEstado())){
					if(param1.getTexto()!=null){
						valorDef = param1.getTexto().trim();	
					}								
				}
			}*/
			
			// SI ESTÃ_ o NO ESTÃ_ HABILITADO EL USO DE LIFERAY
			if(Constant.SI_db.equals((""+valorDef))){
//				Object objLifeRay = AbstractDaoImpl.getNuevoObjetoGenerico(objUsuario, Usuario.class);
//				if(objLifeRay!=null){
//					Usuario userLifeRay = (Usuario)objLifeRay;
//					String keyClave = EncriptaKeyService.getDescifrado(userLifeRay.getClave());
//					userLifeRay.setClave(keyClave);
//					try{
//						liferayService.registrar(userLifeRay,null,null,null,null,0);	
//					}catch(Exception ex){
//						ex.printStackTrace();
//						result = 2;
//						//CONTINUAR SI SE CAE?
//					}
//				}
			}
			
			


			return result;
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;					
	}

	@Override
	@Transactional
	public int eliminarUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.eliminarUsuario(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
	
	@Override
	@Transactional
	public int actualizar(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.actualizar(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario obtenerUsuarioID(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.obtenerUsuarioID(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarPaginacionSeleccionadorUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.listarPaginacionSeleccionadorUsuario(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public int contadorTotalesSeleccionadorUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.contadorTotalesSeleccionadorUsuario(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarComboUsuarioSupervisor(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			return usuarioDao.listarComboUsuarioSupervisor(objUsuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override
	@Transactional
	public List<VwUsuarioseguridad> listarVwUsuarioseguridad(Usuario usuario) {
		try {
			return usuarioDao.listarVwUsuarioseguridad(usuario);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override
	public Map<String, String> obtenerUsuarioCreacionModificacion(Integer creacion, Integer modificacion) {
		try {
			return usuarioDao.obtenerUsuarioCreacionModificacion(creacion, modificacion);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			Map<String, String> respuestaAux = new HashMap<>();
			respuestaAux.put("creador", "");
			respuestaAux.put("modificador", "");			
			return respuestaAux;
		}
	}



	@Override
	@Transactional
	public int guardarUsuarioGeneral(Usuario objUsuario, boolean flagLR) {
		try{		
			int result =usuarioDao.guardarUsuario(objUsuario);
			if(flagLR){
				/**REGISTRO DE LA SEGURIDAD LIFERAY*/
				//Liferay AQUILES
				try{
					//liferayService.registrar(objUsuario,null,null,null,null,0);
				}catch(Exception ex){
					ex.printStackTrace();
					result = 2;
					//CONTINUAR SI SE CAE?
				}				
			}
			return result;
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;	
	}

	@Override
	public Usuario obtenerPorId(String primaryKey) {
		Object result = usuarioDao.findById(primaryKey);
		return result!=null?(Usuario)result:null;
	}
}
