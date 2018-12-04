package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_LOCALIDAD")
public class SaLocalidad implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer loclocalidadid;
    private Integer dptdptoid;
    private Integer prvprovinciaid;
    private Integer locestado;
    private String loccodigo;
    private String locdescripcion;
    private Integer locusuariocreacion;
    private Date locfechacreacion;
    private String locipcreacion;
    private Integer locultimousuario;
    private Date locultimafechamodif;
    private String locultimoip;
    private Integer paipaisid;
    private String loccodigopostal;
    private Integer conconoid;
    //private Collection<SaCampus> saCampusesByLoclocalidadid;
    
    @Id
    @Column(name = "LOCLOCALIDADID")
    public Integer getLoclocalidadid() {
        return loclocalidadid;
    }

    public void setLoclocalidadid(Integer loclocalidadid) {
        this.loclocalidadid = loclocalidadid;
    }

    @Basic
    @Column(name = "DPTDPTOID")
    public Integer getDptdptoid() {
        return dptdptoid;
    }

    public void setDptdptoid(Integer dptdptoid) {
        this.dptdptoid = dptdptoid;
    }

    @Basic
    @Column(name = "PRVPROVINCIAID")
    public Integer getPrvprovinciaid() {
        return prvprovinciaid;
    }

    public void setPrvprovinciaid(Integer prvprovinciaid) {
        this.prvprovinciaid = prvprovinciaid;
    }

    @Basic
    @Column(name = "LOCESTADO")
    public Integer getLocestado() {
        return locestado;
    }

    public void setLocestado(Integer locestado) {
        this.locestado = locestado;
    }

    @Basic
    @Column(name = "LOCCODIGO")
    public String getLoccodigo() {
        return loccodigo;
    }

    public void setLoccodigo(String loccodigo) {
        this.loccodigo = loccodigo;
    }

    @Basic
    @Column(name = "LOCDESCRIPCION")
    public String getLocdescripcion() {
        return locdescripcion;
    }

    public void setLocdescripcion(String locdescripcion) {
        this.locdescripcion = locdescripcion;
    }

    @Basic
    @Column(name = "LOCUSUARIOCREACION")
    public Integer getLocusuariocreacion() {
        return locusuariocreacion;
    }

    public void setLocusuariocreacion(Integer locusuariocreacion) {
        this.locusuariocreacion = locusuariocreacion;
    }

    @Basic
    @Column(name = "LOCFECHACREACION")
    public Date getLocfechacreacion() {
        return locfechacreacion;
    }

    public void setLocfechacreacion(Date locfechacreacion) {
        this.locfechacreacion = locfechacreacion;
    }

    @Basic
    @Column(name = "LOCIPCREACION")
    public String getLocipcreacion() {
        return locipcreacion;
    }

    public void setLocipcreacion(String locipcreacion) {
        this.locipcreacion = locipcreacion;
    }

    @Basic
    @Column(name = "LOCULTIMOUSUARIO")
    public Integer getLocultimousuario() {
        return locultimousuario;
    }

    public void setLocultimousuario(Integer locultimousuario) {
        this.locultimousuario = locultimousuario;
    }

    @Basic
    @Column(name = "LOCULTIMAFECHAMODIF")
    public Date getLocultimafechamodif() {
        return locultimafechamodif;
    }

    public void setLocultimafechamodif(Date locultimafechamodif) {
        this.locultimafechamodif = locultimafechamodif;
    }

    @Basic
    @Column(name = "LOCULTIMOIP")
    public String getLocultimoip() {
        return locultimoip;
    }

    public void setLocultimoip(String locultimoip) {
        this.locultimoip = locultimoip;
    }

    @Basic
    @Column(name = "PAIPAISID")
    public Integer getPaipaisid() {
        return paipaisid;
    }

    public void setPaipaisid(Integer paipaisid) {
        this.paipaisid = paipaisid;
    }

    @Basic
    @Column(name = "LOCCODIGOPOSTAL")
    public String getLoccodigopostal() {
        return loccodigopostal;
    }

    public void setLoccodigopostal(String loccodigopostal) {
        this.loccodigopostal = loccodigopostal;
    }

    @Basic
    @Column(name = "CONCONOID")
    public Integer getConconoid() {
        return conconoid;
    }

    public void setConconoid(Integer conconoid) {
        this.conconoid = conconoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaLocalidad that = (SaLocalidad) o;

        if (loclocalidadid != that.loclocalidadid) return false;
        if (dptdptoid != that.dptdptoid) return false;
        if (prvprovinciaid != that.prvprovinciaid) return false;
        if (locestado != that.locestado) return false;
        if (paipaisid != that.paipaisid) return false;
        if (loccodigo != null ? !loccodigo.equals(that.loccodigo) : that.loccodigo != null) return false;
        if (locdescripcion != null ? !locdescripcion.equals(that.locdescripcion) : that.locdescripcion != null)
            return false;
        if (locusuariocreacion != null ? !locusuariocreacion.equals(that.locusuariocreacion) : that.locusuariocreacion != null)
            return false;
        if (locfechacreacion != null ? !locfechacreacion.equals(that.locfechacreacion) : that.locfechacreacion != null)
            return false;
        if (locipcreacion != null ? !locipcreacion.equals(that.locipcreacion) : that.locipcreacion != null)
            return false;
        if (locultimousuario != null ? !locultimousuario.equals(that.locultimousuario) : that.locultimousuario != null)
            return false;
        if (locultimafechamodif != null ? !locultimafechamodif.equals(that.locultimafechamodif) : that.locultimafechamodif != null)
            return false;
        if (locultimoip != null ? !locultimoip.equals(that.locultimoip) : that.locultimoip != null) return false;
        if (loccodigopostal != null ? !loccodigopostal.equals(that.loccodigopostal) : that.loccodigopostal != null)
            return false;
        if (conconoid != null ? !conconoid.equals(that.conconoid) : that.conconoid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (loclocalidadid ^ (loclocalidadid >>> 32));
        result = 31 * result + (int) (dptdptoid ^ (dptdptoid >>> 32));
        result = 31 * result + (int) (prvprovinciaid ^ (prvprovinciaid >>> 32));
        result = 31 * result + (int) (locestado ^ (locestado >>> 32));
        result = 31 * result + (loccodigo != null ? loccodigo.hashCode() : 0);
        result = 31 * result + (locdescripcion != null ? locdescripcion.hashCode() : 0);
        result = 31 * result + (locusuariocreacion != null ? locusuariocreacion.hashCode() : 0);
        result = 31 * result + (locfechacreacion != null ? locfechacreacion.hashCode() : 0);
        result = 31 * result + (locipcreacion != null ? locipcreacion.hashCode() : 0);
        result = 31 * result + (locultimousuario != null ? locultimousuario.hashCode() : 0);
        result = 31 * result + (locultimafechamodif != null ? locultimafechamodif.hashCode() : 0);
        result = 31 * result + (locultimoip != null ? locultimoip.hashCode() : 0);
        result = 31 * result + (int) (paipaisid ^ (paipaisid >>> 32));
        result = 31 * result + (loccodigopostal != null ? loccodigopostal.hashCode() : 0);
        result = 31 * result + (conconoid != null ? conconoid.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "saLocalidadByLoclocalidadid")
    public Collection<SaCampus> getSaCampusesByLoclocalidadid() {
        return saCampusesByLoclocalidadid;
    }

    public void setSaCampusesByLoclocalidadid(Collection<SaCampus> saCampusesByLoclocalidadid) {
        this.saCampusesByLoclocalidadid = saCampusesByLoclocalidadid;
    }*/

}
