package erp.realcoresystems.pe.controller.configuracion;


import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.service.UsuarioService;
import org.primefaces.context.RequestContext;
import erp.realcoresystems.pe.controller.AbstractGenericBean;

import erp.realcoresystems.pe.server.EncriptaKeyService;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name="menuHeaderBeans")
@ViewScoped
public class MenuHeaderBeans implements Serializable{


	/*****Componetes cambio clave***/
	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;

 	private static final String NOMBRE_MAIN_WINDOW = "cambioClaveRegistro";
	public Map<String, Object> optionsWindowPrincipal;
	
	private String claveOriginal;
	private String claveNueva;
	private String claveNuevaRepeticion;	
	private Usuario usuarioCambioClave = null;
	private String lbUsuarioActual = null;
	private boolean visibleCambioClave ;
	
	/*******/
	private static String URL_BANDEJA_INICIO = "../../login.xhtml?faces-redirect=true";
	private Personamast personamastSeleccionada = new Personamast();
	private String opcionSeleccionada="";
	private String sexoDescripcion;
	
	/**ADD PARA ALFRESCO* ******/
	///PARA PARAMETROS CORREO
	private String alfrescoUsuario = EntityGlobal.getInstance().getAlfrescoUsuario();
	private String alfrescoClave = EntityGlobal.getInstance().getAlfrescoClave();
	//private String alfrescoPathServer = FacesUtil.getPropertyParametros("PAR_PATH_ALFRESCO");//PROP WEB

	public void eventPreRender(){
		/**OPCIÓN DE CAMBIO DE CLAVE SÓLO PARA USUARIO EXTERNO*/
		System.out.print("Aquiles MH1 ");
		visibleCambioClave = false;
		if((EntityGlobal.getInstance().getTipoUsuario()+"")
				.equals(FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT"))){
			visibleCambioClave = true;
		}
	}
	public void inicializar(){
		if(!FacesUtil.isPostback()){
			cargarDatosEmpleado();
			System.out.print("AquilesPost ");
			//System.out.print("SI Post " + request.getSession().getAttribute("usuarioActivo"));
		}else {

		}
	}
	
	public void actualizarLoginAlfresco(){
		EntityGlobal.getInstance().setAlfrescoIndicaLogin(true);
	}
	public String cerrarSessionUsuario(){
		//personamastSeleccionada=null;
		personamastSeleccionada = new Personamast();
		EntityGlobal.closeInstance();
		return URL_BANDEJA_INICIO;
	}
	
	/**CARGA LOS VALORES DEL PANEL HEADER*/
	public void btnLoadAction(ActionEvent actionEvent) {
		System.out.print("Aquiles MH2 ");
		if(!FacesUtil.isPostback()){
			cargarDatosEmpleado();			
			//System.out.print("SI Post " + request.getSession().getAttribute("usuarioActivo"));
		}else {
			System.out.print("Cabecera 2 ");
			if (EntityGlobal.getInstance()!=null){
				cargarDatosEmpleado();		
			}else{
				cerrarSessionUsuario();
			}
		}
	}
	public void cargarDatosEmpleado(){
		try {
			//personamastSeleccionada.setNombrecompleto("USUARIO : " + EntityGlobal.getInstance().getNombreCompleto());
			//personamastSeleccionada.setDescripcionCCosto(EntityGlobal.getInstance().getEstablecimiento());
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}

	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}

	public Personamast getPersonamastSeleccionada() {
		return personamastSeleccionada;
	}

	public void setPersonamastSeleccionada(Personamast personamastSeleccionada) {
		this.personamastSeleccionada = personamastSeleccionada;
	}

	public String getSexoDescripcion() {
		return sexoDescripcion;
	}

	public void setSexoDescripcion(String sexoDescripcion) {
		this.sexoDescripcion = sexoDescripcion;
	}
	public static String getUrlBandejaInicio() {
		return URL_BANDEJA_INICIO;
	}

	public static void setUrlBandejaInicio(String urlBandejaInicio) {
		URL_BANDEJA_INICIO = urlBandejaInicio;
	}
	/******/
	
	public void btnCambioClave(ActionEvent actionEven) {		
		if(eventoActivarCambioClave()){
			//System.out.println("ETST CAMBIO CALVE::::");
			optionsWindowPrincipal = new HashMap<String, Object>();
			optionsWindowPrincipal.put("resizable", false);
			optionsWindowPrincipal.put("draggable", true);
			optionsWindowPrincipal.put("modal", true);
			optionsWindowPrincipal.put("contentWidth", 600);
			optionsWindowPrincipal.put("contentHeight", 220);
			RequestContext.getCurrentInstance().openDialog(NOMBRE_MAIN_WINDOW, optionsWindowPrincipal, null);								
		}
	}
	public boolean  eventoActivarCambioClave() {
		EntityGlobal usuario=EntityGlobal.getInstance();
		if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
			usuarioCambioClave = new Usuario();
			usuarioCambioClave.setUsuario(usuario.getUsuario());
			//usuarioCambioClave = 0; usuarioService.obtenerUsuarioID(usuarioCambioClave);
			if (usuarioCambioClave == null) {
				
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noUserValido"));
			} else {
				//captchaVisible = false;
				lbUsuarioActual=""+(usuarioCambioClave.getNombre()+"").trim()+":"+(usuarioCambioClave.getUsuario()+"").trim();
				return true;
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noUserIngresado"));
		}
		return false;
	}
	
	public void eventoCancelarCambioClave() {
		claveOriginal = null;
		claveNueva = null;
		claveNuevaRepeticion = null;				
	}
	public void eventoGuardarCambioClave() {
		String mensaje = "";
		boolean correcto = false;
		boolean claveVacia = false;
		if(usuarioCambioClave.getClave()!=null){
			if(usuarioCambioClave.getClave().length()==0){
				claveVacia=true;
			}
		}else{
			claveVacia=true;
		}
		if(claveVacia){
			if(claveOriginal!=null){
				if(claveOriginal.length()==0){
					if (claveNueva != null && claveNuevaRepeticion != null && !"".equals(claveNueva)
							&& !"".equals(claveNuevaRepeticion)) {
						if (claveNueva.equals(claveNuevaRepeticion)) {
							correcto = true;
						} else {
							mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noCoincidenClaveNueva");
						}
					} else {
						mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noClaveNuevaRep");
					}										
				}else{
					correcto = false;
				}
			}else{
				correcto = true;
			}
		}else{			
			boolean continuar =true;
			String paramMinLongClave = getParametroMinimoLongClaves();
			int minimoLong = Integer.parseInt(paramMinLongClave);
			if(minimoLong>0){				
				if((claveNueva+"").trim().length()< minimoLong){
					continuar = false;		
					mensaje = FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_longMinimaClave") + "("+minimoLong+")";					
				}
			}	
			if(continuar){
				String claveOriginalDescifrada = EncriptaKeyService.getDescifrado(usuarioCambioClave.getClave());
				//if (claveOriginal != null && !"".equals(claveOriginal)) {
					if ((claveOriginalDescifrada+"").equals(claveOriginal)) {
						if (claveNueva != null && claveNuevaRepeticion != null && !"".equals(claveNueva)
								&& !"".equals(claveNuevaRepeticion)) {
							if (claveNueva.equals(claveNuevaRepeticion)) {
								correcto = true;
							} else {
								mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noCoincidenClaveNueva");
							}
						} else {
							mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noClaveNuevaRep");
						}
					} else {
						mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noCoincidenClaveOrig");
					}
				//} else {
				//	mensaje = FacesUtil.getMSJProperty("MSJ_WARN_noClaveOrig");
				//}		
			}		
		}
		

		if (correcto) {
			//captchaVisible = true;			
			if (usuarioCambioClave != null) {
				Date fecha = new Date();
				String claveCifrada = EncriptaKeyService.getCifrado(claveNueva);
				usuarioCambioClave.setClave(claveCifrada);
				//usuarioCambioClave.setUsuarioEntGlobal(usuarioCambioClave.getUsuario());
				//usuarioCambioClave.setUltimousuario(usuarioCambioClave.getUsuario());
				//usuarioCambioClave.setUltimafechamodif(new Timestamp(fecha.getTime()));
				int result = 0;//usuarioService.guardarUsuario(usuarioCambioClave);
				if (result > 0) {					
					RequestContext.getCurrentInstance().closeDialog(usuarioCambioClave);		
					// model = buscarPrincipal();
					usuarioCambioClave = null;					
					FacesUtil.jsMensajePropiedades("MSJ_INFO_cambioClaveCorrecto", AbstractGenericBean.SUCCESS);
				} else {					
					correcto = false;					
					FacesUtil.jsMensajePropiedades("MSJ_ERROR_noUpdateCorrecto", AbstractGenericBean.WARN);
				}
			} else {

			}
		} else {
			FacesUtil.adicionarMensajeWarning(mensaje);
		}

	}
	public String getParametroMinimoLongClaves() {
		String param = EntityGlobal.getInstance()
				.getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_MIN_LONGPERM_CLAVE"));
		if(param == null){
			param = "1";
		}			
		return param;
	}

	public void btnCancelar(ActionEvent actionEvent) {
		RequestContext.getCurrentInstance().closeDialog(usuarioCambioClave);		
		// model = buscarPrincipal();
		usuarioCambioClave = null;
	}
	


	public String getClaveOriginal() {
		return claveOriginal;
	}

	public void setClaveOriginal(String claveOriginal) {
		this.claveOriginal = claveOriginal;
	}

	public String getClaveNueva() {
		return claveNueva;
	}

	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}

	public String getClaveNuevaRepeticion() {
		return claveNuevaRepeticion;
	}

	public void setClaveNuevaRepeticion(String claveNuevaRepeticion) {
		this.claveNuevaRepeticion = claveNuevaRepeticion;
	}

	public Usuario getUsuarioCambioClave() {
		return usuarioCambioClave;
	}

	public void setUsuarioCambioClave(Usuario usuarioCambioClave) {
		this.usuarioCambioClave = usuarioCambioClave;
	}

	public String getLbUsuarioActual() {
		return lbUsuarioActual;
	}

	public void setLbUsuarioActual(String lbUsuarioActual) {
		this.lbUsuarioActual = lbUsuarioActual;
	}

	public boolean isVisibleCambioClave() {
		return visibleCambioClave;
	}

	public void setVisibleCambioClave(boolean visibleCambioClave) {
		this.visibleCambioClave = visibleCambioClave;
	}	
	
	/***/
	public void  accionCerrarSesion(){
		//System.out.println("AAAAAAAAAAAAA");
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("saUsuariomantenimientoBeans");
		//System.out.println("BBBBBBBBBB");
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public String getAlfrescoUsuario() {
		return alfrescoUsuario;
	}
	public void setAlfrescoUsuario(String alfrescoUsuario) {
		this.alfrescoUsuario = alfrescoUsuario;
	}
	public String getAlfrescoClave() {
		return alfrescoClave;
	}
	public void setAlfrescoClave(String alfrescoClave) {
		this.alfrescoClave = alfrescoClave;
	}

	
}
