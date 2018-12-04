package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SA_TIPODOCUMENTO")
public class SaTipodocumento extends Entidad implements Serializable    {
    private Integer tpdocumentoid;
    private String tpdcodigo;
    private String tpddescripcion;
    private String tpdmension;
    private Integer tpdclasificador;
    private Integer tpdgrupo;
    private Integer tpdestado;
    private Integer tpdusuariocreacion;
    private Date tpdfechacreacion;
    private String tpdipcreacion;
    private Integer tpdultimousuario;
    private Date tpdultimafechamodif;
    private String tpdultimoip;

    @Id
    @Column(name = "TPDOCUMENTOID")
    public Integer getTpdocumentoid() {
        return tpdocumentoid;
    }

    public void setTpdocumentoid(Integer tpdocumentoid) {
        this.tpdocumentoid = tpdocumentoid;
    }

    @Basic
    @Column(name = "TPDCODIGO")
    public String getTpdcodigo() {
        return tpdcodigo;
    }

    public void setTpdcodigo(String tpdcodigo) {
        this.tpdcodigo = tpdcodigo;
    }

    @Basic
    @Column(name = "TPDDESCRIPCION")
    public String getTpddescripcion() {
        return tpddescripcion;
    }

    public void setTpddescripcion(String tpddescripcion) {
        this.tpddescripcion = tpddescripcion;
    }

    @Basic
    @Column(name = "TPDMENSION")
    public String getTpdmension() {
        return tpdmension;
    }

    public void setTpdmension(String tpdmension) {
        this.tpdmension = tpdmension;
    }

    @Basic
    @Column(name = "TPDCLASIFICADOR")
    public Integer getTpdclasificador() {
        return tpdclasificador;
    }

    public void setTpdclasificador(Integer tpdclasificador) {
        this.tpdclasificador = tpdclasificador;
    }

    @Basic
    @Column(name = "TPDGRUPO")
    public Integer getTpdgrupo() {
        return tpdgrupo;
    }

    public void setTpdgrupo(Integer tpdgrupo) {
        this.tpdgrupo = tpdgrupo;
    }

    @Basic
    @Column(name = "TPDESTADO")
    public Integer getTpdestado() {
        return tpdestado;
    }

    public void setTpdestado(Integer tpdestado) {
        this.tpdestado = tpdestado;
    }

    @Basic
    @Column(name = "TPDUSUARIOCREACION")
    public Integer getTpdusuariocreacion() {
        return tpdusuariocreacion;
    }

    public void setTpdusuariocreacion(Integer tpdusuariocreacion) {
        this.tpdusuariocreacion = tpdusuariocreacion;
    }

    @Basic
    @Column(name = "TPDFECHACREACION")
    public Date getTpdfechacreacion() {
        return tpdfechacreacion;
    }

    public void setTpdfechacreacion(Date tpdfechacreacion) {
        this.tpdfechacreacion = tpdfechacreacion;
    }

    @Basic
    @Column(name = "TPDIPCREACION")
    public String getTpdipcreacion() {
        return tpdipcreacion;
    }

    public void setTpdipcreacion(String tpdipcreacion) {
        this.tpdipcreacion = tpdipcreacion;
    }

    @Basic
    @Column(name = "TPDULTIMOUSUARIO")
    public Integer getTpdultimousuario() {
        return tpdultimousuario;
    }

    public void setTpdultimousuario(Integer tpdultimousuario) {
        this.tpdultimousuario = tpdultimousuario;
    }

    @Basic
    @Column(name = "TPDULTIMAFECHAMODIF")
    public Date getTpdultimafechamodif() {
        return tpdultimafechamodif;
    }

    public void setTpdultimafechamodif(Date tpdultimafechamodif) {
        this.tpdultimafechamodif = tpdultimafechamodif;
    }

    @Basic
    @Column(name = "TPDULTIMOIP")
    public String getTpdultimoip() {
        return tpdultimoip;
    }

    public void setTpdultimoip(String tpdultimoip) {
        this.tpdultimoip = tpdultimoip;
    }


}
