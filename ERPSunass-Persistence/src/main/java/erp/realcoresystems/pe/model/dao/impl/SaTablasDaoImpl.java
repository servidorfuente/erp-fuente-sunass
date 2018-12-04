package erp.realcoresystems.pe.model.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaTablasDao;
import erp.realcoresystems.pe.model.domain.SaTablas;

@Repository
public class SaTablasDaoImpl extends AbstractDaoImpl<SaTablas, Integer> implements SaTablasDao {

	protected SaTablasDaoImpl() {
		super(SaTablas.class);	
	}

	@Override
	public SaTablas obtenerPorID(SaTablas objDao) {
		/*
		Criteria criteria = getCurrentSession().createCriteria(SaTablas.class);
		criteria.add(Restrictions.eq("idtabla", objDao.getIdtabla()));							
		return  (SaTablas) criteria.uniqueResult();
		*/		
		return findById(objDao.getIdtabla());
	}

	@Override
	public List<SaTablas> listarElementos(SaTablas objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablas.class);		
		if("MULTI".equals(objDao.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if (objDao.getEstado()!=null) {
				criteria.add(Restrictions.eq("estado",objDao.getEstado()));
			}			
			if(objDao.getDescripcion02()!=null){
				String[] vector =    objDao.getDescripcion02().split("/");
				//System.out.println("TEST TABLAS:PERSIS::"+vector.length);
				if(vector.length>0){
					try{
						BigDecimal[] ids = new BigDecimal[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								ids[i] = BigDecimal.valueOf(Double.parseDouble(vector[i]));
								//System.out.println("TEST TABLAS:PERSIS:IDXXXXXXXX:"+ids[i]);
							}
						}	
						criteria.add(Restrictions.in("idtabla", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}				
			}		
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("idtabla", 0));
			}
		}else{
			if (objDao.getEstado()!=null) {
				criteria.add(Restrictions.eq("estado",objDao.getEstado()));
			}			
			if (objDao.getNombretabla()!=null && !"".equals(objDao.getNombretabla())) {
				criteria.add(Restrictions.like("nombretabla", objDao.getNombretabla(),MatchMode.ANYWHERE).ignoreCase());
			}				
			if ( !"".equals(objDao.getClassname()+"") &&   objDao.getClassname()!=null) {
				criteria.add(Restrictions.like("classname", objDao.getClassname(),MatchMode.ANYWHERE).ignoreCase());			
			}					
			if ( !"".equals(objDao.getDescripcion()+"") &&  objDao.getDescripcion()!=null) {
				criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(),MatchMode.ANYWHERE).ignoreCase());			
			}													
		}		
		return (List<SaTablas>) criteria.list();
	}

	@Override
	public int guardar(SaTablas objDao) {
		saveOrUpdate(objDao);
		return 1;
	}

	@Override
	public int eliminar(SaTablas objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaTablas objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablas objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablas.class);
		/*
		if ( !"".equals(objDao.getAplicacioncodigo()+"") &&  objDao.getAplicacioncodigo()!=null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}*/					
		if("MULTI".equals(objDao.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if(objDao.getDescripcion02()!=null){
				String[] vector =    objDao.getDescripcion02().split("|");
				//System.out.println("TEST TABLAS:PERSIS::"+vector.length);
				if(vector.length>0){
					try{
						BigDecimal[] ids = new BigDecimal[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								ids[i] = BigDecimal.valueOf(Double.parseDouble(vector[i]));
								//System.out.println("TEST TABLAS:PERSIS:IDXXXXXXXX:"+ids[i]);
							}
						}	
						criteria.add(Restrictions.in("idtabla", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}				
			}		
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("idtabla", 0));
			}
		}else{
			if (objDao.getNombretabla()!=null && !"".equals(objDao.getNombretabla())) {
				criteria.add(Restrictions.like("nombretabla", objDao.getNombretabla(),MatchMode.ANYWHERE).ignoreCase());
			}				
			if ( !"".equals(objDao.getClassname()+"") &&   objDao.getClassname()!=null) {
				criteria.add(Restrictions.like("classname", objDao.getClassname(),MatchMode.ANYWHERE).ignoreCase());			
			}					
			if ( !"".equals(objDao.getDescripcion()+"") &&  objDao.getDescripcion()!=null) {
				criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(),MatchMode.ANYWHERE).ignoreCase());			
			}													
		}															
		criteria.setProjection(Projections.rowCount());			
		return Integer.parseInt(criteria.uniqueResult().toString());	
	}

	@Override
	public List<SaTablas> listarElementosPag(SaTablas objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablas.class);		
		if("MULTI".equals(objDao.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if(objDao.getDescripcion02()!=null){
				String[] vector =    objDao.getDescripcion02().split("|");
				//System.out.println("TEST TABLAS:PERSIS::"+vector.length);
				if(vector.length>0){
					try{
						BigDecimal[] ids = new BigDecimal[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								ids[i] = BigDecimal.valueOf(Double.parseDouble(vector[i]));
								//System.out.println("TEST TABLAS:PERSIS:IDXXXXXXXX:"+ids[i]);
							}
						}	
						criteria.add(Restrictions.in("idtabla", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}				
			}		
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("idtabla", 0));
			}
		}else{
			if (objDao.getNombretabla()!=null && !"".equals(objDao.getNombretabla())) {
				criteria.add(Restrictions.like("nombretabla", objDao.getNombretabla(),MatchMode.ANYWHERE).ignoreCase());
			}				
			if ( !"".equals(objDao.getClassname()+"") &&   objDao.getClassname()!=null) {
				criteria.add(Restrictions.like("classname", objDao.getClassname(),MatchMode.ANYWHERE).ignoreCase());			
			}					
			if ( !"".equals(objDao.getDescripcion()+"") &&  objDao.getDescripcion()!=null) {
				criteria.add(Restrictions.like("descripcion", objDao.getDescripcion(),MatchMode.ANYWHERE).ignoreCase());			
			}													
		}		
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas()); 
		return (List<SaTablas>) criteria.list();
	}

}
