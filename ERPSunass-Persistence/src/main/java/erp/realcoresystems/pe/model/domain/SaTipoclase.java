package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_TIPOCLASE")
public class SaTipoclase extends Entidad{
    private Integer tcltipoclaseid;
    private Integer tclestado;
    private String tclcodigo;
    private Integer tclflagteorico;
    private Integer tclflagpractico;
    private Integer tclflagcontabilizable;
    private String tcldescripcion;
    
    private Integer tclusuariocreacion;
    private Date tclfechacreacion;
    private String tclipcreacion;
    private Integer tclultimousuario;
    private Date tclultimafechamodif;
    private String tclultimoip;
    
    // Transient 
    private Integer cboTipoHoraContabilizar;
    
   // private Collection<SaCursocompartido> saCursocompartidosByTcltipoclaseid;
   // private Collection<SaMatrclase> saMatrclasesByTcltipoclaseid;

    @Id
    @Column(name = "TCLTIPOCLASEID")
    public Integer getTcltipoclaseid() {
        return tcltipoclaseid;
    }

    public void setTcltipoclaseid(Integer tcltipoclaseid) {
        this.tcltipoclaseid = tcltipoclaseid;
    }

    @Basic
    @Column(name = "TCLESTADO")
    public Integer getTclestado() {
        return tclestado;
    }

    public void setTclestado(Integer tclestado) {
        this.tclestado = tclestado;
    }

    @Basic
    @Column(name = "TCLCODIGO")
    public String getTclcodigo() {
        return tclcodigo;
    }

    public void setTclcodigo(String tclcodigo) {
        this.tclcodigo = tclcodigo;
    }

    @Basic
    @Column(name = "TCLFLAGTEORICO")
    public Integer getTclflagteorico() {
        return tclflagteorico;
    }

    public void setTclflagteorico(Integer tclflagteorico) {
        this.tclflagteorico = tclflagteorico;
    }

    @Basic
    @Column(name = "TCLFLAGCONTABILIZABLE")
    public Integer getTclflagcontabilizable() {
        return tclflagcontabilizable;
    }

    public void setTclflagcontabilizable(Integer tclflagcontabilizable) {
        this.tclflagcontabilizable = tclflagcontabilizable;
    }

    @Basic
    @Column(name = "TCLDESCRIPCION")
    public String getTcldescripcion() {
        return tcldescripcion;
    }

    public void setTcldescripcion(String tcldescripcion) {
        this.tcldescripcion = tcldescripcion;
    }

    @Basic
    @Column(name = "TCLUSUARIOCREACION")
    public Integer getTclusuariocreacion() {
        return tclusuariocreacion;
    }

    public void setTclusuariocreacion(Integer tclusuariocreacion) {
        this.tclusuariocreacion = tclusuariocreacion;
    }

    @Basic
    @Column(name = "TCLFECHACREACION")
    public Date getTclfechacreacion() {
        return tclfechacreacion;
    }

    public void setTclfechacreacion(Date tclfechacreacion) {
        this.tclfechacreacion = tclfechacreacion;
    }

    @Basic
    @Column(name = "TCLIPCREACION")
    public String getTclipcreacion() {
        return tclipcreacion;
    }

    public void setTclipcreacion(String tclipcreacion) {
        this.tclipcreacion = tclipcreacion;
    }

    @Basic
    @Column(name = "TCLULTIMOUSUARIO")
    public Integer getTclultimousuario() {
        return tclultimousuario;
    }

    public void setTclultimousuario(Integer tclultimousuario) {
        this.tclultimousuario = tclultimousuario;
    }

    @Basic
    @Column(name = "TCLULTIMAFECHAMODIF")
    public Date getTclultimafechamodif() {
        return tclultimafechamodif;
    }

    public void setTclultimafechamodif(Date tclultimafechamodif) {
        this.tclultimafechamodif = tclultimafechamodif;
    }

    @Basic
    @Column(name = "TCLULTIMOIP")
    public String getTclultimoip() {
        return tclultimoip;
    }

    public void setTclultimoip(String tclultimoip) {
        this.tclultimoip = tclultimoip;
    }

    @Basic
    @Column(name = "TCLFLAGPRACTICO")
    public Integer getTclflagpractico() {
        return tclflagpractico;
    }

    public void setTclflagpractico(Integer tclflagpractico) {
        this.tclflagpractico = tclflagpractico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTipoclase that = (SaTipoclase) o;

        if (tcltipoclaseid != that.tcltipoclaseid) return false;
        if (tclestado != that.tclestado) return false;
        if (tclflagteorico != that.tclflagteorico) return false;
        if (tclflagcontabilizable != that.tclflagcontabilizable) return false;
        if (tclcodigo != null ? !tclcodigo.equals(that.tclcodigo) : that.tclcodigo != null) return false;
        if (tcldescripcion != null ? !tcldescripcion.equals(that.tcldescripcion) : that.tcldescripcion != null)
            return false;
        if (tclusuariocreacion != null ? !tclusuariocreacion.equals(that.tclusuariocreacion) : that.tclusuariocreacion != null)
            return false;
        if (tclfechacreacion != null ? !tclfechacreacion.equals(that.tclfechacreacion) : that.tclfechacreacion != null)
            return false;
        if (tclipcreacion != null ? !tclipcreacion.equals(that.tclipcreacion) : that.tclipcreacion != null)
            return false;
        if (tclultimousuario != null ? !tclultimousuario.equals(that.tclultimousuario) : that.tclultimousuario != null)
            return false;
        if (tclultimafechamodif != null ? !tclultimafechamodif.equals(that.tclultimafechamodif) : that.tclultimafechamodif != null)
            return false;
        if (tclultimoip != null ? !tclultimoip.equals(that.tclultimoip) : that.tclultimoip != null) return false;
        if (tclflagpractico != null ? !tclflagpractico.equals(that.tclflagpractico) : that.tclflagpractico != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tcltipoclaseid ^ (tcltipoclaseid >>> 32));
        result = 31 * result + (int) (tclestado ^ (tclestado >>> 32));
        result = 31 * result + (tclcodigo != null ? tclcodigo.hashCode() : 0);
        result = 31 * result + (int) (tclflagteorico ^ (tclflagteorico >>> 32));
//        result = 31 * result + (tclflagcontabilizable !=nll (tclflagcontabilizable >>> 32));
        result = 31 * result + (tcldescripcion != null ? tcldescripcion.hashCode() : 0);
        result = 31 * result + (tclusuariocreacion != null ? tclusuariocreacion.hashCode() : 0);
        result = 31 * result + (tclfechacreacion != null ? tclfechacreacion.hashCode() : 0);
        result = 31 * result + (tclipcreacion != null ? tclipcreacion.hashCode() : 0);
        result = 31 * result + (tclultimousuario != null ? tclultimousuario.hashCode() : 0);
        result = 31 * result + (tclultimafechamodif != null ? tclultimafechamodif.hashCode() : 0);
        result = 31 * result + (tclultimoip != null ? tclultimoip.hashCode() : 0);
        result = 31 * result + (tclflagpractico != null ? tclflagpractico.hashCode() : 0);
        return result;
    }
/*
    @OneToMany(mappedBy = "saTipoclaseByTcltipoclaseid")
    public Collection<SaCursocompartido> getSaCursocompartidosByTcltipoclaseid() {
        return saCursocompartidosByTcltipoclaseid;
    }

    public void setSaCursocompartidosByTcltipoclaseid(Collection<SaCursocompartido> saCursocompartidosByTcltipoclaseid) {
        this.saCursocompartidosByTcltipoclaseid = saCursocompartidosByTcltipoclaseid;
    }

    @OneToMany(mappedBy = "saTipoclaseByTcltipoclaseid")
    public Collection<SaMatrclase> getSaMatrclasesByTcltipoclaseid() {
        return saMatrclasesByTcltipoclaseid;
    }

    public void setSaMatrclasesByTcltipoclaseid(Collection<SaMatrclase> saMatrclasesByTcltipoclaseid) {
        this.saMatrclasesByTcltipoclaseid = saMatrclasesByTcltipoclaseid;
    }*/

    @Transient
	public Integer getCboTipoHoraContabilizar() {
		return cboTipoHoraContabilizar;
	}

	public void setCboTipoHoraContabilizar(Integer cboTipoHoraContabilizar) {
		this.cboTipoHoraContabilizar = cboTipoHoraContabilizar;
	}
}
