package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaUbigeoDao;
import erp.realcoresystems.pe.model.domain.SaDepartamento;
import erp.realcoresystems.pe.model.domain.SaProvincia;
import erp.realcoresystems.pe.model.domain.SaUbigeo;
import erp.realcoresystems.pe.model.domain.SaZonaPostal;

@Repository
public class SaUbigeoDaoImpl extends AbstractDaoImpl<SaUbigeo, String> implements SaUbigeoDao{

	protected SaUbigeoDaoImpl() {
		super(SaUbigeo.class);
	}

	@Override
	public SaUbigeo obtenerUbigeoPorId(int id) {
		return null;
	}

	@Override
	public SaUbigeo obtenerPorCodigo(String ubigeo){
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		criteria.add(Restrictions.eq("ubigeo", ubigeo));
		return (SaUbigeo) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaUbigeo> listar(SaUbigeo objeto) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		return (List<SaUbigeo>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaDepartamento> listarDepartamento(String codigoPais) {
		Criteria criteria = getCurrentSession().createCriteria(SaDepartamento.class);
		criteria.add(Restrictions.eq("paicodigo",codigoPais));
        return (List<SaDepartamento>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaProvincia> listarProvinciaPorDepartamento(String codigoPais, String codigoDepartamento) {
		Criteria criteria = getCurrentSession().createCriteria(SaProvincia.class);
		criteria.add(Restrictions.eq("paicodigo",codigoPais));
		criteria.add(Restrictions.eq("dptcodigo",codigoDepartamento));
		return (List<SaProvincia>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaZonaPostal> listarDistritoPorProvincia(String codigoPais, String codigoDepartamento, String codigoProvincia) {
		Criteria criteria = getCurrentSession().createCriteria(SaZonaPostal.class);
		criteria.add(Restrictions.eq("paicodigo",codigoPais));
		criteria.add(Restrictions.eq("dptcodigo",codigoDepartamento));
		criteria.add(Restrictions.eq("prvcodigo",codigoProvincia));
		return (List<SaZonaPostal>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listarComboDepartamentos(SaUbigeo ubigeo) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		criteria.setProjection(Projections.distinct(Projections.property("dpto")));
		criteria.addOrder(Order.asc("dpto"));
		return (List<String>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listarComboProvincias(SaUbigeo ubigeo) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		if(ubigeo.getDpto() != null && !"".equals(ubigeo.getDpto())){
			criteria.add(Restrictions.eq("dpto", ubigeo.getDpto()));
		}
		criteria.setProjection(Projections.distinct(Projections.property("prov")));
		criteria.addOrder(Order.asc("prov"));
		return (List<String>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listarComboDistritos(SaUbigeo ubigeo) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
//		if(ubigeo.getDpto() != null && !"".equals(ubigeo.getDpto())){
			criteria.add(Restrictions.eq("dpto", ubigeo.getDpto()));
//		}
		if(ubigeo.getProv() != null && !"".equals(ubigeo.getProv())){
			criteria.add(Restrictions.eq("prov", ubigeo.getProv()));
		}
		criteria.setProjection(Projections.distinct(Projections.property("dist")));
		criteria.addOrder(Order.asc("dist"));
		return (List<String>) criteria.list();
	}
	
	@Override
	public SaUbigeo localizarDepProvDis(SaUbigeo ubigeo){
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		if(ubigeo.getDpto() != null && !"".equals(ubigeo.getDpto())){
			criteria.add(Restrictions.eq("dpto", ubigeo.getDpto()));
		}
		if(ubigeo.getProv() != null && !"".equals(ubigeo.getProv())){
			criteria.add(Restrictions.eq("prov", ubigeo.getProv()));
		}
		if(ubigeo.getDist() != null && !"".equals(ubigeo.getDist())){
			criteria.add(Restrictions.eq("dist", ubigeo.getDist()));
		}
		return (SaUbigeo) criteria.uniqueResult();
	} 

	@SuppressWarnings("unchecked")
	@Override
	public List<SaUbigeo> listarComboDepartamento(String codigoPais) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		
        criteria.setProjection(Projections.projectionList()  
                .add(Property.forName("dptoubigeo").as("dptoubigeo")) 
                .add(Property.forName("dpto").as("dpto"))  
			    .add(Projections.projectionList()
			    		.add(Projections.groupProperty("dptoubigeo")))
			    		.add(Projections.groupProperty("dpto")));
        
	    criteria.add(Restrictions.eq("paicodigo",codigoPais));
	    criteria.addOrder(Order.asc("dpto"));
	    criteria.setResultTransformer(Transformers.aliasToBean(SaUbigeo.class));

        return (List<SaUbigeo>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaUbigeo> listarComboProvincia(String codigoPais, String codigoDepartamento) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		
        criteria.setProjection(Projections.projectionList()  
                .add(Property.forName("provubigeo").as("provubigeo")) 
                .add(Property.forName("prov").as("prov"))  
			    .add(Projections.projectionList()
			    		.add(Projections.groupProperty("provubigeo")))
			    		.add(Projections.groupProperty("prov")));
        
		criteria.add(Restrictions.eq("paicodigo",codigoPais));
		criteria.add(Restrictions.eq("dptoubigeo",codigoDepartamento));
	    criteria.addOrder(Order.asc("prov"));
	    criteria.setResultTransformer(Transformers.aliasToBean(SaUbigeo.class));
		
		return (List<SaUbigeo>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaUbigeo> listarComboDistrito(String codigoPais, String codigoDepartamento, String codigoProvincia) {
		Criteria criteria = getCurrentSession().createCriteria(SaUbigeo.class);
		
        criteria.setProjection(Projections.projectionList()  
                .add(Property.forName("distubigeo").as("distubigeo")) 
                .add(Property.forName("dist").as("dist"))  
			    .add(Projections.projectionList()
			    		.add(Projections.groupProperty("distubigeo")))
			    		.add(Projections.groupProperty("dist")));
        
		criteria.add(Restrictions.eq("paicodigo",codigoPais));
		criteria.add(Restrictions.eq("dptoubigeo",codigoDepartamento));
		criteria.add(Restrictions.eq("provubigeo",codigoProvincia));
	    criteria.addOrder(Order.asc("dist"));
	    criteria.setResultTransformer(Transformers.aliasToBean(SaUbigeo.class));
	    
		return (List<SaUbigeo>)criteria.list();
	}
	
}
