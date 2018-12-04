package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PrProcesoperiodoPK implements Serializable {
    private String companiasocio;
    private String periodo;
    private String tipoplanilla;
    private String tipoproceso;

    @Column(name = "COMPANIASOCIO")
    @Id
    public String getCompaniasocio() {
        return companiasocio;
    }

    public void setCompaniasocio(String companiasocio) {
        this.companiasocio = companiasocio;
    }

    @Column(name = "PERIODO")
    @Id
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Column(name = "TIPOPLANILLA")
    @Id
    public String getTipoplanilla() {
        return tipoplanilla;
    }

    public void setTipoplanilla(String tipoplanilla) {
        this.tipoplanilla = tipoplanilla;
    }

    @Column(name = "TIPOPROCESO")
    @Id
    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }


}
