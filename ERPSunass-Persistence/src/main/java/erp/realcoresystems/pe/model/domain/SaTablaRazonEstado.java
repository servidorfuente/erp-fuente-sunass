package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TABLARAZONESTADO")
@IdClass(SaTablaRazonEstadoPK.class)
public class SaTablaRazonEstado {
	
    private Integer tabtablaid;
    private Integer tbsestadoenlaceid;
    private Integer tbrrazon;
    private String tbrdescripcion;
    private Integer tbrusuariocreacion;
    private Date tbrfechacreacion;
    private String tbripcreacion;
    private Integer tbrultimousuario;
    private Date tbrultimafechamodif;
    private String tbrultimoip;
    private SaTablaEstado saTablaestado;

    @Id
    @Column(name = "TABTABLAID")
    public Integer getTabtablaid() {
        return tabtablaid;
    }

    public void setTabtablaid(Integer tabtablaid) {
        this.tabtablaid = tabtablaid;
    }

    @Id
    @Column(name = "TBSESTADOENLACEID")
    public Integer getTbsestadoenlaceid() {
        return tbsestadoenlaceid;
    }

    public void setTbsestadoenlaceid(Integer tbsestadoenlaceid) {
        this.tbsestadoenlaceid = tbsestadoenlaceid;
    }

    @Id
    @Column(name = "TBRRAZON")
    public Integer getTbrrazon() {
        return tbrrazon;
    }

    public void setTbrrazon(Integer tbrrazon) {
        this.tbrrazon = tbrrazon;
    }

    @Basic
    @Column(name = "TBRDESCRIPCION")
    public String getTbrdescripcion() {
        return tbrdescripcion;
    }

    public void setTbrdescripcion(String tbrdescripcion) {
        this.tbrdescripcion = tbrdescripcion;
    }

    @Basic
    @Column(name = "TBRUSUARIOCREACION")
    public Integer getTbrusuariocreacion() {
        return tbrusuariocreacion;
    }

    public void setTbrusuariocreacion(Integer tbrusuariocreacion) {
        this.tbrusuariocreacion = tbrusuariocreacion;
    }

    @Basic
    @Column(name = "TBRFECHACREACION")
    public Date getTbrfechacreacion() {
        return tbrfechacreacion;
    }

    public void setTbrfechacreacion(Date tbrfechacreacion) {
        this.tbrfechacreacion = tbrfechacreacion;
    }

    @Basic
    @Column(name = "TBRIPCREACION")
    public String getTbripcreacion() {
        return tbripcreacion;
    }

    public void setTbripcreacion(String tbripcreacion) {
        this.tbripcreacion = tbripcreacion;
    }

    @Basic
    @Column(name = "TBRULTIMOUSUARIO")
    public Integer getTbrultimousuario() {
        return tbrultimousuario;
    }

    public void setTbrultimousuario(Integer tbrultimousuario) {
        this.tbrultimousuario = tbrultimousuario;
    }

    @Basic
    @Column(name = "TBRULTIMAFECHAMODIF")
    public Date getTbrultimafechamodif() {
        return tbrultimafechamodif;
    }

    public void setTbrultimafechamodif(Date tbrultimafechamodif) {
        this.tbrultimafechamodif = tbrultimafechamodif;
    }

    @Basic
    @Column(name = "TBRULTIMOIP")
    public String getTbrultimoip() {
        return tbrultimoip;
    }

    public void setTbrultimoip(String tbrultimoip) {
        this.tbrultimoip = tbrultimoip;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "TABTABLAID", referencedColumnName = "TABTABLAID", nullable = false,insertable=false, updatable=false), 
    	@JoinColumn(name = "TBSESTADOENLACEID", referencedColumnName = "TBSESTADOENLACEID", nullable = false,insertable=false, updatable=false)})
    public SaTablaEstado getSaTablaestado() {
        return saTablaestado;
    }

    public void setSaTablaestado(SaTablaEstado saTablaestado) {
        this.saTablaestado = saTablaestado;
    }
}
