package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "SS_PERIODOFORMULARIODETALLE")
@IdClass(SsPeriodoformulariodetallePK.class)
public class SsPeriodoformulariodetalle   extends Entidad {
    private String companyowner;
    private long ffanno;
    private long secuencia;
    private String tipofrecuencia;
    private Long mes;
    private Time fechainicio;
    private Time fechafin;
    private String sucursal;
    private Long sectorid;
    private String descripcion;
    private Long estadodocumento;
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
    @Column(name = "FFANNO")
    public long getFfanno() {
        return ffanno;
    }

    public void setFfanno(long ffanno) {
        this.ffanno = ffanno;
    }

    @Id
    @Column(name = "SECUENCIA")
    public long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(long secuencia) {
        this.secuencia = secuencia;
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
    @Column(name = "MES")
    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "FECHAINICIO")
    public Time getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Time fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Basic
    @Column(name = "FECHAFIN")
    public Time getFechafin() {
        return fechafin;
    }

    public void setFechafin(Time fechafin) {
        this.fechafin = fechafin;
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
    @Column(name = "SECTORID")
    public Long getSectorid() {
        return sectorid;
    }

    public void setSectorid(Long sectorid) {
        this.sectorid = sectorid;
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
    @Column(name = "ESTADODOCUMENTO")
    public Long getEstadodocumento() {
        return estadodocumento;
    }

    public void setEstadodocumento(Long estadodocumento) {
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

        SsPeriodoformulariodetalle that = (SsPeriodoformulariodetalle) o;

        if (ffanno != that.ffanno) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (tipofrecuencia != null ? !tipofrecuencia.equals(that.tipofrecuencia) : that.tipofrecuencia != null)
            return false;
        if (mes != null ? !mes.equals(that.mes) : that.mes != null) return false;
        if (fechainicio != null ? !fechainicio.equals(that.fechainicio) : that.fechainicio != null) return false;
        if (fechafin != null ? !fechafin.equals(that.fechafin) : that.fechafin != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (sectorid != null ? !sectorid.equals(that.sectorid) : that.sectorid != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (estadodocumento != null ? !estadodocumento.equals(that.estadodocumento) : that.estadodocumento != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (int) (ffanno ^ (ffanno >>> 32));
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        result = 31 * result + (tipofrecuencia != null ? tipofrecuencia.hashCode() : 0);
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (fechainicio != null ? fechainicio.hashCode() : 0);
        result = 31 * result + (fechafin != null ? fechafin.hashCode() : 0);
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (sectorid != null ? sectorid.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estadodocumento != null ? estadodocumento.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
