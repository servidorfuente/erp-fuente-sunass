package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import erp.realcoresystems.pe.model.domain.Entidad;

@Entity
@Table(name = "VW_CALENDARIO")
public class VwCalendario extends Entidad {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer calcalendarioid;
	private Integer calestado;
	private Integer caltipojerarquia;
	private Integer perperiodoid;
	private Integer uneunegocioid;
	private Integer moemestudioid;
	private Integer crrcarreraid;
	private Integer secseccionid;
	private Integer caltipocalendario;
	private String calcodigocalendario;
	private Date calfechadesde;
	private Date calfechahasta;
	private Integer curcursoid;
	private Integer cugcursogrupoid;
	private Integer feeforelementoid;
	private Integer feeforelementoidpapa;
	private Date calfechacreacion;
	private String calipcreacion;
	private Integer calultimousuario;
	private Date calultimafechamodif;
	private String calultimoip;
	private Integer calusuariocreacion;

	private String perperiodo;
	private Integer perestado;
	private String crrdescripcion;
	private Integer crrestado;
	private String seccodigo;
	private Integer secciclo;
	private Integer secestado;
	private String curnombrecorto;
	private Integer curestado;
	private String caldescripcioncalendario;
	private String maestado;

	public VwCalendario() {
	}

	@Column(name="CALCALENDARIOID")
	public Integer getCalcalendarioid() {
		return calcalendarioid;
	}

	public void setCalcalendarioid(Integer calcalendarioid) {
		this.calcalendarioid = calcalendarioid;
	}

	@Column(name="CALESTADO")
	public Integer getCalestado() {
		return calestado;
	}

	public void setCalestado(Integer calestado) {
		this.calestado = calestado;
	}

	@Column(name="CALTIPOJERARQUIA")
	public Integer getCaltipojerarquia() {
		return caltipojerarquia;
	}

	public void setCaltipojerarquia(Integer caltipojerarquia) {
		this.caltipojerarquia = caltipojerarquia;
	}

	@Column(name="PERPERIODOID")
	public Integer getPerperiodoid() {
		return perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}

	@Column(name="UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Column(name="MOEMESTUDIOID")
	public Integer getMoemestudioid() {
		return moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	@Column(name="CRRCARRERAID")
	public Integer getCrrcarreraid() {
		return crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}

	@Column(name="SECSECCIONID")
	public Integer getSecseccionid() {
		return secseccionid;
	}

	public void setSecseccionid(Integer secseccionid) {
		this.secseccionid = secseccionid;
	}

	@Column(name="CALTIPOCALENDARIO")
	public Integer getCaltipocalendario() {
		return caltipocalendario;
	}

	public void setCaltipocalendario(Integer caltipocalendario) {
		this.caltipocalendario = caltipocalendario;
	}

	@Column(name="CALCODIGOCALENDARIO")
	public String getCalcodigocalendario() {
		return calcodigocalendario;
	}

	public void setCalcodigocalendario(String calcodigocalendario) {
		this.calcodigocalendario = calcodigocalendario;
	}

	@Column(name="CALFECHADESDE")
	@Temporal(TemporalType.TIMESTAMP)	
	public Date getCalfechadesde() {
		return calfechadesde;
	}

	public void setCalfechadesde(Date calfechadesde) {
		this.calfechadesde = calfechadesde;
	}

	@Column(name="CALFECHAHASTA")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCalfechahasta() {
		return calfechahasta;
	}

	public void setCalfechahasta(Date calfechahasta) {
		this.calfechahasta = calfechahasta;
	}

	@Column(name="CURCURSOID")
	public Integer getCurcursoid() {
		return curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	@Column(name="CUGCURSOGRUPOID")
	public Integer getCugcursogrupoid() {
		return cugcursogrupoid;
	}

	public void setCugcursogrupoid(Integer cugcursogrupoid) {
		this.cugcursogrupoid = cugcursogrupoid;
	}

	@Column(name="FEEFORELEMENTOID")
	public Integer getFeeforelementoid() {
		return feeforelementoid;
	}

	public void setFeeforelementoid(Integer feeforelementoid) {
		this.feeforelementoid = feeforelementoid;
	}

	@Column(name="FEEFORELEMENTOIDPAPA")
	public Integer getFeeforelementoidpapa() {
		return feeforelementoidpapa;
	}

	public void setFeeforelementoidpapa(Integer feeforelementoidpapa) {
		this.feeforelementoidpapa = feeforelementoidpapa;
	}

	@Column(name="PERPERIODO")
	public String getPerperiodo() {
		return perperiodo;
	}

	public void setPerperiodo(String perperiodo) {
		this.perperiodo = perperiodo;
	}

	@Column(name="PERESTADO")
	public Integer getPerestado() {
		return perestado;
	}

	public void setPerestado(Integer perestado) {
		this.perestado = perestado;
	}

	@Column(name="CRRDESCRIPCION")
	public String getCrrdescripcion() {
		return crrdescripcion;
	}

	public void setCrrdescripcion(String crrdescripcion) {
		this.crrdescripcion = crrdescripcion;
	}

	@Column(name="CRRESTADO")
	public Integer getCrrestado() {
		return crrestado;
	}

	public void setCrrestado(Integer crrestado) {
		this.crrestado = crrestado;
	}

	@Column(name="SECCODIGO")
	public String getSeccodigo() {
		return seccodigo;
	}

	public void setSeccodigo(String seccodigo) {
		this.seccodigo = seccodigo;
	}

	@Column(name="SECCICLO")
	public Integer getSecciclo() {
		return secciclo;
	}

	public void setSecciclo(Integer secciclo) {
		this.secciclo = secciclo;
	}

	@Column(name="SECESTADO")
	public Integer getSecestado() {
		return secestado;
	}

	public void setSecestado(Integer secestado) {
		this.secestado = secestado;
	}

	@Column(name="CURNOMBRECORTO")
	public String getCurnombrecorto() {
		return curnombrecorto;
	}

	public void setCurnombrecorto(String curnombrecorto) {
		this.curnombrecorto = curnombrecorto;
	}

	@Column(name="CURESTADO")
	public Integer getCurestado() {
		return curestado;
	}

	public void setCurestado(Integer curestado) {
		this.curestado = curestado;
	}

	@Column(name="CALDESCRIPCIONCALENDARIO")
	public String getCaldescripcioncalendario() {
		return caldescripcioncalendario;
	}

	public void setCaldescripcioncalendario(String caldescripcioncalendario) {
		this.caldescripcioncalendario = caldescripcioncalendario;
	}

	@Column(name="MAESTADO")
	public String getMaestado() {
		return maestado;
	}

	public void setMaestado(String maestado) {
		this.maestado = maestado;
	}

	@Column(name="CALFECHACREACION")
	public Date getCalfechacreacion() {
		return calfechacreacion;
	}

	public void setCalfechacreacion(Date calfechacreacion) {
		this.calfechacreacion = calfechacreacion;
	}

	@Column(name="CALIPCREACION")
	public String getCalipcreacion() {
		return calipcreacion;
	}

	public void setCalipcreacion(String calipcreacion) {
		this.calipcreacion = calipcreacion;
	}

	@Column(name="CALULTIMOUSUARIO")
	public Integer getCalultimousuario() {
		return calultimousuario;
	}

	public void setCalultimousuario(Integer calultimousuario) {
		this.calultimousuario = calultimousuario;
	}

	@Column(name="CALULTIMAFECHAMODIF")
	public Date getCalultimafechamodif() {
		return calultimafechamodif;
	}

	public void setCalultimafechamodif(Date calultimafechamodif) {
		this.calultimafechamodif = calultimafechamodif;
	}

	@Column(name="CALULTIMOIP")
	public String getCalultimoip() {
		return calultimoip;
	}

	public void setCalultimoip(String calultimoip) {
		this.calultimoip = calultimoip;
	}

	@Column(name="CALUSUARIOCREACION")
	public Integer getCalusuariocreacion() {
		return calusuariocreacion;
	}

	public void setCalusuariocreacion(Integer calusuariocreacion) {
		this.calusuariocreacion = calusuariocreacion;
	}

}