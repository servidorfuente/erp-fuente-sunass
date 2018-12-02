package erp.realcoresystems.pe.model.util;

public class LongUtil {
	
	public static final Long LONG_ZERO = new Long(0);
	public static final Long LONG_ONE = new Long(1);
	public static final Long LONG_TEN = new Long(10);
	
	public static final Long LONG_NEGATIVE_ONE = new Long(-1);
	public static final Long LONG_NEGATIVE_TEN = new Long(-10);

	public static long getLongNativo(Long value){
		return value == null ? LONG_ZERO.longValue():value.longValue(); 
	}
	
	public static String imprimir(long value){
		return String.valueOf(value);
	}
	
	public static String imprimir(Long value){
		return String.valueOf(getLongNativo(value));
	}
	
	public static Long getLong(String value){
		return Long.parseLong(value);
	}
	
	public static Long getLong(long value){
		return Long.valueOf(value);
	}
	
	public static long getLong(int value){
		return (long) value;
	}
	
	public static Long getLong(Integer value){
		long longValue = getLong(value == null ? LONG_ZERO.longValue() : value.intValue());
		return getLong(longValue);
	}
	
	public static long plusLong(long value, int add){
		return value + (long)add;
	}
	
	public static Long plusLong(Long value, int add){
		return getLong(plusLong(getLongNativo(value), add));
	}

	public static Long substractLong(long value, int substract){
		return value - (long) substract;
	}
	
	public static Long substractLong(Long value, int substract){
		return getLong(substractLong(getLongNativo(value), substract));
	}
	
	/**
	 * <li> -1 =  (x <  y) </li>
	 * <li>  0 =  (x == y)</li>
	 * <li>  1 =  (x >  y)</li>
	 */
	public static int compareLong(Long long1, Long long2){
		long1 = long1 == null ? LONG_ZERO: long1;
		long2 = long2 == null ? LONG_ZERO: long2;
		int result = long1.compareTo(long2);
		return result;
	}
}
