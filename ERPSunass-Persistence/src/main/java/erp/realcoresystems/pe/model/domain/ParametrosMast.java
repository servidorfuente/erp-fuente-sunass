package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="PARAMETROSMAST")
public class ParametrosMast  extends Entidad{
	
	private static final long serialVersionUID = 1L;
	private ParametrosMastPK id;
	private String descripcionparametro;
	private String estado;
	private String explicacion;
	private String explicacionadicional;
	private Date fecha;
	private String financecomunflag;
	private BigDecimal numero;
	private String texto;
	private String tipodedatoflag;
	private Date ultimafechamodif;
	private String ultimousuario;

	public ParametrosMast() {
		id = new ParametrosMastPK();
	}


	@EmbeddedId
	public ParametrosMastPK getId() {
		return this.id;
	}

	public void setId(ParametrosMastPK id) {
		this.id = id;
	}


	public String getDescripcionparametro() {
		return this.descripcionparametro;
	}

	public void setDescripcionparametro(String descripcionparametro) {
		this.descripcionparametro = descripcionparametro;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}


	public String getExplicacionadicional() {
		return this.explicacionadicional;
	}

	public void setExplicacionadicional(String explicacionadicional) {
		this.explicacionadicional = explicacionadicional;
	}


	
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getFinancecomunflag() {
		return this.financecomunflag;
	}

	public void setFinancecomunflag(String financecomunflag) {
		this.financecomunflag = financecomunflag;
	}


	public BigDecimal getNumero() {
		return this.numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}


	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getTipodedatoflag() {
		return this.tipodedatoflag;
	}

	public void setTipodedatoflag(String tipodedatoflag) {
		this.tipodedatoflag = tipodedatoflag;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}


	@Override
	public String toString() {
		return "ParametrosMast [id=" + id + ", descripcionparametro=" + descripcionparametro + ", estado=" + estado
				+ ", explicacion=" + explicacion + ", explicacionadicional=" + explicacionadicional + ", fecha=" + fecha
				+ ", financecomunflag=" + financecomunflag + ", numero=" + numero + ", texto=" + texto
				+ ", tipodedatoflag=" + tipodedatoflag + ", ultimafechamodif=" + ultimafechamodif + ", ultimousuario="
				+ ultimousuario + "]";
	}

	
}