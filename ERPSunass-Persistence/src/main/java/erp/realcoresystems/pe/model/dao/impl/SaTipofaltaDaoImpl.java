package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTipofaltaDao;
import erp.realcoresystems.pe.model.domain.SaTipofalta;
import java.util.List;

@Repository
public class SaTipofaltaDaoImpl extends AbstractDaoImpl<SaTipofalta, Integer>  implements SaTipofaltaDao {


	protected SaTipofaltaDaoImpl() {
		super(SaTipofalta.class);		
	}

	@Override
	public SaTipofalta obtenerPorID(Integer id) {	
		return findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaTipofalta> listar(SaTipofalta saTipofalta,boolean paginable) {	
		Criteria criteria = getCurrentSession().createCriteria(SaTipofalta.class);
		if(UtilesCommons.noEsVacio(saTipofalta.getTfatipofaltaid())){
			criteria.add(Restrictions.eq("tfatipofaltaid",saTipofalta.getTfatipofaltaid()));	
		}
		if(UtilesCommons.noEsVacio(saTipofalta.getTfaestado())){
			criteria.add(Restrictions.eq("tfaestado",saTipofalta.getTfaestado()));
		}
		return(List<SaTipofalta>) criteria.list();
	}

	@Override
	public int guardar(SaTipofalta saTipofalta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(SaTipofalta saTipofalta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contador(SaTipofalta saTipofalta) {
		// TODO Auto-generated method stub
		return 0;
	}
}
