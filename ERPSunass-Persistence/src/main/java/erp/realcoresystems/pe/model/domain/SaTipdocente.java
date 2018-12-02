package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SA_TIPDOCENTE database table.
 * 
 */
@Entity
@Table(name="SA_TIPDOCENTE")
public class SaTipdocente extends Entidad {
	private static final long serialVersionUID = 1L;
	private Long tdotipdocenteid;
	private String tdocodigo;
	private String tdodescripcion;
	private Integer tdoestado;
	private Date tdofechacreacion;
	private String tdoipcreacion;
	private Date tdoultimafechamodif;
	private String tdoultimoip;
	private Long tdoultimousuario;
	private Long tdousuariocreacion;

	public SaTipdocente() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public Long getTdotipdocenteid() {
		return this.tdotipdocenteid;
	}

	public void setTdotipdocenteid(Long tdotipdocenteid) {
		this.tdotipdocenteid = tdotipdocenteid;
	}


	@Column(nullable=false, length=10)
	public String getTdocodigo() {
		return this.tdocodigo;
	}

	public void setTdocodigo(String tdocodigo) {
		this.tdocodigo = tdocodigo;
	}


	@Column(nullable=false, length=100)
	public String getTdodescripcion() {
		return this.tdodescripcion;
	}

	public void setTdodescripcion(String tdodescripcion) {
		this.tdodescripcion = tdodescripcion;
	}


	@Column(nullable=false)
	public Integer getTdoestado() {
		return this.tdoestado;
	}

	public void setTdoestado(Integer tdoestado) {
		this.tdoestado = tdoestado;
	}


	
	public Date getTdofechacreacion() {
		return this.tdofechacreacion;
	}

	public void setTdofechacreacion(Date tdofechacreacion) {
		this.tdofechacreacion = tdofechacreacion;
	}


	@Column(length=20)
	public String getTdoipcreacion() {
		return this.tdoipcreacion;
	}

	public void setTdoipcreacion(String tdoipcreacion) {
		this.tdoipcreacion = tdoipcreacion;
	}


	
	public Date getTdoultimafechamodif() {
		return this.tdoultimafechamodif;
	}

	public void setTdoultimafechamodif(Date tdoultimafechamodif) {
		this.tdoultimafechamodif = tdoultimafechamodif;
	}


	@Column(length=20)
	public String getTdoultimoip() {
		return this.tdoultimoip;
	}

	public void setTdoultimoip(String tdoultimoip) {
		this.tdoultimoip = tdoultimoip;
	}


	public Long getTdoultimousuario() {
		return this.tdoultimousuario;
	}

	public void setTdoultimousuario(Long tdoultimousuario) {
		this.tdoultimousuario = tdoultimousuario;
	}


	public Long getTdousuariocreacion() {
		return this.tdousuariocreacion;
	}

	public void setTdousuariocreacion(Long tdousuariocreacion) {
		this.tdousuariocreacion = tdousuariocreacion;
	}

}