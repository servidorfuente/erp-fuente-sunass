package erp.realcoresystems.pe.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the CLIENTEMAST database table.
 * 
 */
@Entity
@NamedQuery(name = "Clientemast.findAll", query = "SELECT c FROM Clientemast c")
public class Clientemast implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cantidaddependientes;

	private String centrocosto;

	private String clasificacion;
	@Id
	private Integer cliente;

	private String conceptofacturacion;

	private String esgarante;

	private String fechavencimientologica;

	private Integer financiamientotasa;

	private String formadepago;

	private String formafacturacion;

	private String garanteclasificacion;

	private String garantedireccion;

	private String garantedocumento;

	private String garantenombre;

	private Integer ingresomensual;

	
	private Date licenciafechadesde;

	
	private Date licenciafechahasta;

	private String licencianumero;

	private Integer lineacredito;

	
	private Date lineacreditofechavencimiento;

	private String lineacreditomoneda;

	private String nacionalidad;

	private Integer numerodiascobranza;

	private String pagoefectivoflag;

	private String personacontacto;

	private String practicotmcflag;

	private String resoluciondirectoral;

	private String rutadespacho;

	private String suspensionflag;

	private String tipoactividad;

	private String tipocliente;

	private String tipodocumento;

	private String tipofacturacion;

	private String tiposervicio;

	private String tipoventa;

	private Integer totalacumulado;

	private Integer vendedor;

	public Clientemast() {
	}

	public Integer getCantidaddependientes() {
		return this.cantidaddependientes;
	}

	public void setCantidaddependientes(Integer cantidaddependientes) {
		this.cantidaddependientes = cantidaddependientes;
	}

	public String getCentrocosto() {
		return this.centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Integer getCliente() {
		return this.cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public String getConceptofacturacion() {
		return this.conceptofacturacion;
	}

	public void setConceptofacturacion(String conceptofacturacion) {
		this.conceptofacturacion = conceptofacturacion;
	}

	public String getEsgarante() {
		return this.esgarante;
	}

	public void setEsgarante(String esgarante) {
		this.esgarante = esgarante;
	}

	public String getFechavencimientologica() {
		return this.fechavencimientologica;
	}

	public void setFechavencimientologica(String fechavencimientologica) {
		this.fechavencimientologica = fechavencimientologica;
	}

	public Integer getFinanciamientotasa() {
		return this.financiamientotasa;
	}

	public void setFinanciamientotasa(Integer financiamientotasa) {
		this.financiamientotasa = financiamientotasa;
	}

	public String getFormadepago() {
		return this.formadepago;
	}

	public void setFormadepago(String formadepago) {
		this.formadepago = formadepago;
	}

	public String getFormafacturacion() {
		return this.formafacturacion;
	}

	public void setFormafacturacion(String formafacturacion) {
		this.formafacturacion = formafacturacion;
	}

	public String getGaranteclasificacion() {
		return this.garanteclasificacion;
	}

	public void setGaranteclasificacion(String garanteclasificacion) {
		this.garanteclasificacion = garanteclasificacion;
	}

	public String getGarantedireccion() {
		return this.garantedireccion;
	}

	public void setGarantedireccion(String garantedireccion) {
		this.garantedireccion = garantedireccion;
	}

	public String getGarantedocumento() {
		return this.garantedocumento;
	}

	public void setGarantedocumento(String garantedocumento) {
		this.garantedocumento = garantedocumento;
	}

	public String getGarantenombre() {
		return this.garantenombre;
	}

	public void setGarantenombre(String garantenombre) {
		this.garantenombre = garantenombre;
	}

	public Integer getIngresomensual() {
		return this.ingresomensual;
	}

	public void setIngresomensual(Integer ingresomensual) {
		this.ingresomensual = ingresomensual;
	}

	public Date getLicenciafechadesde() {
		return this.licenciafechadesde;
	}

	public void setLicenciafechadesde(Date licenciafechadesde) {
		this.licenciafechadesde = licenciafechadesde;
	}

	public Date getLicenciafechahasta() {
		return this.licenciafechahasta;
	}

	public void setLicenciafechahasta(Date licenciafechahasta) {
		this.licenciafechahasta = licenciafechahasta;
	}

	public String getLicencianumero() {
		return this.licencianumero;
	}

	public void setLicencianumero(String licencianumero) {
		this.licencianumero = licencianumero;
	}

	public Integer getLineacredito() {
		return this.lineacredito;
	}

	public void setLineacredito(Integer lineacredito) {
		this.lineacredito = lineacredito;
	}

	public Date getLineacreditofechavencimiento() {
		return this.lineacreditofechavencimiento;
	}

	public void setLineacreditofechavencimiento(Date lineacreditofechavencimiento) {
		this.lineacreditofechavencimiento = lineacreditofechavencimiento;
	}

	public String getLineacreditomoneda() {
		return this.lineacreditomoneda;
	}

	public void setLineacreditomoneda(String lineacreditomoneda) {
		this.lineacreditomoneda = lineacreditomoneda;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getNumerodiascobranza() {
		return this.numerodiascobranza;
	}

	public void setNumerodiascobranza(Integer numerodiascobranza) {
		this.numerodiascobranza = numerodiascobranza;
	}

	public String getPagoefectivoflag() {
		return this.pagoefectivoflag;
	}

	public void setPagoefectivoflag(String pagoefectivoflag) {
		this.pagoefectivoflag = pagoefectivoflag;
	}

	public String getPersonacontacto() {
		return this.personacontacto;
	}

	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}

	public String getPracticotmcflag() {
		return this.practicotmcflag;
	}

	public void setPracticotmcflag(String practicotmcflag) {
		this.practicotmcflag = practicotmcflag;
	}

	public String getResoluciondirectoral() {
		return this.resoluciondirectoral;
	}

	public void setResoluciondirectoral(String resoluciondirectoral) {
		this.resoluciondirectoral = resoluciondirectoral;
	}

	public String getRutadespacho() {
		return this.rutadespacho;
	}

	public void setRutadespacho(String rutadespacho) {
		this.rutadespacho = rutadespacho;
	}

	public String getSuspensionflag() {
		return this.suspensionflag;
	}

	public void setSuspensionflag(String suspensionflag) {
		this.suspensionflag = suspensionflag;
	}

	public String getTipoactividad() {
		return this.tipoactividad;
	}

	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public String getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getTipofacturacion() {
		return this.tipofacturacion;
	}

	public void setTipofacturacion(String tipofacturacion) {
		this.tipofacturacion = tipofacturacion;
	}

	public String getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public String getTipoventa() {
		return this.tipoventa;
	}

	public void setTipoventa(String tipoventa) {
		this.tipoventa = tipoventa;
	}

	public Integer getTotalacumulado() {
		return this.totalacumulado;
	}

	public void setTotalacumulado(Integer totalacumulado) {
		this.totalacumulado = totalacumulado;
	}

	public Integer getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Integer vendedor) {
		this.vendedor = vendedor;
	}

}