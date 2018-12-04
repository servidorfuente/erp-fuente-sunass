package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsCargainicialDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsCargainicialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssCargainicialService")
@Transactional(readOnly = true)
public class SsCargainicialServiceImpl extends AbstractServiceImpl implements SsCargainicialService {

	private SsCargainicialDao ssCargainicialDao;


	@Override
	public SsCargainicial buscar(SsCargainicial filtro) {
		return null;
	}

	@Override
	public List<SsCargainicial> listar(SsCargainicial filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(SsCargainicial filtro) {
		return 0;
	}

	@Override
	public int guardar(SsCargainicial objDao) {
		return 0;
	}

	@Override
	public int actualizar(SsCargainicial objDao) {
		return 0;
	}

	@Override
	public int eliminar(SsCargainicial objDao) {
		return 0;
	}
}
