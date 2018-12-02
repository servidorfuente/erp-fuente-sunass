package erp.realcoresystems.pe.service;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;


import java.util.List;
import java.util.Map;

public interface MaMiscelaneosdetalleService {

    public List<MaMiscelaneosdetalle> CombosGenericos(MaMiscelaneosdetalle maMiscelaneosdetalle);
    
    public List<MaMiscelaneosdetalle> listarElementos(MaMiscelaneosdetalle maMiscelaneosdetalle);
    public MaMiscelaneosdetalle obtenerPorID(MaMiscelaneosdetalle maMiscelaneosdetalle);
    
	public List<MaMiscelaneosdetalle> listarElementosPag(MaMiscelaneosdetalle filtro);
	
	public int guardar(MaMiscelaneosdetalle objDao, String _creador, String _ip);
	public int crear(MaMiscelaneosdetalle objDao, String _creador, String _ip);
	public int actualizar(MaMiscelaneosdetalle objDao, String _creador, String _ip);
	
	public String guardarCorrelativo(MaMiscelaneosdetalle objDao, String _creador, String _ip);
	public String actualizarCorrelativo(MaMiscelaneosdetalle objDao, String _creador, String _ip);
	
	public int contadorTotaleslistarElementos(MaMiscelaneosdetalle filtro);
	
	public List<MaMiscelaneosdetalle> listarTipoReservaPorArea(MaMiscelaneosdetalle maMiscelaneosdetalle);
	
	public List<MaMiscelaneosdetalle> listarDetalles(MaMiscelaneosdetalle filtro);
	
	public Map<String, MaMiscelaneosdetalle> mapearDetalles(MaMiscelaneosdetalle filtro);
	

	public boolean verificarDuplicidad(MaMiscelaneosdetalle filtro);	
	public int guardar(MaMiscelaneosdetalle objSave);
	public int actualizar(MaMiscelaneosdetalle objSave);
	public int eliminar(MaMiscelaneosdetalle objSave);
}
