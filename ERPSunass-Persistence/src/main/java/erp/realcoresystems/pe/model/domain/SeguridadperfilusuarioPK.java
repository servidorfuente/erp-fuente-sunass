package erp.realcoresystems.pe.model.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mamania on 29/12/2015.
 */
public class SeguridadperfilusuarioPK implements Serializable {
    private String perfil;
    private String usuario;

    @Column(name = "PERFIL")
    @Id
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Column(name = "USUARIO")
    @Id
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguridadperfilusuarioPK that = (SeguridadperfilusuarioPK) o;

        if (perfil != null ? !perfil.equals(that.perfil) : that.perfil != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = perfil != null ? perfil.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
