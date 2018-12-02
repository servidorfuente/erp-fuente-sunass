package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.SaPersonaRelacionesDao;
import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;
import erp.realcoresystems.pe.service.SaPersonaRelacionesService;
import erp.realcoresystems.pe.util.Log;

@Service("saPersonaRelacionesService")
@Transactional(readOnly = true)
public class SaPersonaRelacionesServiceImpl implements SaPersonaRelacionesService {
	
	@Autowired
	SaPersonaRelacionesDao saPersonaRelacionesDao;

	@Override
	public SaPersonaRelaciones obtenerPorId(Long id) {		
		return saPersonaRelacionesDao.findById(id);
	}

	@Override
	public List<SaPersonaRelaciones> listarElementos(SaPersonaRelaciones objDao, boolean paginable) {
		return saPersonaRelacionesDao.listarElementos(objDao,paginable);
	}

	@Override
	public int contarElementos(SaPersonaRelaciones objDao) {
		try{
			return saPersonaRelacionesDao.contarElementos(objDao);
		}catch(Exception e){
			Log.error(e, "contarElementos");
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public long guardar(SaPersonaRelaciones objDao) {	
		return saPersonaRelacionesDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SaPersonaRelaciones objDao) {
		return saPersonaRelacionesDao.actualizar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SaPersonaRelaciones objDao) {
		return saPersonaRelacionesDao.eliminar(objDao);
	}

}
