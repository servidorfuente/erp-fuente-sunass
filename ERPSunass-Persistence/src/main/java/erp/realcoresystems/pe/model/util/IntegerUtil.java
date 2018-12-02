package erp.realcoresystems.pe.model.util;

public class IntegerUtil {

	public static final Integer INTEGER_ZERO = new Integer(0);
	public static final Integer INTEGER_ONE = new Integer(1);
	public static final Integer INTEGER_TEN = new Integer(10);

	public static final Integer INTEGER_NEGATIVE_ONE = new Integer(-1);
	public static final Integer INTEGER_NEGATIVE_TEN = new Integer(-10);
	
	public static final int RESULTADO_MAYOR = -1;
	public static final int RESULTADO_IGUAL = 0;
	public static final int RESULTADO_MENOR = 1;
	

	public static int getIntegerNativo(Integer value) {
		return value == null ? INTEGER_ZERO.intValue() : value.intValue();
	}
	
	public static int getIntegerNativo(String value){
		return (value == null || value.trim().isEmpty()) ? 0 : Integer.parseInt(value);
	}
	
	public static String imprimir(int value) {
		return String.valueOf(value);
	}

	public static String imprimir(Integer value) {
		return String.valueOf(getIntegerNativo(value));
	}

	public static Integer getInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception ex) {
			return INTEGER_ZERO;
		}
	}

	public static Integer getInteger(int value) {
		return Integer.valueOf(value);
	}

	public static Integer getInteger(long value) {
		return getInteger((int) value);
	}

	public static Integer getInteger(Long value) {
		long longValue = (value == null) ? new Long(0).longValue() : value.longValue();
		int intValue = (int) longValue;
		return Integer.valueOf(intValue);
	}

	public static Integer getInteger(Integer value) {
		Integer IntegerValue = (value == null) ? INTEGER_ZERO : value;
		return IntegerValue;
	}

	public static Integer plusInteger(Integer value, int add) {
		int suma = getIntegerNativo(value) + add;
		return getInteger(suma);
	}

	public static Integer plusInteger(int value, int add) {
		int suma = value + add;
		return getInteger(suma);
	}

	public static Integer plusInteger(Integer value, Integer add) {
		int suma = getIntegerNativo(value) + getIntegerNativo(add);
		return getInteger(suma);
	}

	public static Integer substractInteger(Integer value, int substract) {
		int resta = getIntegerNativo(value) - substract;
		return getInteger(resta);
	}

	public static Integer substractInteger(Integer value, Integer substract) {
		int resta = getIntegerNativo(value) - getIntegerNativo(substract);
		return getInteger(resta);
	}

	public static int getMinInt(int... values) {
		int minInteger = Integer.MAX_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (minInteger > values[i]) {
				minInteger = values[i];
			}
		}
		return minInteger;
	}

	public static Integer getMinInteger(Integer... values) {
		Integer minInteger = Integer.MAX_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (minInteger > getIntegerNativo(values[i])) {
				minInteger = getIntegerNativo(values[i]);
			}
		}
		return minInteger;
	}
	
	/**
	 * <li> -1 =  (x <  y) </li>
	 * <li>  0 =  (x == y)</li>
	 * <li>  1 =  (x >  y)</li>
	 */
	public static int compareInteger(Integer integer1, Integer integer2) {
		integer1 = integer1 == null ? INTEGER_ZERO : integer1;
		integer2 = integer2 == null ? INTEGER_ZERO : integer2;
		int result = integer1.compareTo(integer2);
		return result;
	}
	
	/**
	 * 
	 * @param integer1
	 * @param resultEsperado
	 * @param values
	 * @return
	 */
	public static boolean compareIntegerSame(Integer integer1, Integer...values) {	
		for (Integer integer : values) {
			int result = compareInteger(integer1,integer);
			if(result == RESULTADO_IGUAL) {
				return true;
			} 
		}
		return false;
	}
}
