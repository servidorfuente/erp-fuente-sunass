package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.util.Date;

@Entity
@Table(name = "WF_VW_PROCESO")
public class WfVwProceso extends Entidad {
    private Integer indice;
    private Integer idproceso;
    private Integer idaplicacion;
    private String codigoproceso;
    private String descripcion;
    private String correoalerta;
    private String medidatiempoescalamiento;
    private Integer tiempoescalamiento;
    private String estado;
    private String tipoproceso;
    private String flaginicio;
    private String flagverseguimiento;
    private String flagtipoproceso;
    private Integer flagnuevotramite;
    private Integer idversion;
    private Integer idformulario;
    private String esactual;
    private String enproduccion;
    private String flagdependencia;
    private Integer idprocesopadre;
    private Integer idversionpadre;
    private String medidatiempo;
    private Integer tiempopromedio;
    private String medidatiempoproc;
    private Integer tiempoproceso;
    private String flaghabilitarcopias;
    private String emailalertatiempoproc;
    private String estadoversion;
    private Integer usuariocreacion;
    private Date fechacreacion;
    private Integer usuariomodificacion;
    private Date fechamodificacion;

    @Id
    @Basic
    @Column(name = "INDICE")
    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    @Basic
    @Column(name = "IDPROCESO")
    public Integer getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(Integer idproceso) {
        this.idproceso = idproceso;
    }

    @Basic
    @Column(name = "IDVERSION")
    public Integer getIdversion() {
        return idversion;
    }

    public void setIdversion(Integer idversion) {
        this.idversion = idversion;
    }


    public void setIdformulario(Integer idformulario) {
        this.idformulario = idformulario;
    }

    @Basic
    @Column(name = "IDAPLICACION")
    public Integer getIdaplicacion() {
        return idaplicacion;
    }

    public void setIdaplicacion(Integer idaplicacion) {
        this.idaplicacion = idaplicacion;
    }

    @Basic
    @Column(name = "CODIGOPROCESO")
    public String getCodigoproceso() {
        return codigoproceso;
    }

    public void setCodigoproceso(String codigoproceso) {
        this.codigoproceso = codigoproceso;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "CORREOALERTA")
    public String getCorreoalerta() {
        return correoalerta;
    }

    public void setCorreoalerta(String correoalerta) {
        this.correoalerta = correoalerta;
    }

    @Basic
    @Column(name = "MEDIDATIEMPOESCALAMIENTO")
    public String getMedidatiempoescalamiento() {
        return medidatiempoescalamiento;
    }

    public void setMedidatiempoescalamiento(String medidatiempoescalamiento) {
        this.medidatiempoescalamiento = medidatiempoescalamiento;
    }

    @Basic
    @Column(name = "TIEMPOESCALAMIENTO")
    public Integer getTiempoescalamiento() {
        return tiempoescalamiento;
    }

    public void setTiempoescalamiento(Integer tiempoescalamiento) {
        this.tiempoescalamiento = tiempoescalamiento;
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
    @Column(name = "TIPOPROCESO")
    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    @Basic
    @Column(name = "FLAGINICIO")
    public String getFlaginicio() {
        return flaginicio;
    }

    public void setFlaginicio(String flaginicio) {
        this.flaginicio = flaginicio;
    }

    @Basic
    @Column(name = "FLAGVERSEGUIMIENTO")
    public String getFlagverseguimiento() {
        return flagverseguimiento;
    }

    public void setFlagverseguimiento(String flagverseguimiento) {
        this.flagverseguimiento = flagverseguimiento;
    }

    @Basic
    @Column(name = "FLAGTIPOPROCESO")
    public String getFlagtipoproceso() {
        return flagtipoproceso;
    }

    public void setFlagtipoproceso(String flagtipoproceso) {
        this.flagtipoproceso = flagtipoproceso;
    }

    @Basic
    @Column(name = "FLAGNUEVOTRAMITE")
    public Integer getFlagnuevotramite() {
        return flagnuevotramite;
    }

    public void setFlagnuevotramite(Integer flagnuevotramite) {
        this.flagnuevotramite = flagnuevotramite;
    }


    @Basic
    @Column(name = "ESACTUAL")
    public String getEsactual() {
        return esactual;
    }

    public void setEsactual(String esactual) {
        this.esactual = esactual;
    }

    @Basic
    @Column(name = "ENPRODUCCION")
    public String getEnproduccion() {
        return enproduccion;
    }

    public void setEnproduccion(String enproduccion) {
        this.enproduccion = enproduccion;
    }

    @Basic
    @Column(name = "FLAGDEPENDENCIA")
    public String getFlagdependencia() {
        return flagdependencia;
    }

    public void setFlagdependencia(String flagdependencia) {
        this.flagdependencia = flagdependencia;
    }

    @Basic
    @Column(name = "IDPROCESOPADRE")
    public Integer getIdprocesopadre() {
        return idprocesopadre;
    }

    public void setIdprocesopadre(Integer idprocesopadre) {
        this.idprocesopadre = idprocesopadre;
    }

    @Basic
    @Column(name = "IDVERSIONPADRE")
    public Integer getIdversionpadre() {
        return idversionpadre;
    }

    public void setIdversionpadre(Integer idversionpadre) {
        this.idversionpadre = idversionpadre;
    }

    @Basic
    @Column(name = "MEDIDATIEMPO")
    public String getMedidatiempo() {
        return medidatiempo;
    }

    public void setMedidatiempo(String medidatiempo) {
        this.medidatiempo = medidatiempo;
    }

    @Basic
    @Column(name = "TIEMPOPROMEDIO")
    public Integer getTiempopromedio() {
        return tiempopromedio;
    }

    public void setTiempopromedio(Integer tiempopromedio) {
        this.tiempopromedio = tiempopromedio;
    }

    @Basic
    @Column(name = "MEDIDATIEMPOPROC")
    public String getMedidatiempoproc() {
        return medidatiempoproc;
    }

    public void setMedidatiempoproc(String medidatiempoproc) {
        this.medidatiempoproc = medidatiempoproc;
    }

    @Basic
    @Column(name = "TIEMPOPROCESO")
    public Integer getTiempoproceso() {
        return tiempoproceso;
    }

    public void setTiempoproceso(Integer tiempoproceso) {
        this.tiempoproceso = tiempoproceso;
    }

    @Basic
    @Column(name = "FLAGHABILITARCOPIAS")
    public String getFlaghabilitarcopias() {
        return flaghabilitarcopias;
    }

    public void setFlaghabilitarcopias(String flaghabilitarcopias) {
        this.flaghabilitarcopias = flaghabilitarcopias;
    }

    @Basic
    @Column(name = "EMAILALERTATIEMPOPROC")
    public String getEmailalertatiempoproc() {
        return emailalertatiempoproc;
    }

    public void setEmailalertatiempoproc(String emailalertatiempoproc) {
        this.emailalertatiempoproc = emailalertatiempoproc;
    }

    @Basic
    @Column(name = "ESTADOVERSION")
    public String getEstadoversion() {
        return estadoversion;
    }

    public void setEstadoversion(String estadoversion) {
        this.estadoversion = estadoversion;
    }

    @Basic
    @Column(name = "USUARIOCREACION")
    public Integer getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(Integer usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    @Basic
    @Column(name = "FECHACREACION")
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "USUARIOMODIFICACION")
    public Integer getUsuariomodificacion() {
        return usuariomodificacion;
    }

    public void setUsuariomodificacion(Integer usuariomodificacion) {
        this.usuariomodificacion = usuariomodificacion;
    }

    @Basic
    @Column(name = "FECHAMODIFICACION")
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

}
