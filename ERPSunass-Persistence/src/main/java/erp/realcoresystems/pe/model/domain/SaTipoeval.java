package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import erp.realcoresystems.pe.model.util.BooleanToIntegerConverter;

import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOEVAL")
public class SaTipoeval extends Entidad {
	private Integer uneunegocioid;
	private Integer moemestudioid;
	private Integer tevtipoevalid;
	private Integer tevestado;
	private String tevcodigo;
	private String tevprefijo;
	private String tevdescripcion;
	private String tevdescripcioncorta;
	private Integer tevusuariocreacion;
	private Date tevfechacreacion;
	private String tevipcreacion;
	private Integer tevultimousuario;
	private Date tevultimafechamodif;
	private String tevultimoip;
	private Boolean tevrolexamen;

	@Id
	@Column(name = "UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Id
	@Column(name = "MOEMESTUDIOID")
	public Integer getMoemestudioid() {
		return moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	@Id
	@Column(name = "TEVTIPOEVALID")
	public Integer getTevtipoevalid() {
		return tevtipoevalid;
	}

	public void setTevtipoevalid(Integer tevtipoevalid) {
		this.tevtipoevalid = tevtipoevalid;
	}

	@Basic
	@Column(name = "TEVESTADO")
	public Integer getTevestado() {
		return tevestado;
	}

	public void setTevestado(Integer tevestado) {
		this.tevestado = tevestado;
	}

	@Basic
	@Column(name = "TEVCODIGO")
	public String getTevcodigo() {
		return tevcodigo;
	}

	public void setTevcodigo(String tevcodigo) {
		this.tevcodigo = tevcodigo;
	}

	@Basic
	@Column(name = "TEVPREFIJO")
	public String getTevprefijo() {
		return tevprefijo;
	}

	public void setTevprefijo(String tevprefijo) {
		this.tevprefijo = tevprefijo;
	}

	@Basic
	@Column(name = "TEVDESCRIPCION")
	public String getTevdescripcion() {
		return tevdescripcion;
	}

	public void setTevdescripcion(String tevdescripcion) {
		this.tevdescripcion = tevdescripcion;
	}

	@Basic
	@Column(name = "TEVDESCRIPCIONCORTA")
	public String getTevdescripcioncorta() {
		return tevdescripcioncorta;
	}

	public void setTevdescripcioncorta(String tevdescripcioncorta) {
		this.tevdescripcioncorta = tevdescripcioncorta;
	}

	@Basic
	@Column(name = "TEVUSUARIOCREACION")
	public Integer getTevusuariocreacion() {
		return tevusuariocreacion;
	}

	public void setTevusuariocreacion(Integer tevusuariocreacion) {
		this.tevusuariocreacion = tevusuariocreacion;
	}

	@Basic
	@Column(name = "TEVFECHACREACION")
	public Date getTevfechacreacion() {
		return tevfechacreacion;
	}

	public void setTevfechacreacion(Date tevfechacreacion) {
		this.tevfechacreacion = tevfechacreacion;
	}

	@Basic
	@Column(name = "TEVIPCREACION")
	public String getTevipcreacion() {
		return tevipcreacion;
	}

	public void setTevipcreacion(String tevipcreacion) {
		this.tevipcreacion = tevipcreacion;
	}

	@Basic
	@Column(name = "TEVULTIMOUSUARIO")
	public Integer getTevultimousuario() {
		return tevultimousuario;
	}

	public void setTevultimousuario(Integer tevultimousuario) {
		this.tevultimousuario = tevultimousuario;
	}

	@Basic
	@Column(name = "TEVULTIMAFECHAMODIF")
	public Date getTevultimafechamodif() {
		return tevultimafechamodif;
	}

	public void setTevultimafechamodif(Date tevultimafechamodif) {
		this.tevultimafechamodif = tevultimafechamodif;
	}

	@Basic
	@Column(name = "TEVULTIMOIP")
	public String getTevultimoip() {
		return tevultimoip;
	}

	public void setTevultimoip(String tevultimoip) {
		this.tevultimoip = tevultimoip;
	}

	@Basic
	@Column(name = "TEVROLEXAMEN")
	@Convert(converter = BooleanToIntegerConverter.class)
	public Boolean getTevrolexamen() {
		return tevrolexamen;
	}

	public void setTevrolexamen(Boolean tevrolexamen) {
		this.tevrolexamen = tevrolexamen;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SaTipoeval that = (SaTipoeval) o;

		if (uneunegocioid != that.uneunegocioid)
			return false;
		if (moemestudioid != that.moemestudioid)
			return false;
		if (tevtipoevalid != that.tevtipoevalid)
			return false;
		if (tevestado != that.tevestado)
			return false;
		if (tevcodigo != null ? !tevcodigo.equals(that.tevcodigo) : that.tevcodigo != null)
			return false;
		if (tevprefijo != null ? !tevprefijo.equals(that.tevprefijo) : that.tevprefijo != null)
			return false;
		if (tevdescripcion != null ? !tevdescripcion.equals(that.tevdescripcion) : that.tevdescripcion != null)
			return false;
		if (tevdescripcioncorta != null ? !tevdescripcioncorta.equals(that.tevdescripcioncorta)
				: that.tevdescripcioncorta != null)
			return false;
		if (tevusuariocreacion != null ? !tevusuariocreacion.equals(that.tevusuariocreacion)
				: that.tevusuariocreacion != null)
			return false;
		if (tevfechacreacion != null ? !tevfechacreacion.equals(that.tevfechacreacion) : that.tevfechacreacion != null)
			return false;
		if (tevipcreacion != null ? !tevipcreacion.equals(that.tevipcreacion) : that.tevipcreacion != null)
			return false;
		if (tevultimousuario != null ? !tevultimousuario.equals(that.tevultimousuario) : that.tevultimousuario != null)
			return false;
		if (tevultimafechamodif != null ? !tevultimafechamodif.equals(that.tevultimafechamodif)
				: that.tevultimafechamodif != null)
			return false;
		if (tevultimoip != null ? !tevultimoip.equals(that.tevultimoip) : that.tevultimoip != null)
			return false;
		// if (tevrolexamen != null ? !tevrolexamen.equals(that.tevrolexamen) :
		// that.tevrolexamen != null)
		// return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (uneunegocioid ^ (uneunegocioid >>> 32));
		result = 31 * result + (int) (moemestudioid ^ (moemestudioid >>> 32));
		result = 31 * result + (int) (tevtipoevalid ^ (tevtipoevalid >>> 32));
		result = 31 * result + (int) (tevestado ^ (tevestado >>> 32));
		result = 31 * result + (tevcodigo != null ? tevcodigo.hashCode() : 0);
		result = 31 * result + (tevprefijo != null ? tevprefijo.hashCode() : 0);
		result = 31 * result + (tevdescripcion != null ? tevdescripcion.hashCode() : 0);
		result = 31 * result + (tevdescripcioncorta != null ? tevdescripcioncorta.hashCode() : 0);
		result = 31 * result + (tevusuariocreacion != null ? tevusuariocreacion.hashCode() : 0);
		result = 31 * result + (tevfechacreacion != null ? tevfechacreacion.hashCode() : 0);
		result = 31 * result + (tevipcreacion != null ? tevipcreacion.hashCode() : 0);
		result = 31 * result + (tevultimousuario != null ? tevultimousuario.hashCode() : 0);
		result = 31 * result + (tevultimafechamodif != null ? tevultimafechamodif.hashCode() : 0);
		result = 31 * result + (tevultimoip != null ? tevultimoip.hashCode() : 0);
		// result = 31 * result + (tevrolexamen != null ?
		// tevrolexamen.hashCode() : 0);
		return result;
	}
}
