package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.CompaniaMastDao;
import erp.realcoresystems.pe.model.domain.CompaniaMast;

@Repository
public class CompaniaMastDaoImpl extends AbstractDaoImpl<CompaniaMast, String> implements CompaniaMastDao{

	
	protected CompaniaMastDaoImpl() {
		super(CompaniaMast.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompaniaMast> companiaListar(CompaniaMast companiamast) {
        Criteria criteria = getCurrentSession().createCriteria(CompaniaMast.class);
        return (List<CompaniaMast>) criteria.list();
	}

}
