package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SP_IDIOMA database table.
 * 
 */
@Entity
@Table(name="SP_IDIOMA")
public class SpIdioma extends Entidad {
	private static final long serialVersionUID = 1L;
	private Long idiidiomaid;
	private String ididescripcion;
	private Integer idiestado;
	private Date idifechacreacion;
	private String idiipcreacion;
	private Date idiultimafechamodif;
	private String idiultimoip;
	private Integer idiultimousuario;
	private Integer idiusuariocreacion;

	public SpIdioma() {
	}


	@Id
	public Long getIdiidiomaid() {
		return this.idiidiomaid;
	}

	public void setIdiidiomaid(Long idiidiomaid) {
		this.idiidiomaid = idiidiomaid;
	}


	public String getIdidescripcion() {
		return this.ididescripcion;
	}

	public void setIdidescripcion(String ididescripcion) {
		this.ididescripcion = ididescripcion;
	}


	public Integer getIdiestado() {
		return this.idiestado;
	}

	public void setIdiestado(Integer idiestado) {
		this.idiestado = idiestado;
	}


	
	public Date getIdifechacreacion() {
		return this.idifechacreacion;
	}

	public void setIdifechacreacion(Date idifechacreacion) {
		this.idifechacreacion = idifechacreacion;
	}


	public String getIdiipcreacion() {
		return this.idiipcreacion;
	}

	public void setIdiipcreacion(String idiipcreacion) {
		this.idiipcreacion = idiipcreacion;
	}


	
	public Date getIdiultimafechamodif() {
		return this.idiultimafechamodif;
	}

	public void setIdiultimafechamodif(Date idiultimafechamodif) {
		this.idiultimafechamodif = idiultimafechamodif;
	}


	public String getIdiultimoip() {
		return this.idiultimoip;
	}

	public void setIdiultimoip(String idiultimoip) {
		this.idiultimoip = idiultimoip;
	}


	public Integer getIdiultimousuario() {
		return this.idiultimousuario;
	}

	public void setIdiultimousuario(Integer idiultimousuario) {
		this.idiultimousuario = idiultimousuario;
	}


	public Integer getIdiusuariocreacion() {
		return this.idiusuariocreacion;
	}

	public void setIdiusuariocreacion(Integer idiusuariocreacion) {
		this.idiusuariocreacion = idiusuariocreacion;
	}

}