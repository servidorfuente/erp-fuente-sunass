package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

import erp.realcoresystems.pe.model.util.Utiles;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_INSTRUCCION database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_INSTRUCCION")
public class SaPersonaInstruccion extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaPersonaInstruccionPK id;
	private String anosexperiencia;
	private String archivo;
	private String archivootro;
	private String area;
	private String auspicio;
	private String capacitacion;
	private Long centroestudios;
	private String colegioprofesional;
	private String colegioprofesionalpadron;
	private String convalidacion;
	private BigDecimal duraciond;
	private BigDecimal duracionh;
	private BigDecimal duracionm;
	private BigDecimal duraciony;
	private Date fechadesde;
	private Date fechahasta;
	private Date fechaobtenciontitulo;
	private String flagnivelmayor;
	private String flagparapracticas;
	private String idioma;
	private String lugar;
	private String nivel;
	private String observaciones;
	private String ordenmeritos;
	private String otracarrera;
	private String otrocentroestudios;
	private String pais;
	private Long profesion;
	private String registrotitulo;
	private String titulo;
	private Date ultimafechamodif;
	private String ultimogrado;
	private String ultimousuario;
	private String universidadconvalida;
	private String year;

	private String estado;
	
	private Long gradoinstruccion;
	
	//private SaCenestudio centroestudiosObj = new SaCenestudio();
	
	private boolean  convalidacionColegBool;
	private boolean  ultimogradoBool;
	private boolean flagparapracticasBool;
	
	
	public SaPersonaInstruccion() {
		id = new SaPersonaInstruccionPK();
	}


	@EmbeddedId
	public SaPersonaInstruccionPK getId() {
		return this.id;
	}

	public void setId(SaPersonaInstruccionPK id) {
		this.id = id;
	}


	public String getAnosexperiencia() {
		return this.anosexperiencia;
	}

	public void setAnosexperiencia(String anosexperiencia) {
		this.anosexperiencia = anosexperiencia;
	}


	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	public String getArchivootro() {
		return this.archivootro;
	}

	public void setArchivootro(String archivootro) {
		this.archivootro = archivootro;
	}


	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getAuspicio() {
		return this.auspicio;
	}

	public void setAuspicio(String auspicio) {
		this.auspicio = auspicio;
	}


	public String getCapacitacion() {
		return this.capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}

	
	public Long getCentroestudios() {	
		return this.centroestudios;
	}

	public void setCentroestudios(Long centroestudios) {
		this.centroestudios = centroestudios;
	}


	public String getColegioprofesional() {
		return this.colegioprofesional;
	}

	public void setColegioprofesional(String colegioprofesional) {
		this.colegioprofesional = colegioprofesional;
	}


	public String getColegioprofesionalpadron() {
		return this.colegioprofesionalpadron;
	}

	public void setColegioprofesionalpadron(String colegioprofesionalpadron) {
		this.colegioprofesionalpadron = colegioprofesionalpadron;
	}


	public String getConvalidacion() {
		return this.convalidacion;
	}

	public void setConvalidacion(String convalidacion) {
		this.convalidacion = convalidacion;
	}


	public BigDecimal getDuraciond() {
		return this.duraciond;
	}

	public void setDuraciond(BigDecimal duraciond) {
		this.duraciond = duraciond;
	}


	public BigDecimal getDuracionh() {
		return this.duracionh;
	}

	public void setDuracionh(BigDecimal duracionh) {
		this.duracionh = duracionh;
	}


	public BigDecimal getDuracionm() {
		return this.duracionm;
	}

	public void setDuracionm(BigDecimal duracionm) {
		this.duracionm = duracionm;
	}


	public BigDecimal getDuraciony() {
		return this.duraciony;
	}

	public void setDuraciony(BigDecimal duraciony) {
		this.duraciony = duraciony;
	}


	
	public Date getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}


	
	public Date getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}


	
	public Date getFechaobtenciontitulo() {
		return this.fechaobtenciontitulo;
	}

	public void setFechaobtenciontitulo(Date fechaobtenciontitulo) {
		this.fechaobtenciontitulo = fechaobtenciontitulo;
	}


	public String getFlagnivelmayor() {
		return this.flagnivelmayor;
	}

	public void setFlagnivelmayor(String flagnivelmayor) {
		this.flagnivelmayor = flagnivelmayor;
	}


	public String getFlagparapracticas() {
		return this.flagparapracticas;
	}

	public void setFlagparapracticas(String flagparapracticas) {
		this.flagparapracticas = flagparapracticas;
	}


	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getOrdenmeritos() {
		return this.ordenmeritos;
	}

	public void setOrdenmeritos(String ordenmeritos) {
		this.ordenmeritos = ordenmeritos;
	}


	public String getOtracarrera() {
		return this.otracarrera;
	}

	public void setOtracarrera(String otracarrera) {
		this.otracarrera = otracarrera;
	}


	public String getOtrocentroestudios() {
		return this.otrocentroestudios;
	}

	public void setOtrocentroestudios(String otrocentroestudios) {
		this.otrocentroestudios = otrocentroestudios;
	}


	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	public Long getProfesion() {
		return this.profesion;
	}

	public void setProfesion(Long profesion) {
		this.profesion = profesion;
	}


	public String getRegistrotitulo() {
		return this.registrotitulo;
	}

	public void setRegistrotitulo(String registrotitulo) {
		this.registrotitulo = registrotitulo;
	}


	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


	public String getUltimogrado() {
		return this.ultimogrado;
	}

	public void setUltimogrado(String ultimogrado) {
		this.ultimogrado = ultimogrado;
	}


	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}


	public String getUniversidadconvalida() {
		return this.universidadconvalida;
	}

	public void setUniversidadconvalida(String universidadconvalida) {
		this.universidadconvalida = universidadconvalida;
	}


	@Column(name="\"YEAR\"")
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	@Column(name="ESTADO")	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	@Transient
	public boolean isUltimogradoBool() {
		if(Utiles.SI_db.equals(ultimogrado)){
			ultimogradoBool=true;
		}else{
			ultimogradoBool=false;
		}		
		return ultimogradoBool;				
	}


	public void setUltimogradoBool(boolean ultimogradoBool) {
		if(ultimogradoBool){
			setUltimogrado(Utiles.SI_db); 
		}else{
			setUltimogrado(Utiles.NO_db);
		}
		this.ultimogradoBool = ultimogradoBool;
	}

	@Transient
	public boolean isFlagparapracticasBool() {
		if(Utiles.SI_db.equals(flagparapracticas)){
			flagparapracticasBool=true;
		}else{
			flagparapracticasBool=false;
		}		
		return flagparapracticasBool;					
	}


	public void setFlagparapracticasBool(boolean flagparapracticasBool) {
		if(flagparapracticasBool){
			setFlagparapracticas(Utiles.SI_db); 
		}else{
			setFlagparapracticas(Utiles.NO_db);
		}			
		this.flagparapracticasBool = flagparapracticasBool;
	}

	@Transient
	public boolean isConvalidacionColegBool() {
		if(Utiles.SI_db.equals(convalidacion)){
			convalidacionColegBool=true;
		}else{
			convalidacionColegBool=false;
		}					
		return convalidacionColegBool;
	}


	public void setConvalidacionColegBool(boolean convalidacionColegBool) {
		if(convalidacionColegBool){
			setConvalidacion(Utiles.SI_db); 
		}else{
			setConvalidacion(Utiles.NO_db);
		}				
		this.convalidacionColegBool = convalidacionColegBool;
	}
	public Long getGradoinstruccion() {
		return this.gradoinstruccion;
	}
	public void setGradoinstruccion(Long gradoinstruccion) {
		this.gradoinstruccion = gradoinstruccion;
	}
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="CENTROESTUDIOS", insertable=false, updatable=false)
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CENTROESTUDIOS", insertable=false, updatable=false)	
	public SaCenestudio getCentroestudiosObj() {
		if(centroestudiosObj==null){
			centroestudiosObj = new SaCenestudio();
		}
		return centroestudiosObj;
	}


	public void setCentroestudiosObj(SaCenestudio centroestudiosObj) {
		this.centroestudiosObj = centroestudiosObj;
	}*/
	
	
	
}