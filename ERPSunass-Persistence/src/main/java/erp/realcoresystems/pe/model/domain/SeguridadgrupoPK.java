package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mamania on 22/12/2015.
 */
public class SeguridadgrupoPK implements Serializable {
    private String aplicacioncodigo;
    private String grupo;

    @Column(name = "APLICACIONCODIGO")
    @Id
    public String getAplicacioncodigo() {
        return aplicacioncodigo;
    }

    public void setAplicacioncodigo(String aplicacioncodigo) {
        this.aplicacioncodigo = aplicacioncodigo;
    }

    @Column(name = "GRUPO")
    @Id
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguridadgrupoPK that = (SeguridadgrupoPK) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        return result;
    }
}
