package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="SA_TIPOPROCREGLAMENTO")
public class SaTipopProcReglamento extends Entidad{
	
	private Integer tregid;
	private Date fechacreacion;
	private Date fechamodificacion;
	private String tregcodigo;
	private String tregdescripcion;
	private Integer tregestado;
	private String usuariocreacion;
	private String usuariomodificacion;

	public SaTipopProcReglamento() {
	}

	@Id
	@Column(name = "TREGID")
	public Integer getTregid() {
		return this.tregid;
	}

	public void setTregid(Integer tregid) {
		this.tregid = tregid;
	}


	
	@Column(name = "FECHACREACION")
	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}


	
	@Column(name = "FECHAMODIFICACION")
	public Date getFechamodificacion() {
		return this.fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	@Column(name = "TREGCODIGO")
	public String getTregcodigo() {
		return this.tregcodigo;
	}

	public void setTregcodigo(String tregcodigo) {
		this.tregcodigo = tregcodigo;
	}

	@Column(name = "TREGDESCRIPCION")
	public String getTregdescripcion() {
		return this.tregdescripcion;
	}

	public void setTregdescripcion(String tregdescripcion) {
		this.tregdescripcion = tregdescripcion;
	}

	@Column(name = "TREGESTADO")
	public Integer getTregestado() {
		return this.tregestado;
	}

	public void setTregestado(Integer tregestado) {
		this.tregestado = tregestado;
	}

	@Column(name = "USUARIOCREACION")
	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	@Column(name = "USUARIOMODIFICACION")
	public String getUsuariomodificacion() {
		return this.usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}

}