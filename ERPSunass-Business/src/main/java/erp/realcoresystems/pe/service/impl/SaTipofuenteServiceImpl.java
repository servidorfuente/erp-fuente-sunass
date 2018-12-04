package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsFormcom01ADao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsFormcom01AService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("saTipofuenteService")
@Transactional(readOnly = true)
public class SaTipofuenteServiceImpl extends AbstractServiceImpl implements SaTipofuenteService {

	private SaTipofuenteDao saTipofuenteDao;


	@Override
	public SaTipofuente buscar(SaTipofuente filtro) {
		return null;
	}

	@Override
	public List<SaTipofuente> listar(SaTipofuente filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(SaTipofuente filtro) {
		return 0;
	}

	@Override
	public int guardar(SaTipofuente objDao) {
		return 0;
	}

	@Override
	public int actualizar(SaTipofuente objDao) {
		return 0;
	}

	@Override
	public int eliminar(SaTipofuente objDao) {
		return 0;
	}
}
