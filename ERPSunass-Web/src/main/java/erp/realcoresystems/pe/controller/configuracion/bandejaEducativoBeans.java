package erp.realcoresystems.pe.controller.configuracion;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;


import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named(value = "bandejaEducativoBeans")
@Scope("session")
public class bandejaEducativoBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private HttpServletRequest request;


 	@Autowired
 	private ApplicationContext applicationContext;

	/* Activiad*/
	private int inicioConsulta = 0;
	private String opcionCombo = "1";
	private String valorTxtFiltro = "";

	private TreeNode selectedNode;
	private String opcionSeleccionada = "../bandejaProyecto/bienesRecursosPaciente.xhtml";
	private String formatoURLSeleccionada;
	private boolean indicaPanelEastCollapsed=true;
	private static String FORM_URL_DEFAULT = "../modulos/paginaDefault.xhtml";
	
	public String TIPOO_OBJETO_db = "O";
	public String TIPOO_CARPETA_db = "C";
	public String TIPOO_ARCHIVO_db = "A";

	public String getFormatoURLRecursos() {
		return formatoURLRecursos;
	}

	public void setFormatoURLRecursos(String formatoURLRecursos) {
		this.formatoURLRecursos = formatoURLRecursos;
	}

	private String formatoURLRecursos;
	private TreeNode root;
	private String codigoTablaGlobal = "DD000";
	private MaMiscelaneosdetalle maMiscelaneosDetalleRecursoSeleccionado;
	private int primeraVez = 0;

	private String nombreNontroller = "#{ssHcAnamnesisEaController.submitAction}";
	private static String URL_BANDEJA_INICIO = "../../login.xhtml?faces-redirect=true";
	private boolean visibleFiltrosRecestas;

	public bandejaEducativoBeans() {
		// TODO Auto-generated constructor stub
		// lazyMaMiscelaneosDetalle = consultaTablaBienesRecursos(codigoTablaGlobal);
		// cargarFiltroCombosBienesRecursos();
	}

	public void cargarFiltroCombosBienesRecursos() {

	}
	
	public void inicializar() {
		String ruta ="../sa/principal.xhtml";
		formatoURLSeleccionada = ruta;
	}
	
	public void btnLoadAction(ActionEvent actionEvent) throws IOException {
		if (!FacesUtil.isPostback()) {

		} else {
			String ruta ="../sa/principal.xhtml";
			formatoURLSeleccionada = ruta;
			//perfilWebMasterAux = new ArrayList<Vistaconceptoautoriza>();
			System.out.print("Cabecera 2 " + ruta );
			if (EntityGlobal.getInstance()!=null){
				root = createSsCheVistaSeguridads();
				cargarFiltroCombosBienesRecursos();				
			}else{
				cerrarSessionUsuario() ;
			}
			/*listaTablaBienesRecursos.clear();
			inicioConsulta = 0;
			maMiscelaneosDetalleBuscador = new MaMiscelaneosDetalle();
			consultaTablaBienesRecursos(codigoTablaGlobal);*/
		}
	}
	
	
	public String cerrarSessionUsuario() throws IOException {
		EntityGlobal.closeInstance();
		FacesContext.getCurrentInstance().getExternalContext().redirect(URL_BANDEJA_INICIO);
		//response.sendRedirect(request.getContextPath() + "/login.xhtml");
		return URL_BANDEJA_INICIO;
	}
	public TreeNode createSsCheVistaSeguridads() {
		try {
			root = new DefaultTreeNode("Root", null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return root;
	}
	
	/** cargar NODOS HIJOS DEL ARBOL PLANTILLA */
	public void createSubNode(Object objSsCheVistaSeguridad, TreeNode node) {

	}

	/**Carga los Objetos de SEGURIDAD DEL CONCEPTO SELECCIONADO*/
	public void cargarObjetosConceptos(Object objSsCheVistaSeguridad) {

	}
	/**Valida si el concepto seleccionado está APTO PARA AUDITORÍA o NO*/
	public void cargarValidoParaAuditoria(Object objConcepto) {
		EntityGlobal.getInstance().setFlagValidoParaAudtoria(Utiles.NO_db);
		boolean  validoParaAuditoria = false;		
		

		
	}
	
	public void onNodeSelectForm(NodeSelectEvent event) throws IOException {

	}
	public void onNodeSelect(NodeSelectEvent event) throws IOException {
		}
	
	public void setDataOpcionSelection(Object opcionActual) {
	 }

	
	public void btnBuscarAction(ActionEvent actionEvent) {

	}


	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}

	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}

	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public String getFormatoURLSeleccionada() {
		return formatoURLSeleccionada;
	}

	public void setFormatoURLSeleccionada(String formatoURLSeleccionada) {
		this.formatoURLSeleccionada = formatoURLSeleccionada;
	}

	public static String getUrlBandejaInicio() {
		return URL_BANDEJA_INICIO;
	}

	public static void setUrlBandejaInicio(String urlBandejaInicio) {
		URL_BANDEJA_INICIO = urlBandejaInicio;
	}




}


