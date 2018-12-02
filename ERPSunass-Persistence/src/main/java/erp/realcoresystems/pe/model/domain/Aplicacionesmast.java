package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mamania on 22/12/2015.
 */
@Entity
public class Aplicacionesmast  implements java.io.Serializable{
    private String aplicacioncodigo;

    @Id
    @javax.persistence.Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    private String descripcioncorta;

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONCORTA")
    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    private String descripcionlarga;

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONLARGA")
    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    private String ultimoperiodocontable;

    @Basic
    @javax.persistence.Column(name = "ULTIMOPERIODOCONTABLE")
    public String getUltimoperiodocontable() {
        return ultimoperiodocontable;
    }

    public void setUltimoperiodocontable(String ultimoperiodocontable) {
        this.ultimoperiodocontable = ultimoperiodocontable;
    }

    private String sistemafuente;

    @Basic
    @javax.persistence.Column(name = "SISTEMAFUENTE")
    public String getSistemafuente() {
        return sistemafuente;
    }

    public void setSistemafuente(String sistemafuente) {
        this.sistemafuente = sistemafuente;
    }

    private String estadisponible;

    @Basic
    @javax.persistence.Column(name = "ESTADISPONIBLE")
    public String getEstadisponible() {
        return estadisponible;
    }

    public void setEstadisponible(String estadisponible) {
        this.estadisponible = estadisponible;
    }

    private String departamentorevisor;

    @Basic
    @javax.persistence.Column(name = "DEPARTAMENTOREVISOR")
    public String getDepartamentorevisor() {
        return departamentorevisor;
    }

    public void setDepartamentorevisor(String departamentorevisor) {
        this.departamentorevisor = departamentorevisor;
    }

    private String ultimoperiodoprocesado;

    @Basic
    @javax.persistence.Column(name = "ULTIMOPERIODOPROCESADO")
    public String getUltimoperiodoprocesado() {
        return ultimoperiodoprocesado;
    }

    public void setUltimoperiodoprocesado(String ultimoperiodoprocesado) {
        this.ultimoperiodoprocesado = ultimoperiodoprocesado;
    }

    private String aplicacionusuario;

    @Basic
    @javax.persistence.Column(name = "APLICACIONUSUARIO")
    public String getAplicacionusuario() {
        return aplicacionusuario;
    }

    public void setAplicacionusuario(String aplicacionusuario) {
        this.aplicacionusuario = aplicacionusuario;
    }

    private String estado;

    @Basic
    @javax.persistence.Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String ultimousuario;

    @Basic
    @javax.persistence.Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    private Date ultimafechamodif;

    @Basic
    @javax.persistence.Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    private String aplicacionusuario02;

    @Basic
    @javax.persistence.Column(name = "APLICACIONUSUARIO02")
    public String getAplicacionusuario02() {
        return aplicacionusuario02;
    }

    public void setAplicacionusuario02(String aplicacionusuario02) {
        this.aplicacionusuario02 = aplicacionusuario02;
    }

    private String aplicacionusuario03;

    @Basic
    @javax.persistence.Column(name = "APLICACIONUSUARIO03")
    public String getAplicacionusuario03() {
        return aplicacionusuario03;
    }

    public void setAplicacionusuario03(String aplicacionusuario03) {
        this.aplicacionusuario03 = aplicacionusuario03;
    }

    private String aplicacionusuario04;

    @Basic
    @javax.persistence.Column(name = "APLICACIONUSUARIO04")
    public String getAplicacionusuario04() {
        return aplicacionusuario04;
    }

    public void setAplicacionusuario04(String aplicacionusuario04) {
        this.aplicacionusuario04 = aplicacionusuario04;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aplicacionesmast that = (Aplicacionesmast) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (descripcioncorta != null ? !descripcioncorta.equals(that.descripcioncorta) : that.descripcioncorta != null)
            return false;
        if (descripcionlarga != null ? !descripcionlarga.equals(that.descripcionlarga) : that.descripcionlarga != null)
            return false;
        if (ultimoperiodocontable != null ? !ultimoperiodocontable.equals(that.ultimoperiodocontable) : that.ultimoperiodocontable != null)
            return false;
        if (sistemafuente != null ? !sistemafuente.equals(that.sistemafuente) : that.sistemafuente != null)
            return false;
        if (estadisponible != null ? !estadisponible.equals(that.estadisponible) : that.estadisponible != null)
            return false;
        if (departamentorevisor != null ? !departamentorevisor.equals(that.departamentorevisor) : that.departamentorevisor != null)
            return false;
        if (ultimoperiodoprocesado != null ? !ultimoperiodoprocesado.equals(that.ultimoperiodoprocesado) : that.ultimoperiodoprocesado != null)
            return false;
        if (aplicacionusuario != null ? !aplicacionusuario.equals(that.aplicacionusuario) : that.aplicacionusuario != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (aplicacionusuario02 != null ? !aplicacionusuario02.equals(that.aplicacionusuario02) : that.aplicacionusuario02 != null)
            return false;
        if (aplicacionusuario03 != null ? !aplicacionusuario03.equals(that.aplicacionusuario03) : that.aplicacionusuario03 != null)
            return false;
        if (aplicacionusuario04 != null ? !aplicacionusuario04.equals(that.aplicacionusuario04) : that.aplicacionusuario04 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (descripcioncorta != null ? descripcioncorta.hashCode() : 0);
        result = 31 * result + (descripcionlarga != null ? descripcionlarga.hashCode() : 0);
        result = 31 * result + (ultimoperiodocontable != null ? ultimoperiodocontable.hashCode() : 0);
        result = 31 * result + (sistemafuente != null ? sistemafuente.hashCode() : 0);
        result = 31 * result + (estadisponible != null ? estadisponible.hashCode() : 0);
        result = 31 * result + (departamentorevisor != null ? departamentorevisor.hashCode() : 0);
        result = 31 * result + (ultimoperiodoprocesado != null ? ultimoperiodoprocesado.hashCode() : 0);
        result = 31 * result + (aplicacionusuario != null ? aplicacionusuario.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (aplicacionusuario02 != null ? aplicacionusuario02.hashCode() : 0);
        result = 31 * result + (aplicacionusuario03 != null ? aplicacionusuario03.hashCode() : 0);
        result = 31 * result + (aplicacionusuario04 != null ? aplicacionusuario04.hashCode() : 0);
        return result;
    }
}
