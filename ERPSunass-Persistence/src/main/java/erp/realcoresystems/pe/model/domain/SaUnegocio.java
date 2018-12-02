package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_UNEGOCIO")
public class SaUnegocio  extends Entidad{

	private static final long serialVersionUID = -518364180072348722L;
	private Integer uneunegocioid;
    private Companyowner companyowner;
    private String companiacodigo;
    private Integer tuntunegocioid;
    private Integer uneestado;
    private String unecodigo;
    private String unedescripcion;
    private Integer uneusuariocreacion;
    private Timestamp unefechacreacion;
    private String uneipcreacion;
    private Integer uneultimousuario;
    private Timestamp uneultimafechamodif;
    private String uneultimoip;
    private String uneresolucionautorizacion;
    private Timestamp uneresolucionautorizacionfecha;
    private String uneresolucionrevalidacion;
    private Timestamp uneresolucionrevalidacionfecha;
    private String unedre;
    private String uneugel;
    private Integer uneflagpropiedad;
    private String unecodigomodular;
    private String unenemonico;

    
    public SaUnegocio() {

	}
  
    public SaUnegocio(Companyowner companyowner) {
    	this.companyowner = companyowner;
	}

	@Id
    @Column(name = "UNEUNEGOCIOID")
    public Integer getUneunegocioid() {
        return uneunegocioid;
    }

    public void setUneunegocioid(Integer uneunegocioid) {
        this.uneunegocioid = uneunegocioid;
    }

    @ManyToOne
    @JoinColumn(name="COMPANYOWNER")
    public Companyowner getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(Companyowner companyowner) {
        this.companyowner = companyowner;
    }
    
    @Basic
    @Column(name = "COMPANIACODIGO")
    public String getCompaniacodigo() {
        return companiacodigo;
    }

    public void setCompaniacodigo(String companiacodigo) {
        this.companiacodigo = companiacodigo;
    }

    @Basic
    @Column(name = "TUNTUNEGOCIOID")
    public Integer getTuntunegocioid() {
        return tuntunegocioid;
    }

    public void setTuntunegocioid(Integer tuntunegocioid) {
        this.tuntunegocioid = tuntunegocioid;
    }

    @Basic
    @Column(name = "UNEESTADO")
    public Integer getUneestado() {
        return uneestado;
    }

    public void setUneestado(Integer uneestado) {
        this.uneestado = uneestado;
    }

    @Basic
    @Column(name = "UNECODIGO")
    public String getUnecodigo() {
        return unecodigo;
    }

    public void setUnecodigo(String unecodigo) {
        this.unecodigo = unecodigo;
    }

    @Basic
    @Column(name = "UNEDESCRIPCION")
    public String getUnedescripcion() {
        return unedescripcion;
    }

    public void setUnedescripcion(String unedescripcion) {
        this.unedescripcion = unedescripcion;
    }

    @Basic
    @Column(name = "UNEUSUARIOCREACION")
    public Integer getUneusuariocreacion() {
        return uneusuariocreacion;
    }

    public void setUneusuariocreacion(Integer uneusuariocreacion) {
        this.uneusuariocreacion = uneusuariocreacion;
    }

    @Basic
    @Column(name = "UNEFECHACREACION")
    public Timestamp getUnefechacreacion() {
        return unefechacreacion;
    }

    public void setUnefechacreacion(Timestamp unefechacreacion) {
        this.unefechacreacion = unefechacreacion;
    }

    @Basic
    @Column(name = "UNEIPCREACION")
    public String getUneipcreacion() {
        return uneipcreacion;
    }

    public void setUneipcreacion(String uneipcreacion) {
        this.uneipcreacion = uneipcreacion;
    }

    @Basic
    @Column(name = "UNEULTIMOUSUARIO")
    public Integer getUneultimousuario() {
        return uneultimousuario;
    }

    public void setUneultimousuario(Integer uneultimousuario) {
        this.uneultimousuario = uneultimousuario;
    }

    @Basic
    @Column(name = "UNEULTIMAFECHAMODIF")
    public Timestamp getUneultimafechamodif() {
        return uneultimafechamodif;
    }

    public void setUneultimafechamodif(Timestamp uneultimafechamodif) {
        this.uneultimafechamodif = uneultimafechamodif;
    }

    @Basic
    @Column(name = "UNEULTIMOIP")
    public String getUneultimoip() {
        return uneultimoip;
    }

    public void setUneultimoip(String uneultimoip) {
        this.uneultimoip = uneultimoip;
    }

    @Basic
    @Column(name = "UNERESOLUCIONAUTORIZACION")
    public String getUneresolucionautorizacion() {
        return uneresolucionautorizacion;
    }

    public void setUneresolucionautorizacion(String uneresolucionautorizacion) {
        this.uneresolucionautorizacion = uneresolucionautorizacion;
    }

    @Basic
    @Column(name = "UNERESOLUCIONAUTORIZACIONFECHA")
    public Timestamp getUneresolucionautorizacionfecha() {
        return uneresolucionautorizacionfecha;
    }

    public void setUneresolucionautorizacionfecha(Timestamp uneresolucionautorizacionfecha) {
        this.uneresolucionautorizacionfecha = uneresolucionautorizacionfecha;
    }

    @Basic
    @Column(name = "UNERESOLUCIONREVALIDACION")
    public String getUneresolucionrevalidacion() {
        return uneresolucionrevalidacion;
    }

    public void setUneresolucionrevalidacion(String uneresolucionrevalidacion) {
        this.uneresolucionrevalidacion = uneresolucionrevalidacion;
    }

    @Basic
    @Column(name = "UNERESOLUCIONREVALIDACIONFECHA")
    public Timestamp getUneresolucionrevalidacionfecha() {
        return uneresolucionrevalidacionfecha;
    }

    public void setUneresolucionrevalidacionfecha(Timestamp uneresolucionrevalidacionfecha) {
        this.uneresolucionrevalidacionfecha = uneresolucionrevalidacionfecha;
    }
    
    @Basic
    @Column(name = "UNEDRE")
    public String getUnedre() {
        return unedre;
    }

    public void setUnedre(String unedre) {
        this.unedre = unedre;
    }

    @Basic
    @Column(name = "UNEUGEL")
    public String getUneugel() {
        return uneugel;
    }

    public void setUneugel(String uneugel) {
        this.uneugel = uneugel;
    }

    @Basic
    @Column(name = "UNEFLAGPROPIEDAD")
    public Integer getUneflagpropiedad() {
        return uneflagpropiedad;
    }

    public void setUneflagpropiedad(Integer uneflagpropiedad) {
        this.uneflagpropiedad = uneflagpropiedad;
    }

    @Basic
    @Column(name = "UNECODIGOMODULAR")
    public String getUnecodigomodular() {
        return unecodigomodular;
    }

    public void setUnecodigomodular(String unecodigomodular) {
        this.unecodigomodular = unecodigomodular;
    }

    @Basic
    @Column(name = "UNENEMONICO")
    public String getUnenemonico() {
        return unenemonico;
    }

    public void setUnenemonico(String unenemonico) {
        this.unenemonico = unenemonico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaUnegocio that = (SaUnegocio) o;

        if (uneunegocioid != that.uneunegocioid) return false;
        if (tuntunegocioid != that.tuntunegocioid) return false;
        if (uneestado != that.uneestado) return false;
        if (uneflagpropiedad != that.uneflagpropiedad) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (companiacodigo != null ? !companiacodigo.equals(that.companiacodigo) : that.companiacodigo != null)
            return false;
        if (unecodigo != null ? !unecodigo.equals(that.unecodigo) : that.unecodigo != null) return false;
        if (unedescripcion != null ? !unedescripcion.equals(that.unedescripcion) : that.unedescripcion != null)
            return false;
        if (uneusuariocreacion != null ? !uneusuariocreacion.equals(that.uneusuariocreacion) : that.uneusuariocreacion != null)
            return false;
        if (unefechacreacion != null ? !unefechacreacion.equals(that.unefechacreacion) : that.unefechacreacion != null)
            return false;
        if (uneipcreacion != null ? !uneipcreacion.equals(that.uneipcreacion) : that.uneipcreacion != null)
            return false;
        if (uneultimousuario != null ? !uneultimousuario.equals(that.uneultimousuario) : that.uneultimousuario != null)
            return false;
        if (uneultimafechamodif != null ? !uneultimafechamodif.equals(that.uneultimafechamodif) : that.uneultimafechamodif != null)
            return false;
        if (uneultimoip != null ? !uneultimoip.equals(that.uneultimoip) : that.uneultimoip != null) return false;
        if (uneresolucionautorizacion != null ? !uneresolucionautorizacion.equals(that.uneresolucionautorizacion) : that.uneresolucionautorizacion != null)
            return false;
        if (uneresolucionautorizacionfecha != null ? !uneresolucionautorizacionfecha.equals(that.uneresolucionautorizacionfecha) : that.uneresolucionautorizacionfecha != null)
            return false;
        if (uneresolucionrevalidacion != null ? !uneresolucionrevalidacion.equals(that.uneresolucionrevalidacion) : that.uneresolucionrevalidacion != null)
            return false;
        if (uneresolucionrevalidacionfecha != null ? !uneresolucionrevalidacionfecha.equals(that.uneresolucionrevalidacionfecha) : that.uneresolucionrevalidacionfecha != null)
            return false;
        if (unedre != null ? !unedre.equals(that.unedre) : that.unedre != null) return false;
        if (uneugel != null ? !uneugel.equals(that.uneugel) : that.uneugel != null) return false;
        if (unecodigomodular != null ? !unecodigomodular.equals(that.unecodigomodular) : that.unecodigomodular != null)
            return false;
        if (unenemonico != null ? !unenemonico.equals(that.unenemonico) : that.unenemonico != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uneunegocioid ^ (uneunegocioid >>> 32));
        result = 31 * result + (companyowner != null ? companyowner.hashCode() : 0);
        result = 31 * result + (companiacodigo != null ? companiacodigo.hashCode() : 0);
        result = 31 * result + (int) (tuntunegocioid ^ (tuntunegocioid >>> 32));
        result = 31 * result + (int) (uneestado ^ (uneestado >>> 32));
        result = 31 * result + (unecodigo != null ? unecodigo.hashCode() : 0);
        result = 31 * result + (unedescripcion != null ? unedescripcion.hashCode() : 0);
        result = 31 * result + (uneusuariocreacion != null ? uneusuariocreacion.hashCode() : 0);
        result = 31 * result + (unefechacreacion != null ? unefechacreacion.hashCode() : 0);
        result = 31 * result + (uneipcreacion != null ? uneipcreacion.hashCode() : 0);
        result = 31 * result + (uneultimousuario != null ? uneultimousuario.hashCode() : 0);
        result = 31 * result + (uneultimafechamodif != null ? uneultimafechamodif.hashCode() : 0);
        result = 31 * result + (uneultimoip != null ? uneultimoip.hashCode() : 0);
        result = 31 * result + (uneresolucionautorizacion != null ? uneresolucionautorizacion.hashCode() : 0);
        result = 31 * result + (uneresolucionautorizacionfecha != null ? uneresolucionautorizacionfecha.hashCode() : 0);
        result = 31 * result + (uneresolucionrevalidacion != null ? uneresolucionrevalidacion.hashCode() : 0);
        result = 31 * result + (uneresolucionrevalidacionfecha != null ? uneresolucionrevalidacionfecha.hashCode() : 0);
        result = 31 * result + (unedre != null ? unedre.hashCode() : 0);
        result = 31 * result + (uneugel != null ? uneugel.hashCode() : 0);
        result = 31 * result + (int) (uneflagpropiedad ^ (uneflagpropiedad >>> 32));
        result = 31 * result + (unecodigomodular != null ? unecodigomodular.hashCode() : 0);
        result = 31 * result + (unenemonico != null ? unenemonico.hashCode() : 0);
        return result;
    }
}
