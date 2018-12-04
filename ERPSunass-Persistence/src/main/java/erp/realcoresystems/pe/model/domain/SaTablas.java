package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SA_TABLAS")
public class SaTablas extends  Entidad{
	
    private Integer idtabla;
    private String nombretabla;
    private String classname;
    private String descripcion;
    private String descripcionextranjera;
    private String tipotabla;
    private Integer estado;
    private Date fechacreacion;
    private String usuariocreacion;
    private String usuariomodificacion;
    private Date fechamodificacion;
    private String nombretablaAudit;
    private String classnameAudit;

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public void setFechamodificacion(Timestamp fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Id
    @Column(name = "IDTABLA")
    public Integer getIdtabla() {
        return idtabla;
    }

    public void setIdtabla(Integer idtabla) {
        this.idtabla = idtabla;
    }

    @Basic
    @Column(name = "NOMBRETABLA")
    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    @Basic
    @Column(name = "CLASSNAME")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
    @Column(name = "DESCRIPCIONEXTRANJERA")
    public String getDescripcionextranjera() {
        return descripcionextranjera;
    }

    public void setDescripcionextranjera(String descripcionextranjera) {
        this.descripcionextranjera = descripcionextranjera;
    }

    @Basic
    @Column(name = "TIPOTABLA")
    public String getTipotabla() {
        return tipotabla;
    }

    public void setTipotabla(String tipotabla) {
        this.tipotabla = tipotabla;
    }

    @Basic
    @Column(name = "ESTADO")
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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

        SaTablas saTablas = (SaTablas) o;

        if (idtabla != null ? !idtabla.equals(saTablas.idtabla) : saTablas.idtabla != null) return false;
        if (nombretabla != null ? !nombretabla.equals(saTablas.nombretabla) : saTablas.nombretabla != null)
            return false;
        if (classname != null ? !classname.equals(saTablas.classname) : saTablas.classname != null) return false;
        if (descripcion != null ? !descripcion.equals(saTablas.descripcion) : saTablas.descripcion != null)
            return false;
        if (descripcionextranjera != null ? !descripcionextranjera.equals(saTablas.descripcionextranjera) : saTablas.descripcionextranjera != null)
            return false;
        if (tipotabla != null ? !tipotabla.equals(saTablas.tipotabla) : saTablas.tipotabla != null) return false;
        if (estado != null ? !estado.equals(saTablas.estado) : saTablas.estado != null) return false;
        if (fechacreacion != null ? !fechacreacion.equals(saTablas.fechacreacion) : saTablas.fechacreacion != null)
            return false;
        if (usuariocreacion != null ? !usuariocreacion.equals(saTablas.usuariocreacion) : saTablas.usuariocreacion != null)
            return false;
        if (usuariomodificacion != null ? !usuariomodificacion.equals(saTablas.usuariomodificacion) : saTablas.usuariomodificacion != null)
            return false;
        if (fechamodificacion != null ? !fechamodificacion.equals(saTablas.fechamodificacion) : saTablas.fechamodificacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtabla != null ? idtabla.hashCode() : 0;
        result = 31 * result + (nombretabla != null ? nombretabla.hashCode() : 0);
        result = 31 * result + (classname != null ? classname.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (descripcionextranjera != null ? descripcionextranjera.hashCode() : 0);
        result = 31 * result + (tipotabla != null ? tipotabla.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (fechacreacion != null ? fechacreacion.hashCode() : 0);
        result = 31 * result + (usuariocreacion != null ? usuariocreacion.hashCode() : 0);
        result = 31 * result + (usuariomodificacion != null ? usuariomodificacion.hashCode() : 0);
        result = 31 * result + (fechamodificacion != null ? fechamodificacion.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "NOMBRETABLA_AUDIT")
    public String getNombretablaAudit() {
        return nombretablaAudit;
    }

    public void setNombretablaAudit(String nombretablaAudit) {
        this.nombretablaAudit = nombretablaAudit;
    }

    @Basic
    @Column(name = "CLASSNAME_AUDIT")
    public String getClassnameAudit() {
        return classnameAudit;
    }

    public void setClassnameAudit(String classnameAudit) {
        this.classnameAudit = classnameAudit;
    }
}
