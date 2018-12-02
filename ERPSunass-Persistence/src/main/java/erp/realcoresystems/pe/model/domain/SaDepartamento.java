package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name = "SA_DPTO")
public class SaDepartamento implements Serializable{

	private static final long serialVersionUID = 1L;
    private String dptcodigo;
    private String paicodigo;
    private String dptdescripcion;
    private Integer dptestado;
    private Integer dptusuariocreacion;
    private Date dptfechacreacion;
    private String dptipcreacion;
    private Integer dptultimousuario;
    private Date dptultimafechamodif;
    private String dptultimoip;

    @Id
    @Basic
    @Column(name = "DPTCODIGO")
    public String getDptcodigo() {
        return dptcodigo;
    }

    public void setDptcodigo(String dptcodigo) {
        this.dptcodigo = dptcodigo;
    }

    @Basic
    @Column(name = "PAICODIGO")
    public String getPaicodigo() {
        return paicodigo;
    }

    public void setPaicodigo(String paicodigo) {
        this.paicodigo = paicodigo;
    }
    
    @Basic
    @Column(name = "DPTESTADO")
    public Integer getDptestado() {
        return dptestado;
    }

    public void setDptestado(Integer dptestado) {
        this.dptestado = dptestado;
    }

    @Basic
    @Column(name = "DPTDESCRIPCION")
    public String getDptdescripcion() {
        return dptdescripcion;
    }

    public void setDptdescripcion(String dptdescripcion) {
        this.dptdescripcion = dptdescripcion;
    }

    @Basic
    @Column(name = "DPTUSUARIOCREACION")
    public Integer getDptusuariocreacion() {
        return dptusuariocreacion;
    }

    public void setDptusuariocreacion(Integer dptusuariocreacion) {
        this.dptusuariocreacion = dptusuariocreacion;
    }

    @Basic
    @Column(name = "DPTFECHACREACION")
    public Date getDptfechacreacion() {
        return dptfechacreacion;
    }

    public void setDptfechacreacion(Date dptfechacreacion) {
        this.dptfechacreacion = dptfechacreacion;
    }

    @Basic
    @Column(name = "DPTIPCREACION")
    public String getDptipcreacion() {
        return dptipcreacion;
    }

    public void setDptipcreacion(String dptipcreacion) {
        this.dptipcreacion = dptipcreacion;
    }

    @Basic
    @Column(name = "DPTULTIMOUSUARIO")
    public Integer getDptultimousuario() {
        return dptultimousuario;
    }

    public void setDptultimousuario(Integer dptultimousuario) {
        this.dptultimousuario = dptultimousuario;
    }

    @Basic
    @Column(name = "DPTULTIMAFECHAMODIF")
    public Date getDptultimafechamodif() {
        return dptultimafechamodif;
    }

    public void setDptultimafechamodif(Date dptultimafechamodif) {
        this.dptultimafechamodif = dptultimafechamodif;
    }

    @Basic
    @Column(name = "DPTULTIMOIP")
    public String getDptultimoip() {
        return dptultimoip;
    }

    public void setDptultimoip(String dptultimoip) {
        this.dptultimoip = dptultimoip;
    }
}
