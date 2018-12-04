package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mamania on 07/01/2016.
 */
@Entity
public class Seguridadauditoria extends Entidad{
    private long auditoriaid;
    private String hostname;
    private String aplicacion;
    private String modulo;
    private String usuario;
    private String tipo;
    private String tablename;
    private Long tableidvalue;
    private String primarykeydata;
    private String olddata;
    private String newdata;
    private Date updatedate;
    private String vistadata;

    @Id
    @Column(name = "AUDITORIAID")
    public long getAuditoriaid() {
        return auditoriaid;
    }

    public void setAuditoriaid(long auditoriaid) {
        this.auditoriaid = auditoriaid;
    }

    @Basic
    @Column(name = "HOSTNAME")
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Basic
    @Column(name = "APLICACION")
    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Basic
    @Column(name = "MODULO")
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @Basic
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "TABLENAME")
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    @Basic
    @Column(name = "TABLEIDVALUE")
    public Long getTableidvalue() {
        return tableidvalue;
    }

    public void setTableidvalue(Long tableidvalue) {
        this.tableidvalue = tableidvalue;
    }

    @Basic
    @Column(name = "PRIMARYKEYDATA")
    public String getPrimarykeydata() {
        return primarykeydata;
    }

    public void setPrimarykeydata(String primarykeydata) {
        this.primarykeydata = primarykeydata;
    }

    @Basic
    @Column(name = "OLDDATA")
    public String getOlddata() {
        return olddata;
    }

    public void setOlddata(String olddata) {
        this.olddata = olddata;
    }

    @Basic
    @Column(name = "NEWDATA")
    public String getNewdata() {
        return newdata;
    }

    public void setNewdata(String newdata) {
        this.newdata = newdata;
    }

    @Basic
    @Column(name = "UPDATEDATE")
    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    @Basic
    @Column(name = "VISTADATA")
    public String getVistadata() {
        return vistadata;
    }

    public void setVistadata(String vistadata) {
        this.vistadata = vistadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seguridadauditoria that = (Seguridadauditoria) o;

        if (auditoriaid != that.auditoriaid) return false;
        if (hostname != null ? !hostname.equals(that.hostname) : that.hostname != null) return false;
        if (aplicacion != null ? !aplicacion.equals(that.aplicacion) : that.aplicacion != null) return false;
        if (modulo != null ? !modulo.equals(that.modulo) : that.modulo != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (tablename != null ? !tablename.equals(that.tablename) : that.tablename != null) return false;
        if (tableidvalue != null ? !tableidvalue.equals(that.tableidvalue) : that.tableidvalue != null) return false;
        if (primarykeydata != null ? !primarykeydata.equals(that.primarykeydata) : that.primarykeydata != null)
            return false;
        if (olddata != null ? !olddata.equals(that.olddata) : that.olddata != null) return false;
        if (newdata != null ? !newdata.equals(that.newdata) : that.newdata != null) return false;
        if (updatedate != null ? !updatedate.equals(that.updatedate) : that.updatedate != null) return false;
        if (vistadata != null ? !vistadata.equals(that.vistadata) : that.vistadata != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (auditoriaid ^ (auditoriaid >>> 32));
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (aplicacion != null ? aplicacion.hashCode() : 0);
        result = 31 * result + (modulo != null ? modulo.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (tablename != null ? tablename.hashCode() : 0);
        result = 31 * result + (tableidvalue != null ? tableidvalue.hashCode() : 0);
        result = 31 * result + (primarykeydata != null ? primarykeydata.hashCode() : 0);
        result = 31 * result + (olddata != null ? olddata.hashCode() : 0);
        result = 31 * result + (newdata != null ? newdata.hashCode() : 0);
        result = 31 * result + (updatedate != null ? updatedate.hashCode() : 0);
        result = 31 * result + (vistadata != null ? vistadata.hashCode() : 0);
        return result;
    }
}
