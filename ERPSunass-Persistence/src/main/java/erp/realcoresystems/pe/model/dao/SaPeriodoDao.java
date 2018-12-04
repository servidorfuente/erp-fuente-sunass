package erp.realcoresystems.pe.model.dao;

import java.util.Date;
import java.util.List;
import erp.realcoresystems.pe.model.domain.SaPeriodo;

public interface SaPeriodoDao extends AbstractDao<SaPeriodo, Integer> {

	public SaPeriodo obtenerPorId(Integer unidadNegocioId, Integer modalidadEstudioId, Integer periodoId);
	public List<SaPeriodo> validate(SaPeriodo saPeriodo);
	public SaPeriodo periodoActivo(SaPeriodo saPeriodo);
	public SaPeriodo obtenerPorID(SaPeriodo saPeriodo);
	public List<SaPeriodo> listar(SaPeriodo saPeriodo,boolean paginable);
	public List<SaPeriodo> listarCombo(SaPeriodo saPeriodo);
	
	public int contador(SaPeriodo saPeriodo);
	public List<SaPeriodo> listarPorNegocio(SaPeriodo saPeriodo);
	public List<SaPeriodo> obtenerPorFecha(SaPeriodo saPeriodo, Date fecha);
	public Integer obtenerPeriodoActual(SaPeriodo saPeriodo);
	
	
	public int guardar(SaPeriodo saPeriodo);
	public int actualizar(SaPeriodo objDao);
	public int eliminar(SaPeriodo saPeriodo);
}
