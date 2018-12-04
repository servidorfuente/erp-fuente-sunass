package erp.realcoresystems.pe.controller.gestion;


import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.service.CompaniaOwnerService;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "cargainicialBean")
@ViewScoped
public class CargainicialBean extends AbstractGenericBean implements InterfaceGenericBean {

    @ManagedProperty(value="#{companiaOwnerService}")
    private CompaniaOwnerService companiaOwnerService;

    @ManagedProperty(value = "#{maMiscelaneosdetalleService}")
    private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

    private List<MaMiscelaneosdetalle> maMisDestalleTipoFrencuencia;
    private List<MaMiscelaneosdetalle> maMisDestalleEstadoDocumento;


    @Override
    public void cargarObjetoFiltros(int first, int pageSize, int counter) {

    }

    @Override
    public void btnBuscar() {

    }

    @Override
    public void btnGuardar() {

    }

    @Override
    public void btnAceptar() {

    }

    @Override
    public void btnCancelar() {

    }

    @Override
    public void btnNuevo() {

    }

    @Override
    public void btnModificar() {

    }

    @Override
    public void btnVer() {

    }

    @Override
    public void btnEliminar() {

    }

    @Override
    public void abrirRegistro() {

    }
}

