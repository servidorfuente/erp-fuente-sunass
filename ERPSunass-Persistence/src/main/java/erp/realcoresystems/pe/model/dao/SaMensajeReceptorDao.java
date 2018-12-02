package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaMensajeReceptor;
import erp.realcoresystems.pe.model.domain.vista.VwMensajeReceptor;

public interface SaMensajeReceptorDao {
	public  SaMensajeReceptor obtenerPorID(Long id);
	public List<SaMensajeReceptor> listarElementos(SaMensajeReceptor objDao, boolean paginable);	
		
	public long guardar(SaMensajeReceptor objDao);	
	public int eliminar(SaMensajeReceptor objDao);
	public int actualizar(SaMensajeReceptor objDao);	
	
	public int contarElementos(SaMensajeReceptor objDao);
	
	public List<VwMensajeReceptor> listarElementos(VwMensajeReceptor objDao, boolean paginable);
	public int contarElementos(VwMensajeReceptor objDao);
}
