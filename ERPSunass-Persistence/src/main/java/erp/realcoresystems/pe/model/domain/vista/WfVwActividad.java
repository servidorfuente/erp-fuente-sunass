package erp.realcoresystems.pe.model.domain.vista;

import javax.persistence.*;

import erp.realcoresystems.pe.model.domain.Entidad;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "WF_VW_ACTIVIDAD")
public class WfVwActividad  extends Entidad {
    private Integer indice;
    private Integer idproceso;
    private Integer idversion;
    private Integer idactividad;
    private String codigoproceso;
    private String descripcionproceso;
    private String correoalerta;
    private String medidatiempoescalamiento;
    private Integer tiempoescalamiento;
    private String estadoproceso;
    private String descripcion;
    private String tipoactividad;
    private String tipoaprobacion;
    private String condicionaprobacion;
    private Integer nroaprobadores;
    private String seleccionmultiple;
    private String flagcondiciones;
    private Integer idconexion;
    private Integer idvista;
    private String medidatiempo;
    private Integer tiempopromedio;
    private Integer idobjeto;
    private String estado;
    private Integer usuariocreacion;
    private Date fechacreacion;
    private Integer usuariomodificacion;
    private Date fechamodificacion;
    private Integer idestado;
    private String descripcionestado;
    private String valorretorno;
    private Integer orden;

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

    @Basic
    @Column(name = "IDACTIVIDAD")
    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
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
    @Column(name = "DESCRIPCIONPROCESO")
    public String getDescripcionproceso() {
        return descripcionproceso;
    }

    public void setDescripcionproceso(String descripcionproceso) {
        this.descripcionproceso = descripcionproceso;
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
    @Column(name = "ESTADOPROCESO")
    public String getEstadoproceso() {
        return estadoproceso;
    }

    public void setEstadoproceso(String estadoproceso) {
        this.estadoproceso = estadoproceso;
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
    @Column(name = "TIPOACTIVIDAD")
    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    @Basic
    @Column(name = "TIPOAPROBACION")
    public String getTipoaprobacion() {
        return tipoaprobacion;
    }

    public void setTipoaprobacion(String tipoaprobacion) {
        this.tipoaprobacion = tipoaprobacion;
    }

    @Basic
    @Column(name = "CONDICIONAPROBACION")
    public String getCondicionaprobacion() {
        return condicionaprobacion;
    }

    public void setCondicionaprobacion(String condicionaprobacion) {
        this.condicionaprobacion = condicionaprobacion;
    }

    @Basic
    @Column(name = "NROAPROBADORES")
    public Integer getNroaprobadores() {
        return nroaprobadores;
    }

    public void setNroaprobadores(Integer nroaprobadores) {
        this.nroaprobadores = nroaprobadores;
    }

    @Basic
    @Column(name = "SELECCIONMULTIPLE")
    public String getSeleccionmultiple() {
        return seleccionmultiple;
    }

    public void setSeleccionmultiple(String seleccionmultiple) {
        this.seleccionmultiple = seleccionmultiple;
    }

    @Basic
    @Column(name = "FLAGCONDICIONES")
    public String getFlagcondiciones() {
        return flagcondiciones;
    }

    public void setFlagcondiciones(String flagcondiciones) {
        this.flagcondiciones = flagcondiciones;
    }

    @Basic
    @Column(name = "IDCONEXION")
    public Integer getIdconexion() {
        return idconexion;
    }

    public void setIdconexion(Integer idconexion) {
        this.idconexion = idconexion;
    }

    @Basic
    @Column(name = "IDVISTA")
    public Integer getIdvista() {
        return idvista;
    }

    public void setIdvista(Integer idvista) {
        this.idvista = idvista;
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
    @Column(name = "IDOBJETO")
    public Integer getIdobjeto() {
        return idobjeto;
    }

    public void setIdobjeto(Integer idobjeto) {
        this.idobjeto = idobjeto;
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

    @Basic
    @Column(name = "IDESTADO")
    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    @Basic
    @Column(name = "DESCRIPCIONESTADO")
    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    @Basic
    @Column(name = "VALORRETORNO")
    public String getValorretorno() {
        return valorretorno;
    }

    public void setValorretorno(String valorretorno) {
        this.valorretorno = valorretorno;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
