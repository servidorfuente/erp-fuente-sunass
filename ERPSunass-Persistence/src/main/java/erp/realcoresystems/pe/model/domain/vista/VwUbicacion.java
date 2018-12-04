package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import erp.realcoresystems.pe.model.domain.Entidad;

@Entity
@Table(name = "VW_UBICACION")
public class VwUbicacion extends Entidad {

	private static final long serialVersionUID = 1L;

	// UBICACION
	private Integer ubicacionid;
	private Integer uneunegocioid;
	private Integer seccionid;
	private Integer tipoalmacenid;
	private Integer capacidadid;
	private String ubidescripcion;
	private Integer ubiestado;

	// TIPO ALMACEN
	private String tipalmdescripcion;
	private Integer tipalmestado;

	// CAPACIDAD
	private String capdescripcion;
	private Integer totalfila;
	private Integer totalcolumna;
	private Integer totalcelda;
	private Integer capestado;

	// SECCION
	private String secdescripcion;
	private Integer secestado;

	// AUDITORIA UBICACION
	private Integer usuariocreacion;
	private Date fechacreacion;
	private String ipcreacion;
	private Integer ultimousuario;
	private Date ultimafechamodif;
	private String ultimoip;

	public VwUbicacion() {

	}

	/*** GET - SET ***/

	// UBICACION
	@Id
	@Column(name = "UBICACIONID")
	public Integer getUbicacionid() {
		return ubicacionid;
	}

	public void setUbicacionid(Integer ubicacionid) {
		this.ubicacionid = ubicacionid;
	}

	@Column(name = "UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Column(name = "SECCIONID")
	public Integer getSeccionid() {
		return seccionid;
	}

	public void setSeccionid(Integer seccionid) {
		this.seccionid = seccionid;
	}
	
	@Column(name = "TIPOALMACENID")
	public Integer getTipoalmacenid() {
		return tipoalmacenid;
	}

	public void setTipoalmacenid(Integer tipoalmacenid) {
		this.tipoalmacenid = tipoalmacenid;
	}

	@Column(name = "CAPACIDADID")
	public Integer getCapacidadid() {
		return capacidadid;
	}

	public void setCapacidadid(Integer capacidadid) {
		this.capacidadid = capacidadid;
	}

	@Column(name = "UBIDESCRIPCION")
	public String getUbidescripcion() {
		return ubidescripcion;
	}

	public void setUbidescripcion(String ubidescripcion) {
		this.ubidescripcion = ubidescripcion;
	}

	@Column(name = "UBIESTADO")
	public Integer getUbiestado() {
		return ubiestado;
	}

	public void setUbiestado(Integer ubiestado) {
		this.ubiestado = ubiestado;
	}

	// TIPO ALMACEN

	@Basic
	@Column(name = "TIPALMDESCRIPCION")
	public String getTipalmdescripcion() {
		return tipalmdescripcion;
	}

	public void setTipalmdescripcion(String tipalmdescripcion) {
		this.tipalmdescripcion = tipalmdescripcion;
	}

	@Basic
	@Column(name = "TIPALMESTADO")
	public Integer getTipalmestado() {
		return tipalmestado;
	}

	public void setTipalmestado(Integer tipalmestado) {
		this.tipalmestado = tipalmestado;
	}

	// CAPACIDAD

	@Basic
	@Column(name = "CAPDESCRIPCION")
	public String getCapdescripcion() {
		return capdescripcion;
	}

	public void setCapdescripcion(String capdescripcion) {
		this.capdescripcion = capdescripcion;
	}

	@Column(name = "TOTALFILA")
	public Integer getTotalfila() {
		return totalfila;
	}

	public void setTotalfila(Integer totalfila) {
		this.totalfila = totalfila;
	}

	@Column(name = "TOTALCOLUMNA")
	public Integer getTotalcolumna() {
		return totalcolumna;
	}

	public void setTotalcolumna(Integer totalcolumna) {
		this.totalcolumna = totalcolumna;
	}

	@Column(name = "TOTALCELDA")
	public Integer getTotalcelda() {
		return totalcelda;
	}

	public void setTotalcelda(Integer totalcelda) {
		this.totalcelda = totalcelda;
	}

	@Basic
	@Column(name = "CAPESTADO")
	public Integer getCapestado() {
		return capestado;
	}

	public void setCapestado(Integer capestado) {
		this.capestado = capestado;
	}

	// SECCION

	@Column(name = "SECDESCRIPCION")
	public String getSecdescripcion() {
		return secdescripcion;
	}

	public void setSecdescripcion(String secdescripcion) {
		this.secdescripcion = secdescripcion;
	}

	@Column(name = "SECESTADO")
	public Integer getSecestado() {
		return secestado;
	}

	public void setSecestado(Integer secestado) {
		this.secestado = secestado;
	}

	// AUDITORIA UBICACION
	@Column(name = "USUARIOCREACION")
	public Integer getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(Integer usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	@Column(name = "FECHACREACION")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	@Column(name = "IPCREACION")
	public String getIpcreacion() {
		return ipcreacion;
	}

	public void setIpcreacion(String ipcreacion) {
		this.ipcreacion = ipcreacion;
	}

	@Column(name = "ULTIMOUSUARIO")
	public Integer getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(Integer ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	@Column(name = "ULTIMAFECHAMODIF")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	@Column(name = "ULTIMOIP")
	public String getUltimoip() {
		return ultimoip;
	}

	public void setUltimoip(String ultimoip) {
		this.ultimoip = ultimoip;
	}

}
