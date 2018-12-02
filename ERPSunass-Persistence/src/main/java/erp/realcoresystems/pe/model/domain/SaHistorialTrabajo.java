package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="SA_HISTORIALTRABAJO")
public class SaHistorialTrabajo extends Entidad{
	
	private Long historialtrabajoid;
	private Long admisiondetalleid;
	private String htrcargoactual;
	private String htrcargoanterior;
	private Date htrfecha;
	private String htrinstitutoactual;
	private String htrinstitutoanterior;
	private String htrnombrecompleto;
	private Integer moemestudioid;
	private Integer pedpedidoid;
	private Integer perperiodoid;
	private Integer persona;
	private Integer pospostulanteid;
	private Integer uneunegocioid;

	public SaHistorialTrabajo() {
	}

	@Id
	public long getHistorialtrabajoid() {
		return this.historialtrabajoid;
	}

	public void setHistorialtrabajoid(long historialtrabajoid) {
		this.historialtrabajoid = historialtrabajoid;
	}

	public Long getAdmisiondetalleid() {
		return this.admisiondetalleid;
	}

	public void setAdmisiondetalleid(Long admisiondetalleid) {
		this.admisiondetalleid = admisiondetalleid;
	}

	public String getHtrcargoactual() {
		return this.htrcargoactual;
	}

	public void setHtrcargoactual(String htrcargoactual) {
		this.htrcargoactual = htrcargoactual;
	}

	public String getHtrcargoanterior() {
		return this.htrcargoanterior;
	}

	public void setHtrcargoanterior(String htrcargoanterior) {
		this.htrcargoanterior = htrcargoanterior;
	}

	
	public Date getHtrfecha() {
		return this.htrfecha;
	}

	public void setHtrfecha(Date htrfecha) {
		this.htrfecha = htrfecha;
	}


	public String getHtrinstitutoactual() {
		return this.htrinstitutoactual;
	}

	public void setHtrinstitutoactual(String htrinstitutoactual) {
		this.htrinstitutoactual = htrinstitutoactual;
	}

	public String getHtrinstitutoanterior() {
		return this.htrinstitutoanterior;
	}

	public void setHtrinstitutoanterior(String htrinstitutoanterior) {
		this.htrinstitutoanterior = htrinstitutoanterior;
	}

	public String getHtrnombrecompleto() {
		return this.htrnombrecompleto;
	}

	public void setHtrnombrecompleto(String htrnombrecompleto) {
		this.htrnombrecompleto = htrnombrecompleto;
	}

	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	public Integer getPedpedidoid() {
		return this.pedpedidoid;
	}

	public void setPedpedidoid(Integer pedpedidoid) {
		this.pedpedidoid = pedpedidoid;
	}

	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}

	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getPospostulanteid() {
		return this.pospostulanteid;
	}

	public void setPospostulanteid(Integer pospostulanteid) {
		this.pospostulanteid = pospostulanteid;
	}

	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}
	/**COMENT*/
	
}