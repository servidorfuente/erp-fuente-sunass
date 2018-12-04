package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name = "SA_COMPENDIODETALLE")
public class SaCompendioDetalle  extends Entidad{
	
    private Integer nidecompendio;
    private Integer nidedetalle;
    private Date dfecfinvig;
    private Date dfecinivig;
    private Date dtfecreg;
    private Integer ndesref1;
    private Integer ndesref2;
    private Integer ndesref3;
    private Integer ndesref4;
    private Integer ndesref5;
    private Integer ndesref6;
    private Integer nestado;
    private Integer nideusureg;
    private Integer nindelegrupo;
    private Integer nvalorref;
    private String vcodelemento;
    private String vdesref1;
    private String vdesref2;
    private String vdesref3;
    private String vdesref4;
    private String vdesref5;
    private String vdesref6;
    private String vnomcorto;
    private String vnomdetalle;
    
    @Id
    @javax.persistence.Column(name = "NIDECOMPENDIO")
    public Integer getNidecompendio() {
        return nidecompendio;
    }

    @Id
    @javax.persistence.Column(name = "NIDEDETALLE")
    public Integer getNidedetalle() {
        return nidedetalle;
    }
    
    @Basic
    @javax.persistence.Column(name = "DFECFINVIG")
    public Date getDfecfinvig() {
        return dfecfinvig;
    }

    @Basic
    @javax.persistence.Column(name = "DFECINIVIG")
    public Date getDfecinivig() {
        return dfecinivig;
    }

    @Basic
    @javax.persistence.Column(name = "DTFECREG")
    public Date getDtfecreg() {
        return dtfecreg;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF1")
    public Integer getNdesref1() {
        return ndesref1;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF2")
    public Integer getNdesref2() {
        return ndesref2;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF3")
    public Integer getNdesref3() {
        return ndesref3;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF4")
    public Integer getNdesref4() {
        return ndesref4;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF5")
    public Integer getNdesref5() {
        return ndesref5;
    }

    @Basic
    @javax.persistence.Column(name = "NDESREF6")
    public Integer getNdesref6() {
        return ndesref6;
    }

    @Basic
    @javax.persistence.Column(name = "NESTADO")
    public Integer getNestado() {
        return nestado;
    }

    @Basic
    @javax.persistence.Column(name = "NIDEUSUREG")
    public Integer getNideusureg() {
        return nideusureg;
    }

    @Basic
    @javax.persistence.Column(name = "NINDELEGRUPO")
    public Integer getNindelegrupo() {
        return nindelegrupo;
    }

    @Basic
    @javax.persistence.Column(name = "NVALORREF")
    public Integer getNvalorref() {
        return nvalorref;
    }

    @Basic
    @javax.persistence.Column(name = "VCODELEMENTO")
    public String getVcodelemento() {
        return vcodelemento;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF1")
    public String getVdesref1() {
        return vdesref1;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF2")
    public String getVdesref2() {
        return vdesref2;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF3")
    public String getVdesref3() {
        return vdesref3;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF4")
    public String getVdesref4() {
        return vdesref4;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF5")
    public String getVdesref5() {
        return vdesref5;
    }

    @Basic
    @javax.persistence.Column(name = "VDESREF6")
    public String getVdesref6() {
        return vdesref6;
    }

    @Basic
    @javax.persistence.Column(name = "VNOMCORTO")
    public String getVnomcorto() {
        return vnomcorto;
    }

    @Basic
    @javax.persistence.Column(name = "VNOMDETALLE")
    public String getVnomdetalle() {
        return vnomdetalle;
    }
    
    public void setDfecfinvig(Date dfecfinvig) {
        this.dfecfinvig = dfecfinvig;
    }

    public void setDfecinivig(Date dfecinivig) {
        this.dfecinivig = dfecinivig;
    }

    public void setDtfecreg(Date dtfecreg) {
        this.dtfecreg = dtfecreg;
    }

    public void setNdesref1(Integer ndesref1) {
        this.ndesref1 = ndesref1;
    }

    public void setNdesref2(Integer ndesref2) {
        this.ndesref2 = ndesref2;
    }

    public void setNdesref3(Integer ndesref3) {
        this.ndesref3 = ndesref3;
    }

    public void setNdesref4(Integer ndesref4) {
        this.ndesref4 = ndesref4;
    }

    public void setNdesref5(Integer ndesref5) {
        this.ndesref5 = ndesref5;
    }

    public void setNdesref6(Integer ndesref6) {
        this.ndesref6 = ndesref6;
    }

    public void setNestado(Integer nestado) {
        this.nestado = nestado;
    }

    public void setNidecompendio(Integer nidecompendio) {
        this.nidecompendio = nidecompendio;
    }

    public void setNidedetalle(Integer nidedetalle) {
        this.nidedetalle = nidedetalle;
    }

    public void setNideusureg(Integer nideusureg) {
        this.nideusureg = nideusureg;
    }

    public void setNindelegrupo(Integer nindelegrupo) {
        this.nindelegrupo = nindelegrupo;
    }

    public void setNvalorref(Integer nvalorref) {
        this.nvalorref = nvalorref;
    }

    public void setVcodelemento(String vcodelemento) {
        this.vcodelemento = vcodelemento;
    }

    public void setVdesref1(String vdesref1) {
        this.vdesref1 = vdesref1;
    }

    public void setVdesref2(String vdesref2) {
        this.vdesref2 = vdesref2;
    }

    public void setVdesref3(String vdesref3) {
        this.vdesref3 = vdesref3;
    }

    public void setVdesref4(String vdesref4) {
        this.vdesref4 = vdesref4;
    }

    public void setVdesref5(String vdesref5) {
        this.vdesref5 = vdesref5;
    }

    public void setVdesref6(String vdesref6) {
        this.vdesref6 = vdesref6;
    }

    public void setVnomcorto(String vnomcorto) {
        this.vnomcorto = vnomcorto;
    }

    public void setVnomdetalle(String vnomdetalle) {
        this.vnomdetalle = vnomdetalle;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dfecfinvig == null) ? 0 : dfecfinvig.hashCode());
		result = prime * result
				+ ((dfecinivig == null) ? 0 : dfecinivig.hashCode());
		result = prime * result
				+ ((dtfecreg == null) ? 0 : dtfecreg.hashCode());
		result = prime * result
				+ ((ndesref1 == null) ? 0 : ndesref1.hashCode());
		result = prime * result
				+ ((ndesref2 == null) ? 0 : ndesref2.hashCode());
		result = prime * result
				+ ((ndesref3 == null) ? 0 : ndesref3.hashCode());
		result = prime * result
				+ ((ndesref4 == null) ? 0 : ndesref4.hashCode());
		result = prime * result
				+ ((ndesref5 == null) ? 0 : ndesref5.hashCode());
		result = prime * result
				+ ((ndesref6 == null) ? 0 : ndesref6.hashCode());
		result = prime * result + ((nestado == null) ? 0 : nestado.hashCode());
		result = prime * result
				+ ((nidecompendio == null) ? 0 : nidecompendio.hashCode());
		result = prime * result
				+ ((nidedetalle == null) ? 0 : nidedetalle.hashCode());
		result = prime * result
				+ ((nideusureg == null) ? 0 : nideusureg.hashCode());
		result = prime * result
				+ ((nindelegrupo == null) ? 0 : nindelegrupo.hashCode());
		result = prime * result
				+ ((nvalorref == null) ? 0 : nvalorref.hashCode());
		result = prime * result
				+ ((vcodelemento == null) ? 0 : vcodelemento.hashCode());
		result = prime * result
				+ ((vdesref1 == null) ? 0 : vdesref1.hashCode());
		result = prime * result
				+ ((vdesref2 == null) ? 0 : vdesref2.hashCode());
		result = prime * result
				+ ((vdesref3 == null) ? 0 : vdesref3.hashCode());
		result = prime * result
				+ ((vdesref4 == null) ? 0 : vdesref4.hashCode());
		result = prime * result
				+ ((vdesref5 == null) ? 0 : vdesref5.hashCode());
		result = prime * result
				+ ((vdesref6 == null) ? 0 : vdesref6.hashCode());
		result = prime * result
				+ ((vnomcorto == null) ? 0 : vnomcorto.hashCode());
		result = prime * result
				+ ((vnomdetalle == null) ? 0 : vnomdetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaCompendioDetalle other = (SaCompendioDetalle) obj;
		if (dfecfinvig == null) {
			if (other.dfecfinvig != null)
				return false;
		} else if (!dfecfinvig.equals(other.dfecfinvig))
			return false;
		if (dfecinivig == null) {
			if (other.dfecinivig != null)
				return false;
		} else if (!dfecinivig.equals(other.dfecinivig))
			return false;
		if (dtfecreg == null) {
			if (other.dtfecreg != null)
				return false;
		} else if (!dtfecreg.equals(other.dtfecreg))
			return false;
		if (ndesref1 == null) {
			if (other.ndesref1 != null)
				return false;
		} else if (!ndesref1.equals(other.ndesref1))
			return false;
		if (ndesref2 == null) {
			if (other.ndesref2 != null)
				return false;
		} else if (!ndesref2.equals(other.ndesref2))
			return false;
		if (ndesref3 == null) {
			if (other.ndesref3 != null)
				return false;
		} else if (!ndesref3.equals(other.ndesref3))
			return false;
		if (ndesref4 == null) {
			if (other.ndesref4 != null)
				return false;
		} else if (!ndesref4.equals(other.ndesref4))
			return false;
		if (ndesref5 == null) {
			if (other.ndesref5 != null)
				return false;
		} else if (!ndesref5.equals(other.ndesref5))
			return false;
		if (ndesref6 == null) {
			if (other.ndesref6 != null)
				return false;
		} else if (!ndesref6.equals(other.ndesref6))
			return false;
		if (nestado == null) {
			if (other.nestado != null)
				return false;
		} else if (!nestado.equals(other.nestado))
			return false;
		if (nidecompendio == null) {
			if (other.nidecompendio != null)
				return false;
		} else if (!nidecompendio.equals(other.nidecompendio))
			return false;
		if (nidedetalle == null) {
			if (other.nidedetalle != null)
				return false;
		} else if (!nidedetalle.equals(other.nidedetalle))
			return false;
		if (nideusureg == null) {
			if (other.nideusureg != null)
				return false;
		} else if (!nideusureg.equals(other.nideusureg))
			return false;
		if (nindelegrupo == null) {
			if (other.nindelegrupo != null)
				return false;
		} else if (!nindelegrupo.equals(other.nindelegrupo))
			return false;
		if (nvalorref == null) {
			if (other.nvalorref != null)
				return false;
		} else if (!nvalorref.equals(other.nvalorref))
			return false;
		if (vcodelemento == null) {
			if (other.vcodelemento != null)
				return false;
		} else if (!vcodelemento.equals(other.vcodelemento))
			return false;
		if (vdesref1 == null) {
			if (other.vdesref1 != null)
				return false;
		} else if (!vdesref1.equals(other.vdesref1))
			return false;
		if (vdesref2 == null) {
			if (other.vdesref2 != null)
				return false;
		} else if (!vdesref2.equals(other.vdesref2))
			return false;
		if (vdesref3 == null) {
			if (other.vdesref3 != null)
				return false;
		} else if (!vdesref3.equals(other.vdesref3))
			return false;
		if (vdesref4 == null) {
			if (other.vdesref4 != null)
				return false;
		} else if (!vdesref4.equals(other.vdesref4))
			return false;
		if (vdesref5 == null) {
			if (other.vdesref5 != null)
				return false;
		} else if (!vdesref5.equals(other.vdesref5))
			return false;
		if (vdesref6 == null) {
			if (other.vdesref6 != null)
				return false;
		} else if (!vdesref6.equals(other.vdesref6))
			return false;
		if (vnomcorto == null) {
			if (other.vnomcorto != null)
				return false;
		} else if (!vnomcorto.equals(other.vnomcorto))
			return false;
		if (vnomdetalle == null) {
			if (other.vnomdetalle != null)
				return false;
		} else if (!vnomdetalle.equals(other.vnomdetalle))
			return false;
		return true;
	}
    
}
