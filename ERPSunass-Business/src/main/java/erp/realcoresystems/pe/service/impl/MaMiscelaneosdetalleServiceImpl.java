package erp.realcoresystems.pe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaMiscelaneosdetalleDao;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;

import erp.realcoresystems.pe.model.util.ValorRetorno;
import erp.realcoresystems.pe.service.MaMiscelaneosdetalleService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;
import erp.realcoresystems.pe.util.UtilesService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("maMiscelaneosdetalleService")
@Transactional(readOnly = true)
public class MaMiscelaneosdetalleServiceImpl implements MaMiscelaneosdetalleService {

	@Autowired
	private MaMiscelaneosdetalleDao maMiscelaneosdetalleDao;


	
	//@Autowired
	//private MoodleSoaService moodleService;
	
	@Override
	public List<MaMiscelaneosdetalle> CombosGenericos(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		try {
			List<MaMiscelaneosdetalle> objList = new ArrayList<MaMiscelaneosdetalle>();
			MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
			if (maMiscelaneosdetalle.getCodigotabla().equals("compania")) {
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("1");
				obj.setDescripcionlocal("UNIVERSIDAD DEL PERU");
				objList.add(obj);
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("2");
				obj.setDescripcionlocal("INSTITUTO DEL PERU");
				objList.add(obj);
			}
			if (maMiscelaneosdetalle.getCodigotabla().equals("sede")) {
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("1");
				obj.setDescripcionlocal("Central - Lima");
				objList.add(obj);
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("2");
				obj.setDescripcionlocal("Sede - Chosica");
				objList.add(obj);
			}
			if (maMiscelaneosdetalle.getCodigotabla().equals("mestudio")) {
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("1");
				obj.setDescripcionlocal("Centro de Produccion");
				objList.add(obj);
				obj = new MaMiscelaneosdetalle();
				obj.setCodigoelemento("2");
				obj.setDescripcionlocal("Pre-Grado");
				objList.add(obj);
			}
			return objList;

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<MaMiscelaneosdetalle> listarElementos(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		try {
			List<MaMiscelaneosdetalle> listaMisce = new ArrayList<MaMiscelaneosdetalle>();
			//OBS: LISTAR SOLO LOS ACTIVOS: 16-06-16
			maMiscelaneosdetalle.setEstado(Constant.ACTIVO);
			listaMisce =  maMiscelaneosdetalleDao.listarElementos(maMiscelaneosdetalle);			
			
			//****ADD PARA OBTENER UN OBJ EXTRA
			if("ADD_CODELEMENTO".equals(maMiscelaneosdetalle.getFlagConsultaEntGlobal())){
				List<MaMiscelaneosdetalle> listaMisceAux = new ArrayList<MaMiscelaneosdetalle>();
				if(listaMisce== null){
					listaMisce = new ArrayList<MaMiscelaneosdetalle>();
				}
				maMiscelaneosdetalle.setEstado(null);
				maMiscelaneosdetalle.setCodigoelemento(maMiscelaneosdetalle.getString1());
				listaMisceAux =  maMiscelaneosdetalleDao.listarElementos(maMiscelaneosdetalle);
				if(listaMisceAux!=null){
					listaMisce.addAll(listaMisceAux);
				}
			}
			//****
			
			return listaMisce;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

	@Override
	public MaMiscelaneosdetalle obtenerPorID(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		try {
			return maMiscelaneosdetalleDao.obtenerPorID(maMiscelaneosdetalle);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<MaMiscelaneosdetalle> listarElementosPag(MaMiscelaneosdetalle filtro) {
		try {
			return maMiscelaneosdetalleDao.listarElementosPag(filtro);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return UtilesCommons.getNewList();
		}
	}

	@Override
	@Transactional
	public int guardar(MaMiscelaneosdetalle objDao, String _creador, String _ip) {
		try {
			objDao.setUltimafechamodif(new Date());
			objDao.setUltimousuario(_creador);
			return maMiscelaneosdetalleDao.guardar(objDao);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));

		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int crear(MaMiscelaneosdetalle objDao,String _creador, String _ip) {
		int result = 0;
		try {
			objDao.setUltimafechamodif(new Date());
			objDao.setUltimousuario(_creador);
			if(objDao.getCodigotabla().equalsIgnoreCase(Constant.MISCELANEO_DETALLE_AREACURSO)){
				if(UtilesService.noEsVacio(objDao.getString10()) && objDao.getString10().equalsIgnoreCase(Constant.SI_db)){
					//objDao = moodleService.crearCategoria(objDao);
				}
			}
			result = maMiscelaneosdetalleDao.crear(objDao);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			Log.logger.error(Log.getStackTrace(e));
			result = 0;
		}
		return result;
	}

	@Override
	@Transactional
	public int actualizar(MaMiscelaneosdetalle objDao, String _creador, String _ip) {
		try {
			objDao.setUltimafechamodif(new Date());
			objDao.setUltimousuario(_creador);
			if(objDao.getCodigotabla().equalsIgnoreCase(Constant.MISCELANEO_DETALLE_AREACURSO)){
				if(UtilesService.noEsVacio(objDao.getString10()) && objDao.getString10().equalsIgnoreCase(Constant.SI_db)){
					//objDao = moodleService.guardarCategoria(objDao);
				}
			}
			int result = maMiscelaneosdetalleDao.actualizar(objDao);
			return result;
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	public int contadorTotaleslistarElementos(MaMiscelaneosdetalle filtro) {
		try {
			return maMiscelaneosdetalleDao.contadorTotaleslistarElementos(filtro);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}
	
	@Override
	public List<MaMiscelaneosdetalle> listarTipoReservaPorArea(MaMiscelaneosdetalle maMiscelaneosdetalle){
		try {
			return maMiscelaneosdetalleDao.listarTipoReservaPorArea(maMiscelaneosdetalle);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}
	
	@Override
	public List<MaMiscelaneosdetalle> listarDetalles(MaMiscelaneosdetalle filtro){
		try{
			return maMiscelaneosdetalleDao.listarElementos(filtro);
		}catch(Exception e){
			Log.error(e, "MaMiscelaneoDetalleService :: listarDetalles");
			return UtilesCommons.getNewList();
		}
	}
	
	@Override
	public Map<String, MaMiscelaneosdetalle> mapearDetalles(MaMiscelaneosdetalle filtro){
		Map<String, MaMiscelaneosdetalle> map = UtilesService.getNewLinkedHashMap();
		try{
			List<MaMiscelaneosdetalle> list =  maMiscelaneosdetalleDao.listarElementos(filtro);
			if(UtilesService.noEsVacio(list)){
				for(MaMiscelaneosdetalle detalle : list){
					map.put(detalle.getCodigoelemento(), detalle);
				}
			}
			return map;
		}catch(Exception e){
			Log.error(e, "MaMiscelaneoDetalleService :: listarDetalles");
			return map;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public String guardarCorrelativo(MaMiscelaneosdetalle objDao, String _creador, String _ip) {
		try {
			if(maMiscelaneosdetalleDao.verificarDuplicidad(objDao)){
				objDao.setUltimafechamodif(new Date());
				objDao.setUltimousuario(_creador);
				return maMiscelaneosdetalleDao.guardarCorrelativo(objDao) == ValorRetorno.GUARDO ? ValorRetorno.OK : ValorRetorno.ERROR;
			}else{
				return ValorRetorno.DUPLICADO;
			}
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return "";
	}

	@Override
	@Transactional(readOnly = false)
	public String actualizarCorrelativo(MaMiscelaneosdetalle objDao, String _creador, String _ip) {
		try {
			if(maMiscelaneosdetalleDao.verificarDuplicidad(objDao)){
				objDao.setUltimafechamodif(new Date());
				objDao.setUltimousuario(_creador);
				return maMiscelaneosdetalleDao.actualizarCorrelativo(objDao) == ValorRetorno.GUARDO ? ValorRetorno.OK : ValorRetorno.ERROR;
			}else{
				return ValorRetorno.DUPLICADO;
			}
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return "";
	}



	@Override
	public boolean verificarDuplicidad(MaMiscelaneosdetalle filtro) {
		try {
			boolean verificar = false;
			int result = 0;
			List<MaMiscelaneosdetalle> busqueda = maMiscelaneosdetalleDao.busquedaDuplicidad(filtro);
			if(UtilesCommons.noEsVacio(busqueda)){
				for (MaMiscelaneosdetalle value : busqueda) {
					if(UtilesCommons.sonCadenasIguales(value.getDescripcionlocal(), filtro.getDescripcionlocal())){
						result++;						
					}	
					if(result > 1){
						verificar = true;
						break;
					}
				}
			}
			return verificar;		
			 
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
		}
		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(MaMiscelaneosdetalle objSave) {
		try {
			return maMiscelaneosdetalleDao.guardarCorrelativo(objSave);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MaMiscelaneosdetalle objSave) {
		try {
			return maMiscelaneosdetalleDao.actualizarCorrelativo(objSave);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MaMiscelaneosdetalle objSave) {
		try {
			return maMiscelaneosdetalleDao.eliminarCorrelativo(objSave);
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}

}