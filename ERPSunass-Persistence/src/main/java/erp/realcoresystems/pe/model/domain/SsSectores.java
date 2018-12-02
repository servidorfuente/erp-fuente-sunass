package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "SS_SECTORES")
public class SsSectores   extends Entidad {
    private Integer sectorid;
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;
    private String secodigo;
    private String sedescripcion;
    private String seobservaciones;
    private String seestado;

    @Id
    @Column(name = "SECTORID")
    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    @Basic
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Basic
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Basic
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Basic
    @Column(name = "SECODIGO")
    public String getSecodigo() {
        return secodigo;
    }

    public void setSecodigo(String secodigo) {
        this.secodigo = secodigo;
    }

    @Basic
    @Column(name = "SEDESCRIPCION")
    public String getSedescripcion() {
        return sedescripcion;
    }

    public void setSedescripcion(String sedescripcion) {
        this.sedescripcion = sedescripcion;
    }

    @Basic
    @Column(name = "SEOBSERVACIONES")
    public String getSeobservaciones() {
        return seobservaciones;
    }

    public void setSeobservaciones(String seobservaciones) {
        this.seobservaciones = seobservaciones;
    }

    @Basic
    @Column(name = "SEESTADO")
    public String getSeestado() {
        return seestado;
    }

    public void setSeestado(String seestado) {
        this.seestado = seestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsSectores that = (SsSectores) o;

        if (sectorid != that.sectorid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (proyectoid != null ? !proyectoid.equals(that.proyectoid) : that.proyectoid != null) return false;
        if (secodigo != null ? !secodigo.equals(that.secodigo) : that.secodigo != null) return false;
        if (sedescripcion != null ? !sedescripcion.equals(that.sedescripcion) : that.sedescripcion != null)
            return false;
        if (seobservaciones != null ? !seobservaciones.equals(that.seobservaciones) : that.seobservaciones != null)
            return false;
        if (seestado != null ? !seestado.equals(that.seestado) : that.seestado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sectorid ^ (sectorid >>> 32));
        result = 31 * result + (companyowner != null ? companyowner.hashCode() : 0);
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (proyectoid != null ? proyectoid.hashCode() : 0);
        result = 31 * result + (secodigo != null ? secodigo.hashCode() : 0);
        result = 31 * result + (sedescripcion != null ? sedescripcion.hashCode() : 0);
        result = 31 * result + (seobservaciones != null ? seobservaciones.hashCode() : 0);
        result = 31 * result + (seestado != null ? seestado.hashCode() : 0);
        return result;
    }
}
