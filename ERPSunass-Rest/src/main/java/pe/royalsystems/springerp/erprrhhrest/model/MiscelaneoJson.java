package erp.realcoresystems.pe.erprrhhrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;

import java.util.Date;

@JsonIgnoreProperties( value = {
        "uri",
        "paginable"
})
@JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
public class MiscelaneoJson {
    private String aplicacionCodigo;
    private String maestroCodigo;
    private String valorCodigo;
    private String codigo01;
    private String codigo02;
    private String codigo03;
    private String descripcion01;
    private String descripcionIngles;
    private String descripcionLocal;
    private String estado;
    private Integer numero01;
    private Date ultimaFechaModif;
    private String ultimoUsuario;
    private String idCompuesto;
    private String tituloHeaderDetalle;

    public String getAplicacionCodigo() {
        return aplicacionCodigo;
    }

    public void setAplicacionCodigo(String aplicacionCodigo) {
        this.aplicacionCodigo = aplicacionCodigo;
    }

    public String getMaestroCodigo() {
        return maestroCodigo;
    }

    public void setMaestroCodigo(String maestroCodigo) {
        this.maestroCodigo = maestroCodigo;
    }

    public String getValorCodigo() {
        return valorCodigo;
    }

    public void setValorCodigo(String valorCodigo) {
        this.valorCodigo = valorCodigo;
    }

    public String getCodigo01() {
        return codigo01;
    }

    public void setCodigo01(String codigo01) {
        this.codigo01 = codigo01;
    }

    public String getCodigo02() {
        return codigo02;
    }

    public void setCodigo02(String codigo02) {
        this.codigo02 = codigo02;
    }

    public String getCodigo03() {
        return codigo03;
    }

    public void setCodigo03(String codigo03) {
        this.codigo03 = codigo03;
    }

    public String getDescripcion01() {
        return descripcion01;
    }

    public void setDescripcion01(String descripcion01) {
        this.descripcion01 = descripcion01;
    }

    public String getDescripcionIngles() {
        return descripcionIngles;
    }

    public void setDescripcionIngles(String descripcionIngles) {
        this.descripcionIngles = descripcionIngles;
    }

    public String getDescripcionLocal() {
        return descripcionLocal;
    }

    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero01() {
        return numero01;
    }

    public void setNumero01(Integer numero01) {
        this.numero01 = numero01;
    }

    public Date getUltimaFechaModif() {
        return ultimaFechaModif;
    }

    public void setUltimaFechaModif(Date ultimaFechaModif) {
        this.ultimaFechaModif = ultimaFechaModif;
    }

    public String getUltimoUsuario() {
        return ultimoUsuario;
    }

    public void setUltimoUsuario(String ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }

    public String getIdCompuesto() {
        return idCompuesto;
    }

    public void setIdCompuesto(String idCompuesto) {
        this.idCompuesto = idCompuesto;
    }

    public String getTituloHeaderDetalle() {
        return tituloHeaderDetalle;
    }

    public void setTituloHeaderDetalle(String tituloHeaderDetalle) {
        this.tituloHeaderDetalle = tituloHeaderDetalle;
    }


    public MiscelaneoJson() {
        super();
        // TODO Auto-generated constructor stub
    }
}
