package erp.realcoresystems.pe.model.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Created by mamania on 07/01/2016.
 */
@Entity
@Table(name = "AC_SUCURSAL")
public class AcSucursal extends Entidad{
	
	private static final long serialVersionUID = 1L;
	private String sucursal;
    private String sucursalgrupo;
    private Integer sedsedegrupoid;
    private Companyowner companyowner = new Companyowner();
    private String descripcionlocal;
    private String descripcioningles;
    private String estado;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String cuentacontabledefecto;

    @Id
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Basic
    @Column(name = "SUCURSALGRUPO")
    public String getSucursalgrupo() {
        return sucursalgrupo;
    }

    public void setSucursalgrupo(String sucursalgrupo) {
        this.sucursalgrupo = sucursalgrupo;
    }

    @Basic
    @Column(name="SEDSEDEGRUPOID")
	public Integer getSedsedegrupoid() {
		return sedsedegrupoid;
	}

	public void setSedsedegrupoid(Integer sedsedegrupoid) {
		this.sedsedegrupoid = sedsedegrupoid;
	}
	
    @Basic
    @Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    @Basic
    @Column(name = "DESCRIPCIONINGLES")
    public String getDescripcioningles() {
        return descripcioningles;
    }

    public void setDescripcioningles(String descripcioningles) {
        this.descripcioningles = descripcioningles;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    @Basic
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }    
    
    @ManyToOne
    @JoinColumn(name="COMPANYOWNER")
	public Companyowner getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(Companyowner companyowner) {
		this.companyowner = companyowner;
	}

    @Basic
    @Column(name = "CUENTACONTABLEDEFECTO")
    public String getCuentacontabledefecto() {
        return cuentacontabledefecto;
    }

    public void setCuentacontabledefecto(String cuentacontabledefecto) {
        this.cuentacontabledefecto = cuentacontabledefecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcSucursal that = (AcSucursal) o;

        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (sucursalgrupo != null ? !sucursalgrupo.equals(that.sucursalgrupo) : that.sucursalgrupo != null)
            return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (descripcionlocal != null ? !descripcionlocal.equals(that.descripcionlocal) : that.descripcionlocal != null)
            return false;
        if (descripcioningles != null ? !descripcioningles.equals(that.descripcioningles) : that.descripcioningles != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (cuentacontabledefecto != null ? !cuentacontabledefecto.equals(that.cuentacontabledefecto) : that.cuentacontabledefecto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sucursal != null ? sucursal.hashCode() : 0;
        result = 31 * result + (sucursalgrupo != null ? sucursalgrupo.hashCode() : 0);
        result = 31 * result + (companyowner != null ? companyowner.hashCode() : 0);
        result = 31 * result + (descripcionlocal != null ? descripcionlocal.hashCode() : 0);
        result = 31 * result + (descripcioningles != null ? descripcioningles.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (cuentacontabledefecto != null ? cuentacontabledefecto.hashCode() : 0);
        return result;
    }
		
}
