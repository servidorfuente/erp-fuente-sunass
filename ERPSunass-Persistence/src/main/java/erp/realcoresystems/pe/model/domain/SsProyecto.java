package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SS_PROYECTO" )
@IdClass(SsProyectoPK.class)
public class SsProyecto   extends Entidad{
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;
    private Integer sectorid;
    private String prcodigo;
    private String prdescripcion;
    private String prubigeo;
    private String probservaciones;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String estado;

    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Id
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
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
    @Column(name = "CREACIONUSUARIO")
    public String getCreacionusuario() {
        return creacionusuario;
    }

    public void setCreacionusuario(String creacionusuario) {
        this.creacionusuario = creacionusuario;
    }

    @Basic
    @Column(name = "CREACIONFECHA")
    public Date getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date creacionfecha) {
        this.creacionfecha = creacionfecha;
    }

    @Basic
    @Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    @Basic
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsProyecto that = (SsProyecto) o;

        if (proyectoid != that.proyectoid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (sectorid != null ? !sectorid.equals(that.sectorid) : that.sectorid != null) return false;
        if (prcodigo != null ? !prcodigo.equals(that.prcodigo) : that.prcodigo != null) return false;
        if (prdescripcion != null ? !prdescripcion.equals(that.prdescripcion) : that.prdescripcion != null)
            return false;
        if (prubigeo != null ? !prubigeo.equals(that.prubigeo) : that.prubigeo != null) return false;
        if (probservaciones != null ? !probservaciones.equals(that.probservaciones) : that.probservaciones != null)
            return false;
        if (creacionusuario != null ? !creacionusuario.equals(that.creacionusuario) : that.creacionusuario != null)
            return false;
        if (creacionfecha != null ? !creacionfecha.equals(that.creacionfecha) : that.creacionfecha != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (proyectoid ^ (proyectoid >>> 32));
        result = 31 * result + (sectorid != null ? sectorid.hashCode() : 0);
        result = 31 * result + (prcodigo != null ? prcodigo.hashCode() : 0);
        result = 31 * result + (prdescripcion != null ? prdescripcion.hashCode() : 0);
        result = 31 * result + (prubigeo != null ? prubigeo.hashCode() : 0);
        result = 31 * result + (probservaciones != null ? probservaciones.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
