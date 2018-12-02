package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@javax.persistence.Table(name = "SA_TIPOCURSO")
public class SaTipocurso  extends Entidad{
    private String tcucodigo;

    private String tcudescripcion;

    private Integer tcuestado;

    private Date tcufechacreacion;

    private Integer tcuflagasistenciaalu;

    private Integer tcuflagasistenciadoc;

    private Integer tcuflagenmalla;

    private Integer tcuflaghorario;

    private Integer tcuflagmatricula;

    private Integer tcuflagnota;

    private Integer tcuflagobligatorio;

    private String tcuipcreacion;

    private Integer tcutipocursoid;

    private Date tcuultimafechamodif;

    private String tcuultimoip;

    private Integer tcuultimousuario;

    private Integer tcuusuariocreacion;

   
    @Basic
    @javax.persistence.Column(name = "TCUCODIGO")
    public String getTcucodigo() {
        return tcucodigo;
    }

    @Basic
    @javax.persistence.Column(name = "TCUDESCRIPCION")
    public String getTcudescripcion() {
        return tcudescripcion;
    }

    @Basic
    @javax.persistence.Column(name = "TCUESTADO")
    public Integer getTcuestado() {
        return tcuestado;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFECHACREACION")
    public Date getTcufechacreacion() {
        return tcufechacreacion;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGASISTENCIAALU")
    public Integer getTcuflagasistenciaalu() {
        return tcuflagasistenciaalu;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGASISTENCIADOC")
    public Integer getTcuflagasistenciadoc() {
        return tcuflagasistenciadoc;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGENMALLA")
    public Integer getTcuflagenmalla() {
        return tcuflagenmalla;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGHORARIO")
    public Integer getTcuflaghorario() {
        return tcuflaghorario;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGMATRICULA")
    public Integer getTcuflagmatricula() {
        return tcuflagmatricula;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGNOTA")
    public Integer getTcuflagnota() {
        return tcuflagnota;
    }

    @Basic
    @javax.persistence.Column(name = "TCUFLAGOBLIGATORIO")
    public Integer getTcuflagobligatorio() {
        return tcuflagobligatorio;
    }

    @Basic
    @javax.persistence.Column(name = "TCUIPCREACION")
    public String getTcuipcreacion() {
        return tcuipcreacion;
    }

    @Id
    @javax.persistence.Column(name = "TCUTIPOCURSOID")
    public Integer getTcutipocursoid() {
        return tcutipocursoid;
    }

    @Basic
    @javax.persistence.Column(name = "TCUULTIMAFECHAMODIF")
    public Date getTcuultimafechamodif() {
        return tcuultimafechamodif;
    }

    @Basic
    @javax.persistence.Column(name = "TCUULTIMOIP")
    public String getTcuultimoip() {
        return tcuultimoip;
    }

    @Basic
    @javax.persistence.Column(name = "TCUULTIMOUSUARIO")
    public Integer getTcuultimousuario() {
        return tcuultimousuario;
    }

    @Basic
    @javax.persistence.Column(name = "TCUUSUARIOCREACION")
    public Integer getTcuusuariocreacion() {
        return tcuusuariocreacion;
    }

    @Override
    public int hashCode() {
        int result = (int) (tcutipocursoid ^ (tcutipocursoid >>> 32));
        result = 31 * result + (int) (tcuestado ^ (tcuestado >>> 32));
        result = 31 * result + (tcucodigo != null ? tcucodigo.hashCode() : 0);
        result = 31 * result + (tcudescripcion != null ? tcudescripcion.hashCode() : 0);
        result = 31 * result + (int) (tcuflagobligatorio ^ (tcuflagobligatorio >>> 32));
        result = 31 * result + (tcuflagenmalla != null ? tcuflagenmalla.hashCode() : 0);
        result = 31 * result + (int) (tcuflagmatricula ^ (tcuflagmatricula >>> 32));
        result = 31 * result + (int) (tcuflaghorario ^ (tcuflaghorario >>> 32));
        result = 31 * result + (int) (tcuflagasistenciadoc ^ (tcuflagasistenciadoc >>> 32));
        result = 31 * result + (int) (tcuflagasistenciaalu ^ (tcuflagasistenciaalu >>> 32));
        result = 31 * result + (int) (tcuflagnota ^ (tcuflagnota >>> 32));
        result = 31 * result + (tcuusuariocreacion != null ? tcuusuariocreacion.hashCode() : 0);
        result = 31 * result + (tcufechacreacion != null ? tcufechacreacion.hashCode() : 0);
        result = 31 * result + (tcuipcreacion != null ? tcuipcreacion.hashCode() : 0);
        result = 31 * result + (tcuultimousuario != null ? tcuultimousuario.hashCode() : 0);
        result = 31 * result + (tcuultimafechamodif != null ? tcuultimafechamodif.hashCode() : 0);
        result = 31 * result + (tcuultimoip != null ? tcuultimoip.hashCode() : 0);
        return result;
    }

    public void setTcucodigo(String tcucodigo) {
        this.tcucodigo = tcucodigo;
    }

    public void setTcudescripcion(String tcudescripcion) {
        this.tcudescripcion = tcudescripcion;
    }

    public void setTcuestado(Integer tcuestado) {
        this.tcuestado = tcuestado;
    }

    public void setTcufechacreacion(Date tcufechacreacion) {
        this.tcufechacreacion = tcufechacreacion;
    }

    public void setTcuflagasistenciaalu(Integer tcuflagasistenciaalu) {
        this.tcuflagasistenciaalu = tcuflagasistenciaalu;
    }

    public void setTcuflagasistenciadoc(Integer tcuflagasistenciadoc) {
        this.tcuflagasistenciadoc = tcuflagasistenciadoc;
    }

    public void setTcuflagenmalla(Integer tcuflagenmalla) {
        this.tcuflagenmalla = tcuflagenmalla;
    }

    public void setTcuflaghorario(Integer tcuflaghorario) {
        this.tcuflaghorario = tcuflaghorario;
    }

    public void setTcuflagmatricula(Integer tcuflagmatricula) {
        this.tcuflagmatricula = tcuflagmatricula;
    }

    public void setTcuflagnota(Integer tcuflagnota) {
        this.tcuflagnota = tcuflagnota;
    }

    public void setTcuflagobligatorio(Integer tcuflagobligatorio) {
        this.tcuflagobligatorio = tcuflagobligatorio;
    }

    public void setTcuipcreacion(String tcuipcreacion) {
        this.tcuipcreacion = tcuipcreacion;
    }

    public void setTcutipocursoid(Integer tcutipocursoid) {
        this.tcutipocursoid = tcutipocursoid;
    }

    public void setTcuultimafechamodif(Date tcuultimafechamodif) {
        this.tcuultimafechamodif = tcuultimafechamodif;
    }

    public void setTcuultimoip(String tcuultimoip) {
        this.tcuultimoip = tcuultimoip;
    }

    public void setTcuultimousuario(Integer tcuultimousuario) {
        this.tcuultimousuario = tcuultimousuario;
    }

    public void setTcuusuariocreacion(Integer tcuusuariocreacion) {
        this.tcuusuariocreacion = tcuusuariocreacion;
    }
}
