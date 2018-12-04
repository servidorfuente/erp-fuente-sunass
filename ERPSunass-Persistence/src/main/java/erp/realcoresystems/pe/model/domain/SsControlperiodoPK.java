package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsControlperiodoPK implements Serializable {
    private String companyowner;
    private String tipofrecuencia;
    private Integer ffanno;
    private Integer formularioid;
    private String periodo;
    private Integer secuencia;

    @Column(name = "COMPANYOWNER")
    @Id
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
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
    public Integer getFfanno() {
        return ffanno;
    }

    public void setFfanno(Integer ffanno) {
        this.ffanno = ffanno;
    }

    @Column(name = "FORMULARIOID")
    @Id
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
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
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsControlperiodoPK that = (SsControlperiodoPK) o;

        if (ffanno != that.ffanno) return false;
        if (formularioid != that.formularioid) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (tipofrecuencia != null ? !tipofrecuencia.equals(that.tipofrecuencia) : that.tipofrecuencia != null)
            return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (tipofrecuencia != null ? tipofrecuencia.hashCode() : 0);
        result = 31 * result + (int) (ffanno ^ (ffanno >>> 32));
        result = 31 * result + (int) (formularioid ^ (formularioid >>> 32));
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        return result;
    }
}
