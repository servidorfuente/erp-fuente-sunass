package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOCOLEGIO")
public class SaTipoColegio {
	
    private int tipocolegioid;
    private String codigo;
    private String descripcion;
    private int estado;
    private int usuariocreacion;
    private Date fechacreacion;
    private String ipcreacion;
    private Long ultimousuario;
    private Date ultimafechamodif;
    private String ultimoip;

    @Id
    @Column(name = "TCLTIPOCOLEGIOID")
    public long getTipocolegioid() {
        return tipocolegioid;
    }

    public void setTipocolegioid(int tipocolegioid) {
        this.tipocolegioid = tipocolegioid;
    }

    @Basic
    @Column(name = "TCLCODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "TCLDESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "TCLESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "TCLUSUARIOCREACION")
    public int getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(int usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    @Basic
    @Column(name = "TCLFECHACREACION")
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "TCLIPCREACION")
    public String getIpcreacion() {
        return ipcreacion;
    }

    public void setIpcreacion(String ipcreacion) {
        this.ipcreacion = ipcreacion;
    }

    @Basic
    @Column(name = "TCLULTIMOUSUARIO")
    public Long getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(Long ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    @Basic
    @Column(name = "TCLULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @Column(name = "TCLULTIMOIP")
    public String getUltimoip() {
        return ultimoip;
    }

    public void setUltimoip(String ultimoip) {
        this.ultimoip = ultimoip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTipoColegio that = (SaTipoColegio) o;

        if (tipocolegioid != that.tipocolegioid) return false;
        if (estado != that.estado) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null)
            return false;
        if (usuariocreacion != that.usuariocreacion)
            return false;
        if (fechacreacion != null ? !fechacreacion.equals(that.fechacreacion) : that.fechacreacion != null)
            return false;
        if (ipcreacion != null ? !ipcreacion.equals(that.ipcreacion) : that.ipcreacion != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (ultimoip != null ? !ultimoip.equals(that.ultimoip) : that.ultimoip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipocolegioid ^ (tipocolegioid >>> 32));
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (int) (estado ^ (estado >>> 32));
        result = 31 * result + (int) (usuariocreacion ^ (usuariocreacion >>> 32));
        result = 31 * result + (fechacreacion != null ? fechacreacion.hashCode() : 0);
        result = 31 * result + (ipcreacion != null ? ipcreacion.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (ultimoip != null ? ultimoip.hashCode() : 0);
        return result;
    }
}
