package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "SA_FORMARIOS")
public class SaFormarios extends Entidad {
    private Integer formularioid;
    private String frconcepto;
    private String frdescripcion;
    private String frgrupo;
    private String fraspecto;
    private String frurl;
    private String frestado;

    @Id
    @Column(name = "FORMULARIOID")
    public Integer getFormularioid() {
        return formularioid;
    }

    public void setFormularioid(Integer formularioid) {
        this.formularioid = formularioid;
    }

    @Basic
    @Column(name = "FRCONCEPTO")
    public String getFrconcepto() {
        return frconcepto;
    }

    public void setFrconcepto(String frconcepto) {
        this.frconcepto = frconcepto;
    }

    @Basic
    @Column(name = "FRDESCRIPCION")
    public String getFrdescripcion() {
        return frdescripcion;
    }

    public void setFrdescripcion(String frdescripcion) {
        this.frdescripcion = frdescripcion;
    }

    @Basic
    @Column(name = "FRGRUPO")
    public String getFrgrupo() {
        return frgrupo;
    }

    public void setFrgrupo(String frgrupo) {
        this.frgrupo = frgrupo;
    }

    @Basic
    @Column(name = "FRASPECTO")
    public String getFraspecto() {
        return fraspecto;
    }

    public void setFraspecto(String fraspecto) {
        this.fraspecto = fraspecto;
    }

    @Basic
    @Column(name = "FRURL")
    public String getFrurl() {
        return frurl;
    }

    public void setFrurl(String frurl) {
        this.frurl = frurl;
    }

    @Basic
    @Column(name = "FRESTADO")
    public String getFrestado() {
        return frestado;
    }

    public void setFrestado(String frestado) {
        this.frestado = frestado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaFormarios that = (SaFormarios) o;

        if (formularioid != that.formularioid) return false;
        if (frconcepto != null ? !frconcepto.equals(that.frconcepto) : that.frconcepto != null) return false;
        if (frdescripcion != null ? !frdescripcion.equals(that.frdescripcion) : that.frdescripcion != null)
            return false;
        if (frgrupo != null ? !frgrupo.equals(that.frgrupo) : that.frgrupo != null) return false;
        if (fraspecto != null ? !fraspecto.equals(that.fraspecto) : that.fraspecto != null) return false;
        if (frurl != null ? !frurl.equals(that.frurl) : that.frurl != null) return false;
        if (frestado != null ? !frestado.equals(that.frestado) : that.frestado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (formularioid ^ (formularioid >>> 32));
        result = 31 * result + (frconcepto != null ? frconcepto.hashCode() : 0);
        result = 31 * result + (frdescripcion != null ? frdescripcion.hashCode() : 0);
        result = 31 * result + (frgrupo != null ? frgrupo.hashCode() : 0);
        result = 31 * result + (fraspecto != null ? fraspecto.hashCode() : 0);
        result = 31 * result + (frurl != null ? frurl.hashCode() : 0);
        result = 31 * result + (frestado != null ? frestado.hashCode() : 0);
        return result;
    }
}
