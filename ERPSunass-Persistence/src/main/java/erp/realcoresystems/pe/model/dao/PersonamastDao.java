package erp.realcoresystems.pe.model.dao;


import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;

import java.util.List;

public interface PersonamastDao extends AbstractDao<Personamast, Integer>{
	
   public Personamast obtenerPorId(int personaId);
   public List<Personamast> PersonamastListar(Personamast objPersonaMast);
   public Personamast PersonaContacto(Personamast objPersonaMast);
   public int contadorTotalesPersona(Personamast objPersonaMast);
   public int guardar(Personamast objPersonaMast);
   public int guardarPersona(Personamast objPersonaMast);
   public int actualizarPersona(Personamast objPersonaMast);
   public List<Personamast> obtenerPorDocumento(int tipo, String documento);
   public int forzarActualizar(Personamast personamast);
   
   public List<Personamast> listarElementos(Personamast objPersonaMast);
   public List<Personamast> validate(Personamast objPersonaMast);
   
   public List<VwPersonaGeneral> listar(VwPersonaGeneral filtro, boolean paginable);
   public int contar(VwPersonaGeneral filtro);
}

