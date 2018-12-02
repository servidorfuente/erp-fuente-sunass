package erp.realcoresystems.pe.util;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class UtilesService {

	private static final String PATTERN_DECIMAL_2_DIGITOS = "######.00";
	
	private static final Long LONG_ZERO = new Long(0);
	
	private static final Integer INTEGER_ZERO = new Integer(0);
	
	private static final BigDecimal BIG_DECIMAL_ZERO = BigDecimal.ZERO;
	
	private static final BigDecimal BIG_DECIMAL_ONE = BigDecimal.ONE;

	private static final DecimalFormatSymbols decimalSymbols = new DecimalFormatSymbols(
			Locale.getDefault(Locale.Category.DISPLAY));

	private static final DecimalFormat format2Digitos = new DecimalFormat(PATTERN_DECIMAL_2_DIGITOS, decimalSymbols);

	public static final String UTF_8 = "UTF-8";

	/****** METODOS PARA EL CALCULO DE NOTAS *********/

	/**
	 * Promedio de ELementos a partir de una lIsta de Notas (se Considera n
	 * notas a eliminar)
	 */
	public static Double getPromedioAritmetico(List<Double> listaElementosProm, Integer flagRedondeo,
			Integer numeroDecimales, Integer cantidadElemEliminar) {
		Double prom = 0.0;
		try {
			Double sumaCalculo = 0.0;
			int cantidad = 0;
			List<Double> listaElementosPromCalculo;
			if (listaElementosProm.size() > 0) {
				// ELIMINAR (n) NOTAS MÃ_NIMAS
				if (cantidadElemEliminar > 0) {
					// Ordenamos Lista (Ascendentemente)
					insercionDirecta(listaElementosProm);
					listaElementosPromCalculo = new ArrayList<Double>();
					// Se toma desde la posiciÃ³n (n), asÃ­ no consideramos
					// las (n) mÃ­nimas notas
					for (int i = cantidadElemEliminar; i < listaElementosProm.size(); i++) {
						listaElementosPromCalculo.add(listaElementosProm.get(i));
					}
				} else {
					listaElementosPromCalculo = listaElementosProm;
				}
				for (Double valor : listaElementosPromCalculo) {
					sumaCalculo = sumaCalculo + valor;
					cantidad++;
				}
				if (cantidad > 0) {
					prom = sumaCalculo / cantidad;
				}
			}
			if ("1".equals("" + flagRedondeo)) {
				// REDONDEDEAR
				prom = (double) Math.round(prom);
			}
			prom = redondearDecimales(prom, numeroDecimales);// OBS
		} catch (Exception ex) {
			ex.printStackTrace();
			Log.logger.error(Log.getStackTrace(ex));
		}
		return prom;
	}

	/** Redonde un valor DOUBLE a un determinado numero de decimales */
	public static Double redondearDecimales(Double value, int decimales) {
		if (decimales < 0)
			throw new IllegalArgumentException();
		if (!value.isNaN()) {
			BigDecimal bd = new BigDecimal(value != null ? value.doubleValue() : 0.0);
			bd = bd.setScale(decimales, RoundingMode.HALF_UP);
			return bd.doubleValue();
		} else {
			return 0.0;
		}
	}

	/** ALGORITMO DE ORDENAMIENTO por INSERCION: (ASCENDENTE - para DOUBLES) */
	public static void insercionDirecta(List<Double> listaValores) {
		int p, j;
		Double aux;
		// desde el segundo elemento hasta el final, guardamos el elemento y
		// empezamos a comprobar con el anterior
		for (p = 1; p < listaValores.size(); p++) {
			aux = listaValores.get(p);
			j = p - 1;
			// mientras queden posiciones y el valor de aux sea menor
			// que los de la izquierda, se desplaza a la derecha
			while ((j >= 0) && (aux < listaValores.get(j))) {
				listaValores.set(j + 1, listaValores.get(j));
				j--;
			}
			listaValores.set(j + 1, aux); // colocamos aux en su sitio
		}
	}

	/*************************************************************/

	public static int getEnteroNativo(Integer value) {
		if (value == null) {
			return 0;
		} else {
			return value.intValue();
		}
	}
	
	public static long getLongNativo(Long value){
		return value == null ? 0:value.longValue();
	}
	
	public static String imprimirEnteroNativo(Integer value){
		return String.valueOf(getEnteroNativo(value));
	}

	public static boolean getBooleanNativoNuloTrue(Boolean value) {
		if (value == null || value.booleanValue()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean getBooleanNativoNuloFalse(Boolean value) {
		if (value == null) {
			return false;
		} else {
			if (value.booleanValue()) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static <E> List<E> transformarMapaALista(final Map<?, E> map) {
		if (map == null || map.isEmpty()) {
			new ArrayList<E>();
		}
		return new ArrayList<E>(map.values());
	}

	public static <E> List<E> getListaVacia(List<E> list) {
		if (list == null) {
			list = new ArrayList<E>();
		} else {
			list.clear();
		}
		return list;
	}

	public static <E> List<E> getNewLista() {
		return new ArrayList<E>();
	}

	/**
	 * Obtiene un numero plano ejm: 44445555 => 44445555 ; 4.4445555E7 =>
	 * 44445555
	 * 
	 * @param value
	 * @return
	 */
	public static String obtenerNumeroPlano(String value) {
		try {
			if (value != null) {
				BigDecimal big = new BigDecimal(value);
				return big.toPlainString();
			} else {
				return "0.0";
			}
		} catch (Exception ex) {
			Log.error(ex, "UtilesService :: obtenerNumeroPlano");
			return value;
		}
	}

	public static String obtenerNumeroNotacionCientifica(String value) {
		try {
			return String.valueOf(Double.valueOf(value));
		} catch (Exception ex) {
			Log.error(ex, "UtilesService :: obtenerNumeroNotacionCientifica");
			return value;
		}
	}

	public static Entidad setGetRegistroAuditoriaDeEntGlobal(Entidad objVista, Entidad obj, Object objetoAntiguo,
															 Class<?> claseTablaAudit) {
		if (obj != null) {
			obj.setUsuarioEntGlobal(objVista.getUsuarioEntGlobal());
			obj.setHostEntGlobal(objVista.getHostEntGlobal());
			obj.setAppCodigoEntGlobal(objVista.getAppCodigoEntGlobal());
			obj.setModuloEntGlobal(objVista.getModuloEntGlobal());
			obj.setConceptoEntGlobal(objVista.getConceptoEntGlobal());
			obj.setConceptoPadreEntGlobal(objVista.getConceptoPadreEntGlobal());
			obj.setFechaAccionEntGlobal(objVista.getFechaAccionEntGlobal());
			obj.setFechaSessionEntGlobal(objVista.getFechaSessionEntGlobal());
			obj.setIpEntGlobal(objVista.getIpEntGlobal());
			obj.setPcNameClienteEntGlobal(objVista.getPcNameClienteEntGlobal());
			obj.setMacClienteEntGlobal(objVista.getMacClienteEntGlobal());
			obj.setSysUrlEntGlobal(objVista.getSysUrlEntGlobal());
			obj.setSysVersionEntGlobal(objVista.getSysVersionEntGlobal());
			obj.setFlagAuditoriaEntGlobal(objVista.getFlagAuditoriaEntGlobal());
			obj.setClaseTablaAudit(claseTablaAudit);
			/// NUEVOS
			obj.setFlagAuditSoloTransactEntGlobal(objVista.getFlagAuditSoloTransactEntGlobal());
			obj.setUsuarioDbEntGlobal(objVista.getUsuarioDbEntGlobal());
			//
			obj.setObjetoAntiguo(objetoAntiguo);
		}
		return obj;
	}

	public static String aproximar2Digitos(Double value) {
		if (value == null) {
			return "";
		}

		if (value.doubleValue() == 0) {
			return "0.00";
		}
		try {
			String valueFormat = format2Digitos.format(value.doubleValue());
			if (valueFormat.substring(valueFormat.length() - 3, valueFormat.length() - 2).equalsIgnoreCase(",")) {
				valueFormat = valueFormat.substring(0, valueFormat.length() - 3) + "."
						+ valueFormat.substring(valueFormat.length() - 2, valueFormat.length());
			}
			return valueFormat;
		} catch (Exception ex) {
			Log.error(ex, "UtilesService :: aproximar2Digitos");
			return String.valueOf(value.doubleValue());
		}

	}

	/** Obtener un Objeto completamente nuevo partir de otro */
	public static Object getNuevoObjetoGenerico(Object objetoOrigen) {
		try {
			Object objAntiguo = null;
			if (objetoOrigen != null) {
				String type = objetoOrigen.getClass().getName();
				objAntiguo = Class.forName(type).newInstance();// sgAgenteSeleccionado;
				Field[] fields = objAntiguo.getClass().getDeclaredFields();
				for (Field field : fields) {
					try {
						if ((field.getModifiers()
								& java.lang.reflect.Modifier.FINAL) == java.lang.reflect.Modifier.FINAL) {
							// ES FINAL
						} else {
							field.setAccessible(true);
							Object fieldValue = field.get(objetoOrigen);
							// Object fieldValue = field.get(objAntiguo);
							field.set(objAntiguo, fieldValue);
						}
					} catch (IllegalArgumentException e) {
						// System.out.println("TEST EXC ADD FIELD OBJ OLD::");
						e.printStackTrace();
					}
				}
			}
			return objAntiguo;
		} catch (Exception ex) {
			// System.out.println("TEST EXC ADD OBJ OLD::");
			ex.printStackTrace();
		}
		return null;
	}

	public static boolean esPositivo(Integer value) {
		if (value == null || value < 1) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean esNumero(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		} catch(Exception ex){
			return false;
		}
	}

	public static String fileNameUtf8(String fileName) {
		try {
			return new String(fileName.getBytes(Charset.defaultCharset()), UTF_8);
		} catch (UnsupportedEncodingException e) {
			return fileName;
		}
	}

	public static boolean esVacio(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean noEsVacio(List<?> list) {
		return !esVacio(list);
	}
	
	public static <T> boolean esVacio(T[] array){
		if(array == null || array.length == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static <T> boolean noEsVacio(T[] array){
		return !esVacio(array);
	}

	public static boolean esVacio(String value) {
		if (value == null || value.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean noEsVacio(String value) {
		return !esVacio(value);
	}

	public static boolean esVacio(Integer value) {
		if (value == null || value.intValue() <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean noEsVacio(Integer value) {
		return !esVacio(value);
	}
	
	public static boolean esVacio(Long value){
		return value == null || value.compareTo(LONG_ZERO) == 0? true: false;
	}
	
	public static boolean noEsVacio(Long value){
		return !esVacio(value);
	}
	
	public static boolean esVacio(Date value) {
		if (value == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean noEsVacio(Date value) {
		return !esVacio(value);
	}
	
	public static boolean esVacio(BigDecimal value){
		return value == null || value.compareTo(BIG_DECIMAL_ZERO) == 0 ? true : false;
	}
	
	public static boolean noEsVacio(BigDecimal value){
		return !esVacio(value);
	}

	public static String upper(String value) {
		if (esVacio(value)) {
			return "";
		}
		return value.toUpperCase();
	}

	public static String lower(String value) {
		if (esVacio(value)) {
			return "";
		}
		return value.toLowerCase();
	}

	public static <K, V> Map<K, V> getNewLinkedHashMap() {
		return new LinkedHashMap<K, V>();
	}

	public static <K, V> Map<K, V> getNewHashMap() {
		return new HashMap<K, V>();
	}

	public static <K, V> Map<K, V> getCleanLinkedHashMap(Map<K, V> map) {
		if (map == null) {
			return getNewLinkedHashMap();
		} else {
			map.clear();
		}
		return map;
	}
	
	public static <K> Set<K> getNewHashSet(){
		return new HashSet<K>();
	}
	
	public static <K> Set<K> getNewLinkedHashSet(){
		return new LinkedHashSet<K>(); 
	}

	public static <K, V> Map<K, V> getCleanHashMap(Map<K, V> map) {
		if (map == null) {
			return getNewHashMap();
		} else {
			map.clear();
		}
		return map;
	}

	public static <E> List<E> getCleanList(List<E> list) {
		if (list == null) {
			return getNewLista();
		} else {
			list.clear();
		}
		return list;
	}

	public static <K, V> boolean esVacio(Map<K, V> map) {
		if (map == null || map.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static <K, V> boolean noEsVacio(Map<K, V> map) {
		return !esVacio(map);
	}
	
	
	public static <K> boolean esVacio(Set<K> set){
		return set == null || set.isEmpty() ? true : false;
	}
	
	public static <K> boolean noEsVacio(Set<K> set){
		return !esVacio(set);
	}

	public static String getCadena(String cadena) {
		if (esVacio(cadena)) {
			return "";
		}
		return cadena;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E, K, V> void listaIterator(List<E> list, Map<K, V> map) {
		list = UtilesService.getCleanList(list);
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<K, V> e = (Entry<K, V>) it.next();
			list.add((E) e.getValue());
		}
	}

	public static boolean esNulo(Object obj) {
		return obj == null ? true : false;
	}

	public static boolean noEsNulo(Object obj) {
		return !esNulo(obj);
	}
	
	
	public static <E> Map<E, E> transformarListaEnMapa(List<E> list){
		Map<E, E> map = getNewLinkedHashMap();
		if(esVacio(list)){
			return map;
		}
		for(E e : list){
			map.put(e, e);
		}
		return map;
	}
	
	public static <E> Map<E, E> transformarArrayEnMapa(E[] array){
		Map<E, E> map = getNewLinkedHashMap();
		if(esVacio(array)){
			return map;
		}
		for(int i = 0; i < array.length; i++){
			map.put(array[i], array[i]);
		}
		return map;
	}
	
	public static <E> List<E> transformarArrayEnList(E[] array){
		List<E> list = getNewLista();
		if(esVacio(array)){
			return list;
		}
		for(int i = 0; i < array.length; i++){
			list.add(array[i]);
		}
		return list;
	}
	
	public static Date transformarCalendarEnDate(Calendar calendar){
		if(calendar == null){
			return null;
		}
		return calendar.getTime();
	}
}
