package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaMiscelaneosdetalleDao;
import erp.realcoresystems.pe.model.dao.SaMiscelaneosHeaderDao;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosheader;
import erp.realcoresystems.pe.service.SaMiscelaneosHeaderService;
import erp.realcoresystems.pe.util.Log;

@Service("maMiscelaneosheaderService")
@Transactional(readOnly = true)
public class SaMiscelaneosheaderServiceImpl implements SaMiscelaneosHeaderService {

	private SaMiscelaneosHeaderDao maMiscelaneosHeaderDao;
	private MaMiscelaneosdetalleDao miscelaneoDetalleDao;

	@Autowired
	public void setMaMiscelaneosHeaderDao(SaMiscelaneosHeaderDao maMiscelaneosHeaderDao) {
		this.maMiscelaneosHeaderDao = maMiscelaneosHeaderDao;
	}

	@Autowired
	public void setMiscelaneoDetalleDao(MaMiscelaneosdetalleDao miscelaneoDetalleDao) {
		this.miscelaneoDetalleDao = miscelaneoDetalleDao;
	}

	@Override
	public List<MaMiscelaneosheader> listarElementos(MaMiscelaneosheader maMiscelaneosheader) {
		try {
			return maMiscelaneosHeaderDao.listarElementos(maMiscelaneosheader);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();

	}

	@Override
	public List<MaMiscelaneosheader> listar(MaMiscelaneosheader maMiscelaneosheader, boolean paginable) {
		try {
			return maMiscelaneosHeaderDao.listar(maMiscelaneosheader, paginable);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return UtilesCommons.getNewList();

	}

	@Override
	public int contar(MaMiscelaneosheader filtro) {
		try {
			return maMiscelaneosHeaderDao.contar(filtro);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return 0;

	}

	@Override
	public MaMiscelaneosheader obtenerPorID(MaMiscelaneosheader maMiscelaneosheader) {
		try {
			return maMiscelaneosHeaderDao.obtenerPorID(maMiscelaneosheader);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(MaMiscelaneosheader objSave) {
		try {
			return maMiscelaneosHeaderDao.guardar(objSave);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MaMiscelaneosheader objSave) {
		try {
			return maMiscelaneosHeaderDao.actualizar(objSave);
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MaMiscelaneosheader objSave) {
		try {

			MaMiscelaneosdetalle filtro = new MaMiscelaneosdetalle();
			filtro.setAplicacioncodigo(objSave.getAplicacioncodigo());
			filtro.setCompania(objSave.getCompania());
			filtro.setCodigotabla(objSave.getCodigotabla());
			List<MaMiscelaneosdetalle> list = miscelaneoDetalleDao.listarElementos(filtro);
			 
			if (UtilesCommons.noEsVacio(list)) {
				for (MaMiscelaneosdetalle obj : list) {
					miscelaneoDetalleDao.delete(obj);
				}
			}

			maMiscelaneosHeaderDao.eliminar(objSave);

			return 1;
		} catch (Exception ex) {
			Log.logger.error(Log.getStackTrace(ex));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}
}
