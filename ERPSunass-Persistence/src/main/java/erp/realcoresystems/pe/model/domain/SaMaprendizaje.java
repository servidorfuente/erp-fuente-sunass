package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mamania on 14/01/2016.
 */
@Entity
@Table(name = "SA_MAPRENDIZAJE")
public class SaMaprendizaje extends Entidad {
    private Integer mapmaprendizajeid;
    private Integer mapestado;
    private String mapcodigo;
    private String mapdescripcion;
    private Integer mapusuariocreacion;
    private Date mapfechacreacion;
    private String mapipcreacion;
    private Integer mapultimousuario;
    private Date mapultimafechamodif;
    private String mapultimoip;

    @Id
    @Column(name = "MAPMAPRENDIZAJEID")
    public Integer getMapmaprendizajeid() {
        return mapmaprendizajeid;
    }

    public void setMapmaprendizajeid(Integer mapmaprendizajeid) {
        this.mapmaprendizajeid = mapmaprendizajeid;
    }

    @Basic
    @Column(name = "MAPESTADO")
    public Integer getMapestado() {
        return mapestado;
    }

    public void setMapestado(Integer mapestado) {
        this.mapestado = mapestado;
    }

    @Basic
    @Column(name = "MAPCODIGO")
    public String getMapcodigo() {
        return mapcodigo;
    }

    public void setMapcodigo(String mapcodigo) {
        this.mapcodigo = mapcodigo;
    }

    @Basic
    @Column(name = "MAPDESCRIPCION")
    public String getMapdescripcion() {
        return mapdescripcion;
    }

    public void setMapdescripcion(String mapdescripcion) {
        this.mapdescripcion = mapdescripcion;
    }

    @Basic
    @Column(name = "MAPUSUARIOCREACION")
    public Integer getMapusuariocreacion() {
        return mapusuariocreacion;
    }

    public void setMapusuariocreacion(Integer mapusuariocreacion) {
        this.mapusuariocreacion = mapusuariocreacion;
    }

    @Basic
    @Column(name = "MAPFECHACREACION")
    public Date getMapfechacreacion() {
        return mapfechacreacion;
    }

    public void setMapfechacreacion(Date mapfechacreacion) {
        this.mapfechacreacion = mapfechacreacion;
    }

    @Basic
    @Column(name = "MAPIPCREACION")
    public String getMapipcreacion() {
        return mapipcreacion;
    }

    public void setMapipcreacion(String mapipcreacion) {
        this.mapipcreacion = mapipcreacion;
    }

    @Basic
    @Column(name = "MAPULTIMOUSUARIO")
    public Integer getMapultimousuario() {
        return mapultimousuario;
    }

    public void setMapultimousuario(Integer mapultimousuario) {
        this.mapultimousuario = mapultimousuario;
    }

    @Basic
    @Column(name = "MAPULTIMAFECHAMODIF")
    public Date getMapultimafechamodif() {
        return mapultimafechamodif;
    }

    public void setMapultimafechamodif(Date mapultimafechamodif) {
        this.mapultimafechamodif = mapultimafechamodif;
    }

    @Basic
    @Column(name = "MAPULTIMOIP")
    public String getMapultimoip() {
        return mapultimoip;
    }

    public void setMapultimoip(String mapultimoip) {
        this.mapultimoip = mapultimoip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaMaprendizaje that = (SaMaprendizaje) o;

        if (mapmaprendizajeid != that.mapmaprendizajeid) return false;
        if (mapestado != that.mapestado) return false;
        if (mapcodigo != null ? !mapcodigo.equals(that.mapcodigo) : that.mapcodigo != null) return false;
        if (mapdescripcion != null ? !mapdescripcion.equals(that.mapdescripcion) : that.mapdescripcion != null)
            return false;
        if (mapusuariocreacion != null ? !mapusuariocreacion.equals(that.mapusuariocreacion) : that.mapusuariocreacion != null)
            return false;
        if (mapfechacreacion != null ? !mapfechacreacion.equals(that.mapfechacreacion) : that.mapfechacreacion != null)
            return false;
        if (mapipcreacion != null ? !mapipcreacion.equals(that.mapipcreacion) : that.mapipcreacion != null)
            return false;
        if (mapultimousuario != null ? !mapultimousuario.equals(that.mapultimousuario) : that.mapultimousuario != null)
            return false;
        if (mapultimafechamodif != null ? !mapultimafechamodif.equals(that.mapultimafechamodif) : that.mapultimafechamodif != null)
            return false;
        if (mapultimoip != null ? !mapultimoip.equals(that.mapultimoip) : that.mapultimoip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mapmaprendizajeid ^ (mapmaprendizajeid >>> 32));
        result = 31 * result + (int) (mapestado ^ (mapestado >>> 32));
        result = 31 * result + (mapcodigo != null ? mapcodigo.hashCode() : 0);
        result = 31 * result + (mapdescripcion != null ? mapdescripcion.hashCode() : 0);
        result = 31 * result + (mapusuariocreacion != null ? mapusuariocreacion.hashCode() : 0);
        result = 31 * result + (mapfechacreacion != null ? mapfechacreacion.hashCode() : 0);
        result = 31 * result + (mapipcreacion != null ? mapipcreacion.hashCode() : 0);
        result = 31 * result + (mapultimousuario != null ? mapultimousuario.hashCode() : 0);
        result = 31 * result + (mapultimafechamodif != null ? mapultimafechamodif.hashCode() : 0);
        result = 31 * result + (mapultimoip != null ? mapultimoip.hashCode() : 0);
        return result;
    }
}
