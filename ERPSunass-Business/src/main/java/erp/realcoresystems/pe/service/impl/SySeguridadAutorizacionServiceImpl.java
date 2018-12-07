package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.AcSucursalDao;
import erp.realcoresystems.pe.model.dao.SyAutorizacionSeguridadDao;
import erp.realcoresystems.pe.model.domain.AcSucursal;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.service.SySeguridadAutorizacionService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;
import erp.realcoresystems.pe.util.UtilesService;

@Service("SySeguridadAutorizacionService")
@Transactional(readOnly = true)
public class SySeguridadAutorizacionServiceImpl implements SySeguridadAutorizacionService {

	@Autowired
	private SyAutorizacionSeguridadDao sySeguridadAutorizacionDao;

	@Autowired
	private AcSucursalDao acSucursalDao;

	@Override
	@Transactional
	public int guardarSeguridadAutorizaciones(List<SySeguridadautorizaciones> listadoSySeguridad,
			SySeguridadautorizaciones sySeguridadautorizaciones) {

		try {
			List<SySeguridadautorizaciones> listaAgregarSySeguridad = new ArrayList<SySeguridadautorizaciones>();
			int res = 0;						
			res = sySeguridadAutorizacionDao.eliminarSeguridadAutorizaciones(sySeguridadautorizaciones);			
			for (SySeguridadautorizaciones s : listadoSySeguridad) {
				if (s.getGrupo().equals(
						Constant.SUCURSAL)) {/* VALIDAR SI ES SUCURSAL */
					SySeguridadautorizaciones bean = new SySeguridadautorizaciones();
					bean.setAplicacioncodigo(s.getAplicacioncodigo());
					bean.setGrupo(Constant.COMPANIA);
					bean.setConcepto(s.getConceptoMaster());
					bean.setUsuario(s.getUsuario());
					bean.setEstado(Constant.ACTIVO);
					bean.setUltimousuario(s.getUltimousuario());
					bean.setUltimafechamodif(s.getUltimafechamodif());
					/******* PARA AUDITORÍA ******/
					bean = (SySeguridadautorizaciones) UtilesService.setGetRegistroAuditoriaDeEntGlobal(sySeguridadautorizaciones,
							bean ,null,null);//OBS//SETCLASS AUDIT
					/**************************/						
					if (listaAgregarSySeguridad.size() == 0) {
						listaAgregarSySeguridad.add(bean);
					} else {
						boolean agregar = true;
						for (SySeguridadautorizaciones sys : listaAgregarSySeguridad) {
							if (sys.getConcepto().equals(bean.getConcepto())) {
								agregar = false;
								break;
							}
						}
						if (agregar) {											
							listaAgregarSySeguridad.add(bean);
						}
					}
				}else{
					/******* PARA AUDITORÍA ******/
					s = (SySeguridadautorizaciones) UtilesService.setGetRegistroAuditoriaDeEntGlobal(sySeguridadautorizaciones,
							s,null,null);//OBS//SETCLASS AUDIT
					/**************************/	
				}
			}
			listaAgregarSySeguridad.addAll(listadoSySeguridad);
			res = sySeguridadAutorizacionDao.guardarSeguridadAutorizaciones(listaAgregarSySeguridad);
			//listaAgregarSySeguridad.clear();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override /** YA SE AGREGO ESTADO **/
	public List<SySeguridadautorizaciones> listadoSySeguridadPorGrupo(
			SySeguridadautorizaciones sySeguridadautorizaciones) {

		try {
			List<SySeguridadautorizaciones> lista = sySeguridadAutorizacionDao
					.listadoSySeguridad(sySeguridadautorizaciones);
			for (SySeguridadautorizaciones bean : lista) {
				AcSucursal acSucursal = (AcSucursal) acSucursalDao.findById(bean.getConcepto());
				bean.setDescripcionlarga(acSucursal.getCompanyowner());
				bean.setDescripcionlocal(acSucursal.getDescripcionlocal());
				bean.setConceptoMaster(acSucursal.getCompanyowner());
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return null;
	}

}
