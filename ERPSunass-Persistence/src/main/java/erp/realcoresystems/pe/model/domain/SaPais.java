package erp.realcoresystems.pe.model.domain;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SA_PAIS")
public class SaPais  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String paicodigo;
	private Integer concontinenteid;
	private String paidescripcion;
	private Integer paiestado;
	private Date paifechacreacion;
	private String paiipcreacion;
	private Date paiultimafechamodif;
	private String paiultimoip;
	private Integer paiultimousuario;
	private Integer paiusuariocreacion;
	private String paicodigotelefonico;
	private Integer zgozonageograficaid;

	@Id
	@Column(name = "PAICODIGO")
	public String getPaicodigo() {
		return this.paicodigo;
	}

	public void setPaicodigo(String paicodigo) {
		this.paicodigo = paicodigo;
	}

	@Basic
	@Column(name = "CONCONTINENTEID")
	public Integer getConcontinenteid() {
		return this.concontinenteid;
	}

	public void setConcontinenteid(Integer concontinenteid) {
		this.concontinenteid = concontinenteid;
	}

	@Basic
    @Column(name = "PAIDESCRIPCION")
	public String getPaidescripcion() {
		return this.paidescripcion;
	}

	public void setPaidescripcion(String paidescripcion) {
		this.paidescripcion = paidescripcion;
	}

	@Basic
    @Column(name = "PAIESTADO")
	public Integer getPaiestado() {
		return this.paiestado;
	}

	public void setPaiestado(Integer paiestado) {
		this.paiestado = paiestado;
	}

	
	@Basic
	@Column(name = "PAIFECHACREACION")
	public Date getPaifechacreacion() {
		return this.paifechacreacion;
	}

	public void setPaifechacreacion(Date paifechacreacion) {
		this.paifechacreacion = paifechacreacion;
	}

	@Basic
	@Column(name = "PAIIPCREACION")
	public String getPaiipcreacion() {
		return this.paiipcreacion;
	}

	public void setPaiipcreacion(String paiipcreacion) {
		this.paiipcreacion = paiipcreacion;
	}

	@Basic
	
	@Column(name = "PAIULTIMAFECHAMODIF")
	public Date getPaiultimafechamodif() {
		return this.paiultimafechamodif;
	}

	public void setPaiultimafechamodif(Date paiultimafechamodif) {
		this.paiultimafechamodif = paiultimafechamodif;
	}

	@Basic
	@Column(name = "PAIULTIMOIP")
	public String getPaiultimoip() {
		return this.paiultimoip;
	}

	public void setPaiultimoip(String paiultimoip) {
		this.paiultimoip = paiultimoip;
	}

	@Basic
	@Column(name = "PAIULTIMOUSUARIO")
	public Integer getPaiultimousuario() {
		return this.paiultimousuario;
	}

	public void setPaiultimousuario(Integer paiultimousuario) {
		this.paiultimousuario = paiultimousuario;
	}

	@Basic
	@Column(name = "PAIUSUARIOCREACION")
	public Integer getPaiusuariocreacion() {
		return this.paiusuariocreacion;
	}

	public void setPaiusuariocreacion(Integer paiusuariocreacion) {
		this.paiusuariocreacion = paiusuariocreacion;
	}

	@Basic
	@Column(name = "PAICODIGOTELEFONICO")
	public String getPaicodigotelefonico() {
		return this.paicodigotelefonico;
	}

	public void setPaicodigotelefonico(String paicodigotelefonico) {
		this.paicodigotelefonico = paicodigotelefonico;
	}

	@Basic
	@Column(name = "ZGOZONAGEOGRAFICAID")
	public Integer getZgozonageograficaid() {
		return this.zgozonageograficaid;
	}

	public void setZgozonageograficaid(Integer zgozonageograficaid) {
		this.zgozonageograficaid = zgozonageograficaid;
	}

}