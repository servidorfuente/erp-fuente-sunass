package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "SA_COMPENDIOHEADER")
public class SaCompendio  extends Entidad{
	
    private Integer nidecompendio;
    private String vnomtabla;
    private Date dfecinivig;
    private Date dfecfinvig;
    private Integer nideusureg;
    private Date dtfecreg;
    private Integer nestado;

    @Id
    @Column(name = "NIDECOMPENDIO")
    public Integer getNidecompendio() {
        return nidecompendio;
    }

    public void setNidecompendio(Integer nidecompendio) {
        this.nidecompendio = nidecompendio;
    }

    @Basic
    @Column(name = "VNOMTABLA")
    public String getVnomtabla() {
        return vnomtabla;
    }

    public void setVnomtabla(String vnomtabla) {
        this.vnomtabla = vnomtabla;
    }

    @Basic
    @Column(name = "DFECINIVIG")
    public Date getDfecinivig() {
        return dfecinivig;
    }

    public void setDfecinivig(Date dfecinivig) {
        this.dfecinivig = dfecinivig;
    }

    @Basic
    @Column(name = "DFECFINVIG")
    public Date getDfecfinvig() {
        return dfecfinvig;
    }

    public void setDfecfinvig(Date dfecfinvig) {
        this.dfecfinvig = dfecfinvig;
    }

    @Basic
    @Column(name = "NIDEUSUREG")
    public Integer getNideusureg() {
        return nideusureg;
    }

    public void setNideusureg(Integer nideusureg) {
        this.nideusureg = nideusureg;
    }

    @Basic
    @Column(name = "DTFECREG")
    public Date getDtfecreg() {
        return dtfecreg;
    }

    public void setDtfecreg(Date dtfecreg) {
        this.dtfecreg = dtfecreg;
    }

    @Basic
    @Column(name = "NESTADO")
    public Integer getNestado() {
        return nestado;
    }

    public void setNestado(Integer nestado) {
        this.nestado = nestado;
    }
}
