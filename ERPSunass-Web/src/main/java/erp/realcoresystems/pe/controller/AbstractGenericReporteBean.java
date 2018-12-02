package erp.realcoresystems.pe.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import erp.realcoresystems.pe.commons.EventosBean;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.util.IntegerUtil;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;

public abstract class AbstractGenericReporteBean  implements Serializable{

	
	private static final String URL_DEFAULT= "/vistas/comercial/paginaDefault.xhtml?faces-redirect=true";
	
	protected EventosBean eventoSeleccion= new EventosBean();	
	
	/** MODOS */
	public static String MODO_NEW = "Nuevo";	
	public static String MODO_VIEW = "Ver";
	
	/** MENSAJES TIPOS **/
	public static String SUCCESS = "success";
	public static String ERROR = "error";
	public static String WARN = "warning";
	public static String INFO = "info";
	
	public String MODO_ACTUAL = MODO_NEW;
	// PARA MENSAJES POST WINDOW

	public boolean btnBuscarVisible;
	public boolean btnAceptarVisible;
	public boolean btnCancelarVisible;
	public boolean btnNuevoVisible;
	public boolean btnModificarVisible;
	public boolean btnEliminarVisible;
	public boolean btnVerVisible;
	public boolean btnGuardarVisible;
	public boolean btnGuardarEliminarVisible;
	public boolean btnGuardarInactivarVisible;
	
	public boolean componentesReadonly;

	private boolean modoNew;
	private boolean modoView;
	
	public Integer tipoproducto;
	
	public Map<Integer, String> MAP_DIAS_LABEL;
	public Map<Integer, String> MAP_MES_LABEL;
	public Map<Integer, String> MAP_DIAS_RESUMEN_LABEL;
	
	
	public void initComponentes() {		
		///////////						
		btnBuscarVisible = true;
		btnAceptarVisible = true;
		btnCancelarVisible = true;
		btnNuevoVisible = true;
		btnModificarVisible = true;
		btnEliminarVisible = true;		
		btnVerVisible = true;
		
		modoNew=false;
		modoView=false;		
		/////////////
		btnGuardarVisible = true;
		btnGuardarEliminarVisible=true;
		btnGuardarInactivarVisible=true;		
		componentesReadonly = false;

	}

	public void setAtributosWindowsRegistro(String modo) {
		if (MODO_VIEW.equals(modo)) {			
			componentesReadonly = true;
			btnGuardarVisible = false;
			btnAceptarVisible = true;
			btnCancelarVisible = false;			
			btnGuardarEliminarVisible=false;
			btnGuardarInactivarVisible=false;
			setModoView(true);
		} else if (MODO_NEW.equals(modo)) {			
			componentesReadonly = false;
			btnGuardarVisible = true;
			btnAceptarVisible = false;
			btnCancelarVisible = true;			
			btnGuardarEliminarVisible=false;
			btnGuardarInactivarVisible=false;			
			setModoNew(true);
		} 
	}
	
	
	public void cargarMapDiasLabel() {
		MAP_DIAS_LABEL = new LinkedHashMap<Integer, String>();
		MAP_DIAS_LABEL.put(TimeCommons.DIA_LUNES_JODA, FacesUtil.getPropertyLabels("DAY_LUNES"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_MARTES_JODA, FacesUtil.getPropertyLabels("DAY_MARTES"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_MIERCOLES_JODA, FacesUtil.getPropertyLabels("DAY_MIERCOLES"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_JUEVES_JODA, FacesUtil.getPropertyLabels("DAY_JUEVES"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_VIERNES_JODA, FacesUtil.getPropertyLabels("DAY_VIERNES"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_SABADO_JODA, FacesUtil.getPropertyLabels("DAY_SABADO"));
		MAP_DIAS_LABEL.put(TimeCommons.DIA_DOMINGO_JODA, FacesUtil.getPropertyLabels("DAY_DOMINGO"));		
	}
	
	public void cargarMapMesLabel() {
		MAP_MES_LABEL = new LinkedHashMap<Integer, String>();
		MAP_MES_LABEL.put(TimeCommons.MES_ENERO_JODA, FacesUtil.getPropertyLabels("MES_ENERO"));
		MAP_MES_LABEL.put(TimeCommons.MES_FEBRERO_JODA, FacesUtil.getPropertyLabels("MES_FEBRERO"));
		MAP_MES_LABEL.put(TimeCommons.MES_MARZO_JODA, FacesUtil.getPropertyLabels("MES_MARZO"));
		MAP_MES_LABEL.put(TimeCommons.MES_ABRIL_JODA, FacesUtil.getPropertyLabels("MES_ABRIL"));
		MAP_MES_LABEL.put(TimeCommons.MES_MAYO_JODA, FacesUtil.getPropertyLabels("MES_MAYO"));
		MAP_MES_LABEL.put(TimeCommons.MES_JUNIO_JODA, FacesUtil.getPropertyLabels("MES_JUNIO"));
		MAP_MES_LABEL.put(TimeCommons.MES_JULIO_JODA, FacesUtil.getPropertyLabels("MES_JULIO"));
		MAP_MES_LABEL.put(TimeCommons.MES_AGOSTO_JODA, FacesUtil.getPropertyLabels("MES_AGOSTO"));
		MAP_MES_LABEL.put(TimeCommons.MES_SEPTIEMBRE_JODA, FacesUtil.getPropertyLabels("MES_SEPTIEMBRE"));
		MAP_MES_LABEL.put(TimeCommons.MES_OCTUBRE_JODA, FacesUtil.getPropertyLabels("MES_OCTUBRE"));
		MAP_MES_LABEL.put(TimeCommons.MES_NOVIEMBRE_JODA, FacesUtil.getPropertyLabels("MES_NOVIEMBRE"));
		MAP_MES_LABEL.put(TimeCommons.MES_DICIEMBRE_JODA, FacesUtil.getPropertyLabels("MES_DICIEMBRE"));		
	}

	
	/**
	 * PRUEBA DE SET DEL CONTENEDOR REPORTE
	 */
	public void setContenedor_ReporteTest() {
		String varDialog="";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(Utiles.COD_REPORTE_SERVLET,Utiles.COD_REPORTE_USUARIO);						
		//LLAMAR A CONTNEDOR GENERAL
		FacesUtil.setContenedor_ReporteGen(parametros,"FormUsuario",varDialog,"",Utiles.FORMATO_PDF,"600",false);	
	}	
	
	
	@SuppressWarnings("el-syntax")
	public Object getGenericObjectBean(String nombreBean, String nombreAtributo, Class<?> tipo) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ELContext el = facesContext.getELContext();
			Application app = facesContext.getApplication();
			ExpressionFactory ef = app.getExpressionFactory();
			ValueExpression ve = ef.createValueExpression(el, "#{" + nombreBean + "." + nombreAtributo + "}", tipo);
			Object obj = ve.getValue(el);
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public EventosBean getGenericEventoBean(String nombreBean, String nombreEvento) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ELContext el = facesContext.getELContext();
			Application app = facesContext.getApplication();
			ExpressionFactory ef = app.getExpressionFactory();
			ValueExpression ve = ef.createValueExpression(el, "#{" + nombreBean + "." + nombreEvento + "}",
					EventosBean.class);
			EventosBean obj = (EventosBean) ve.getValue(el);
			return obj;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public EventosBean getEventoSeleccion() {
		return eventoSeleccion;
	}

	public void setEventoSeleccion(EventosBean eventoSeleccion) {
		this.eventoSeleccion = eventoSeleccion;
	}

	public boolean isBtnBuscarVisible() {
		return btnBuscarVisible;
	}

	public void setBtnBuscarVisible(boolean btnBuscarVisible) {
		this.btnBuscarVisible = btnBuscarVisible;
	}

	public boolean isBtnAceptarVisible() {
		return btnAceptarVisible;
	}

	public void setBtnAceptarVisible(boolean btnAceptarVisible) {
		this.btnAceptarVisible = btnAceptarVisible;
	}

	public boolean isBtnCancelarVisible() {
		return btnCancelarVisible;
	}

	public void setBtnCancelarVisible(boolean btnCancelarVisible) {
		this.btnCancelarVisible = btnCancelarVisible;
	}

	public boolean isBtnNuevoVisible() {
		return btnNuevoVisible;
	}

	public void setBtnNuevoVisible(boolean btnNuevoVisible) {
		this.btnNuevoVisible = btnNuevoVisible;
	}

	public boolean isBtnModificarVisible() {
		return btnModificarVisible;
	}

	public void setBtnModificarVisible(boolean btnModificarVisible) {
		this.btnModificarVisible = btnModificarVisible;
	}

	public boolean isBtnEliminarVisible() {
		return btnEliminarVisible;
	}

	public void setBtnEliminarVisible(boolean btnEliminarVisible) {
		this.btnEliminarVisible = btnEliminarVisible;
	}

	public boolean isBtnVerVisible() {
		return btnVerVisible;
	}

	public void setBtnVerVisible(boolean btnVerVisible) {
		this.btnVerVisible = btnVerVisible;
	}

	public boolean isBtnGuardarVisible() {
		return btnGuardarVisible;
	}

	public void setBtnGuardarVisible(boolean btnGuardarVisible) {
		this.btnGuardarVisible = btnGuardarVisible;
	}

	public boolean isBtnGuardarEliminarVisible() {
		return btnGuardarEliminarVisible;
	}

	public void setBtnGuardarEliminarVisible(boolean btnGuardarEliminarVisible) {
		this.btnGuardarEliminarVisible = btnGuardarEliminarVisible;
	}

	public boolean isBtnGuardarInactivarVisible() {
		return btnGuardarInactivarVisible;
	}

	public void setBtnGuardarInactivarVisible(boolean btnGuardarInactivarVisible) {
		this.btnGuardarInactivarVisible = btnGuardarInactivarVisible;
	}

	public boolean isComponentesReadonly() {
		return componentesReadonly;
	}

	public void setComponentesReadonly(boolean componentesReadonly) {
		this.componentesReadonly = componentesReadonly;
	}

	public boolean isModoNew() {
		return modoNew;
	}

	public void setModoNew(boolean modoNew) {
		this.modoNew = modoNew;
	}


	public boolean isModoView() {
		return modoView;
	}

	public void setModoView(boolean modoView) {
		this.modoView = modoView;
	}

	public Map<Integer, String> getMAP_DIAS_LABEL() {
		return MAP_DIAS_LABEL;
	}

	public Map<Integer, String> getMAP_MES_LABEL() {
		return MAP_MES_LABEL;
	}

	public Map<Integer, String> getMAP_DIAS_RESUMEN_LABEL() {
		return MAP_DIAS_RESUMEN_LABEL;
	}


	
	
}
