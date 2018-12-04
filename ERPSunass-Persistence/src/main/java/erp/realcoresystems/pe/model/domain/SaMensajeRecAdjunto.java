package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_MENSAJE_REC_ADJUNTO database table.
 * 
 */
@Entity
@Table(name="SA_MENSAJE_REC_ADJUNTO")
public class SaMensajeRecAdjunto extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaMensajeRecAdjuntoPK id;
	private Integer meadestado;
	private String meadflagalfresco;
	private String meadnombredoc;
	private String meadpath;
	private String meaduuid;
	private Date ultimafechamodif;
	private String ultimousuario;
	
	
	//private SaMensajeObjeto saMensajeObjeto;

	public SaMensajeRecAdjunto() {
		id = new SaMensajeRecAdjuntoPK();
	}


	@EmbeddedId
	public SaMensajeRecAdjuntoPK getId() {
		return this.id;
	}

	public void setId(SaMensajeRecAdjuntoPK id) {
		this.id = id;
	}


	public Integer getMeadestado() {
		return this.meadestado;
	}

	public void setMeadestado(Integer meadestado) {
		this.meadestado = meadestado;
	}


	public String getMeadflagalfresco() {
		return this.meadflagalfresco;
	}

	public void setMeadflagalfresco(String meadflagalfresco) {
		this.meadflagalfresco = meadflagalfresco;
	}


	public String getMeadnombredoc() {
		return this.meadnombredoc;
	}

	public void setMeadnombredoc(String meadnombredoc) {
		this.meadnombredoc = meadnombredoc;
	}


	public String getMeadpath() {
		return this.meadpath;
	}

	public void setMeadpath(String meadpath) {
		this.meadpath = meadpath;
	}


	public String getMeaduuid() {
		return this.meaduuid;
	}

	public void setMeaduuid(String meaduuid) {
		this.meaduuid = meaduuid;
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


	//bi-directional many-to-one association to SaMensajeObjeto
	/*@ManyToOne
	@JoinColumn(name="MENS_MENSAJEID")
	public SaMensajeObjeto getSaMensajeObjeto() {
		return this.saMensajeObjeto;
	}

	public void setSaMensajeObjeto(SaMensajeObjeto saMensajeObjeto) {
		this.saMensajeObjeto = saMensajeObjeto;
	}*/
	
}