package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_CONCEPTO_CONFIG database table.
 * 
 */
@Entity
@Table(name="SA_CONCEPTO_CONFIG")
public class SaConceptoConfig extends Entidad{
	private static final long serialVersionUID = 1L;
	private String conceptoConfigCod;
	private String descripcion;
	private Integer estado;
	private String flagTipoAccion;
	private String tipoConceptoConfig;
	private Date ultimafechamodif;
	private String ultimousuario;
	
	private String tipousoConceptoConfig;
	

	public SaConceptoConfig() {
	}


	@Id
	@Column(name="CONCEPTO_CONFIG_COD")
	public String getConceptoConfigCod() {
		return this.conceptoConfigCod;
	}

	public void setConceptoConfigCod(String conceptoConfigCod) {
		this.conceptoConfigCod = conceptoConfigCod;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	@Column(name="FLAG_TIPO_ACCION")
	public String getFlagTipoAccion() {
		return this.flagTipoAccion;
	}

	public void setFlagTipoAccion(String flagTipoAccion) {
		this.flagTipoAccion = flagTipoAccion;
	}


	@Column(name="TIPO_CONCEPTO_CONFIG")
	public String getTipoConceptoConfig() {
		return this.tipoConceptoConfig;
	}

	public void setTipoConceptoConfig(String tipoConceptoConfig) {
		this.tipoConceptoConfig = tipoConceptoConfig;
	}


	//@Temporal(TemporalType.DATE)
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

	
	@Column(name="TIPOUSO_CONCEPTO_CONFIG")
	public String getTipousoConceptoConfig() {
		return tipousoConceptoConfig;
	}


	public void setTipousoConceptoConfig(String tipousoConceptoConfig) {
		this.tipousoConceptoConfig = tipousoConceptoConfig;
	}

}