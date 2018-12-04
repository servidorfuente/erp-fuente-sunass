package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TABLASCONCEPTOS")
@IdClass(SaTablasconceptosPK.class)
public class SaTablasconceptos  extends Entidad{
    private String aplicacioncodigo;
    private String grupo;
    private String concepto;
    private BigDecimal idtabla;
    private Date fechacreacion;
    private String usuariocreacion;
    private String usuariomodificacion;
    private Date fechamodificacion;
    private SaTablas saTablasByIdtabla;

    @Id
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Id
    @Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Id
    @Column(name = "CONCEPTO")
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Basic
    @Column(name = "IDTABLA")
    public BigDecimal getIdtabla() {
        return idtabla;
    }

    public void setIdtabla(BigDecimal idtabla) {
        this.idtabla = idtabla;
    }

    @Basic
    @Column(name = "FECHACREACION")
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "USUARIOCREACION")
    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    @Basic
    @Column(name = "USUARIOMODIFICACION")
    public String getUsuariomodificacion() {
        return usuariomodificacion;
    }

    public void setUsuariomodificacion(String usuariomodificacion) {
        this.usuariomodificacion = usuariomodificacion;
    }

    @Basic
    @Column(name = "FECHAMODIFICACION")
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTablasconceptos that = (SaTablasconceptos) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;
        if (idtabla != null ? !idtabla.equals(that.idtabla) : that.idtabla != null) return false;
        if (fechacreacion != null ? !fechacreacion.equals(that.fechacreacion) : that.fechacreacion != null)
            return false;
        if (usuariocreacion != null ? !usuariocreacion.equals(that.usuariocreacion) : that.usuariocreacion != null)
            return false;
        if (usuariomodificacion != null ? !usuariomodificacion.equals(that.usuariomodificacion) : that.usuariomodificacion != null)
            return false;
        if (fechamodificacion != null ? !fechamodificacion.equals(that.fechamodificacion) : that.fechamodificacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + (idtabla != null ? idtabla.hashCode() : 0);
        result = 31 * result + (fechacreacion != null ? fechacreacion.hashCode() : 0);
        result = 31 * result + (usuariocreacion != null ? usuariocreacion.hashCode() : 0);
        result = 31 * result + (usuariomodificacion != null ? usuariomodificacion.hashCode() : 0);
        result = 31 * result + (fechamodificacion != null ? fechamodificacion.hashCode() : 0);
        return result;
    }

   /* @ManyToOne
    @JoinColumn(name = "IDTABLA", referencedColumnName = "IDTABLA", nullable = false)
    public SaTablas getSaTablasByIdtabla() {
        return saTablasByIdtabla;
    }

    public void setSaTablasByIdtabla(SaTablas saTablasByIdtabla) {
        this.saTablasByIdtabla = saTablasByIdtabla;
    }*/
}
