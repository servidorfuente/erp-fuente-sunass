package erp.realcoresystems.pe.server;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public  class EntityGlobal implements Serializable{

	private static final long serialVersionUID = 1L;


	// SUNASS

	private Integer periodoAnnoActual;
	private Integer wordFlowNumero;
	private Integer estadoNumero;
	private String  companiaafiliada;
	private String  nombreEtapa;

	
	//ADICIONAL PARA INTERNACIONALIZACION	
	private Locale localeConfigActual;
	
	//GENERALES MODALIDAD
	private Integer uneunegocioid;
	private Integer moemestudioid;
	private String moindicadormodalidad;
	private String moindicadorinstitucion;
	private String flagIndicadorModular;
	private Integer carreraCursoLibreId;
	
	
	// TIPOS DE USUARIO SGA
	private Integer tipoUsuario;	
	private Integer tipoUsuarioEmpleado;

	
	private String flagValidoParaAudtoria;
	private String codigoSucursal;
	private String codigoCompanyowner;
	private Integer sedSedeGrupoId;
	private String ipCliente;
	private String sysUrl;
	private String sysVersion;
	private String flagObligarcambioClave;
	private String macCliente;
	private String pcNameCliente;
	private String urlDinamico;
	private Integer urlIDdinamico;
	public Map<String,String>  mapPropSeguridad= new HashMap<String ,String>();
	public Map<String,String>  mapPropParametros= new HashMap<String ,String>();
	
	
	//ADICIONAL VIEWS HCE
	private String tipoPanelViewActual;
	
	private Integer idPacienteActual;
	private Long idEpiAtencionActual;
	private Integer idEpiClinicoActual;
	private String unidadReplicacionActual;
	private String nombrePacienteActual;
	private Integer idAgenteActual;
	
	//ADICIONAL DOCUMENTOS
	private String serieFacturaDefault;
	private String serieBoletaDefault;
	private String serieGuiaDefault;
	
	
	//ADDICIONAL CONCEPTOS
	private String sysAplicacionCodigo;
	private String sysGrupo;
	private String sysConcepto;
	private String sysConceptoDesc;
	
	
	///PARA PARAMETROS CORREO
	private String correoUsuario;
	private String correoClave;
	private String correoHost;
	private String correoPort;
	private String correoSocketPort;
	
	///PARA PARAMETROS ALFRESCO
	private String alfrescoUsuario;
	private String alfrescoClave;
	private String alfrescoUrlDoc;
	private String alfrescoUrlPreviaDoc;
	private String alfrescoNombreDoc;
	private String alfrescoToken;
	private boolean alfrescoIndicaLogin;
	
	///PARA LIFE RAY
	private String ldapUrl;
	private String principle;
	private String password;
	private String lifePassword;
	private String lifeUsuario;
	
	
	////PARA SET CONCEPTO ACTUAL
	private String conceptoActualDesc;
	private String aplicacionCodigoActual;
	private String grupoActual;
	private String conceptoActual;
	private String conceptoPadreActual;	
	private String hostActual;
	private Date fechaSessionActual;
	private Integer aplicacionCodigo;
	private Integer persona;
    private Integer idEspecialidad;    
    private Integer nivel;
    
    private String sucursal;
    private Integer establecimientoId;
    
    private String establecimiento;
	private String sede;
	private String aplicacion;
	private String seguridad;
	private String centroCostos;
	private String unidadNegocio;
	private String unidadReplicacion;
	private String userId;
	private String nombreCompleto;	
	private Integer vendor;
	private String pais;
	private String idioma;
	private String empresa;
	private String responsable_empleado;
	private String urlPaginaInicio;
	private List<String> paginasGuardadas;
	private List<String> aplicacionesMantFavoritos;
	private String periodoVoucher;
	private Integer NroMenu;
	private String usuario;

	private String organizationalUnit;


	//Para Ventas Cajeros
	private Integer idCajero;
	private String nombresCompletoCajero;
	private String documentoIdentidad;
	private String tipoCajero;
	private String terminalCajero;
	private String companiaCajero;
	private String establecimientoCajero;


	private String terminalHostName;

	//Para Ventas Cajeros - modalidad, descripciones
	private String companyownerDesc;
	private String establecimientoDesc;
	private String modalidadEstudioDesc;
		
	//adicionales REPORT - DOC
	private String reportConcepto;
	private String reportName;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public Integer getAplicacionCodigo() {
		return aplicacionCodigo;
	}

	public void setAplicacionCodigo(Integer aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}

	public String getCentroCostos() {
		return centroCostos;
	}

	public void setCentroCostos(String centroCostos) {
		this.centroCostos = centroCostos;
	}

	public String getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public String getUnidadReplicacion() {
		return unidadReplicacion;
	}

	public void setUnidadReplicacion(String unidadReplicacion) {
		this.unidadReplicacion = unidadReplicacion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getVendor() {
		return vendor;
	}

	public void setVendor(Integer vendor) {
		this.vendor = vendor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getResponsable_empleado() {
		return responsable_empleado;
	}

	public void setResponsable_empleado(String responsable_empleado) {
		this.responsable_empleado = responsable_empleado;
	}

	public String getUrlPaginaInicio() {
		return urlPaginaInicio;
	}

	public void setUrlPaginaInicio(String urlPaginaInicio) {
		this.urlPaginaInicio = urlPaginaInicio;
	}

	public List<String> getPaginasGuardadas() {
		return paginasGuardadas;
	}

	public void setPaginasGuardadas(List<String> paginasGuardadas) {
		this.paginasGuardadas = paginasGuardadas;
	}

	public List<String> getAplicacionesMantFavoritos() {
		return aplicacionesMantFavoritos;
	}

	public void setAplicacionesMantFavoritos(List<String> aplicacionesMantFavoritos) {
		this.aplicacionesMantFavoritos = aplicacionesMantFavoritos;
	}

	public String getPeriodoVoucher() {
		if(periodoVoucher==null){
			//POR DEFECTO			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			periodoVoucher =  sdf.format(new Date());
		}		
		return periodoVoucher;
	}

	public void setPeriodoVoucher(String periodoVoucher) {
		this.periodoVoucher = periodoVoucher;
	}

	public Integer getNroMenu() {
		return NroMenu;
	}

	public void setNroMenu(Integer nroMenu) {
		NroMenu = nroMenu;
	}

	public Integer getBrowser() {
		return browser;
	}

	public void setBrowser(Integer browser) {
		this.browser = browser;
	}

	public Integer getCodSistema() {
		return codSistema;
	}

	public void setCodSistema(Integer codSistema) {
		this.codSistema = codSistema;
	}

	public String getCorreinterno() {
		return correinterno;
	}

	public void setCorreinterno(String correinterno) {
		this.correinterno = correinterno;
	}

	public Integer getWidth() {
		return Width;
	}

	public void setWidth(Integer width) {
		Width = width;
	}

	public Integer getHeight() {
		return Height;
	}

	public void setHeight(Integer height) {
		Height = height;
	}


	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public static void setInstance(EntityGlobal instance) {
		Instance = instance;
	}

	
	
	
	public String getGrupoActual() {
		return grupoActual;
	}

	public void setGrupoActual(String grupoActual) {
		this.grupoActual = grupoActual;
	}

	public String getConceptoActual() {
		return conceptoActual;
	}

	public void setConceptoActual(String conceptoActual) {
		this.conceptoActual = conceptoActual;
	}

	public String getConceptoPadreActual() {
		return conceptoPadreActual;
	}

	public void setConceptoPadreActual(String conceptoPadreActual) {
		this.conceptoPadreActual = conceptoPadreActual;
	}




	public String getAplicacionCodigoActual() {
		return aplicacionCodigoActual;
	}

	public void setAplicacionCodigoActual(String aplicacionCodigoActual) {
		this.aplicacionCodigoActual = aplicacionCodigoActual;
	}




	public String getHostActual() {
		return hostActual;
	}

	public void setHostActual(String hostActual) {
		this.hostActual = hostActual;
	}




	public Date getFechaSessionActual() {
		return fechaSessionActual;
	}

	public void setFechaSessionActual(Date fechaSessionActual) {
		this.fechaSessionActual = fechaSessionActual;
	}




	private Integer browser;
	private Integer codSistema;
 	private String correinterno;
	private Integer Width;
	private Integer Height;

	
    private static  EntityGlobal Instance;

	public static EntityGlobal getInstance() {
		try{			
			if(FacesContext.getCurrentInstance()!=null){							
				HttpSession session = (FacesContext.getCurrentInstance().getExternalContext().getSession(false)!=null?
						(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false):null );
				if(session!=null){
					Instance =(EntityGlobal) session.getAttribute("EntityGlobal");
				}else{
					Instance=null;
				}
				//return  entityGlobal;
				return Instance;		
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public static EntityGlobal closeInstance() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("EntityGlobal");
		//return  entityGlobal;
		Instance= null;
		return Instance;
	}


	public Integer getUneunegocioid() {
		
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	public Integer getMoemestudioid() {
		return moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public String getSysUrl() {
		return sysUrl;
	}

	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl;
	}

	public String getSysVersion() {
		return sysVersion;
	}

	public void setSysVersion(String sysVersion) {
		this.sysVersion = sysVersion;
	}

	public String getMacCliente() {
		return macCliente;
	}

	public void setMacCliente(String macCliente) {
		this.macCliente = macCliente;
	}

	public String getPcNameCliente() {
		return pcNameCliente;
	}

	public void setPcNameCliente(String pcNameCliente) {
		this.pcNameCliente = pcNameCliente;
	}

	public Map<String, String> getMapPropSeguridad() {
		return mapPropSeguridad;
	}

	public void setMapPropSeguridad(Map<String, String> mapPropSeguridad) {
		this.mapPropSeguridad = mapPropSeguridad;
	}

	public Map<String, String> getMapPropParametros() {
		return mapPropParametros;
	}

	public void setMapPropParametros(Map<String, String> mapPropParametros) {
		this.mapPropParametros = mapPropParametros;
	}

	public String getFlagValidoParaAudtoria() {
		return flagValidoParaAudtoria;
	}

	public void setFlagValidoParaAudtoria(String flagValidoParaAudtoria) {
		this.flagValidoParaAudtoria = flagValidoParaAudtoria;
	}


	public String getLdapUrl() {
		return ldapUrl;
	}

	public void setLdapUrl(String ldapUrl) {
		this.ldapUrl = ldapUrl;
	}

	public String getPrinciple() {
		return principle;
	}

	public void setPrinciple(String principle) {
		this.principle = principle;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationalUnit() {
		return organizationalUnit;
	}

	public void setOrganizationalUnit(String organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public String getCodigoCompanyowner() {
		return codigoCompanyowner;
	}

	public void setCodigoCompanyowner(String codigoCompanyowner) {
		this.codigoCompanyowner = codigoCompanyowner;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getCorreoClave() {
		return correoClave;
	}

	public void setCorreoClave(String correoClave) {
		this.correoClave = correoClave;
	}

	public String getCorreoHost() {
		return correoHost;
	}

	public void setCorreoHost(String correoHost) {
		this.correoHost = correoHost;
	}

	public String getCorreoPort() {
		return correoPort;
	}

	public void setCorreoPort(String correoPort) {
		this.correoPort = correoPort;
	}

	public String getCorreoSocketPort() {
		return correoSocketPort;
	}

	public void setCorreoSocketPort(String correoSocketPort) {
		this.correoSocketPort = correoSocketPort;
	}

	public String getConceptoActualDesc() {
		return conceptoActualDesc;
	}

	public void setConceptoActualDesc(String conceptoActualDesc) {
		this.conceptoActualDesc = conceptoActualDesc;
	}

	public Integer getSedSedeGrupoId() {
		return sedSedeGrupoId;
	}

	public void setSedSedeGrupoId(Integer sedSedeGrupoId) {
		this.sedSedeGrupoId = sedSedeGrupoId;
	}

	public String getFlagObligarcambioClave() {
		return flagObligarcambioClave;
	}

	public void setFlagObligarcambioClave(String flagObligarcambioClave) {
		this.flagObligarcambioClave = flagObligarcambioClave;
	}
	public String getLifePassword() {
		return lifePassword;
	}

	public void setLifePassword(String lifePassword) {
		this.lifePassword = lifePassword;
	}

	public String getLifeUsuario() {
		return lifeUsuario;
	}

	public void setLifeUsuario(String lifeUsuario) {
		this.lifeUsuario = lifeUsuario;
	}

	public String getSysAplicacionCodigo() {
		return sysAplicacionCodigo;
	}

	public void setSysAplicacionCodigo(String sysAplicacionCodigo) {
		this.sysAplicacionCodigo = sysAplicacionCodigo;
	}

	public String getSysGrupo() {
		return sysGrupo;
	}

	public void setSysGrupo(String sysGrupo) {
		this.sysGrupo = sysGrupo;
	}

	public String getSysConcepto() {
		return sysConcepto;
	}

	public void setSysConcepto(String sysConcepto) {
		this.sysConcepto = sysConcepto;
	}

	public String getSysConceptoDesc() {
		return sysConceptoDesc;
	}

	public void setSysConceptoDesc(String sysConceptoDesc) {
		this.sysConceptoDesc = sysConceptoDesc;
	}

	public String getAlfrescoUsuario() {
		return alfrescoUsuario;
	}

	public void setAlfrescoUsuario(String alfrescoUsuario) {
		this.alfrescoUsuario = alfrescoUsuario;
	}

	public String getAlfrescoClave() {
		return alfrescoClave;
	}

	public void setAlfrescoClave(String alfrescoClave) {
		this.alfrescoClave = alfrescoClave;
	}

	public String getAlfrescoUrlDoc() {
		return alfrescoUrlDoc;
	}

	public void setAlfrescoUrlDoc(String alfrescoUrlDoc) {
		this.alfrescoUrlDoc = alfrescoUrlDoc;
	}

	public String getAlfrescoUrlPreviaDoc() {
		return alfrescoUrlPreviaDoc;
	}

	public void setAlfrescoUrlPreviaDoc(String alfrescoUrlPreviaDoc) {
		this.alfrescoUrlPreviaDoc = alfrescoUrlPreviaDoc;
	}

	public String getAlfrescoNombreDoc() {
		return alfrescoNombreDoc;
	}

	public void setAlfrescoNombreDoc(String alfrescoNombreDoc) {
		this.alfrescoNombreDoc = alfrescoNombreDoc;
	}

	public String getAlfrescoToken() {
		return alfrescoToken;
	}

	public void setAlfrescoToken(String alfrescoToken) {
		this.alfrescoToken = alfrescoToken;
	}

	public boolean isAlfrescoIndicaLogin() {
		return alfrescoIndicaLogin;
	}

	public void setAlfrescoIndicaLogin(boolean alfrescoIndicaLogin) {
		this.alfrescoIndicaLogin = alfrescoIndicaLogin;
	}

	public String getSerieFacturaDefault() {
		return serieFacturaDefault;
	}

	public void setSerieFacturaDefault(String serieFacturaDefault) {
		this.serieFacturaDefault = serieFacturaDefault;
	}

	public String getSerieBoletaDefault() {
		return serieBoletaDefault;
	}

	public void setSerieBoletaDefault(String serieBoletaDefault) {
		this.serieBoletaDefault = serieBoletaDefault;
	}

	public String getSerieGuiaDefault() {
		return serieGuiaDefault;
	}

	public void setSerieGuiaDefault(String serieGuiaDefault) {
		this.serieGuiaDefault = serieGuiaDefault;
	}


	public Integer getIdCajero() {
		return idCajero;
	}

	public void setIdCajero(Integer idCajero) {
		this.idCajero = idCajero;
	}

	public String getNombresCompletoCajero() {
		return nombresCompletoCajero;
	}

	public void setNombresCompletoCajero(String nombresCompletoCajero) {
		this.nombresCompletoCajero = nombresCompletoCajero;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getTipoCajero() {
		return tipoCajero;
	}

	public void setTipoCajero(String tipoCajero) {
		this.tipoCajero = tipoCajero;
	}

	public String getTerminalCajero() {
		return terminalCajero;
	}

	public void setTerminalCajero(String terminalCajero) {
		this.terminalCajero = terminalCajero;
	}

	public String getCompaniaCajero() {
		return companiaCajero;
	}

	public void setCompaniaCajero(String companiaCajero) {
		this.companiaCajero = companiaCajero;
	}

	public String getEstablecimientoCajero() {
		return establecimientoCajero;
	}

	public void setEstablecimientoCajero(String establecimientoCajero) {
		this.establecimientoCajero = establecimientoCajero;
	}

	public Locale getLocaleConfigActual() {
		return localeConfigActual;
	}

	public void setLocaleConfigActual(Locale localeConfigActual) {
		this.localeConfigActual = localeConfigActual;
	}

	public String getCompanyownerDesc() {
		return companyownerDesc;
	}

	public void setCompanyownerDesc(String companyownerDesc) {
		this.companyownerDesc = companyownerDesc;
	}

	public String getEstablecimientoDesc() {
		return establecimientoDesc;
	}

	public void setEstablecimientoDesc(String establecimientoDesc) {
		this.establecimientoDesc = establecimientoDesc;
	}


	public String getTerminalHostName() {
		return terminalHostName;
	}

	public void setTerminalHostName(String terminalHostName) {
		this.terminalHostName = terminalHostName;
	}

	public String getTipoPanelViewActual() {
		return tipoPanelViewActual;
	}

	public void setTipoPanelViewActual(String tipoPanelViewActual) {
		this.tipoPanelViewActual = tipoPanelViewActual;
	}

	public Integer getIdPacienteActual() {
		return idPacienteActual;
	}

	public void setIdPacienteActual(Integer idPacienteActual) {
		this.idPacienteActual = idPacienteActual;
	}

	public Long getIdEpiAtencionActual() {
		return idEpiAtencionActual;
	}

	public void setIdEpiAtencionActual(Long idEpiAtencionActual) {
		this.idEpiAtencionActual = idEpiAtencionActual;
	}

	public Integer getIdEpiClinicoActual() {
		return idEpiClinicoActual;
	}

	public void setIdEpiClinicoActual(Integer idEpiClinicoActual) {
		this.idEpiClinicoActual = idEpiClinicoActual;
	}

	public String getUnidadReplicacionActual() {
		return unidadReplicacionActual;
	}

	public void setUnidadReplicacionActual(String unidadReplicacionActual) {
		this.unidadReplicacionActual = unidadReplicacionActual;
	}
	public String getUrlDinamico() {
		return urlDinamico;
	}

	public void setUrlDinamico(String urlDinamico) {
		this.urlDinamico = urlDinamico;
	}

	public Integer getUrlIDdinamico() {
		return urlIDdinamico;
	}

	public void setUrlIDdinamico(Integer urlIDdinamico) {
		this.urlIDdinamico = urlIDdinamico;
	}

	public String getNombrePacienteActual() {
		return nombrePacienteActual;
	}

	public void setNombrePacienteActual(String nombrePacienteActual) {
		this.nombrePacienteActual = nombrePacienteActual;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getEstablecimientoId() {
		return establecimientoId;
	}

	public void setEstablecimientoId(Integer establecimientoId) {
		this.establecimientoId = establecimientoId;
	}

	public Integer getIdAgenteActual() {
		return idAgenteActual;
	}

	public void setIdAgenteActual(Integer idAgenteActual) {
		this.idAgenteActual = idAgenteActual;
	}

	public Integer getTipoUsuarioEmpleado() {
		return tipoUsuarioEmpleado;
	}

	public void setTipoUsuarioEmpleado(Integer tipoUsuarioEmpleado) {
		this.tipoUsuarioEmpleado = tipoUsuarioEmpleado;
	}

	public String getMoindicadormodalidad() {
		return moindicadormodalidad;
	}

	public void setMoindicadormodalidad(String moindicadormodalidad) {
		this.moindicadormodalidad = moindicadormodalidad;
	}

	public String getMoindicadorinstitucion() {
		return moindicadorinstitucion;
	}

	public void setMoindicadorinstitucion(String moindicadorinstitucion) {
		this.moindicadorinstitucion = moindicadorinstitucion;
	}

	public String getFlagIndicadorModular() {
		return flagIndicadorModular;
	}

	public void setFlagIndicadorModular(String flagIndicadorModular) {
		this.flagIndicadorModular = flagIndicadorModular;
	}

	public Integer getCarreraCursoLibreId() {
		return carreraCursoLibreId;
	}

	public void setCarreraCursoLibreId(Integer carreraCursoLibreId) {
		this.carreraCursoLibreId = carreraCursoLibreId;
	}

	public String getReportConcepto() {
		return reportConcepto;
	}

	public void setReportConcepto(String reportConcepto) {
		this.reportConcepto = reportConcepto;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getModalidadEstudioDesc() {
		return modalidadEstudioDesc;
	}

	public void setModalidadEstudioDesc(String modalidadEstudioDesc) {
		this.modalidadEstudioDesc = modalidadEstudioDesc;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getPeriodoAnnoActual() {
		return periodoAnnoActual;
	}

	public void setPeriodoAnnoActual(Integer periodoAnnoActual) {
		this.periodoAnnoActual = periodoAnnoActual;
	}

	public Integer getWordFlowNumero() {
		return wordFlowNumero;
	}

	public void setWordFlowNumero(Integer wordFlowNumero) {
		this.wordFlowNumero = wordFlowNumero;
	}

	public Integer getEstadoNumero() {
		return estadoNumero;
	}

	public void setEstadoNumero(Integer estadoNumero) {
		this.estadoNumero = estadoNumero;
	}

	public String getCompaniaafiliada() {
		return companiaafiliada;
	}

	public void setCompaniaafiliada(String companiaafiliada) {
		this.companiaafiliada = companiaafiliada;
	}

	public String getNombreEtapa() {
		return nombreEtapa;
	}

	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
}