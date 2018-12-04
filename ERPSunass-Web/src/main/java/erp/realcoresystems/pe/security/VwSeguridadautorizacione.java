package erp.realcoresystems.pe.security;

import java.io.Serializable;


import java.sql.Timestamp;


/**
 * The persistent class for the VW_SEGURIDADAUTORIZACIONES database table.
 * 
 */
//@Entity
//@Table(name="VW_CW_SEGURIDADAUTORIZACIONES")
public class VwSeguridadautorizacione implements Serializable{
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
	private Timestamp ultimaFechaModif;
	private String ultimoUsuario;
	private String url;
	private String usuario;
	private String usuarioPerfil;
	private String visibleFlag;
	private String workFlag;
	private Integer indicadorObjeto;


	public VwSeguridadautorizacione() {
	}

	public String getAplicacionCodigo() {
		return this.aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}
	
	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	


	public String getConcepto() {
		return this.concepto;
	}
	

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public String getConceptoPadre() {
		return this.conceptoPadre;
	}

	public void setConceptoPadre(String conceptoPadre) {
		this.conceptoPadre = conceptoPadre;
	}



	public String getDescripcionCortaAplicacion() {
		return this.descripcionCortaAplicacion;
	}

	public void setDescripcionCortaAplicacion(String descripcionCortaAplicacion) {
		this.descripcionCortaAplicacion = descripcionCortaAplicacion;
	}



	public String getDescripcionGrupo() {
		return this.descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}



	public String getDescripcionSegConcepto() {
		return this.descripcionSegConcepto;
	}

	public void setDescripcionSegConcepto(String descripcionSegConcepto) {
		this.descripcionSegConcepto = descripcionSegConcepto;
	}



	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getEstadoSegConcepto() {
		return this.estadoSegConcepto;
	}

	public void setEstadoSegConcepto(String estadoSegConcepto) {
		this.estadoSegConcepto = estadoSegConcepto;
	}


	
	public String getEstadoUsuario() {
		return this.estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}



	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	
	public String getObjeto() {
		return this.objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}



	public String getObjetoWindow() {
		return this.objetoWindow;
	}

	public void setObjetoWindow(String objetoWindow) {
		this.objetoWindow = objetoWindow;
	}


	
	public String getOpcionAgregarFlag() {
		return this.opcionAgregarFlag;
	}

	public void setOpcionAgregarFlag(String opcionAgregarFlag) {
		this.opcionAgregarFlag = opcionAgregarFlag;
	}

 
	public String getOpcionAprobarFlag() {
		return this.opcionAprobarFlag;
	}

	public void setOpcionAprobarFlag(String opcionAprobarFlag) {
		this.opcionAprobarFlag = opcionAprobarFlag;
	}



	public String getOpcionBorrarFlag() {
		return this.opcionBorrarFlag;
	}

	public void setOpcionBorrarFlag(String opcionBorrarFlag) {
		this.opcionBorrarFlag = opcionBorrarFlag;
	}


	public String getOpcionModificarFlag() {
		return this.opcionModificarFlag;
	}

	public void setOpcionModificarFlag(String opcionModificarFlag) {
		this.opcionModificarFlag = opcionModificarFlag;
	}



	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}


	public String getTipodeAcceso() {
		return this.tipodeAcceso;
	}

	public void setTipodeAcceso(String tipodeAcceso) {
		this.tipodeAcceso = tipodeAcceso;
	}


	public String getTipodeDetalle() {
		return this.tipodeDetalle;
	}

	public void setTipodeDetalle(String tipodeDetalle) {
		this.tipodeDetalle = tipodeDetalle;
	}


	public String getTipodeObjeto() {
		return this.tipodeObjeto;
	}

	public void setTipodeObjeto(String tipodeObjeto) {
		this.tipodeObjeto = tipodeObjeto;
	}


	public Timestamp getUltimaFechaModif() {
		return this.ultimaFechaModif;
	}

	public void setUltimaFechaModif(Timestamp ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}


	public String getUltimoUsuario() {
		return this.ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsuarioPerfil() {
		return this.usuarioPerfil;
	}

	public void setUsuarioPerfil(String usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}


	public String getVisibleFlag() {
		return this.visibleFlag;
	}

	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

	public String getWorkFlag() {
		return this.workFlag;
	}

	public void setWorkFlag(String workFlag) {
		this.workFlag = workFlag;
	}
	public Integer getIndicadorObjeto() {
		return indicadorObjeto;
	}

	public void setIndicadorObjeto(Integer indicadorObjeto) {
		this.indicadorObjeto = indicadorObjeto;
	}

}