package erp.realcoresystems.pe.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import erp.realcoresystems.pe.model.domain.Entidad;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import erp.realcoresystems.pe.model.util.FacesUtil;

@ManagedBean(name = "dataSeleccionadorFileUpload")
@ViewScoped
//@RequestScoped
public class DataSeleccionadorFileUpload implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1576127040956906312L;
	// VALORE DEFAULT
	private String PATH_CONFIG = "C:\\DATAFILE\\";
	private String valorSizeLimitDEF = "10000000"; //10 MB
	private String valorAllowTypesDEF = "/(\\.|\\/)(gif|jpeg|jpg|png|pdf)$/"; //|document|sheet ..para docs y xlsx
	private String valorFileLimitDEF = "3";

	private EventosBean eventoSeleccion = new EventosBean();
	/* Busqueda */

	// private SpEvaluacionPlantilla objSeleccion =null;
	private Entidad objConfig = new Entidad();

	private String formularioPadre = null;
	private String descSeleccionador = null;
	private String sectorAplicarUpdate;
	private boolean esVisibleField;
	private boolean esMultiple;
	private String valorSizeLimit;
	private String valorAllowTypes;
	private String valorFileLimit;

	private boolean esPathRelativo;
	
	private Part file;
	 private UploadedFile fileUp; 

	/**
	 * valores por default
	 */
	public void inicializar() {
		if (objConfig != null) {			
			formularioPadre = objConfig.getString1();
			descSeleccionador = objConfig.getString2();
			//sectorAplicarUpdate = objConfig.getString3();
			//// UI
			esVisibleField = objConfig.getInt_1() == 1 ? true : false;
			esMultiple = objConfig.getInt_2() == 1 ? true : false;
			valorSizeLimit = objConfig.getString1() != null ? objConfig.getString1() : valorSizeLimitDEF;
			valorFileLimit = objConfig.getString2() != null ? objConfig.getString2() : valorFileLimitDEF;
			valorAllowTypes = objConfig.getString3() != null ? objConfig.getString3() : valorAllowTypesDEF;
			//valorAllowTypes = valorAllowTypesDEF;//"/(\\.|\\/)(gif|jpe?g|png|pdf|doc|docx|xls|xlsx|csv|txt|rtf|ppt|html|zip)";
			esPathRelativo = objConfig.getInt_3() == 1 ? true : false;
			//System.out.println("drtydtydrty4");
			
		}
		//System.out.println("[TEST INFO SYS INICIALIZAR]");
	}
	
	/********************************************************************************************/
	/************IMPLEMETACION USANDO FILE UPLOAD en MODO ADVANCED y con el HANDLE EVENT  ... *****/
	/********************************************************************************************/	
	
	
	/** EVENTO DE RETORNO */
	public void handleFileUpload(FileUploadEvent event) {
		try {
			//System.out.println(1);
			if (eventoSeleccion.getEventoSeleccionUploadFile() != null) {
				//System.out.println(2);
				if (event != null) {
					//System.out.println(3);
					if (saveFile(event.getFile().getFileName(), event.getFile().getInputstream(),
							event.getFile().getContents())) {
						//System.out.println(3.1);
						eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(
								event.getFile().getInputstream(), event.getFile().getFileName(), 1);
						eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(
								event.getFile().getContents(), event.getFile().getFileName(), 1);
					} else {
						//System.out.println(44);
						eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(null, null, -1);
						eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(null, null, -1);
					}
				} else {
					//System.out.println(55);
					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(null, null, 0);
					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(null, null, 0);
				}
			}
			//System.out.println(6);
			objConfig = new Entidad();
			sectorAplicarUpdate = "";
		} catch (Exception ex) {
			//System.out.println(7);
			ex.printStackTrace();
		}
	}
	
	/** Metodo para retornor evento del FILE UPLOADER 
	 * @param event
	 */
	public void subirArchivo(FileUploadEvent event){
		try{
			if(eventoSeleccion.getEventoSeleccionUploadFile() != null && event != null){
				eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileUpload(event.getFile(), 1);
				if(event.getFile()!=null){
					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(
							event.getFile().getInputstream(), event.getFile().getFileName(), 1);
					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(
							event.getFile().getContents(), event.getFile().getFileName(), 1);									
				}
				sectorAplicarUpdate = "@all";
			}
		}catch(Exception ex){
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileUpload(null, -1);
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(null, null, -1);
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(null, null, -1);			
			FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_NO_CARGA_FILE"));
		}
	}

	public boolean saveFile(String fileName, InputStream in, byte fileBytes[]) {
		boolean result = false;
		try {
			String path = PATH_CONFIG;
			if (!esPathRelativo) {
				if (objConfig.getString4() != null) {
					path = objConfig.getString4();
				}
			} else {
				ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
						.getContext();
				path = servletContext.getRealPath("/") + objConfig.getString4();
			}
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(path + fileName));
			int read = 0;
			byte[] bytes = new byte[fileBytes != null ? fileBytes.length : 1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			//System.out.println("ARCHIVO CREADO");
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	/********************************************************************************************/
	/************IMPLEMETACION USANDO FILE UPLOAD en MODO SIMPLE ... *****/
	/********************************************************************************************/	
	
	
	/**
	 * Evento para Cargar Archivo PART ...
	 */
	public void upload() {
		boolean resultCorrecto = false;
        try {
        	if(validarFileUpload(file)){
            	UploadedFile fileUp = generarUploadedFileDefault(file);
            	if(fileUp!=null){
    				eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileUpload(fileUp, 1);
    				if(fileUp!=null){
    					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(
    							file.getInputStream(), fileUp.getFileName(), 1);
    					eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(
    							fileUp.getContents(), fileUp.getFileName(), 1);									
    				}
    				//sectorAplicarUpdate = "@all";	    				
    				resultCorrecto = true;
            	}  
        	}else{
        		file = null;
        	}        
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        
        if(!resultCorrecto){
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileUpload(null, -1);
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectInputStreamFile(null, null, -1);
			eventoSeleccion.getEventoSeleccionUploadFile().retornoObjectFileBytes(null, null, -1);						
        }
	}
	/********************************************************************************************/
	/************IMPLEMETACION USANDO HTTP SERVLET PART  y componente INPUT FILE de JSF ... *****/
	/********************************************************************************************/

    
    /** Valdar PART as File con las restricciones actuales
     * @param value
     * @return
     */
    public boolean  validarFileUpload(Object value) {
    	boolean valido = true;
    	String message="";
        Part file = (Part) value;
        if (file != null) {        	        	
            try {
                if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() ){
                	message= FacesUtil.getMSJProperty("MSJ_WARNING_NO_VALID_FILE");
                	FacesUtil.adicionarMensajeWarning(message);
                	valido= false;   
                }          
                if (!validarAlloyTypes(file, valorAllowTypes)){                     	
                    message= FacesUtil.getMSJProperty("MSJ_WARNING_NO_VALID_TYPE_FILE");
                    FacesUtil.adicionarMensajeWarning(message);
                    valido= false;   
                }                	
                if (file.getSize() > Integer.parseInt(valorSizeLimit)){                   	
                	message = FacesUtil.getMSJPropertyParams("MSJ_WARNING_NO_VALID_DIMENSION_BYTES_FILE", ""+valorSizeLimit);
                	FacesUtil.adicionarMensajeWarning(message);
                	valido= false;   
                }
    	
                if(!valido){                      	
                	file = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }            
        } else {
        	FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_NO_CARGA_FILE"));        	           
        }
        return valido;
    }
	
    public boolean validarAlloyTypes(Part fileUp, String allowTypes){
    	boolean valido = false;
        if(fileUp != null && UtilesCommons.noEsVacio(allowTypes)){        	
        	/**Convertir /(\\.|\\/)(gif|jpe?g|png|pdf)$/  en Array*/
        	String strTypesTemp  = allowTypes.replace("\\","");
        	strTypesTemp  = strTypesTemp.replace("/","");
        	strTypesTemp  = strTypesTemp.replace(".","");
        	strTypesTemp  = strTypesTemp.replace("(","");
        	strTypesTemp  = strTypesTemp.replace(")","");
        	strTypesTemp  = strTypesTemp.replace("$","");
        	strTypesTemp  = strTypesTemp.replace("|",",");
        	String[] strVector = strTypesTemp.split(",");
        	String contenTypeActual = fileUp.getContentType();
        	for(String sufix : strVector){
        		if (UtilesCommons.noEsVacio(sufix) && contenTypeActual.endsWith(sufix)){  
        			return true;
        		}
        	}
        }        
        return valido;
    }
    
    
    /** generar un UPLOADEDFILE.. a partir de un  HTTP SERVLET PART
     * @param filePart
     * @return
     */
    public UploadedFile generarUploadedFileDefault(Part filePart){
    	UploadedFile uploaded = new UploadedFile() {
			
			@Override
			public void write(String arg0) throws Exception {
				// TODO Auto-generated method stub						
			}
			
			@Override
			public long getSize() {				
				return filePart.getSize();
			}
			
			@Override
			public InputStream getInputstream() throws IOException {
				return filePart.getInputStream();
			}
			
			@Override
			public String getFileName() {
				return filePart.getSubmittedFileName();
			}
			
			@Override
			public byte[] getContents() {
				byte[] bytes =null;
				try {
					InputStream is = filePart.getInputStream();
					bytes = IOUtils.toByteArray(is);
				} catch(Exception e) {
				    e.printStackTrace();
				}					
				return bytes;
			}
			
			@Override
			public String getContentType() {
				return filePart.getContentType();
			}
		};
		return uploaded;
    }
    
	/**GET AND SET**/
    
	
    public Part getFile() {
        return file;
    }

    /**
     * @param filePart
     */
    public void setFile(Part filePart) {                
        this.file = filePart;
    }
    
    
	public EventosBean getEventoSeleccion() {
		return eventoSeleccion;
	}

	public void setEventoSeleccion(EventosBean eventoSeleccion) {
		this.eventoSeleccion = eventoSeleccion;
	}

	public Entidad getObjConfig() {
		return objConfig;
	}

	public void setObjConfig(Entidad objConfig) {
		this.objConfig = objConfig;
	}

	public String getFormularioPadre() {
		return formularioPadre;
	}

	public void setFormularioPadre(String formularioPadre) {
		this.formularioPadre = formularioPadre;
	}

	public String getDescSeleccionador() {
		return descSeleccionador;
	}

	public void setDescSeleccionador(String descSeleccionador) {
		this.descSeleccionador = descSeleccionador;
	}

	public String getSectorAplicarUpdate() {
		return sectorAplicarUpdate;
	}

	public void setSectorAplicarUpdate(String sectorAplicarUpdate) {
		this.sectorAplicarUpdate = sectorAplicarUpdate;
	}

	public boolean isEsVisibleField() {
		return esVisibleField;
	}

	public void setEsVisibleField(boolean esVisibleField) {
		this.esVisibleField = esVisibleField;
	}

	public boolean isEsMultiple() {
		return esMultiple;
	}

	public void setEsMultiple(boolean esMultiple) {
		this.esMultiple = esMultiple;
	}

	public String getValorSizeLimit() {
		return valorSizeLimit;
	}

	public void setValorSizeLimit(String valorSizeLimit) {
		this.valorSizeLimit = valorSizeLimit;
	}

	public String getValorAllowTypes() {
		return valorAllowTypes;
	}

	public void setValorAllowTypes(String valorAllowTypes) {
		this.valorAllowTypes = valorAllowTypes;
	}

	public String getValorFileLimit() {
		return valorFileLimit;
	}

	public void setValorFileLimit(String valorFileLimit) {
		this.valorFileLimit = valorFileLimit;
	}

	public boolean isEsPathRelativo() {
		return esPathRelativo;
	}

	public void setEsPathRelativo(boolean esPathRelativo) {
		this.esPathRelativo = esPathRelativo;
	}

	/**
	 * ENVIAR: obj1: (ENTIDAD) visibleFieldSet (Boolean indica visible el
	 * FIELDSET DE LA UI) visibleFieldSet: (Header del FIELD SET, si fuera
	 * visible) sizeLimit: (Valor del atributo sizeLimit del UploadFile)
	 * fileLimit: (Valor del atributo fileLimit del UploadFile) allowTypes:
	 * (Valor del atributo fileLimit del UploadFile) multiple: (Valor del
	 * atributo que indica si es MUltiple file o no) flagPathRelativo: (Valor
	 * del atributo que indica si se ingresará un PATH RELATIVO o NO) pathSave:
	 * (Valor de l PATH, relativo o absoluto donde se guardarán los archivos)
	 */
	public static Entidad setGetObjetoConfig(Entidad objRef, boolean visibleFieldSet, String tituloFieldSet,
			String sizeLimit, String fileLimit, String allowTypes, boolean multiple, boolean flagPathRelativo,
			String pathSave) {
		if (objRef != null) {
			objRef.setInt_1(visibleFieldSet ? 1 : 0);
			objRef.setString5(tituloFieldSet);
			
			objRef.setString1(sizeLimit);
			objRef.setString2(fileLimit);
			objRef.setString3(allowTypes);
			objRef.setInt_2(multiple ? 1 : 0);
			objRef.setInt_3(flagPathRelativo ? 1 : 0);
			objRef.setString4(pathSave);
		}
		return objRef;
	}

	public UploadedFile getFileUp() {
		return fileUp;
	}

	public void setFileUp(UploadedFile fileUp) {
		this.fileUp = fileUp;
	}

	
	
}
