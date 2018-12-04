package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SS_CARGAINICIALDETALLE", schema = "MGR_DESA_SS", catalog = "")
@IdClass(SsCargainicialdetallePK.class)
public class SsCargainicialdetalle   extends Entidad{
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;
    private Integer fuenteid;
    private Integer anno;
    private Integer secuencia;
    private Integer tintero01Valor;
    private Integer tintero02Valor;
    private Integer tintero03Valor;
    private Integer tintero04Valor;
    private Integer tintero05Valor;
    private Integer tintero06Valor;
    private Integer tintero08Valor;
    private Integer tintero09Valor;
    private Integer tintero07Valor;
    private String tcadena01Valor;
    private String tcadena02Valor;
    private String tcadena03Valor;
    private String tcadena04Valor;
    private String tcadena05Valor;
    private String tcadena06Valor;
    private String tcadena07Valor;
    private String estado;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String observacion;

    @Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Id
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Id
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Id
    @Column(name = "FUENTEID")
    public Integer getFuenteid() {
        return fuenteid;
    }

    public void setFuenteid(Integer fuenteid) {
        this.fuenteid = fuenteid;
    }

    @Id
    @Column(name = "ANNO")
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Id
    @Column(name = "SECUENCIA")
    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    @Basic
    @Column(name = "TINTERO01VALOR")
    public Integer getTintero01Valor() {
        return tintero01Valor;
    }

    public void setTintero01Valor(Integer tintero01Valor) {
        this.tintero01Valor = tintero01Valor;
    }

    @Basic
    @Column(name = "TINTERO02VALOR")
    public Integer getTintero02Valor() {
        return tintero02Valor;
    }

    public void setTintero02Valor(Integer tintero02Valor) {
        this.tintero02Valor = tintero02Valor;
    }

    @Basic
    @Column(name = "TINTERO03VALOR")
    public Integer getTintero03Valor() {
        return tintero03Valor;
    }

    public void setTintero03Valor(Integer tintero03Valor) {
        this.tintero03Valor = tintero03Valor;
    }

    @Basic
    @Column(name = "TINTERO04VALOR")
    public Integer getTintero04Valor() {
        return tintero04Valor;
    }

    public void setTintero04Valor(Integer tintero04Valor) {
        this.tintero04Valor = tintero04Valor;
    }

    @Basic
    @Column(name = "TINTERO05VALOR")
    public Integer getTintero05Valor() {
        return tintero05Valor;
    }

    public void setTintero05Valor(Integer tintero05Valor) {
        this.tintero05Valor = tintero05Valor;
    }

    @Basic
    @Column(name = "TINTERO06VALOR")
    public Integer getTintero06Valor() {
        return tintero06Valor;
    }

    public void setTintero06Valor(Integer tintero06Valor) {
        this.tintero06Valor = tintero06Valor;
    }

    @Basic
    @Column(name = "TINTERO08VALOR")
    public Integer getTintero08Valor() {
        return tintero08Valor;
    }

    public void setTintero08Valor(Integer tintero08Valor) {
        this.tintero08Valor = tintero08Valor;
    }

    @Basic
    @Column(name = "TINTERO09VALOR")
    public Integer getTintero09Valor() {
        return tintero09Valor;
    }

    public void setTintero09Valor(Integer tintero09Valor) {
        this.tintero09Valor = tintero09Valor;
    }

    @Basic
    @Column(name = "TINTERO07VALOR")
    public Integer getTintero07Valor() {
        return tintero07Valor;
    }

    public void setTintero07Valor(Integer tintero07Valor) {
        this.tintero07Valor = tintero07Valor;
    }

    @Basic
    @Column(name = "TCADENA01VALOR")
    public String getTcadena01Valor() {
        return tcadena01Valor;
    }

    public void setTcadena01Valor(String tcadena01Valor) {
        this.tcadena01Valor = tcadena01Valor;
    }

    @Basic
    @Column(name = "TCADENA02VALOR")
    public String getTcadena02Valor() {
        return tcadena02Valor;
    }

    public void setTcadena02Valor(String tcadena02Valor) {
        this.tcadena02Valor = tcadena02Valor;
    }

    @Basic
    @Column(name = "TCADENA03VALOR")
    public String getTcadena03Valor() {
        return tcadena03Valor;
    }

    public void setTcadena03Valor(String tcadena03Valor) {
        this.tcadena03Valor = tcadena03Valor;
    }

    @Basic
    @Column(name = "TCADENA04VALOR")
    public String getTcadena04Valor() {
        return tcadena04Valor;
    }

    public void setTcadena04Valor(String tcadena04Valor) {
        this.tcadena04Valor = tcadena04Valor;
    }

    @Basic
    @Column(name = "TCADENA05VALOR")
    public String getTcadena05Valor() {
        return tcadena05Valor;
    }

    public void setTcadena05Valor(String tcadena05Valor) {
        this.tcadena05Valor = tcadena05Valor;
    }

    @Basic
    @Column(name = "TCADENA06VALOR")
    public String getTcadena06Valor() {
        return tcadena06Valor;
    }

    public void setTcadena06Valor(String tcadena06Valor) {
        this.tcadena06Valor = tcadena06Valor;
    }

    @Basic
    @Column(name = "TCADENA07VALOR")
    public String getTcadena07Valor() {
        return tcadena07Valor;
    }

    public void setTcadena07Valor(String tcadena07Valor) {
        this.tcadena07Valor = tcadena07Valor;
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
    @Column(name = "CREACIONUSUARIO")
    public String getCreacionusuario() {
        return creacionusuario;
    }

    public void setCreacionusuario(String creacionusuario) {
        this.creacionusuario = creacionusuario;
    }

    @Basic
    @Column(name = "CREACIONFECHA")
    public Date getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date creacionfecha) {
        this.creacionfecha = creacionfecha;
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
    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsCargainicialdetalle that = (SsCargainicialdetalle) o;

        if (proyectoid != that.proyectoid) return false;
        if (fuenteid != that.fuenteid) return false;
        if (anno != that.anno) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (secuencia != null ? !secuencia.equals(that.secuencia) : that.secuencia != null) return false;
        if (tintero01Valor != null ? !tintero01Valor.equals(that.tintero01Valor) : that.tintero01Valor != null)
            return false;
        if (tintero02Valor != null ? !tintero02Valor.equals(that.tintero02Valor) : that.tintero02Valor != null)
            return false;
        if (tintero03Valor != null ? !tintero03Valor.equals(that.tintero03Valor) : that.tintero03Valor != null)
            return false;
        if (tintero04Valor != null ? !tintero04Valor.equals(that.tintero04Valor) : that.tintero04Valor != null)
            return false;
        if (tintero05Valor != null ? !tintero05Valor.equals(that.tintero05Valor) : that.tintero05Valor != null)
            return false;
        if (tintero06Valor != null ? !tintero06Valor.equals(that.tintero06Valor) : that.tintero06Valor != null)
            return false;
        if (tintero08Valor != null ? !tintero08Valor.equals(that.tintero08Valor) : that.tintero08Valor != null)
            return false;
        if (tintero09Valor != null ? !tintero09Valor.equals(that.tintero09Valor) : that.tintero09Valor != null)
            return false;
        if (tintero07Valor != null ? !tintero07Valor.equals(that.tintero07Valor) : that.tintero07Valor != null)
            return false;
        if (tcadena01Valor != null ? !tcadena01Valor.equals(that.tcadena01Valor) : that.tcadena01Valor != null)
            return false;
        if (tcadena02Valor != null ? !tcadena02Valor.equals(that.tcadena02Valor) : that.tcadena02Valor != null)
            return false;
        if (tcadena03Valor != null ? !tcadena03Valor.equals(that.tcadena03Valor) : that.tcadena03Valor != null)
            return false;
        if (tcadena04Valor != null ? !tcadena04Valor.equals(that.tcadena04Valor) : that.tcadena04Valor != null)
            return false;
        if (tcadena05Valor != null ? !tcadena05Valor.equals(that.tcadena05Valor) : that.tcadena05Valor != null)
            return false;
        if (tcadena06Valor != null ? !tcadena06Valor.equals(that.tcadena06Valor) : that.tcadena06Valor != null)
            return false;
        if (tcadena07Valor != null ? !tcadena07Valor.equals(that.tcadena07Valor) : that.tcadena07Valor != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (creacionusuario != null ? !creacionusuario.equals(that.creacionusuario) : that.creacionusuario != null)
            return false;
        if (creacionfecha != null ? !creacionfecha.equals(that.creacionfecha) : that.creacionfecha != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (observacion != null ? !observacion.equals(that.observacion) : that.observacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (proyectoid ^ (proyectoid >>> 32));
        result = 31 * result + (int) (fuenteid ^ (fuenteid >>> 32));
        result = 31 * result + (int) (anno ^ (anno >>> 32));
        result = 31 * result + (secuencia != null ? secuencia.hashCode() : 0);
        result = 31 * result + (tintero01Valor != null ? tintero01Valor.hashCode() : 0);
        result = 31 * result + (tintero02Valor != null ? tintero02Valor.hashCode() : 0);
        result = 31 * result + (tintero03Valor != null ? tintero03Valor.hashCode() : 0);
        result = 31 * result + (tintero04Valor != null ? tintero04Valor.hashCode() : 0);
        result = 31 * result + (tintero05Valor != null ? tintero05Valor.hashCode() : 0);
        result = 31 * result + (tintero06Valor != null ? tintero06Valor.hashCode() : 0);
        result = 31 * result + (tintero08Valor != null ? tintero08Valor.hashCode() : 0);
        result = 31 * result + (tintero09Valor != null ? tintero09Valor.hashCode() : 0);
        result = 31 * result + (tintero07Valor != null ? tintero07Valor.hashCode() : 0);
        result = 31 * result + (tcadena01Valor != null ? tcadena01Valor.hashCode() : 0);
        result = 31 * result + (tcadena02Valor != null ? tcadena02Valor.hashCode() : 0);
        result = 31 * result + (tcadena03Valor != null ? tcadena03Valor.hashCode() : 0);
        result = 31 * result + (tcadena04Valor != null ? tcadena04Valor.hashCode() : 0);
        result = 31 * result + (tcadena05Valor != null ? tcadena05Valor.hashCode() : 0);
        result = 31 * result + (tcadena06Valor != null ? tcadena06Valor.hashCode() : 0);
        result = 31 * result + (tcadena07Valor != null ? tcadena07Valor.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (observacion != null ? observacion.hashCode() : 0);
        return result;
    }
}
