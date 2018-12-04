package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PARAMETROSMAST database table.
 * 
 */
@Embeddable
public class ParametrosMastPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String companiacodigo;
	private String aplicacioncodigo;
	private String parametroclave;

	public ParametrosMastPK() {
	}

	public String getCompaniacodigo() {
		return this.companiacodigo;
	}
	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}

	public String getAplicacioncodigo() {
		return this.aplicacioncodigo;
	}
	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}

	public String getParametroclave() {
		return this.parametroclave;
	}
	public void setParametroclave(String parametroclave) {
		this.parametroclave = parametroclave;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ParametrosMastPK)) {
			return false;
		}
		ParametrosMastPK castOther = (ParametrosMastPK)other;
		return 
			this.companiacodigo.equals(castOther.companiacodigo)
			&& this.aplicacioncodigo.equals(castOther.aplicacioncodigo)
			&& this.parametroclave.equals(castOther.parametroclave);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companiacodigo.hashCode();
		hash = hash * prime + this.aplicacioncodigo.hashCode();
		hash = hash * prime + this.parametroclave.hashCode();
		
		return hash;
	}

	@Override
	public String toString() {
		return "ParametrosMastPK [companiacodigo=" + companiacodigo + ", aplicacioncodigo=" + aplicacioncodigo
				+ ", parametroclave=" + parametroclave + "]";
	}
	
	
}