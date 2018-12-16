package erp.realcoresystems.pe.controller.formularios;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.*;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.*;


@ManagedBean(name = "ssFormcal11CBean")
@ViewScoped
public class SsFormcal11CBean extends AbstractGenericBean implements InterfaceGenericBean {

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value="#{acSucursalService}")
    private AcSucursalService acSucursalService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    @ManagedProperty(value="#{ssFormcal11CService}")
    private SsFormcal11CService ssFormcal11CService;

    private  List<AcSucursal> listarSucursal ;
    private List<Companyowner> listarCompanias;

    private List<MaMiscelaneosdetalle> maMisTipoFuente;
    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private List<MaMiscelaneosdetalle> maMisSubTipoInfraestructura;
    private List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuencia;
    private List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuenciaHijo;

    protected LazyDataModel<SsFormcal11C> dataModel;
    protected List<SsFormcal11C> listaDataModel;

    private List<SsFormcal11C> ssFormcal11CFiltroListar;

    // Entity
    private SsFormcal11C ssFormcal11CFiltro = new SsFormcal11C();
    private SsFormcal11C ssFormcal11CSeleccion = new SsFormcal11C();
    private SsFormcal11C ssFormcal11CRegistro = new SsFormcal11C();


    private Companyowner companiaDefault;

    private boolean buttonesEstado;
    private String mensajeEstado;


    @PostConstruct
    public void inicializar() {
        super.initComponentes();
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        inicializarEntidad();
        inicializarDatoInicial();


    }


    public void inicializarEntidad(){
        FacesUtil.removeIfExistsSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);

        ssFormcal11CFiltro = new SsFormcal11C();
        ssFormcal11CSeleccion = new SsFormcal11C();
        ssFormcal11CRegistro = new SsFormcal11C();
        maMisTipoFuente = UtilesCommons.getNewList();
        maMisDestalleEstadoDocumento = UtilesCommons.getNewList();
        maMisSubTipoInfraestructura = UtilesCommons.getNewList();
        maMiscelaneosdellTipoFecuencia = UtilesCommons.getNewList();
        ssFormcal11CFiltroListar = UtilesCommons.getNewList();
        listaDataModel = UtilesCommons.getNewList();


    }
    public void inicializarDatoInicial(){
        cargarCompaniaPermisos();
        cargarSucursal();
        ssFormcal11CRegistro.setFfanno(EntityGlobal.getInstance().getPeriodoAnnoActual());
        ssFormcal11CFiltro.setFfanno(EntityGlobal.getInstance().getPeriodoAnnoActual());
        ssFormcal11CFiltro.setTipofrecuencia("MENSUAL");
        ssFormcal11CRegistro.setTipofrecuencia("MENSUAL");

        maMisDestalleEstadoDocumento = listarMiscelaneosDetalle("","ESTADODOC");
        maMiscelaneosdellTipoFecuencia = listarMiscelaneosDetalle("","TIPOFRECUE");
        maMisSubTipoInfraestructura = listarMiscelaneosDetalle("", "SUBTIPINFR");
        maMiscelaneosdellTipoFecuenciaHijo = listarMiscelaneosDetalle("", "MENSUAL");


        buscarPrincipal();
    }
    public List<Companyowner> cargarCompaniaPermisos(){
        listarCompanias = companiaOwnerService.listarSeguridad(
                new Companyowner(),EntityGlobal.getInstance().getUsuario());
        if (listarCompanias.size()>0){
            companiaDefault = listarCompanias.get(0);
            ssFormcal11CFiltro.setCompanyowner(companiaDefault.getCompanyowner());
            ssFormcal11CRegistro.setCompanyowner(companiaDefault.getCompanyowner());
        }
        return listarCompanias;
    }
    public List<AcSucursal> cargarSucursal(){
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(companiaDefault.getCompanyowner());
        listarSucursal  = acSucursalService.sucursalListar(objBusc);
        if (listarSucursal.size()>0){
            ssFormcal11CFiltro.setSucursal(listarSucursal.get(0).getSucursal());
            ssFormcal11CRegistro.setSucursal(listarSucursal.get(0).getSucursal());
        }
        return listarSucursal;
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
    public LazyDataModel<SsFormcal11C> buscarPrincipal() {
        dataModel = new LazyDataModel<SsFormcal11C>() {
            private static final long serialVersionUID = 1L;

            @Override
            public List<SsFormcal11C> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                               Map<String, Object> filters) {
                cargarObjetoFiltros(first, pageSize, 0);
                setOrderListadoGeneric(ssFormcal11CFiltro, sortField, sortOrder);
                listaDataModel = ssFormcal11CService.listar(ssFormcal11CFiltro,true);
                if(UtilesCommons.noEsVacio(listaDataModel)){
                    setRowCount(ssFormcal11CService.contar(ssFormcal11CFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return listaDataModel;
            }

            @Override
            public SsFormcal11C getRowData(String rowKey) {
                for (SsFormcal11C event : listaDataModel) {
                    if ((event.getSecuencia().toString().equals(rowKey))) {
                        ssFormcal11CSeleccion= (SsFormcal11C) event;
                        return ssFormcal11CSeleccion;
                    }
                }
                return null;
            }

            @Override
            public Object getRowKey(SsFormcal11C event) {
                return (event.getSecuencia().toString());
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

    }

    @Override
    public void btnBuscar() {

    }

    @Override
    public void btnGuardar() {
        int result = 0;
        String onSuccesMsg = "";
        if(esValidoFormulario(ssFormcal11CRegistro)){
            transformarEntidad();
            if (MODO_ACTUAL.equals(MODO_NEW)) {
                result = ssFormcal11CService.guardar(ssFormcal11CRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_UPDATE)) {
                result = ssFormcal11CService.actualizar(ssFormcal11CRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_DELETE)) {
                result = ssFormcal11CService.eliminar(ssFormcal11CRegistro);
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
    public boolean esValidoFormulario( SsFormcal11C objSave) {
        boolean validoFormulario = true;

        if (!UtilesCommons.noEsVacio(ssFormcal11CRegistro.getCompanyowner())) {
            FacesUtil.adicionarMensajeWarning("Seleccione  EPS.");
            //FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("Seleccione  EPS."));
            validoFormulario = false;
        }
        if (!UtilesCommons.noEsVacio(ssFormcal11CRegistro.getSucursal())) {
            FacesUtil.adicionarMensajeWarning("Seleccione Localidad");
            //FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("Seleccione Localidad"));
            validoFormulario = false;
        }

        SsFormcal11C busqueda = ssFormcal11CService.buscar(ssFormcal11CRegistro);
        if (busqueda != null && MODO_ACTUAL.equals(MODO_NEW)) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_EXISTEREGISTRO"));
            validoFormulario = false;
        }
        return validoFormulario;
    }
    public void transformarEntidad(){
        ssFormcal11CRegistro.setUsuarioCreacionGlobal(getUSUARIO_ACTUAL().toUpperCase());
        ssFormcal11CRegistro.setUltimousuario(getUSUARIO_ACTUAL().toUpperCase());
        ssFormcal11CRegistro.setCreacionfecha(new Date());
        ssFormcal11CRegistro.setUltimafechamodif(new Date());
    }
    @Override
    public void btnAceptar() {
        visibleRegistro = false;
        ssFormcal11CRegistro = new SsFormcal11C();
        ssFormcal11CSeleccion = new SsFormcal11C();
    }

    @Override
    public void btnCancelar() {
        visibleRegistro = false;
        ssFormcal11CRegistro = new SsFormcal11C();
        ssFormcal11CSeleccion = new SsFormcal11C();
    }

    @Override
    public void btnNuevo() {
        MODO_ACTUAL = MODO_NEW;
        ssFormcal11CRegistro.setCmueEstado("A");
        ssFormcal11CRegistro.setCmueEstadodocumento(2);
        if (UtilesCommons.noEsVacio(ssFormcal11CFiltro.getCompanyowner()))
            ssFormcal11CRegistro.setCompanyowner(ssFormcal11CFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(ssFormcal11CFiltro.getSucursal()))
            ssFormcal11CRegistro.setSucursal(ssFormcal11CFiltro.getSucursal());
        setAtributosWindowsRegistro(MODO_ACTUAL);
    }

    @Override
    public void btnModificar() {
        if (ssFormcal11CSeleccion != null) {
            ssFormcal11CRegistro = ssFormcal11CService.buscar(ssFormcal11CSeleccion);
            MODO_ACTUAL = MODO_UPDATE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        }else{
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnVer() {
        if (ssFormcal11CRegistro != null) {
            MODO_ACTUAL = MODO_VIEW;
            setAtributosWindowsRegistro(MODO_VIEW);
        } else {
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnEliminar() {
        if (ssFormcal11CRegistro != null) {
            MODO_ACTUAL = MODO_DELETE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        } else {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
        }
    }

    @Override
    public void abrirRegistro() {

    }
    public void seleccionarPeriodo(){
        //ssFormcal11CFiltro.setTipofrecuencia("MENSUAL");
        //ssFormcal11CRegistro.setTipofrecuencia("MENSUAL");
        maMiscelaneosdellTipoFecuenciaHijo = listarMiscelaneosDetalle("", ssFormcal11CFiltro.getTipofrecuencia());
    }
    public void seleccionarPeriodoRegistro(){
        //ssFormcal11CFiltro.setTipofrecuencia("MENSUAL");
        //ssFormcal11CRegistro.setTipofrecuencia("MENSUAL");
        maMiscelaneosdellTipoFecuenciaHijo = listarMiscelaneosDetalle("", ssFormcal11CRegistro.getTipofrecuencia());
    }
    public void seleccionarSucursal() {
        SsControlperiodo tempPeriodo = new SsControlperiodo();
        /*if (UtilesCommons.noEsVacio(ssFormcal11CRegistro.getCompanyowner())) {
            cargarSucursal();
        }
        listarSucursal = UtilesCommons.getCleanList(listarSucursal);
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(vwCargaInicialFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getCompanyowner())) {
            listarSucursal  = acSucursalService.sucursalListar(objBusc);
            int a=0;
        }*/
    }






    public CompaniaOwnerService getCompaniaOwnerService() {
        return companiaOwnerService;
    }

    public void setCompaniaOwnerService(CompaniaOwnerService companiaOwnerService) {
        this.companiaOwnerService = companiaOwnerService;
    }

    public AcSucursalService getAcSucursalService() {
        return acSucursalService;
    }

    public void setAcSucursalService(AcSucursalService acSucursalService) {
        this.acSucursalService = acSucursalService;
    }

    public MaMiscelaneosdetalleService getMaMiscelaneosdetalleService() {
        return maMiscelaneosdetalleService;
    }

    public void setMaMiscelaneosdetalleService(MaMiscelaneosdetalleService maMiscelaneosdetalleService) {
        this.maMiscelaneosdetalleService = maMiscelaneosdetalleService;
    }

    public SsFormcal11CService getSsFormcal11CService() {
        return ssFormcal11CService;
    }

    public void setSsFormcal11CService(SsFormcal11CService ssFormcal11CService) {
        this.ssFormcal11CService = ssFormcal11CService;
    }

    public List<AcSucursal> getListarSucursal() {
        return listarSucursal;
    }

    public void setListarSucursal(List<AcSucursal> listarSucursal) {
        this.listarSucursal = listarSucursal;
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

    public LazyDataModel<SsFormcal11C> getDataModel() {
        return dataModel;
    }

    public void setDataModel(LazyDataModel<SsFormcal11C> dataModel) {
        this.dataModel = dataModel;
    }

    public List<SsFormcal11C> getListaDataModel() {
        return listaDataModel;
    }

    public void setListaDataModel(List<SsFormcal11C> listaDataModel) {
        this.listaDataModel = listaDataModel;
    }

    public List<SsFormcal11C> getSsFormcal11CFiltroListar() {
        return ssFormcal11CFiltroListar;
    }

    public void setSsFormcal11CFiltroListar(List<SsFormcal11C> ssFormcal11CFiltroListar) {
        this.ssFormcal11CFiltroListar = ssFormcal11CFiltroListar;
    }

    public SsFormcal11C getSsFormcal11CFiltro() {
        return ssFormcal11CFiltro;
    }

    public void setSsFormcal11CFiltro(SsFormcal11C ssFormcal11CFiltro) {
        this.ssFormcal11CFiltro = ssFormcal11CFiltro;
    }

    public SsFormcal11C getSsFormcal11CSeleccion() {
        return ssFormcal11CSeleccion;
    }

    public void setSsFormcal11CSeleccion(SsFormcal11C ssFormcal11CSeleccion) {
        this.ssFormcal11CSeleccion = ssFormcal11CSeleccion;
    }

    public SsFormcal11C getSsFormcal11CRegistro() {
        return ssFormcal11CRegistro;
    }

    public void setSsFormcal11CRegistro(SsFormcal11C ssFormcal11CRegistro) {
        this.ssFormcal11CRegistro = ssFormcal11CRegistro;
    }

    public Companyowner getCompaniaDefault() {
        return companiaDefault;
    }

    public void setCompaniaDefault(Companyowner companiaDefault) {
        this.companiaDefault = companiaDefault;
    }

    public List<Companyowner> getListarCompanias() {
        return listarCompanias;
    }

    public void setListarCompanias(List<Companyowner> listarCompanias) {
        this.listarCompanias = listarCompanias;
    }

    public boolean isButtonesEstado() {
        return buttonesEstado;
    }

    public void setButtonesEstado(boolean buttonesEstado) {
        this.buttonesEstado = buttonesEstado;
    }

    public String getMensajeEstado() {
        return mensajeEstado;
    }

    public void setMensajeEstado(String mensajeEstado) {
        this.mensajeEstado = mensajeEstado;
    }

    public List<MaMiscelaneosdetalle> getMaMiscelaneosdellTipoFecuencia() {
        return maMiscelaneosdellTipoFecuencia;
    }

    public void setMaMiscelaneosdellTipoFecuencia(List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuencia) {
        this.maMiscelaneosdellTipoFecuencia = maMiscelaneosdellTipoFecuencia;
    }


    public List<MaMiscelaneosdetalle> getMaMiscelaneosdellTipoFecuenciaHijo() {
        return maMiscelaneosdellTipoFecuenciaHijo;
    }

    public void setMaMiscelaneosdellTipoFecuenciaHijo(List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuenciaHijo) {
        this.maMiscelaneosdellTipoFecuenciaHijo = maMiscelaneosdellTipoFecuenciaHijo;
    }


}
