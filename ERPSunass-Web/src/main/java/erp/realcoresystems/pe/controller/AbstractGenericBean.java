package erp.realcoresystems.pe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.UsuarioService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

import erp.realcoresystems.pe.commons.EventosBean;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;

import erp.realcoresystems.pe.model.util.IntegerUtil;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Log;
import erp.realcoresystems.pe.model.util.Utiles;


public abstract class AbstractGenericBean extends ParametroBean implements Serializable {

	public static String URL_DEFAULT = FacesUtil.getPropertyParametros("PAR_PAGINA_DEFAULT_BLANK");

	/***/
	private String lenguaje;

	/** VARIABLES DEL SISTEMA */
	// public ResourceBundle propiedades = ResourceBundle.getBundle("mensajes");

	/** VARIABLES DEL SISTEMA */
	// public ResourceBundle propiedades = ResourceBundle.getBundle("mensajes");

	private static final long serialVersionUID = 1L;

	// public Map<String, Object> optionsWindowPrincipal;

	@ManagedProperty( value = "#{usuarioService}")
	private UsuarioService usuarioServiceAbstractGen;

	
	@ManagedProperty( value = "#{maMiscelaneosdetalleService}")
	private MaMiscelaneosdetalleService miscelaneoServiceAbstractGen;
	

	public static String APP_CODIGO = "...";
	public static String USUARIO_ACTUAL = "...";
	public static String UNOMBRE_SUARIO_ACTUAL = "...";
	public static Long USUARIO_EMPLEADO_ID = new Long(0);
	/** MODOS */
	public static final String MODO_NEW = "Nuevo";
	public static final String MODO_UPDATE = "Editar";
	public static final String MODO_DELETE = "Eliminar";
	public static final String MODO_INACTIVAR = "Inactivar";
	public static final String MODO_VIEW = "Ver";

	public static final String MODO_EXTERNO = "Registro";

	public static final String TIPO_OPER_GUARDARVOLVER = "SAVE_BACK";
	public static final String TIPO_OPER_GUARDAR = "SAVE";
	public static final String TIPO_OPER_VER = "VER";
	public static final String TIPO_OPER_GUARDAR_ERROR = "SAVE_ERROR";

	public static String MODO_ACCION_MAESTRO = "Maestro";
	public static String MODO_CERRAR = "Cerrar";
	public static String MODO_ACCION = MODO_ACCION_MAESTRO;


	/** MENSAJES TIPOS **/
	public static String SUCCESS = "success";
	public static String ERROR = "error";
	public static String WARN = "warning";
	public static String INFO = "info";

	public String MODO_ACTUAL = MODO_NEW;
	// PARA MENSAJES POST WINDOW

	public String onSuccesMsg;
	public String onSuccesType;
	public boolean onSuccesIndica;

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
	private boolean modoUpdate;
	private boolean modoView;
	private boolean modoDelete;
	private boolean modoInactivate;

	public String paginaDefault;
	public String paginaActual;
	public String conceptoDescActual;

	public String grupoDefault;
	public String conceptoDefault;

	public boolean visibleRegistro;
	public boolean indicaModoExterno;

	public Map<String, String> mapPropSeguridad = new HashMap<String, String>();
	protected boolean evitarSeguridad;

	public String localeSession;
	
	protected  Map<String, String> auditoria;	
	
	/**TIPO DE PRODUCTO***/
	private List<SelectItem> listItemTP;
	private Map<String, MaMiscelaneosdetalle> mapTipoProducto = new LinkedHashMap<String, MaMiscelaneosdetalle>();
	
	public Integer tipoproducto;	
	
	public void initComponentes() {		
		///////////
		visibleRegistro = false;
		indicaModoExterno = false;

		btnBuscarVisible = true;
		btnAceptarVisible = true;
		btnCancelarVisible = true;
		btnNuevoVisible = true;
		btnModificarVisible = true;
		btnEliminarVisible = true;
		btnVerVisible = true;

		modoNew = false;
		modoView = false;
		modoUpdate = false;
		modoDelete = false;
		/////////////
		btnGuardarVisible = true;
		btnGuardarEliminarVisible = true;
		btnGuardarInactivarVisible = true;

		componentesReadonly = false;
		onSuccesMsg = "...";
		onSuccesType = Utiles.TYPE_MSG_INFO;
		onSuccesIndica = false;
		evitarSeguridad = true;
						
		
		auditoria = new HashMap<String, String>();
		
	}
	
	public <T> T getObjectBean(String nombreBean, String nombreAtributo, Class<T> tipo){
		Object obj = getGenericObjectBean(nombreBean, nombreAtributo, tipo);
		return UtilesCommons.castearObjeto(obj, tipo);
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

	public String getConcatenarDes(String codigo, String descripcion){
		return UtilesCommons.noEsVacio(codigo) && UtilesCommons.noEsVacio(descripcion) ? "("+codigo+") "+ descripcion  : "";
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

	public <T> T getGenericObjectBeanCast(String nombreBean, String nombreAtributo, Class<T> tipo) {
		Object obj = getGenericObjectBean(nombreBean, nombreAtributo, tipo);
		return UtilesCommons.castearObjeto(obj, tipo);
	}

	public boolean evaluarSeguridad(String idObjecto) {
		Map<String, String> seguridad = getMapPropSeguridad();
		if (seguridad.containsKey(idObjecto)) {
			String rpta = seguridad.get(idObjecto);
			if (Utiles.esVacio(rpta)) {
				if (evitarSeguridad) {
					return true;
				} else {
					return false;
				}
			} else {
				if (rpta.equalsIgnoreCase(Utiles.SI_db) || evitarSeguridad) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			if (evitarSeguridad) {
				return true;
			} else {
				return false;
			}
		}

	}

	public void setAtributosWindowsRegistro(String modo) {
		switch (modo) {
		case MODO_VIEW:
			modoView();
			break;
		case MODO_NEW:
			modoNew();
			break;
		case MODO_UPDATE:
			modoUpdate();
			break;
		case MODO_DELETE:
			modoDelete();
			break;
		case MODO_INACTIVAR:
			modoInactivate();
			break;
		}
	}

	public void modoView() {
		visibleRegistro = true;
		componentesReadonly = true;
		btnGuardarVisible = false;
		btnEliminarVisible= false;
		btnAceptarVisible = true;
		btnCancelarVisible = false;
		btnGuardarEliminarVisible = false;
		btnGuardarInactivarVisible = false;
		setModoView(true);
	}

	public void modoNew() {
		visibleRegistro = true;
		componentesReadonly = false;
		btnGuardarVisible = true;
		btnEliminarVisible= false;
		btnAceptarVisible = false;
		btnCancelarVisible = true;
		btnGuardarEliminarVisible = false;
		btnGuardarInactivarVisible = false;
		setModoNew(true);
	}

	public void modoUpdate() {
		visibleRegistro = true;
		componentesReadonly = false;
		btnGuardarVisible = true;
		btnAceptarVisible = false;
		btnEliminarVisible= false;
		btnCancelarVisible = true;
		btnGuardarEliminarVisible = false;
		btnGuardarInactivarVisible = false;
		setModoUpdate(true);
	}

	public void modoDelete() {
		visibleRegistro = true;
		componentesReadonly = true;
		btnGuardarVisible = false;
		btnAceptarVisible = false;
		btnEliminarVisible= true;
		btnCancelarVisible = true;
		btnGuardarEliminarVisible = true;
		btnGuardarInactivarVisible = false;
		setModoDelete(true);
	}

	public void modoInactivate() {
		visibleRegistro = true;
		componentesReadonly = true;
		btnGuardarVisible = false;
		btnAceptarVisible = false;
		btnEliminarVisible= false;
		btnCancelarVisible = true;
		btnGuardarEliminarVisible = false;
		btnGuardarInactivarVisible = true;
		setModoInactivate(true);
	}

	

	
	public String obtenerNombreUsuarioCreacion(Map<String, String> mapUsuarioCyM){
		if(mapUsuarioCyM.containsKey("creador")){
			return mapUsuarioCyM.get("creador");	
		}else{
			return "";
		}
	}

	public String obtenerNombreUsuarioModificacion(Map<String, String> mapUsuarioCyM){
		if(mapUsuarioCyM.containsKey("modificador")){
			return mapUsuarioCyM.get("modificador");	
		}else{
			return "";
		}
	}
	

	public Integer getInteger(int value){
		return Integer.valueOf(value);
	}
	
	public Integer getInteger(Integer value){
		return value == null ? new Integer(0) : value;
	}
	
	public int getIntegerNativo(Integer value){
		return value == null ? new Integer(0).intValue() : value.intValue();
	}
	
	public Integer plusInteger(Integer value, Integer add) {
		int suma = getIntegerNativo(value) + getIntegerNativo(add);
		return getInteger(suma);
	}
	
	public Integer substractInteger(Integer value, Integer substract) {
		int resta = getIntegerNativo(value) - getIntegerNativo(substract);
		return getInteger(resta);
	}
	
//	public boolean esDisponibleEventoGuardar(EventosBean evento) {
//		if (UtilesCommons.noEsNulo(evento) && UtilesCommons.noEsNulo(evento.getEventoGuardarGeneral())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public boolean esDisponibleEventoAceptar(EventosBean evento) {
//		if (UtilesCommons.noEsNulo(evento) && UtilesCommons.noEsNulo(evento.getEventoAceptarGeneral())) {
//			return true;
//		} else {
//			return false;
//		}
//	}

//	public boolean esDisponibleEventoCancelar(EventosBean evento) {
//		if (UtilesCommons.noEsNulo(evento) && UtilesCommons.noEsNulo(evento.getEventoCancelarGeneral())) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	


	public void setSeguridad() {
		setMapPropSeguridad(EntityGlobal.getInstance().mapPropSeguridad);
		setEvitarSeguridad(false);
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

	public boolean isComponentesReadonly() {
		return componentesReadonly;
	}

	public boolean isBtnGuardarEliminarVisible() {
		return btnGuardarEliminarVisible;
	}

	public void setBtnGuardarEliminarVisible(boolean btnGuardarEliminarVisible) {
		this.btnGuardarEliminarVisible = btnGuardarEliminarVisible;
	}

	public void setComponentesReadonly(boolean componentesReadonly) {
		this.componentesReadonly = componentesReadonly;
	}

	public String getOnSuccesMsg() {
		return onSuccesMsg;
	}

	public void setOnSuccesMsg(String onSuccesMsg) {
		this.onSuccesMsg = onSuccesMsg;
	}

	public String getOnSuccesType() {
		return onSuccesType;
	}

	public void setOnSuccesType(String onSuccesType) {
		this.onSuccesType = onSuccesType;
	}

	public boolean isOnSuccesIndica() {
		return onSuccesIndica;
	}

	public void setOnSuccesIndica(boolean onSuccesIndica) {
		this.onSuccesIndica = onSuccesIndica;
	}

	public static Long getUSUARIO_EMPLEADO_ID() {
		return USUARIO_EMPLEADO_ID;
	}

	public static void setUSUARIO_EMPLEADO_ID(Long uSUARIO_EMPLEADO_ID) {
		USUARIO_EMPLEADO_ID = uSUARIO_EMPLEADO_ID;
	}

	public static String getAPP_CODIGO() {
		return APP_CODIGO;
	}

	public static void setAPP_CODIGO(String aPP_CODIGO) {
		APP_CODIGO = aPP_CODIGO;
	}

	public static String getUSUARIO_ACTUAL() {
		// return USUARIO_ACTUAL;
		return EntityGlobal.getInstance().getUsuario();
	}

	public static void setUSUARIO_ACTUAL(String uSUARIO_ACTUAL) {
		USUARIO_ACTUAL = uSUARIO_ACTUAL;
	}

	public static String getUNOMBRE_SUARIO_ACTUAL() {
		// UNOMBRE_SUARIO_ACTUAL = EntityGlobal.getInstance()
		// !=null?EntityGlobal.getInstance().getNombreCompleto():"Nombre";
		return UNOMBRE_SUARIO_ACTUAL;
	}

	public static void setUNOMBRE_SUARIO_ACTUAL(String uNOMBRE_SUARIO_ACTUAL) {
		UNOMBRE_SUARIO_ACTUAL = uNOMBRE_SUARIO_ACTUAL;
	}

	public boolean isModoUpdate() {
		return modoUpdate;
	}

	public void setModoUpdate(boolean modoUpdate) {
		this.modoNew = !modoUpdate;
		this.modoView = !modoUpdate;
		this.modoDelete = !modoUpdate;
		this.modoUpdate = modoUpdate;
		this.modoInactivate = !modoUpdate;/* MLUYO */
	}

	public boolean isModoView() {
		return modoView;
	}

	public void setModoView(boolean modoView) {
		this.modoNew = !modoView;
		this.modoView = modoView;
		this.modoDelete = !modoView;
		this.modoUpdate = !modoView;
		this.modoInactivate = !modoView;
	}

	public boolean isModoDelete() {
		return modoDelete;
	}

	public void setModoDelete(boolean modoDelete) {
		this.modoNew = !modoDelete;
		this.modoView = !modoDelete;
		this.modoDelete = modoDelete;
		this.modoUpdate = !modoDelete;
		this.modoInactivate = !modoDelete;
	}

	public boolean isModoNew() {
		return modoNew;
	}

	public void setModoNew(boolean modoNew) {
		this.modoNew = modoNew;
		this.modoView = !modoNew;
		this.modoDelete = !modoNew;
		this.modoUpdate = !modoNew;
		this.modoInactivate = !modoNew;/* MLUYO */
	}

	public boolean isModoInactivate() {
		return modoInactivate;
	}

	public void setModoInactivate(boolean modoInactivate) {
		this.modoNew = !modoInactivate;
		this.modoView = !modoInactivate;
		this.modoDelete = !modoInactivate;
		this.modoUpdate = !modoInactivate;
		this.modoInactivate = modoInactivate;
	}

	public Map<String, String> getMapPropSeguridad() {
		mapPropSeguridad = EntityGlobal.getInstance().getMapPropSeguridad();
		if (mapPropSeguridad == null) {
			mapPropSeguridad = new HashMap<String, String>();
		}
		return mapPropSeguridad;
	}

	public void setMapPropSeguridad(Map<String, String> mapPropSeguridad) {
		this.mapPropSeguridad = mapPropSeguridad;
	}
	
	public String getTipoProductoDes(String codigoElemento){
		try{
			return "";// mapTipoProducto.get(codigoElemento).getDescripcionlocal();
		}catch(NullPointerException ex){
			return "";
		}
	}

	public boolean isEvitarSeguridad() {
		return evitarSeguridad;
	}

	public void setEvitarSeguridad(boolean evitarSeguridad) {
		this.evitarSeguridad = evitarSeguridad;
	}

	/*
	 * public void eventPreRender() {
	 * setMapPropSeguridad(EntityGlobal.getInstance().getMapPropSeguridad()); }
	 */

	public String getMODO_ACTUAL() {
		return MODO_ACTUAL;
	}

	public void setMODO_ACTUAL(String mODO_ACTUAL) {
		MODO_ACTUAL = mODO_ACTUAL;
	}

	/*** EDICIÓN DE DESCARGAS ******/
	private String titulo = "";

	public void actionLinkDescarga(String infoDoc) {
		// System.out.println("TEST actionLinkDescarga..:"+infoDoc);
		titulo = infoDoc;
	}




    public void postProcessXLS_descarga(Object document) {
    	//System.out.println("TEST POST DESCARGA XLS...:"+titulo);
    	try{
            HSSFWorkbook wb = (HSSFWorkbook) document;
            HSSFSheet sheet = wb.getSheetAt(0);
            //SET NOMBRE A LA HOJA
            wb.setSheetName(wb.getSheetIndex(sheet), titulo);
            
            
                        
            //sheet.shiftRows(startRow, endRow, n);
            sheet.shiftRows(0,sheet.getLastRowNum(),7);
                        
            int rowHeadFecha=0;
            int rowHeadUser=1;
            int rowTitle=5;
            int rowHeader=7;
            short colorForer = HSSFColor.CORNFLOWER_BLUE.index; 
            //wb.setSheetName(0, titulo);           
            //cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK); 
            //cellStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
            	
            /*PARAT TÍTULO*/
            HSSFFont tituloFont = wb.createFont();
            tituloFont.setBoldweight(tituloFont.BOLDWEIGHT_BOLD);
            tituloFont.setFontHeightInPoints((short) 14);
            tituloFont.setColor(IndexedColors.WHITE.getIndex());
           //Set Estilos
            CellStyle tituloStyle = wb.createCellStyle();
            tituloStyle.setFillForegroundColor(colorForer);
            tituloStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            //tituloStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
            tituloStyle.setAlignment(tituloStyle.ALIGN_CENTER);
            tituloStyle.setFont(tituloFont);
            tituloStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
            //BORDE
            tituloStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            tituloStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            tituloStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            tituloStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
 
            tituloStyle.setTopBorderColor( HSSFColor.BLACK.index);
            tituloStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            tituloStyle.setRightBorderColor(HSSFColor.BLACK.index);
            tituloStyle.setBottomBorderColor(HSSFColor.BLACK.index);              

            /*PARA HEADER*/
            HSSFFont headerFont = wb.createFont();
            headerFont.setBoldweight(headerFont.BOLDWEIGHT_BOLD);
            headerFont.setFontHeightInPoints((short) 10);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerFont.setFontName("Arial");
                  
            
            HSSFCellStyle cellStyle = wb.createCellStyle();        
            cellStyle.setFillForegroundColor(colorForer);
            //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            //cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
            cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            cellStyle.setFont(headerFont);
            //BORDE
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
 
            cellStyle.setTopBorderColor( HSSFColor.BLACK.index);
            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);            
            
            HSSFCellStyle cellStyleData = wb.createCellStyle();        
            //cellStyleData.setFillForegroundColor(HSSFColor.RED.index);
            //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            //cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
            //cellStyleData.setFillPattern(CellStyle.SOLID_FOREGROUND);
            //cellStyleData.setAlignment(CellStyle.ALIGN_CENTER);
            cellStyleData.setFont(headerFont);
            //BORDE
            cellStyleData.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyleData.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyleData.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyleData.setBorderBottom(HSSFCellStyle.BORDER_THIN);
 
            cellStyleData.setTopBorderColor( HSSFColor.BLACK.index);
            cellStyleData.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyleData.setBottomBorderColor(HSSFColor.BLACK.index);    
            
            
            //SET HEADER
            HSSFRow header = sheet.getRow(rowHeader);
            int cantCeldasTitulo=0;
            for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
                HSSFCell cell = header.getCell(i);             
                cell.setCellStyle(cellStyle);
                sheet.autoSizeColumn(i);
                cantCeldasTitulo++;
            }
            if(cantCeldasTitulo<5){
            	
            }
            
            //System.out.println("[INFO TEST::]"+cantCeldasTitulo);
            //SET TITULO
            //HSSFRow title = sheet.getRow(rowTitle);            
            HSSFRow title = sheet.createRow(rowTitle);
            for(int i=0; i < cantCeldasTitulo;i++) {
            	title.createCell(i);	
            }            
            
            sheet.addMergedRegion(new CellRangeAddress(rowTitle,rowTitle,0,cantCeldasTitulo-1));
            
            for(int i=0;i<cantCeldasTitulo;i++){
            	title.getCell(i).setCellStyle(tituloStyle);	
            }                      
            title.getCell(0).setCellValue(""+titulo);
            
            
            /*TRABAJAR LOGIN **/
            try{
            	            	
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                
                String logo = servletContext.getRealPath("") + File.separator+"resources"+File.separator  + "images"  + File.separator + FacesUtil.getPropertyParametros("PARAM_IMAGEN_LOGO_HEAD_XLS");
                //System.out.println("TEST PRE  DESCARGA PDF LOGO...:"+logo);
                /**FALTA AJUSTAR LA IMAGEN*/                                
                //FileInputStream obtains input bytes from the image file
                InputStream inputStream = new FileInputStream(logo);
                //Get the contents of an InputStream as a byte[].
                byte[] bytes = IOUtils.toByteArray(inputStream);
                //Adds a picture to the workbook
                int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
                //close the input stream
                inputStream.close();                
                //Returns an object that handles instantiating concrete classes
                CreationHelper helper = wb.getCreationHelper();
                //Crear the top-level 
                Drawing drawing = sheet.createDrawingPatriarch();
                //Create an anchor that is attached to the worksheet
                ClientAnchor anchor = helper.createClientAnchor();
                //set top-left corner for the image
                anchor.setCol1(0);
                anchor.setCol2(2);
                anchor.setRow1(0);
                anchor.setRow2(3);
                //Creates a picture
                Picture pict = drawing.createPicture(anchor, pictureIdx);
                //Reset the image to the original size
                pict.resize();
            }catch(Exception  ex){ //FileNotFoundException
            	ex.printStackTrace();
            }
            
            /******************/
            
    	}catch(Exception ex){    		
    		ex.printStackTrace();
    		FacesUtil.adicionarMensajeWarning("No se pudo descargar el Archivo en este momento.");
    	}    	
        titulo="";
    }      
    
	public void preProcessPDF_descarga(Object document) throws IOException, BadElementException, DocumentException {
		//System.out.println("TEST PRE  DESCARGA PDF...:"+titulo);
        Document pdf = (Document) document;
        pdf.setPageSize(PageSize.A4.rotate());        
        pdf.open();                       
        pdf.addCreationDate();        
        
        //ADD IMAGEN
        try{
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String logo = servletContext.getRealPath("") + File.separator+"resources"+File.separator + "images"  + File.separator + FacesUtil.getPropertyParametros("PARAM_IMAGEN_LOGO_HEAD_PDF");
            //System.out.println("TEST PRE  DESCARGA PDF LOGO...:"+logo);
            /**FALTA AJUSTAR LA IMAGEN*/
            Image imageLeft = Image.getInstance(logo);

            //imageLeft.scaleToFit(2,2);
            //imageLeft.scaleAbsolute(150,35);
            //imageLeft.setAlignment(Image.ALIGN_CENTER);                        
            imageLeft.setAlignment(Image.ALIGN_LEFT);
            pdf.add(imageLeft);
        }catch(Exception  ex){ //FileNotFoundException
        	ex.printStackTrace();
        }

		//ADD TITULO
        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingAfter(20);
        paragraph.setSpacingBefore(30);
        paragraph.setAlignment(Element.ALIGN_CENTER);                                        
        paragraph.add(new Chunk(new String(titulo.getBytes(), "ISO-8859-1"), new Font(Font.BOLD,22)));
        //Phrase  phTit = new Phrase();
        //phTit.setFont(new Font(Font.BOLD, 25));
        //phTit.add("ESTE ES EL TITULO");               
        pdf.add(paragraph);
        
        
        
        titulo="";
	}
	
	   /** DOWLOAD FILE:
     * return 1: SI ocurrió con éxito el proceso de descarga
     * return -1: No se encontrp archivo en el ID enviado
     * return -2: No se obtuvoningún ID del Doc
     * return -3: Exception de IO
     * return -4: Exception de cierre de los INPUTSTREAM (NO GRAVE)
     * return 0: Exception general     
     *  */
	public int descargarFileGeneral(String docUUID,String nombreFile,String contentType){
		ServletOutputStream out = null;		
		FileInputStream fileInput = null;
		int result = 0;
		try {			
			if(docUUID!=null){
				//OBTENER FILE POR EL UUID (DEL GESTOR DE CONTENIDO)				

				//File archivo = new File(_documento.getPdodocumentopath().concat(_documento.getPdorecursodocumento()));

			}else{				
				result = -2;							
			}									
		} catch (Exception err) {
			result = -3;			
			Log.error(err,"SaProcesoAdmisionBean : lnkMostrarDocumento : " + err.getLocalizedMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fileInput != null) {
					fileInput.close();
				}				
			} catch (IOException err) {
				result = -4;
				Log.error(err,"SaProcesoAdmisionBean : lnkMostrarDocumento : " + err.getLocalizedMessage());
			}
			FacesContext.getCurrentInstance().getResponseComplete();
		}
		return result;
	}	
	
	

	
	public void setInactiveAllModes(){
		this.modoNew = false;
		this.modoView = false;
		this.modoDelete = false;
		this.modoUpdate = false;
		this.modoInactivate= false;
	}
	
	public boolean isBtnGuardarInactivarVisible() {
		return btnGuardarInactivarVisible;
	}

	public void setBtnGuardarInactivarVisible(boolean btnGuardarInactivarVisible) {
		this.btnGuardarInactivarVisible = btnGuardarInactivarVisible;
	}

	public String getPaginaDefault() {
		if (EntityGlobal.getInstance() != null) {
			paginaDefault = EntityGlobal.getInstance().getUrlPaginaInicio();
		}
		return paginaDefault;
	}

	public void setPaginaDefault(String paginaDefault) {
		this.paginaDefault = paginaDefault;
	}

	public String getPaginaActual() {
		if (EntityGlobal.getInstance() != null) {
			paginaActual = EntityGlobal.getInstance().getSysUrl();
		}
		return paginaActual;
	}

	public void setPaginaActual(String paginaActual) {
		this.paginaActual = paginaActual;
	}

	public String getGrupoDefault() {
		if (EntityGlobal.getInstance() != null) {
			grupoDefault = EntityGlobal.getInstance().getSysGrupo();
		}
		return grupoDefault;
	}

	public void setGrupoDefault(String grupoDefault) {
		this.grupoDefault = grupoDefault;
	}

	public String getConceptoDefault() {
		if (EntityGlobal.getInstance() != null) {
			conceptoDefault = EntityGlobal.getInstance().getSysConcepto();
		}
		return conceptoDefault;
	}

	public void setConceptoDefault(String conceptoDefault) {
		this.conceptoDefault = conceptoDefault;
	}

	public String getConceptoDescActual() {
		if (EntityGlobal.getInstance() != null) {
			conceptoDescActual = EntityGlobal.getInstance().getConceptoActualDesc();
		}
		return conceptoDescActual;
	}

	public void setConceptoDescActual(String conceptoDescActual) {
		this.conceptoDescActual = conceptoDescActual;
	}

	public boolean isVisibleRegistro() {
		return visibleRegistro;
	}

	public void setVisibleRegistro(boolean visibleRegistro) {
		this.visibleRegistro = visibleRegistro;
	}

	public String getLenguaje() {
		lenguaje = FacesUtil.getSessionLocale().getLanguage();
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getLocaleSession() {
		return localeSession;
	}

	public void setLocaleSession(String localeSession) {
		localeSession = FacesUtil.getSessionLocale().getLanguage();
		this.localeSession = localeSession;
	}

	public String getUrlDefaultBlank() {
		return URL_DEFAULT;
	}


	public boolean isIndicaModoExterno() {
		return indicaModoExterno;
	}

	public void setIndicaModoExterno(boolean indicaModoExterno) {
		this.indicaModoExterno = indicaModoExterno;
	}


	public List<SelectItem> getListItemTP() {
		return listItemTP;
	}

	public void setListItemTP(List<SelectItem> listItemTP) {
		this.listItemTP = listItemTP;
	}



	public void setTipoproducto(Integer tipoproducto) {
		this.tipoproducto = tipoproducto;
	}


	public Map<String, String> getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Map<String, String> auditoria) {
		this.auditoria = auditoria;
	}

	public void setUsuarioServiceAbstractGen(UsuarioService usuarioServiceAbstractGen) {
		this.usuarioServiceAbstractGen = usuarioServiceAbstractGen;
	}

	public void setMiscelaneoServiceAbstractGen(MaMiscelaneosdetalleService miscelaneoServiceAbstractGen) {
		this.miscelaneoServiceAbstractGen = miscelaneoServiceAbstractGen;
	}

	/***********************************************************
	 *  MAP GENERAL **
	 *  ********************************************************/	
	public Map<Integer, String> MAP_ASISTENCIA_DOCENTE; 
	
	// COLORES PARA EL HORARIO **/
	public final String COLOR_FERIADO= "colorFeriado";
	public final String COLOR_REUNION = "colorReunion";
	public final String COLOR_RECESO = "colorReceso";
	
	public final String COLOR_UNO = "color1"; 
	public final String COLOR_DOS = "color2"; 
	public final String COLOR_TRES = "color3"; 
	public final String COLOR_CUATRO = "color4"; 
	public final String COLOR_CINCO = "color5";
	public final String COLOR_SEIS = "color6"; 
	public final String COLOR_SIETE = "color7"; 
	public final String COLOR_OCHO = "color8";
	public final String COLOR_NUEVE = "color9";
	public final String COLOR_DIEZ = "color10";
	public final String COLOR_ONCE = "color11";
	public final String COLOR_DOCE = "color12";
	public final String COLOR_TRECE = "color13";
	public final String COLOR_CATORCE = "color14";
	public final String COLOR_QUINCE = "color15";
	public final String COLOR_DIECISEIS = "color16";
	public final String COLOR_DIECISIETE = "color17";
	public final String COLOR_DIECIOCHO = "color18";
	public final String COLOR_DIECINUEVE = "color19";
	public final String COLOR_VEINTE = "color20";

	
	public Map<Integer, String> MAP_DIAS_LABEL;
	public Map<Integer, String> MAP_MES_LABEL;
	public Map<Integer, String> MAP_DIAS_RESUMEN_LABEL;
	public Map<Integer, String> MAP_TIPO_DURACION_LABEL;
	public Map<Integer, String> MAP_COLORES_HORARIO;
	public Map<String, String>  MAP_HORARIO_ESTADO_LABEL;
	
	
	public void cargarMapDiasResumenLabel() {
		MAP_DIAS_RESUMEN_LABEL = new LinkedHashMap<Integer, String>();
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_LUNES_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_LUNES"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_MARTES_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_MARTES"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_MIERCOLES_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_MIERCOLES"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_JUEVES_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_JUEVES"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_VIERNES_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_VIERNES"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_SABADO_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_SABADO"));
		MAP_DIAS_RESUMEN_LABEL.put(TimeCommons.DIA_DOMINGO_JODA, FacesUtil.getPropertyLabels("DAY_RESUMEN_DOMINGO"));
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
	
 
	public void cargarMapTipoDuracionLabel() {
//		MAP_TIPO_DURACION_LABEL = new LinkedHashMap<Integer, String>();
//		MAP_TIPO_DURACION_LABEL.put(Constant.TIPO_DURACION_ANIO, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_ANIO"));
//		MAP_TIPO_DURACION_LABEL.put(Constant.TIPO_DURACION_MES, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_MES"));
//		MAP_TIPO_DURACION_LABEL.put(Constant.TIPO_DURACION_DIA, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_DIA"));
//		MAP_TIPO_DURACION_LABEL.put(Constant.TIPO_DURACION_HORAS, FacesUtil.getPropertyLabels("ITEM_TIPO_DURACION_HORAS"));
	}
	
	public void cargarMapColorHorario() {
		MAP_COLORES_HORARIO = new LinkedHashMap<Integer, String>();
		MAP_COLORES_HORARIO.put(1, COLOR_UNO);
		MAP_COLORES_HORARIO.put(2, COLOR_DOS);
		MAP_COLORES_HORARIO.put(3, COLOR_TRES);
		MAP_COLORES_HORARIO.put(4, COLOR_CUATRO);
		MAP_COLORES_HORARIO.put(5, COLOR_CINCO);
		MAP_COLORES_HORARIO.put(6, COLOR_SEIS);
		MAP_COLORES_HORARIO.put(7, COLOR_SIETE);
		MAP_COLORES_HORARIO.put(8, COLOR_OCHO);
		MAP_COLORES_HORARIO.put(9, COLOR_NUEVE);
		MAP_COLORES_HORARIO.put(10, COLOR_DIEZ);
		MAP_COLORES_HORARIO.put(11, COLOR_ONCE);
		MAP_COLORES_HORARIO.put(12, COLOR_DOCE);
		MAP_COLORES_HORARIO.put(13, COLOR_TRECE);
		MAP_COLORES_HORARIO.put(14, COLOR_CATORCE);
		MAP_COLORES_HORARIO.put(15, COLOR_QUINCE);
		MAP_COLORES_HORARIO.put(16, COLOR_DIECISEIS);
		MAP_COLORES_HORARIO.put(17, COLOR_DIECISIETE);
		MAP_COLORES_HORARIO.put(18, COLOR_DIECIOCHO);
		MAP_COLORES_HORARIO.put(19, COLOR_DIECINUEVE);
		MAP_COLORES_HORARIO.put(20, COLOR_VEINTE);
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


	
	public Map<Integer, String> getMAP_DIAS_RESUMEN_LABEL() {
		return MAP_DIAS_RESUMEN_LABEL;
	}

	public void setMAP_DIAS_RESUMEN_LABEL(Map<Integer, String> mAP_DIAS_RESUMEN_LABEL) {
		MAP_DIAS_RESUMEN_LABEL = mAP_DIAS_RESUMEN_LABEL;
	}

	public Map<Integer, String> getMAP_TIPO_DURACION_LABEL() {
		return MAP_TIPO_DURACION_LABEL;
	}

	public void setMAP_TIPO_DURACION_LABEL(Map<Integer, String> mAP_TIPO_DURACION_LABEL) {
		MAP_TIPO_DURACION_LABEL = mAP_TIPO_DURACION_LABEL;
	}

	public Map<Integer, String> getMAP_COLORES_HORARIO() {
		return MAP_COLORES_HORARIO;
	}

	public void setMAP_COLORES_HORARIO(Map<Integer, String> mAP_COLORES_HORARIO) {
		MAP_COLORES_HORARIO = mAP_COLORES_HORARIO;
	}

	public Map<String, String> getMAP_HORARIO_ESTADO_LABEL() {
		return MAP_HORARIO_ESTADO_LABEL;
	}

	public void setMAP_HORARIO_ESTADO_LABEL(Map<String, String> mAP_HORARIO_ESTADO_LABEL) {
		MAP_HORARIO_ESTADO_LABEL = mAP_HORARIO_ESTADO_LABEL;
	}

	public Map<Integer, String> getMAP_DIAS_LABEL() {
		return MAP_DIAS_LABEL;
	}

	public void setMAP_DIAS_LABEL(Map<Integer, String> mAP_DIAS_LABEL) {
		MAP_DIAS_LABEL = mAP_DIAS_LABEL;
	}

	public Map<Integer, String> getMAP_MES_LABEL() {
		return MAP_MES_LABEL;
	}

	public void setMAP_MES_LABEL(Map<Integer, String> mAP_MES_LABEL) {
		MAP_MES_LABEL = mAP_MES_LABEL;
	}

	public Map<Integer, String> getMAP_ASISTENCIA_DOCENTE() {
		return MAP_ASISTENCIA_DOCENTE;
	}

	public void setMAP_ASISTENCIA_DOCENTE(Map<Integer, String> mAP_ASISTENCIA_DOCENTE) {
		MAP_ASISTENCIA_DOCENTE = mAP_ASISTENCIA_DOCENTE;
	}
	 



}
