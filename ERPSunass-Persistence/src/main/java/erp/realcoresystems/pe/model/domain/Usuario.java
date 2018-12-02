package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@SuppressWarnings("serial")
@Entity
public class Usuario  extends Entidad{
	
	private String usuario;

    private String usuarioperfil;

    private String nombre;

    private String clave;

    private String expirarpasswordflag;

    private Date fechaexpiracion;

    private Date ultimologin;

    private Integer numerologinsdisponible;

    private Integer numerologinsusados;

    private String sqllogin;

    private String sqlpassword;

    private String estado;

    private String ultimousuario;

    private Date ultimafechamodif;

    private String usuariored;

    private Integer empleado;

    private Integer sidOracle;

    private Date sidOracleFecha;

    private Integer persona;

    private Integer tipousuario;

    private Integer orden;

    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;
        if (usuarioperfil != null ? !usuarioperfil.equals(usuario1.usuarioperfil) : usuario1.usuarioperfil != null)
            return false;
        if (nombre != null ? !nombre.equals(usuario1.nombre) : usuario1.nombre != null) return false;
        if (clave != null ? !clave.equals(usuario1.clave) : usuario1.clave != null) return false;
        if (expirarpasswordflag != null ? !expirarpasswordflag.equals(usuario1.expirarpasswordflag) : usuario1.expirarpasswordflag != null)
            return false;
        if (fechaexpiracion != null ? !fechaexpiracion.equals(usuario1.fechaexpiracion) : usuario1.fechaexpiracion != null)
            return false;
        if (ultimologin != null ? !ultimologin.equals(usuario1.ultimologin) : usuario1.ultimologin != null)
            return false;
        if (numerologinsdisponible != null ? !numerologinsdisponible.equals(usuario1.numerologinsdisponible) : usuario1.numerologinsdisponible != null)
            return false;
        if (numerologinsusados != null ? !numerologinsusados.equals(usuario1.numerologinsusados) : usuario1.numerologinsusados != null)
            return false;
        if (sqllogin != null ? !sqllogin.equals(usuario1.sqllogin) : usuario1.sqllogin != null) return false;
        if (sqlpassword != null ? !sqlpassword.equals(usuario1.sqlpassword) : usuario1.sqlpassword != null)
            return false;
        if (estado != null ? !estado.equals(usuario1.estado) : usuario1.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(usuario1.ultimousuario) : usuario1.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(usuario1.ultimafechamodif) : usuario1.ultimafechamodif != null)
            return false;
        if (usuariored != null ? !usuariored.equals(usuario1.usuariored) : usuario1.usuariored != null) return false;
        if (empleado != null ? !empleado.equals(usuario1.empleado) : usuario1.empleado != null) return false;
        if (sidOracle != null ? !sidOracle.equals(usuario1.sidOracle) : usuario1.sidOracle != null) return false;
        if (sidOracleFecha != null ? !sidOracleFecha.equals(usuario1.sidOracleFecha) : usuario1.sidOracleFecha != null)
            return false;
        if (persona != null ? !persona.equals(usuario1.persona) : usuario1.persona != null) return false;
        if (tipousuario != null ? !tipousuario.equals(usuario1.tipousuario) : usuario1.tipousuario != null)
            return false;
        if (orden != null ? !orden.equals(usuario1.orden) : usuario1.orden != null) return false;

        return true;
    }

    @Basic
    @javax.persistence.Column(name = "CLAVE")
    public String getClave() {
        return clave;
    }

    @Basic
    @javax.persistence.Column(name = "EMPLEADO")
    public Integer getEmpleado() {
        return empleado;
    }

    @Basic
    @javax.persistence.Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    @Basic
    @javax.persistence.Column(name = "EXPIRARPASSWORDFLAG")
    public String getExpirarpasswordflag() {
        return expirarpasswordflag;
    }

    @Basic
    @javax.persistence.Column(name = "FECHAEXPIRACION")
    public Date getFechaexpiracion() {
        return fechaexpiracion;
    }

    @Basic
    @javax.persistence.Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    @Basic
    @javax.persistence.Column(name = "NUMEROLOGINSDISPONIBLE")
    public Integer getNumerologinsdisponible() {
        return numerologinsdisponible;
    }

    @Basic
    @javax.persistence.Column(name = "NUMEROLOGINSUSADOS")
    public Integer getNumerologinsusados() {
        return numerologinsusados;
    }

    @Basic
    @javax.persistence.Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    @Basic
    @javax.persistence.Column(name = "PERSONA")
    public Integer getPersona() {
        return persona;
    }

    @Basic
    @javax.persistence.Column(name = "SID_ORACLE")
    public Integer getSidOracle() {
        return sidOracle;
    }

    @Basic
    @javax.persistence.Column(name = "SID_ORACLE_FECHA")
    public Date getSidOracleFecha() {
        return sidOracleFecha;
    }

    @Basic
    @javax.persistence.Column(name = "SQLLOGIN")
    public String getSqllogin() {
        return sqllogin;
    }

    @Basic
    @javax.persistence.Column(name = "SQLPASSWORD")
    public String getSqlpassword() {
        return sqlpassword;
    }

    @Basic
    @javax.persistence.Column(name = "TIPOUSUARIO")
    public Integer getTipousuario() {
        return tipousuario;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMOLOGIN")
    public Date getUltimologin() {
        return ultimologin;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    @Id
    @javax.persistence.Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    @Basic
    @javax.persistence.Column(name = "USUARIOPERFIL")
    public String getUsuarioperfil() {
        return usuarioperfil;
    }

    @Basic
    @javax.persistence.Column(name = "USUARIORED")
    public String getUsuariored() {
        return usuariored;
    }

    @Override
    public int hashCode() {
        int result = usuario != null ? usuario.hashCode() : 0;
        result = 31 * result + (usuarioperfil != null ? usuarioperfil.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (clave != null ? clave.hashCode() : 0);
        result = 31 * result + (expirarpasswordflag != null ? expirarpasswordflag.hashCode() : 0);
        result = 31 * result + (fechaexpiracion != null ? fechaexpiracion.hashCode() : 0);
        result = 31 * result + (ultimologin != null ? ultimologin.hashCode() : 0);
        result = 31 * result + (numerologinsdisponible != null ? numerologinsdisponible.hashCode() : 0);
        result = 31 * result + (numerologinsusados != null ? numerologinsusados.hashCode() : 0);
        result = 31 * result + (sqllogin != null ? sqllogin.hashCode() : 0);
        result = 31 * result + (sqlpassword != null ? sqlpassword.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (usuariored != null ? usuariored.hashCode() : 0);
        result = 31 * result + (empleado != null ? empleado.hashCode() : 0);
        result = 31 * result + (sidOracle != null ? sidOracle.hashCode() : 0);
        result = 31 * result + (sidOracleFecha != null ? sidOracleFecha.hashCode() : 0);
        result = 31 * result + (persona != null ? persona.hashCode() : 0);
        result = 31 * result + (tipousuario != null ? tipousuario.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        return result;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setExpirarpasswordflag(String expirarpasswordflag) {
        this.expirarpasswordflag = expirarpasswordflag;
    }

    public void setFechaexpiracion(Date fechaexpiracion) {
        this.fechaexpiracion = fechaexpiracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumerologinsdisponible(Integer numerologinsdisponible) {
        this.numerologinsdisponible = numerologinsdisponible;
    }

    public void setNumerologinsusados(Integer numerologinsusados) {
        this.numerologinsusados = numerologinsusados;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public void setSidOracle(Integer sidOracle) {
        this.sidOracle = sidOracle;
    }

    public void setSidOracleFecha(Date sidOracleFecha) {
        this.sidOracleFecha = sidOracleFecha;
    }

    public void setSqllogin(String sqllogin) {
        this.sqllogin = sqllogin;
    }

    public void setSqlpassword(String sqlpassword) {
        this.sqlpassword = sqlpassword;
    }

    public void setTipousuario(Integer tipousuario) {
        this.tipousuario = tipousuario;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    public void setUltimologin(Date ultimologin) {
        this.ultimologin = ultimologin;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setUsuarioperfil(String usuarioperfil) {
        this.usuarioperfil = usuarioperfil;
    }

    public void setUsuariored(String usuariored) {
        this.usuariored = usuariored;
    }
}
