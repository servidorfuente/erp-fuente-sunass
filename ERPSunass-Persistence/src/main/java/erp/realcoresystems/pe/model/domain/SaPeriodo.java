package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Table;

import erp.realcoresystems.pe.model.util.BooleanToIntegerConverter;

import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_PERIODO")
public class SaPeriodo  extends Entidad{
	
	//private static final long serialVersionUID = 1L;
	private Integer moemestudioid;
    private Integer perconsideradpi;
    private String perdescripcion;
    private Integer perestado;
    private Date perfechaacta;
    private Date perfechacreacion;
    private Date perfechafin;
    private Date perfechainicio;
    private boolean perflagconsideradpi;
    private Integer perflaggrupo;
    private Integer perflagjerarquia;
    private boolean perflagordinario;
    private String peripcreacion;
    private String perperiodo;
    private Integer perperiodoid;
    private Integer perperiodoidgrupo;
    private String perperiodoinicio;
    private Date perultimafechamodif;
    private String perultimoip;
    private Integer perultimousuario;
    private Integer perusuariocreacion;
    private Integer sedsedegrupoid;
    private Integer uneunegocioid;

    @Basic
    @Column(name = "MOEMESTUDIOID")
    public Integer getMoemestudioid() {
        return moemestudioid;
    }

    @Basic
    @Column(name = "PERCONSIDERADPI")
    public Integer getPerconsideradpi() {
        return perconsideradpi;
    }

    @Basic
    @Column(name = "PERDESCRIPCION")
    public String getPerdescripcion() {
        return perdescripcion;
    }

    @Basic
    @Column(name = "PERESTADO")
    public Integer getPerestado() {
        return perestado;
    }

    @Basic
    @Column(name = "PERFECHAACTA")
    public Date getPerfechaacta() {
        return perfechaacta;
    }

    @Basic
    @Column(name = "PERFECHACREACION")
    public Date getPerfechacreacion() {
        return perfechacreacion;
    }

    @Basic
    @Column(name = "PERFECHAFIN")
    public Date getPerfechafin() {
        return perfechafin;
    }

    @Basic
    @Column(name = "PERFECHAINICIO")
    public Date getPerfechainicio() {
        return perfechainicio;
    }

    @Basic
    @Column(name = "PERFLAGCONSIDERADPI")
    @Convert(converter = BooleanToIntegerConverter.class)
    public boolean getPerflagconsideradpi() {
        return perflagconsideradpi;
    }

    @Basic
    @Column(name = "PERFLAGGRUPO")
    public Integer getPerflaggrupo() {
        return perflaggrupo;
    }

    @Basic
    @Column(name = "PERFLAGJERARQUIA")
    public Integer getPerflagjerarquia() {
        return perflagjerarquia;
    }

    @Basic
    @Column(name = "PERFLAGORDINARIO")
    @Convert(converter = BooleanToIntegerConverter.class)
    public boolean getPerflagordinario() {
        return perflagordinario;
    }

    @Basic
    @Column(name = "PERIPCREACION")
    public String getPeripcreacion() {
        return peripcreacion;
    }

    @Basic
    @Column(name = "PERPERIODO")
    public String getPerperiodo() {
        return perperiodo;
    }

    @Id
    @Column(name = "PERPERIODOID")
    public Integer getPerperiodoid() {
        return perperiodoid;
    }

    @Basic
    @Column(name = "PERPERIODOIDGRUPO")
    public Integer getPerperiodoidgrupo() {
        return perperiodoidgrupo;
    }

    @Basic
    @Column(name = "PERPERIODOINICIO")
    public String getPerperiodoinicio() {
        return perperiodoinicio;
    }

    @Basic
    @Column(name = "PERULTIMAFECHAMODIF")
    public Date getPerultimafechamodif() {
        return perultimafechamodif;
    }

    @Basic
    @Column(name = "PERULTIMOIP")
    public String getPerultimoip() {
        return perultimoip;
    }

    @Basic
    @Column(name = "PERULTIMOUSUARIO")
    public Integer getPerultimousuario() {
        return perultimousuario;
    }

    @Basic
    @Column(name = "PERUSUARIOCREACION")
    public Integer getPerusuariocreacion() {
        return perusuariocreacion;
    }

    @Basic
    @Column(name = "SEDSEDEGRUPOID")
    public Integer getSedsedegrupoid() {
        return sedsedegrupoid;
    }

    @Basic
    @Column(name = "UNEUNEGOCIOID")
    public Integer getUneunegocioid() {
        return uneunegocioid;
    }

    public void setMoemestudioid(Integer moemestudioid) {
        this.moemestudioid = moemestudioid;
    }

    public void setPerconsideradpi(Integer perconsideradpi) {
        this.perconsideradpi = perconsideradpi;
    }

    public void setPerdescripcion(String perdescripcion) {
        this.perdescripcion = perdescripcion;
    }

    public void setPerestado(Integer perestado) {
        this.perestado = perestado;
    }

    public void setPerfechaacta(Date perfechaacta) {
        this.perfechaacta = perfechaacta;
    }

    public void setPerfechacreacion(Date perfechacreacion) {
        this.perfechacreacion = perfechacreacion;
    }

    public void setPerfechafin(Date perfechafin) {
        this.perfechafin = perfechafin;
    }

    public void setPerfechainicio(Date perfechainicio) {
        this.perfechainicio = perfechainicio;
    }

    public void setPerflagconsideradpi(boolean perflagconsideradpi) {
        this.perflagconsideradpi = perflagconsideradpi;
    }

    public void setPerflaggrupo(Integer perflaggrupo) {
        this.perflaggrupo = perflaggrupo;
    }

    public void setPerflagjerarquia(Integer perflagjerarquia) {
        this.perflagjerarquia = perflagjerarquia;
    }

    public void setPerflagordinario(boolean perflagordinario) {
        this.perflagordinario = perflagordinario;
    }

    public void setPeripcreacion(String peripcreacion) {
        this.peripcreacion = peripcreacion;
    }

    public void setPerperiodo(String perperiodo) {
        this.perperiodo = perperiodo;
    }

    public void setPerperiodoid(Integer perperiodoid) {
        this.perperiodoid = perperiodoid;
    }

    public void setPerperiodoidgrupo(Integer perperiodoidgrupo) {
        this.perperiodoidgrupo = perperiodoidgrupo;
    }

    public void setPerperiodoinicio(String perperiodoinicio) {
        this.perperiodoinicio = perperiodoinicio;
    }

    public void setPerultimafechamodif(Date perultimafechamodif) {
        this.perultimafechamodif = perultimafechamodif;
    }

    public void setPerultimoip(String perultimoip) {
        this.perultimoip = perultimoip;
    }

    public void setPerultimousuario(Integer perultimousuario) {
        this.perultimousuario = perultimousuario;
    }

    public void setPerusuariocreacion(Integer perusuariocreacion) {
        this.perusuariocreacion = perusuariocreacion;
    }

    public void setSedsedegrupoid(Integer sedsedegrupoid) {
        this.sedsedegrupoid = sedsedegrupoid;
    }

    public void setUneunegocioid(Integer uneunegocioid) {
        this.uneunegocioid = uneunegocioid;
    }
}
