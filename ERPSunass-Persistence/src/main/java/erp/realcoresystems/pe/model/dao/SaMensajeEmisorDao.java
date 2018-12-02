package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaMensajeEmisor;

public interface SaMensajeEmisorDao {
	public  SaMensajeEmisor obtenerPorID(Long id);
	public List<SaMensajeEmisor> listarElementos(SaMensajeEmisor objDao, boolean paginable);	
		
	public long guardar(SaMensajeEmisor objDao);	
	public int eliminar(SaMensajeEmisor objDao);
	public int actualizar(SaMensajeEmisor objDao);	
	
	public int contarElementos(SaMensajeEmisor objDao);
}
