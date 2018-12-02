package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VW_SACOMPETENCIASGENERALES")
public class VwSaCompetenciasGenerales extends Entidad {

	private static final long serialVersionUID = 1L;

	private Integer cmacurmaccompid;
	private String cmadescripcion;
	private Integer cmaestado;
	private Date cmafechacreacion;
	private String cmaipcreacion;
	private Integer cmasecuencia;
	private Date cmaultimafechamodif;
	private String cmaultimoip;
	private Integer cmaultimousuario;
	private Integer cmausuariocreacion;
	private Integer curcursoid;
	private Integer moemestudioid;
	private Integer perperiodoid;
	private Integer uneunegocioid;
	private String cmalogros;
	
	
	// nombre de curso
	private String curnombrecorto;
	private String curnombrelargo;

	// descripcion de periodo
	private String perperiodo;

	public VwSaCompetenciasGenerales() {
	}

	@Id
	public Integer getCmacurmaccompid() {
		return this.cmacurmaccompid;
	}

	public void setCmacurmaccompid(Integer cmacurmaccompid) {
		this.cmacurmaccompid = cmacurmaccompid;
	}

	@Basic
	public String getCmadescripcion() {
		return this.cmadescripcion;
	}

	public void setCmadescripcion(String cmadescripcion) {
		this.cmadescripcion = cmadescripcion;
	}

	@Basic
	public Integer getCmaestado() {
		return this.cmaestado;
	}

	public void setCmaestado(Integer cmaestado) {
		this.cmaestado = cmaestado;
	}

	@Basic
	
	public Date getCmafechacreacion() {
		return this.cmafechacreacion;
	}

	public void setCmafechacreacion(Date cmafechacreacion) {
		this.cmafechacreacion = cmafechacreacion;
	}

	@Basic
	public String getCmaipcreacion() {
		return this.cmaipcreacion;
	}

	public void setCmaipcreacion(String cmaipcreacion) {
		this.cmaipcreacion = cmaipcreacion;
	}

	@Basic
	public Integer getCmasecuencia() {
		return this.cmasecuencia;
	}

	public void setCmasecuencia(Integer cmasecuencia) {
		this.cmasecuencia = cmasecuencia;
	}

	@Basic
	
	public Date getCmaultimafechamodif() {
		return this.cmaultimafechamodif;
	}

	public void setCmaultimafechamodif(Date cmaultimafechamodif) {
		this.cmaultimafechamodif = cmaultimafechamodif;
	}

	@Basic
	public String getCmaultimoip() {
		return this.cmaultimoip;
	}

	public void setCmaultimoip(String cmaultimoip) {
		this.cmaultimoip = cmaultimoip;
	}

	@Basic
	public Integer getCmaultimousuario() {
		return this.cmaultimousuario;
	}

	public void setCmaultimousuario(Integer cmaultimousuario) {
		this.cmaultimousuario = cmaultimousuario;
	}

	@Basic
	public Integer getCmausuariocreacion() {
		return this.cmausuariocreacion;
	}

	public void setCmausuariocreacion(Integer cmausuariocreacion) {
		this.cmausuariocreacion = cmausuariocreacion;
	}

	@Basic
	public Integer getCurcursoid() {
		return this.curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	@Basic
	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	@Basic
	public String getPerperiodo() {
		return this.perperiodo;
	}

	public void setPerperiodo(String perperiodo) {
		this.perperiodo = perperiodo;
	}

	@Basic
	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}

	@Basic
	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Basic
	public String getCurnombrecorto() {
		return curnombrecorto;
	}

	public void setCurnombrecorto(String curnombrecorto) {
		this.curnombrecorto = curnombrecorto;
	}

	@Basic
	public String getCurnombrelargo() {
		return curnombrelargo;
	}

	public void setCurnombrelargo(String curnombrelargo) {
		this.curnombrelargo = curnombrelargo;
	}

	public String getCmalogros() {
		return cmalogros;
	}

	public void setCmalogros(String cmalogros) {
		this.cmalogros = cmalogros;
	}

}