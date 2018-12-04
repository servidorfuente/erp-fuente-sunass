package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;

public interface MaMiscelaneosdetalleDao extends AbstractDao<MaMiscelaneosdetalle, String>  {	
	
	public MaMiscelaneosdetalle obtenerPorID(MaMiscelaneosdetalle objDao);
	public List<MaMiscelaneosdetalle> listarElementos(MaMiscelaneosdetalle objDao);	
	public List<MaMiscelaneosdetalle> listarElementosPag(MaMiscelaneosdetalle filtro);
	
	public int guardar(MaMiscelaneosdetalle objDao);
	public int crear(MaMiscelaneosdetalle objDao);
	public int actualizar(MaMiscelaneosdetalle objDao);
	public int eliminarCorrelativo(MaMiscelaneosdetalle objDao);
	
	public int guardarCorrelativo(MaMiscelaneosdetalle objDao);
	public int actualizarCorrelativo(MaMiscelaneosdetalle objDao);
	public boolean verificarDuplicidad(MaMiscelaneosdetalle objDao);
	
	public int contadorTotaleslistarElementos(MaMiscelaneosdetalle filtro);

	public List<MaMiscelaneosdetalle> listarTipoReservaPorArea(MaMiscelaneosdetalle maMiscelaneosdetalle);
	public List<MaMiscelaneosdetalle> busquedaDuplicidad(MaMiscelaneosdetalle objDao);
	
}
