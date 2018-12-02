package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import erp.realcoresystems.pe.commons.UtilesCommons;

import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_RELACIONES database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_RELACIONES")
public class SaPersonaRelaciones extends Entidad{
	private static final long serialVersionUID = 1L;
	private Long prelsecuencia;
	private String prelcomentarios;
	private String prelestado;
	private Date prelfechacreacion;
	private Date prelfechafinRelacion;
	private Date prelfechainicioRelacion;
	private String prelflagDuracionDefinida;
	private String prelipcreacion;
	private Integer prelpersonaRelacionDe;
	private Integer prelpersonaRelacionSecund;
	private String preltipoRelacionDe;
	private Date prelultimafechamodif;
	private String prelultimoip;
	private String prelultimousuario;
	private String prelusuariocreacion;
	
	private Personamast personaMastRelacionSecund;
	
	private Personamast personaMastRelacionDe;
	
	private boolean prelflagDuracionDefinidaBool;

	public SaPersonaRelaciones() {
	}


	@Id
	public Long getPrelsecuencia() {
		return this.prelsecuencia;
	}

	public void setPrelsecuencia(Long prelsecuencia) {
		this.prelsecuencia = prelsecuencia;
	}


	public String getPrelcomentarios() {
		return this.prelcomentarios;
	}

	public void setPrelcomentarios(String prelcomentarios) {
		this.prelcomentarios = prelcomentarios;
	}


	public String getPrelestado() {
		return this.prelestado;
	}

	public void setPrelestado(String prelestado) {
		this.prelestado = prelestado;
	}


	@Temporal(TemporalType.DATE)
	public Date getPrelfechacreacion() {
		return this.prelfechacreacion;
	}

	public void setPrelfechacreacion(Date prelfechacreacion) {
		this.prelfechacreacion = prelfechacreacion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PRELFECHAFIN_RELACION")
	public Date getPrelfechafinRelacion() {
		return this.prelfechafinRelacion;
	}

	public void setPrelfechafinRelacion(Date prelfechafinRelacion) {
		this.prelfechafinRelacion = prelfechafinRelacion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PRELFECHAINICIO_RELACION")
	public Date getPrelfechainicioRelacion() {
		return this.prelfechainicioRelacion;
	}

	public void setPrelfechainicioRelacion(Date prelfechainicioRelacion) {
		this.prelfechainicioRelacion = prelfechainicioRelacion;
	}


	@Column(name="PRELFLAG_DURACION_DEFINIDA")
	public String getPrelflagDuracionDefinida() {
		return this.prelflagDuracionDefinida;
	}

	public void setPrelflagDuracionDefinida(String prelflagDuracionDefinida) {
		this.prelflagDuracionDefinida = prelflagDuracionDefinida;
	}


	public String getPrelipcreacion() {
		return this.prelipcreacion;
	}

	public void setPrelipcreacion(String prelipcreacion) {
		this.prelipcreacion = prelipcreacion;
	}


	@Column(name="PRELPERSONA_RELACION_DE")
	public Integer getPrelpersonaRelacionDe() {
		return this.prelpersonaRelacionDe;
	}

	public void setPrelpersonaRelacionDe(Integer prelpersonaRelacionDe) {
		this.prelpersonaRelacionDe = prelpersonaRelacionDe;
	}


	@Column(name="PRELPERSONA_RELACION_SECUND")
	public Integer getPrelpersonaRelacionSecund() {
		return this.prelpersonaRelacionSecund;
	}

	public void setPrelpersonaRelacionSecund(Integer prelpersonaRelacionSecund) {
		this.prelpersonaRelacionSecund = prelpersonaRelacionSecund;
	}


	@Column(name="PRELTIPO_RELACION_DE")
	public String getPreltipoRelacionDe() {
		return this.preltipoRelacionDe;
	}

	public void setPreltipoRelacionDe(String preltipoRelacionDe) {
		this.preltipoRelacionDe = preltipoRelacionDe;
	}


	@Temporal(TemporalType.DATE)
	public Date getPrelultimafechamodif() {
		return this.prelultimafechamodif;
	}

	public void setPrelultimafechamodif(Date prelultimafechamodif) {
		this.prelultimafechamodif = prelultimafechamodif;
	}


	public String getPrelultimoip() {
		return this.prelultimoip;
	}

	public void setPrelultimoip(String prelultimoip) {
		this.prelultimoip = prelultimoip;
	}


	public String getPrelultimousuario() {
		return this.prelultimousuario;
	}

	public void setPrelultimousuario(String prelultimousuario) {
		this.prelultimousuario = prelultimousuario;
	}


	public String getPrelusuariocreacion() {
		return this.prelusuariocreacion;
	}

	public void setPrelusuariocreacion(String prelusuariocreacion) {
		this.prelusuariocreacion = prelusuariocreacion;
	}

	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "PRELPERSONA_RELACION_SECUND", referencedColumnName = "PERSONA", 
					insertable = false, updatable = false, nullable = true)
			})
	@NotFound(action = NotFoundAction.IGNORE)
	public Personamast getPersonaMastRelacionSecund() {
		return personaMastRelacionSecund;
	}


	public void setPersonaMastRelacionSecund(Personamast personaMastRelacionSecund) {
		this.personaMastRelacionSecund = personaMastRelacionSecund;
	}


	@Transient
	public boolean isPrelflagDuracionDefinidaBool() {
		if(UtilesCommons.SI_db.equals(getPrelflagDuracionDefinida()) ){
			prelflagDuracionDefinidaBool = true;
		}else{
			prelflagDuracionDefinidaBool = false;
		}
		return prelflagDuracionDefinidaBool;
	}


	public void setPrelflagDuracionDefinidaBool(boolean prelflagDuracionDefinidaBool) {
		if(prelflagDuracionDefinidaBool){
			setPrelflagDuracionDefinida(UtilesCommons.SI_db);
		}else{
			setPrelflagDuracionDefinida(UtilesCommons.NO_db);
		}
		this.prelflagDuracionDefinidaBool = prelflagDuracionDefinidaBool;
	}

	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "PRELPERSONA_RELACION_DE", referencedColumnName = "PERSONA", 
					insertable = false, updatable = false, nullable = true)
			})
	@NotFound(action = NotFoundAction.IGNORE)
	public Personamast getPersonaMastRelacionDe() {
		return personaMastRelacionDe;
	}


	public void setPersonaMastRelacionDe(Personamast personaMastRelacionDe) {
		this.personaMastRelacionDe = personaMastRelacionDe;
	}



	
}