package erp.realcoresystems.pe.controller.gestion;


import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.domain.vista.VwCargainicial;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.service.*;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "cargainicialBean")
@ViewScoped
public class CargainicialBean extends AbstractGenericBean implements InterfaceGenericBean {

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    @ManagedProperty(value="#{saTipofuenteService}")
    private SaTipofuenteService saTipofuenteService;

    @ManagedProperty(value="#{ssCargainicialService}")
    private SsCargainicialService ssCargainicialService;

    @ManagedProperty(value="#{acSucursalService}")
    private AcSucursalService acSucursalService;

    @ManagedProperty(value="#{ssProyectoService}")
    private SsProyectoService ssProyectoService;

    @ManagedProperty(value="#{ssControlperiodoService}")
    private SsControlperiodoService ssControlperiodoService;

    private  List<SaTipofuente> listarFuente ;
    private  List<AcSucursal> listarSucursal ;
    private  List<SsProyecto> listarProyecto;
    private  List<SsCargainicial> listarCargaInicial;

    private SsCargainicial ssCargaInicialRegistro;
    private SsCargainicial ssCargaInicialSeleccion;
    private SsCargainicial ssCargaInicialFiltro;
    private VwCargainicial vwCargaInicialSelect;
    private VwCargainicial vwCargaInicialFiltro;
    private List<Companyowner> listarCompanias;

    private List<MaMiscelaneosdetalle> maMisTipoFuente;
    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;
    private List<MaMiscelaneosdetalle> maMisSubTipoInfraestructura;

    protected LazyDataModel<VwCargainicial> dataModel;
    protected List<VwCargainicial> listaDataModel;

    private Companyowner companiaDefault;
    private SsControlperiodo ssControlperiodo;

    private String fuenteidLocal;
    private boolean buttonesEstado;
    private String mensajeEstado;

    @PostConstruct
    public void inicializar() {
        super.initComponentes();
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        fuenteidLocal =(String) map.get("fuenteid");
        inicializarEntidad();
        //cargarParametrosSistema();
        inicializarDatoInicial();
        buscarPrincipal();
        maMisTipoFuente = listarMiscelaneosDetalle("","TIPOFUENTE");
        maMisSubTipoInfraestructura = listarMiscelaneosDetalle("", "SUBTIPINFR");
        maMisDestalleEstadoDocumento = listarMiscelaneosDetalle("","ESTADODOC");
    }
    public void inicializarEntidad(){
        FacesUtil.removeIfExistsSessionMap(Utiles.COD_SESSION_LISTADO_PERSONAS);
        ssCargaInicialRegistro = new SsCargainicial();
        ssCargaInicialSeleccion = new SsCargainicial();
        ssCargaInicialFiltro = new SsCargainicial();
        vwCargaInicialSelect = new VwCargainicial();
        vwCargaInicialFiltro = new VwCargainicial();
        ssControlperiodo = new SsControlperiodo();
        //vwCargaInicialFiltro.setAnno(annoActual());
        maMisTipoFuente = UtilesCommons.getNewList();
        maMisDestalleEstadoDocumento = UtilesCommons.getNewList();
        maMisSubTipoInfraestructura = UtilesCommons.getNewList();
        listarFuente = UtilesCommons.getNewList();
        listarSucursal = UtilesCommons.getNewList();
        listarProyecto = UtilesCommons.getNewList();
        listarCargaInicial = UtilesCommons.getNewList();

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

         ssCargaInicialRegistro.setFuenteid(Integer.parseInt(fuenteidLocal));
         ssCargaInicialFiltro.setFuenteid(Integer.parseInt(fuenteidLocal));
         vwCargaInicialFiltro.setFuenteid(Integer.parseInt(fuenteidLocal));

       // cargarListaProyectos();
    }
    public void cargarListaProyectos(){
        listarProyecto = ssProyectoService.listar(new SsProyecto(),false);
    }
    public void seleccionarSucursal() {
        SsControlperiodo tempPeriodo = new SsControlperiodo();
        if (UtilesCommons.noEsVacio(ssCargaInicialRegistro.getCompanyowner())) {
            vwCargaInicialFiltro.setCompanyowner(ssCargaInicialRegistro.getCompanyowner());
            if (MODO_ACTUAL.equals(MODO_NEW)) {
                tempPeriodo.setCompanyowner(ssCargaInicialRegistro.getCompanyowner());
                tempPeriodo.setFlagmodocargainicial(1);
                tempPeriodo.setTipooperacion("CARGAINICIAL");
                tempPeriodo.setEstadodocumento(2);
                ssControlperiodo = ssControlperiodoService.buscar(tempPeriodo);
                if (ssControlperiodo!=null){
                    ssCargaInicialRegistro.setAnno(ssControlperiodo.getAnno());
                    mensajeEstado="AUTORIZADO CARGA INICIAL";
                    buttonesEstado=false;
                }else{
                    ssCargaInicialRegistro.setAnno(null);
                    mensajeEstado="SIN AUTORIZACION CARGA INICIAL";
                    buttonesEstado=true;
                }

            }
        }
        listarSucursal = UtilesCommons.getCleanList(listarSucursal);
        AcSucursal objBusc= new AcSucursal();
        objBusc.setCompanyowner(vwCargaInicialFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getCompanyowner())) {
            listarSucursal  = acSucursalService.sucursalListar(objBusc);
            int a=0;
        }
    }
    public void seleccionarProyecto() {
        if (UtilesCommons.noEsVacio(ssCargaInicialRegistro.getCompanyowner()))
            vwCargaInicialFiltro.setCompanyowner(ssCargaInicialRegistro.getCompanyowner());
        if (UtilesCommons.noEsVacio(ssCargaInicialRegistro.getSucursal()))
            vwCargaInicialFiltro.setSucursal(ssCargaInicialRegistro.getSucursal());
        listarProyecto = UtilesCommons.getCleanList(listarProyecto);
        SsProyecto objEntidad= new SsProyecto();
        objEntidad.setCompanyowner(vwCargaInicialFiltro.getCompanyowner());
        objEntidad.setSucursal(vwCargaInicialFiltro.getSucursal());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getCompanyowner())) {
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
            objEntidad.setCompanyowner(vwCargaInicialFiltro.getCompanyowner());
            objEntidad.setSucursal(listarSucursal.get(0).getSucursal());
            if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getCompanyowner())) {
                listarProyecto = ssProyectoService.listar(objEntidad, false);
            }
        }
        return listarSucursal;
    }


    public LazyDataModel<VwCargainicial> buscarPrincipal() {
        dataModel = new LazyDataModel<VwCargainicial>() {
            private static final long serialVersionUID = 1L;

            @Override
            public List<VwCargainicial> load(int first, int pageSize, String sortField, SortOrder sortOrder,
                                               Map<String, Object> filters) {
                cargarObjetoFiltros(first, pageSize, 0);
                setOrderListadoGeneric(vwCargaInicialFiltro, sortField, sortOrder);
                listaDataModel = ssCargainicialService.listarVista(vwCargaInicialFiltro,ssCargaInicialFiltro,true);
                if(UtilesCommons.noEsVacio(listaDataModel)){
                    setRowCount(ssCargainicialService.contarVista(vwCargaInicialFiltro));
                }
                setPageSize(pageSize);
                setRowIndex(first);
                return listaDataModel;
            }

            @Override
            public VwCargainicial getRowData(String rowKey) {
                for (VwCargainicial event : listaDataModel) {
                    if ((event.getCargainicialid().toString().equals(rowKey))) {
                        vwCargaInicialSelect= (VwCargainicial) event;
                        return vwCargaInicialSelect;
                    }
                }
                return null;
            }

            @Override
            public Object getRowKey(VwCargainicial event) {
                return (event.getCargainicialid().toString());
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
    public void onRowSelect(SelectEvent event) {

    }
    @Override
    public void cargarObjetoFiltros(int first, int pageSize, int counter) {
        if (vwCargaInicialFiltro== null) {
            vwCargaInicialFiltro = new VwCargainicial();
        }

        vwCargaInicialFiltro.setOrdernable(true);
        vwCargaInicialFiltro.setAtributoOrdenacion("cargainicialid");
        vwCargaInicialFiltro.setInicio(first);
        vwCargaInicialFiltro.setNumeroFilas(pageSize);
    }

    @Override
    public void btnBuscar() {
        buscarPrincipal();
    }

    @Override
    public void btnGuardar() {
        int result = 0;
        String onSuccesMsg = "";
        if(esValidoFormulario(ssCargaInicialRegistro)){
            transformarEntidad();
            if (MODO_ACTUAL.equals(MODO_NEW)) {
                result = ssCargainicialService.guardar(ssCargaInicialRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_UPDATE)) {
                result = ssCargainicialService.actualizar(ssCargaInicialRegistro);
                onSuccesMsg = FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto");
            }else if (MODO_ACTUAL.equals(MODO_DELETE)) {
                result = ssCargainicialService.eliminar(ssCargaInicialRegistro);
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
       ssCargaInicialRegistro.setUsuarioCreacionGlobal(getUSUARIO_ACTUAL().toUpperCase());
        ssCargaInicialRegistro.setUltimousuario(getUSUARIO_ACTUAL().toUpperCase());
        ssCargaInicialRegistro.setCreacionfecha(new Date());
        ssCargaInicialRegistro.setUltimafechamodif(new Date());
    }
    
    public boolean esValidoFormulario( SsCargainicial objSave) {
        boolean validoFormulario = true;
        if(!UtilesCommons.noEsVacio(ssCargaInicialRegistro.getFuenteid())){
            //FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("Selecccione fuente de Información"));
            FacesUtil.adicionarMensajeWarning("Selecccione fuente de Información");
            validoFormulario = false;
        }
        if (!UtilesCommons.noEsVacio(ssCargaInicialRegistro.getCompanyowner())) {
            FacesUtil.adicionarMensajeWarning("Seleccione  EPS.");
            //FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("Seleccione  EPS."));
            validoFormulario = false;
        }
        if (!UtilesCommons.noEsVacio(ssCargaInicialRegistro.getSucursal())) {
            FacesUtil.adicionarMensajeWarning("Seleccione Localidad");
            //FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("Seleccione Localidad"));
            validoFormulario = false;
        }
        if(!UtilesCommons.noEsVacio(ssCargaInicialRegistro.getProyectoid())){
            FacesUtil.adicionarMensajeWarning("Seleccione proyecto.");
            validoFormulario = false;
        }
        if(!UtilesCommons.noEsVacio(ssCargaInicialRegistro.getAnno())){
            FacesUtil.adicionarMensajeWarning("Ingrese año.");
            validoFormulario = false;
        }
        if(!esValidoxFormulario(ssCargaInicialRegistro)){
            validoFormulario = false;
            return validoFormulario;
        }
        if(!esValidoFormularioCaptacion(ssCargaInicialRegistro)) {
        	 validoFormulario = false;
             return validoFormulario;
        }
        
        SsCargainicial busqueda = ssCargainicialService.buscar(ssCargaInicialRegistro);
        if (busqueda != null && MODO_ACTUAL.equals(MODO_NEW)) {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_EXISTEREGISTRO"));
            validoFormulario = false;
        }
        return validoFormulario;
    }
    
    public boolean esValidoxFormulario( SsCargainicial validaxFormulario) {
        boolean validoxFormulario = true;
        if (validaxFormulario.getFuenteid()==1){ // Formulario FUENTE DE AGUA
            if(!UtilesCommons.noEsVacio(validaxFormulario.getCapacActualLps())){
                FacesUtil.adicionarMensajeWarning("Ingrese capacidad de producción");
                validoxFormulario = false;
            }
            if(!UtilesCommons.noEsVacio(validaxFormulario.getCaudalcaptadodirectoLps())){
                FacesUtil.adicionarMensajeWarning("Ingrese caudal de captación");
                validoxFormulario = false;
            }
            if(!UtilesCommons.noEsVacio(validaxFormulario.getFuenteid())) {
                FacesUtil.adicionarMensajeWarning("Seleccione tipo de fuente");
                validoxFormulario = false;
            }
            // FERIFICAR VALIDACION DATA
            SsCargainicial busqueda = ssCargainicialService.verificar(validaxFormulario);
            if (busqueda != null ){
                if (UtilesCommons.noEsNulo(validaxFormulario.getValidFuente01Valor01())){
                    BigDecimal valor1  = busqueda.getValidFuente01Valor01();
                    BigDecimal valorLocal1  =  ssCargaInicialRegistro.getCapacActualLps();
                    if (valor1.intValue()>valorLocal1.intValue()) {
                        FacesUtil.adicionarMensajeWarning("Capacidad de Producción M3, no puede ser menor del año anterior.");
                        validoxFormulario = false;
                    }
                }
                if (UtilesCommons.noEsNulo(validaxFormulario.getValidFuente01Valor02())){
                    BigDecimal valor2  = busqueda.getValidFuente01Valor02();
                    BigDecimal valorLocal2  =  ssCargaInicialRegistro.getCaudalcaptadodirectoLps();
                    if (valor2.intValue()>valorLocal2.intValue()) {
                        FacesUtil.adicionarMensajeWarning("Capacidad de Producción M3, no puede ser menor del año anterior.");
                        validoxFormulario = false;
                    }

                    if (busqueda.getValidFuente01Valor01().longValue()> ssCargaInicialRegistro.getCapacActualLps().longValue()){
                        FacesUtil.adicionarMensajeWarning("Caudal de captación, no puede ser manor del año anterior.");
                        validoxFormulario = false;
                    }
                }

            }
        }

        return validoxFormulario;
    }
    
    public boolean esValidoFormularioCaptacion(SsCargainicial formulario) {
    	if(formulario.getFuenteid().compareTo(new Integer(7)) == 0) {// FORMULARIO CAPTACION
//    		if(UtilesCommons.esVacio(formulario.getCodSistemaCaptacion())) {
//    			FacesUtil.adicionarMensajeWarning("Ingrese el código del sistema de captación.");
//    			return false;
//    		}
//    		if(UtilesCommons.esVacio(formulario.getNombreSistemaCaptacion())) {
//    			FacesUtil.adicionarMensajeWarning("Ingrese el nombre del sistema de captación.");
//    			return false;
//    		}
    	/*	if(UtilesCommons.esVacio(formulario.getSubTipoInfraestructura())) {
    			FacesUtil.adicionarMensajeWarning("Seleccione el sub tipo de infraestructura.");
    			return false;
    		}
    		if(UtilesCommons.sonCadenasIguales(formulario.getSubTipoInfraestructura(), Constant.CAPTACION_SUB_TIPO_INFRAESTRUCTURA_SUPERFICIAL)
    				&& UtilesCommons.esNulo(formulario.getCaudalurbanoLps()) 
    				&& UtilesCommons.esNulo(formulario.getCaudalruralLps())) {
    			FacesUtil.adicionarMensajeWarning("Debe ingresar almenos el caudal urbano o rural cuando es sub tipo de infraestructura es superficial.");
    			return false;
    		}
    		if(!UtilesCommons.sonCadenasIguales(formulario.getSubTipoInfraestructura(), Constant.CAPTACION_SUB_TIPO_INFRAESTRUCTURA_SUPERFICIAL)
    				&& UtilesCommons.esNulo(formulario.getCaudalcaptadodirectoLps()) 
    				&& UtilesCommons.esNulo(formulario.getCaudalcaptadobombeoLps())
    				&& UtilesCommons.esVacio(formulario.getPotenciaHp())) {
    			FacesUtil.adicionarMensajeWarning("Debe ingresar almenos el caudal directo, bombeo o la potencia HP cuando es sub tipo de infraestructura no es superficial.");
    			return false;
    		}*/
    	}
    	return true;
    }
    
    @Override
    public void btnAceptar() {
        visibleRegistro = false;
        ssCargaInicialRegistro = new SsCargainicial();
        ssCargaInicialSeleccion = new SsCargainicial();
    }

    @Override
    public void btnCancelar() {
        visibleRegistro = false;
        ssCargaInicialRegistro = new SsCargainicial();
        ssCargaInicialSeleccion = new SsCargainicial();
    }

    @Override
    public void btnNuevo() {
        MODO_ACTUAL = MODO_NEW;
        buttonesEstado=true;
        ssCargaInicialRegistro.setEstado("A");
        ssCargaInicialRegistro.setEstadodocumento(3);
        //ssCargaInicialRegistro = new SsCargainicial();
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getCompanyowner()))
            ssCargaInicialRegistro.setCompanyowner(vwCargaInicialFiltro.getCompanyowner());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getSucursal()))
            ssCargaInicialRegistro.setSucursal(vwCargaInicialFiltro.getSucursal());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getFuenteid()))
            ssCargaInicialRegistro.setFuenteid(vwCargaInicialFiltro.getFuenteid());
        if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getProyectoid()))
            ssCargaInicialRegistro.setProyectoid(vwCargaInicialFiltro.getProyectoid());
        //if (UtilesCommons.noEsVacio(vwCargaInicialFiltro.getAnno()))
           // ssCargaInicialRegistro.setAnno(vwCargaInicialFiltro.getAnno());
        setAtributosWindowsRegistro(MODO_ACTUAL);
    }

    @Override
    public void btnModificar() {
        if (vwCargaInicialSelect != null) {
            ssCargaInicialSeleccion = new SsCargainicial();
            ssCargaInicialSeleccion.setFuenteid(vwCargaInicialSelect.getFuenteid());
            ssCargaInicialSeleccion.setCompanyowner(vwCargaInicialSelect.getCompanyowner());
            ssCargaInicialSeleccion.setSucursal(vwCargaInicialSelect.getSucursal());
            ssCargaInicialSeleccion.setProyectoid(vwCargaInicialSelect.getProyectoid());
            ssCargaInicialSeleccion.setAnno(vwCargaInicialSelect.getAnno());
            ssCargaInicialRegistro = ssCargainicialService.buscar(ssCargaInicialSeleccion);
            MODO_ACTUAL = MODO_UPDATE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        }else{
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnVer() {
        if (ssCargaInicialSeleccion != null) {
            MODO_ACTUAL = MODO_VIEW;
            setAtributosWindowsRegistro(MODO_VIEW);
        } else {
            FacesUtil.mensajeWarningPropiedades("MSJ_WARN_elementoNoSelecc");
        }
    }

    @Override
    public void btnEliminar() {
        if (ssCargaInicialSeleccion != null) {
            MODO_ACTUAL = MODO_DELETE;
            setAtributosWindowsRegistro(MODO_ACTUAL);
        } else {
            FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
        }
    }

    @Override
    public void abrirRegistro() {

    }

    //SetGet

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

    public SsCargainicialService getSsCargainicialService() {
        return ssCargainicialService;
    }

    public void setSsCargainicialService(SsCargainicialService ssCargainicialService) {
        this.ssCargainicialService = ssCargainicialService;
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

    public List<SsCargainicial> getListarCargaInicial() {
        return listarCargaInicial;
    }

    public void setListarCargaInicial(List<SsCargainicial> listarCargaInicial) {
        this.listarCargaInicial = listarCargaInicial;
    }

    public SsCargainicial getSsCargaInicialRegistro() {
        return ssCargaInicialRegistro;
    }

    public void setSsCargaInicialRegistro(SsCargainicial ssCargaInicialRegistro) {
        this.ssCargaInicialRegistro = ssCargaInicialRegistro;
    }

    public SsCargainicial getSsCargaInicialSeleccion() {
        return ssCargaInicialSeleccion;
    }

    public void setSsCargaInicialSeleccion(SsCargainicial ssCargaInicialSeleccion) {
        this.ssCargaInicialSeleccion = ssCargaInicialSeleccion;
    }

    public SsCargainicial getSsCargaInicialFiltro() {
        return ssCargaInicialFiltro;
    }

    public void setSsCargaInicialFiltro(SsCargainicial ssCargaInicialFiltro) {
        this.ssCargaInicialFiltro = ssCargaInicialFiltro;
    }

    public List<MaMiscelaneosdetalle> getmaMisTipoFuente() {
        return maMisTipoFuente;
    }

    public void setmaMisTipoFuente(List<MaMiscelaneosdetalle> maMisTipoFuente) {
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

    public VwCargainicial getVwCargaInicialSelect() {
        return vwCargaInicialSelect;
    }

    public void setVwCargaInicialSelect(VwCargainicial vwCargaInicialSelect) {
        this.vwCargaInicialSelect = vwCargaInicialSelect;
    }

    public VwCargainicial getVwCargaInicialFiltro() {
        return vwCargaInicialFiltro;
    }

    public void setVwCargaInicialFiltro(VwCargainicial vwCargaInicialFiltro) {
        this.vwCargaInicialFiltro = vwCargaInicialFiltro;
    }

    public LazyDataModel<VwCargainicial> getDataModel() {
        return dataModel;
    }

    public void setDataModel(LazyDataModel<VwCargainicial> dataModel) {
        this.dataModel = dataModel;
    }

    public List<VwCargainicial> getListaDataModel() {
        return listaDataModel;
    }

    public void setListaDataModel(List<VwCargainicial> listaDataModel) {
        this.listaDataModel = listaDataModel;
    }

    public List<Companyowner> getListarCompanias() {
        return listarCompanias;
    }

    public void setListarCompanias(List<Companyowner> listarCompanias) {
        this.listarCompanias = listarCompanias;
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

    public SsControlperiodoService getSsControlperiodoService() {
        return ssControlperiodoService;
    }

    public void setSsControlperiodoService(SsControlperiodoService ssControlperiodoService) {
        this.ssControlperiodoService = ssControlperiodoService;
    }

    public List<MaMiscelaneosdetalle> getMaMisTipoFuente() {
        return maMisTipoFuente;
    }

    public void setMaMisTipoFuente(List<MaMiscelaneosdetalle> maMisTipoFuente) {
        this.maMisTipoFuente = maMisTipoFuente;
    }

    public Companyowner getCompaniaDefault() {
        return companiaDefault;
    }

    public SsControlperiodo getSsControlperiodo() {
        return ssControlperiodo;
    }

    public void setSsControlperiodo(SsControlperiodo ssControlperiodo) {
        this.ssControlperiodo = ssControlperiodo;
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
}

