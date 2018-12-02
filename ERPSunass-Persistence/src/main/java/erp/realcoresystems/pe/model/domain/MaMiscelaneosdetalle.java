package erp.realcoresystems.pe.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by mamania on 29/12/2015.
 */
@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name = "MA_MISCELANEOSDETALLE")
public class MaMiscelaneosdetalle extends Entidad{
	
    private String aplicacioncodigo;
    private String codigotabla;
    private String compania;
    private String codigoelemento;
    private String descripcionlocal;
    private String descripcionextranjera;
    private Double valornumerico;
    private String valorcodigo1;
    private String valorcodigo2;
    private String valorcodigo3;
    private String valorcodigo4;
    private String valorcodigo5;
    private String valorcodigo6;
    private String valorcodigo7;
    private String valorcodigo8;
    private String valorcodigo9;
    private String valorcodigo0;
    private Date valorfecha;
    private Long valorentero1;
    private Long valorentero2;
    private Long valorentero3;
    private Long valorentero4;
    private Long valorentero5;
    private Long valorentero6;
    private Long valorentero7;
    private Long valorentero8;
    private Long valorentero9;
    private Long valorentero0;
    private String estado;
    private Long estadoint;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String dataTexto;
    
    @Transient
    private List<String> listaRepeat;
    
    @Transient
    private String idCompuesto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaMiscelaneosdetalle that = (MaMiscelaneosdetalle) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (codigotabla != null ? !codigotabla.equals(that.codigotabla) : that.codigotabla != null) return false;
        if (compania != null ? !compania.equals(that.compania) : that.compania != null) return false;
        if (codigoelemento != null ? !codigoelemento.equals(that.codigoelemento) : that.codigoelemento != null)
            return false;
        if (descripcionlocal != null ? !descripcionlocal.equals(that.descripcionlocal) : that.descripcionlocal != null)
            return false;
        if (descripcionextranjera != null ? !descripcionextranjera.equals(that.descripcionextranjera) : that.descripcionextranjera != null)
            return false;
        if (valornumerico != null ? !valornumerico.equals(that.valornumerico) : that.valornumerico != null)
            return false;
        if (valorcodigo1 != null ? !valorcodigo1.equals(that.valorcodigo1) : that.valorcodigo1 != null) return false;
        if (valorcodigo2 != null ? !valorcodigo2.equals(that.valorcodigo2) : that.valorcodigo2 != null) return false;
        if (valorcodigo3 != null ? !valorcodigo3.equals(that.valorcodigo3) : that.valorcodigo3 != null) return false;
        if (valorcodigo4 != null ? !valorcodigo4.equals(that.valorcodigo4) : that.valorcodigo4 != null) return false;
        if (valorcodigo5 != null ? !valorcodigo5.equals(that.valorcodigo5) : that.valorcodigo5 != null) return false;
        if (valorcodigo6 != null ? !valorcodigo6.equals(that.valorcodigo6) : that.valorcodigo6 != null) return false;
        if (valorcodigo7 != null ? !valorcodigo7.equals(that.valorcodigo7) : that.valorcodigo7 != null) return false;
        if (valorcodigo8 != null ? !valorcodigo8.equals(that.valorcodigo8) : that.valorcodigo8 != null) return false;
        if (valorcodigo9 != null ? !valorcodigo9.equals(that.valorcodigo9) : that.valorcodigo9 != null) return false;
        if (valorcodigo0 != null ? !valorcodigo0.equals(that.valorcodigo0) : that.valorcodigo0 != null) return false;
        if (valorfecha != null ? !valorfecha.equals(that.valorfecha) : that.valorfecha != null) return false;
        if (valorentero1 != null ? !valorentero1.equals(that.valorentero1) : that.valorentero1 != null) return false;
        if (valorentero2 != null ? !valorentero2.equals(that.valorentero2) : that.valorentero2 != null) return false;
        if (valorentero3 != null ? !valorentero3.equals(that.valorentero3) : that.valorentero3 != null) return false;
        if (valorentero4 != null ? !valorentero4.equals(that.valorentero4) : that.valorentero4 != null) return false;
        if (valorentero5 != null ? !valorentero5.equals(that.valorentero5) : that.valorentero5 != null) return false;
        if (valorentero6 != null ? !valorentero6.equals(that.valorentero6) : that.valorentero6 != null) return false;
        if (valorentero7 != null ? !valorentero7.equals(that.valorentero7) : that.valorentero7 != null) return false;
        if (valorentero8 != null ? !valorentero8.equals(that.valorentero8) : that.valorentero8 != null) return false;
        if (valorentero9 != null ? !valorentero9.equals(that.valorentero9) : that.valorentero9 != null) return false;
        if (valorentero0 != null ? !valorentero0.equals(that.valorentero0) : that.valorentero0 != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (estadoint != null ? !estadoint.equals(that.estadoint) : that.estadoint != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;

        return true;
    }

    @Id
    @javax.persistence.Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    @Id
    @javax.persistence.Column(name = "CODIGOELEMENTO")
    public String getCodigoelemento() {
        return codigoelemento;
    }

    @Id
    @javax.persistence.Column(name = "CODIGOTABLA")
    public String getCodigotabla() {
        return codigotabla;
    }

    @Id
    @javax.persistence.Column(name = "COMPANIA")
    public String getCompania() {
        return compania;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONEXTRANJERA")
    public String getDescripcionextranjera() {
        return descripcionextranjera;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    @Basic
    @javax.persistence.Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    @Basic
    @javax.persistence.Column(name = "ESTADOINT")
    public Long getEstadoint() {
        return estadoint;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO0")
    public String getValorcodigo0() {
        return valorcodigo0;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO1")
    public String getValorcodigo1() {
        return valorcodigo1;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO2")
    public String getValorcodigo2() {
        return valorcodigo2;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO3")
    public String getValorcodigo3() {
        return valorcodigo3;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO4")
    public String getValorcodigo4() {
        return valorcodigo4;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO5")
    public String getValorcodigo5() {
        return valorcodigo5;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO6")
    public String getValorcodigo6() {
        return valorcodigo6;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO7")
    public String getValorcodigo7() {
        return valorcodigo7;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO8")
    public String getValorcodigo8() {
        return valorcodigo8;
    }

    @Basic
    @javax.persistence.Column(name = "VALORCODIGO9")
    public String getValorcodigo9() {
        return valorcodigo9;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO0")
    public Long getValorentero0() {
        return valorentero0;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO1")
    public Long getValorentero1() {
        return valorentero1;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO2")
    public Long getValorentero2() {
        return valorentero2;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO3")
    public Long getValorentero3() {
        return valorentero3;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO4")
    public Long getValorentero4() {
        return valorentero4;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO5")
    public Long getValorentero5() {
        return valorentero5;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO6")
    public Long getValorentero6() {
        return valorentero6;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO7")
    public Long getValorentero7() {
        return valorentero7;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO8")
    public Long getValorentero8() {
        return valorentero8;
    }

    @Basic
    @javax.persistence.Column(name = "VALORENTERO9")
    public Long getValorentero9() {
        return valorentero9;
    }

    @Basic
    @javax.persistence.Column(name = "VALORFECHA")
    public Date getValorfecha() {
        return valorfecha;
    }

    @Basic
    @javax.persistence.Column(name = "VALORNUMERICO")
    public Double getValornumerico() {
        return valornumerico;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (codigotabla != null ? codigotabla.hashCode() : 0);
        result = 31 * result + (compania != null ? compania.hashCode() : 0);
        result = 31 * result + (codigoelemento != null ? codigoelemento.hashCode() : 0);
        result = 31 * result + (descripcionlocal != null ? descripcionlocal.hashCode() : 0);
        result = 31 * result + (descripcionextranjera != null ? descripcionextranjera.hashCode() : 0);
        result = 31 * result + (valornumerico != null ? valornumerico.hashCode() : 0);
        result = 31 * result + (valorcodigo1 != null ? valorcodigo1.hashCode() : 0);
        result = 31 * result + (valorcodigo2 != null ? valorcodigo2.hashCode() : 0);
        result = 31 * result + (valorcodigo3 != null ? valorcodigo3.hashCode() : 0);
        result = 31 * result + (valorcodigo4 != null ? valorcodigo4.hashCode() : 0);
        result = 31 * result + (valorcodigo5 != null ? valorcodigo5.hashCode() : 0);
        result = 31 * result + (valorcodigo6 != null ? valorcodigo6.hashCode() : 0);
        result = 31 * result + (valorcodigo7 != null ? valorcodigo7.hashCode() : 0);
        result = 31 * result + (valorcodigo8 != null ? valorcodigo8.hashCode() : 0);
        result = 31 * result + (valorcodigo9 != null ? valorcodigo9.hashCode() : 0);
        result = 31 * result + (valorcodigo0 != null ? valorcodigo0.hashCode() : 0);
        result = 31 * result + (valorfecha != null ? valorfecha.hashCode() : 0);
        result = 31 * result + (valorentero1 != null ? valorentero1.hashCode() : 0);
        result = 31 * result + (valorentero2 != null ? valorentero2.hashCode() : 0);
        result = 31 * result + (valorentero3 != null ? valorentero3.hashCode() : 0);
        result = 31 * result + (valorentero4 != null ? valorentero4.hashCode() : 0);
        result = 31 * result + (valorentero5 != null ? valorentero5.hashCode() : 0);
        result = 31 * result + (valorentero6 != null ? valorentero6.hashCode() : 0);
        result = 31 * result + (valorentero7 != null ? valorentero7.hashCode() : 0);
        result = 31 * result + (valorentero8 != null ? valorentero8.hashCode() : 0);
        result = 31 * result + (valorentero9 != null ? valorentero9.hashCode() : 0);
        result = 31 * result + (valorentero0 != null ? valorentero0.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (estadoint != null ? estadoint.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        return result;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    public void setCodigoelemento(String codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public void setCodigotabla(String codigotabla) {
        this.codigotabla = codigotabla;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setDescripcionextranjera(String descripcionextranjera) {
        this.descripcionextranjera = descripcionextranjera;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEstadoint(Long estadoint) {
        this.estadoint = estadoint;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    public void setValorcodigo0(String valorcodigo0) {
        this.valorcodigo0 = valorcodigo0;
    }

    public void setValorcodigo1(String valorcodigo1) {
        this.valorcodigo1 = valorcodigo1;
    }

    public void setValorcodigo2(String valorcodigo2) {
        this.valorcodigo2 = valorcodigo2;
    }

    public void setValorcodigo3(String valorcodigo3) {
        this.valorcodigo3 = valorcodigo3;
    }

    public void setValorcodigo4(String valorcodigo4) {
        this.valorcodigo4 = valorcodigo4;
    }

    public void setValorcodigo5(String valorcodigo5) {
        this.valorcodigo5 = valorcodigo5;
    }

    public void setValorcodigo6(String valorcodigo6) {
        this.valorcodigo6 = valorcodigo6;
    }

    public void setValorcodigo7(String valorcodigo7) {
        this.valorcodigo7 = valorcodigo7;
    }

    public void setValorcodigo8(String valorcodigo8) {
        this.valorcodigo8 = valorcodigo8;
    }

    public void setValorcodigo9(String valorcodigo9) {
        this.valorcodigo9 = valorcodigo9;
    }

    public void setValorentero0(Long valorentero0) {
        this.valorentero0 = valorentero0;
    }

    public void setValorentero1(Long valorentero1) {
        this.valorentero1 = valorentero1;
    }

    public void setValorentero2(Long valorentero2) {
        this.valorentero2 = valorentero2;
    }

    public void setValorentero3(Long valorentero3) {
        this.valorentero3 = valorentero3;
    }

    public void setValorentero4(Long valorentero4) {
        this.valorentero4 = valorentero4;
    }

    public void setValorentero5(Long valorentero5) {
        this.valorentero5 = valorentero5;
    }

    public void setValorentero6(Long valorentero6) {
        this.valorentero6 = valorentero6;
    }

    public void setValorentero7(Long valorentero7) {
        this.valorentero7 = valorentero7;
    }

    public void setValorentero8(Long valorentero8) {
        this.valorentero8 = valorentero8;
    }

    public void setValorentero9(Long valorentero9) {
        this.valorentero9 = valorentero9;
    }

    public void setValorfecha(Date valorfecha) {
        this.valorfecha = valorfecha;
    }

    public void setValornumerico(Double valornumerico) {
        this.valornumerico = valornumerico;
    }
    
    
    //@Column(name="DATATEXTO")
	@Transient
    public String getDataTexto() {
		return dataTexto;
	}

	public void setDataTexto(String dataTexto) {
		this.dataTexto = dataTexto;
	}

	@Override
	public String toString() {
		return "MaMiscelaneosdetalle [aplicacioncodigo=" + aplicacioncodigo + ", codigotabla=" + codigotabla
				+ ", compania=" + compania + ", codigoelemento=" + codigoelemento + ", descripcionlocal="
				+ descripcionlocal + ", descripcionextranjera=" + descripcionextranjera + ", valornumerico="
				+ valornumerico + ", valorcodigo1=" + valorcodigo1 + ", valorcodigo2=" + valorcodigo2
				+ ", valorcodigo3=" + valorcodigo3 + ", valorcodigo4=" + valorcodigo4 + ", valorcodigo5=" + valorcodigo5
				+ ", valorcodigo6=" + valorcodigo6 + ", valorcodigo7=" + valorcodigo7 + ", valorcodigo8=" + valorcodigo8
				+ ", valorcodigo9=" + valorcodigo9 + ", valorcodigo0=" + valorcodigo0 + ", valorfecha=" + valorfecha
				+ ", valorentero1=" + valorentero1 + ", valorentero2=" + valorentero2 + ", valorentero3=" + valorentero3
				+ ", valorentero4=" + valorentero4 + ", valorentero5=" + valorentero5 + ", valorentero6=" + valorentero6
				+ ", valorentero7=" + valorentero7 + ", valorentero8=" + valorentero8 + ", valorentero9=" + valorentero9
				+ ", valorentero0=" + valorentero0 + ", estado=" + estado + ", estadoint=" + estadoint
				+ ", ultimousuario=" + ultimousuario + ", ultimafechamodif=" + ultimafechamodif + "]";
	}

	@Transient
	public List<String> getListaRepeat() {
		return listaRepeat;
	}

	public void setListaRepeat(List<String> listaRepeat) {
		this.listaRepeat = listaRepeat;
	}

	@Transient
	public String getIdCompuesto() {
		idCompuesto = aplicacioncodigo+"_"+codigotabla+"_"+compania+"_"+codigoelemento;
		return idCompuesto;
	}

	public void setIdCompuesto(String idCompuesto) {
		this.idCompuesto = idCompuesto;
	}
	
	
    
    
}
