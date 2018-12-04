package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_AUDITORIA")
public class SaAuditoria  extends Entidad{
    private Long auditoriaid;
    private String aplicacioncodigo;
    private String grupo;
    private String concepto;
    private String hostname;
    private String usuario;
    private String tipo;
    private String tablename;
    private Long tableidvalue;
    private String primarykeydata;
    private String olddata;
    private String newdata;
    private Date updatedate;
    private String vistadata;
    private Date sessiondate;
    private String usuariodb;
    private String dirmacClient;
    private String ipClient;
    private String pcName;
    private Long flagExito;
    private String sysVersion;
    private String sysUrl;
    private String observacion;

    public void setAuditoriaid(Long auditoriaid) {
        this.auditoriaid = auditoriaid;
    }


    @Id
    @Column(name = "AUDITORIAID")
    public Long getAuditoriaid() {
        return auditoriaid;
    }

    public void setAuditoriaid(long auditoriaid) {
        this.auditoriaid = auditoriaid;
    }

    @Basic
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Basic
    @Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Basic
    @Column(name = "CONCEPTO")
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

        SaAuditoria that = (SaAuditoria) o;

        if (auditoriaid != that.auditoriaid) return false;
        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;
        if (hostname != null ? !hostname.equals(that.hostname) : that.hostname != null) return false;
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
        result = 31 * result + (aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0);
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
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

    @Basic
    @Column(name = "SESSIONDATE")
    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @Basic
    @Column(name = "USUARIODB")
    public String getUsuariodb() {
        return usuariodb;
    }

    public void setUsuariodb(String usuariodb) {
        this.usuariodb = usuariodb;
    }

    @Basic
    @Column(name = "DIRMAC_CLIENT")
    public String getDirmacClient() {
        return dirmacClient;
    }

    public void setDirmacClient(String dirmacClient) {
        this.dirmacClient = dirmacClient;
    }

    @Basic
    @Column(name = "IP_CLIENT")
    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }

    @Basic
    @Column(name = "PC_NAME")
    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    @Basic
    @Column(name = "FLAG_EXITO")
    public Long getFlagExito() {
        return flagExito;
    }

    public void setFlagExito(Long flagExito) {
        this.flagExito = flagExito;
    }

    @Basic
    @Column(name = "SYS_VERSION")
    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    @Basic
    @Column(name = "SYS_URL")
    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl;
    }

    @Basic
    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
