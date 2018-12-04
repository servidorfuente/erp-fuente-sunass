package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;
import java.util.Date;


/**
 * The persistent class for the VW_MONITORIOREGISTRO database table.
 * 
 */
@Entity
@Table(name="VW_MONITORIOREGISTRO")
public class VwMonitorioregistro extends Entidad {
	private static final long serialVersionUID = 1L;
	
	private Integer monitorioid;
	
	private Integer alertaEstado;
	private String clasificacion;
	private Integer clocurriculoid;
	private String comentarios;
	private Integer crrcarreraid;
	private String crrdescripcion;
	private Integer curcursoid;
	private String curnombrecorto;
	private String curnombrelargo;
	private Integer cursesionid;
	private String descripcion;
	private Integer estadomonitorio;
	private Date fechaMonitoreo;
	private Integer idalerta;
	private Integer moemestudioid;
	private Integer moneciclo;
	private Integer monitorEstado;
	private String monitorEstadoDesc;
	private String nivelDesc;
	private String nivelFlagCorreo;
	private String nivelPlantCorreo;
	private String nivelalerta;
	private String observaciones;
	private String perdescripcion;
	private String perperiodo;
	private Integer perperiodoid;
	private String seccodigo;
	private Integer secseccionid;
	private String sesionDesc;
	private String tipoalerta;
	private String tipoalertaDesc;
	private String tipoincidencia;
	private Integer uneunegocioid;

	private Integer crrflagmodular;
	
	private String tipoincidenciaDesc;
	private String clasificacionDesc;
	
	private Integer docenteprincipal;
	private Integer personaRegistro;
	private Integer personaAtencion;
	private Integer hrhhorheaderid;
	
	private String flagMonitoratencion;
	
	private String docenteprincipalNombre;
	private String personaRegistroNombre;
	private String personaAtencionNombre;
	
	private String actComplemDesc;

	
	public VwMonitorioregistro() {
	}


	@Column(name="ALERTA_ESTADO")
	public Integer getAlertaEstado() {
		return this.alertaEstado;
	}

	public void setAlertaEstado(Integer alertaEstado) {
		this.alertaEstado = alertaEstado;
	}


	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}


	public Integer getClocurriculoid() {
		return this.clocurriculoid;
	}

	public void setClocurriculoid(Integer clocurriculoid) {
		this.clocurriculoid = clocurriculoid;
	}


	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public Integer getCrrcarreraid() {
		return this.crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}


	public String getCrrdescripcion() {
		return this.crrdescripcion;
	}

	public void setCrrdescripcion(String crrdescripcion) {
		this.crrdescripcion = crrdescripcion;
	}


	public Integer getCurcursoid() {
		return this.curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}


	public String getCurnombrecorto() {
		return this.curnombrecorto;
	}

	public void setCurnombrecorto(String curnombrecorto) {
		this.curnombrecorto = curnombrecorto;
	}


	public String getCurnombrelargo() {
		return this.curnombrelargo;
	}

	public void setCurnombrelargo(String curnombrelargo) {
		this.curnombrelargo = curnombrelargo;
	}


	public Integer getCursesionid() {
		return this.cursesionid;
	}

	public void setCursesionid(Integer cursesionid) {
		this.cursesionid = cursesionid;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstadomonitorio() {
		return this.estadomonitorio;
	}

	public void setEstadomonitorio(Integer estadomonitorio) {
		this.estadomonitorio = estadomonitorio;
	}

	
	@Column(name="FECHA_MONITOREO")
	public Date getFechaMonitoreo() {
		return this.fechaMonitoreo;
	}

	public void setFechaMonitoreo(Date fechaMonitoreo) {
		this.fechaMonitoreo = fechaMonitoreo;
	}


	public Integer getIdalerta() {
		return this.idalerta;
	}

	public void setIdalerta(Integer idalerta) {
		this.idalerta = idalerta;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public Integer getMoneciclo() {
		return this.moneciclo;
	}

	public void setMoneciclo(Integer moneciclo) {
		this.moneciclo = moneciclo;
	}


	@Column(name="MONITOR_ESTADO")
	public Integer getMonitorEstado() {
		return this.monitorEstado;
	}

	public void setMonitorEstado(Integer monitorEstado) {
		this.monitorEstado = monitorEstado;
	}


	@Column(name="MONITOR_ESTADO_DESC")
	public String getMonitorEstadoDesc() {
		return this.monitorEstadoDesc;
	}

	public void setMonitorEstadoDesc(String monitorEstadoDesc) {
		this.monitorEstadoDesc = monitorEstadoDesc;
	}


	@Column(name="NIVEL_DESC")
	public String getNivelDesc() {
		return this.nivelDesc;
	}

	public void setNivelDesc(String nivelDesc) {
		this.nivelDesc = nivelDesc;
	}


	@Column(name="NIVEL_FLAG_CORREO")
	public String getNivelFlagCorreo() {
		return this.nivelFlagCorreo;
	}

	public void setNivelFlagCorreo(String nivelFlagCorreo) {
		this.nivelFlagCorreo = nivelFlagCorreo;
	}


	@Column(name="NIVEL_PLANT_CORREO")
	public String getNivelPlantCorreo() {
		return this.nivelPlantCorreo;
	}

	public void setNivelPlantCorreo(String nivelPlantCorreo) {
		this.nivelPlantCorreo = nivelPlantCorreo;
	}


	public String getNivelalerta() {
		return this.nivelalerta;
	}

	public void setNivelalerta(String nivelalerta) {
		this.nivelalerta = nivelalerta;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getPerdescripcion() {
		return this.perdescripcion;
	}

	public void setPerdescripcion(String perdescripcion) {
		this.perdescripcion = perdescripcion;
	}


	public String getPerperiodo() {
		return this.perperiodo;
	}

	public void setPerperiodo(String perperiodo) {
		this.perperiodo = perperiodo;
	}


	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}


	public String getSeccodigo() {
		return this.seccodigo;
	}

	public void setSeccodigo(String seccodigo) {
		this.seccodigo = seccodigo;
	}


	public Integer getSecseccionid() {
		return this.secseccionid;
	}

	public void setSecseccionid(Integer secseccionid) {
		this.secseccionid = secseccionid;
	}


	@Column(name="SESION_DESC")
	public String getSesionDesc() {
		return this.sesionDesc;
	}

	public void setSesionDesc(String sesionDesc) {
		this.sesionDesc = sesionDesc;
	}


	public String getTipoalerta() {
		return this.tipoalerta;
	}

	public void setTipoalerta(String tipoalerta) {
		this.tipoalerta = tipoalerta;
	}


	@Column(name="TIPOALERTA_DESC")
	public String getTipoalertaDesc() {
		return this.tipoalertaDesc;
	}

	public void setTipoalertaDesc(String tipoalertaDesc) {
		this.tipoalertaDesc = tipoalertaDesc;
	}


	public String getTipoincidencia() {
		return this.tipoincidencia;
	}

	public void setTipoincidencia(String tipoincidencia) {
		this.tipoincidencia = tipoincidencia;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Id
	@Column(name="MONITORIOID")
	public Integer getMonitorioid() {
		return monitorioid;
	}


	public void setMonitorioid(Integer monitorioid) {
		this.monitorioid = monitorioid;
	}
	
	@Column(name="CRRFLAGMODULAR")
	public Integer getCrrflagmodular() {
		return crrflagmodular;
	}

	public void setCrrflagmodular(Integer crrflagmodular) {
		this.crrflagmodular = crrflagmodular;
	}

	@Column(name="TIPOINCIDENCIA_DESC")
	public String getTipoincidenciaDesc() {
		return tipoincidenciaDesc;
	}


	public void setTipoincidenciaDesc(String tipoincidenciaDesc) {
		this.tipoincidenciaDesc = tipoincidenciaDesc;
	}

	@Column(name="CLASIFICACION_DESC")
	public String getClasificacionDesc() {
		return clasificacionDesc;
	}
	
	
	public void setClasificacionDesc(String clasificacionDesc) {
		this.clasificacionDesc = clasificacionDesc;
	}
	


	@Column(name = "DOCENTEPRINCIPAL")
	public Integer getDocenteprincipal() {
		return docenteprincipal;
	}


	public void setDocenteprincipal(Integer docenteprincipal) {
		this.docenteprincipal = docenteprincipal;
	}


	@Column(name = "PERSONA_REGISTRO")
	public Integer getPersonaRegistro() {
		return personaRegistro;
	}


	public void setPersonaRegistro(Integer personaRegistro) {
		this.personaRegistro = personaRegistro;
	}

	@Column(name = "PERSONA_ATENCION")
	public Integer getPersonaAtencion() {
		return personaAtencion;
	}


	public void setPersonaAtencion(Integer personaAtencion) {
		this.personaAtencion = personaAtencion;
	}	

	@Column(name = "HRHHORHEADERID")
	public Integer getHrhhorheaderid() {
		return hrhhorheaderid;
	}


	public void setHrhhorheaderid(Integer hrhhorheaderid) {
		this.hrhhorheaderid = hrhhorheaderid;
	}
	
	@Column(name = "FLAG_MONITORATENCION")
	public String getFlagMonitoratencion() {
		return flagMonitoratencion;
	}


	public void setFlagMonitoratencion(String flagMonitoratencion) {
		this.flagMonitoratencion = flagMonitoratencion;
	}

	@Column(name = "DOCENTEPRINCIPAL_NOMBRE")
	public String getDocenteprincipalNombre() {
		return docenteprincipalNombre;
	}


	public void setDocenteprincipalNombre(String docenteprincipalNombre) {
		this.docenteprincipalNombre = docenteprincipalNombre;
	}

	@Column(name = "PERSONA_REGISTRO_NOMBRE")
	public String getPersonaRegistroNombre() {
		return personaRegistroNombre;
	}


	public void setPersonaRegistroNombre(String personaRegistroNombre) {
		this.personaRegistroNombre = personaRegistroNombre;
	}

	@Column(name = "PERSONA_ATENCION_NOMBRE")
	public String getPersonaAtencionNombre() {
		return personaAtencionNombre;
	}


	public void setPersonaAtencionNombre(String personaAtencionNombre) {
		this.personaAtencionNombre = personaAtencionNombre;
	}

	@Column(name = "ACT_COMPLEM_DESC")
	public String getActComplemDesc() {
		return actComplemDesc;
	}


	public void setActComplemDesc(String actComplemDesc) {
		this.actComplemDesc = actComplemDesc;
	}
	
}