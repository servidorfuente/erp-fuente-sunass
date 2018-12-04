package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;

import erp.realcoresystems.pe.model.util.Utiles;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SA_PERSONA_EXPERIENCIA database table.
 * 
 */
@Entity
@Table(name="SA_PERSONA_EXPERIENCIA")
public class SaPersonaExperiencia extends Entidad{
	private static final long serialVersionUID = 1L;
	private SaPersonaExperienciaPK id;
	private Integer agnoExp;
	private String areaexperiencia;
	private String cargoocupado;
	private String codigoCargoocupado;
	private String codigoInstitucion;
	private String empresaInstitucion;
	private String especialidad;
	private Date fechadesde;
	private Date fechahasta;
	private String flagpedido;
	private String flagrespuesta;
	private String funciones;
	private String giroempresa;
	private String jefeinmediato;
	private Integer moemestudioid;
	private String moneda;
	private String motivocese;
	private Integer puestosimilar;
	private BigDecimal sueldo;
	private String tipo;
	private String tipoentidad;
	private String trabajosrealizados;
	private Date ultimafechamodif;
	private String ultimousuario;
	private Integer uneunegocioid;

	private boolean tipoDocenteBool;
	
	private String estado;
	private String tipoexperiencia;
	
	public SaPersonaExperiencia() {
		id = new SaPersonaExperienciaPK();
	}


	@EmbeddedId
	public SaPersonaExperienciaPK getId() {
		return this.id;
	}

	public void setId(SaPersonaExperienciaPK id) {
		this.id = id;
	}


	@Column(name="AGNO_EXP")
	public Integer getAgnoExp() {
		return this.agnoExp;
	}

	public void setAgnoExp(Integer agnoExp) {
		this.agnoExp = agnoExp;
	}


	public String getAreaexperiencia() {
		return this.areaexperiencia;
	}

	public void setAreaexperiencia(String areaexperiencia) {
		this.areaexperiencia = areaexperiencia;
	}


	public String getCargoocupado() {
		return this.cargoocupado;
	}

	public void setCargoocupado(String cargoocupado) {
		this.cargoocupado = cargoocupado;
	}


	@Column(name="CODIGO_CARGOOCUPADO")
	public String getCodigoCargoocupado() {
		return this.codigoCargoocupado;
	}

	public void setCodigoCargoocupado(String codigoCargoocupado) {
		this.codigoCargoocupado = codigoCargoocupado;
	}


	@Column(name="CODIGO_INSTITUCION")
	public String getCodigoInstitucion() {
		return this.codigoInstitucion;
	}

	public void setCodigoInstitucion(String codigoInstitucion) {
		this.codigoInstitucion = codigoInstitucion;
	}


	@Column(name="EMPRESA_INSTITUCION")
	public String getEmpresaInstitucion() {
		return this.empresaInstitucion;
	}

	public void setEmpresaInstitucion(String empresaInstitucion) {
		this.empresaInstitucion = empresaInstitucion;
	}


	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	
	public Date getFechadesde() {
		return this.fechadesde;
	}

	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}


	
	public Date getFechahasta() {
		return this.fechahasta;
	}

	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}


	public String getFlagpedido() {
		return this.flagpedido;
	}

	public void setFlagpedido(String flagpedido) {
		this.flagpedido = flagpedido;
	}


	public String getFlagrespuesta() {
		return this.flagrespuesta;
	}

	public void setFlagrespuesta(String flagrespuesta) {
		this.flagrespuesta = flagrespuesta;
	}


	public String getFunciones() {
		return this.funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}


	public String getGiroempresa() {
		return this.giroempresa;
	}

	public void setGiroempresa(String giroempresa) {
		this.giroempresa = giroempresa;
	}


	public String getJefeinmediato() {
		return this.jefeinmediato;
	}

	public void setJefeinmediato(String jefeinmediato) {
		this.jefeinmediato = jefeinmediato;
	}


	public Integer getMoemestudioid() {
		return this.moemestudioid;
	}

	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getMotivocese() {
		return this.motivocese;
	}

	public void setMotivocese(String motivocese) {
		this.motivocese = motivocese;
	}


	public Integer getPuestosimilar() {
		return this.puestosimilar;
	}

	public void setPuestosimilar(Integer puestosimilar) {
		this.puestosimilar = puestosimilar;
	}


	public BigDecimal getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTipoentidad() {
		return this.tipoentidad;
	}

	public void setTipoentidad(String tipoentidad) {
		this.tipoentidad = tipoentidad;
	}


	public String getTrabajosrealizados() {
		return this.trabajosrealizados;
	}

	public void setTrabajosrealizados(String trabajosrealizados) {
		this.trabajosrealizados = trabajosrealizados;
	}


	
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	@Column(name="ESTADO")	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Transient	
	public boolean isTipoDocenteBool() {
		/**l_gica para DATOS DE EXP LABORAL DE DOCENTES: SGA */
		if(Utiles.FLAG_DOCENTE_db.equals(tipo)){
			tipoDocenteBool = true;
		}else{
			tipoDocenteBool = false;
		}
		return tipoDocenteBool;
	}


	public void setTipoDocenteBool(boolean tipoDocenteBool) {
		/**l_gica para DATOS DE EXP LABORAL DE DOCENTES: SGA */
		if(tipoDocenteBool){
			setTipo(Utiles.FLAG_DOCENTE_db);
		}else{
			setTipo(null);
		}			
		this.tipoDocenteBool = tipoDocenteBool;
	}
	public String getTipoexperiencia() {
		return this.tipoexperiencia;
	}
	public void setTipoexperiencia(String tipoexperiencia) {
		this.tipoexperiencia = tipoexperiencia;
	}
}