package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Entidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ldapUrl;
	private String principle;
	private String password;
	private String organizationalUnit;

	private String commonName;
	private String companyCenter;
	private String department;

	private String dN;
	private String email;
	private String familyName;
	private String givenName;
	private String manager;
	private String phone;
	private String userId;

	private int inicio;
	private int numeroFilas;

	private int numeroColumnas;
	private boolean visibled;

	private boolean acessos;
	private int rowNumber;

	private String flagAuditoriaEntGlobal;
	private String flagAuditSoloTransactEntGlobal;
	private String nombreUsuarioEntGlobal;
	private String usuarioEntGlobal;
	private String hostEntGlobal;
	private String ipEntGlobal;
	private String conceptoPadreEntGlobal;
	private String conceptoEntGlobal;
	private String appCodigoEntGlobal;
	private String moduloEntGlobal;
	private String motivoObservacionAuditEntGlobal;

	private String usuarioDbEntGlobal;
	private Date fechaAccionEntGlobal;
	private Date fechaSessionEntGlobal;
	private String pcNameClienteEntGlobal;
	private String macClienteEntGlobal;
	private Long flagExitoEntGlobal;
	private String sysVersionEntGlobal;
	private String sysUrlEntGlobal;

	private Object objetoAntiguo;
	private Class<?> claseTablaAudit;

	private String descripcionCCosto;
	private String descripcion01;
	private String descripcion02;
	private String flagConsultaEntGlobal;

	private String usuarioCreacionGlobal;
	private String usuarioModificacionGlobal;

	private String sectorAplicarUpdate;

	private Integer cursoID;
	private Integer tipoProductoTM;
	private Integer crrflagmodularTM;
	private Integer ccucicloTM;
	private Integer clocurriculoidTM;

	private String tipoOrdenacion;

	private Date fechaInicioBusqueda;
	private Date fechaFinBusqueda;
	private Date horaInicioBusqueda;
	private Date horaFinBusqueda;

	private String nombreConsulta = "";

	private String atributoList;// SIRVE PARA COLOCAR EL NOMBRE DE LA COLUMNA CON EL CUAL SE USARAN LAS CONSULTAS IN
	private List<String> listString;
	private List<Integer> listInteger;

	private String parametroNombreFiltro;
	private String parametroNombreOrden;

	private boolean transactionRollback = true;

	public Date getFechaInicioBusqueda() {
		return fechaInicioBusqueda;
	}

	public void setFechaInicioBusqueda(Date fechaInicioBusqueda) {
		this.fechaInicioBusqueda = fechaInicioBusqueda;
	}

	public Date getFechaFinBusqueda() {
		return fechaFinBusqueda;
	}

	public void setFechaFinBusqueda(Date fechaFinBusqueda) {
		this.fechaFinBusqueda = fechaFinBusqueda;
	}

	public String getUsuarioCreacionGlobal() {
		return usuarioCreacionGlobal;
	}

	public void setUsuarioCreacionGlobal(String usuarioCreacionGlobal) {
		this.usuarioCreacionGlobal = usuarioCreacionGlobal;
	}

	public String getUsuarioModificacionGlobal() {
		return usuarioModificacionGlobal;
	}

	public void setUsuarioModificacionGlobal(String usuarioModificacionGlobal) {
		this.usuarioModificacionGlobal = usuarioModificacionGlobal;
	}

	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	public void setNumeroColumnas(int numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}

	private String accion;
	private double totalProg;
	private double totalEject;

	public double getTotalProg() {
		return totalProg;
	}

	public void setTotalProg(double totalProg) {
		this.totalProg = totalProg;
	}

	public double getTotalEject() {
		return totalEject;
	}

	public void setTotalEject(double totalEject) {
		this.totalEject = totalEject;
	}

	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;
	private String string6;
	private String string7;
	private String string8;
	private String string9;
	private String string10;

	private int int_1;
	private int int_2;
	private int int_3;
	private Long long_1;
	private Long long_2;

	private boolean bool_1;
	private boolean bool_2;

	private Integer integer1;
	private Integer integer2;
	private Integer integer3;

	private boolean nuevo;

	private List<Long> listaLong;
	private List<Integer> listaInteger;
	private List<Integer> listaInteger2;
	private List<String> listaString;


	private String atributoOrdenacion;
	private List<String> listaAtributoOrdenacion;

	private boolean paginable;
	private boolean ordernable;

	public boolean isOrdernable() {
		return ordernable;
	}

	public void setOrdernable(boolean ordernable) {
		this.ordernable = ordernable;
	}

	public List<String> getListaAtributoOrdenacion() {
		return listaAtributoOrdenacion;
	}

	public void setListaAtributoOrdenacion(List<String> listaAtributoOrdenacion) {
		this.listaAtributoOrdenacion = listaAtributoOrdenacion;
	}

	public void setAtributoOrdenacion(String atributoOrdenacion) {
		this.atributoOrdenacion = atributoOrdenacion;
	}

	public String getAtributoOrdenacion() {
		return atributoOrdenacion;
	}

	public List<Integer> getListaInteger() {
		return listaInteger;
	}

	public void setListaInteger(List<Integer> listaInteger) {
		this.listaInteger = listaInteger;
	}

	public List<Integer> getListaInteger2() {
		return listaInteger2;
	}

	public void setListaInteger2(List<Integer> listaInteger2) {
		this.listaInteger2 = listaInteger2;
	}

	public List<Long> getListaLong() {
		return listaLong;
	}

	public void setListaLong(List<Long> listaLong) {
		this.listaLong = listaLong;
	}

	public List<String> getListaString() {
		return listaString;
	}

	public void setListaString(List<String> listaString) {
		this.listaString = listaString;
	}

	public boolean isVisibled() {
		return visibled;
	}

	public void setVisibled(boolean visibled) {
		this.visibled = visibled;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getInt_1() {
		return int_1;
	}

	public void setInt_1(int int_1) {
		this.int_1 = int_1;
	}

	public int getInt_2() {
		return int_2;
	}

	public void setInt_2(int int_2) {
		this.int_2 = int_2;
	}

	public int getInt_3() {
		return int_3;
	}

	public void setInt_3(int int_3) {
		this.int_3 = int_3;
	}

	public Long getLong_1() {
		return long_1;
	}

	public void setLong_1(Long long_1) {
		this.long_1 = long_1;
	}

	public Long getLong_2() {
		return long_2;
	}

	public void setLong_2(Long long_2) {
		this.long_2 = long_2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public String getString4() {
		return string4;
	}

	public void setString4(String string4) {
		this.string4 = string4;
	}

	public String getString5() {
		return string5;
	}

	public void setString5(String string5) {
		this.string5 = string5;
	}

	public String getString6() {
		return string6;
	}

	public void setString6(String string6) {
		this.string6 = string6;
	}

	public String getString7() {
		return string7;
	}

	public void setString7(String string7) {
		this.string7 = string7;
	}

	public String getString8() {
		return string8;
	}

	public void setString8(String string8) {
		this.string8 = string8;
	}

	public String getString9() {
		return string9;
	}

	public void setString9(String string9) {
		this.string9 = string9;
	}

	public String getString10() {
		return string10;
	}

	public void setString10(String string10) {
		this.string10 = string10;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getNumeroFilas() {
		return numeroFilas;
	}

	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getNombreUsuarioEntGlobal() {
		return nombreUsuarioEntGlobal;
	}

	public void setNombreUsuarioEntGlobal(String nombreUsuarioEntGlobal) {
		this.nombreUsuarioEntGlobal = nombreUsuarioEntGlobal;
	}

	public String getUsuarioEntGlobal() {
		return usuarioEntGlobal;
	}

	public void setUsuarioEntGlobal(String usuarioEntGlobal) {
		this.usuarioEntGlobal = usuarioEntGlobal;
	}

	public String getHostEntGlobal() {
		return hostEntGlobal;
	}

	public void setHostEntGlobal(String hostEntGlobal) {
		this.hostEntGlobal = hostEntGlobal;
	}

	public String getIpEntGlobal() {
		return ipEntGlobal;
	}

	public void setIpEntGlobal(String ipEntGlobal) {
		this.ipEntGlobal = ipEntGlobal;
	}

	public String getConceptoPadreEntGlobal() {
		return conceptoPadreEntGlobal;
	}

	public void setConceptoPadreEntGlobal(String conceptoPadreEntGlobal) {
		this.conceptoPadreEntGlobal = conceptoPadreEntGlobal;
	}

	public String getDescripcionCCosto() {
		return descripcionCCosto;
	}

	public void setDescripcionCCosto(String descripcionCCosto) {
		this.descripcionCCosto = descripcionCCosto;
	}

	public String getConceptoEntGlobal() {
		return conceptoEntGlobal;
	}

	public void setConceptoEntGlobal(String conceptoEntGlobal) {
		this.conceptoEntGlobal = conceptoEntGlobal;
	}

	public String getAppCodigoEntGlobal() {
		return appCodigoEntGlobal;
	}

	public void setAppCodigoEntGlobal(String appCodigoEntGlobal) {
		this.appCodigoEntGlobal = appCodigoEntGlobal;
	}

	public String getModuloEntGlobal() {
		return moduloEntGlobal;
	}

	public void setModuloEntGlobal(String moduloEntGlobal) {
		this.moduloEntGlobal = moduloEntGlobal;
	}

	public Date getFechaAccionEntGlobal() {
		return fechaAccionEntGlobal;
	}

	public void setFechaAccionEntGlobal(Date fechaAccionEntGlobal) {
		this.fechaAccionEntGlobal = fechaAccionEntGlobal;
	}

	public Date getFechaSessionEntGlobal() {
		return fechaSessionEntGlobal;
	}

	public void setFechaSessionEntGlobal(Date fechaSessionEntGlobal) {
		this.fechaSessionEntGlobal = fechaSessionEntGlobal;
	}

	public String getPcNameClienteEntGlobal() {
		return pcNameClienteEntGlobal;
	}

	public void setPcNameClienteEntGlobal(String pcNameClienteEntGlobal) {
		this.pcNameClienteEntGlobal = pcNameClienteEntGlobal;
	}

	public String getMacClienteEntGlobal() {
		return macClienteEntGlobal;
	}

	public void setMacClienteEntGlobal(String macClienteEntGlobal) {
		this.macClienteEntGlobal = macClienteEntGlobal;
	}

	public Long getFlagExitoEntGlobal() {
		return flagExitoEntGlobal;
	}

	public void setFlagExitoEntGlobal(Long flagExitoEntGlobal) {
		this.flagExitoEntGlobal = flagExitoEntGlobal;
	}

	public String getSysVersionEntGlobal() {
		return sysVersionEntGlobal;
	}

	public void setSysVersionEntGlobal(String sysVersionEntGlobal) {
		this.sysVersionEntGlobal = sysVersionEntGlobal;
	}

	public String getSysUrlEntGlobal() {
		return sysUrlEntGlobal;
	}

	public void setSysUrlEntGlobal(String sysUrlEntGlobal) {
		this.sysUrlEntGlobal = sysUrlEntGlobal;
	}

	public String getUsuarioDbEntGlobal() {
		return usuarioDbEntGlobal;
	}

	public void setUsuarioDbEntGlobal(String usuarioDbEntGlobal) {
		this.usuarioDbEntGlobal = usuarioDbEntGlobal;
	}

	public Object getObjetoAntiguo() {
		return objetoAntiguo;
	}

	public void setObjetoAntiguo(Object objetoAntiguo) {
		this.objetoAntiguo = objetoAntiguo;
	}

	public Class<?> getClaseTablaAudit() {
		return claseTablaAudit;
	}

	public void setClaseTablaAudit(Class<?> claseTablaAudit) {
		this.claseTablaAudit = claseTablaAudit;
	}

	public String getDescripcion01() {
		return descripcion01;
	}

	public void setDescripcion01(String descripcion01) {
		this.descripcion01 = descripcion01;
	}

	public String getDescripcion02() {
		return descripcion02;
	}

	public void setDescripcion02(String descripcion02) {
		this.descripcion02 = descripcion02;
	}

	public String getFlagConsultaEntGlobal() {
		return flagConsultaEntGlobal;
	}

	public void setFlagConsultaEntGlobal(String flagConsultaEntGlobal) {
		this.flagConsultaEntGlobal = flagConsultaEntGlobal;
	}

	public String getFlagAuditoriaEntGlobal() {
		return flagAuditoriaEntGlobal;
	}

	public void setFlagAuditoriaEntGlobal(String flagAuditoriaEntGlobal) {
		this.flagAuditoriaEntGlobal = flagAuditoriaEntGlobal;
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

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getdN() {
		return dN;
	}

	public void setdN(String dN) {
		this.dN = dN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyCenter() {
		return companyCenter;
	}

	public void setCompanyCenter(String companyCenter) {
		this.companyCenter = companyCenter;
	}

	public String getSectorAplicarUpdate() {
		return sectorAplicarUpdate;
	}

	public void setSectorAplicarUpdate(String sectorAplicarUpdate) {
		this.sectorAplicarUpdate = sectorAplicarUpdate;
	}

	public String getFlagAuditSoloTransactEntGlobal() {
		return flagAuditSoloTransactEntGlobal;
	}

	public void setFlagAuditSoloTransactEntGlobal(String flagAuditSoloTransactEntGlobal) {
		this.flagAuditSoloTransactEntGlobal = flagAuditSoloTransactEntGlobal;
	}

	public boolean isBool_1() {
		return bool_1;
	}

	public void setBool_1(boolean bool_1) {
		this.bool_1 = bool_1;
	}

	public boolean isBool_2() {
		return bool_2;
	}

	public void setBool_2(boolean bool_2) {
		this.bool_2 = bool_2;
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	public Integer getCursoID() {
		return cursoID;
	}

	public void setCursoID(Integer cursoID) {
		this.cursoID = cursoID;
	}

	public Integer getTipoProductoTM() {
		return tipoProductoTM;
	}

	public void setTipoProductoTM(Integer tipoProductoTM) {
		this.tipoProductoTM = tipoProductoTM;
	}

	public Integer getCrrflagmodularTM() {
		return crrflagmodularTM;
	}

	public void setCrrflagmodularTM(Integer crrflagmodularTM) {
		this.crrflagmodularTM = crrflagmodularTM;
	}

	public Integer getCcucicloTM() {
		return ccucicloTM;
	}

	public void setCcucicloTM(Integer ccucicloTM) {
		this.ccucicloTM = ccucicloTM;
	}

	public Integer getClocurriculoidTM() {
		return clocurriculoidTM;
	}

	public void setClocurriculoidTM(Integer clocurriculoidTM) {
		this.clocurriculoidTM = clocurriculoidTM;
	}

	public boolean isAcessos() {
		return acessos;
	}

	public void setAcessos(boolean acessos) {
		this.acessos = acessos;
	}

	public boolean isPaginable() {
		return paginable;
	}

	public void setPaginable(boolean paginable) {
		this.paginable = paginable;
	}

	public boolean isTransactionRollback() {
		return transactionRollback;
	}

	public void setTransactionRollback(boolean transactionRollback) {
		this.transactionRollback = transactionRollback;
	}

	public Integer getInteger1() {
		return integer1;
	}

	public void setInteger1(Integer integer1) {
		this.integer1 = integer1;
	}

	public Integer getInteger2() {
		return integer2;
	}

	public void setInteger2(Integer integer2) {
		this.integer2 = integer2;
	}

	public Integer getInteger3() {
		return integer3;
	}

	public void setInteger3(Integer integer3) {
		this.integer3 = integer3;
	}

	public String getParametroNombreFiltro() {
		return parametroNombreFiltro;
	}

	public void setParametroNombreFiltro(String parametroNombreFiltro) {
		this.parametroNombreFiltro = parametroNombreFiltro;
	}

	public String getParametroNombreOrden() {
		return parametroNombreOrden;
	}

	public void setParametroNombreOrden(String parametroNombreOrden) {
		this.parametroNombreOrden = parametroNombreOrden;
	}

	public String getTipoOrdenacion() {
		return tipoOrdenacion;
	}

	public void setTipoOrdenacion(String tipoOrdenacion) {
		this.tipoOrdenacion = tipoOrdenacion;
	}

	public String getAtributoList() {
		return atributoList;
	}

	public void setAtributoList(String atributoList) {
		this.atributoList = atributoList;
	}

	public String getMotivoObservacionAuditEntGlobal() {
		return motivoObservacionAuditEntGlobal;
	}

	public void setMotivoObservacionAuditEntGlobal(String motivoObservacionAuditEntGlobal) {
		this.motivoObservacionAuditEntGlobal = motivoObservacionAuditEntGlobal;
	}

	public Date getHoraInicioBusqueda() {
		return horaInicioBusqueda;
	}

	public void setHoraInicioBusqueda(Date horaInicioBusqueda) {
		this.horaInicioBusqueda = horaInicioBusqueda;
	}

	public Date getHoraFinBusqueda() {
		return horaFinBusqueda;
	}

	public void setHoraFinBusqueda(Date horaFinBusqueda) {
		this.horaFinBusqueda = horaFinBusqueda;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getNombreConsulta() {
		return nombreConsulta;
	}

	public void setNombreConsulta(String nombreConsulta) {
		this.nombreConsulta = nombreConsulta;
	}

	public List<String> getListString() {
		return listString;
	}

	public void setListString(List<String> listString) {
		this.listString = listString;
	}

	public List<Integer> getListInteger() {
		return listInteger;
	}

	public void setListInteger(List<Integer> listInteger) {
		this.listInteger = listInteger;
	}

}
