package erp.realcoresystems.pe.model.domain.vista;

import erp.realcoresystems.pe.model.domain.Entidad;

import javax.persistence.*;
import java.sql.Date  ;

@Entity
@Table(name = "VW_CONTROLPERIODO")
public class VwControlperiodo extends Entidad {
    private Integer idcontador;
    private String companyowner;
    private String description;
    private String tipooperacion;
    private Integer anno;
    private Integer formularioid;
    private String frdescripcion;
    private Integer secuencia;
    private String sucursal;
    private String tipofrecuencia;
    private String periodo;
    private Integer mes;
    private Date   fechainicio;
    private Date   fechafin;
    private String descripcion;
    private String observaciones;
    private Integer proyectoid;
    private String creacionusuario;
    private Date   creacionfecha;
    private String ultimousuario;
    private Date   ultimafechamodif;
    private Integer flagmodoformulario;
    private Integer flagmodocargainicial;
    private Integer estadodocumento;
    private String estado;

    @Basic
    @Column(name = "IDCONTADOR")
    public Integer getIdcontador() {
        return idcontador;
    }

    public void setIdcontador(Integer idcontador) {
        this.idcontador = idcontador;
    }

    @Id
    @Basic
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "TIPOOPERACION")
    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    @Basic
    @Column(name = "ANNO")
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Basic
    @Column(name = "FORMULARIOID")
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
    }

    @Basic
    @Column(name = "FRDESCRIPCION")
    public String getFrdescripcion() {
        return frdescripcion;
    }

    public void setFrdescripcion(String frdescripcion) {
        this.frdescripcion = frdescripcion;
    }

    @Basic
    @Column(name = "SECUENCIA")
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Basic
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Basic
    @Column(name = "TIPOFRECUENCIA")
    public String getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(String tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
    }

    @Basic
    @Column(name = "PERIODO")
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
    @Column(name = "FECHAINICIO")
    public Date   getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date   fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Basic
    @Column(name = "FECHAFIN")
    public Date   getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date   fechafin) {
        this.fechafin = fechafin;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    @Column(name = "CREACIONUSUARIO")
    public String getCreacionusuario() {
        return creacionusuario;
    }

    public void setCreacionusuario(String creacionusuario) {
        this.creacionusuario = creacionusuario;
    }

    @Basic
    @Column(name = "CREACIONFECHA")
    public Date   getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date   creacionfecha) {
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
    public Date   getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date   ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @Column(name = "FLAGMODOFORMULARIO")
    public Integer getFlagmodoformulario() {
        return flagmodoformulario;
    }

    public void setFlagmodoformulario(Integer flagmodoformulario) {
        this.flagmodoformulario = flagmodoformulario;
    }

    @Basic
    @Column(name = "FLAGMODOCARGAINICIAL")
    public Integer getFlagmodocargainicial() {
        return flagmodocargainicial;
    }

    public void setFlagmodocargainicial(Integer flagmodocargainicial) {
        this.flagmodocargainicial = flagmodocargainicial;
    }

    @Basic
    @Column(name = "ESTADODOCUMENTO")
    public Integer getEstadodocumento() {
        return estadodocumento;
    }

    public void setEstadodocumento(Integer estadodocumento) {
        this.estadodocumento = estadodocumento;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
