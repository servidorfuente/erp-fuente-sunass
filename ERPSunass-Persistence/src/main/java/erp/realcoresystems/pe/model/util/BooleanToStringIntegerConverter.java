package erp.realcoresystems.pe.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToStringIntegerConverter implements AttributeConverter<Boolean, String> {
	
	private static final String STR_TRUE = "1";
	private static final String STR_FALSE = "0";
	
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if(attribute != null && attribute.compareTo(Boolean.TRUE) == 0){
			return STR_TRUE;
		}else{
			return STR_FALSE;
		}
	}
	
	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if(dbData != null && !dbData.trim().isEmpty() && dbData.equalsIgnoreCase(STR_TRUE)){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}

}
