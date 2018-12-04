package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOAULA")
public class SaTipoaula extends Entidad {
	
	private Integer tautipoaulaid;
	private Integer tauestado;
	private String taucodigo;
	private String taudescripcion;
	private Integer tauvacantes;
	private Integer tauusuariocreacion;
	private Date taufechacreacion;
	private String tauipcreacion;
	private Integer tauultimousuario;
	private Date tauultimafechamodif;
	private String tauultimoip;

	@Id
	@Column(name = "TAUTIPOAULAID")
	public Integer getTautipoaulaid() {
		return tautipoaulaid;
	}

	public void setTautipoaulaid(Integer tautipoaulaid) {
		this.tautipoaulaid = tautipoaulaid;
	}

	@Basic
	@Column(name = "TAUESTADO")
	public Integer getTauestado() {
		return tauestado;
	}

	public void setTauestado(Integer tauestado) {
		this.tauestado = tauestado;
	}

	@Basic
	@Column(name = "TAUCODIGO")
	public String getTaucodigo() {
		return taucodigo;
	}

	public void setTaucodigo(String taucodigo) {
		this.taucodigo = taucodigo;
	}

	@Basic
	@Column(name = "TAUDESCRIPCION")
	public String getTaudescripcion() {
		return taudescripcion;
	}

	public void setTaudescripcion(String taudescripcion) {
		this.taudescripcion = taudescripcion;
	}

	@Basic
	@Column(name = "TAUVACANTES")
	public Integer getTauvacantes() {
		return tauvacantes;
	}

	public void setTauvacantes(Integer tauvacantes) {
		this.tauvacantes = tauvacantes;
	}

	@Basic
	@Column(name = "TAUUSUARIOCREACION")
	public Integer getTauusuariocreacion() {
		return tauusuariocreacion;
	}

	public void setTauusuariocreacion(Integer tauusuariocreacion) {
		this.tauusuariocreacion = tauusuariocreacion;
	}

	@Basic
	@Column(name = "TAUFECHACREACION")
	public Date getTaufechacreacion() {
		return taufechacreacion;
	}

	public void setTaufechacreacion(Date taufechacreacion) {
		this.taufechacreacion = taufechacreacion;
	}

	@Basic
	@Column(name = "TAUIPCREACION")
	public String getTauipcreacion() {
		return tauipcreacion;
	}

	public void setTauipcreacion(String tauipcreacion) {
		this.tauipcreacion = tauipcreacion;
	}

	@Basic
	@Column(name = "TAUULTIMOUSUARIO")
	public Integer getTauultimousuario() {
		return tauultimousuario;
	}

	public void setTauultimousuario(Integer tauultimousuario) {
		this.tauultimousuario = tauultimousuario;
	}

	@Basic
	@Column(name = "TAUULTIMAFECHAMODIF")
	public Date getTauultimafechamodif() {
		return tauultimafechamodif;
	}

	public void setTauultimafechamodif(Date tauultimafechamodif) {
		this.tauultimafechamodif = tauultimafechamodif;
	}

	@Basic
	@Column(name = "TAUULTIMOIP")
	public String getTauultimoip() {
		return tauultimoip;
	}

	public void setTauultimoip(String tauultimoip) {
		this.tauultimoip = tauultimoip;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SaTipoaula that = (SaTipoaula) o;

		if (tautipoaulaid != that.tautipoaulaid)
			return false;
		if (tauestado != that.tauestado)
			return false;
		if (tauvacantes != that.tauvacantes)
			return false;
		if (taucodigo != null ? !taucodigo.equals(that.taucodigo) : that.taucodigo != null)
			return false;
		if (taudescripcion != null ? !taudescripcion.equals(that.taudescripcion) : that.taudescripcion != null)
			return false;
		if (tauusuariocreacion != null ? !tauusuariocreacion.equals(that.tauusuariocreacion)
				: that.tauusuariocreacion != null)
			return false;
		if (taufechacreacion != null ? !taufechacreacion.equals(that.taufechacreacion) : that.taufechacreacion != null)
			return false;
		if (tauipcreacion != null ? !tauipcreacion.equals(that.tauipcreacion) : that.tauipcreacion != null)
			return false;
		if (tauultimousuario != null ? !tauultimousuario.equals(that.tauultimousuario) : that.tauultimousuario != null)
			return false;
		if (tauultimafechamodif != null ? !tauultimafechamodif.equals(that.tauultimafechamodif)
				: that.tauultimafechamodif != null)
			return false;
		if (tauultimoip != null ? !tauultimoip.equals(that.tauultimoip) : that.tauultimoip != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (tautipoaulaid ^ (tautipoaulaid >>> 32));
		result = 31 * result + (int) (tauestado ^ (tauestado >>> 32));
		result = 31 * result + (taucodigo != null ? taucodigo.hashCode() : 0);
		result = 31 * result + (taudescripcion != null ? taudescripcion.hashCode() : 0);
		result = 31 * result + (int) (tauvacantes ^ (tauvacantes >>> 32));
		result = 31 * result + (tauusuariocreacion != null ? tauusuariocreacion.hashCode() : 0);
		result = 31 * result + (taufechacreacion != null ? taufechacreacion.hashCode() : 0);
		result = 31 * result + (tauipcreacion != null ? tauipcreacion.hashCode() : 0);
		result = 31 * result + (tauultimousuario != null ? tauultimousuario.hashCode() : 0);
		result = 31 * result + (tauultimafechamodif != null ? tauultimafechamodif.hashCode() : 0);
		result = 31 * result + (tauultimoip != null ? tauultimoip.hashCode() : 0);
		return result;
	}
}
