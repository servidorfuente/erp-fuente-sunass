package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaMensajeRecAdjunto;
import erp.realcoresystems.pe.model.domain.SaMensajeRecAdjuntoPK;

public interface SaMensajeRecAdjuntoDao {
	public  SaMensajeRecAdjunto obtenerPorID(SaMensajeRecAdjuntoPK id);
	public List<SaMensajeRecAdjunto> listarElementos(SaMensajeRecAdjunto objDao, boolean paginable);	
		
	public int guardar(SaMensajeRecAdjunto objDao);	
	public int eliminar(SaMensajeRecAdjunto objDao);
	public int actualizar(SaMensajeRecAdjunto objDao);	
	
	public int contarElementos(SaMensajeRecAdjunto objDao);
}
