package erp.realcoresystems.pe.erprrhhrest.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class UtilesRest {

	public static final String LOCALE_CODIGO_SPAIN="_es";
	public static final String LOCALE_CODIGO_ENGLISH="_en";
	public static final String LOCALE_CODIGO_ITALIAN="_it";
	
	public static final String SI_db="S";
	public static final String NO_db="N";	
	
	public static ResourceBundle applicationProp = ResourceBundle.getBundle("application");
	public static ResourceBundle propiedades = ResourceBundle.getBundle("messages");

	public static String getMSJProperty(String prop){	
		//propiedades.getLocale().setDefault(FacesContext.getCurrentInstance().getViewRoot().getLocale());
		//propiedades = ResourceBundle.getBundle("mensajes",FacesUtil.getContextLocale());
		if(propiedades.containsKey(prop)){
			return propiedades.getString(prop);	
		}else{
			return "";
		}				
	}
	
	public static String getAppProperty(String prop){		
		if(applicationProp.containsKey(prop)){
			return applicationProp.getString(prop);	
		}else{
			return "";
		}				
	}
	
	/** Devolver el objeto FILE de un archivo local o recurso: xml, property, yml, json , etc.
	 * @param mappingFile
	 * @return
	 */
	public static File getFileResource(String mappingFile){
		File fileResut = null;
    	//resource.getFile()
    	try {
    		Resource resource = new ClassPathResource(mappingFile);  
    		fileResut =  resource.getFile();
		} catch (IOException e) {		
			e.printStackTrace();
		}
    	return fileResut;
	}
	
	public static String getMsgResultCorreo(int reusltMsg){
		String mensaje = "";
		/**4: MOSTRAR MENSAJES */
		switch (reusltMsg){
			case 1: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_EXITO");				
				break;
			case 0: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_FALLO");
				break;
			case -1: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_FALLO_PLANT_INVALIDA");
				break;
			case -2: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_FALLO_MAIL_INVALIDA");
				break;
			case -3: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_FALLO_SUBJECT_INVALIDA");
				break;
			case -4: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_FALLO_NO_BUILD");
				break;
			case -5: mensaje = getMSJProperty("CORREOS_GEN.ENVIO_CORREO_NO_ENVIO");
				break;		
			default : mensaje = "error";
		}				
		
		return mensaje;
	}
}
