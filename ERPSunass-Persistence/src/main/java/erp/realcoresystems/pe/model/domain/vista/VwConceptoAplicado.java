package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import erp.realcoresystems.pe.model.domain.Entidad;


/**
 * The persistent class for the VW_CONCEPTO_APLICADO database table.
 * 
 */
@Entity
@Table(name="VW_CONCEPTO_APLICADO")
public class VwConceptoAplicado extends Entidad {
	private static final long serialVersionUID = 1L;

	private Integer alualumnoid;
	
    private Integer oblobligacionid;

	private Integer clocurriculoid;

	private Integer crrcarreraid;

	private Integer curcursoid;

	@Id
	private Integer indice;

	private String itemdescripcion;

	private Integer moemestudioid;

	private String monedadocumento;

	private Integer montopagadoext;

	private Integer montopagadolocal;

	private Integer montototalext;

	private Integer montototallocal;

	private Integer oblcantidad;

	private Integer obldescuento;

	private Integer oblestado;
	
	private Date oblfechaemision;
	
	private Date oblfechavencimiento;

	private Integer oblmonto;

	private Integer oblmontodescontar;

	private Integer oblmontosindscto;

	private Integer oblmora;

	private Integer oblpagoxbancoflag;

	@Column(name="PACONC_CODIGO_SERVICIO_COM")
	private String paconcCodigoServicioCom;

	private Integer pedpedidoid;

	private String peobcomentario;

	private Integer peobestado;

	private Integer perperiodoid;

	private Integer persona;

	private Integer pospostulanteid;

	private Integer secseccionid;

	private Integer tipocambio;

	private String tipomoneda;

	private Integer uneunegocioid;

	@Column(name="PACONC_DESCRIPCIONLOCAL")
	private String paconcDescripcionlocal;
	
	@Column(name="PERSONA_TIPODOCUMENTO")
	private Integer personaTipodocumento;
	
	@Column(name="PERSONA_DOCUMENTO")
	private String personaDocumento;
	
	@Column(name="PERSONA_NOMBRECOMPLETO")
	private String personaNombrecompleto;
	
	private String crrdescripcion;
	private String curnombrecorto;
	private String peobtipodocumento;
	private String peobtipopago;		
	private String perperiodo;
	private Integer paconcpagoconceptoid;
	private String tipodocumento;
	
	@Transient
	private Double montoDevuelto;
	
	
	
	public VwConceptoAplicado() {
	}

	public Integer getAlualumnoid() {
		return this.alualumnoid;
	}

	public void setAlualumnoid(Integer alualumnoid) {
		this.alualumnoid = alualumnoid;
	}

	public Integer getClocurriculoid() {
		return this.clocurriculoid;
	}

	public void setClocurriculoid(Integer clocurriculoid) {
		this.clocurriculoid = clocurriculoid;
	}

	public Integer getCrrcarreraid() {
		return this.crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}

	public Integer getCurcursoid() {
		return this.curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	public Integer getIndice() {
		return this.indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getItemdescripcion() {
		return this.itemdescripcion;
	}

	public void setItemdescripcion(String itemdescripcion) {
		this.itemdescripcion = itemdescripcion;
	}

	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	public String getMonedadocumento() {
		return this.monedadocumento;
	}
	
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setMonedadocumento(String monedadocumento) {
		this.monedadocumento = monedadocumento;
	}

	public Integer getMontopagadoext() {
		return this.montopagadoext;
	}

	public void setMontopagadoext(Integer montopagadoext) {
		this.montopagadoext = montopagadoext;
	}

	public Integer getMontopagadolocal() {
		return this.montopagadolocal;
	}

	public void setMontopagadolocal(Integer montopagadolocal) {
		this.montopagadolocal = montopagadolocal;
	}

	public Integer getMontototalext() {
		return this.montototalext;
	}

	public void setMontototalext(Integer montototalext) {
		this.montototalext = montototalext;
	}

	public Integer getMontototallocal() {
		return this.montototallocal;
	}

	public void setMontototallocal(Integer montototallocal) {
		this.montototallocal = montototallocal;
	}

	public Integer getOblcantidad() {
		return this.oblcantidad;
	}

	public void setOblcantidad(Integer oblcantidad) {
		this.oblcantidad = oblcantidad;
	}

	public Integer getObldescuento() {
		return this.obldescuento;
	}

	public void setObldescuento(Integer obldescuento) {
		this.obldescuento = obldescuento;
	}

	public Integer getOblestado() {
		return this.oblestado;
	}

	public void setOblestado(Integer oblestado) {
		this.oblestado = oblestado;
	}

	public Date getOblfechaemision() {
		return this.oblfechaemision;
	}

	public void setOblfechaemision(Date oblfechaemision) {
		this.oblfechaemision = oblfechaemision;
	}

	public Date getOblfechavencimiento() {
		return this.oblfechavencimiento;
	}

	public void setOblfechavencimiento(Date oblfechavencimiento) {
		this.oblfechavencimiento = oblfechavencimiento;
	}

	public Integer getOblmonto() {
		return this.oblmonto;
	}

	public void setOblmonto(Integer oblmonto) {
		this.oblmonto = oblmonto;
	}

	public Integer getOblmontodescontar() {
		return this.oblmontodescontar;
	}

	public void setOblmontodescontar(Integer oblmontodescontar) {
		this.oblmontodescontar = oblmontodescontar;
	}

	public Integer getOblmontosindscto() {
		return this.oblmontosindscto;
	}

	public void setOblmontosindscto(Integer oblmontosindscto) {
		this.oblmontosindscto = oblmontosindscto;
	}

	public Integer getOblmora() {
		return this.oblmora;
	}

	public void setOblmora(Integer oblmora) {
		this.oblmora = oblmora;
	}

	public Integer getOblpagoxbancoflag() {
		return this.oblpagoxbancoflag;
	}

	public void setOblpagoxbancoflag(Integer oblpagoxbancoflag) {
		this.oblpagoxbancoflag = oblpagoxbancoflag;
	}

	public String getPaconcCodigoServicioCom() {
		return this.paconcCodigoServicioCom;
	}

	public void setPaconcCodigoServicioCom(String paconcCodigoServicioCom) {
		this.paconcCodigoServicioCom = paconcCodigoServicioCom;
	}

	public Integer getPedpedidoid() {
		return this.pedpedidoid;
	}

	public void setPedpedidoid(Integer pedpedidoid) {
		this.pedpedidoid = pedpedidoid;
	}

	public String getPeobcomentario() {
		return this.peobcomentario;
	}

	public void setPeobcomentario(String peobcomentario) {
		this.peobcomentario = peobcomentario;
	}

	public Integer getPeobestado() {
		return this.peobestado;
	}

	public void setPeobestado(Integer peobestado) {
		this.peobestado = peobestado;
	}

	public Integer getPerperiodoid() {
		return this.perperiodoid;
	}

	public void setPerperiodoid(Integer perperiodoid) {
		this.perperiodoid = perperiodoid;
	}

	public Integer getPersona() {
		return this.persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getPospostulanteid() {
		return this.pospostulanteid;
	}

	public void setPospostulanteid(Integer pospostulanteid) {
		this.pospostulanteid = pospostulanteid;
	}

	public Integer getSecseccionid() {
		return this.secseccionid;
	}

	public void setSecseccionid(Integer secseccionid) {
		this.secseccionid = secseccionid;
	}

	public Integer getTipocambio() {
		return this.tipocambio;
	}

	public void setTipocambio(Integer tipocambio) {
		this.tipocambio = tipocambio;
	}

	public String getTipomoneda() {
		return this.tipomoneda;
	}

	public void setTipomoneda(String tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	


	
	public String getPaconcDescripcionlocal() {
		return paconcDescripcionlocal;
	}

	public void setPaconcDescripcionlocal(String paconcDescripcionlocal) {
		this.paconcDescripcionlocal = paconcDescripcionlocal;
	}

	
	public Integer getPersonaTipodocumento() {
		return personaTipodocumento;
	}

	public void setPersonaTipodocumento(Integer personaTipodocumento) {
		this.personaTipodocumento = personaTipodocumento;
	}

	
	public String getPersonaDocumento() {
		return personaDocumento;
	}

	public void setPersonaDocumento(String personaDocumento) {
		this.personaDocumento = personaDocumento;
	}

	
	public String getPersonaNombrecompleto() {
		return personaNombrecompleto;
	}

	public void setPersonaNombrecompleto(String personaNombrecompleto) {
		this.personaNombrecompleto = personaNombrecompleto;
	}
	
	//@Column(name="CRRDESCRIPCION")
	public String getCrrdescripcion() {
		return crrdescripcion;
	}

	public void setCrrdescripcion(String crrdescripcion) {
		this.crrdescripcion = crrdescripcion;
	}
	//@Column(name="CURNOMBRECORTO")
	public String getCurnombrecorto() {
		return curnombrecorto;
	}

	public void setCurnombrecorto(String curnombrecorto) {
		this.curnombrecorto = curnombrecorto;
	}
	//@Column(name="PEOBTIPODOCUMENTO")
	public String getPeobtipodocumento() {
		return peobtipodocumento;
	}

	public void setPeobtipodocumento(String peobtipodocumento) {
		this.peobtipodocumento = peobtipodocumento;
	}

	//@Column(name="PEOBTIPOPAGO")
	public String getPeobtipopago() {
		return peobtipopago;
	}

	public void setPeobtipopago(String peobtipopago) {
		this.peobtipopago = peobtipopago;
	}
	
	//@Column(name="PERPERIODO")
	public String getPerperiodo() {
		return perperiodo;
	}

	public void setPerperiodo(String perperiodo) {
		this.perperiodo = perperiodo;
	}

	public Integer getPaconcpagoconceptoid() {
		return paconcpagoconceptoid;
	}

	public void setPaconcpagoconceptoid(Integer paconcpagoconceptoid) {
		this.paconcpagoconceptoid = paconcpagoconceptoid;
	}

	public Integer getOblobligacionid() {
		return oblobligacionid;
	}

	public void setOblobligacionid(Integer oblobligacionid) {
		this.oblobligacionid = oblobligacionid;
	}
	
	@Transient
	public Double getMontoDevuelto() {
		return montoDevuelto;
	}

	public void setMontoDevuelto(Double montoDevuelto) {
		this.montoDevuelto = montoDevuelto;
	}
	
	
}