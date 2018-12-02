package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_FAMILIAR database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_FAMILIAR")
public class SaPersonaFamiliar extends Entidad {
	private static final long serialVersionUID = 1L;
	private SaPersonaFamiliarPK id;
	private String apellidomaterno;
	private String apellidopaterno;
	private String carnetasistenciasocial;
	private Integer centroasistenciasocial;
	private String centroeducacion;
	private String cirugias;
	private String codigopostal;
	private String codigoseguro;
	private String comentarios;
	private String conseguro;
	private String departamento;
	private String direccioncompleta;
	private String direccionempresa;
	private String documentoatencionmedica;
	private String documentoidentidad;
	private String documentoincapacidad;
	private String empresa;
	private String enfermedadgraveflag;
	private String estado;
	private String fax;
	private Date fechabaja;
	private Date fechanacimiento;
	private String flagbeneficio;
	private String flagdomiciliopropio;
	private String flagtrabaja;
	private String gradoeducacion;
	private String historiamedica;
	private String motivobaja;
	private String nombrecompleto;
	private String nombres;
	private String sexo;
	private BigDecimal sueldo;
	private String telefono;
	private Integer tiemposervicio;
	private String tieneescolaridad;
	private String tipocarga;
	private String tipocarnetasistenciasocial;
	private String tipodependiente;
	private String tipodependientedesc;
	private String tipodocumentoatencionmedica;
	private String tipodocumentoidentidad;
	private String tipoescolariadad;
	private String tiposangre;
	private Date ultimafechamodif;
	private String ultimousuario;
	private String vacunas;

	public SaPersonaFamiliar() {
		id = new SaPersonaFamiliarPK();
	}


	@EmbeddedId
	public SaPersonaFamiliarPK getId() {
		return this.id;
	}

	public void setId(SaPersonaFamiliarPK id) {
		this.id = id;
	}


	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}


	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}


	public String getCarnetasistenciasocial() {
		return this.carnetasistenciasocial;
	}

	public void setCarnetasistenciasocial(String carnetasistenciasocial) {
		this.carnetasistenciasocial = carnetasistenciasocial;
	}


	public Integer getCentroasistenciasocial() {
		return this.centroasistenciasocial;
	}

	public void setCentroasistenciasocial(Integer centroasistenciasocial) {
		this.centroasistenciasocial = centroasistenciasocial;
	}


	public String getCentroeducacion() {
		return this.centroeducacion;
	}

	public void setCentroeducacion(String centroeducacion) {
		this.centroeducacion = centroeducacion;
	}


	public String getCirugias() {
		return this.cirugias;
	}

	public void setCirugias(String cirugias) {
		this.cirugias = cirugias;
	}


	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}


	public String getCodigoseguro() {
		return this.codigoseguro;
	}

	public void setCodigoseguro(String codigoseguro) {
		this.codigoseguro = codigoseguro;
	}


	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getConseguro() {
		return this.conseguro;
	}

	public void setConseguro(String conseguro) {
		this.conseguro = conseguro;
	}


	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getDireccioncompleta() {
		return this.direccioncompleta;
	}

	public void setDireccioncompleta(String direccioncompleta) {
		this.direccioncompleta = direccioncompleta;
	}


	public String getDireccionempresa() {
		return this.direccionempresa;
	}

	public void setDireccionempresa(String direccionempresa) {
		this.direccionempresa = direccionempresa;
	}


	public String getDocumentoatencionmedica() {
		return this.documentoatencionmedica;
	}

	public void setDocumentoatencionmedica(String documentoatencionmedica) {
		this.documentoatencionmedica = documentoatencionmedica;
	}


	public String getDocumentoidentidad() {
		return this.documentoidentidad;
	}

	public void setDocumentoidentidad(String documentoidentidad) {
		this.documentoidentidad = documentoidentidad;
	}


	public String getDocumentoincapacidad() {
		return this.documentoincapacidad;
	}

	public void setDocumentoincapacidad(String documentoincapacidad) {
		this.documentoincapacidad = documentoincapacidad;
	}


	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getEnfermedadgraveflag() {
		return this.enfermedadgraveflag;
	}

	public void setEnfermedadgraveflag(String enfermedadgraveflag) {
		this.enfermedadgraveflag = enfermedadgraveflag;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	
	public Date getFechabaja() {
		return this.fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}


	
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	public String getFlagbeneficio() {
		return this.flagbeneficio;
	}

	public void setFlagbeneficio(String flagbeneficio) {
		this.flagbeneficio = flagbeneficio;
	}


	public String getFlagdomiciliopropio() {
		return this.flagdomiciliopropio;
	}

	public void setFlagdomiciliopropio(String flagdomiciliopropio) {
		this.flagdomiciliopropio = flagdomiciliopropio;
	}


	public String getFlagtrabaja() {
		return this.flagtrabaja;
	}

	public void setFlagtrabaja(String flagtrabaja) {
		this.flagtrabaja = flagtrabaja;
	}


	public String getGradoeducacion() {
		return this.gradoeducacion;
	}

	public void setGradoeducacion(String gradoeducacion) {
		this.gradoeducacion = gradoeducacion;
	}


	public String getHistoriamedica() {
		return this.historiamedica;
	}

	public void setHistoriamedica(String historiamedica) {
		this.historiamedica = historiamedica;
	}


	public String getMotivobaja() {
		return this.motivobaja;
	}

	public void setMotivobaja(String motivobaja) {
		this.motivobaja = motivobaja;
	}


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public BigDecimal getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Integer getTiemposervicio() {
		return this.tiemposervicio;
	}

	public void setTiemposervicio(Integer tiemposervicio) {
		this.tiemposervicio = tiemposervicio;
	}


	public String getTieneescolaridad() {
		return this.tieneescolaridad;
	}

	public void setTieneescolaridad(String tieneescolaridad) {
		this.tieneescolaridad = tieneescolaridad;
	}


	public String getTipocarga() {
		return this.tipocarga;
	}

	public void setTipocarga(String tipocarga) {
		this.tipocarga = tipocarga;
	}


	public String getTipocarnetasistenciasocial() {
		return this.tipocarnetasistenciasocial;
	}

	public void setTipocarnetasistenciasocial(String tipocarnetasistenciasocial) {
		this.tipocarnetasistenciasocial = tipocarnetasistenciasocial;
	}


	public String getTipodependiente() {
		return this.tipodependiente;
	}

	public void setTipodependiente(String tipodependiente) {
		this.tipodependiente = tipodependiente;
	}


	public String getTipodependientedesc() {
		return this.tipodependientedesc;
	}

	public void setTipodependientedesc(String tipodependientedesc) {
		this.tipodependientedesc = tipodependientedesc;
	}


	public String getTipodocumentoatencionmedica() {
		return this.tipodocumentoatencionmedica;
	}

	public void setTipodocumentoatencionmedica(String tipodocumentoatencionmedica) {
		this.tipodocumentoatencionmedica = tipodocumentoatencionmedica;
	}


	public String getTipodocumentoidentidad() {
		return this.tipodocumentoidentidad;
	}

	public void setTipodocumentoidentidad(String tipodocumentoidentidad) {
		this.tipodocumentoidentidad = tipodocumentoidentidad;
	}


	public String getTipoescolariadad() {
		return this.tipoescolariadad;
	}

	public void setTipoescolariadad(String tipoescolariadad) {
		this.tipoescolariadad = tipoescolariadad;
	}


	public String getTiposangre() {
		return this.tiposangre;
	}

	public void setTiposangre(String tiposangre) {
		this.tiposangre = tiposangre;
	}


	
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


	public String getVacunas() {
		return this.vacunas;
	}

	public void setVacunas(String vacunas) {
		this.vacunas = vacunas;
	}

}