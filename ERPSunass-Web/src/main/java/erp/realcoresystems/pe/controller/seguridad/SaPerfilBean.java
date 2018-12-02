package erp.realcoresystems.pe.controller.seguridad;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


@ManagedBean(name = "saPerfilBean")
@ViewScoped
public class SaPerfilBean extends AbstractGenericBean implements InterfaceGenericBean {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	private Usuario filtro = new Usuario();
	private Usuario seleccion = new Usuario();
	private Usuario registro = new Usuario();

	private LazyDataModel<Usuario> dataModel;
	private List<Usuario> listaDataModel;

	public void inicializar() {
		inicializarEntidad();
		inicializarDatoInicial();
		buscarPrincipal();
	}

	public void inicializarEntidad() {
		filtro = new Usuario();
		registro = new Usuario();
		seleccion = new Usuario();
	}

	public void inicializarDatoInicial() {
		filtro.setEstado(Constant.ACTIVO);
	}

	@Override
	public void btnBuscar() {
		buscarPrincipal();
	}

	@Override
	public void btnGuardar() {
		if (validarFormulario(registro)) {
			if (validarExistencia(registro)) {
				int result = 0;
				Usuario objSave = transformarEntidad(registro);
				
				if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
					result = usuarioService.guardarUsuario(objSave);
				}
				else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)){
					result = usuarioService.actualizar(objSave);
				}
				else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)){
					result = usuarioService.actualizar(objSave);
				}				
				
				if(result > 0){
					btnAceptar();
					buscarPrincipal();
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
				}
				else{
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

	public void btnInactivar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			if (UtilesCommons.sonCadenasIguales(registro.getEstado(), Constant.INACTIVO)) {
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_PERFIL_alreadyDisabled"));
				return;
			}
			MODO_ACTUAL = MODO_INACTIVAR;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnEliminar() {

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
		registro = new Usuario();
		seleccion = new Usuario();
		visibleRegistro = false;

	}

	@Override
	public void btnCancelar() {
		registro = new Usuario();
		seleccion = new Usuario();
		visibleRegistro = false;
	}

	@Override
	public void abrirRegistro() {
	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		filtro = UtilesCommons.esNulo(filtro) ? new Usuario() : filtro;
		filtro.setUsuarioperfil(Constant.PERFIL);
		filtro.setFlagConsultaEntGlobal("EXCEPTO");
		filtro.setDescripcion01(Constant.USUARIO_ADMINSYS);
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
	}

	public LazyDataModel<Usuario> buscarPrincipal() {

		dataModel = new LazyDataModel<Usuario>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				cargarObjetoFiltros(first, pageSize, 0);
				listaDataModel = usuarioService.UsuarioPerfilListar(filtro);
				setRowCount(usuarioService.contadorTotalesUsuario(filtro));
				setPageSize(pageSize);
				setRowIndex(first);
				return listaDataModel;
			}

			@Override
			public Usuario getRowData(String rowKey) {
				for (Usuario event : listaDataModel) {
					if (UtilesCommons.sonCadenasIguales(event.getUsuario(), rowKey)) {
						seleccion = (Usuario) event;
						return seleccion;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(Usuario event) {
				return event.getUsuario();
			}
		};
		return dataModel;
	}

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);
		if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
			registro = new Usuario();
			registro.setUsuariored(getUSUARIO_ACTUAL());
			registro.setEstado(Constant.ACTIVO);
		} else {
			registro = seleccion;
		}
	}

	public boolean validarFormulario(Usuario registro) {
		boolean valida = true;
		if (UtilesCommons.esVacio(registro.getUsuario())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERFIL_NOMBREPERFIL"));
			valida = false;
		}
		if (UtilesCommons.esVacio(registro.getNombre())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERFIL_DESCRIPCION"));
			valida = false;
		}
		return valida;
	}

	public boolean validarExistencia(Usuario registro) {
		boolean valida = true;
		if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
			Usuario busqueda = usuarioService.UsuarioBuscar(registro);
			if (UtilesCommons.noEsNulo(busqueda)) {
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_codPerfilRepetido"));
				valida = false;
			}
		}
		return valida;
	}

	/** METODO SECUNDARIO **/
	public Usuario transformarEntidad(Usuario registro) {
		if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)) {
			registro.setEstado(Constant.INACTIVO);
			registro.setUsuarioperfil(Constant.PERFIL);
			registro.setUltimousuario(getUSUARIO_ACTUAL());
			registro.setUltimafechamodif(new Date());
			registro.setExpirarpasswordflag(UtilesCommons.obtenerValorStringSiNo(registro.isVisibled()));
		
		}
		else{
			registro.setUsuarioperfil(Constant.PERFIL);
			registro.setUsuario(UtilesCommons.noEsVacio(registro.getUsuario()) ? registro.getUsuario().toUpperCase() : registro.getUsuario());
			registro.setExpirarpasswordflag(UtilesCommons.obtenerValorStringSiNo(registro.isVisibled()));
			 
			if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
				registro.setUsuariored(getUSUARIO_ACTUAL());
				registro.setSidOracleFecha(new Date());
			}else{
				registro.setUltimafechamodif(new Date());
				registro.setExpirarpasswordflag(UtilesCommons.obtenerValorStringSiNo(registro.isVisibled()));
			
			}
		}		 
		return registro;
	}

	/******* GETTERS AND SETTERS *******/
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getFiltro() {
		return filtro;
	}

	public void setFiltro(Usuario filtro) {
		this.filtro = filtro;
	}

	public Usuario getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Usuario seleccion) {
		this.seleccion = seleccion;
	}

	public Usuario getRegistro() {
		return registro;
	}

	public void setRegistro(Usuario registro) {
		this.registro = registro;
	}

	public LazyDataModel<Usuario> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<Usuario> dataModel) {
		this.dataModel = dataModel;
	}

	public List<Usuario> getListaDataModel() {
		return listaDataModel;
	}

	public void setListaDataModel(List<Usuario> listaDataModel) {
		this.listaDataModel = listaDataModel;
	}

}
