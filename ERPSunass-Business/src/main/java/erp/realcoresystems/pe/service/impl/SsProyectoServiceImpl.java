package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.dao.SsProyectoDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import erp.realcoresystems.pe.model.domain.SsProyecto;
import erp.realcoresystems.pe.service.SaTipofuenteService;
import erp.realcoresystems.pe.service.SsProyectoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssProyectoService")
@Transactional(readOnly = true)
public class SsProyectoServiceImpl extends AbstractServiceImpl implements SsProyectoService {

	private SsProyectoDao ssProyectoDao;


	@Override
	public SsProyecto buscar(SsProyecto filtro) {
		return null;
	}

	@Override
	public List<SsProyecto> listar(SsProyecto filtro, boolean pagina) {
		return null;
	}

	@Override
	public int contar(SsProyecto filtro) {
		return 0;
	}

	@Override
	public int guardar(SsProyecto objDao) {
		return 0;
	}

	@Override
	public int actualizar(SsProyecto objDao) {
		return 0;
	}

	@Override
	public int eliminar(SsProyecto objDao) {
		return 0;
	}
}
