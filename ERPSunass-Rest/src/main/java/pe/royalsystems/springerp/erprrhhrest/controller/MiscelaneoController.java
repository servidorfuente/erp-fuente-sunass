package erp.realcoresystems.pe.erprrhhrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import erp.realcoresystems.pe.comercial.service.MaMaestroMiscelaneoDetalleService;
import erp.realcoresystems.pe.erprrhhrest.model.JsonViewInterfaces;
import erp.realcoresystems.pe.erprrhhrest.model.MiscelaneoJson;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;
import erp.realcoresystems.pe.model.generales.domain.MaMaestroMiscelaneoDetalle;
import erp.realcoresystems.pe.utilesJson.util.JsonViewAssembler;

import java.util.List;

@RestController
@RequestMapping("/api/ispring/miscelaneo")
public class MiscelaneoController {

    @Autowired
    MaMaestroMiscelaneoDetalleService miscelaneoDetalleService;
    private JsonViewAssembler<MaMaestroMiscelaneoDetalle, MiscelaneoJson> jsonAssemb =
            new JsonViewAssembler<MaMaestroMiscelaneoDetalle, MiscelaneoJson>(MiscelaneoJson.class);
    @RequestMapping(value = "/buscarcodigo/{codigo}", method = RequestMethod.GET)
    @JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
    public ResponseEntity<List<MiscelaneoJson>> listaElementos(@PathVariable("codigo") String codigo)
    {
        MaMaestroMiscelaneoDetalle objRest = new MaMaestroMiscelaneoDetalle();

        List<MaMaestroMiscelaneoDetalle> listaElementos = null; // miscelaneoDetalleService.listarElementos(objRest,false);
        if(listaElementos.isEmpty()){
            return new ResponseEntity<List<MiscelaneoJson>>(HttpStatus.NO_CONTENT);
        }else{

            List<MiscelaneoJson> listaElementoJson = jsonAssemb.getJsonList(listaElementos);
            return new ResponseEntity<List<MiscelaneoJson>>(listaElementoJson, HttpStatus.OK);
        }
    }

}
