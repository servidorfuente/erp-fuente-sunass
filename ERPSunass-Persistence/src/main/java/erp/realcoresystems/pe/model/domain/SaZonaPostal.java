package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SA_ZONAPOSTAL")
public class SaZonaPostal  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String paicodigo;
	private String dptcodigo;
	private String zptcodigo;
	private String prvcodigo;
	private String zptdescripcion;
	private Integer zptestado;
	private Date zptfechacreacion;
	private String zptipcreacion;
	private Date zptultimafechamodif;
	private String zptultimoip;
	private Integer zptultimousuario;
	private Integer zptusuariocreacion;

	@Id
	public String getZptcodigo() {
		return zptcodigo;
	}

	public void setZptcodigo(String zptcodigo) {
		this.zptcodigo = zptcodigo;
	}
	
	public String getPaicodigo() {
		return paicodigo;
	}

	public void setPaicodigo(String paicodigo) {
		this.paicodigo = paicodigo;
	}

	public String getDptcodigo() {
		return dptcodigo;
	}

	public void setDptcodigo(String dptcodigo) {
		this.dptcodigo = dptcodigo;
	}

	public String getPrvcodigo() {
		return prvcodigo;
	}

	public void setPrvcodigo(String prvcodigo) {
		this.prvcodigo = prvcodigo;
	}

	public String getZptdescripcion() {
		return this.zptdescripcion;
	}

	public void setZptdescripcion(String zptdescripcion) {
		this.zptdescripcion = zptdescripcion;
	}


	public Integer getZptestado() {
		return this.zptestado;
	}

	public void setZptestado(Integer zptestado) {
		this.zptestado = zptestado;
	}


	
	public Date getZptfechacreacion() {
		return this.zptfechacreacion;
	}

	public void setZptfechacreacion(Date zptfechacreacion) {
		this.zptfechacreacion = zptfechacreacion;
	}


	public String getZptipcreacion() {
		return this.zptipcreacion;
	}

	public void setZptipcreacion(String zptipcreacion) {
		this.zptipcreacion = zptipcreacion;
	}


	
	public Date getZptultimafechamodif() {
		return this.zptultimafechamodif;
	}

	public void setZptultimafechamodif(Date zptultimafechamodif) {
		this.zptultimafechamodif = zptultimafechamodif;
	}


	public String getZptultimoip() {
		return this.zptultimoip;
	}

	public void setZptultimoip(String zptultimoip) {
		this.zptultimoip = zptultimoip;
	}


	public Integer getZptultimousuario() {
		return this.zptultimousuario;
	}

	public void setZptultimousuario(Integer zptultimousuario) {
		this.zptultimousuario = zptultimousuario;
	}


	public Integer getZptusuariocreacion() {
		return this.zptusuariocreacion;
	}

	public void setZptusuariocreacion(Integer zptusuariocreacion) {
		this.zptusuariocreacion = zptusuariocreacion;
	}

}