package erp.realcoresystems.pe.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the VW_AULA database table.
 * 
 */
@Entity
@Table(name="VW_AULA")
public class VwAula extends Entidad {
	private static final long serialVersionUID = 1L;
	private Integer aulaulaid;
	private String aulcodigo;
	private Integer auldefinehospital;
	private String auldescripcion;
	private Integer aulestado;
	private Date aulfechacreacion;
	private String aulipcreacion;
	private Integer aulminimovacantes;
	private Integer aulnroaula;
	private String aulpiso;
	private Date aulultimafechamodif;
	private String aulultimoip;
	private Integer aulultimousuario;
	private Integer aulusuariocreacion;
	private Integer sedsedeid;
	private Integer taucodigo;
	private String taudescripcion;
	private Integer tauestado;
	private Integer tautipoaulaid;
	private Integer tauvacantes;
	private Integer vacantes;
	private String seddescripcion;
	private Integer tipoevento;
	private Integer crrcarreraid;
	private String nombrecompleto;
	
	private Date fecha;
	private Date horaInicio;
	private Date horaFin;
	private String formatoTiempo;
	private boolean interno;

	private boolean ocupado;
	private boolean consultaExterna;
	private boolean consultaInterna;
	private boolean consultaEspecial;
	private Integer tipoAmbiente;
	private boolean soloExterno;
	
	private String tipodictado;
	private String desctipodictado;

	public VwAula() {
	}


	@Id
	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getAulaulaid() {
		return this.aulaulaid;
	}

	public void setAulaulaid(Integer aulaulaid) {
		this.aulaulaid = aulaulaid;
	}


	@Column(insertable=false, updatable=false, nullable=false, length=10)
	public String getAulcodigo() {
		return this.aulcodigo;
	}

	public void setAulcodigo(String aulcodigo) {
		this.aulcodigo = aulcodigo;
	}


	@Column(insertable=false, updatable=false)
	public Integer getAuldefinehospital() {
		return this.auldefinehospital;
	}

	public void setAuldefinehospital(Integer auldefinehospital) {
		this.auldefinehospital = auldefinehospital;
	}


	@Column(insertable=false, updatable=false, nullable=false, length=100)
	public String getAuldescripcion() {
		return this.auldescripcion;
	}

	public void setAuldescripcion(String auldescripcion) {
		this.auldescripcion = auldescripcion;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getAulestado() {
		return this.aulestado;
	}

	public void setAulestado(Integer aulestado) {
		this.aulestado = aulestado;
	}


	
	@Column(insertable=false, updatable=false)
	public Date getAulfechacreacion() {
		return this.aulfechacreacion;
	}

	public void setAulfechacreacion(Date aulfechacreacion) {
		this.aulfechacreacion = aulfechacreacion;
	}


	@Column(insertable=false, updatable=false, length=20)
	public String getAulipcreacion() {
		return this.aulipcreacion;
	}

	public void setAulipcreacion(String aulipcreacion) {
		this.aulipcreacion = aulipcreacion;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getAulminimovacantes() {
		return this.aulminimovacantes;
	}

	public void setAulminimovacantes(Integer aulminimovacantes) {
		this.aulminimovacantes = aulminimovacantes;
	}


	@Column(insertable=false, updatable=false)
	public Integer getAulnroaula() {
		return this.aulnroaula;
	}

	public void setAulnroaula(Integer aulnroaula) {
		this.aulnroaula = aulnroaula;
	}


	@Column(insertable=false, updatable=false, nullable=false, length=100)
	public String getAulpiso() {
		return this.aulpiso;
	}

	public void setAulpiso(String aulpiso) {
		this.aulpiso = aulpiso;
	}


	
	@Column(insertable=false, updatable=false)
	public Date getAulultimafechamodif() {
		return this.aulultimafechamodif;
	}

	public void setAulultimafechamodif(Date aulultimafechamodif) {
		this.aulultimafechamodif = aulultimafechamodif;
	}


	@Column(insertable=false, updatable=false, length=20)
	public String getAulultimoip() {
		return this.aulultimoip;
	}

	public void setAulultimoip(String aulultimoip) {
		this.aulultimoip = aulultimoip;
	}


	@Column(insertable=false, updatable=false)
	public Integer getAulultimousuario() {
		return this.aulultimousuario;
	}

	public void setAulultimousuario(Integer aulultimousuario) {
		this.aulultimousuario = aulultimousuario;
	}


	@Column(insertable=false, updatable=false)
	public Integer getAulusuariocreacion() {
		return this.aulusuariocreacion;
	}

	public void setAulusuariocreacion(Integer aulusuariocreacion) {
		this.aulusuariocreacion = aulusuariocreacion;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getSedsedeid() {
		return this.sedsedeid;
	}

	public void setSedsedeid(Integer sedsedeid) {
		this.sedsedeid = sedsedeid;
	}


	@Column(insertable=false, updatable=false, nullable=false, length=10)
	public Integer getTaucodigo() {
		return this.taucodigo;
	}

	public void setTaucodigo(Integer taucodigo) {
		this.taucodigo = taucodigo;
	}


	@Column(insertable=false, updatable=false, nullable=false, length=100)
	public String getTaudescripcion() {
		return this.taudescripcion;
	}

	public void setTaudescripcion(String taudescripcion) {
		this.taudescripcion = taudescripcion;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getTauestado() {
		return this.tauestado;
	}

	public void setTauestado(Integer tauestado) {
		this.tauestado = tauestado;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getTautipoaulaid() {
		return this.tautipoaulaid;
	}

	public void setTautipoaulaid(Integer tautipoaulaid) {
		this.tautipoaulaid = tautipoaulaid;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getTauvacantes() {
		return this.tauvacantes;
	}

	public void setTauvacantes(Integer tauvacantes) {
		this.tauvacantes = tauvacantes;
	}


	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getVacantes() {
		return this.vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}
	
	@Column(insertable=false, updatable=false, nullable=false)
	public String getSeddescripcion() {
		return seddescripcion;
	}
	
	public void setSeddescripcion(String seddescripcion) {
		this.seddescripcion = seddescripcion;
	}
	
	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getCrrcarreraid() {
		return crrcarreraid;
	}
	
	public void setCrrcarreraid(Integer crrcarreraid) {
		this.crrcarreraid = crrcarreraid;
	}
	
	@Column(insertable=false, updatable=false, nullable=false)
	public Integer getTipoevento() {
		return tipoevento;
	}
	
	public void setTipoevento(Integer tipoevento) {
		this.tipoevento = tipoevento;
	}
	
	@Column(insertable=false, updatable=false, nullable=false)
	public String getNombrecompleto() {
		return nombrecompleto;
	}


	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	
	@Transient
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Transient
	public Date getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	@Transient
	public Date getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	

	@Transient
	public boolean isOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	@Transient
	public boolean isInterno() {
		return interno;
	}
	
	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	
	@Transient
	public String getFormatoTiempo() {
		return formatoTiempo;
	}
	
	public void setFormatoTiempo(String formatoTiempo) {
		this.formatoTiempo = formatoTiempo;
	}
	
	@Transient
	public boolean isConsultaExterna() {
		return consultaExterna;
	}


	public void setConsultaExterna(boolean consultaExterna) {
		this.consultaExterna = consultaExterna;
	}

	@Transient
	public boolean isConsultaInterna() {
		return consultaInterna;
	}


	public void setConsultaInterna(boolean consultaInterna) {
		this.consultaInterna = consultaInterna;
	}

	@Transient
	public boolean isConsultaEspecial() {
		return consultaEspecial;
	}
	
	public void setConsultaEspecial(boolean consultaEspecial) {
		this.consultaEspecial = consultaEspecial;
	}
	
	@Transient
	public Integer getTipoAmbiente() {
		return tipoAmbiente;
	}
	
	public void setTipoAmbiente(Integer tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	
	@Transient
	public boolean isSoloExterno() {
		return soloExterno;
	}
	
	public void setSoloExterno(boolean soloExterno) {
		this.soloExterno = soloExterno;
	}
	
	@Column(name = "TIPODICTADO")
	public String getTipodictado() {
		return tipodictado;
	}


	public void setTipodictado(String tipodictado) {
		this.tipodictado = tipodictado;
	}

	@Column(name = "DESCTIPODICTADO")
	public String getDesctipodictado() {
		return desctipodictado;
	}


	public void setDesctipodictado(String desctipodictado) {
		this.desctipodictado = desctipodictado;
	}




	
	
}