package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOSECCION")
public class SaTiposeccion extends Entidad{
	
    private Integer tsctiposeccionid;
    private Integer tscestado;
    private String tsccodigo;
    private String tscdescripcion;
    private Integer tscusuariocreacion;
    private Date tscfechacreacion;
    private String tscipcreacion;
    private Integer tscultimousuario;
    private Date tscultimafechamodif;
    private String tscultimoip;
    //private Collection<SaSeccionmst> saSeccionmstsByTsctiposeccionid;

    @Id
    @Column(name = "TSCTIPOSECCIONID")
    public Integer getTsctiposeccionid() {
        return tsctiposeccionid;
    }

    public void setTsctiposeccionid(Integer tsctiposeccionid) {
        this.tsctiposeccionid = tsctiposeccionid;
    }

    @Basic
    @Column(name = "TSCESTADO")
    public Integer getTscestado() {
        return tscestado;
    }

    public void setTscestado(Integer tscestado) {
        this.tscestado = tscestado;
    }

    @Basic
    @Column(name = "TSCCODIGO")
    public String getTsccodigo() {
        return tsccodigo;
    }

    public void setTsccodigo(String tsccodigo) {
        this.tsccodigo = tsccodigo;
    }

    @Basic
    @Column(name = "TSCDESCRIPCION")
    public String getTscdescripcion() {
        return tscdescripcion;
    }

    public void setTscdescripcion(String tscdescripcion) {
        this.tscdescripcion = tscdescripcion;
    }

    @Basic
    @Column(name = "TSCUSUARIOCREACION")
    public Integer getTscusuariocreacion() {
        return tscusuariocreacion;
    }

    public void setTscusuariocreacion(Integer tscusuariocreacion) {
        this.tscusuariocreacion = tscusuariocreacion;
    }

    @Basic
    @Column(name = "TSCFECHACREACION")
    public Date getTscfechacreacion() {
        return tscfechacreacion;
    }

    public void setTscfechacreacion(Date tscfechacreacion) {
        this.tscfechacreacion = tscfechacreacion;
    }

    @Basic
    @Column(name = "TSCIPCREACION")
    public String getTscipcreacion() {
        return tscipcreacion;
    }

    public void setTscipcreacion(String tscipcreacion) {
        this.tscipcreacion = tscipcreacion;
    }

    @Basic
    @Column(name = "TSCULTIMOUSUARIO")
    public Integer getTscultimousuario() {
        return tscultimousuario;
    }

    public void setTscultimousuario(Integer tscultimousuario) {
        this.tscultimousuario = tscultimousuario;
    }

    @Basic
    @Column(name = "TSCULTIMAFECHAMODIF")
    public Date getTscultimafechamodif() {
        return tscultimafechamodif;
    }

    public void setTscultimafechamodif(Date tscultimafechamodif) {
        this.tscultimafechamodif = tscultimafechamodif;
    }

    @Basic
    @Column(name = "TSCULTIMOIP")
    public String getTscultimoip() {
        return tscultimoip;
    }

    public void setTscultimoip(String tscultimoip) {
        this.tscultimoip = tscultimoip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTiposeccion that = (SaTiposeccion) o;

        if (tsctiposeccionid != that.tsctiposeccionid) return false;
        if (tscestado != that.tscestado) return false;
        if (tsccodigo != null ? !tsccodigo.equals(that.tsccodigo) : that.tsccodigo != null) return false;
        if (tscdescripcion != null ? !tscdescripcion.equals(that.tscdescripcion) : that.tscdescripcion != null)
            return false;
        if (tscusuariocreacion != null ? !tscusuariocreacion.equals(that.tscusuariocreacion) : that.tscusuariocreacion != null)
            return false;
        if (tscfechacreacion != null ? !tscfechacreacion.equals(that.tscfechacreacion) : that.tscfechacreacion != null)
            return false;
        if (tscipcreacion != null ? !tscipcreacion.equals(that.tscipcreacion) : that.tscipcreacion != null)
            return false;
        if (tscultimousuario != null ? !tscultimousuario.equals(that.tscultimousuario) : that.tscultimousuario != null)
            return false;
        if (tscultimafechamodif != null ? !tscultimafechamodif.equals(that.tscultimafechamodif) : that.tscultimafechamodif != null)
            return false;
        if (tscultimoip != null ? !tscultimoip.equals(that.tscultimoip) : that.tscultimoip != null) return false;

        return true;
    }

//    @OneToMany(mappedBy = "saTiposeccionByTsctiposeccionid")
//    public Collection<SaSeccionmst> getSaSeccionmstsByTsctiposeccionid() {
//        return saSeccionmstsByTsctiposeccionid;
//    }

//    public void setSaSeccionmstsByTsctiposeccionid(Collection<SaSeccionmst> saSeccionmstsByTsctiposeccionid) {
//        this.saSeccionmstsByTsctiposeccionid = saSeccionmstsByTsctiposeccionid;
//    }
    
    
}
