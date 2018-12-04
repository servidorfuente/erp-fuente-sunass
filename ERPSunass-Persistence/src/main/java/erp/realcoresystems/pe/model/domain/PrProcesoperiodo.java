package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PR_PROCESOPERIODO" )
@IdClass(PrProcesoperiodoPK.class)
public class PrProcesoperiodo  extends Entidad {
    private String companiasocio;
    private String periodo;
    private String tipoplanilla;
    private String tipoproceso;
    private String flagprocesado;
    private String flagperiodomensual;
    private Integer generador;
    private Date fechadesde;
    private Date fechahasta;
    private Date fechaproceso;
    private Date fechapago;
    private String estado;
    private String flagaprobado;
    private Date fechaaprobacion;
    private Integer aprobadopor;
    private String nrovoucher;
    private Date fechacierre;
    private Integer cerradopor;
    private String ultimousuario;
    private Date ultimafechamodif;
    private Integer numerocts;

    @Id
    @Column(name = "COMPANIASOCIO")
    public String getCompaniasocio() {
        return companiasocio;
    }

    public void setCompaniasocio(String companiasocio) {
        this.companiasocio = companiasocio;
    }

    @Id
    @Column(name = "PERIODO")
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Id
    @Column(name = "TIPOPLANILLA")
    public String getTipoplanilla() {
        return tipoplanilla;
    }

    public void setTipoplanilla(String tipoplanilla) {
        this.tipoplanilla = tipoplanilla;
    }

    @Id
    @Column(name = "TIPOPROCESO")
    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    @Basic
    @Column(name = "FLAGPROCESADO")
    public String getFlagprocesado() {
        return flagprocesado;
    }

    public void setFlagprocesado(String flagprocesado) {
        this.flagprocesado = flagprocesado;
    }

    @Basic
    @Column(name = "FLAGPERIODOMENSUAL")
    public String getFlagperiodomensual() {
        return flagperiodomensual;
    }

    public void setFlagperiodomensual(String flagperiodomensual) {
        this.flagperiodomensual = flagperiodomensual;
    }

    @Basic
    @Column(name = "GENERADOR")
    public Integer getGenerador() {
        return generador;
    }

    public void setGenerador(Integer generador) {
        this.generador = generador;
    }

    @Basic
    @Column(name = "FECHADESDE")
    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    @Basic
    @Column(name = "FECHAHASTA")
    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    @Basic
    @Column(name = "FECHAPROCESO")
    public Date getFechaproceso() {
        return fechaproceso;
    }

    public void setFechaproceso(Date fechaproceso) {
        this.fechaproceso = fechaproceso;
    }

    @Basic
    @Column(name = "FECHAPAGO")
    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
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
    @Column(name = "FLAGAPROBADO")
    public String getFlagaprobado() {
        return flagaprobado;
    }

    public void setFlagaprobado(String flagaprobado) {
        this.flagaprobado = flagaprobado;
    }

    @Basic
    @Column(name = "FECHAAPROBACION")
    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    @Basic
    @Column(name = "APROBADOPOR")
    public Integer getAprobadopor() {
        return aprobadopor;
    }

    public void setAprobadopor(Integer aprobadopor) {
        this.aprobadopor = aprobadopor;
    }

    @Basic
    @Column(name = "NROVOUCHER")
    public String getNrovoucher() {
        return nrovoucher;
    }

    public void setNrovoucher(String nrovoucher) {
        this.nrovoucher = nrovoucher;
    }

    @Basic
    @Column(name = "FECHACIERRE")
    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    @Basic
    @Column(name = "CERRADOPOR")
    public Integer getCerradopor() {
        return cerradopor;
    }

    public void setCerradopor(Integer cerradopor) {
        this.cerradopor = cerradopor;
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
    @Column(name = "NUMEROCTS")
    public Integer getNumerocts() {
        return numerocts;
    }

    public void setNumerocts(Integer numerocts) {
        this.numerocts = numerocts;
    }


}
