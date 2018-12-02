package erp.realcoresystems.pe.erprrhhrest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;

import java.util.Date;


@JsonIgnoreProperties( value = { 
		/**Campos a ignorar*/	
		"uri"
		,"paginable"
	})
@JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
public class PersonaMastJson  extends EntidadJson<PersonaMastJson> {

	private int persona;
	private String origen;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String nombreCompleto;
	private String busqueda;
	private String tipoDocumento;
	private String documento;
	private String codigoBarras;
	private String tipoPersonaUsuario;
	private String esCliente;
	private String esProveedor;
	private String esEmpleado;
	private String esOtro;
	private String tipoPersona;
	private Date fechaNacimiento;
	private String ciudadNacimiento;
	private String sexo;
	private String nacionalidad;
	private String estadoCivil;
	private String nivelInstruccion;
	private String direccion;
	private String departamento;
	private String provincia;
	private String codigoPostal;
	private String telefono;
	private String fax;
	private String documentoFiscal;
	private String documentoIdentidad;
	private String carnetExtranjeria;
	private String documentoMilitarFa;
	private String tipoBrevete;
	private String brevete;
	private String pasaporte;
	private String nombreEmergencia;
	private String direccionEmergencia;
	private String telefonoEmergencia;
	private String bancoMonedaLocal;
	private String tipoCuentaLocal;
	private String cuentaMonedaLocal;
	private String bancoMonedaExtranjera;
	private String tipoCuentaExtranjera;
	private String cuentaMonedaExtranjera;
	private String personaAnt;
	private String correoElectronico;
	private String clasePersonaCodigo;
	private String enfermedadGraveFlag;
	private Date ingresoFechaRegistro;
	private String ingresoAplicacionCodigo;
	private String ingresoUsuario;
	private String pymeFlag;
	private String personaClasificacion;
	private String tarjetadeCredito;
	private String flagActualizacion;
	private String celular;
	private String parentescoEmergencia;
	private String celularEmergencia;
	private String lugarNacimiento;
	private String estado;
	private String ultimoUsuario;
	private Date ultimaFechaModif;
	private String direccionReferencia;
	private Date breveteFecVcto;
	private Date carnetExtranjeriaFecVcto;
	private String sunatNacionalidad;
	private String sunatVia;
	private String sunatZona;
	private String sunatUbigeo;
	private String sunatDomiciliado;
	private String paisEmisor;
	private String codigoLdn;
	private String codigoInterbancario;
	private String flagsolicitausuario;
	private String pais;

	public int getPersona() {
		return persona;
	}

	public void setPersona(int persona) {
		this.persona = persona;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getTipoPersonaUsuario() {
		return tipoPersonaUsuario;
	}

	public void setTipoPersonaUsuario(String tipoPersonaUsuario) {
		this.tipoPersonaUsuario = tipoPersonaUsuario;
	}

	public String getEsCliente() {
		return esCliente;
	}

	public void setEsCliente(String esCliente) {
		this.esCliente = esCliente;
	}

	public String getEsProveedor() {
		return esProveedor;
	}

	public void setEsProveedor(String esProveedor) {
		this.esProveedor = esProveedor;
	}

	public String getEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(String esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

	public String getEsOtro() {
		return esOtro;
	}

	public void setEsOtro(String esOtro) {
		this.esOtro = esOtro;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNivelInstruccion() {
		return nivelInstruccion;
	}

	public void setNivelInstruccion(String nivelInstruccion) {
		this.nivelInstruccion = nivelInstruccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDocumentoFiscal() {
		return documentoFiscal;
	}

	public void setDocumentoFiscal(String documentoFiscal) {
		this.documentoFiscal = documentoFiscal;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getCarnetExtranjeria() {
		return carnetExtranjeria;
	}

	public void setCarnetExtranjeria(String carnetExtranjeria) {
		this.carnetExtranjeria = carnetExtranjeria;
	}

	public String getDocumentoMilitarFa() {
		return documentoMilitarFa;
	}

	public void setDocumentoMilitarFa(String documentoMilitarFa) {
		this.documentoMilitarFa = documentoMilitarFa;
	}

	public String getTipoBrevete() {
		return tipoBrevete;
	}

	public void setTipoBrevete(String tipoBrevete) {
		this.tipoBrevete = tipoBrevete;
	}

	public String getBrevete() {
		return brevete;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getNombreEmergencia() {
		return nombreEmergencia;
	}

	public void setNombreEmergencia(String nombreEmergencia) {
		this.nombreEmergencia = nombreEmergencia;
	}

	public String getDireccionEmergencia() {
		return direccionEmergencia;
	}

	public void setDireccionEmergencia(String direccionEmergencia) {
		this.direccionEmergencia = direccionEmergencia;
	}

	public String getTelefonoEmergencia() {
		return telefonoEmergencia;
	}

	public void setTelefonoEmergencia(String telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}

	public String getBancoMonedaLocal() {
		return bancoMonedaLocal;
	}

	public void setBancoMonedaLocal(String bancoMonedaLocal) {
		this.bancoMonedaLocal = bancoMonedaLocal;
	}

	public String getTipoCuentaLocal() {
		return tipoCuentaLocal;
	}

	public void setTipoCuentaLocal(String tipoCuentaLocal) {
		this.tipoCuentaLocal = tipoCuentaLocal;
	}

	public String getCuentaMonedaLocal() {
		return cuentaMonedaLocal;
	}

	public void setCuentaMonedaLocal(String cuentaMonedaLocal) {
		this.cuentaMonedaLocal = cuentaMonedaLocal;
	}

	public String getBancoMonedaExtranjera() {
		return bancoMonedaExtranjera;
	}

	public void setBancoMonedaExtranjera(String bancoMonedaExtranjera) {
		this.bancoMonedaExtranjera = bancoMonedaExtranjera;
	}

	public String getTipoCuentaExtranjera() {
		return tipoCuentaExtranjera;
	}

	public void setTipoCuentaExtranjera(String tipoCuentaExtranjera) {
		this.tipoCuentaExtranjera = tipoCuentaExtranjera;
	}

	public String getCuentaMonedaExtranjera() {
		return cuentaMonedaExtranjera;
	}

	public void setCuentaMonedaExtranjera(String cuentaMonedaExtranjera) {
		this.cuentaMonedaExtranjera = cuentaMonedaExtranjera;
	}

	public String getPersonaAnt() {
		return personaAnt;
	}

	public void setPersonaAnt(String personaAnt) {
		this.personaAnt = personaAnt;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getClasePersonaCodigo() {
		return clasePersonaCodigo;
	}

	public void setClasePersonaCodigo(String clasePersonaCodigo) {
		this.clasePersonaCodigo = clasePersonaCodigo;
	}

	public String getEnfermedadGraveFlag() {
		return enfermedadGraveFlag;
	}

	public void setEnfermedadGraveFlag(String enfermedadGraveFlag) {
		this.enfermedadGraveFlag = enfermedadGraveFlag;
	}

	public Date getIngresoFechaRegistro() {
		return ingresoFechaRegistro;
	}

	public void setIngresoFechaRegistro(Date ingresoFechaRegistro) {
		this.ingresoFechaRegistro = ingresoFechaRegistro;
	}

	public String getIngresoAplicacionCodigo() {
		return ingresoAplicacionCodigo;
	}

	public void setIngresoAplicacionCodigo(String ingresoAplicacionCodigo) {
		this.ingresoAplicacionCodigo = ingresoAplicacionCodigo;
	}

	public String getIngresoUsuario() {
		return ingresoUsuario;
	}

	public void setIngresoUsuario(String ingresoUsuario) {
		this.ingresoUsuario = ingresoUsuario;
	}

	public String getPymeFlag() {
		return pymeFlag;
	}

	public void setPymeFlag(String pymeFlag) {
		this.pymeFlag = pymeFlag;
	}

	public String getPersonaClasificacion() {
		return personaClasificacion;
	}

	public void setPersonaClasificacion(String personaClasificacion) {
		this.personaClasificacion = personaClasificacion;
	}

	public String getTarjetadeCredito() {
		return tarjetadeCredito;
	}

	public void setTarjetadeCredito(String tarjetadeCredito) {
		this.tarjetadeCredito = tarjetadeCredito;
	}

	public String getFlagActualizacion() {
		return flagActualizacion;
	}

	public void setFlagActualizacion(String flagActualizacion) {
		this.flagActualizacion = flagActualizacion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getParentescoEmergencia() {
		return parentescoEmergencia;
	}

	public void setParentescoEmergencia(String parentescoEmergencia) {
		this.parentescoEmergencia = parentescoEmergencia;
	}

	public String getCelularEmergencia() {
		return celularEmergencia;
	}

	public void setCelularEmergencia(String celularEmergencia) {
		this.celularEmergencia = celularEmergencia;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	public Date getUltimaFechaModif() {
		return ultimaFechaModif;
	}

	public void setUltimaFechaModif(Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public Date getBreveteFecVcto() {
		return breveteFecVcto;
	}

	public void setBreveteFecVcto(Date breveteFecVcto) {
		this.breveteFecVcto = breveteFecVcto;
	}

	public Date getCarnetExtranjeriaFecVcto() {
		return carnetExtranjeriaFecVcto;
	}

	public void setCarnetExtranjeriaFecVcto(Date carnetExtranjeriaFecVcto) {
		this.carnetExtranjeriaFecVcto = carnetExtranjeriaFecVcto;
	}

	public String getSunatNacionalidad() {
		return sunatNacionalidad;
	}

	public void setSunatNacionalidad(String sunatNacionalidad) {
		this.sunatNacionalidad = sunatNacionalidad;
	}

	public String getSunatVia() {
		return sunatVia;
	}

	public void setSunatVia(String sunatVia) {
		this.sunatVia = sunatVia;
	}

	public String getSunatZona() {
		return sunatZona;
	}

	public void setSunatZona(String sunatZona) {
		this.sunatZona = sunatZona;
	}

	public String getSunatUbigeo() {
		return sunatUbigeo;
	}

	public void setSunatUbigeo(String sunatUbigeo) {
		this.sunatUbigeo = sunatUbigeo;
	}

	public String getSunatDomiciliado() {
		return sunatDomiciliado;
	}

	public void setSunatDomiciliado(String sunatDomiciliado) {
		this.sunatDomiciliado = sunatDomiciliado;
	}

	public String getPaisEmisor() {
		return paisEmisor;
	}

	public void setPaisEmisor(String paisEmisor) {
		this.paisEmisor = paisEmisor;
	}

	public String getCodigoLdn() {
		return codigoLdn;
	}

	public void setCodigoLdn(String codigoLdn) {
		this.codigoLdn = codigoLdn;
	}

	public String getCodigoInterbancario() {
		return codigoInterbancario;
	}

	public void setCodigoInterbancario(String codigoInterbancario) {
		this.codigoInterbancario = codigoInterbancario;
	}

	public String getFlagsolicitausuario() {
		return flagsolicitausuario;
	}

	public void setFlagsolicitausuario(String flagsolicitausuario) {
		this.flagsolicitausuario = flagsolicitausuario;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
