package erp.realcoresystems.pe.erprrhhrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import erp.realcoresystems.pe.erprrhhrest.model.EmpleadoMastJson;
import erp.realcoresystems.pe.erprrhhrest.model.JsonViewInterfaces;
import erp.realcoresystems.pe.erprrhhrest.model.PersonaMastJson;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;
import erp.realcoresystems.pe.erprrhhrest.util.UtilesRest;
import erp.realcoresystems.pe.generales.service.EmpleadoMastService;
import erp.realcoresystems.pe.generales.service.PersonamastService;
import erp.realcoresystems.pe.model.generales.domain.EmpleadoMast;
import erp.realcoresystems.pe.model.generales.domain.Personamast;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.utilesJson.util.JsonViewAssembler;

@RestController
@RequestMapping("/api/ispring/empleado")
public class EmpleadoMastController {

    @Autowired
    EmpleadoMastService empleadoMastService ;

    @Autowired
    PersonamastService personamastService ;

    private final String FILE_PERSONA_MAPPING_ASSEMBLER="mapping-assembler\\empleado-mapper.json";
    private JsonViewAssembler<EmpleadoMast, EmpleadoMastJson> jsonAssembEmp =
            new JsonViewAssembler<EmpleadoMast, EmpleadoMastJson>(EmpleadoMastJson.class);
    private JsonViewAssembler<EmpleadoMastJson, EmpleadoMast> jsonAssembInversoEmp =
            new JsonViewAssembler<EmpleadoMastJson, EmpleadoMast>(EmpleadoMast.class);
    private JsonViewAssembler<Personamast, PersonaMastJson> jsonAssembPers =
            new JsonViewAssembler<Personamast, PersonaMastJson>(PersonaMastJson.class);
    private JsonViewAssembler<PersonaMastJson, Personamast> jsonAssembInversoPers =
            new JsonViewAssembler<PersonaMastJson, Personamast>(Personamast.class);

    @PostMapping(value = "/registro/insert/")
    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
    public ResponseEntity<EmpleadoMastJson> guardar(@RequestBody EmpleadoMastJson empleado, UriComponentsBuilder ucBuilder) {
        int resultPersona = 0;
        int resultEmpleado = 0;
        try{
            resultPersona = 0;
            //Personamast objPersona = jsonAssembInversoPers.getJsonObject(persona);
            EmpleadoMast objEmpleado = jsonAssembInversoEmp.getJsonObject(empleado);
            //resultPersona = personamastService.guardar(objPersona);
            objEmpleado.setEmpleado(resultPersona);
            resultEmpleado = empleadoMastService.guardar(objEmpleado);
            EmpleadoMastJson empleadoJson =  jsonAssembEmp.getJsonObject(objEmpleado);
            return new ResponseEntity<EmpleadoMastJson>(empleadoJson, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<EmpleadoMastJson>(HttpStatus.NOT_FOUND);
        }
    }

 }

