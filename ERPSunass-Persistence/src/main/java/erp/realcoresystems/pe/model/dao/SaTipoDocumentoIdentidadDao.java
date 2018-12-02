package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipoDocumentoIdentidad;


public interface SaTipoDocumentoIdentidadDao extends AbstractDao<SaTipoDocumentoIdentidad, Integer>{
	
	public List<SaTipoDocumentoIdentidad> listar(Integer[] arrayString);
	public List<SaTipoDocumentoIdentidad> listarTodos(SaTipoDocumentoIdentidad filtro,boolean paginable);
	public int guardar(SaTipoDocumentoIdentidad filtro) ;
	public int eliminar(SaTipoDocumentoIdentidad filtro);
	public List<SaTipoDocumentoIdentidad> validate(SaTipoDocumentoIdentidad filtro);
	public int actualizar(SaTipoDocumentoIdentidad filtro);
	public int contador(SaTipoDocumentoIdentidad filtro);
}
