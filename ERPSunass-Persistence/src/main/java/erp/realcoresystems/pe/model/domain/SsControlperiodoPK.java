package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsControlperiodoPK implements Serializable {
    private String companyowner;
    private String tipooperacion;
    private Integer anno;
    private Integer formularioid;
    private Integer secuencia;

    @Column(name = "COMPANYOWNER")
    @Id
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Column(name = "TIPOOPERACION")
    @Id
    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    @Column(name = "ANNO")
    @Id
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Column(name = "FORMULARIOID")
    @Id
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
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

        if (anno != that.anno) return false;
        if (formularioid != that.formularioid) return false;
        if (secuencia != that.secuencia) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (tipooperacion != null ? !tipooperacion.equals(that.tipooperacion) : that.tipooperacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (tipooperacion != null ? tipooperacion.hashCode() : 0);
        result = 31 * result + (int) (anno ^ (anno >>> 32));
        result = 31 * result + (int) (formularioid ^ (formularioid >>> 32));
        result = 31 * result + (int) (secuencia ^ (secuencia >>> 32));
        return result;
    }
}
