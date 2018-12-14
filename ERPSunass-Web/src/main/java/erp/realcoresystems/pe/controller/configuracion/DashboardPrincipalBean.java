package erp.realcoresystems.pe.controller.configuracion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import erp.realcoresystems.pe.commons.EventosBean;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.util.FacesUtil;

import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.SsCargainicialService;
import erp.realcoresystems.pe.service.SsPeriodogeneralService;
import org.primefaces.event.ResizeEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "dashboardPrincipalBean")
@ViewScoped
public class DashboardPrincipalBean extends AbstractGenericBean implements InterfaceGenericBean {


	@ManagedProperty(value="#{ssPeriodogeneralService}")
	private SsPeriodogeneralService ssPeriodogeneralService;


	public static final String ICON_STATE_INI = "fa fa-clock-o";
	public static final String ICON_STATE_MIDDLE = "fa fa-cogs";
	public static final String ICON_STATE_END = "fa fa-check-circle";

	public  static final int CODE_WF_ETAPA_ACTUAL = 1;
	public  static final int CODE_WF_ETAPA_BLOQUEADA = 2;
	public  static final int CODE_WF_ETAPA_ANTERIOR = 3;
	public  static final int CODE_WF_ETAPA_SIGUIENTE = 4;

	private EventosBean eventoSeleccion= new EventosBean();
	private TreeNode root;
	private TreeNode selectedNode;
	private List<TreeNode> listaTreeNodeFlujoMst;
    private SsPeriodogeneral ssPeriodogeneralFiltro = new SsPeriodogeneral();
	private List<SsPeriodogeneral> ssPeriodogeneralList = new ArrayList<>();
	private List<SsPeriodogeneral> ssPeriodogeneralEstado = new ArrayList<>();

	//private Integer indexNode;
	private String flujoTipoRegistroDoc;
	private String flujoAreaRevisoraDoc;
	private String flujoEstadoActual;
	private String flujoEstadoSiguiente;

	private int countProfundidad;
	private String valorShowVentaDia;
	private String valorShowRemesaDia;
	private String valorShowCobranzaDia;
	private String simboloMoneda;

	private List<MaMiscelaneosdetalle> masAnnos;
	private List<MaMiscelaneosdetalle> masEstados;


	@PostConstruct
	public void inicializar() {	
		cargarDashboardVenta();
		inicializarEntidad();
	}
	public void inicializarEntidad(){
		flujoTipoRegistroDoc = null;
		flujoAreaRevisoraDoc = null;
		flujoEstadoActual = null;
		flujoEstadoSiguiente = null;
		countProfundidad = 0;
		masAnnos = UtilesCommons.getNewList();
		listaTreeNodeFlujoMst = UtilesCommons.getNewList();
		iniciarViewFlujoEstados();
		cargarAnnos();
		cargaEstadoActual();
	}
	public void cargarAnnos() {
	 Integer annoActual=annoActual();
	 int annoInicio = annoActual-10;
	 int annoFin = annoActual+10;
		MaMiscelaneosdetalle valores;
		for (int i=annoInicio; i<=annoFin; i++){
			valores =new MaMiscelaneosdetalle();
			//valores.setAplicacioncodigo("AP");
			//valores.setCompania("9999");
			//valores.setCodigotabla(i+"");
			valores.setCodigoelemento(i+"");
			valores.setValorentero1(Long.parseLong(i+""));
			masAnnos.add(valores);
		}
	}
	public void cargarEstado() {
		SsPeriodogeneral valEstados =new SsPeriodogeneral();
		valEstados.setAnno(9999);
		ssPeriodogeneralEstado = ssPeriodogeneralService.listar(valEstados,false);
	}
	public void cargaEstadoActual(){
		SsPeriodogeneral valEstados =new SsPeriodogeneral();
		valEstados.setAnno(annoActual());
		//valEstados.setSecuencia(1);
		ssPeriodogeneralEstado = ssPeriodogeneralService.listar(valEstados,false);
		if (ssPeriodogeneralEstado.size()>0){
			for(SsPeriodogeneral obj : ssPeriodogeneralEstado)
				if (obj.getSecuencia() == 1) {
					EntityGlobal.getInstance().setPeriodoAnnoActual(obj.getAnno());

					EntityGlobal.getInstance().setNivel(obj.getNivel());
					EntityGlobal.getInstance().setNombreEtapa(obj.getTipooperacion());
					EntityGlobal.getInstance().setEstadoNumero(obj.getEstadodocumento());
					ssPeriodogeneralFiltro.setAnno(obj.getAnno());
					ssPeriodogeneralFiltro.setSecuencia(obj.getSecuencia());
					ssPeriodogeneralFiltro.setNivel(obj.getNivel());
					ssPeriodogeneralFiltro.setEstadodocumento(obj.getEstadodocumento());
					ssPeriodogeneralFiltro.setEstado(obj.getEstado());
				}
		}else{
			valEstados =new SsPeriodogeneral();
			valEstados.setAnno(9999);
			ssPeriodogeneralEstado = ssPeriodogeneralService.listar(valEstados,false);
			for(SsPeriodogeneral obj : ssPeriodogeneralEstado){
				if (obj.getSecuencia()==1){
					ssPeriodogeneralFiltro.setAnno(annoActual());
					ssPeriodogeneralFiltro.setSecuencia(obj.getSecuencia());
					ssPeriodogeneralFiltro.setNivel(obj.getNivel());
					ssPeriodogeneralFiltro.setEstadodocumento(obj.getEstadodocumento());
					ssPeriodogeneralFiltro.setEstado(obj.getEstado());
				}
			}
		}

		if (EntityGlobal.getInstance().getUsuario().equals("10102020")){
			ssPeriodogeneralFiltro.setNivel(2);
		}

	}
	public int annoActual(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		System.out.println(date); //15/10/2013
		Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		return TimeCommons.getAnio(today);
	}
	public void btnAperturaAnno() {
		SsPeriodogeneral valEstados =new SsPeriodogeneral();
		valEstados.setAnno(9999);
		ssPeriodogeneralEstado = ssPeriodogeneralService.listar(valEstados,false);
		int respuesta=0;
		if (UtilesCommons.noEsVacio(ssPeriodogeneralFiltro.getAnno())) {
			for(SsPeriodogeneral obj : ssPeriodogeneralEstado){
				obj.setAnno(ssPeriodogeneralFiltro.getAnno());
				if (obj.getTipooperacion().equals("APERTURA")){
					obj.setSecuencia(1);
					obj.setEstadodocumento(2);
				}else{
					obj.setSecuencia(0);
					obj.setEstadodocumento(1);
				}
				if (obj.getTipooperacion().equals("PREPARACION")){
					obj.setSecuencia(0);
					obj.setEstadodocumento(2);
				}
				respuesta = ssPeriodogeneralService.guardar(obj);
			}
		}
		cargaEstadoActual();
	}
	/**CARGAR DATOS DASHBOARD**/

	/*public void onResize(ResizeEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Image resized", "Width:" + event.getWidth() + ",Height:" + event.getHeight());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}*/
	public TreeNode crearTreeNode(Map<Integer,SsPeriodogeneral > mapIndexEstados, SsPeriodogeneral  objData,
								  int[][] matrizEstadosTrans, TreeNode nodePadreActual, int indexInicio ,
								  String estadoActual, String estadoSgte){

		TreeNode nodeElem  = new DefaultTreeNode(objData, nodePadreActual);
		if(matrizEstadosTrans!=null){
			countProfundidad++;
			nodeElem.setRowKey(""+countProfundidad);
			nodeElem.setType("Etapa");
			nodeElem.setExpanded(true);
			listaTreeNodeFlujoMst.add(nodeElem);
			/**1.- cargar NODOS ETAPAS si hubiere */
			//SET - ICON
			if(nodeElem.getParent()==null){
				objData.setString3(ICON_STATE_INI);
			}else if(nodeElem.getChildCount()>0){
				objData.setString3(ICON_STATE_MIDDLE);
			}else{
				objData.setString3(ICON_STATE_END);
			}
		}
		return nodeElem;
	}

	public void iniciarViewFlujoEstados() {
		
			try{

				root = new DefaultTreeNode("Root", null);
				TreeNode node0 = new DefaultTreeNode("Node 0", root);
				TreeNode node1 = new DefaultTreeNode("Node 1", root);

				TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
				TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);

				TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);

				node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
				node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
				node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
				node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
				node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
				root.getChildren().add(new DefaultTreeNode("Node 2"));

				SsPeriodogeneral  flujo = new SsPeriodogeneral ();

			}catch(Exception e){
				e.printStackTrace();
			}
			//List<SsPeriodogeneral > listaFlujoAuxiliar = new ArrayList<SsPeriodogeneral >();
			//Map<String,List<SsPeriodogeneral >> maplistaFlujoAuxiliar = new HashMap<String,List<SsPeriodogeneral >>();


	}
	public void cargarDashboardVenta(){
		try{
			BigDecimal valorVentaDia =BigDecimal.ZERO; 
			BigDecimal valorRemesaDia =BigDecimal.ZERO;
			simboloMoneda = "";
			//SI EXISTE UN CAJERO PRECARGADO (POR LOGIN o POR AUTORIZACIÓN DIRECTA)
	
				valorShowVentaDia = Utiles.getNumeroFormat(FacesUtil.getPropertyLabels("PATTERN_NUM_2DEC"), 
						valorVentaDia.doubleValue());		
				valorShowRemesaDia = Utiles.getNumeroFormat(FacesUtil.getPropertyLabels("PATTERN_NUM_2DEC"), 
						valorRemesaDia.doubleValue());					
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public String getValorShowVentaDia() {
		return valorShowVentaDia;
	}

	public void setValorShowVentaDia(String valorShowVentaDia) {
		this.valorShowVentaDia = valorShowVentaDia;
	}

	public String getValorShowRemesaDia() {
		return valorShowRemesaDia;
	}

	public void setValorShowRemesaDia(String valorShowRemesaDia) {
		this.valorShowRemesaDia = valorShowRemesaDia;
	}

	public String getValorShowCobranzaDia() {
		return valorShowCobranzaDia;
	}

	public void setValorShowCobranzaDia(String valorShowCobranzaDia) {
		this.valorShowCobranzaDia = valorShowCobranzaDia;
	}

	public String getSimboloMoneda() {
		return simboloMoneda;
	}

	public void setSimboloMoneda(String simboloMoneda) {
		this.simboloMoneda = simboloMoneda;
	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {

	}

	@Override
	public void btnBuscar() {
		cargaEstadoActual();
	}

	@Override
	public void btnGuardar() {

	}

	@Override
	public void btnAceptar() {

	}

	@Override
	public void btnCancelar() {

	}

	@Override
	public void btnNuevo() {

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

	@Override
	public void abrirRegistro() {

	}


	public static String getIconStateIni() {
		return ICON_STATE_INI;
	}

	public static String getIconStateMiddle() {
		return ICON_STATE_MIDDLE;
	}

	public static String getIconStateEnd() {
		return ICON_STATE_END;
	}

	public static int getCodeWfEtapaActual() {
		return CODE_WF_ETAPA_ACTUAL;
	}

	public static int getCodeWfEtapaBloqueada() {
		return CODE_WF_ETAPA_BLOQUEADA;
	}

	public static int getCodeWfEtapaAnterior() {
		return CODE_WF_ETAPA_ANTERIOR;
	}

	public static int getCodeWfEtapaSiguiente() {
		return CODE_WF_ETAPA_SIGUIENTE;
	}

	public EventosBean getEventoSeleccion() {
		return eventoSeleccion;
	}

	public void setEventoSeleccion(EventosBean eventoSeleccion) {
		this.eventoSeleccion = eventoSeleccion;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public List<TreeNode> getListaTreeNodeFlujoMst() {
		return listaTreeNodeFlujoMst;
	}

	public void setListaTreeNodeFlujoMst(List<TreeNode> listaTreeNodeFlujoMst) {
		this.listaTreeNodeFlujoMst = listaTreeNodeFlujoMst;
	}


	public List<SsPeriodogeneral> getSsPeriodogeneralList() {
		return ssPeriodogeneralList;
	}

	public void setSsPeriodogeneralList(List<SsPeriodogeneral> ssPeriodogeneralList) {
		this.ssPeriodogeneralList = ssPeriodogeneralList;
	}

	public String getFlujoTipoRegistroDoc() {
		return flujoTipoRegistroDoc;
	}

	public void setFlujoTipoRegistroDoc(String flujoTipoRegistroDoc) {
		this.flujoTipoRegistroDoc = flujoTipoRegistroDoc;
	}

	public String getFlujoAreaRevisoraDoc() {
		return flujoAreaRevisoraDoc;
	}

	public void setFlujoAreaRevisoraDoc(String flujoAreaRevisoraDoc) {
		this.flujoAreaRevisoraDoc = flujoAreaRevisoraDoc;
	}

	public String getFlujoEstadoActual() {
		return flujoEstadoActual;
	}

	public void setFlujoEstadoActual(String flujoEstadoActual) {
		this.flujoEstadoActual = flujoEstadoActual;
	}

	public String getFlujoEstadoSiguiente() {
		return flujoEstadoSiguiente;
	}

	public void setFlujoEstadoSiguiente(String flujoEstadoSiguiente) {
		this.flujoEstadoSiguiente = flujoEstadoSiguiente;
	}

	public int getCountProfundidad() {
		return countProfundidad;
	}

	public void setCountProfundidad(int countProfundidad) {
		this.countProfundidad = countProfundidad;
	}
	public SsPeriodogeneralService getSsPeriodogeneralService() {
		return ssPeriodogeneralService;
	}

	public void setSsPeriodogeneralService(SsPeriodogeneralService ssPeriodogeneralService) {
		this.ssPeriodogeneralService = ssPeriodogeneralService;
	}

	public List<MaMiscelaneosdetalle> getMasAnnos() {
		return masAnnos;
	}

	public void setMasAnnos(List<MaMiscelaneosdetalle> masAnnos) {
		this.masAnnos = masAnnos;
	}

	public List<MaMiscelaneosdetalle> getMasEstados() {
		return masEstados;
	}

	public void setMasEstados(List<MaMiscelaneosdetalle> masEstados) {
		this.masEstados = masEstados;
	}

	public List<SsPeriodogeneral> getSsPeriodogeneralEstado() {
		return ssPeriodogeneralEstado;
	}

	public void setSsPeriodogeneralEstado(List<SsPeriodogeneral> ssPeriodogeneralEstado) {
		this.ssPeriodogeneralEstado = ssPeriodogeneralEstado;
	}


	public SsPeriodogeneral getSsPeriodogeneralFiltro() {
		return ssPeriodogeneralFiltro;
	}

	public void setSsPeriodogeneralFiltro(SsPeriodogeneral ssPeriodogeneralFiltro) {
		this.ssPeriodogeneralFiltro = ssPeriodogeneralFiltro;
	}
}
