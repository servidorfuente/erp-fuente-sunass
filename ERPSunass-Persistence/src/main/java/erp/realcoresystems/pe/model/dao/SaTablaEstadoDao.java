package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaTablaEstado;

public interface SaTablaEstadoDao extends AbstractDao<SaTablaEstado, String>{

	public List<SaTablaEstado> listarEstadosPorTabla(int id_Tabla);
	public List<SaTablaEstado> listarEstadoEn(int id_Tabla, Integer[] en);
	public List<SaTablaEstado> listarEstadoNoIgualA(int id_Tabla, Integer[] fuera);
	public SaTablaEstado obtenerPorId(int id_estado);
	public List<SaTablaEstado> listarEstados(int id_Tabla, Integer[] en);
}
