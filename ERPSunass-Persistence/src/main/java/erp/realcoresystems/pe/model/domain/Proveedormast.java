package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PROVEEDORMAST database table.
 * 
 */
@Entity
@NamedQuery(name = "Proveedormast.findAll", query = "SELECT p FROM Proveedormast p")
public class Proveedormast extends Entidad {
	private static final long serialVersionUID = 1L;

	private String chequenonegociableflag;

	private String clasificacionfiscal;

	private String giro;

	private String cobradornombre;

	private String cobradornumerodocumento;

	private String cobradortipodocumento;

	private Date comentariofecha;

	private String comentarioservicio;

	private String comentariousuario;

	private String cuentacontablegasto;

	private String detraccioncodigo;

	private String detraccioncodigoflag;

	private String detraccioncuentabancaria;

	private String exoneradodeclaracion;

	private Date exoneradofechafinal;

	private Date exoneradofechainicio;

	private String exoneradomediopresentacion;

	private String experienciatiempo;

	private Date fechaautorizacionfiscal;

	private Date fechaconstitucion;

	private String formadepago;

	private String intervencionfiscalcomentario;

	private String intervencionfiscaldocumento;

	private Date intervencionfiscalfecha;

	private String intervencionfiscalflag;

	private String licenciamunicipal;

	private String monedapago;

	private Integer numerodiasentrega;

	private Integer numerodiaspago;

	private String pagaranombre;

	private String pagarendireccion;

	private String personacontacto;

	private Integer proveedor;

	private Integer proveedorrelacionado;

	private String registropublico;

	private String representantelegal;

	private String responsible;

	private String retenerpagosflag;

	private Personamast saPersona;

	private String suspensionfonaviflag;

	private String suspensionrentaflag;

	private String tipodocumentodefault;

	private String tipopago;

	private String tipoproveedor;

	private String maplatitud;

	private String maplongitud;

	// entidades
	@Basic
	@Column(name = "MAPLATITUD")
	public String getMaplatitud() {
		return maplatitud;
	}

	@Basic
	@Column(name = "MAPLONGITUD")
	public String getMaplongitud() {
		return maplongitud;
	}

	private String tiposervicio;

	// ---------------------------------------------

	@Basic
	@Column(name = "CHEQUENONEGOCIABLEFLAG")
	public String getChequenonegociableflag() {
		return this.chequenonegociableflag;
	}

	@Basic
	@Column(name = "CLASIFICACIONFISCAL")
	public String getClasificacionfiscal() {
		return this.clasificacionfiscal;
	}

	@Basic
	@Column(name = "COBRADORNOMBRE")
	public String getCobradornombre() {
		return this.cobradornombre;
	}

	@Basic
	@Column(name = "COBRADORNUMERODOCUMENTO")
	public String getCobradornumerodocumento() {
		return this.cobradornumerodocumento;
	}

	@Basic
	@Column(name = "COBRADORTIPODOCUMENTO")
	public String getCobradortipodocumento() {
		return this.cobradortipodocumento;
	}

	@Basic
	@Column(name = "COMENTARIOFECHA")
	
	public Date getComentariofecha() {
		return this.comentariofecha;
	}

	@Basic
	@Column(name = "COMENTARIOSERVICIO")
	public String getComentarioservicio() {
		return this.comentarioservicio;
	}

	@Basic
	@Column(name = "COMENTARIOUSUARIO")
	public String getComentariousuario() {
		return this.comentariousuario;
	}

	@Basic
	@Column(name = "CUENTACONTABLEGASTO")
	public String getCuentacontablegasto() {
		return this.cuentacontablegasto;
	}

	@Basic
	@Column(name = "DETRACCIONCODIGO")
	public String getDetraccioncodigo() {
		return this.detraccioncodigo;
	}

	@Basic
	@Column(name = "DETRACCIONCODIGOFLAG")
	public String getDetraccioncodigoflag() {
		return this.detraccioncodigoflag;
	}

	@Basic
	@Column(name = "DETRACCIONCUENTABANCARIA")
	public String getDetraccioncuentabancaria() {
		return this.detraccioncuentabancaria;
	}

	@Basic
	@Column(name = "EXONERADODECLARACION")
	public String getExoneradodeclaracion() {
		return this.exoneradodeclaracion;
	}

	@Basic
	@Column(name = "EXONERADOFECHAFINAL")
	
	public Date getExoneradofechafinal() {
		return this.exoneradofechafinal;
	}

	@Basic
	@Column(name = "EXONERADOFECHAINICIO")
	
	public Date getExoneradofechainicio() {
		return this.exoneradofechainicio;
	}

	@Basic
	@Column(name = "EXONERADOMEDIOPRESENTACION")
	public String getExoneradomediopresentacion() {
		return this.exoneradomediopresentacion;
	}

	@Basic
	@Column(name = "EXPERIENCIATIEMPO")
	public String getExperienciatiempo() {
		return this.experienciatiempo;
	}

	@Basic
	@Column(name = "FECHAAUTORIZACIONFISCAL")
	
	public Date getFechaautorizacionfiscal() {
		return this.fechaautorizacionfiscal;
	}

	@Basic
	@Column(name = "FECHACONSTITUCION")
	
	public Date getFechaconstitucion() {
		return this.fechaconstitucion;
	}

	@Basic
	@Column(name = "FORMADEPAGO")
	public String getFormadepago() {
		return this.formadepago;
	}

	@Basic
	@Column(name = "INTERVENCIONFISCALCOMENTARIO")
	public String getIntervencionfiscalcomentario() {
		return this.intervencionfiscalcomentario;
	}

	@Basic
	@Column(name = "INTERVENCIONFISCALDOCUMENTO")
	public String getIntervencionfiscaldocumento() {
		return this.intervencionfiscaldocumento;
	}

	@Basic
	@Column(name = "INTERVENCIONFISCALFECHA")
	
	public Date getIntervencionfiscalfecha() {
		return this.intervencionfiscalfecha;
	}

	@Basic
	@Column(name = "INTERVENCIONFISCALFLAG")
	public String getIntervencionfiscalflag() {
		return this.intervencionfiscalflag;
	}

	@Basic
	@Column(name = "LICENCIAMUNICIPAL")
	public String getLicenciamunicipal() {
		return this.licenciamunicipal;
	}

	@Basic
	@Column(name = "MONEDAPAGO")
	public String getMonedapago() {
		return this.monedapago;
	}

	@Basic
	@Column(name = "NUMERODIASENTREGA")
	public Integer getNumerodiasentrega() {
		return this.numerodiasentrega;
	}

	@Basic
	@Column(name = "NUMERODIASPAGO")
	public Integer getNumerodiaspago() {
		return this.numerodiaspago;
	}

	@Basic
	@Column(name = "PAGARANOMBRE")
	public String getPagaranombre() {
		return this.pagaranombre;
	}

	@Basic
	@Column(name = "PAGARENDIRECCION")
	public String getPagarendireccion() {
		return this.pagarendireccion;
	}

	@Basic
	@Column(name = "PERSONACONTACTO")
	public String getPersonacontacto() {
		return this.personacontacto;
	}

	@Id
	@Column(name = "PROVEEDOR")
	public Integer getProveedor() {
		return this.proveedor;
	}

	@Basic
	@Column(name = "PROVEEDORRELACIONADO")
	public Integer getProveedorrelacionado() {
		return this.proveedorrelacionado;
	}

	@Basic
	@Column(name = "REGISTROPUBLICO")
	public String getRegistropublico() {
		return this.registropublico;
	}

	@Basic
	@Column(name = "REPRESENTANTELEGAL")
	public String getRepresentantelegal() {
		return this.representantelegal;
	}

	@Basic
	@Column(name = "RESPONSIBLE")
	public String getResponsible() {
		return this.responsible;
	}

	@Basic
	@Column(name = "RETENERPAGOSFLAG")
	public String getRetenerpagosflag() {
		return this.retenerpagosflag;
	}

	@OneToOne
	@JoinColumn(name = "PROVEEDOR", referencedColumnName = "PERSONA", insertable = false, updatable = false, nullable = true)
	public Personamast getSaPersona() {
		return saPersona;
	}

	@Basic
	@Column(name = "SUSPENSIONFONAVIFLAG")
	public String getSuspensionfonaviflag() {
		return this.suspensionfonaviflag;
	}

	@Basic
	@Column(name = "SUSPENSIONRENTAFLAG")
	public String getSuspensionrentaflag() {
		return this.suspensionrentaflag;
	}

	@Basic
	@Column(name = "TIPODOCUMENTODEFAULT")
	public String getTipodocumentodefault() {
		return this.tipodocumentodefault;
	}

	@Basic
	@Column(name = "TIPOPAGO")
	public String getTipopago() {
		return this.tipopago;
	}

	@Basic
	@Column(name = "TIPOPROVEEDOR")
	public String getTipoproveedor() {
		return this.tipoproveedor;
	}

	@Basic
	@Column(name = "TIPOSERVICIO")
	public String getTiposervicio() {
		return this.tiposervicio;
	}

	@Basic
	@Column(name = "GIRO")
	public String getGiro() {
		return giro;
	}

	// -----------------------------------------------------
	public void setChequenonegociableflag(String chequenonegociableflag) {
		this.chequenonegociableflag = chequenonegociableflag;
	}

	public void setClasificacionfiscal(String clasificacionfiscal) {
		this.clasificacionfiscal = clasificacionfiscal;
	}

	public void setCobradornombre(String cobradornombre) {
		this.cobradornombre = cobradornombre;
	}

	public void setCobradornumerodocumento(String cobradornumerodocumento) {
		this.cobradornumerodocumento = cobradornumerodocumento;
	}

	public void setCobradortipodocumento(String cobradortipodocumento) {
		this.cobradortipodocumento = cobradortipodocumento;
	}

	public void setComentariofecha(Date comentariofecha) {
		this.comentariofecha = comentariofecha;
	}

	public void setComentarioservicio(String comentarioservicio) {
		this.comentarioservicio = comentarioservicio;
	}

	public void setComentariousuario(String comentariousuario) {
		this.comentariousuario = comentariousuario;
	}

	public void setCuentacontablegasto(String cuentacontablegasto) {
		this.cuentacontablegasto = cuentacontablegasto;
	}

	public void setDetraccioncodigo(String detraccioncodigo) {
		this.detraccioncodigo = detraccioncodigo;
	}

	public void setDetraccioncodigoflag(String detraccioncodigoflag) {
		this.detraccioncodigoflag = detraccioncodigoflag;
	}

	public void setDetraccioncuentabancaria(String detraccioncuentabancaria) {
		this.detraccioncuentabancaria = detraccioncuentabancaria;
	}

	public void setExoneradodeclaracion(String exoneradodeclaracion) {
		this.exoneradodeclaracion = exoneradodeclaracion;
	}

	public void setExoneradofechafinal(Date exoneradofechafinal) {
		this.exoneradofechafinal = exoneradofechafinal;
	}

	public void setExoneradofechainicio(Date exoneradofechainicio) {
		this.exoneradofechainicio = exoneradofechainicio;
	}

	public void setExoneradomediopresentacion(String exoneradomediopresentacion) {
		this.exoneradomediopresentacion = exoneradomediopresentacion;
	}

	public void setExperienciatiempo(String experienciatiempo) {
		this.experienciatiempo = experienciatiempo;
	}

	public void setFechaautorizacionfiscal(Date fechaautorizacionfiscal) {
		this.fechaautorizacionfiscal = fechaautorizacionfiscal;
	}

	public void setFechaconstitucion(Date fechaconstitucion) {
		this.fechaconstitucion = fechaconstitucion;
	}

	public void setFormadepago(String formadepago) {
		this.formadepago = formadepago;
	}

	public void setIntervencionfiscalcomentario(String intervencionfiscalcomentario) {
		this.intervencionfiscalcomentario = intervencionfiscalcomentario;
	}

	public void setIntervencionfiscaldocumento(String intervencionfiscaldocumento) {
		this.intervencionfiscaldocumento = intervencionfiscaldocumento;
	}

	public void setIntervencionfiscalfecha(Date intervencionfiscalfecha) {
		this.intervencionfiscalfecha = intervencionfiscalfecha;
	}

	public void setIntervencionfiscalflag(String intervencionfiscalflag) {
		this.intervencionfiscalflag = intervencionfiscalflag;
	}

	public void setLicenciamunicipal(String licenciamunicipal) {
		this.licenciamunicipal = licenciamunicipal;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}

	public void setNumerodiasentrega(Integer numerodiasentrega) {
		this.numerodiasentrega = numerodiasentrega;
	}

	public void setNumerodiaspago(Integer numerodiaspago) {
		this.numerodiaspago = numerodiaspago;
	}

	public void setPagaranombre(String pagaranombre) {
		this.pagaranombre = pagaranombre;
	}

	public void setPagarendireccion(String pagarendireccion) {
		this.pagarendireccion = pagarendireccion;
	}

	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

	public void setProveedorrelacionado(Integer proveedorrelacionado) {
		this.proveedorrelacionado = proveedorrelacionado;
	}

	public void setRegistropublico(String registropublico) {
		this.registropublico = registropublico;
	}

	public void setRepresentantelegal(String representantelegal) {
		this.representantelegal = representantelegal;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public void setRetenerpagosflag(String retenerpagosflag) {
		this.retenerpagosflag = retenerpagosflag;
	}

	public void setSaPersona(Personamast saPersona) {
		this.saPersona = saPersona;
	}

	public void setSuspensionfonaviflag(String suspensionfonaviflag) {
		this.suspensionfonaviflag = suspensionfonaviflag;
	}

	public void setSuspensionrentaflag(String suspensionrentaflag) {
		this.suspensionrentaflag = suspensionrentaflag;
	}

	public void setTipodocumentodefault(String tipodocumentodefault) {
		this.tipodocumentodefault = tipodocumentodefault;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public void setTipoproveedor(String tipoproveedor) {
		this.tipoproveedor = tipoproveedor;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public void setMaplatitud(String maplatitud) {
		this.maplatitud = maplatitud;
	}

	public void setMaplongitud(String maplongitud) {
		this.maplongitud = maplongitud;
	}

}