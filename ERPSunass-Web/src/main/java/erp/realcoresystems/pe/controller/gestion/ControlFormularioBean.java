package erp.realcoresystems.pe.controller.gestion;

import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.SsPeriodoformulariodetalle;
import erp.realcoresystems.pe.model.domain.vista.VwSsperiodoformulario;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.SsControlperiodoService;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "controlFormularioBean")
@ViewScoped
public class ControlFormularioBean extends AbstractGenericBean implements InterfaceGenericBean {
    // Service
    @ManagedProperty(value = "#{ssControlperiodoService}")
    private SsControlperiodoService ssControlperiodoService;

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    private List<MaMiscelaneosdetalle> maMisDestalleTipoFrencuencia;

    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private LazyDataModel<VwSsperiodoformulario> listaVwSsperiodoformularioModel;
    private List<VwSsperiodoformulario> listaVwSsperiodoformulario;

    // Entity
    private VwSsperiodoformulario controlPeriodoFiltro = new VwSsperiodoformulario();
    private VwSsperiodoformulario controlPeriodoSeleccion = new VwSsperiodoformulario();
    private SsPeriodoformulariodetalle ssPeriodoFormRegistro = new SsPeriodoformulariodetalle();

    // Variables
    private boolean chkEstado;
    private List<Companyowner>  listaCompanyowner;

    @PostConstruct
    public void iniciar() {
        FacesUtil.putSessionMap("namedBeanSingleton", "controlFormularioBean");
        super.initComponentes();
        ssPeriodoFormRegistro = new SsPeriodoformulariodetalle();
        controlPeriodoSeleccion = new VwSsperiodoformulario();
        controlPeriodoFiltro = new VwSsperiodoformulario();
        controlPeriodoFiltro.setEstado(Constant.ACTIVO);
        maMisDestalleTipoFrencuencia = new ArrayList<>();
        maMisDestalleEstadoDocumento = new ArrayList<>();
        listaCompanyowner = new ArrayList<>();

        //listarCompania();
       // buscarPrincipal();

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

    public SsControlperiodoService getSsControlperiodoService() {
        return ssControlperiodoService;
    }

    public void setSsControlperiodoService(SsControlperiodoService ssControlperiodoService) {
        this.ssControlperiodoService = ssControlperiodoService;
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

    public List<MaMiscelaneosdetalle> getMaMisDestalleTipoFrencuencia() {
        return maMisDestalleTipoFrencuencia;
    }

    public void setMaMisDestalleTipoFrencuencia(List<MaMiscelaneosdetalle> maMisDestalleTipoFrencuencia) {
        this.maMisDestalleTipoFrencuencia = maMisDestalleTipoFrencuencia;
    }

    public List<MaMiscelaneosdetalle> getMaMisDestalleEstadoDocumento() {
        return maMisDestalleEstadoDocumento;
    }

    public void setMaMisDestalleEstadoDocumento(List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento) {
        this.maMisDestalleEstadoDocumento = maMisDestalleEstadoDocumento;
    }

    public LazyDataModel<VwSsperiodoformulario> getListaVwSsperiodoformularioModel() {
        return listaVwSsperiodoformularioModel;
    }

    public void setListaVwSsperiodoformularioModel(LazyDataModel<VwSsperiodoformulario> listaVwSsperiodoformularioModel) {
        this.listaVwSsperiodoformularioModel = listaVwSsperiodoformularioModel;
    }

    public List<VwSsperiodoformulario> getListaVwSsperiodoformulario() {
        return listaVwSsperiodoformulario;
    }

    public void setListaVwSsperiodoformulario(List<VwSsperiodoformulario> listaVwSsperiodoformulario) {
        this.listaVwSsperiodoformulario = listaVwSsperiodoformulario;
    }

    public VwSsperiodoformulario getControlPeriodoFiltro() {
        return controlPeriodoFiltro;
    }

    public void setControlPeriodoFiltro(VwSsperiodoformulario controlPeriodoFiltro) {
        this.controlPeriodoFiltro = controlPeriodoFiltro;
    }

    public VwSsperiodoformulario getControlPeriodoSeleccion() {
        return controlPeriodoSeleccion;
    }

    public void setControlPeriodoSeleccion(VwSsperiodoformulario controlPeriodoSeleccion) {
        this.controlPeriodoSeleccion = controlPeriodoSeleccion;
    }

    public boolean isChkEstado() {
        return chkEstado;
    }

    public void setChkEstado(boolean chkEstado) {
        this.chkEstado = chkEstado;
    }

    public List<Companyowner> getListaCompanyowner() {
        return listaCompanyowner;
    }

    public void setListaCompanyowner(List<Companyowner> listaCompanyowner) {
        this.listaCompanyowner = listaCompanyowner;
    }

    public SsPeriodoformulariodetalle getSsPeriodoFormRegistro() {
        return ssPeriodoFormRegistro;
    }

    public void setSsPeriodoFormRegistro(SsPeriodoformulariodetalle ssPeriodoFormRegistro) {
        this.ssPeriodoFormRegistro = ssPeriodoFormRegistro;
    }
}
