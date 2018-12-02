package erp.realcoresystems.pe.model.dao;

import java.util.List;
import erp.realcoresystems.pe.model.domain.AcSucursal;

public interface AcSucursalDao extends AbstractDao<AcSucursal, String> {

	public List<AcSucursal> sucursalListar(AcSucursal acSucursal);
	
	public String obtenerMaximo();
	
	public int guardar(AcSucursal acSucursal);
	
}
