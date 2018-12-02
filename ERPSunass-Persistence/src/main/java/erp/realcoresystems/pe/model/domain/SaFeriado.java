package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_FERIADO")
public class SaFeriado extends Entidad {

	private Integer fdoferiodoid;
	private Integer fdoestado;
	private String fdoflagdiacompleto;
	private Integer fdotabla;
	private Integer fdotablaid;
	private Date fdofecha;
	private Date fdohorainicio;
	private Date fdohorafin;
	private Integer fdousuariocreacion;
	private Date fdofechacreacion;
	private String fdoipcreacion;
	private Integer fdoultimousuario;
	private Date fdoultimafechamodif;
	private String fdoultimoip;

	private String fdodescripcion;
	private String fdotipoferiado;
	private String fdoflagfechaespecifica;

	@Id
	@Column(name = "FDOFERIODOID")
	public Integer getFdoferiodoid() {
		return fdoferiodoid;
	}

	public void setFdoferiodoid(Integer fdoferiodoid) {
		this.fdoferiodoid = fdoferiodoid;
	}

	@Basic
	@Column(name = "FDOESTADO")
	public Integer getFdoestado() {
		return fdoestado;
	}

	public void setFdoestado(Integer fdoestado) {
		this.fdoestado = fdoestado;
	}

	@Basic
	@Column(name = "FDOFLAGDIACOMPLETO")
	public String getFdoflagdiacompleto() {
		return fdoflagdiacompleto;
	}

	public void setFdoflagdiacompleto(String fdoflagdiacompleto) {
		this.fdoflagdiacompleto = fdoflagdiacompleto;
	}

	@Basic
	@Column(name = "FDOTABLA")
	public Integer getFdotabla() {
		return fdotabla;
	}

	public void setFdotabla(Integer fdotabla) {
		this.fdotabla = fdotabla;
	}

	@Basic
	@Column(name = "FDOTABLAID")
	public Integer getFdotablaid() {
		return fdotablaid;
	}

	public void setFdotablaid(Integer fdotablaid) {
		this.fdotablaid = fdotablaid;
	}

	@Basic
	@Column(name = "FDOFECHA")
	public Date getFdofecha() {
		return fdofecha;
	}

	public void setFdofecha(Date fdofecha) {
		this.fdofecha = fdofecha;
	}

	@Basic
	@Column(name = "FDOHORAINICIO")
	public Date getFdohorainicio() {
		return fdohorainicio;
	}

	public void setFdohorainicio(Date fdohorainicio) {
		this.fdohorainicio = fdohorainicio;
	}

	@Basic
	@Column(name = "FDOHORAFIN")
	public Date getFdohorafin() {
		return fdohorafin;
	}

	public void setFdohorafin(Date fdohorafin) {
		this.fdohorafin = fdohorafin;
	}

	@Basic
	@Column(name = "FDOUSUARIOCREACION")
	public Integer getFdousuariocreacion() {
		return fdousuariocreacion;
	}

	public void setFdousuariocreacion(Integer fdousuariocreacion) {
		this.fdousuariocreacion = fdousuariocreacion;
	}

	@Basic
	@Column(name = "FDOFECHACREACION")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFdofechacreacion() {
		return fdofechacreacion;
	}

	public void setFdofechacreacion(Date fdofechacreacion) {
		this.fdofechacreacion = fdofechacreacion;
	}

	@Basic
	@Column(name = "FDOIPCREACION")
	public String getFdoipcreacion() {
		return fdoipcreacion;
	}

	public void setFdoipcreacion(String fdoipcreacion) {
		this.fdoipcreacion = fdoipcreacion;
	}

	@Basic
	@Column(name = "FDOULTIMOUSUARIO")
	public Integer getFdoultimousuario() {
		return fdoultimousuario;
	}

	public void setFdoultimousuario(Integer fdoultimousuario) {
		this.fdoultimousuario = fdoultimousuario;
	}

	@Basic
	@Column(name = "FDOULTIMAFECHAMODIF")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFdoultimafechamodif() {
		return fdoultimafechamodif;
	}

	public void setFdoultimafechamodif(Date fdoultimafechamodif) {
		this.fdoultimafechamodif = fdoultimafechamodif;
	}

	@Basic
	@Column(name = "FDOULTIMOIP")
	public String getFdoultimoip() {
		return fdoultimoip;
	}

	public void setFdoultimoip(String fdoultimoip) {
		this.fdoultimoip = fdoultimoip;
	}

	@Basic
	@Column(name = "FDODESCRIPCION")
	public String getFdodescripcion() {
		return fdodescripcion;
	}

	public void setFdodescripcion(String fdodescripcion) {
		this.fdodescripcion = fdodescripcion;
	}

	@Basic
	@Column(name = "FDOTIPOFERIADO")
	public String getFdotipoferiado() {
		return fdotipoferiado;
	}

	public void setFdotipoferiado(String fdotipoferiado) {
		this.fdotipoferiado = fdotipoferiado;
	}

	@Basic
	@Column(name = "FDOFLAGFECHAESPECIFICA")
	public String getFdoflagfechaespecifica() {
		return fdoflagfechaespecifica;
	}

	public void setFdoflagfechaespecifica(String fdoflagfechaespecifica) {
		this.fdoflagfechaespecifica =fdoflagfechaespecifica;
	}

	
	
}
