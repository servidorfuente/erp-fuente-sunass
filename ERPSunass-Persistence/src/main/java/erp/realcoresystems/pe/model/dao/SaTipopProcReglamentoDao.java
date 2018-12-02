
package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTipopProcReglamento;


public interface SaTipopProcReglamentoDao extends AbstractDao<SaTipopProcReglamento, Integer>  {
	
	public SaTipopProcReglamento obtenerTipoPorId(Integer id);
	
	public List<SaTipopProcReglamento> listarTipo(SaTipopProcReglamento saTipopProcReglamento);
	
	public int contarTipo(SaTipopProcReglamento saTipopProcReglamento);
	
	public List<SaTipopProcReglamento> listarCombo(SaTipopProcReglamento saTipopProcReglamentoId);
	
	public int guardarTipo(SaTipopProcReglamento saTipopProcReglamento);
	
	public int actualizarTipo(SaTipopProcReglamento saTipopProcReglamento);
	
	public int eliminarTipo(SaTipopProcReglamento saTipopProcReglamento);
	

}
