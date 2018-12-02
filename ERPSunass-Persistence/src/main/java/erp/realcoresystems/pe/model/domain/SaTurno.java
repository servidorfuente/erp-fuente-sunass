package erp.realcoresystems.pe.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.IdClass;
import javax.persistence.Column;
import javax.persistence.Basic;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "SA_TURNO")
public class SaTurno extends Entidad{
	
	private static final long serialVersionUID = 6105070131783398689L;
	private Integer uneunegocioid;
    private Integer turturnoid;
    private Integer turestado;
    private String turcodigo;
    private String turdescripcion;
    private Integer turusuariocreacion;
    private Date turfechacreacion;
    private String turipcreacion;
    private Integer turultimousuario;
    private Date turultimafechamodif;
    private String turultimoip;
    private Date turhorainicio;
    private Date turhorafin;
    private Integer turminutosbloquehor;

    @Column(name = "TURHORAINICIO")
    public Date getTurhorainicio() {
		return turhorainicio;
	}
    
    public void setTurhorainicio(Date turhorainicio) {
		this.turhorainicio = turhorainicio;
	}
    
	@Column(name = "TURHORAFIN")
	public Date getTurhorafin() {
		return turhorafin;
	}

	public void setTurhorafin(Date turhorafin) {
		this.turhorafin = turhorafin;
	}
	
	@Column(name = "TURMINUTOS_BLOQUEHOR")
	public Integer getTurminutosbloquehor() {
		return turminutosbloquehor;
	}

	public void setTurminutosbloquehor(Integer turminutosbloquehor) {
		this.turminutosbloquehor = turminutosbloquehor;
	}
	@Id
	@Column(name = "UNEUNEGOCIOID")
    public Integer getUneunegocioid() {
        return uneunegocioid;
    }

    public void setUneunegocioid(Integer uneunegocioid) {
        this.uneunegocioid = uneunegocioid;
    }

    @Id
    @Column(name = "TURTURNOID")
    public Integer getTurturnoid() {
        return turturnoid;
    }

    public void setTurturnoid(Integer turturnoid) {
        this.turturnoid = turturnoid;
    }

    @Basic
    @Column(name = "TURESTADO")
    public Integer getTurestado() {
        return turestado;
    }

    public void setTurestado(Integer turestado) {
        this.turestado = turestado;
    }

    @Basic
    @Column(name = "TURCODIGO")
    public String getTurcodigo() {
        return turcodigo;
    }

    public void setTurcodigo(String turcodigo) {
        this.turcodigo = turcodigo;
    }

    @Basic
    @Column(name = "TURDESCRIPCION")
    public String getTurdescripcion() {
        return turdescripcion;
    }

    public void setTurdescripcion(String turdescripcion) {
        this.turdescripcion = turdescripcion;
    }

    @Basic
    @Column(name = "TURUSUARIOCREACION")
    public Integer getTurusuariocreacion() {
        return turusuariocreacion;
    }

    public void setTurusuariocreacion(Integer turusuariocreacion) {
        this.turusuariocreacion = turusuariocreacion;
    }

    @Basic
    @Column(name = "TURFECHACREACION")
    public Date getTurfechacreacion() {
        return turfechacreacion;
    }

    public void setTurfechacreacion(Date turfechacreacion) {
        this.turfechacreacion = turfechacreacion;
    }

    @Basic
    @Column(name = "TURIPCREACION")
    public String getTuripcreacion() {
        return turipcreacion;
    }

    public void setTuripcreacion(String turipcreacion) {
        this.turipcreacion = turipcreacion;
    }

    @Basic
    @Column(name = "TURULTIMOUSUARIO")
    public Integer getTurultimousuario() {
        return turultimousuario;
    }

    public void setTurultimousuario(Integer turultimousuario) {
        this.turultimousuario = turultimousuario;
    }

    @Basic
    @Column(name = "TURULTIMAFECHAMODIF")
    public Date getTurultimafechamodif() {
        return turultimafechamodif;
    }

    public void setTurultimafechamodif(Date turultimafechamodif) {
        this.turultimafechamodif = turultimafechamodif;
    }

    @Basic
    @Column(name = "TURULTIMOIP")
    public String getTurultimoip() {
        return turultimoip;
    }

    public void setTurultimoip(String turultimoip) {
        this.turultimoip = turultimoip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTurno saTurno = (SaTurno) o;

        if (uneunegocioid != saTurno.uneunegocioid) return false;
        if (turturnoid != saTurno.turturnoid) return false;
        if (turestado != saTurno.turestado) return false;
        if (turcodigo != null ? !turcodigo.equals(saTurno.turcodigo) : saTurno.turcodigo != null) return false;
        if (turdescripcion != null ? !turdescripcion.equals(saTurno.turdescripcion) : saTurno.turdescripcion != null)
            return false;
        if (turusuariocreacion != null ? !turusuariocreacion.equals(saTurno.turusuariocreacion) : saTurno.turusuariocreacion != null)
            return false;
        if (turfechacreacion != null ? !turfechacreacion.equals(saTurno.turfechacreacion) : saTurno.turfechacreacion != null)
            return false;
        if (turipcreacion != null ? !turipcreacion.equals(saTurno.turipcreacion) : saTurno.turipcreacion != null)
            return false;
        if (turultimousuario != null ? !turultimousuario.equals(saTurno.turultimousuario) : saTurno.turultimousuario != null)
            return false;
        if (turultimafechamodif != null ? !turultimafechamodif.equals(saTurno.turultimafechamodif) : saTurno.turultimafechamodif != null)
            return false;
        if (turultimoip != null ? !turultimoip.equals(saTurno.turultimoip) : saTurno.turultimoip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uneunegocioid ^ (uneunegocioid >>> 32));
        result = 31 * result + (int) (turturnoid ^ (turturnoid >>> 32));
        result = 31 * result + (int) (turestado ^ (turestado >>> 32));
        result = 31 * result + (turcodigo != null ? turcodigo.hashCode() : 0);
        result = 31 * result + (turdescripcion != null ? turdescripcion.hashCode() : 0);
        result = 31 * result + (turusuariocreacion != null ? turusuariocreacion.hashCode() : 0);
        result = 31 * result + (turfechacreacion != null ? turfechacreacion.hashCode() : 0);
        result = 31 * result + (turipcreacion != null ? turipcreacion.hashCode() : 0);
        result = 31 * result + (turultimousuario != null ? turultimousuario.hashCode() : 0);
        result = 31 * result + (turultimafechamodif != null ? turultimafechamodif.hashCode() : 0);
        result = 31 * result + (turultimoip != null ? turultimoip.hashCode() : 0);
        return result;
    }
}
