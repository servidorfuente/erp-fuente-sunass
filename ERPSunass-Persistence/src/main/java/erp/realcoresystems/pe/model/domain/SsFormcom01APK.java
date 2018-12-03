package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsFormcom01APK implements Serializable {
    private String companyowner;
    private String sucursal;
    private long tipofrecuencia;
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
    public long getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(long tipofrecuencia) {
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

        SsFormcom01APK that = (SsFormcom01APK) o;

        if (tipofrecuencia != that.tipofrecuencia) return false;
        if (ffanno != that.ffanno) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;

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
        return result;
    }
}
