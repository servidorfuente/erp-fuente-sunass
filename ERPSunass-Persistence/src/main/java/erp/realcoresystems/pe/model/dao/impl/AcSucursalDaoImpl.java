package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.AcSucursalDao;
import erp.realcoresystems.pe.model.domain.AcSucursal;

@Repository
public class AcSucursalDaoImpl extends AbstractDaoImpl<AcSucursal, String> implements AcSucursalDao{

	protected AcSucursalDaoImpl() {
		super(AcSucursal.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcSucursal> sucursalListar(AcSucursal acSucursal) {
        Criteria criteria = getCurrentSession().createCriteria(AcSucursal.class);
        if(acSucursal.getCompanyowner().getCompanyowner() != null){
        	criteria.add(Restrictions.eq("companyowner.companyowner", acSucursal.getCompanyowner().getCompanyowner()));
        }
        return (List<AcSucursal>) criteria.list();
	}

	@Override
	public String obtenerMaximo(){
		Criteria criteria = getCurrentSession().createCriteria(AcSucursal.class);
		criteria.setProjection(Projections.max("sucursal"));
		return String.valueOf(criteria.uniqueResult());
	}
	
	
	@Override
	public int guardar(AcSucursal acSucursal){
		saveOrUpdate(acSucursal);
		return 1;
	}
}
