package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaMensajeObjeto;
import erp.realcoresystems.pe.model.domain.vista.VwMensajeObjetoEmisor;

public interface SaMensajeObjetoDao {
	public  SaMensajeObjeto obtenerPorID(Long id);
	public List<SaMensajeObjeto> listarElementos(SaMensajeObjeto objDao, boolean paginable);	
		
	public long guardar(SaMensajeObjeto objDao);	
	public int eliminar(SaMensajeObjeto objDao);
	public int actualizar(SaMensajeObjeto objDao);	
	
	public int contarElementos(SaMensajeObjeto objDao);
	
	public List<VwMensajeObjetoEmisor> listarElementos(VwMensajeObjetoEmisor objDao, boolean paginable);
	public int contarElementos(VwMensajeObjetoEmisor objDao);
}
