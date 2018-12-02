package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "SA_TIPODOCID")
public class SaTipoDocumentoIdentidad extends Entidad implements Serializable{
	
    private Integer tditipodocid;
    private Integer tdiestado;
    private String tdicodigo;
    private String tdidescripcion;
    private Integer tdinumerocaracteres;
    private String tdiformatoedicion;
    private Integer tdiusuariocreacion;
    private Date tdifechacreacion;
    private String tdiipcreacion;
    private Integer tdiultimousuario;
    private Date tdiultimafechamodif;
    private String tdiultimoip;
    private String tdicodigoexterno;
    private String tdidescripcioncorta;

    @Id
    @Column(name = "TDITIPODOCID")
    public Integer getTditipodocid() {
        return tditipodocid;
    }

    public void setTditipodocid(Integer tditipodocid) {
        this.tditipodocid = tditipodocid;
    }

    @Basic
    @Column(name = "TDIESTADO")
    public Integer getTdiestado() {
        return tdiestado;
    }

    public void setTdiestado(Integer tdiestado) {
        this.tdiestado = tdiestado;
    }

    @Basic
    @Column(name = "TDICODIGO")
    public String getTdicodigo() {
        return tdicodigo;
    }

    public void setTdicodigo(String tdicodigo) {
        this.tdicodigo = tdicodigo;
    }

    @Basic
    @Column(name = "TDIDESCRIPCION")
    public String getTdidescripcion() {
        return tdidescripcion;
    }

    public void setTdidescripcion(String tdidescripcion) {
        this.tdidescripcion = tdidescripcion;
    }

    @Basic
    @Column(name = "TDINUMEROCARACTERES")
    public Integer getTdinumerocaracteres() {
        return tdinumerocaracteres;
    }

    public void setTdinumerocaracteres(Integer tdinumerocaracteres) {
        this.tdinumerocaracteres = tdinumerocaracteres;
    }

    @Basic
    @Column(name = "TDIFORMATOEDICION")
    public String getTdiformatoedicion() {
        return tdiformatoedicion;
    }

    public void setTdiformatoedicion(String tdiformatoedicion) {
        this.tdiformatoedicion = tdiformatoedicion;
    }

    @Basic
    @Column(name = "TDIUSUARIOCREACION")
    public Integer getTdiusuariocreacion() {
        return tdiusuariocreacion;
    }

    public void setTdiusuariocreacion(Integer tdiusuariocreacion) {
        this.tdiusuariocreacion = tdiusuariocreacion;
    }

    @Basic
    @Column(name = "TDIFECHACREACION")
    public Date getTdifechacreacion() {
        return tdifechacreacion;
    }

    public void setTdifechacreacion(Date tdifechacreacion) {
        this.tdifechacreacion = tdifechacreacion;
    }

    @Basic
    @Column(name = "TDIIPCREACION")
    public String getTdiipcreacion() {
        return tdiipcreacion;
    }

    public void setTdiipcreacion(String tdiipcreacion) {
        this.tdiipcreacion = tdiipcreacion;
    }

    @Basic
    @Column(name = "TDIULTIMOUSUARIO")
    public Integer getTdiultimousuario() {
        return tdiultimousuario;
    }

    public void setTdiultimousuario(Integer tdiultimousuario) {
        this.tdiultimousuario = tdiultimousuario;
    }

    @Basic
    @Column(name = "TDIULTIMAFECHAMODIF")
    public Date getTdiultimafechamodif() {
        return tdiultimafechamodif;
    }

    public void setTdiultimafechamodif(Date tdiultimafechamodif) {
        this.tdiultimafechamodif = tdiultimafechamodif;
    }

    @Basic
    @Column(name = "TDIULTIMOIP")
    public String getTdiultimoip() {
        return tdiultimoip;
    }

    public void setTdiultimoip(String tdiultimoip) {
        this.tdiultimoip = tdiultimoip;
    }

    @Basic
    @Column(name = "TDICODIGOEXTERNO")
    public String getTdicodigoexterno() {
        return tdicodigoexterno;
    }

    public void setTdicodigoexterno(String tdicodigoexterno) {
        this.tdicodigoexterno = tdicodigoexterno;
    }

    @Basic
    @Column(name = "TDIDESCRIPCIONCORTA")
    public String getTdidescripcioncorta() {
        return tdidescripcioncorta;
    }

    public void setTdidescripcioncorta(String tdidescripcioncorta) {
        this.tdidescripcioncorta = tdidescripcioncorta;
    }
}
