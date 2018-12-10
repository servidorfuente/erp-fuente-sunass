 package erp.realcoresystems.pe.model.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public abstract class Constant implements Serializable{

	/*GENERAL NEGOCIO AQUILES*/
	public static final String USUARIO_ADMINSYS= "WEBMASTER";
	public static final String COMPANIA_VARIABLE = "999999";
	public static final String APLICACION_CODIGO = "SA";
	public static final String GRUPO_COMPANIA = "COMPANIASOCIO";
	
	/** PARA LA CAPTACION DE AGUA**/
	public static final String CAPTACION_SUB_TIPO_INFRAESTRUCTURA_SUPERFICIAL = "005";

	private static final long serialVersionUID = -6743013645117707062L;	
	public static ResourceBundle propiedadesParam= ResourceBundle.getBundle("parametrosService");

	/**App para USO externo*/

	/** TIPOS DE ACCESO A LAS OPCIONES DEL SYS, debido a las VERSIONES DEL MENU **/
	public static final String SEGURIDAD_OPCION_TIPO_MENU = "M";
	public static final String SEGURIDAD_OPCION_TIPO_TREE = "T";
	
	public static final String TRACE_INSERT_OR_UPDATE = "IoU";
	public static final String TRACE_INSERT = Constant.INSERT_db;
	public static final String TRACE_UPDATE = Constant.UPDATE_db;
	public static final String TRACE_DELETE = Constant.DELETE_db;
	
	/**CONSTANTES PARA LA TABLA DE USUARIO **/
	public static final String USUARIO = "US";
	public static final String PERFIL = "PE";
	
	public static final String DEFAULT_PASSWORD = "2";
	public static final int USUARIO_INTERNO = 1;
	public static final int USUARIO_EXERTNO = 2;
	public static final String DEFAULT_PAIS_ID = "PER";
	/** CONSTANTES PARA SOLO PERFILES DE LA TABLA USUARIO **/


	
	/** BOOLEAN EN INT **/
	public static final int INT_BOOLEAN_TRUE = 1;
	public static final int INT_BOOLEAN_FALSE = 0;
	

	public static final String PARAMETRO_TIPO_TEXTO = "T";
	public static final String PARAMETRO_TIPO_NUMERICO = "N";
	public static final String PARAMETRO_TIPO_FECHA = "D";
	

	
	//public static final String ESTUDIO_POSGRADO = "POSGRADO";
	//public static final String ESTUDIO_PREGRADO = "PREGRADO";
	

	
	public static final String PATTRON_CODIGO_CURR ="C-";
		
	public static int PRIORIDAD_APROBADO = 1;
	public static int PRIORIDAD_REPROBADO = 2;
	
	public static final String PERSONA_NATURAL = "N";
	public static final String PERSONA_JURIDICA = "J";

	public static final String ORDER_ASC  = "ASC";
	public static final String ORDER_DESC = "DESC";

	public static final String ORIGEN_PERU = "PE";

	public static final String ESTADO_CIVIL_SOLTERO = "S";
	public static final String ESTADO_CIVIL_CASADO = "C";
	public static final String ESTADO_CIVIL_VIUDO = "V";
	public static final String ESTADO_CIVIL_DIVORCIADO = "D";
	
	/** CONSTANTES PARA CAMBIAR EL VALOR DEL UBIGEO DE LIMA CALLAO QUE SE OBTIENE DE LA RENIEC, HACIA LA BASE DE DATOS DEL ERP**/
	public static final String UBIGEO_DPTO_WS_RENIEC_LIMA_CALLAO = "24";
	public static final String UBIGEO_PROV_WS_RENIEC_LIMA_CALLAO = "01";
	
	public static final String UBIGEO_DPTO_DB_LIMA = "14";
	public static final String UBIGEO_PROV_DB_CALLAO = "11";
	
	/** SE USA EN REGISTRO DE ALUMNO EN LA COLUMNA EMPLEADO DE LA TABLA USUARIO **/
	public static final int DOCUMENTO_DNI = 1;
	public static final int DOCUMENTO_CARNET_EXTRANJERIA = 2;
	public static final int DOCUMENTO_PASAPORTE = 3;
	public static final int DOCUMENTO_OTROS = 4;
	public static final int DOCUMENTO_RUC = 5;
	
	/** CODIGOS DE TIPOS DE DOCUMENTOS EXTERNOS (USADO EN EL SPRING ... ) **/
	public static final String TIPO_DOCUMENTO_DNI = "D";
	public static final String TIPO_DOCUMENTO_CARNETEXT = "X";
	public static final String TIPO_DOCUMENTO_AUTOGEN = "Z";
	


	public static String COMPANIA = "COMPANIASOCIO";
	public static String SUCURSAL = "SUCURSAL";
	public static String APP_CODE = "SA";
	public static final String COMPANIA_999999 = "999999";
	
	public static final String YES_db = "Y";
	
	public static final String SI_db = "S";
	public static final String NO_db = "N";
	public static final int INT_SI = 1;
	public static final int INT_NO = 2;
	
	public static final String SI_desc = "SI";
	
	public static final String DELETE_db = "D";
	public static final String UPDATE_db = "U";
	public static final String INSERT_db = "I";
	
	public static final int YEAR_db = 1970;
	public static final int MONTH_db = 1;
	public static final int DAY_db = 1;
	public static final int HOUR_INI_db = 0;
	public static final int MINUTE_INI_db = 0;
	public static final int SECOND_INI_db = 0;
	public static final int MILLIS_INI_db = 0;
	public static final int HOUR_FIN_db = 23;
	public static final int MINUTE_FIN_db = 59;
	public static final int SECOND_FIN_db = 59;
	public static final int MILLIS_FIN_db = 59;
	
	public static final int INT_LUNES = DateTimeConstants.MONDAY;
	public static final int INT_MARTES = DateTimeConstants.TUESDAY;
	public static final int INT_MIERCOLES = DateTimeConstants.WEDNESDAY;
	public static final int INT_JUEVES = DateTimeConstants.THURSDAY;
	public static final int INT_VIERNES = DateTimeConstants.FRIDAY;
	public static final int INT_SABADO = DateTimeConstants.SATURDAY;
	public static final int INT_DOMINGO = DateTimeConstants.SUNDAY;
	
	public static final String INACTIVO = "I";
	public static final String ACTIVO = "A";
	public static final String POR_VERIFICAR = "V";
	public static final String ELIMINADO = "E";
	public static final String BLOQUEADO = "B";
	
	public static final String EST_CAMBIAR_CLAVE_db = "C";
	
	public static final Integer INT_ACTIVO = Integer.valueOf(1);
	public static final Integer INT_INACTIVO = Integer.valueOf(2);	
	public static final Integer INT_EN_MANTENIMIENTO = Integer.valueOf(3);
	public static final Integer INT_EN_PREPARACION = Integer.valueOf(4); 
	public static final Integer INT_SUSPENDIDO = Integer.valueOf(5); 
	
	public static final Integer INT_MATRICULADO = Integer.valueOf(2);
	public static final Integer INT_NOTAFINAL = Integer.valueOf(6);
	public static final Integer INT_ELIMINADO = Integer.valueOf(3);
	public static final Integer INT_VIGENTE = Integer.valueOf(3);
	public static final Integer INT_NO_VIGENTE = Integer.valueOf(4);
	
	public static String TIPO_CLIENTE = "CL";
	public static String TIPO_CONTACTO = "CO";
	public static String TIPO_EMPLEADO = "EM";
	public static String TIPO_PROVEEDOR = "PR";
	public static String TIPO_GENERAL = "GE";
	
	public static String CURSO_LIBRE = "CURSO LIBRE";
	
	public static String MISCELANEO_DETALLE_USUARIO_TIPO_USUARIO = "TIPOUSER";
	public static String MISCELANEO_DETALLE_USUARIO_LDAP = "LDAP";

	public static final String MISCELANEO_DETALLE_AREACURSO = "AREACURSO";
	public static final String MISCELANEO_DETALLE_AGRCURSO = "AGRCURSO";
	public static final String MISCELANEO_DETALLE_SUBSUBCATEGORIA = "SUBSUBCAT";

	public static final String SEXO_MASCULINO = "M";
	public static final String SEXO_FEMENINO = "F";

	
	/*** CONSTNTES PARA LOS FORMATOS DE FECHA ***/
	public static final String PATTERN_FECHA = "dd/MM/yyyy";
	public static final String PATTERN_HORA = "HH:mm";
	public static final String PATTERN_FECHA_HORA = PATTERN_FECHA+" "+PATTERN_HORA;
	public static final String PATTERN_HORA_SEGUNDOS = "HH:mm:ss";
	
	public static final DateTime MIN_HOUR_DAY = new DateTime(YEAR_db, MONTH_db, DAY_db, HOUR_INI_db, MINUTE_INI_db);
	public static final DateTime MAX_HOUR_DAY = new DateTime(YEAR_db, MONTH_db, DAY_db, HOUR_FIN_db, MINUTE_FIN_db);
	

	
	/**CONSTANTES PARA LA CODIGOS DE ICONOS DE LAS CATEGORIAS TREE **/
	public static final  String CATEG_ICON_PADRE= "fa fa-plus-square";
	public static final  String CATEG_ICON_ITEM= "fa fa-cog";

	/**CONSTANTES PARA LA CODIGOS DE ICONOS DE LAS CATEGORIAS TREE **/
	public static final  String CATEG_COLOR_PADRE= "#232E35";
	public static final  String CATEG_COLOR_ITEM= "#097718";

	
	
	/**CONSTANTES PARA LA TIPOS DE CATEGORIAS TREE**/
	public static final  String TIPO_TREE_PADRE_CARPETA_db= "C";
	public static final  String TIPO_TREE_ITEM_ARCHIVO_db= "A";
	public static final  String TIPO_TREE_ITEM_OBJETO_db= "O";


	public static final String REGEX_SPLIT_COMP ="@_@";

	public static final String TIPOIMPUESTO_RENTA ="R";

	/** CONSTANTES DE PERSONA **/
	public static final String PERSONA_GRUPO = "G";

	public static final String PERSONA_NATURAL_CON_NEGOCIO = "B";

	public static final String PERSONA_DNI = "D";
	public static final String PERSONA_CARNETMILITAR = "C";
	public static final String PERSONA_NITEXTRANJERO = "E";
	public static final String PERSONA_LIBRETAMILITAR = "M";
	public static final String PERSONA_PARTIDANACIMIENTO = "N";
	public static final String PERSONA_OTROSTIPOSDEDOCUMENTOS = "O";
	public static final String PERSONA_PASAPORTE = "P";
	public static final String PERSONA_RUC = "R";
	public static final String PERSONA_CARNETEXTRANJERA = "X";
	public static final String PERSONA_DOCADMINISTRATIVO = "A";

	public static final String PERSONA_CLASIFICACION_S = "S";

	/** CONSTANTES PARA NIVEL **/
	//Numeros de digitos
	public static final Integer NIVEL_INFERIOR = 1;
	public static final Integer NIVEL_SUPERIOR = 2;

	/** CONSTANTTES ESTADO PERIODO **/
	public static final String ESTADO_ABIERTO = "S";
	public static final String ESTADO_CERRADO = "N";

	/** CONSTANTES DE EMPLEADO **/
	public static final String PERSONA_EMPLEADO_PLANILLA ="EM";

	/** CONCEPTO GASTO **/
	public static final String USUARIOTYPE_APROBADORES_AP = "AP";
	public static final String USUARIOTYPE_AUTORIZADORES_US = "US";

	/** CONSTANTES DE EMPLEADO **/
	public static final String CENTROCOSTO_INCOMEFLAG_YES ="Y";

	/** CONSTANTES DE ESTADO CIVIL **/
	public static final String ESTADOCIVIL_SOLTERO = "S";
	public static final String ESTADOCIVIL_CASADO = "C";
	public static final String ESTADOCIVIL_VIUDO = "V";
	public static final String ESTADOCIVIL_DIVORCIDO = "D";
	public static final String ESTADOCIVIL_CONVIVIENTE = "T";
	public static final String ESTADOCIVIL_OTRO = "O";

	/** CONSTANTES DE USUARIO **/
	public static final String USUARIO_PERFIL = "PE";
	public static final String USUARIO_USUARIO = "US";

	public static final String USUARIO_CLAVE_DEF = "1";



	public static final String TIPODOC_DNI = "D";

	public static final String APP_CODIGO_SYS = "SY";
	public static final String APP_CODIGO_ANT = "AC";
	public static final String APP_CODIGO = "AW";
	public static final String APP_CODIGO_WH_ANT= "WH";
	public static final String APP_COMPANIA = "999999";
	public static final String PERFIL_PACIENTE_DEF = "PACIENTE";
	public static final String PERFIL_ADMINSYS_DEF = "ADMINSYS";

	public static final int ESTADO_DOCUMENTO_APROBADO = 2;
	public static final int ESTADO_DOCUMENTO_ANULADO = 5;


	public static final int TIPO_CITA_DEFAULT = 1;
	public static final int TIPO_SERVICIO_DEFAULT = 1;
	public static final int TIPO_TURNO_DEFAULT = 11;
	public static final int TIPO_REGISTRO_HORARIO_DEFAULT_1 = 1;
	public static final int TIPO_REGISTRO_HORARIO_DEFAULT_2 = 3;

	public static final String TURNO_MANIANA = "M";

	public static final String TIPOCAMBIO_MONEDACODIGO_LIBRA = "04";
	public static final String TIPOCAMBIO_MONEDACODIGO_FRANCOSUIZO = "07";
	public static final String TIPOCAMBIO_MONEDACODIGO_YEN = "08";
	public static final String TIPOCAMBIO_MONEDACODIGO_EURO = "22";


	/** TIPOS DE ORDEN PERSISTENCIA  */


	/** RRHH: CONSTANTES PARA TIPOS DE CODIGO ORGANIGRAMA **/
	public static final String ORGAN_CODIGO_TIPO_POSICION_EMPRESA = "1";
	public static final String ORGAN_CODIGO_TIPO_PUESTO_EMPRESA= "2";

	/** RRHH: CONSTANTES PARA UNIDAD DE NEGOCIO DEFAUL**/
	public static final String CODIGO_UNIDAD_NEGOCIO_DEFAULT = "DEFA";
	public static final String CODIGO_UNIDAD_NEGOCIO_LIMA = "LIMA";

	/** CONSTANTES PARA LOS MISCEALENOS HEADER **/
	public static final String MISCELANEO_HEADER_VALIDACION_CITAS_WEB = "VAL_CIWEB";
	public static final String MISCELANEO_HEADER_TIPOANULACION = "TIPO_ANULA";

	/** CONSTANTES PARA LOS MISCELANEOS DETALLE **/
	public static final String TIPO_CAMBIO_CODIGO_VENTA= "VENTA";

	public static final String MISCELANEO_DETALLE_VALIDACION_CITAS_POR_DIA = "VAL_NCITAS";

	public static final String CODIGO_MONEDA_LOCAL = "LO";
	public static final String CODIGO_MONEDA_EXTRANJERA = "EX";

	public static final String CODIGO_UNIDAD_DEFAULT = "UNI";



	/** CONSTANTES DE LIQUIDACION **/

	public static final String TIPO_LIQUIDACION_VENTA = "VEN";

	public static final String LIQUIDACION_ESTADO_APROBADO = "AP";
	public static final String LIQUIDACION_ESTADO_CERRADA = "RV";
	public static final String LIQUIDACION_ESTADO_APERTURADA = "PR";
	public static final String LIQUIDACION_ESTADO_ANULADA = "AN";

	public static final String LIQ_SUSTENTOGRUPO_ACCION = "AC";
	public static final String LIQ_SUSTENTOGRUPO_SUSTENTO = "SU";

	public static final String LIQ_SUSTENTOTIPO_SOBRANTE = "S";
	public static final String LIQ_SUSTENTOTIPO_FALTANTE = "F";




	/** PARAMETROS DEL APLICATIVO **/
	public static final String PAR_CODIGO_IGV = "IGVCODE";
	public static final String PAR_CODIGO_TIPO_CAMBIO = "VNTRPD-TCE";
	public static final String PAR_CODIGO_VALIDACION_LISTA_MINIMA_PRECIOS = "LISTPRECMI";

	public static final String PAR_CODIGO_EDITAR_PRECIOS_VENTA = "EDITPRICE";
	public static final String PAR_CODIGO_LISTA_PRECIO_INCLUYE_IGV = "LISTPRECII";

	public static final String PAR_MODALIDAD_ESTUDIO_SOLO_CURSOS = "MESOLOCUR";

	public static final String PAR_COTIZACION_REVISAR = "CTSTATUSRV";

	public static final String PAR_CONTROLAR_STOCK_ALMACEN = "CONT_STOCK";

	/** CONSTANTES PARA SERVICIO **/
	//Numeros de digitos
	public static final Integer SERVICIO_NIVEL1 = 3;
	public static final Integer SERVICIO_NIVEL2 = 6;

	/** CONSTANTES PARA REMESA TIPO **/
	public static final String TIPOREMESA_VENTA_ASIGNACIONCAJA = "FIN";
	public static final String TIPOREMESA_VENTA_FONDOCAJA = "FON";
	public static final String TIPOREMESA_VENTA_VENTAS = "VEN";

	public static final String VALOR_EGRESO = "E";
	public static final String VALOR_INGRESO = "I";
	public static final String REMESA_ESTADO_ENBOVEDA = "EB";

	public static final String COBRANZA_TIPOPAGO_EF = "EF";

	public static final String REMESATIPO_TIPOCUADREFLAG_FONDOCAJA= "F";
	public static final String REMESATIPO_TIPOCUADREFLAG_ASIGNACION= "N";
	public static final String REMESATIPO_TIPOCUADREFLAG_VENTAS= "E";


	/** ESTADOS DE REMESAS FONDO CAJA*/
	public static final String REMESAFONDO_ESTADO_COMPLETADO = "CO";
	public static final String REMESAFONDO_ESTADO_ASIGNADO = "AP";
	public static final String REMESAFONDO_ESTADO_ENBOVEDA = "PR";
	public static final String REMESAFONDO_ESTADO_ANULADO = "AN";

	public static final String TIPOCOMPROBANTE_SY = "SY";
	public static final String TIPOCOMPROBANTE_FC = "FC";
	public static final String SERIE_CORC = "CORC";
	public static final String SERIE_COCJ = "COCJ";

	/** MA_MaestroMiscelaneoDetalle  **/

	//Maestro Codigo
	public static final String MA_MAESTROMISCELANEODETALLE_MAESTROCODIGO_SUNATNACIONALIDAD = "SUNATNACIO";
	public static final String MA_MAESTROMISCELANEODETALLE_MAESTROCODIGO_SUNATUBIGEO = "SUNATUBIGE";
	public static final String MA_MAESTROMISCELANEODETALLE_MAESTROCODIGO_SUNATVIA = "SUNATVIA";
	public static final String MA_MAESTROMISCELANEODETALLE_MAESTROCODIGO_SUNATZONA = "SUNATZONA";
	public static final String MA_MAESTROMISCELANEODETALLE_MAESTROCODIGO_SUNATTIPDI = "SUNATTIPDI";

	//Aplicacion Codigo
	public static final String MA_MAESTROMISCELANEODETALLE_APLICACIONCODIGO_AC= "AC";



	/** CO_DOCUMENTO IMPUESTOS  **/
	public static final String DOCUMENTO_IMPUESTO_TIPO_IMPUESTO = "I";

	/** DIMENSION DEL NUMERO DE DOCUMENTO EN LA VENTA**/
	public static final int DIMENSION_NUMERO_DOCUMENTO = 9;

	public static final String FORMA_PAGO_CONTADO = "CON";
	public static final String FORMA_PAGO_CREDITO = "CRE";

	/** ESTADOS DE LOS DOCUMENTOS VENTA**/

	public static final String DOCUMENTO_ESTADO_CANJEADO = "CJ";
	public static final String DOCUMENTO_ESTADO_COBRADO = "CO";
	public static final String DOCUMENTO_ESTADO_ANULADO = "AN";
	public static final String DOCUMENTO_ESTADO_CASTIGADO = "CA";

	/** ESTADOS ESPECIALES DE DOCMENTO PARA LA BUSQUEDA**/
	public static final String DOCUMENTO_ESTADO_NO_ANULADOS = "DENA";

	/** ESTADOS DE LAS COBRANZAS **/
	public static final String COBRANZA_ESTADO_PREPARACION = "PR";
	public static final String COBRANZA_ESTADO_REVISADO = "RV";
	public static final String COBRANZA_ESTADO_APROBADO = "AP";
	public static final String COBRANZA_ESTADO_ANULADO = "AN";

	/** TIPOS DE DOCUMENTO DETALLE **/
	public static final String DOCUMENTO_DETALLE_TIPO_ITEM = "I";
	public static final String DOCUMENTO_DETALLE_TIPO_SERVICIO = "S";

	/** TIPOS DE PAGO **/
	public static final String TIPO_PAGO_ABONO_CUENTA = "AC";
	public static final String TIPO_PAGO_CHEQUE = "CH";
	public static final String TIPO_PAGO_EFECTIVO = "EF";
	public static final String TIPO_PAGO_TARJETA_CREDITO = "TC";

	/** TIPOS DE CAJERO **/
	public static final String TIPO_CAJERO_CAJERO = "CA";
	public static final String TIPO_CAJERO_SUPERVISOR = "SU";

	/** CLASES DE CAJERO **/
	public static final String ARQUEO_ESTADO_PREPARACION = "PR";
	public static final String ARQUEO_ESTADO_ANULADO = "AN";

	/** ESCALA CALCULO PARA BIGDECIMLES **/

	public static final int ESCALA_CALCULO_DEFAULT = 2;
	public static final RoundingMode APROXIMADOR_CALCULO_DEFAULT = RoundingMode.HALF_UP;


	/** Constantes de BigDecimal **/
	public static final BigDecimal BIG_DECIMAL_ZERO = BigDecimal.ZERO.setScale(ESCALA_CALCULO_DEFAULT,
			APROXIMADOR_CALCULO_DEFAULT);
	public static final BigDecimal BIG_DECIMAL_ONE = BigDecimal.ONE.setScale(ESCALA_CALCULO_DEFAULT,
			APROXIMADOR_CALCULO_DEFAULT);
	public static final BigDecimal BIG_DECIMAL_ONE_HUNDRED = new BigDecimal(100);



	public static final String VOUCHER_DET_ESTADO_V = "V";


	public static String getPropertyServ(String prop){
		if(propiedadesParam.containsKey(prop)){
			return propiedadesParam.getString(prop);
		}else{
			return "";
		}
	}


    public static DateTime convertirDateTime(Date date){
    	return new DateTime(date);
    }

    public static DateTime convertirFechaInicioDefecto(DateTime fecha){
    	return fecha.withHourOfDay(HOUR_INI_db).withMinuteOfHour(MINUTE_INI_db);
    }

    public static DateTime convertirFechaFinDefecto(DateTime fecha){
    	return fecha.withHourOfDay(HOUR_FIN_db).withMinuteOfHour(MINUTE_FIN_db);
    }

    public static Date obtenerFechaActualPorDia(int dia){
    	LocalDate local = LocalDate.now();
    	return local.withDayOfWeek(dia).toDate();
    }

    public static Date obtenerFechaPorDia(DateTime fecha, int dia){
    	LocalDate local = new LocalDate(fecha);
    	return local.withDayOfWeek(dia).toDate();
    }

    public static String obtenerStringFechaDefecto(Date fecha){
    	return convertirDateTime(fecha).toString(Constant.PATTERN_FECHA);
    }

    public static String obtenerStringHoraDefecto(Date hora){
    	return convertirDateTime(hora).toString(Constant.PATTERN_HORA);
    }





    public static DateTime generarDateTime(DateTime fecha, DateTime hora){
    	DateTime dt = new DateTime(fecha).withHourOfDay(hora.getHourOfDay()).withMinuteOfHour(hora.getMinuteOfHour()).withSecondOfMinute(hora.getSecondOfMinute()).withMillisOfSecond(hora.getMillisOfSecond());
    	return dt;
    }

    public static DateTime obtenerMinHoraDia(){
    	return new DateTime(YEAR_db, MONTH_db, DAY_db, HOUR_INI_db, MINUTE_INI_db, SECOND_INI_db, MILLIS_INI_db);
    }

    public static DateTime obtenerMaxHoraDia(){
    	return new DateTime(YEAR_db, MONTH_db, DAY_db, HOUR_FIN_db, MINUTE_FIN_db, SECOND_FIN_db, MILLIS_FIN_db);
    }


    public static int compararSoloHoras(DateTime dt1, DateTime dt2){
    	dt1 = dt1.withYear(YEAR_db).withMonthOfYear(MONTH_db).withDayOfMonth(DAY_db);
    	dt2 = dt2.withYear(YEAR_db).withMonthOfYear(MONTH_db).withDayOfMonth(DAY_db);

    	if(dt1.isBefore(dt2)){
    		return -1;
    	}else if(dt1.isEqual(dt2)){
    		return 0;
    	}else{
    		return 1;
    	}
    }
}
