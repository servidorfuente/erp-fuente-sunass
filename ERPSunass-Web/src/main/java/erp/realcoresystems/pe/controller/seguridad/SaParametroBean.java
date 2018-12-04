package erp.realcoresystems.pe.controller.seguridad;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Aplicacionesmast;
import erp.realcoresystems.pe.model.domain.CompaniaMast;
import erp.realcoresystems.pe.model.domain.ParametrosMast;
import erp.realcoresystems.pe.model.domain.ParametrosMastPK;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.AplicacionMastService;
import erp.realcoresystems.pe.service.CompaniaMastService;
import erp.realcoresystems.pe.service.ParametrosMastService;
import erp.realcoresystems.pe.model.util.Constant;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;



@ManagedBean(name = "saParametroBean")
@ViewScoped
public class SaParametroBean extends AbstractGenericBean implements InterfaceGenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{parametrosMastService}")
	private ParametrosMastService parametrosService;

	@ManagedProperty(value = "#{aplicacionMastService}")
	private AplicacionMastService aplicacionService;

	@ManagedProperty(value = "#{companiaMastService}")
	private CompaniaMastService companiaService;

	private LazyDataModel<ParametrosMast> dataModel;
	private List<ParametrosMast> listadoDataModel;

	private List<Aplicacionesmast> listadoAplicacion;
	private List<CompaniaMast> listadoCompania;

	private ParametrosMast filtro = new ParametrosMast();
	private ParametrosMast seleccion = new ParametrosMast();
	private ParametrosMast registro = new ParametrosMast();

	private double valorNumerico;

	private boolean esFinanzaComun;
	private boolean disableValorTexto;
	private boolean disableValorNumerico;
	private boolean disableValorFecha;

	private boolean checkCompania;

	public void inicializar() {
		inicializarEntidad();
		inicializarLista();
		inicializarDatoInicial();
		buscarPrincipal();
	}

	public void inicializarEntidad() {
		filtro = new ParametrosMast();
		seleccion = new ParametrosMast();
		registro = new ParametrosMast();
	}

	public void inicializarDatoInicial() {
		checkCompania = true;
		filtro.setEstado(Constant.ACTIVO);
	}

	public void inicializarLista() {
		listadoAplicacion = UtilesCommons.getCleanList(listadoAplicacion);
		listadoCompania = UtilesCommons.getCleanList(listadoCompania);
	}

	@Override
	public void btnBuscar() {
		dataModel = buscarPrincipal();
	}

	@Override
	public void btnGuardar() {
		if (esValidoFormulario(registro)) {
			if(validarExistencia(registro)){
				int result = 0;
				ParametrosMast objSave = transformarEntidad(registro);

				if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
					result = parametrosService.guardar(objSave);
				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)) {
					result = parametrosService.actualizar(objSave);
				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)) {
					result = parametrosService.actualizar(objSave);
				} else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_DELETE)) {
					result = parametrosService.eliminar(objSave);
				}

				if (result > 0) {
					btnAceptar();
					btnBuscar();
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
				} else {
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
				}
			} 
		}

	}

	@Override
	public void btnNuevo() {
		MODO_ACTUAL = MODO_NEW;
		setAtributosWindowsRegistro(MODO_ACTUAL);
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
			MODO_ACTUAL = MODO_DELETE;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	public void btnInactivar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			if (UtilesCommons.sonCadenasIguales(seleccion.getEstado(), Constant.INACTIVO)) {
				FacesUtil.adicionarMensajeWarning(	FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_DISABLED_PARAMETRO"));
				return;
			}
			MODO_ACTUAL = MODO_INACTIVAR;
			setAtributosWindowsRegistro(MODO_ACTUAL);
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
		seleccion = new ParametrosMast();
		registro = new ParametrosMast();
	}

	@Override
	public void btnCancelar() {
		visibleRegistro = false;
		seleccion = new ParametrosMast();
		registro = new ParametrosMast();
	}

	@Override
	public void abrirRegistro() {

	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		filtro = UtilesCommons.esNulo(filtro) ? new ParametrosMast() : filtro;
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
	}

	public LazyDataModel<ParametrosMast> buscarPrincipal() {
		dataModel = new LazyDataModel<ParametrosMast>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<ParametrosMast> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				cargarObjetoFiltros(first, pageSize, 0);
				listadoDataModel = parametrosService.listarPorPag(filtro);
				setRowCount(parametrosService.contarPorPag(filtro));
				setPageSize(pageSize);
				setRowIndex(first);
				return listadoDataModel;
			}

			@Override
			public ParametrosMast getRowData(String rowKey) {
				for (ParametrosMast event : listadoDataModel) {
					if (UtilesCommons.sonCadenasIguales(("" + event.getId().getParametroclave()), ("" + rowKey))) {
						seleccion = event;
						return seleccion;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(ParametrosMast event) {
				return event.getId().getParametroclave();
			}
		};
		return dataModel;
	}

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);
		if (UtilesCommons.sonCadenasIguales(modo, MODO_NEW)) {
			registro = new ParametrosMast();
			registro.getId().setAplicacioncodigo(Constant.APLICACION_CODIGO);
			registro.getId().setCompaniacodigo(Constant.COMPANIA_VARIABLE);
			registro.setEstado(Constant.ACTIVO);
			registro.setTipodedatoflag(Constant.PARAMETRO_TIPO_TEXTO);
		} else {
			registro = seleccion;
		}

		seleccionarValorParametro();
		listarComboRegistro();
	}

	/** METODO PARA VALIDAR **/
	public boolean esValidoFormulario(ParametrosMast objSave) {
		boolean validoFormulario = true;
		if (UtilesCommons.esVacio(objSave.getId().getCompaniacodigo())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_SELECTED_COMPANIA"));
			validoFormulario = false;
		}

		if (UtilesCommons.esVacio(objSave.getId().getAplicacioncodigo())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_SELECTED_APLICACION"));
			validoFormulario = false;
		}

		if (UtilesCommons.esVacio(objSave.getId().getParametroclave())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_REQUIRED_PARAMETRO"));
			validoFormulario = false;
		}

		if (UtilesCommons.esVacio(objSave.getDescripcionparametro())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_REQUIRED_DESCRIPCION"));
			validoFormulario = false;
		}
				
		
		if(esParametroTexto() && UtilesCommons.esVacio(objSave.getTexto())){
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_REQUIRED_TEXTO"));
			validoFormulario = false;
		}		 
		else if(esParametroFecha() && UtilesCommons.esNulo(objSave.getFecha())){
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_REQUIRED_FECHA"));
			validoFormulario = false;
		} 
		else{
			
		}

		return validoFormulario;
	}
	
	public boolean validarExistencia(ParametrosMast objSave) {
		boolean valida = true;
		if(UtilesCommons.cadenaEnListIgnoreCase(MODO_ACTUAL, MODO_INACTIVAR, MODO_DELETE)){
			
		}
		else{
			if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
				ParametrosMastPK filtroPK = new ParametrosMastPK();
				filtroPK.setCompaniacodigo(objSave.getId().getCompaniacodigo());
				filtroPK.setAplicacioncodigo(objSave.getId().getAplicacioncodigo());
				filtroPK.setParametroclave(objSave.getId().getParametroclave());

				ParametrosMast busqueda = parametrosService.buscarPorID(filtroPK);
				if (UtilesCommons.noEsNulo(busqueda)) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PARAMETRO_REPEATED_PARAMETRO"));
					valida = false;
				}
			}
		}
		
		return valida;
	}

	/** METODO PARA SELECCIONAR **/
	public void seleccionarFinanzaComun() {
		registro.setFinancecomunflag(UtilesCommons.obtenerValorStringSiNo(esFinanzaComun));
	}

	public void seleccionarCompania() {
		if (isCheckCompania()) {
			registro.getId().setCompaniacodigo(Constant.APLICACION_CODIGO);
		}
	}

	public void seleccionarTipoParametro() {
		registro.setFecha(null);
		registro.setTexto(null);
		valorNumerico = 0;
		seleccionarValorParametro();
	}

	public void seleccionarValorParametro() {
		if (UtilesCommons.noEsVacio(registro.getTipodedatoflag())) {
			if (esParametroTexto()) {
				disableValorTexto = false;
				disableValorNumerico = true;
				disableValorFecha = true;
			}
			else if (esParametroNumerico()) {
				disableValorTexto = true;
				disableValorNumerico = false;
				disableValorFecha = true;
			}
			else if (esParametroFecha()) {
				disableValorTexto = true;
				disableValorNumerico = true;
				disableValorFecha = false;
			}
		} else {
			disableValorTexto = true;
			disableValorNumerico = true;
			disableValorFecha = true;
		}
	}
	

	/** METODO PARA LISTAR **/
	public void listarComboRegistro() {
		listadoAplicacion = listarAplicacion();
		listadoCompania = listarCompania();
	}

	public List<Aplicacionesmast> listarAplicacion() {
		return aplicacionService.listarPorEstado(Utiles.ACTIVO_db);
	}

	public List<CompaniaMast> listarCompania() {
		return companiaService.companiaListar(null);
	}

	/** METODO PARA SECUNDARIO **/
	public boolean esParametroTexto(){
		return  (UtilesCommons.sonCadenasIguales(registro.getTipodedatoflag(), Constant.PARAMETRO_TIPO_TEXTO)) ? true : false;			
	}
	
	public boolean esParametroNumerico(){
		return  (UtilesCommons.sonCadenasIguales(registro.getTipodedatoflag(), Constant.PARAMETRO_TIPO_NUMERICO)) ? true : false;			
	}
	
	public boolean esParametroFecha(){
		return  (UtilesCommons.sonCadenasIguales(registro.getTipodedatoflag(), Constant.PARAMETRO_TIPO_FECHA)) ? true : false;			
	}
	
	
	public ParametrosMast transformarEntidad(ParametrosMast registro) {

		if (UtilesCommons.sonCadenasIguales(MODO_INACTIVAR, MODO_ACTUAL)) {
			registro.setEstado(Constant.INACTIVO);
		} else if (UtilesCommons.sonCadenasIguales(MODO_DELETE, MODO_ACTUAL)) {
			registro.setEstado(Constant.ELIMINADO);
		} else {

		}

		if (esParametroNumerico()|| !disableValorNumerico) {
			registro.setNumero(new BigDecimal(valorNumerico));
		}

		registro.getId().setParametroclave(UtilesCommons.esVacio(registro.getId().getParametroclave()) ? "": registro.getId().getParametroclave().toUpperCase());
		registro.setDescripcionparametro(UtilesCommons.esVacio(registro.getDescripcionparametro()) ? "": registro.getDescripcionparametro().toUpperCase());
		registro.setUltimousuario(EntityGlobal.getInstance().getUsuario());
		registro.setUltimafechamodif(new Date());

		return registro;
	}

	public String getParametroDes(String flagParametro) {
		if (flagParametro.equalsIgnoreCase(Constant.PARAMETRO_TIPO_TEXTO)) {
			return "Texto";
		} else if (flagParametro.equalsIgnoreCase(Constant.PARAMETRO_TIPO_NUMERICO)) {
			return "Numerico";
		} else if (flagParametro.equalsIgnoreCase(Constant.PARAMETRO_TIPO_FECHA)) {
			return "Fecha";
		} else {
			return "No Determinado";
		}
	}

	/** GET - SET **/
	public ParametrosMastService getParametrosService() {
		return parametrosService;
	}

	public void setParametrosService(ParametrosMastService parametrosService) {
		this.parametrosService = parametrosService;
	}

	public AplicacionMastService getAplicacionService() {
		return aplicacionService;
	}

	public void setAplicacionService(AplicacionMastService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}

	public CompaniaMastService getCompaniaService() {
		return companiaService;
	}

	public void setCompaniaService(CompaniaMastService companiaService) {
		this.companiaService = companiaService;
	}

	public LazyDataModel<ParametrosMast> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<ParametrosMast> dataModel) {
		this.dataModel = dataModel;
	}

	public List<ParametrosMast> getListadoDataModel() {
		return listadoDataModel;
	}

	public void setListadoDataModel(List<ParametrosMast> listadoDataModel) {
		this.listadoDataModel = listadoDataModel;
	}

	public List<Aplicacionesmast> getListadoAplicacion() {
		return listadoAplicacion;
	}

	public void setListadoAplicacion(List<Aplicacionesmast> listadoAplicacion) {
		this.listadoAplicacion = listadoAplicacion;
	}

	public List<CompaniaMast> getListadoCompania() {
		return listadoCompania;
	}

	public void setListadoCompania(List<CompaniaMast> listadoCompania) {
		this.listadoCompania = listadoCompania;
	}

	public ParametrosMast getFiltro() {
		return filtro;
	}

	public void setFiltro(ParametrosMast filtro) {
		this.filtro = filtro;
	}

	public ParametrosMast getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(ParametrosMast seleccion) {
		this.seleccion = seleccion;
	}

	public ParametrosMast getRegistro() {
		return registro;
	}

	public void setRegistro(ParametrosMast registro) {
		this.registro = registro;
	}

	public double getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(double valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public boolean isEsFinanzaComun() {
		return esFinanzaComun;
	}

	public void setEsFinanzaComun(boolean esFinanzaComun) {
		this.esFinanzaComun = esFinanzaComun;
	}

	public boolean isDisableValorTexto() {
		return disableValorTexto;
	}

	public void setDisableValorTexto(boolean disableValorTexto) {
		this.disableValorTexto = disableValorTexto;
	}

	public boolean isDisableValorNumerico() {
		return disableValorNumerico;
	}

	public void setDisableValorNumerico(boolean disableValorNumerico) {
		this.disableValorNumerico = disableValorNumerico;
	}

	public boolean isDisableValorFecha() {
		return disableValorFecha;
	}

	public void setDisableValorFecha(boolean disableValorFecha) {
		this.disableValorFecha = disableValorFecha;
	}

	public boolean isCheckCompania() {
		return checkCompania;
	}

	public void setCheckCompania(boolean checkCompania) {
		this.checkCompania = checkCompania;
	}

}
