package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 07/01/2016.
 */
@Entity
@Table(name = "AC_SUCURSALGRUPO")
public class AcSucursalgrupo extends Entidad{
    private String sucursalgrupo;
    private String descripcionlocal;
    private String descripcioningles;
    private String estado;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String sucursalgrupomayor;

    @Id
    @Column(name = "SUCURSALGRUPO")
    public String getSucursalgrupo() {
        return sucursalgrupo;
    }

    public void setSucursalgrupo(String sucursalgrupo) {
        this.sucursalgrupo = sucursalgrupo;
    }

    @Basic
    @Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    @Basic
    @Column(name = "DESCRIPCIONINGLES")
    public String getDescripcioningles() {
        return descripcioningles;
    }

    public void setDescripcioningles(String descripcioningles) {
        this.descripcioningles = descripcioningles;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    @Column(name = "SUCURSALGRUPOMAYOR")
    public String getSucursalgrupomayor() {
        return sucursalgrupomayor;
    }

    public void setSucursalgrupomayor(String sucursalgrupomayor) {
        this.sucursalgrupomayor = sucursalgrupomayor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcSucursalgrupo that = (AcSucursalgrupo) o;

        if (sucursalgrupo != null ? !sucursalgrupo.equals(that.sucursalgrupo) : that.sucursalgrupo != null)
            return false;
        if (descripcionlocal != null ? !descripcionlocal.equals(that.descripcionlocal) : that.descripcionlocal != null)
            return false;
        if (descripcioningles != null ? !descripcioningles.equals(that.descripcioningles) : that.descripcioningles != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (sucursalgrupomayor != null ? !sucursalgrupomayor.equals(that.sucursalgrupomayor) : that.sucursalgrupomayor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sucursalgrupo != null ? sucursalgrupo.hashCode() : 0;
        result = 31 * result + (descripcionlocal != null ? descripcionlocal.hashCode() : 0);
        result = 31 * result + (descripcioningles != null ? descripcioningles.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (sucursalgrupomayor != null ? sucursalgrupomayor.hashCode() : 0);
        return result;
    }
}
