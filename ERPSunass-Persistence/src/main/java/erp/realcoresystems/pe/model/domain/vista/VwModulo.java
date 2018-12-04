package erp.realcoresystems.pe.model.domain.vista;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import erp.realcoresystems.pe.model.domain.Entidad;

/**
 * The persistent class for the VW_MODULO database table.
 * 
 */
@Entity
@Table(name = "VW_MODULO")
public class VwModulo extends Entidad {
	private static final long serialVersionUID = 1L;
	private String agrupadorprograma;
	private String clocodigo;
	private Integer clocurriculoid;
	private Integer clocurriculoidanterior;
	private String clodescripcion;
	private Integer cloestado;
	private String cloflagmodular;
	private String costcenter;
	private Integer crrcarreraid;
	private Integer crrciclos;
	private String crrcodigo;
	private String crrdescripcion;
	private Integer crrestado;
	private boolean crrflagasistencia;
	private Integer crrflagmodular;
	private boolean crrflagnotas;
	private Integer crrnumeroasistencia;
	private Integer crrnumeronotas;
	private Integer modasistencia;
	private String modcodigo;
	private Integer modcreditos;
	private String moddescripcion;
	private Integer modduracion;
	private Integer modestado;
	private Date modfechacreacion;
	private boolean modflagasistencia;
	private boolean modflagnotas;
	private Integer modhoras;
	private String modipcreacion;
	private String modmension;
	private Integer modmoduloid;
	private Integer modnota;
	private Integer modpersonaautoriza;
	private String modresolucion;
	private Integer modtipoduracion;
	private Integer modtipomodulo;
	private Date modultimafechamodif;
	private String modultimoip;
	private Integer modultimousuario;
	private String modunidadcompetencia;
	private Integer modusuariocreacion;
	private Integer moemestudioid;
	private Integer uneunegocioid;
	private String personaautorizanombre;
	private Integer ciccuciclo;
	private Integer secciclo;
	
	// Transient
	@Transient
	private String idCompuesto;

	public VwModulo() {
	}

	@Basic
	@Column(name = "AGRUPADORPROGRAMA")
	public String getAgrupadorprograma() {
		return this.agrupadorprograma;
	}

	public void setAgrupadorprograma(String agrupadorprograma) {
		this.agrupadorprograma = agrupadorprograma;
	}

	@Basic
	@Column(name = "CLOCODIGO")
	public String getClocodigo() {
		return this.clocodigo;
	}

	public void setClocodigo(String clocodigo) {
		this.clocodigo = clocodigo;
	}

	@Basic
	@Column(name = "CLOCURRICULOID")
	public Integer getClocurriculoid() {
		return this.clocurriculoid;
	}

	public void setClocurriculoid(Integer clocurriculoid) {
		this.clocurriculoid = clocurriculoid;
	}

	@Basic
	@Column(name = "CLOCURRICULOIDANTERIOR")
	public Integer getClocurriculoidanterior() {
		return this.clocurriculoidanterior;
	}

	public void setClocurriculoidanterior(Integer clocurriculoidanterior) {
		this.clocurriculoidanterior = clocurriculoidanterior;
	}

	@Basic
	@Column(name = "CLODESCRIPCION")
	public String getClodescripcion() {
		return this.clodescripcion;
	}

	public void setClodescripcion(String clodescripcion) {
		this.clodescripcion = clodescripcion;
	}

	@Basic
	@Column(name = "CLOESTADO")
	public Integer getCloestado() {
		return this.cloestado;
	}

	public void setCloestado(Integer cloestado) {
		this.cloestado = cloestado;
	}

	@Basic
	@Column(name = "CLOFLAGMODULAR")
	public String getCloflagmodular() {
		return this.cloflagmodular;
	}

	public void setCloflagmodular(String cloflagmodular) {
		this.cloflagmodular = cloflagmodular;
	}

	@Basic
	@Column(name = "COSTCENTER")
	public String getCostcenter() {
		return this.costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	@Basic
	@Column(name = "CRRCARRERAID")
	public Integer getCrrcarreraid() {
		return this.crrcarreraid;
	}

	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}

	@Basic
	@Column(name = "CRRCICLOS")
	public Integer getCrrciclos() {
		return this.crrciclos;
	}

	public void setCrrciclos(Integer crrciclos) {
		this.crrciclos = crrciclos;
	}

	@Basic
	@Column(name = "CRRCODIGO")
	public String getCrrcodigo() {
		return this.crrcodigo;
	}

	public void setCrrcodigo(String crrcodigo) {
		this.crrcodigo = crrcodigo;
	}

	@Basic
	@Column(name = "CRRDESCRIPCION")
	public String getCrrdescripcion() {
		return this.crrdescripcion;
	}

	public void setCrrdescripcion(String crrdescripcion) {
		this.crrdescripcion = crrdescripcion;
	}

	@Basic
	@Column(name = "CRRESTADO")
	public Integer getCrrestado() {
		return this.crrestado;
	}

	public void setCrrestado(Integer crrestado) {
		this.crrestado = crrestado;
	}

	@Basic
	@Column(name = "CRRFLAGASISTENCIA")
	public boolean getCrrflagasistencia() {
		return this.crrflagasistencia;
	}

	public void setCrrflagasistencia(boolean crrflagasistencia) {
		this.crrflagasistencia = crrflagasistencia;
	}

	@Basic
	@Column(name = "CRRFLAGMODULAR")
	public Integer getCrrflagmodular() {
		return this.crrflagmodular;
	}

	public void setCrrflagmodular(Integer crrflagmodular) {
		this.crrflagmodular = crrflagmodular;
	}

	@Basic
	@Column(name = "CRRFLAGNOTAS")
	public boolean getCrrflagnotas() {
		return this.crrflagnotas;
	}

	public void setCrrflagnotas(boolean crrflagnotas) {
		this.crrflagnotas = crrflagnotas;
	}

	@Basic
	@Column(name = "CRRNUMEROASISTENCIA")
	public Integer getCrrnumeroasistencia() {
		return this.crrnumeroasistencia;
	}

	public void setCrrnumeroasistencia(Integer crrnumeroasistencia) {
		this.crrnumeroasistencia = crrnumeroasistencia;
	}

	@Basic
	@Column(name = "CRRNUMERONOTAS")
	public Integer getCrrnumeronotas() {
		return this.crrnumeronotas;
	}

	public void setCrrnumeronotas(Integer crrnumeronotas) {
		this.crrnumeronotas = crrnumeronotas;
	}

	@Basic
	@Column(name = "MODASISTENCIA")
	public Integer getModasistencia() {
		return this.modasistencia;
	}

	public void setModasistencia(Integer modasistencia) {
		this.modasistencia = modasistencia;
	}

	@Basic
	@Column(name = "MODCODIGO")
	public String getModcodigo() {
		return this.modcodigo;
	}

	public void setModcodigo(String modcodigo) {
		this.modcodigo = modcodigo;
	}

	@Basic
	@Column(name = "MODCREDITOS")
	public Integer getModcreditos() {
		return this.modcreditos;
	}

	public void setModcreditos(Integer modcreditos) {
		this.modcreditos = modcreditos;
	}

	@Basic
	@Column(name = "MODDESCRIPCION")
	public String getModdescripcion() {
		return this.moddescripcion;
	}

	public void setModdescripcion(String moddescripcion) {
		this.moddescripcion = moddescripcion;
	}

	@Basic
	@Column(name = "MODDURACION")
	public Integer getModduracion() {
		return this.modduracion;
	}

	public void setModduracion(Integer modduracion) {
		this.modduracion = modduracion;
	}

	@Basic
	@Column(name = "MODESTADO")
	public Integer getModestado() {
		return this.modestado;
	}

	public void setModestado(Integer modestado) {
		this.modestado = modestado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	@Column(name = "MODFECHACREACION")
	public Date getModfechacreacion() {
		return this.modfechacreacion;
	}

	public void setModfechacreacion(Date modfechacreacion) {
		this.modfechacreacion = modfechacreacion;
	}

	@Basic
	@Column(name = "MODFLAGASISTENCIA")
	public boolean getModflagasistencia() {
		return this.modflagasistencia;
	}

	public void setModflagasistencia(boolean modflagasistencia) {
		this.modflagasistencia = modflagasistencia;
	}

	@Basic
	@Column(name = "MODFLAGNOTAS")
	public boolean getModflagnotas() {
		return this.modflagnotas;
	}

	public void setModflagnotas(boolean modflagnotas) {
		this.modflagnotas = modflagnotas;
	}

	@Basic
	@Column(name = "MODHORAS")
	public Integer getModhoras() {
		return this.modhoras;
	}

	public void setModhoras(Integer modhoras) {
		this.modhoras = modhoras;
	}

	@Basic
	@Column(name = "MODIPCREACION")
	public String getModipcreacion() {
		return this.modipcreacion;
	}

	public void setModipcreacion(String modipcreacion) {
		this.modipcreacion = modipcreacion;
	}

	@Basic
	@Column(name = "MODMENSION")
	public String getModmension() {
		return this.modmension;
	}

	public void setModmension(String modmension) {
		this.modmension = modmension;
	}

	@Id
	@Basic
	@Column(name = "MODMODULOID")
	public Integer getModmoduloid() {
		return this.modmoduloid;
	}

	public void setModmoduloid(Integer modmoduloid) {
		this.modmoduloid = modmoduloid;
	}

	@Basic
	@Column(name = "MODNOTA")
	public Integer getModnota() {
		return this.modnota;
	}

	public void setModnota(Integer modnota) {
		this.modnota = modnota;
	}

	@Basic
	@Column(name = "MODPERSONAAUTORIZA")
	public Integer getModpersonaautoriza() {
		return this.modpersonaautoriza;
	}

	public void setModpersonaautoriza(Integer modpersonaautoriza) {
		this.modpersonaautoriza = modpersonaautoriza;
	}

	@Basic
	@Column(name = "MODRESOLUCION")
	public String getModresolucion() {
		return this.modresolucion;
	}

	public void setModresolucion(String modresolucion) {
		this.modresolucion = modresolucion;
	}

	@Basic
	@Column(name = "MODTIPODURACION")
	public Integer getModtipoduracion() {
		return this.modtipoduracion;
	}

	public void setModtipoduracion(Integer modtipoduracion) {
		this.modtipoduracion = modtipoduracion;
	}

	@Basic
	@Column(name = "MODTIPOMODULO")
	public Integer getModtipomodulo() {
		return this.modtipomodulo;
	}

	public void setModtipomodulo(Integer modtipomodulo) {
		this.modtipomodulo = modtipomodulo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Basic
	@Column(name = "MODULTIMAFECHAMODIF")
	public Date getModultimafechamodif() {
		return this.modultimafechamodif;
	}

	public void setModultimafechamodif(Date modultimafechamodif) {
		this.modultimafechamodif = modultimafechamodif;
	}

	@Basic
	@Column(name = "MODULTIMOIP")
	public String getModultimoip() {
		return this.modultimoip;
	}

	public void setModultimoip(String modultimoip) {
		this.modultimoip = modultimoip;
	}

	@Basic
	@Column(name = "MODULTIMOUSUARIO")
	public Integer getModultimousuario() {
		return this.modultimousuario;
	}

	public void setModultimousuario(Integer modultimousuario) {
		this.modultimousuario = modultimousuario;
	}

	@Basic
	@Column(name = "MODUNIDADCOMPETENCIA")
	public String getModunidadcompetencia() {
		return this.modunidadcompetencia;
	}

	public void setModunidadcompetencia(String modunidadcompetencia) {
		this.modunidadcompetencia = modunidadcompetencia;
	}

	@Basic
	@Column(name = "MODUSUARIOCREACION")
	public Integer getModusuariocreacion() {
		return this.modusuariocreacion;
	}

	public void setModusuariocreacion(Integer modusuariocreacion) {
		this.modusuariocreacion = modusuariocreacion;
	}

	@Basic
	@Column(name = "MOEMESTUDIOID")
	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

	@Basic
	@Column(name = "UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Basic
	@Column(name = "PERSONAAUTORIZANOMBRE")
	public String getPersonaautorizanombre() {
		return personaautorizanombre;
	}

	public void setPersonaautorizanombre(String personaautorizanombre) {
		this.personaautorizanombre = personaautorizanombre;
	}

	@Basic
	@Column(name = "CICCUCICLO")
	public Integer getCiccuciclo() {
		return ciccuciclo;
	}

	public void setCiccuciclo(Integer ciccuciclo) {
		this.ciccuciclo = ciccuciclo;
	}

	@Basic
	@Column(name = "SECCICLO")
	public Integer getSecciclo() {
		return secciclo;
	}

	public void setSecciclo(Integer secciclo) {
		this.secciclo = secciclo;
	}

	// Transient
	@Transient
	public String getIdCompuesto() {
		idCompuesto = String.join("_", "" + getUneunegocioid(), "" + getMoemestudioid(), "" + getClocurriculoid(),
				"" + getCrrcarreraid(), "" + getModmoduloid());
		return idCompuesto;
	}

	public void setIdCompuesto(String idCompuesto) {
		this.idCompuesto = idCompuesto;
	}

}