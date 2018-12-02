package erp.realcoresystems.pe.model.domain.vista;

import java.io.Serializable;
import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VW_MENSAJE_RECEPTOR database table.
 * 
 */
@Entity
@Table(name="VW_MENSAJE_RECEPTOR")
public class VwMensajeReceptor extends Entidad {
	private static final long serialVersionUID = 1L;	
	
	private Long mrecRecepcionid;
	private Long mensMensajeid;
	
	private String mensAsunto;
	private String mensContenido;
	private Integer mensEstado;
	
	private String mensTipo;
	private Integer moemestudioid;
	private String mrecEmail;
	private Integer mrecEstado;
	private String mrecFlagemail;
	private String mrecFlagleido;
	private String mrecFlagurgente;
	
	private Long mrecRecepcionidOrigen;
	private String mrecTipomensaje;
	private String mrecTiporeceptor;
	private String mrecTiposesion;
	private Integer mrecUbicacion;
	private String mrecUsuario;
	private String nombrecompleto;
	private Integer persona;
	private String personadocumento;
	private Integer uneunegocioid;
	
	private Date mrecFecharecepcion;
	private Date mrecFechalectura;
	
	private Long memiEmisionid;
	private Date memiFechaemision;
	private Integer memiEstado;
	private String memiEmail;
	private Integer personaEmision;
	private String nombrecompletoEmision;


	
	public VwMensajeReceptor() {
	}



	@Column(name="MENS_ASUNTO")
	public String getMensAsunto() {
		return this.mensAsunto;
	}

	public void setMensAsunto(String mensAsunto) {
		this.mensAsunto = mensAsunto;
	}


	@Column(name="MENS_CONTENIDO")
	public String getMensContenido() {
		return this.mensContenido;
	}

	public void setMensContenido(String mensContenido) {
		this.mensContenido = mensContenido;
	}


	@Column(name="MENS_ESTADO")
	public Integer getMensEstado() {
		return this.mensEstado;
	}

	public void setMensEstado(Integer mensEstado) {
		this.mensEstado = mensEstado;
	}


	@Column(name="MENS_MENSAJEID")
	public Long getMensMensajeid() {
		return this.mensMensajeid;
	}

	public void setMensMensajeid(Long mensMensajeid) {
		this.mensMensajeid = mensMensajeid;
	}


	@Column(name="MENS_TIPO")
	public String getMensTipo() {
		return this.mensTipo;
	}

	public void setMensTipo(String mensTipo) {
		this.mensTipo = mensTipo;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	@Column(name="MREC_EMAIL")
	public String getMrecEmail() {
		return this.mrecEmail;
	}

	public void setMrecEmail(String mrecEmail) {
		this.mrecEmail = mrecEmail;
	}


	@Column(name="MREC_ESTADO")
	public Integer getMrecEstado() {
		return this.mrecEstado;
	}

	public void setMrecEstado(Integer mrecEstado) {
		this.mrecEstado = mrecEstado;
	}


	@Column(name="MREC_FLAGEMAIL")
	public String getMrecFlagemail() {
		return this.mrecFlagemail;
	}

	public void setMrecFlagemail(String mrecFlagemail) {
		this.mrecFlagemail = mrecFlagemail;
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


	@Id
	@Column(name="MREC_RECEPCIONID")
	public Long getMrecRecepcionid() {
		return this.mrecRecepcionid;
	}

	public void setMrecRecepcionid(Long mrecRecepcionid) {
		this.mrecRecepcionid = mrecRecepcionid;
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


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}


	public String getPersonadocumento() {
		return this.personadocumento;
	}

	public void setPersonadocumento(String personadocumento) {
		this.personadocumento = personadocumento;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}


	

	
	
	@Column(name="MREC_FECHARECEPCION")
	public Date getMrecFecharecepcion() {
		return mrecFecharecepcion;
	}



	public void setMrecFecharecepcion(Date mrecFecharecepcion) {
		this.mrecFecharecepcion = mrecFecharecepcion;
	}


		

	
	@Column(name="MREC_FECHALECTURA")	
	public Date getMrecFechalectura() {
		return mrecFechalectura;
	}



	public void setMrecFechalectura(Date mrecFechalectura) {
		this.mrecFechalectura = mrecFechalectura;
	}
	

	
	@Column(name="MEMI_EMISIONID")	
	public Long getMemiEmisionid() {
		return memiEmisionid;
	}



	public void setMemiEmisionid(Long memiEmisionid) {
		this.memiEmisionid = memiEmisionid;
	}


	@Column(name="MEMI_FECHAEMISION")
	public Date getMemiFechaemision() {
		return memiFechaemision;
	}



	public void setMemiFechaemision(Date memiFechaemision) {
		this.memiFechaemision = memiFechaemision;
	}

	
	@Column(name="MEMI_ESTADO")
	public Integer getMemiEstado() {
		return memiEstado;
	}



	public void setMemiEstado(Integer memiEstado) {
		this.memiEstado = memiEstado;
	}

	
	@Column(name="MEMI_EMAIL")
	public String getMemiEmail() {
		return memiEmail;
	}



	public void setMemiEmail(String memiEmail) {
		this.memiEmail = memiEmail;
	}
	
	
	@Column(name="PERSONA_EMISION")
	public Integer getPersonaEmision() {
		return personaEmision;
	}



	public void setPersonaEmision(Integer personaEmision) {
		this.personaEmision = personaEmision;
	}

	
	@Column(name="NOMBRECOMPLETO_EMISION")
	public String getNombrecompletoEmision() {
		return nombrecompletoEmision;
	}



	public void setNombrecompletoEmision(String nombrecompletoEmision) {
		this.nombrecompletoEmision = nombrecompletoEmision;
	}

	
	
}