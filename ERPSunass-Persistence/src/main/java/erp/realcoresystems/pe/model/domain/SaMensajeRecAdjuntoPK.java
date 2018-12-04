package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SA_MENSAJE_REC_ADJUNTO database table.
 * 
 */
@Embeddable
public class SaMensajeRecAdjuntoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Long mensMensajeid;
	private Integer meadAdjuntoid;

	public SaMensajeRecAdjuntoPK() {
	}

	@Column(name="MENS_MENSAJEID", insertable=false, updatable=false)
	public Long getMensMensajeid() {
		return this.mensMensajeid;
	}
	public void setMensMensajeid(Long mensMensajeid) {
		this.mensMensajeid = mensMensajeid;
	}

	@Column(name="MEAD_ADJUNTOID")
	public Integer getMeadAdjuntoid() {
		return this.meadAdjuntoid;
	}
	public void setMeadAdjuntoid(Integer meadAdjuntoid) {
		this.meadAdjuntoid = meadAdjuntoid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SaMensajeRecAdjuntoPK)) {
			return false;
		}
		SaMensajeRecAdjuntoPK castOther = (SaMensajeRecAdjuntoPK)other;
		return 
			(this.mensMensajeid == castOther.mensMensajeid)
			&& (this.meadAdjuntoid == castOther.meadAdjuntoid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.mensMensajeid ^ (this.mensMensajeid >>> 32)));
		hash = hash * prime + ((int) (this.meadAdjuntoid ^ (this.meadAdjuntoid >>> 32)));
		
		return hash;
	}
}