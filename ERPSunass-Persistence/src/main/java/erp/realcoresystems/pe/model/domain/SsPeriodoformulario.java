package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "SS_PERIODOFORMULARIO")
@IdClass(SsPeriodoformularioPK.class)
public class SsPeriodoformulario   extends Entidad {
    private String companyowner;
    private long ffanno;
    private String ffdescripcion;
    private String ffobservaciones;
    private String fftipofuente;
    private String ffestado;

    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "FFANNO")
    public long getFfanno() {
        return ffanno;
    }

    public void setFfanno(long ffanno) {
        this.ffanno = ffanno;
    }

    @Basic
    @Column(name = "FFDESCRIPCION")
    public String getFfdescripcion() {
        return ffdescripcion;
    }

    public void setFfdescripcion(String ffdescripcion) {
        this.ffdescripcion = ffdescripcion;
    }

    @Basic
    @Column(name = "FFOBSERVACIONES")
    public String getFfobservaciones() {
        return ffobservaciones;
    }

    public void setFfobservaciones(String ffobservaciones) {
        this.ffobservaciones = ffobservaciones;
    }

    @Basic
    @Column(name = "FFTIPOFUENTE")
    public String getFftipofuente() {
        return fftipofuente;
    }

    public void setFftipofuente(String fftipofuente) {
        this.fftipofuente = fftipofuente;
    }

    @Basic
    @Column(name = "FFESTADO")
    public String getFfestado() {
        return ffestado;
    }

    public void setFfestado(String ffestado) {
        this.ffestado = ffestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsPeriodoformulario that = (SsPeriodoformulario) o;

        if (ffanno != that.ffanno) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (ffdescripcion != null ? !ffdescripcion.equals(that.ffdescripcion) : that.ffdescripcion != null)
            return false;
        if (ffobservaciones != null ? !ffobservaciones.equals(that.ffobservaciones) : that.ffobservaciones != null)
            return false;
        if (fftipofuente != null ? !fftipofuente.equals(that.fftipofuente) : that.fftipofuente != null) return false;
        if (ffestado != null ? !ffestado.equals(that.ffestado) : that.ffestado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (int) (ffanno ^ (ffanno >>> 32));
        result = 31 * result + (ffdescripcion != null ? ffdescripcion.hashCode() : 0);
        result = 31 * result + (ffobservaciones != null ? ffobservaciones.hashCode() : 0);
        result = 31 * result + (fftipofuente != null ? fftipofuente.hashCode() : 0);
        result = 31 * result + (ffestado != null ? ffestado.hashCode() : 0);
        return result;
    }
}
