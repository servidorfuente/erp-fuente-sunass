package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SsPeriodogeneralPK implements Serializable {
    private Integer periodoid;
    private Integer anno;
    private String tipooperacion;

    @Column(name = "PERIODOID")
    @Id
    public Integer getPeriodoid() {
        return periodoid;
    }

    public void setPeriodoid(Integer periodoid) {
        this.periodoid = periodoid;
    }

    @Column(name = "ANNO")
    @Id
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Column(name = "TIPOOPERACION")
    @Id
    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsPeriodogeneralPK that = (SsPeriodogeneralPK) o;

        if (periodoid != null ? !periodoid.equals(that.periodoid) : that.periodoid != null) return false;
        if (anno != null ? !anno.equals(that.anno) : that.anno != null) return false;
        if (tipooperacion != null ? !tipooperacion.equals(that.tipooperacion) : that.tipooperacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = periodoid != null ? periodoid.hashCode() : 0;
        result = 31 * result + (anno != null ? anno.hashCode() : 0);
        result = 31 * result + (tipooperacion != null ? tipooperacion.hashCode() : 0);
        return result;
    }
}
