package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MA_CATEGORIA_MISCALENEOSDET database table.
 * 
 */
@Embeddable
public class MaCategoriaMiscelaneosdetPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String aplicacioncodigo;
	private String codigotablaCateg;
	private Integer categSecuencia;

	public MaCategoriaMiscelaneosdetPK() {
	}

	public String getAplicacioncodigo() {
		return this.aplicacioncodigo;
	}
	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}

	@Column(name="CODIGOTABLA_CATEG")
	public String getCodigotablaCateg() {
		return this.codigotablaCateg;
	}
	public void setCodigotablaCateg(String codigotablaCateg) {
		this.codigotablaCateg = codigotablaCateg;
	}

	@Column(name="CATEG_SECUENCIA")
	public Integer getCategSecuencia() {
		return this.categSecuencia;
	}
	public void setCategSecuencia(Integer categSecuencia) {
		this.categSecuencia = categSecuencia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MaCategoriaMiscelaneosdetPK)) {
			return false;
		}
		MaCategoriaMiscelaneosdetPK castOther = (MaCategoriaMiscelaneosdetPK)other;
		return 
			this.aplicacioncodigo.equals(castOther.aplicacioncodigo)
			&& this.codigotablaCateg.equals(castOther.codigotablaCateg)
			&& (this.categSecuencia == castOther.categSecuencia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.aplicacioncodigo.hashCode();
		hash = hash * prime + this.codigotablaCateg.hashCode();
		hash = hash * prime + ((int) (this.categSecuencia ^ (this.categSecuencia >>> 32)));
		
		return hash;
	}
}