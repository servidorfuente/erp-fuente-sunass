package erp.realcoresystems.pe.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.commons.model.Email;
import erp.realcoresystems.pe.commons.service.EmailService;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.service.EmailGenericService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.model.util.Constant;
 


@Service("emailGenericService")
public class EmailGenericServiceImpl implements EmailGenericService{


	@Autowired
	private MaMiscelaneosdetalleService maMiscelaneosDetalleService;
	
	@Override
	public int enviarCorreo(Email objCorreo) {
		int resultMsg = 0;
		try{
			/**1: BUSCAR PARAMETROS DE CONEX*/		
			
			/**2: SET PAR|METROS DE CONEXI|N**/
			if(objCorreo!=null){
				if(!objCorreo.isParametrosConexionSet()){
					// BUSCAR PARAMETROS DE CONEX en DB
					MaMiscelaneosdetalle objMisc = new MaMiscelaneosdetalle (); 
					objMisc.setAplicacioncodigo(Utiles.getPropertyService("PAR_CODE_APP"));
					objMisc.setCompania(Utiles.getPropertyService("PAR_CODE_COMPANY"));
					objMisc.setCodigotabla(Utiles.getPropertyService("PAR_CODIGOTABLA_VARCORREOS"));
					objMisc.setEstado(Constant.ACTIVO);
					boolean halladoParametrosConex = false;
					List<MaMiscelaneosdetalle>  lista = maMiscelaneosDetalleService.listarElementos(objMisc);
					if(lista!=null){
						if(lista.size()>0){
							halladoParametrosConex = true;
							EmailService.setEmailParametrosConexion(objCorreo, 
									lista.get(0).getValorcodigo1(), 
									lista.get(0).getValorcodigo2(),  
									lista.get(0).getValorcodigo3(),  
									lista.get(0).getValorcodigo4(), 
									lista.get(0).getValorcodigo5(),  
									lista.get(0).getValorcodigo6(),
									lista.get(0).getValorcodigo7()  );
						}
					}
					if(!halladoParametrosConex){
						EmailService.setEmailParametrosConexion(objCorreo, 
								Utiles.getPropertyService("PAR_VAL_CORREO_ENVIA"), 
								Utiles.getPropertyService("PAR_VAL_CLAVE_CORREO_ENVIA"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_HOST"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_PORT"), 
								Utiles.getPropertyService("PAR_VAL_CORREO_SPORT"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_TTL"), 
								Utiles.getPropertyService("PAR_VAL_CORREO_ACCOUNT"));
					}					
				}

			}
			/**3: ENVIO CORREOS */
			resultMsg = EmailService.enviarEmail(objCorreo,objCorreo.isEsBodyPlantilla());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public int enviarCorreo(Email objCorreo, String procesoPlantilla) {
		int resultMsg = 0;
		try{
			if(objCorreo!=null){
				/**1: BUSCAR PLANTILLAS PARA EL BODY*/		
				// BUSCAR PARAMETROS DE CONEX en DB
				MaMiscelaneosdetalle objMiscPlant = new MaMiscelaneosdetalle (); 
				objMiscPlant.setAplicacioncodigo(Utiles.getPropertyService("PAR_CODE_APP"));
				objMiscPlant.setCompania(Utiles.getPropertyService("PAR_CODE_COMPANY"));			
				objMiscPlant.setCodigotabla(Utiles.getPropertyService("PAR_CODIGOTABLA_PLANT_CORREOS"));
				objMiscPlant.setEstado(Constant.ACTIVO);
				objMiscPlant.setValorcodigo1(procesoPlantilla);
				boolean halladoPlantillaCorreo = false;
				String plantillaCorreo = null;
				String subjectAux = null;
				List<MaMiscelaneosdetalle>  listaPt = maMiscelaneosDetalleService.listarElementos(objMiscPlant);
				if(listaPt!=null){
					if(listaPt.size()>0){
						halladoPlantillaCorreo = true;
						plantillaCorreo = listaPt.get(0).getDataTexto();
						if(UtilesCommons.esVacio(plantillaCorreo)){
							plantillaCorreo = listaPt.get(0).getDescripcionextranjera();	
						}
						
						subjectAux = listaPt.get(0).getValorcodigo2();
					}
				}
				/**2: MATCH VARIABLES CON PLANTILLA CORREO**/
				if(halladoPlantillaCorreo && plantillaCorreo!=null && objCorreo.isEsBodyPlantilla()){
					objCorreo.setBody(plantillaCorreo);					
				}else{
					objCorreo.setEsBodyPlantilla(false);
				}			
				//AUX EN CASO EL SUBJECT SEA NULO....
				if( UtilesCommons.esVacio(objCorreo.getSubject())){
					objCorreo.setSubject(subjectAux);
				}
				
			/**3: SET PAR|METROS DE CONEXI|N**/
			
				if(!objCorreo.isParametrosConexionSet()){
					// BUSCAR PARAMETROS DE CONEX en DB
					MaMiscelaneosdetalle objMisc = new MaMiscelaneosdetalle (); 
					objMisc.setAplicacioncodigo(Utiles.getPropertyService("PAR_CODE_APP"));
					objMisc.setCompania(Utiles.getPropertyService("PAR_CODE_COMPANY"));
					objMisc.setCodigotabla(Utiles.getPropertyService("PAR_CODIGOTABLA_VARCORREOS"));
					objMisc.setEstado(Constant.ACTIVO);
					boolean halladoParametrosConex = false;
					List<MaMiscelaneosdetalle>  lista = maMiscelaneosDetalleService.listarElementos(objMisc);
					if(lista!=null){
						if(lista.size()>0){
							halladoParametrosConex = true;
							EmailService.setEmailParametrosConexion(objCorreo, 
									lista.get(0).getValorcodigo1(), 
									lista.get(0).getValorcodigo2(),  
									lista.get(0).getValorcodigo3(),  
									lista.get(0).getValorcodigo4(), 
									lista.get(0).getValorcodigo5(),  
									lista.get(0).getValorcodigo6(),
									lista.get(0).getValorcodigo7()  );
						}
					}
					if(!halladoParametrosConex){
						EmailService.setEmailParametrosConexion(objCorreo, 
								Utiles.getPropertyService("PAR_VAL_CORREO_ENVIA"), 
								Utiles.getPropertyService("PAR_VAL_CLAVE_CORREO_ENVIA"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_HOST"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_PORT"), 
								Utiles.getPropertyService("PAR_VAL_CORREO_SPORT"),  
								Utiles.getPropertyService("PAR_VAL_CORREO_TTL"), 
								Utiles.getPropertyService("PAR_VAL_CORREO_ACCOUNT"));
					}					
				}

			}								
			/**3: ENVIO CORREOS */
			resultMsg = EmailService.enviarEmail(objCorreo,objCorreo.isEsBodyPlantilla());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public Email getObjetoMail(List<String> listCorreoDestinos, String subject, String body,
			List<String> listPathFileAtached, Date correoFecha,boolean contienePlantilla) {
		Email email = 
				EmailService.construirMail(listCorreoDestinos, subject, body, 
						listPathFileAtached, correoFecha);
		email.setEsBodyPlantilla(contienePlantilla);
		return email;
	}

	@Override
	public Email getObjetoMail(List<String> listCorreoDestinos, String subject, String bodyPlantilla,
			List<String> listPathFileAtached, Date correoFecha, Map<String, String> mapvariablesValores) {
		
		Email email = 
				EmailService.construirMail(listCorreoDestinos, subject, bodyPlantilla, 
						listPathFileAtached, correoFecha);
		email.setMapvariablesValores(mapvariablesValores);			
		if(mapvariablesValores!=null){
			email.setEsBodyPlantilla(true);	
		}		
		return email;
	}

	@Override
	public int enviarCorreoMixto(List<Email> listaObjCorreo) {
		// TODO Auto-generated method stub
		return 0;
	}



}
