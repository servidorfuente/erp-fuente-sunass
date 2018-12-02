package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.math.BigDecimal;


/**
 * The persistent class for the VW_CONFIGURACION_PAGO database table.
 * 
 */
@Entity
@Table(name="VW_CONFIGURACION_PAGO")
public class VwConfiguracionPago extends Entidad {
	private static final long serialVersionUID = 1L;
	private BigDecimal costosporcentaje;
	private Integer crrcarreraid;
	private String crrdescripcion;
	private Integer crrflagmodular;
	private Integer curcursoid;
	private String curnombrecorto;
	private String docentenombrecompleto;
	private Integer docenteprincipal;
	private Integer estado;
	private String estadodesc;
	private Integer moemestudioid;
	private BigDecimal pagosporcentaje;
	private String periodoproceso;
	private String periodoprocesopagoDesc;
	private Integer secuenciaconfig;
	private String tipoconfigpago;
	private String tipoconfigpagoDesc;
	private String tipoconfigperiodo;
	private String tipoconfigperiodoDesc;
	private String tipoconfigtiempo;
	private Integer uneunegocioid;

	public VwConfiguracionPago() {
	}

	@Id
	public Integer getSecuenciaconfig() {
		return this.secuenciaconfig;
	}

	public void setSecuenciaconfig(Integer secuenciaconfig) {
		this.secuenciaconfig = secuenciaconfig;
	}

	public BigDecimal getCostosporcentaje() {
		return this.costosporcentaje;
	}

	public void setCostosporcentaje(BigDecimal costosporcentaje) {
		this.costosporcentaje = costosporcentaje;
	}


	public Integer getCrrcarreraid() {
		return this.crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}


	public String getCrrdescripcion() {
		return this.crrdescripcion;
	}

	public void setCrrdescripcion(String crrdescripcion) {
		this.crrdescripcion = crrdescripcion;
	}


	public Integer getCrrflagmodular() {
		return this.crrflagmodular;
	}

	public void setCrrflagmodular(Integer crrflagmodular) {
		this.crrflagmodular = crrflagmodular;
	}


	public Integer getCurcursoid() {
		return this.curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}


	public String getCurnombrecorto() {
		return this.curnombrecorto;
	}

	public void setCurnombrecorto(String curnombrecorto) {
		this.curnombrecorto = curnombrecorto;
	}


	public String getDocentenombrecompleto() {
		return this.docentenombrecompleto;
	}

	public void setDocentenombrecompleto(String docentenombrecompleto) {
		this.docentenombrecompleto = docentenombrecompleto;
	}


	public Integer getDocenteprincipal() {
		return this.docenteprincipal;
	}

	public void setDocenteprincipal(Integer docenteprincipal) {
		this.docenteprincipal = docenteprincipal;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String getEstadodesc() {
		return this.estadodesc;
	}

	public void setEstadodesc(String estadodesc) {
		this.estadodesc = estadodesc;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public BigDecimal getPagosporcentaje() {
		return this.pagosporcentaje;
	}

	public void setPagosporcentaje(BigDecimal pagosporcentaje) {
		this.pagosporcentaje = pagosporcentaje;
	}


	public String getPeriodoproceso() {
		return this.periodoproceso;
	}

	public void setPeriodoproceso(String periodoproceso) {
		this.periodoproceso = periodoproceso;
	}


	@Column(name="PERIODOPROCESOPAGO_DESC")
	public String getPeriodoprocesopagoDesc() {
		return this.periodoprocesopagoDesc;
	}

	public void setPeriodoprocesopagoDesc(String periodoprocesopagoDesc) {
		this.periodoprocesopagoDesc = periodoprocesopagoDesc;
	}




	public String getTipoconfigpago() {
		return this.tipoconfigpago;
	}

	public void setTipoconfigpago(String tipoconfigpago) {
		this.tipoconfigpago = tipoconfigpago;
	}


	@Column(name="TIPOCONFIGPAGO_DESC")
	public String getTipoconfigpagoDesc() {
		return this.tipoconfigpagoDesc;
	}

	public void setTipoconfigpagoDesc(String tipoconfigpagoDesc) {
		this.tipoconfigpagoDesc = tipoconfigpagoDesc;
	}


	public String getTipoconfigperiodo() {
		return this.tipoconfigperiodo;
	}

	public void setTipoconfigperiodo(String tipoconfigperiodo) {
		this.tipoconfigperiodo = tipoconfigperiodo;
	}


	@Column(name="TIPOCONFIGPERIODO_DESC")
	public String getTipoconfigperiodoDesc() {
		return this.tipoconfigperiodoDesc;
	}

	public void setTipoconfigperiodoDesc(String tipoconfigperiodoDesc) {
		this.tipoconfigperiodoDesc = tipoconfigperiodoDesc;
	}


	public String getTipoconfigtiempo() {
		return this.tipoconfigtiempo;
	}

	public void setTipoconfigtiempo(String tipoconfigtiempo) {
		this.tipoconfigtiempo = tipoconfigtiempo;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

}