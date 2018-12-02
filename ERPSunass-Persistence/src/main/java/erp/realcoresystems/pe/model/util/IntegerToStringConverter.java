package erp.realcoresystems.pe.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author RosasH
 *
 * Convierte un String-varchar-char de la base de datos en entero como atributo de la entidad y viceversa.
 */

@Converter
public class IntegerToStringConverter implements AttributeConverter<Integer, String> {

	@Override
	public Integer convertToEntityAttribute(String dbData) {
		if(esNumeroInteger(dbData)){
			Integer value = new Integer(dbData);
			return value;
		}else{
			return null;
		}
	}
	
	@Override
	public String convertToDatabaseColumn(Integer attribute) {
		if(attribute == null){
			return null;
		}else{
			return attribute.toString();
		}
	}
	
	public boolean esNumeroInteger(String value){
		try{
			Integer integer = Integer.parseInt(value);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
}
