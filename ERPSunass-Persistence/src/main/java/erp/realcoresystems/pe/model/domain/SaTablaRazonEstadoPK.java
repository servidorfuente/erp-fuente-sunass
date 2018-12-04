package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SaTablaRazonEstadoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer tabtablaid;
    private Integer tbsestadoenlaceid;
    private Integer tbrrazon;

    @Column(name = "TABTABLAID")
    @Id
    public Integer getTabtablaid() {
        return tabtablaid;
    }

    public void setTabtablaid(Integer tabtablaid) {
        this.tabtablaid = tabtablaid;
    }

    @Column(name = "TBSESTADOENLACEID")
    @Id
    public Integer getTbsestadoenlaceid() {
        return tbsestadoenlaceid;
    }

    public void setTbsestadoenlaceid(Integer tbsestadoenlaceid) {
        this.tbsestadoenlaceid = tbsestadoenlaceid;
    }

    @Column(name = "TBRRAZON")
    @Id
    public Integer getTbrrazon() {
        return tbrrazon;
    }

    public void setTbrrazon(Integer tbrrazon) {
        this.tbrrazon = tbrrazon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTablaRazonEstadoPK that = (SaTablaRazonEstadoPK) o;

        if (tabtablaid != that.tabtablaid) return false;
        if (tbsestadoenlaceid != that.tbsestadoenlaceid) return false;
        if (tbrrazon != that.tbrrazon) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tabtablaid ^ (tabtablaid >>> 32));
        result = 31 * result + (int) (tbsestadoenlaceid ^ (tbsestadoenlaceid >>> 32));
        result = 31 * result + (int) (tbrrazon ^ (tbrrazon >>> 32));
        return result;
    }
}
