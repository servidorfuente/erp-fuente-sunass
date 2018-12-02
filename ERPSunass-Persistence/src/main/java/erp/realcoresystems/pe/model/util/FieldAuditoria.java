package erp.realcoresystems.pe.model.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdet;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdetPK;
import erp.realcoresystems.pe.model.domain.Personamast;


public class FieldAuditoria {

	public static Map<String, String> MAP_FIELDS;

	/** PARA LA AUDITORIA **/

	// TABLA : SA_CURSO
	public static final String FIELD_SA_CURSO_1 = "uneunegocioid";
	public static final String FIELD_SA_CURSO_2 = "moemestudioid";
	public static final String FIELD_SA_CURSO_3 = "curcursoid";

	// TABLA : MA_CATEGORIA_MISCELANEOSDET
	public static final String FIELD_MA_CATEGORIA_MISCELANEOSDET_1 = "uneunegocioid";
	public static final String FIELD_MA_CATEGORIA_MISCELANEOSDET_2 = "moemestudioid";
	public static final String FIELD_MA_CATEGORIA_MISCELANEOSDET_3 = "categSecuencia";

	public static Map<String, String> cargarFieldSaCurso() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(FIELD_SA_CURSO_1, FIELD_SA_CURSO_1);
		map.put(FIELD_SA_CURSO_2, FIELD_SA_CURSO_2);
		map.put(FIELD_SA_CURSO_3, FIELD_SA_CURSO_3);
		return map;
	}

	public static Map<String, String> cargarFieldCategoriaCurso() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(FIELD_MA_CATEGORIA_MISCELANEOSDET_1, FIELD_MA_CATEGORIA_MISCELANEOSDET_1);
		map.put(FIELD_MA_CATEGORIA_MISCELANEOSDET_2, FIELD_MA_CATEGORIA_MISCELANEOSDET_2);
		map.put(FIELD_MA_CATEGORIA_MISCELANEOSDET_3, FIELD_MA_CATEGORIA_MISCELANEOSDET_3);
		return map;
	}

	/**
	 * Metodo para obtener la llave primary del dato de la auditoria
	 * @param cls = objeto clase
	 * @return
	 */
	public static String getPrimaryKeyData(Object cls) {
		String primaryKeyData = "";

		if (cls == null) {
			throw new IllegalArgumentException("The class must not be null");
		} else {

			if (cls instanceof Personamast) {
				MAP_FIELDS = cargarFieldSaCurso();
			} else if (cls instanceof MaCategoriaMiscelaneosdet) {
				MAP_FIELDS = cargarFieldCategoriaCurso();
			}

			for (Field field : cls.getClass().getDeclaredFields()) {
				try {
					String fieldName = field.getName();
					if (!Modifier.isStatic(field.getModifiers())) {
						field.setAccessible(true);
												 
						Object fieldType = field.getType().getSimpleName();
						if (fieldType.equals(MaCategoriaMiscelaneosdetPK.class.getSimpleName())) {
							Object subClase = field.get(cls);
							primaryKeyData += getValueSubField(subClase);
						} 
						else {							
							if (MAP_FIELDS.containsKey(fieldName)) {
								Object value = field.get(cls);
								primaryKeyData += fieldName + ":" + value + "//";
							}
						}
					}

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					primaryKeyData = "";
				} catch (Exception ex) {
					ex.printStackTrace();
					primaryKeyData = "";
				}
			}
		}
		return primaryKeyData;
	}

	public static String getValueSubField(Object cls) {
		String valueString = "";
		for (Field field : cls.getClass().getDeclaredFields()) {
			try {
				String fieldName = field.getName();
				field.setAccessible(true);
				if (!Modifier.isStatic(field.getModifiers())) {
					if (MAP_FIELDS.containsKey(fieldName)) {
						Object value = field.get(cls);
						valueString += fieldName + ":" + value + "//";
					}
				}
			} catch (IllegalArgumentException e) {
				valueString = "";
			} catch (Exception ex) {
				valueString = "";
			}
		}
		return valueString;
	}

}
