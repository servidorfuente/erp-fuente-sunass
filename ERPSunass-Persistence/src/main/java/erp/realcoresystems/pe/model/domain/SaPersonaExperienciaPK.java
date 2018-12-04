package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SA_PERSONA_EXPERIENCIA database table.
 * 
 */
@Embeddable
public class SaPersonaExperienciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer persona;
	
	private Long secuencia;

	public SaPersonaExperienciaPK() {
	}

	public Integer getPersona() {
		return this.persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}



	public Long getSecuencia() {
		return this.secuencia;
	}
	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SaPersonaExperienciaPK)) {
			return false;
		}
		SaPersonaExperienciaPK castOther = (SaPersonaExperienciaPK)other;
		return 
			(this.persona == castOther.persona)			
			&& (this.secuencia == castOther.secuencia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.persona ^ (this.persona >>> 32)));		
		hash = hash * prime + ((int) (this.secuencia ^ (this.secuencia >>> 32)));
		
		return hash;
	}
}