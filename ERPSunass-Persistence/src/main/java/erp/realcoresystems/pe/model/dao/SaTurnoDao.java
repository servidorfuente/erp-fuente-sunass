package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTurno;
import erp.realcoresystems.pe.model.domain.SaTurnoPK;

public interface SaTurnoDao extends AbstractDao<SaTurno, SaTurnoPK> {

	public List<SaTurno> listarTodos(SaTurno filtro);
	public SaTurno obtenerTurno(SaTurno filtro);
	public int guardar(SaTurno filtro) ;
	public int eliminar(SaTurno filtro);
	public List<SaTurno> validate(SaTurno filtro);
	public int actualizar(SaTurno filtro);
	public int contador(SaTurno filtro);
	public List<SaTurno> listar(SaTurno filtro);
}
