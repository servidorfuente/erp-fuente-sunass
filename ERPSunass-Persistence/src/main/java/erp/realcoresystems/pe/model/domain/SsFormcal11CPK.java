package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsFormcal11CPK implements Serializable {
    private String companyowner;
    private String sucursal;
    private String tipofrecuencia;
    private Integer ffanno;
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
    public Integer getFfanno() {
        return ffanno;
    }

    public void setFfanno(Integer ffanno) {
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
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }


}
