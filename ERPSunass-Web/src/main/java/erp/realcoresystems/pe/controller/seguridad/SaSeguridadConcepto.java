package erp.realcoresystems.pe.controller.seguridad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.model.util.FacesUtil;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;
import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;
import erp.realcoresystems.pe.service.SeguridadConceptoService;
import erp.realcoresystems.pe.service.SeguridadGrupoService;
import erp.realcoresystems.pe.service.SeguridadautorizacionesService;
import erp.realcoresystems.pe.model.util.Constant;


@ManagedBean(name = "saSeguridadConcepto")
@ViewScoped
public class SaSeguridadConcepto extends AbstractGenericBean implements InterfaceGenericBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7513510350006933679L;

	public String TIPOO_OBJETO_db = "O";
	public String TIPOO_CARPETA_db = "C";
	public String TIPOO_ARCHIVO_db = "A";
	
	public static final String ICON_DIRECTORIO = "icon-desktop";
	public static final String ICON_ARCHIVO_MENU = "fa fa-circle-o";
	public static final String ICON_OPERACION_MENU = "fa fa-cog";
	
	public static final String URL_PARCIAL = "/vistas/sa";
	
	
	
	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadAutorizacioneService;
	
	
	@ManagedProperty(value = "#{seguridadConceptoService}")
	private SeguridadConceptoService seguridadConceptoService;
	
	
	@ManagedProperty(value = "#{seguridadGrupoService}")
	private SeguridadGrupoService seguridadGrupoService;
	
	private List<Seguridadgrupo> listaSeguridadGrupo = new ArrayList<Seguridadgrupo>();
	
	private List<Vistaconceptoautoriza> listaPerfilWebMasterRegAux = new ArrayList<Vistaconceptoautoriza>();
	private TreeNode root;
	private TreeNode selectedNode;
	
	private Vistaconceptoautoriza objPermisoPadreSeleccion;
	
	private Seguridadconcepto objPermisoRegistro;
	
	
	private Seguridadconcepto objCopiaActual;
	private Vistaconceptoautoriza objPermisoSeleccion;
	private Vistaconceptoautoriza objPermisoFiltro;
	
	/**copiar pegar*/
	private boolean validoCopiar;
	private boolean validoPegar;
	
	@PostConstruct
	public void inicializar() {
		super.initComponentes();		
		objPermisoRegistro = new Seguridadconcepto();
		objPermisoSeleccion = new Vistaconceptoautoriza();
		objPermisoPadreSeleccion = new Vistaconceptoautoriza();
		
		objCopiaActual = new Seguridadconcepto();
		
		
		//default
		validoCopiar = false;
		validoPegar = false;
		
		objPermisoFiltro = new Vistaconceptoautoriza();		
		objPermisoFiltro.setVisibleflag(Constant.SI_db);
		btnBuscar();
	}

	
	
	
	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		if(objPermisoFiltro ==null ){
			objPermisoFiltro = new Vistaconceptoautoriza();
		}
		objPermisoFiltro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		objPermisoFiltro.setUsuario(Constant.USUARIO_ADMINSYS);			
		objPermisoFiltro.setEstado(Constant.ACTIVO);		
		
		//objPermisoFiltro.setVisibleflag(Constant.SI_db);
		// ANTERIOR QUE ERA DE TIPO TREE
		objPermisoFiltro.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
		//ORDENAR
		objPermisoFiltro.setOrdernable(true);
		objPermisoFiltro.setAtributoOrdenacion("orden");
		
	}

	@Override
	public void btnBuscar() {
		listaPerfilWebMasterRegAux = new ArrayList<Vistaconceptoautoriza>();
		cargarObjetoFiltros(0,0,0);
		root = createSsCheVistaSeguridads();	
		
	}

	/** validar antes de guardar
	 * @param registro
	 * @return
	 */
	public boolean validarFormulario(Seguridadconcepto registro) {
		boolean valida = true;
		if (UtilesCommons.esVacio(registro.getDescripcion())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISOPERFIL_REQ_CONCEPTO"));
			valida = false;
		}
		
		if (UtilesCommons.esVacio(registro.getDescripcion())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISOPERFIL_REQ_DESCRIPCION"));
			valida = false;
		}
		if (UtilesCommons.esVacio(registro.getGrupo())) {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISOPERFIL_REQ_GRUPO"));
			valida = false;
		}
		//Validar repeticion de Codigo concepto
		if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
			Seguridadconcepto objFiltro = new Seguridadconcepto ();
			objFiltro.setAplicacioncodigo(registro.getAplicacioncodigo());
			objFiltro.setGrupo(registro.getGrupo());
			objFiltro.setConcepto(registro.getConcepto());
			Seguridadconcepto objConcepto =  seguridadConceptoService.obtenerPorId(objFiltro);
			if(objConcepto!=null){
				//entonces existe otro igual
				valida = false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARNING_PERMISOPERFIL_CONCEPTO_REPETIDO"));
			}
		}
		
		
		return valida;
	}
	
	@Override
	public void btnGuardar() {
		if (validarFormulario(objPermisoRegistro)) {
			int result = 0;
			objPermisoRegistro.setUltimafechamodif(new Date());
			if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
				if(UtilesCommons.esVacio(objPermisoRegistro.getConceptopadre()) &&
						TIPOO_CARPETA_db.equals(objPermisoRegistro.getTipodeobjeto())){
					objPermisoRegistro.setConceptopadre(objPermisoRegistro.getGrupo());
				}				
				result = seguridadConceptoService.guardar(objPermisoRegistro);
				if(result>0){
					//Agregar al PERFIL MASTER-plantilla
					agregarPermisoPerfil(objPermisoRegistro, Constant.USUARIO_ADMINSYS);					
				}
			}else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)){
				result = seguridadConceptoService.actualizar(objPermisoRegistro);
			}else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)){
				objPermisoRegistro.setVisibleflag(Constant.NO_db);
				result = seguridadConceptoService.actualizar(objPermisoRegistro);
			}else if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_DELETE)){
				result = seguridadConceptoService.eliminar(objPermisoRegistro);
			}	
			
			if(result > 0){
				btnAceptar();
				btnBuscar();
				FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
			}
			else{
				FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
			}	
		}
	}

	
	/** guardar un Permiso para un determinado perfil por defecto 
	 * @param seguridadPermiso
	 * @param perfil
	 */
	public void agregarPermisoPerfil(Seguridadconcepto seguridadPermiso, String perfil) {
		
		Seguridadautorizaciones objSave = new Seguridadautorizaciones();
		objSave.setAplicacioncodigo(seguridadPermiso.getAplicacioncodigo());
		objSave.setGrupo(seguridadPermiso.getGrupo());
		objSave.setConcepto(seguridadPermiso.getConcepto());
		objSave.setUsuario(perfil);
		objSave.setEstado(Constant.ACTIVO);
		objSave.setUltimousuario(getUSUARIO_ACTUAL());
		objSave.setUltimafechamodif(new Date());
		
		seguridadAutorizacioneService.guardar(objSave);
	}
	
	
	@Override
	public void btnAceptar() {
		objPermisoRegistro = new Seguridadconcepto();
		objPermisoSeleccion = new Vistaconceptoautoriza();
		objPermisoPadreSeleccion = new Vistaconceptoautoriza();		
		visibleRegistro = false;
		
	}

	@Override
	public void btnCancelar() {
		objPermisoRegistro = new Seguridadconcepto();
		objPermisoSeleccion = new Vistaconceptoautoriza();
		objPermisoPadreSeleccion = new Vistaconceptoautoriza();
		visibleRegistro = false;
	}

	@Override
	public void btnNuevo() {
		//Nuevo			
		objPermisoSeleccion = new Vistaconceptoautoriza();
		objPermisoPadreSeleccion = new Vistaconceptoautoriza();
		
		objPermisoRegistro = new Seguridadconcepto();
		objPermisoRegistro.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
		objPermisoRegistro.setWebflag(Constant.SI_db);
		objPermisoRegistro.setUltimousuario(getUSUARIO_ACTUAL());
		objPermisoRegistro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		objPermisoRegistro.setGrupo(null);
		objPermisoRegistro.setConceptopadre(null);
		objPermisoRegistro.setObjetowindow(ICON_DIRECTORIO);
		objPermisoRegistro.setTipodeobjeto(TIPOO_CARPETA_db);
		objPermisoRegistro.setVisibleflag(Constant.SI_db);
		
		MODO_ACTUAL = MODO_NEW;
		abrirRegistro();
	}

	
	public void btnNuevoHijo() {
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
//			if(selectedNode.getParent()!=null){				
//				if(selectedNode.getParent() instanceof Vistaconceptoautoriza){
//					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
//				}
//			}							
			
			//Sobre seleccion
			objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();			
			objPermisoPadreSeleccion = objPermisoSeleccion;
			
			objPermisoRegistro = new Seguridadconcepto();
			objPermisoRegistro.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
			objPermisoRegistro.setWebflag(Constant.SI_db);
			objPermisoRegistro.setUltimousuario(getUSUARIO_ACTUAL());
			if(TIPOO_CARPETA_db.equals((""+objPermisoSeleccion.getTipodeobjeto()).trim())){				
				objPermisoRegistro.setTipodeobjeto(TIPOO_ARCHIVO_db);
				objPermisoRegistro.setObjetowindow(ICON_ARCHIVO_MENU);
			}else if(TIPOO_ARCHIVO_db.equals((""+objPermisoSeleccion.getTipodeobjeto()).trim())){
				objPermisoRegistro.setTipodeobjeto(TIPOO_OBJETO_db);
				objPermisoRegistro.setObjetowindow(ICON_OPERACION_MENU);
			}
			objPermisoRegistro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
			objPermisoRegistro.setGrupo(objPermisoSeleccion.getGrupo());
			objPermisoRegistro.setConceptopadre(objPermisoSeleccion.getConcepto());
			objPermisoRegistro.setVisibleflag(Constant.SI_db);
			
			
			MODO_ACTUAL = MODO_NEW;
			abrirRegistro();
		}else{
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));			
		}
	}
	@Override
	public void btnModificar() {
		
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
			if(selectedNode.getParent()!=null){
				if(selectedNode.getParent().getData() instanceof Vistaconceptoautoriza){
					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
				}				
			}	
			
			
			objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();
			
			Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
			conceptoFiltro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
			conceptoFiltro.setGrupo(objPermisoSeleccion.getGrupo());
			conceptoFiltro.setConcepto(objPermisoSeleccion.getConcepto());
			objPermisoRegistro = seguridadConceptoService.obtenerPorId(conceptoFiltro);
		
			MODO_ACTUAL = MODO_UPDATE;
			abrirRegistro();
		}else{
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}

		
	}

	@Override
	public void btnVer() {
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
			if(selectedNode.getParent()!=null){
				if(selectedNode.getParent().getData() instanceof Vistaconceptoautoriza){
					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
				}
			}	
			
			objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();
			
			Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
			conceptoFiltro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
			conceptoFiltro.setGrupo(objPermisoSeleccion.getGrupo());
			conceptoFiltro.setConcepto(objPermisoSeleccion.getConcepto());
			objPermisoRegistro = seguridadConceptoService.obtenerPorId(conceptoFiltro);
		
			MODO_ACTUAL = MODO_VIEW;
			abrirRegistro();
		}else{
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnEliminar() {
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
			if(selectedNode.getParent()!=null){
				if(selectedNode.getParent().getData() instanceof Vistaconceptoautoriza){
					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
				}
			}	
			
			objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();
			
			Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
			conceptoFiltro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
			conceptoFiltro.setGrupo(objPermisoSeleccion.getGrupo());
			conceptoFiltro.setConcepto(objPermisoSeleccion.getConcepto());
			objPermisoRegistro = seguridadConceptoService.obtenerPorId(conceptoFiltro);
		
			MODO_ACTUAL = MODO_DELETE;
			abrirRegistro();
		}else{
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	
	public void btnInactivar() {
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
			if(selectedNode.getParent()!=null){
				if(selectedNode.getParent().getData() instanceof Vistaconceptoautoriza){
					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
				}
			}	
			
			objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();
			
			Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
			conceptoFiltro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
			conceptoFiltro.setGrupo(objPermisoSeleccion.getGrupo());
			conceptoFiltro.setConcepto(objPermisoSeleccion.getConcepto());
			objPermisoRegistro = seguridadConceptoService.obtenerPorId(conceptoFiltro);
		
			MODO_ACTUAL = MODO_INACTIVAR;
			abrirRegistro();
		}else{
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}
	
	/**
	 * copiar un item del menú
	 */
	public void btnCopiar() {
		if (selectedNode != null && selectedNode.getData()!=null) {
			//Sobre el padre (Si hubiere)
			if(selectedNode.getParent()!=null){
				if(selectedNode.getParent().getData() instanceof Vistaconceptoautoriza){
					objPermisoPadreSeleccion = 	(Vistaconceptoautoriza)selectedNode.getParent().getData();	
				}
			}	
			if(selectedNode.getData() instanceof Vistaconceptoautoriza){
				objPermisoSeleccion = (Vistaconceptoautoriza) selectedNode.getData();
				
				Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
				conceptoFiltro.setAplicacioncodigo(objPermisoSeleccion.getAplicacioncodigo());
				conceptoFiltro.setGrupo(objPermisoSeleccion.getGrupo());
				conceptoFiltro.setConcepto(objPermisoSeleccion.getConcepto());
				objCopiaActual = seguridadConceptoService.obtenerPorId(conceptoFiltro);																	
			}

		}
		
	}	

	/**
	 * copiar un item del menú
	 */
	public void btnPegar() {	
		if(objCopiaActual!=null && objCopiaActual.getConcepto()!=null){
			//inicializar nuevo hijo
			btnNuevoHijo();
			if(objPermisoRegistro!=null){													
				//validar duplicidad de CONCEPTOS ...
				objPermisoRegistro.setConcepto(objCopiaActual.getConcepto());		
				boolean codigoConceptoValido = false;				
				//OBS***** Por errores X, no permitir que se convierta en un Bucle infinito....
				int maxIntentos = 10;
				int countIntentos = 0;				
				while(!codigoConceptoValido && countIntentos < maxIntentos){
					//validar				
					Seguridadconcepto conceptoFiltro = new Seguridadconcepto();			
					conceptoFiltro.setAplicacioncodigo(objPermisoRegistro.getAplicacioncodigo());
					conceptoFiltro.setGrupo(objPermisoRegistro.getGrupo());
					conceptoFiltro.setConcepto(objPermisoRegistro.getConcepto());
					Seguridadconcepto objPermisoValidacion = seguridadConceptoService.obtenerPorId(conceptoFiltro);
					if(objPermisoValidacion!=null && objPermisoValidacion.getConcepto() !=null){
						//Existe ---CODIGO DE CONCEPTO INVALIDO... repetirlo
						codigoConceptoValido = false;
						int random = UtilesCommons.getIntRandomLongitud(5);
						objPermisoRegistro.setConcepto("M"+random);						
					}else{
						codigoConceptoValido = true;
					}
					countIntentos++;
				}
				//set valores PK del concepto Registro construido				
				
				objCopiaActual.setUltimousuario(objPermisoRegistro.getUltimousuario());
				objCopiaActual.setAplicacioncodigo(objPermisoRegistro.getAplicacioncodigo());
				objCopiaActual.setGrupo(objPermisoRegistro.getGrupo());
				objCopiaActual.setConceptopadre(objPermisoRegistro.getConceptopadre());
				objCopiaActual.setConcepto(objPermisoRegistro.getConcepto());
				objCopiaActual.setVisibleflag(Constant.SI_db);		
				//referenciar  el concepto registro (A guardar) con el concepto COPIADO
				objPermisoRegistro = objCopiaActual;
				MODO_ACTUAL = MODO_NEW;
				//guardar ...
				btnGuardar();				
			}
		}
	}	

	/** evento al seleccionar el treetable
	 * @param event
	 */
	public void eventoTreeSeleccion(NodeSelectEvent event) {
		if(event.getTreeNode()!=null && event.getTreeNode().getData()!=null){
			if(event.getTreeNode().getData() instanceof Vistaconceptoautoriza){
				Vistaconceptoautoriza seleccionTemp = (Vistaconceptoautoriza) event.getTreeNode().getData();
				if(TIPOO_CARPETA_db.equals(seleccionTemp.getTipodeobjeto())){
					validoCopiar=false;	
				}else{
					validoCopiar=true;
				}						
				
				if(objCopiaActual!=null && objCopiaActual.getConcepto()!=null){
					if(TIPOO_CARPETA_db.equals(seleccionTemp.getTipodeobjeto()) && 
							TIPOO_ARCHIVO_db.equals(objCopiaActual.getTipodeobjeto())){
						validoPegar=true;
					}else if(TIPOO_ARCHIVO_db.equals(seleccionTemp.getTipodeobjeto()) && 
							TIPOO_OBJETO_db.equals(objCopiaActual.getTipodeobjeto())){
						validoPegar=true;
					}else{
						validoPegar=false;
					}						
				}else{
					validoPegar=false;
				}
			}						
		}
	}
	

	@Override
	public void abrirRegistro() {	
		cargarGrupos();		
		setAtributosWindowsRegistro(MODO_ACTUAL);
	}	
	
	/**
	 * listar grupos seguridad
	 */
	public void cargarGrupos(){
		listaSeguridadGrupo = new ArrayList<Seguridadgrupo>();
		Seguridadgrupo filtro = new Seguridadgrupo();
		filtro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		listaSeguridadGrupo = seguridadGrupoService.listarCombo(filtro);
	}
	
	/** CARGAR NODOS PRINCIPALES DEL ÁRBOL PLANTILLA */
	public TreeNode createSsCheVistaSeguridads() {
		try {
			root = new DefaultTreeNode("Root", null);

			/**Cargar grupo o conceptos Generales*/
			List<Vistaconceptoautoriza> lista = new ArrayList<Vistaconceptoautoriza>();			
			objPermisoFiltro.setFlagConsultaEntGlobal(null);
			objPermisoFiltro.setTipodeobjeto(TIPOO_CARPETA_db);
			lista = seguridadAutorizacioneService.listarPermisosUsuario(objPermisoFiltro);
			//listaPerfilWebMasterRegAux.addAll(lista);
			
			
			/**
			 * OBS: CARGAR TODAS LAS OPCIONES EN UNA SOLA CONSULTA (para el
			 * WABMASTER)
			 **/

			List<Vistaconceptoautoriza> listaAux = new ArrayList<Vistaconceptoautoriza>();
			
			//no incluir los grupos/carpetas
			objPermisoFiltro.setFlagConsultaEntGlobal("NO_IN_TIPODEOBJETO");
			objPermisoFiltro.setTipodeobjeto(TIPOO_CARPETA_db);			

			// ***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION
			// ANTERIOR QUE ERA DE TIPO TREE
			//objPermisoFiltro.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);		
			listaAux = seguridadAutorizacioneService.listarPermisosUsuario(objPermisoFiltro);
			if (listaAux != null) {				
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


	public List<Vistaconceptoautoriza> getListaPerfilWebMasterRegAux() {
		return listaPerfilWebMasterRegAux;
	}




	public void setListaPerfilWebMasterRegAux(List<Vistaconceptoautoriza> listaPerfilWebMasterRegAux) {
		this.listaPerfilWebMasterRegAux = listaPerfilWebMasterRegAux;
	}




	public TreeNode getRoot() {
		return root;
	}




	public void setRoot(TreeNode root) {
		this.root = root;
	}




	public void setSeguridadAutorizacioneService(SeguridadautorizacionesService seguridadAutorizacioneService) {
		this.seguridadAutorizacioneService = seguridadAutorizacioneService;
	}


	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}


	public Seguridadconcepto getObjPermisoRegistro() {
		return objPermisoRegistro;
	}




	public void setObjPermisoRegistro(Seguridadconcepto objPermisoRegistro) {
		this.objPermisoRegistro = objPermisoRegistro;
	}




	public Vistaconceptoautoriza getObjPermisoFiltro() {
		return objPermisoFiltro;
	}




	public void setObjPermisoFiltro(Vistaconceptoautoriza objPermisoFiltro) {
		this.objPermisoFiltro = objPermisoFiltro;
	}


	public Vistaconceptoautoriza getObjPermisoSeleccion() {
		return objPermisoSeleccion;
	}

	public void setObjPermisoSeleccion(Vistaconceptoautoriza objPermisoSeleccion) {
		this.objPermisoSeleccion = objPermisoSeleccion;
	}


	public void setSeguridadConceptoService(SeguridadConceptoService seguridadConceptoService) {
		this.seguridadConceptoService = seguridadConceptoService;
	}




	public void setSeguridadGrupoService(SeguridadGrupoService seguridadGrupoService) {
		this.seguridadGrupoService = seguridadGrupoService;
	}




	public List<Seguridadgrupo> getListaSeguridadGrupo() {
		return listaSeguridadGrupo;
	}




	public void setListaSeguridadGrupo(List<Seguridadgrupo> listaSeguridadGrupo) {
		this.listaSeguridadGrupo = listaSeguridadGrupo;
	}




	public Vistaconceptoautoriza getObjPermisoPadreSeleccion() {
		return objPermisoPadreSeleccion;
	}




	public void setObjPermisoPadreSeleccion(Vistaconceptoautoriza objPermisoPadreSeleccion) {
		this.objPermisoPadreSeleccion = objPermisoPadreSeleccion;
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




	public Seguridadconcepto getObjCopiaActual() {
		return objCopiaActual;
	}




	public void setObjCopiaActual(Seguridadconcepto objCopiaActual) {
		this.objCopiaActual = objCopiaActual;
	}




	public boolean isValidoCopiar() {
		return validoCopiar;
	}




	public void setValidoCopiar(boolean validoCopiar) {
		this.validoCopiar = validoCopiar;
	}




	public boolean isValidoPegar() {
		return validoPegar;
	}




	public void setValidoPegar(boolean validoPegar) {
		this.validoPegar = validoPegar;
	}
	
	
}
