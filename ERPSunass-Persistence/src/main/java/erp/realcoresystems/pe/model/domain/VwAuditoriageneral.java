package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mamania on 18/01/2016.
 */
@Entity
@javax.persistence.Table(name = "VW_AUDITORIAGENERAL")
public class VwAuditoriageneral extends Entidad{
    private BigDecimal idcontador;

    @Id
    @Basic
    @javax.persistence.Column(name = "IDCONTADOR")
    public BigDecimal getIdcontador() {
        return idcontador;
    }

    public void setIdcontador(BigDecimal idcontador) {
        this.idcontador = idcontador;
    }

    private String grupoDesc;

    @Basic
    @javax.persistence.Column(name = "GRUPO_DESC")
    public String getGrupoDesc() {
        return grupoDesc;
    }

    public void setGrupoDesc(String grupoDesc) {
        this.grupoDesc = grupoDesc;
    }

    private String conceptoDesc;

    @Basic
    @javax.persistence.Column(name = "CONCEPTO_DESC")
    public String getConceptoDesc() {
        return conceptoDesc;
    }

    public void setConceptoDesc(String conceptoDesc) {
        this.conceptoDesc = conceptoDesc;
    }

    private String usuarioNombre;

    @Basic
    @javax.persistence.Column(name = "USUARIO_NOMBRE")
    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    private BigDecimal usuarioEmpleado;

    @Basic
    @javax.persistence.Column(name = "USUARIO_EMPLEADO")
    public BigDecimal getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(BigDecimal usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    private String tablaNombre;

    @Basic
    @javax.persistence.Column(name = "TABLA_NOMBRE")
    public String getTablaNombre() {
        return tablaNombre;
    }

    public void setTablaNombre(String tablaNombre) {
        this.tablaNombre = tablaNombre;
    }

    private String tablaClassname;

    @Basic
    @javax.persistence.Column(name = "TABLA_CLASSNAME")
    public String getTablaClassname() {
        return tablaClassname;
    }

    public void setTablaClassname(String tablaClassname) {
        this.tablaClassname = tablaClassname;
    }

    private String tablaNombretablaAudit;

    @Basic
    @javax.persistence.Column(name = "TABLA_NOMBRETABLA_AUDIT")
    public String getTablaNombretablaAudit() {
        return tablaNombretablaAudit;
    }

    public void setTablaNombretablaAudit(String tablaNombretablaAudit) {
        this.tablaNombretablaAudit = tablaNombretablaAudit;
    }

    private String configauditoriaEstado;

    @Basic
    @javax.persistence.Column(name = "CONFIGAUDITORIA_ESTADO")
    public String getConfigauditoriaEstado() {
        return configauditoriaEstado;
    }

    public void setConfigauditoriaEstado(String configauditoriaEstado) {
        this.configauditoriaEstado = configauditoriaEstado;
    }

    private BigDecimal auditoriaid;

    @Basic
    @javax.persistence.Column(name = "AUDITORIAID")
    public BigDecimal getAuditoriaid() {
        return auditoriaid;
    }

    public void setAuditoriaid(BigDecimal auditoriaid) {
        this.auditoriaid = auditoriaid;
    }

    private String aplicacioncodigo;

    @Basic
    @javax.persistence.Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    private String grupo;

    @Basic
    @javax.persistence.Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    private String concepto;

    @Basic
    @javax.persistence.Column(name = "CONCEPTO")
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    private String hostname;

    @Basic
    @javax.persistence.Column(name = "HOSTNAME")
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    private String usuario;

    @Basic
    @javax.persistence.Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String tipo;

    @Basic
    @javax.persistence.Column(name = "TIPO")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String tablename;

    @Basic
    @javax.persistence.Column(name = "TABLENAME")
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    private BigDecimal tableidvalue;

    @Basic
    @javax.persistence.Column(name = "TABLEIDVALUE")
    public BigDecimal getTableidvalue() {
        return tableidvalue;
    }

    public void setTableidvalue(BigDecimal tableidvalue) {
        this.tableidvalue = tableidvalue;
    }

    private String primarykeydata;

    @Basic
    @javax.persistence.Column(name = "PRIMARYKEYDATA")
    public String getPrimarykeydata() {
        return primarykeydata;
    }

    public void setPrimarykeydata(String primarykeydata) {
        this.primarykeydata = primarykeydata;
    }

    private String olddata;

    @Basic
    @javax.persistence.Column(name = "OLDDATA")
    public String getOlddata() {
        return olddata;
    }

    public void setOlddata(String olddata) {
        this.olddata = olddata;
    }

    private String newdata;

    @Basic
    @javax.persistence.Column(name = "NEWDATA")
    public String getNewdata() {
        return newdata;
    }

    public void setNewdata(String newdata) {
        this.newdata = newdata;
    }

    private Date updatedate;

    @Basic
    @javax.persistence.Column(name = "UPDATEDATE")
    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    private String vistadata;

    @Basic
    @javax.persistence.Column(name = "VISTADATA")
    public String getVistadata() {
        return vistadata;
    }

    public void setVistadata(String vistadata) {
        this.vistadata = vistadata;
    }

    private Date sessiondate;

    @Basic
    @javax.persistence.Column(name = "SESSIONDATE")
    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    private String usuariodb;

    @Basic
    @javax.persistence.Column(name = "USUARIODB")
    public String getUsuariodb() {
        return usuariodb;
    }

    public void setUsuariodb(String usuariodb) {
        this.usuariodb = usuariodb;
    }

    private String dirmacClient;

    @Basic
    @javax.persistence.Column(name = "DIRMAC_CLIENT")
    public String getDirmacClient() {
        return dirmacClient;
    }

    public void setDirmacClient(String dirmacClient) {
        this.dirmacClient = dirmacClient;
    }

    private String ipClient;

    @Basic
    @javax.persistence.Column(name = "IP_CLIENT")
    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }

    private String pcName;

    @Basic
    @javax.persistence.Column(name = "PC_NAME")
    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    private BigDecimal flagExito;

    @Basic
    @javax.persistence.Column(name = "FLAG_EXITO")
    public BigDecimal getFlagExito() {
        return flagExito;
    }

    public void setFlagExito(BigDecimal flagExito) {
        this.flagExito = flagExito;
    }

    private String sysVersion;

    @Basic
    @javax.persistence.Column(name = "SYS_VERSION")
    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    private String sysUrl;

    @Basic
    @javax.persistence.Column(name = "SYS_URL")
    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl;
    }

    private String observacion;

    @Basic
    @javax.persistence.Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VwAuditoriageneral that = (VwAuditoriageneral) o;

        if (idcontador != null ? !idcontador.equals(that.idcontador) : that.idcontador != null) return false;
        if (grupoDesc != null ? !grupoDesc.equals(that.grupoDesc) : that.grupoDesc != null) return false;
        if (conceptoDesc != null ? !conceptoDesc.equals(that.conceptoDesc) : that.conceptoDesc != null) return false;
        if (usuarioNombre != null ? !usuarioNombre.equals(that.usuarioNombre) : that.usuarioNombre != null)
            return false;
        if (usuarioEmpleado != null ? !usuarioEmpleado.equals(that.usuarioEmpleado) : that.usuarioEmpleado != null)
            return false;
        if (tablaNombre != null ? !tablaNombre.equals(that.tablaNombre) : that.tablaNombre != null) return false;
        if (tablaClassname != null ? !tablaClassname.equals(that.tablaClassname) : that.tablaClassname != null)
            return false;
        if (tablaNombretablaAudit != null ? !tablaNombretablaAudit.equals(that.tablaNombretablaAudit) : that.tablaNombretablaAudit != null)
            return false;
        if (configauditoriaEstado != null ? !configauditoriaEstado.equals(that.configauditoriaEstado) : that.configauditoriaEstado != null)
            return false;
        if (auditoriaid != null ? !auditoriaid.equals(that.auditoriaid) : that.auditoriaid != null) return false;
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
        if (sessiondate != null ? !sessiondate.equals(that.sessiondate) : that.sessiondate != null) return false;
        if (usuariodb != null ? !usuariodb.equals(that.usuariodb) : that.usuariodb != null) return false;
        if (dirmacClient != null ? !dirmacClient.equals(that.dirmacClient) : that.dirmacClient != null) return false;
        if (ipClient != null ? !ipClient.equals(that.ipClient) : that.ipClient != null) return false;
        if (pcName != null ? !pcName.equals(that.pcName) : that.pcName != null) return false;
        if (flagExito != null ? !flagExito.equals(that.flagExito) : that.flagExito != null) return false;
        if (sysVersion != null ? !sysVersion.equals(that.sysVersion) : that.sysVersion != null) return false;
        if (sysUrl != null ? !sysUrl.equals(that.sysUrl) : that.sysUrl != null) return false;
        return !(observacion != null ? !observacion.equals(that.observacion) : that.observacion != null);

    }

    @Override
    public int hashCode() {
        int result = idcontador != null ? idcontador.hashCode() : 0;
        result = 31 * result + (grupoDesc != null ? grupoDesc.hashCode() : 0);
        result = 31 * result + (conceptoDesc != null ? conceptoDesc.hashCode() : 0);
        result = 31 * result + (usuarioNombre != null ? usuarioNombre.hashCode() : 0);
        result = 31 * result + (usuarioEmpleado != null ? usuarioEmpleado.hashCode() : 0);
        result = 31 * result + (tablaNombre != null ? tablaNombre.hashCode() : 0);
        result = 31 * result + (tablaClassname != null ? tablaClassname.hashCode() : 0);
        result = 31 * result + (tablaNombretablaAudit != null ? tablaNombretablaAudit.hashCode() : 0);
        result = 31 * result + (configauditoriaEstado != null ? configauditoriaEstado.hashCode() : 0);
        result = 31 * result + (auditoriaid != null ? auditoriaid.hashCode() : 0);
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
        result = 31 * result + (sessiondate != null ? sessiondate.hashCode() : 0);
        result = 31 * result + (usuariodb != null ? usuariodb.hashCode() : 0);
        result = 31 * result + (dirmacClient != null ? dirmacClient.hashCode() : 0);
        result = 31 * result + (ipClient != null ? ipClient.hashCode() : 0);
        result = 31 * result + (pcName != null ? pcName.hashCode() : 0);
        result = 31 * result + (flagExito != null ? flagExito.hashCode() : 0);
        result = 31 * result + (sysVersion != null ? sysVersion.hashCode() : 0);
        result = 31 * result + (sysUrl != null ? sysUrl.hashCode() : 0);
        result = 31 * result + (observacion != null ? observacion.hashCode() : 0);
        return result;
    }
}
