package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import java.util.Date;



/**
 * The persistent class for the SA_MENSAJE_OBJETO database table.
 * 
 */
@Entity
@Table(name="SA_MENSAJE_OBJETO")
public class SaMensajeObjeto extends Entidad {
	private static final long serialVersionUID = 1L;
	private Long mensMensajeid;
	private Long memiEmisionid;
	
	private String mensAsunto;
	private String mensContenido;
	private Integer mensEstado;
	private String mensTipo;
	private Integer moemestudioid;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;
	
	//private List<SaMensajeRecAdjunto> saMensajeRecAdjuntos;

	public SaMensajeObjeto() {
	}


	@Id
	@Column(name="MENS_MENSAJEID")
	public Long getMensMensajeid() {
		return this.mensMensajeid;
	}

	public void setMensMensajeid(Long mensMensajeid) {
		this.mensMensajeid = mensMensajeid;
	}


	@Column(name="MEMI_EMISIONID")
	public Long getMemiEmisionid() {
		return this.memiEmisionid;
	}
	public void setMemiEmisionid(Long memiEmisionid) {
		this.memiEmisionid = memiEmisionid;
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


	@Temporal(TemporalType.DATE)
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


	//bi-directional many-to-one association to SaMensajeRecAdjunto
	/*@OneToMany(mappedBy="saMensajeObjeto")
	public List<SaMensajeRecAdjunto> getSaMensajeRecAdjuntos() {
		return this.saMensajeRecAdjuntos;
	}

	public void setSaMensajeRecAdjuntos(List<SaMensajeRecAdjunto> saMensajeRecAdjuntos) {
		this.saMensajeRecAdjuntos = saMensajeRecAdjuntos;
	}*/

	/*
	public SaMensajeRecAdjunto addSaMensajeRecAdjunto(SaMensajeRecAdjunto saMensajeRecAdjunto) {
		getSaMensajeRecAdjuntos().add(saMensajeRecAdjunto);
		saMensajeRecAdjunto.setSaMensajeObjeto(this);

		return saMensajeRecAdjunto;
	}

	public SaMensajeRecAdjunto removeSaMensajeRecAdjunto(SaMensajeRecAdjunto saMensajeRecAdjunto) {
		getSaMensajeRecAdjuntos().remove(saMensajeRecAdjunto);
		saMensajeRecAdjunto.setSaMensajeObjeto(null);

		return saMensajeRecAdjunto;
	}*/

}