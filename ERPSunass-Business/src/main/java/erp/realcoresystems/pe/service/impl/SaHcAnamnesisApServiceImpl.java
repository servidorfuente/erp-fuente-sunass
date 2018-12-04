package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.model.dao.SaHcAnamnesisApDao;
import erp.realcoresystems.pe.model.domain.SaHcAnamnesisAp;
import erp.realcoresystems.pe.model.domain.SaHcAnamnesisApPK;
import erp.realcoresystems.pe.service.SaHcAnamnesisApService;

@Service("saHcAnamnesisApService")
@Transactional(readOnly = true)
public class SaHcAnamnesisApServiceImpl implements SaHcAnamnesisApService {

	@Autowired
	SaHcAnamnesisApDao saHcAnamnesisApDao;
	
	@Override
	public SaHcAnamnesisAp obtenerPorID(SaHcAnamnesisApPK id) {	
		return saHcAnamnesisApDao.obtenerPorID(id);
	}

	@Override
	public List<SaHcAnamnesisAp> listarElementos(SaHcAnamnesisAp objDao, boolean paginable) {		
		return saHcAnamnesisApDao.listarElementos(objDao, paginable);
	}

	@Override
	public int contarElementos(SaHcAnamnesisAp objDao) {		
		return saHcAnamnesisApDao.contarElementos(objDao);
	}

	@Override
	@Transactional(readOnly = true)
	public int guardar(SaHcAnamnesisAp objDao) {	
		return saHcAnamnesisApDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = true)
	public int actualizar(SaHcAnamnesisAp objDao) {
		return saHcAnamnesisApDao.actualizar(objDao);
	}

	
	@Override
	@Transactional(readOnly = true)
	public int eliminar(SaHcAnamnesisAp objDao) {
		return saHcAnamnesisApDao.eliminar(objDao);
	}


}
