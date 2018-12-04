package erp.realcoresystems.pe.model.dao;


import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;


import java.util.List;

public interface SeguridadConceptoDao extends AbstractDao<Seguridadconcepto, String>{
	
   public List<Seguridadconcepto> SeguridadConceptoLista(Seguridadautorizaciones seguridadAutorizaciones);
   
   public Seguridadconcepto obtenerPorId(Seguridadconcepto seguridadconcepto);
   public List<Seguridadconcepto> listar(Seguridadconcepto seguridadconcepto);
   public List<Seguridadconcepto> listarElementos(Seguridadconcepto seguridadconcepto,boolean paginable);
   public int contar(Seguridadconcepto seguridadconcepto);
   public int guardar(Seguridadconcepto seguridadconcepto);
   public int actualizar(Seguridadconcepto seguridadconcepto); 
   
   public Seguridadconcepto SeguridadConceptoBuscar(Seguridadconcepto objPersonaMast);
}

