package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mamania on 22/12/2015.
 */
@Entity
@IdClass(SeguridadgrupoPK.class)
public class Seguridadgrupo  extends Entidad{
    private String aplicacioncodigo;
    private String grupo;
    private String descripcion;
    private String ultimousuario;
    private Date ultimafechamodif;
    private BigDecimal orden;
    private String descripcioningles;

    @Id
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Id
    @Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
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
    @Column(name = "ORDEN")
    public BigDecimal getOrden() {
        return orden;
    }

    public void setOrden(BigDecimal orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "DESCRIPCIONINGLES")
    public String getDescripcioningles() {
        return descripcioningles;
    }

    public void setDescripcioningles(String descripcioningles) {
        this.descripcioningles = descripcioningles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seguridadgrupo that = (Seguridadgrupo) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (descripcioningles != null ? !descripcioningles.equals(that.descripcioningles) : that.descripcioningles != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (descripcioningles != null ? descripcioningles.hashCode() : 0);
        return result;
    }
}
