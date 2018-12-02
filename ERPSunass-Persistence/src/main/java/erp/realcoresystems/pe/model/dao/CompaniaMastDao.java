package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.CompaniaMast;

public interface CompaniaMastDao extends AbstractDao<CompaniaMast, String>{

	public List<CompaniaMast> companiaListar(CompaniaMast companiamast);
}
