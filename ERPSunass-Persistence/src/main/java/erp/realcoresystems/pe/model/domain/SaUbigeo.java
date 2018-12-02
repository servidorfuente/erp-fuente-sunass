package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Id;

@Entity
@Table(name = "SA_UBIGEO")
public class SaUbigeo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer ubigeoid;
    private String ubigeo;
    private String dpto;
    private String prov;
    private String dist;
    private String paicodigo;
    private String dptoubigeo;
    private String provubigeo;
    private String distubigeo;
    private String cregion;
    private String csubregion;
    private Integer fcambio;
    private String hcambio;
    private String cusuario;
    private Integer fini;
    private Integer ffin;
    private String cono;
    private Integer estadoUbigeo;

    @Id
    @Column(name = "UBIGEOID")
    public Integer getUbigeoid() {
        return ubigeoid;
    }

    public void setUbigeoid(Integer ubigeoid) {
        this.ubigeoid = ubigeoid;
    }

    @Basic
    @Column(name = "UBIGEO")
    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Basic
    @Column(name = "DPTO")
    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    @Basic
    @Column(name = "PROV")
    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    @Basic
    @Column(name = "DIST")
    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }
    
	@Basic
    @Column(name = "PAICODIGO")
	public String getPaicodigo() {
		return paicodigo;
	}

	public void setPaicodigo(String paicodigo) {
		this.paicodigo = paicodigo;
	}

	@Basic
    @Column(name = "DPTOUBIGEO")
    public String getDptoubigeo() {
		return dptoubigeo;
	}

	public void setDptoubigeo(String dptoubigeo) {
		this.dptoubigeo = dptoubigeo;
	}

	@Basic
    @Column(name = "PROVUBIGEO")
	public String getProvubigeo() {
		return provubigeo;
	}

	public void setProvubigeo(String provubigeo) {
		this.provubigeo = provubigeo;
	}

	@Basic
    @Column(name = "DISTUBIGEO")
	public String getDistubigeo() {
		return distubigeo;
	}

	public void setDistubigeo(String distubigeo) {
		this.distubigeo = distubigeo;
	}

	@Basic
    @Column(name = "CREGION")
    public String getCregion() {
        return cregion;
    }

    public void setCregion(String cregion) {
        this.cregion = cregion;
    }

    @Basic
    @Column(name = "CSUBREGION")
    public String getCsubregion() {
        return csubregion;
    }

    public void setCsubregion(String csubregion) {
        this.csubregion = csubregion;
    }

    @Basic
    @Column(name = "FCAMBIO")
    public Integer getFcambio() {
        return fcambio;
    }

    public void setFcambio(Integer fcambio) {
        this.fcambio = fcambio;
    }

    @Basic
    @Column(name = "HCAMBIO")
    public String getHcambio() {
        return hcambio;
    }

    public void setHcambio(String hcambio) {
        this.hcambio = hcambio;
    }

    @Basic
    @Column(name = "CUSUARIO")
    public String getCusuario() {
        return cusuario;
    }

    public void setCusuario(String cusuario) {
        this.cusuario = cusuario;
    }

    @Basic
    @Column(name = "FINI")
    public Integer getFini() {
        return fini;
    }

    public void setFini(Integer fini) {
        this.fini = fini;
    }

    @Basic
    @Column(name = "FFIN")
    public Integer getFfin() {
        return ffin;
    }

    public void setFfin(Integer ffin) {
        this.ffin = ffin;
    }

    @Basic
    @Column(name = "CONO")
    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    @Basic
    @Column(name = "ESTADO_UBIGEO")
    public Integer getEstadoUbigeo() {
        return estadoUbigeo;
    }

    public void setEstadoUbigeo(Integer estadoUbigeo) {
        this.estadoUbigeo = estadoUbigeo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaUbigeo saUbigeo = (SaUbigeo) o;

        if (ubigeoid != saUbigeo.ubigeoid) return false;
        if (ubigeo != null ? !ubigeo.equals(saUbigeo.ubigeo) : saUbigeo.ubigeo != null) return false;
        if (dpto != null ? !dpto.equals(saUbigeo.dpto) : saUbigeo.dpto != null) return false;
        if (prov != null ? !prov.equals(saUbigeo.prov) : saUbigeo.prov != null) return false;
        if (dist != null ? !dist.equals(saUbigeo.dist) : saUbigeo.dist != null) return false;
        if (cregion != null ? !cregion.equals(saUbigeo.cregion) : saUbigeo.cregion != null) return false;
        if (csubregion != null ? !csubregion.equals(saUbigeo.csubregion) : saUbigeo.csubregion != null) return false;
        if (fcambio != null ? !fcambio.equals(saUbigeo.fcambio) : saUbigeo.fcambio != null) return false;
        if (hcambio != null ? !hcambio.equals(saUbigeo.hcambio) : saUbigeo.hcambio != null) return false;
        if (cusuario != null ? !cusuario.equals(saUbigeo.cusuario) : saUbigeo.cusuario != null) return false;
        if (fini != null ? !fini.equals(saUbigeo.fini) : saUbigeo.fini != null) return false;
        if (ffin != null ? !ffin.equals(saUbigeo.ffin) : saUbigeo.ffin != null) return false;
        if (cono != null ? !cono.equals(saUbigeo.cono) : saUbigeo.cono != null) return false;
        if (estadoUbigeo != null ? !estadoUbigeo.equals(saUbigeo.estadoUbigeo) : saUbigeo.estadoUbigeo != null)
            return false;

        return true;
    }

}
