package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import erp.realcoresystems.pe.model.dao.CoServicioClasificacionDao;
import erp.realcoresystems.pe.model.domain.CoServicioClasificacion;
import erp.realcoresystems.pe.model.util.Utiles;

@Repository
public class CoServicioClasificacionDaoImpl extends AbstractDaoImpl<CoServicioClasificacion, String>implements CoServicioClasificacionDao {

	protected CoServicioClasificacionDaoImpl() {
		super(CoServicioClasificacion.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoServicioClasificacion> listar(CoServicioClasificacion clasificacion) {				
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		
		if (clasificacion.getServicioclasificacionid() != null){
        	criteria.add(Restrictions.eq("servicioclasificacionid", clasificacion.getServicioclasificacionid()));
        }
		
		if (clasificacion.getEstado() != null && !clasificacion.getEstado().trim().isEmpty()){
        	criteria.add(Restrictions.eq("estado", clasificacion.getEstado()));
        }
		
		if (clasificacion.getUnidadnegocio() != null && !clasificacion.getEstado().trim().isEmpty()){
        	criteria.add(Restrictions.eq("unidadnegocio", clasificacion.getUnidadnegocio()));
        }
		
        if (clasificacion.getServicioclasificacion() != null && !clasificacion.getServicioclasificacion().trim().isEmpty()){
        	criteria.add(Restrictions.ilike("servicioclasificacion", clasificacion.getServicioclasificacion(),MatchMode.ANYWHERE));
        }
        if (clasificacion.getDescripcionlocal() != null && !clasificacion.getDescripcionlocal().trim().isEmpty()){
        	criteria.add(Restrictions.like("descripcionlocal", clasificacion.getDescripcionlocal(),MatchMode.ANYWHERE).ignoreCase());
        }
        if(clasificacion.getClasificacion() != null && !clasificacion.getClasificacion().trim().isEmpty()){
        	criteria.add(Restrictions.eq("clasificacion", clasificacion.getClasificacion()));
        }
        if(clasificacion.isOrdernable()){
        	//criteria.addOrder(Property.forName("clasificacion").asc());
        	criteria.addOrder(Order.asc("clasificacion"));
        }
		criteria.setFirstResult(clasificacion.getInicio());
		criteria.setMaxResults(clasificacion.getNumeroFilas());
		criteria.setFetchSize(clasificacion.getNumeroFilas());        
        return (List<CoServicioClasificacion>) criteria.list();
	}

	@Override
	public int guardar(CoServicioClasificacion clasificacion) {
		
		if (clasificacion.getServicioclasificacionid() == null) {			
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("servicioclasificacionid"));
			Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();
			
			int valorMax = 0;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			clasificacion.setServicioclasificacionid(valorMax + 1);
			clasificacion.setServicioclasificacion(Utiles.obtenerCodigoString(valorMax + 1,10));
		}
		
		saveOrUpdate(clasificacion);
		return clasificacion.getServicioclasificacionid();
	}

	@Override
	public int actualizar(CoServicioClasificacion clasificacion) {
		return 0;
	}

	@Override
	public int contarTotal(CoServicioClasificacion clasificacion) {
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		
		if (clasificacion.getServicioclasificacionid() != null){
        	criteria.add(Restrictions.eq("servicioclasificacionid", clasificacion.getServicioclasificacionid()));
        }
		
		if (clasificacion.getEstado() != null && !clasificacion.getEstado().trim().isEmpty()){
        	criteria.add(Restrictions.eq("estado", clasificacion.getEstado()));
        }
		
		if (clasificacion.getUnidadnegocio() != null && !clasificacion.getEstado().trim().isEmpty()){
        	criteria.add(Restrictions.eq("unidadnegocio", clasificacion.getUnidadnegocio()));
        }
		
        if (clasificacion.getServicioclasificacion() != null && !clasificacion.getServicioclasificacion().trim().isEmpty()){
        	criteria.add(Restrictions.ilike("servicioclasificacion", clasificacion.getServicioclasificacion(),MatchMode.ANYWHERE));
        }
        if (clasificacion.getDescripcionlocal() != null && !clasificacion.getDescripcionlocal().trim().isEmpty()){
        	criteria.add(Restrictions.like("descripcionlocal", clasificacion.getDescripcionlocal(),MatchMode.ANYWHERE).ignoreCase());
        }
        if(clasificacion.getClasificacion() != null && !clasificacion.getClasificacion().trim().isEmpty()){
        	criteria.add(Restrictions.eq("clasificacion", clasificacion.getClasificacion()));
        }
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public CoServicioClasificacion buscarPorId(String servicioclasificacion) {
		
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		criteria.add(Restrictions.eq("servicioclasificacion", servicioclasificacion).ignoreCase());    
        return (CoServicioClasificacion) criteria.uniqueResult();
	}
	
	@Override
	public CoServicioClasificacion buscarPorId(Integer servicioclasificacionid){
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		criteria.add(Restrictions.eq("servicioclasificacionid", servicioclasificacionid));
		return (CoServicioClasificacion) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoServicioClasificacion> buscarPorCodigo(String codigoServicio){
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		criteria.add(Restrictions.eq("servicioclasificacion", codigoServicio).ignoreCase()); 
		return (List<CoServicioClasificacion>) criteria.list();
	}
	
	@Override
	public int obtenerMaximoId(){
		Criteria criteria = getCurrentSession().createCriteria(CoServicioClasificacion.class);
		criteria.setProjection(Projections.max("servicioclasificacionid"));
		Object result = criteria.uniqueResult();
		if(result == null){
			return 0;
		}else{
			return Integer.parseInt(result.toString());
		}
	}
}
