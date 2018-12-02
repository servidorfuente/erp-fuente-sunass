package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "SS_PROYECTO")
public class SsProyecto   extends Entidad {
    private Integer proyectoid;
    private String companyowner;
    private String sucursal;
    private Integer sectorid;
    private String prcodigo;
    private String prdescripcion;
    private String prubigeo;
    private String probservaciones;
    private String seestado;

    @Id
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
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
    @Column(name = "SECTORID")
    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    @Basic
    @Column(name = "PRCODIGO")
    public String getPrcodigo() {
        return prcodigo;
    }

    public void setPrcodigo(String prcodigo) {
        this.prcodigo = prcodigo;
    }

    @Basic
    @Column(name = "PRDESCRIPCION")
    public String getPrdescripcion() {
        return prdescripcion;
    }

    public void setPrdescripcion(String prdescripcion) {
        this.prdescripcion = prdescripcion;
    }

    @Basic
    @Column(name = "PRUBIGEO")
    public String getPrubigeo() {
        return prubigeo;
    }

    public void setPrubigeo(String prubigeo) {
        this.prubigeo = prubigeo;
    }

    @Basic
    @Column(name = "PROBSERVACIONES")
    public String getProbservaciones() {
        return probservaciones;
    }

    public void setProbservaciones(String probservaciones) {
        this.probservaciones = probservaciones;
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

        SsProyecto that = (SsProyecto) o;

        if (proyectoid != that.proyectoid) return false;
        if (sectorid != that.sectorid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (prcodigo != null ? !prcodigo.equals(that.prcodigo) : that.prcodigo != null) return false;
        if (prdescripcion != null ? !prdescripcion.equals(that.prdescripcion) : that.prdescripcion != null)
            return false;
        if (prubigeo != null ? !prubigeo.equals(that.prubigeo) : that.prubigeo != null) return false;
        if (probservaciones != null ? !probservaciones.equals(that.probservaciones) : that.probservaciones != null)
            return false;
        if (seestado != null ? !seestado.equals(that.seestado) : that.seestado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (proyectoid ^ (proyectoid >>> 32));
        result = 31 * result + (companyowner != null ? companyowner.hashCode() : 0);
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (sectorid ^ (sectorid >>> 32));
        result = 31 * result + (prcodigo != null ? prcodigo.hashCode() : 0);
        result = 31 * result + (prdescripcion != null ? prdescripcion.hashCode() : 0);
        result = 31 * result + (prubigeo != null ? prubigeo.hashCode() : 0);
        result = 31 * result + (probservaciones != null ? probservaciones.hashCode() : 0);
        result = 31 * result + (seestado != null ? seestado.hashCode() : 0);
        return result;
    }
}
