package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name = "SA_PROVINCIA")
public class SaProvincia implements Serializable{

	private static final long serialVersionUID = 1L;
    private String paicodigo;
	private String dptcodigo;
    private String prvcodigo;
    private Integer prvestado;
    private String prvdescripcion;
    private Integer prvusuariocreacion;
    private Date prvfechacreacion;
    private String prvipcreacion;
    private Integer prvultimousuario;
    private Date prvultimafechamodif;
    private String prvultimoip;

    @Id
    @Basic
    @Column(name = "PRVCODIGO")
    public String getPrvcodigo() {
        return prvcodigo;
    }

    public void setPrvcodigo(String prvcodigo) {
        this.prvcodigo = prvcodigo;
    }
    
    @Column(name = "DPTCODIGO")
    public String getDptcodigo() {
        return dptcodigo;
    }

    public void setDptcodigo(String dptcodigo) {
        this.dptcodigo = dptcodigo;
    }

    @Basic
    @Column(name = "PRVESTADO")
    public Integer getPrvestado() {
        return prvestado;
    }

    public void setPrvestado(Integer prvestado) {
        this.prvestado = prvestado;
    }

    @Basic
    @Column(name = "PRVDESCRIPCION")
    public String getPrvdescripcion() {
        return prvdescripcion;
    }

    public void setPrvdescripcion(String prvdescripcion) {
        this.prvdescripcion = prvdescripcion;
    }

    @Basic
    @Column(name = "PRVUSUARIOCREACION")
    public Integer getPrvusuariocreacion() {
        return prvusuariocreacion;
    }

    public void setPrvusuariocreacion(Integer prvusuariocreacion) {
        this.prvusuariocreacion = prvusuariocreacion;
    }

    @Basic
    @Column(name = "PRVFECHACREACION")
    public Date getPrvfechacreacion() {
        return prvfechacreacion;
    }

    public void setPrvfechacreacion(Date prvfechacreacion) {
        this.prvfechacreacion = prvfechacreacion;
    }

    @Basic
    @Column(name = "PRVIPCREACION")
    public String getPrvipcreacion() {
        return prvipcreacion;
    }

    public void setPrvipcreacion(String prvipcreacion) {
        this.prvipcreacion = prvipcreacion;
    }

    @Basic
    @Column(name = "PRVULTIMOUSUARIO")
    public Integer getPrvultimousuario() {
        return prvultimousuario;
    }

    public void setPrvultimousuario(Integer prvultimousuario) {
        this.prvultimousuario = prvultimousuario;
    }

    @Basic
    @Column(name = "PRVULTIMAFECHAMODIF")
    public Date getPrvultimafechamodif() {
        return prvultimafechamodif;
    }

    public void setPrvultimafechamodif(Date prvultimafechamodif) {
        this.prvultimafechamodif = prvultimafechamodif;
    }

    @Basic
    @Column(name = "PRVULTIMOIP")
    public String getPrvultimoip() {
        return prvultimoip;
    }

    public void setPrvultimoip(String prvultimoip) {
        this.prvultimoip = prvultimoip;
    }

    @Basic
    @Column(name = "PAICODIGO")
    public String getPaicodigo() {
        return paicodigo;
    }

    public void setPaicodigo(String paicodigo) {
        this.paicodigo = paicodigo;
    }
}
