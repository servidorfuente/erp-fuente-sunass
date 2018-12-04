package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTurno;

public interface SaTurnoService {

	public List<SaTurno> listarTodos(SaTurno filtro);
	public SaTurno obtenerTurno(SaTurno filtro);
	public int guardar(SaTurno objSave);	
	public int actualizar(SaTurno objSave);	
	public int eliminar(SaTurno objSave);	
	public List<SaTurno> validate(SaTurno objSave);	
	public List<SaTurno> listar(SaTurno filtro);
	public int contador(SaTurno filtro);
}
