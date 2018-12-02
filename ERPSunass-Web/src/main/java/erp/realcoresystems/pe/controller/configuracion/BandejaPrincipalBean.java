package erp.realcoresystems.pe.controller.configuracion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import erp.realcoresystems.pe.commons.UtilesCommons;

import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;
import erp.realcoresystems.pe.security.VwSeguridadautorizacione;
import erp.realcoresystems.pe.server.EntityGlobal;
//import erp.realcoresystems.pe.service.CompanyownerService;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.service.SeguridadautorizacionesService;
import erp.realcoresystems.pe.model.util.Constant;

/**
 * @author araucoj
 *
 */
@ManagedBean
@ViewScoped
public class BandejaPrincipalBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String URL_PORTAL_INDEX = FacesUtil.getPropertyParametros("PAR_PAGINA_PORTALINDEX");
	// private static String FORM_URL_DEFAULT =
	// "../modulos/paginaDefault.xhtml";
	// private static String URL_BANDEJA_INICIO =
	// "../../login.xhtml?faces-redirect=true";



	public static final String URL_INTRODUCCION = "/vistas/encuestaExtra/IntroduccionEncuesta.jsf";
	public static final String URL_MENU_MAIN = "/vistas/inicio/menu_main.xhtml";

	@ManagedProperty(value = "#{seguridadautorizacionesService}")
	private SeguridadautorizacionesService seguridadAutorizacioneService;
	
	// @ManagedProperty(value = "#{companyownerService}")
	// CompanyownerService companyownerService;

	/** variables MENU */

	public String TIPOO_OBJETO_db = "O";
	public String TIPOO_CARPETA_db = "C";
	public String TIPOO_ARCHIVO_db = "A";

	private List<VwSeguridadautorizacione> listaPermisos = new ArrayList<VwSeguridadautorizacione>();
	private List<VwSeguridadautorizacione> listaGruposPermisosGen = null;

	private String conceptoDescActual;
	private String conceptoActual;
	private String conceptoPadreActual;
	private String grupoActual;
	private String urlActual;

	private String appCodigoActual;

	private String conceptoDescSysDefault;
	private String conceptoSysDefault;
	private String grupoSysDefault;
	private String urlSysDefault;

	private String nombreOpcionFiltro;
	// private boolean indicaMenuCollapsed;
	private String separadorParam = ":@:";

	private Map<String, String> mapSubMenuDisplay;
	private String actualSubMenuDisplay;

	/********/

	/*** Variables EXTRA *****/

	private String menuActual;

	public void cargarFiltroCombosBienesRecursos() {

	}

	@PostConstruct
	public void inicializar() {
		actualSubMenuDisplay = "";
		mapSubMenuDisplay = new HashMap<String, String>();
		nombreOpcionFiltro = null;
		this.appCodigoActual = (EntityGlobal.getInstance().getAplicacionCodigoActual() + "").trim();
		this.grupoActual = ("" + EntityGlobal.getInstance().getGrupoActual()).trim();
		this.conceptoActual = ("" + EntityGlobal.getInstance().getConceptoActual()).trim();
		eventoCargarPermisosMenu();
	}

	/**
	 * Cargar los permisos para el MENU
	 */
	public void eventoCargarPermisosMenu() {

		listaPermisos = new ArrayList<VwSeguridadautorizacione>();
		try {
			actualSubMenuDisplay = "";
			List<VwSeguridadautorizacione> listaOpcPermisos = new ArrayList<VwSeguridadautorizacione>();
			List<VwSeguridadautorizacione> listaGrupoPermisosTemp = obtenerGruposPermisosMenu();
			if (UtilesCommons.noEsVacio(listaGrupoPermisosTemp)) {
				listaPermisos.addAll(listaGrupoPermisosTemp);				
			}
			if (EntityGlobal.getInstance().getConceptoPadreActual() != null
					&& EntityGlobal.getInstance().getGrupoActual() != null) {
				// ABRIMOS EL GRUPO ACTUAL
				listaOpcPermisos = obtenerOpcionesPermisosMenu(nombreOpcionFiltro,
						EntityGlobal.getInstance().getGrupoActual(),
						EntityGlobal.getInstance().getConceptoPadreActual());
				
				if (UtilesCommons.noEsVacio(listaOpcPermisos)) {					
					actualSubMenuDisplay = EntityGlobal.getInstance().getGrupoActual() + separadorParam
							+ EntityGlobal.getInstance().getConceptoPadreActual();
					/**filtrar GRUPOS*/								
//					listaGrupoPermisosTemp = filtrarGruposPermisosMenu(listaGrupoPermisosTemp,listaOpcPermisos);
//					if (UtilesCommons.noEsVacio(listaGrupoPermisosTemp)) {
//						//listaPermisos.addAll(listaGrupoPermisosTemp);
//						listaPermisos.addAll(listaOpcPermisos);
//					}
					listaPermisos.addAll(listaOpcPermisos);
					/************/					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	/**
	 * Obtiene la lista de Permisos , pero del tipo de objeto 'C', que son las
	 * carpetas agrupadoras
	 * 
	 * @return
	 */
	public List<VwSeguridadautorizacione> filtrarGruposPermisosMenu(
			List<VwSeguridadautorizacione> listaGruposOpcionesMenu ,List<VwSeguridadautorizacione> listaOpcionesMenu ) {
		List<VwSeguridadautorizacione> listaFiltrada = listaGruposOpcionesMenu;
		if(UtilesCommons.noEsVacio(listaGruposOpcionesMenu)){
			/**SOLO FILTRAR aquellos GRUPOS que estan INCLUIDOS en la LISTA DE MENU DE OPCIONES */
			listaFiltrada =	listaGruposOpcionesMenu.stream()
					.filter(pGrupoMenu -> listaOpcionesMenu.stream()
										.anyMatch( pOpcionMenu -> pOpcionMenu.getGrupo().equals(pGrupoMenu.getGrupo()) )
							).collect(Collectors.toList());
		}
		 				
		return listaFiltrada;
		//return MenuPrincipalEstaticoBean.obtenerGruposPermisosMenuEstatic();
	}
	
	/**
	 * Obtiene la lista de Permisos , pero del tipo de objeto 'C', que son las
	 * carpetas agrupadoras
	 * 
	 * @return
	 */
	public List<VwSeguridadautorizacione> obtenerGruposPermisosMenu() {
		//return obtenerGruposPermisosMenuDB();
		return MenuPrincipalEstaticoBean.obtenerGruposPermisosMenuEstatic();
	}

	/**
	 * Obtiene la lista de Permisos , pero del tipo de objeto 'C', que son las
	 * carpetas agrupadoras
	 * 
	 * @return
	 */
	public List<VwSeguridadautorizacione> obtenerGruposPermisosMenuDB() {
		List<VwSeguridadautorizacione> listaGruposPermisos = new ArrayList<VwSeguridadautorizacione>();
		// VwSeguridadautorizacione objPermisos = new
		// VwSeguridadautorizacione();
		// objPermisos.setAplicacionCodigo(Constant.APLICACION_CODIGO);
		// objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
		// objPermisos.setEstado(Constant.ACTIVO);
		// objPermisos.setTipodeObjeto(TIPOO_CARPETA_db);
		// //objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
		// objPermisos.setVisibleFlag(Constant.SI_db);
		// //objPermisos = getOrdenable(objPermisos,
		// Arrays.asList("webGrupoSecuencia"), Constant.ORDER_ASC);

		List<Vistaconceptoautoriza> listaGruposPermisosTemp = new ArrayList<Vistaconceptoautoriza>();
		Vistaconceptoautoriza objPermisos = new Vistaconceptoautoriza();
		objPermisos.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
		objPermisos.setEstado(Constant.ACTIVO);
		objPermisos.setTipodeobjeto(TIPOO_CARPETA_db);
		// objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
		objPermisos.setVisibleflag(Constant.SI_db);
		// objPermisos = getOrdenable(objPermisos,
		// Arrays.asList("webGrupoSecuencia"), Constant.ORDER_ASC);

		// ***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION
		// ANTERIOR QUE ERA DE TIPO TREE
		objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
		//ORDENAR
		objPermisos.setOrdernable(true);
		objPermisos.setAtributoOrdenacion("orden");
		

		/** CARGAR DESDE DB */
		if (listaGruposPermisosGen == null) {
			//
			//listaGruposPermisosTemp = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos,
				//	EntityGlobal.getInstance().getUneunegocioid(),EntityGlobal.getInstance().getMoemestudioid());
			// mapper
			listaGruposPermisosGen = getMapperListaPermisos(listaGruposPermisosTemp);
			listaGruposPermisos.addAll(listaGruposPermisosGen);
		} else {
			listaGruposPermisos.addAll(listaGruposPermisosGen);
		}

		return listaGruposPermisos;
	}

	public List<VwSeguridadautorizacione> getMapperListaPermisos(List<Vistaconceptoautoriza> listaAutoriza) {
		List<VwSeguridadautorizacione> listaGruposPermisos = new ArrayList<VwSeguridadautorizacione>();
		if (listaAutoriza != null) {
			for (Vistaconceptoautoriza objAutorizacioMenu : listaAutoriza) {
				VwSeguridadautorizacione objPermisos = new VwSeguridadautorizacione();
				objPermisos.setAplicacionCodigo(objAutorizacioMenu.getAplicacioncodigo());
				objPermisos.setUsuario(objAutorizacioMenu.getUsuario());
				objPermisos.setEstado(objAutorizacioMenu.getEstado());
				objPermisos.setTipodeObjeto(objAutorizacioMenu.getTipodeobjeto());
				// objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
				objPermisos.setVisibleFlag(objAutorizacioMenu.getVisibleflag());

				objPermisos.setGrupo(objAutorizacioMenu.getGrupo());
				objPermisos.setConcepto(objAutorizacioMenu.getConcepto());
				objPermisos.setConceptoPadre(objAutorizacioMenu.getConceptopadre());
				objPermisos.setDescripcionGrupo(objAutorizacioMenu.getDescripcion());
				objPermisos.setDescripcionSegConcepto(objAutorizacioMenu.getDescripcion());
				objPermisos.setObjetoWindow(objAutorizacioMenu.getObjetowindow());
				objPermisos.setUrl(objAutorizacioMenu.getUrl());
				if(!existeEnListaPermisosShow(objPermisos, listaGruposPermisos)){
					listaGruposPermisos.add(objPermisos);	
				}								
			}
		}

		return listaGruposPermisos;
	}

	/** Valida si Permiso existe o no en lista de Permisos 
	 * (Otra forma es usar Algoritmo de Eliminación de repetidos ... Ver Registro de Permisos de Perfil)
	 * @return
	 */
	public boolean existeEnListaPermisosShow(VwSeguridadautorizacione objPermisoAdd,List<VwSeguridadautorizacione> listaPermisosShow){
		boolean result = false;
		for (VwSeguridadautorizacione objPermisoShow : listaPermisosShow) {
			//Si es el mismo concepto (en el mismo padre)
			if(objPermisoShow.getAplicacionCodigo().trim().equals(objPermisoAdd.getAplicacionCodigo().trim())
				&& objPermisoShow.getGrupo().trim().equals(objPermisoAdd.getGrupo().trim())
				&& objPermisoShow.getConcepto().trim().equals(objPermisoAdd.getConcepto().trim())
				&& (""+objPermisoShow.getConceptoPadre()).trim().equals((objPermisoAdd.getConceptoPadre()+"").trim())
					){		
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Obtiene la lista de Permisos , pero del tipo de objeto 'A', que son los
	 * Archivos de opciones
	 * 
	 * @return
	 */
	public List<VwSeguridadautorizacione> obtenerOpcionesPermisosMenu(String filtroNombre, String grupo,
			String conceptoPadre) {
		//return obtenerOpcionesPermisosMenuDB(filtroNombre, grupo,conceptoPadre);
		return MenuPrincipalEstaticoBean.obtenerOpcionesPermisosMenuEstatic(filtroNombre, grupo, conceptoPadre);
	}

	/**
	 * Obtiene la lista de Permisos , pero del tipo de objeto 'A', que son los
	 * Archivos de opciones
	 * 
	 * @return
	 */
	public List<VwSeguridadautorizacione> obtenerOpcionesPermisosMenuDB(String filtroNombre, String grupo,
			String conceptoPadre) {
		List<VwSeguridadautorizacione> listaOpcPermisos = new ArrayList<VwSeguridadautorizacione>();
		// VwSeguridadautorizacione objPermisos = new
		// VwSeguridadautorizacione();
		// objPermisos.setAplicacionCodigo(Constant.APLICACION_CODIGO);
		// objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
		// objPermisos.setEstado(Constant.ACTIVO);
		// objPermisos.setTipodeObjeto(TIPOO_ARCHIVO_db);
		// objPermisos.setGrupo(grupo);
		// objPermisos.setConceptoPadre(conceptoPadre);
		// objPermisos.setDescripcionSegConcepto(filtroNombre);
		// //objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
		// objPermisos.setVisibleFlag(Constant.SI_db);

		List<Vistaconceptoautoriza> listaOpcPermisosTemp = new ArrayList<Vistaconceptoautoriza>();
		Vistaconceptoautoriza objPermisos = new Vistaconceptoautoriza();
		objPermisos.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
		objPermisos.setEstado(Constant.ACTIVO);
		objPermisos.setTipodeobjeto(TIPOO_ARCHIVO_db);
		objPermisos.setGrupo(grupo);
		objPermisos.setConceptopadre(conceptoPadre);
		objPermisos.setDescripcion(filtroNombre);
		// objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
		objPermisos.setVisibleflag(Constant.SI_db);

		// ***OBS TIPO DE ACCESO: DE TIPO MENU, EN CONTRAPOSICION CON LA VERSION
		// ANTERIOR QUE ERA DE TIPO TREE
		objPermisos.setTipodeacceso(Constant.SEGURIDAD_OPCION_TIPO_MENU);
		//ORDENAR
		objPermisos.setOrdernable(true);
		objPermisos.setAtributoOrdenacion("orden");
		/** CARGAR DESDE DB */
		//listaOpcPermisosTemp = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos,
			//	EntityGlobal.getInstance().getUneunegocioid(),EntityGlobal.getInstance().getMoemestudioid());
		if (listaOpcPermisosTemp != null) {
			listaOpcPermisos.addAll(getMapperListaPermisos(listaOpcPermisosTemp));
		}

		return listaOpcPermisos;
	}





	/**
	 * Evento que busca el Menú de opciones por el nombre
	 */
	public void buscarPermisosMenuFiltro() {

		listaPermisos = new ArrayList<VwSeguridadautorizacione>();
		try {
			if (UtilesCommons.noEsVacio(nombreOpcionFiltro)) {
				List<VwSeguridadautorizacione> listaOpcPermisos = new ArrayList<VwSeguridadautorizacione>();
				List<VwSeguridadautorizacione> listaGrupoPermisosTemp = obtenerGruposPermisosMenu();
				listaOpcPermisos = obtenerOpcionesPermisosMenu(nombreOpcionFiltro, null, null);
				if (listaOpcPermisos != null) {
					/**filtrar GRUPOS*/								
					listaGrupoPermisosTemp = filtrarGruposPermisosMenu(listaGrupoPermisosTemp,listaOpcPermisos);
					if (UtilesCommons.noEsVacio(listaGrupoPermisosTemp)) {
						listaPermisos.addAll(listaGrupoPermisosTemp);
						listaPermisos.addAll(listaOpcPermisos);
					}
					/************/					
				}
			}else{
				eventoCargarPermisosMenu();
			}
			actualSubMenuDisplay = null;
			//actualSubMenuDisplay = "";
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Evento al seleccionar una opcion del MENU
	 */
	public void onSelectMenu() {
		try {
			String paramData = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("dataSelect");
			if (paramData != null) {
				String[] cadenas = paramData.split(separadorParam);
				if (cadenas.length > 1) {
					grupoActual = cadenas[0];
					conceptoActual = cadenas[1];
					urlActual = cadenas[2];
					conceptoDescActual = cadenas[3];
					conceptoPadreActual = cadenas[4];
					EntityGlobal.getInstance().setGrupoActual(grupoActual);
					EntityGlobal.getInstance().setConceptoActual(conceptoActual);
					EntityGlobal.getInstance().setSysUrl(urlActual);
					EntityGlobal.getInstance().setConceptoActualDesc(conceptoDescActual);
					EntityGlobal.getInstance().setConceptoPadreActual(conceptoPadreActual);

					/** TRAEMOS LOS CONCEPTOS **/
					if(UtilesCommons.noEsVacio(grupoActual) && UtilesCommons.noEsVacio(conceptoActual)) {
						Vistaconceptoautoriza objPermisos = new Vistaconceptoautoriza();
						objPermisos.setAplicacioncodigo(Constant.APLICACION_CODIGO);
						objPermisos.setGrupo(grupoActual);
						objPermisos.setVisibleflag(Constant.SI_db);
						objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
						objPermisos.setConceptopadre(conceptoActual);
						List<Vistaconceptoautoriza> list = null;
						//List<Vistaconceptoautoriza> list = seguridadAutorizacioneService.listarPermisosUsuario(objPermisos,
							//	EntityGlobal.getInstance().getUneunegocioid(),EntityGlobal.getInstance().getMoemestudioid());
						Map<String, String> mapSeguridad = UtilesCommons.getNewLinkedHashMap();
						if(UtilesCommons.noEsVacio(list)) {							
							for (Vistaconceptoautoriza segconcepto : list) {
								mapSeguridad.put(segconcepto.getObjeto(), segconcepto.getObjeto()); 
							}						
						}
						EntityGlobal.getInstance().setMapPropSeguridad(mapSeguridad);
					} 
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Evento al seleccionar una opcion del MENU
	 */
	public void onSelectMenuTop() {
		try {
			String paramData = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("dataSelect");
			if (paramData != null) {
				String[] cadenas = paramData.split(separadorParam);
				if (cadenas.length > 1) {
					String grupoTemp = cadenas[0];
					String urlTemp = cadenas[2];
					//
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Evento al seleccionar una opcion PADRE del MENU
	 */
	public void onSelectGroupMenu() {
		try {
			String paramData = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
					.get("dataSelect");
			if (paramData != null) {
				// indicaMenuCollapsed = false;
				String[] cadenas = paramData.split(separadorParam);
				if (cadenas.length > 1) {
					String grupoActualTemp = cadenas[0];
					String conceptoPadreActualTemp = cadenas[1];
					listaPermisos = new ArrayList<VwSeguridadautorizacione>();
					if (UtilesCommons.noEsVacio(nombreOpcionFiltro)) {
						buscarPermisosMenuFiltro();
						actualSubMenuDisplay = paramData;
					}else{
						List<VwSeguridadautorizacione> listaOpcPermisos = new ArrayList<VwSeguridadautorizacione>();
						List<VwSeguridadautorizacione> listaGrupoPermisosTemp = obtenerGruposPermisosMenu();
						if (UtilesCommons.noEsVacio(listaGrupoPermisosTemp)) {
							listaPermisos.addAll(listaGrupoPermisosTemp);						
						}
						listaOpcPermisos = obtenerOpcionesPermisosMenu(nombreOpcionFiltro, grupoActualTemp,
								conceptoPadreActualTemp);
						if (listaOpcPermisos != null) {						
							listaPermisos.addAll(listaOpcPermisos);
							actualSubMenuDisplay = paramData;
							// mapSubMenuDisplay.put(paramData, "S");
						}
					}
				}
			} else {
				actualSubMenuDisplay = "";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * método para controlar que opciones se muestran y cuales no
	 * 
	 * @param grupo
	 * @param conceptoPadre
	 * @param tipoObjeto
	 * @return
	 */
	public String getDisplayMenu(String grupo, String conceptoPadre, String tipoObjeto) {
		String result = "block";
		String param = grupo + separadorParam + conceptoPadre;
		if (TIPOO_CARPETA_db.equals(tipoObjeto)) {
			if (actualSubMenuDisplay != null) {
				if (param.equals(actualSubMenuDisplay)) {
					result = "block";
				} else {
					result = "none";
				}
			} else {
				result = "block";
			}
		} else {
			result = "none";
		}
		return result;
		// #{elem.grupo.trim()}:@:#{elem.concepto.trim()}
	}

	/***/
	public String obtenerUrl(String url, String componente) {
		if (url != null) {
			return url;
		} else {
			return URL_PORTAL_INDEX;
		}

	}

	/**
	 * DEFAULT DATA OPCION
	 * 
	 * @param url
	 * @param descripcion
	 */
	public static void setDataOpcionActualDefault(String url, String descripcion) {
		EntityGlobal.getInstance().setGrupoActual("000000");
		EntityGlobal.getInstance().setConceptoActual("CON000X");
		EntityGlobal.getInstance().setSysUrl(url);
		EntityGlobal.getInstance().setConceptoActualDesc(descripcion);
		EntityGlobal.getInstance().setConceptoPadreActual("000000");
	}

	public VwSeguridadautorizacione getOrdenable(VwSeguridadautorizacione objPermisos, List<String> listOrdenacion,
			String tipoOrdenacion) {
		//objPermisos.setListaAtributoOrdenacion(listOrdenacion);
		//objPermisos.setTipoordenacion(tipoOrdenacion);
		return objPermisos;
	}

	/** METODO PARA INVOCAR AL GENERADOR DE REMESAS COMO UN DIALOG **/

	public String getConceptoActual() {
		if (EntityGlobal.getInstance() != null) {
			conceptoActual = EntityGlobal.getInstance().getConceptoActual();
		}
		return conceptoActual;
	}

	public void setConceptoActual(String conceptoActual) {
		this.conceptoActual = conceptoActual;
	}

	public String getGrupoActual() {
		return grupoActual;
	}

	public void setGrupoActual(String grupoActual) {
		if (EntityGlobal.getInstance() != null) {
			grupoActual = EntityGlobal.getInstance().getGrupoActual();
		}
		this.grupoActual = grupoActual;
	}

	public String getAppCodigoActual() {
		return appCodigoActual;
	}

	public void setAppCodigoActual(String appCodigoActual) {
		this.appCodigoActual = appCodigoActual;
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

	public String getUrlActual() {
		if (EntityGlobal.getInstance() != null) {
			urlActual = EntityGlobal.getInstance().getSysUrl();
		}
		return urlActual;
	}

	public void setUrlActual(String urlActual) {
		this.urlActual = urlActual;
	}

	public String getConceptoSysDefault() {
		if (EntityGlobal.getInstance() != null) {
			conceptoSysDefault = EntityGlobal.getInstance().getSysConcepto();
		}
		return conceptoSysDefault;
	}

	public void setConceptoSysDefault(String conceptoSysDefault) {
		this.conceptoSysDefault = conceptoSysDefault;
	}

	public String getGrupoSysDefault() {
		if (EntityGlobal.getInstance() != null) {
			grupoSysDefault = EntityGlobal.getInstance().getSysGrupo();
		}
		return grupoSysDefault;
	}

	public void setGrupoSysDefault(String grupoSysDefault) {
		this.grupoSysDefault = grupoSysDefault;
	}

	public String getUrlSysDefault() {
		if (EntityGlobal.getInstance() != null) {
			urlSysDefault = EntityGlobal.getInstance().getUrlPaginaInicio();
		}
		return urlSysDefault;
	}

	public void setUrlSysDefault(String urlSysDefault) {
		this.urlSysDefault = urlSysDefault;
	}

	public String getConceptoDescSysDefault() {
		if (EntityGlobal.getInstance() != null) {
			conceptoDescSysDefault = EntityGlobal.getInstance().getSysConceptoDesc();
		}
		return conceptoDescSysDefault;
	}

	public void setConceptoDescSysDefault(String conceptoDescSysDefault) {
		this.conceptoDescSysDefault = conceptoDescSysDefault;
	}

	public String getNombreOpcionFiltro() {
		return nombreOpcionFiltro;
	}

	public void setNombreOpcionFiltro(String nombreOpcionFiltro) {
		this.nombreOpcionFiltro = nombreOpcionFiltro;
	}

	public String getConceptoPadreActual() {
		return conceptoPadreActual;
	}

	public void setConceptoPadreActual(String conceptoPadreActual) {
		this.conceptoPadreActual = conceptoPadreActual;
	}

	public Map<String, String> getMapSubMenuDisplay() {
		return mapSubMenuDisplay;
	}

	public void setMapSubMenuDisplay(Map<String, String> mapSubMenuDisplay) {
		this.mapSubMenuDisplay = mapSubMenuDisplay;
	}

	public List<VwSeguridadautorizacione> getListaPermisos() {
		return listaPermisos;
	}

	public void setListaPermisos(List<VwSeguridadautorizacione> listaPermisos) {
		this.listaPermisos = listaPermisos;
	}

	public List<VwSeguridadautorizacione> getListaGruposPermisosGen() {
		return listaGruposPermisosGen;
	}

	public void setListaGruposPermisosGen(List<VwSeguridadautorizacione> listaGruposPermisosGen) {
		this.listaGruposPermisosGen = listaGruposPermisosGen;
	}

	public String getMenuActual() {
		menuActual = URL_MENU_MAIN;

		return menuActual;
	}

	public void setMenuActual(String menuActual) {
		this.menuActual = menuActual;
	}

	public String getSeparadorParam() {
		return separadorParam;
	}

	public void setSeparadorParam(String separadorParam) {
		this.separadorParam = separadorParam;
	}

	public SeguridadautorizacionesService getSeguridadAutorizacioneService() {
		return seguridadAutorizacioneService;
	}

	public void setSeguridadAutorizacioneService(SeguridadautorizacionesService seguridadAutorizacioneService) {
		this.seguridadAutorizacioneService = seguridadAutorizacioneService;
	}
}
