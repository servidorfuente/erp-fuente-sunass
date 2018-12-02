package erp.realcoresystems.pe.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SA_CURMISCELANEO")
public class SaCurMiscelaneo extends Entidad {

	
	private Integer curmiscelaneoid;
	private Integer curcursoid;
	private String tipocurmiscelaneo;
	private String curdescripcion;
	private Integer curestado;

	// ---Getters & Setters---

	@Id
	public Integer getCurmiscelaneoid() {
		return curmiscelaneoid;
	}

	public void setCurmiscelaneoid(Integer curmiscelaneoid) {
		this.curmiscelaneoid = curmiscelaneoid;
	}

	public Integer getCurcursoid() {
		return curcursoid;
	}

	public void setCurcursoid(Integer curcursoid) {
		this.curcursoid = curcursoid;
	}

	public String getTipocurmiscelaneo() {
		return tipocurmiscelaneo;
	}

	public void setTipocurmiscelaneo(String tipocurmiscelaneo) {
		this.tipocurmiscelaneo = tipocurmiscelaneo;
	}

	public String getCurdescripcion() {
		return curdescripcion;
	}

	public void setCurdescripcion(String curdescripcion) {
		this.curdescripcion = curdescripcion;
	}

	public Integer getCurestado() {
		return curestado;
	}

	public void setCurestado(Integer curestado) {
		this.curestado = curestado;
	}

}
