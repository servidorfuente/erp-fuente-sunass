package erp.realcoresystems.pe.model.domain.vista;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import erp.realcoresystems.pe.model.domain.Entidad;

@SuppressWarnings("serial")
@Entity
@Table(name = "VW_DAYSOFWEEK")
public class VwDayOfWeek extends Entidad {

	private Integer daysofweekid;
	private Date lunes;
	private Date martes;
	private Date miercoles;
	private Date jueves;
	private Date viernes;
	private Date sabado;
	private Date domingo;

	private String lunesFormat;
	private String martesFormat;
	private String miercolesFormat;
	private String juevesFormat;
	private String viernesFormat;
	private String sabadoFormat;
	private String domingoFormat;

	@Transient
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM");

	// --- Gettes & Setters

	@Transient
	public String getLunesFormat() {
		return dateformat.format(lunes);
	}

	public void setLunesFormat(String lunesFormat) {
		this.lunesFormat = lunesFormat;
	}

	@Transient
	public String getMartesFormat() {
		return dateformat.format(martes);
	}

	public void setMartesFormat(String martesFormat) {
		this.martesFormat = martesFormat;
	}

	@Transient
	public String getMiercolesFormat() {
		return dateformat.format(miercoles);
	}

	public void setMiercolesFormat(String miercolesFormat) {
		this.miercolesFormat = miercolesFormat;
	}

	@Transient
	public String getJuevesFormat() {
		return dateformat.format(jueves);
	}

	public void setJuevesFormat(String juevesFormat) {
		this.juevesFormat = juevesFormat;
	}

	@Transient
	public String getViernesFormat() {
		return dateformat.format(viernes);
	}

	public void setViernesFormat(String viernesFormat) {
		this.viernesFormat = viernesFormat;
	}

	@Transient
	public String getSabadoFormat() {
		return dateformat.format(sabado);
	}

	public void setSabadoFormat(String sabadoFormat) {
		this.sabadoFormat = sabadoFormat;
	}

	@Transient
	public String getDomingoFormat() {
		return dateformat.format(domingo);
	}

	public void setDomingoFormat(String domingoFormat) {
		this.domingoFormat = domingoFormat;
	}

	public Date getLunes() {
		return lunes;
	}

	public void setLunes(Date lunes) {
		this.lunes = lunes;
	}

	public Date getMartes() {
		return martes;
	}

	public void setMartes(Date martes) {
		this.martes = martes;
	}

	public Date getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(Date miercoles) {
		this.miercoles = miercoles;
	}

	public Date getJueves() {
		return jueves;
	}

	public void setJueves(Date jueves) {
		this.jueves = jueves;
	}

	public Date getViernes() {
		return viernes;
	}

	public void setViernes(Date viernes) {
		this.viernes = viernes;
	}

	public Date getSabado() {
		return sabado;
	}

	public void setSabado(Date sabado) {
		this.sabado = sabado;
	}

	public Date getDomingo() {
		return domingo;
	}

	public void setDomingo(Date domingo) {
		this.domingo = domingo;
	}

	@Id
	public Integer getDaysofweekid() {
		return daysofweekid;
	}

	public void setDaysofweekid(Integer daysofweekid) {
		this.daysofweekid = daysofweekid;
	}

}