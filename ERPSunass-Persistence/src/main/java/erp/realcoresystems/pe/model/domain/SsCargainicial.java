package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SS_CARGAINICIAL")
@IdClass(SsCargainicialPK.class)
public class SsCargainicial   extends Entidad{
    private String companyowner;
    private String sucursal;
    private Integer proyectoid;
    private Integer fuenteid;
    private Integer anno;
    private Integer cargainicialid;
    private Integer sectorid;
    private Integer mes;
    private String fuobservaciones;
    private String fuusaldecaptacoin;
    private String fupacidadproduccion;
    private String futipofuente;
    private Date fechainformacion;
    private String direccion;
    private String ubigeo;
    private String volumenM3;
    private String capacActualLps;
    private String capacMaximaLps;
    private String antiguedadAos;
    private String estadofisico;
    private String tipodeenergia;
    private String potenciamotorHp;
    private String potenciabombaHp;
    private String cuentaconfoculadorDFT;
    private String diametroPulg;
    private String IntegeritudMts;
    private String tipodetuberia;
    private String anchoMts;
    private String primariaAreaHaUnidad;
    private String secundariaAreaHaUnidad;
    private String terciariaAreaHaUnidad;
    private String unidades;
    private String alturaMts;
    private String presionmaximaMca;
    private String caudalurbanoLps;
    private String caudalruralLps;
    private String caudalcaptadodirectoLps;
    private String caudalcaptadobombeoLps;
    private String potenciaHp;
    private String observacion;
    private String documentofuente;
    private String creacionusuario;
    private Date creacionfecha;
    private String ultimousuario;
    private Date ultimafechamodif;
    private String estado;

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
    @Column(name = "CARGAINICIALID")
    public Integer getCargainicialid() {
        return cargainicialid;
    }

    public void setCargainicialid(Integer cargainicialid) {
        this.cargainicialid = cargainicialid;
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
    public Date getFechainformacion() {
        return fechainformacion;
    }

    public void setFechainformacion(Date fechainformacion) {
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
    @Column(name = "UBIGEO")
    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Basic
    @Column(name = "VOLUMEN_M3")
    public String getVolumenM3() {
        return volumenM3;
    }

    public void setVolumenM3(String volumenM3) {
        this.volumenM3 = volumenM3;
    }

    @Basic
    @Column(name = "CAPAC_ACTUAL_LPS")
    public String getCapacActualLps() {
        return capacActualLps;
    }

    public void setCapacActualLps(String capacActualLps) {
        this.capacActualLps = capacActualLps;
    }

    @Basic
    @Column(name = "CAPAC_MAXIMA_LPS")
    public String getCapacMaximaLps() {
        return capacMaximaLps;
    }

    public void setCapacMaximaLps(String capacMaximaLps) {
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
    @Column(name = "IntegerITUD_MTS")
    public String getIntegeritudMts() {
        return IntegeritudMts;
    }

    public void setIntegeritudMts(String IntegeritudMts) {
        this.IntegeritudMts = IntegeritudMts;
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
    public String getCaudalurbanoLps() {
        return caudalurbanoLps;
    }

    public void setCaudalurbanoLps(String caudalurbanoLps) {
        this.caudalurbanoLps = caudalurbanoLps;
    }

    @Basic
    @Column(name = "CAUDALRURAL_LPS")
    public String getCaudalruralLps() {
        return caudalruralLps;
    }

    public void setCaudalruralLps(String caudalruralLps) {
        this.caudalruralLps = caudalruralLps;
    }

    @Basic
    @Column(name = "CAUDALCAPTADODIRECTO_LPS")
    public String getCaudalcaptadodirectoLps() {
        return caudalcaptadodirectoLps;
    }

    public void setCaudalcaptadodirectoLps(String caudalcaptadodirectoLps) {
        this.caudalcaptadodirectoLps = caudalcaptadodirectoLps;
    }

    @Basic
    @Column(name = "CAUDALCAPTADOBOMBEO_LPS")
    public String getCaudalcaptadobombeoLps() {
        return caudalcaptadobombeoLps;
    }

    public void setCaudalcaptadobombeoLps(String caudalcaptadobombeoLps) {
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
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsCargainicial that = (SsCargainicial) o;

        if (proyectoid != that.proyectoid) return false;
        if (fuenteid != that.fuenteid) return false;
        if (anno != that.anno) return false;
        if (cargainicialid != that.cargainicialid) return false;
        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (sucursal != null ? !sucursal.equals(that.sucursal) : that.sucursal != null) return false;
        if (sectorid != null ? !sectorid.equals(that.sectorid) : that.sectorid != null) return false;
        if (mes != null ? !mes.equals(that.mes) : that.mes != null) return false;
        if (fuobservaciones != null ? !fuobservaciones.equals(that.fuobservaciones) : that.fuobservaciones != null)
            return false;
        if (fuusaldecaptacoin != null ? !fuusaldecaptacoin.equals(that.fuusaldecaptacoin) : that.fuusaldecaptacoin != null)
            return false;
        if (fupacidadproduccion != null ? !fupacidadproduccion.equals(that.fupacidadproduccion) : that.fupacidadproduccion != null)
            return false;
        if (futipofuente != null ? !futipofuente.equals(that.futipofuente) : that.futipofuente != null) return false;
        if (fechainformacion != null ? !fechainformacion.equals(that.fechainformacion) : that.fechainformacion != null)
            return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (ubigeo != null ? !ubigeo.equals(that.ubigeo) : that.ubigeo != null) return false;
        if (volumenM3 != null ? !volumenM3.equals(that.volumenM3) : that.volumenM3 != null) return false;
        if (capacActualLps != null ? !capacActualLps.equals(that.capacActualLps) : that.capacActualLps != null)
            return false;
        if (capacMaximaLps != null ? !capacMaximaLps.equals(that.capacMaximaLps) : that.capacMaximaLps != null)
            return false;
        if (antiguedadAos != null ? !antiguedadAos.equals(that.antiguedadAos) : that.antiguedadAos != null)
            return false;
        if (estadofisico != null ? !estadofisico.equals(that.estadofisico) : that.estadofisico != null) return false;
        if (tipodeenergia != null ? !tipodeenergia.equals(that.tipodeenergia) : that.tipodeenergia != null)
            return false;
        if (potenciamotorHp != null ? !potenciamotorHp.equals(that.potenciamotorHp) : that.potenciamotorHp != null)
            return false;
        if (potenciabombaHp != null ? !potenciabombaHp.equals(that.potenciabombaHp) : that.potenciabombaHp != null)
            return false;
        if (cuentaconfoculadorDFT != null ? !cuentaconfoculadorDFT.equals(that.cuentaconfoculadorDFT) : that.cuentaconfoculadorDFT != null)
            return false;
        if (diametroPulg != null ? !diametroPulg.equals(that.diametroPulg) : that.diametroPulg != null) return false;
        if (IntegeritudMts != null ? !IntegeritudMts.equals(that.IntegeritudMts) : that.IntegeritudMts != null) return false;
        if (tipodetuberia != null ? !tipodetuberia.equals(that.tipodetuberia) : that.tipodetuberia != null)
            return false;
        if (anchoMts != null ? !anchoMts.equals(that.anchoMts) : that.anchoMts != null) return false;
        if (primariaAreaHaUnidad != null ? !primariaAreaHaUnidad.equals(that.primariaAreaHaUnidad) : that.primariaAreaHaUnidad != null)
            return false;
        if (secundariaAreaHaUnidad != null ? !secundariaAreaHaUnidad.equals(that.secundariaAreaHaUnidad) : that.secundariaAreaHaUnidad != null)
            return false;
        if (terciariaAreaHaUnidad != null ? !terciariaAreaHaUnidad.equals(that.terciariaAreaHaUnidad) : that.terciariaAreaHaUnidad != null)
            return false;
        if (unidades != null ? !unidades.equals(that.unidades) : that.unidades != null) return false;
        if (alturaMts != null ? !alturaMts.equals(that.alturaMts) : that.alturaMts != null) return false;
        if (presionmaximaMca != null ? !presionmaximaMca.equals(that.presionmaximaMca) : that.presionmaximaMca != null)
            return false;
        if (caudalurbanoLps != null ? !caudalurbanoLps.equals(that.caudalurbanoLps) : that.caudalurbanoLps != null)
            return false;
        if (caudalruralLps != null ? !caudalruralLps.equals(that.caudalruralLps) : that.caudalruralLps != null)
            return false;
        if (caudalcaptadodirectoLps != null ? !caudalcaptadodirectoLps.equals(that.caudalcaptadodirectoLps) : that.caudalcaptadodirectoLps != null)
            return false;
        if (caudalcaptadobombeoLps != null ? !caudalcaptadobombeoLps.equals(that.caudalcaptadobombeoLps) : that.caudalcaptadobombeoLps != null)
            return false;
        if (potenciaHp != null ? !potenciaHp.equals(that.potenciaHp) : that.potenciaHp != null) return false;
        if (observacion != null ? !observacion.equals(that.observacion) : that.observacion != null) return false;
        if (documentofuente != null ? !documentofuente.equals(that.documentofuente) : that.documentofuente != null)
            return false;
        if (creacionusuario != null ? !creacionusuario.equals(that.creacionusuario) : that.creacionusuario != null)
            return false;
        if (creacionfecha != null ? !creacionfecha.equals(that.creacionfecha) : that.creacionfecha != null)
            return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (sucursal != null ? sucursal.hashCode() : 0);
        result = 31 * result + (int) (proyectoid ^ (proyectoid >>> 32));
        result = 31 * result + (int) (fuenteid ^ (fuenteid >>> 32));
        result = 31 * result + (int) (anno ^ (anno >>> 32));
        result = 31 * result + (int) (cargainicialid ^ (cargainicialid >>> 32));
        result = 31 * result + (sectorid != null ? sectorid.hashCode() : 0);
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (fuobservaciones != null ? fuobservaciones.hashCode() : 0);
        result = 31 * result + (fuusaldecaptacoin != null ? fuusaldecaptacoin.hashCode() : 0);
        result = 31 * result + (fupacidadproduccion != null ? fupacidadproduccion.hashCode() : 0);
        result = 31 * result + (futipofuente != null ? futipofuente.hashCode() : 0);
        result = 31 * result + (fechainformacion != null ? fechainformacion.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (ubigeo != null ? ubigeo.hashCode() : 0);
        result = 31 * result + (volumenM3 != null ? volumenM3.hashCode() : 0);
        result = 31 * result + (capacActualLps != null ? capacActualLps.hashCode() : 0);
        result = 31 * result + (capacMaximaLps != null ? capacMaximaLps.hashCode() : 0);
        result = 31 * result + (antiguedadAos != null ? antiguedadAos.hashCode() : 0);
        result = 31 * result + (estadofisico != null ? estadofisico.hashCode() : 0);
        result = 31 * result + (tipodeenergia != null ? tipodeenergia.hashCode() : 0);
        result = 31 * result + (potenciamotorHp != null ? potenciamotorHp.hashCode() : 0);
        result = 31 * result + (potenciabombaHp != null ? potenciabombaHp.hashCode() : 0);
        result = 31 * result + (cuentaconfoculadorDFT != null ? cuentaconfoculadorDFT.hashCode() : 0);
        result = 31 * result + (diametroPulg != null ? diametroPulg.hashCode() : 0);
        result = 31 * result + (IntegeritudMts != null ? IntegeritudMts.hashCode() : 0);
        result = 31 * result + (tipodetuberia != null ? tipodetuberia.hashCode() : 0);
        result = 31 * result + (anchoMts != null ? anchoMts.hashCode() : 0);
        result = 31 * result + (primariaAreaHaUnidad != null ? primariaAreaHaUnidad.hashCode() : 0);
        result = 31 * result + (secundariaAreaHaUnidad != null ? secundariaAreaHaUnidad.hashCode() : 0);
        result = 31 * result + (terciariaAreaHaUnidad != null ? terciariaAreaHaUnidad.hashCode() : 0);
        result = 31 * result + (unidades != null ? unidades.hashCode() : 0);
        result = 31 * result + (alturaMts != null ? alturaMts.hashCode() : 0);
        result = 31 * result + (presionmaximaMca != null ? presionmaximaMca.hashCode() : 0);
        result = 31 * result + (caudalurbanoLps != null ? caudalurbanoLps.hashCode() : 0);
        result = 31 * result + (caudalruralLps != null ? caudalruralLps.hashCode() : 0);
        result = 31 * result + (caudalcaptadodirectoLps != null ? caudalcaptadodirectoLps.hashCode() : 0);
        result = 31 * result + (caudalcaptadobombeoLps != null ? caudalcaptadobombeoLps.hashCode() : 0);
        result = 31 * result + (potenciaHp != null ? potenciaHp.hashCode() : 0);
        result = 31 * result + (observacion != null ? observacion.hashCode() : 0);
        result = 31 * result + (documentofuente != null ? documentofuente.hashCode() : 0);
        result = 31 * result + (creacionusuario != null ? creacionusuario.hashCode() : 0);
        result = 31 * result + (creacionfecha != null ? creacionfecha.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
