package erp.realcoresystems.pe.model.domain.vista;


import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.util.Date;


/**
 * The persistent class for the VW_PERSONA_ALUMNO database table.
 * 
 */
@Entity
@Table(name="VW_PERSONA_ALUMNO")
public class VwPersonaAlumno extends Entidad {
	private static final long serialVersionUID = 1L;
	private String apellidomaterno;
	private String apellidopaterno;
	private String bancomonedaextranjera;
	private String bancomonedalocal;
	private String brevete;
	private Date breveteFecvcto;
	private String busqueda;
	private String cargoid;
	private String carnetextranjeria;
	private Date carnetextranjeriaFecvcto;
	private String celular;
	private String celularemergencia;
	private String ciudadnacimiento;
	private String codigobarras;
	private String codigopostal;
	private String correoelectronico;
	private String correoinstitucional;
	private String cuentamonedaextranjera;
	private String cuentamonedalocal;
	private String departamento;
	private String direccion;
	private String direccionemergencia;
	private String direccionreferencia;
	private Integer discapacidadflag;
	private String distrito;
	private String distritolabor;
	private String documento;
	private String documentofiscal;
	private String documentofiscalfactura;
	private String documentoidentidad;
	private String documentoidentidadFecvcto;
	private String documentomilitarfa;
	private String dptolabor;
	private Integer enfermedadgraveflag;
	private String escliente;
	private String escontacto;
	private String esempleado;
	private String esproveedor;
	private String estado;
	private String estadocivil;
	private String fax;
	private Date fechanacimiento;
	private String flagactualizacion;
	private String grupoetnico;
	private String ingresoaplicacioncodigo;
	private Date ingresofecharegistro;
	private String ingresousuario;
	private String institucionid;
	private String lugarnacimiento;
	private String nacionalidad;
	private String nivelgobierno;
	private String nivelinstruccion;
	private String nombrecompleto;
	private String nombreemergencia;
	private String nombres;
	private String origen;
	private String parentescoemergencia;
	private String pasaporte;
	private String pasaporteFecvcto;
	private Long persona;
	private String personaOld;
	private String personaant;
	private String personaclasificacion;
	private String personanew;
	private String provincia;
	private String provincialabor;
	private String pymeflag;
	private String sexo;
	private String sunatdomiciliado;
	private String sunatnacionalidad;
	private String sunatubigeo;
	private String sunatvia;
	private String sunatzona;
	private String tarjetadecredito;
	private String telefono;
	private String telefonoemergencia;
	private String tipobrevete;
	private String tipocuentaextranjera;
	private String tipocuentalocal;
	private String tipodocumento;
	private String tipopersona;
	private String tipopersonafactura;
	private String tipopersonausuario;
	private Date ultimafechamodif;
	private String ultimousuario;

	public VwPersonaAlumno() {
	}


	@Column(length=60)
	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}


	@Column(length=60)
	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}


	@Column(length=3)
	public String getBancomonedaextranjera() {
		return this.bancomonedaextranjera;
	}

	public void setBancomonedaextranjera(String bancomonedaextranjera) {
		this.bancomonedaextranjera = bancomonedaextranjera;
	}


	@Column(length=3)
	public String getBancomonedalocal() {
		return this.bancomonedalocal;
	}

	public void setBancomonedalocal(String bancomonedalocal) {
		this.bancomonedalocal = bancomonedalocal;
	}


	@Column(length=18)
	public String getBrevete() {
		return this.brevete;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="BREVETE_FECVCTO")
	public Date getBreveteFecvcto() {
		return this.breveteFecvcto;
	}

	public void setBreveteFecvcto(Date breveteFecvcto) {
		this.breveteFecvcto = breveteFecvcto;
	}


	@Column(length=80)
	public String getBusqueda() {
		return this.busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}


	@Column(length=20)
	public String getCargoid() {
		return this.cargoid;
	}

	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}


	@Column(length=10)
	public String getCarnetextranjeria() {
		return this.carnetextranjeria;
	}

	public void setCarnetextranjeria(String carnetextranjeria) {
		this.carnetextranjeria = carnetextranjeria;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CARNETEXTRANJERIA_FECVCTO")
	public Date getCarnetextranjeriaFecvcto() {
		return this.carnetextranjeriaFecvcto;
	}

	public void setCarnetextranjeriaFecvcto(Date carnetextranjeriaFecvcto) {
		this.carnetextranjeriaFecvcto = carnetextranjeriaFecvcto;
	}


	@Column(length=30)
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	@Column(length=30)
	public String getCelularemergencia() {
		return this.celularemergencia;
	}

	public void setCelularemergencia(String celularemergencia) {
		this.celularemergencia = celularemergencia;
	}


	@Column(length=20)
	public String getCiudadnacimiento() {
		return this.ciudadnacimiento;
	}

	public void setCiudadnacimiento(String ciudadnacimiento) {
		this.ciudadnacimiento = ciudadnacimiento;
	}


	@Column(length=18)
	public String getCodigobarras() {
		return this.codigobarras;
	}

	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}


	@Column(length=3)
	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}


	@Column(length=50)
	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}


	@Column(length=50)
	public String getCorreoinstitucional() {
		return this.correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}


	@Column(length=20)
	public String getCuentamonedaextranjera() {
		return this.cuentamonedaextranjera;
	}

	public void setCuentamonedaextranjera(String cuentamonedaextranjera) {
		this.cuentamonedaextranjera = cuentamonedaextranjera;
	}


	@Column(length=20)
	public String getCuentamonedalocal() {
		return this.cuentamonedalocal;
	}

	public void setCuentamonedalocal(String cuentamonedalocal) {
		this.cuentamonedalocal = cuentamonedalocal;
	}


	@Column(length=3)
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	@Column(length=200)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Column(length=60)
	public String getDireccionemergencia() {
		return this.direccionemergencia;
	}

	public void setDireccionemergencia(String direccionemergencia) {
		this.direccionemergencia = direccionemergencia;
	}


	@Column(length=255)
	public String getDireccionreferencia() {
		return this.direccionreferencia;
	}

	public void setDireccionreferencia(String direccionreferencia) {
		this.direccionreferencia = direccionreferencia;
	}


	public Integer getDiscapacidadflag() {
		return this.discapacidadflag;
	}

	public void setDiscapacidadflag(Integer discapacidadflag) {
		this.discapacidadflag = discapacidadflag;
	}


	@Column(length=3)
	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	@Column(length=3)
	public String getDistritolabor() {
		return this.distritolabor;
	}

	public void setDistritolabor(String distritolabor) {
		this.distritolabor = distritolabor;
	}


	@Column(length=20)
	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	@Column(length=20)
	public String getDocumentofiscal() {
		return this.documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}


	@Column(length=20)
	public String getDocumentofiscalfactura() {
		return this.documentofiscalfactura;
	}

	public void setDocumentofiscalfactura(String documentofiscalfactura) {
		this.documentofiscalfactura = documentofiscalfactura;
	}


	@Column(length=20)
	public String getDocumentoidentidad() {
		return this.documentoidentidad;
	}

	public void setDocumentoidentidad(String documentoidentidad) {
		this.documentoidentidad = documentoidentidad;
	}


	@Column(name="DOCUMENTOIDENTIDAD_FECVCTO", length=1)
	public String getDocumentoidentidadFecvcto() {
		return this.documentoidentidadFecvcto;
	}

	public void setDocumentoidentidadFecvcto(String documentoidentidadFecvcto) {
		this.documentoidentidadFecvcto = documentoidentidadFecvcto;
	}


	@Column(length=10)
	public String getDocumentomilitarfa() {
		return this.documentomilitarfa;
	}

	public void setDocumentomilitarfa(String documentomilitarfa) {
		this.documentomilitarfa = documentomilitarfa;
	}


	@Column(length=3)
	public String getDptolabor() {
		return this.dptolabor;
	}

	public void setDptolabor(String dptolabor) {
		this.dptolabor = dptolabor;
	}


	public Integer getEnfermedadgraveflag() {
		return this.enfermedadgraveflag;
	}

	public void setEnfermedadgraveflag(Integer enfermedadgraveflag) {
		this.enfermedadgraveflag = enfermedadgraveflag;
	}


	@Column(length=1)
	public String getEscliente() {
		return this.escliente;
	}

	public void setEscliente(String escliente) {
		this.escliente = escliente;
	}


	@Column(length=1)
	public String getEscontacto() {
		return this.escontacto;
	}

	public void setEscontacto(String escontacto) {
		this.escontacto = escontacto;
	}


	@Column(length=1)
	public String getEsempleado() {
		return this.esempleado;
	}

	public void setEsempleado(String esempleado) {
		this.esempleado = esempleado;
	}


	@Column(length=1)
	public String getEsproveedor() {
		return this.esproveedor;
	}

	public void setEsproveedor(String esproveedor) {
		this.esproveedor = esproveedor;
	}


	@Column(length=1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Column(length=1)
	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}


	@Column(length=30)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	@Temporal(TemporalType.DATE)
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	@Column(length=6)
	public String getFlagactualizacion() {
		return this.flagactualizacion;
	}

	public void setFlagactualizacion(String flagactualizacion) {
		this.flagactualizacion = flagactualizacion;
	}


	@Column(length=3)
	public String getGrupoetnico() {
		return this.grupoetnico;
	}

	public void setGrupoetnico(String grupoetnico) {
		this.grupoetnico = grupoetnico;
	}


	@Column(length=2)
	public String getIngresoaplicacioncodigo() {
		return this.ingresoaplicacioncodigo;
	}

	public void setIngresoaplicacioncodigo(String ingresoaplicacioncodigo) {
		this.ingresoaplicacioncodigo = ingresoaplicacioncodigo;
	}


	@Temporal(TemporalType.DATE)
	public Date getIngresofecharegistro() {
		return this.ingresofecharegistro;
	}

	public void setIngresofecharegistro(Date ingresofecharegistro) {
		this.ingresofecharegistro = ingresofecharegistro;
	}


	@Column(length=20)
	public String getIngresousuario() {
		return this.ingresousuario;
	}

	public void setIngresousuario(String ingresousuario) {
		this.ingresousuario = ingresousuario;
	}


	@Column(length=20)
	public String getInstitucionid() {
		return this.institucionid;
	}

	public void setInstitucionid(String institucionid) {
		this.institucionid = institucionid;
	}


	@Column(length=255)
	public String getLugarnacimiento() {
		return this.lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}


	@Column(length=20)
	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Column(length=4)
	public String getNivelgobierno() {
		return this.nivelgobierno;
	}

	public void setNivelgobierno(String nivelgobierno) {
		this.nivelgobierno = nivelgobierno;
	}


	@Column(length=3)
	public String getNivelinstruccion() {
		return this.nivelinstruccion;
	}

	public void setNivelinstruccion(String nivelinstruccion) {
		this.nivelinstruccion = nivelinstruccion;
	}


	@Column(length=80)
	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	@Column(length=50)
	public String getNombreemergencia() {
		return this.nombreemergencia;
	}

	public void setNombreemergencia(String nombreemergencia) {
		this.nombreemergencia = nombreemergencia;
	}


	@Column(length=30)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	@Column(length=4)
	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	@Column(length=1)
	public String getParentescoemergencia() {
		return this.parentescoemergencia;
	}

	public void setParentescoemergencia(String parentescoemergencia) {
		this.parentescoemergencia = parentescoemergencia;
	}


	@Column(length=18)
	public String getPasaporte() {
		return this.pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}


	@Column(name="PASAPORTE_FECVCTO", length=1)
	public String getPasaporteFecvcto() {
		return this.pasaporteFecvcto;
	}

	public void setPasaporteFecvcto(String pasaporteFecvcto) {
		this.pasaporteFecvcto = pasaporteFecvcto;
	}


	@Id
	@Column(nullable=false)
	public Long getPersona() {
		return this.persona;
	}

	public void setPersona(Long persona) {
		this.persona = persona;
	}


	@Column(name="PERSONA_OLD", length=6)
	public String getPersonaOld() {
		return this.personaOld;
	}

	public void setPersonaOld(String personaOld) {
		this.personaOld = personaOld;
	}


	@Column(length=15)
	public String getPersonaant() {
		return this.personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}


	@Column(length=10)
	public String getPersonaclasificacion() {
		return this.personaclasificacion;
	}

	public void setPersonaclasificacion(String personaclasificacion) {
		this.personaclasificacion = personaclasificacion;
	}


	@Column(length=15)
	public String getPersonanew() {
		return this.personanew;
	}

	public void setPersonanew(String personanew) {
		this.personanew = personanew;
	}


	@Column(length=3)
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	@Column(length=3)
	public String getProvincialabor() {
		return this.provincialabor;
	}

	public void setProvincialabor(String provincialabor) {
		this.provincialabor = provincialabor;
	}


	@Column(length=1)
	public String getPymeflag() {
		return this.pymeflag;
	}

	public void setPymeflag(String pymeflag) {
		this.pymeflag = pymeflag;
	}


	@Column(length=1)
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	@Column(length=1)
	public String getSunatdomiciliado() {
		return this.sunatdomiciliado;
	}

	public void setSunatdomiciliado(String sunatdomiciliado) {
		this.sunatdomiciliado = sunatdomiciliado;
	}


	@Column(length=6)
	public String getSunatnacionalidad() {
		return this.sunatnacionalidad;
	}

	public void setSunatnacionalidad(String sunatnacionalidad) {
		this.sunatnacionalidad = sunatnacionalidad;
	}


	@Column(length=10)
	public String getSunatubigeo() {
		return this.sunatubigeo;
	}

	public void setSunatubigeo(String sunatubigeo) {
		this.sunatubigeo = sunatubigeo;
	}


	@Column(length=2)
	public String getSunatvia() {
		return this.sunatvia;
	}

	public void setSunatvia(String sunatvia) {
		this.sunatvia = sunatvia;
	}


	@Column(length=2)
	public String getSunatzona() {
		return this.sunatzona;
	}

	public void setSunatzona(String sunatzona) {
		this.sunatzona = sunatzona;
	}


	@Column(length=1)
	public String getTarjetadecredito() {
		return this.tarjetadecredito;
	}

	public void setTarjetadecredito(String tarjetadecredito) {
		this.tarjetadecredito = tarjetadecredito;
	}


	@Column(length=30)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Column(length=30)
	public String getTelefonoemergencia() {
		return this.telefonoemergencia;
	}

	public void setTelefonoemergencia(String telefonoemergencia) {
		this.telefonoemergencia = telefonoemergencia;
	}


	@Column(length=1)
	public String getTipobrevete() {
		return this.tipobrevete;
	}

	public void setTipobrevete(String tipobrevete) {
		this.tipobrevete = tipobrevete;
	}


	@Column(length=3)
	public String getTipocuentaextranjera() {
		return this.tipocuentaextranjera;
	}

	public void setTipocuentaextranjera(String tipocuentaextranjera) {
		this.tipocuentaextranjera = tipocuentaextranjera;
	}


	@Column(length=3)
	public String getTipocuentalocal() {
		return this.tipocuentalocal;
	}

	public void setTipocuentalocal(String tipocuentalocal) {
		this.tipocuentalocal = tipocuentalocal;
	}


	@Column(length=1)
	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	@Column(length=1)
	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}


	@Column(length=1)
	public String getTipopersonafactura() {
		return this.tipopersonafactura;
	}

	public void setTipopersonafactura(String tipopersonafactura) {
		this.tipopersonafactura = tipopersonafactura;
	}


	@Column(length=3)
	public String getTipopersonausuario() {
		return this.tipopersonausuario;
	}

	public void setTipopersonausuario(String tipopersonausuario) {
		this.tipopersonausuario = tipopersonausuario;
	}


	@Temporal(TemporalType.DATE)
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


	@Column(length=20)
	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}


}