package erp.realcoresystems.pe.model.domain;

import javax.persistence.Table;

import erp.realcoresystems.pe.model.util.BooleanToIntegerConverter;

import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "SA_BLOQUEO")
public class SaBloqueo extends Entidad{
	
    private Integer blobloqueoid;
    private Integer bloestado;
    private String blocodigo;
    private String blodescripcion;
    private Integer blousuariocreacion;
    private Date blofechacreacion;
    private String bloipcreacion;
    private Integer bloultimousuario;
    private Date bloultimafechamodif;
    private String bloultimoip;
    private boolean bloaplicatiempoflag;
    private Integer blotiempobloqueo;
    private Integer blounidadtiempo;

    @Id
    @Column(name = "BLOBLOQUEOID")
    public Integer getBlobloqueoid() {
        return blobloqueoid;
    }

    public void setBlobloqueoid(Integer blobloqueoid) {
        this.blobloqueoid = blobloqueoid;
    }

    @Basic
    @Column(name = "BLOESTADO")
    public Integer getBloestado() {
        return bloestado;
    }

    public void setBloestado(Integer bloestado) {
        this.bloestado = bloestado;
    }

    @Basic
    @Column(name = "BLOCODIGO")
    public String getBlocodigo() {
        return blocodigo;
    }

    public void setBlocodigo(String blocodigo) {
        this.blocodigo = blocodigo;
    }

    @Basic
    @Column(name = "BLODESCRIPCION")
    public String getBlodescripcion() {
        return blodescripcion;
    }

    public void setBlodescripcion(String blodescripcion) {
        this.blodescripcion = blodescripcion;
    }

    @Basic
    @Column(name = "BLOUSUARIOCREACION")
    public Integer getBlousuariocreacion() {
        return blousuariocreacion;
    }

    public void setBlousuariocreacion(Integer blousuariocreacion) {
        this.blousuariocreacion = blousuariocreacion;
    }

    @Basic
    @Column(name = "BLOFECHACREACION")
    public Date getBlofechacreacion() {
        return blofechacreacion;
    }

    public void setBlofechacreacion(Date blofechacreacion) {
        this.blofechacreacion = blofechacreacion;
    }

    @Basic
    @Column(name = "BLOIPCREACION")
    public String getBloipcreacion() {
        return bloipcreacion;
    }

    public void setBloipcreacion(String bloipcreacion) {
        this.bloipcreacion = bloipcreacion;
    }

    @Basic
    @Column(name = "BLOULTIMOUSUARIO")
    public Integer getBloultimousuario() {
        return bloultimousuario;
    }

    public void setBloultimousuario(Integer bloultimousuario) {
        this.bloultimousuario = bloultimousuario;
    }

    @Basic
    @Column(name = "BLOULTIMAFECHAMODIF")
    public Date getBloultimafechamodif() {
        return bloultimafechamodif;
    }

    public void setBloultimafechamodif(Date bloultimafechamodif) {
        this.bloultimafechamodif = bloultimafechamodif;
    }

    @Basic
    @Column(name = "BLOULTIMOIP")
    public String getBloultimoip() {
        return bloultimoip;
    }

    public void setBloultimoip(String bloultimoip) {
        this.bloultimoip = bloultimoip;
    }
    
	@Basic
    @Column(name = "BLOAPLICATIEMPOFLAG")
	@Convert(converter = BooleanToIntegerConverter.class)
    public boolean isBloaplicatiempoflag() {
		return bloaplicatiempoflag;
	}

	public void setBloaplicatiempoflag(boolean bloaplicatiempoflag) {
		this.bloaplicatiempoflag = bloaplicatiempoflag;
	}

	@Basic
    @Column(name = "BLOTIEMPOBLOQUEO")
    public Integer getBlotiempobloqueo() {
        return blotiempobloqueo;
    }

    public void setBlotiempobloqueo(Integer blotiempobloqueo) {
        this.blotiempobloqueo = blotiempobloqueo;
    }

    @Basic
    @Column(name = "BLOUNIDADTIEMPO")
    public Integer getBlounidadtiempo() {
		return blounidadtiempo;
	}

	public void setBlounidadtiempo(Integer blounidadtiempo) {
		this.blounidadtiempo = blounidadtiempo;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaBloqueo saBloqueo = (SaBloqueo) o;

        if (blobloqueoid != saBloqueo.blobloqueoid) return false;
        if (bloestado != saBloqueo.bloestado) return false;
        if (blocodigo != null ? !blocodigo.equals(saBloqueo.blocodigo) : saBloqueo.blocodigo != null) return false;
        if (blodescripcion != null ? !blodescripcion.equals(saBloqueo.blodescripcion) : saBloqueo.blodescripcion != null)
            return false;
        if (blousuariocreacion != null ? !blousuariocreacion.equals(saBloqueo.blousuariocreacion) : saBloqueo.blousuariocreacion != null)
            return false;
        if (blofechacreacion != null ? !blofechacreacion.equals(saBloqueo.blofechacreacion) : saBloqueo.blofechacreacion != null)
            return false;
        if (bloipcreacion != null ? !bloipcreacion.equals(saBloqueo.bloipcreacion) : saBloqueo.bloipcreacion != null)
            return false;
        if (bloultimousuario != null ? !bloultimousuario.equals(saBloqueo.bloultimousuario) : saBloqueo.bloultimousuario != null)
            return false;
        if (bloultimafechamodif != null ? !bloultimafechamodif.equals(saBloqueo.bloultimafechamodif) : saBloqueo.bloultimafechamodif != null)
            return false;
        if (bloultimoip != null ? !bloultimoip.equals(saBloqueo.bloultimoip) : saBloqueo.bloultimoip != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (blobloqueoid ^ (blobloqueoid >>> 32));
        result = 31 * result + (int) (bloestado ^ (bloestado >>> 32));
        result = 31 * result + (blocodigo != null ? blocodigo.hashCode() : 0);
        result = 31 * result + (blodescripcion != null ? blodescripcion.hashCode() : 0);
        result = 31 * result + (blousuariocreacion != null ? blousuariocreacion.hashCode() : 0);
        result = 31 * result + (blofechacreacion != null ? blofechacreacion.hashCode() : 0);
        result = 31 * result + (bloipcreacion != null ? bloipcreacion.hashCode() : 0);
        result = 31 * result + (bloultimousuario != null ? bloultimousuario.hashCode() : 0);
        result = 31 * result + (bloultimafechamodif != null ? bloultimafechamodif.hashCode() : 0);
        result = 31 * result + (bloultimoip != null ? bloultimoip.hashCode() : 0);
        return result;
    }
}
