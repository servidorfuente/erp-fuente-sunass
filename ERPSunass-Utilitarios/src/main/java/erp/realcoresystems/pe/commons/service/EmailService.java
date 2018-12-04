package erp.realcoresystems.pe.commons.service;



import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.commons.model.Email;

public class EmailService {

	/**Envía el correo electrónico de acuerdo a los parámetros Stnadar  de correo, un Map de las Variables y sus
	 * respectivos valores y todo el esquema del mensaje de correo (PLANTILLA)
	 * DEVUELVE:
	 * 1:	si el envío fu exitos
	 * 0:	si hubo una excepción
	 * -1:	Si no se recibió una plantilla válida
	 * -2:	No se encontraron correos destino
	 * -3:	No se encontró un motivo del correo (SUBJECT)
	 * -4:	No se construyó el objeto de Correo. (Algún parámetro erróneo)
	 * -5:	No se pudo enviar el correo. Sucedió un error en el envío.
	 * */
	public static int enviarEmailPlantilla(String bodyPlantilla,List<String> correoDestinos,String subject, 
			List<String>  pathFilesAtached, Date correoFecha , Map<String,String> mapvariablesValores){
		int result =0;
		try{
			if(bodyPlantilla!=null && !"".equals(bodyPlantilla+"")){
				if(correoDestinos!=null){
					if(correoDestinos.size()>0){
						if(subject!=null && !"".equals(subject+"")){
							Email email = construirMail(correoDestinos, subject, bodyPlantilla, pathFilesAtached, correoFecha, mapvariablesValores);
							email = EmailService.setEmailVariablesGenerales(email);
							if(email!=null){
								if(EmailService.sendMail(UtilesCommons.SI_db,email)){
									result =1;	
								}else{
									result =-5;	
								}
							}else{
								result =-4;
							}			
						}else{
							result =-3;
						}
					}else{
						result =-2;
					}
				}else{
					result =-2;
				}
			}else{
				result =-1;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			result =0;
		}
		return result;
	}
		

	/**Envía el correo electrónico de acuerdo a los parámetros estandar  de correo
	 * @param email: el objeto del Email
	 * @param contienePlantilla: si posee o no plantilla de correo
	 * @return
	 * 1:	si el envío fu exitos
	 * 0:	si hubo una excepción
	 * -1:	Si no se recibió una plantilla válida
	 * -2:	No se encontraron correos destino
	 * -3:	No se encontró un motivo del correo (SUBJECT)
	 * -4:	No se recibió el objeto de Correo. (Algún parámetro erróneo)
	 * -5:	No se pudo enviar el correo. Sucedió un error en el envío.	 * 
	 */
	public static int enviarEmail(Email email,boolean contienePlantilla){
		int result =0;
		try{			
			if(email!=null){				
				if(contienePlantilla){
					//Tratamiento si hubiese
					email = EmailService.construirMail(email, email.getMapvariablesValores());
				}else{
				}
				
				if(email.getBody()!=null && !"".equals(email.getBody()+"")){
					if(email.getListCorreoDestinos()!=null){
						if(email.getListCorreoDestinos().size()>0){
							if(email.getSubject()!=null && !"".equals(email.getSubject()+"")){
								if(EmailService.enviarEmail(email)){
									result =1;	
								}else{
									result =-5;	
								}								
							}else{
								result =-3;
							}
						}else{
							result =-2;
						}
					}else{
						result =-2;
					}
				}else{
					result =-1;
				}
			}else{
				result =-4;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			result =0;
		}
		return result;
	}	
	
	public static Email construirMail(Email objEmail, Map<String,String> mapvariablesValores){		
		/***VARIABLES PROPIOS DE LA TAREA:*/
		if(objEmail!=null){
			String bodyPlantilla=objEmail.getBody();
			if(mapvariablesValores!=null && bodyPlantilla!=null){
				Collection<String> collKey =  mapvariablesValores.keySet();
				for(String key :collKey){	
					String valor = mapvariablesValores.get(key);
					if(valor!=null){
						bodyPlantilla = bodyPlantilla.replaceAll(key, valor);	
					}else{
						bodyPlantilla = bodyPlantilla.replaceAll(key,"");
					}
						
				}
			}
			objEmail.setBody(bodyPlantilla);
		}
		return objEmail;
	}
	
	public static Email setEmailVariablesGenerales(Email objEmail){		
		/***VARIABLES PROPIOS DE LA TAREA:*/
		if(objEmail!=null){
			String bodyPlantilla=objEmail.getBody();					
			//mapvariablesGeneralesValores.put(FacesUtil.getPropertyCorreo("PAR_USUARIO"),"");
			objEmail.setBody(bodyPlantilla);
		}
		return objEmail;
	}
	
	/**construir EMAIL CON VALORES DE PLANTILLA*/
	public static Email construirMail(List<String> listCorreoDestinos,String subject, String bodyPlantilla, 
			List<String>  listPathFileAtached, Date correoFecha , Map<String,String> mapvariablesValores){
		Email email = null;
		try{
			//System.out.println("TEST LLEGA EVENTO USUARIO 2222");
			/******************************/			
			email= new Email();			
			email.setListCorreoDestinos(listCorreoDestinos);
			email.setSubject(subject);			
			//armar CUERPO: reemplazamos las variables que existiesen por los valores:						
			/***VARIABLES GENERALES*/
			//PlantillaCorreo = PlantillaCorreo.replaceAll(FacesUtil.getPropertyCorreo("PAR_FECHA_ACTUAL"),Utiles.printDate("dd/MM/yyyy",Utiles.getFechaHoy()));						
			email.setBody(bodyPlantilla);			
			email.setListpathFilesDestinos(listPathFileAtached);
			email.setCorreoFecha(UtilesCommons.getFechaHoy());
			email = construirMail(email, mapvariablesValores);
			
			/******************************/
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return email;
	}
	/**construir EMAIL SIN VALORES DE PLANTILLA*/
	public static Email construirMail(List<String> listCorreoDestinos,String subject, String body, 
			List<String>  listPathFileAtached, Date correoFecha){
	Email email = null;
	try{
		//System.out.println("TEST LLEGA EVENTO USUARIO 2222");
		/******************************/			
		email= new Email();			
		email.setListCorreoDestinos(listCorreoDestinos);
		email.setSubject(subject);			
		//armar CUERPO: reemplazamos las variables que existiesen por los valores:						
		/***VARIABLES GENERALES*/
		//PlantillaCorreo = PlantillaCorreo.replaceAll(FacesUtil.getPropertyCorreo("PAR_FECHA_ACTUAL"),Utiles.printDate("dd/MM/yyyy",Utiles.getFechaHoy()));						
		email.setBody(body);			
		email.setListpathFilesDestinos(listPathFileAtached);
		email.setCorreoFecha(UtilesCommons.getFechaHoy());
		
		
		/******************************/
	}catch(Exception ex){
		ex.printStackTrace();
	}		
	return email;
}
	
	public static boolean sendMail(String actiboJB,Email email){
		/**CONFIG CONFIG EN JBOSS O EN MISMA APLICACIÓN*/
		actiboJB =UtilesCommons.NO_db;		
		if(UtilesCommons.SI_db.equals(actiboJB)){
			return sendMail(email);
		}else{
			return enviarEmail(email);
		}
	}
	
	
	public static Email setEmailParametrosConexion(Email email,
			String correoRemitente,String correoClave,String correoHost,String correoPort
			,String correoSocketPort,String activoTTL,String correoCuenta){
		if(email!=null){
			email.setCORREO_USAURIO(correoRemitente!=null?correoRemitente.trim():"");
			email.setCORREO_CLAVE(correoClave!=null?correoClave.trim():"");
			email.setCORREO_HOST(correoHost!=null?correoHost.trim():"");
			email.setCORREO_PORT(correoPort!=null?correoPort.trim():"");
			email.setCORREO_SOCKETPORT(correoSocketPort!=null?correoSocketPort.trim():"");
			//email.setCORREO_ACTIVO_TTL(isActivoTTL?UtilesCommons.SI_db:UtilesCommons.NO_db);
			email.setCORREO_ACTIVO_TTL(activoTTL!=null?activoTTL.trim():"");
			email.setCORREO_ACCOUNT(correoCuenta!=null?correoCuenta.trim():"");
			email.setParametrosConexionSet(true);
		}
		return email;
	}
			
	
	/**llamada al Servicio de correo con la configuración en JB y Java Mail */
	public static boolean sendMail(Email email){
		EmailServiceJB emaliServ = new EmailServiceJB();
		//String [] destino = {"araucoj@realcoresystems.com"};
		//EmailServlet.enviarEmail(destino,"SUBJECT", "XXXXXXXX", null,Utiles.getFechaHoy());
		return emaliServ.sendMail(email);		
	}
	
	/**llamada al Servicio de correo con la configuración propia del JavaMail */
	public static boolean enviarEmail(Email email){
		/***********************
		 * prueba envío correo
		***************************/
		try{
			if(email!=null){
				String correoUser= email.getCORREO_USAURIO();
				String correoPw= email.getCORREO_CLAVE();
				String correoHost= email.getCORREO_HOST();
				String correoPort= email.getCORREO_PORT();
				String correoSPort= email.getCORREO_SOCKETPORT();
				String correoTTL = email.getCORREO_ACTIVO_TTL();
				String correoAccount = email.getCORREO_ACCOUNT();
				
				EmailServiceGen objMail = new EmailServiceGen(correoUser,correoPw);
				objMail.setParametrosMail(correoHost, correoPort, correoSPort,correoTTL);
				//objMail.setUserpassw();
				if(email.getListCorreoDestinos()!=null){
					String[] toArray = new String[email.getListCorreoDestinos().size()];					
					int i=0;
					for(String correo: email.getListCorreoDestinos()){
						toArray[i] = correo;
						i++;
					}					
					objMail.setTo(toArray);
				}else if(email.getTotalCorreoDestinos()!=null){
					objMail.setTo(email.getTotalCorreoDestinos());	
				}
				
								
				objMail.setFrom(correoUser);										
				objMail.setAccount(correoAccount);
				objMail.setSubject(email.getSubject());				
				objMail.setBody(email.getBody());
				if(email.getPathFileAttached()!=null){
					objMail.addAttachment(email.getPathFileAttached());
				}
				if(email.getListpathFilesDestinos()!=null){
					objMail.addAttachment(email.getListpathFilesDestinos());
				}				
				objMail.send();
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			//logger.error(e.getMessage());
		}
		return false;
	}
}
