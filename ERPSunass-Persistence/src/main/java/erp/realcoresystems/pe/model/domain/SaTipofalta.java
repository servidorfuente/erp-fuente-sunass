package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOFALTA")
public class SaTipofalta extends Entidad{
    private Integer tfatipofaltaid;
    private Integer tfaestado;
    private String tfacodigo;
    private String tfadescripcion;
    private Integer tfausuariocreacion;
    private Date tfafechacreacion;
    private String tfaipcreacion;
    private Integer tfaultimousuario;
    private Date tfaultimafechamodif;
    private String tfaultimoip;

    @Id
    @Column(name = "TFATIPOFALTAID")
    public Integer getTfatipofaltaid() {
        return tfatipofaltaid;
    }

    public void setTfatipofaltaid(Integer tfatipofaltaid) {
        this.tfatipofaltaid = tfatipofaltaid;
    }

    @Basic
    @Column(name = "TFAESTADO")
    public Integer getTfaestado() {
        return tfaestado;
    }

    public void setTfaestado(Integer tfaestado) {
        this.tfaestado = tfaestado;
    }

    @Basic
    @Column(name = "TFACODIGO")
    public String getTfacodigo() {
        return tfacodigo;
    }

    public void setTfacodigo(String tfacodigo) {
        this.tfacodigo = tfacodigo;
    }

    @Basic
    @Column(name = "TFADESCRIPCION")
    public String getTfadescripcion() {
        return tfadescripcion;
    }

    public void setTfadescripcion(String tfadescripcion) {
        this.tfadescripcion = tfadescripcion;
    }

    @Basic
    @Column(name = "TFAUSUARIOCREACION")
    public Integer getTfausuariocreacion() {
        return tfausuariocreacion;
    }

    public void setTfausuariocreacion(Integer tfausuariocreacion) {
        this.tfausuariocreacion = tfausuariocreacion;
    }

    @Basic
    @Column(name = "TFAFECHACREACION")
    public Date getTfafechacreacion() {
        return tfafechacreacion;
    }

    public void setTfafechacreacion(Date tfafechacreacion) {
        this.tfafechacreacion = tfafechacreacion;
    }

    @Basic
    @Column(name = "TFAIPCREACION")
    public String getTfaipcreacion() {
        return tfaipcreacion;
    }

    public void setTfaipcreacion(String tfaipcreacion) {
        this.tfaipcreacion = tfaipcreacion;
    }

    @Basic
    @Column(name = "TFAULTIMOUSUARIO")
    public Integer getTfaultimousuario() {
        return tfaultimousuario;
    }

    public void setTfaultimousuario(Integer tfaultimousuario) {
        this.tfaultimousuario = tfaultimousuario;
    }

    @Basic
    @Column(name = "TFAULTIMAFECHAMODIF")
    public Date getTfaultimafechamodif() {
        return tfaultimafechamodif;
    }

    public void setTfaultimafechamodif(Date tfaultimafechamodif) {
        this.tfaultimafechamodif = tfaultimafechamodif;
    }

    @Basic
    @Column(name = "TFAULTIMOIP")
    public String getTfaultimoip() {
        return tfaultimoip;
    }

    public void setTfaultimoip(String tfaultimoip) {
        this.tfaultimoip = tfaultimoip;
    }
}
