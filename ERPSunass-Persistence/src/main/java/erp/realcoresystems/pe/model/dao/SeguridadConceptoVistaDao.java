package erp.realcoresystems.pe.model.dao;

import erp.realcoresystems.pe.model.domain.Vistaconceptoautoriza;

import java.util.ArrayList;
import java.util.List;

public interface SeguridadConceptoVistaDao extends AbstractDao<Vistaconceptoautoriza, String>{
   public List<Vistaconceptoautoriza> SeguridadConceptoVistaLista(Vistaconceptoautoriza vistaconceptoautoriza, ArrayList<String> elemIn);
   public Vistaconceptoautoriza SeguridadConceptoVistaBuscar(Vistaconceptoautoriza objPersonaMast, ArrayList<String> elemIn);
   
   
   public List<Vistaconceptoautoriza> listarElementos(Vistaconceptoautoriza vistaconceptoautoriza);
}

