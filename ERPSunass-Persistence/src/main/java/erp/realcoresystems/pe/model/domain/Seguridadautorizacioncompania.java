package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Seguridadautorizacioncompania extends Entidad{

	private static final long serialVersionUID = 1L;
	private String companyowner;
    private String usuario;
    private String estado;
    private Date ultimafechamodif;
    private String ultimousuario;
    private String campodata;
    
    @Id
    @Basic
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }
    @Id
    @Basic
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
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
    @Column(name = "CAMPODATA")
    public String getCampodata() {
        return campodata;
    }

    public void setCampodata(String campodata) {
        this.campodata = campodata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seguridadautorizacioncompania that = (Seguridadautorizacioncompania) o;

        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (campodata != null ? !campodata.equals(that.campodata) : that.campodata != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (campodata != null ? campodata.hashCode() : 0);
        return result;
    }
}
