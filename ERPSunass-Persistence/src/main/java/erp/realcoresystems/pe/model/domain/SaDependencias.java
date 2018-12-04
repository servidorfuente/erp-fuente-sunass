package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name = "SA_DEPENDENCIAS")
public class SaDependencias extends Entidad {

	private Date dfecfinvig;
	private Date dfecinivig;
	private Date dtfecreg;
	private Date moeultimafechamodif;
	private String moeultimoip;
	private Integer moeultimousuario;
	private Integer nbansel;
	private String ncoddep;
	private Integer nestado;
	private Integer nidedep;
	private Integer nidedeppadre;
	private Integer nidedepregion;
	private Integer nideempresa;
	private Integer nidetipodep;
	private Integer nideusureg;
	private Integer norden;
	private Integer uneunegocioid;
	private String vcodigopuesto;
	private String vdescripcion;
	private String vflagjefe;
	private String vreferencia;
	private String vsigdep;

	@Id
	@javax.persistence.Column(name = "UNEUNEGOCIOID")
	public Integer getUneunegocioid() {
		return uneunegocioid;
	}

	@Id
	@javax.persistence.Column(name = "NIDEDEP")
	public Integer getNidedep() {
		return nidedep;
	}

	@Basic
	@javax.persistence.Column(name = "DFECFINVIG")
	public Date getDfecfinvig() {
		return dfecfinvig;
	}

	@Basic
	@javax.persistence.Column(name = "DFECINIVIG")
	public Date getDfecinivig() {
		return dfecinivig;
	}

	@Basic
	@javax.persistence.Column(name = "DTFECREG")
	public Date getDtfecreg() {
		return dtfecreg;
	}

	@Basic
	@javax.persistence.Column(name = "MOEULTIMAFECHAMODIF")
	public Date getMoeultimafechamodif() {
		return moeultimafechamodif;
	}

	@Basic
	@javax.persistence.Column(name = "MOEULTIMOIP")
	public String getMoeultimoip() {
		return moeultimoip;
	}

	@Basic
	@javax.persistence.Column(name = "MOEULTIMOUSUARIO")
	public Integer getMoeultimousuario() {
		return moeultimousuario;
	}

	@Basic
	@javax.persistence.Column(name = "NBANSEL")
	public Integer getNbansel() {
		return nbansel;
	}

	@Basic
	@javax.persistence.Column(name = "NCODDEP")
	public String getNcoddep() {
		return ncoddep;
	}

	@Basic
	@javax.persistence.Column(name = "NESTADO")
	public Integer getNestado() {
		return nestado;
	}

	@Basic
	@javax.persistence.Column(name = "NIDEDEPPADRE")
	public Integer getNidedeppadre() {
		return nidedeppadre;
	}

	@Basic
	@javax.persistence.Column(name = "NIDEDEPREGION")
	public Integer getNidedepregion() {
		return nidedepregion;
	}

	@Basic
	@javax.persistence.Column(name = "NIDEEMPRESA")
	public Integer getNideempresa() {
		return nideempresa;
	}

	@Basic
	@javax.persistence.Column(name = "NIDETIPODEP")
	public Integer getNidetipodep() {
		return nidetipodep;
	}

	@Basic
	@javax.persistence.Column(name = "NIDEUSUREG")
	public Integer getNideusureg() {
		return nideusureg;
	}

	@Basic
	@javax.persistence.Column(name = "NORDEN")
	public Integer getNorden() {
		return norden;
	}

	@Basic
	@javax.persistence.Column(name = "VCODIGOPUESTO")
	public String getVcodigopuesto() {
		return vcodigopuesto;
	}

	@Basic
	@javax.persistence.Column(name = "VDESCRIPCION")
	public String getVdescripcion() {
		return vdescripcion;
	}

	@Basic
	@javax.persistence.Column(name = "VFLAGJEFE")
	public String getVflagjefe() {
		return vflagjefe;
	}

	@Basic
	@javax.persistence.Column(name = "VREFERENCIA")
	public String getVreferencia() {
		return vreferencia;
	}

	@Basic
	@javax.persistence.Column(name = "VSIGDEP")
	public String getVsigdep() {
		return vsigdep;
	}

	public void setDfecfinvig(Date dfecfinvig) {
		this.dfecfinvig = dfecfinvig;
	}

	public void setDfecinivig(Date dfecinivig) {
		this.dfecinivig = dfecinivig;
	}

	public void setDtfecreg(Date dtfecreg) {
		this.dtfecreg = dtfecreg;
	}

	public void setMoeultimafechamodif(Date moeultimafechamodif) {
		this.moeultimafechamodif = moeultimafechamodif;
	}

	public void setMoeultimoip(String moeultimoip) {
		this.moeultimoip = moeultimoip;
	}

	public void setMoeultimousuario(Integer moeultimousuario) {
		this.moeultimousuario = moeultimousuario;
	}

	public void setNbansel(Integer nbansel) {
		this.nbansel = nbansel;
	}

	public void setNcoddep(String ncoddep) {
		this.ncoddep = ncoddep;
	}

	public void setNestado(Integer nestado) {
		this.nestado = nestado;
	}

	public void setNidedep(Integer nidedep) {
		this.nidedep = nidedep;
	}

	public void setNidedeppadre(Integer nidedeppadre) {
		this.nidedeppadre = nidedeppadre;
	}

	public void setNidedepregion(Integer nidedepregion) {
		this.nidedepregion = nidedepregion;
	}

	public void setNideempresa(Integer nideempresa) {
		this.nideempresa = nideempresa;
	}

	public void setNidetipodep(Integer nidetipodep) {
		this.nidetipodep = nidetipodep;
	}

	public void setNideusureg(Integer nideusureg) {
		this.nideusureg = nideusureg;
	}

	public void setNorden(Integer norden) {
		this.norden = norden;
	}

	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}

	public void setVcodigopuesto(String vcodigopuesto) {
		this.vcodigopuesto = vcodigopuesto;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

	public void setVflagjefe(String vflagjefe) {
		this.vflagjefe = vflagjefe;
	}

	public void setVreferencia(String vreferencia) {
		this.vreferencia = vreferencia;
	}

	public void setVsigdep(String vsigdep) {
		this.vsigdep = vsigdep;
	}

	@Override
	public int hashCode() {
		int result = uneunegocioid != null ? uneunegocioid.hashCode() : 0;
		result = 31 * result + (nidedep != null ? nidedep.hashCode() : 0);
		result = 31 * result + (nidetipodep != null ? nidetipodep.hashCode() : 0);
		result = 31 * result + (vdescripcion != null ? vdescripcion.hashCode() : 0);
		result = 31 * result + (nidedepregion != null ? nidedepregion.hashCode() : 0);
		result = 31 * result + (nidedeppadre != null ? nidedeppadre.hashCode() : 0);
		result = 31 * result + (ncoddep != null ? ncoddep.hashCode() : 0);
		result = 31 * result + (vsigdep != null ? vsigdep.hashCode() : 0);
		result = 31 * result + (nbansel != null ? nbansel.hashCode() : 0);
		result = 31 * result + (vreferencia != null ? vreferencia.hashCode() : 0);
		result = 31 * result + (dfecinivig != null ? dfecinivig.hashCode() : 0);
		result = 31 * result + (dfecfinvig != null ? dfecfinvig.hashCode() : 0);
		result = 31 * result + (nideusureg != null ? nideusureg.hashCode() : 0);
		result = 31 * result + (dtfecreg != null ? dtfecreg.hashCode() : 0);
		result = 31 * result + (nideempresa != null ? nideempresa.hashCode() : 0);
		result = 31 * result + (vcodigopuesto != null ? vcodigopuesto.hashCode() : 0);
		result = 31 * result + (vflagjefe != null ? vflagjefe.hashCode() : 0);
		result = 31 * result + (norden != null ? norden.hashCode() : 0);
		result = 31 * result + (moeultimousuario != null ? moeultimousuario.hashCode() : 0);
		result = 31 * result + (moeultimafechamodif != null ? moeultimafechamodif.hashCode() : 0);
		result = 31 * result + (moeultimoip != null ? moeultimoip.hashCode() : 0);
		result = 31 * result + (nestado != null ? nestado.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SaDependencias that = (SaDependencias) o;

		if (uneunegocioid != null ? !uneunegocioid.equals(that.uneunegocioid) : that.uneunegocioid != null)
			return false;
		if (nidedep != null ? !nidedep.equals(that.nidedep) : that.nidedep != null)
			return false;
		if (nidetipodep != null ? !nidetipodep.equals(that.nidetipodep) : that.nidetipodep != null)
			return false;
		if (vdescripcion != null ? !vdescripcion.equals(that.vdescripcion) : that.vdescripcion != null)
			return false;
		if (nidedepregion != null ? !nidedepregion.equals(that.nidedepregion) : that.nidedepregion != null)
			return false;
		if (nidedeppadre != null ? !nidedeppadre.equals(that.nidedeppadre) : that.nidedeppadre != null)
			return false;
		if (ncoddep != null ? !ncoddep.equals(that.ncoddep) : that.ncoddep != null)
			return false;
		if (vsigdep != null ? !vsigdep.equals(that.vsigdep) : that.vsigdep != null)
			return false;
		if (nbansel != null ? !nbansel.equals(that.nbansel) : that.nbansel != null)
			return false;
		if (vreferencia != null ? !vreferencia.equals(that.vreferencia) : that.vreferencia != null)
			return false;
		if (dfecinivig != null ? !dfecinivig.equals(that.dfecinivig) : that.dfecinivig != null)
			return false;
		if (dfecfinvig != null ? !dfecfinvig.equals(that.dfecfinvig) : that.dfecfinvig != null)
			return false;
		if (nideusureg != null ? !nideusureg.equals(that.nideusureg) : that.nideusureg != null)
			return false;
		if (dtfecreg != null ? !dtfecreg.equals(that.dtfecreg) : that.dtfecreg != null)
			return false;
		if (nideempresa != null ? !nideempresa.equals(that.nideempresa) : that.nideempresa != null)
			return false;
		if (vcodigopuesto != null ? !vcodigopuesto.equals(that.vcodigopuesto) : that.vcodigopuesto != null)
			return false;
		if (vflagjefe != null ? !vflagjefe.equals(that.vflagjefe) : that.vflagjefe != null)
			return false;
		if (norden != null ? !norden.equals(that.norden) : that.norden != null)
			return false;
		if (moeultimousuario != null ? !moeultimousuario.equals(that.moeultimousuario) : that.moeultimousuario != null)
			return false;
		if (moeultimafechamodif != null ? !moeultimafechamodif.equals(that.moeultimafechamodif)
				: that.moeultimafechamodif != null)
			return false;
		if (moeultimoip != null ? !moeultimoip.equals(that.moeultimoip) : that.moeultimoip != null)
			return false;
		if (nestado != null ? !nestado.equals(that.nestado) : that.nestado != null)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "SaDependencias [dfecfinvig=" + dfecfinvig + ", dfecinivig=" + dfecinivig + ", dtfecreg=" + dtfecreg
				+ ", moeultimafechamodif=" + moeultimafechamodif + ", moeultimoip=" + moeultimoip
				+ ", moeultimousuario=" + moeultimousuario + ", nbansel=" + nbansel + ", ncoddep=" + ncoddep
				+ ", nestado=" + nestado + ", nidedep=" + nidedep + ", nidedeppadre=" + nidedeppadre
				+ ", nidedepregion=" + nidedepregion + ", nideempresa=" + nideempresa + ", nidetipodep=" + nidetipodep
				+ ", nideusureg=" + nideusureg + ", norden=" + norden + ", uneunegocioid=" + uneunegocioid
				+ ", vcodigopuesto=" + vcodigopuesto + ", vdescripcion=" + vdescripcion + ", vflagjefe=" + vflagjefe
				+ ", vreferencia=" + vreferencia + ", vsigdep=" + vsigdep + "]";
	}

	
}
