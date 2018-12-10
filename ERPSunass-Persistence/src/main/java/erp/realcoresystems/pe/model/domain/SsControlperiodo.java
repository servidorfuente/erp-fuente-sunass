package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "SS_CONTROLPERIODO")
@IdClass(SsControlperiodoPK.class)
public class SsControlperiodo  extends Entidad{
    private String companyowner;
    private String tipooperacion;
    private Integer anno;
    private Integer formularioid;
    private Integer secuencia;
    private String sucursal;
    private String tipofrecuencia;
    private String periodo;
    private Integer mes;
    private Date fechainicio;
    private Date fechafin;
    private String descripcion;
    private String observaciones;
    private Integer proyectoid;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;
    private Integer flagmodoformulario;
    private Integer flagmodocargainicial;
    private Integer estadodocumento;
    private String estado;

    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "TIPOOPERACION")
    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    @Id
    @Column(name = "ANNO")
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Id
    @Column(name = "FORMULARIOID")
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
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
    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Basic
    @Column(name = "FECHAFIN")
    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsControlperiodo that = (SsControlperiodo) o;

        if (anno != that.anno) return false;
        if (formularioid != that.formularioid) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (tipooperacion != null ? !tipooperacion.equals(that.tipooperacion) : that.tipooperacion != null)
            return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (tipofrecuencia != null ? !tipofrecuencia.equals(that.tipofrecuencia) : that.tipofrecuencia != null)
            return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;
        if (mes != null ? !mes.equals(that.mes) : that.mes != null) return false;
        if (fechainicio != null ? !fechainicio.equals(that.fechainicio) : that.fechainicio != null) return false;
        if (fechafin != null ? !fechafin.equals(that.fechafin) : that.fechafin != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;
        if (proyectoid != null ? !proyectoid.equals(that.proyectoid) : that.proyectoid != null) return false;
        if (creacionusuario != null ? !creacionusuario.equals(that.creacionusuario) : that.creacionusuario != null)
            return false;
        if (creacionfecha != null ? !creacionfecha.equals(that.creacionfecha) : that.creacionfecha != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (flagmodoformulario != null ? !flagmodoformulario.equals(that.flagmodoformulario) : that.flagmodoformulario != null)
            return false;
        if (flagmodocargainicial != null ? !flagmodocargainicial.equals(that.flagmodocargainicial) : that.flagmodocargainicial != null)
            return false;
        if (estadodocumento != null ? !estadodocumento.equals(that.estadodocumento) : that.estadodocumento != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (tipooperacion != null ? tipooperacion.hashCode() : 0);
        result = 31 * result + (int) (anno ^ (anno >>> 32));
        result = 31 * result + (int) (formularioid ^ (formularioid >>> 32));
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (tipofrecuencia != null ? tipofrecuencia.hashCode() : 0);
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (fechainicio != null ? fechainicio.hashCode() : 0);
        result = 31 * result + (fechafin != null ? fechafin.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (proyectoid != null ? proyectoid.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (flagmodoformulario != null ? flagmodoformulario.hashCode() : 0);
        result = 31 * result + (flagmodocargainicial != null ? flagmodocargainicial.hashCode() : 0);
        result = 31 * result + (estadodocumento != null ? estadodocumento.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
