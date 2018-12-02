package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.util.Utiles;


/**
 * The persistent class for the VW_EMPLEADO database table.
 * 
 */
@Entity
@Table(name="VW_EMPLEADO")
public class VwEmpleado extends Entidad {
	private static final long serialVersionUID = 1L;
	
	
	private String apellidomaterno;
	private String apellidopaterno;
	private String correoelectronico;
	private String correoinstitucional;
	private String documento;
	private Integer empleado;
	private boolean escliente;
	private boolean escontacto;
	private boolean esempleado;
	private boolean esproveedor;
	private String estado;
	private String ncoddep;
	private Integer nidedep;
	private Integer nidetipodep;
	private String nombrecompleto;
	private String nombres;
	private String sexo;
	private String tipodocumento;
	private String tipopersona;
	private Integer uneunegocioid;
	private String vdescripcion;
	private String flagsmf;
	
//	@Transient
//	private boolean enviarCorreoDefault;

	public VwEmpleado() {
	}


	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}


	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}


	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}


	public String getCorreoinstitucional() {
		return this.correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	@Id
	public Integer getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}


	
	@Basic
	@Column(name = "ESCLIENTE")
	@Type(type = "yes_no")
	public boolean isEscliente() {
		return escliente;
	}


	public void setEscliente(boolean escliente) {
		this.escliente = escliente;
	}

	@Basic
	@Column(name = "ESCONTACTO")
	@Type(type = "yes_no")
	public boolean isEscontacto() {
		return escontacto;
	}


	public void setEscontacto(boolean escontacto) {
		this.escontacto = escontacto;
	}

	@Basic
	@Column(name = "ESEMPLEADO")
	@Type(type = "yes_no")
	public boolean isEsempleado() {
		return esempleado;
	}


	public void setEsempleado(boolean esempleado) {
		this.esempleado = esempleado;
	}

	@Basic
	@Column(name = "ESPROVEEDOR")
	@Type(type = "yes_no")
	public boolean isEsproveedor() {
		return esproveedor;
	}


	public void setEsproveedor(boolean esproveedor) {
		this.esproveedor = esproveedor;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNcoddep() {
		return this.ncoddep;
	}

	public void setNcoddep(String ncoddep) {
		this.ncoddep = ncoddep;
	}


	@Id
	public Integer getNidedep() {
		return this.nidedep;
	}

	public void setNidedep(Integer nidedep) {
		this.nidedep = nidedep;
	}


	public Integer getNidetipodep() {
		return this.nidetipodep;
	}

	public void setNidetipodep(Integer nidetipodep) {
		this.nidetipodep = nidetipodep;
	}


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public String getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}


	public Integer getUneunegocioid() {
		return this.uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}


	public String getVdescripcion() {
		return this.vdescripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

	public String getFlagsmf() {
		return flagsmf;
	}
	
	public void setFlagsmf(String flagsmf) {
		this.flagsmf = flagsmf;
	}
	
}