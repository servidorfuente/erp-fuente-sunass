package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@javax.persistence.Table(name = "SA_CALENDARIO")
public class SaCalendario extends Entidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer calcalendarioid;

	@Id
	@javax.persistence.Column(name = "CALCALENDARIOID")
	public Integer getCalcalendarioid() {
		return calcalendarioid;
	}

	public void setCalcalendarioid(Integer calcalendarioid) {
		this.calcalendarioid = calcalendarioid;
	}

	private Integer calestado;

	@Basic
	@javax.persistence.Column(name = "CALESTADO")
	public Integer getCalestado() {
		return calestado;
	}

	public void setCalestado(Integer calestado) {
		this.calestado = calestado;
	}

	private Integer caltipojerarquia;

	@Basic
	@javax.persistence.Column(name = "CALTIPOJERARQUIA")
	public Integer getCaltipojerarquia() {
		return caltipojerarquia;
	}

	public void setCaltipojerarquia(Integer caltipojerarquia) {
		this.caltipojerarquia = caltipojerarquia;
	}

	private Integer perperiodoid;

	@Basic
	@javax.persistence.Column(name = "PERPERIODOID")
	public Integer getPerperiodoid() {
		return perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}

	private Integer uneunegocioid;

	@Basic
	@javax.persistence.Column(name = "UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	private Integer moemestudioid;

	@Basic
	@javax.persistence.Column(name = "MOEMESTUDIOID")
	public Integer getMoemestudioid() {
		return moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	private Integer crrcarreraid;

	@Basic
	@javax.persistence.Column(name = "CRRCARRERAID")
	public Integer getCrrcarreraid() {
		return crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}

	private Integer secseccionid;

	@Basic
	@javax.persistence.Column(name = "SECSECCIONID")
	public Integer getSecseccionid() {
		return secseccionid;
	}

	public void setSecseccionid(Integer secseccionid) {
		this.secseccionid = secseccionid;
	}

	private Integer caltipocalendario;

	@Basic
	@javax.persistence.Column(name = "CALTIPOCALENDARIO")
	public Integer getCaltipocalendario() {
		return caltipocalendario;
	}

	public void setCaltipocalendario(Integer caltipocalendario) {
		this.caltipocalendario = caltipocalendario;
	}

	private String calcodigocalendario;

	@Basic
	@javax.persistence.Column(name = "CALCODIGOCALENDARIO")
	public String getCalcodigocalendario() {
		return calcodigocalendario;
	}

	public void setCalcodigocalendario(String calcodigocalendario) {
		this.calcodigocalendario = calcodigocalendario;
	}

	private Date calfechadesde;

	@Basic
	@javax.persistence.Column(name = "CALFECHADESDE")
	public Date getCalfechadesde() {
		return calfechadesde;
	}

	public void setCalfechadesde(Date calfechadesde) {
		this.calfechadesde = calfechadesde;
	}

	private Date calfechahasta;

	@Basic
	@javax.persistence.Column(name = "CALFECHAHASTA")
	public Date getCalfechahasta() {
		return calfechahasta;
	}

	public void setCalfechahasta(Date calfechahasta) {
		this.calfechahasta = calfechahasta;
	}

	private Integer loplogprocesoidultimo;

	@Basic
	@javax.persistence.Column(name = "LOPLOGPROCESOIDULTIMO")
	public Integer getLoplogprocesoidultimo() {
		return loplogprocesoidultimo;
	}

	public void setLoplogprocesoidultimo(Integer loplogprocesoidultimo) {
		this.loplogprocesoidultimo = loplogprocesoidultimo;
	}

	private Integer calusuariocreacion;

	@Basic
	@javax.persistence.Column(name = "CALUSUARIOCREACION")
	public Integer getCalusuariocreacion() {
		return calusuariocreacion;
	}

	public void setCalusuariocreacion(Integer calusuariocreacion) {
		this.calusuariocreacion = calusuariocreacion;
	}

	private Date calfechacreacion;

	@Basic
	@javax.persistence.Column(name = "CALFECHACREACION")
	public Date getCalfechacreacion() {
		return calfechacreacion;
	}

	public void setCalfechacreacion(Date calfechacreacion) {
		this.calfechacreacion = calfechacreacion;
	}

	private String calipcreacion;

	@Basic
	@javax.persistence.Column(name = "CALIPCREACION")
	public String getCalipcreacion() {
		return calipcreacion;
	}

	public void setCalipcreacion(String calipcreacion) {
		this.calipcreacion = calipcreacion;
	}

	private Integer calultimousuario;

	@Basic
	@javax.persistence.Column(name = "CALULTIMOUSUARIO")
	public Integer getCalultimousuario() {
		return calultimousuario;
	}

	public void setCalultimousuario(Integer calultimousuario) {
		this.calultimousuario = calultimousuario;
	}

	private Date calultimafechamodif;

	@Basic
	@javax.persistence.Column(name = "CALULTIMAFECHAMODIF")
	public Date getCalultimafechamodif() {
		return calultimafechamodif;
	}

	public void setCalultimafechamodif(Date calultimafechamodif) {
		this.calultimafechamodif = calultimafechamodif;
	}

	private String calultimoip;

	@Basic
	@javax.persistence.Column(name = "CALULTIMOIP")
	public String getCalultimoip() {
		return calultimoip;
	}

	public void setCalultimoip(String calultimoip) {
		this.calultimoip = calultimoip;
	}

	private Integer curcursoid;

	@Basic
	@javax.persistence.Column(name = "CURCURSOID")
	public Integer getCurcursoid() {
		return curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	private Integer cugcursogrupoid;

	@Basic
	@javax.persistence.Column(name = "CUGCURSOGRUPOID")
	public Integer getCugcursogrupoid() {
		return cugcursogrupoid;
	}

	public void setCugcursogrupoid(Integer cugcursogrupoid) {
		this.cugcursogrupoid = cugcursogrupoid;
	}

	private Integer feeforelementoid;

	@Basic
	@javax.persistence.Column(name = "FEEFORELEMENTOID")
	public Integer getFeeforelementoid() {
		return feeforelementoid;
	}

	public void setFeeforelementoid(Integer feeforelementoid) {
		this.feeforelementoid = feeforelementoid;
	}

	private Integer feeforelementoidpapa;

	@Basic
	@javax.persistence.Column(name = "FEEFORELEMENTOIDPAPA")
	public Integer getFeeforelementoidpapa() {
		return feeforelementoidpapa;
	}

	public void setFeeforelementoidpapa(Integer feeforelementoidpapa) {
		this.feeforelementoidpapa = feeforelementoidpapa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SaCalendario that = (SaCalendario) o;

		if (calcalendarioid != that.calcalendarioid)
			return false;
		if (calestado != that.calestado)
			return false;
		if (perperiodoid != that.perperiodoid)
			return false;
		if (caltipocalendario != that.caltipocalendario)
			return false;
		if (caltipojerarquia != null ? !caltipojerarquia.equals(that.caltipojerarquia) : that.caltipojerarquia != null)
			return false;
		if (uneunegocioid != null ? !uneunegocioid.equals(that.uneunegocioid) : that.uneunegocioid != null)
			return false;
		if (moemestudioid != null ? !moemestudioid.equals(that.moemestudioid) : that.moemestudioid != null)
			return false;
		if (crrcarreraid != null ? !crrcarreraid.equals(that.crrcarreraid) : that.crrcarreraid != null)
			return false;
		if (secseccionid != null ? !secseccionid.equals(that.secseccionid) : that.secseccionid != null)
			return false;
		if (calcodigocalendario != null ? !calcodigocalendario.equals(that.calcodigocalendario)
				: that.calcodigocalendario != null)
			return false;
		if (calfechadesde != null ? !calfechadesde.equals(that.calfechadesde) : that.calfechadesde != null)
			return false;
		if (calfechahasta != null ? !calfechahasta.equals(that.calfechahasta) : that.calfechahasta != null)
			return false;
		if (loplogprocesoidultimo != null ? !loplogprocesoidultimo.equals(that.loplogprocesoidultimo)
				: that.loplogprocesoidultimo != null)
			return false;
		if (calusuariocreacion != null ? !calusuariocreacion.equals(that.calusuariocreacion)
				: that.calusuariocreacion != null)
			return false;
		if (calfechacreacion != null ? !calfechacreacion.equals(that.calfechacreacion) : that.calfechacreacion != null)
			return false;
		if (calipcreacion != null ? !calipcreacion.equals(that.calipcreacion) : that.calipcreacion != null)
			return false;
		if (calultimousuario != null ? !calultimousuario.equals(that.calultimousuario) : that.calultimousuario != null)
			return false;
		if (calultimafechamodif != null ? !calultimafechamodif.equals(that.calultimafechamodif)
				: that.calultimafechamodif != null)
			return false;
		if (calultimoip != null ? !calultimoip.equals(that.calultimoip) : that.calultimoip != null)
			return false;
		if (curcursoid != null ? !curcursoid.equals(that.curcursoid) : that.curcursoid != null)
			return false;
		if (cugcursogrupoid != null ? !cugcursogrupoid.equals(that.cugcursogrupoid) : that.cugcursogrupoid != null)
			return false;
		if (feeforelementoid != null ? !feeforelementoid.equals(that.feeforelementoid) : that.feeforelementoid != null)
			return false;
		if (feeforelementoidpapa != null ? !feeforelementoidpapa.equals(that.feeforelementoidpapa)
				: that.feeforelementoidpapa != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (calcalendarioid ^ (calcalendarioid >>> 32));
		result = 31 * result + (int) (calestado ^ (calestado >>> 32));
		result = 31 * result + (caltipojerarquia != null ? caltipojerarquia.hashCode() : 0);
		result = 31 * result + (int) (perperiodoid ^ (perperiodoid >>> 32));
		result = 31 * result + (uneunegocioid != null ? uneunegocioid.hashCode() : 0);
		result = 31 * result + (moemestudioid != null ? moemestudioid.hashCode() : 0);
		result = 31 * result + (crrcarreraid != null ? crrcarreraid.hashCode() : 0);
		result = 31 * result + (secseccionid != null ? secseccionid.hashCode() : 0);
		result = 31 * result + (int) (caltipocalendario ^ (caltipocalendario >>> 32));
		result = 31 * result + (calcodigocalendario != null ? calcodigocalendario.hashCode() : 0);
		result = 31 * result + (calfechadesde != null ? calfechadesde.hashCode() : 0);
		result = 31 * result + (calfechahasta != null ? calfechahasta.hashCode() : 0);
		result = 31 * result + (loplogprocesoidultimo != null ? loplogprocesoidultimo.hashCode() : 0);
		result = 31 * result + (calusuariocreacion != null ? calusuariocreacion.hashCode() : 0);
		result = 31 * result + (calfechacreacion != null ? calfechacreacion.hashCode() : 0);
		result = 31 * result + (calipcreacion != null ? calipcreacion.hashCode() : 0);
		result = 31 * result + (calultimousuario != null ? calultimousuario.hashCode() : 0);
		result = 31 * result + (calultimafechamodif != null ? calultimafechamodif.hashCode() : 0);
		result = 31 * result + (calultimoip != null ? calultimoip.hashCode() : 0);
		result = 31 * result + (curcursoid != null ? curcursoid.hashCode() : 0);
		result = 31 * result + (cugcursogrupoid != null ? cugcursogrupoid.hashCode() : 0);
		result = 31 * result + (feeforelementoid != null ? feeforelementoid.hashCode() : 0);
		result = 31 * result + (feeforelementoidpapa != null ? feeforelementoidpapa.hashCode() : 0);
		return result;
	}

}
