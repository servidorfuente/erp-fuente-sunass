package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_MENSAJE_EMISOR database table.
 * 
 */
@Entity
@Table(name="SA_MENSAJE_EMISOR")
public class SaMensajeEmisor extends Entidad {
	private static final long serialVersionUID = 1L;
	
	private Integer memiEstado;
	private Date memiFechacreacion;
	private Date memiFechaemision;
	private String memiTipoemisor;
	private String memiTiposesion;
	private String memiUsuario;
	private Integer moemestudioid;
	private Long mrecRecepcionidOrigen;
	private Integer persona;
	private Date ultimafechamodif;
	private String ultimousuario;	
	private Integer uneunegocioid;
	
	private String memiEmail;

	private Long memiEmisionid;
	

	private String memiFlagurgente;
	private String memiFlagleido;
	
	public SaMensajeEmisor() {		
	}


	@Id
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


	//@Temporal(TemporalType.DATE)
	@Column(name="MEMI_FECHACREACION")
	public Date getMemiFechacreacion() {
		return this.memiFechacreacion;
	}

	public void setMemiFechacreacion(Date memiFechacreacion) {
		this.memiFechacreacion = memiFechacreacion;
	}


	//@Temporal(TemporalType.DATE)
	@Column(name="MEMI_FECHAEMISION")
	public Date getMemiFechaemision() {
		return this.memiFechaemision;
	}

	public void setMemiFechaemision(Date memiFechaemision) {
		this.memiFechaemision = memiFechaemision;
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

	
	@Column(name="MEMI_EMAIL")
	public String getMemiEmail() {
		return memiEmail;
	}


	public void setMemiEmail(String memiEmail) {
		this.memiEmail = memiEmail;
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