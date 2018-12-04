package erp.realcoresystems.pe.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the SA_TITULOGRADO database table.
 * 
 */
@Entity
@Table(name="SA_TITULOGRADO")
public class SaTitulogrado extends Entidad {
	private static final long serialVersionUID = 1L;
	

	
	private Integer alualumnoid;

	private Integer clocurriculoid;

	private String codigocertificacion;

	private Integer creditosaprobados;

	private Integer crrcarreraid;

	private Integer curcursoid;

	private Integer horasaprobados;

	private Integer moemestudioid;

	private Integer perperiodoid;

	private Integer persona;

	private Integer tipomodaltituloid;

	private Integer tipoproducto;

	private Integer tipotituloid;

	private String titarearegistra;

	private String titasiento;

	private String titdenominacioncarrera;

	private String titdiplomanumero;

	private Integer titestadoalumno;

	private Integer titestadoentrega;

	private Date titfechacreacion;

	private Date titfechaentrega;

	private Date titfechainicio;

	private Date titfechatermino;

	private String titfolio;

	private String titinstitucionotorga;

	private String titipcreacion;

	private String titobsresolucion;

	private Integer titperiodoegreso;

	private String titresolcarrerafecha;

	private String titresolcarreranro;

	private String titresolucion;

	private Integer titresponsableaprueba;

	private Integer titresponsableemision;

	private String tittomo;

	private Date titultimafechamodif;

	private String titultimoip;

	private Integer titultimousuario;

	private Integer titusuariocreacion;

	@Id
	private Integer titutlogradoid;

	private Integer tratramiteid;

	private Integer uneunegocioid;
	
	private Integer ttordenmerito;
	
	private Double ttpuntaje;
	
	@Transient
	private String tipoTramite;
	
	@Transient
	private String unecodigomodular;
	
	
	@Transient
	public String getUnecodigomodular() {
		return unecodigomodular;
	}

	public void setUnecodigomodular(String unecodigomodular) {
		this.unecodigomodular = unecodigomodular;
	}

	@Transient
	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public SaTitulogrado() {
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

	public String getCodigocertificacion() {
		return this.codigocertificacion;
	}

	public void setCodigocertificacion(String codigocertificacion) {
		this.codigocertificacion = codigocertificacion;
	}

	public Integer getCreditosaprobados() {
		return this.creditosaprobados;
	}

	public void setCreditosaprobados(Integer creditosaprobados) {
		this.creditosaprobados = creditosaprobados;
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

	public Integer getHorasaprobados() {
		return this.horasaprobados;
	}

	public void setHorasaprobados(Integer horasaprobados) {
		this.horasaprobados = horasaprobados;
	}

	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
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

	public Integer getTipomodaltituloid() {
		return this.tipomodaltituloid;
	}

	public void setTipomodaltituloid(Integer tipomodaltituloid) {
		this.tipomodaltituloid = tipomodaltituloid;
	}

	public Integer getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipoproducto(Integer tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public Integer getTipotituloid() {
		return this.tipotituloid;
	}

	public void setTipotituloid(Integer tipotituloid) {
		this.tipotituloid = tipotituloid;
	}

	public String getTitarearegistra() {
		return this.titarearegistra;
	}

	public void setTitarearegistra(String titarearegistra) {
		this.titarearegistra = titarearegistra;
	}

	public String getTitasiento() {
		return this.titasiento;
	}

	public void setTitasiento(String titasiento) {
		this.titasiento = titasiento;
	}

	public String getTitdenominacioncarrera() {
		return this.titdenominacioncarrera;
	}

	public void setTitdenominacioncarrera(String titdenominacioncarrera) {
		this.titdenominacioncarrera = titdenominacioncarrera;
	}

	public String getTitdiplomanumero() {
		return this.titdiplomanumero;
	}

	public void setTitdiplomanumero(String titdiplomanumero) {
		this.titdiplomanumero = titdiplomanumero;
	}

	public Integer getTitestadoalumno() {
		return this.titestadoalumno;
	}

	public void setTitestadoalumno(Integer titestadoalumno) {
		this.titestadoalumno = titestadoalumno;
	}

	public Integer getTitestadoentrega() {
		return this.titestadoentrega;
	}

	public void setTitestadoentrega(Integer titestadoentrega) {
		this.titestadoentrega = titestadoentrega;
	}

	public Date getTitfechacreacion() {
		return this.titfechacreacion;
	}

	public void setTitfechacreacion(Date titfechacreacion) {
		this.titfechacreacion = titfechacreacion;
	}

	public Date getTitfechaentrega() {
		return this.titfechaentrega;
	}

	public void setTitfechaentrega(Date titfechaentrega) {
		this.titfechaentrega = titfechaentrega;
	}

	public Date getTitfechainicio() {
		return this.titfechainicio;
	}

	public void setTitfechainicio(Date titfechainicio) {
		this.titfechainicio = titfechainicio;
	}

	public Date getTitfechatermino() {
		return this.titfechatermino;
	}

	public void setTitfechatermino(Date titfechatermino) {
		this.titfechatermino = titfechatermino;
	}

	public String getTitfolio() {
		return this.titfolio;
	}

	public void setTitfolio(String titfolio) {
		this.titfolio = titfolio;
	}

	public String getTitinstitucionotorga() {
		return this.titinstitucionotorga;
	}

	public void setTitinstitucionotorga(String titinstitucionotorga) {
		this.titinstitucionotorga = titinstitucionotorga;
	}

	public String getTitipcreacion() {
		return this.titipcreacion;
	}

	public void setTitipcreacion(String titipcreacion) {
		this.titipcreacion = titipcreacion;
	}

	public String getTitobsresolucion() {
		return this.titobsresolucion;
	}

	public void setTitobsresolucion(String titobsresolucion) {
		this.titobsresolucion = titobsresolucion;
	}

	public Integer getTitperiodoegreso() {
		return this.titperiodoegreso;
	}

	public void setTitperiodoegreso(Integer titperiodoegreso) {
		this.titperiodoegreso = titperiodoegreso;
	}

	public String getTitresolcarrerafecha() {
		return this.titresolcarrerafecha;
	}

	public void setTitresolcarrerafecha(String titresolcarrerafecha) {
		this.titresolcarrerafecha = titresolcarrerafecha;
	}

	public String getTitresolcarreranro() {
		return this.titresolcarreranro;
	}

	public void setTitresolcarreranro(String titresolcarreranro) {
		this.titresolcarreranro = titresolcarreranro;
	}

	public String getTitresolucion() {
		return this.titresolucion;
	}

	public void setTitresolucion(String titresolucion) {
		this.titresolucion = titresolucion;
	}

	public Integer getTitresponsableaprueba() {
		return this.titresponsableaprueba;
	}

	public void setTitresponsableaprueba(Integer titresponsableaprueba) {
		this.titresponsableaprueba = titresponsableaprueba;
	}

	public Integer getTitresponsableemision() {
		return this.titresponsableemision;
	}

	public void setTitresponsableemision(Integer titresponsableemision) {
		this.titresponsableemision = titresponsableemision;
	}

	public String getTittomo() {
		return this.tittomo;
	}

	public void setTittomo(String tittomo) {
		this.tittomo = tittomo;
	}

	public Date getTitultimafechamodif() {
		return this.titultimafechamodif;
	}

	public void setTitultimafechamodif(Date titultimafechamodif) {
		this.titultimafechamodif = titultimafechamodif;
	}

	public String getTitultimoip() {
		return this.titultimoip;
	}

	public void setTitultimoip(String titultimoip) {
		this.titultimoip = titultimoip;
	}

	public Integer getTitultimousuario() {
		return this.titultimousuario;
	}

	public void setTitultimousuario(Integer titultimousuario) {
		this.titultimousuario = titultimousuario;
	}

	public Integer getTitusuariocreacion() {
		return this.titusuariocreacion;
	}

	public void setTitusuariocreacion(Integer titusuariocreacion) {
		this.titusuariocreacion = titusuariocreacion;
	}

	public Integer getTitutlogradoid() {
		return this.titutlogradoid;
	}

	public void setTitutlogradoid(Integer titutlogradoid) {
		this.titutlogradoid = titutlogradoid;
	}

	public Integer getTratramiteid() {
		return this.tratramiteid;
	}

	public void setTratramiteid(Integer tratramiteid) {
		this.tratramiteid = tratramiteid;
	}

	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	public Integer getTtordenmerito() {
		return ttordenmerito;
	}

	public void setTtordenmerito(Integer ttordenmerito) {
		this.ttordenmerito = ttordenmerito;
	}

	public Double getTtpuntaje() {
		return ttpuntaje;
	}

	public void setTtpuntaje(Double ttpuntaje) {
		this.ttpuntaje = ttpuntaje;
	}
	
}