package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import erp.realcoresystems.pe.model.util.Utiles;


/**
 * The persistent class for the SA_GRADOINSTRUCCION database table.
 * 
 */
@Entity
@Table(name="SA_GRADOINSTRUCCION")
public class SaGradoinstruccion extends Entidad {
	private static final long serialVersionUID = 1L;
	private Integer gradoinstruccion;
	private String descripcion;
	private String estado;
	private String flagcentroestudios;
	private String flagtienecarrera;
	private String gradoinstruccionsuperior;
	private String niveleducativortps;
	private Date uitimafechamodif;
	private Date ultimafechamodif;
	private String ultimousuario;
	
	private boolean flagcentroestudiosBool;
	private boolean flagtienecarreraBool;

	public SaGradoinstruccion() {
	}


	@Id
	public Integer getGradoinstruccion() {
		return this.gradoinstruccion;
	}

	public void setGradoinstruccion(Integer gradoinstruccion) {
		this.gradoinstruccion = gradoinstruccion;
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


	public String getFlagcentroestudios() {
		return this.flagcentroestudios;
	}

	public void setFlagcentroestudios(String flagcentroestudios) {
		this.flagcentroestudios = flagcentroestudios;
	}


	public String getFlagtienecarrera() {
		return this.flagtienecarrera;
	}

	public void setFlagtienecarrera(String flagtienecarrera) {
		this.flagtienecarrera = flagtienecarrera;
	}


	public String getGradoinstruccionsuperior() {
		return this.gradoinstruccionsuperior;
	}

	public void setGradoinstruccionsuperior(String gradoinstruccionsuperior) {
		this.gradoinstruccionsuperior = gradoinstruccionsuperior;
	}


	public String getNiveleducativortps() {
		return this.niveleducativortps;
	}

	public void setNiveleducativortps(String niveleducativortps) {
		this.niveleducativortps = niveleducativortps;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUitimafechamodif() {
		return this.uitimafechamodif;
	}

	public void setUitimafechamodif(Date uitimafechamodif) {
		this.uitimafechamodif = uitimafechamodif;
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

	@Transient
	public boolean isFlagcentroestudiosBool() {
		if(Utiles.SI_db.equals(flagcentroestudios)){
			flagcentroestudiosBool=true;
		}else{
			flagcentroestudiosBool=false;
		}
		return flagcentroestudiosBool;
	}


	public void setFlagcentroestudiosBool(boolean flagcentroestudiosBool) {
		if(flagcentroestudiosBool){
			setFlagcentroestudios(Utiles.SI_db); 
		}else{
			setFlagcentroestudios(Utiles.NO_db);
		}
		this.flagcentroestudiosBool = flagcentroestudiosBool;
	}
	
	@Transient
	public boolean isFlagtienecarreraBool() {
		if(Utiles.SI_db.equals(flagtienecarrera)){
			flagtienecarreraBool=true;
		}else{
			flagtienecarreraBool=false;
		}
		return flagtienecarreraBool;
	}


	public void setFlagtienecarreraBool(boolean flagtienecarreraBool) {
		if(flagtienecarreraBool){
			setFlagtienecarrera(Utiles.SI_db); 
		}else{
			setFlagtienecarrera(Utiles.NO_db);
		}
		this.flagtienecarreraBool = flagtienecarreraBool;
	}
	
	

}