package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsProyectoPK implements Serializable {
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsProyectoPK that = (SsProyectoPK) o;

        if (proyectoid != that.proyectoid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (proyectoid ^ (proyectoid >>> 32));
        return result;
    }
}
