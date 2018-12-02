package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VW_CONTRATO_ALUMNO database table.
 * 
 */
@Entity
@Table(name="VW_CONTRATO_ALUMNO")
public class VwContratoAlumno extends Entidad {
	private static final long serialVersionUID = 1L;
	
	private Integer conacontratoAlumnoId;
	
	private Integer admadmisionid;
	private Integer alualumnoid;
	private Integer becbecaid;
	private Integer becrRegbecaconvid;
	private Integer clocurriculoid;
	private String conacodigo;
	private String conacomentario;
	private String conacondicionCodigo;
	
	private Integer conaestado;
	private Date conafechaFin;
	private Date conafechaInicio;
	private Date conafechaRegistro;
	private Integer conconvenioid;
	private Integer crrcarreraid;
	private String crrdescripcion;
	private Integer crrflagmodular;
	private Integer curcursoid;
	private String curnombrecorto;
	private String documento;
	private Date fechanacimiento;
	private Integer ghorGrupohorarioid;
	private Integer moemestudioid;
	private BigDecimal montopagadoext;
	private BigDecimal montopagadolocal;
	private BigDecimal montototalext;
	private BigDecimal montototallocal;
	private String nombrecompleto;
	private Integer pedpedidoid;
	private Integer peobestado;
	private Integer perperiodoid;
	private String sexo;
	private BigDecimal tipocambio;
	private String tipodocumento;
	private String tipomoneda;
	private Integer uneunegocioid;
	
	private Integer persona;
	
	private String clodescripcion;
	private Integer cloestado;
	private Integer clocreditosobligatorios;
	private Integer clotienecreditos;

	private Integer aluestado;
	private String alucodigo;
	
	private String perperiodo;
	
	private String agrupadorcurso;
	private String agrupcursodesc;
	
		
	
	public VwContratoAlumno() {
	}


	public Integer getAdmadmisionid() {
		return this.admadmisionid;
	}

	public void setAdmadmisionid(Integer admadmisionid) {
		this.admadmisionid = admadmisionid;
	}


	public Integer getAlualumnoid() {
		return this.alualumnoid;
	}

	public void setAlualumnoid(Integer alualumnoid) {
		this.alualumnoid = alualumnoid;
	}


	public Integer getBecbecaid() {
		return this.becbecaid;
	}

	public void setBecbecaid(Integer becbecaid) {
		this.becbecaid = becbecaid;
	}


	@Column(name="BECR_REGBECACONVID")
	public Integer getBecrRegbecaconvid() {
		return this.becrRegbecaconvid;
	}

	public void setBecrRegbecaconvid(Integer becrRegbecaconvid) {
		this.becrRegbecaconvid = becrRegbecaconvid;
	}


	public Integer getClocurriculoid() {
		return this.clocurriculoid;
	}

	public void setClocurriculoid(Integer clocurriculoid) {
		this.clocurriculoid = clocurriculoid;
	}


	public String getConacodigo() {
		return this.conacodigo;
	}

	public void setConacodigo(String conacodigo) {
		this.conacodigo = conacodigo;
	}


	public String getConacomentario() {
		return this.conacomentario;
	}

	public void setConacomentario(String conacomentario) {
		this.conacomentario = conacomentario;
	}


	@Column(name="CONACONDICION_CODIGO")
	public String getConacondicionCodigo() {
		return this.conacondicionCodigo;
	}

	public void setConacondicionCodigo(String conacondicionCodigo) {
		this.conacondicionCodigo = conacondicionCodigo;
	}


	@Id
	@Column(name="CONACONTRATO_ALUMNO_ID")
	public Integer getConacontratoAlumnoId() {
		return this.conacontratoAlumnoId;
	}

	public void setConacontratoAlumnoId(Integer conacontratoAlumnoId) {
		this.conacontratoAlumnoId = conacontratoAlumnoId;
	}


	public Integer getConaestado() {
		return this.conaestado;
	}

	public void setConaestado(Integer conaestado) {
		this.conaestado = conaestado;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CONAFECHA_FIN")
	public Date getConafechaFin() {
		return this.conafechaFin;
	}

	public void setConafechaFin(Date conafechaFin) {
		this.conafechaFin = conafechaFin;
	}


	
	@Column(name="CONAFECHA_INICIO")
	public Date getConafechaInicio() {
		return this.conafechaInicio;
	}

	public void setConafechaInicio(Date conafechaInicio) {
		this.conafechaInicio = conafechaInicio;
	}


	
	@Column(name="CONAFECHA_REGISTRO")
	public Date getConafechaRegistro() {
		return this.conafechaRegistro;
	}

	public void setConafechaRegistro(Date conafechaRegistro) {
		this.conafechaRegistro = conafechaRegistro;
	}


	public Integer getConconvenioid() {
		return this.conconvenioid;
	}

	public void setConconvenioid(Integer conconvenioid) {
		this.conconvenioid = conconvenioid;
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


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	@Column(name="GHOR_GRUPOHORARIOID")
	public Integer getGhorGrupohorarioid() {
		return this.ghorGrupohorarioid;
	}

	public void setGhorGrupohorarioid(Integer ghorGrupohorarioid) {
		this.ghorGrupohorarioid = ghorGrupohorarioid;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public BigDecimal getMontopagadoext() {
		return this.montopagadoext;
	}

	public void setMontopagadoext(BigDecimal montopagadoext) {
		this.montopagadoext = montopagadoext;
	}


	public BigDecimal getMontopagadolocal() {
		return this.montopagadolocal;
	}

	public void setMontopagadolocal(BigDecimal montopagadolocal) {
		this.montopagadolocal = montopagadolocal;
	}


	public BigDecimal getMontototalext() {
		return this.montototalext;
	}

	public void setMontototalext(BigDecimal montototalext) {
		this.montototalext = montototalext;
	}


	public BigDecimal getMontototallocal() {
		return this.montototallocal;
	}

	public void setMontototallocal(BigDecimal montototallocal) {
		this.montototallocal = montototallocal;
	}


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public Integer getPedpedidoid() {
		return this.pedpedidoid;
	}

	public void setPedpedidoid(Integer pedpedidoid) {
		this.pedpedidoid = pedpedidoid;
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


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public BigDecimal getTipocambio() {
		return this.tipocambio;
	}

	public void setTipocambio(BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}


	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
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

	
	@Column(name="PERSONA")
	public Integer getPersona() {
		return persona;
	}


	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	@Column(name="CLODESCRIPCION")
	public String getClodescripcion() {
		return clodescripcion;
	}


	public void setClodescripcion(String clodescripcion) {
		this.clodescripcion = clodescripcion;
	}

	
	@Column(name="CLOESTADO")
	public Integer getCloestado() {
		return cloestado;
	}


	public void setCloestado(Integer cloestado) {
		this.cloestado = cloestado;
	}

	@Column(name="CLOCREDITOSOBLIGATORIOS")
	public Integer getClocreditosobligatorios() {
		return clocreditosobligatorios;
	}


	public void setClocreditosobligatorios(Integer clocreditosobligatorios) {
		this.clocreditosobligatorios = clocreditosobligatorios;
	}
	
	@Column(name="CLOTIENECREDITOS")
	public Integer getClotienecreditos() {
		return clotienecreditos;
	}


	public void setClotienecreditos(Integer clotienecreditos) {
		this.clotienecreditos = clotienecreditos;
	}


	@Column(name="ALUESTADO")
	public Integer getAluestado() {
		return aluestado;
	}


	public void setAluestado(Integer aluestado) {
		this.aluestado = aluestado;
	}
	
	@Column(name="ALUCODIGO")
	public String getAlucodigo() {
		return alucodigo;
	}


	public void setAlucodigo(String alucodigo) {
		this.alucodigo = alucodigo;
	}

	
	@Column(name="PERPERIODO")
	public String getPerperiodo() {
		return perperiodo;
	}


	public void setPerperiodo(String perperiodo) {
		this.perperiodo = perperiodo;
	}


	@Column(name="AGRUPADORCURSO")
	public String getAgrupadorcurso() {
		return agrupadorcurso;
	}


	public void setAgrupadorcurso(String agrupadorcurso) {
		this.agrupadorcurso = agrupadorcurso;
	}

	@Column(name="AGRUPCURSODESC")
	public String getAgrupcursodesc() {
		return agrupcursodesc;
	}


	public void setAgrupcursodesc(String agrupcursodesc) {
		this.agrupcursodesc = agrupcursodesc;
	}

}