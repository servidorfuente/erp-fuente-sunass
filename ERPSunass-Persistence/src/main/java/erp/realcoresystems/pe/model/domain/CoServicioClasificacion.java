package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@javax.persistence.Table(name = "CO_SERVICIOCLASIFICACION")
public class CoServicioClasificacion extends Entidad{
	
	private static final long serialVersionUID = 1L;

    private String servicioclasificacion;
	private String afectodescuentoflag;
    private String centrocosto;
    private String clasificacion;
    private String codigoreferencia;
    private String comisionaflag;
    private String companiasocio;
    private String conceptofacturacion;
    private String cuentacontabledolares;
    private String cuentacontablelocal;
    private String cuentadiferidodolares;
    private String cuentadiferidolocal;
    private String cuentadudosadolares;
    private String cuentadudosalocal;
    private String cuentadudosaprovisiondolares;
    private String cuentadudosaprovisionlocal;
    private String descripcioningles;
    private String descripcionlocal;
    private String descuentoeducativoflag;
    private String detraccioncodigo;
    private String diferidoflag;
    private String estado;
    private String flujodecaja;
    private String grupo;
    private String igvexoneradoflag;
    private String interfaseexternaflag;
    private String manejamoraflag;
    private Integer numerodigitos;
    private String proyecto;
    private String reembolsableflag;
    private Double reembolsableporcentaje;
    private String referenciafiscal02;
    private String requierecarreraflag;
    private String servicioacademicoflag;
    private String serviciorelacionado;
    private Date ultimafechamodif;
    private String ultimousuario;
    private String unidadnegocio;
    private Integer servicioclasificacionid;

    
    @Id
    @javax.persistence.Column(name = "SERVICIOCLASIFICACIONID")
    public Integer getServicioclasificacionid() {
		return servicioclasificacionid;
	}    
    
    @Basic
    @javax.persistence.Column(name = "SERVICIOCLASIFICACION")
    public String getServicioclasificacion() {
        return servicioclasificacion;
    }    
    
	
	@Basic
    @javax.persistence.Column(name = "AFECTODESCUENTOFLAG")
    public String getAfectodescuentoflag() {
        return afectodescuentoflag;
    }

    @Basic
    @javax.persistence.Column(name = "CENTROCOSTO")
    public String getCentrocosto() {
        return centrocosto;
    }

    @Basic
    @javax.persistence.Column(name = "CLASIFICACION")
    public String getClasificacion() {
        return clasificacion;
    }

    @Basic
    @javax.persistence.Column(name = "CODIGOREFERENCIA")
    public String getCodigoreferencia() {
        return codigoreferencia;
    }

    @Basic
    @javax.persistence.Column(name = "COMISIONAFLAG")
    public String getComisionaflag() {
        return comisionaflag;
    }

    @Basic
    @javax.persistence.Column(name = "COMPANIASOCIO")
    public String getCompaniasocio() {
        return companiasocio;
    }

    @Basic
    @javax.persistence.Column(name = "CONCEPTOFACTURACION")
    public String getConceptofacturacion() {
        return conceptofacturacion;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTACONTABLEDOLARES")
    public String getCuentacontabledolares() {
        return cuentacontabledolares;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTACONTABLELOCAL")
    public String getCuentacontablelocal() {
        return cuentacontablelocal;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADIFERIDODOLARES")
    public String getCuentadiferidodolares() {
        return cuentadiferidodolares;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADIFERIDOLOCAL")
    public String getCuentadiferidolocal() {
        return cuentadiferidolocal;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADUDOSADOLARES")
    public String getCuentadudosadolares() {
        return cuentadudosadolares;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADUDOSALOCAL")
    public String getCuentadudosalocal() {
        return cuentadudosalocal;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADUDOSAPROVISIONDOLARES")
    public String getCuentadudosaprovisiondolares() {
        return cuentadudosaprovisiondolares;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTADUDOSAPROVISIONLOCAL")
    public String getCuentadudosaprovisionlocal() {
        return cuentadudosaprovisionlocal;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONINGLES")
    public String getDescripcioningles() {
        return descripcioningles;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    @Basic
    @javax.persistence.Column(name = "DESCUENTOEDUCATIVOFLAG")
    public String getDescuentoeducativoflag() {
        return descuentoeducativoflag;
    }

    @Basic
    @javax.persistence.Column(name = "DETRACCIONCODIGO")
    public String getDetraccioncodigo() {
        return detraccioncodigo;
    }

    @Basic
    @javax.persistence.Column(name = "DIFERIDOFLAG")
    public String getDiferidoflag() {
        return diferidoflag;
    }

    @Basic
    @javax.persistence.Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    @Basic
    @javax.persistence.Column(name = "FLUJODECAJA")
    public String getFlujodecaja() {
        return flujodecaja;
    }

    @Basic
    @javax.persistence.Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    @Basic
    @javax.persistence.Column(name = "IGVEXONERADOFLAG")
    public String getIgvexoneradoflag() {
        return igvexoneradoflag;
    }

    @Basic
    @javax.persistence.Column(name = "INTERFASEEXTERNAFLAG")
    public String getInterfaseexternaflag() {
        return interfaseexternaflag;
    }

    @Basic
    @javax.persistence.Column(name = "MANEJAMORAFLAG")
    public String getManejamoraflag() {
        return manejamoraflag;
    }

    @Basic
    @javax.persistence.Column(name = "NUMERODIGITOS")
    public Integer getNumerodigitos() {
        return numerodigitos;
    }

    @Basic
    @javax.persistence.Column(name = "PROYECTO")
    public String getProyecto() {
        return proyecto;
    }

    @Basic
    @javax.persistence.Column(name = "REEMBOLSABLEFLAG")
    public String getReembolsableflag() {
        return reembolsableflag;
    }

    @Basic
    @javax.persistence.Column(name = "REEMBOLSABLEPORCENTAJE")
    public Double getReembolsableporcentaje() {
        return reembolsableporcentaje;
    }

    @Basic
    @javax.persistence.Column(name = "REFERENCIAFISCAL02")
    public String getReferenciafiscal02() {
        return referenciafiscal02;
    }

    @Basic
    @javax.persistence.Column(name = "REQUIERECARRERAFLAG")
    public String getRequierecarreraflag() {
        return requierecarreraflag;
    }

    @Basic
    @javax.persistence.Column(name = "SERVICIOACADEMICOFLAG")
    public String getServicioacademicoflag() {
        return servicioacademicoflag;
    }

    @Basic
    @javax.persistence.Column(name = "SERVICIORELACIONADO")
    public String getServiciorelacionado() {
        return serviciorelacionado;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    @Basic
    @javax.persistence.Column(name = "UNIDADNEGOCIO")
    public String getUnidadnegocio() {
        return unidadnegocio;
    }
    
    public void setServicioclasificacionid(Integer servicioclasificacionid) {
		this.servicioclasificacionid = servicioclasificacionid;
	}
    
    public void setAfectodescuentoflag(String afectodescuentoflag) {
        this.afectodescuentoflag = afectodescuentoflag;
    }

    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setCodigoreferencia(String codigoreferencia) {
        this.codigoreferencia = codigoreferencia;
    }

    public void setComisionaflag(String comisionaflag) {
        this.comisionaflag = comisionaflag;
    }

    public void setCompaniasocio(String companiasocio) {
        this.companiasocio = companiasocio;
    }

    public void setConceptofacturacion(String conceptofacturacion) {
        this.conceptofacturacion = conceptofacturacion;
    }

    public void setCuentacontabledolares(String cuentacontabledolares) {
        this.cuentacontabledolares = cuentacontabledolares;
    }

    public void setCuentacontablelocal(String cuentacontablelocal) {
        this.cuentacontablelocal = cuentacontablelocal;
    }

    public void setCuentadiferidodolares(String cuentadiferidodolares) {
        this.cuentadiferidodolares = cuentadiferidodolares;
    }

    public void setCuentadiferidolocal(String cuentadiferidolocal) {
        this.cuentadiferidolocal = cuentadiferidolocal;
    }

    public void setCuentadudosadolares(String cuentadudosadolares) {
        this.cuentadudosadolares = cuentadudosadolares;
    }

    public void setCuentadudosalocal(String cuentadudosalocal) {
        this.cuentadudosalocal = cuentadudosalocal;
    }

    public void setCuentadudosaprovisiondolares(String cuentadudosaprovisiondolares) {
        this.cuentadudosaprovisiondolares = cuentadudosaprovisiondolares;
    }

    public void setCuentadudosaprovisionlocal(String cuentadudosaprovisionlocal) {
        this.cuentadudosaprovisionlocal = cuentadudosaprovisionlocal;
    }

    public void setDescripcioningles(String descripcioningles) {
        this.descripcioningles = descripcioningles;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    public void setDescuentoeducativoflag(String descuentoeducativoflag) {
        this.descuentoeducativoflag = descuentoeducativoflag;
    }

    public void setDetraccioncodigo(String detraccioncodigo) {
        this.detraccioncodigo = detraccioncodigo;
    }

    public void setDiferidoflag(String diferidoflag) {
        this.diferidoflag = diferidoflag;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFlujodecaja(String flujodecaja) {
        this.flujodecaja = flujodecaja;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setIgvexoneradoflag(String igvexoneradoflag) {
        this.igvexoneradoflag = igvexoneradoflag;
    }

    public void setInterfaseexternaflag(String interfaseexternaflag) {
        this.interfaseexternaflag = interfaseexternaflag;
    }

    public void setManejamoraflag(String manejamoraflag) {
        this.manejamoraflag = manejamoraflag;
    }

    public void setNumerodigitos(Integer numerodigitos) {
        this.numerodigitos = numerodigitos;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public void setReembolsableflag(String reembolsableflag) {
        this.reembolsableflag = reembolsableflag;
    }

    public void setReembolsableporcentaje(Double reembolsableporcentaje) {
        this.reembolsableporcentaje = reembolsableporcentaje;
    }

    public void setReferenciafiscal02(String referenciafiscal02) {
        this.referenciafiscal02 = referenciafiscal02;
    }

    public void setRequierecarreraflag(String requierecarreraflag) {
        this.requierecarreraflag = requierecarreraflag;
    }

    public void setServicioacademicoflag(String servicioacademicoflag) {
        this.servicioacademicoflag = servicioacademicoflag;
    }

    public void setServicioclasificacion(String servicioclasificacion) {
        this.servicioclasificacion = servicioclasificacion;
    }

    public void setServiciorelacionado(String serviciorelacionado) {
        this.serviciorelacionado = serviciorelacionado;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    public void setUnidadnegocio(String unidadnegocio) {
        this.unidadnegocio = unidadnegocio;
    }
}
