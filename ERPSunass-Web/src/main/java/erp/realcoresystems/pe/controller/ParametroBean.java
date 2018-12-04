package erp.realcoresystems.pe.controller;

import java.io.Serializable;

import erp.realcoresystems.pe.commons.UtilesCommons;

import erp.realcoresystems.pe.model.domain.ParametrosMastPK;
import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Constant;

public class ParametroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String parametroCantRows;
	private String entradasVisualizadas;
	private String parametroAuditSoloTransact;
	private String parametroMinimoLongClaves;
	private String parametroElimnarFisico;
	private String parametroHoraLectiva;
	private String parametroHoraLectivaPrograma;
	private String parametroHoraLectivaCurso;
	private String parametroActivoUsoMoodle;

	private String parametroAlumnoHorarioModoRegistro;
	private String parametroActivoValidarPersonaHistAcad;
	private String parametroActivoUsoAlfreso;

	private String parametroActivoUsoReniec;

	private String parametroHoraInicio;
	private String parametroHoraFin;
		
	private boolean indicaShowServicionExternoIComercial;
	private boolean indicaShowServicionExternoIPlanilla;
	
	private boolean indicaGuardarArchivosSoloPath;
	private boolean indicaHabilitarSilabusContenido;
	private boolean indicaHabilitarRegDirectoVentaDocumento;
	
	private String  paramUrlBaseiSpringComercial;
	private String  paramUrlBaseiSpringCore;
	private String  paramUrlBaseiSpringPlanilla;
	
	public String getParametroCantRows() {
		String filas = EntityGlobal.getInstance().getMapPropParametros().get(FacesUtil.getPropertyParametros("PAR_CANTPAGINA"));
		if (filas == null) {
			filas = FacesUtil.getPropertyParametros("DEFAULT_CANTPAGINA");
		}
		Double numfilas = Double.parseDouble(filas);
		parametroCantRows = ""+numfilas.intValue();
		return parametroCantRows;
	}

	public String getParametroAuditSoloTransact() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_AUDIT_SOLOTRANSACT"));
		if (param == null) {
			param = "S";
		}
		parametroAuditSoloTransact = param;
		return parametroAuditSoloTransact;
	}

	public String getEntradasVisualizadas() {
		String entradas = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_ENTRIES_VIEW"));
		if (entradas == null) {
			entradas = FacesUtil.getPropertyParametros("DEFAULT_ENTRIES_VIEW");
		}
		entradasVisualizadas = entradas;
		return entradasVisualizadas;
	}

	public String getParametroMinimoLongClaves() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_MIN_LONGPERM_CLAVE"));
		if (param == null) {
			param = "1";
		}
		parametroMinimoLongClaves = param;
		return parametroMinimoLongClaves;
	}

	public String getParametroElimnarFisico() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_ELIMINAR_FISICO"));
		if (param == null) {
			param = "S";
		}
		parametroElimnarFisico = param;
		return parametroElimnarFisico;
	}

	public String getParametroHoraLectiva() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA_DEFAULT");
		}
		parametroHoraLectiva = param;
		return parametroHoraLectiva;
	}

	/**********/
	public String getParametroHoraLectivaPrograma() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA_PROGRAMA"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA_PROGRAMA_DEFAULT");
		}
		Double numfilas = Double.parseDouble(param);
		parametroHoraLectivaPrograma = ""+numfilas.intValue();
		return parametroHoraLectivaPrograma;
	}

	public String getParametroHoraLectivaCurso() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA_CURSO"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PAR_HORA_LECTIVA_CURSO_DEFAULT");
		}
		Double numfilas = Double.parseDouble(param);
		parametroHoraLectivaCurso = ""+numfilas.intValue();
		return parametroHoraLectivaCurso;
	}

	public String getParametroActivoUsoMoodle() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PARAM_MOODLE"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PARAM_MOODLE_DEFAULT");
		}
		parametroActivoUsoMoodle = param;
		return parametroActivoUsoMoodle;
	}

	/**
	 * Por defecto el MODO de REGISRO DEL HORARIO, debe ser SEMANAL: SEM
	 * 
	 * @return
	 */
	public String getParametroAlumnoHorarioModoRegistro() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PARAM_ALUMNO_HORARIO_MODO_REGISTRO"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PARAM_ALUMNO_HORARIO_MODO_REGISTRO_DEFAULT");
		}
		parametroAlumnoHorarioModoRegistro = param;
		return parametroAlumnoHorarioModoRegistro;
	}

	public String getParametroActivoValidarPersonaHistAcad() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_VALIDAR_PERS_EXISTE_HIST_ACAD"));
		if (param == null) {
			param = Constant.SI_db;// OBS:
		}
		parametroActivoValidarPersonaHistAcad = param;
		return parametroActivoValidarPersonaHistAcad;
	}

	public String getParametroActivoUsoAlfreso() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PARAM_GESTORCONTENT"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PARAM_GESTORCONTENT_DEFAULT");
		}
		parametroActivoUsoAlfreso = param;
		return parametroActivoUsoAlfreso;
	}

	public String getParametroActivoUsoReniec() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PARAM_RENIEC"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PARAM_RENIEC_DEFAULT");
		}
		parametroActivoUsoReniec = param;
		return parametroActivoUsoReniec;
	}

	public String getParametroHoraInicio() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_HORA_INICIO"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PAR_HORA_INICIO_DEFAULT");
		}
		Double numfilas = Double.parseDouble(param);
		parametroHoraInicio = ""+numfilas.intValue();
		return parametroHoraInicio;
	}

	public String getParametroHoraFin() {
		String param = EntityGlobal.getInstance().getMapPropParametros()
				.get(FacesUtil.getPropertyParametros("PAR_HORA_FIN"));
		if (param == null) {
			param = FacesUtil.getPropertyParametros("PAR_HORA_FIN_DEFAULT");
		}
		Double numfilas = Double.parseDouble(param);
		parametroHoraFin = ""+numfilas.intValue();
		return parametroHoraFin;
	}

	public ParametrosMastPK buildDefaultParameterId(String parameterName) {
		ParametrosMastPK id = new ParametrosMastPK();
		id.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		id.setCompaniacodigo(Constant.COMPANIA_VARIABLE);
		id.setParametroclave(parameterName);
		return id;
	}

	public ParametrosMastPK buildDefaultPropertyParameterId(String propertyKey) {
		return buildDefaultParameterId(getPropertyParameter(propertyKey));
	}

	public String getPropertyParameter(String propertyKey) {
		String propertyValue = FacesUtil.getPropertyParametros(propertyKey);
		return propertyValue;
	}

	public boolean isIndicaShowServicionExternoIComercial() {
		indicaShowServicionExternoIComercial = false;
		String param = FacesUtil.getPropertyParametros("PARAM_SHOW_SERVICE_EXT_ICOMERCIAL");
		if (param != null && Constant.SI_db.equals(param)) {
			indicaShowServicionExternoIComercial = true;
		}						
		return indicaShowServicionExternoIComercial;
	}

	public boolean isIndicaShowServicionExternoIPlanilla() {
		indicaShowServicionExternoIPlanilla = false;
		String param = FacesUtil.getPropertyParametros("PARAM_SHOW_SERVICE_EXT_IPLANILLA");
		if (param != null && Constant.SI_db.equals(param)) {
			indicaShowServicionExternoIPlanilla = true;
		}			
		return indicaShowServicionExternoIPlanilla;
	}

	public boolean isIndicaGuardarArchivosSoloPath() {
		indicaGuardarArchivosSoloPath = false;
		String param = FacesUtil.getPropertyParametros("PARAM_SAVEFILES_SOLOPATH");
		if (param != null && Constant.SI_db.equals(param)) {
			indicaGuardarArchivosSoloPath = true;
		}			
		return indicaGuardarArchivosSoloPath;
				
	}


	public boolean isIndicaHabilitarSilabusContenido() {
		indicaHabilitarSilabusContenido = false;
		String param = FacesUtil.getPropertyParametrosSystemServer("PARAM_SHOW_SILABUSCONTEN_PROP");
		if(UtilesCommons.esVacio(param)){
			param = FacesUtil.getPropertyParametros("PARAM_SHOW_SILABUSCONTEN");
		}
		if (param != null && Constant.SI_db.equals(param)) {
			indicaHabilitarSilabusContenido = true;
		}			
		return indicaHabilitarSilabusContenido;
	}
	
	
	
	public boolean isIndicaHabilitarRegDirectoVentaDocumento() {
		indicaHabilitarRegDirectoVentaDocumento = false;
		String param = FacesUtil.getPropertyParametrosSystemServer("PARAM_SHOW_REGDIRECTO_VENTADOCUMENTO_PROP");
		if(UtilesCommons.esVacio(param)){
			param = FacesUtil.getPropertyParametros("PARAM_SHOW_REGDIRECTO_VENTADOCUMENTO");
		}
		
		if (param != null && Constant.SI_db.equals(param)) {
			indicaHabilitarRegDirectoVentaDocumento = true;
		}
		return indicaHabilitarRegDirectoVentaDocumento;		
	}

	/** URL ISPRING COMERCIAL
	 * @return
	 */
	public String getParamUrlBaseiSpringComercial() {
		String urlBaseiSpring = "";
		urlBaseiSpring = FacesUtil.getPropertyParametrosSystemServer("URL_SERVICE_REST_ISPRING_PROP");
		if(UtilesCommons.esVacio(urlBaseiSpring)){
			urlBaseiSpring = FacesUtil.getPropertyParametros("URL_SERVICE_REST_ISPRING");	
		}	
		paramUrlBaseiSpringComercial = urlBaseiSpring;
		return paramUrlBaseiSpringComercial;
	}

	public String getParamUrlBaseiSpringCore() {
		String urlBaseiSpring = "";
		urlBaseiSpring = FacesUtil.getPropertyParametrosSystemServer("URL_SERVICE_REST_ISPRING_CORE_PROP");
		if(UtilesCommons.esVacio(urlBaseiSpring)){
			urlBaseiSpring = FacesUtil.getPropertyParametros("URL_SERVICE_REST_ISPRING_CORE");	
		}	
		paramUrlBaseiSpringCore = urlBaseiSpring;				
		return paramUrlBaseiSpringCore;
	}

	public String getParamUrlBaseiSpringPlanilla() {
		String urlBaseiSpring = "";
		urlBaseiSpring = FacesUtil.getPropertyParametrosSystemServer("URL_SERVICE_REST_PLANILLA");
		if(UtilesCommons.esVacio(urlBaseiSpring)){
			urlBaseiSpring = FacesUtil.getPropertyParametros("URL_SERVICE_REST_PLANILLA");	
		}	
		paramUrlBaseiSpringPlanilla = urlBaseiSpring;	
		return paramUrlBaseiSpringPlanilla;
	}
	
}
