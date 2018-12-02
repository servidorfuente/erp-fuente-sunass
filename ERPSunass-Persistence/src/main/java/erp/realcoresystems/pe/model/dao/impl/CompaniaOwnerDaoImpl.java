package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.CompaniaOwnerDao;
import erp.realcoresystems.pe.model.domain.Companyowner;

@Repository
public class CompaniaOwnerDaoImpl extends AbstractDaoImpl<Companyowner, String> implements CompaniaOwnerDao{

	protected CompaniaOwnerDaoImpl() {
		super(Companyowner.class);
	}

	@Override
	public List<Companyowner> listarCompanias(Companyowner companyowner) throws Exception {
        Criteria criteria = getCurrentSession().createCriteria(Companyowner.class);
        if(companyowner != null){
        	if (companyowner.getCompanyowner()!=null && !companyowner.getCompanyowner().equals("")){
        		criteria.add(Restrictions.like("companyowner", companyowner.getCompanyowner()));
        	}        	
        }              
        return (List<Companyowner>) criteria.list();	
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Companyowner> listar(Companyowner filtro) {
		Criteria criteria = createCriteria();
		if(filtro.getCompany()!=null){
			criteria.add(Restrictions.eq("company", filtro.getCompany()));
		}

		if("MULTI_COMPANIASOCIO".equals(filtro.getNombreConsulta())){
			boolean filtrosHallados=false;
			if(filtro.getListString()!=null && filtro.getAtributoList()!=null){
				if(filtro.getListString().size()>0){
					try{
						criteria.add(Restrictions.in(filtro.getAtributoList(), filtro.getListString()));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("companyowner",null));
			}
		}

		if(!UtilesCommons.esVacio(filtro.getDescription())){
			criteria.add(Restrictions.ilike("description", filtro.getDescription(), MatchMode.ANYWHERE));
		}

		setOrdenable(criteria, ORDER_ASC, filtro.getListaAtributoOrdenacion());
		//setOrdenable(criteria, ORDER_DESC, filtro.getli());
		return criteria.list();
	}

	@Override
	public int guardar(Companyowner objDao) {
		save(objDao);
		return 1;
	}

	@Override
	public int actualizar(Companyowner objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(Companyowner objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int contar(Companyowner filtro) {
		Criteria cq = createCriteria();

		if(!UtilesCommons.esVacio(filtro.getDescription())){
			cq.add(Restrictions.ilike("description", filtro.getDescription(), MatchMode.ANYWHERE));
		}

		if(filtro.getCompany()!=null){
			cq.add(Restrictions.eq("company", filtro.getCompany()));
		}

		cq.setProjection(Projections.rowCount());
		String obj = cq.uniqueResult() != null ? cq.uniqueResult().toString() : "0";
		return Integer.parseInt(obj);
	}


}
