package erp.realcoresystems.pe.service;


import java.util.List;

import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;

public interface SeguridadConceptoVistaService {
    public List<Vistaconceptoautoriza> SeguridadConceptoVistaLista(Vistaconceptoautoriza seguridadAutorizaciones);
    public Vistaconceptoautoriza SeguridadConceptoVistaBuscar(Vistaconceptoautoriza objPersonaMast);
}
