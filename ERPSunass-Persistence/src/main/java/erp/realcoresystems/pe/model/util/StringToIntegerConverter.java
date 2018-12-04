package erp.realcoresystems.pe.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class StringToIntegerConverter implements AttributeConverter<String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		if(esNumeroInteger(attribute)){
			return Integer.parseInt(attribute);
		}else{
			return null;
		}
	}
	
	@Override
	public String convertToEntityAttribute(Integer dbData) {
		if(dbData == null){
			return null;
		}else{
			return dbData.toString();
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
