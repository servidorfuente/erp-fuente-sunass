package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import erp.realcoresystems.pe.model.domain.Entidad;


/**	
 * The persistent class for the VW_SEGURIDADAUTORIZACIONES database table.
 * 
 */
@Entity
@Table(name = "VW_SEGURIDADAUTORIZACIONES")
public class VwSeguridadautorizacione extends Entidad {
	private static final long serialVersionUID = 1L;
	private String aplicacionCodigo;
	private String concepto;
	private String conceptoPadre;
	private String descripcionCortaAplicacion;
	private String descripcionGrupo;
	private String descripcionSegConcepto;
	private String estado;
	private String estadoSegConcepto;
	private String estadoUsuario;
	private String grupo;
	private String nombreUsuario;
	private String objeto;
	private String objetoWindow;
	private String opcionAgregarFlag;
	private String opcionAprobarFlag;
	private String opcionBorrarFlag;
	private String opcionModificarFlag;
	private Integer persona;
	private String tipodeAcceso;
	private String tipodeDetalle;
	private String tipodeObjeto;
	private Date ultimaFechaModif;
	private String ultimoUsuario;
	private String url;
	private String usuario;
	private String usuarioPerfil;
	private String visibleFlag;
	private String workFlag;
	private Integer webGrupoSecuencia;

	public VwSeguridadautorizacione() {
	}

	@Id
	@Column(name = "AplicacionCodigo")
	public String getAplicacionCodigo() {
		return this.aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	@Id
	@Column(name = "Grupo")
	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Id
	@Column(name = "Concepto")
	public String getConcepto() {
		return this.concepto;
	}

	@Id
	@Column(name = "Usuario")
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Column(name = "ConceptoPadre")
	public String getConceptoPadre() {
		return this.conceptoPadre;
	}

	public void setConceptoPadre(String conceptoPadre) {
		this.conceptoPadre = conceptoPadre;
	}

	@Column(name = "DescripcionCortaAplicacion")
	public String getDescripcionCortaAplicacion() {
		return this.descripcionCortaAplicacion;
	}

	public void setDescripcionCortaAplicacion(String descripcionCortaAplicacion) {
		this.descripcionCortaAplicacion = descripcionCortaAplicacion;
	}

	@Column(name = "DescripcionGrupo")
	public String getDescripcionGrupo() {
		return this.descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}

	@Column(name = "DescripcionSegConcepto")
	public String getDescripcionSegConcepto() {
		return this.descripcionSegConcepto;
	}

	public void setDescripcionSegConcepto(String descripcionSegConcepto) {
		this.descripcionSegConcepto = descripcionSegConcepto;
	}

	@Column(name = "Estado")
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "EstadoSegConcepto")
	public String getEstadoSegConcepto() {
		return this.estadoSegConcepto;
	}

	public void setEstadoSegConcepto(String estadoSegConcepto) {
		this.estadoSegConcepto = estadoSegConcepto;
	}

	@Column(name = "EstadoUsuario")
	public String getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	@Column(name = "NombreUsuario")
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "Objeto")
	public String getObjeto() {
		return this.objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	@Column(name = "ObjetoWindow")
	public String getObjetoWindow() {
		return this.objetoWindow;
	}

	public void setObjetoWindow(String objetoWindow) {
		this.objetoWindow = objetoWindow;
	}

	@Column(name = "OpcionAgregarFlag")
	public String getOpcionAgregarFlag() {
		return this.opcionAgregarFlag;
	}

	public void setOpcionAgregarFlag(String opcionAgregarFlag) {
		this.opcionAgregarFlag = opcionAgregarFlag;
	}

	@Column(name = "OpcionAprobarFlag")
	public String getOpcionAprobarFlag() {
		return this.opcionAprobarFlag;
	}

	public void setOpcionAprobarFlag(String opcionAprobarFlag) {
		this.opcionAprobarFlag = opcionAprobarFlag;
	}

	@Column(name = "OpcionBorrarFlag")
	public String getOpcionBorrarFlag() {
		return this.opcionBorrarFlag;
	}

	public void setOpcionBorrarFlag(String opcionBorrarFlag) {
		this.opcionBorrarFlag = opcionBorrarFlag;
	}

	@Column(name = "OpcionModificarFlag")
	public String getOpcionModificarFlag() {
		return this.opcionModificarFlag;
	}

	public void setOpcionModificarFlag(String opcionModificarFlag) {
		this.opcionModificarFlag = opcionModificarFlag;
	}

	@Column(name = "Persona")
	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	@Column(name = "TipodeAcceso")
	public String getTipodeAcceso() {
		return this.tipodeAcceso;
	}

	public void setTipodeAcceso(String tipodeAcceso) {
		this.tipodeAcceso = tipodeAcceso;
	}

	@Column(name = "TipodeDetalle")
	public String getTipodeDetalle() {
		return this.tipodeDetalle;
	}

	public void setTipodeDetalle(String tipodeDetalle) {
		this.tipodeDetalle = tipodeDetalle;
	}

	@Column(name = "TipodeObjeto")
	public String getTipodeObjeto() {
		return this.tipodeObjeto;
	}

	public void setTipodeObjeto(String tipodeObjeto) {
		this.tipodeObjeto = tipodeObjeto;
	}

	@Column(name = "UltimaFechaModif")
	public Date getUltimaFechaModif() {
		return this.ultimaFechaModif;
	}

	public void setUltimaFechaModif(Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}

	@Column(name = "UltimoUsuario")
	public String getUltimoUsuario() {
		return this.ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	@Column(name = "Url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "UsuarioPerfil")
	public String getUsuarioPerfil() {
		return this.usuarioPerfil;
	}

	public void setUsuarioPerfil(String usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	@Column(name = "VisibleFlag")
	public String getVisibleFlag() {
		return this.visibleFlag;
	}

	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

	@Column(name = "WorkFlag")
	public String getWorkFlag() {
		return this.workFlag;
	}

	public void setWorkFlag(String workFlag) {
		this.workFlag = workFlag;
	}

	@Column(name = "WebGrupoSecuencia")
	public Integer getWebGrupoSecuencia() {
		return webGrupoSecuencia;
	}

	public void setWebGrupoSecuencia(Integer webGrupoSecuencia) {
		this.webGrupoSecuencia = webGrupoSecuencia;
	}

	
}