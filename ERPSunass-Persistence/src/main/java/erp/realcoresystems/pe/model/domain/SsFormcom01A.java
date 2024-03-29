package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SS_FORMCOM01A" )
@IdClass(SsFormcom01APK.class)
public class SsFormcom01A  extends Entidad{
    private String companyowner;
    private String sucursal;
    private Integer tipofrecuencia;
    private Integer ffanno;
    private String periodo;
    private Integer secuencia;
    private Integer mes;
    private Date fecha;
    private Integer sectorid;
    private Integer proyectoid;
    private String cresResemi;
    private String cresNumsum;
    private Date fresFecing;
    private String cresTiprecl;
    private String cresNpriins;
    private Date fresPriinsnot;
    private Date fresPrrecon;
    private Date fresRecon;
    private Date fresReconnot;
    private String cresNrecon;
    private String cresTipsoluc;
    private String cresNomusua;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;
    private Integer cresEstadodocumento;
    private String cresEstado;

    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Id
    @Column(name = "TIPOFRECUENCIA")
    public Integer getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(Integer tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
    }

    @Id
    @Column(name = "FFANNO")
    public Integer getFfanno() {
        return ffanno;
    }

    public void setFfanno(Integer ffanno) {
        this.ffanno = ffanno;
    }

    @Id
    @Column(name = "PERIODO")
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
    @Column(name = "MES")
    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Basic
    @Column(name = "CRES_RESEMI")
    public String getCresResemi() {
        return cresResemi;
    }

    public void setCresResemi(String cresResemi) {
        this.cresResemi = cresResemi;
    }

    @Basic
    @Column(name = "CRES_NUMSUM")
    public String getCresNumsum() {
        return cresNumsum;
    }

    public void setCresNumsum(String cresNumsum) {
        this.cresNumsum = cresNumsum;
    }

    @Basic
    @Column(name = "FRES_FECING")
    public Date getFresFecing() {
        return fresFecing;
    }

    public void setFresFecing(Date fresFecing) {
        this.fresFecing = fresFecing;
    }

    @Basic
    @Column(name = "CRES_TIPRECL")
    public String getCresTiprecl() {
        return cresTiprecl;
    }

    public void setCresTiprecl(String cresTiprecl) {
        this.cresTiprecl = cresTiprecl;
    }

    @Basic
    @Column(name = "CRES_NPRIINS")
    public String getCresNpriins() {
        return cresNpriins;
    }

    public void setCresNpriins(String cresNpriins) {
        this.cresNpriins = cresNpriins;
    }

    @Basic
    @Column(name = "FRES_PRIINSNOT")
    public Date getFresPriinsnot() {
        return fresPriinsnot;
    }

    public void setFresPriinsnot(Date fresPriinsnot) {
        this.fresPriinsnot = fresPriinsnot;
    }

    @Basic
    @Column(name = "FRES_PRRECON")
    public Date getFresPrrecon() {
        return fresPrrecon;
    }

    public void setFresPrrecon(Date fresPrrecon) {
        this.fresPrrecon = fresPrrecon;
    }

    @Basic
    @Column(name = "FRES_RECON")
    public Date getFresRecon() {
        return fresRecon;
    }

    public void setFresRecon(Date fresRecon) {
        this.fresRecon = fresRecon;
    }

    @Basic
    @Column(name = "FRES_RECONNOT")
    public Date getFresReconnot() {
        return fresReconnot;
    }

    public void setFresReconnot(Date fresReconnot) {
        this.fresReconnot = fresReconnot;
    }

    @Basic
    @Column(name = "CRES_NRECON")
    public String getCresNrecon() {
        return cresNrecon;
    }

    public void setCresNrecon(String cresNrecon) {
        this.cresNrecon = cresNrecon;
    }

    @Basic
    @Column(name = "CRES_TIPSOLUC")
    public String getCresTipsoluc() {
        return cresTipsoluc;
    }

    public void setCresTipsoluc(String cresTipsoluc) {
        this.cresTipsoluc = cresTipsoluc;
    }

    @Basic
    @Column(name = "CRES_NOMUSUA")
    public String getCresNomusua() {
        return cresNomusua;
    }

    public void setCresNomusua(String cresNomusua) {
        this.cresNomusua = cresNomusua;
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
    @Column(name = "CRES_ESTADODOCUMENTO")
    public Integer getCresEstadodocumento() {
        return cresEstadodocumento;
    }

    public void setCresEstadodocumento(Integer cresEstadodocumento) {
        this.cresEstadodocumento = cresEstadodocumento;
    }

    @Basic
    @Column(name = "CRES_ESTADO")
    public String getCresEstado() {
        return cresEstado;
    }

    public void setCresEstado(String cresEstado) {
        this.cresEstado = cresEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsFormcom01A that = (SsFormcom01A) o;

        if (tipofrecuencia != that.tipofrecuencia) return false;
        if (ffanno != that.ffanno) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;
        if (mes != null ? !mes.equals(that.mes) : that.mes != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (sectorid != null ? !sectorid.equals(that.sectorid) : that.sectorid != null) return false;
        if (proyectoid != null ? !proyectoid.equals(that.proyectoid) : that.proyectoid != null) return false;
        if (cresResemi != null ? !cresResemi.equals(that.cresResemi) : that.cresResemi != null) return false;
        if (cresNumsum != null ? !cresNumsum.equals(that.cresNumsum) : that.cresNumsum != null) return false;
        if (fresFecing != null ? !fresFecing.equals(that.fresFecing) : that.fresFecing != null) return false;
        if (cresTiprecl != null ? !cresTiprecl.equals(that.cresTiprecl) : that.cresTiprecl != null) return false;
        if (cresNpriins != null ? !cresNpriins.equals(that.cresNpriins) : that.cresNpriins != null) return false;
        if (fresPriinsnot != null ? !fresPriinsnot.equals(that.fresPriinsnot) : that.fresPriinsnot != null)
            return false;
        if (fresPrrecon != null ? !fresPrrecon.equals(that.fresPrrecon) : that.fresPrrecon != null) return false;
        if (fresRecon != null ? !fresRecon.equals(that.fresRecon) : that.fresRecon != null) return false;
        if (fresReconnot != null ? !fresReconnot.equals(that.fresReconnot) : that.fresReconnot != null) return false;
        if (cresNrecon != null ? !cresNrecon.equals(that.cresNrecon) : that.cresNrecon != null) return false;
        if (cresTipsoluc != null ? !cresTipsoluc.equals(that.cresTipsoluc) : that.cresTipsoluc != null) return false;
        if (cresNomusua != null ? !cresNomusua.equals(that.cresNomusua) : that.cresNomusua != null) return false;
        if (creacionusuario != null ? !creacionusuario.equals(that.creacionusuario) : that.creacionusuario != null)
            return false;
        if (creacionfecha != null ? !creacionfecha.equals(that.creacionfecha) : that.creacionfecha != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (cresEstadodocumento != null ? !cresEstadodocumento.equals(that.cresEstadodocumento) : that.cresEstadodocumento != null)
            return false;
        if (cresEstado != null ? !cresEstado.equals(that.cresEstado) : that.cresEstado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (tipofrecuencia ^ (tipofrecuencia >>> 32));
        result = 31 * result + (int) (ffanno ^ (ffanno >>> 32));
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (sectorid != null ? sectorid.hashCode() : 0);
        result = 31 * result + (proyectoid != null ? proyectoid.hashCode() : 0);
        result = 31 * result + (cresResemi != null ? cresResemi.hashCode() : 0);
        result = 31 * result + (cresNumsum != null ? cresNumsum.hashCode() : 0);
        result = 31 * result + (fresFecing != null ? fresFecing.hashCode() : 0);
        result = 31 * result + (cresTiprecl != null ? cresTiprecl.hashCode() : 0);
        result = 31 * result + (cresNpriins != null ? cresNpriins.hashCode() : 0);
        result = 31 * result + (fresPriinsnot != null ? fresPriinsnot.hashCode() : 0);
        result = 31 * result + (fresPrrecon != null ? fresPrrecon.hashCode() : 0);
        result = 31 * result + (fresRecon != null ? fresRecon.hashCode() : 0);
        result = 31 * result + (fresReconnot != null ? fresReconnot.hashCode() : 0);
        result = 31 * result + (cresNrecon != null ? cresNrecon.hashCode() : 0);
        result = 31 * result + (cresTipsoluc != null ? cresTipsoluc.hashCode() : 0);
        result = 31 * result + (cresNomusua != null ? cresNomusua.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (cresEstadodocumento != null ? cresEstadodocumento.hashCode() : 0);
        result = 31 * result + (cresEstado != null ? cresEstado.hashCode() : 0);
        return result;
    }
}
