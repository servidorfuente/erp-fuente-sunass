package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SA_PROFESION database table.
 * 
 */
@Entity
@Table(name = "SA_PROFESION")
public class SaProfesion extends Entidad {
	private static final long serialVersionUID = 1L;
	private Long profesion;
	private String area;
	private String descripcion;
	private String estado;
	private Date ultimafechamodif;
	private String ultimousuario;
	private String unidadreplicacion;

	public SaProfesion() {
	}

	@Id
	public Long getProfesion() {
		return this.profesion;
	}

	public void setProfesion(Long profesion) {
		this.profesion = profesion;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	public String getUnidadreplicacion() {
		return this.unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

}