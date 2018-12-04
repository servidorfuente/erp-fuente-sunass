package erp.realcoresystems.pe.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author RosasH
 *
 *	Convierte un string-varchar-char de la base de datos en boolean como atributo de la entidad y viceversa.
 */

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

	private static final String YES_db = "Y";
	private static final String SI_db = "S";
	private static final String NO_db = "N";
	
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if(attribute == null || attribute.compareTo(Boolean.FALSE) == 0){
			return NO_db;
		}else{
			return YES_db;
		}
	}
	
	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		if(dbData != null 
				&& (dbData.equalsIgnoreCase(YES_db) || dbData.equalsIgnoreCase(SI_db))){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
}
