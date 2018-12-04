package erp.realcoresystems.pe.model.domain;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SaTurnoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer uneunegocioid;
    private Integer turturnoid;

    @Column(name = "UNEUNEGOCIOID")
    @Id
    public Integer getUneunegocioid() {
        return uneunegocioid;
    }

    public void setUneunegocioid(Integer uneunegocioid) {
        this.uneunegocioid = uneunegocioid;
    }

    @Column(name = "TURTURNOID")
    @Id
    public Integer getTurturnoid() {
        return turturnoid;
    }

    public void setTurturnoid(Integer turturnoid) {
        this.turturnoid = turturnoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTurnoPK saTurnoPK = (SaTurnoPK) o;

        if (uneunegocioid != saTurnoPK.uneunegocioid) return false;
        if (turturnoid != saTurnoPK.turturnoid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uneunegocioid ^ (uneunegocioid >>> 32));
        result = 31 * result + (int) (turturnoid ^ (turturnoid >>> 32));
        return result;
    }
}
