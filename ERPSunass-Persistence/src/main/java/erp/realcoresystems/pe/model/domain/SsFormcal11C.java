package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SS_FORMCAL11C")
@IdClass(SsFormcal11CPK.class)
public class SsFormcal11C  extends Entidad{
    private String companyowner;
    private String sucursal;
    private String tipofrecuencia;
    private Integer ffanno;
    private String periodo;
    private Integer secuencia;
    private Integer mes;
    private Date fecha;
    private Integer sectorid;
    private Integer proyectoid;
    private String cmueGrupo;
    private String cmueCodigo;
    private String nmuePoblserv;
    private Integer cmueEstadodocumento;
    private String cmueEstado;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;


    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Id
    @Column(name = "TIPOFRECUENCIA")
    public String getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(String tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
    }

    @Id
    @Column(name = "FFANNO")
    public Integer getFfanno() {
        return ffanno;
    }

    public void setFfanno(Integer ffanno) {
        this.ffanno = ffanno;
    }

    @Id
    @Column(name = "PERIODO")
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Id
    @Column(name = "SECUENCIA")
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Basic
    @Column(name = "MES")
    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "SECTORID")
    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    @Basic
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Basic
    @Column(name = "CMUE_GRUPO")
    public String getCmueGrupo() {
        return cmueGrupo;
    }

    public void setCmueGrupo(String cmueGrupo) {
        this.cmueGrupo = cmueGrupo;
    }

    @Basic
    @Column(name = "CMUE_CODIGO")
    public String getCmueCodigo() {
        return cmueCodigo;
    }

    public void setCmueCodigo(String cmueCodigo) {
        this.cmueCodigo = cmueCodigo;
    }

    @Basic
    @Column(name = "NMUE_POBLSERV")
    public String getNmuePoblserv() {
        return nmuePoblserv;
    }

    public void setNmuePoblserv(String nmuePoblserv) {
        this.nmuePoblserv = nmuePoblserv;
    }

    @Basic
    @Column(name = "CMUE_ESTADODOCUMENTO")
    public Integer getCmueEstadodocumento() {
        return cmueEstadodocumento;
    }

    public void setCmueEstadodocumento(Integer cmueEstadodocumento) {
        this.cmueEstadodocumento = cmueEstadodocumento;
    }

    @Basic
    @Column(name = "CMUE_ESTADO")
    public String getCmueEstado() {
        return cmueEstado;
    }

    public void setCmueEstado(String cmueEstado) {
        this.cmueEstado = cmueEstado;
    }
    @Basic
    @Column(name = "CREACIONUSUARIO")
    public String getCreacionusuario() {
        return creacionusuario;
    }

    public void setCreacionusuario(String creacionusuario) {
        this.creacionusuario = creacionusuario;
    }

    @Basic
    @Column(name = "CREACIONFECHA")
    public Date getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date creacionfecha) {
        this.creacionfecha = creacionfecha;
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


}
