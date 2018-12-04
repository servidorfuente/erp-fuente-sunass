package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the VW_USUARIOSEGURIDAD database table.
 * 
 */
@Entity
@Table(name="VW_USUARIOSEGURIDAD")
public class VwUsuarioseguridad extends Entidad {
	private static final long serialVersionUID = 1L;

	private String clave;

	private Integer cuentacompaniasadd;

	private Integer cuentaconceptosadd;

	private Integer cuentaconceptosarchivoadd;

	private Integer cuentaperfilesadd;

	private Integer empleado;

	private String estado;

	private String expirarpasswordflag;

	
	private Date fechaexpiracion;

	private Integer idcontador;

	private Integer modalidadesadd;

	private String nombre;

	private Integer numerologinsdisponible;

	private Integer numerologinsusados;

	private Integer orden;

	private Integer persona;

	//@Column(name="SID_ORACLE")
	private Integer sidOracle;

	
	//@Column(name="SID_ORACLE_FECHA")
	private Date sidOracleFecha;

	private String sqllogin;

	private String sqlpassword;

	private Integer sucursalesadd;

	private Integer tipousuario;

	
	private Date ultimafechamodif;

	
	private Date ultimologin;

	private String ultimousuario;

	private String usuario;

	private String usuarioperfil;

	private String usuariored;

	public VwUsuarioseguridad() {
	}

	@Basic
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	@Basic
	public Integer getCuentacompaniasadd() {
		return this.cuentacompaniasadd;
	}

	public void setCuentacompaniasadd(Integer cuentacompaniasadd) {
		this.cuentacompaniasadd = cuentacompaniasadd;
	}
	@Basic
	public Integer getCuentaconceptosadd() {
		return this.cuentaconceptosadd;
	}

	public void setCuentaconceptosadd(Integer cuentaconceptosadd) {
		this.cuentaconceptosadd = cuentaconceptosadd;
	}
	@Basic
	public Integer getCuentaconceptosarchivoadd() {
		return this.cuentaconceptosarchivoadd;
	}

	public void setCuentaconceptosarchivoadd(Integer cuentaconceptosarchivoadd) {
		this.cuentaconceptosarchivoadd = cuentaconceptosarchivoadd;
	}
	@Basic
	public Integer getCuentaperfilesadd() {
		return this.cuentaperfilesadd;
	}

	public void setCuentaperfilesadd(Integer cuentaperfilesadd) {
		this.cuentaperfilesadd = cuentaperfilesadd;
	}
	@Basic
	public Integer getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}
	@Basic
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Basic
	public String getExpirarpasswordflag() {
		return this.expirarpasswordflag;
	}

	public void setExpirarpasswordflag(String expirarpasswordflag) {
		this.expirarpasswordflag = expirarpasswordflag;
	}
	@Basic
	public Date getFechaexpiracion() {
		return this.fechaexpiracion;
	}

	public void setFechaexpiracion(Date fechaexpiracion) {
		this.fechaexpiracion = fechaexpiracion;
	}

	@Id
	public Integer getIdcontador() {
		return this.idcontador;
	}

	public void setIdcontador(Integer idcontador) {
		this.idcontador = idcontador;
	}
	@Basic
	public Integer getModalidadesadd() {
		return this.modalidadesadd;
	}

	public void setModalidadesadd(Integer modalidadesadd) {
		this.modalidadesadd = modalidadesadd;
	}
	@Basic
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Basic
	public Integer getNumerologinsdisponible() {
		return this.numerologinsdisponible;
	}

	public void setNumerologinsdisponible(Integer numerologinsdisponible) {
		this.numerologinsdisponible = numerologinsdisponible;
	}
	@Basic
	public Integer getNumerologinsusados() {
		return this.numerologinsusados;
	}

	public void setNumerologinsusados(Integer numerologinsusados) {
		this.numerologinsusados = numerologinsusados;
	}
	@Basic
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	@Basic
	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	@Basic
	@Column(name="SID_ORACLE")
	public Integer getSidOracle() {
		return this.sidOracle;
	}

	public void setSidOracle(Integer sidOracle) {
		this.sidOracle = sidOracle;
	}
	@Basic
	@Column(name = "SID_ORACLE_FECHA")
	public Date getSidOracleFecha() {
		return this.sidOracleFecha;
	}

	public void setSidOracleFecha(Date sidOracleFecha) {
		this.sidOracleFecha = sidOracleFecha;
	}
	@Basic
	public String getSqllogin() {
		return this.sqllogin;
	}

	public void setSqllogin(String sqllogin) {
		this.sqllogin = sqllogin;
	}
	@Basic
	public String getSqlpassword() {
		return this.sqlpassword;
	}

	public void setSqlpassword(String sqlpassword) {
		this.sqlpassword = sqlpassword;
	}
	@Basic
	public Integer getSucursalesadd() {
		return this.sucursalesadd;
	}

	public void setSucursalesadd(Integer sucursalesadd) {
		this.sucursalesadd = sucursalesadd;
	}
	@Basic
	public Integer getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Integer tipousuario) {
		this.tipousuario = tipousuario;
	}
	@Basic
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	@Basic
	public Date getUltimologin() {
		return this.ultimologin;
	}

	public void setUltimologin(Date ultimologin) {
		this.ultimologin = ultimologin;
	}
	@Basic
	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	@Basic
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Basic
	public String getUsuarioperfil() {
		return this.usuarioperfil;
	}

	public void setUsuarioperfil(String usuarioperfil) {
		this.usuarioperfil = usuarioperfil;
	}
	@Basic
	public String getUsuariored() {
		return this.usuariored;
	}

	public void setUsuariored(String usuariored) {
		this.usuariored = usuariored;
	}

}