package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mamania on 14/01/2016.
 */
public class SaTablasconceptosPK implements Serializable {
    private String aplicacioncodigo;
    private String grupo;
    private String concepto;

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

    @Column(name = "CONCEPTO")
    @Id
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTablasconceptosPK that = (SaTablasconceptosPK) o;

        if (aplicacioncodigo != null ? !aplicacioncodigo.equals(that.aplicacioncodigo) : that.aplicacioncodigo != null)
            return false;
        if (grupo != null ? !grupo.equals(that.grupo) : that.grupo != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aplicacioncodigo != null ? aplicacioncodigo.hashCode() : 0;
        result = 31 * result + (grupo != null ? grupo.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        return result;
    }
}
