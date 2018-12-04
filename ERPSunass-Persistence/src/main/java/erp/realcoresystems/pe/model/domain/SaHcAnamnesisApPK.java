package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SA_HC_ANAMNESIS_AP database table.
 * 
 */
@Embeddable
public class SaHcAnamnesisApPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer persona;
	private Integer episodioclinicoid;

	public SaHcAnamnesisApPK() {
	}

	public Integer getPersona() {
		return this.persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getEpisodioclinicoid() {
		return this.episodioclinicoid;
	}
	public void setEpisodioclinicoid(Integer episodioclinicoid) {
		this.episodioclinicoid = episodioclinicoid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SaHcAnamnesisApPK)) {
			return false;
		}
		SaHcAnamnesisApPK castOther = (SaHcAnamnesisApPK)other;
		return 
			(this.persona == castOther.persona)
			&& (this.episodioclinicoid == castOther.episodioclinicoid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.persona ^ (this.persona >>> 32)));
		hash = hash * prime + ((int) (this.episodioclinicoid ^ (this.episodioclinicoid >>> 32)));
		
		return hash;
	}
}