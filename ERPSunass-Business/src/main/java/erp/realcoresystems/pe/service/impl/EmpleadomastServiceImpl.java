package erp.realcoresystems.pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.EmpleadomastDao;
import erp.realcoresystems.pe.model.dao.SaDependenciasDao;
import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.SaDependencias;
import erp.realcoresystems.pe.model.domain.vista.VwEmpleado;
import erp.realcoresystems.pe.service.EmpleadomastService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

import java.util.List;

@Service("empleadoService")
@Transactional(readOnly = true)
public class EmpleadomastServiceImpl implements EmpleadomastService {

	@Autowired
	private EmpleadomastDao empleadoDao;

	@Autowired
	private SaDependenciasDao saDependenciasDao;

	@Override
	public Empleadomast obtenerPorId(int empleadoId) {
		try {
			Empleadomast empleado = empleadoDao.obtenerPorId(empleadoId);
			if (empleado != null) {
				SaDependencias organigrama = saDependenciasDao.obtenerPorID(empleado.getPosicionorganigrama());
				if (organigrama != null) {
					empleado.setOrganigrama(organigrama);
				} else {
					empleado.setOrganigrama(new SaDependencias());
				}
			}
			return empleado;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Empleadomast> listar(Empleadomast empleado) {
		try {
			return empleadoDao.listar(empleado);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int guardar(Empleadomast empleado) {
		try {
			return empleadoDao.guardar(empleado);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int actualizar(Empleadomast empleado) {
		try {
			return empleadoDao.actualizar(empleado);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int eliminar(Empleadomast empleado) {
		try {
			return empleadoDao.eliminar(empleado);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public int contarTotal(Empleadomast empleado) {
		try {
			return empleadoDao.contador(empleado);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}
	
	@Override
	public List<Empleadomast> obtenerPorDependencia(SaDependencias dependencia){
		try {
			return empleadoDao.obtenerPorDependencia(dependencia);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
	
	@Override
	public List<VwEmpleado> listar(VwEmpleado filtro, boolean paginable){
		try{
			return empleadoDao.listar(filtro, paginable);
		}catch(Exception ex){
			Log.logger.error(Log.getStackTrace(ex));
			return null;
		}
	}
	
	@Override
	public List<VwEmpleado> listarParaEnviarTramite(VwEmpleado filtro, boolean paginable){
		//METODO QUE VA A LISTAR A LOS EMPLEADOS POR DEFAULT DE UNA DEPENDENCIA PARA ENVIARLES UN AVISO POR CORREO.
		try{
			filtro.setFlagsmf(Constant.SI_db);
			List<VwEmpleado> empleados = empleadoDao.listar(filtro, paginable);
			if(empleados == null || empleados.isEmpty()){
				//SI NO HAY EMPLEADOS POR DEFAULT PARA ENVIAR TRAE A TODOS LOS EMPLEADOS DE LA DEPENDENCIA Y LES ENVIA A ELLOS.
				filtro.setFlagsmf(null);
				empleados = empleadoDao.listar(filtro, paginable);
			}
			return empleados;
		}catch(Exception ex){
			Log.logger.error(Log.getStackTrace(ex));
			return null;
		}
	}
}
