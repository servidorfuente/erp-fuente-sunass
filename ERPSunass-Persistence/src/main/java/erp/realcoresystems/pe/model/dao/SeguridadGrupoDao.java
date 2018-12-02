package erp.realcoresystems.pe.model.dao;


import erp.realcoresystems.pe.model.domain.Seguridadgrupo;



import java.util.List;

public interface SeguridadGrupoDao extends AbstractDao<Seguridadgrupo, String>{
	
   public List<Seguridadgrupo> SeguridadGrupoLista(Seguridadgrupo seguridadAutorizaciones);
   public Seguridadgrupo SeguridadGrupoBuscar(Seguridadgrupo objPersonaMast);
   
	public Seguridadgrupo obtenerTipoPorId(Integer id);
	public List<Seguridadgrupo> listarTipo(Seguridadgrupo seguridadgrupo);
	public int contarTipo(Seguridadgrupo seguridadgrupo);
	public List<Seguridadgrupo> listarCombo(Seguridadgrupo seguridadgrupoId);
	public int guardarTipo(Seguridadgrupo seguridadgrupo);
	
	
	public int actualizarTipo(Seguridadgrupo seguridadgrupo);
	public int eliminarTipo(Seguridadgrupo seguridadgrupo);
	
	public List<Seguridadgrupo> listarTodos(Seguridadgrupo seguridadgrupo,Boolean paginable);
	public int contarTodos(Seguridadgrupo seguridadgrupo);
	public List<Seguridadgrupo> validate(Seguridadgrupo seguridadgrupo);

}

