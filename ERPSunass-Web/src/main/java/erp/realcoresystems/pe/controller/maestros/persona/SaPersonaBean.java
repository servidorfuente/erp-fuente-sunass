package erp.realcoresystems.pe.controller.maestros.persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import erp.realcoresystems.pe.commons.EventosBean;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.IntegerUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.*;
import erp.realcoresystems.pe.util.Log;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


@ManagedBean(name = "saPersonaBean")
@ViewScoped
public class SaPersonaBean extends AbstractGenericBean implements InterfaceGenericBean {

	private static final long serialVersionUID = 1L;

	private final String PAIS_DEFAULT = UtilesCommons.trim(FacesUtil.getPropertyParametros("DEFAULT_PAIS_ID"));
	
	/** IDS **/
	private final String FORMULARIO_ID = "FormularioPersona";
	private final String TAB_VIEW_ID = "tabView";
	private final String FORMULARIO_TABVIEW = FORMULARIO_ID + ":" + TAB_VIEW_ID;
	private final String TAB_EMPLEADO_ID = "tabEmpleado";
	
	private final String DIALOG_ORGANIGRAMA_ID = "dlgOrganigrama";
	
	private final Integer UPDATE_TIPO_TABVIEW = Integer.valueOf(2);
	private final int INT_MAXIMO_DOCUMENTO_GENERAL = 8;

	@ManagedProperty(value = "#{personamastService}")
	private PersonamastService personamastService;
	
	@ManagedProperty(value = "#{empleadoService}")
	private EmpleadomastService empleadomastService;

	@ManagedProperty(value = "#{saUbigeoService}")
	private SaUbigeoService ubigeoService;

	@ManagedProperty(value = "#{saDocumentoIdentidadService}")
	private SaDocumentoIdentidadService saDocumentoIdentidadService;

	@ManagedProperty(value = "#{maMiscelaneosdetalleService}")
	private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

	
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{saPersonaRelacionesService}")
	private SaPersonaRelacionesService saPersonaRelacionesService;
	
	private LazyDataModel<Personamast> dataModel;
	private List<Personamast> listaDataModel;

	private List<MaMiscelaneosdetalle> maMiscelaneosdetallesTipoDoc;

	private Personamast filtro = new Personamast();
	private Personamast registro = new Personamast();
	private Personamast seleccion = new Personamast();
	private Empleadomast registroEmpleado = new Empleadomast();

	private List<SaUbigeo> listadoDepartamento;
	private List<SaUbigeo> listadoProvincia;
	private List<SaUbigeo> listadoDistrito;
	private Map<Integer, SaTipoDocumentoIdentidad> mapTipoDocumento;

	private boolean esSoloMisRegistro;
	private boolean esEnvioCorreoDefecto;
	private boolean esEmpleado;
	private boolean disabledCheckEsEmpleado;

	private int activeIndex;
	private int maximoDocumento;
	
	/**Variables TAB PERSONAS RELACIONES*/
	private  List<SaPersonaRelaciones> listaPersonaRelaciones;
	private  List<SaPersonaRelaciones> listaPersonaRelacionesSave;
	private  List<SaPersonaRelaciones> listaPersonaRelacionesDel;
	
	private  Personamast personaAutoCompleteSeleccion;
	private  List<Personamast> listaPersonaListado;
	
	private int countPersonasRelacion;
	private boolean indicaDocAutogenerado;
	private boolean indicaCambioDocumentoAutoGen;

	@PostConstruct
	public void inicializar() {
		FacesUtil.removeSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);
		inicializarEntidad();
		inicializarLista();
		inicializarDatoInicial();
		buscarPrincipal();
		maMiscelaneosdetallesTipoDoc = listarMiscelaneosDetalle(null,"TIPODOCUM");

	}
	public List<MaMiscelaneosdetalle> listarMiscelaneosDetalle(String valorcodigo1, String codigotabla) {
		MaMiscelaneosdetalle filtro = new MaMiscelaneosdetalle();
		filtro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		filtro.setCompania(Constant.COMPANIA_999999);
		filtro.setEstado(Constant.ACTIVO);
		filtro.setValorcodigo1(valorcodigo1);
		filtro.setCodigotabla(codigotabla);
		return maMiscelaneosdetalleService.listarElementos(filtro);
	}

	public void inicializarEntidad() {
		filtro = new Personamast();
		//filtro.setTipoDocumentoIdentidad(new SaTipoDocumentoIdentidad());
		seleccion = new Personamast();
		registro = new Personamast();
		registroEmpleado = new Empleadomast();
	}

	public void inicializarLista() {
		listadoDepartamento = UtilesCommons.getCleanList(listadoDepartamento);
		listadoProvincia = UtilesCommons.getCleanList(listadoProvincia);
		listadoDistrito = UtilesCommons.getCleanList(listadoDistrito);
		listaPersonaRelaciones = new ArrayList<SaPersonaRelaciones>();
		listaPersonaRelacionesDel = new ArrayList<SaPersonaRelaciones>();
		listaPersonaRelacionesSave = new ArrayList<SaPersonaRelaciones>();
	}

	public void inicializarDatoInicial() {
		filtro.setEstado(Constant.ACTIVO);
		esSoloMisRegistro = false;
		esEnvioCorreoDefecto = false;
		esEmpleado = false;
		disabledCheckEsEmpleado = false;
		maximoDocumento = INT_MAXIMO_DOCUMENTO_GENERAL;
		activeIndex = 0;
		indicaDocAutogenerado = false;
		indicaCambioDocumentoAutoGen = false;
		countPersonasRelacion=0;
	}

	public void onTabChange(TabChangeEvent event) {
		String tabId = event.getTab().getId();
		if (UtilesCommons.sonCadenasIguales(tabId, TAB_EMPLEADO_ID)) {
			activeIndex = 1;
		} else {
			//validaciones ....
			//activeIndex = 0;
		}
	}

	@Override
	public void btnBuscar() {
		buscarPrincipal();
	}

	@Override
	public void btnNuevo() {
		MODO_ACTUAL = MODO_NEW;
		setAtributosWindowsRegistro(MODO_ACTUAL);
	}

	@Override
	public void btnGuardar() {
		if (validarFormulario(registro)) {
			if (validarExistencia(registro)) {
				int result = 0;
				Personamast objSave = transformarEntidad(registro);
				Empleadomast objSaveEmpleado = transformarEntidad(registroEmpleado);
				
				if(UtilesCommons.noEsVacio(listaPersonaRelacionesDel)){
					listaPersonaRelacionesSave.addAll(listaPersonaRelacionesDel);
				}
				if(UtilesCommons.noEsVacio(listaPersonaRelaciones)){
					listaPersonaRelacionesSave.addAll(listaPersonaRelaciones);
				}
				
				if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
					//result = personamastService.guardar(objSave,null,null,objSaveEmpleado,
					//		null,listaPersonaRelacionesSave);
					result = personamastService.guardar(objSave);

				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)) {
					//result = personamastService.actualizar(objSave, null, null, objSaveEmpleado,
					//		null,listaPersonaRelacionesSave);
					result = personamastService.guardar(objSave);

				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)) {
					result = personamastService.actualizarEstadoPersona(objSave, EntityGlobal.getInstance().getUsuario(), EntityGlobal.getInstance().getIpCliente());
				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_DELETE)) {
					result = personamastService.eliminar(objSave);
				}

				if (result > 0) {
					btnAceptar();
					buscarPrincipal();
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
				} else if (result == -1) {
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_PERSONA_DELETE_NO_ELIMINAR_EXISTE_ALUMNO"));
				} else{
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
				}
			}
		}
	}

	@Override
	public void btnModificar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_UPDATE;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnEliminar() {
		if (UtilesCommons.noEsNulo(seleccion)) { 
			if(validarEliminar(MODO_DELETE, seleccion)){
				MODO_ACTUAL = MODO_DELETE;
				setAtributosWindowsRegistro(MODO_ACTUAL);
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	public void btnInactivar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			if(validarEliminar(MODO_INACTIVAR, seleccion)){
				if (UtilesCommons.sonCadenasIguales(seleccion.getEstado(), Constant.INACTIVO)) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_DISABLED_PERSONA"));
					return;
				}
				MODO_ACTUAL = MODO_INACTIVAR;
				setAtributosWindowsRegistro(MODO_ACTUAL);
			} 
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnVer() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_VIEW;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnAceptar() {
		visibleRegistro = false;
		seleccion = new Personamast();
		registro = new Personamast();
	}

	@Override
	public void btnCancelar() {
		visibleRegistro = false;
		seleccion = new Personamast();
		registro = new Personamast();

	}

	@Override
	public void abrirRegistro() {

	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		filtro = UtilesCommons.esNulo(filtro) ? new Personamast() : filtro;
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
	}

	public LazyDataModel<Personamast> buscarPrincipal() {
		dataModel = new LazyDataModel<Personamast>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<Personamast> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				cargarObjetoFiltros(first, pageSize, 0);
				listaDataModel = personamastService.PersonamastListar(filtro);
				setRowCount(personamastService.contadorTotalesPersona(filtro));
				setRowIndex(first);
				setPageSize(pageSize);
				return listaDataModel;
			}

			@Override
			public Personamast getRowData(String rowKey) {
				for (Personamast event : listaDataModel) {
					if (UtilesCommons.sonCadenasIguales((event.getPersona() + ""), ("" + rowKey))) {
						seleccion = (Personamast) event;
						return seleccion;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(Personamast event) {
				return event.getPersona();
			}
		};
		return dataModel;
	}

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);
		indicaDocAutogenerado = false;
		indicaCambioDocumentoAutoGen = false;
		listaPersonaRelaciones = new ArrayList<SaPersonaRelaciones>();
		listaPersonaRelacionesSave = new ArrayList<SaPersonaRelaciones>();
		listaPersonaRelacionesDel = new ArrayList<SaPersonaRelaciones>();

		
		if (UtilesCommons.sonCadenasIguales(modo, MODO_NEW)) {
			/** Seteamos valores**/
			indicaCambioDocumentoAutoGen = true;
			registro = new Personamast();
			registroEmpleado = new Empleadomast();
			registroEmpleado.setOrganigrama(new SaDependencias());
			listadoProvincia = UtilesCommons.getCleanList(listadoProvincia);
			listadoDistrito = UtilesCommons.getCleanList(listadoDistrito);
			esEnvioCorreoDefecto = false;
			maximoDocumento = INT_MAXIMO_DOCUMENTO_GENERAL;
			esEmpleado = false;
		
			/** Asignamos valores **/
			registro.setEstado(Constant.ACTIVO);
			registro.setTipodocumento(Constant.DOCUMENTO_DNI);
			registro.setTipopersona(Constant.PERSONA_NATURAL);
			listadoDepartamento = listarDepartamento();
			//mapTipoDocumento = listarMapTipoDocumento(Constant.DOCUMENTO_DNI, Constant.DOCUMENTO_CARNET_EXTRANJERIA, Constant.DOCUMENTO_PASAPORTE, Constant.DOCUMENTO_OTROS);
			
			if(UtilesCommons.noEsVacio(mapTipoDocumento)){
				Map.Entry<Integer,SaTipoDocumentoIdentidad> entry= mapTipoDocumento.entrySet().iterator().next();			
				SaTipoDocumentoIdentidad value = entry.getValue();
				registro.setTipodocumento(entry.getKey()); 
				maximoDocumento = value.getTdinumerocaracteres(); 
			} 
		} 
		else {
			/** Seteamos valores **/
			indicaCambioDocumentoAutoGen = false;
			registroEmpleado = new Empleadomast();
			registroEmpleado.setOrganigrama(new SaDependencias());
			listadoProvincia = UtilesCommons.getCleanList(listadoProvincia);
			listadoDistrito = UtilesCommons.getCleanList(listadoDistrito);
			esEnvioCorreoDefecto = false;
			disabledCheckEsEmpleado = false;
			
			/** Asignamos valores **/
			esEmpleado = seleccion.isEsempleado();
			registro = seleccion; 
			
			if(esEmpleado){
				Empleadomast busqEmpleado = empleadomastService.obtenerPorId(registro.getPersona());
				if(busqEmpleado!=null){
					registroEmpleado = busqEmpleado;
					esEnvioCorreoDefecto = UtilesCommons.obtenerValorBooleanoSiNo(registroEmpleado.getFlagsmf());
					disabledCheckEsEmpleado = true;					
				}else{
					/** Seteamos valores **/
					registroEmpleado = new Empleadomast();
					registroEmpleado.setOrganigrama(new SaDependencias());
				}
			}
			
			listadoDepartamento = listarDepartamento();
			if (UtilesCommons.noEsVacio(listadoDepartamento)) {
				if (UtilesCommons.noEsVacio(registro.getDepartamento())) {
					listadoProvincia = ubigeoService.listarComboProvincia(PAIS_DEFAULT, registro.getDepartamento());
					if (UtilesCommons.noEsVacio(listadoProvincia)) {
						if (UtilesCommons.noEsVacio(registro.getDepartamento()) && UtilesCommons.noEsVacio(registro.getProvincia())) {
							listadoDistrito = ubigeoService.listarComboDistrito(PAIS_DEFAULT, registro.getDepartamento(), registro.getProvincia());
						}
					}
				}
			}
			//mapTipoDocumento = listarMapTipoDocumento(Constant.DOCUMENTO_RUC);
			//seleccionarTipoPersona();
			
			
			/**listar persona - relaciones*/
			SaPersonaRelaciones filtroPrel = new SaPersonaRelaciones();
			filtroPrel.setPrelpersonaRelacionDe(registro.getPersona());
			//listaPersonaRelaciones = saPersonaRelacionesService.listarElementos(filtroPrel, false);
			//
			
			/**Verificar tipo de documento*/
			/*if (UtilesCommons.sonCadenasIguales(modo, MODO_UPDATE)) {
				if(UtilesCommons.noEsVacio(registro.getTipodocumento())){
					String codigoTipoDocExt = "";
					SaTipoDocumentoIdentidad tipoDoc = saDocumentoIdentidadService.obtenerPorId(registro.getTipodocumento());
					if(tipoDoc!=null){
						codigoTipoDocExt = tipoDoc.getTdicodigoexterno();
						if(Constant.TIPO_DOCUMENTO_AUTOGEN.equals((""+codigoTipoDocExt).trim())){
							indicaCambioDocumentoAutoGen = true;	
							indicaDocAutogenerado = true;							
						}
						maximoDocumento = tipoDoc.getTdinumerocaracteres();
					}										
				}else{
					indicaCambioDocumentoAutoGen = true;
				}
			}*/
						
		}

		activeIndex = 0;
	}

	/** METODO PARA VALIDAR **/
	private boolean validarFormulario(Personamast registro) {
		boolean valida = true;
		if (UtilesCommons.cadenaEnListIgnoreCase(MODO_ACTUAL, MODO_DELETE, MODO_INACTIVAR)) {

		} else {
			/** SI ES EL TIPO DE PERSONA ES NATURAL **/
			if (esTipoPersonaNatural()) {
				/** SI EL TIPO DE DOCUMENTO ES DNI **/
				if (esTipoDocumentoDNI()) {

					if (UtilesCommons.esVacio(registro.getDocumento())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
					} else  {
						if (MODO_ACTUAL.equals(MODO_NEW) && registro.getDocumento().length() != maximoDocumento){
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NUMERODOCUMENTO_DNI_NOVALIDO"));
							valida = false;	
						}						
					}

					if (UtilesCommons.esVacio(registro.getNombres())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
					}
					if (UtilesCommons.esVacio(registro.getApellidopaterno())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_APELLIDO_PATERNO"));
					}
					if (UtilesCommons.esVacio(registro.getApellidomaterno())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_APELLIDO_MATERNO"));
					}
				}
				/**
				 * SI EL TIPO DE DOCUMENTO ES CARNET EXTRANJERIA O PASAPORTE
				 **/
				else if (esTipoDocumentoCarnetExtranjeria() ||  esTipoDocumentoPasaporte()) {

					if (UtilesCommons.esVacio(registro.getDocumento())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning( FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
					}

					if (UtilesCommons.esVacio(registro.getNombres())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning( FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
					}
					if (UtilesCommons.esVacio(registro.getApellidopaterno())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning( FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_APELLIDO_PATERNO"));
					}
				}
				/** SI EL TIPO DE DOCUMENTO ES OTROS **/
				else if (esTipoDocumentoOtros()) {
					if (UtilesCommons.esVacio(registro.getDocumento())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
					}

					if (UtilesCommons.esVacio(registro.getNombrecompleto())) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRE_COMPLETO"));
					}
				}
			}
			/** SI ES EL TIPO DE PERSONA ES JURIDICA **/
			else {
				if (UtilesCommons.esVacio(registro.getDocumento())) {
					valida = false;
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NOMBRES"));
				} else if (registro.getDocumento().length() != maximoDocumento && IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_RUC) == 0) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_NUMERODOCUMENTO_RUC_NOVALIDO"));
					valida = false;
				}

				if (UtilesCommons.esVacio(registro.getNombrecompleto())) {
					valida = false;
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_RAZON_SOCIAL"));
				}
			}

			/** Validar PERSONA RELACIONES*/
			if(UtilesCommons.noEsVacio(listaPersonaRelaciones) ){
				for( SaPersonaRelaciones persRel : listaPersonaRelaciones){
					if(UtilesCommons.esVacio(persRel.getPreltipoRelacionDe())){
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_PERS_RELACION_REQUIRED_TIPORELACION"));
						break;
					}
					
					if(UtilesCommons.esVacio(persRel.getPrelpersonaRelacionSecund())){
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_PERS_RELACION_REQUIRED_PERSONA_SECUND"));
						break;
					}
					
					if(persRel.isPrelflagDuracionDefinidaBool()){
						if(UtilesCommons.esVacio(persRel.getPrelfechainicioRelacion())){
							valida = false;
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_PERS_RELACION_REQUIRED_FECHAINI"));
							break;
						}else if(UtilesCommons.esVacio(persRel.getPrelfechafinRelacion())){
							valida = false;
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_PERS_RELACION_REQUIRED_FECHAFIN"));
							break;
						}else{
							//rango fechas
							if(TimeCommons.compararSoloFecha(persRel.getPrelfechainicioRelacion(),
									persRel.getPrelfechafinRelacion()) >= 0){
								FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_PERS_RELACION_RANGO_FECHAS"));								
							}
						}
					}
				}
			}
			
			/**Validar fechas de nacimiento*/
			if (UtilesCommons.noEsVacio(registro.getFechanacimiento())) {
				int anio = TimeCommons.getAnio(registro.getFechanacimiento());
				if(anio < 1900){//***criterio
					valida = false;				
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_FECHA_NAC_FORMATO_INVALIDO"));
				}
			}
			
			
			
			/*No validar como obligatorio...*/
//			if (UtilesCommons.esVacio(registro.getDireccion())) {
//				valida = false;
//				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_DIRECCION"));
//			}
//			if (UtilesCommons.esVacio(registro.getCorreoelectronico())) {
//				valida = false;
//				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REQUIRED_CORREO_ELECTRONICO"));
//			}

		}
		return valida;
	}
	
	private boolean validarExistencia(Personamast registro) {
		boolean valida = true;
		if (UtilesCommons.cadenaEnListIgnoreCase(MODO_ACTUAL, MODO_DELETE, MODO_INACTIVAR)) {

		} else {
			if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
				List<Personamast> busqPersona = personamastService.obtenerPersonaPorDocumento(registro.getTipodocumento(), registro.getDocumento());
				if(UtilesCommons.noEsVacio(busqPersona)){
					valida = false;
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERSONA_REPEATED_PERSONA"));
				}
			} 
		}
		return valida;
	}
	

	public boolean validarEliminar(String modo,Personamast seleccion){
		boolean valida = true;
		if(UtilesCommons.noEsNulo(seleccion)){

			List<Usuario> busqUsuario = listarUsuarioPorPersona(seleccion);		 

		}		
		return valida;
	}

	/** METODO PARA BUSCADORES **/
	public void btnBuscarOrganigrama() {
		try {			
			

			
			FacesUtil.executeSecure("inicializarBDependencia(); PF('"+DIALOG_ORGANIGRAMA_ID+"').show();");
			
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			FacesUtil.mensajeErrorAbrirBuscador();
		}
	}
 

	/** METODO PARA SELECCIONAR **/
	public void seleccionarTipoPersona() {
		mapTipoDocumento = UtilesCommons.getCleanLinkedHashMap(mapTipoDocumento);
		registro.setTipodocumento(null);
		/** SI ES PERSONA JURIDICA **/
		if (esTipoPersonaJuridica()) {
			mapTipoDocumento = listarMapTipoDocumento(Constant.DOCUMENTO_RUC);
		}
		/** SI ES PERSONA NATURAL **/
		else {
			mapTipoDocumento = listarMapTipoDocumento(Constant.DOCUMENTO_DNI, Constant.DOCUMENTO_CARNET_EXTRANJERIA, Constant.DOCUMENTO_PASAPORTE, Constant.DOCUMENTO_OTROS);
		}		
		/** ASIGNAMOS EL PRIMER VALOR DEL MAP **/
		if(UtilesCommons.noEsVacio(mapTipoDocumento)){
			Map.Entry<Integer,SaTipoDocumentoIdentidad> entry = mapTipoDocumento.entrySet().iterator().next();			
			registro.setTipodocumento(entry.getKey()); 
			seleccionarTipoDocumento();
		} 
	}

	public void seleccionarTipoDocumento(){	
		indicaDocAutogenerado = false;
		
		if(UtilesCommons.noEsVacio(registro.getTipodocumento())){
			if(mapTipoDocumento.containsKey(registro.getTipodocumento())){
				SaTipoDocumentoIdentidad tipoDocHallado = mapTipoDocumento.get(registro.getTipodocumento());
												
				if(tipoDocHallado!=null){
					maximoDocumento = tipoDocHallado.getTdinumerocaracteres();
					
					/**logica para determinar si sera AUTOGENERADO o NO*/
					if(Constant.TIPO_DOCUMENTO_AUTOGEN.equals((""+tipoDocHallado.getTdicodigoexterno()).trim())){
						registro.setDocumento(obtenerDocumentoAutogenerado());
						indicaDocAutogenerado = true;						
					}
				}
				
			}	
		}
		else{
			maximoDocumento = INT_MAXIMO_DOCUMENTO_GENERAL;
		}
	}
 
	/** autogenerar un codigo para el NUMERO DE DOC
	 * @return
	 */
	public String obtenerDocumentoAutogenerado(){
		return personamastService.obtenerDocumentoAutogenerado();
	}
	

	public void seleccionarDepartamento() {
		listadoProvincia = UtilesCommons.getCleanList(listadoProvincia);
		listadoDistrito = UtilesCommons.getCleanList(listadoDistrito);
		registro.setProvincia(null);
		registro.setDistrito(null);

		if (UtilesCommons.noEsVacio(registro.getDepartamento())) {
			listadoProvincia = ubigeoService.listarComboProvincia(PAIS_DEFAULT, registro.getDepartamento());
		}
	}

	public void seleccionarProvincia() {
		listadoDistrito = UtilesCommons.getCleanList(listadoDistrito);
		registro.setDistrito(null);

		if (UtilesCommons.noEsVacio(registro.getDepartamento()) && UtilesCommons.noEsVacio(registro.getProvincia())) {
			listadoDistrito = ubigeoService.listarComboDistrito(PAIS_DEFAULT, registro.getDepartamento(), registro.getProvincia());
		}
	}	
	
	public void seleccionarCheckReceptorCorreoDefecto() {	
		registroEmpleado.setFlagsmf(UtilesCommons.obtenerValorStringSiNo(isEsEnvioCorreoDefecto()));
	}

	/** METODO PARA LISTAR **/
	public List<SaUbigeo> listarDepartamento() {
		return ubigeoService.listarComboDepartamento(PAIS_DEFAULT);
	}

	public Map<Integer, SaTipoDocumentoIdentidad> listarMapTipoDocumento(Integer... integers) {
		SaTipoDocumentoIdentidad filtro = new SaTipoDocumentoIdentidad();
		filtro.setTdiestado(Constant.INT_ACTIVO);
		List<SaTipoDocumentoIdentidad> busqueda =  saDocumentoIdentidadService.listarTodos(filtro, false);		
		//List<SaTipoDocumentoIdentidad> busqueda =  saDocumentoIdentidadService.listar(integers);
		Map<Integer, SaTipoDocumentoIdentidad> map = UtilesCommons.getNewLinkedHashMap();
		if(UtilesCommons.noEsVacio(busqueda)){
			for (SaTipoDocumentoIdentidad obj : busqueda) {
				obj.setTdinumerocaracteres(IntegerUtil.getInteger(obj.getTdinumerocaracteres()));
				map.put(obj.getTditipodocid(),obj);
			}
		} 
		return map;
	}
	
	public List<Usuario> listarUsuarioPorPersona(Personamast seleccion){
		Usuario filUsuario = new Usuario();
		filUsuario.setPersona(seleccion.getPersona());
		return usuarioService.UsuarioListar(filUsuario);
	}

	/** METODO SECUNDARIO **/
	public Personamast transformarEntidad(Personamast registro) {
		if (UtilesCommons.sonCadenasIguales(MODO_NEW, MODO_ACTUAL)) {
			registro.setIngresofecharegistro(new Date());
			registro.setIngresousuario(EntityGlobal.getInstance().getUsuario());
			registro.setOrigen(Constant.ORIGEN_PERU);
		}
		else {
			if (UtilesCommons.sonCadenasIguales(MODO_INACTIVAR, MODO_ACTUAL)) {
				registro.setEstado(Constant.INACTIVO);
			}
			registro.setUltimafechamodif(new Date());
			registro.setUltimousuario(EntityGlobal.getInstance().getUsuario());
		}		
		
		if(esTipoDocumentoDNI()){
			registro.setDocumentoidentidad(registro.getDocumento());
		}
		else if(esTipoDocumentoCarnetExtranjeria() || esTipoDocumentoPasaporte()){
			registro.setCarnetextranjeria(registro.getDocumento());			
		} 
		else if(esTipoDocumentoRUC() || esTipoDocumentoOtros()){
			registro.setDocumentofiscal(registro.getDocumento());
		}	
		
		registro.setEsempleado(isEsEmpleado());
		registro.setBusqueda(registro.getNombrecompleto());
		return registro;
	}
	
	public Empleadomast transformarEntidad(Empleadomast registroEmpleado) {
		if(isEsEmpleado()){
			registroEmpleado.setFlagsmf(UtilesCommons.obtenerValorStringSiNo(isEsEnvioCorreoDefecto()));
		}
		else{
			registroEmpleado = null;
		}	 
		return registroEmpleado;
	}
	
 
	public void setearNombreCompleto() {
		String apePaterno = "";
		if (UtilesCommons.noEsVacio(registro.getApellidopaterno())) {
			apePaterno = UtilesCommons.trim(registro.getApellidopaterno()) + " ";
		}

		String apeMaterno = "";
		if (UtilesCommons.noEsVacio(registro.getApellidomaterno())) {
			apeMaterno = UtilesCommons.trim(registro.getApellidomaterno()) + ", ";
		}

		String nombres = "";
		if (UtilesCommons.noEsVacio(registro.getNombres())) {
			nombres = UtilesCommons.trim(registro.getNombres());
		}

		String nombreCompleto = apePaterno + apeMaterno + nombres;
		registro.setNombrecompleto(nombreCompleto);
	}
	
	public void updateForm(Integer tipo, String... componenteIds) {
		if (UtilesCommons.esVacio(componenteIds)) {
			if (IntegerUtil.compareInteger(tipo, UPDATE_TIPO_TABVIEW) == 0) {
				FacesUtil.update(FORMULARIO_TABVIEW);
			} else {
				FacesUtil.update(FORMULARIO_ID);
			}
		} else {
			String formClientId = "";
			if (IntegerUtil.compareInteger(tipo, UPDATE_TIPO_TABVIEW) == 0) {
				formClientId = FORMULARIO_TABVIEW;
			} else {
				formClientId = FORMULARIO_ID;
			}

			int index = -1;
			String[] array = new String[componenteIds.length];
			for (String string : componenteIds) {
				index++;
				array[index] = UtilesCommons.noEsVacio(string) ? formClientId + ":" + string : string;
			}
			FacesUtil.update(array);
		}
	}
	
	/** METODO SECUNDARIO PARA BOOLEANOS **/
	public boolean esTipoDocumentoDNI(){
		return IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_DNI) == 0 ? true : false;
	}
	
	public boolean esTipoDocumentoRUC(){
		return IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_RUC) == 0 ? true : false;
	}
	
	public boolean esTipoDocumentoPasaporte(){
		return IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_PASAPORTE) == 0 ? true : false;
	}
	
	public boolean esTipoDocumentoCarnetExtranjeria(){
		return IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_CARNET_EXTRANJERIA) == 0 ? true : false;
	}
	
	public boolean esTipoDocumentoOtros(){
		return IntegerUtil.compareInteger(registro.getTipodocumento(), Constant.DOCUMENTO_OTROS) == 0 ? true : false;
	}
	
	public boolean esTipoPersonaNatural(){
		return UtilesCommons.sonCadenasIguales(registro.getTipopersona(), Constant.PERSONA_NATURAL) ? true : false;
	}
	
	public boolean esTipoPersonaJuridica(){
		return UtilesCommons.sonCadenasIguales(registro.getTipopersona(), Constant.PERSONA_JURIDICA) ? true : false;
	}
	
	/**TAB PERSONAS ASOCIADAS **/
	
	
	public List<Personamast> listarCompletePersona(String query){
		List<Personamast> listaTemp = new ArrayList<Personamast>();
		Personamast objFiltro = new Personamast();
		objFiltro.setNombrecompleto(query);
		objFiltro.setInicio(0);
		objFiltro.setNumeroFilas(15);
		listaTemp = personamastService.PersonamastListar(objFiltro);//AUX
		if(listaTemp!=null){
			listaPersonaListado = listaTemp;
			FacesUtil.putSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS, listaPersonaListado);
		}
		return listaTemp;
	}
	
	public void seleccionarPersonaBusqueda(AjaxBehaviorEvent event) {
		if (personaAutoCompleteSeleccion != null && personaAutoCompleteSeleccion.getPersona() != null) {			
			//SsGeDiagnosticoFiltro = personaAutoCompleteSeleccion;
			btnAgregarPersonaRelacion();			
		}
	}
	
	/**
	 * agregar un elemento de persona-relacion
	 */
	public void btnAgregarPersonaRelacion() {
		if (listaPersonaRelaciones != null 
				&& personaAutoCompleteSeleccion != null 
				&& UtilesCommons.noEsVacio(personaAutoCompleteSeleccion.getPersona())) {
			countPersonasRelacion--;
			SaPersonaRelaciones objAdd = new SaPersonaRelaciones();
			objAdd.setPersonaMastRelacionSecund(new Personamast());
			objAdd.setPrelestado(Constant.ACTIVO);
			objAdd.setPrelsecuencia(Long.valueOf(countPersonasRelacion));
			objAdd.setPersonaMastRelacionSecund(new Personamast());
			objAdd.getPersonaMastRelacionSecund().setPersona(personaAutoCompleteSeleccion.getPersona());
			objAdd.getPersonaMastRelacionSecund().setNombrecompleto(personaAutoCompleteSeleccion.getNombrecompleto());
			//objAdd.setString1(personaAutoCompleteSeleccion.);

			objAdd.setPrelpersonaRelacionDe(null);//Set al guardar
			objAdd.setPrelpersonaRelacionSecund(personaAutoCompleteSeleccion.getPersona());//***
			objAdd.setPrelflagDuracionDefinidaBool(false);
			objAdd.setAccion(Utiles.INSERT_db);
			objAdd.setPrelusuariocreacion(getUSUARIO_ACTUAL());
			
			/**** SET OBJETO ANTIGUO AUDITORÍA ***/
				
			if (listaPersonaRelaciones.size() > 0) {
				listaPersonaRelaciones.add(0, objAdd);
			} else {
				listaPersonaRelaciones.add(objAdd);
			}
			//defaulr
			personaAutoCompleteSeleccion = new Personamast();			
			// mapExpLab.put(""+contadorItems, objPersLab);
		}
	}
	
	
	/** remover un elemento de la lista y retenerla...para ser eliminada (si existiera en DB)
	 * @param objDel
	 */
	public void btnQuitarPersonaRelacion(SaPersonaRelaciones objDel) {
		if (objDel != null) {
			boolean halladoDel = false;
			SaPersonaRelaciones objDelPersi = new SaPersonaRelaciones();
			for (SaPersonaRelaciones objExpLab : listaPersonaRelaciones) {
				if (("" + objDel.getPrelsecuencia()).equals("" + objExpLab.getPrelsecuencia())) {
					if (!Utiles.INSERT_db.equals("" + objExpLab.getAccion())) {
						halladoDel = true;
						objDelPersi.setPrelsecuencia(objExpLab.getPrelsecuencia());
					}
					listaPersonaRelaciones.remove(objExpLab);			
					break;
				}
			}
			if (halladoDel) {
				objDelPersi.setAccion(Utiles.DELETE_db);
				
				listaPersonaRelacionesDel.add(objDelPersi);
			}
		}
	}
	
	/** Guardar item de PERSONA-RELACIOn
	 * @param save
	 */
	public void btnGuardarPersonaRelacion(SaPersonaRelaciones save) {
		if(save!=null && registro !=null){
			try{
				save.setPrelpersonaRelacionDe(registro.getPersona());
				save.setPrelfechacreacion(new Date());
				long result = saPersonaRelacionesService.guardar(save);
				if(result>0){
					save.setAccion(Constant.UPDATE_db);	
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
				}
			}catch(Exception e){
				Log.error(e,"btnGuardarPersonaRelacion");
			}
		}
	}
	
	/** GET - SET **/
	public PersonamastService getPersonamastService() {
		return personamastService;
	}

	public void setPersonamastService(PersonamastService personamastService) {
		this.personamastService = personamastService;
	}

	public SaUbigeoService getUbigeoService() {
		return ubigeoService;
	}

	public void setUbigeoService(SaUbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}

	public Personamast getFiltro() {
		return filtro;
	}

	public void setFiltro(Personamast filtro) {
		this.filtro = filtro;
	}

	public Personamast getRegistro() {
		return registro;
	}

	public void setRegistro(Personamast registro) {
		this.registro = registro;
	}

	public Personamast getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Personamast seleccion) {
		this.seleccion = seleccion;
	}

	public boolean isEsSoloMisRegistro() {
		return esSoloMisRegistro;
	}

	public void setEsSoloMisRegistro(boolean esSoloMisRegistro) {
		this.esSoloMisRegistro = esSoloMisRegistro;
	}

	public boolean isEsEnvioCorreoDefecto() {
		return esEnvioCorreoDefecto;
	}

	public void setEsEnvioCorreoDefecto(boolean esEnvioCorreoDefecto) {
		this.esEnvioCorreoDefecto = esEnvioCorreoDefecto;
	}

	public LazyDataModel<Personamast> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<Personamast> dataModel) {
		this.dataModel = dataModel;
	}

	public List<Personamast> getListaDataModel() {
		return listaDataModel;
	}

	public void setListaDataModel(List<Personamast> listaDataModel) {
		this.listaDataModel = listaDataModel;
	}

	public List<SaUbigeo> getListadoDepartamento() {
		return listadoDepartamento;
	}

	public void setListadoDepartamento(List<SaUbigeo> listadoDepartamento) {
		this.listadoDepartamento = listadoDepartamento;
	}

	public List<SaUbigeo> getListadoProvincia() {
		return listadoProvincia;
	}

	public void setListadoProvincia(List<SaUbigeo> listadoProvincia) {
		this.listadoProvincia = listadoProvincia;
	}

	public List<SaUbigeo> getListadoDistrito() {
		return listadoDistrito;
	}

	public void setListadoDistrito(List<SaUbigeo> listadoDistrito) {
		this.listadoDistrito = listadoDistrito;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
 
	public Map<Integer, SaTipoDocumentoIdentidad> getMapTipoDocumento() {
		return mapTipoDocumento;
	}

	public void setMapTipoDocumento(Map<Integer, SaTipoDocumentoIdentidad> mapTipoDocumento) {
		this.mapTipoDocumento = mapTipoDocumento;
	}

	public Empleadomast getRegistroEmpleado() {
		return registroEmpleado;
	}

	public void setRegistroEmpleado(Empleadomast registroEmpleado) {
		this.registroEmpleado = registroEmpleado;
	}

	public SaDocumentoIdentidadService getSaDocumentoIdentidadService() {
		return saDocumentoIdentidadService;
	}

	public void setSaDocumentoIdentidadService(SaDocumentoIdentidadService saDocumentoIdentidadService) {
		this.saDocumentoIdentidadService = saDocumentoIdentidadService;
	}


	public int getMaximoDocumento() {
		return maximoDocumento;
	}

	public void setMaximoDocumento(int maximoDocumento) {
		this.maximoDocumento = maximoDocumento;
	}
 
	public boolean isEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

	public EmpleadomastService getEmpleadomastService() {
		return empleadomastService;
	}

	public void setEmpleadomastService(EmpleadomastService empleadomastService) {
		this.empleadomastService = empleadomastService;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public boolean isDisabledCheckEsEmpleado() {
		return disabledCheckEsEmpleado;
	}

	public void setDisabledCheckEsEmpleado(boolean disabledCheckEsEmpleado) {
		this.disabledCheckEsEmpleado = disabledCheckEsEmpleado;
	}

	public List<SaPersonaRelaciones> getListaPersonaRelaciones() {
		return listaPersonaRelaciones;
	}

	public void setListaPersonaRelaciones(List<SaPersonaRelaciones> listaPersonaRelaciones) {
		this.listaPersonaRelaciones = listaPersonaRelaciones;
	}

	public void setSaPersonaRelacionesService(SaPersonaRelacionesService saPersonaRelacionesService) {
		this.saPersonaRelacionesService = saPersonaRelacionesService;
	}

	public List<SaPersonaRelaciones> getListaPersonaRelacionesSave() {
		return listaPersonaRelacionesSave;
	}

	public void setListaPersonaRelacionesSave(List<SaPersonaRelaciones> listaPersonaRelacionesSave) {
		this.listaPersonaRelacionesSave = listaPersonaRelacionesSave;
	}

	public List<SaPersonaRelaciones> getListaPersonaRelacionesDel() {
		return listaPersonaRelacionesDel;
	}

	public void setListaPersonaRelacionesDel(List<SaPersonaRelaciones> listaPersonaRelacionesDel) {
		this.listaPersonaRelacionesDel = listaPersonaRelacionesDel;
	}

	public void setCountPersonasRelacion(int countPersonasRelacion) {
		this.countPersonasRelacion = countPersonasRelacion;
	}

	public Personamast getPersonaAutoCompleteSeleccion() {
		return personaAutoCompleteSeleccion;
	}

	public void setPersonaAutoCompleteSeleccion(Personamast personaAutoCompleteSeleccion) {
		this.personaAutoCompleteSeleccion = personaAutoCompleteSeleccion;
	}

	public List<Personamast> getListaPersonaListado() {
		return listaPersonaListado;
	}

	public void setListaPersonaListado(List<Personamast> listaPersonaListado) {
		this.listaPersonaListado = listaPersonaListado;
	}

	public boolean isIndicaDocAutogenerado() {
		return indicaDocAutogenerado;
	}

	public void setIndicaDocAutogenerado(boolean indicaDocAutogenerado) {
		this.indicaDocAutogenerado = indicaDocAutogenerado;
	}

	public boolean isIndicaCambioDocumentoAutoGen() {
		return indicaCambioDocumentoAutoGen;
	}

	public void setIndicaCambioDocumentoAutoGen(boolean indicaCambioDocumentoAutoGen) {
		this.indicaCambioDocumentoAutoGen = indicaCambioDocumentoAutoGen;
	}


	public MaMiscelaneosdetalleService getMaMiscelaneosdetalleService() {
		return maMiscelaneosdetalleService;
	}

	public void setMaMiscelaneosdetalleService(MaMiscelaneosdetalleService maMiscelaneosdetalleService) {
		this.maMiscelaneosdetalleService = maMiscelaneosdetalleService;
	}

	public List<MaMiscelaneosdetalle> getMaMiscelaneosdetallesTipoDoc() {
		return maMiscelaneosdetallesTipoDoc;
	}

	public void setMaMiscelaneosdetallesTipoDoc(List<MaMiscelaneosdetalle> maMiscelaneosdetallesTipoDoc) {
		this.maMiscelaneosdetallesTipoDoc = maMiscelaneosdetallesTipoDoc;
	}


}
