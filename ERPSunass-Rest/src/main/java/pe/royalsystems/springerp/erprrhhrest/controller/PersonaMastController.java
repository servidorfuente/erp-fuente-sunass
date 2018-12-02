package erp.realcoresystems.pe.erprrhhrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.commons.model.PaginaModel;
import erp.realcoresystems.pe.erprrhhrest.model.JsonViewInterfaces;
import erp.realcoresystems.pe.erprrhhrest.model.PersonaMastJson;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;
import erp.realcoresystems.pe.erprrhhrest.util.UtilesRest;
import erp.realcoresystems.pe.generales.service.ClienteMastService;
import erp.realcoresystems.pe.generales.service.PersonamastService;
import erp.realcoresystems.pe.model.comercial.domain.ClienteMast;
import erp.realcoresystems.pe.model.generales.domain.Personamast;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.utilesJson.util.JsonViewAssembler;

import java.util.List;

//import erp.realcoresystems.pe.erpcomercialrest.util.JsonViewAssembler;


@RestController
@RequestMapping("/api/ispring/persona") 
public class PersonaMastController {

	private final String FILE_PERSONA_MAPPING_ASSEMBLER="mapping-assembler\\persona-mapper.json";
	
	@Autowired
	PersonamastService personaMastService ; 

	@Autowired
	ClienteMastService clienteMastService ; 
	
	 private JsonViewAssembler<Personamast, PersonaMastJson> jsonAssemb =
			 new JsonViewAssembler<Personamast, PersonaMastJson>(PersonaMastJson.class,
					 UtilesRest.getFileResource(FILE_PERSONA_MAPPING_ASSEMBLER));
	 private JsonViewAssembler<PersonaMastJson, Personamast> jsonAssembInverso =
			 new JsonViewAssembler<PersonaMastJson, Personamast>(Personamast.class,
					 UtilesRest.getFileResource(FILE_PERSONA_MAPPING_ASSEMBLER));


	     
	    /** listar todos los elementos ...
	     * @return
	     */	    	  
	    @GetMapping(value = "/all/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<PersonaMastJson>> listAllElementos() {
	        List<Personamast> users = personaMastService.listar(new Personamast());	        	        	       	        
	        
	        if(users.isEmpty()){
	            return new ResponseEntity<List<PersonaMastJson>>(HttpStatus.NO_CONTENT);
	        }else{
		        List<PersonaMastJson> usersJson = jsonAssemb.getJsonListDozer(users);
		        
		        return new ResponseEntity<List<PersonaMastJson>>(usersJson, HttpStatus.OK);
	        }
	    }
	 
	 
	   
	     
	    /** Retornar un Objeto por Id
	     * @param id
	     * @return
	     */	    
	    @GetMapping(value = "/persona/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<PersonaMastJson> getElementoId(@PathVariable("id") Integer id) {
	    	Personamast objResult = personaMastService.obtenerPorId(id);
	        if (objResult == null) {	            
	            return new ResponseEntity<PersonaMastJson>(HttpStatus.NOT_FOUND);
	        }else{	        	
	        	return new ResponseEntity<PersonaMastJson>(jsonAssemb.getJsonObject(objResult), HttpStatus.OK);
	        }
	    }
	 
	    /** Retornar un Objeto por Id
	     * @param id
	     * @return
	     */	    
	    @GetMapping(value = "/persona/doc/{tipoDocumento}/{documento}" , produces = MediaType.APPLICATION_JSON_VALUE)
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<PersonaMastJson>> getElementoDocumento(
	    		@PathVariable("tipoDocumento") String tipoDocumento,
	    		@PathVariable("documento") String documento
	    		) {	       
	    	
	        //System.out.println("Fetching User with id " + usuario);
	    	Personamast persona = new Personamast();
	    	persona.setTipoDocumento(tipoDocumento);
	    	persona.setDocumento(documento);
	    	List<Personamast> personas = personaMastService.listar(persona);
	        if(personas.isEmpty()){
	            return new ResponseEntity<List<PersonaMastJson>>(HttpStatus.NO_CONTENT);
	        }else{
		        List<PersonaMastJson> usersJson = jsonAssemb.getJsonListDozer(personas);
		        
		        return new ResponseEntity<List<PersonaMastJson>>(usersJson, HttpStatus.OK);
	        }
	    }

	    
	    /** Listado POST, con filtros variados, SIN PAGINAR
	     * @param usuario
	     * @param ucBuilder
	     * @return
	     */
	        		
	    @PostMapping(value = "/personas/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<PersonaMastJson>> listElementos(
                @RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	        //System.out.println("Fetching User with id " + usuario);
	    	
	    	List<Personamast> users = personaMastService.listar(
	    			jsonAssembInverso.getJsonObject(persona));
	        if(users.isEmpty()){
	            return new ResponseEntity<List<PersonaMastJson>>(HttpStatus.NO_CONTENT);
	        }else{
		        List<PersonaMastJson> usersJson = jsonAssemb.getJsonListDozer(users);
		        
		        return new ResponseEntity<List<PersonaMastJson>>(usersJson, HttpStatus.OK);
	        }
	        	     
	    }
	    
	    /** Listado POST, con filtros variados, PAGINADO
	     * @param usuario
	     * @param ucBuilder
	     * @return
	     */	        
	    @PostMapping(value = "/personas/pag/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<PersonaMastJson>> listElementosPaginado(@RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	        //System.out.println("Fetching User with id " + usuario);
	    	Personamast filtro = jsonAssembInverso.getJsonObject(persona);
	    	 PaginaModel<Personamast> pagModel =  personaMastService.listarPaginado(filtro);
	    		        	        	       	        	        
	        if(pagModel.getNroTotalElementos() <=  0){
	            return new ResponseEntity<List<PersonaMastJson>>(HttpStatus.NO_CONTENT);
	        }else{	        	
	        	List<PersonaMastJson> listadoJson = jsonAssemb.getJsonListDozer(pagModel.getListaElementos());
	        	/** Verificar que si apesar de listar paginado no se requiere la paginacion */
	        	if(persona.isPaginable()){
		        	//Set valor de la cuenta para la paginacion...
		        	int cuenta =pagModel.getNroTotalElementos();
		        	//listado.stream().forEach(u -> {u.setContadorTotal(cuenta);});	        		        	        		        			        
		        	for(PersonaMastJson obj : listadoJson){
		        		obj.setContadorTotal(cuenta);
		        	}
	        		
	        	}
		        return new ResponseEntity<List<PersonaMastJson>>(listadoJson, HttpStatus.OK);
	        }
	        	     
	    }
	    	     
	    
	    @PostMapping(value = "/clientes/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<PersonaMastJson>> listElementosClients(
                @RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	        //System.out.println("Fetching User with id " + usuario);
	    	Personamast filtro = jsonAssembInverso.getJsonObject(persona);
	    	filtro.setEsCliente(Constant.SI_db);
	    	filtro.setEsOtro(Constant.SI_db);	    	
	    	filtro.setNombreConsulta("CLIENTE_U_OTRO");

	    	List<Personamast> users = personaMastService.listar(
	    			jsonAssembInverso.getJsonObject(persona));
	        if(users.isEmpty()){
	            return new ResponseEntity<List<PersonaMastJson>>(HttpStatus.NO_CONTENT);
	        }else{
		        List<PersonaMastJson> usersJson = jsonAssemb.getJsonListDozer(users);
		        
		        return new ResponseEntity<List<PersonaMastJson>>(usersJson, HttpStatus.OK);
	        }
	        	     
	    }
	    
	    /** Guardar nuevo
	     * @param persona
	     * @param ucBuilder
	     * @return
	     */	    
	    @PostMapping(value = "/persona/i/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<PersonaMastJson> guardar(@RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	         try{	 
	        	 int result = 0;
	        	 Personamast objTransacc = jsonAssembInverso.getJsonObject(persona);
	        	 /**En el caso POSEYERA ROWUID en la DB*/
	        	 //set ID UNIQUE ex: 864E2DE8-DBAD-4078-972F-DB70F7FAA0E3
//	        	 objTransacc.setRowguid(""+UtilesCommons.getIntRandomLongitud(8)+"-"
//	        			 		+UtilesCommons.getIntRandomLongitud(4)+"-"
//	        			 		+UtilesCommons.getIntRandomLongitud(4)+"-"
//	        			 		+UtilesCommons.getIntRandomLongitud(4)+"-"
//	        			 		+UtilesCommons.getIntRandomLongitud(8)+""+""+UtilesCommons.getIntRandomLongitud(4)
//	        			 		
//	        			 );
	        	
	        	 if(Constant.SI_db.equals(UtilesRest.getAppProperty("rs.unidadreplicacion.uso.enabled_crearpersonas"))){
	        		 result = personaMastService.guardarXCorrelativoUnidadReplicacion(objTransacc, 
	        				 UtilesRest.getAppProperty("rs.unidadreplicacion.code"));
	        	 }else{
	        		 result = personaMastService.guardar(objTransacc);
	        	 }
	        		        	         	
	        	 if(result > 0){
	        		 objTransacc.setPersona(result);
	        		 persona.setPersona(result);
	        	 }	
			     return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.CREATED);
		     }catch(Exception e){
		        return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		     }		         	         
	    }
	    
	    /**Actualizar
	     * @param persona
	     * @param ucBuilder
	     * @return
	     */	    
	    @PostMapping(value = "/persona/u/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<PersonaMastJson> actualizar(@RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	         try{	 
	        	 int result = 0;
	        	 //Personamast objTransacc = jsonAssembInverso.getJsonObject(persona);
	        	 Personamast objTransacc =  personaMastService.obtenerPorId(persona.getPersona());
	        	 if(objTransacc!=null){
	        		 //Actualizar Objeto obtenido con los valores del Objeto parametro recibido...
	        		 objTransacc = jsonAssembInverso.getJsonObjectDestino(persona, objTransacc);
		        	 result = personaMastService.actualizar(objTransacc);
		        	 if(result > 0){
		        		 //persona.setUsuaId(result);
		        	 }		        		 
	        	 }
	        	 if(result > 0){
	        		 return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.CREATED);
	        	 }else{
	        		 return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
	        	 }			     
		     }catch(Exception e){
		        return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		     }		         	         
	    }
	    
	    /**Eliminar
	     * @param persona
	     * @param ucBuilder
	     * @return
	     */	    
	    @DeleteMapping(value = "/persona/u/")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<PersonaMastJson> eliminar(@RequestBody PersonaMastJson persona, UriComponentsBuilder ucBuilder) {
	         try{	 
	        	 int result = 0;
	        	 //Personamast objTransacc = jsonAssembInverso.getJsonObject(persona);
	        	 Personamast objTransacc =  personaMastService.obtenerPorId(persona.getPersona());
	        	 if(objTransacc!=null){
	        		 //Actualizar Objeto obtenido con los valores del Objeto parametro recibido...
	        		 objTransacc = jsonAssembInverso.getJsonObjectDestino(persona, objTransacc);
		        	 result = personaMastService.eliminar(objTransacc);
		        	 if(result > 0){
		        		 //persona.setUsuaId(result);
		        	 }		        		 
	        	 }
	        	 if(result > 0){
	        		 return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.CREATED);
	        	 }else{
	        		 return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
	        	 }			     
		     }catch(Exception e){
		        return new ResponseEntity<PersonaMastJson>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		     }	
	         
	    }	 	  		 
	
	    /** generar al CLIENTEMAST dede el id de una PERSONA ....si ya existe se devuelve el id existente
	     * @param personaId
	     * @return
	     */	   
	    @PostMapping(value = "/cliente/generar/{personaId}")
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<Integer> generarClientePersona(
	    		@PathVariable("personaId") Integer personaId) {
	    	
	    	Integer idClienteActual =0;
	         try{	 		        	 
	        	 Personamast persona = personaMastService.obtenerPorId(personaId);
	        	 if(persona!=null){
	        		ClienteMast cliente =  clienteMastService.obtenerPorId(personaId);
	        		if(cliente!=null){
	        			//Ya existe cliente
	        			idClienteActual = cliente.getCliente();
	        		}else{
	        			//crear cliente
	        			ClienteMast clienteSave = new ClienteMast();
	        			clienteSave.setCliente(personaId);
	        			clienteSave.setEstadocliente(UtilesCommons.ACTIVO_db);
	        			//clienteSave.setFechaRegistro(new Date());	        			
	        			idClienteActual = clienteMastService.guardar(clienteSave);
	        		}
	        		//ACTUALIZAR CLIENTE FLAG en PERSONA
        			if(idClienteActual>0){
        				persona.setEsCliente(UtilesRest.SI_db);
        				personaMastService.actualizar(persona);
        			}
	        	 }	  	        	 
			     return new ResponseEntity<Integer>(idClienteActual, HttpStatus.CREATED);
		     }catch(Exception e){
		        return new ResponseEntity<Integer>(idClienteActual, HttpStatus.INTERNAL_SERVER_ERROR);
		     }		         	         
	    }
}
