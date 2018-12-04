package erp.realcoresystems.pe.model.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utiles {

	/*** PARÁMETROS GENERALES ***/
	public static final int DEFAULT_TIPO_ALUMNO = 1;

	public static String PUNTO_EXTENSION_PAGs = ".xhtml";
	public static String FLAG_PANEL_OPCIONES = "OPCIONES";
	public static String FLAG_PANEL_RECURSOS = "RECURSOS";

	public static String HOST_APP = "HOST_UNDEF";
	
	public static final String CREADOR_AUDIT_COD = "creador";
	public static final String MODIFICADOR_AUDIT_COD = "modificador";
	
	
	/*
	 * public static final String USUARIO_ADMINSYS= "ADMINSYS"; public static
	 * final String COMPANIA_VARIABLE = "999999"; public static final String
	 * APLICACION_CODIGO = "XW";
	 */
	public static String TIPO_TRABAJADOR = "08";

	public static String MODULO = "GRUP15";

	public static Integer TIPO_ATENCION = 1;
	public static String UNIDAD_REPLICACION = "CEG";

	public static final String CODIGO_PERFIL = "PE";
	public static final String CODIGO_USUARIO = "US";

	public static final String BLOQUEADO_db = "B";
	public static final String ACTIVO_db = "A";
	public static final String EST_CAMBIAR_db = "C";
	public static final String INACTIVO_db = "I";
	public static final Long ACTIVO_NUM_db = Long.valueOf(1);
	public static final Long INACTIVO_NUM_db = Long.valueOf(2);

	public static final String SI_db = "S";
	public static final String NO_db = "N";

	public static final String SI_desc = "Sí";
	public static final String NO_desc = "No";
	public static final String DELETE_db = "D";
	public static final String UPDATE_db = "U";
	public static final String INSERT_db = "I";

	public static final int DEFAULT_SEDE = 1;
	public static final int INFRAESTRUCTURA_INTERNA = 1;
	public static final int INFRAESTRUCTURA_EXTERNA = 2;

	public static final String TYPE_MSG_WARN = "warn";
	public static final String TYPE_MSG_INFO = "info";
	public static final String TYPE_MSG_ERROR = "error";

	public static final String FORMA_DATECOMPLETA = "FECHACOMLETA";

	public static final String ESTADO_ELIMINADO_db = "E";
	public static final Long ESTADO_ELIMINADO_NUM_db = Long.valueOf(3);

	public static String UNID_SEGUNDOS = "segundos";

	public static final String UTF_8 = "UTF-8";

	public static final String LOCALHOST_IPV4 = "127.0.0.1";
	public static final String LOCALHOST_IPV6_1 = "0:0:0:0:0:0:0:1";
	public static final String LOCALHOST_IPV6_2 = "::1";
	public static final String LOCALHOST = "localhost";

	/*** PARÁMETROS REPORTES ***/
	public static final String COD_REPORTE_SERVLET="reporte";
	public static final String INDICADOR_MODALIDAD_REPORTE_ALUM_MAT = "indicadormodalidad";
	public static final String INDICADOR_MODALIDAD_CURSO_LIBRE = "modcursolibre";
	public static final String INDICADOR_MODALIDAD_PROGRAMA = "modprograma";
	public static final String INDICADOR_PAGO_REPORTE_DOCENTE_LIQ = "indicadorpagoliq";
	
	public static final String COD_REPORTE_ASISTENCIA_ALUMNOS = "reporte_asistencia_alumnos";
	public static final String COD_REPORTE_USUARIO =  "reporte_usuario";
	public static final String COD_REPORTE_DOCUMENTO=  "reporte_documento";
	public static final String COD_REPORTE_ALUMNOS_MATRICULADOS = "reporte_alumnos_matriculados";
	public static final String COD_REPORTE_LISTADO_ALUMNOS_SIN_DOC = "reporte_listado_alumnos_dindoc";
	public static final String COD_REPORTE_CERTIFICADO_ALUMNO=  "reporte_certificado_alumno";
	public static final String COD_REPORTE_LISTADO_ALUMNOS = "reporte_listado_alumnos";
	public static final String COD_REPORTE_LISTADO_ASISTENCIA = "reporte_listado_asistencia";
	public static final String COD_REPORTE_LISTADO_OBLIGA_ALUMNO = "reporte_listado_obliga_alumno";
	public static final String COD_REPORTE_ASISTENCIA_DOC = "reporte_asistencia_doc";
	public static final String COD_REPORTE_ACTA_FILE = "reporte_acta_file";
	public static final String COD_REPORTE_LIQUIDACION_DOCENTE = "reporte_liquidacion_docente";
	public static final String COD_REPORTE_LIQUIDACION_DOCENTE_RESUMEN = "reporte_liquidacion_docente_resumen";
	public static final String COD_REPORTE_PROCESO_NOTAS = "reporte_proceso_notas";
	public static final String COD_REPORTE_HORARIO = "reporte_horario";
	public static final String COD_REPORTE_LIQUIDACION_DOCENTE_RESUMEN_DETALLE = "reporte_liquidacion_docente_resumen_detalle";
	public static final String COD_REPORTE_LISTADO_PAGO_CONSOLIDADO_ALUMNO = "reporte_listado_pago_consolidado_alumno";
	public static final String COD_REPORTE_HORARIOS_ALUMNOS = "reporte_hor_alumnos";
	
	public static final String COD_REPORTE_RESUMEN_OBLIGA_ALUMNO = "reporte_resumen_obliga_alumno";
	public static final String COD_REPORTE_RESUMEN_ALUMNOS = "reporte_resumen_alumno";
	
	public static final String COD_REPORTE_FICHA_INSC_MALLA = "reporte_ficha_ins_malla";
	public static final String COD_REPORTE_FICHA_INSC_MODULO = "reporte_ficha_ins_mod";
	
	public static final String PUNTO_EXT_REPORTES_TEMPLATE= ".jrxml";
	public static final String PUNTO_EXT_REPORTES_COMPILE= ".jasper";
	
	public static final String FORMATO_PDF= "PDF";
	public static final String FORMATO_XLS= "XLS";
	public static final String FORMATO_XHTML= "xhtml";

	public static final String PERSISTENCIA_PATH = "path";
	public static final String PERSISTENCIA_GEST_CONTENIDO = "gestorconten";
	public static final String NOMBREPARAM_PATH = "path";
	public static final String NOMBREPARAM_FILESAVE = "fileSave";
	public static final String NOMBREPARAM_PERSIST = "persistencia";

	/*** ADICIONALES ESSION **/
	
	public static final String COD_SESSION_LISTADO_PERSONAS = "PERSONA_LISTADO_AUTO";
	public static final String COD_SESSION_LISTADO_CURCURSO = "CURCURSO_LISTADO_AUTO";
	public static final String COD_SESSION_LISTADO_AULA = "AULA_LISTADO_AUTO";
	public static final String COD_SESSION_LISTADO_ALUMNO = "ALUMNO_LISTADO_AUTO";
	public static final String COD_SESSION_LISTADO_PAGOS_CONFIG_ACAD_DET	 = "PAGOACADCONFIG_DET_LISTADO_AUTO";
	
	
	public static final String COD_SESSION_FILTRO_AMBIENTE_RESERVA_AMBIENTE = "AMBIENTE_RESERVA_AMBIENTE_FILTRO_AUTO";
	public static final String COD_SESSION_IDCONTRATOALUMNO_REGNUEVO = "ID_CONTRATOALUMNO_REGISTRO_NUEVO";
	/****************************************************************************/

	/** Convert Date to calendar **/
	public static Calendar dateToCalendar(Date date) {
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} else {
			return null;
		}
	}

	/** Convert Calendar to Date **/
	public static Date calendarToDate(Calendar calendar) {
		if (calendar != null) {
			return calendar.getTime();
		} else {
			return null;
		}
	}

	public static Date getFechaHoy() {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		return now;
	}

	public static Timestamp obtenerTimestamp() {
		try {
			// 1) create a java calendar instance
			Calendar calendar = Calendar.getInstance();

			// 2) get a java.util.Date from the calendar instance.
			// this date will represent the current instant, or "now".
			Date now = calendar.getTime();

			// 3) a java current time (now) instance
			Timestamp currentTimestamp = new Timestamp(now.getTime());

			return currentTimestamp;
		} catch (Exception e) {
			// TODO: handle exception
			// Log.error(e, "Utiles :: obtenerTimestamp :: controlado");
			return null;
		}
	}

	public static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static String formatoFechaString(Date fecha, String formato) {
		String fechaConFormato = "";
		try {
			if (FORMA_DATECOMPLETA.equals(formato)) {
				if (fecha != null) {
					SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
					SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
					SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
					String day = sdfDay.format(fecha);
					String month = sdfMonth.format(fecha);
					String year = sdfYear.format(fecha);
					int monthNum = Integer.parseInt(month);
					fechaConFormato = nombreDiaSemana(fecha) + " " + day + " de " + getDescMes(monthNum) + " del "
							+ year;
				}
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				fechaConFormato = sdf.format(fecha);
			}
		} catch (Exception ex) {
			// Log.error(ex, "Utiles :: getIPCliente :: controlado");
		}
		return fechaConFormato;
	}

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
						// Log.error(e, "Utiles :: getNuevoObjetoGenerico ::
						// controlado");
					}
				}
			}
			return objAntiguo;
		} catch (Exception ex) {
			// Log.error(ex, "Utiles :: getNuevoObjetoGenerico :: controlado");
		}
		return null;
	}

	@SuppressWarnings("unused")
	public static void showObjeto(Object objShow) {
		try {

			if (objShow != null) {
				Field[] fields = objShow.getClass().getDeclaredFields();
				for (Field field : fields) {
					try {
						String fieldName = field.getName();
						field.setAccessible(true);
						Object fieldValue = field.get(objShow);
					} catch (IllegalArgumentException e) {
						// Log.error(e, "Utiles :: showObjeto :: controlado");
					}
				}
			}
		} catch (Exception ex) {
			// Log.error(ex, "Utiles :: showObjeto :: controlado");
		}
	}

	/**********************************/
	public static final String DAY_LUNES = "Lunes";
	public static final String DAY_MART = "Martes";
	public static final String DAY_MIERC = "Miércoles";
	public static final String DAY_JUEV = "Jueves";
	public static final String DAY_VIER = "Viernes";
	public static final String DAY_SAB = "Sábado";
	public static final String DAY_DOM = "Domingo";

	public static final int DIA_LUNES = DateTimeConstants.MONDAY;
	public static final int DIA_MARTES = DateTimeConstants.TUESDAY;
	public static final int DIA_MIERCOLES = DateTimeConstants.WEDNESDAY;
	public static final int DIA_JUEVES = DateTimeConstants.THURSDAY;
	public static final int DIA_VIERNES = DateTimeConstants.FRIDAY;
	public static final int DIA_SABADO = DateTimeConstants.SATURDAY;
	public static final int DIA_DOMINGO = DateTimeConstants.SUNDAY;

	public static final String MONTH_ENERO = "enero";
	public static final String MONTH_FEB = "febrero";
	public static final String MONTH_MARZ = "marzo";
	public static final String MONTH_ABR = "abril";
	public static final String MONTH_MAY = "mayo";
	public static final String MONTH_JUN = "junio";
	public static final String MONTH_JUL = "julio";
	public static final String MONTH_AGO = "agosto";
	public static final String MONTH_SET = "setiembre";
	public static final String MONTH_OCT = "octubre";
	public static final String MONTH_NOV = "noviembre";
	public static final String MONTH_DIC = "diciembre";

	public static final int MES_ENERO = 1;
	public static final int MES_FEBRERO = 2;
	public static final int MES_MARZO = 3;
	public static final int MES_ABRIL = 4;
	public static final int MES_MAYO = 5;
	public static final int MES_JUNIO = 6;
	public static final int MES_JULIO = 7;
	public static final int MES_AGOSTO = 8;
	public static final int MES_SEPTIEMBRE = 9;
	public static final int MES_OCTUBRE = 10;
	public static final int MES_NOVIEMBRE = 11;
	public static final int MES_DICIEMBRE = 12;

	public static final int TIPO_DICTADO_TEORICO = 1;
	public static final int TIPO_DICTADO_PRACTICO = 2;

	public static String getDescMes(int numOrden) {
		switch (numOrden) {
		case 1:
			return MONTH_ENERO;
		case 2:
			return MONTH_FEB;
		case 3:
			return MONTH_MARZ;
		case 4:
			return MONTH_ABR;
		case 5:
			return MONTH_MAY;
		case 6:
			return MONTH_JUN;
		case 7:
			return MONTH_JUL;
		case 8:
			return MONTH_AGO;
		case 9:
			return MONTH_SET;
		case 10:
			return MONTH_OCT;
		case 11:
			return MONTH_NOV;
		case 12:
			return MONTH_DIC;
		default:
			return "";
		}
	}

	public static String nombreDiaSemana(Date fecha) {
		try {
			if (fechaEsLunes(fecha)) {
				return DAY_LUNES;
			} else if (fechaEsMartes(fecha)) {
				return DAY_MART;
			} else if (fechaEsMiercoles(fecha)) {
				return DAY_MIERC;
			} else if (fechaEsjueves(fecha)) {
				return DAY_JUEV;
			} else if (fechaEsViernes(fecha)) {
				return DAY_VIER;
			} else if (fechaEsSabado(fecha)) {
				return DAY_SAB;
			} else if (fechaEsDomingo(fecha)) {
				return DAY_DOM;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String obtenerEstadoAlumno(int estadoAlumno) {
		switch (estadoAlumno) {
		case 0:
			return "Nuevo";
		case 1:
			return "Regular";
		case 2:
			return "Suspendido";
		case 3:
			return "Retirado del Ciclo";
		case 4:
			return "Dado de Baja";
		case 5:
			return "Con Reserva";
		case 6:
			return "Egresado";
		case 7:
			return "Anulado";
		case 8:
			return "Desertor";
		default:
			return "";
		}
	}

	public static String obtenerEstadoMatricula(int estadoMatricula) {
		switch (estadoMatricula) {
		case 1:
			return "Con Carga Hábil";
		case 2:
			return "Matriculado";
		case 3:
			return "Retiro de Ciclo";
		case 4:
			return "Reserva de Matrícula";
		case 5:
			return "PreMatriculado";
		case 6:
			return "Deserción";
		default:
			return "";
		}
	}

	public static String obtenerTipoRegistroMatricula(int tipoRegistro) {
		switch (tipoRegistro) {
		case 1:
			return "Presencial";
		default:
			return "";
		}
	}

	public static String nombreDiaSemana(int dia) {
		if (dia == 1) {
			return DAY_LUNES;
		} else if (dia == 2) {
			return DAY_MART;
		} else if (dia == 3) {
			return DAY_MIERC;
		} else if (dia == 4) {
			return DAY_JUEV;
		} else if (dia == 5) {
			return DAY_VIER;
		} else if (dia == 6) {
			return DAY_SAB;
		} else if (dia == 7) {
			return DAY_DOM;
		} else {
			return "";
		}
	}

	public static String obtenerTurno(int turno) {
		if (turno == 1) {
			return "Mañana";
		} else if (turno == 2) {
			return "Tarde";
		} else if (turno == 3) {
			return "Noche";
		} else {
			return "";
		}
	}

	/***/
	public static boolean fechaEsLunes(Date fecha) {
		return fechaEsDiaSemana(fecha, 1);
	}

	/***/
	public static boolean fechaEsMartes(Date fecha) {
		return fechaEsDiaSemana(fecha, 2);
	}

	/***/
	public static boolean fechaEsMiercoles(Date fecha) {
		return fechaEsDiaSemana(fecha, 3);
	}

	/***/
	public static boolean fechaEsjueves(Date fecha) {
		return fechaEsDiaSemana(fecha, 4);
	}

	/***/
	public static boolean fechaEsViernes(Date fecha) {
		return fechaEsDiaSemana(fecha, 5);
	}

	/***/
	public static boolean fechaEsSabado(Date fecha) {
		return fechaEsDiaSemana(fecha, 6);
	}

	/***/
	public static boolean fechaEsDomingo(Date fecha) {
		return fechaEsDiaSemana(fecha, 0); /// Domingo = 0 y lunes = 1
	}

	/***/
	@SuppressWarnings("deprecation")
	public static boolean fechaEsDiaSemana(Date fecha, int dia) {
		try {
			if (fecha != null) {
				if (fecha.getDay() == dia) {
					return true;
				}
			}
		} catch (Exception e) {
			// Log.error(e, "Utiles :: fechaEsDiaSemana :: controlado");
		}
		return false;
	}

	/***/
	public static long fechaDiferenciaEnDias_Con(Date fecha, Date fechaDif) {
		try {
			if (fecha != null && fechaDif != null) {
				Date fechaAux = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fecha));
				Date fechaAuxDif = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fechaDif));
				long time = fechaAux.getTime();
				long timeDif = fechaAuxDif.getTime();
				long dias = Math.abs((time - timeDif) / 86400000);

				return dias;
			}
		} catch (Exception e) {
			// Log.error(e, "Utiles :: fechaDiferenciaEnDias_Con ::
			// controlado");
		}
		return 0;
	}

	/***/
	public static String printDate(String pattern, Date valor) {
		if (valor != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(valor);
		} else {
			return null;
		}
	}

	public static Date getDateFormat(String pattern, String valor) {
		try {
			if (valor != null) {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				return sdf.parse(valor);
			}
		} catch (Exception e) {
			// Log.error(e, "Utiles :: getDateFormat :: controlado");
		}
		return null;
	}

	/** Devuelve la fecha desplazada tantos días (Sólo días, no Horas...) */
	public static Date fechaMasNumeroDias(Date fecha, int dias) {
		// fecha.getDay()
		try {
			/// FALLA CUANDO SE LE AÑADE MáS DE 24 Días de golpe (Tener cuidado)
			if (fecha != null) {
				int signo = 1;
				if (dias < 0) {
					signo = -1;
				}
				int diasAux = Math.abs(dias);
				while (diasAux >= 24) {
					Date fechaAux = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fecha));
					long time = fechaAux.getTime();
					time = time + 86400000 * 20 * signo; //// equivalente a un
															//// dia = 86400000
															//// ms
					Date fechaAux2 = new Date(time);
					// return fechaAux2;
					diasAux = diasAux - 20;
					fecha = fechaAux2;
					dias = diasAux;
				}
				// long fecha1 = Integer.parseInt( printDate("yyyyMMdd",
				// fecha));
				Date fechaAux = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fecha));
				long time = fechaAux.getTime();
				time = time + 86400000 * diasAux * signo; //// equivalente a un
															//// dia = 86400000
															//// ms
				Date fechaAux2 = new Date(time);
				return fechaAux2;
			}
		} catch (Exception e) {
			// Log.error(e, "Utiles :: fechaMasNumeroDias :: controlado");
		}
		return null;
	}

	/** Obtener IP del cliente **/
	public static String getIPCliente() {// 192.168, 172.16. o 10.0.
		String ipAddress = "";
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			ipAddress = request.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
				if (ipAddress.equals("127.0.0.1")) {
					try {
						ipAddress = InetAddress.getLocalHost().getHostAddress();
					} catch (Exception e) {
						ipAddress = "";
					}
				}
			}
			String[] ips = ipAddress.split(",");
			for (String ip : ips) {
				if (!ip.trim().startsWith("127.0.")) {
					ipAddress = ip;
				}
			}
		} catch (Exception ex) {
			// Log.error(ex, "Utiles :: getIPCliente :: controlado");
		}
		return ipAddress;
	}

	/** Obtener Work Satation Name del cliente **/
	public static String getPcNombreCliente() {
		String host = "";
		try {
			String ips[] = getIPCliente().split("\\.");
			byte[] ipAddr = new byte[] { (byte) Integer.parseInt(ips[0]), (byte) Integer.parseInt(ips[1]),
					(byte) Integer.parseInt(ips[2]), (byte) Integer.parseInt(ips[3]) };
			InetAddress inet = InetAddress.getByAddress(ipAddr);
			host = inet.getHostName();
		} catch (Exception ex) {
			// Log.error(ex, "Utiles :: getPcNombreCliente :: controlado");
		}
		return host;
	}

	/** Obtener MAC del cliente **/
	public static String getMacCliente() {
		InetAddress ip;
		byte[] mac = null;
		StringBuilder sb = new StringBuilder();
		try {
			ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			mac = network.getHardwareAddress();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
		} catch (UnknownHostException e) {
			// Log.error(e, "Utiles :: getMacCliente :: controlado");
		} catch (SocketException e) {
			// Log.error(e, "Utiles :: getMacCliente :: controlado");
		} catch (NullPointerException e) {
			// Log.error(e, "Utiles :: getMacCliente :: controlado");
		}
		return sb.toString();
	}

	public static <E> List<E> union(final List<? extends E> list1, final List<? extends E> list2) {
		final ArrayList<E> result = new ArrayList<E>(list1);
		result.addAll(list2);
		return result;
	}

	/***/
	public static String formatoCerosIzqNum(int dimensionTotal, String numero) {
		String codigo = "";
		int dimNum = numero.length();
		if (dimensionTotal - dimNum >= 0) {
			for (int i = 0; i < dimensionTotal - dimNum; i++) {
				codigo = codigo + "0";
			}
		}
		codigo = codigo + numero;
		return codigo;
	}

	public static String formatoCerosIzqNum(int dimensionTotal, Number numeroIn) {
		String codigo = "";
		String numero = "";
		if (numeroIn != null) {
			numero = "" + numeroIn;
		}
		int dimNum = numero.length();
		if (dimensionTotal - dimNum >= 0) {
			for (int i = 0; i < dimensionTotal - dimNum; i++) {
				codigo = codigo + "0";
			}
		}
		codigo = codigo + numero;
		return codigo;
	}

	/**
	 * DEVUELVE EL VALOR NUMERICO (unidad de tiempo:indica) en un formato de
	 * CRONOMETRO
	 */
	public static String tiempoFormato(int unidades, String indica) {
		String tiempo = null;
		int horas = 0;
		int segundosSob = 0;
		int minutos = 0;
		int segundos = 0;

		if (UNID_SEGUNDOS.equals(indica)) {
			horas = unidades / 3600;
			segundosSob = unidades % 3600;
			minutos = segundosSob / 60;
			segundos = unidades - (minutos * 60);
			// Date time = new Date(unidades);
			tiempo = formatoCerosIzqNum(2, "" + horas) + ": " + formatoCerosIzqNum(2, "" + minutos) + ": "
					+ formatoCerosIzqNum(2, "" + segundos);
		}
		return tiempo;
	}

	/*** Para Horario **/

	public static int obtenerEnteroNativo(Integer value) {
		return (value == null ? 0 : value.intValue());
	}

	/******/
	public static boolean esVacio(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static <E> boolean sinContenido(List<E> list) {
		if (list == null || list.isEmpty()) {
			return true;
		} else {
			return false;
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

	public static String codificarCadena(String cadena, String codificacion) {
		try {
			return new String(cadena.getBytes(Charset.defaultCharset()), codificacion);
		} catch (UnsupportedEncodingException e) {
			return cadena;
		}
	}

	public static String codificarEnUtf8(String cadena) {
		try {
			return new String(cadena.getBytes(Charset.defaultCharset()), UTF_8);
		} catch (UnsupportedEncodingException e) {
			return cadena;
		}
	}

	public static boolean esLocalHost(String ip) {
		if (ip == null) {
			return false;
		}
		return (ip.equalsIgnoreCase(LOCALHOST) || ip.equalsIgnoreCase(LOCALHOST_IPV4)
				|| ip.equalsIgnoreCase(LOCALHOST_IPV6_1) || ip.equalsIgnoreCase(LOCALHOST_IPV6_2) ? true : false);
	}

	public static String obtenerIpRemota() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String remoteAddress = request.getRemoteAddr();
		return remoteAddress;
	}

	public static String obtenerNombrePcRemota() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();

		String remoteAddress = request.getRemoteAddr();
		try {
			InetAddress inetAddress = null;
			if (esLocalHost(remoteAddress)) {
				inetAddress = InetAddress.getLocalHost();
			} else {
				inetAddress = InetAddress.getByName(remoteAddress);
			}
			String pcName = inetAddress.getHostName();
			if (esLocalHost(pcName)) {
				pcName = inetAddress.getCanonicalHostName();
			}
			return pcName;
		} catch (UnknownHostException e) {
			return null;
		}
	}

	/**
	 * Obtener Número Con formato en String
	 * 
	 * @param pattern
	 * @param value
	 * @return
	 */
	static public String getNumeroFormat(String pattern, Double value) {
		String result = "";
		try {
			if (value != null) {
				/*
				 * NumberFormat currencyFormatter =
				 * NumberFormat.getCurrencyInstance(FacesUtil.getSessionLocale()
				 * ); result = currencyFormatter.format(value);
				 */
				DecimalFormat myFormatter = new DecimalFormat(pattern);
				Locale locEN = Locale.ENGLISH;
				// myFormatter.setDecimalFormatSymbols(new
				// DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)));
				myFormatter.setDecimalFormatSymbols(new DecimalFormatSymbols(locEN));
				result = myFormatter.format(value);
			} else {
				result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getContentType(String fileName) {
		File file = new File(fileName);
		String contentType = null;
		try {
			contentType = Files.probeContentType(file.toPath());
		} catch (IOException e) {
			contentType = "application/pdf";
		}
		return contentType;
	}
	/*** AGREGADOS ***/

	/***/
	public static long fechaDiferenciaEnDias(Date fecha, Date fechaDif) {
		try {
			if (fecha != null && fechaDif != null) {
				Date fechaAux = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fecha));
				Date fechaAuxDif = getDateFormat("yyyyMMdd", printDate("yyyyMMdd", fechaDif));
				long time = fechaAux.getTime();
				long timeDif = fechaAuxDif.getTime();
				long dias = (time - timeDif) / 86400000;
				// long dias = Math.abs((time - timeDif) / 86400000);

				return dias;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param fechaA
	 * @param fechaB
	 * @return
	 */
	public static Integer diferenciaHoras(Date fechaA, Date fechaB) {
		Integer result = null;
		if (fechaA != null && fechaB != null) {
			DateTime dateTimeA = convertirEnDateTime(fechaA);
			DateTime dateTimeB = convertirEnDateTime(fechaB);
			Hours obj = Hours.hoursBetween(dateTimeA, dateTimeB);
			result = obj.getHours();
		}
		return result;
	}

	/**
	 * @param fechaA
	 * @param fechaB
	 * @return
	 */
	public static Integer diferenciaMinutos(Date fechaA, Date fechaB) {
		Integer result = null;
		if (fechaA != null && fechaB != null) {
			DateTime dateTimeA = convertirEnDateTime(fechaA);
			DateTime dateTimeB = convertirEnDateTime(fechaB);
			Minutes min = Minutes.minutesBetween(dateTimeA, dateTimeB);
			result = min.getMinutes();
			// Hours obj= Hours.hoursBetween(dateTimeA, dateTimeB);
			// result = obj.getHours();
		}
		return result;
	}

	/**
	 * Convierte un java.util.Date en un or.joda.time.DateTime
	 * 
	 * @param date
	 * @return
	 */
	public static DateTime convertirEnDateTime(Date date) {
		return new DateTime(date);
	}

	/*** AGREGACIONES SGA ***/

	public static final Map<Integer, String> MAP_DIAS_RESUMEN_LABEL = new LinkedHashMap<Integer, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(DIA_LUNES, FacesUtil.getPropertyLabels("DAY_RESUMEN_LUNES"));
			put(DIA_MARTES, FacesUtil.getPropertyLabels("DAY_RESUMEN_MARTES"));
			put(DIA_MIERCOLES, FacesUtil.getPropertyLabels("DAY_RESUMEN_MIERCOLES"));
			put(DIA_JUEVES, FacesUtil.getPropertyLabels("DAY_RESUMEN_JUEVES"));
			put(DIA_VIERNES, FacesUtil.getPropertyLabels("DAY_RESUMEN_VIERNES"));
			put(DIA_SABADO, FacesUtil.getPropertyLabels("DAY_RESUMEN_SABADO"));
			put(DIA_DOMINGO, FacesUtil.getPropertyLabels("DAY_RESUMEN_DOMINGO"));
		}
	};

	public static final Map<Integer, String> MAP_DIAS_LABEL = new LinkedHashMap<Integer, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(DIA_LUNES, FacesUtil.getPropertyLabels("DAY_LUNES"));
			put(DIA_MARTES, FacesUtil.getPropertyLabels("DAY_MARTES"));
			put(DIA_MIERCOLES, FacesUtil.getPropertyLabels("DAY_MIERCOLES"));
			put(DIA_JUEVES, FacesUtil.getPropertyLabels("DAY_JUEVES"));
			put(DIA_VIERNES, FacesUtil.getPropertyLabels("DAY_VIERNES"));
			put(DIA_SABADO, FacesUtil.getPropertyLabels("DAY_SABADO"));
			put(DIA_DOMINGO, FacesUtil.getPropertyLabels("DAY_DOMINGO"));
		}
	};

//	public static final Map<Integer, String> MAP_MES_LABEL = new LinkedHashMap<Integer, String>() {
//
//		private static final long serialVersionUID = 1L;
//
//		{
//			put(MES_ENERO, FacesUtil.getPropertyLabels("MES_ENERO"));
//			put(MES_FEBRERO, FacesUtil.getPropertyLabels("MES_FEBRERO"));
//			put(MES_MARZO, FacesUtil.getPropertyLabels("MES_MARZO"));
//			put(MES_ABRIL, FacesUtil.getPropertyLabels("MES_ABRIL"));
//			put(MES_MAYO, FacesUtil.getPropertyLabels("MES_MAYO"));
//			put(MES_JUNIO, FacesUtil.getPropertyLabels("MES_JUNIO"));
//			put(MES_JULIO, FacesUtil.getPropertyLabels("MES_JULIO"));
//			put(MES_AGOSTO, FacesUtil.getPropertyLabels("MES_AGOSTO"));
//			put(MES_SEPTIEMBRE, FacesUtil.getPropertyLabels("MES_SEPTIEMBRE"));
//			put(MES_OCTUBRE, FacesUtil.getPropertyLabels("MES_OCTUBRE"));
//			put(MES_NOVIEMBRE, FacesUtil.getPropertyLabels("MES_NOVIEMBRE"));
//			put(MES_DICIEMBRE, FacesUtil.getPropertyLabels("MES_DICIEMBRE"));
//		}
//	};

	public static final Map<Integer, String> MAP_TIPO_DICTADO_LABEL_INICIAL = new LinkedHashMap<Integer, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(TIPO_DICTADO_TEORICO, FacesUtil.getPropertyLabels("TIPO_DICTADO_TEORICO_INICIAL"));
			put(TIPO_DICTADO_PRACTICO, FacesUtil.getPropertyLabels("TIPO_DICTADO_PRACTICO_INICIAL"));
		}
	};

	public static boolean esNuloNegativo(Integer value) {
		if (value == null || value < 1) {
			return true;
		} else {
			return false;
		}
	}

	public static InputStream getInputStream(File file) throws FileNotFoundException {
		return new FileInputStream(file);
	}
	
	public static InputStream getInputStream(byte[] array) {
		return new ByteArrayInputStream(array);
	}
	
	/** DURACION **/	
	
//	public static final Map<Integer, String> MAP_TIPO_DURACION_LABEL = new LinkedHashMap<Integer, String>() {
//
//		private static final long serialVersionUID = 1L;
//
//		{
//			put(Constant.TIPO_DURACION_ANIO, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_ANIO"));
//			put(Constant.TIPO_DURACION_MES, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_MES"));
//			put(Constant.TIPO_DURACION_DIA, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_DIA"));
//			put(Constant.TIPO_DURACION_HORAS, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_HORAS"));
//		}
//	};
	
	
//	/** COLORES PARA EL HORARIO **/
//	private static final String COLOR_UNO = "color1"; /** #458b74 **/
//	private static final String COLOR_DOS = "color2"; /** #4f5066 **/
//	private static final String COLOR_TRES = "color3"; /** #cd6600 **/
//	private static final String COLOR_CUATRO = "color4"; /** #cd5c5c **/
//	private static final String COLOR_CINCO = "color5"; /** #808080 **/
//	private static final String COLOR_SEIS = "color6"; /** #c39797 **/
//	private static final String COLOR_SIETE = "color7"; /** #b2d080 **/
//	private static final String COLOR_OCHO = "color8"; /** #34b7ea **/
//	private static final String COLOR_NUEVE = "color9";/** #daa520 **/
//	private static final String COLOR_DIEZ = "color10";/** #3b5998 **/
//	private static final String COLOR_ONCE = "color11";/** #eed5b7 **/
//	private static final String COLOR_DOCE = "color12";/** #9fb6cd **/
//	private static final String COLOR_TRECE = "color13";/** #7d26cd **/
//	private static final String COLOR_CATORCE = "color14";/** #8b475d **/
//	private static final String COLOR_QUINCE = "color15";/** #548b54 **/
//	private static final String COLOR_DIECISEIS = "color16";/** #8db6cd **/
//	private static final String COLOR_DIECISIETE = "color17";/** #1874cd **/
//	private static final String COLOR_DIECIOCHO = "color18";/** #8b8378 **/
//	private static final String COLOR_DIECINUEVE = "color19";/** #7e8851 **/
//	private static final String COLOR_VEINTE = "color20";/** #d2b48c **/
//
//	public static final Map<Integer, String> MAP_COLORES_HORARIO = new LinkedHashMap<Integer, String>() {
//
//		private static final long serialVersionUID = 1L;
//
//		{
//			put(1, COLOR_UNO);
//			put(2, COLOR_DOS);
//			put(3, COLOR_TRES);
//			put(4, COLOR_CUATRO);
//			put(5, COLOR_CINCO);
//			put(6, COLOR_SEIS);
//			put(7, COLOR_SIETE);
//			put(8, COLOR_OCHO);
//			put(9, COLOR_NUEVE);
//			put(10, COLOR_DIEZ);
//			put(11, COLOR_ONCE);
//			put(12, COLOR_DOCE);
//			put(13, COLOR_TRECE);
//			put(14, COLOR_CATORCE);
//			put(15, COLOR_QUINCE);
//			put(16, COLOR_DIECISEIS);
//			put(17, COLOR_DIECISIETE);
//			put(18, COLOR_DIECIOCHO);
//			put(19, COLOR_DIECINUEVE);
//			put(20, COLOR_VEINTE);
//		}
//	};
	
	/** ESTADO DEL HORARIO MANTENIMIENTO **/	
//	public static final Map<String, String> MAP_HORARIO_ESTADO_LABEL = new LinkedHashMap<String, String>() {
//
//		private static final long serialVersionUID = 1L;
//		{
//			put(Constant.ESTADO_GRUPO_HORARIO_EN_PREPARACION, FacesUtil.getPropertyLabels("ITEM_ESTADO_EN_PREPARACION"));
//			put(Constant.ESTADO_GRUPO_HORARIO_APROBADO, FacesUtil.getPropertyLabels("ITEM_ESTADO_APROBADO"));
//			put(Constant.ESTADO_GRUPO_HORARIO_ANULADO, FacesUtil.getPropertyLabels("ITEM_ESTADO_ANULADO"));
//		}
//	};
	
	

}

