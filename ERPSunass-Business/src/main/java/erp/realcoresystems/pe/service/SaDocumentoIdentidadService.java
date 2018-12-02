package erp.realcoresystems.pe.service;

import java.util.List;
import erp.realcoresystems.pe.model.domain.SaTipoDocumentoIdentidad;

public interface SaDocumentoIdentidadService {

	public SaTipoDocumentoIdentidad obtenerPorId(Integer id);
	
	public List<SaTipoDocumentoIdentidad> listar(Integer[] arrayString);
	public List<SaTipoDocumentoIdentidad> listarTodos(SaTipoDocumentoIdentidad objSave, boolean paginable);
	public int guardar(SaTipoDocumentoIdentidad objSave);	
	public int actualizar(SaTipoDocumentoIdentidad objSave);	
	public int eliminar(SaTipoDocumentoIdentidad objSave);	
	public List<SaTipoDocumentoIdentidad> validate(SaTipoDocumentoIdentidad objSave);	
	public int contador(SaTipoDocumentoIdentidad filtro);
}
