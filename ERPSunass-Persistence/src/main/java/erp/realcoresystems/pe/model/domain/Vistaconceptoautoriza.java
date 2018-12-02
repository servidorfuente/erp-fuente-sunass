package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mamania on 30/12/2015.
 */
@Entity
public class Vistaconceptoautoriza extends  Entidad implements Serializable {

    public Vistaconceptoautoriza() {
    }
    private String aplicacioncodigo;

    @Id
    @GeneratedValue
    @Basic
    @Column(name = "APLICACIONCODIGO")
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    private String grupo;
    @Id
    @GeneratedValue
    @Basic
    @Column(name = "GRUPO")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    private String concepto;
    @Id
    @GeneratedValue
    @Basic
    @Column(name = "CONCEPTO")
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    private String conceptopadre;

    @Basic
    @Column(name = "CONCEPTOPADRE")
    public String getConceptopadre() {
        return conceptopadre;
    }

    public void setConceptopadre(String conceptopadre) {
        this.conceptopadre = conceptopadre;
    }

    private String descripcion;

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private String descripcionEs;

    @Basic
    @Column(name = "DESCRIPCION_ES")
    public String getDescripcionEs() {
        return descripcionEs;
    }

    public void setDescripcionEs(String descripcionEs) {
        this.descripcionEs = descripcionEs;
    }

    private String descripcionEn;

    @Basic
    @Column(name = "DESCRIPCION_EN")
    public String getDescripcionEn() {
        return descripcionEn;
    }

    public void setDescripcionEn(String descripcionEn) {
        this.descripcionEn = descripcionEn;
    }

    private String visibleflag;

    @Basic
    @Column(name = "VISIBLEFLAG")
    public String getVisibleflag() {
        return visibleflag;
    }

    public void setVisibleflag(String visibleflag) {
        this.visibleflag = visibleflag;
    }

    private String tipodedetalle;

    @Basic
    @Column(name = "TIPODEDETALLE")
    public String getTipodedetalle() {
        return tipodedetalle;
    }

    public void setTipodedetalle(String tipodedetalle) {
        this.tipodedetalle = tipodedetalle;
    }

    private String tipodeobjeto;

    @Basic
    @Column(name = "TIPODEOBJETO")
    public String getTipodeobjeto() {
        return tipodeobjeto;
    }

    public void setTipodeobjeto(String tipodeobjeto) {
        this.tipodeobjeto = tipodeobjeto;
    }

    private String objeto;

    @Basic
    @Column(name = "OBJETO")
    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    private String tipodeacceso;

    @Basic
    @Column(name = "TIPODEACCESO")
    public String getTipodeacceso() {
        return tipodeacceso;
    }

    public void setTipodeacceso(String tipodeacceso) {
        this.tipodeacceso = tipodeacceso;
    }

    private String objetowindow;

    @Basic
    @Column(name = "OBJETOWINDOW")
    public String getObjetowindow() {
        return objetowindow;
    }

    public void setObjetowindow(String objetowindow) {
        this.objetowindow = objetowindow;
    }

    private String workflag;

    @Basic
    @Column(name = "WORKFLAG")
    public String getWorkflag() {
        return workflag;
    }

    public void setWorkflag(String workflag) {
        this.workflag = workflag;
    }

    private String workagregarflag;

    @Basic
    @Column(name = "WORKAGREGARFLAG")
    public String getWorkagregarflag() {
        return workagregarflag;
    }

    public void setWorkagregarflag(String workagregarflag) {
        this.workagregarflag = workagregarflag;
    }

    private String workmodificarflag;

    @Basic
    @Column(name = "WORKMODIFICARFLAG")
    public String getWorkmodificarflag() {
        return workmodificarflag;
    }

    public void setWorkmodificarflag(String workmodificarflag) {
        this.workmodificarflag = workmodificarflag;
    }

    private String workborrarflag;

    @Basic
    @Column(name = "WORKBORRARFLAG")
    public String getWorkborrarflag() {
        return workborrarflag;
    }

    public void setWorkborrarflag(String workborrarflag) {
        this.workborrarflag = workborrarflag;
    }

    private String workaprobarflag;

    @Basic
    @Column(name = "WORKAPROBARFLAG")
    public String getWorkaprobarflag() {
        return workaprobarflag;
    }

    public void setWorkaprobarflag(String workaprobarflag) {
        this.workaprobarflag = workaprobarflag;
    }

    private String xestado;

    @Basic
    @Column(name = "XESTADO")
    public String getXestado() {
        return xestado;
    }

    public void setXestado(String xestado) {
        this.xestado = xestado;
    }

    private String webflag;

    @Basic
    @Column(name = "WEBFLAG")
    public String getWebflag() {
        return webflag;
    }

    public void setWebflag(String webflag) {
        this.webflag = webflag;
    }

    private String webpage;

    @Basic
    @Column(name = "WEBPAGE")
    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    private String webaction;

    @Basic
    @Column(name = "WEBACTION")
    public String getWebaction() {
        return webaction;
    }

    public void setWebaction(String webaction) {
        this.webaction = webaction;
    }

    private String webgrupo;

    @Basic
    @Column(name = "WEBGRUPO")
    public String getWebgrupo() {
        return webgrupo;
    }

    public void setWebgrupo(String webgrupo) {
        this.webgrupo = webgrupo;
    }

    private String descripcioningles;

    @Basic
    @Column(name = "DESCRIPCIONINGLES")
    public String getDescripcioningles() {
        return descripcioningles;
    }

    public void setDescripcioningles(String descripcioningles) {
        this.descripcioningles = descripcioningles;
    }

    private BigDecimal webgruposecuencia;

    @Basic
    @Column(name = "WEBGRUPOSECUENCIA")
    public BigDecimal getWebgruposecuencia() {
        return webgruposecuencia;
    }

    public void setWebgruposecuencia(BigDecimal webgruposecuencia) {
        this.webgruposecuencia = webgruposecuencia;
    }

    private String workprocesarflag;

    @Basic
    @Column(name = "WORKPROCESARFLAG")
    public String getWorkprocesarflag() {
        return workprocesarflag;
    }

    public void setWorkprocesarflag(String workprocesarflag) {
        this.workprocesarflag = workprocesarflag;
    }

    private String workopcion1Flag;

    @Basic
    @Column(name = "WORKOPCION1FLAG")
    public String getWorkopcion1Flag() {
        return workopcion1Flag;
    }

    public void setWorkopcion1Flag(String workopcion1Flag) {
        this.workopcion1Flag = workopcion1Flag;
    }

    private String workopcion2Flag;

    @Basic
    @Column(name = "WORKOPCION2FLAG")
    public String getWorkopcion2Flag() {
        return workopcion2Flag;
    }

    public void setWorkopcion2Flag(String workopcion2Flag) {
        this.workopcion2Flag = workopcion2Flag;
    }

    private String workopcion3Flag;

    @Basic
    @Column(name = "WORKOPCION3FLAG")
    public String getWorkopcion3Flag() {
        return workopcion3Flag;
    }

    public void setWorkopcion3Flag(String workopcion3Flag) {
        this.workopcion3Flag = workopcion3Flag;
    }

    private String workopcion4Flag;

    @Basic
    @Column(name = "WORKOPCION4FLAG")
    public String getWorkopcion4Flag() {
        return workopcion4Flag;
    }

    public void setWorkopcion4Flag(String workopcion4Flag) {
        this.workopcion4Flag = workopcion4Flag;
    }

    private String workopcion5Flag;

    @Basic
    @Column(name = "WORKOPCION5FLAG")
    public String getWorkopcion5Flag() {
        return workopcion5Flag;
    }

    public void setWorkopcion5Flag(String workopcion5Flag) {
        this.workopcion5Flag = workopcion5Flag;
    }

    private String tipodeacceso2;

    @Basic
    @Column(name = "TIPODEACCESO2")
    public String getTipodeacceso2() {
        return tipodeacceso2;
    }

    public void setTipodeacceso2(String tipodeacceso2) {
        this.tipodeacceso2 = tipodeacceso2;
    }

    private String tipodeacceso3;

    @Basic
    @Column(name = "TIPODEACCESO3")
    public String getTipodeacceso3() {
        return tipodeacceso3;
    }

    public void setTipodeacceso3(String tipodeacceso3) {
        this.tipodeacceso3 = tipodeacceso3;
    }

    private String tipodeacceso4;

    @Basic
    @Column(name = "TIPODEACCESO4")
    public String getTipodeacceso4() {
        return tipodeacceso4;
    }

    public void setTipodeacceso4(String tipodeacceso4) {
        this.tipodeacceso4 = tipodeacceso4;
    }

    private String accesodirectoflag;

    @Basic
    @Column(name = "ACCESODIRECTOFLAG")
    public String getAccesodirectoflag() {
        return accesodirectoflag;
    }

    public void setAccesodirectoflag(String accesodirectoflag) {
        this.accesodirectoflag = accesodirectoflag;
    }

    private String url;

    @Basic
    @Column(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private BigDecimal orden;

    @Basic
    @Column(name = "ORDEN")
    public BigDecimal getOrden() {
        return orden;
    }

    public void setOrden(BigDecimal orden) {
        this.orden = orden;
    }

    private String rutaimagen;

    @Basic
    @Column(name = "RUTAIMAGEN")
    public String getRutaimagen() {
        return rutaimagen;
    }

    public void setRutaimagen(String rutaimagen) {
        this.rutaimagen = rutaimagen;
    }

    private String tooltip;

    @Basic
    @Column(name = "TOOLTIP")
    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    private String usuario;

    @Basic
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String opcionagregarflag;

    @Basic
    @Column(name = "OPCIONAGREGARFLAG")
    public String getOpcionagregarflag() {
        return opcionagregarflag;
    }

    public void setOpcionagregarflag(String opcionagregarflag) {
        this.opcionagregarflag = opcionagregarflag;
    }

    private String opcionmodificarflag;

    @Basic
    @Column(name = "OPCIONMODIFICARFLAG")
    public String getOpcionmodificarflag() {
        return opcionmodificarflag;
    }

    public void setOpcionmodificarflag(String opcionmodificarflag) {
        this.opcionmodificarflag = opcionmodificarflag;
    }

    private String opcionborrarflag;

    @Basic
    @Column(name = "OPCIONBORRARFLAG")
    public String getOpcionborrarflag() {
        return opcionborrarflag;
    }

    public void setOpcionborrarflag(String opcionborrarflag) {
        this.opcionborrarflag = opcionborrarflag;
    }

    private String estado;

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String ultimousuario;

    @Basic
    @Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    private Date ultimafechamodif;

    @Basic
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    private String opcionaprobarflag;

    @Basic
    @Column(name = "OPCIONAPROBARFLAG")
    public String getOpcionaprobarflag() {
        return opcionaprobarflag;
    }

    public void setOpcionaprobarflag(String opcionaprobarflag) {
        this.opcionaprobarflag = opcionaprobarflag;
    }

    private String opcionprocesarflag;

    @Basic
    @Column(name = "OPCIONPROCESARFLAG")
    public String getOpcionprocesarflag() {
        return opcionprocesarflag;
    }

    public void setOpcionprocesarflag(String opcionprocesarflag) {
        this.opcionprocesarflag = opcionprocesarflag;
    }

    private String opcionopcion1Flag;

    @Basic
    @Column(name = "OPCIONOPCION1FLAG")
    public String getOpcionopcion1Flag() {
        return opcionopcion1Flag;
    }

    public void setOpcionopcion1Flag(String opcionopcion1Flag) {
        this.opcionopcion1Flag = opcionopcion1Flag;
    }

    private String opcionopcion2Flag;

    @Basic
    @Column(name = "OPCIONOPCION2FLAG")
    public String getOpcionopcion2Flag() {
        return opcionopcion2Flag;
    }

    public void setOpcionopcion2Flag(String opcionopcion2Flag) {
        this.opcionopcion2Flag = opcionopcion2Flag;
    }

    private String opcionopcion3Flag;

    @Basic
    @Column(name = "OPCIONOPCION3FLAG")
    public String getOpcionopcion3Flag() {
        return opcionopcion3Flag;
    }

    public void setOpcionopcion3Flag(String opcionopcion3Flag) {
        this.opcionopcion3Flag = opcionopcion3Flag;
    }

    private String opcionopcion4Flag;

    @Basic
    @Column(name = "OPCIONOPCION4FLAG")
    public String getOpcionopcion4Flag() {
        return opcionopcion4Flag;
    }

    public void setOpcionopcion4Flag(String opcionopcion4Flag) {
        this.opcionopcion4Flag = opcionopcion4Flag;
    }

    private String opcionopcion5Flag;

    @Basic
    @Column(name = "OPCIONOPCION5FLAG")
    public String getOpcionopcion5Flag() {
        return opcionopcion5Flag;
    }

    public void setOpcionopcion5Flag(String opcionopcion5Flag) {
        this.opcionopcion5Flag = opcionopcion5Flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vistaconceptoautoriza that = (Vistaconceptoautoriza) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;
        if (conceptopadre != null ? !conceptopadre.equals(that.conceptopadre) : that.conceptopadre != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (descripcionEs != null ? !descripcionEs.equals(that.descripcionEs) : that.descripcionEs != null)
            return false;
        if (descripcionEn != null ? !descripcionEn.equals(that.descripcionEn) : that.descripcionEn != null)
            return false;
        if (visibleflag != null ? !visibleflag.equals(that.visibleflag) : that.visibleflag != null) return false;
        if (tipodedetalle != null ? !tipodedetalle.equals(that.tipodedetalle) : that.tipodedetalle != null)
            return false;
        if (tipodeobjeto != null ? !tipodeobjeto.equals(that.tipodeobjeto) : that.tipodeobjeto != null) return false;
        if (objeto != null ? !objeto.equals(that.objeto) : that.objeto != null) return false;
        if (tipodeacceso != null ? !tipodeacceso.equals(that.tipodeacceso) : that.tipodeacceso != null) return false;
        if (objetowindow != null ? !objetowindow.equals(that.objetowindow) : that.objetowindow != null) return false;
        if (workflag != null ? !workflag.equals(that.workflag) : that.workflag != null) return false;
        if (workagregarflag != null ? !workagregarflag.equals(that.workagregarflag) : that.workagregarflag != null)
            return false;
        if (workmodificarflag != null ? !workmodificarflag.equals(that.workmodificarflag) : that.workmodificarflag != null)
            return false;
        if (workborrarflag != null ? !workborrarflag.equals(that.workborrarflag) : that.workborrarflag != null)
            return false;
        if (workaprobarflag != null ? !workaprobarflag.equals(that.workaprobarflag) : that.workaprobarflag != null)
            return false;
        if (xestado != null ? !xestado.equals(that.xestado) : that.xestado != null) return false;
        if (webflag != null ? !webflag.equals(that.webflag) : that.webflag != null) return false;
        if (webpage != null ? !webpage.equals(that.webpage) : that.webpage != null) return false;
        if (webaction != null ? !webaction.equals(that.webaction) : that.webaction != null) return false;
        if (webgrupo != null ? !webgrupo.equals(that.webgrupo) : that.webgrupo != null) return false;
        if (descripcioningles != null ? !descripcioningles.equals(that.descripcioningles) : that.descripcioningles != null)
            return false;
        if (webgruposecuencia != null ? !webgruposecuencia.equals(that.webgruposecuencia) : that.webgruposecuencia != null)
            return false;
        if (workprocesarflag != null ? !workprocesarflag.equals(that.workprocesarflag) : that.workprocesarflag != null)
            return false;
        if (workopcion1Flag != null ? !workopcion1Flag.equals(that.workopcion1Flag) : that.workopcion1Flag != null)
            return false;
        if (workopcion2Flag != null ? !workopcion2Flag.equals(that.workopcion2Flag) : that.workopcion2Flag != null)
            return false;
        if (workopcion3Flag != null ? !workopcion3Flag.equals(that.workopcion3Flag) : that.workopcion3Flag != null)
            return false;
        if (workopcion4Flag != null ? !workopcion4Flag.equals(that.workopcion4Flag) : that.workopcion4Flag != null)
            return false;
        if (workopcion5Flag != null ? !workopcion5Flag.equals(that.workopcion5Flag) : that.workopcion5Flag != null)
            return false;
        if (tipodeacceso2 != null ? !tipodeacceso2.equals(that.tipodeacceso2) : that.tipodeacceso2 != null)
            return false;
        if (tipodeacceso3 != null ? !tipodeacceso3.equals(that.tipodeacceso3) : that.tipodeacceso3 != null)
            return false;
        if (tipodeacceso4 != null ? !tipodeacceso4.equals(that.tipodeacceso4) : that.tipodeacceso4 != null)
            return false;
        if (accesodirectoflag != null ? !accesodirectoflag.equals(that.accesodirectoflag) : that.accesodirectoflag != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (rutaimagen != null ? !rutaimagen.equals(that.rutaimagen) : that.rutaimagen != null) return false;
        if (tooltip != null ? !tooltip.equals(that.tooltip) : that.tooltip != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (opcionagregarflag != null ? !opcionagregarflag.equals(that.opcionagregarflag) : that.opcionagregarflag != null)
            return false;
        if (opcionmodificarflag != null ? !opcionmodificarflag.equals(that.opcionmodificarflag) : that.opcionmodificarflag != null)
            return false;
        if (opcionborrarflag != null ? !opcionborrarflag.equals(that.opcionborrarflag) : that.opcionborrarflag != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (opcionaprobarflag != null ? !opcionaprobarflag.equals(that.opcionaprobarflag) : that.opcionaprobarflag != null)
            return false;
        if (opcionprocesarflag != null ? !opcionprocesarflag.equals(that.opcionprocesarflag) : that.opcionprocesarflag != null)
            return false;
        if (opcionopcion1Flag != null ? !opcionopcion1Flag.equals(that.opcionopcion1Flag) : that.opcionopcion1Flag != null)
            return false;
        if (opcionopcion2Flag != null ? !opcionopcion2Flag.equals(that.opcionopcion2Flag) : that.opcionopcion2Flag != null)
            return false;
        if (opcionopcion3Flag != null ? !opcionopcion3Flag.equals(that.opcionopcion3Flag) : that.opcionopcion3Flag != null)
            return false;
        if (opcionopcion4Flag != null ? !opcionopcion4Flag.equals(that.opcionopcion4Flag) : that.opcionopcion4Flag != null)
            return false;
        if (opcionopcion5Flag != null ? !opcionopcion5Flag.equals(that.opcionopcion5Flag) : that.opcionopcion5Flag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + (conceptopadre != null ? conceptopadre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (descripcionEs != null ? descripcionEs.hashCode() : 0);
        result = 31 * result + (descripcionEn != null ? descripcionEn.hashCode() : 0);
        result = 31 * result + (visibleflag != null ? visibleflag.hashCode() : 0);
        result = 31 * result + (tipodedetalle != null ? tipodedetalle.hashCode() : 0);
        result = 31 * result + (tipodeobjeto != null ? tipodeobjeto.hashCode() : 0);
        result = 31 * result + (objeto != null ? objeto.hashCode() : 0);
        result = 31 * result + (tipodeacceso != null ? tipodeacceso.hashCode() : 0);
        result = 31 * result + (objetowindow != null ? objetowindow.hashCode() : 0);
        result = 31 * result + (workflag != null ? workflag.hashCode() : 0);
        result = 31 * result + (workagregarflag != null ? workagregarflag.hashCode() : 0);
        result = 31 * result + (workmodificarflag != null ? workmodificarflag.hashCode() : 0);
        result = 31 * result + (workborrarflag != null ? workborrarflag.hashCode() : 0);
        result = 31 * result + (workaprobarflag != null ? workaprobarflag.hashCode() : 0);
        result = 31 * result + (xestado != null ? xestado.hashCode() : 0);
        result = 31 * result + (webflag != null ? webflag.hashCode() : 0);
        result = 31 * result + (webpage != null ? webpage.hashCode() : 0);
        result = 31 * result + (webaction != null ? webaction.hashCode() : 0);
        result = 31 * result + (webgrupo != null ? webgrupo.hashCode() : 0);
        result = 31 * result + (descripcioningles != null ? descripcioningles.hashCode() : 0);
        result = 31 * result + (webgruposecuencia != null ? webgruposecuencia.hashCode() : 0);
        result = 31 * result + (workprocesarflag != null ? workprocesarflag.hashCode() : 0);
        result = 31 * result + (workopcion1Flag != null ? workopcion1Flag.hashCode() : 0);
        result = 31 * result + (workopcion2Flag != null ? workopcion2Flag.hashCode() : 0);
        result = 31 * result + (workopcion3Flag != null ? workopcion3Flag.hashCode() : 0);
        result = 31 * result + (workopcion4Flag != null ? workopcion4Flag.hashCode() : 0);
        result = 31 * result + (workopcion5Flag != null ? workopcion5Flag.hashCode() : 0);
        result = 31 * result + (tipodeacceso2 != null ? tipodeacceso2.hashCode() : 0);
        result = 31 * result + (tipodeacceso3 != null ? tipodeacceso3.hashCode() : 0);
        result = 31 * result + (tipodeacceso4 != null ? tipodeacceso4.hashCode() : 0);
        result = 31 * result + (accesodirectoflag != null ? accesodirectoflag.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (rutaimagen != null ? rutaimagen.hashCode() : 0);
        result = 31 * result + (tooltip != null ? tooltip.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (opcionagregarflag != null ? opcionagregarflag.hashCode() : 0);
        result = 31 * result + (opcionmodificarflag != null ? opcionmodificarflag.hashCode() : 0);
        result = 31 * result + (opcionborrarflag != null ? opcionborrarflag.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (opcionaprobarflag != null ? opcionaprobarflag.hashCode() : 0);
        result = 31 * result + (opcionprocesarflag != null ? opcionprocesarflag.hashCode() : 0);
        result = 31 * result + (opcionopcion1Flag != null ? opcionopcion1Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion2Flag != null ? opcionopcion2Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion3Flag != null ? opcionopcion3Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion4Flag != null ? opcionopcion4Flag.hashCode() : 0);
        result = 31 * result + (opcionopcion5Flag != null ? opcionopcion5Flag.hashCode() : 0);
        return result;
    }
}
