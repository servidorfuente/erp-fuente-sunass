package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_MENSAJE_RECEPTOR database table.
 * 
 */
@Entity
@Table(name="SA_MENSAJE_RECEPTOR")
public class SaMensajeReceptor extends Entidad {
	private static final long serialVersionUID = 1L;
	
	private Long mensMensajeid;
	private Long mrecRecepcionid;
	
	//private SaMensajeReceptorPK id;
	private Integer moemestudioid;
	private Integer mrecEstado;
	private Date mrecFechacreacion;
	private Date mrecFechaeliminacion;
	private Date mrecFechalectura;
	private Date mrecFecharecepcion;
	private String mrecFlagleido;
	private String mrecFlagurgente;
	private Long mrecRecepcionidOrigen;
	private String mrecTipomensaje;
	private String mrecTiporeceptor;
	private String mrecTiposesion;
	private Integer mrecUbicacion;
	private String mrecUsuario;
	private Integer persona;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;

	private String mrecFlagemail;
	private String mrecEmail;
	
	   
	
	public SaMensajeReceptor() {

	}


	@Id
	@Column(name="MREC_RECEPCIONID")
	public Long getMrecRecepcionid() {
		return this.mrecRecepcionid;
	}
	public void setMrecRecepcionid(Long mrecRecepcionid) {
		this.mrecRecepcionid = mrecRecepcionid;
	}
	
	@Column(name="MENS_MENSAJEID")
	public Long getMensMensajeid() {
		return this.mensMensajeid;
	}
	public void setMensMensajeid(Long mensMensajeid) {
		this.mensMensajeid = mensMensajeid;
	}

	
	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	@Column(name="MREC_ESTADO")
	public Integer getMrecEstado() {
		return this.mrecEstado;
	}

	public void setMrecEstado(Integer mrecEstado) {
		this.mrecEstado = mrecEstado;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="MREC_FECHACREACION")
	public Date getMrecFechacreacion() {
		return this.mrecFechacreacion;
	}

	public void setMrecFechacreacion(Date mrecFechacreacion) {
		this.mrecFechacreacion = mrecFechacreacion;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="MREC_FECHAELIMINACION")
	public Date getMrecFechaeliminacion() {
		return this.mrecFechaeliminacion;
	}

	public void setMrecFechaeliminacion(Date mrecFechaeliminacion) {
		this.mrecFechaeliminacion = mrecFechaeliminacion;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="MREC_FECHALECTURA")
	public Date getMrecFechalectura() {
		return this.mrecFechalectura;
	}

	public void setMrecFechalectura(Date mrecFechalectura) {
		this.mrecFechalectura = mrecFechalectura;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="MREC_FECHARECEPCION")
	public Date getMrecFecharecepcion() {
		return this.mrecFecharecepcion;
	}

	public void setMrecFecharecepcion(Date mrecFecharecepcion) {
		this.mrecFecharecepcion = mrecFecharecepcion;
	}


	@Column(name="MREC_FLAGLEIDO")
	public String getMrecFlagleido() {
		return this.mrecFlagleido;
	}

	public void setMrecFlagleido(String mrecFlagleido) {
		this.mrecFlagleido = mrecFlagleido;
	}


	@Column(name="MREC_FLAGURGENTE")
	public String getMrecFlagurgente() {
		return this.mrecFlagurgente;
	}

	public void setMrecFlagurgente(String mrecFlagurgente) {
		this.mrecFlagurgente = mrecFlagurgente;
	}


	@Column(name="MREC_RECEPCIONID_ORIGEN")
	public Long getMrecRecepcionidOrigen() {
		return this.mrecRecepcionidOrigen;
	}

	public void setMrecRecepcionidOrigen(Long mrecRecepcionidOrigen) {
		this.mrecRecepcionidOrigen = mrecRecepcionidOrigen;
	}


	@Column(name="MREC_TIPOMENSAJE")
	public String getMrecTipomensaje() {
		return this.mrecTipomensaje;
	}

	public void setMrecTipomensaje(String mrecTipomensaje) {
		this.mrecTipomensaje = mrecTipomensaje;
	}


	@Column(name="MREC_TIPORECEPTOR")
	public String getMrecTiporeceptor() {
		return this.mrecTiporeceptor;
	}

	public void setMrecTiporeceptor(String mrecTiporeceptor) {
		this.mrecTiporeceptor = mrecTiporeceptor;
	}


	@Column(name="MREC_TIPOSESION")
	public String getMrecTiposesion() {
		return this.mrecTiposesion;
	}

	public void setMrecTiposesion(String mrecTiposesion) {
		this.mrecTiposesion = mrecTiposesion;
	}


	@Column(name="MREC_UBICACION")
	public Integer getMrecUbicacion() {
		return this.mrecUbicacion;
	}

	public void setMrecUbicacion(Integer mrecUbicacion) {
		this.mrecUbicacion = mrecUbicacion;
	}


	@Column(name="MREC_USUARIO")
	public String getMrecUsuario() {
		return this.mrecUsuario;
	}

	public void setMrecUsuario(String mrecUsuario) {
		this.mrecUsuario = mrecUsuario;
	}


	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}


	//@Temporal(TemporalType.DATE)
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


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	
	
	@Column(name="MREC_FLAGEMAIL")
	public String getMrecFlagemail() {
		return mrecFlagemail;
	}


	public void setMrecFlagemail(String mrecFlagemail) {
		this.mrecFlagemail = mrecFlagemail;
	}

	
	@Column(name="MREC_EMAIL")
	public String getMrecEmail() {
		return mrecEmail;
	}


	public void setMrecEmail(String mrecEmail) {
		this.mrecEmail = mrecEmail;
	}
	


}