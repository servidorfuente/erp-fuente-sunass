package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_CURSOS database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_CURSOS")
public class SaPersonaCurso extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaPersonaCursoPK id;
	private String archivo;
	private String auspicio;
	private BigDecimal calificacion;
	private String capacitacion;
	private BigDecimal carrera;
	private Long centroestudios;
	private Integer creditosotorgados;
	private String cursodescripcion;
	private String descripcioncurso;
	private Integer dias;
	private String documento;
	private Date fechafin;
	private Date fechainicio;
	private String flagaprobacion;
	private String flagcertificacion;
	private String flagcurso;
	private String grado;
	private Integer horas;
	private String listening;
	private String motivodesaprobacion;
	private String observaciones;
	private String otrocentroestudios;
	private String readingwriting;
	private String speaking;
	private String tipocurso;
	private BigDecimal totalhoras;
	private Date ultimafechamodif;
	private String ultimousuario;
	private BigDecimal vigencia;

	private String estado;
	private Integer curso;
	
	public SaPersonaCurso() {
		id= new SaPersonaCursoPK();
	}


	@EmbeddedId
	public SaPersonaCursoPK getId() {
		return this.id;
	}

	public void setId(SaPersonaCursoPK id) {
		this.id = id;
	}


	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	public String getAuspicio() {
		return this.auspicio;
	}

	public void setAuspicio(String auspicio) {
		this.auspicio = auspicio;
	}


	public BigDecimal getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}


	public String getCapacitacion() {
		return this.capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}


	public BigDecimal getCarrera() {
		return this.carrera;
	}

	public void setCarrera(BigDecimal carrera) {
		this.carrera = carrera;
	}


	public Long getCentroestudios() {
		return this.centroestudios;
	}

	public void setCentroestudios(Long centroestudios) {
		this.centroestudios = centroestudios;
	}


	public Integer getCreditosotorgados() {
		return this.creditosotorgados;
	}

	public void setCreditosotorgados(Integer creditosotorgados) {
		this.creditosotorgados = creditosotorgados;
	}


	public String getCursodescripcion() {
		return this.cursodescripcion;
	}

	public void setCursodescripcion(String cursodescripcion) {
		this.cursodescripcion = cursodescripcion;
	}


	public String getDescripcioncurso() {
		return this.descripcioncurso;
	}

	public void setDescripcioncurso(String descripcioncurso) {
		this.descripcioncurso = descripcioncurso;
	}


	public Integer getDias() {
		return this.dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	
	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}


	
	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getFlagaprobacion() {
		return this.flagaprobacion;
	}

	public void setFlagaprobacion(String flagaprobacion) {
		this.flagaprobacion = flagaprobacion;
	}


	public String getFlagcertificacion() {
		return this.flagcertificacion;
	}

	public void setFlagcertificacion(String flagcertificacion) {
		this.flagcertificacion = flagcertificacion;
	}


	public String getFlagcurso() {
		return this.flagcurso;
	}

	public void setFlagcurso(String flagcurso) {
		this.flagcurso = flagcurso;
	}


	public String getGrado() {
		return this.grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}


	public Integer getHoras() {
		return this.horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}


	public String getListening() {
		return this.listening;
	}

	public void setListening(String listening) {
		this.listening = listening;
	}


	public String getMotivodesaprobacion() {
		return this.motivodesaprobacion;
	}

	public void setMotivodesaprobacion(String motivodesaprobacion) {
		this.motivodesaprobacion = motivodesaprobacion;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getOtrocentroestudios() {
		return this.otrocentroestudios;
	}

	public void setOtrocentroestudios(String otrocentroestudios) {
		this.otrocentroestudios = otrocentroestudios;
	}


	public String getReadingwriting() {
		return this.readingwriting;
	}

	public void setReadingwriting(String readingwriting) {
		this.readingwriting = readingwriting;
	}


	public String getSpeaking() {
		return this.speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}


	public String getTipocurso() {
		return this.tipocurso;
	}

	public void setTipocurso(String tipocurso) {
		this.tipocurso = tipocurso;
	}


	public BigDecimal getTotalhoras() {
		return this.totalhoras;
	}

	public void setTotalhoras(BigDecimal totalhoras) {
		this.totalhoras = totalhoras;
	}


	
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


	public BigDecimal getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(BigDecimal vigencia) {
		this.vigencia = vigencia;
	}
	
	@Column(name = "ESTADO")
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCurso() {
		return this.curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
}