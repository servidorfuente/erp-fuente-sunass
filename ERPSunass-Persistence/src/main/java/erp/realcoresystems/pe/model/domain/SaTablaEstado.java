package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SA_TABLAESTADO")
public class SaTablaEstado extends Entidad{
	
	private static final long serialVersionUID = 1L;
	private Integer tabtablaid;
    private Integer tbsestadoenlaceid;
    private String tbsnombre;
    private String tbsdescripcion;
    private Integer tbsestado;/** 1 = INDICA ACTIVO **/
    private Integer tbsusuariocreacion;
    private Date tbsfechacreacion;
    private String tbsipcreacion;
    private Integer tbsultimousuario;
    private Date tbsultimafechamodif;
    private String tbsultimoip;
    private SaTablas saTablaByTabtablaid;
    private Set<SaTablaRazonEstado> saTablarazonestados;

    @Column(name = "TABTABLAID")
    public Integer getTabtablaid() {
        return tabtablaid;
    }

    public void setTabtablaid(Integer tabtablaid) {
        this.tabtablaid = tabtablaid;
    }

    @Id
    @Column(name = "TBSESTADOENLACEID")
    public Integer getTbsestadoenlaceid() {
        return tbsestadoenlaceid;
    }

    public void setTbsestadoenlaceid(Integer tbsestadoenlaceid) {
        this.tbsestadoenlaceid = tbsestadoenlaceid;
    }

    @Basic
    @Column(name = "TBSNOMBRE")
    public String getTbsnombre() {
        return tbsnombre;
    }

    public void setTbsnombre(String tbsnombre) {
        this.tbsnombre = tbsnombre;
    }

    @Basic
    @Column(name = "TBSDESCRIPCION")
    public String getTbsdescripcion() {
        return tbsdescripcion;
    }

    public void setTbsdescripcion(String tbsdescripcion) {
        this.tbsdescripcion = tbsdescripcion;
    }

    @Basic
    @Column(name = "TBSESTADO")
    public Integer getTbsestado() {
        return tbsestado;
    }

    public void setTbsestado(Integer tbsestado) {
        this.tbsestado = tbsestado;
    }

    @Basic
    @Column(name = "TBSUSUARIOCREACION")
    public Integer getTbsusuariocreacion() {
        return tbsusuariocreacion;
    }

    public void setTbsusuariocreacion(Integer tbsusuariocreacion) {
        this.tbsusuariocreacion = tbsusuariocreacion;
    }

    @Basic
    @Column(name = "TBSFECHACREACION")
    public Date getTbsfechacreacion() {
        return tbsfechacreacion;
    }

    public void setTbsfechacreacion(Date tbsfechacreacion) {
        this.tbsfechacreacion = tbsfechacreacion;
    }

    @Basic
    @Column(name = "TBSIPCREACION")
    public String getTbsipcreacion() {
        return tbsipcreacion;
    }

    public void setTbsipcreacion(String tbsipcreacion) {
        this.tbsipcreacion = tbsipcreacion;
    }

    @Basic
    @Column(name = "TBSULTIMOUSUARIO")
    public Integer getTbsultimousuario() {
        return tbsultimousuario;
    }

    public void setTbsultimousuario(Integer tbsultimousuario) {
        this.tbsultimousuario = tbsultimousuario;
    }

    @Basic
    @Column(name = "TBSULTIMAFECHAMODIF")
    public Date getTbsultimafechamodif() {
        return tbsultimafechamodif;
    }

    public void setTbsultimafechamodif(Date tbsultimafechamodif) {
        this.tbsultimafechamodif = tbsultimafechamodif;
    }

    @Basic
    @Column(name = "TBSULTIMOIP")
    public String getTbsultimoip() {
        return tbsultimoip;
    }

    public void setTbsultimoip(String tbsultimoip) {
        this.tbsultimoip = tbsultimoip;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "TABTABLAID", referencedColumnName = "IDTABLA", nullable = true, insertable=false, updatable=false)
    public SaTablas getSaTablaByTabtablaid() {
        return saTablaByTabtablaid;
    }

    public void setSaTablaByTabtablaid(SaTablas saTablaByTabtablaid) {
        this.saTablaByTabtablaid = saTablaByTabtablaid;
    }

    @OneToMany(mappedBy = "saTablaestado",fetch=FetchType.LAZY)
    public Set<SaTablaRazonEstado> getSaTablarazonestados() {
        return saTablarazonestados;
    }

    public void setSaTablarazonestados(Set<SaTablaRazonEstado> saTablarazonestados) {
        this.saTablarazonestados = saTablarazonestados;
    }
}
