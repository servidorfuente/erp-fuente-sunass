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
    private String potenciaHp;
    private String observacion;
    private String documentofuente;
    private String creacionusuario;
    private Date  creacionfecha;
    private String ultimousuario;
    private Date  ultimafechamodif;

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


}
