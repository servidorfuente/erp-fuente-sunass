package erp.realcoresystems.pe.controller.configuracion;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.service.UsuarioService;
import org.primefaces.context.RequestContext;

import erp.realcoresystems.pe.server.EncriptaKeyService;
import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;

@ManagedBean(name = "preferenciasBeans")
@ViewScoped
public class PreferenciasBeans {

    
    
	public static String UrlBandejaEducativo= FacesUtil.getPropertyParametros("PAR_PAGININA_DEFAULT");	
    //private static String UrlBandejaEducativo = "/vistas/modulos/bandejaEducativoIndex.xhtml?faces-redirect=true";
	
	private static String URL_PAGINA_BLANK = FacesUtil.getPropertyParametros("PAR_PAGINA_DEFAULT_BLANK");
	
    private static String URL_LOGIN_PAGINA = "/login.xhtml?faces-redirect=true";
    private static String URL_PREFERENCIAS_PAGINA = "/preferencias.xhtml?faces-redirect=true";
    private static String URL_CAMBIOCLAVE_PAGINA = "/cambioClaveLogin.xhtml?faces-redirect=true";
    
	@ManagedProperty( value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
    
    private String indicadorModulo = "1";

    private Integer vuneunegocioid;
    private Integer vmoemestudioid;
    private String codigoSucursal;
    private String codigoCompanyownerSelecc;
    private Integer sedGrupoId;
    
	/*****Componetes cambio clave***/
	    
    private String usuarioActual;    
    private String messageAlertCambioClave = "";
	private String claveOriginal;
	private String claveNueva;
	private String claveNuevaRepeticion;	
	private Usuario usuarioCambioClave = null;
	private boolean cambioClave = false;
	
	/*****ADD para el tema de LENGUAJE***/
	private Locale locale;
	private String lenguaje;
	
	
    public PreferenciasBeans() {

    }

	public void inicializar() {		
		vuneunegocioid=null;
		vmoemestudioid=null;
		codigoSucursal=null;
		sedGrupoId=null;
		codigoCompanyownerSelecc=null;
	    //inicializar valores de SESION
	    setParametrosDefault();
	    
	    indicadorModulo = "1";		        
	    /***analizar si redireccina o NO al panel de CAMBIO DE CLAVE  ****/
	    cambioClave=false;
	    String flagCambioClave = EntityGlobal.getInstance().getFlagObligarcambioClave();	    
	    if(Utiles.SI_db.equals(flagCambioClave)){
	    	if(eventoActivarCambioClave()){
	        	String paginaSgt=URL_CAMBIOCLAVE_PAGINA;
	        	redirect(paginaSgt);	    		    			    			
	    	}
	    }else{
	        /***analizar si redireccina o NO al panel principal  ****/
	        String compa = EntityGlobal.getInstance().getCodigoCompanyowner();
	        String suc = EntityGlobal.getInstance().getCodigoSucursal();
	        Integer modalidad = EntityGlobal.getInstance().getMoemestudioid();
	        /**SI POSEE VALORE POR DEFECTO EN COMPANIA SUCURSAL Y MODALIDAD (Es porque solo existían uno de 
	         * c/u no se necesario LA PAG DE PREFERENCIAS)*/
	        if(compa!=null && suc!=null && modalidad!=null ){
	        	String paginaSgt=UrlBandejaEducativo;
	        	redirect(paginaSgt);
	        }else{
	        	//cargarComboCompania();  
	        }	
	    }
    }
	public void redirect(String paginaSgt){
		//String paginaSgt=UrlBandejaEducativo;		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String url="";
		String contextPath="";
		if(request!=null){
			url = request.getRequestURL().toString();			
			contextPath = request.getContextPath();			
		}else{			
		}			
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		try {			
				url = contextPath+paginaSgt;
		        ec.redirect(url);
		} catch (IOException ex) {
			ex.printStackTrace();
		}				
	}
    


    
    public void setParametrosDefault(){
    	try{
        	FacesUtil.propiedades = ResourceBundle.getBundle("mensajes",FacesUtil.getContextLocale());
        	
        	EntityGlobal.getInstance().setSysUrl(UrlBandejaEducativo);
        	EntityGlobal.getInstance().setUrlPaginaInicio(UrlBandejaEducativo);
        	
        	EntityGlobal.getInstance().setConceptoActualDesc(FacesUtil.getPropertyParametros("PAR_SEG_CONCEPTODESC_DEF"));
        	EntityGlobal.getInstance().setConceptoActual(FacesUtil.getPropertyParametros("PAR_SEG_CONCEPTO_DEF"));
        	EntityGlobal.getInstance().setGrupoActual(FacesUtil.getPropertyParametros("PAR_SEG_GRUPO_DEF"));
        	EntityGlobal.getInstance().setAplicacionCodigoActual(FacesUtil.getPropertyParametros("PAR_SEG_APPCODIGO_DEF"));

        	EntityGlobal.getInstance().setSysConceptoDesc(FacesUtil.getPropertyParametros("PAR_SEG_CONCEPTODESC_DEF"));
        	EntityGlobal.getInstance().setSysConcepto(FacesUtil.getPropertyParametros("PAR_SEG_CONCEPTO_DEF"));
        	EntityGlobal.getInstance().setSysGrupo(FacesUtil.getPropertyParametros("PAR_SEG_GRUPO_DEF"));
        	EntityGlobal.getInstance().setSysAplicacionCodigo(FacesUtil.getPropertyParametros("PAR_SEG_APPCODIGO_DEF"));
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    }
    
    public String getIndicadorModulo() {
        return indicadorModulo;
    }

    public void setIndicadorModulo(String indicadorModulo) {
        this.indicadorModulo = indicadorModulo;
    }

    public static String getUrlModuloHistoriaClinica() {
        return UrlBandejaEducativo;
    }

    public static void setUrlModuloHistoriaClinica(String urlModuloHistoriaClinica) {
        UrlBandejaEducativo = urlModuloHistoriaClinica;
    }

  

    public static String getUrlLoginPagina() {
        return URL_LOGIN_PAGINA;
    }

    public static void setUrlLoginPagina(String urlLoginPagina) {
        URL_LOGIN_PAGINA = urlLoginPagina;
    }

 
    public Integer getVuneunegocioid() {
        return vuneunegocioid;
    }

    public void setVuneunegocioid(Integer vuneunegocioid) {
        this.vuneunegocioid = vuneunegocioid;
    }

    public Integer getVmoemestudioid() {
        return vmoemestudioid;
    }

    public void setVmoemestudioid(Integer vmoemestudioid) {
        this.vmoemestudioid = vmoemestudioid;
    }

	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public String getCodigoCompanyownerSelecc() {
		return codigoCompanyownerSelecc;
	}

	public void setCodigoCompanyownerSelecc(String codigoCompanyownerSelecc) {
		this.codigoCompanyownerSelecc = codigoCompanyownerSelecc;
	}

	public Integer getSedGrupoId() {
		return sedGrupoId;
	}

	public String getMessageAlertCambioClave() {
		return messageAlertCambioClave;
	}

	public void setMessageAlertCambioClave(String messageAlertCambioClave) {
		this.messageAlertCambioClave = messageAlertCambioClave;
	}

	public String getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(String usuarioActual) {
		this.usuarioActual = usuarioActual;
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
	/**REFERENTE AL CAMBIO DE CLAVE FORZADO*/
	public boolean  eventoActivarCambioClave() {
		EntityGlobal usuario=EntityGlobal.getInstance();
		if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
			usuarioCambioClave = new Usuario();
			usuarioCambioClave.setUsuario(usuario.getUsuario());
			usuarioCambioClave = usuarioService.obtenerPorId(usuario.getUsuario());
			if (usuarioCambioClave == null) {				
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noUserValido"));
			} else {
				usuarioActual=EntityGlobal.getInstance().getUsuario();
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
	
	/**Evento  previo al pase a la siguietne página . Acá se ejecuta el cambio de clave y se comprueba que todo salió bien.*/
	public void btnPreCambioClave(){
		try{				
			cambioClave = eventoGuardarCambioClave();
			if(cambioClave){
				messageAlertCambioClave = null;
				RequestContext.getCurrentInstance().execute("eventoAceptarCambioClave();");
			}									
//			RequestContext context = RequestContext.getCurrentInstance();
//			context.addCallbackParam("isCambioClave", cambioClave);						
		}catch(Exception ex){
//			RequestContext context = RequestContext.getCurrentInstance();
//			context.addCallbackParam("isCambioClave", false);
			FacesUtil.adicionarMensajeError("Ocurrió un error Inesperado");
			ex.printStackTrace();
		}
	}
	
    public String aceptarCambioClave() {       	
    	if(cambioClave){
    		EntityGlobal.getInstance().setFlagObligarcambioClave(Utiles.NO_db);    		
    		return URL_PREFERENCIAS_PAGINA;
    	}else{
    		return URL_CAMBIOCLAVE_PAGINA;
    	}    	
    }
    
	public boolean  eventoGuardarCambioClave() {
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
				usuarioCambioClave.setUsuarioEntGlobal(usuarioCambioClave.getUsuario());
				usuarioCambioClave.setUltimousuario(usuarioCambioClave.getUsuario());
				usuarioCambioClave.setUltimafechamodif(new Timestamp(fecha.getTime()));
				usuarioCambioClave.setSqlpassword(Utiles.ACTIVO_db);//PARA NO FORZAR CAMBIO DE CONTRASEÑA
				int result = usuarioService.guardarUsuario(usuarioCambioClave);
				if (result > 0) {											
					// model = buscarPrincipal();
					usuarioCambioClave = null;					
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_cambioClaveCorrecto"));
					//FacesUtil.jsMensajePropiedades("MSJ_INFO_cambioClaveCorrecto", AbstractGenericBean.SUCCESS);
				} else {					
					correcto = false;	
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noUpdateCorrecto"));
					//FacesUtil.jsMensajePropiedades("MSJ_ERROR_noUpdateCorrecto", AbstractGenericBean.WARN);
				}
			} else {

			}
		} else {
			FacesUtil.adicionarMensajeWarning(mensaje);
		}
		return correcto;
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

	public boolean isCambioClave() {
		return cambioClave;
	}

	public void setCambioClave(boolean cambioClave) {
		this.cambioClave = cambioClave;
	}

	
	

	public static void setURL_CAMBIOCLAVE_PAGINA(String uRL_CAMBIOCLAVE_PAGINA) {
		URL_CAMBIOCLAVE_PAGINA = uRL_CAMBIOCLAVE_PAGINA;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}	
	
	
	public String getLenguaje() {
		lenguaje =FacesUtil.getSessionLocale().getLanguage(); 
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	
}


