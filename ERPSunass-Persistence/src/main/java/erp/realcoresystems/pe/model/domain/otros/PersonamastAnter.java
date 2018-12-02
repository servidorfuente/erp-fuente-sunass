package erp.realcoresystems.pe.model.domain.otros;

import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.domain.SaTipoDocumentoIdentidad;
import erp.realcoresystems.pe.model.util.BooleanToIntegerConverter;
import erp.realcoresystems.pe.model.util.BooleanToStringConverter;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERSONAMAST")
public class PersonamastAnter extends Entidad {

	private Integer persona;
	private String origen;
	private String apellidopaterno;
	private String apellidomaterno;
	private String nombres;
	private String nombrecompleto;
	private String busqueda;
	private Integer tipodocumento;
	private String documento;
	private String codigobarras;
	private boolean escliente;
	private boolean esproveedor;
	private boolean esempleado;
	private boolean escontacto;
	private String tipopersona;
	private Date fechanacimiento;
	private String ciudadnacimiento;
	private String sexo = "M";
	private String nacionalidad;
	private String estadocivil;
	private String nivelinstruccion;
	private String direccion;
	private String codigopostal;
	private String provincia;
	private String departamento;
	private String distrito;
	private String telefono;
	private String fax;
	private String documentofiscal;
	private String documentoidentidad;
	private String carnetextranjeria;
	private String documentomilitarfa;
	private String tipobrevete;
	private String brevete;
	private String pasaporte;
	private String nombreemergencia;
	private String direccionemergencia;
	private String telefonoemergencia;
	private String bancomonedalocal;
	private String tipocuentalocal;
	private String cuentamonedalocal;
	private String bancomonedaextranjera;
	private String tipocuentaextranjera;
	private String cuentamonedaextranjera;
	private Integer personaant;
	private String correoelectronico;
	private String correoinstitucional;
	private String grupoetnico;
	private boolean enfermedadgraveflag;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String tipopersonausuario;
	private Date ingresofecharegistro;
	private String ingresoaplicacioncodigo;
	private String ingresousuario;
	private String pymeflag;
	private String nivelgobierno;
	/** SE USA PARA REGION **/
	private String personaclasificacion;
	private Date breveteFecvcto;
	private Date carnetextranjeriaFecvcto;
	private String pasaporteFecvcto;
	private String direccionreferencia;
	private String personanew;
	private String personaOld;
	private String lugarnacimiento;
	private String celularemergencia;
	private String tarjetadecredito;
	private String flagactualizacion;
	private String celular;
	private String parentescoemergencia;
	private String documentoidentidadFecvcto;
	private String sunatnacionalidad;
	private String sunatvia;
	private String sunatzona;
	private String sunatubigeo;
	private String sunatdomiciliado;
	private String cargoid;
	private String institucionid;
	private String dptolabor;
	private String provincialabor;
	private String distritolabor;
	private Boolean discapacidadflag;

	private SaTipoDocumentoIdentidad tipoDocumentoIdentidad;

	private String tipopersonafactura;
	private String documentofiscalfactura;

	@Transient
	private String correoElectronico;
	@Transient
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public PersonamastAnter() {
	}

	public PersonamastAnter(String cargoid, String institucionid) {
		this.cargoid = cargoid;
		this.institucionid = institucionid;
	}

	@Id
	@Column(name = "PERSONA")
	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	@Basic
	@Column(name = "ORIGEN")
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Basic
	@Column(name = "APELLIDOPATERNO")
	public String getApellidopaterno() {
		return apellidopaterno == null ? apellidopaterno : apellidopaterno.toUpperCase();
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	@Basic
	@Column(name = "APELLIDOMATERNO")
	public String getApellidomaterno() {
		return apellidomaterno == null ? apellidomaterno : apellidomaterno.toUpperCase();
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	@Basic
	@Column(name = "NOMBRES")
	public String getNombres() {
		return nombres == null ? nombres : nombres.toUpperCase();
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Basic
	@Column(name = "NOMBRECOMPLETO")
	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	@Basic
	@Column(name = "BUSQUEDA")
	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	@Basic
	@Column(name = "TIPODOCUMENTO")
	public Integer getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(Integer tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	@Basic
	@Column(name = "DOCUMENTO")
	public String getDocumento() {
		return documento == null ? documento : documento.toUpperCase();
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Basic
	@Column(name = "CODIGOBARRAS")
	public String getCodigobarras() {
		return codigobarras;
	}

	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}

	@Basic
	@Column(name = "ESCLIENTE")
//	@Type(type = "yes_no")
	@Convert(converter = BooleanToStringConverter.class)
	public boolean isEscliente() {
		return escliente;
	}

	public void setEscliente(boolean escliente) {
		this.escliente = escliente;
	}

	@Basic
	@Column(name = "ESPROVEEDOR")
//	@Type(type = "yes_no")
	@Convert(converter = BooleanToStringConverter.class)
	public boolean isEsproveedor() {
		return esproveedor;
	}

	public void setEsproveedor(boolean esproveedor) {
		this.esproveedor = esproveedor;
	}

	@Basic
	@Column(name = "ESEMPLEADO")
//	@Type(type = "yes_no")
	@Convert(converter = BooleanToStringConverter.class)
	public boolean isEsempleado() {
		return esempleado;
	}

	public void setEsempleado(boolean esempleado) {
		this.esempleado = esempleado;
	}

	@Basic
	@Column(name = "ESCONTACTO")
//	@Type(type = "yes_no")
	@Convert(converter = BooleanToStringConverter.class)
	public boolean isEscontacto() {
		return escontacto;
	}

	public void setEscontacto(boolean escontacto) {
		this.escontacto = escontacto;
	}

	@Basic
	@Column(name = "TIPOPERSONA")
	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	@Basic
	@Column(name = "FECHANACIMIENTO")
	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Basic
	@Column(name = "CIUDADNACIMIENTO")
	public String getCiudadnacimiento() {
		return ciudadnacimiento;
	}

	public void setCiudadnacimiento(String ciudadnacimiento) {
		this.ciudadnacimiento = ciudadnacimiento;
	}

	@Basic
	@Column(name = "SEXO")
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Basic
	@Column(name = "NACIONALIDAD")
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Basic
	@Column(name = "ESTADOCIVIL")
	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	@Basic
	@Column(name = "NIVELINSTRUCCION")
	public String getNivelinstruccion() {
		return nivelinstruccion;
	}

	public void setNivelinstruccion(String nivelinstruccion) {
		this.nivelinstruccion = nivelinstruccion;
	}

	@Basic
	@Column(name = "DIRECCION")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Basic
	@Column(name = "CODIGOPOSTAL")
	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	@Basic
	@Column(name = "PROVINCIA")
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Basic
	@Column(name = "DEPARTAMENTO")
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Basic
	@Column(name = "DISTRITO")
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Basic
	@Column(name = "TELEFONO")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Basic
	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Basic
	@Column(name = "DOCUMENTOFISCAL")
	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}

	@Basic
	@Column(name = "DOCUMENTOIDENTIDAD")
	public String getDocumentoidentidad() {
		return documentoidentidad;
	}

	public void setDocumentoidentidad(String documentoidentidad) {
		this.documentoidentidad = documentoidentidad;
	}

	@Basic
	@Column(name = "CARNETEXTRANJERIA")
	public String getCarnetextranjeria() {
		return carnetextranjeria;
	}

	public void setCarnetextranjeria(String carnetextranjeria) {
		this.carnetextranjeria = carnetextranjeria;
	}

	@Basic
	@Column(name = "DOCUMENTOMILITARFA")
	public String getDocumentomilitarfa() {
		return documentomilitarfa;
	}

	public void setDocumentomilitarfa(String documentomilitarfa) {
		this.documentomilitarfa = documentomilitarfa;
	}

	@Basic
	@Column(name = "TIPOBREVETE")
	public String getTipobrevete() {
		return tipobrevete;
	}

	public void setTipobrevete(String tipobrevete) {
		this.tipobrevete = tipobrevete;
	}

	@Basic
	@Column(name = "BREVETE")
	public String getBrevete() {
		return brevete;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}

	@Basic
	@Column(name = "PASAPORTE")
	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	@Basic
	@Column(name = "NOMBREEMERGENCIA")
	public String getNombreemergencia() {
		return nombreemergencia;
	}

	public void setNombreemergencia(String nombreemergencia) {
		this.nombreemergencia = nombreemergencia;
	}

	@Basic
	@Column(name = "DIRECCIONEMERGENCIA")
	public String getDireccionemergencia() {
		return direccionemergencia;
	}

	public void setDireccionemergencia(String direccionemergencia) {
		this.direccionemergencia = direccionemergencia;
	}

	@Basic
	@Column(name = "TELEFONOEMERGENCIA")
	public String getTelefonoemergencia() {
		return telefonoemergencia;
	}

	public void setTelefonoemergencia(String telefonoemergencia) {
		this.telefonoemergencia = telefonoemergencia;
	}

	@Basic
	@Column(name = "BANCOMONEDALOCAL")
	public String getBancomonedalocal() {
		return bancomonedalocal;
	}

	public void setBancomonedalocal(String bancomonedalocal) {
		this.bancomonedalocal = bancomonedalocal;
	}

	@Basic
	@Column(name = "TIPOCUENTALOCAL")
	public String getTipocuentalocal() {
		return tipocuentalocal;
	}

	public void setTipocuentalocal(String tipocuentalocal) {
		this.tipocuentalocal = tipocuentalocal;
	}

	@Basic
	@Column(name = "CUENTAMONEDALOCAL")
	public String getCuentamonedalocal() {
		return cuentamonedalocal;
	}

	public void setCuentamonedalocal(String cuentamonedalocal) {
		this.cuentamonedalocal = cuentamonedalocal;
	}

	@Basic
	@Column(name = "BANCOMONEDAEXTRANJERA")
	public String getBancomonedaextranjera() {
		return bancomonedaextranjera;
	}

	public void setBancomonedaextranjera(String bancomonedaextranjera) {
		this.bancomonedaextranjera = bancomonedaextranjera;
	}

	@Basic
	@Column(name = "TIPOCUENTAEXTRANJERA")
	public String getTipocuentaextranjera() {
		return tipocuentaextranjera;
	}

	public void setTipocuentaextranjera(String tipocuentaextranjera) {
		this.tipocuentaextranjera = tipocuentaextranjera;
	}

	@Basic
	@Column(name = "CUENTAMONEDAEXTRANJERA")
	public String getCuentamonedaextranjera() {
		return cuentamonedaextranjera;
	}

	public void setCuentamonedaextranjera(String cuentamonedaextranjera) {
		this.cuentamonedaextranjera = cuentamonedaextranjera;
	}

	@Basic
	@Column(name = "PERSONAANT")
	public Integer getPersonaant() {
		return personaant;
	}

	public void setPersonaant(Integer personaant) {
		this.personaant = personaant;
	}

	@Basic
	@Column(name = "CORREOELECTRONICO")
	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	@Basic
	@Column(name = "CORREOINSTITUCIONAL")
	public String getCorreoinstitucional() {
		return correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}

	@Basic
	@Column(name = "GRUPOETNICO")
	public String getGrupoetnico() {
		return grupoetnico;
	}

	public void setGrupoetnico(String grupoetnico) {
		this.grupoetnico = grupoetnico;
	}

	@Basic
	@Column(name = "ENFERMEDADGRAVEFLAG")
	@Convert(converter = BooleanToIntegerConverter.class)
	public Boolean getEnfermedadgraveflag() {
		return enfermedadgraveflag;
	}

	public void setEnfermedadgraveflag(Boolean enfermedadgraveflag) {
		this.enfermedadgraveflag = enfermedadgraveflag;
	}

	@Basic
	@Column(name = "ESTADO")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Basic
	@Column(name = "ULTIMOUSUARIO")
	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	@Basic
	@Column(name = "ULTIMAFECHAMODIF")
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	@Basic
	@Column(name = "TIPOPERSONAUSUARIO")
	public String getTipopersonausuario() {
		return tipopersonausuario;
	}

	public void setTipopersonausuario(String tipopersonausuario) {
		this.tipopersonausuario = tipopersonausuario;
	}

	@Basic
	@Column(name = "INGRESOFECHAREGISTRO")
	public Date getIngresofecharegistro() {
		return ingresofecharegistro;
	}

	public void setIngresofecharegistro(Date ingresofecharegistro) {
		this.ingresofecharegistro = ingresofecharegistro;
	}

	@Basic
	@Column(name = "INGRESOAPLICACIONCODIGO")
	public String getIngresoaplicacioncodigo() {
		return ingresoaplicacioncodigo;
	}

	public void setIngresoaplicacioncodigo(String ingresoaplicacioncodigo) {
		this.ingresoaplicacioncodigo = ingresoaplicacioncodigo;
	}

	@Basic
	@Column(name = "INGRESOUSUARIO")
	public String getIngresousuario() {
		return ingresousuario;
	}

	public void setIngresousuario(String ingresousuario) {
		this.ingresousuario = ingresousuario;
	}

	@Basic
	@Column(name = "PYMEFLAG")
	public String getPymeflag() {
		return pymeflag;
	}

	public void setPymeflag(String pymeflag) {
		this.pymeflag = pymeflag;
	}

	@Basic
	@Column(name = "NIVELGOBIERNO")
	public String getNivelgobierno() {
		return nivelgobierno;
	}

	public void setNivelgobierno(String nivelgobierno) {
		this.nivelgobierno = nivelgobierno;
	}

	@Basic
	@Column(name = "PERSONACLASIFICACION")
	public String getPersonaclasificacion() {
		return personaclasificacion;
	}

	public void setPersonaclasificacion(String personaclasificacion) {
		this.personaclasificacion = personaclasificacion;
	}

	@Basic
	@Column(name = "BREVETE_FECVCTO")
	public Date getBreveteFecvcto() {
		return breveteFecvcto;
	}

	public void setBreveteFecvcto(Date breveteFecvcto) {
		this.breveteFecvcto = breveteFecvcto;
	}

	@Basic
	@Column(name = "CARNETEXTRANJERIA_FECVCTO")
	public Date getCarnetextranjeriaFecvcto() {
		return carnetextranjeriaFecvcto;
	}

	public void setCarnetextranjeriaFecvcto(Date carnetextranjeriaFecvcto) {
		this.carnetextranjeriaFecvcto = carnetextranjeriaFecvcto;
	}

	@Basic
	@Column(name = "PASAPORTE_FECVCTO")
	public String getPasaporteFecvcto() {
		return pasaporteFecvcto;
	}

	public void setPasaporteFecvcto(String pasaporteFecvcto) {
		this.pasaporteFecvcto = pasaporteFecvcto;
	}

	@Basic
	@Column(name = "DIRECCIONREFERENCIA")
	public String getDireccionreferencia() {
		return direccionreferencia;
	}

	public void setDireccionreferencia(String direccionreferencia) {
		this.direccionreferencia = direccionreferencia;
	}

	@Basic
	@Column(name = "PERSONANEW")
	public String getPersonanew() {
		return personanew;
	}

	public void setPersonanew(String personanew) {
		this.personanew = personanew;
	}

	@Basic
	@Column(name = "PERSONA_OLD")
	public String getPersonaOld() {
		return personaOld;
	}

	public void setPersonaOld(String personaOld) {
		this.personaOld = personaOld;
	}

	@Basic
	@Column(name = "LUGARNACIMIENTO")
	public String getLugarnacimiento() {
		return lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	@Basic
	@Column(name = "CELULAREMERGENCIA")
	public String getCelularemergencia() {
		return celularemergencia;
	}

	public void setCelularemergencia(String celularemergencia) {
		this.celularemergencia = celularemergencia;
	}

	@Basic
	@Column(name = "TARJETADECREDITO")
	public String getTarjetadecredito() {
		return tarjetadecredito;
	}

	public void setTarjetadecredito(String tarjetadecredito) {
		this.tarjetadecredito = tarjetadecredito;
	}

	@Basic
	@Column(name = "FLAGACTUALIZACION")
	public String getFlagactualizacion() {
		return flagactualizacion;
	}

	public void setFlagactualizacion(String flagactualizacion) {
		this.flagactualizacion = flagactualizacion;
	}

	@Basic
	@Column(name = "CELULAR")
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Basic
	@Column(name = "PARENTESCOEMERGENCIA")
	public String getParentescoemergencia() {
		return parentescoemergencia;
	}

	public void setParentescoemergencia(String parentescoemergencia) {
		this.parentescoemergencia = parentescoemergencia;
	}

	@Basic
	@Column(name = "DOCUMENTOIDENTIDAD_FECVCTO")
	public String getDocumentoidentidadFecvcto() {
		return documentoidentidadFecvcto;
	}

	public void setDocumentoidentidadFecvcto(String documentoidentidadFecvcto) {
		this.documentoidentidadFecvcto = documentoidentidadFecvcto;
	}

	@Basic
	@Column(name = "SUNATNACIONALIDAD")
	public String getSunatnacionalidad() {
		return sunatnacionalidad;
	}

	public void setSunatnacionalidad(String sunatnacionalidad) {
		this.sunatnacionalidad = sunatnacionalidad;
	}

	@Basic
	@Column(name = "SUNATVIA")
	public String getSunatvia() {
		return sunatvia;
	}

	public void setSunatvia(String sunatvia) {
		this.sunatvia = sunatvia;
	}

	@Basic
	@Column(name = "SUNATZONA")
	public String getSunatzona() {
		return sunatzona;
	}

	public void setSunatzona(String sunatzona) {
		this.sunatzona = sunatzona;
	}

	@Basic
	@Column(name = "SUNATUBIGEO")
	public String getSunatubigeo() {
		return sunatubigeo;
	}

	public void setSunatubigeo(String sunatubigeo) {
		this.sunatubigeo = sunatubigeo;
	}

	@Basic
	@Column(name = "SUNATDOMICILIADO")
	public String getSunatdomiciliado() {
		return sunatdomiciliado;
	}

	public void setSunatdomiciliado(String sunatdomiciliado) {
		this.sunatdomiciliado = sunatdomiciliado;
	}

	@OneToOne
	@JoinColumn(name = "TIPODOCUMENTO", referencedColumnName = "TDITIPODOCID", insertable = false, updatable = false, nullable = true)
	public SaTipoDocumentoIdentidad getTipoDocumentoIdentidad() {
		return tipoDocumentoIdentidad;
	}

	public void setTipoDocumentoIdentidad(SaTipoDocumentoIdentidad tipoDocumentoIdentidad) {
		this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
	}

	@Basic
	@Column(name = "CARGOID")
	public String getCargoid() {
		return cargoid;
	}

	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}

	@Basic
	@Column(name = "INSTITUCIONID")
	public String getInstitucionid() {
		return institucionid;
	}

	public void setInstitucionid(String institucionid) {
		this.institucionid = institucionid;
	}

	@Basic
	@Column(name = "DPTOLABOR")
	public String getDptolabor() {
		return dptolabor;
	}

	public void setDptolabor(String dptolabor) {
		this.dptolabor = dptolabor;
	}

	@Basic
	@Column(name = "PROVINCIALABOR")
	public String getProvincialabor() {
		return provincialabor;
	}

	public void setProvincialabor(String provincialabor) {
		this.provincialabor = provincialabor;
	}

	@Basic
	@Column(name = "DISTRITOLABOR")
	public String getDistritolabor() {
		return distritolabor;
	}

	public void setDistritolabor(String distritolabor) {
		this.distritolabor = distritolabor;
	}

	@Column(name = "DISCAPACIDADFLAG")
	@Convert(converter = BooleanToIntegerConverter.class)
	public Boolean getDiscapacidadflag() {
		return discapacidadflag;
	}

	
	public void setDiscapacidadflag(Boolean discapacidadflag) {
		this.discapacidadflag = discapacidadflag;
	}


	
	@Column(name = "TIPOPERSONAFACTURA")
	public String getTipopersonafactura() {
		return tipopersonafactura;
	}

	public void setTipopersonafactura(String tipopersonafactura) {
		this.tipopersonafactura = tipopersonafactura;
	}

	@Column(name = "DOCUMENTOFISCALFACTURA")
	public String getDocumentofiscalfactura() {
		return documentofiscalfactura;
	}

	public void setDocumentofiscalfactura(String documentofiscalfactura) {
		this.documentofiscalfactura = documentofiscalfactura;
	}

	
}
