package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.AcCostCenterMst;

public interface AcCostCenterMstDao {

	/** Metodo para buscar u obtener **/
	public AcCostCenterMst obtenerPorID(String id);
	  
	/** Metodo para listar **/
	public List<AcCostCenterMst> listar(AcCostCenterMst objDao, boolean paginable);
	public int contar(AcCostCenterMst objDao);
		
	/** Metodo transaccionales **/	
	public int guardar(AcCostCenterMst objDao);	
	public int eliminar(AcCostCenterMst objDao);
	public int actualizar(AcCostCenterMst objDao);
		
	 
}
