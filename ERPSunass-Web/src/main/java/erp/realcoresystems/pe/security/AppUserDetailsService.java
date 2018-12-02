package erp.realcoresystems.pe.security;

import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.service.*;
import erp.realcoresystems.pe.model.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.server.InicializaGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Log;
import erp.realcoresystems.pe.model.util.Utiles;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


public class AppUserDetailsService implements UserDetailsService {

	/***********/
	private static String UrlBandejaEducativo = "/index.xhtml?faces-redirect=true";
	private static String PAGINA_PREFERENCIAS = "/preferencias.xhtml?faces-redirect=true";
	private static String MISMA_PAGINA = "/login.xhtml?faces-redirect=true";
	private boolean logeado = false;
	private boolean irDirectoPanelPrincipal = false;
	/***********/


	@Autowired
	private UsuarioService usuarioService;


	
	@Autowired 
	private ParametrosMastService parametrosMastService;
	
	@Autowired
    private PersonamastService personaMastService;
	
	@Autowired
    private EmpleadomastService empleadoMastService;
	
	@Autowired
    private CompaniaOwnerService companyownerService;
	
	

	Map<String, String> mapParametrosSys = new HashMap<String, String>();

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		System.out.println("AppUserDetailsService:loadUserByUsername: "
				+ req.getRequestURL());
		String users = (String) req.getParameter("j_username");
		String clave = (String) req.getParameter("j_password");
		String success = (String) req.getParameter("j_loginsuccessful"); // PARÁMETRO SET POR LA VALIDACIÓN
		String idAgente = (String) req.getParameter("j_loginidagente");
		String tipoAgente = (String) req.getParameter("j_logintipoagente");
		String companyowner = (String) req.getParameter("j_logincompanyowner");
		
		logeado = Utiles.SI_db.equals(success) ? true : false;
		System.out.println("LOGUEADO EN SGA WEB PORTAL " + logeado);

		UsuarioSistema user = null;
		String paginaSgt = MISMA_PAGINA;

		if (logeado) {// SOLO SI LA VALIDACIÓN ES CORRECTA
			Usuario objAcceso = new Usuario();
			objAcceso.setUsuario(users);
			
			Usuario login =getUsuarioGeneral(idAgente,users,clave,"DB");
			
			/**Atributos auxiliares*/
			//login.setTipotrabajador(tipoAgente);
			login.setString1(companyowner);//AUX
			
			System.out.println("TEST VALIDO ACTIVE Y CADUCIDAD");
			generarAcceso(login);
					
			/**PARA EL LOGIN LIFE RAY*/
			//if (login.getEmpleado()!=null) rutaUrl=login.getEmpleado();
			//EntityGlobal.getInstance().setVendor(rutaUrl);		
			//EntityGlobal.getInstance().setLifeUsuario("l"+users);		

			/*if (irDirectoPanelPrincipal)
				paginaSgt = UrlBandejaEducativo;
			} else {
				paginaSgt = PAGINA_PREFERENCIAS;
			}*/
			
			/**PARA EL LOGIN ALFRESCO*/
			EntityGlobal.getInstance().setAlfrescoUsuario(users); //OBS
			EntityGlobal.getInstance().setAlfrescoClave(clave);
			//setParametrosAlfresco(users,clave,true);
			/************************************/
			/** SI LAS VALIDACIONES SON CORRECTAS: forzar al SPRING SECURITY */								
			login.setClave(clave);
			logeado = true;
			user = new UsuarioSistema(login, getRoles(login));

		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getRoles(Usuario login) {

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
		/*
		 * for(RolLogin rol : login.getRoles()){ authorities.add(new
		 * SimpleGrantedAuthority(rol.getNombre().toUpperCase())); }
		 */
		return authorities;
	}

	/***/
	public Usuario getUsuarioGeneral(String idAgente,String usuario, String clave,String indica) {
		Usuario objResult = null;
		try{
			if("DB".equals(indica) && idAgente!=null){
				Usuario usuarioLogin = new Usuario();
				usuarioLogin.setUsuario(usuario);
				usuarioLogin.setClave(clave);
//				Integer id  = Integer.parseInt(idAgente);
//				objResult = new Usuario();
//				objResult.setIdAgente(-1);
//				objResult.setCodigoAgente(usuario);
//				objResult.setNombre(usuario);
//				objResult.setClave(clave);
				objResult = usuarioService.obtenerPorId(usuario);
			}else{
				objResult = new Usuario();				
				objResult.setUsuario(usuario);
				objResult.setNombre(usuario);
				objResult.setClave(clave);
				//objResult.setEstado(UtilesCommons.ACTIVO_db);
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return objResult;
	}
	
	/** Generar Accesos */
	public void generarAcceso(Usuario objAcceso) {
		try{		
			EntityGlobal global = new EntityGlobal();
			global.setUsuario(objAcceso.getUsuario());
			/* OBS POR DEFINIR */
			global.setNombreCompleto(objAcceso.getNombre());
			global.setAplicacion(Constant.APLICACION_CODIGO); // OBS HARD CODE
			global.setHostActual(Utiles.HOST_APP); // OBS HARD CODE
			global.setFechaSessionActual(Utiles.getFechaHoy());
			//global.setTipoUsuario(objAcceso.getTipousuario());
			//global.setTipoUsuarioEmpleado(objAcceso.getEmpleado());//PARA DISCERNIR SI ES : DOCENTE , ALUMNO O NO
			
			///////TRATR PERSONA - EMPLEADO ... 
			AbstractGenericBean.setUSUARIO_ACTUAL(global.getUsuario());
			AbstractGenericBean.setAPP_CODIGO(global.getAplicacion());
			AbstractGenericBean.setUNOMBRE_SUARIO_ACTUAL(global.getNombreCompleto());
			
			global.setCodigoCompanyowner(objAcceso.getString1());		//AUX de compania	
			if (UtilesCommons.noEsVacio(objAcceso.getPersona())) {
				/**Guardar el ID de  Persona*/
				AbstractGenericBean.setUSUARIO_EMPLEADO_ID(objAcceso.getPersona().longValue());
				global.setPersona(objAcceso.getPersona());
			}else{
				/**Buscar y Guardar el ID del Empleado,*/
				Empleadomast empleadoFiltro = new Empleadomast();
				empleadoFiltro.setCompaniasocio(objAcceso.getString1());//AUX de compania
				empleadoFiltro.setCodigousuario(global.getUsuario());
				List<Empleadomast> listaEmp =  empleadoMastService.listar(empleadoFiltro);//, false);
				if(UtilesCommons.noEsVacio(listaEmp)){
					/**Se supone que SOLAMENTE DEBERIA HABER un EMPLEADO con este CODIGO DE USUARIO ...*/
					AbstractGenericBean.setUSUARIO_EMPLEADO_ID((long)listaEmp.get(0).getEmpleado());
					global.setPersona(listaEmp.get(0).getEmpleado());					
				}
			}
			/*****SET PARAMETROS CLIENTE*****/		
			InicializaGlobal.InitGlobal(global);
			/**CARGAR VALORES ...**/
			setParametrosSystem(true,null);
			setParametrosCliente();
			cargarAccesosDeSeguridad(objAcceso);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/** Set parámetros generales del SISTEMA a la SESIÓN ACTUAL */
	public void setParametrosSystem(boolean indicaCarga, String companiaCodigo) {
		try{
			//mapParametrosSys = parametrosMastService.listarParametroPorNegocio(Constant.APP_CODIGO,companiaCodigo);
			if(indicaCarga && mapParametrosSys!=null){
				EntityGlobal.getInstance().setMapPropParametros(mapParametrosSys);
			}			
		}catch(Exception ex){
			Log.logger.error("AppUserDetailsService:setParametrosSystem: " + ex);
		}		
	}
	
	
	/** Establece los valores de Alfresco para la Sesión, de acuerdo al usuario Logueado
	 * debe asegurarse su uso, luego de que exista la instancia para nuestro objeto de sesión : EntityGlobal

	 * @param indicaUserActual
	 */
	public void setParametrosAlfresco(String usuario,String clave, boolean indicaUserActual) {
		try{			
			if(indicaUserActual){
				/*String objTicket = cmisAlfrescoService.getTicket(usuario,clave);
				if(objTicket!=null){

				}	*/
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/** Set parámetros generales del CLEINTE la SESIÓN ACTUAL */
	public void setParametrosCliente() {
		try{
			if(EntityGlobal.getInstance()!=null){
				EntityGlobal.getInstance().setIpCliente(Utiles.getIPCliente());
				EntityGlobal.getInstance().setPcNameCliente(Utiles.getPcNombreCliente());	
				EntityGlobal.getInstance().setMacCliente(Utiles.getMacCliente());		
				EntityGlobal.getInstance().setSysVersion(FacesUtil.getPropertyLabels("VERSION"));
				//URL 
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				String url="";			
				if(request!=null){
					url = request.getRequestURL().toString();			
					EntityGlobal.getInstance().setSysUrl(url);		
				}				
			}
		}catch(Exception ex){
			Log.logger.error("AppUserDetailsService:setParametrosCliente: " + ex);
		}	
	}



	public boolean esNecesarioCambioClave(Usuario objValidar,
			String claveIngresada) {
		boolean result = false;
		/*if (Utiles.EST_CAMBIAR_db.equals(objValidar.getSqlpassword())) {
			result = true;
		}*/
		return result;
	}

	/**
	 * Cargar los accesos de seguridad que posee el usuario sea ALUMNO , DOCENTE O ADMINISTRATIVO
	 * 
	 */
	public void cargarAccesosDeSeguridadPortal(Usuario objAcceso) {
		try{	
			//OBS: DATA DE PRUEBA....
			EntityGlobal.getInstance().setCodigoCompanyowner("00000000");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Cargar los accesos de seguridad que posee el usuario y set en la Sesión
	 * (Si poseyera menos de dos opciones)
	 */
	public void cargarAccesosDeSeguridad(Usuario objAcceso) {
		try{
			//COMPANIA DESC
			String companyOwner  = EntityGlobal.getInstance().getCodigoCompanyowner();
			if(UtilesCommons.noEsVacio(companyOwner)){
				Companyowner companiaActual =  companyownerService.obtenerPorId(companyOwner);
				if(companiaActual!=null){
					EntityGlobal.getInstance().setCompanyownerDesc(companiaActual.getDescription());
				}
			}
			
			
			//ES NECESARIO CAMBIO DE CLAVE
			EntityGlobal.getInstance().setFlagObligarcambioClave(Utiles.NO_db);
			
		}catch(Exception ex){
			Log.logger.error("AppUserDetailsService:cargarAccesosDeSeguridad: " + ex);
		}	

	}

}
