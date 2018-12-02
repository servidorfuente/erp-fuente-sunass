package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.*;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;
import erp.realcoresystems.pe.model.domain.vista.VwSsperiodoformulario;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.service.*;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Service("ssControlperiodoService")
@Transactional(readOnly = true)
public class SsControlperiodoServiceImpl extends AbstractServiceImpl implements SsControlperiodoService {

	@Autowired
	SsControlperiodoDao ssControlperiodoDao;


	@Override
	public SsPeriodoformulario buscarCab(SsPeriodoformulario filtro) {
		return null;
	}

	@Override
	public SsPeriodoformulariodetalle buscar(SsPeriodoformulariodetalle filtro) {
		return null;
	}

	@Override
	public List<SsPeriodoformulariodetalle> listar(SsPeriodoformulariodetalle filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(SsPeriodoformulariodetalle filtro) {
		return 0;
	}

	@Override
	public List<VwSsperiodoformulario> listarVista(VwSsperiodoformulario filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(VwSsperiodoformulario filtro) {
		return 0;
	}

	@Override
	public int guardarCab(SsPeriodoformulario objDao) {
		return 0;
	}

	@Override
	public int actualizarCab(SsPeriodoformulario objDao) {
		return 0;
	}

	@Override
	public int eliminarCab(SsPeriodoformulario objDao) {
		return 0;
	}

	@Override
	public int guardar(SsPeriodoformulariodetalle objDao) {
		return 0;
	}

	@Override
	public int actualizar(SsPeriodoformulariodetalle objDao) {
		return 0;
	}

	@Override
	public int eliminar(SsPeriodoformulariodetalle objDao) {
		return 0;
	}
}