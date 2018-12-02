package erp.realcoresystems.pe.model.domain.vista;

import java.io.Serializable;
import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VW_MENSAJE_OBJETO_EMISOR database table.
 * 
 */
@Entity
@Table(name="VW_MENSAJE_OBJETO_EMISOR")
public class VwMensajeObjetoEmisor extends Entidad {
	private static final long serialVersionUID = 1L;
	
	private Long mensMensajeid;
	
	private String documentoEmisor;
	private String memiEmail;
	private Long memiEmisionid;
	private Integer memiEstado;
	private String memiTipoemisor;
	private String memiTiposesion;
	private String memiUsuario;
	private String mensAsunto;
	private String mensContenido;
	private Integer mensEstado;
	
	private String mensTipo;
	private Integer moemestudioid;
	private Long mrecRecepcionidOrigen;
	private String nombrecompletoEmisor;
	private Integer personaEmisor;
	private Integer uneunegocioid;
	
	private Date memiFechacreacion;
	private Date memiFechaemision;

	private String memiFlagurgente;
	private String memiFlagleido;

	
	public VwMensajeObjetoEmisor() {
	}
	
	
	@Id
	@Column(name="MENS_MENSAJEID")
	public Long getMensMensajeid() {
		return this.mensMensajeid;
	}

	public void setMensMensajeid(Long mensMensajeid) {
		this.mensMensajeid = mensMensajeid;
	}


	@Column(name="DOCUMENTO_EMISOR")
	public String getDocumentoEmisor() {
		return this.documentoEmisor;
	}

	public void setDocumentoEmisor(String documentoEmisor) {
		this.documentoEmisor = documentoEmisor;
	}


	@Column(name="MEMI_EMAIL")
	public String getMemiEmail() {
		return this.memiEmail;
	}

	public void setMemiEmail(String memiEmail) {
		this.memiEmail = memiEmail;
	}


	@Column(name="MEMI_EMISIONID")
	public Long getMemiEmisionid() {
		return this.memiEmisionid;
	}

	public void setMemiEmisionid(Long memiEmisionid) {
		this.memiEmisionid = memiEmisionid;
	}


	@Column(name="MEMI_ESTADO")
	public Integer getMemiEstado() {
		return this.memiEstado;
	}

	public void setMemiEstado(Integer memiEstado) {
		this.memiEstado = memiEstado;
	}


	@Column(name="MEMI_TIPOEMISOR")
	public String getMemiTipoemisor() {
		return this.memiTipoemisor;
	}

	public void setMemiTipoemisor(String memiTipoemisor) {
		this.memiTipoemisor = memiTipoemisor;
	}


	@Column(name="MEMI_TIPOSESION")
	public String getMemiTiposesion() {
		return this.memiTiposesion;
	}

	public void setMemiTiposesion(String memiTiposesion) {
		this.memiTiposesion = memiTiposesion;
	}


	@Column(name="MEMI_USUARIO")
	public String getMemiUsuario() {
		return this.memiUsuario;
	}

	public void setMemiUsuario(String memiUsuario) {
		this.memiUsuario = memiUsuario;
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


	@Column(name="MREC_RECEPCIONID_ORIGEN")
	public Long getMrecRecepcionidOrigen() {
		return this.mrecRecepcionidOrigen;
	}

	public void setMrecRecepcionidOrigen(Long mrecRecepcionidOrigen) {
		this.mrecRecepcionidOrigen = mrecRecepcionidOrigen;
	}


	@Column(name="NOMBRECOMPLETO_EMISOR")
	public String getNombrecompletoEmisor() {
		return this.nombrecompletoEmisor;
	}

	public void setNombrecompletoEmisor(String nombrecompletoEmisor) {
		this.nombrecompletoEmisor = nombrecompletoEmisor;
	}


	@Column(name="PERSONA_EMISOR")
	public Integer getPersonaEmisor() {
		return this.personaEmisor;
	}

	public void setPersonaEmisor(Integer personaEmisor) {
		this.personaEmisor = personaEmisor;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}


	
	@Column(name="MEMI_FECHACREACION")
	public Date getMemiFechacreacion() {
		return memiFechacreacion;
	}


	public void setMemiFechacreacion(Date memiFechacreacion) {
		this.memiFechacreacion = memiFechacreacion;
	}


	
	@Column(name="MEMI_FECHAEMISION")
	public Date getMemiFechaemision() {
		return memiFechaemision;
	}


	public void setMemiFechaemision(Date memiFechaemision) {
		this.memiFechaemision = memiFechaemision;
	}

	
	
	

	@Column(name="MEMI_FLAGURGENTE")
	public String getMemiFlagurgente() {
		return memiFlagurgente;
	}


	public void setMemiFlagurgente(String memiFlagurgente) {
		this.memiFlagurgente = memiFlagurgente;
	}
		

	@Column(name="MEMI_FLAGLEIDO")
	public String getMemiFlagleido() {
		return memiFlagleido;
	}


	public void setMemiFlagleido(String memiFlagleido) {
		this.memiFlagleido = memiFlagleido;
	}

	
}