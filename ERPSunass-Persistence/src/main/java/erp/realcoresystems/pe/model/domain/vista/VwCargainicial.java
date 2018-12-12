package erp.realcoresystems.pe.model.domain.vista;

import erp.realcoresystems.pe.model.domain.Entidad;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date ;

@Entity
@Table(name = "VW_CARGAINICIAL" )
public class VwCargainicial  extends Entidad {
    private String companyowner;
    private String englishdescription;
    private String sucursal;
    private String descripcionlocal;
    private Integer proyectoid;
    private String prdescripcion;
    private Integer fuenteid;
    private String descripcion;
    private Integer anno;
    private Integer cargainicialid;
    private Integer sectorid;
    private Integer mes;
    private String fuobservaciones;
    private String fuusaldecaptacoin;
    private String fupacidadproduccion;
    private String futipofuente;
    private Date  fechainformacion;
    private String direccion;
    private String estado;
    private String sedescripcion;
    private String ubigeo;
    private BigDecimal volumenM3;
    private BigDecimal  capacActualLps;
    private BigDecimal  capacMaximaLps;
    private String antiguedadAos;
    private String estadofisico;
    private String tipodeenergia;
    private String potenciamotorHp;
    private String potenciabombaHp;
    private String cuentaconfoculadorDFT;
    private String diametroPulg;
    private String longitudMts;
    private String tipodetuberia;
    private String anchoMts;
    private String primariaAreaHaUnidad;
    private String secundariaAreaHaUnidad;
    private String terciariaAreaHaUnidad;
    private String unidades;
    private String alturaMts;
    private String presionmaximaMca;
    private BigDecimal  caudalurbanoLps;
    private BigDecimal  caudalruralLps;
    private BigDecimal  caudalcaptadodirectoLps;
    private BigDecimal  caudalcaptadobombeoLps;

    private BigDecimal ptaresprima2Areatotal;
    private BigDecimal ptaressecun2Areatotal;
    private BigDecimal ptaresterce2Areatotal;
    private BigDecimal ptaresprima2Cantidad;
    private BigDecimal ptaressecun2Canbtidad;
    private BigDecimal ptaresterce2Cantidad;
    private BigDecimal ptareslontiudmts3;
    private BigDecimal ptaresanchodmts4;
    private BigDecimal ptarescantidadunit5;
    private BigDecimal ptaresdiametropulg6;
    private BigDecimal ptaresalturamts7;
    private BigDecimal ptarescapacactualips;
    private BigDecimal ptarescapacmaximaips;


    private String potenciaHp;
    private String observacion;
    private String documentofuente;
    private String creacionusuario;
    private Date  creacionfecha;
    private String ultimousuario;
    private Date  ultimafechamodif;
    private Integer  estadodocumento;
    private String  subTipoInfraestructura;

    @Id
    @Basic
    @Column(name = "CARGAINICIALID")
    public Integer getCargainicialid() {
        return cargainicialid;
    }

    public void setCargainicialid(Integer cargainicialid) {
        this.cargainicialid = cargainicialid;
    }

    @Basic
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Basic
    @Column(name = "ENGLISHDESCRIPTION")
    public String getEnglishdescription() {
        return englishdescription;
    }

    public void setEnglishdescription(String englishdescription) {
        this.englishdescription = englishdescription;
    }

    @Basic
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Basic
    @Column(name = "DESCRIPCIONLOCAL")
    public String getDescripcionlocal() {
        return descripcionlocal;
    }

    public void setDescripcionlocal(String descripcionlocal) {
        this.descripcionlocal = descripcionlocal;
    }

    @Basic
    @Column(name = "PROYECTOID")
    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    @Basic
    @Column(name = "PRDESCRIPCION")
    public String getPrdescripcion() {
        return prdescripcion;
    }

    public void setPrdescripcion(String prdescripcion) {
        this.prdescripcion = prdescripcion;
    }

    @Basic
    @Column(name = "FUENTEID")
    public Integer getFuenteid() {
        return fuenteid;
    }

    public void setFuenteid(Integer fuenteid) {
        this.fuenteid = fuenteid;
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
    @Column(name = "ANNO")
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Basic
    @Column(name = "SECTORID")
    public Integer getSectorid() {
        return sectorid;
    }

    public void setSectorid(Integer sectorid) {
        this.sectorid = sectorid;
    }

    @Basic
    @Column(name = "MES")
    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "FUOBSERVACIONES")
    public String getFuobservaciones() {
        return fuobservaciones;
    }

    public void setFuobservaciones(String fuobservaciones) {
        this.fuobservaciones = fuobservaciones;
    }

    @Basic
    @Column(name = "FUUSALDECAPTACOIN")
    public String getFuusaldecaptacoin() {
        return fuusaldecaptacoin;
    }

    public void setFuusaldecaptacoin(String fuusaldecaptacoin) {
        this.fuusaldecaptacoin = fuusaldecaptacoin;
    }

    @Basic
    @Column(name = "FUPACIDADPRODUCCION")
    public String getFupacidadproduccion() {
        return fupacidadproduccion;
    }

    public void setFupacidadproduccion(String fupacidadproduccion) {
        this.fupacidadproduccion = fupacidadproduccion;
    }

    @Basic
    @Column(name = "FUTIPOFUENTE")
    public String getFutipofuente() {
        return futipofuente;
    }

    public void setFutipofuente(String futipofuente) {
        this.futipofuente = futipofuente;
    }

    @Basic
    @Column(name = "FECHAINFORMACION")
    public Date  getFechainformacion() {
        return fechainformacion;
    }

    public void setFechainformacion(Date  fechainformacion) {
        this.fechainformacion = fechainformacion;
    }

    @Basic
    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    @Column(name = "SEDESCRIPCION")
    public String getSedescripcion() {
        return sedescripcion;
    }

    public void setSedescripcion(String sedescripcion) {
        this.sedescripcion = sedescripcion;
    }

    @Basic
    @Column(name = "UBIGEO")
    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Basic
    @Column(name = "VOLUMEN_M3")
    public BigDecimal  getVolumenM3() {
        return volumenM3;
    }

    public void setVolumenM3(BigDecimal  volumenM3) {
        this.volumenM3 = volumenM3;
    }

    @Basic
    @Column(name = "CAPAC_ACTUAL_LPS")
    public BigDecimal  getCapacActualLps() {
        return capacActualLps;
    }

    public void setCapacActualLps(BigDecimal  capacActualLps) {
        this.capacActualLps = capacActualLps;
    }


    @Basic
    @Column(name = "CAPAC_MAXIMA_LPS")
    public BigDecimal  getCapacMaximaLps() {
        return capacMaximaLps;
    }

    public void setCapacMaximaLps(BigDecimal  capacMaximaLps) {
        this.capacMaximaLps = capacMaximaLps;
    }




    @Basic
    @Column(name = "PTARESPRIMA2AREATOTAL")
    public BigDecimal getPtaresprima2Areatotal() {
        return ptaresprima2Areatotal;
    }

    public void setPtaresprima2Areatotal(BigDecimal ptaresprima2Areatotal) {
        this.ptaresprima2Areatotal = ptaresprima2Areatotal;
    }

    @Basic
    @Column(name = "PTARESSECUN2AREATOTAL")
    public BigDecimal getPtaressecun2Areatotal() {
        return ptaressecun2Areatotal;
    }

    public void setPtaressecun2Areatotal(BigDecimal ptaressecun2Areatotal) {
        this.ptaressecun2Areatotal = ptaressecun2Areatotal;
    }

    @Basic
    @Column(name = "PTARESTERCE2AREATOTAL")
    public BigDecimal getPtaresterce2Areatotal() {
        return ptaresterce2Areatotal;
    }

    public void setPtaresterce2Areatotal(BigDecimal ptaresterce2Areatotal) {
        this.ptaresterce2Areatotal = ptaresterce2Areatotal;
    }

    @Basic
    @Column(name = "PTARESPRIMA2CANTIDAD")
    public BigDecimal getPtaresprima2Cantidad() {
        return ptaresprima2Cantidad;
    }

    public void setPtaresprima2Cantidad(BigDecimal ptaresprima2Cantidad) {
        this.ptaresprima2Cantidad = ptaresprima2Cantidad;
    }

    @Basic
    @Column(name = "PTARESSECUN2CANBTIDAD")
    public BigDecimal getPtaressecun2Canbtidad() {
        return ptaressecun2Canbtidad;
    }

    public void setPtaressecun2Canbtidad(BigDecimal ptaressecun2Canbtidad) {
        this.ptaressecun2Canbtidad = ptaressecun2Canbtidad;
    }

    @Basic
    @Column(name = "PTARESTERCE2CANTIDAD")
    public BigDecimal getPtaresterce2Cantidad() {
        return ptaresterce2Cantidad;
    }

    public void setPtaresterce2Cantidad(BigDecimal ptaresterce2Cantidad) {
        this.ptaresterce2Cantidad = ptaresterce2Cantidad;
    }

    @Basic
    @Column(name = "PTARESLONTIUDMTS3")
    public BigDecimal getPtareslontiudmts3() {
        return ptareslontiudmts3;
    }

    public void setPtareslontiudmts3(BigDecimal ptareslontiudmts3) {
        this.ptareslontiudmts3 = ptareslontiudmts3;
    }

    @Basic
    @Column(name = "PTARESANCHODMTS4")
    public BigDecimal getPtaresanchodmts4() {
        return ptaresanchodmts4;
    }

    public void setPtaresanchodmts4(BigDecimal ptaresanchodmts4) {
        this.ptaresanchodmts4 = ptaresanchodmts4;
    }

    @Basic
    @Column(name = "PTARESCANTIDADUNIT5")
    public BigDecimal getPtarescantidadunit5() {
        return ptarescantidadunit5;
    }

    public void setPtarescantidadunit5(BigDecimal ptarescantidadunit5) {
        this.ptarescantidadunit5 = ptarescantidadunit5;
    }

    @Basic
    @Column(name = "PTARESDIAMETROPULG6")
    public BigDecimal getPtaresdiametropulg6() {
        return ptaresdiametropulg6;
    }

    public void setPtaresdiametropulg6(BigDecimal ptaresdiametropulg6) {
        this.ptaresdiametropulg6 = ptaresdiametropulg6;
    }

    @Basic
    @Column(name = "PTARESALTURAMTS7")
    public BigDecimal getPtaresalturamts7() {
        return ptaresalturamts7;
    }

    public void setPtaresalturamts7(BigDecimal ptaresalturamts7) {
        this.ptaresalturamts7 = ptaresalturamts7;
    }

    @Basic
    @Column(name = "PTARESCAPACACTUALIPS")
    public BigDecimal getPtarescapacactualips() {
        return ptarescapacactualips;
    }

    public void setPtarescapacactualips(BigDecimal ptarescapacactualips) {
        this.ptarescapacactualips = ptarescapacactualips;
    }

    @Basic
    @Column(name = "PTARESCAPACMAXIMAIPS")
    public BigDecimal getPtarescapacmaximaips() {
        return ptarescapacmaximaips;
    }

    public void setPtarescapacmaximaips(BigDecimal ptarescapacmaximaips) {
        this.ptarescapacmaximaips = ptarescapacmaximaips;
    }


    @Basic
    @Column(name = "ANTIGUEDAD_AOS")
    public String getAntiguedadAos() {
        return antiguedadAos;
    }

    public void setAntiguedadAos(String antiguedadAos) {
        this.antiguedadAos = antiguedadAos;
    }

    @Basic
    @Column(name = "ESTADOFISICO")
    public String getEstadofisico() {
        return estadofisico;
    }

    public void setEstadofisico(String estadofisico) {
        this.estadofisico = estadofisico;
    }

    @Basic
    @Column(name = "TIPODEENERGIA")
    public String getTipodeenergia() {
        return tipodeenergia;
    }

    public void setTipodeenergia(String tipodeenergia) {
        this.tipodeenergia = tipodeenergia;
    }

    @Basic
    @Column(name = "POTENCIAMOTOR_HP")
    public String getPotenciamotorHp() {
        return potenciamotorHp;
    }

    public void setPotenciamotorHp(String potenciamotorHp) {
        this.potenciamotorHp = potenciamotorHp;
    }

    @Basic
    @Column(name = "POTENCIABOMBA_HP")
    public String getPotenciabombaHp() {
        return potenciabombaHp;
    }

    public void setPotenciabombaHp(String potenciabombaHp) {
        this.potenciabombaHp = potenciabombaHp;
    }

    @Basic
    @Column(name = "CUENTACONFOCULADOR_D_F_T")
    public String getCuentaconfoculadorDFT() {
        return cuentaconfoculadorDFT;
    }

    public void setCuentaconfoculadorDFT(String cuentaconfoculadorDFT) {
        this.cuentaconfoculadorDFT = cuentaconfoculadorDFT;
    }

    @Basic
    @Column(name = "DIAMETRO_PULG")
    public String getDiametroPulg() {
        return diametroPulg;
    }

    public void setDiametroPulg(String diametroPulg) {
        this.diametroPulg = diametroPulg;
    }

    @Basic
    @Column(name = "LONGITUD_MTS")
    public String getLongitudMts() {
        return longitudMts;
    }

    public void setLongitudMts(String longitudMts) {
        this.longitudMts = longitudMts;
    }



    @Basic
    @Column(name = "TIPODETUBERIA")
    public String getTipodetuberia() {
        return tipodetuberia;
    }

    public void setTipodetuberia(String tipodetuberia) {
        this.tipodetuberia = tipodetuberia;
    }

    @Basic
    @Column(name = "ANCHO_MTS")
    public String getAnchoMts() {
        return anchoMts;
    }

    public void setAnchoMts(String anchoMts) {
        this.anchoMts = anchoMts;
    }

    @Basic
    @Column(name = "PRIMARIA_AREA_HA_UNIDAD")
    public String getPrimariaAreaHaUnidad() {
        return primariaAreaHaUnidad;
    }

    public void setPrimariaAreaHaUnidad(String primariaAreaHaUnidad) {
        this.primariaAreaHaUnidad = primariaAreaHaUnidad;
    }

    @Basic
    @Column(name = "SECUNDARIA_AREA_HA_UNIDAD")
    public String getSecundariaAreaHaUnidad() {
        return secundariaAreaHaUnidad;
    }

    public void setSecundariaAreaHaUnidad(String secundariaAreaHaUnidad) {
        this.secundariaAreaHaUnidad = secundariaAreaHaUnidad;
    }

    @Basic
    @Column(name = "TERCIARIA_AREA_HA_UNIDAD")
    public String getTerciariaAreaHaUnidad() {
        return terciariaAreaHaUnidad;
    }

    public void setTerciariaAreaHaUnidad(String terciariaAreaHaUnidad) {
        this.terciariaAreaHaUnidad = terciariaAreaHaUnidad;
    }

    @Basic
    @Column(name = "UNIDADES")
    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    @Basic
    @Column(name = "ALTURA_MTS")
    public String getAlturaMts() {
        return alturaMts;
    }

    public void setAlturaMts(String alturaMts) {
        this.alturaMts = alturaMts;
    }

    @Basic
    @Column(name = "PRESIONMAXIMA_MCA")
    public String getPresionmaximaMca() {
        return presionmaximaMca;
    }

    public void setPresionmaximaMca(String presionmaximaMca) {
        this.presionmaximaMca = presionmaximaMca;
    }

    @Basic
    @Column(name = "CAUDALURBANO_LPS")
    public BigDecimal  getCaudalurbanoLps() {
        return caudalurbanoLps;
    }

    public void setCaudalurbanoLps(BigDecimal  caudalurbanoLps) {
        this.caudalurbanoLps = caudalurbanoLps;
    }

    @Basic
    @Column(name = "CAUDALRURAL_LPS")
    public BigDecimal  getCaudalruralLps() {
        return caudalruralLps;
    }

    public void setCaudalruralLps(BigDecimal  caudalruralLps) {
        this.caudalruralLps = caudalruralLps;
    }

    @Basic
    @Column(name = "CAUDALCAPTADODIRECTO_LPS")
    public BigDecimal  getCaudalcaptadodirectoLps() {
        return caudalcaptadodirectoLps;
    }

    public void setCaudalcaptadodirectoLps(BigDecimal  caudalcaptadodirectoLps) {
        this.caudalcaptadodirectoLps = caudalcaptadodirectoLps;
    }

    @Basic
    @Column(name = "CAUDALCAPTADOBOMBEO_LPS")
    public BigDecimal  getCaudalcaptadobombeoLps() {
        return caudalcaptadobombeoLps;
    }

    public void setCaudalcaptadobombeoLps(BigDecimal  caudalcaptadobombeoLps) {
        this.caudalcaptadobombeoLps = caudalcaptadobombeoLps;
    }

    @Basic
    @Column(name = "POTENCIA_HP")
    public String getPotenciaHp() {
        return potenciaHp;
    }

    public void setPotenciaHp(String potenciaHp) {
        this.potenciaHp = potenciaHp;
    }

    @Basic
    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "DOCUMENTOFUENTE")
    public String getDocumentofuente() {
        return documentofuente;
    }

    public void setDocumentofuente(String documentofuente) {
        this.documentofuente = documentofuente;
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
    public Date  getCreacionfecha() {
        return creacionfecha;
    }

    public void setCreacionfecha(Date  creacionfecha) {
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
    public Date  getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date  ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @Column(name = "ESTADODOCUMENTO")
    public Integer getEstadodocumento() {
        return estadodocumento;
    }
    public void setEstadodocumento(Integer estadodocumento) {
        this.estadodocumento = estadodocumento;
    }

    @Basic
    @Column(name = "SUB_TIPO_INFRAESTRUCTURA")

    public String getSubTipoInfraestructura() {
        return subTipoInfraestructura;
    }

    public void setSubTipoInfraestructura(String subTipoInfraestructura) {
        this.subTipoInfraestructura = subTipoInfraestructura;
    }


}
