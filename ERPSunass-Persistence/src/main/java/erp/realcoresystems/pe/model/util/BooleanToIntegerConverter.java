package erp.realcoresystems.pe.model.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author RosasH
 *
 *	Convierte un entero de la base de datos en booleano como atributo de la entidad y viceversa.
 */

@Converter
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

	private static final Integer INTEGER_ZERO = new Integer(0);
	private static final Integer INTEGER_ONE = new Integer(1);
	
	@Override
	public Boolean convertToEntityAttribute(Integer dbData) {
		if(dbData != null && dbData.compareTo(INTEGER_ONE) == 0){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}
	}
	
	@Override
	public Integer convertToDatabaseColumn(Boolean attribute) {
		if(attribute == null || attribute.compareTo(Boolean.FALSE) == 0){
			return INTEGER_ZERO;
		}else{
			return INTEGER_ONE;
		}
	}
}
