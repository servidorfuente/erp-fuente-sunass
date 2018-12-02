package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.AcSucursalDao;
import erp.realcoresystems.pe.model.dao.SyAutorizacionSeguridadDao;
import erp.realcoresystems.pe.model.domain.AcSucursal;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.service.AcSucursalService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("acSucursalService")
@Transactional(readOnly = true)
public class AcSucursalServiceImpl implements AcSucursalService{

    @Autowired
    private AcSucursalDao acSucursalDao;
    
    @Autowired
    private SyAutorizacionSeguridadDao syAutorizacionSeguridadDao;
    
	@Override
	public List<AcSucursal> sucursalListar(AcSucursal acSucursal) {
		try {
			
			return acSucursalDao.sucursalListar(acSucursal);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

	@Override
	public List<AcSucursal> sucursalListarPorAutorizacion(AcSucursal acSucursal) {
		try {
			SySeguridadautorizaciones sySeguridadautorizaciones = new SySeguridadautorizaciones();
		sySeguridadautorizaciones.setUsuario(acSucursal.getUsuarioEntGlobal());
		sySeguridadautorizaciones.setGrupo(Constant.SUCURSAL);
		sySeguridadautorizaciones.setEstado(Constant.ACTIVO);
		List<SySeguridadautorizaciones> listaAutorizaciones = syAutorizacionSeguridadDao.listadoSySeguridad(sySeguridadautorizaciones);
		List<AcSucursal> listaCompania = acSucursalDao.sucursalListar(acSucursal);
		List<AcSucursal> lista = new ArrayList<AcSucursal>();
		for (SySeguridadautorizaciones a : listaAutorizaciones) {
			for (AcSucursal s : listaCompania) {
				if(a.getConcepto().equals(s.getSucursal())){
					lista.add(s);
				}
			}			
		}
		return lista;
		
			
			
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));	
			return null;
		}
	}

}
