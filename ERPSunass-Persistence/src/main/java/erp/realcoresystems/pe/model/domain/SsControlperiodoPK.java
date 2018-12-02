package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsControlperiodoPK implements Serializable {
    private String companyowner;
    private String periodo;
    private String tipofrecuencia;

    @Column(name = "COMPANYOWNER")
    @Id
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Column(name = "PERIODO")
    @Id
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Column(name = "TIPOFRECUENCIA")
    @Id
    public String getTipofrecuencia() {
        return tipofrecuencia;
    }

    public void setTipofrecuencia(String tipofrecuencia) {
        this.tipofrecuencia = tipofrecuencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsControlperiodoPK that = (SsControlperiodoPK) o;

        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;
        if (tipofrecuencia != null ? !tipofrecuencia.equals(that.tipofrecuencia) : that.tipofrecuencia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (tipofrecuencia != null ? tipofrecuencia.hashCode() : 0);
        return result;
    }
}
