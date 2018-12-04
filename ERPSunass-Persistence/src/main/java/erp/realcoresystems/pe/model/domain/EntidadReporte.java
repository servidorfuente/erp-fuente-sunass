package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EntidadReporte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5959997090802571042L;
	
	Map<String, Object> parametros;
	
	private String nombreReportGen;
	private String codigoReportGen;
	private String formatoReportGen;
	private String formPadreReportGen;
	private String varDialogReportGen;
	
	private String urlReportGen;
	
	private String heightReporteGen;
	
	private Integer idReporteGen;
	
	private String nombreFileReportGen;
	private String pathFileReportGen;
	private boolean indicaPersistenciaPath;
	private boolean indicaPersistenciaGestorContenido;

	private boolean visibleAceptarReportGen;

	private boolean indicaModoDescarga;

	public boolean isIndicaModoDescarga() {
		return indicaModoDescarga;
	}

	public void setIndicaModoDescarga(boolean indicaModoDescarga) {
		this.indicaModoDescarga = indicaModoDescarga;
	}

	public EntidadReporte() {		
		parametros = new HashMap<String, Object>();
	}

	public Map<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}

	public String getNombreReportGen() {
		return nombreReportGen;
	}

	public void setNombreReportGen(String nombreReportGen) {
		this.nombreReportGen = nombreReportGen;
	}

	public String getFormatoReportGen() {
		return formatoReportGen;
	}

	public void setFormatoReportGen(String formatoReportGen) {
		this.formatoReportGen = formatoReportGen;
	}

	public String getUrlReportGen() {
		return urlReportGen;
	}

	public void setUrlReportGen(String urlReportGen) {
		this.urlReportGen = urlReportGen;
	}

	public boolean isVisibleAceptarReportGen() {
		return visibleAceptarReportGen;
	}

	public void setVisibleAceptarReportGen(boolean visibleAceptarReportGen) {
		this.visibleAceptarReportGen = visibleAceptarReportGen;
	}

	public String getFormPadreReportGen() {
		return formPadreReportGen;
	}

	public void setFormPadreReportGen(String formPadreReportGen) {
		this.formPadreReportGen = formPadreReportGen;
	}

	public String getVarDialogReportGen() {
		return varDialogReportGen;
	}

	public void setVarDialogReportGen(String varDialogReportGen) {
		this.varDialogReportGen = varDialogReportGen;
	}

	public String getHeightReporteGen() {
		return heightReporteGen;
	}

	public void setHeightReporteGen(String heightReporteGen) {
		this.heightReporteGen = heightReporteGen;
	}

	public Integer getIdReporteGen() {
		return idReporteGen;
	}

	public void setIdReporteGen(Integer idReporteGen) {
		this.idReporteGen = idReporteGen;
	}

	public String getCodigoReportGen() {
		return codigoReportGen;
	}

	public void setCodigoReportGen(String codigoReportGen) {
		this.codigoReportGen = codigoReportGen;
	}

	public String getNombreFileReportGen() {
		return nombreFileReportGen;
	}

	public void setNombreFileReportGen(String nombreFileReportGen) {
		this.nombreFileReportGen = nombreFileReportGen;
	}

	public String getPathFileReportGen() {
		return pathFileReportGen;
	}

	public void setPathFileReportGen(String pathFileReportGen) {
		this.pathFileReportGen = pathFileReportGen;
	}

	public boolean isIndicaPersistenciaPath() {
		return indicaPersistenciaPath;
	}

	public void setIndicaPersistenciaPath(boolean indicaPersistenciaPath) {
		this.indicaPersistenciaPath = indicaPersistenciaPath;
	}

	public boolean isIndicaPersistenciaGestorContenido() {
		return indicaPersistenciaGestorContenido;
	}

	public void setIndicaPersistenciaGestorContenido(boolean indicaPersistenciaGestorContenido) {
		this.indicaPersistenciaGestorContenido = indicaPersistenciaGestorContenido;
	}
	
}
