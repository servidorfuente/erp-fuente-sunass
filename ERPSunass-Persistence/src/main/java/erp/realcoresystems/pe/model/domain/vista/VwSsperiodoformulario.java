package erp.realcoresystems.pe.model.domain.vista;

import erp.realcoresystems.pe.model.domain.Entidad;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VW_SSPERIODOFORMULARIO")
public class VwSsperiodoformulario extends Entidad {
    private String companyowner;
    private Integer ffanno;
    private String ffestado;
    private Integer secuencia;
    private String ffdescripcion;
    private String tipofrecuencia;
    private Integer mes;
    private Date fechainicio;
    private Date fechafin;
    private String sucursal;
    private Integer sectorid;
    private String descripcion;
    private Integer estadodocumento;
    private String estado;
    private Integer formularioid;
    private Integer frgrupo;

    @Id
    @Basic
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }
    @Id
    @Basic
    @Column(name = "FFANNO")
    public Integer getFfanno() {
        return ffanno;
    }

    public void setFfanno(Integer ffanno) {
        this.ffanno = ffanno;
    }

    @Basic
    @Column(name = "FFESTADO")
    public String getFfestado() {
        return ffestado;
    }

    public void setFfestado(String ffestado) {
        this.ffestado = ffestado;
    }
    @Id
    @Basic
    @Column(name = "SECUENCIA")
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Basic
    @Column(name = "FFDESCRIPCION")
    public String getFfdescripcion() {
        return ffdescripcion;
    }

    public void setFfdescripcion(String ffdescripcion) {
        this.ffdescripcion = ffdescripcion;
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
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
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
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Basic
    @Column(name = "FORMULARIOID")
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
    }

    @Basic
    @Column(name = "FRGRUPO")
    public Integer getFrgrupo() {
        return frgrupo;
    }

    public void setFrgrupo(Integer frgrupo) {
        this.frgrupo = frgrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwSsperiodoformulario that = (VwSsperiodoformulario) o;

        if (ffanno != that.ffanno) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (ffestado != null ? !ffestado.equals(that.ffestado) : that.ffestado != null) return false;
        if (ffdescripcion != null ? !ffdescripcion.equals(that.ffdescripcion) : that.ffdescripcion != null)
            return false;
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
        result = 31 * result + (ffestado != null ? ffestado.hashCode() : 0);
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        result = 31 * result + (ffdescripcion != null ? ffdescripcion.hashCode() : 0);
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
