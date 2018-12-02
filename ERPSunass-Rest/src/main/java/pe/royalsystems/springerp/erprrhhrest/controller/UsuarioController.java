package erp.realcoresystems.pe.erprrhhrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import erp.realcoresystems.pe.comercial.service.MaMaestroMiscelaneoDetalleService;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.erprrhhrest.model.JsonViewInterfaces;
import erp.realcoresystems.pe.erprrhhrest.model.UsuarioJson;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;
import erp.realcoresystems.pe.generales.service.CompanyownerService;
import erp.realcoresystems.pe.generales.service.EmpleadoMastService;
import erp.realcoresystems.pe.generales.service.UsuarioService;
import erp.realcoresystems.pe.model.generales.domain.EmpleadoMast;
import erp.realcoresystems.pe.model.generales.domain.Usuario;
import erp.realcoresystems.pe.utilesJson.util.JsonViewAssembler;

import java.util.List;

@RestController
@RequestMapping("/api/ispring/usuario") 
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService ;
	
	@Autowired
	EmpleadoMastService empleadoService;
	
	@Autowired
	CompanyownerService companyownerService;

	@Autowired
	MaMaestroMiscelaneoDetalleService maestroMiscelaneoDetalleService;

	
	 private JsonViewAssembler<Usuario, UsuarioJson> jsonAssemb =
			 new JsonViewAssembler<Usuario, UsuarioJson>(UsuarioJson.class);

	 private JsonViewAssembler<UsuarioJson, Usuario> jsonAssembInverso =
			 new JsonViewAssembler<UsuarioJson, Usuario>(Usuario.class);
	 
	    /** Obtener todos los elementos
	     * @return
	     */
	    @RequestMapping(value = "/all", method = RequestMethod.GET)	   
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<List<UsuarioJson>> listAllElementos() {
	    	Usuario objRest = new Usuario();	    	
	        List<Usuario> listaElementos = null; //usuarioService.listarElementos(objRest,false);
	        if(listaElementos.isEmpty()){
	            return new ResponseEntity<List<UsuarioJson>>(HttpStatus.NO_CONTENT);
	        }else{	        	
	        	
	        	
	        	List<UsuarioJson> listaElementoJson = jsonAssemb.getJsonList(listaElementos);
		        return new ResponseEntity<List<UsuarioJson>>(listaElementoJson, HttpStatus.OK);
	        }
	    }	 

	    /** Obtener un Usuario por el LOGIN

	     * @return
	     */
	    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
	    public ResponseEntity<UsuarioJson> getLogin(@RequestBody UsuarioJson objRest, UriComponentsBuilder ucBuilder) {
	    	
	    	Usuario userTemp = jsonAssembInverso.getJsonObject(objRest);
	    	Usuario user = usuarioService.validarLogin(objRest.getUsuario(),objRest.getClave());
	        if (user == null) {	            
	            return new ResponseEntity<UsuarioJson>(HttpStatus.NOT_FOUND);
	        }else{	        	
	        	//traer datos del EMPLEADO
	        	UsuarioJson userJson =  jsonAssemb.getJsonObject(user);
	        	EmpleadoMast empleado = getEmpleadoUsuario(user);
	        	if(empleado!=null){	        		        		
	        		userJson.setPersona(empleado.getEmpleado());
	        		userJson.setAreaRevisora(empleado.getOficina());
	        		userJson.setCompaniaSocio(empleado.getCompaniaSocio());
	        		userJson.setCompaniaSocioDesc(empleado.getString1());
	        	}
	        	return new ResponseEntity<UsuarioJson>(userJson, HttpStatus.OK);
	        }
	    }
	    
		public EmpleadoMast getEmpleadoUsuario(Usuario usuario){
			try {
				EmpleadoMast result = null;
				if (usuario!=null){
					if(UtilesCommons.noEsVacio(usuario.getPersona())){
						EmpleadoMast empleado = empleadoService.obtenerPorId(usuario.getPersona());
						if(UtilesCommons.noEsNulo(empleado)){
							result = empleado;
						} 
					}else{
						EmpleadoMast objEmpleadoFiltro = new EmpleadoMast();
						objEmpleadoFiltro.setCodigoUsuario(usuario.getUsuario());
						List<EmpleadoMast> listaEmpleado = empleadoService.listarElementos(objEmpleadoFiltro,false);
						//DEBERÍA OBTENER UN SOLO EMPLEADO
						
						if(listaEmpleado!=null){
							if(listaEmpleado.size()>0){
								result = listaEmpleado.get(0);
							}
						}					
					}
					
					//set datos de compania y AREA REVISORA


				}
				return result;
			} catch (Exception e) {		
				e.printStackTrace();
				return null;
			}
		}	    
}
