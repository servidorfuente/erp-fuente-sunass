package erp.realcoresystems.pe.controller.formularios;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.SsFormcom01AService;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "sSFORMCOM01ABean")
@ViewScoped
public class SSFORMCOM01ABean extends AbstractGenericBean implements InterfaceGenericBean {
    // Service
    @ManagedProperty(value="#{ssFormcom01AService}")
    private SsFormcom01AService ssFormcom01AService;

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    private List<MaMiscelaneosdetalle> maMisDestalleTipoFrencuencia;

    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private LazyDataModel<SsFormcom01A> listaSsFormcom01AModel;
    private List<SsFormcom01A> listaSsFormcom01A;

    // Entity
    private SsFormcom01A ssFormcom01AFiltro = new SsFormcom01A();
    private SsFormcom01A ssFormcom01ASeleccion = new SsFormcom01A();
    private SsFormcom01A ssFormcom01ARegistro = new SsFormcom01A();

    // Variables
    private boolean chkEstado;
    private List<Companyowner>  listaCompanyowner;

    @PostConstruct
    public void iniciar() {
        FacesUtil.putSessionMap("namedBeanSingleton", "controlFormularioBean");
        super.initComponentes();
        ssFormcom01ARegistro = new SsFormcom01A();
        ssFormcom01ASeleccion = new SsFormcom01A();
        ssFormcom01AFiltro = new SsFormcom01A();
        ssFormcom01AFiltro.setCresEstado(Constant.ACTIVO);
        maMisDestalleTipoFrencuencia = new ArrayList<>();
        maMisDestalleEstadoDocumento = new ArrayList<>();
        listaCompanyowner = new ArrayList<>();

        //listarCompania();
        // buscarPrincipal();

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
        setAtributosWindowsRegistro(MODO_ACTUAL);
    }

    @Override
    public void btnModificar() {
        if (ssFormcom01ASeleccion != null) {
            MODO_ACTUAL = MODO_UPDATE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        }else{
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnVer() {
        if (ssFormcom01ASeleccion != null) {
            MODO_ACTUAL = MODO_VIEW;
            setAtributosWindowsRegistro(MODO_VIEW);
        } else {
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnEliminar() {
        if (ssFormcom01ASeleccion != null) {
            MODO_ACTUAL = MODO_DELETE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        } else {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
        }
    }


    public void setAtributosWindowsRegistro(String modo){
        super.setAtributosWindowsRegistro(modo);
        if(modo.equals(MODO_NEW)){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String date = sdf.format(new Date());
            System.out.println(date); //15/10/2013
            Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);

        }

        cargarCombos();

    }
    // Listados
    public List<MaMiscelaneosdetalle> listarMiscelaneosDetalle(String valorcodigo1, String codigotabla) {
        MaMiscelaneosdetalle filtro = new MaMiscelaneosdetalle();
        filtro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
        filtro.setCompania(Constant.COMPANIA_999999);
        filtro.setEstado(Constant.ACTIVO);
        filtro.setValorcodigo1(valorcodigo1);
        filtro.setCodigotabla(codigotabla);
        return maMiscelaneosdetalleService.listarElementos(filtro);
    }
    public void cargarCombos(){
        maMisDestalleTipoFrencuencia =listarMiscelaneosDetalle("","TIPOFRECUE");
        maMisDestalleEstadoDocumento =listarMiscelaneosDetalle("","ESTADODOC");
    }

    @Override
    public void abrirRegistro() {

    }
    public void listarCompania() {
        try{
            if(listaCompanyowner!=null){
                listaCompanyowner.clear();
            }
            if(UtilesCommons.noEsVacio(EntityGlobal.getInstance().getUsuario())){
                Companyowner filtro = new Companyowner();
                listaCompanyowner = companiaOwnerService.listarSeguridad(filtro, EntityGlobal.getInstance().getUsuario());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void cargarObjetoFiltros(int first, int pageSize, int counter) {

        ssFormcom01AFiltro.setOrdernable(true);
        ssFormcom01AFiltro.setAtributoOrdenacion("id.fechaCambio");
        ssFormcom01AFiltro.setInicio(first);
        ssFormcom01AFiltro.setNumeroFilas(pageSize);
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

    public LazyDataModel<SsFormcom01A> getListaSsFormcom01AModel() {
        return listaSsFormcom01AModel;
    }

    public void setListaSsFormcom01AModel(LazyDataModel<SsFormcom01A> listaSsFormcom01AModel) {
        this.listaSsFormcom01AModel = listaSsFormcom01AModel;
    }

    public List<SsFormcom01A> getListaSsFormcom01A() {
        return listaSsFormcom01A;
    }

    public void setListaSsFormcom01A(List<SsFormcom01A> listaSsFormcom01A) {
        this.listaSsFormcom01A = listaSsFormcom01A;
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

    public SsFormcom01A getSsFormcom01AFiltro() {
        return ssFormcom01AFiltro;
    }

    public void setSsFormcom01AFiltro(SsFormcom01A ssFormcom01AFiltro) {
        this.ssFormcom01AFiltro = ssFormcom01AFiltro;
    }

    public SsFormcom01A getSsFormcom01ASeleccion() {
        return ssFormcom01ASeleccion;
    }

    public void setSsFormcom01ASeleccion(SsFormcom01A ssFormcom01ASeleccion) {
        this.ssFormcom01ASeleccion = ssFormcom01ASeleccion;
    }

    public SsFormcom01A getSsFormcom01ARegistro() {
        return ssFormcom01ARegistro;
    }

    public void setSsFormcom01ARegistro(SsFormcom01A ssFormcom01ARegistro) {
        this.ssFormcom01ARegistro = ssFormcom01ARegistro;
    }

    public SsFormcom01AService getSsFormcom01AService() {
        return ssFormcom01AService;
    }

    public void setSsFormcom01AService(SsFormcom01AService ssFormcom01AService) {
        this.ssFormcom01AService = ssFormcom01AService;
    }
}
