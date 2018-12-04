package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_HC_ANAMNESIS_AP database table.
 * 
 */
@Entity
@Table(name="SA_HC_ANAMNESIS_AP")
public class SaHcAnamnesisAp extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaHcAnamnesisApPK id;
	private String actividadfisica;
	private String alcohol;
	private String alergiasgenerales;
	private String alimentos;
	private String caracteristicasmenstruaciones;
	private Integer conmanifestacionesdepresivas;
	private String consumofrutas;
	private String consumoverduras;
	private Integer cpnumeroembarazos;
	private String desarrollosicomotriz;
	private String drogas;
	private Integer estado;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Date fechaultimaregla;
	private Date fechaultimoperiodo;
	private String informacionembarazos;
	private String medicamentos;
	private String menarquia;
	private String menopausia;
	private String metodosanticonceptivos;
	private String saludbucal;
	private String tabaco;
	private String transfusiones;
	private String usuariocreacion;
	private String usuariomodificacion;

	public SaHcAnamnesisAp() {
		id = new SaHcAnamnesisApPK();
	}


	@EmbeddedId
	public SaHcAnamnesisApPK getId() {
		return this.id;
	}

	public void setId(SaHcAnamnesisApPK id) {
		this.id = id;
	}


	public String getActividadfisica() {
		return this.actividadfisica;
	}

	public void setActividadfisica(String actividadfisica) {
		this.actividadfisica = actividadfisica;
	}


	public String getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}


	public String getAlergiasgenerales() {
		return this.alergiasgenerales;
	}

	public void setAlergiasgenerales(String alergiasgenerales) {
		this.alergiasgenerales = alergiasgenerales;
	}


	public String getAlimentos() {
		return this.alimentos;
	}

	public void setAlimentos(String alimentos) {
		this.alimentos = alimentos;
	}


	public String getCaracteristicasmenstruaciones() {
		return this.caracteristicasmenstruaciones;
	}

	public void setCaracteristicasmenstruaciones(String caracteristicasmenstruaciones) {
		this.caracteristicasmenstruaciones = caracteristicasmenstruaciones;
	}


	public Integer getConmanifestacionesdepresivas() {
		return this.conmanifestacionesdepresivas;
	}

	public void setConmanifestacionesdepresivas(Integer conmanifestacionesdepresivas) {
		this.conmanifestacionesdepresivas = conmanifestacionesdepresivas;
	}


	public String getConsumofrutas() {
		return this.consumofrutas;
	}

	public void setConsumofrutas(String consumofrutas) {
		this.consumofrutas = consumofrutas;
	}


	public String getConsumoverduras() {
		return this.consumoverduras;
	}

	public void setConsumoverduras(String consumoverduras) {
		this.consumoverduras = consumoverduras;
	}


	public Integer getCpnumeroembarazos() {
		return this.cpnumeroembarazos;
	}

	public void setCpnumeroembarazos(Integer cpnumeroembarazos) {
		this.cpnumeroembarazos = cpnumeroembarazos;
	}


	public String getDesarrollosicomotriz() {
		return this.desarrollosicomotriz;
	}

	public void setDesarrollosicomotriz(String desarrollosicomotriz) {
		this.desarrollosicomotriz = desarrollosicomotriz;
	}


	public String getDrogas() {
		return this.drogas;
	}

	public void setDrogas(String drogas) {
		this.drogas = drogas;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechamodificacion() {
		return this.fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechaultimaregla() {
		return this.fechaultimaregla;
	}

	public void setFechaultimaregla(Date fechaultimaregla) {
		this.fechaultimaregla = fechaultimaregla;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechaultimoperiodo() {
		return this.fechaultimoperiodo;
	}

	public void setFechaultimoperiodo(Date fechaultimoperiodo) {
		this.fechaultimoperiodo = fechaultimoperiodo;
	}


	public String getInformacionembarazos() {
		return this.informacionembarazos;
	}

	public void setInformacionembarazos(String informacionembarazos) {
		this.informacionembarazos = informacionembarazos;
	}


	public String getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}


	public String getMenarquia() {
		return this.menarquia;
	}

	public void setMenarquia(String menarquia) {
		this.menarquia = menarquia;
	}


	public String getMenopausia() {
		return this.menopausia;
	}

	public void setMenopausia(String menopausia) {
		this.menopausia = menopausia;
	}


	public String getMetodosanticonceptivos() {
		return this.metodosanticonceptivos;
	}

	public void setMetodosanticonceptivos(String metodosanticonceptivos) {
		this.metodosanticonceptivos = metodosanticonceptivos;
	}


	public String getSaludbucal() {
		return this.saludbucal;
	}

	public void setSaludbucal(String saludbucal) {
		this.saludbucal = saludbucal;
	}


	public String getTabaco() {
		return this.tabaco;
	}

	public void setTabaco(String tabaco) {
		this.tabaco = tabaco;
	}


	public String getTransfusiones() {
		return this.transfusiones;
	}

	public void setTransfusiones(String transfusiones) {
		this.transfusiones = transfusiones;
	}


	public String getUsuariocreacion() {
		return this.usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}


	public String getUsuariomodificacion() {
		return this.usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}

}