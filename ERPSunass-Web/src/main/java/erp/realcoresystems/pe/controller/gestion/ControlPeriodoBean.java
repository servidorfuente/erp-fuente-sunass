package erp.realcoresystems.pe.controller.gestion;

import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.SsControlperiodo;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.EntPeriodo;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.service.SsControlperiodoService;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.text.SimpleDateFormat;
import java.util.*;


@ManagedBean(name = "controlPeriodoBean")
@ViewScoped
public class ControlPeriodoBean extends AbstractGenericBean implements InterfaceGenericBean {


    private static final long serialVersionUID = 1L;
    @ManagedProperty(value = "#{ssControlperiodoService}")
    private SsControlperiodoService ssControlperiodoService;

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    private List<MaMiscelaneosdetalle> maMisDestalleTipoFrencuencia;

    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    // Service

    private LazyDataModel<SsControlperiodo> listaSsControlperiodoModel;
    private List<SsControlperiodo> listaSsControlperiodo;

    // Entity
    private SsControlperiodo controlPeriodoFiltro = new SsControlperiodo();
    private SsControlperiodo controlPeriodoSeleccion = new SsControlperiodo();
    private SsControlperiodo controlPeriodoRegistro = new SsControlperiodo();

    // Variables
    private boolean chkEstado;

    private List<Companyowner>  listaCompanyowner;
    private List<EntPeriodo>  listaEntPeriodo;
    private static String MES[] = {"","ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SETIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
    @PostConstruct
    public void iniciar() {
        FacesUtil.putSessionMap("namedBeanSingleton", "controlPeriodoBean");
        super.initComponentes();
        controlPeriodoRegistro = new SsControlperiodo();
        controlPeriodoSeleccion = new SsControlperiodo();
        controlPeriodoFiltro = new SsControlperiodo();
        controlPeriodoFiltro.setEstado(Constant.ACTIVO);
        maMisDestalleTipoFrencuencia = new ArrayList<>();
        maMisDestalleEstadoDocumento = new ArrayList<>();
        listaEntPeriodo = new ArrayList<>();
        listaCompanyowner = new ArrayList<>();
        listarCompania();
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
    @Override
    public void btnBuscar() {
        buscarPrincipal();
    }

    @Override
    public void btnGuardar() {
        int result = 0;
        String onSuccesMsg = "";
        if(esValidoFormulario(controlPeriodoRegistro)){

            transformarEntidad();

            if (MODO_ACTUAL.equals(MODO_NEW)) {
             //   result = ssControlperiodoService.guardar(controlPeriodoRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_UPDATE)) {
              //  result = ssControlperiodoService.actualizar(controlPeriodoRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_DELETE)) {
               // result = ssControlperiodoService.eliminar(controlPeriodoRegistro);
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

    @Override
    public void btnAceptar() {
        visibleRegistro = false;
        controlPeriodoRegistro = new SsControlperiodo();
        controlPeriodoSeleccion = new SsControlperiodo();
    }

    @Override
    public void btnCancelar() {
        visibleRegistro = false;
        controlPeriodoRegistro = new SsControlperiodo();
        controlPeriodoSeleccion = new SsControlperiodo();
    }

    @Override
    public void btnNuevo() {
        MODO_ACTUAL = MODO_NEW;
        setAtributosWindowsRegistro(MODO_ACTUAL);
    }

    @Override
    public void btnModificar() {
        if (controlPeriodoSeleccion != null) {
            MODO_ACTUAL = MODO_UPDATE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        }else{
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnVer() {
        if (controlPeriodoSeleccion != null) {
            MODO_ACTUAL = MODO_VIEW;
            setAtributosWindowsRegistro(MODO_VIEW);
        } else {
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnEliminar() {
        if (controlPeriodoSeleccion != null) {
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
            listaEntPeriodo =  generarPeriodo(TimeCommons.getAnio(today));
            controlPeriodoRegistro = new SsControlperiodo();
           // controlPeriodoRegistro.setAnno(TimeCommons.getAnio(today));
            controlPeriodoRegistro.setEstadodocumento(1);
            controlPeriodoRegistro.setFechainicio(new Date());
            controlPeriodoRegistro.setFechafin(new Date());
            controlPeriodoRegistro.setTipofrecuencia("MENSUAL");
            controlPeriodoRegistro.setEstado(Utiles.ACTIVO_db);
            controlPeriodoRegistro.setPeriodo(TimeCommons.getAnio(today)+"0101");
            // arregar
            //controlPeriodoRegistro.getId().setFechaCambio(new Date());
        }else{
            controlPeriodoRegistro = controlPeriodoSeleccion;
        }
        convertirStringBoolean();
        cargarCombos();

    }
    // Listados
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
        if (controlPeriodoFiltro == null) {
            controlPeriodoFiltro = new SsControlperiodo();
        }

        controlPeriodoFiltro.setOrdernable(true);
        controlPeriodoFiltro.setAtributoOrdenacion("id.fechaCambio");
        controlPeriodoFiltro.setInicio(first);
        controlPeriodoFiltro.setNumeroFilas(pageSize);
    }

    public LazyDataModel<SsControlperiodo> buscarPrincipal() {
        listaSsControlperiodoModel = new LazyDataModel<SsControlperiodo>() {
            private static final long serialVersionUID = 1L;

            @Override
            public List<SsControlperiodo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                             Map<String, Object> filters) {
                cargarObjetoFiltros(first, pageSize, 0);
               // listaSsControlperiodo = ssControlperiodoService.listar(controlPeriodoFiltro,true);
                if(UtilesCommons.noEsVacio(listaSsControlperiodo)){
                 //   setRowCount(ssControlperiodoService.contar(controlPeriodoFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return listaSsControlperiodo;
            }

            @Override
            public SsControlperiodo getRowData(String rowKey) {
                for (SsControlperiodo event : listaSsControlperiodo) {
                    if ((event.getCompanyowner()+event.getTipofrecuencia()+event.getPeriodo()).equals(rowKey)) {
                        controlPeriodoSeleccion = (SsControlperiodo) event;
                        return controlPeriodoSeleccion;
                    }
                }
                return null;
            }

            @Override
            public Object getRowKey(SsControlperiodo event) {
                return (event.getCompanyowner()+event.getTipofrecuencia()+event.getPeriodo());
            }
        };
        return listaSsControlperiodoModel;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void transformarEntidad(){
        convertirBooleanString();
       // controlPeriodoRegistro.setFactor(new Float(0.0));
       // controlPeriodoRegistro.setFechaCambioString(UtilesCommons.printDate("yyyyMMdd", controlPeriodoRegistro.getId().getFechaCambio()));
       //controlPeriodoRegistro.setUltimoUsuario(getUSUARIO_ACTUAL().toUpperCase());
       // controlPeriodoRegistro.setUltimaFechaModif(new Date());
    }
    public void seleccionaTipoFrecuencia(){
       // booleanTipoPago = false;
        if(UtilesCommons.noEsVacio(controlPeriodoRegistro.getTipofrecuencia())){
            listaEntPeriodo.clear();
            if (controlPeriodoRegistro.getTipofrecuencia().equals("MENSUAL")){
             //   listaEntPeriodo =  generarPeriodo(controlPeriodoRegistro.getAnno());
            }

            /*if(impuestoRegistro.getTipoImpuesto().equalsIgnoreCase(Constant.TIPOIMPUESTO_RENTA)){
                booleanTipoPago = true;
                chkIncluirCertificado = true;
            }*/
        }
    }
    public List<EntPeriodo> generarPeriodo(int annoo){
        EntPeriodo entObj = new EntPeriodo();
        for (int i = 1; i < 13; i++) {
           // entObj.setAnno(controlPeriodoRegistro.getAnno());
            entObj.setMes(i);
            entObj.setDia(i);
            entObj.setTipo("MENSUAL");
            entObj.setPeriodoDescripcion(MES[i]);
            listaEntPeriodo.add(entObj);
        }
        return listaEntPeriodo;
    }
    public boolean esValidoFormulario(SsControlperiodo objSave) {
        boolean validoFormulario = true;
        if (objSave.getCompanyowner()== null) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_INFO_WARN_controlPeriodo_REQUIRED_FECHACAMBIO"));
            validoFormulario = false;
        }

        if (objSave.getTipofrecuencia() == null) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_INFO_WARN_controlPeriodo_REQUIRED_COMPRA"));
            validoFormulario = false;
        }
        else if(objSave.getPeriodo()==null){
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_INFO_WARN_controlPeriodo_REQUIRED_COMPRA_MAYORACERO"));
            validoFormulario = false;
        }

        SsControlperiodo filtroPK = new SsControlperiodo();
        filtroPK.setCompanyowner(objSave.getCompanyowner());
        filtroPK.setTipofrecuencia(objSave.getTipofrecuencia());
        filtroPK.setPeriodo(objSave.getPeriodo());

        SsControlperiodo busqueda = null;//ssControlperiodoService.buscar(filtroPK);
        if (busqueda != null && MODO_ACTUAL.equals(MODO_NEW)) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_controlPeriodo_controlPeriodo_REPETIDO"));
            validoFormulario = false;
        }

        return validoFormulario;
    }

    //Convertimos el valor Boolean a String
    public void convertirBooleanString() {
        String estado = UtilesCommons.obtenerValorString(isChkEstado(), UtilesCommons.ACTIVO_db, UtilesCommons.INACTIVO_db);
        controlPeriodoRegistro.setEstado(estado);
    }

    //Convertimos el valor String a Boolean
    public void convertirStringBoolean() {
        chkEstado = UtilesCommons.obtenerValorBooleano(controlPeriodoRegistro.getEstado(), UtilesCommons.ACTIVO_db, UtilesCommons.INACTIVO_db);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SsControlperiodoService getSsControlperiodoService() {
        return ssControlperiodoService;
    }

    public void setSsControlperiodoService(SsControlperiodoService ssControlperiodoService) {
        this.ssControlperiodoService = ssControlperiodoService;
    }

    public LazyDataModel<SsControlperiodo> getListaSsControlperiodoModel() {
        return listaSsControlperiodoModel;
    }

    public void setListaSsControlperiodoModel(LazyDataModel<SsControlperiodo> listaSsControlperiodoModel) {
        this.listaSsControlperiodoModel = listaSsControlperiodoModel;
    }

    public List<SsControlperiodo> getListaSsControlperiodo() {
        return listaSsControlperiodo;
    }

    public void setListaSsControlperiodo(List<SsControlperiodo> listaSsControlperiodo) {
        this.listaSsControlperiodo = listaSsControlperiodo;
    }

    public SsControlperiodo getControlPeriodoFiltro() {
        return controlPeriodoFiltro;
    }

    public void setControlPeriodoFiltro(SsControlperiodo controlPeriodoFiltro) {
        this.controlPeriodoFiltro = controlPeriodoFiltro;
    }

    public SsControlperiodo getControlPeriodoSeleccion() {
        return controlPeriodoSeleccion;
    }

    public void setControlPeriodoSeleccion(SsControlperiodo controlPeriodoSeleccion) {
        this.controlPeriodoSeleccion = controlPeriodoSeleccion;
    }

    public SsControlperiodo getControlPeriodoRegistro() {
        return controlPeriodoRegistro;
    }

    public void setControlPeriodoRegistro(SsControlperiodo controlPeriodoRegistro) {
        this.controlPeriodoRegistro = controlPeriodoRegistro;
    }

    public boolean isChkEstado() {
        return chkEstado;
    }

    public void setChkEstado(boolean chkEstado) {
        this.chkEstado = chkEstado;
    }

    public CompaniaOwnerService getCompaniaOwnerService() {
        return companiaOwnerService;
    }

    public void setCompaniaOwnerService(CompaniaOwnerService companiaOwnerService) {
        this.companiaOwnerService = companiaOwnerService;
    }

    public List<Companyowner> getListaCompanyowner() {
        return listaCompanyowner;
    }

    public void setListaCompanyowner(List<Companyowner> listaCompanyowner) {
        this.listaCompanyowner = listaCompanyowner;
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

}
