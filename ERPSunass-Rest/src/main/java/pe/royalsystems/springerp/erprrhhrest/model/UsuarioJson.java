package erp.realcoresystems.pe.erprrhhrest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;

import java.util.Date;

@JsonIgnoreProperties( value = { 
		/**Campos a ignorar*/	
		"uri"
		,"paginable"
	})
@JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
public class UsuarioJson extends EntidadJson<UsuarioJson> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 784807356316702700L;
	private String usuario;
	private String clave;
	private String estado;
	private String expirarPasswordFlag;	
	private String nombre;
	private Integer numeroLoginsDisponible;
	private Integer numeroLoginsUsados;
	private String SQLLogin;
	private String SQLPassword;
	private String ultimoUsuario;
	private String usuarioPerfil;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'" )
	private Date fechaExpiracion;
	
	//formato default: dd/MM/yyyy HH:mm:ss
	private String fechaExpiracionStr;
	
	private Integer persona;
			
	private String companiaSocio;
	private String companiaSocioDesc;
	private String areaRevisora;
	private String areaRevisoraDesc;
	
	
	
	
	
	public UsuarioJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getExpirarPasswordFlag() {
		return expirarPasswordFlag;
	}
	public void setExpirarPasswordFlag(String expirarPasswordFlag) {
		this.expirarPasswordFlag = expirarPasswordFlag;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getNumeroLoginsDisponible() {
		return numeroLoginsDisponible;
	}
	public void setNumeroLoginsDisponible(Integer numeroLoginsDisponible) {
		this.numeroLoginsDisponible = numeroLoginsDisponible;
	}
	public Integer getNumeroLoginsUsados() {
		return numeroLoginsUsados;
	}
	public void setNumeroLoginsUsados(Integer numeroLoginsUsados) {
		this.numeroLoginsUsados = numeroLoginsUsados;
	}
	public String getSQLLogin() {
		return SQLLogin;
	}
	public void setSQLLogin(String sQLLogin) {
		SQLLogin = sQLLogin;
	}
	public String getSQLPassword() {
		return SQLPassword;
	}
	public void setSQLPassword(String sQLPassword) {
		SQLPassword = sQLPassword;
	}
	public String getUltimoUsuario() {
		return ultimoUsuario;
	}
	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}
	public String getUsuarioPerfil() {
		return usuarioPerfil;
	}
	public void setUsuarioPerfil(String usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}
	public Integer getPersona() {
		return persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	public String getCompaniaSocio() {
		return companiaSocio;
	}
	public void setCompaniaSocio(String companiaSocio) {
		this.companiaSocio = companiaSocio;
	}
	public String getAreaRevisora() {
		return areaRevisora;
	}
	public void setAreaRevisora(String areaRevisora) {
		this.areaRevisora = areaRevisora;
	}
	public String getCompaniaSocioDesc() {
		return companiaSocioDesc;
	}
	public void setCompaniaSocioDesc(String companiaSocioDesc) {
		this.companiaSocioDesc = companiaSocioDesc;
	}
	public String getAreaRevisoraDesc() {
		return areaRevisoraDesc;
	}
	public void setAreaRevisoraDesc(String areaRevisoraDesc) {
		this.areaRevisoraDesc = areaRevisoraDesc;
	}
	public Date getFechaExpiracion() {
		fixDateFormat(this, fechaExpiracion, m -> m.setFechaExpiracion(getFecha(fechaExpiracionStr)));
//		if(fechaExpiracion==null){
//			setFechaExpiracion(getFecha(fechaExpiracionStr));
//		}		
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public String getFechaExpiracionStr() {
		fixDateFormat(this, fechaExpiracionStr, m -> m.setFechaExpiracionStr(getFechaFormat(fechaExpiracion)));
//		if(fechaExpiracionStr==null){
//			setFechaExpiracionStr(getFechaFormat(fechaExpiracion));
//		}
		return fechaExpiracionStr;
	}
	public void setFechaExpiracionStr(String fechaExpiracionStr) {
		this.fechaExpiracionStr = fechaExpiracionStr;
	}

}
