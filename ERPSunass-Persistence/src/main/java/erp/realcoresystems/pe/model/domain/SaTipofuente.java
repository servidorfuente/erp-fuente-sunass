package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date ;

@Entity
@Table(name = "SA_TIPOFUENTE")
public class SaTipofuente  extends Entidad{
    private Integer fuenteid;
    private String descripcion;
    private String creacionusuario;
    private Date  creacionfecha;
    private String ultimousuario;
    private Date  ultimafechamodif;
    private String estado;

    @Id
    @Column(name = "FUENTEID")
    public Integer getFuenteid() {
        return fuenteid;
    }

    public void setFuenteid(Integer fuenteid) {
        this.fuenteid = fuenteid;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Date  getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date  creacionfecha) {
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
    public Date  getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date  ultimafechamodif) {
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

        SaTipofuente that = (SaTipofuente) o;

        if (fuenteid != that.fuenteid) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
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
        int result = (int) (fuenteid ^ (fuenteid >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
