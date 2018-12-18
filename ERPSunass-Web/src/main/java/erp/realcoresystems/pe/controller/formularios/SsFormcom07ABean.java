package erp.realcoresystems.pe.controller.formularios;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.AcSucursalService;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.SsFormcom07AService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "ssFormcom07ABean")
@ViewScoped
public class SsFormcom07ABean extends AbstractGenericBean implements InterfaceGenericBean {

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value="#{acSucursalService}")
    private AcSucursalService acSucursalService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    @ManagedProperty(value="#{ssFormcom07AService}")
    private SsFormcom07AService ssFormcom07AService;

    private List<AcSucursal> listarSucursal ;
    private List<Companyowner> listarCompanias;

    private List<MaMiscelaneosdetalle> maMisTipoFuente;
    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private List<MaMiscelaneosdetalle> maMisSubTipoInfraestructura;
    private List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuencia;
    private List<MaMiscelaneosdetalle> maMiscelaneosdellTipoFecuenciaHijo;
    private List<MaMiscelaneosdetalle> maMiscelaneosdellTipoCategoriaTar;

    private LazyDataModel<SsFormcom07A> dataModel;
    private List<SsFormcom07A> listaDataModel;

    private List<SsFormcom07A> ssFormcom07AFiltroListar;

    // Entity
    private SsFormcom07A ssFormcom07AFiltro = new SsFormcom07A();
    private SsFormcom07A ssFormcom07ASeleccion = new SsFormcom07A();
    private SsFormcom07A ssFormcom07ARegistro = new SsFormcom07A();


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

    @Override
    public void cargarObjetoFiltros(int first, int pageSize, int counter) {

    }

    @Override
    public void btnBuscar() {

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
        MODO_ACTUAL = MODO_NEW;
        ssFormcom07ARegistro.setCresEstado("A");
        ssFormcom07ARegistro.setCresEstadodocumento(2);
        if (UtilesCommons.noEsVacio(ssFormcom07AFiltro.getCompanyowner()))
            ssFormcom07ARegistro.setCompanyowner(ssFormcom07AFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(ssFormcom07AFiltro.getSucursal()))
            ssFormcom07ARegistro.setSucursal(ssFormcom07AFiltro.getSucursal());
        setAtributosWindowsRegistro(MODO_ACTUAL);
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

    public void inicializarEntidad(){
        FacesUtil.removeIfExistsSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);

        ssFormcom07AFiltro = new SsFormcom07A();
        ssFormcom07ASeleccion = new SsFormcom07A();
        ssFormcom07ARegistro = new SsFormcom07A();
        maMisTipoFuente = UtilesCommons.getNewList();
        maMisDestalleEstadoDocumento = UtilesCommons.getNewList();
        maMisSubTipoInfraestructura = UtilesCommons.getNewList();
        maMiscelaneosdellTipoFecuencia = UtilesCommons.getNewList();
        ssFormcom07AFiltroListar = UtilesCommons.getNewList();
        listaDataModel = UtilesCommons.getNewList();
    }

    public void inicializarDatoInicial(){
        cargarCompaniaPermisos();
        cargarSucursal();
        ssFormcom07ARegistro.setFfanno(EntityGlobal.getInstance().getPeriodoAnnoActual());
        ssFormcom07AFiltro.setFfanno(EntityGlobal.getInstance().getPeriodoAnnoActual());
        ssFormcom07AFiltro.setTipofrecuencia("MENSUAL");
        ssFormcom07ARegistro.setTipofrecuencia("MENSUAL");

        maMisDestalleEstadoDocumento = listarMiscelaneosDetalle("","ESTADODOC");
        maMiscelaneosdellTipoFecuencia = listarMiscelaneosDetalle("","TIPOFRECUE");
        maMisSubTipoInfraestructura = listarMiscelaneosDetalle("", "SUBTIPINFR");
        maMiscelaneosdellTipoFecuenciaHijo = listarMiscelaneosDetalle("", "MENSUAL");
        maMiscelaneosdellTipoCategoriaTar = listarMiscelaneosDetalle("", "TIPCATETAR");
        
        buscarPrincipal();
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

    public LazyDataModel<SsFormcom07A> buscarPrincipal() {
        dataModel = new LazyDataModel<SsFormcom07A>() {
            private static final long serialVersionUID = 1L;

            @Override
            public List<SsFormcom07A> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                           Map<String, Object> filters) {
                cargarObjetoFiltros(first, pageSize, 0);
                setOrderListadoGeneric(ssFormcom07AFiltro, sortField, sortOrder);
                listaDataModel = ssFormcom07AService.listar(ssFormcom07AFiltro,true);
                if(UtilesCommons.noEsVacio(listaDataModel)){
                    setRowCount(ssFormcom07AService.contar(ssFormcom07AFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return listaDataModel;
            }

            @Override
            public SsFormcom07A getRowData(String rowKey) {
                for (SsFormcom07A event : listaDataModel) {
                    if ((event.getSecuencia().toString().equals(rowKey))) {
                        ssFormcom07ASeleccion= (SsFormcom07A) event;
                        return ssFormcom07ASeleccion;
                    }
                }
                return null;
            }

            @Override
            public Object getRowKey(SsFormcom07A event) {
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

    public List<Companyowner> cargarCompaniaPermisos(){
        listarCompanias = companiaOwnerService.listarSeguridad(
                new Companyowner(),EntityGlobal.getInstance().getUsuario());
        if (listarCompanias.size()>0){
            companiaDefault = listarCompanias.get(0);
            ssFormcom07AFiltro.setCompanyowner(companiaDefault.getCompanyowner());
            ssFormcom07ARegistro.setCompanyowner(companiaDefault.getCompanyowner());
        }
        return listarCompanias;
    }

    public List<AcSucursal> cargarSucursal(){
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(companiaDefault.getCompanyowner());
        listarSucursal  = acSucursalService.sucursalListar(objBusc);
        if (listarSucursal.size()>0){
            ssFormcom07AFiltro.setSucursal(listarSucursal.get(0).getSucursal());
            ssFormcom07ARegistro.setSucursal(listarSucursal.get(0).getSucursal());
        }
        return listarSucursal;
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

    public SsFormcom07AService getSsFormcom07AService() {
        return ssFormcom07AService;
    }

    public void setSsFormcom07AService(SsFormcom07AService ssFormcom07AService) {
        this.ssFormcom07AService = ssFormcom07AService;
    }

    public List<AcSucursal> getListarSucursal() {
        return listarSucursal;
    }

    public void setListarSucursal(List<AcSucursal> listarSucursal) {
        this.listarSucursal = listarSucursal;
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

    public LazyDataModel<SsFormcom07A> getDataModel() {
        return dataModel;
    }

    public void setDataModel(LazyDataModel<SsFormcom07A> dataModel) {
        this.dataModel = dataModel;
    }

    public List<SsFormcom07A> getListaDataModel() {
        return listaDataModel;
    }

    public void setListaDataModel(List<SsFormcom07A> listaDataModel) {
        this.listaDataModel = listaDataModel;
    }

    public List<SsFormcom07A> getSsFormcom07AFiltroListar() {
        return ssFormcom07AFiltroListar;
    }

    public void setSsFormcom07AFiltroListar(List<SsFormcom07A> ssFormcom07AFiltroListar) {
        this.ssFormcom07AFiltroListar = ssFormcom07AFiltroListar;
    }

    public SsFormcom07A getSsFormcom07AFiltro() {
        return ssFormcom07AFiltro;
    }

    public void setSsFormcom07AFiltro(SsFormcom07A ssFormcom07AFiltro) {
        this.ssFormcom07AFiltro = ssFormcom07AFiltro;
    }

    public SsFormcom07A getSsFormcom07ASeleccion() {
        return ssFormcom07ASeleccion;
    }

    public void setSsFormcom07ASeleccion(SsFormcom07A ssFormcom07ASeleccion) {
        this.ssFormcom07ASeleccion = ssFormcom07ASeleccion;
    }

    public SsFormcom07A getSsFormcom07ARegistro() {
        return ssFormcom07ARegistro;
    }

    public void setSsFormcom07ARegistro(SsFormcom07A ssFormcom07ARegistro) {
        this.ssFormcom07ARegistro = ssFormcom07ARegistro;
    }

    public Companyowner getCompaniaDefault() {
        return companiaDefault;
    }

    public void setCompaniaDefault(Companyowner companiaDefault) {
        this.companiaDefault = companiaDefault;
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

    public List<MaMiscelaneosdetalle> getMaMiscelaneosdellTipoCategoriaTar() {
        return maMiscelaneosdellTipoCategoriaTar;
    }

    public void setMaMiscelaneosdellTipoCategoriaTar(List<MaMiscelaneosdetalle> maMiscelaneosdellTipoCategoriaTar) {
        this.maMiscelaneosdellTipoCategoriaTar = maMiscelaneosdellTipoCategoriaTar;
    }
}
