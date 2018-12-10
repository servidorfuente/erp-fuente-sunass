package erp.realcoresystems.pe.controller.gestion;


import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.model.util.ValorRetorno;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.*;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

@ManagedBean(name = "aprobacionesAperturaBean")
@ViewScoped
public class AprobacionesAperturaBean extends AbstractGenericBean implements InterfaceGenericBean {
    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    @ManagedProperty(value="#{saTipofuenteService}")
    private SaTipofuenteService saTipofuenteService;

    @ManagedProperty(value="#{ssControlperiodoService}")
    private SsControlperiodoService ssControlperiodoService;

    @ManagedProperty(value="#{acSucursalService}")
    private AcSucursalService acSucursalService;

    @ManagedProperty(value="#{ssProyectoService}")
    private SsProyectoService ssProyectoService;

    private  List<SaTipofuente> listarFuente ;
    private  List<AcSucursal> listarSucursal ;
    private  List<SsProyecto> listarProyecto;
    private  List<SsControlperiodo> listarCargaInicial;

    private SsControlperiodo ssControlperiodoRegistro;
    private SsControlperiodo ssControlperiodoSeleccion;
    private SsControlperiodo ssControlperiodoFiltro;
    private VwControlperiodo vwControlperiodoSelect;
    private VwControlperiodo vwControlperiodoFiltro;
    private List<Companyowner> listarCompanias;

    private List<MaMiscelaneosdetalle> maMisTipoFuente;
    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private List<MaMiscelaneosdetalle> maMisSubTipoInfraestructura;

    protected LazyDataModel<VwControlperiodo> dataModel;
    protected List<VwControlperiodo> listaDataModel;

    protected List<VwControlperiodo> listaSelecionados;
    private Companyowner companiaDefault;

    protected List<VwControlperiodo> listaSeleccion;
    protected List<VwControlperiodo> listaSeleccionTotal;

    private String fuenteidLocal;
    private boolean indicaSeleccionTotal;
    private boolean indicaSeleccionFilas;

    private Integer elementosListadoTotal;

    private Consumer<String> accionEventoConfirmacion;
    private String mensajeConfirmacion;

    private  String accionFiltro;
    private boolean modoAprobarRechazar;
    private boolean modoDesaprobar;
    private  String  indicaProceso;
    private static final String DIALOG_CONFIRM_OPERACION = "confirm";
    @PostConstruct
    public void inicializar() {
        super.initComponentes();
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        // fuenteidLocal =(String) map.get("fuenteid");
        inicializarEntidad();
        //cargarParametrosSistema();
        inicializarDatoInicial();
        buscarPrincipal();
        maMisTipoFuente = listarMiscelaneosDetalle("","ESTADODOC");
        maMisSubTipoInfraestructura = listarMiscelaneosDetalle("", "SUBTIPINFR");
    }
    public void inicializarEntidad(){
        FacesUtil.removeIfExistsSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);
        ssControlperiodoRegistro = new SsControlperiodo();
        ssControlperiodoSeleccion = new SsControlperiodo();
        ssControlperiodoFiltro = new SsControlperiodo();
        vwControlperiodoSelect = new VwControlperiodo();
        vwControlperiodoFiltro = new VwControlperiodo();
        vwControlperiodoFiltro.setAnno(annoActual());
        maMisTipoFuente = UtilesCommons.getNewList();
        maMisDestalleEstadoDocumento = UtilesCommons.getNewList();
        maMisSubTipoInfraestructura = UtilesCommons.getNewList();
        listarFuente = UtilesCommons.getNewList();
        listarSucursal = UtilesCommons.getNewList();
        listarProyecto = UtilesCommons.getNewList();
        listarCargaInicial = UtilesCommons.getNewList();

        listaSeleccion = UtilesCommons.getNewList();
        listaSeleccionTotal = UtilesCommons.getNewList();

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
    public int annoActual(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        System.out.println(date); //15/10/2013
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return TimeCommons.getAnio(today);
    }
    public void inicializarDatoInicial() {
        cargarCompaniaPermisos();
        cargarSucursal();
        cargarListaFuente();
        vwControlperiodoFiltro.setString1("000000");

        // cargarListaProyectos();
    }
    public void cargarListaProyectos(){
        listarProyecto = ssProyectoService.listar(new SsProyecto(),false);
    }
    public void seleccionarSucursal() {
        if (UtilesCommons.noEsVacio(ssControlperiodoRegistro.getCompanyowner()))
            vwControlperiodoFiltro.setCompanyowner(ssControlperiodoRegistro.getCompanyowner());
        listarSucursal = UtilesCommons.getCleanList(listarSucursal);
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(vwControlperiodoFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getCompanyowner())) {
            listarSucursal  = acSucursalService.sucursalListar(objBusc);
            int a=0;
        }
    }
    public void seleccionarProyecto() {
        if (UtilesCommons.noEsVacio(ssControlperiodoRegistro.getCompanyowner()))
            vwControlperiodoFiltro.setCompanyowner(ssControlperiodoRegistro.getCompanyowner());
        if (UtilesCommons.noEsVacio(ssControlperiodoRegistro.getSucursal()))
            vwControlperiodoFiltro.setSucursal(ssControlperiodoRegistro.getSucursal());
        listarProyecto = UtilesCommons.getCleanList(listarProyecto);
        SsProyecto objEntidad= new SsProyecto();
        objEntidad.setCompanyowner(vwControlperiodoFiltro.getCompanyowner());
        objEntidad.setSucursal(vwControlperiodoFiltro.getSucursal());
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getCompanyowner())) {
            listarProyecto = ssProyectoService.listar(objEntidad, false);
        }
    }
    public void cargarListaFuente(){
        listarFuente = saTipofuenteService.listar(new SaTipofuente(),false);
    }
    public List<Companyowner> cargarCompaniaPermisos(){
        listarCompanias = companiaOwnerService.listarSeguridad(
                new Companyowner(),EntityGlobal.getInstance().getUsuario());
        if (listarCompanias.size()>0)
            companiaDefault = listarCompanias.get(0);
        return listarCompanias;
    }
    public List<AcSucursal> cargarSucursal(){
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(companiaDefault.getCompanyowner());
        listarSucursal  = acSucursalService.sucursalListar(objBusc);
        if (listarSucursal.size()>0){
            SsProyecto objEntidad= new SsProyecto();
            objEntidad.setCompanyowner(vwControlperiodoFiltro.getCompanyowner());
            objEntidad.setSucursal(listarSucursal.get(0).getSucursal());
            if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getCompanyowner())) {
                listarProyecto = ssProyectoService.listar(objEntidad, false);
            }
        }
        return listarSucursal;
    }
    public LazyDataModel<VwControlperiodo> buscarPrincipal() {
        dataModel = new LazyDataModel<VwControlperiodo>() {
            private static final long serialVersionUID = 1L;

            @Override
            public List<VwControlperiodo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                               Map<String, Object> filters) {
                cargarObjetoFiltros(first, pageSize, 0);
                setOrderListadoGeneric(vwControlperiodoFiltro, sortField, sortOrder);
                listaDataModel = ssControlperiodoService.listarVista(vwControlperiodoFiltro,true);
                if(UtilesCommons.noEsVacio(listaDataModel)){
                    setRowCount(ssControlperiodoService.contarVista(vwControlperiodoFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return listaDataModel;
            }

            @Override
            public VwControlperiodo getRowData(String rowKey) {
                for (VwControlperiodo event : listaDataModel) {
                    if ((event.getIdcontador().toString().equals(rowKey))) {
                        vwControlperiodoSelect= (VwControlperiodo) event;
                        return vwControlperiodoSelect;
                    }
                }
                return null;
            }

            @Override
            public Object getRowKey(VwControlperiodo event) {
                return (event.getIdcontador().toString());
            }
        };
        return dataModel;
    }
    public void setOrderListadoGeneric(Entidad entidadFiltro, String sortField, SortOrder sortOrder){
        /**Order FACES*/
        entidadFiltro.setOrdernableGenericAsc(false);
        entidadFiltro.setOrdernableGenericDesc(false);
        if(sortField != null && !sortField.isEmpty()){
            if(SortOrder.ASCENDING.name().equals(sortOrder.name())){
                entidadFiltro.setOrdernableGenericAsc(true);
            }else if(SortOrder.DESCENDING.name().equals(sortOrder.name())){
                entidadFiltro.setOrdernableGenericDesc(true);
            }
            /**Asegurar que FIELD exista en la ENTIDAD PRINCIPAL (Ver Tabla DB)*/
            entidadFiltro.setAtributoOrdenacion(sortField);
        }
    }

    @Override
    public void cargarObjetoFiltros(int first, int pageSize, int counter) {
        if (vwControlperiodoFiltro== null) {
            vwControlperiodoFiltro = new VwControlperiodo();
        }
        vwControlperiodoFiltro.setString1("00000000");
        vwControlperiodoFiltro.setOrdernable(true);
        vwControlperiodoFiltro.setAtributoOrdenacion("secuencia");
        vwControlperiodoFiltro.setInicio(first);
        vwControlperiodoFiltro.setNumeroFilas(pageSize);
    }

    @Override
    public void btnBuscar() {
        buscarPrincipal();
    }

    @Override
    public void btnGuardar() {
        int result = 0;
        String onSuccesMsg = "";
        if(esValidoFormulario(ssControlperiodoRegistro)){
            transformarEntidad();
            if (MODO_ACTUAL.equals(MODO_NEW)) {
                result = ssControlperiodoService.guardar(ssControlperiodoRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_UPDATE)) {
                result = ssControlperiodoService.actualizar(ssControlperiodoRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_DELETE)) {
                result = ssControlperiodoService.eliminar(ssControlperiodoRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }

            if(result>0){
                btnCancelar();
                btnBuscar();
                FacesUtil.adicionarMensajeInfo(onSuccesMsg);
            }else{
                FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
            }
        }
    }
    public void transformarEntidad(){
        ssControlperiodoRegistro.setUsuarioCreacionGlobal(getUSUARIO_ACTUAL().toUpperCase());
        ssControlperiodoRegistro.setUltimousuario(getUSUARIO_ACTUAL().toUpperCase());
        ssControlperiodoRegistro.setCreacionfecha(new Date());
        ssControlperiodoRegistro.setUltimafechamodif(new Date());
    }
    public void btnAperturar() {
        int result = 0;
        String onSuccesMsg = "";
        if(esValidoFormulario(ssControlperiodoRegistro)){
            List<VwControlperiodo> listadoTemp;
            if (indicaSeleccionTotal){
                listadoTemp = ssControlperiodoService.listarVista(vwControlperiodoFiltro,false);
            }else{
                listadoTemp = listaSeleccionTotal;
            }
            result = ssControlperiodoService.registrarVista(listadoTemp,vwControlperiodoFiltro, false );
            if(result>0){
                btnCancelar();
                btnBuscar();
                FacesUtil.adicionarMensajeInfo(onSuccesMsg);
            }else{
                FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
            }
        }

    }
    public boolean esValidoFormulario( SsControlperiodo objSave) {
        boolean validoFormulario = true;
        if (UtilesCommons.esVacio(vwControlperiodoFiltro.getInteger1())){
            FacesUtil.adicionarMensajeWarning("Ingreso el año de apertura.");
            validoFormulario = false;
            return validoFormulario;
        }
        if (indicaSeleccionTotal){
            if (!(listaDataModel.size()>0)){
                FacesUtil.adicionarMensajeWarning("Seleccione EPS.");
                validoFormulario = false;
                return validoFormulario;
            }else{
                if (listaDataModel.get(0).getAnno()==vwControlperiodoFiltro.getInteger1()){
                    FacesUtil.adicionarMensajeWarning("Ya existe una apertura para este año..");
                    validoFormulario = false;
                    return validoFormulario;
                }
            }

        }else{
            if (!(listaSeleccionTotal.size()>0)){
                FacesUtil.adicionarMensajeWarning("Seleccione EPS.");
                validoFormulario = false;
            }
            if (listaSeleccionTotal.size()>0){
                Integer nYear = 0;
                if (UtilesCommons.noEsVacio(listaSeleccionTotal.get(0).getAnno())) {
                    FacesUtil.adicionarMensajeWarning("Ya existe apertura para este año");
                    validoFormulario = false;
                }
            }
        }
        /*
        SsControlperiodo busqueda = ssControlperiodoService.buscar(ssControlperiodoRegistro);
        if (busqueda != null && MODO_ACTUAL.equals(MODO_NEW)) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_EXISTEREGISTRO"));
            validoFormulario = false;
        }*/
        return validoFormulario;
    }
    public boolean esValidoxFormulario( SsControlperiodo validaxFormulario) {
        boolean validoxFormulario = true;

        return validoxFormulario;
    }
    @Override
    public void btnAceptar() {
        visibleRegistro = false;
        ssControlperiodoRegistro = new SsControlperiodo();
        ssControlperiodoSeleccion = new SsControlperiodo();
    }

    @Override
    public void btnCancelar() {
        visibleRegistro = false;
        ssControlperiodoRegistro = new SsControlperiodo();
        ssControlperiodoSeleccion = new SsControlperiodo();
    }

    @Override
    public void btnNuevo() {
        MODO_ACTUAL = MODO_NEW;
        ssControlperiodoRegistro.setEstado("A");
        //ssControlperiodoRegistro = new SsControlperiodo();
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getCompanyowner()))
            ssControlperiodoRegistro.setCompanyowner(vwControlperiodoFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getSucursal()))
            ssControlperiodoRegistro.setSucursal(vwControlperiodoFiltro.getSucursal());
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getProyectoid()))
            ssControlperiodoRegistro.setProyectoid(vwControlperiodoFiltro.getProyectoid());
        if (UtilesCommons.noEsVacio(vwControlperiodoFiltro.getAnno()))
            ssControlperiodoRegistro.setAnno(vwControlperiodoFiltro.getAnno());
        setAtributosWindowsRegistro(MODO_ACTUAL);
    }

    @Override
    public void btnModificar() {
        if (vwControlperiodoSelect != null) {
            ssControlperiodoSeleccion = new SsControlperiodo();
            ssControlperiodoSeleccion.setCompanyowner(vwControlperiodoSelect.getCompanyowner());
            ssControlperiodoSeleccion.setSucursal(vwControlperiodoSelect.getSucursal());
            ssControlperiodoSeleccion.setProyectoid(vwControlperiodoSelect.getProyectoid());
            ssControlperiodoSeleccion.setAnno(vwControlperiodoSelect.getAnno());
            ssControlperiodoRegistro = ssControlperiodoService.buscar(ssControlperiodoSeleccion);
            MODO_ACTUAL = MODO_UPDATE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        }else{
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnVer() {
        if (ssControlperiodoSeleccion != null) {
            MODO_ACTUAL = MODO_VIEW;
            setAtributosWindowsRegistro(MODO_VIEW);
        } else {
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnEliminar() {
        if (ssControlperiodoSeleccion != null) {
            MODO_ACTUAL = MODO_DELETE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        } else {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
        }
    }
    public void onSeleccionTotal(){
        if(indicaSeleccionTotal){
            indicaProceso="APROB_MASIVA";
            listaSeleccion.clear();
            listaSeleccion.addAll(listaDataModel);
        }else{
            listaSeleccion.clear();
        }
        onRowToggleSelect();
    }
    public void onRowToggleSelect(){
        listaSeleccionTotal.clear();
        if(UtilesCommons.noEsVacio(listaSeleccion)){
            indicaSeleccionTotal = true;

        }else{
            indicaSeleccionTotal = false;
        }
    }

    /** Evento al Seleccionar una fila A TARVES DEL CHECK de SELECCION
     * @param event
     */
    public void onRowSelectCheckboxAction( SelectEvent event){
        if(indicaSeleccionTotal){
            listaSeleccionTotal.clear();
            indicaSeleccionTotal = false;
        }else{
            //indicaSeleccionFilas= false;
        }

        Object obj = event.getObject();
        if(obj != null){
            VwControlperiodo voucherUnselected = (VwControlperiodo)obj;
            agregarElementoListaSeleccionTotal(voucherUnselected);
        }
    }

    /** Evento al DESSeleccionar una fila A TARVES DEL CHECK de SELECCION
     * @param event
     */
    public void onRowUnselectCheckbox(UnselectEvent event ){
        Object obj = event.getObject();
        if(obj != null){
            VwControlperiodo voucherUnselected = (VwControlperiodo)obj;
            quitarListaSeleccionTotal(voucherUnselected);
        }
        if(indicaSeleccionTotal){
            listaSeleccionTotal.clear();
            indicaSeleccionTotal = false;
        }

    }
    public void agregarElementoListaSeleccionTotal(VwControlperiodo objSelecc) {
        if(listaSeleccionTotal == null){
            listaSeleccionTotal = UtilesCommons.getNewList();
        }
        boolean existe = listaSeleccionTotal.stream()
                .anyMatch(p -> p.getCompanyowner().equals(objSelecc.getCompanyowner())
                        && p.getAnno().equals(objSelecc.getAnno())
                );
        if(!existe){
            listaSeleccionTotal.add(objSelecc);
        }
        if (listaSeleccionTotal.size()>0)
        {indicaSeleccionFilas=true;}
        else
        {indicaSeleccionFilas=false;}

    }

    /** QUITAR en elemento de la LISTA DE SELECCION TOTAL
     * @param objDeseleccionar
     */
    public void quitarListaSeleccionTotal(VwControlperiodo objDeseleccionar) {
        if(UtilesCommons.noEsVacio(listaSeleccionTotal)){
            Optional<VwControlperiodo> opVoucherDel = listaSeleccionTotal.stream()
                    .filter(p -> p.getCompanyowner().equals(objDeseleccionar.getCompanyowner())
                            && p.getAnno().equals(objDeseleccionar.getAnno())
                    ).findFirst();
            if(opVoucherDel.isPresent()){
                listaSeleccionTotal.remove(opVoucherDel.get());
            }
        }
        if (listaSeleccionTotal.size()>0)
        {indicaSeleccionFilas=true;}
        else
        {indicaSeleccionFilas=false;}
    }
    /** Evento al Seleccionar una fila INDIVUDUALMENTE
     * @param event
     */
    public void onRowSelect(SelectEvent event){
        listaSeleccionTotal.clear();
        onRowSelectCheckboxAction(event);
        //matchListaSeleccionActualConSeleccionTotal(listaDataModel);
    }

    public void onRowUnselect(UnselectEvent event){
        listaSeleccionTotal.clear();
        onRowUnselectCheckbox(event);
    }


    public void onAceptarConfirmacion() {
        if(accionEventoConfirmacion != null){
            accionEventoConfirmacion.accept(ValorRetorno.OK);
        }

        if("APROB_MASIVA".equals(indicaProceso)){


        }else if("RECHAZO_MASIVA".equals(indicaProceso)){
            //...
        }

        FacesUtil.execute("PF('"+DIALOG_CONFIRM_OPERACION+"').hide();");
    }
    @Override
    public void abrirRegistro() {

    }

    public CompaniaOwnerService getCompaniaOwnerService() {
        return companiaOwnerService;
    }

    public void setCompaniaOwnerService(CompaniaOwnerService companiaOwnerService) {
        this.companiaOwnerService = companiaOwnerService;
    }

    public MaMiscelaneosdetalleService getMaMiscelaneosdetalleService() {
        return maMiscelaneosdetalleService;
    }

    public void setMaMiscelaneosdetalleService(MaMiscelaneosdetalleService maMiscelaneosdetalleService) {
        this.maMiscelaneosdetalleService = maMiscelaneosdetalleService;
    }

    public SaTipofuenteService getSaTipofuenteService() {
        return saTipofuenteService;
    }

    public void setSaTipofuenteService(SaTipofuenteService saTipofuenteService) {
        this.saTipofuenteService = saTipofuenteService;
    }



    public AcSucursalService getAcSucursalService() {
        return acSucursalService;
    }

    public void setAcSucursalService(AcSucursalService acSucursalService) {
        this.acSucursalService = acSucursalService;
    }

    public SsProyectoService getSsProyectoService() {
        return ssProyectoService;
    }

    public void setSsProyectoService(SsProyectoService ssProyectoService) {
        this.ssProyectoService = ssProyectoService;
    }

    public List<SaTipofuente> getListarFuente() {
        return listarFuente;
    }

    public void setListarFuente(List<SaTipofuente> listarFuente) {
        this.listarFuente = listarFuente;
    }

    public List<AcSucursal> getListarSucursal() {
        return listarSucursal;
    }

    public void setListarSucursal(List<AcSucursal> listarSucursal) {
        this.listarSucursal = listarSucursal;
    }

    public List<SsProyecto> getListarProyecto() {
        return listarProyecto;
    }

    public void setListarProyecto(List<SsProyecto> listarProyecto) {
        this.listarProyecto = listarProyecto;
    }

    public List<SsControlperiodo> getListarCargaInicial() {
        return listarCargaInicial;
    }

    public void setListarCargaInicial(List<SsControlperiodo> listarCargaInicial) {
        this.listarCargaInicial = listarCargaInicial;
    }

    public SsControlperiodo getSsControlperiodoRegistro() {
        return ssControlperiodoRegistro;
    }

    public void setSsControlperiodoRegistro(SsControlperiodo ssControlperiodoRegistro) {
        this.ssControlperiodoRegistro = ssControlperiodoRegistro;
    }

    public SsControlperiodo getSsControlperiodoSeleccion() {
        return ssControlperiodoSeleccion;
    }

    public void setSsControlperiodoSeleccion(SsControlperiodo ssControlperiodoSeleccion) {
        this.ssControlperiodoSeleccion = ssControlperiodoSeleccion;
    }

    public SsControlperiodo getSsControlperiodoFiltro() {
        return ssControlperiodoFiltro;
    }

    public void setSsControlperiodoFiltro(SsControlperiodo ssControlperiodoFiltro) {
        this.ssControlperiodoFiltro = ssControlperiodoFiltro;
    }

    public VwControlperiodo getVwControlperiodoSelect() {
        return vwControlperiodoSelect;
    }

    public void setVwControlperiodoSelect(VwControlperiodo vwControlperiodoSelect) {
        this.vwControlperiodoSelect = vwControlperiodoSelect;
    }

    public VwControlperiodo getVwControlperiodoFiltro() {
        return vwControlperiodoFiltro;
    }

    public void setVwControlperiodoFiltro(VwControlperiodo vwControlperiodoFiltro) {
        this.vwControlperiodoFiltro = vwControlperiodoFiltro;
    }

    public List<Companyowner> getListarCompanias() {
        return listarCompanias;
    }

    public void setListarCompanias(List<Companyowner> listarCompanias) {
        this.listarCompanias = listarCompanias;
    }

    public List<MaMiscelaneosdetalle> getMaMisTipoFuente() {
        return maMisTipoFuente;
    }

    public void setMaMisTipoFuente(List<MaMiscelaneosdetalle> maMisTipoFuente) {
        this.maMisTipoFuente = maMisTipoFuente;
    }

    public List<MaMiscelaneosdetalle> getMaMisDestalleEstadoDocumento() {
        return maMisDestalleEstadoDocumento;
    }

    public void setMaMisDestalleEstadoDocumento(List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento) {
        this.maMisDestalleEstadoDocumento = maMisDestalleEstadoDocumento;
    }

    public List<MaMiscelaneosdetalle> getMaMisSubTipoInfraestructura() {
        return maMisSubTipoInfraestructura;
    }

    public void setMaMisSubTipoInfraestructura(List<MaMiscelaneosdetalle> maMisSubTipoInfraestructura) {
        this.maMisSubTipoInfraestructura = maMisSubTipoInfraestructura;
    }

    public LazyDataModel<VwControlperiodo> getDataModel() {
        return dataModel;
    }

    public void setDataModel(LazyDataModel<VwControlperiodo> dataModel) {
        this.dataModel = dataModel;
    }

    public List<VwControlperiodo> getListaDataModel() {
        return listaDataModel;
    }

    public void setListaDataModel(List<VwControlperiodo> listaDataModel) {
        this.listaDataModel = listaDataModel;
    }

    public Companyowner getCompaniaDefault() {
        return companiaDefault;
    }

    public void setCompaniaDefault(Companyowner companiaDefault) {
        this.companiaDefault = companiaDefault;
    }

    public String getFuenteidLocal() {
        return fuenteidLocal;
    }

    public void setFuenteidLocal(String fuenteidLocal) {
        this.fuenteidLocal = fuenteidLocal;
    }

    public boolean isIndicaSeleccionTotal() {
        return indicaSeleccionTotal;
    }

    public void setIndicaSeleccionTotal(boolean indicaSeleccionTotal) {
        this.indicaSeleccionTotal = indicaSeleccionTotal;
    }

    public boolean isIndicaSeleccionFilas() {
        return indicaSeleccionFilas;
    }

    public void setIndicaSeleccionFilas(boolean indicaSeleccionFilas) {
        this.indicaSeleccionFilas = indicaSeleccionFilas;
    }

    public Integer getElementosListadoTotal() {
        return elementosListadoTotal;
    }

    public void setElementosListadoTotal(Integer elementosListadoTotal) {
        this.elementosListadoTotal = elementosListadoTotal;
    }

    public List<VwControlperiodo> getListaSelecionados() {
        return listaSelecionados;
    }

    public void setListaSelecionados(List<VwControlperiodo> listaSelecionados) {
        this.listaSelecionados = listaSelecionados;
    }

    public Consumer<String> getAccionEventoConfirmacion() {
        return accionEventoConfirmacion;
    }

    public void setAccionEventoConfirmacion(Consumer<String> accionEventoConfirmacion) {
        this.accionEventoConfirmacion = accionEventoConfirmacion;
    }

    public String getMensajeConfirmacion() {
        return mensajeConfirmacion;
    }

    public void setMensajeConfirmacion(String mensajeConfirmacion) {
        this.mensajeConfirmacion = mensajeConfirmacion;
    }

    public String getAccionFiltro() {
        return accionFiltro;
    }

    public void setAccionFiltro(String accionFiltro) {
        this.accionFiltro = accionFiltro;
    }

    public boolean isModoAprobarRechazar() {
        return modoAprobarRechazar;
    }

    public void setModoAprobarRechazar(boolean modoAprobarRechazar) {
        this.modoAprobarRechazar = modoAprobarRechazar;
    }

    public boolean isModoDesaprobar() {
        return modoDesaprobar;
    }

    public void setModoDesaprobar(boolean modoDesaprobar) {
        this.modoDesaprobar = modoDesaprobar;
    }

    public String getIndicaProceso() {
        return indicaProceso;
    }

    public void setIndicaProceso(String indicaProceso) {
        this.indicaProceso = indicaProceso;
    }

    public List<VwControlperiodo> getListaSeleccion() {
        return listaSeleccion;
    }

    public void setListaSeleccion(List<VwControlperiodo> listaSeleccion) {
        this.listaSeleccion = listaSeleccion;
    }

    public List<VwControlperiodo> getListaSeleccionTotal() {
        return listaSeleccionTotal;
    }

    public void setListaSeleccionTotal(List<VwControlperiodo> listaSeleccionTotal) {
        this.listaSeleccionTotal = listaSeleccionTotal;
    }

    public SsControlperiodoService getSsControlperiodoService() {
        return ssControlperiodoService;
    }

    public void setSsControlperiodoService(SsControlperiodoService ssControlperiodoService) {
        this.ssControlperiodoService = ssControlperiodoService;
    }

    //SetGet
}

