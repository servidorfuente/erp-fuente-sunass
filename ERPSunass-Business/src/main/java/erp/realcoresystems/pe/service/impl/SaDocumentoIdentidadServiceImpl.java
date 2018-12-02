package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTipoDocumentoIdentidadDao;
import erp.realcoresystems.pe.model.domain.SaTipoDocumentoIdentidad;
import erp.realcoresystems.pe.service.SaDocumentoIdentidadService;
import erp.realcoresystems.pe.util.Log;

@Service("saDocumentoIdentidadService")
@Transactional(readOnly = true)
public class SaDocumentoIdentidadServiceImpl implements SaDocumentoIdentidadService {

	@Autowired
	private SaTipoDocumentoIdentidadDao saTipoDocumentoIdentidadDao;


	@Override
	public SaTipoDocumentoIdentidad obtenerPorId(Integer id) {		
		return saTipoDocumentoIdentidadDao.findById(id);
	}
	
	@Override
	public List<SaTipoDocumentoIdentidad> listar(Integer[] arrayString) {
		try {
			return saTipoDocumentoIdentidadDao.listar(arrayString);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	
	@Override
	public List<SaTipoDocumentoIdentidad> listarTodos(SaTipoDocumentoIdentidad filtro,boolean paginable) {
		try {
			return saTipoDocumentoIdentidadDao.listarTodos(filtro,paginable);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();
	}

	
	@Override
	@Transactional(readOnly = false)
	public int guardar(SaTipoDocumentoIdentidad objSave) {
		try{			
			return saTipoDocumentoIdentidadDao.guardar(objSave);
		}catch(Exception e){
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}	
	}
	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaTipoDocumentoIdentidad objSave) {
		try {
			return saTipoDocumentoIdentidadDao.actualizar(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
		
	}

	@Transactional(readOnly = false)
	public int eliminar(SaTipoDocumentoIdentidad objSave) {
		try {
			return saTipoDocumentoIdentidadDao.eliminar(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	public List<SaTipoDocumentoIdentidad> validate(SaTipoDocumentoIdentidad objSave) {
		try {
			return saTipoDocumentoIdentidadDao.validate(objSave);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
		
		
	}

	

	@Override
	public int contador(SaTipoDocumentoIdentidad filtro) {
		try {
			return saTipoDocumentoIdentidadDao.contador(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
		
	}


}
