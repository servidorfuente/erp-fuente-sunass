package erp.realcoresystems.pe.controller.configuracion;

import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ResourceBundle;


@ManagedBean
@ViewScoped
public class RedireccionaBeans {
	
	// URL-INICIAL    /vistas/modulos/bandejaPortalIndex.xhtml?faces-redirect=true
    private static String URL_PORTALGENERAL= FacesUtil.getPropertyParametros("PAR_PAGININA_DEFAULT"); 
	//private static String URL_PREFERENCIAS="/vistas/encuestas/formularioEncuesta.xhtml";
	private static String URL_FORMULARIO_ENCUESTA="/vistas/encuestas/encuestaFormulario.xhtml";	
	//private static String URL_PREFERENCIAS="/vistas/inicio/dashboardAdministracion.xhtml";

	private boolean cambioClave = false;
	private  String urlActual;
	
	//@PostConstruct
    public void inicializar() { 
        /***analizar si redireccina o NO al panel de CAMBIO DE CLAVE  ****/
        cambioClave=false;
        Integer rutaUrl=0;
        String paginaSgt="";        
        /**LÓGICA DE LA PÁGINA DE MENÚ INICIAL*/                             
        //paginaSgt = URL_PORTALGENERAL;
        paginaSgt = URL_PORTALGENERAL;        
        urlActual = paginaSgt; 
        setParametrosDefault();
        FacesUtil.redirect(paginaSgt);
		//FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, URL_PREFERENCIAS);
        
        
	}

    public void setParametrosDefault(){
    	try{
        	FacesUtil.propiedades = ResourceBundle.getBundle("mensajes",FacesUtil.getContextLocale());
        	
        	EntityGlobal.getInstance().setSysUrl(URL_PORTALGENERAL);
        	EntityGlobal.getInstance().setUrlPaginaInicio(URL_PORTALGENERAL);
        	
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
	public String ingresar() {
		return urlActual;
	}
	public boolean isCambioClave() {
		return cambioClave;
	}

	public void setCambioClave(boolean cambioClave) {
		this.cambioClave = cambioClave;
	}


}


