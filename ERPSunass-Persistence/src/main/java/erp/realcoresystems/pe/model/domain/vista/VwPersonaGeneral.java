package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.util.BooleanToStringIntegerConverter;

/**
 * The persistent class for the VW_PERSONA_GENERAL database table.
 * 
 */
@Entity
@Table(name = "VW_PERSONA_GENERAL")
public class VwPersonaGeneral extends Entidad {
	private static final long serialVersionUID = 1L;
	private String apellidomaterno;
	private String apellidopaterno;
	private String busqueda;
	private String celular;
	private String codigopostal;
	private String correoelectronico;
	private String correoinstitucional;
	private String departamento;
	private String direccion;
	private String direccionemergencia;
	private Integer docestado;
	private String documento;
	private String documentofiscalfactura;
	private Boolean enfermedadgraveflag;
	private String escliente;
	private String escontacto;
	private String esempleado;
	private String esproveedor;
	private String estado;
	private String estadocivil;
	private Date fechanacimiento;
	private String flaghabilitadoRnp;
	private String flagsmf;
	private Date ingresofecharegistro;
	private String nombrecompleto;
	private String nombreemergencia;
	private String nombres;
	private String observaciones;
	private String organigrama;
	private String origen;
	private Integer persona;
	private Integer personaant;
	private String personaclasificacion;
	private Integer posicionorganigrama;
	private String provincia;
	private String sexo;
	private String telefono;
	private String tipodocumento;
	private String tipopersona;
	private String tipopersonafactura;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;
	private Date vigenciaRnp;

	public VwPersonaGeneral() {
	}

	@Column(length = 60)
	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	@Column(length = 60)
	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	@Column(length = 80)
	public String getBusqueda() {
		return this.busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	@Column(length = 30)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(length = 3)
	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	@Column(length = 50)
	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	@Column(length = 50)
	public String getCorreoinstitucional() {
		return this.correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}

	@Column(length = 3)
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Column(length = 200)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(length = 60)
	public String getDireccionemergencia() {
		return this.direccionemergencia;
	}

	public void setDireccionemergencia(String direccionemergencia) {
		this.direccionemergencia = direccionemergencia;
	}

	public Integer getDocestado() {
		return this.docestado;
	}

	public void setDocestado(Integer docestado) {
		this.docestado = docestado;
	}

	@Column(length = 20)
	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Column(length = 20)
	public String getDocumentofiscalfactura() {
		return this.documentofiscalfactura;
	}

	public void setDocumentofiscalfactura(String documentofiscalfactura) {
		this.documentofiscalfactura = documentofiscalfactura;
	}

	@Convert(converter = BooleanToStringIntegerConverter.class)
	public Boolean getEnfermedadgraveflag() {
		return this.enfermedadgraveflag;
	}

	public void setEnfermedadgraveflag(Boolean enfermedadgraveflag) {
		this.enfermedadgraveflag = enfermedadgraveflag;
	}

	@Column(length = 1)
	public String getEscliente() {
		return this.escliente;
	}

	public void setEscliente(String escliente) {
		this.escliente = escliente;
	}

	@Column(length = 1)
	public String getEscontacto() {
		return this.escontacto;
	}

	public void setEscontacto(String escontacto) {
		this.escontacto = escontacto;
	}

	@Column(length = 1)
	public String getEsempleado() {
		return this.esempleado;
	}

	public void setEsempleado(String esempleado) {
		this.esempleado = esempleado;
	}

	@Column(length = 1)
	public String getEsproveedor() {
		return this.esproveedor;
	}

	public void setEsproveedor(String esproveedor) {
		this.esproveedor = esproveedor;
	}

	@Column(length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(length = 1)
	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Column(name = "FLAGHABILITADO_RNP", length = 1)
	public String getFlaghabilitadoRnp() {
		return this.flaghabilitadoRnp;
	}

	public void setFlaghabilitadoRnp(String flaghabilitadoRnp) {
		this.flaghabilitadoRnp = flaghabilitadoRnp;
	}

	@Column(length = 1)
	public String getFlagsmf() {
		return this.flagsmf;
	}

	public void setFlagsmf(String flagsmf) {
		this.flagsmf = flagsmf;
	}

	@Temporal(TemporalType.DATE)
	public Date getIngresofecharegistro() {
		return this.ingresofecharegistro;
	}

	public void setIngresofecharegistro(Date ingresofecharegistro) {
		this.ingresofecharegistro = ingresofecharegistro;
	}

	@Column(length = 80)
	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	@Column(length = 50)
	public String getNombreemergencia() {
		return this.nombreemergencia;
	}

	public void setNombreemergencia(String nombreemergencia) {
		this.nombreemergencia = nombreemergencia;
	}

	@Column(length = 30)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(length = 1000)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(length = 150)
	public String getOrganigrama() {
		return this.organigrama;
	}

	public void setOrganigrama(String organigrama) {
		this.organigrama = organigrama;
	}

	@Column(length = 4)
	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Id
	@Column(nullable = false)
	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getPersonaant() {
		return this.personaant;
	}

	public void setPersonaant(Integer personaant) {
		this.personaant = personaant;
	}

	@Column(length = 10)
	public String getPersonaclasificacion() {
		return this.personaclasificacion;
	}

	public void setPersonaclasificacion(String personaclasificacion) {
		this.personaclasificacion = personaclasificacion;
	}

	public Integer getPosicionorganigrama() {
		return this.posicionorganigrama;
	}

	public void setPosicionorganigrama(Integer posicionorganigrama) {
		this.posicionorganigrama = posicionorganigrama;
	}

	@Column(length = 3)
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Column(length = 1)
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(length = 30)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(length = 1)
	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	@Column(length = 1)
	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	@Column(length = 1)
	public String getTipopersonafactura() {
		return this.tipopersonafactura;
	}

	public void setTipopersonafactura(String tipopersonafactura) {
		this.tipopersonafactura = tipopersonafactura;
	}

	@Temporal(TemporalType.DATE)
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	@Column(length = 20)
	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VIGENCIA_RNP")
	public Date getVigenciaRnp() {
		return this.vigenciaRnp;
	}

	public void setVigenciaRnp(Date vigenciaRnp) {
		this.vigenciaRnp = vigenciaRnp;
	}

}