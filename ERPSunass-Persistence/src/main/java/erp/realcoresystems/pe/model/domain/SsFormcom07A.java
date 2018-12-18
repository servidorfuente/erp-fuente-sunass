package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "SS_FORMCOM07A")
@IdClass(SsFormcom07APK.class)
public class SsFormcom07A extends Entidad{
    private String companyowner;
    private String sucursal;
    private String tipofrecuencia;
    private long ffanno;
    private String periodo;
    private Integer secuencia;
    private Long mes;
    private Time fecha;
    private Long sectorid;
    private Long proyectoid;
    private String ccatetar;
    private String cingRango;
    private String cingDescrango;
    private Long ningAgualcLec;
    private Long ningAgualcAsig;
    private Long ningAgualcProm;
    private Long ningAguLec;
    private Long ningAguAsig;
    private Long ningAguProm;
    private Long ningAlcan;
    private String creacionusuario;
    private Time creacionfecha;
    private String ultimousuario;
    private Time ultimafechamodif;
    private Long cresEstadodocumento;
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
    public String getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(String tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
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
    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "FECHA")
    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
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
    @Column(name = "PROYECTOID")
    public Long getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Long proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Basic
    @Column(name = "CCATETAR")
    public String getCcatetar() {
        return ccatetar;
    }

    public void setCcatetar(String ccatetar) {
        this.ccatetar = ccatetar;
    }

    @Basic
    @Column(name = "CING_RANGO")
    public String getCingRango() {
        return cingRango;
    }

    public void setCingRango(String cingRango) {
        this.cingRango = cingRango;
    }

    @Basic
    @Column(name = "CING_DESCRANGO")
    public String getCingDescrango() {
        return cingDescrango;
    }

    public void setCingDescrango(String cingDescrango) {
        this.cingDescrango = cingDescrango;
    }

    @Basic
    @Column(name = "NING_AGUALC_LEC")
    public Long getNingAgualcLec() {
        return ningAgualcLec;
    }

    public void setNingAgualcLec(Long ningAgualcLec) {
        this.ningAgualcLec = ningAgualcLec;
    }

    @Basic
    @Column(name = "NING_AGUALC_ASIG")
    public Long getNingAgualcAsig() {
        return ningAgualcAsig;
    }

    public void setNingAgualcAsig(Long ningAgualcAsig) {
        this.ningAgualcAsig = ningAgualcAsig;
    }

    @Basic
    @Column(name = "NING_AGUALC_PROM")
    public Long getNingAgualcProm() {
        return ningAgualcProm;
    }

    public void setNingAgualcProm(Long ningAgualcProm) {
        this.ningAgualcProm = ningAgualcProm;
    }

    @Basic
    @Column(name = "NING_AGU_LEC")
    public Long getNingAguLec() {
        return ningAguLec;
    }

    public void setNingAguLec(Long ningAguLec) {
        this.ningAguLec = ningAguLec;
    }

    @Basic
    @Column(name = "NING_AGU_ASIG")
    public Long getNingAguAsig() {
        return ningAguAsig;
    }

    public void setNingAguAsig(Long ningAguAsig) {
        this.ningAguAsig = ningAguAsig;
    }

    @Basic
    @Column(name = "NING_AGU_PROM")
    public Long getNingAguProm() {
        return ningAguProm;
    }

    public void setNingAguProm(Long ningAguProm) {
        this.ningAguProm = ningAguProm;
    }

    @Basic
    @Column(name = "NING_ALCAN")
    public Long getNingAlcan() {
        return ningAlcan;
    }

    public void setNingAlcan(Long ningAlcan) {
        this.ningAlcan = ningAlcan;
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
    public Time getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Time creacionfecha) {
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
    public Time getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Time ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @Column(name = "CRES_ESTADODOCUMENTO")
    public Long getCresEstadodocumento() {
        return cresEstadodocumento;
    }

    public void setCresEstadodocumento(Long cresEstadodocumento) {
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
        SsFormcom07A that = (SsFormcom07A) o;
        return ffanno == that.ffanno &&
                secuencia == that.secuencia &&
                Objects.equals(companyowner, that.companyowner) &&
                Objects.equals(sucursal, that.sucursal) &&
                Objects.equals(tipofrecuencia, that.tipofrecuencia) &&
                Objects.equals(periodo, that.periodo) &&
                Objects.equals(mes, that.mes) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(sectorid, that.sectorid) &&
                Objects.equals(proyectoid, that.proyectoid) &&
                Objects.equals(ccatetar, that.ccatetar) &&
                Objects.equals(cingRango, that.cingRango) &&
                Objects.equals(cingDescrango, that.cingDescrango) &&
                Objects.equals(ningAgualcLec, that.ningAgualcLec) &&
                Objects.equals(ningAgualcAsig, that.ningAgualcAsig) &&
                Objects.equals(ningAgualcProm, that.ningAgualcProm) &&
                Objects.equals(ningAguLec, that.ningAguLec) &&
                Objects.equals(ningAguAsig, that.ningAguAsig) &&
                Objects.equals(ningAguProm, that.ningAguProm) &&
                Objects.equals(ningAlcan, that.ningAlcan) &&
                Objects.equals(creacionusuario, that.creacionusuario) &&
                Objects.equals(creacionfecha, that.creacionfecha) &&
                Objects.equals(ultimousuario, that.ultimousuario) &&
                Objects.equals(ultimafechamodif, that.ultimafechamodif) &&
                Objects.equals(cresEstadodocumento, that.cresEstadodocumento) &&
                Objects.equals(cresEstado, that.cresEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyowner, sucursal, tipofrecuencia, ffanno, periodo, secuencia, mes, fecha, sectorid, proyectoid, ccatetar, cingRango, cingDescrango, ningAgualcLec, ningAgualcAsig, ningAgualcProm, ningAguLec, ningAguAsig, ningAguProm, ningAlcan, creacionusuario, creacionfecha, ultimousuario, ultimafechamodif, cresEstadodocumento, cresEstado);
    }
}
