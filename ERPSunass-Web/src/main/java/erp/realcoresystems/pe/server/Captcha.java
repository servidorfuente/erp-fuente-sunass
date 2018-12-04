package erp.realcoresystems.pe.server;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

 
public class Captcha {
 
	private final Log log = LogFactory.getLog(Captcha.class);
	
	/******************************************************************************/
	/******************************************************************************/
	/***CAPTCHA BASADO EN REAL EL API JCAPTCHA: com.octo.captcha ***/
	/******************************************************************************/
/*
	private ImageCaptchaService imageCaptchaService = new DefaultManageableImageCaptchaService(
            new FastHashMapCaptchaStore(),
            new ImageCaptchaEngineRS(),
            180,
            100000,
            75000);
	
	//private final DefaultManageableImageCaptchaService imageCaptchaService;
 
	private String captchaId;
 
	private String captchaValue;
 
	private byte[] captchaImage;
	
	
 
  *//**
   * Recibe el servicio de generación de captcha y genera una nueva imagen
   *//*
	public Captcha(ImageCaptchaService imageCaptchaService) {
		//this.imageCaptchaService = imageCaptchaService ;//(DefaultManageableImageCaptchaService)imageCaptchaService;
		this.imageCaptchaService = new DefaultManageableImageCaptchaService(
	            new FastHashMapCaptchaStore(),
	            new ImageCaptchaEngineRS(),
	            180,
	            100000,
	            75000);
		try {
			generateCaptchaImage();
		} catch (IOException e) {
			log.error("Error generando captcha: " + e.getMessage());
		}
	}
	 
	  *//**
	   * Construye el captcha y genera una nueva imagen
	   *//*
	
		public Captcha() {			
			this.imageCaptchaService = new DefaultManageableImageCaptchaService(
		            new FastHashMapCaptchaStore(),
		            new ImageCaptchaEngineRS(),
		            180,
		            100000,
		            75000);
			try {
				generateCaptchaImage();
			} catch (IOException e) {
				log.error("Error generando captcha: " + e.getMessage());
			}
		}
	*//**
	 * Devuelve una imagen de captcha
	 * 
	 * @return
	 * @throws IOException
	 *//*
	public void generateCaptchaImage() throws IOException {
		final HttpServletRequest httpServletRequest = (HttpServletRequest)FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
		// Stream de salida para la imagen del captcha
		final ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream(); 
		try{	 
			// Guarda el identificador de sesión del usuario para validar el captcha
			captchaId = httpServletRequest.getSession().getId();	
			// Creación de la imagen de captchacall the ImageCaptchaService getChallenge method
			final BufferedImage challenge = imageCaptchaService.getImageChallengeForID(captchaId);
	 
			// Codificamos la imagen en JPEG
			ImageIO.write(challenge, "jpg", jpegOutputStream);
			//final JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
			//jpegEncoder.encode(challenge);
	 
			// Guardamos la imagen como un flujo de bytes para pintarla en pantalla
			captchaImage = jpegOutputStream.toByteArray();
		}catch(CaptchaServiceException e){
			e.printStackTrace();
		}
	}

	 
	  *//**
	   * Crea una nueva Image CAPTCH
	   *//*
		public void refrescarCaptcha() {
			//this.imageCaptchaService = imageCaptchaService ;//(DefaultManageableImageCaptchaService)imageCaptchaService;
			this.imageCaptchaService = new DefaultManageableImageCaptchaService(
		            new FastHashMapCaptchaStore(),
		            new ImageCaptchaEngineRS(),
		            180,
		            100000,
		            75000);
			try {
				generateCaptchaImage();
			} catch (IOException e) {
				log.error("Error generando captcha: " + e.getMessage());
			}
		}
	
	*//**
	 * Validación del captcha. Se recoge el identificador de la sesión del usuario y el texto introducido para validar que ha
	 * reconocido el texto del captcha.
	 * 
	 * @return
	 *//*
	public boolean isValidCaptcha() {
		boolean validate = false;
		try {
			*//**OBS cambio a MAYUSC *//*
			if(captchaValue!=null){
				captchaValue = captchaValue.toUpperCase();	
			}							
			validate = imageCaptchaService.validateResponseForID(captchaId, captchaValue);
			captchaValue="";
		} catch (Exception e) {
			log.error("Error durante la validación del captcha: " + e.getMessage());
		}
 
		return validate;
	}
 
	public String getCaptchaValue() {
		return captchaValue;
	}
 
	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}
 
	public byte[] getCaptchaImage() {
		return captchaImage;
	}
	*/
	/******************************************************************************/
	/******************************************************************************/
	/***CAPTCHA BASADO EN REAL PERSON: http://keith-wood.name/realPerson.html ***/
	/******************************************************************************/
	
	private String captchaVariable;
	
	/**Constructor*/
	public Captcha(String indicador) {
		captchaVariable = indicador;
	}

	
	/**Validación CAPCHA REAL PERSON*/
	public boolean isValidCaptchaRealPerson() {
		boolean result = false;		
		FacesContext fctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = fctx.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
		String realPersonhash= request.getParameter(captchaVariable+"Hash");			
		if (rpHash(request.getParameter(captchaVariable)).equals(
				realPersonhash)) {			
			result =true;
		} else {
			result =false;								
		}				
		return result;
	}
	
	/**ALGORITMO HASH RAL PERSON*/
	private String rpHash(String value) { 
	    int hash = 5381; 
	    value = value.toUpperCase(); 	    
	    for(int i = 0; i < value.length(); i++) { 
	        hash = ((hash << 5) + hash) + value.charAt(i); 
	    } 	    
	    return String.valueOf(hash); 
	}
}