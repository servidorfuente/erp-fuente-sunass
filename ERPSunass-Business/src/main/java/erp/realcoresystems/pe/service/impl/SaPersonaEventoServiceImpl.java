package erp.realcoresystems.pe.service.impl;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.ParametrosMastDao;
import erp.realcoresystems.pe.model.dao.PersonamastDao;
import erp.realcoresystems.pe.model.dao.SaPersonaEventoDao;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.SaPersonaEvento;
import erp.realcoresystems.pe.model.domain.SaPersonaEventoPK;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaEvento;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.model.util.ValorRetorno;
import erp.realcoresystems.pe.service.SaPersonaEventoService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;
import erp.realcoresystems.pe.util.UtilEventoHilo;


/**
 * @author araucoj
 *
 */
@Service("saPersonaEventoService")
@Transactional(readOnly = true)
public class SaPersonaEventoServiceImpl implements SaPersonaEventoService {

	
	@Autowired
	ParametrosMastDao parametrosMastDao;
	
	@Autowired
	SaPersonaEventoDao saPersonaEventoDao;
	
	@Autowired
	PersonamastDao personamastDao;
	

	
	@Override
	public SaPersonaEvento obtenerPorID(SaPersonaEventoPK id) {
		try {
			return saPersonaEventoDao.obtenerPorID(id);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;	
	}

	@Override
	public List<SaPersonaEvento> listarElementos(SaPersonaEvento objDao) {
		try {
			return saPersonaEventoDao.listarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<SaPersonaEvento> listarElementosPag(SaPersonaEvento objDao) {
		try {
			return saPersonaEventoDao.listarElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwPersonaEvento> listarVwElementosPag(VwPersonaEvento objDao) {
		try {
			return saPersonaEventoDao.listarVwElementosPag(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional
	public long guardar(SaPersonaEvento objDao) {
		try {
			long idSec = saPersonaEventoDao.guardar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int eliminar(SaPersonaEvento objDao) {
		try {
			int idSec = saPersonaEventoDao.eliminar(objDao);
						
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional
	public int actualizar(SaPersonaEvento objDao) {
		try {
			int idSec = saPersonaEventoDao.actualizar(objDao);
			return idSec;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contarElementos(SaPersonaEvento objDao) {
		try {
			return saPersonaEventoDao.contarElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}

	@Override
	public int contarVwElementos(VwPersonaEvento objDao) {
		try {
			return saPersonaEventoDao.contarVwElementos(objDao);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;
	}
	


	public boolean getPersonaEventpFromMapData(List<Map<String,Object>> listaData, 
			int contadorFilas,int indexHeader){
		boolean result = false;
		try{
			for(Map<String,Object> mapData: listaData){						
				if(contadorFilas == indexHeader){//SI ES LA FILA CORRESP. AL HEADER
					//HEADER	
					contadorFilas++;
				}else{
					VwPersonaEvento objDataEvento = new VwPersonaEvento();
					objDataEvento.setIdcontador(Long.valueOf(contadorFilas));									
					Field fieldObj =objDataEvento.getClass().getDeclaredField(DOCUMENTO);	
					String headerKeyAux = getHeaderMatchCampoFormatoFile(DOCUMENTO, true);
					Object valor = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObj.getType());
					if(valor!=null){
						String documento = (String)valor;	
						UtilEventoHilo hilo = new UtilEventoHilo(documento, new UtilEventoHilo.AccionEventoHilo() {
							
							@Override
							public void retornoEvento(String codigoHilo,UtilEventoHilo hiloParent) {								
							//	PersonaWSBean objRENIEC = validarPersonaRENIEC(codigoHilo);
							}
						});
						hilo.start();
					}
															
					contadorFilas++;
				}
			}
		}catch(Exception ex){
			Log.logger.error(Log.getStackTrace(ex));
		}

		return result;
	}
			
	

	/** obtiene un objeto del tipo VwPersonaEvento a partir del Map del FIle
	 * @param mapData: Map de las celdas del File 
	 * @param indexPersona: Nï¿½mero de registro
	 * @param listaKeyHeader: List  que contiene los valores para cada celda del HEADER del FILE a usar
	 * @return un objeto del tipo VwPersonaEvento
	 */
 /***/
	public Object getValorMatchDataFormatoFile(String headerKey,Map<String,Object> mapData,Class<?> typeField){
		Object result =null;
		try{
			if(mapData.containsKey(headerKey)){								
				result = mapData.get(headerKey);
				if(result!=null && typeField!=null){
					String tipo = result.getClass().getSimpleName();
					//System.out.println("TEST TIPO XX:OUT::"+tipo +"==="+typeField.getSimpleName());					
					//System.out.println("TEST TIPO XX:IN::"+typeField.getSimpleName());
					if(!typeField.getSimpleName().equals(""+tipo)){
						if(typeField.getSimpleName().equals("Date") && (result!=null?""+result:"").trim().length()== 0 ){
							result = null;
						}
					}					
				}

				/*
				if(result!=null){
					if(result instanceof Number){
						
					}
					if((""+result.getClass().getName()).equals(typeField.getName())){
						
					}
				}*/
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return result;
	}
	

	public String validarInconsistencias(VwPersonaEvento objDataEvento,Map<String,Object> mapData, boolean esRENIEC){
		String result =""+ValorRetorno.OK;
		try{
			String origen = (esRENIEC?"RENIEC":"SGA");
			String mensaje = "";
			//USAR REFLECTION
			//NOMBRE
			Field fieldObjAux =objDataEvento.getClass().getDeclaredField(NOMBRES);
			String headerKeyAux = getHeaderMatchCampoFormatoFile(NOMBRES, true);
			Object valorAux = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObjAux.getType());
			if(!(""+valorAux).trim().toUpperCase().equals((""+objDataEvento.getNombres()).trim().toUpperCase())){
				mensaje = mensaje+"Inconsistencia en "+NOMBRES+": "+origen+" =/= ARCHIVO.";
			}


			//SEXO
			
			fieldObjAux =objDataEvento.getClass().getDeclaredField(SEXO);
			headerKeyAux = getHeaderMatchCampoFormatoFile(SEXO, true);
			valorAux = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObjAux.getType());
			//CONERT CODIGO SEXO
			String valTemp = (""+valorAux).trim()+"XX";//Artificio
			//OBTENER CODIGO SEXO 
			String valAux = valTemp.substring(0,2).toUpperCase();
			valAux=Constant.getPropertyServ("PAR_PREF_SEXO_"+valAux);
			valorAux = valAux;						
			if(!(""+valorAux).trim().toUpperCase().equals((""+objDataEvento.getSexo()).trim().toUpperCase())){
				mensaje = mensaje+"Inconsistencia en "+SEXO+": "+origen+" =/= ARCHIVO.";
			}

			//FECHANACIMIENTO
			fieldObjAux =objDataEvento.getClass().getDeclaredField(FECHANACIMIENTO);
			headerKeyAux = getHeaderMatchCampoFormatoFile(FECHANACIMIENTO, true);
			valorAux = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObjAux.getType());
			if(valorAux!=null){
				if(valorAux instanceof Date){
					if(!(""+Utiles.printDate("yyyyMMdd", (Date)valorAux)).
							equals((""+Utiles.printDate("yyyyMMdd",objDataEvento.getFechanacimiento())))){
						mensaje = mensaje+"Inconsistencia en "+FECHANACIMIENTO+": "+origen+" =/= ARCHIVO.";
					}	
				}																			
			}

			if(!esRENIEC){
				//CORREOELECTRONICO
				fieldObjAux =objDataEvento.getClass().getDeclaredField(CORREOELECTRONICO);
				headerKeyAux = getHeaderMatchCampoFormatoFile(CORREOELECTRONICO, true);
				valorAux = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObjAux.getType());
				if(!(""+valorAux).trim().toUpperCase().equals((""+objDataEvento.getCorreoelectronico()).trim().toUpperCase())){
					mensaje = mensaje+"Inconsistencia en "+CORREOELECTRONICO+": "+origen+" =/= ARCHIVO.";
				}	
				//CORREOINSTITUCIONAL
				fieldObjAux =objDataEvento.getClass().getDeclaredField(CORREOINSTITUCIONAL);
				headerKeyAux = getHeaderMatchCampoFormatoFile(CORREOINSTITUCIONAL, true);
				valorAux = getValorMatchDataFormatoFile(headerKeyAux, mapData, fieldObjAux.getType());
				if(!(""+valorAux).trim().toUpperCase().equals((""+objDataEvento.getCorreoinstitucional()).trim().toUpperCase())){
					mensaje = mensaje+"Inconsistencia en "+CORREOINSTITUCIONAL+": "+origen+" =/= ARCHIVO.";
				}
			}
			
			if(mensaje.length()>0){
				return mensaje;
			}else{
				return result;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	public String getCampoMatchHeaderFormatoFile(String headerKey,boolean indicaOrdenNum){
		String nombreCampo ="";
		String valorFormato ="VALORFORMATO_1";
		if((indicaOrdenNum?"1":valorFormato).equals(headerKey)){
			return NOMBRES;
		}else if((indicaOrdenNum?"2":valorFormato).equals(headerKey)){
			return APELLIDOPATERNO;
		}else if((indicaOrdenNum?"3":valorFormato).equals(headerKey)){
			return CORREOELECTRONICO;
		}else if((indicaOrdenNum?"4":valorFormato).equals(headerKey)){
			return ESTADOASISTENTEDESC;
		}else if((indicaOrdenNum?"5":valorFormato).equals(headerKey)){
			return TELEFONO;
		}else if((indicaOrdenNum?"6":valorFormato).equals(headerKey)){
			return SEXO;
		}else if((indicaOrdenNum?"7":valorFormato).equals(headerKey)){
			return FECHANACIMIENTO;
		}else if((indicaOrdenNum?"8":valorFormato).equals(headerKey)){
			return DOCUMENTO;
		}else if((indicaOrdenNum?"9":valorFormato).equals(headerKey)){
			return INSTITUCIONDESC;
		}else if((indicaOrdenNum?"10":valorFormato).equals(headerKey)){
			return CARGODESC;
		}else if((indicaOrdenNum?"11":valorFormato).equals(headerKey)){
			return TELEFONOLABOR;
		}else if((indicaOrdenNum?"12":valorFormato).equals(headerKey)){
			return CORREOINSTITUCIONAL;
		}else if((indicaOrdenNum?"13":valorFormato).equals(headerKey)){
			return CORREOELECTRONICO;
		}else if((indicaOrdenNum?"14":valorFormato).equals(headerKey)){
			return NIVELGOBIERNODESC;
		}else if((indicaOrdenNum?"15":valorFormato).equals(headerKey)){
			return OBSERVACIONES;
		}else if((indicaOrdenNum?"16":valorFormato).equals(headerKey)){
			return ESTADOCONSENTCONDDESC;
		}
		return nombreCampo;
	}
	
	
	public String getHeaderMatchCampoFormatoFile(String campo,boolean indicaOrdenNum){
		String nombreCampo ="";
		String valorFormato ="VALORFORMATO_1";
		if((indicaOrdenNum?NOMBRES:valorFormato).equals(campo)){
			return "1";
		}else if((indicaOrdenNum?APELLIDOPATERNO:valorFormato).equals(campo)){
			return "2";
		}else if((indicaOrdenNum?CORREOELECTRONICO:valorFormato).equals(campo)){
			return "3";
		}else if((indicaOrdenNum?ESTADOASISTENTEDESC:valorFormato).equals(campo)){
			return "4";
		}else if((indicaOrdenNum?TELEFONO:valorFormato).equals(campo)){
			return "5";
		}else if((indicaOrdenNum?SEXO:valorFormato).equals(campo)){
			return "6";
		}else if((indicaOrdenNum?FECHANACIMIENTO:valorFormato).equals(campo)){
			return "7";
		}else if((indicaOrdenNum?DOCUMENTO:valorFormato).equals(campo)){
			return "8";
		}else if((indicaOrdenNum?INSTITUCIONDESC:valorFormato).equals(campo)){
			return "9";
		}else if((indicaOrdenNum?CARGODESC:valorFormato).equals(campo)){
			return "10";
		}else if((indicaOrdenNum?TELEFONOLABOR:valorFormato).equals(campo)){
			return "11";
		}else if((indicaOrdenNum?CORREOINSTITUCIONAL:valorFormato).equals(campo)){
			return "12";
		}else if((indicaOrdenNum?CORREOELECTRONICO:valorFormato).equals(campo)){
			return "13";
		}else if((indicaOrdenNum?NIVELGOBIERNODESC:valorFormato).equals(campo)){
			return "14";
		}else if((indicaOrdenNum?OBSERVACIONES:valorFormato).equals(campo)){
			return "15";
		}else if((indicaOrdenNum?ESTADOCONSENTCONDDESC:valorFormato).equals(campo)){
			return "16";
		}
		return nombreCampo;
	}
	
/*********************************VARIABLE AUX VW_PERSONA_EVENTO**********************************************/
	public static final String	APELLIDOMATERNO	=	"apellidomaterno";
	public static final String	APELLIDOPATERNO	=	"apellidopaterno";
	public static final String	CARGODESC	=	"cargoDesc";
	public static final String	CARGOID	=	"cargoid";
	public static final String	CELULAREMERGENCIA	=	"celularemergencia";
	public static final String	CODIGOPOSTAL	=	"codigopostal";
	public static final String	CORREOELECTRONICO	=	"correoelectronico";
	public static final String	CORREOINSTITUCIONAL	=	"correoinstitucional";
	public static final String	DEPARTAMENTO	=	"departamento";
	public static final String	DIRECCION	=	"direccion";
	public static final String	DIRECCIONREFERENCIA	=	"direccionreferencia";
	public static final String	DISTRITOLABOR	=	"distritolabor";
	public static final String	DOCUMENTO	=	"documento";
	public static final String	DPTOLABOR	=	"dptolabor";
	public static final String	ESTADOASISTENTE	=	"estadoAsistente";
	public static final String	ESTADOASISTENTEDESC	=	"estadoAsistenteDesc";
	public static final String	ESTADOCONSENTCONDDESC	=	"estadoConsentCondDesc";
	public static final String	ESTADOCONSENTCONDICIONES	=	"estadoConsentCondiciones";
	public static final String	ESTADOPERSONA	=	"estadopersona";
	public static final String	EVEDESCRIPCION	=	"evedescripcion";
	public static final String	EVEESTADO	=	"eveestado";
	public static final String	EVEESTADOPROCESO	=	"eveestadoproceso";
	public static final String	EVEESTADOPROCESODESC	=	"eveestadoprocesoDesc";
	public static final String	EVEEVENTOID	=	"eveeventoid";
	public static final String	EVEFECHAFIN	=	"evefechafin";
	public static final String	EVEFECHAINICIO	=	"evefechainicio";
	public static final String	EVETIPO	=	"evetipo";
	public static final String	FECHANACIMIENTO	=	"fechanacimiento";
	public static final String	IDCONTADOR	=	"idcontador";
	public static final String	INSTITUCIONDESC	=	"institucionDesc";
	public static final String	INSTITUCIONID	=	"institucionid";
	public static final String	MOEMESTUDIOID	=	"moemestudioid";
	public static final String	NACIONALIDAD	=	"nacionalidad";
	public static final String	NIVELGOBIERNO	=	"nivelgobierno";
	public static final String	NIVELGOBIERNODESC	=	"nivelgobiernoDesc";
	public static final String	NIVELINSTRUCCION	=	"nivelinstruccion";
	public static final String	NOMBRECOMPLETO	=	"nombrecompleto";
	public static final String	NOMBRES	=	"nombres";
	public static final String	OBSERVACIONES	=	"observaciones";
	public static final String	PERPERIODOID	=	"perperiodoid";
	public static final String	PERSONA	=	"persona";
	public static final String	PERSONAANT	=	"personaant";
	public static final String	PERSONAEVEESTADO	=	"personaeveEstado";
	public static final String	PERSONAEVENTOID	=	"personaeventoid";
	public static final String	PROVINCIA	=	"provincia";
	public static final String	PROVINCIALABOR	=	"provincialabor";
	public static final String	SEXO	=	"sexo";
	public static final String	TELEFONO	=	"telefono";
	public static final String	TIPODOCUMENTO	=	"tipodocumento";
	public static final String	ULTIMAFECHAMODIF	=	"ultimafechamodif";
	public static final String	ULTIMOUSUARIO	=	"ultimousuario";
	public static final String	UNEUNEGOCIOID	=	"uneunegocioid";
	
	public static final String	HRHHORHEADERID	=	"hrhhorheaderid";
	public static final String	TELEFONOLABOR	=	"telefonoLabor";

	@Override
	@Transactional
	public long guardarMasivo(List<VwPersonaEvento> listaDao) {
		long result =0;
		long valorTransac=0;
		try {			
			
			for(VwPersonaEvento objSave: listaDao){
				int idPersona =0;
				if(Constant.INSERT_db.equals(objSave.getAccion())){
					//EN EL CASO DE SER NUEVOS REGISTROS (DE LAS PERSONAS)
					
					//Comprobamos si aÃºn no existe ningÃºn registro de esa persona (CON EL DNI)
					Personamast objPersona=null;
					 List<Personamast> listaPerso = 
							 personamastDao.obtenerPorDocumento(Constant.DOCUMENTO_DNI, ""+objSave.getDocumento());
					if(listaPerso!=null){
						if(listaPerso.size()>0){
							//TOMAR PRIMERO POR DEFECTO (Solo debe listar 1 elemento)
							objPersona = listaPerso.get(0);
						}
					}
					if(objPersona!=null){
						//ACTUALIZAR
						objPersona.setTelefono(objSave.getTelefono());
						objPersona.setTelefonoemergencia(objSave.getString2());//AUX TELEFONO LABOR
						objPersona.setCorreoelectronico(objSave.getCorreoelectronico());
						objPersona.setCorreoinstitucional(objSave.getCorreoinstitucional());																		
						idPersona = personamastDao.actualizarPersona(objPersona);
					}else{
						Personamast registro = new Personamast();										
						registro.setTipodocumento(objSave.getTipodocumento());
						registro.setDocumento(objSave.getDocumento());
						registro.setNombres(objSave.getNombres());
						registro.setNombrecompleto(objSave.getNombrecompleto());
						registro.setApellidomaterno(objSave.getApellidomaterno());
						registro.setApellidopaterno(objSave.getApellidopaterno());
						registro.setSexo(objSave.getSexo());
						registro.setEscliente(true);
						registro.setTelefono(objSave.getTelefono());
						registro.setTelefonoemergencia(objSave.getTelefonoLabor());//AUX TELEFONO LABOR
						registro.setCorreoelectronico(objSave.getCorreoelectronico());
						registro.setCorreoinstitucional(objSave.getCorreoinstitucional());
						registro.setFechanacimiento(objSave.getFechanacimiento());
						registro.setEstado(Constant.ACTIVO);
						registro.setTipopersona(Constant.PERSONA_NATURAL);
						registro.setPersona(null);
						//AUX .. campos en nulo?
						registro.setInstitucionid(objSave.getInstitucionid());
						registro.setCargoid(objSave.getCargoid());
						registro.setNivelgobierno(objSave.getNivelgobierno());
						registro.setBusqueda(objSave.getNombrecompleto());
						registro.setOrigen(Constant.DEFAULT_PAIS_ID);
						/*				
						registro.setDepartamento(persona.getDepartamentoUbigeo());
						registro.setProvincia(persona.getProvinciaUbigeo());
						registro.setDistrito(persona.getDistritoUbigeo());
						registro.setDireccion(persona.getDireccion());
						registro.setDiscapacidadflag(persona.isTieneDiscapacidad());
						registro.setEnfermedadgraveflag(persona.isEnfermedadGrave());					
											
						registro.setFechanacimiento(persona.getFechaNacimiento());
						// ACERCA DEL TRABAJO 
						registro.setCargoid(persona.getCargoId());
						registro.setInstitucionid(persona.getInstitucionId());
						registro.setEstado(Constant.ACTIVO);
						registro.setGrupoetnico(persona.getGrupoetnico());
						registro.setDptolabor(persona.getLaborDepartamento());
						registro.setProvincialabor(persona.getLaborProvincia());
						registro.setDistritolabor(persona.getLaborDistrito());
						registro.setDireccionreferencia(persona.getLaborDireccion());
						//ADD
						registro.setNivelgobierno(persona.getNivelgobierno());
						registro.setPersonaant(persona.getTipoProcEducacion());//AUC para tipo C.E. Procedencia		
						*/
						
						//
						valorTransac = -1;
						idPersona = personamastDao.guardar(registro);
					}

					///....					
				}else if(Constant.UPDATE_db.equals(objSave.getAccion())){
					//EN EL CASO De QUE LAS PERSONAS YA EXISTAN (DE LAS PERSONAS)
					idPersona = objSave.getPersona();
					Personamast  registro = personamastDao.obtenerPorId(idPersona);
					if(registro!=null){												
									
						registro.setTelefono(objSave.getTelefono());
						registro.setTelefonoemergencia(objSave.getString2());//AUX TELEFONO LABOR
						registro.setCorreoelectronico(objSave.getCorreoelectronico());
						registro.setCorreoinstitucional(objSave.getCorreoinstitucional());												
						
						idPersona = personamastDao.actualizarPersona(registro);
					}
				
				}
				if(idPersona>0){
					//PERSONA EXISTE EN EL MISMO EVENTO?
					SaPersonaEvento objFiltroValid = new SaPersonaEvento();
					SaPersonaEventoPK objPk = new SaPersonaEventoPK(); 
					objPk.setPersona(idPersona);
					objFiltroValid.setId(objPk);
					objFiltroValid.setUneunegocioid(objSave.getUneunegocioid());
					objFiltroValid.setMoemestudioid(objSave.getMoemestudioid());
					objFiltroValid.setHrhhorheaderid(objSave.getHrhhorheaderid());							
					List<SaPersonaEvento> listaAux =  saPersonaEventoDao.listarElementos(objFiltroValid);
					boolean existeEnEvento = false;
					if(listaAux!=null){
						if(listaAux.size()>0){
							//QUIERE DECIR QUE YA SE REGISTRÃ“ A DICHA PERSONA EN EL MISMO EVENTO PROGRAMADO.
							existeEnEvento = true;
						}									
					}
					if(!existeEnEvento){						
						SaPersonaEvento registroEventoPersona = new SaPersonaEvento();
						registroEventoPersona.getId().setPersona(idPersona);
						registroEventoPersona.getId().setPersonaeventoid(null);
						registroEventoPersona.setEveeventoid(objSave.getEveeventoid());
						registroEventoPersona.setHrhhorheaderid(objSave.getHrhhorheaderid());
						
						registroEventoPersona.setUneunegocioid(objSave.getUneunegocioid());
						registroEventoPersona.setMoemestudioid(objSave.getMoemestudioid());
						registroEventoPersona.setPerperiodoid(objSave.getPerperiodoid());
						registroEventoPersona.setEstadoAsistente(objSave.getEstadoAsistente());
						registroEventoPersona.setEstadoConsentCondiciones(objSave.getEstadoConsentCondiciones());
						registroEventoPersona.setObservaciones(objSave.getObservaciones());
						registroEventoPersona.setEstado(objSave.getPersonaeveEstado());
						registroEventoPersona.setUltimousuario(objSave.getUltimousuario());
						registroEventoPersona.setUltimafechamodif(objSave.getUltimafechamodif());
						registroEventoPersona.setInstitucionlaborAuxiliar(objSave.getInstitucionDesc());
						registroEventoPersona.setCargolaborAuxiliar(objSave.getCargoDesc());
						registroEventoPersona.setNivelgobiernolaborAuxiliar(objSave.getNivelgobiernoDesc());
						valorTransac = -2;				
						long idSec = saPersonaEventoDao.guardar(registroEventoPersona);	
						result = 1;//EXITO
					}else{
						objSave.setDescripcion01("La Persona de Documento : "+objSave.getDocumento()+", ya se encuentra en el evento");					
					}
				}
				
			}									
			return result;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result = valorTransac;
		}
		return result;
	}



}
