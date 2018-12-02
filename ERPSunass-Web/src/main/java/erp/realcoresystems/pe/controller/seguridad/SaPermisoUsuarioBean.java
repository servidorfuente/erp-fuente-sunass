package erp.realcoresystems.pe.controller.seguridad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.AcSucursal;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.AcSucursalService;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.SeguridadPerfilUsuarioService;
import erp.realcoresystems.pe.service.SeguridadautorizacionesService;
import erp.realcoresystems.pe.service.SySeguridadAutorizacionService;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;


@ManagedBean(name = "saPermisoUsuarioBean")
@ViewScoped
public class SaPermisoUsuarioBean extends AbstractGenericBean implements InterfaceGenericBean {

	private static final long serialVersionUID = 1L;

	private final String FORMULARIO_ID = "FormularioPermisoUsuario";
	private final String MODO_ASIGNAR_INSTITUCION = "Asignar institución";
	private final String MODO_ASIGNAR_PERFIL = "Asignar perfil";
	private final String MODO_COPIAR_PERFIL = "Copiar perfil";
	
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{maMiscelaneosdetalleService}")
	private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

	@ManagedProperty(value = "#{CompaniaOwnerService}")
	private CompaniaOwnerService companiaOwnerService;

	@ManagedProperty(value = "#{SySeguridadAutorizacionService}")
	private SySeguridadAutorizacionService sySeguridadAutorizacionService;
	
	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadAutorizacionesService;

	
	@ManagedProperty(value = "#{acSucursalService}")
	private AcSucursalService acSucursalService;
	

	private LazyDataModel<VwUsuarioseguridad> dataModel;
	private List<VwUsuarioseguridad> listaDataModel;

	private List<MaMiscelaneosdetalle> listadoTipoUsuario;

	private Usuario filtro = new Usuario();
	private VwUsuarioseguridad seleccion = new VwUsuarioseguridad();
	private Usuario registro = new Usuario();

	private String codtipoUserInt;
	private String codtipoUserExt;

	private boolean modoActualInstitucion;
	private boolean modoActualAsiPerfil;
	private boolean modoActualCopPerfil;
	
	private boolean disabledPerfil;

	public void inicializar() {
		inicializarEntidad();
		inicializarLista();
		inicializarDatoInicial();
		buscarPrincipal();
	}

	public void inicializarEntidad() {
		companyowner = null;
		filtro = new Usuario();
		seleccion = new VwUsuarioseguridad();
		registro = new Usuario();
	}

	public void inicializarLista() {
		listadoTipoUsuario = UtilesCommons.getCleanList(listadoTipoUsuario);
	}

	public void inicializarDatoInicial() {
		filtro.setEstado(Constant.ACTIVO);
		listarComboInicial();
	}

	@Override
	public void btnBuscar() {
		buscarPrincipal();

	}

	@Override
	public void btnNuevo() {
	}

	@Override
	public void btnGuardar() {
		
		int result = 0;
		/** EN CASO SEA : ASIGNAR INSTITUCION **/
		if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_ASIGNAR_INSTITUCION)){			 
			seleccionSyAutorizacionReg.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			seleccionSyAutorizacionReg.setUsuario(registro.getUsuario());			
			result = sySeguridadAutorizacionService.guardarSeguridadAutorizaciones(listaDataModelSyAutorizacionReg,seleccionSyAutorizacionReg);
		}
		/** EN CASO SEA : ASIGNAR PERFIL **/
		else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_ASIGNAR_PERFIL)){
			result = seguridadPerfilService.guardar(listaDataModelPerfilReg);			
		}
		/** EN CASO SEA : COPIAR PERFIL **/
		else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_COPIAR_PERFIL)){
			
			List<Seguridadperfilusuario> listCopySave = new ArrayList<Seguridadperfilusuario>();			
			for (Seguridadperfilusuario x : listaDataModelPerfilReg) {
				Seguridadperfilusuario obj = (Seguridadperfilusuario) UtilesCommons.getNuevoObjetoGenerico(x);
				x.setUsuario(registro.getUsuario());							
				listCopySave.add(obj);
			}
			result = seguridadPerfilService.guardar(listCopySave);
		}
		else{
			/*... */
		}
		
		if (result > 0) {
			btnAceptar();
			buscarPrincipal();
			FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
		} else {
			FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
		} 
	}

	@Override
	public void btnModificar() {

	}

	@Override
	public void btnVer() {

	}

	@Override
	public void btnEliminar() {

	}

	public void btnInactivar() {

	}

	public void btnAsignarInstitucion() {
		if(validarSeleccion()){
			MODO_ACTUAL = MODO_ASIGNAR_INSTITUCION;
			setAtributosWindowsRegistro(MODO_NEW);
		} 
	}

	public void btnAsignarPerfil() {
		if(validarSeleccion()){
			MODO_ACTUAL = MODO_ASIGNAR_PERFIL;
			setAtributosWindowsRegistro(MODO_NEW);
		}
	}

	public void btnCopiarPegar() {		
		if(validarSeleccion()){
			if(flagCopyPaste){
				seleccionCopiarPerfil = registro;
				setModoActual(false, false, false);
			}
			else{
				MODO_ACTUAL = MODO_COPIAR_PERFIL;
				setAtributosWindowsRegistro(MODO_NEW);
			}			
			flagCopyPaste = !flagCopyPaste;
		}		
	}
	
	public void btnCancelarCopiarPerfiles(){
		seleccion = new VwUsuarioseguridad();
		setSeleccionCopiarPerfil(null);
		setFlagCopyPaste(true);
	}

	@Override
	public void btnAceptar() {
		registro = new Usuario();
		seleccion = new VwUsuarioseguridad();
		visibleRegistro = false; 
	}

	@Override
	public void btnCancelar() {
		registro = new Usuario();
		seleccion = new VwUsuarioseguridad();
		visibleRegistro = false;
	}

	@Override
	public void abrirRegistro() {

	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		filtro = UtilesCommons.esNulo(filtro) ? new Usuario() : filtro;
		filtro.setFlagConsultaEntGlobal("EXCEPTO");
		filtro.setDescripcion01(Constant.USUARIO_ADMINSYS);
		filtro.setUsuarioperfil(Constant.USUARIO);
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
	}

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);
		if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_ASIGNAR_INSTITUCION)) {
			setModoActual(true, false, false);
			
			companyowner = null;
			sucursal = null;
			mapSucursalReg = UtilesCommons.getCleanLinkedHashMap(mapSucursalReg);
			mapCompaniaReg = UtilesCommons.getCleanLinkedHashMap(mapCompaniaReg);
			listaDataModelSyAutorizacionReg = UtilesCommons.getCleanList(listaDataModelSyAutorizacionReg);

			mapCompaniaReg = mapListarCompanyOwner();
			listaDataModelSyAutorizacionReg = listarSySeguridadAutorizacion();

		} 
		else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_ASIGNAR_PERFIL)) {
			setModoActual(false, true, false);
			
			perfilReg = null;			
			listadoPerfilReg = UtilesCommons.getCleanList(listadoPerfilReg);
			listaDataModelPerfilReg = UtilesCommons.getCleanList(listaDataModelPerfilReg);
			
			listadoPerfilReg = listarPerfil();
			listaDataModelPerfilReg = listarSeguridadPerfilUsuario(registro.getUsuario(), Constant.ACTIVO);

		} 
		else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_COPIAR_PERFIL)) {
			listaDataModelPerfilRegCopiar = UtilesCommons.getCleanList(listaDataModelPerfilRegCopiar);
			listaDataModelPerfilAnterior = UtilesCommons.getCleanList(listaDataModelPerfilAnterior);
			
			if (UtilesCommons.esVacio(seleccionCopiarPerfil.getUsuario() )) {
				
			} 
			else {				
				listaDataModelPerfilRegCopiar = listarSeguridadPerfilUsuario(seleccionCopiarPerfil.getUsuario(), null);
				
				Seguridadautorizaciones sAutorizaciones = new Seguridadautorizaciones();				
				sAutorizaciones.setUsuario(seleccionCopiarPerfil.getUsuario());
				listaDataModelPerfilAnterior = seguridadAutorizacionesService.listarElementos(sAutorizaciones);
			}
			
			setModoActual(false, false, true);
		}
		else {
			setModoActual(false, false, false);
		}
	}

	public LazyDataModel<VwUsuarioseguridad> buscarPrincipal() {
		dataModel = new LazyDataModel<VwUsuarioseguridad>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<VwUsuarioseguridad> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				cargarObjetoFiltros(first, pageSize, 0);
				listaDataModel = usuarioService.listarVwUsuarioseguridad(filtro);
				setRowCount(usuarioService.contadorTotalesUsuario(filtro));
				setPageSize(pageSize);
				setRowIndex(first);
				return listaDataModel;
			}

			@Override
			public VwUsuarioseguridad getRowData(String rowKey) {
				for (VwUsuarioseguridad event : listaDataModel) {
					if (("" + event.getUsuario()).equals("" + rowKey)) {
						seleccion = (VwUsuarioseguridad) event;
						return seleccion;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(VwUsuarioseguridad event) {
				return event.getUsuario();
			}
		};

		return dataModel;
	}

	public void onRowSelect() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			registro = new Usuario();
			registro.setUsuario(seleccion.getUsuario());
			registro.setClave(seleccion.getClave());
			registro.setEmpleado(seleccion.getEmpleado());
			registro.setEstado(seleccion.getEstado());
			registro.setExpirarpasswordflag(seleccion.getExpirarpasswordflag());
			registro.setFechaexpiracion(seleccion.getFechaexpiracion());
			registro.setNombre(seleccion.getNombre());
			registro.setNumerologinsdisponible(seleccion.getNumerologinsdisponible());
			registro.setNumerologinsusados(seleccion.getNumerologinsusados());
			registro.setOrden(seleccion.getOrden());
			registro.setPersona(seleccion.getPersona());
			registro.setSidOracle(seleccion.getSidOracle());
			registro.setSidOracleFecha(seleccion.getSidOracleFecha());
			registro.setSqllogin(seleccion.getSqllogin());
			registro.setSqlpassword(seleccion.getSqlpassword());
			registro.setTipousuario(seleccion.getTipousuario());
			registro.setUltimafechamodif(seleccion.getUltimafechamodif());
			registro.setUltimologin(seleccion.getUltimologin());
			registro.setUltimousuario(seleccion.getUltimousuario());
			registro.setUsuarioperfil(seleccion.getUsuarioperfil());
			registro.setUsuariored(seleccion.getUsuariored());
			if (UtilesCommons.sonCadenasIguales(registro.getUsuarioperfil(),Constant.PERFIL)) {
				setDisabledPerfil(true);
			} else {
				setDisabledPerfil(false);
			}
		} 
	}

	/** METODO PARA LISTAR **/
	public void listarComboInicial() {
		listadoTipoUsuario = listarMiscelaneosDetalle(null, Constant.MISCELANEO_DETALLE_USUARIO_TIPO_USUARIO);
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

	/** METODO SECUNDARIO **/
	public Usuario transformarEntidad(Usuario registro) {

		return registro;
	}

	/** Agregar PERMISOS POR DEFECTO al usuario NUEVO */
	public boolean agregarPermisoDefecto(String usuarioActual) {
		boolean result = false;
		try {
			// PERMISOS DE COMPAÑÍA
			String codSucursal = EntityGlobal.getInstance().getCodigoSucursal();
			String codCompania = EntityGlobal.getInstance().getCodigoCompanyowner();
			List<SySeguridadautorizaciones> listaAutorizaCompa = new ArrayList<SySeguridadautorizaciones>();
			SySeguridadautorizaciones objAutorizaCompa = new SySeguridadautorizaciones();
			objAutorizaCompa.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			objAutorizaCompa.setGrupo(Constant.SUCURSAL);
			objAutorizaCompa.setConcepto(codSucursal);
			objAutorizaCompa.setConceptoMaster(codCompania);
			objAutorizaCompa.setEstado(Constant.ACTIVO);
			objAutorizaCompa.setUsuario(usuarioActual);
			objAutorizaCompa.setUltimousuario(getUSUARIO_ACTUAL());
			objAutorizaCompa.setUltimafechamodif(new Date());
			listaAutorizaCompa.add(objAutorizaCompa);
			int res = sySeguridadAutorizacionService.guardarSeguridadAutorizaciones(listaAutorizaCompa,
					new SySeguridadautorizaciones());
			if (res > 0) {
				result = true;
			} else {
				result = false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noAddPermisosDefault"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public void updateForm(String... componenteIds) {
		if (UtilesCommons.esVacio(componenteIds)) {
			FacesUtil.update(FORMULARIO_ID);
		} else {
			int index = -1;
			String[] array = new String[componenteIds.length];
			for (String string : componenteIds) {
				index++;
				array[index] = UtilesCommons.noEsVacio(string) ? FORMULARIO_ID + ":" + string : string;
			}
			FacesUtil.update(array);
		}
	}

	public String getCodtipoUserInt() {
		codtipoUserInt = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_INT");
		return codtipoUserInt;
	}

	public void setCodtipoUserInt(String codtipoUserInt) {
		this.codtipoUserInt = codtipoUserInt;
	}

	public String getCodtipoUserExt() {
		codtipoUserExt = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT");
		return codtipoUserExt;
	}

	public void setCodtipoUserExt(String codtipoUserExt) {
		this.codtipoUserExt = codtipoUserExt;
	}

	public void setModoActual(boolean modoActualInstitucion, boolean modoActualAsiPerfil, boolean modoActualCopPerfil) {
		setModoActualInstitucion(modoActualInstitucion);
		setModoActualAsiPerfil(modoActualAsiPerfil);
		setModoActualCopPerfil(modoActualCopPerfil);
	}

	/**************************************************************************
	 * ASIGNAR INSTITUCION
	 *************************************************************************/
	private Map<String, Companyowner> mapCompaniaReg;
	private Map<String, AcSucursal> mapSucursalReg;
	private List<SySeguridadautorizaciones> listaDataModelSyAutorizacionReg;
	private SySeguridadautorizaciones seleccionSyAutorizacionReg;

	private String companyowner;
	private String sucursal;

	public void btnAgregarInstitucion() {
		if (validarAgregarListaInstitucion()) {
			Companyowner objCompanyowner = mapCompaniaReg.get(companyowner);
			AcSucursal objSucursal = mapSucursalReg.get(sucursal);

			SySeguridadautorizaciones obj = new SySeguridadautorizaciones();
			obj.setAplicacioncodigo(getAPP_CODIGO());
			obj.setGrupo(Constant.SUCURSAL);
			obj.setConcepto(objSucursal.getSucursal());
			obj.setGrupoMaster(Constant.COMPANIA);
			obj.setConceptoMaster(objCompanyowner.getCompanyowner());
			obj.setDescripcionlarga(objCompanyowner.getDescription());
			obj.setDescripcionlocal(objSucursal.getSucursal());
			obj.setUsuario(registro.getUsuario());
			obj.setUltimousuario(EntityGlobal.getInstance().getUsuario());
			obj.setUltimafechamodif(new Date());
			obj.setAccion(Constant.INSERT_db);
			listaDataModelSyAutorizacionReg.add(obj);
		}
	}

	public void btnRemoverInstitucion(SySeguridadautorizaciones obj) {
		listaDataModelSyAutorizacionReg.remove(obj);
	}

	/** METODO PARA VALIDAR - ASIGNAR INSTITUCION **/
	public boolean validarSeleccion() {
		boolean valida = true;
		if (UtilesCommons.esNulo(seleccion)) {
			valida = false;
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		} else if (UtilesCommons.cadenaEnListIgnoreCase(seleccion.getEstado(), Constant.ELIMINADO, Constant.INACTIVO)) {
			valida = false;
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_alreadyDisabled"));
		} else {

		}
		return valida;
	}

	public boolean validarAgregarListaInstitucion() {
		boolean valida = true;
		if (UtilesCommons.esVacio(companyowner)) {
			valida = false;
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISO_USUARIO_SELECTED_INSTITUCION"));
		} else if (UtilesCommons.esVacio(sucursal)) {
			valida = false;
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISO_USUARIO_SELECTED_SUCURSAL"));
		} else {
			if (UtilesCommons.noEsVacio(listaDataModelSyAutorizacionReg)) {
				for (SySeguridadautorizaciones obj : listaDataModelSyAutorizacionReg) {
					if (UtilesCommons.sonCadenasIguales(obj.getConcepto(), sucursal)
							&& UtilesCommons.sonCadenasIguales(obj.getGrupo(), Constant.SUCURSAL)) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_INFO_yaSeRegistro"));
						break;
					}
				}
			}
		}
		return valida;
	}

	/** METODO PARA SELECCIONAR **/
	public void seleccionarInstitucion() {
		mapSucursalReg = UtilesCommons.getCleanLinkedHashMap(mapSucursalReg);
		if (UtilesCommons.noEsVacio(companyowner)) {
			mapSucursalReg = mapListarSucursal(companyowner);
		}
	}

	/** METODO PARA LISTAR - ASIGNAR INSTITUCION **/
	public Map<String, Companyowner> mapListarCompanyOwner() {
		Map<String, Companyowner> map = UtilesCommons.getNewLinkedHashMap();
		List<Companyowner> lista = companiaOwnerService.listarCompanias(null);		
		if (UtilesCommons.noEsVacio(lista)) {
			for (Companyowner value : lista) {
				map.put(value.getCompanyowner(), value);
			}
		}
		return map;
	}

	public Map<String, AcSucursal> mapListarSucursal(String companyowner){		
		Map<String, AcSucursal> map = UtilesCommons.getNewLinkedHashMap();		
		AcSucursal acSucursal = new AcSucursal();
		acSucursal.getCompanyowner().setCompanyowner(companyowner);
		List<AcSucursal> lista = acSucursalService.sucursalListar(acSucursal);
		if(UtilesCommons.noEsVacio(lista)){
			for (AcSucursal value : lista) {
				map.put(value.getSucursal(), value);
			}
		}		
		return map;
	}
	
	public List<SySeguridadautorizaciones> listarSySeguridadAutorizacion() {
		SySeguridadautorizaciones sySeguridadautorizaciones = new SySeguridadautorizaciones();
		sySeguridadautorizaciones.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		sySeguridadautorizaciones.setGrupo(Constant.SUCURSAL);
		sySeguridadautorizaciones.setUsuario(registro.getUsuario());
		sySeguridadautorizaciones.setEstado(Constant.ACTIVO);
		return sySeguridadAutorizacionService.listadoSySeguridadPorGrupo(sySeguridadautorizaciones);
	}

	/********************************************************************************************
	 * ASIGNAR PERFIL
	 *******************************************************************************************/
	@ManagedProperty(value = "#{seguridadPerfilUsuarioService}")
	private SeguridadPerfilUsuarioService seguridadPerfilService;
	
	public List<Usuario> listadoPerfilReg;
	public List<Seguridadperfilusuario> listaDataModelPerfilReg;
	
	private String perfilReg;
	
	public void btnAgregarPerfil(){
		if(validarAgregarListaPerfil()){
			Seguridadperfilusuario var = new Seguridadperfilusuario();
			var.setPerfil(perfilReg);
			var.setUsuario(registro.getUsuario());
			var.setEstado(Constant.ACTIVO);
			var.setUltimousuario(registro.getUsuario());
			Date fecha = new Date();
			var.setUltimafechamodif(fecha);	
			listaDataModelPerfilReg.add(var);
		}
	}
 	
	public void btnRemoverPerfil(Seguridadperfilusuario obj) {
		listaDataModelPerfilReg.remove(obj);
	}
	
	/** METODO PARA VALIDAR - ASIGNAR PERFILES */	
	public boolean validarAgregarListaPerfil(){
		boolean valida = true;
		if(UtilesCommons.esVacio(perfilReg)){
			valida = false;
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISO_USUARIO_SELECTED_PERFIL"));
		}else{
			if (UtilesCommons.noEsVacio(listaDataModelPerfilReg)) {
				for (Seguridadperfilusuario obj : listaDataModelPerfilReg) {
					if (UtilesCommons.sonCadenasIguales(obj.getPerfil(),perfilReg)) {
						valida = false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_ERROR_perfilYaAsignado"));
						break;
					}
				}
			}
		}
		return valida;
	}
	
	
	/** METODO PARA LISTAR - ASIGNAR PERFILES */
	public List<Usuario> listarPerfil(){
		Usuario filtro = new Usuario();
		filtro.setUsuarioperfil(Constant.PERFIL);
		filtro.setEstado(Utiles.ACTIVO_db);
		filtro.setFlagConsultaEntGlobal("EXCEPTO"); 
		filtro.setDescripcion01(Constant.USUARIO_ADMINSYS); 
		return usuarioService.UsuarioListar(filtro);
	}
	
	public List<Seguridadperfilusuario> listarSeguridadPerfilUsuario(String usuario, String estado){
		Seguridadperfilusuario filtro = new Seguridadperfilusuario();
		filtro.setUsuario(usuario);
		filtro.setEstado(estado);
		return seguridadPerfilService.SeguridadPerfilLista(filtro);
	} 
	
	
	/********************************************************************************************
	 * COPIAR PERFIL
	 *******************************************************************************************/
	private Usuario seleccionCopiarPerfil;
	private List<Seguridadperfilusuario> listaDataModelPerfilRegCopiar;
	private List<Seguridadautorizaciones> listaDataModelPerfilAnterior;
	
	private boolean flagCopyPaste = true;
 
	
	/** GET - SET **/
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public SeguridadautorizacionesService getSeguridadAutorizacionesService() {
		return seguridadAutorizacionesService;
	}

	public void setSeguridadAutorizacionesService(SeguridadautorizacionesService seguridadAutorizacionesService) {
		this.seguridadAutorizacionesService = seguridadAutorizacionesService;
	}

	public Usuario getSeleccionCopiarPerfil() {
		return seleccionCopiarPerfil;
	}

	public void setSeleccionCopiarPerfil(Usuario seleccionCopiarPerfil) {
		this.seleccionCopiarPerfil = seleccionCopiarPerfil;
	}

	public List<Seguridadperfilusuario> getListaDataModelPerfilRegCopiar() {
		return listaDataModelPerfilRegCopiar;
	}

	public void setListaDataModelPerfilRegCopiar(List<Seguridadperfilusuario> listaDataModelPerfilRegCopiar) {
		this.listaDataModelPerfilRegCopiar = listaDataModelPerfilRegCopiar;
	}

	public MaMiscelaneosdetalleService getMaMiscelaneosdetalleService() {
		return maMiscelaneosdetalleService;
	}

	public void setMaMiscelaneosdetalleService(MaMiscelaneosdetalleService maMiscelaneosdetalleService) {
		this.maMiscelaneosdetalleService = maMiscelaneosdetalleService;
	}

	public CompaniaOwnerService getCompaniaOwnerService() {
		return companiaOwnerService;
	}

	public void setCompaniaOwnerService(CompaniaOwnerService companiaOwnerService) {
		this.companiaOwnerService = companiaOwnerService;
	}

	public SySeguridadAutorizacionService getSySeguridadAutorizacionService() {
		return sySeguridadAutorizacionService;
	}

	public void setSySeguridadAutorizacionService(SySeguridadAutorizacionService sySeguridadAutorizacionService) {
		this.sySeguridadAutorizacionService = sySeguridadAutorizacionService;
	}

	public LazyDataModel<VwUsuarioseguridad> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<VwUsuarioseguridad> dataModel) {
		this.dataModel = dataModel;
	}

	public List<VwUsuarioseguridad> getListaDataModel() {
		return listaDataModel;
	}

	public void setListaDataModel(List<VwUsuarioseguridad> listaDataModel) {
		this.listaDataModel = listaDataModel;
	}

	public List<MaMiscelaneosdetalle> getListadoTipoUsuario() {
		return listadoTipoUsuario;
	}

	public void setListadoTipoUsuario(List<MaMiscelaneosdetalle> listadoTipoUsuario) {
		this.listadoTipoUsuario = listadoTipoUsuario;
	}

	public Map<String, Companyowner> getMapCompaniaReg() {
		return mapCompaniaReg;
	}

	public void setMapCompaniaReg(Map<String, Companyowner> mapCompaniaReg) {
		this.mapCompaniaReg = mapCompaniaReg;
	}

	public Map<String, AcSucursal> getMapSucursalReg() {
		return mapSucursalReg;
	}

	public void setMapSucursalReg(Map<String, AcSucursal> mapSucursalReg) {
		this.mapSucursalReg = mapSucursalReg;
	}

	public List<SySeguridadautorizaciones> getListaDataModelSyAutorizacionReg() {
		return listaDataModelSyAutorizacionReg;
	}

	public void setListaDataModelSyAutorizacionReg(List<SySeguridadautorizaciones> listaDataModelSyAutorizacionReg) {
		this.listaDataModelSyAutorizacionReg = listaDataModelSyAutorizacionReg;
	}

	public SySeguridadautorizaciones getSeleccionSyAutorizacionReg() {
		return seleccionSyAutorizacionReg;
	}

	public void setSeleccionSyAutorizacionReg(SySeguridadautorizaciones seleccionSyAutorizacionReg) {
		this.seleccionSyAutorizacionReg = seleccionSyAutorizacionReg;
	}

	public Usuario getFiltro() {
		return filtro;
	}

	public void setFiltro(Usuario filtro) {
		this.filtro = filtro;
	}

	public VwUsuarioseguridad getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(VwUsuarioseguridad seleccion) {
		this.seleccion = seleccion;
	}

	public Usuario getRegistro() {
		return registro;
	}

	public void setRegistro(Usuario registro) {
		this.registro = registro;
	}

	public boolean isModoActualInstitucion() {
		return modoActualInstitucion;
	}

	public void setModoActualInstitucion(boolean modoActualInstitucion) {
		this.modoActualInstitucion = modoActualInstitucion;
	}

	public boolean isModoActualAsiPerfil() {
		return modoActualAsiPerfil;
	}

	public void setModoActualAsiPerfil(boolean modoActualAsiPerfil) {
		this.modoActualAsiPerfil = modoActualAsiPerfil;
	}

	public boolean isModoActualCopPerfil() {
		return modoActualCopPerfil;
	}

	public void setModoActualCopPerfil(boolean modoActualCopPerfil) {
		this.modoActualCopPerfil = modoActualCopPerfil;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public AcSucursalService getAcSucursalService() {
		return acSucursalService;
	}

	public void setAcSucursalService(AcSucursalService acSucursalService) {
		this.acSucursalService = acSucursalService;
	}

	public boolean isDisabledPerfil() {
		return disabledPerfil;
	}

	public void setDisabledPerfil(boolean disabledPerfil) {
		this.disabledPerfil = disabledPerfil;
	}

	public SeguridadPerfilUsuarioService getSeguridadPerfilService() {
		return seguridadPerfilService;
	}

	public void setSeguridadPerfilService(SeguridadPerfilUsuarioService seguridadPerfilService) {
		this.seguridadPerfilService = seguridadPerfilService;
	}

	public List<Usuario> getListadoPerfilReg() {
		return listadoPerfilReg;
	}

	public void setListadoPerfilReg(List<Usuario> listadoPerfilReg) {
		this.listadoPerfilReg = listadoPerfilReg;
	}

	public List<Seguridadperfilusuario> getListaDataModelPerfilReg() {
		return listaDataModelPerfilReg;
	}

	public void setListaDataModelPerfilReg(List<Seguridadperfilusuario> listaDataModelPerfilReg) {
		this.listaDataModelPerfilReg = listaDataModelPerfilReg;
	}

	public String getPerfilReg() {
		return perfilReg;
	}

	public void setPerfilReg(String perfilReg) {
		this.perfilReg = perfilReg;
	}

	public boolean isFlagCopyPaste() {
		return flagCopyPaste;
	}

	public void setFlagCopyPaste(boolean flagCopyPaste) {
		this.flagCopyPaste = flagCopyPaste;
	}

	
	
}
