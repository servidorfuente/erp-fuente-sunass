package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SA_PERSONA_EVENTO database table.
 * 
 */
@Embeddable
public class SaPersonaEventoPK extends Entidad {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	private Integer persona;
	private Long personaeventoid;
	
	public SaPersonaEventoPK() {
	}



	public Integer getPersona() {
		return this.persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	public Long getPersonaeventoid() {
		return this.personaeventoid;
	}

	public void setPersonaeventoid(Long personaeventoid) {
		this.personaeventoid = personaeventoid;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SaPersonaEventoPK)) {
			return false;
		}
		SaPersonaEventoPK castOther = (SaPersonaEventoPK)other;
		return 
			(this.personaeventoid == castOther.personaeventoid)
			&& (this.persona == castOther.persona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.personaeventoid ^ (this.personaeventoid >>> 32)));
		hash = hash * prime + ((int) (this.persona ^ (this.persona >>> 32)));
		
		return hash;
	}
}