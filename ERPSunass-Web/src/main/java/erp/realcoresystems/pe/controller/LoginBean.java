package erp.realcoresystems.pe.controller;



import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.EncriptaKeyService;
import erp.realcoresystems.pe.service.PersonamastService;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;
import org.primefaces.context.RequestContext;

import erp.realcoresystems.pe.commons.UtilesCommons;

//import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.server.Captcha;
import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
//import erp.realcoresystems.pe.model.util.Log;

import erp.realcoresystems.pe.model.util.Utiles;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;


	private static final String USER_DEFAULT = "admin";

	@ManagedProperty(value="#{personamastService}")
	private PersonamastService personamastService;

	@ManagedProperty(value="#{encriptaKeyService}")
	private EncriptaKeyService encriptaKeyService;

	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value="#{companiaOwnerService}")
	private CompaniaOwnerService companiaOwnerService;

	private String email;
	private String clave;
	private String claveAuxiliar;
	private String tipodocumento;

	private boolean captchaVisible = false;

	private static String VARIABLE_CAPTCHA="realPerson";

	private String messageAlertFood = "";
	private String messageFinal = "";

	private String varTipoDocumento = null;
	private String varUsuarioDef = null;
	private String varTipoMsgNotif = null;

	private boolean logeado = false;
	private String flagLogin = "NO";
	private Captcha captcha;
	private boolean cargarCaptcha = true;

	/**ADD para HCE*/
	private Integer idAgenteTemp ;

	/**ADD SEGURIDAD COMPANIA : Solo algunos modulos */
	private boolean indicaVisibleCompaniaSeguridad;
	private String companyownerSelected;
	private List<Companyowner>  listaCompanyowner;

	@PostConstruct
	public void init(){
		inicializarVariables();
		cargarParametrosSystem("",true);
		if(mapParametrosSys.containsKey(FacesUtil.getPropertyParametros("PAR_MOSTRARCAPTCHA"))){
			if(Utiles.SI_db.equals(mapParametrosSys.get(FacesUtil.getPropertyParametros("PAR_MOSTRARCAPTCHA")))){
				captchaVisible=true;
			}else{
				captchaVisible=false;
			}
		}else{
			captchaVisible=false;
		}
	}

	/**Evento de inicialización de los valores de la página del Login*/
	public void preRender(){
		System.out.println("INICIO PRE RENDER LOGIN ...");
		if(cargarCaptcha){
			captcha = new Captcha(VARIABLE_CAPTCHA);//AUX CONSTRUCTOR REAL PERSON
			cargarCaptcha=false;
		}
		inicializarVariables();
		//cargarParametrosURL();
	}

	/**
	 * Iniciar Valores de las Variables Principales del Login
	 */
	public void inicializarVariables(){
		email=null;
		clave=null;
		listaCompanyowner = new ArrayList<>();
		claveAuxiliar = null;
		indicaVisibleCompaniaSeguridad = true;
		companyownerSelected = null;
		idAgenteTemp = null;
	}

	/**De recibir parámetros por la URL, se recepciona en este método*/
	public void cargarParametrosURL(){
		try{
			if(varTipoDocumento!=null){
				tipodocumento = varTipoDocumento;
			}
			if(varUsuarioDef!=null){
				email = varUsuarioDef;
				//GET CLAVE

			}
			messageAlertFood = "";
			if(varTipoMsgNotif!=null){
				if(varTipoMsgNotif.equals("A")){
					//NUEVA CUENTA
					messageAlertFood = FacesUtil.getMSJProperty("MSJ_INFO_CUENTACREADA_VERCORREO");
				}else if(varTipoMsgNotif.equals("B")){
					//CUENTA EXISTENTE
					messageAlertFood = FacesUtil.getMSJProperty("MSJ_INFO_CUENTAEXISTENTE_VERCORREO");
				}
			}


		}catch(Exception ex){

		}
	}
	/**Evento de previo a la autenticación. Esto incluye las validaciones neecsarias.*/
	public void btnPreLogin(){
		try{

			logeado = validacionLogin(this.getEmail(), this.getClave());
			if(logeado){
				RequestContext.getCurrentInstance().execute("doLogin();");
				messageAlertFood = null;
				claveAuxiliar = this.getClave();
			}
			//nuevoCaptcha();
			//RequestContext context = RequestContext.getCurrentInstance();
			//context.addCallbackParam("estaLogeado", logeado);
		}catch(Exception ex){
			RequestContext context = RequestContext.getCurrentInstance();
			context.addCallbackParam("estaLogeado", false);
			FacesUtil.adicionarMensajeError("Ocurrió un error Inesperado");
			ex.printStackTrace();
		}
	}
	/**Método que indica si el usuario está logueado correctamete (Invocado desde JS)*/
	public boolean estaLogeado() {
		return logeado;
	}

	/**Método correspondiente a la concretización del Login. Llamar al Servlet de Seguridad con el Spring Security*/
	public String doLogin() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		String paramSusces = Utiles.NO_db;
		if(logeado){
			//if(true){
			paramSusces = Utiles.SI_db;
		}
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check?j_username=" + email
						+ "&j_password=" + claveAuxiliar
						+ "&j_loginsuccessful=" + paramSusces
						+ "&j_loginidagente=" + idAgenteTemp
						+ "&j_logintipoagente=" +  this.getTipodocumento()
						+ "&j_logincompanyowner=" +  companyownerSelected


				);
		try{
			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();
		}catch(Exception ex){
			ex.printStackTrace();
		}

		this.setEmail(null);
		return null;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	/****AGREGADOS****/

	private Usuario usuarioSinLogin = null;
	Map<String,String> mapParametrosSys = new HashMap<String,String>();

	/**evento al cambio del USARIO*/
	public void eventoCambioUsuario() {
		try{
			if(indicaVisibleCompaniaSeguridad){
				eventoValidaCompaniaSeguridad();
			}
			messageAlertFood="";
			/*
			usuarioSinLogin=null;
			if (email!= null && !"".equals(email)) {
				Usuario objFiltro = new Usuario();
				objFiltro.setUsuario(email);
				usuarioSinLogin =  usuarioService.obtenerPorId(objFiltro);
			}
			eventoValidarCaducidad();*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**validación de la caducidad de la cuenta de USUARIOS EXTERNOS*/
	public void eventoValidaCompaniaSeguridad() {
		try{
			if(listaCompanyowner!=null){
				listaCompanyowner.clear();
			}
			if(UtilesCommons.noEsVacio(email)){
				Companyowner filtro = new Companyowner();
				listaCompanyowner = companiaOwnerService.listarSeguridad(filtro, email);
				if(UtilesCommons.noEsVacio(listaCompanyowner)){
					companyownerSelected = listaCompanyowner.get(0).getCompanyowner();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**validación de la caducidad de la cuenta de USUARIOS EXTERNOS*/
	public void eventoValidarCaducidad() {
		try{
			/**Por implementar*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**RECUPERACIóN DE CLAVE*/
	public void btnRecuperarClave() {
		if (email != null && !"".equals(email)) {
			if(usuarioSinLogin!=null){
				//if(usuarioSinLogin.getPersona()!=null){
				if(false){//OBS::
					//si es EXTERNO envío para el correo del USUARIO
					/**#A.1 .- obtenemos la persona del usuario y el correo asociado con esta persona*/
					Personamast objPersona = new Personamast();
					//objPersona.setPersona(usuarioSinLogin.getPersona());
					//objPersona = personamastService.obtenerPorId(objPersona.getPersona());
					if(objPersona!=null){
						/*
						String claveNueva = encriptaKeyService.getKeyGenerado_Cifrado(false);
						if(usuarioSinLogin!=null){
							usuarioSinLogin.setClave(encriptaKeyService.getCifrado(claveNueva));
							usuarioSinLogin.setUltimoUsuario(email);
							usuarioSinLogin.setUltimaFechaModif(new Date());
							int result = usuarioService.actualizar(usuarioSinLogin);
							if(result>0){
								if(enviarCorreoUser(objPersona, claveNueva)){
								}
							}
						}	*/
					}else{
						FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_WARN_RecClave_noPersonaAsociada"));
					}
				}else{
				}
			}else{
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noUserValido"));
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noUserIngresado"));
		}
	}

	/**Enviar correo al usuario Exteno creado*/
	public boolean enviarCorreoUser(Personamast objSave,String claveUsuario) {
		boolean result =false;
		try{
			if(objSave!=null){
				/**1: CORREOS DESTINOS */
				List<String> correosTemp = new ArrayList<String>();
				if(objSave.getCorreoElectronico()!=null){
					correosTemp.add(objSave.getCorreoElectronico());
				}
				/**2: set PARAMETROS VARIABLES EN UN MAP, PARA EL BODY, Y SUBJETC*/
				//VARIABLES
				Map<String,String> mapVariables = new HashMap<String,String>();
				mapVariables.put(FacesUtil.getPropertyCorreo("PAR_NOMBRE_DESTINO"), objSave.getNombrecompleto());
				mapVariables.put(FacesUtil.getPropertyCorreo("PAR_USUARIO"), objSave.getDocumento());
				mapVariables.put(FacesUtil.getPropertyCorreo("PAR_VALOR_CLAVE_AUTOGEN"),claveUsuario);
				mapVariables.put(FacesUtil.getPropertyCorreo("PAR_NOMBRE_SYS"),"SISTEMA DE CITAS WEB");
				//mapVariables.put(FacesUtil.getPropertyCorreo("PAR_FECHA_ACTUAL"),
				//	UtilesCommons.printDate("dd/MM/yyyy", UtilesCommons.getFechaHoy()));
				//SUBJECT
				String subject = FacesUtil.getMSJProperty("MSJ_USUARIO_CORREOREGISTRO_SUBJECT");
				//BODY AUX
				String info = FacesUtil.getMSJProperty("MSJ_USUARIO_CORREOREGISTRO_BODY");
				String formattedInfo = MessageFormat.format(info,objSave.getNombrecompleto(),
						"SISTEMA DE CITAS WEB",objSave.getDocumento(),
						claveUsuario);
				String body = formattedInfo;


				/**3: ENVIO CORREOS */
				/*int reusltMsg = emailGenericService.enviarCorreo(
								//ARMAR OBJETO GENÉRICO PARA CORREO: EMAIL e INDICAR SI POSEE O NO PLANTILLA DE CORREOS
									emailGenericService.getObjetoMail(
											correosTemp, subject, body,
											null, UtilesCommons.getFechaHoy()
											,mapVariables
									),
								//ENVIAR EL CÓDIGO DEL PORCESO
								FacesUtil.getPropertyCorreo("PROC_RECUP_CLAVE")
						);
				*/

				/**4: MOSTRAR MENSAJES */
				switch (1){
					case 1: FacesUtil.mensajeInfoPropiedades("MSJ_INFO_USAURIO_correoSucces_UserExt");
						result = true;
						break;
					case 0: FacesUtil.mensajeErrorPropiedades("MSJ_WARN_USAURIO_correoFail_UserExt");
						break;
					case -1: FacesUtil.mensajeWarningPropiedades("MSJ_WARN_CORREO_plantillaNoValida");
						break;
					case -2: FacesUtil.mensajeWarningPropiedades("MSJ_WARN_CORREO_correosNoValidos");
						break;
					case -3: FacesUtil.mensajeWarningPropiedades("MSJ_WARN_CORREO_subjectNoValido");
						break;
					case -4: FacesUtil.mensajeErrorPropiedades("MSJ_ERROR_CORREO_falloCreacionEmail");
						break;
					case -5: FacesUtil.mensajeErrorPropiedades("MSJ_ERROR_CORREO_falloEnvioEmail");
						break;
				}
			}else{
				FacesUtil.mensajeWarningPropiedades("MSJ_WARN_RecClave_noPersonaAsociada");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	/**Sección que se encarga de preparar el Email y enviarlo*/
	public void seccionPrepararEnviarCorreo(boolean esExterno,Personamast objPersona,Map<String,String> mapvariablesValores,
											String procTarea, String msjWarnProcTarea ) {
		String correoUser=null;
		String destinoAux =null;

		correoUser = destinoAux;
		if(correoUser!=null && !"".equals(correoUser+"")){
			/**#A.2 .- Obtenemos la plantilla asociada con esta TAREA */
			//String procTarea = FacesUtil.getPropertyCorreo("PROC_RECUP_CONTRASENA_EXT");
			MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
			obj.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			obj.setCompania(Constant.COMPANIA_VARIABLE);
			obj.setCodigotabla("PTCORREO");
			//obj.setValorcodigo1(procTarea);
			//obj.setEstado(Utiles.ACTIVO_db);
			List<MaMiscelaneosdetalle> listaPlant = null;//maMiscelaneosdetalleService.listarElementos(obj);
			if(listaPlant!=null){
				if(listaPlant.size()>0){
					String PlantillaCorreo ="";
					//POR DEFECTO EL PRIMERO
					/*
					PlantillaCorreo = listaPlant.get(0).getDescripcionextranjera();
					//#A.X .- creamos el objeto Email (se reemplazarán las variables por sus valores)
					String [] destino = {correoUser};
					Email email = EmailService.construirMail(destino,
							listaPlant.get(0).getValorcodigo2(),
							PlantillaCorreo,
							null,
							Utiles.getFechaHoy(),
							mapvariablesValores);
					//Se puede agregar más correos destinos al objeto email o set otros parámetros.
					email = EmailService.setEmailVariablesGenerales(email);
					if(email!=null){

						if(EmailService.sendMail(Utiles.SI_db,email)){

							String tipoExt = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT");
							if(usuarioSinLogin!=null){
							}
							if(tipoExt.equals(usuarioSinLogin.getSQLLogin()+"")){
								FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_RecClaveCorrectoEnvioCorreo"));
							}else{
								FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_RecClaveCorrectoEnvioCorreoInt"));
							}

						}else{
							FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_WARN_RecClaveNoEnvioCorreo"));
						}
					}*/
				}else{
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty(msjWarnProcTarea));
				}
			}
		}else{
			FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_WARN_RecClave_noCorreoAsociado"));
		}
	}
	/**Generar la nueva clave (IMPLE ALGORITMO) y obtenerla*/
	/*public String getClaveNuevaGenerada(String indica){
		String clave =encriptaKeyService.getKeyGenerado_Cifrado(false);;
		///
		return clave;
	}*/

	/** Set parámetros generales del SISTEMA a la SESIÓN ACTUAL*/
	public void setParametrosSystem(boolean indicaCarga){
		if(indicaCarga && mapParametrosSys!=null){
			EntityGlobal.getInstance().setMapPropParametros(mapParametrosSys);
		}
	}
	/** Cargar parámetros generales del SISTEMA*/
	public void cargarParametrosSystem(String tipo, boolean indicaCarga){
		if(indicaCarga){
			/***** OBS:  TRAER PARAMETROS DE LA BASE DE DATOS ******/

			mapParametrosSys = new HashMap<String,String>();
			if(true){
				/******/

				/******/
			}
			/*********************************************************/
			/*******CARGAR PARÁMETROS DE CORREO**************/
			try{
				MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
				obj.setAplicacioncodigo(Constant.APLICACION_CODIGO);
				obj.setCompania(Constant.COMPANIA_VARIABLE);
				obj.setCodigotabla("PAR_EMAIL");//
				//obj.setEstado(Utiles.ACTIVO_db);
				List<MaMiscelaneosdetalle> listaPlant = null;//MaMiscelaneosDetalle.listarElementos(obj);
				if(listaPlant!=null){
					if(listaPlant.size()==1){
						/**OBS */

					}else{

					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			/*********************************************************/
		}
	}

	public String getFlagLogin() {
		return flagLogin;
	}

	public void setFlagLogin(String flagLogin) {
		this.flagLogin = flagLogin;
	}
	/**ADD  VALIDACIONES DEL PRE LOGIN*/
	public boolean validacionLogin(String users,String clave){
		System.out.println("Intentando Loguearse --> user : " + users);

		Usuario login = validarPreAcceso(users,clave);
		/*
		if(login==null){
			login = validarPreAccesoAlfresco(users,clave);
		}
		 */
		//Usuario login = validarPreAccesoAlfresco(users,clave);
		logeado = false;
		boolean msgSoloAdvertencia = true;
		if ( login!= null) {

			if(validarCaptcha()
					&& validarCompania()
					){
				//LOGICA ADICIONAL
				logeado = true;
				if(logeado){
					messageFinal = FacesUtil.getMSJProperty("MSJ_INFO_loginCorrecto") +" " +login.getNombre();
					idAgenteTemp = login.getPersona();
					email = login.getUsuario();
					//return logeado;
				}else{
					//nuevoCaptcha();
				}
			}else{
				msgSoloAdvertencia = false;
			}
		} else {
			msgSoloAdvertencia = false;
			messageFinal = FacesUtil.getMSJProperty("MSJ_WARN_loginIncorrecto");
		}

		if(logeado){
			FacesUtil.adicionarMensajeInfo(messageFinal);
		}else{
			if(UtilesCommons.noEsVacio(messageFinal)){
				if(msgSoloAdvertencia){
					FacesUtil.adicionarMensajeWarning(messageFinal);
				}else{
					FacesUtil.adicionarMensajeError(messageFinal);
				}
			}
		}
		return logeado;
	}

	/** Obtener el USUARIO DE ACCESO*/
	public Usuario validarPreAccesoAlfresco(String usuario, String clave) {
		Usuario objResult = null;
		try{
			//OBTENENMOS UN TICKET DEL SERVIDOR DE ALFRESOC PARA COMPROBAR LA VALIDEZ DEL USUARIO

			/*String objTicket = cmisAlfrescoService.getTicket(usuario,clave);
			if(objTicket!=null){
				objResult = getUsuarioGeneral(usuario, clave, "ALFRESCO");
			}*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return objResult;
	}
	public Usuario getUsuarioGeneral(String usuario, String clave,String indica) {
		Usuario objResult = null;
		try{
			objResult = new Usuario();
			objResult.setUsuario(usuario);//OBS ***
			objResult.setClave(clave);
			//objResult.setEstado(UtilesCommons.ACTIVO_db);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return objResult;
	}

	/** Obtener el USUARIO DE ACCESO*/
	public Usuario validarPreAcceso(String usuario, String clave) {
		if(clave==null){
			clave ="";
		}
		return usuarioService.validarLogin(usuario,encriptaKeyService.getCifrado(clave));
//		Usuario objVerif = new Usuario();
//		objVerif.setUsuario(usuario);
//		objVerif.setClave(clave);
//		//objVerif.setIdAgente(1);
//		return objVerif; ///*****OBS SE RETORNA SIN SEGURIDAD

	}
	/**Método que indica si el usuario está logueado correctamete (Invocado desde JS)*/
	public boolean setIntentosLoginUsados(Usuario userLogin, boolean loginSucces) {
		boolean result =false;
		if(userLogin!=null){
			if(!loginSucces){

			}
		}
		return result;
	}
	public boolean enviarCorreoBloqueoCuenta(Usuario login) {
		boolean result = false;
		try{
			/*********PARA EL USUARIO****************/
			/**1: set PARAMETROS VARIABLES EN UN MAP*/
			List<String> paramCorreos = new ArrayList<String>();
			String procesoTareaEnvioCorreo =  FacesUtil.getPropertyCorreo("PROC_BLOQ_CTA_NOTIFUSER");
			if(procesoTareaEnvioCorreo!=null){
				//procesoTareaEnvioCorreo = FacesUtil.getPropertyCorreo("PROC_CREAR_USER_EXT");

			}
			if(paramCorreos.size()==2){

			}
			/*********PARA ADMINSITRADOR*******************/
			paramCorreos.clear();
			procesoTareaEnvioCorreo =  FacesUtil.getPropertyCorreo("PROC_BLOQ_CTA_NOTIFADMIN");
			if(procesoTareaEnvioCorreo!=null){
				//procesoTareaEnvioCorreo = FacesUtil.getPropertyCorreo("PROC_CREAR_USER_EXT");
				MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
				obj.setAplicacioncodigo(Constant.APLICACION_CODIGO);
				obj.setCompania(Constant.COMPANIA_VARIABLE);
				obj.setCodigotabla("PTCORREO");
				obj.setCodigoelemento(procesoTareaEnvioCorreo);
				//obj.setEstado(Utiles.ACTIVO_db);
				/*List<MaMiscelaneosDetalle> listaPlant = maMiscelaneosdetalleService.listarElementos(obj);
				if(listaPlant!=null){
					if(listaPlant.size()>0){
						//POR DEFECTO EL PRIMERO
						paramCorreos.add(listaPlant.get(0).getDescripcionextranjera());
						paramCorreos.add(listaPlant.get(0).getValorcodigo2());
					}
				}	*/
			}
			if(paramCorreos.size()==2){
				System.out.println("TEST CORREO ADMIN::AAAAA:"+paramCorreos.size());
				/**2: set CORREOS DESTINO*/
				String idPersonaAdmin =  mapParametrosSys.get(FacesUtil.getPropertyParametros("PAR_ADMINISTRADORSYS"));
				if(idPersonaAdmin!=null & !"".equals(idPersonaAdmin+"")){
					System.out.println("TEST CORREO ADMIN::BBB:"+idPersonaAdmin);
					Personamast objPersona = new Personamast();

				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	/**Método que indica si el usuario está logueado correctamete (Invocado desde JS)*/
	public boolean validarIntentosPermitidos(Usuario login) {
		boolean result =true;
		String parIntPermitidos =  mapParametrosSys.get(FacesUtil.getPropertyParametros("PAR_LONGIN_INTENTOSPERM"));
		if(parIntPermitidos!=null){
			//if(Utiles.BLOQUEADO_db.equals((""+login.getSqllogin()).trim())){
			//	result =false;
			//	}
		}
		return result;
	}
	/**método para validar vía WEB SERVICE o otro recurso EXTERNO el usuario con el usuario del Active Directory del dominio*/
	public boolean validarUsuarioInternoActiveDirectory(Usuario objValidar,String claveIngresada) {
		boolean result = true;
		if(Utiles.ACTIVO_db.equals(objValidar.getEstado())){
			//SERVICIO PARA UTILIZAR ACTIVE DIRECTORY

		}else{
			result = false;
			messageFinal = FacesUtil.getMSJProperty("MSJ_WARN_login_UsuarioNoActivo");
		}
		return result;
	}

	/** Validar Compnia seguridad, si fuera necesario
	 * @return
	 */
	public boolean validarCompania() {
		boolean result = true;
		if(indicaVisibleCompaniaSeguridad){
			if(UtilesCommons.esVacio(companyownerSelected)){
				result = false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_login_noCompaniaSeleccionada"));
			}
		}
		return result;
	}

	/**VALIDACIOES DEL USUARIO EXTERNO*/
	public boolean validarUsuarioExterno(Usuario objValidar, String claveIngresada) {
		boolean result = true;
		//try{
		if(Utiles.ACTIVO_db.equals(objValidar.getEstado())){
			boolean claveVacia=false;
			//String claveDescifrada=encriptaKeyService.getDescifrado(objValidar.getClave());
			String claveDescifrada=objValidar.getClave();
			if(claveDescifrada!=null){
				if(claveDescifrada.length()==0){
					claveVacia=true;
				}
			}else{
				claveVacia=true;
			}
			if(claveVacia){
				if(claveIngresada!=null){
					if(claveIngresada.length()>0){
						result=false;
					}
				}
			}else{
				if((""+claveIngresada).equals(claveDescifrada)){
					///CORRECTO
					result=true;
				}else{
					result=false;
				}
			}
			if(result){//CONTINUAR VALIDACIONES

			}else{
				//CONTRAEÑA ERRÓNEA
				result = false;
				messageFinal = FacesUtil.getMSJProperty("MSJ_WARN_loginClaveIncorrecta");
			}
		}else{
			result = false;
			messageFinal = FacesUtil.getMSJProperty("MSJ_WARN_login_UsuarioNoActivo");
		}
		//}catch(Exception ex){
		//ex.printStackTrace();
		//}
		return result;
	}

	/**ADD*/

	private static String URL_REGISTRO_NUEVOUSUARIO= "/vistas/externos/registroNuevoPaciente.xhtml?faces-redirect=true";


	public void onSelectDoc() {


	}
	public void btnRegistroUsuario() {

		FacesUtil.redirect(URL_REGISTRO_NUEVOUSUARIO);
	}

	/****************************************/


	public String getMessageAlertFood() {
		return messageAlertFood;
	}

	public void setMessageAlertFood(String messageAlertFood) {
		this.messageAlertFood = messageAlertFood;
	}



	/**********CAPTCHA***************/
	public boolean validarCaptcha() {
		boolean result =  false;
		if(captchaVisible){
			if (captcha.isValidCaptchaRealPerson()) {
				return true;
			}else{
				result = false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_ERROR_login_LDAP_CAPTCHA_noCodigo"));
			}
			/**OTRA OPCION*/
			/*if (captcha.isValidCaptcha()) {
				return true;
			}*/
		}else{
			result =  true;
		}
		return result;
	}


	//CAPTCHA METODO NO USADO
	/*
	public void nuevoCaptcha() {
		try {
			//welcomeMessage = null;
			if(captchaVisible){
				captcha.refrescarCaptcha();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//log.error("Error generando captcha: " + e.getMessage());
		}
	}*/

	public boolean isCaptchaVisible() {
		return captchaVisible;
	}

	public void setCaptchaVisible(boolean captchaVisible) {
		this.captchaVisible = captchaVisible;
	}

	public Captcha getCaptcha() {
		return captcha;
	}

	public void setCaptcha(Captcha captcha) {
		this.captcha = captcha;
	}

	//CAPTCHA IMAGE NO USADO
	/*
	public StreamedContent getImageCaptcha() {
		if(captcha!=null){
			imageCaptcha  = new DefaultStreamedContent(new ByteArrayInputStream(captcha.getCaptchaImage()));
		}else{
			imageCaptcha = new DefaultStreamedContent();
		}
		return imageCaptcha;
	}
	public void setImageCaptcha(StreamedContent imageCaptcha) {
		this.imageCaptcha = imageCaptcha;
	}	*/

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}



	public String getVarTipoDocumento() {
		return varTipoDocumento;
	}

	public void setVarTipoDocumento(String varTipoDocumento) {
		this.varTipoDocumento = varTipoDocumento;
	}

	public String getVarUsuarioDef() {
		return varUsuarioDef;
	}

	public void setVarUsuarioDef(String varUsuarioDef) {
		this.varUsuarioDef = varUsuarioDef;
	}

	public String getVarTipoMsgNotif() {
		return varTipoMsgNotif;
	}

	public void setVarTipoMsgNotif(String varTipoMsgNotif) {
		this.varTipoMsgNotif = varTipoMsgNotif;
	}


	public PersonamastService getPersonamastService() {
		return personamastService;
	}

	public void setPersonamastService(PersonamastService personamastService) {
		this.personamastService = personamastService;
	}


	public String getClaveAuxiliar() {
		return claveAuxiliar;
	}

	public void setClaveAuxiliar(String claveAuxiliar) {
		this.claveAuxiliar = claveAuxiliar;
	}

	public void setEncriptaKeyService(EncriptaKeyService encriptaKeyService) {
		this.encriptaKeyService = encriptaKeyService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Integer getIdAgenteTemp() {
		return idAgenteTemp;
	}

	public void setIdAgenteTemp(Integer idAgenteTemp) {
		this.idAgenteTemp = idAgenteTemp;
	}

	public boolean isIndicaVisibleCompaniaSeguridad() {
		return indicaVisibleCompaniaSeguridad;
	}

	public void setIndicaVisibleCompaniaSeguridad(boolean indicaVisibleCompaniaSeguridad) {
		this.indicaVisibleCompaniaSeguridad = indicaVisibleCompaniaSeguridad;
	}

	public String getCompanyownerSelected() {
		return companyownerSelected;
	}

	public void setCompanyownerSelected(String companyownerSelected) {
		this.companyownerSelected = companyownerSelected;
	}

	public List<Companyowner> getListaCompanyowner() {
		return listaCompanyowner;
	}

	public void setListaCompanyowner(List<Companyowner> listaCompanyowner) {
		this.listaCompanyowner = listaCompanyowner;
	}


	public CompaniaOwnerService getCompaniaOwnerService() {
		return companiaOwnerService;
	}

	public void setCompaniaOwnerService(CompaniaOwnerService companiaOwnerService) {
		this.companiaOwnerService = companiaOwnerService;
	}

}
