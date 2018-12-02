package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_EVENTO database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_EVENTO")
public class SaPersonaEvento extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaPersonaEventoPK id;
	private String cargolaborAuxiliar;
	private Integer estado;
	private Integer estadoAsistente;
	private Integer estadoConsentCondiciones;
	private String institucionlaborAuxiliar;
	private Integer moemestudioid;
	private String nivelgobiernolaborAuxiliar;
	private String observaciones;
	private Integer perperiodoid;
	
	private String telefonolaborAuxiliar;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;

	private Integer eveeventoid;
	
	private Long hrhhorheaderid;
	
	
	
	public SaPersonaEvento() {
		id = new SaPersonaEventoPK();
	}


	@EmbeddedId
	public SaPersonaEventoPK getId() {
		return this.id;
	}

	public void setId(SaPersonaEventoPK id) {
		this.id = id;
	}


	@Column(name="CARGOLABOR_AUXILIAR")
	public String getCargolaborAuxiliar() {
		return this.cargolaborAuxiliar;
	}

	public void setCargolaborAuxiliar(String cargolaborAuxiliar) {
		this.cargolaborAuxiliar = cargolaborAuxiliar;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	@Column(name="ESTADO_ASISTENTE")
	public Integer getEstadoAsistente() {
		return this.estadoAsistente;
	}

	public void setEstadoAsistente(Integer estadoAsistente) {
		this.estadoAsistente = estadoAsistente;
	}


	@Column(name="ESTADO_CONSENT_CONDICIONES")
	public Integer getEstadoConsentCondiciones() {
		return this.estadoConsentCondiciones;
	}

	public void setEstadoConsentCondiciones(Integer estadoConsentCondiciones) {
		this.estadoConsentCondiciones = estadoConsentCondiciones;
	}


	@Column(name="INSTITUCIONLABOR_AUXILIAR")
	public String getInstitucionlaborAuxiliar() {
		return this.institucionlaborAuxiliar;
	}

	public void setInstitucionlaborAuxiliar(String institucionlaborAuxiliar) {
		this.institucionlaborAuxiliar = institucionlaborAuxiliar;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	@Column(name="NIVELGOBIERNOLABOR_AUXILIAR")
	public String getNivelgobiernolaborAuxiliar() {
		return this.nivelgobiernolaborAuxiliar;
	}

	public void setNivelgobiernolaborAuxiliar(String nivelgobiernolaborAuxiliar) {
		this.nivelgobiernolaborAuxiliar = nivelgobiernolaborAuxiliar;
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


	public Integer getEveeventoid() {
		return this.eveeventoid;
	}
	public void setEveeventoid(Integer eveeventoid) {
		this.eveeventoid = eveeventoid;
	}


	@Column(name="TELEFONOLABOR_AUXILIAR")
	public String getTelefonolaborAuxiliar() {
		return this.telefonolaborAuxiliar;
	}

	public void setTelefonolaborAuxiliar(String telefonolaborAuxiliar) {
		this.telefonolaborAuxiliar = telefonolaborAuxiliar;
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


	@Column(name = "HRHHORHEADERID")
	public Long getHrhhorheaderid() {
		return hrhhorheaderid;
	}


	public void setHrhhorheaderid(Long hrhhorheaderid) {
		this.hrhhorheaderid = hrhhorheaderid;
	}

	
	
	
}