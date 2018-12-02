package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaUbigeoDao;
import erp.realcoresystems.pe.model.domain.SaDepartamento;
import erp.realcoresystems.pe.model.domain.SaProvincia;
import erp.realcoresystems.pe.model.domain.SaUbigeo;
import erp.realcoresystems.pe.model.domain.SaZonaPostal;
import erp.realcoresystems.pe.service.SaUbigeoService;
import erp.realcoresystems.pe.util.Log;

@Service("saUbigeoService")
@Transactional(readOnly = true)
public class SaUbigeoServiceImpl implements SaUbigeoService {

	@Autowired
	private SaUbigeoDao SaUbigeoDao;

	@Override
	public SaUbigeo obtenerUbigeoPorId(int id) {
		try {
			return SaUbigeoDao.obtenerUbigeoPorId(id);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : obtenerUbigeoPorId : ");
		}
		return null;
	}
	
	@Override
	public SaUbigeo obtenerPorCodigo(String ubigeo){
		try {
			return SaUbigeoDao.obtenerPorCodigo(ubigeo);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : obtenerPorCodigo : ");
			return null;
		}
	}

	@Override
	public List<SaUbigeo> listar(SaUbigeo objeto) {
		try {
			return SaUbigeoDao.listar(objeto);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listar : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SaDepartamento> listarDepartamento(String codigoPais) {
		try {
			return SaUbigeoDao.listarDepartamento(codigoPais);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarDepartamento : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SaProvincia> listarProvinciaPorDepartamento(String codigoPais, String codigoDepartamento) {
		try {
			return SaUbigeoDao.listarProvinciaPorDepartamento(codigoPais, codigoDepartamento);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarProvinciaPorDepartamento : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SaZonaPostal> listarDistritoPorProvincia(String codigoPais, String codigoDepartamento,
			String codigoProvincia) {
		try {
			return SaUbigeoDao.listarDistritoPorProvincia(codigoPais, codigoDepartamento, codigoProvincia);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarDistritoPorProvincia : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<String> listarComboDepartamentos(SaUbigeo ubigeo) {
		try {
			return SaUbigeoDao.listarComboDepartamentos(ubigeo);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboDepartamentos : ");
			return UtilesCommons.getNewList();
		}
		
	}

	@Override
	public List<String> listarComboProvincias(SaUbigeo ubigeo) {
		try {
			return SaUbigeoDao.listarComboProvincias(ubigeo);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboProvincias : ");
			return UtilesCommons.getNewList();
		}
		
	}

	@Override
	public List<String> listarComboDistritos(SaUbigeo ubigeo) {
		try {
			return SaUbigeoDao.listarComboDistritos(ubigeo);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboDistritos : ");
			return UtilesCommons.getNewList();
		}
		
	}
	
	@Override
	public SaUbigeo localizarDepProvDis(SaUbigeo ubigeo){
		try {
			return SaUbigeoDao.localizarDepProvDis(ubigeo);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : localizarDepProvDis : ");
			return null;
		}
	}

	
	@Override
	public List<SaUbigeo> listarComboDepartamento(String codigoPais) {
		try {
			return SaUbigeoDao.listarComboDepartamento(codigoPais);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboDepartamento : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SaUbigeo> listarComboProvincia(String codigoPais, String codigoDepartamento) {
		try {
			return SaUbigeoDao.listarComboProvincia(codigoPais, codigoDepartamento);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboProvincia : ");
		}
		return UtilesCommons.getNewList();
	}

	@Override
	public List<SaUbigeo> listarComboDistrito(String codigoPais, String codigoDepartamento,
			String codigoProvincia) {
		try {
			return SaUbigeoDao.listarComboDistrito(codigoPais, codigoDepartamento, codigoProvincia);
		} catch (Exception e) {
			Log.error(e,"SaUbigeoServiceImpl : listarComboDistrito : ");
		}
		return UtilesCommons.getNewList();
	}
	
}
