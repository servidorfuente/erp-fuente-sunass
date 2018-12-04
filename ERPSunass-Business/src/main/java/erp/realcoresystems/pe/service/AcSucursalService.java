package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.AcSucursal;

public interface AcSucursalService {

	public List<AcSucursal> sucursalListar(AcSucursal acSucursal);
	public List<AcSucursal> sucursalListarPorAutorizacion(AcSucursal acSucursal);
}
