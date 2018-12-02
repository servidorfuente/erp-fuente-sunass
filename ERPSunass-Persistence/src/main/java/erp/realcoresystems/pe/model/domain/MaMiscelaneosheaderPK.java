package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mamania on 29/12/2015.
 */
public class MaMiscelaneosheaderPK implements Serializable {
    private String aplicacioncodigo;
    private String codigotabla;
    private String compania;

    @Column(name = "APLICACIONCODIGO")
    @Id
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Column(name = "CODIGOTABLA")
    @Id
    public String getCodigotabla() {
        return codigotabla;
    }

    public void setCodigotabla(String codigotabla) {
        this.codigotabla = codigotabla;
    }

    @Column(name = "COMPANIA")
    @Id
    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaMiscelaneosheaderPK that = (MaMiscelaneosheaderPK) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (codigotabla != null ? !codigotabla.equals(that.codigotabla) : that.codigotabla != null) return false;
        if (compania != null ? !compania.equals(that.compania) : that.compania != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (codigotabla != null ? codigotabla.hashCode() : 0);
        result = 31 * result + (compania != null ? compania.hashCode() : 0);
        return result;
    }
}
