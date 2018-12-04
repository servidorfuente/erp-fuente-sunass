package erp.realcoresystems.pe.model.domain;

import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SA_PEDIDOOBLIGACION database table.
 * 
 */
@Entity
@Table(name="SA_PEDIDOOBLIGACION")
public class SaPedidoObligacion extends Entidad{
	private static final long serialVersionUID = 1L;
	private Integer pedpedidoid;
	private Integer alualumnoid;
	private Integer moemestudioid;
	private String peobcomentario;
	private Integer peobestado;
	private Date peobfechacreacion;
	private String peobipcreacion;
	private Date peobultimafechamodif;
	private String peobultimoip;
	private Integer peobultimousuario;
	private Integer peobusuariocreacion;
	private Integer perperiodoid;
	private Integer persona;
	private Integer pospostulanteid;
	private Integer uneunegocioid;
	
	private Integer pedpedidoidorigen;
	private Integer secseccionid;
	private Integer clocurriculoid;
	
	private String tipomoneda;
	private BigDecimal montototallocal;
	private BigDecimal montototalext;
	private BigDecimal montopagadolocal;
	private BigDecimal montopagadoext;
	private BigDecimal tipocambio;

	private Integer crrcarreraid;
	private Integer curcursoid;
	private String peobTipoConfigAcad;
	private String peobtipodocumento;
	private String peobtipopago;
	private Integer peobpersonaautoriza;
	
	
	private BigDecimal precioDscto01;
	private BigDecimal precioBaseBruto;
	private String descuento01Desc;	
	
	public SaPedidoObligacion() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public Integer getPedpedidoid() {
		return this.pedpedidoid;
	}

	public void setPedpedidoid(Integer pedpedidoid) {
		this.pedpedidoid = pedpedidoid;
	}


	public Integer getAlualumnoid() {
		return this.alualumnoid;
	}

	public void setAlualumnoid(Integer alualumnoid) {
		this.alualumnoid = alualumnoid;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	@Column(length=250)
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


	@Temporal(TemporalType.TIMESTAMP)
	public Date getPeobfechacreacion() {
		return this.peobfechacreacion;
	}

	public void setPeobfechacreacion(Date peobfechacreacion) {
		this.peobfechacreacion = peobfechacreacion;
	}


	@Column(length=100)
	public String getPeobipcreacion() {
		return this.peobipcreacion;
	}

	public void setPeobipcreacion(String peobipcreacion) {
		this.peobipcreacion = peobipcreacion;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getPeobultimafechamodif() {
		return this.peobultimafechamodif;
	}

	public void setPeobultimafechamodif(Date peobultimafechamodif) {
		this.peobultimafechamodif = peobultimafechamodif;
	}


	@Column(length=100)
	public String getPeobultimoip() {
		return this.peobultimoip;
	}

	public void setPeobultimoip(String peobultimoip) {
		this.peobultimoip = peobultimoip;
	}


	public Integer getPeobultimousuario() {
		return this.peobultimousuario;
	}

	public void setPeobultimousuario(Integer peobultimousuario) {
		this.peobultimousuario = peobultimousuario;
	}


	public Integer getPeobusuariocreacion() {
		return this.peobusuariocreacion;
	}

	public void setPeobusuariocreacion(Integer peobusuariocreacion) {
		this.peobusuariocreacion = peobusuariocreacion;
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


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Column(name = "PEDPEDIDOIDORIGEN")
	public Integer getPedpedidoidorigen() {
		return pedpedidoidorigen;
	}


	public void setPedpedidoidorigen(Integer pedpedidoidorigen) {
		this.pedpedidoidorigen = pedpedidoidorigen;
	}

	@Column(name = "SECSECCIONID")
	public Integer getSecseccionid() {
		return secseccionid;
	}


	public void setSecseccionid(Integer secseccionid) {
		this.secseccionid = secseccionid;
	}

	@Column(name = "CLOCURRICULOID")
	public Integer getClocurriculoid() {
		return clocurriculoid;
	}


	public void setClocurriculoid(Integer clocurriculoid) {
		this.clocurriculoid = clocurriculoid;
	}

	@Column(name = "TIPOMONEDA")
	public String getTipomoneda() {
		return tipomoneda;
	}


	public void setTipomoneda(String tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	@Column(name = "MONTOTOTALLOCAL")
	public BigDecimal getMontototallocal() {
		return montototallocal;
	}


	public void setMontototallocal(BigDecimal montototallocal) {
		this.montototallocal = montototallocal;
	}

	@Column(name = "MONTOTOTALEXT")
	public BigDecimal getMontototalext() {
		return montototalext;
	}


	public void setMontototalext(BigDecimal montototalext) {
		this.montototalext = montototalext;
	}
	

	
	
	

	@Column(name = "MONTOPAGADOLOCAL")
	public BigDecimal getMontopagadolocal() {
		return montopagadolocal;
	}

	
	public void setMontopagadolocal(BigDecimal montopagadolocal) {
		this.montopagadolocal = montopagadolocal;
	}

	@Column(name = "MONTOPAGADOEXT")
	public BigDecimal getMontopagadoext() {
		return montopagadoext;
	}


	public void setMontopagadoext(BigDecimal montopagadoext) {
		this.montopagadoext = montopagadoext;
	}

	@Column(name = "TIPOCAMBIO")
	public BigDecimal getTipocambio() {
		return tipocambio;
	}


	public void setTipocambio(BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}

	
	

	@Column(name = "CRRCARRERAID")
	public Integer getCrrcarreraid() {
		return crrcarreraid;
	}


	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}

	@Column(name = "CURCURSOID")
	public Integer getCurcursoid() {
		return curcursoid;
	}


	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	@Column(name = "PEOB_TIPO_CONFIG_ACAD")
	public String getPeobTipoConfigAcad() {
		return peobTipoConfigAcad;
	}


	public void setPeobTipoConfigAcad(String peobTipoConfigAcad) {
		this.peobTipoConfigAcad = peobTipoConfigAcad;
	}

	
	
	
	
	@Column(name = "PEOBTIPODOCUMENTO")
	public String getPeobtipodocumento() {
		return peobtipodocumento;
	}


	public void setPeobtipodocumento(String peobtipodocumento) {
		this.peobtipodocumento = peobtipodocumento;
	}

	
	
	@Column(name = "PEOBTIPOPAGO")
	public String getPeobtipopago() {
		return peobtipopago;
	}


	public void setPeobtipopago(String peobtipopago) {
		this.peobtipopago = peobtipopago;
	}

	
	
	@Column(name = "PEOBPERSONAAUTORIZA")
	public Integer getPeobpersonaautoriza() {
		return peobpersonaautoriza;
	}


	public void setPeobpersonaautoriza(Integer peobpersonaautoriza) {
		this.peobpersonaautoriza = peobpersonaautoriza;
	}

	@Transient
	public BigDecimal getPrecioDscto01() {
		return precioDscto01;
	}


	public void setPrecioDscto01(BigDecimal precioDscto01) {
		this.precioDscto01 = precioDscto01;
	}


	@Transient
	public String getDescuento01Desc() {
		return descuento01Desc;
	}


	public void setDescuento01Desc(String descuento01Desc) {
		this.descuento01Desc = descuento01Desc;
	}

	@Transient
	public BigDecimal getPrecioBaseBruto() {
		return precioBaseBruto;
	}


	public void setPrecioBaseBruto(BigDecimal precioBaseBruto) {
		this.precioBaseBruto = precioBaseBruto;
	}

	
	
}