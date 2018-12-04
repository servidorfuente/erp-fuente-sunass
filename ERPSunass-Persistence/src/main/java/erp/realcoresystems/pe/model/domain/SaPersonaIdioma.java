package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_IDIOMA database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_IDIOMA")
public class SaPersonaIdioma extends Entidad{
	private static final long serialVersionUID = 1L;
	private SaPersonaIdiomaPK id;
	private String capacitacion;
	private Long centroestudios;
	private Date fechatermino;
	private String nivelescritura;
	private String nivelgeneral;
	private String nivellectura;
	private String niveloral;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;
	
	private Integer idiidiomaid;
	
	private String estado;
	

	public SaPersonaIdioma() {
		id = new SaPersonaIdiomaPK();
	}


	@EmbeddedId
	public SaPersonaIdiomaPK getId() {
		return this.id;
	}

	public void setId(SaPersonaIdiomaPK id) {
		this.id = id;
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


	
	public Date getFechatermino() {
		return this.fechatermino;
	}

	public void setFechatermino(Date fechatermino) {
		this.fechatermino = fechatermino;
	}


	public String getNivelescritura() {
		return this.nivelescritura;
	}

	public void setNivelescritura(String nivelescritura) {
		this.nivelescritura = nivelescritura;
	}


	public String getNivelgeneral() {
		return this.nivelgeneral;
	}

	public void setNivelgeneral(String nivelgeneral) {
		this.nivelgeneral = nivelgeneral;
	}


	public String getNivellectura() {
		return this.nivellectura;
	}

	public void setNivellectura(String nivellectura) {
		this.nivellectura = nivellectura;
	}


	public String getNiveloral() {
		return this.niveloral;
	}

	public void setNiveloral(String niveloral) {
		this.niveloral = niveloral;
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


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Column(name = "ESTADO")	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdiidiomaid() {
		return this.idiidiomaid;
	}
	public void setIdiidiomaid(Integer idiidiomaid) {
		this.idiidiomaid = idiidiomaid;
	}
	
}