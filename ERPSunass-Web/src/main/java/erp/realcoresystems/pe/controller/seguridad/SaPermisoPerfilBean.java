package erp.realcoresystems.pe.controller.seguridad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.TreeNode;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;
import erp.realcoresystems.pe.service.SeguridadConceptoVistaService;
import erp.realcoresystems.pe.service.SeguridadautorizacionesService;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;

import erp.realcoresystems.pe.util.Log;


@ManagedBean(name = "saPermisoPerfilBean")
@ViewScoped
public class SaPermisoPerfilBean extends AbstractGenericBean implements InterfaceGenericBean {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{seguridadConceptoVistaService}")
	private SeguridadConceptoVistaService seguridadConceptoVistaService;

	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadAutorizacioneService;
	
	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadautorizacionesService;
		
	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadAutorizacionesService;	
	
	
	private Usuario filtro = new Usuario();
	private VwUsuarioseguridad seleccion = new VwUsuarioseguridad();
	private Usuario registro = new Usuario();

	private LazyDataModel<VwUsuarioseguridad> dataModel;
	private List<VwUsuarioseguridad> listaDataModel;
	
	private List<Vistaconceptoautoriza> listaPerfilModuloReg = new ArrayList<Vistaconceptoautoriza>();
	private List<Vistaconceptoautoriza> listaPerfilOriginalReg = new ArrayList<Vistaconceptoautoriza>();
	private List<Vistaconceptoautoriza> listaPerfilOriginalRegAux = new ArrayList<Vistaconceptoautoriza>();
	private List<Vistaconceptoautoriza> listaPerfilUpdateReg = new ArrayList<Vistaconceptoautoriza>();
	private List<Vistaconceptoautoriza> listaPerfilDeleteReg = new ArrayList<Vistaconceptoautoriza>();
	private List<Seguridadautorizaciones> listaPerfilSaveReg = new ArrayList<Seguridadautorizaciones>();
	private List<Vistaconceptoautoriza> listaPerfilWebMasterReg = new ArrayList<Vistaconceptoautoriza>();
	private List<Vistaconceptoautoriza> listaPerfilWebMasterRegAux = new ArrayList<Vistaconceptoautoriza>();

	private TreeNode[] selectedNode;
	private TreeNode root;
	private TreeNode[] selectedNodePerfil;
	private TreeNode rootPerfil;

	public String TIPOO_OBJETO_db = "O";
	public String TIPOO_CARPETA_db = "C";
	public String TIPOO_ARCHIVO_db = "A";
	
	private boolean btnAgregarVisible;
	private boolean btnQuitarVisible;

	@PostConstruct
	public void inicializar() {
		super.initComponentes();
		inicializarEntidad();
		inicializarDatoInicial();
		buscarPrincipal();
	}

	public void inicializarEntidad() {
		filtro = new Usuario();
		registro = new Usuario();
		seleccion = new VwUsuarioseguridad();
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
		int result = 0;
		listaPerfilSaveReg = getListaGuardar();
		
		if (UtilesCommons.noEsVacio(listaPerfilSaveReg)) {	
			try{
				result = seguridadautorizacionesService.guardarMasivo(listaPerfilSaveReg);	
			}
			catch(HibernateOptimisticLockingFailureException ex){
				result = -7;
				ex.printStackTrace();
				Log.logger.error(Log.getStackTrace(ex));				
			}			
		} else {
			result = -999;
		}
		
		
		if (result > 0) {
			btnAceptar(); 
			buscarPrincipal();
			FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
		} else  if (result == -999) {
			FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_WARN_noDataSave"));
		} else if (result == -7) {
			FacesUtil.adicionarMensajeError("Error inesperardo: Se detectaron incongruencias en los registros relacionados a este Perfil.");
		} else{
			FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
		
		}
	}

	@Override
	public void btnNuevo() {

	}

	@Override
	public void btnModificar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_UPDATE;
			registro = getUsuarioSeleccion(seleccion);
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	public void btnInactivar() {
		
	}

	@Override
	public void btnEliminar() {

	}

	@Override
	public void btnVer() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			registro = getUsuarioSeleccion(seleccion);
			MODO_ACTUAL = MODO_VIEW;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	/** generar el Usuario registro a partir de la vista usario seleccionado
	 * @param usuarioSeguridad
	 * @return
	 */
	public Usuario getUsuarioSeleccion(VwUsuarioseguridad usuarioSeguridad) {
		Usuario usuarioReg = new Usuario();
		usuarioReg.setUsuario(usuarioSeguridad.getUsuario());
		usuarioReg.setNombre(usuarioSeguridad.getNombre());
		usuarioReg.setEstado(usuarioSeguridad.getEstado());
		usuarioReg.setPersona(usuarioSeguridad.getPersona());
		//....mas tributos de ser necesarios...
		
		return usuarioReg;
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
		filtro.setUsuarioperfil(Constant.PERFIL);
		filtro.setFlagConsultaEntGlobal("EXCEPTO");
		filtro.setDescripcion01(Constant.USUARIO_ADMINSYS);
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
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
					if (UtilesCommons.sonCadenasIguales(event.getUsuario(), rowKey)) {
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

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);
		if (MODO_VIEW.equals(modo)) {
			btnAgregarVisible = false;
			btnQuitarVisible = false;
		} else {
			btnAgregarVisible = true;
			btnQuitarVisible = true;
		}
		
		listaPerfilWebMasterReg = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilModuloReg = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilOriginalReg = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilUpdateReg = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilDeleteReg = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilSaveReg = new ArrayList<Seguridadautorizaciones>();

		listaPerfilWebMasterRegAux = new ArrayList<Vistaconceptoautoriza>();
		listaPerfilOriginalRegAux = new ArrayList<Vistaconceptoautoriza>();

		root = createSsCheVistaSeguridads();
		rootPerfil = createSsCheVistaSeguridadsPerfil();
		listaPerfilUpdateReg.addAll(listaPerfilOriginalReg);
		
	}

	public void onRowSelect(SelectEvent event) {		
	
	}

	
	public void btnAgregarConceptos(TreeNode[] nodes) {
		Vistaconceptoautoriza selectVistaconceptoautoriza = new Vistaconceptoautoriza();
		Vistaconceptoautoriza seguridadConceptoPadre = new Vistaconceptoautoriza();

		if (nodes != null && nodes.length > 0) {
			for (TreeNode node : nodes) {
				selectVistaconceptoautoriza = (Vistaconceptoautoriza) node.getData();
				boolean tienePadre = true;
				// RECORRDIDO PADRES
				TreeNode nodeAux = node;
				TreeNode parentAux = null;
				while (tienePadre) {
					parentAux = nodeAux.getParent();
					if (parentAux.getData() != null) {
						if (parentAux.getData() instanceof Vistaconceptoautoriza) {
							seguridadConceptoPadre = (Vistaconceptoautoriza) parentAux.getData(); // verificaExisteConceptoPadre(selectVistaconceptoautoriza);
							tienePadre = true;
							if (!verificaExisteNodo(seguridadConceptoPadre, listaPerfilUpdateReg)) {
								seguridadConceptoPadre.setAccion(Utiles.INSERT_db);
								seguridadConceptoPadre.setEstado(Utiles.ACTIVO_db);
								seguridadConceptoPadre.setOpcionopcion1Flag(registro.getUsuarioperfil());
								seguridadConceptoPadre.setUsuario(registro.getUsuario());									
								listaPerfilUpdateReg.add(seguridadConceptoPadre);
								nodeAux = parentAux;
							} else {
								nodeAux = parentAux;
							}
						} else {
							tienePadre = false;
						}
					} else {
						tienePadre = false;
					}
				}
				if (!verificaExisteNodo(selectVistaconceptoautoriza, listaPerfilUpdateReg)) {
					selectVistaconceptoautoriza.setAccion(Constant.INSERT_db);
					seguridadConceptoPadre.setEstado(Constant.ACTIVO);
					selectVistaconceptoautoriza.setOpcionopcion1Flag(registro.getUsuarioperfil());
					selectVistaconceptoautoriza.setUsuario(registro.getUsuario());
					listaPerfilUpdateReg.add(selectVistaconceptoautoriza);
				}
			}
			rootPerfil = null;
			rootPerfil = createSsCheVistaSeguridadsLocal();
			// selectedNode= null;
		}
	}

	public void btnQuitarConceptos(TreeNode[] nodes) {
		if (UtilesCommons.noEsVacio(listaPerfilUpdateReg)) {
			boolean algunInvalidoDelete = false;
			Vistaconceptoautoriza selectVistaconceptoautoriza = new Vistaconceptoautoriza();
			if (nodes != null && nodes.length > 0) {
				for (TreeNode node : nodes) {
					selectVistaconceptoautoriza = (Vistaconceptoautoriza) node.getData();
					for (Vistaconceptoautoriza obj : listaPerfilUpdateReg) {
						if (UtilesCommons.sonCadenasIguales(obj.getAplicacioncodigo(), selectVistaconceptoautoriza.getAplicacioncodigo())
								&& UtilesCommons.sonCadenasIguales(obj.getGrupo(),selectVistaconceptoautoriza.getGrupo())
								&& UtilesCommons.sonCadenasIguales(obj.getConcepto(),selectVistaconceptoautoriza.getConcepto())

						) {
							if (UtilesCommons.sonCadenasIguales(registro.getUsuario(),obj.getUsuario())) {
								if (!UtilesCommons.sonCadenasIguales(Constant.INSERT_db,obj.getAccion())) {									
									listaPerfilDeleteReg.add(obj);
								}
								listaPerfilUpdateReg.remove(obj);
							} else {
								algunInvalidoDelete = true;
							}
							break;
						}
					}
				}
				if (algunInvalidoDelete) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_ADDCONCEPTO_invalidoAdd"));
				}
			}
		}
		rootPerfil = null;
		rootPerfil = createSsCheVistaSeguridadsLocal();
		// selectedNodePerfil= null;
	}
	
	/** CARGAR NODOS PRINCIPALES DEL ÁRBOL DEL PERFIL (EN EL EVENTO) */
	public TreeNode createSsCheVistaSeguridadsLocal() {
		rootPerfil = new DefaultTreeNode("Root", null);
		for (Vistaconceptoautoriza puntero : listaPerfilModuloReg) {
			if (verificaExisteNodo(puntero, listaPerfilUpdateReg)) {
				TreeNode node = new DefaultTreeNode(puntero, rootPerfil);
				node.setExpanded(true);
				createSubNodePerfilLocal(puntero, node);
			} else {

			}
		}
		return rootPerfil;
	}
	
	public boolean verificaExisteNodo(Vistaconceptoautoriza selectos, List<Vistaconceptoautoriza> listSelectos) {
		boolean valorBoolea = false;
		for (Vistaconceptoautoriza puntero : listSelectos) {
			if (("" + puntero.getAplicacioncodigo()).trim().equals((selectos.getAplicacioncodigo() + "").trim())
					&& ("" + puntero.getGrupo()).trim().equals((selectos.getGrupo() + "").trim())
					&& ("" + puntero.getConcepto()).trim().equals((selectos.getConcepto() + "").trim())) {
				valorBoolea = true;
				break;
			}
		}
		return valorBoolea;
	}
	
	/** CARGAR NODOS HIJOS DEL ÁRBOL DEL PERFIL (EN EL EVENTO) */
	public void createSubNodePerfilLocal(Vistaconceptoautoriza objSsCheVistaSeguridad, TreeNode node) {
		List<Vistaconceptoautoriza> lista = new ArrayList<Vistaconceptoautoriza>();
		// lista.addAll(listaPerfilOriginalReg);
		lista.addAll(listaPerfilUpdateReg);
		for (Vistaconceptoautoriza puntero : lista) {
			if (puntero.getConceptopadre() != null) {
				if ((puntero.getAplicacioncodigo() + "").trim()
						.equals((objSsCheVistaSeguridad.getAplicacioncodigo() + "").trim())
						&& (puntero.getGrupo() + "").trim().equals((objSsCheVistaSeguridad.getGrupo() + "").trim())
						&& puntero.getConceptopadre().trim()
								.equals((objSsCheVistaSeguridad.getConcepto() + "").trim())) {
					TreeNode subNode;
					if (TIPOO_CARPETA_db.equals(puntero.getTipodeobjeto())) {						
						subNode = new DefaultTreeNode("default", puntero, node);
						subNode.setExpanded(true);
						createSubNodePerfilLocal(puntero, subNode);
					} else if (TIPOO_ARCHIVO_db.equals(puntero.getTipodeobjeto())) {						
						subNode = new DefaultTreeNode("document", puntero, node);
						subNode.setExpanded(false);
						createSubNodePerfilLocal(puntero, subNode);
					} else {						
						subNode = new DefaultTreeNode("document", puntero, node);
						subNode.setExpanded(false);
						createSubNodePerfilLocal(puntero, subNode);
					}
				}
			}
		}
	}

	
	/** CARGAR NODOS PRINCIPALES DEL ÁRBOL PLANTILLA */
	public TreeNode createSsCheVistaSeguridads() {
		try {
			root = new DefaultTreeNode("Root", null);
			
//			Vistaconceptoautoriza seguridadConcepto = new Vistaconceptoautoriza();
//			seguridadConcepto.setAplicacioncodigo(Constant.APLICACION_CODIGO);
//			seguridadConcepto.setUsuario(Constant.USUARIO_ADMINSYS);
//			List<Vistaconceptoautoriza> lista = seguridadConceptoVistaService.SeguridadConceptoVistaLista(seguridadConcepto);
//			listaPerfilModuloReg.addAll(lista);
			
			/**Cargar grupo o conceptos Generales*/
			List<Vistaconceptoautoriza> lista = new ArrayList<Vistaconceptoautoriza>();
			Vistaconceptoautoriza objPermisos = new Vistaconceptoautoriza();
			objPermisos.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			objPermisos.setUsuario(Constant.USUARIO_ADMINSYS);
			
			objPermisos.setEstado(Constant.ACTIVO);
			objPermisos.setTipodeobjeto(TIPOO_CARPETA_db);
			// objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
			objPermisos.setVisibleflag(Constant.SI_db);
			// ANTERIOR QUE ERA DE TIPO TREE
			objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
			lista = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos);
			listaPerfilModuloReg.addAll(lista);
			
			
			/**
			 * OBS: CARGAR TODAS LAS OPCIONES EN UNA SOLA CONSULTA (para el
			 * WABMASTER)
			 **/

//			seguridadConcepto.setOpcionagregarflag("T");
//			seguridadConcepto.setXestado("P");
//			List<Vistaconceptoautoriza> listaAux = seguridadConceptoVistaService
//					.SeguridadConceptoVistaLista(seguridadConcepto);		
			
			List<Vistaconceptoautoriza> listaAux = new ArrayList<Vistaconceptoautoriza>();		
			objPermisos.setEstado(Constant.ACTIVO);			
			//objPermisos.setDescripcion(filtroNombre);		
			objPermisos.setVisibleflag(Constant.SI_db);
			//no incluir los grupos/carpetas
			objPermisos.setFlagConsultaEntGlobal("NO_IN_TIPODEOBJETO");
			objPermisos.setTipodeobjeto(TIPOO_CARPETA_db);			

			// ***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION
			// ANTERIOR QUE ERA DE TIPO TREE
			objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);	
			listaAux = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos);
			if (listaAux != null) {
				listaPerfilWebMasterReg.addAll(listaAux);
				listaPerfilWebMasterRegAux.addAll(listaAux);
			}

			/**********/
			for (Vistaconceptoautoriza puntero : lista) {
				TreeNode node = new DefaultTreeNode(puntero, root);
				//node.setExpanded(true);
				createSubNode(puntero, node, true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return root;
	}

	/** cargar NODOS HIJOS DEL ARBOL PLANTILLA */
	public void createSubNode(Vistaconceptoautoriza objSsCheVistaSeguridad, TreeNode node, boolean esPlantilla) {
		List<Vistaconceptoautoriza> lista = new ArrayList<Vistaconceptoautoriza>();
		// lista.addAll(listaPerfilOriginalReg);
		if (esPlantilla) {
			lista.addAll(listaPerfilWebMasterRegAux);
		} else {
			lista.addAll(listaPerfilOriginalRegAux);
		}

		for (Vistaconceptoautoriza puntero : lista) {
			if (puntero.getConceptopadre() != null) {
				if ((puntero.getAplicacioncodigo() + "").trim()
						.equals((objSsCheVistaSeguridad.getAplicacioncodigo() + "").trim())
						&& (puntero.getGrupo() + "").trim().equals((objSsCheVistaSeguridad.getGrupo() + "").trim())
						&& puntero.getConceptopadre().trim()
								.equals((objSsCheVistaSeguridad.getConcepto() + "").trim())) {
					TreeNode subNode;
					if (TIPOO_CARPETA_db.equals(puntero.getTipodeobjeto())) {
						subNode = new DefaultTreeNode("default", puntero, node);
						subNode.setExpanded(true);
						createSubNode(puntero, subNode, esPlantilla);
					} else if (TIPOO_ARCHIVO_db.equals(puntero.getTipodeobjeto())) {						
						subNode = new DefaultTreeNode("document", puntero, node);
						subNode.setExpanded(false);
						createSubNode(puntero, subNode, esPlantilla);
					} else {						
						subNode = new DefaultTreeNode("document", puntero, node);
						subNode.setExpanded(false);
						createSubNode(puntero, subNode, esPlantilla);
					}
				}
			}
		}
	}

	/** Generar Arbol de permisos por PERFIL
	 * @return
	 */
	public TreeNode createSsCheVistaSeguridadsPerfil() {
		rootPerfil = new DefaultTreeNode("Root", null);
		try {
			if(registro!=null && registro.getUsuario() !=null){
//				Vistaconceptoautoriza seguridadConcepto = new Vistaconceptoautoriza();
//				seguridadConcepto.setAplicacioncodigo(Constant.APLICACION_CODIGO);
//				seguridadConcepto.setXestado(Utiles.SI_db);
//				// seguridadConcepto.setGrupo(Utiles.MODULO);
//				seguridadConcepto.setUsuario(registro.getUsuario());
//				List<Vistaconceptoautoriza> lista = seguridadConceptoVistaService
//						.SeguridadConceptoVistaLista(seguridadConcepto);
				
				
				
				/**Cargar grupo o conceptos Generales*/
				List<Vistaconceptoautoriza> lista = new ArrayList<Vistaconceptoautoriza>();
				Vistaconceptoautoriza objPermisos = new Vistaconceptoautoriza();
				objPermisos.setAplicacioncodigo(Constant.APLICACION_CODIGO);
				objPermisos.setUsuario(registro.getUsuario());
				
				objPermisos.setEstado(Constant.ACTIVO);
				objPermisos.setTipodeobjeto(TIPOO_CARPETA_db);
				// objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
				objPermisos.setVisibleflag(Constant.SI_db);
				// ANTERIOR QUE ERA DE TIPO TREE
				objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
				lista = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos);
				
				listaPerfilOriginalReg.addAll(lista);				
				listaPerfilOriginalRegAux.addAll(lista);
				
				/**
				 * OBS: CARGAR TODAS LAS OPCIONES EN UNA SOLA CONSULTA (para el
				 * usaurio seleccionado)
				 **/
				
//				seguridadConcepto.setOpcionagregarflag("T");
//				seguridadConcepto.setXestado("P");
//				List<Vistaconceptoautoriza> listaAux = seguridadConceptoVistaService
//						.SeguridadConceptoVistaLista(seguridadConcepto);
//				List<Vistaconceptoautoriza> listaPerfil = new ArrayList<Vistaconceptoautoriza>();
//				
//				List<Vistaconceptoautoriza> listaAux = new ArrayList<Vistaconceptoautoriza>();
				
				List<Vistaconceptoautoriza> listaPerfil = new ArrayList<Vistaconceptoautoriza>();
				
				objPermisos.setEstado(Constant.ACTIVO);			
				//objPermisos.setDescripcion(filtroNombre);		
				objPermisos.setVisibleflag(Constant.SI_db);
				//no incluir los grupos/carpetas
				objPermisos.setFlagConsultaEntGlobal("NO_IN_TIPODEOBJETO");
				objPermisos.setTipodeobjeto(TIPOO_CARPETA_db);

				// ***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION
				// ANTERIOR QUE ERA DE TIPO TREE
				objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);	
				List<Vistaconceptoautoriza> listaAux = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos);
				
				/** ELIMINAR REPITICIONES */
				for (int i = 0; i < listaAux.size(); i++) {
					String key = (listaAux.get(i).getAplicacioncodigo() + "").trim()
							+ (listaAux.get(i).getGrupo() + "").trim() + (listaAux.get(i).getConcepto() + "").trim();

					boolean hallado = false;
					for (int j = 0; j < listaPerfil.size(); j++) {
						String keyPiv = (listaPerfil.get(j).getAplicacioncodigo() + "").trim()
								+ (listaPerfil.get(j).getGrupo() + "").trim() + (listaPerfil.get(j).getConcepto() + "").trim();

						if (keyPiv.equals(key)) {
							// listaPerfil.get(j).setOpcionopcion2Flag("");
							hallado = true;
							break;
						}
					}
					if(Utiles.NO_db.equals(getParametroElimnarFisico())){
						if(Utiles.ESTADO_ELIMINADO_db.equals(listaAux.get(i).getEstado())){
							hallado=true; //PARA NO MOSTRAR LOS ELIMINADOS LÓGICAMENTE
						}
					}				
					if (!hallado) {
						listaPerfil.add(listaAux.get(i));
					}
				}

				/***********************/
				listaPerfilOriginalReg.addAll(listaPerfil);
				listaPerfilOriginalRegAux.addAll(listaPerfil);

				/**********/
				for (Vistaconceptoautoriza puntero : lista) {
					TreeNode node = new DefaultTreeNode(puntero, rootPerfil);
					node.setExpanded(true);
					createSubNode(puntero, node, false);
	                if(node.getChildCount()<=0){                	
	                	listaPerfilOriginalReg.remove(puntero);
	                	listaPerfilOriginalRegAux.remove(puntero);
	                	rootPerfil.getChildren().remove(node);
	                }				
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rootPerfil;
	}
	
	
	/** METODO SECUNDARIO **/
	public List<Seguridadautorizaciones> getListaGuardar() {
		List<Seguridadautorizaciones> listaPerfilSaveReg = UtilesCommons.getNewList();
		
		/** EN CASO ELIMINE ALGUNOS ELEMENTOS DE LISTA  **/
		if (UtilesCommons.noEsVacio(listaPerfilDeleteReg)) {
			for (Vistaconceptoautoriza obj : listaPerfilDeleteReg) {				
				if (UtilesCommons.sonCadenasIguales(obj.getUsuario() ,registro.getUsuario())) {
					Seguridadautorizaciones objSave = new Seguridadautorizaciones();
					objSave.setAplicacioncodigo(obj.getAplicacioncodigo());
					objSave.setGrupo(obj.getGrupo());
					objSave.setConcepto(obj.getConcepto());										
					objSave.setUsuario(registro.getUsuario());
					objSave.setEstado(Constant.ELIMINADO);
					objSave.setUltimafechamodif(Utiles.obtenerTimestamp());
					objSave.setUltimousuario(getUSUARIO_ACTUAL());
					objSave.setUsuarioEntGlobal(getUSUARIO_ACTUAL());
					objSave.setAppCodigoEntGlobal(getAPP_CODIGO());
					objSave.setFechaAccionEntGlobal(Utiles.obtenerTimestamp());
					objSave.setAccion(Constant.DELETE_db);
					if(UtilesCommons.sonCadenasIguales(Constant.NO_db, getParametroElimnarFisico())){
						objSave.setAccion(Constant.UPDATE_db);	
					}			
					listaPerfilSaveReg.add(objSave);					
				}
			}
		}
		
		
		/** EN CASO INSERT O ACTUALICE ALGUNOS ELEMENTOS DE LISTA  **/
		if (UtilesCommons.noEsVacio(listaPerfilUpdateReg)) {
			for (Vistaconceptoautoriza obj : listaPerfilUpdateReg) {
				// SOLO SI E DE LA SELCCIÓN ACTUAL
				if (UtilesCommons.sonCadenasIguales(obj.getUsuario(), registro.getUsuario())) {									;
					if(UtilesCommons.sonCadenasIguales(Constant.INSERT_db , obj.getAccion())){
						Seguridadautorizaciones objSave = new Seguridadautorizaciones();
					 	objSave.setAplicacioncodigo(obj.getAplicacioncodigo());
						objSave.setGrupo(obj.getGrupo());
						objSave.setConcepto(obj.getConcepto());
						objSave.setUsuario(registro.getUsuario());
		  				//ASEGURARSE REPETICIONES
		  				boolean hallado = false;
		  				for(Seguridadautorizaciones objTrace: listaPerfilSaveReg){
		  					if(UtilesCommons.sonCadenasIguales(objSave.getAplicacioncodigo(),objTrace.getAplicacioncodigo())
		  						&& UtilesCommons.sonCadenasIguales(objSave.getGrupo(),objTrace.getGrupo())
		  						&& UtilesCommons.sonCadenasIguales(objSave.getConcepto(),objTrace.getConcepto())
		  						&& UtilesCommons.sonCadenasIguales(objSave.getUsuario(),objTrace.getUsuario())
		  					){
		  						//ES IGUAL, YA EXISTE
		  						hallado = true;
		  						objTrace.setAplicacioncodigo(obj.getAplicacioncodigo());
		  						objTrace.setGrupo(obj.getGrupo());
		  						objTrace.setConcepto(obj.getConcepto());
		  						objTrace.setUsuario(registro.getUsuario());
		  						objTrace.setEstado(Constant.ACTIVO);
		  						objTrace.setUltimafechamodif(new Date());
		  						objTrace.setUltimousuario(getUSUARIO_ACTUAL());						
										  								  						
		  					}
		  				}
		  				if(!hallado){
							objSave.setEstado(Constant.ACTIVO);
							objSave.setUltimafechamodif(Utiles.obtenerTimestamp());
							objSave.setUltimousuario(getUSUARIO_ACTUAL());								  					
		  					listaPerfilSaveReg.add(objSave);
		  				}
  	  				}										
				}
			}
		}
		
		return listaPerfilSaveReg;
	}
	
	/******* GETTERS AND SETTERS *******/
	 
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public SeguridadConceptoVistaService getSeguridadConceptoVistaService() {
		return seguridadConceptoVistaService;
	}

	public void setSeguridadConceptoVistaService(SeguridadConceptoVistaService seguridadConceptoVistaService) {
		this.seguridadConceptoVistaService = seguridadConceptoVistaService;
	}

	public SeguridadautorizacionesService getSeguridadautorizacionesService() {
		return seguridadautorizacionesService;
	}

	public void setSeguridadautorizacionesService(SeguridadautorizacionesService seguridadautorizacionesService) {
		this.seguridadautorizacionesService = seguridadautorizacionesService;
	}

	public SeguridadautorizacionesService getSeguridadAutorizacionesService() {
		return seguridadAutorizacionesService;
	}

	public void setSeguridadAutorizacionesService(SeguridadautorizacionesService seguridadAutorizacionesService) {
		this.seguridadAutorizacionesService = seguridadAutorizacionesService;
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

	public List<Vistaconceptoautoriza> getListaPerfilModuloReg() {
		return listaPerfilModuloReg;
	}

	public void setListaPerfilModuloReg(List<Vistaconceptoautoriza> listaPerfilModuloReg) {
		this.listaPerfilModuloReg = listaPerfilModuloReg;
	}

	public List<Vistaconceptoautoriza> getListaPerfilOriginalReg() {
		return listaPerfilOriginalReg;
	}

	public void setListaPerfilOriginalReg(List<Vistaconceptoautoriza> listaPerfilOriginalReg) {
		this.listaPerfilOriginalReg = listaPerfilOriginalReg;
	}

	public List<Vistaconceptoautoriza> getListaPerfilOriginalRegAux() {
		return listaPerfilOriginalRegAux;
	}

	public void setListaPerfilOriginalRegAux(List<Vistaconceptoautoriza> listaPerfilOriginalRegAux) {
		this.listaPerfilOriginalRegAux = listaPerfilOriginalRegAux;
	}

	public List<Vistaconceptoautoriza> getListaPerfilUpdateReg() {
		return listaPerfilUpdateReg;
	}

	public void setListaPerfilUpdateReg(List<Vistaconceptoautoriza> listaPerfilUpdateReg) {
		this.listaPerfilUpdateReg = listaPerfilUpdateReg;
	}

	public List<Vistaconceptoautoriza> getListaPerfilDeleteReg() {
		return listaPerfilDeleteReg;
	}

	public void setListaPerfilDeleteReg(List<Vistaconceptoautoriza> listaPerfilDeleteReg) {
		this.listaPerfilDeleteReg = listaPerfilDeleteReg;
	}

	public List<Seguridadautorizaciones> getListaPerfilSaveReg() {
		return listaPerfilSaveReg;
	}

	public void setListaPerfilSaveReg(List<Seguridadautorizaciones> listaPerfilSaveReg) {
		this.listaPerfilSaveReg = listaPerfilSaveReg;
	}

	public List<Vistaconceptoautoriza> getListaPerfilWebMasterReg() {
		return listaPerfilWebMasterReg;
	}

	public void setListaPerfilWebMasterReg(List<Vistaconceptoautoriza> listaPerfilWebMasterReg) {
		this.listaPerfilWebMasterReg = listaPerfilWebMasterReg;
	}

	public List<Vistaconceptoautoriza> getListaPerfilWebMasterRegAux() {
		return listaPerfilWebMasterRegAux;
	}

	public void setListaPerfilWebMasterRegAux(List<Vistaconceptoautoriza> listaPerfilWebMasterRegAux) {
		this.listaPerfilWebMasterRegAux = listaPerfilWebMasterRegAux;
	}

	public TreeNode[] getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode[] selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode[] getSelectedNodePerfil() {
		return selectedNodePerfil;
	}

	public void setSelectedNodePerfil(TreeNode[] selectedNodePerfil) {
		this.selectedNodePerfil = selectedNodePerfil;
	}

	public TreeNode getRootPerfil() {
		return rootPerfil;
	}

	public void setRootPerfil(TreeNode rootPerfil) {
		this.rootPerfil = rootPerfil;
	}

	public String getTIPOO_OBJETO_db() {
		return TIPOO_OBJETO_db;
	}

	public void setTIPOO_OBJETO_db(String tIPOO_OBJETO_db) {
		TIPOO_OBJETO_db = tIPOO_OBJETO_db;
	}

	public String getTIPOO_CARPETA_db() {
		return TIPOO_CARPETA_db;
	}

	public void setTIPOO_CARPETA_db(String tIPOO_CARPETA_db) {
		TIPOO_CARPETA_db = tIPOO_CARPETA_db;
	}

	public String getTIPOO_ARCHIVO_db() {
		return TIPOO_ARCHIVO_db;
	}

	public void setTIPOO_ARCHIVO_db(String tIPOO_ARCHIVO_db) {
		TIPOO_ARCHIVO_db = tIPOO_ARCHIVO_db;
	}

	public boolean isBtnAgregarVisible() {
		return btnAgregarVisible;
	}

	public void setBtnAgregarVisible(boolean btnAgregarVisible) {
		this.btnAgregarVisible = btnAgregarVisible;
	}

	public boolean isBtnQuitarVisible() {
		return btnQuitarVisible;
	}

	public void setBtnQuitarVisible(boolean btnQuitarVisible) {
		this.btnQuitarVisible = btnQuitarVisible;
	}

	public SeguridadautorizacionesService getSeguridadAutorizacioneService() {
		return seguridadAutorizacioneService;
	}

	public void setSeguridadAutorizacioneService(SeguridadautorizacionesService seguridadAutorizacioneService) {
		this.seguridadAutorizacioneService = seguridadAutorizacioneService;
	}

	public String getTipooObjetoDb() {
		return TIPOO_OBJETO_db;
	}

	public String getTipooCarpetaDb() {
		return TIPOO_CARPETA_db;
	}

	public String getTipooArchivoDb() {
		return TIPOO_ARCHIVO_db;
	}

}
