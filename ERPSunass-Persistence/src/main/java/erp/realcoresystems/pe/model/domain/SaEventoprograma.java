package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_EVENTOPROGRAMA database table.
 * 
 */
@Entity
@Table(name="SA_EVENTOPROGRAMA")
public class SaEventoprograma extends Entidad {
	private static final long serialVersionUID = 1L;
	private Integer eveeventoid;
	private String evedescripcion;
	private Integer eveestado;
	private Integer eveestadoproceso;
	private String eveexplicacion;
	private Date evefechacreacion;
	private Date evefechafin;
	private Date evefechainicio;
	private Integer everesponsable;
	private String evetipo;
	private Date eveultimafechamodif;
	private String eveultimousuario;
	private String eveusuariocreacion;
	private Integer moemestudioid;
	private Integer perperiodoid;
	private Integer uneunegocioid;

	public SaEventoprograma() {
	}


	@Id
	public Integer getEveeventoid() {
		return this.eveeventoid;
	}

	public void setEveeventoid(Integer eveeventoid) {
		this.eveeventoid = eveeventoid;
	}


	public String getEvedescripcion() {
		return this.evedescripcion;
	}

	public void setEvedescripcion(String evedescripcion) {
		this.evedescripcion = evedescripcion;
	}


	public Integer getEveestado() {
		return this.eveestado;
	}

	public void setEveestado(Integer eveestado) {
		this.eveestado = eveestado;
	}


	public Integer getEveestadoproceso() {
		return this.eveestadoproceso;
	}

	public void setEveestadoproceso(Integer eveestadoproceso) {
		this.eveestadoproceso = eveestadoproceso;
	}


	public String getEveexplicacion() {
		return this.eveexplicacion;
	}

	public void setEveexplicacion(String eveexplicacion) {
		this.eveexplicacion = eveexplicacion;
	}


	@Temporal(TemporalType.DATE)
	public Date getEvefechacreacion() {
		return this.evefechacreacion;
	}

	public void setEvefechacreacion(Date evefechacreacion) {
		this.evefechacreacion = evefechacreacion;
	}


	@Temporal(TemporalType.DATE)
	public Date getEvefechafin() {
		return this.evefechafin;
	}

	public void setEvefechafin(Date evefechafin) {
		this.evefechafin = evefechafin;
	}


	@Temporal(TemporalType.DATE)
	public Date getEvefechainicio() {
		return this.evefechainicio;
	}

	public void setEvefechainicio(Date evefechainicio) {
		this.evefechainicio = evefechainicio;
	}


	public Integer getEveresponsable() {
		return this.everesponsable;
	}

	public void setEveresponsable(Integer everesponsable) {
		this.everesponsable = everesponsable;
	}


	public String getEvetipo() {
		return this.evetipo;
	}

	public void setEvetipo(String evetipo) {
		this.evetipo = evetipo;
	}


	@Temporal(TemporalType.DATE)
	public Date getEveultimafechamodif() {
		return this.eveultimafechamodif;
	}

	public void setEveultimafechamodif(Date eveultimafechamodif) {
		this.eveultimafechamodif = eveultimafechamodif;
	}


	public String getEveultimousuario() {
		return this.eveultimousuario;
	}

	public void setEveultimousuario(String eveultimousuario) {
		this.eveultimousuario = eveultimousuario;
	}


	public String getEveusuariocreacion() {
		return this.eveusuariocreacion;
	}

	public void setEveusuariocreacion(String eveusuariocreacion) {
		this.eveusuariocreacion = eveusuariocreacion;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

}