package erp.realcoresystems.pe.commons.converter;


import erp.realcoresystems.pe.model.domain.Personamast;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.List;


@FacesConverter("personaConverter")
public class PersonaConverter implements Converter {

	

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	Object objetoLista = FacesUtil.getSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);
            	if(objetoLista!=null){
            		@SuppressWarnings("unchecked")
					List<Personamast> lista = (List<Personamast>) objetoLista;
            		for(Personamast result : lista){
            			if(value.equals(result.getPersona()+"")){            				
            				return result;
            			}
            		}
            	}            	  
               return new Personamast();
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al convertir", "error en el tema."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Personamast) object).getPersona());
        }
        else {
            return null;
        }
    }

    
} 