package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsCargainicialPK implements Serializable {
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;
    private Integer fuenteid;
    private Integer anno;
    private Integer cargainicialid;

    @Column(name = "COMPANYOWNER")
    @Id
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Column(name = "SUCURSAL")
    @Id
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Column(name = "PROYECTOID")
    @Id
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Column(name = "FUENTEID")
    @Id
    public Integer getFuenteid() {
        return fuenteid;
    }

    public void setFuenteid(Integer fuenteid) {
        this.fuenteid = fuenteid;
    }

    @Column(name = "ANNO")
    @Id
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Column(name = "CARGAINICIALID")
    @Id
    public Integer getCargainicialid() {
        return cargainicialid;
    }

    public void setCargainicialid(Integer cargainicialid) {
        this.cargainicialid = cargainicialid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsCargainicialPK that = (SsCargainicialPK) o;

        if (proyectoid != that.proyectoid) return false;
        if (fuenteid != that.fuenteid) return false;
        if (anno != that.anno) return false;
        if (cargainicialid != that.cargainicialid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (proyectoid ^ (proyectoid >>> 32));
        result = 31 * result + (int) (fuenteid ^ (fuenteid >>> 32));
        result = 31 * result + (int) (anno ^ (anno >>> 32));
        result = 31 * result + (int) (cargainicialid ^ (cargainicialid >>> 32));
        return result;
    }
}
