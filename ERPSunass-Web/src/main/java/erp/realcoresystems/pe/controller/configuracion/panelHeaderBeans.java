package erp.realcoresystems.pe.controller.configuracion;


import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.Usuario;
import org.primefaces.context.RequestContext;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;

import erp.realcoresystems.pe.server.EncriptaKeyService;
import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
@ManagedBean(name = "panelHeaderBeans", eager = true)
@ViewScoped
public class panelHeaderBeans implements Serializable{


	//@Autowired
	//private UsuarioService usuarioService;
	
	private String dlgAutorizarCajero = FacesUtil.VAR_DIALOG_LOGIN_CAJERO;	
	
	private static final String NOMBRE_MAIN_WINDOW = "cambioClaveRegistro";
	public Map<String, Object> optionsWindowPrincipal;
	
	private String claveOriginal;
	private String claveNueva;
	private String claveNuevaRepeticion;	
	private Usuario usuarioCambioClave = null;
	private String lbUsuarioActual = null;
	private boolean visibleCambioClave ;
	
	/*****Componentes PROEPRTIES  SYS***/
	private String nombreTipoUsuario;	
	private String lbFechaPrincipal;
	private String lbCompaniaDesc;
	private String lbEstablecimientoDesc;
	private String lbModalidadEstudioDesc;

	private String lbTerminal;
	
	private String nombreCajero;
	private Integer idCajero;
	
	private String nombrePaciente;
	
	private String fechaBuild;
	private String versionBuild;

	
	/*******/
	private static String URL_BANDEJA_INICIO = "../../login.xhtml?faces-redirect=true";
	private Personamast personamastSeleccionada = new Personamast();
	private String opcionSeleccionada="";
	private String sexoDescripcion;
	
	
	public void eventPreRender(){
		/**OPCIÓN DE CAMBIO DE CLAVE SÓLO PARA USUARIO EXTERNO*/
		visibleCambioClave = false;
		if((EntityGlobal.getInstance().getTipoUsuario()+"")
				.equals(FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT"))){
			visibleCambioClave = true;
		}
	}
	
	@PostConstruct
	public void postconstruct() {
		//System.out.println("[INFO TEST ENCUESTA postconstruct.....]");
	
		cargarDatosEmpleado();
	}

	public String cerrarSessionUsuario(){
		//personamastSeleccionada=null;
		personamastSeleccionada = new Personamast();
		EntityGlobal.closeInstance();
		return URL_BANDEJA_INICIO;
	}
	
	public String calcularShowEdad(Date fechaNac){
		int edadNum = 0;
		if(fechaNac!=null){
			int agnoFecNac = TimeCommons.getAnio(fechaNac);
			int mesFecNac = TimeCommons.getMes(fechaNac);
			int diaFecNac = TimeCommons.getDia(fechaNac);
			
			Date fechaActual = new Date();
			int agnoActual = TimeCommons.getAnio(fechaActual);
			int mesActual = TimeCommons.getMes(fechaActual);
			int diaActual = TimeCommons.getDia(fechaActual);
			
			
			if(agnoActual > agnoFecNac){
				edadNum = agnoActual - agnoFecNac;
				if(mesFecNac > mesActual){			
					edadNum = edadNum - 1;
				}else if(mesFecNac == mesActual){
					if(diaFecNac > diaActual){
						edadNum = edadNum - 1;
					}
				}
			}
		}				
		return edadNum+"";
	}
	
	
	/**CARGA LOS VALORES DEL PANEL HEADER*/
	public void btnLoadAction(ActionEvent actionEvent) {
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
			if (EntityGlobal.getInstance()!=null){
				//personamastSeleccionada.getBusqueda("USUARIO : " + EntityGlobal.getInstance().getNombreCompleto());
				//personamastSeleccionada.setDescripcionCCosto(EntityGlobal.getInstance().getEstablecimiento());
			}
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
			//usuarioCambioClave = 0;//usuarioService.obtenerUsuarioID(usuarioCambioClave);
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
	
	/**
	 * Cancela el cambio de clave
	 */
	public void eventoCancelarCambioClave() {
		claveOriginal = null;
		claveNueva = null;
		claveNuevaRepeticion = null;				
	}
	/**
	 * Guardar el Cambio de clave
	 */
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
				//usuarioCambioClave.set(usuarioCambioClave.getUsuario());
				//usuarioCambioClave.setUltimousuario(usuarioCambioClave.getUsuario());
				//usuarioCambioClave.setUltimafechamodif(new Timestamp(fecha.getTime()));
				int result =0;//arioService.guardarUsuario(usuarioCambioClave);
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
	
	
	
	
	
	
	/**
	 * evento al Seleccionar una MODADLIDAD de ESTUDIO
	 */
	public void onSelectMenuTopMEstudio(){
		try{
			String paramData = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("dataSelect");
			if (UtilesCommons.noEsVacio(paramData)
				&& !paramData.equals(""+EntityGlobal.getInstance().getMoemestudioid())
					) {
				//INGRESAR A NUEVA MODALIDAD
				ingresar(Integer.parseInt(paramData));
				
				//RECARGAR PAGINA
				FacesUtil.execute("location.reload(true)");
			}			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
    /**
     * @return
     */
    public void ingresar(Integer vmoemestudioid) {    	        
        EntityGlobal.getInstance().setMoemestudioid(vmoemestudioid);              
        
    }
	

    
    
	/**GET AND SET**/
	
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
	
	/**Obtener el nombre del usuario de la Sesión
	 * @return
	 */
	public String getNombreTipoUsuario() {
		if (EntityGlobal.getInstance()!=null){						
			nombreTipoUsuario = EntityGlobal.getInstance().getNombreCompleto();
		}else{
			
		}
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}
	
	public String getNombreCajero() {
		if (EntityGlobal.getInstance()!=null){		
			nombreCajero = EntityGlobal.getInstance().getNombresCompletoCajero();
		}else{
			nombreCajero = null;
		}
		return nombreCajero;
	}
	
	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}
	
	public Integer getIdCajero() {
		if (EntityGlobal.getInstance()!=null){	
			idCajero = EntityGlobal.getInstance().getIdCajero();
		}else{
			idCajero = null;
		}
		return idCajero;
	}
	
	public void setIdCajero(Integer idCajero) {
		this.idCajero = idCajero;
	}

	/***/
	public void  accionCerrarSesion(){
		//System.out.println("AAAAAAAAAAAAA");
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("saUsuariomantenimientoBeans");
		//System.out.println("BBBBBBBBBB");
	}

	/**Obtener la vista de la fecha con un formato completo
	 * @return
	 */
	public String getLbFechaPrincipal() {
		String FechaFormato = Utiles.formatoFechaString(new Date(), Utiles.FORMA_DATECOMPLETA);
		lbFechaPrincipal = FechaFormato;
		return lbFechaPrincipal;
	}

	public void setLbFechaPrincipal(String lbFechaPrincipal) {
		this.lbFechaPrincipal = lbFechaPrincipal;
	}

	/** obtener la descripción de la compañía de la sesión
	 * @return
	 */
	public String getLbCompaniaDesc() {
		if (EntityGlobal.getInstance()!=null){						
			lbCompaniaDesc = EntityGlobal.getInstance().getCompanyownerDesc();
		}else{
			lbCompaniaDesc="--";
		}			
		return lbCompaniaDesc;
	}

	public void setLbCompaniaDesc(String lbCompaniaDesc) {
		this.lbCompaniaDesc = lbCompaniaDesc;
	}
		

	/** obtener la descripción del establecimiento de la sesión */
	public String getLbEstablecimientoDesc() {
		if (EntityGlobal.getInstance()!=null){						
			lbEstablecimientoDesc = EntityGlobal.getInstance().getEstablecimientoDesc();
		}else{
			lbEstablecimientoDesc="--";
		}					
		return lbEstablecimientoDesc;
	}

	public void setLbEstablecimientoDesc(String lbEstablecimientoDesc) {
		this.lbEstablecimientoDesc = lbEstablecimientoDesc;
	}

	/** Obtener descripcion de la SESION
	 * @return
	 */
	public String getLbModalidadEstudioDesc() {
		if (EntityGlobal.getInstance()!=null){						
			lbModalidadEstudioDesc = EntityGlobal.getInstance().getModalidadEstudioDesc();
		}else{
			lbModalidadEstudioDesc="--";
		}			
		return lbModalidadEstudioDesc;				
	}

	public void setLbModalidadEstudioDesc(String lbModalidadEstudioDesc) {
		this.lbModalidadEstudioDesc = lbModalidadEstudioDesc;
	}


	public String getLbTerminal() {
		return lbTerminal = Utiles.obtenerNombrePcRemota();
	}

	public void setLbTerminal(String lbTerminal) {
		this.lbTerminal = lbTerminal;
	}

	
	public String getDlgAutorizarCajero() {
		return dlgAutorizarCajero;
	}
	
	public void setDlgAutorizarCajero(String dlgAutorizarCajero) {
		this.dlgAutorizarCajero = dlgAutorizarCajero;
	}

	public String getNombrePaciente() {
		if (EntityGlobal.getInstance()!=null){						
			nombrePaciente = EntityGlobal.getInstance().getNombrePacienteActual();
		}else{
			nombrePaciente="--";
		}					
		return nombrePaciente;			
	}

	public void setNombrePaciente(String nombrePaciente) {		
		this.nombrePaciente = nombrePaciente;
	}

	public String getFechaBuild() {
		fechaBuild = FacesUtil.getPropertyBuildInfo("build.timestamp");
		return fechaBuild;
	}

	public void setFechaBuild(String fechaBuild) {
		this.fechaBuild = fechaBuild;
	}

	public String getVersionBuild() {
		versionBuild = FacesUtil.getPropertyBuildInfo("build.version");
		return versionBuild;
	}

	public void setVersionBuild(String versionBuild) {
		this.versionBuild = versionBuild;
	}


}
