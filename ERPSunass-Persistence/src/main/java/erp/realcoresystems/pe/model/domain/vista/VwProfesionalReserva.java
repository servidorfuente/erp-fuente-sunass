package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;


/**
 * The persistent class for the VW_PROFESIONAL_RESERVA database table.
 * 
 */
@Entity
@Table(name="VW_PROFESIONAL_RESERVA")
public class VwProfesionalReserva extends Entidad {
	private static final long serialVersionUID = 1L;
	private String descripciontipodocente;
	private Integer docente;
	private String documento;
	private Integer hrddocestado;
	private String hrdhornombrecompleto;
	private String hrdtipodocente;
	private Integer idcontador;
	private String nombrecompleto;
	private String sexo;
	private Integer tdotipdocenteid;
	private Integer totalReservadet;

	private Integer moemestudioid;	
	private Integer uneunegocioid;
	
	public VwProfesionalReserva() {
	}


	public String getDescripciontipodocente() {
		return this.descripciontipodocente;
	}

	public void setDescripciontipodocente(String descripciontipodocente) {
		this.descripciontipodocente = descripciontipodocente;
	}


	public Integer getDocente() {
		return this.docente;
	}

	public void setDocente(Integer docente) {
		this.docente = docente;
	}


	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public Integer getHrddocestado() {
		return this.hrddocestado;
	}

	public void setHrddocestado(Integer hrddocestado) {
		this.hrddocestado = hrddocestado;
	}


	public String getHrdhornombrecompleto() {
		return this.hrdhornombrecompleto;
	}

	public void setHrdhornombrecompleto(String hrdhornombrecompleto) {
		this.hrdhornombrecompleto = hrdhornombrecompleto;
	}


	public String getHrdtipodocente() {
		return this.hrdtipodocente;
	}

	public void setHrdtipodocente(String hrdtipodocente) {
		this.hrdtipodocente = hrdtipodocente;
	}


	@Id
	public Integer getIdcontador() {
		return this.idcontador;
	}

	public void setIdcontador(Integer idcontador) {
		this.idcontador = idcontador;
	}


	public String getNombrecompleto() {
		return this.nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Integer getTdotipdocenteid() {
		return this.tdotipdocenteid;
	}

	public void setTdotipdocenteid(Integer tdotipdocenteid) {
		this.tdotipdocenteid = tdotipdocenteid;
	}


	@Column(name="TOTAL_RESERVADET")
	public Integer getTotalReservadet() {
		return this.totalReservadet;
	}

	public void setTotalReservadet(Integer totalReservadet) {
		this.totalReservadet = totalReservadet;
	}


	public Integer getMoemestudioid() {
		return moemestudioid;
	}


	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}


	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

}