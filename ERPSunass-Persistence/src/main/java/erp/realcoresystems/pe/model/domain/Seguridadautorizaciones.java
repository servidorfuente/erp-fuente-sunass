package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mamania on 22/12/2015.
 */
@Entity
public class Seguridadautorizaciones extends Entidad {
    private String aplicacioncodigo;

    @Id
    @javax.persistence.Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    private String grupo;

    @Id
    @javax.persistence.Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    private String concepto;

    @Id
    @javax.persistence.Column(name = "CONCEPTO")
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    private String usuario;

    @Id
    @javax.persistence.Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String opcionagregarflag;

    @Basic
    @javax.persistence.Column(name = "OPCIONAGREGARFLAG")
    public String getOpcionagregarflag() {
        return opcionagregarflag;
    }

    public void setOpcionagregarflag(String opcionagregarflag) {
        this.opcionagregarflag = opcionagregarflag;
    }

    private String opcionmodificarflag;

    @Basic
    @javax.persistence.Column(name = "OPCIONMODIFICARFLAG")
    public String getOpcionmodificarflag() {
        return opcionmodificarflag;
    }

    public void setOpcionmodificarflag(String opcionmodificarflag) {
        this.opcionmodificarflag = opcionmodificarflag;
    }

    private String opcionborrarflag;

    @Basic
    @javax.persistence.Column(name = "OPCIONBORRARFLAG")
    public String getOpcionborrarflag() {
        return opcionborrarflag;
    }

    public void setOpcionborrarflag(String opcionborrarflag) {
        this.opcionborrarflag = opcionborrarflag;
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

    private String opcionaprobarflag;

    @Basic
    @javax.persistence.Column(name = "OPCIONAPROBARFLAG")
    public String getOpcionaprobarflag() {
        return opcionaprobarflag;
    }

    public void setOpcionaprobarflag(String opcionaprobarflag) {
        this.opcionaprobarflag = opcionaprobarflag;
    }

    private String opcionprocesarflag;

    @Basic
    @javax.persistence.Column(name = "OPCIONPROCESARFLAG")
    public String getOpcionprocesarflag() {
        return opcionprocesarflag;
    }

    public void setOpcionprocesarflag(String opcionprocesarflag) {
        this.opcionprocesarflag = opcionprocesarflag;
    }

    private String opcionopcion1Flag;

    @Basic
    @javax.persistence.Column(name = "OPCIONOPCION1FLAG")
    public String getOpcionopcion1Flag() {
        return opcionopcion1Flag;
    }

    public void setOpcionopcion1Flag(String opcionopcion1Flag) {
        this.opcionopcion1Flag = opcionopcion1Flag;
    }

    private String opcionopcion2Flag;

    @Basic
    @javax.persistence.Column(name = "OPCIONOPCION2FLAG")
    public String getOpcionopcion2Flag() {
        return opcionopcion2Flag;
    }

    public void setOpcionopcion2Flag(String opcionopcion2Flag) {
        this.opcionopcion2Flag = opcionopcion2Flag;
    }

    private String opcionopcion3Flag;

    @Basic
    @javax.persistence.Column(name = "OPCIONOPCION3FLAG")
    public String getOpcionopcion3Flag() {
        return opcionopcion3Flag;
    }

    public void setOpcionopcion3Flag(String opcionopcion3Flag) {
        this.opcionopcion3Flag = opcionopcion3Flag;
    }

    private String opcionopcion4Flag;

    @Basic
    @javax.persistence.Column(name = "OPCIONOPCION4FLAG")
    public String getOpcionopcion4Flag() {
        return opcionopcion4Flag;
    }

    public void setOpcionopcion4Flag(String opcionopcion4Flag) {
        this.opcionopcion4Flag = opcionopcion4Flag;
    }

    private String opcionopcion5Flag;

    @Basic
    @javax.persistence.Column(name = "OPCIONOPCION5FLAG")
    public String getOpcionopcion5Flag() {
        return opcionopcion5Flag;
    }

    public void setOpcionopcion5Flag(String opcionopcion5Flag) {
        this.opcionopcion5Flag = opcionopcion5Flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seguridadautorizaciones that = (Seguridadautorizaciones) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (opcionagregarflag != null ? !opcionagregarflag.equals(that.opcionagregarflag) : that.opcionagregarflag != null)
            return false;
        if (opcionmodificarflag != null ? !opcionmodificarflag.equals(that.opcionmodificarflag) : that.opcionmodificarflag != null)
            return false;
        if (opcionborrarflag != null ? !opcionborrarflag.equals(that.opcionborrarflag) : that.opcionborrarflag != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (opcionaprobarflag != null ? !opcionaprobarflag.equals(that.opcionaprobarflag) : that.opcionaprobarflag != null)
            return false;
        if (opcionprocesarflag != null ? !opcionprocesarflag.equals(that.opcionprocesarflag) : that.opcionprocesarflag != null)
            return false;
        if (opcionopcion1Flag != null ? !opcionopcion1Flag.equals(that.opcionopcion1Flag) : that.opcionopcion1Flag != null)
            return false;
        if (opcionopcion2Flag != null ? !opcionopcion2Flag.equals(that.opcionopcion2Flag) : that.opcionopcion2Flag != null)
            return false;
        if (opcionopcion3Flag != null ? !opcionopcion3Flag.equals(that.opcionopcion3Flag) : that.opcionopcion3Flag != null)
            return false;
        if (opcionopcion4Flag != null ? !opcionopcion4Flag.equals(that.opcionopcion4Flag) : that.opcionopcion4Flag != null)
            return false;
        if (opcionopcion5Flag != null ? !opcionopcion5Flag.equals(that.opcionopcion5Flag) : that.opcionopcion5Flag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (opcionagregarflag != null ? opcionagregarflag.hashCode() : 0);
        result = 31 * result + (opcionmodificarflag != null ? opcionmodificarflag.hashCode() : 0);
        result = 31 * result + (opcionborrarflag != null ? opcionborrarflag.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (opcionaprobarflag != null ? opcionaprobarflag.hashCode() : 0);
        result = 31 * result + (opcionprocesarflag != null ? opcionprocesarflag.hashCode() : 0);
        result = 31 * result + (opcionopcion1Flag != null ? opcionopcion1Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion2Flag != null ? opcionopcion2Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion3Flag != null ? opcionopcion3Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion4Flag != null ? opcionopcion4Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion5Flag != null ? opcionopcion5Flag.hashCode() : 0);
        return result;
    }
}
