package erp.realcoresystems.pe.service;

import java.util.List;
import java.util.Map;

import erp.realcoresystems.pe.model.domain.SaTablaEstado;

public interface SaTablaEstadoService {

	public List<SaTablaEstado> listarEstadosPorTabla(int id_Tabla);
	public List<SaTablaEstado> listarEstadoEn(int id_Tabla, Integer[] en);
	public List<SaTablaEstado> listarEstadoNoIgualA(int id_Tabla, Integer[] fuera);
	
	public Map<Integer, SaTablaEstado> listarEstadosActivosPorTabla(int id_Tabla);
	public List<SaTablaEstado> listarEstados(int id_Tabla, Integer[] en);
	
}
