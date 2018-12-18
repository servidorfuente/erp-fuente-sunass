package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SsFormcom07APK implements Serializable {
    private String companyowner;
    private String sucursal;
    private String tipofrecuencia;
    private long ffanno;
    private String periodo;
    private long secuencia;

    @Column(name = "COMPANYOWNER")
    @Id
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Column(name = "SUCURSAL")
    @Id
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Column(name = "TIPOFRECUENCIA")
    @Id
    public String getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(String tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
    }

    @Column(name = "FFANNO")
    @Id
    public long getFfanno() {
        return ffanno;
    }

    public void setFfanno(long ffanno) {
        this.ffanno = ffanno;
    }

    @Column(name = "PERIODO")
    @Id
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Column(name = "SECUENCIA")
    @Id
    public long getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(long secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SsFormcom07APK that = (SsFormcom07APK) o;
        return ffanno == that.ffanno &&
                secuencia == that.secuencia &&
                Objects.equals(companyowner, that.companyowner) &&
                Objects.equals(sucursal, that.sucursal) &&
                Objects.equals(tipofrecuencia, that.tipofrecuencia) &&
                Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyowner, sucursal, tipofrecuencia, ffanno, periodo, secuencia);
    }
}
