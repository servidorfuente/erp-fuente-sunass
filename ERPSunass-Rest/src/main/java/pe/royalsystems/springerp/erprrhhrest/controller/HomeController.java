package erp.realcoresystems.pe.erprrhhrest.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import erp.realcoresystems.pe.commons.UtilesCommons;

import java.util.Date;


@RestController
@EnableAutoConfiguration
public class HomeController {
	

	
    @RequestMapping("/home")
    String home() {
    	return "Bienvenido en la fecha:"+UtilesCommons.printDate("dd/MM/yyyyy HH:mm:ss",new Date()) ;
    	//return "";
    }
}
