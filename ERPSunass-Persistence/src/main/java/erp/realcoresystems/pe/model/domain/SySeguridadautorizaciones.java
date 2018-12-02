package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 07/01/2016.
 */
@Entity
@Table(name = "SY_SEGURIDADAUTORIZACIONES")
public class SySeguridadautorizaciones extends Entidad{
	
	private static final long serialVersionUID = 1L;
	private String aplicacioncodigo;
    private String grupo;
    private String usuario;
    private String concepto;
    private String masterbrowseflag;
    private String masterupdateflag;
    private String estado;//A=ACTIVO,E=ELIMINADO
    private String ultimousuario;
    private Date ultimafechamodif;
    private String masterapproveflag;
    
    /*---- Transient  ---*/
    private String grupoMaster;
	private String conceptoMaster;
	private String descripcionlocal;
	private String descripcionlarga;
    
    @Id
    @Basic
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }
    @Id
    @Basic
    @Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
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

    @Id
    @Basic
    @Column(name="CONCEPTO")
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
    @Basic
    @Column(name = "MASTERBROWSEFLAG")
    public String getMasterbrowseflag() {
        return masterbrowseflag;
    }

    public void setMasterbrowseflag(String masterbrowseflag) {
        this.masterbrowseflag = masterbrowseflag;
    }

    @Basic
    @Column(name = "MASTERUPDATEFLAG")
    public String getMasterupdateflag() {
        return masterupdateflag;
    }

    public void setMasterupdateflag(String masterupdateflag) {
        this.masterupdateflag = masterupdateflag;
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

    @Basic
    @Column(name = "MASTERAPPROVEFLAG")
    public String getMasterapproveflag() {
        return masterapproveflag;
    }

    public void setMasterapproveflag(String masterapproveflag) {
        this.masterapproveflag = masterapproveflag;
    }

    @Transient
	public String getGrupoMaster() {
		return grupoMaster;
	}

	public void setGrupoMaster(String grupoMaster) {
		this.grupoMaster = grupoMaster;
	}
	@Transient
	public String getConceptoMaster() {
		return conceptoMaster;
	}

	public void setConceptoMaster(String conceptoMaster) {
		this.conceptoMaster = conceptoMaster;
	}
	@Transient
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	@Transient
	public String getDescripcionlarga() {
		return descripcionlarga;
	}

	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
	}

}
