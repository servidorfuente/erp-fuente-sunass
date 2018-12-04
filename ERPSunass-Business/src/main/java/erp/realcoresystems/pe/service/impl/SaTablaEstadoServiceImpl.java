
package erp.realcoresystems.pe.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTablaEstadoDao;
import erp.realcoresystems.pe.model.domain.SaTablaEstado;
import erp.realcoresystems.pe.service.SaTablaEstadoService;
import erp.realcoresystems.pe.util.Log;

@Service("SaTablaEstadoService")
public class SaTablaEstadoServiceImpl implements SaTablaEstadoService {

	@Autowired
	SaTablaEstadoDao saTablaEstadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<SaTablaEstado> listarEstadosPorTabla(int id_Tabla) {
		try {
			return saTablaEstadoDao.listarEstadosPorTabla(id_Tabla);
		} catch (Exception e) {
			Log.error(e,"SaTablaEstadoServiceImpl : listarEstadosPorTabla : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaTablaEstado> listarEstadoEn(int id_Tabla, Integer[] en) {
		try {
			return saTablaEstadoDao.listarEstadoEn(id_Tabla, en);
		} catch (Exception e) {
			Log.error(e,"SaTablaEstadoServiceImpl : listarEstadoEn : ");
		}
		return UtilesCommons.getNewList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<SaTablaEstado> listarEstados(int id_Tabla, Integer[] en) {
		try {
			return saTablaEstadoDao.listarEstados(id_Tabla, en);
		} catch (Exception e) {
			Log.error(e,"SaTablaEstadoServiceImpl : listarEstados : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaTablaEstado> listarEstadoNoIgualA(int id_Tabla,
			Integer[] fuera) {
		try {
			return saTablaEstadoDao.listarEstadoNoIgualA(id_Tabla, fuera);
		} catch (Exception e) {
			Log.error(e,"SaTablaEstadoServiceImpl : listarEstadoNoIgualA : ");
		}
		return UtilesCommons.getNewList();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Map<Integer, SaTablaEstado> listarEstadosActivosPorTabla(int id_Tabla){
		try{
			Map<Integer, SaTablaEstado> map_estados = new LinkedHashMap<Integer, SaTablaEstado>();
			List<SaTablaEstado> estados = saTablaEstadoDao.listarEstadosPorTabla(id_Tabla);
			for(SaTablaEstado estado : estados){
				map_estados.put(estado.getTbsestadoenlaceid(), estado);
			}
			return map_estados;
		}catch(Exception e){
			Log.error(e,"SaTablaEstadoServiceImpl : listarEstadoNoIgualA : ");
		}
		return UtilesCommons.getNewLinkedHashMap();
	}
}
