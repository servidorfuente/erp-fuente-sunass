package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by mamania on 29/12/2015.
 */
@Entity
@Table(name = "MA_MISCELANEOSHEADER")
//@IdClass(MaMiscelaneosheaderPK.class)
public class MaMiscelaneosheader extends Entidad{
    private String aplicacioncodigo;
    private String codigotabla;
    private String compania;
    private String descripcionlocal;
    private String descripcionextranjera;
    private String estado;
    private String ultimousuario;
    private Date ultimafechamodif;
    
    @Transient
    private String idCompuesto;

    @Id
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Id
    @Column(name = "CODIGOTABLA")
    public String getCodigotabla() {
        return codigotabla;
    }

    public void setCodigotabla(String codigotabla) {
        this.codigotabla = codigotabla;
    }

    @Id
    @Column(name = "COMPANIA")
    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Basic
    @Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    @Basic
    @Column(name = "DESCRIPCIONEXTRANJERA")
    public String getDescripcionextranjera() {
        return descripcionextranjera;
    }

    public void setDescripcionextranjera(String descripcionextranjera) {
        this.descripcionextranjera = descripcionextranjera;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    @Basic
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaMiscelaneosheader that = (MaMiscelaneosheader) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (codigotabla != null ? !codigotabla.equals(that.codigotabla) : that.codigotabla != null) return false;
        if (compania != null ? !compania.equals(that.compania) : that.compania != null) return false;
        if (descripcionlocal != null ? !descripcionlocal.equals(that.descripcionlocal) : that.descripcionlocal != null)
            return false;
        if (descripcionextranjera != null ? !descripcionextranjera.equals(that.descripcionextranjera) : that.descripcionextranjera != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (codigotabla != null ? codigotabla.hashCode() : 0);
        result = 31 * result + (compania != null ? compania.hashCode() : 0);
        result = 31 * result + (descripcionlocal != null ? descripcionlocal.hashCode() : 0);
        result = 31 * result + (descripcionextranjera != null ? descripcionextranjera.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        return result;
    }

    @Transient
	public String getIdCompuesto() {
		idCompuesto = aplicacioncodigo+"_"+codigotabla+"_"+compania;
		return idCompuesto;
	}

	public void setIdCompuesto(String idCompuesto) {
		this.idCompuesto = idCompuesto;
	}
    
    
}
