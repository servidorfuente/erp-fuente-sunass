package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.util.Date;


/**
 * The persistent class for the VW_PERSONA_EVENTO database table.
 * 
 */
@Entity
@Table(name="VW_PERSONA_EVENTO")
public class VwPersonaEvento extends Entidad {
	private static final long serialVersionUID = 1L;
	private String apellidomaterno;
	private String apellidopaterno;
	private String cargoDesc;
	private String cargoid;
	private String celularemergencia;
	private String codigopostal;
	private String correoelectronico;
	private String correoinstitucional;
	private String departamento;
	private String direccion;
	private String direccionreferencia;
	private String distritolabor;
	private String documento;
	private String dptolabor;
	private Integer estadoAsistente;
	private String estadoAsistenteDesc;
	private String estadoConsentCondDesc;
	private Integer estadoConsentCondiciones;
	private String estadopersona;
	private String evedescripcion;
	private Integer eveestado;
	private Integer eveestadoproceso;
	private String eveestadoprocesoDesc;
	private Integer eveeventoid;
	private Date evefechafin;
	private Date evefechainicio;
	private String evetipo;
	private Date fechanacimiento;
	private String institucionDesc;
	private String institucionid;
	private Integer moemestudioid;
	private String nacionalidad;
	private String nivelgobierno;
	private String nivelgobiernoDesc;
	private String nivelinstruccion;
	private String nombrecompleto;
	private String nombres;
	private String observaciones;
	private Integer perperiodoid;
	private Integer persona;
	private String personaant;
	private Integer personaeveEstado;
	private Integer personaeventoid;
	private String provincia;
	private String provincialabor;
	private String sexo;
	private String telefono;
	private Integer tipodocumento;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;

	private Long idcontador;
	
	private Long hrhhorheaderid;
	
	private String telefonoLabor;
	
	
	public VwPersonaEvento() {
	}


	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}


	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}


	@Column(name="CARGO_DESC")
	public String getCargoDesc() {
		return this.cargoDesc;
	}

	public void setCargoDesc(String cargoDesc) {
		this.cargoDesc = cargoDesc;
	}


	public String getCargoid() {
		return this.cargoid;
	}

	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}


	public String getCelularemergencia() {
		return this.celularemergencia;
	}

	public void setCelularemergencia(String celularemergencia) {
		this.celularemergencia = celularemergencia;
	}


	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}


	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}


	public String getCorreoinstitucional() {
		return this.correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}


	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDireccionreferencia() {
		return this.direccionreferencia;
	}

	public void setDireccionreferencia(String direccionreferencia) {
		this.direccionreferencia = direccionreferencia;
	}


	public String getDistritolabor() {
		return this.distritolabor;
	}

	public void setDistritolabor(String distritolabor) {
		this.distritolabor = distritolabor;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getDptolabor() {
		return this.dptolabor;
	}

	public void setDptolabor(String dptolabor) {
		this.dptolabor = dptolabor;
	}


	@Column(name="ESTADO_ASISTENTE")
	public Integer getEstadoAsistente() {
		return this.estadoAsistente;
	}

	public void setEstadoAsistente(Integer estadoAsistente) {
		this.estadoAsistente = estadoAsistente;
	}


	@Column(name="ESTADO_ASISTENTE_DESC")
	public String getEstadoAsistenteDesc() {
		return this.estadoAsistenteDesc;
	}

	public void setEstadoAsistenteDesc(String estadoAsistenteDesc) {
		this.estadoAsistenteDesc = estadoAsistenteDesc;
	}


	@Column(name="ESTADO_CONSENT_COND_DESC")
	public String getEstadoConsentCondDesc() {
		return this.estadoConsentCondDesc;
	}

	public void setEstadoConsentCondDesc(String estadoConsentCondDesc) {
		this.estadoConsentCondDesc = estadoConsentCondDesc;
	}


	@Column(name="ESTADO_CONSENT_CONDICIONES")
	public Integer getEstadoConsentCondiciones() {
		return this.estadoConsentCondiciones;
	}

	public void setEstadoConsentCondiciones(Integer estadoConsentCondiciones) {
		this.estadoConsentCondiciones = estadoConsentCondiciones;
	}


	public String getEstadopersona() {
		return this.estadopersona;
	}

	public void setEstadopersona(String estadopersona) {
		this.estadopersona = estadopersona;
	}


	public String getEvedescripcion() {
		return this.evedescripcion;
	}

	public void setEvedescripcion(String evedescripcion) {
		this.evedescripcion = evedescripcion;
	}


	public Integer getEveestado() {
		return this.eveestado;
	}

	public void setEveestado(Integer eveestado) {
		this.eveestado = eveestado;
	}


	public Integer getEveestadoproceso() {
		return this.eveestadoproceso;
	}

	public void setEveestadoproceso(Integer eveestadoproceso) {
		this.eveestadoproceso = eveestadoproceso;
	}


	@Column(name="EVEESTADOPROCESO_DESC")
	public String getEveestadoprocesoDesc() {
		return this.eveestadoprocesoDesc;
	}

	public void setEveestadoprocesoDesc(String eveestadoprocesoDesc) {
		this.eveestadoprocesoDesc = eveestadoprocesoDesc;
	}


	public Integer getEveeventoid() {
		return this.eveeventoid;
	}

	public void setEveeventoid(Integer eveeventoid) {
		this.eveeventoid = eveeventoid;
	}


	@Temporal(TemporalType.DATE)
	public Date getEvefechafin() {
		return this.evefechafin;
	}

	public void setEvefechafin(Date evefechafin) {
		this.evefechafin = evefechafin;
	}


	@Temporal(TemporalType.DATE)
	public Date getEvefechainicio() {
		return this.evefechainicio;
	}

	public void setEvefechainicio(Date evefechainicio) {
		this.evefechainicio = evefechainicio;
	}


	public String getEvetipo() {
		return this.evetipo;
	}

	public void setEvetipo(String evetipo) {
		this.evetipo = evetipo;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	@Column(name="INSTITUCION_DESC")
	public String getInstitucionDesc() {
		return this.institucionDesc;
	}

	public void setInstitucionDesc(String institucionDesc) {
		this.institucionDesc = institucionDesc;
	}


	public String getInstitucionid() {
		return this.institucionid;
	}

	public void setInstitucionid(String institucionid) {
		this.institucionid = institucionid;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getNivelgobierno() {
		return this.nivelgobierno;
	}

	public void setNivelgobierno(String nivelgobierno) {
		this.nivelgobierno = nivelgobierno;
	}


	@Column(name="NIVELGOBIERNO_DESC")
	public String getNivelgobiernoDesc() {
		return this.nivelgobiernoDesc;
	}

	public void setNivelgobiernoDesc(String nivelgobiernoDesc) {
		this.nivelgobiernoDesc = nivelgobiernoDesc;
	}


	public String getNivelinstruccion() {
		return this.nivelinstruccion;
	}

	public void setNivelinstruccion(String nivelinstruccion) {
		this.nivelinstruccion = nivelinstruccion;
	}


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}


	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}


	public String getPersonaant() {
		return this.personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}


	@Column(name="PERSONAEVE_ESTADO")
	public Integer getPersonaeveEstado() {
		return this.personaeveEstado;
	}

	public void setPersonaeveEstado(Integer personaeveEstado) {
		this.personaeveEstado = personaeveEstado;
	}


	public Integer getPersonaeventoid() {
		return this.personaeventoid;
	}

	public void setPersonaeventoid(Integer personaeventoid) {
		this.personaeventoid = personaeventoid;
	}


	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getProvincialabor() {
		return this.provincialabor;
	}

	public void setProvincialabor(String provincialabor) {
		this.provincialabor = provincialabor;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Integer getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Integer tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	@Temporal(TemporalType.DATE)
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


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

	@Id
	@Column(name = "IDCONTADOR")
	public Long getIdcontador() {
		return idcontador;
	}


	public void setIdcontador(Long idoontador) {
		this.idcontador = idoontador;
	}

	

	@Column(name = "HRHHORHEADERID")
	public Long getHrhhorheaderid() {
		return hrhhorheaderid;
	}


	public void setHrhhorheaderid(Long hrhhorheaderid) {
		this.hrhhorheaderid = hrhhorheaderid;
	}

	@Column(name = "TELEFONO_LABOR")
	public String getTelefonoLabor() {
		return telefonoLabor;
	}

	
	public void setTelefonoLabor(String telefonoLabor) {
		this.telefonoLabor = telefonoLabor;
	}
	
	
}