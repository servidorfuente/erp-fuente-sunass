package erp.realcoresystems.pe.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SeguridadauditoriaDao;
import erp.realcoresystems.pe.model.domain.SaAuditoria;
import erp.realcoresystems.pe.model.domain.VwAuditoriageneral;
import erp.realcoresystems.pe.model.util.Utiles;

@Repository
public class SeguridadauditoriaDaoImpl  extends AbstractDaoImpl<SaAuditoria, String>  implements SeguridadauditoriaDao {


	protected SeguridadauditoriaDaoImpl() {
		super(SaAuditoria.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public SaAuditoria obtenerPorID(SaAuditoria objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaAuditoria.class);
		criteria.add(Restrictions.eq("auditoriaid", objDao.getAuditoriaid()));				
		return  (SaAuditoria) criteria.uniqueResult();
	}

	@Override
	public List<VwAuditoriageneral> listarElementos(VwAuditoriageneral objDao) {			
		Criteria criteria = getCurrentSession().createCriteria(VwAuditoriageneral.class);
		
		//System.out.println("TEST  INICIO BUSCAR PERSISI::"+objDao);
		if (objDao.getTablename()!=null && !"".equals(objDao.getTablename())) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getConceptoDesc()!=null && !"".equals(objDao.getConceptoDesc())) {
			criteria.add(Restrictions.like("conceptoDesc", objDao.getConceptoDesc(),MatchMode.ANYWHERE).ignoreCase());
		}		
		if ( !"".equals(objDao.getAuditoriaid()+"") &&  objDao.getAuditoriaid()!=null) {
			criteria.add(Restrictions.eq("auditoriaid", objDao.getAuditoriaid()));
		}
		if (objDao.getUsuario()!=null && !"".equals(objDao.getUsuario())) {
			criteria.add(Restrictions.like("usuario", objDao.getUsuario(),MatchMode.ANYWHERE).ignoreCase());
		}
		if ( objDao.getTableidvalue()!=null) {
			criteria.add(Restrictions.eq("tableidvalue", objDao.getTableidvalue()));
		}	
		if ( objDao.getTipo()!=null && !"".equals(objDao.getTipo())) {
			criteria.add(Restrictions.eq("tipo", objDao.getTipo()));
		}		
		if ( objDao.getIpClient()!=null && !"".equals(objDao.getIpClient())) {
			criteria.add(Restrictions.like("ipClient", objDao.getIpClient(),MatchMode.ANYWHERE).ignoreCase());			
		}	
		if ( objDao.getPrimarykeydata()!=null && !"".equals(objDao.getPrimarykeydata())) {
			criteria.add(Restrictions.eq("primarykeydata", objDao.getPrimarykeydata()));
		}
		if (objDao.getUpdatedate()!=null ) {
			try{
				if("RANGO".equals(objDao.getFlagConsultaEntGlobal())){ // flag si las fechas son iguales o no
					
					// --- RANGOOO ----
					//Conjunction and = Restrictions.conjunction();
					// mayor igual que
					String fechaIniStr = Utiles.printDate("yyyyMMdd",objDao.getUpdatedate()); 
					Date fechaIni = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaIniStr+"00:00:00");
					criteria.add( Restrictions.ge("updatedate",fechaIni) );							
					if (objDao.getFechaAccionEntGlobal()!=null ) {
						// menor que
						
						// getUpdatedate // fecha Inicio
						// getFechaAccionEntGlobal // fecha fin
						
						String fechaFinStr = Utiles.printDate("yyyyMMdd",objDao.getFechaAccionEntGlobal()); 
						Date fechaFin = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaFinStr+"23:59:59");
						criteria.add( Restrictions.lt("updatedate",fechaFin) ); 							    					   
					}				
				}else{					
					
					// MISMA FECHA 
					
					String fechaIniStr = Utiles.printDate("yyyyMMdd",objDao.getUpdatedate()); 
					String fechaFinStr = Utiles.printDate("yyyyMMdd",Utiles.fechaMasNumeroDias(objDao.getUpdatedate(),1));
					Date fechaIni = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaIniStr+"00:00:00");					
					Date fechaFin = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaFinStr+"00:00:00");
					criteria.add( Restrictions.ge("updatedate",fechaIni) );
					criteria.add( Restrictions.lt("updatedate", fechaFin));				
				}					
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}		
		
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());
		
		return (List<VwAuditoriageneral>) criteria.list();
	}

	@Override
	public int guardar(SaAuditoria objDao) {		
		saveOrUpdate(objDao);			
		return 1;	
	}

	@Override
	public int eliminar(SaAuditoria objDao) {
		delete(objDao);
		return 1;
	}
	@Override
	public int contadorTotaleslistarElementos(VwAuditoriageneral objDao) {				
		Criteria criteria = getCurrentSession().createCriteria(VwAuditoriageneral.class);
		if (objDao.getTablename()!=null && !"".equals(objDao.getTablename())) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}
		if (objDao.getConceptoDesc()!=null && !"".equals(objDao.getConceptoDesc())) {
			criteria.add(Restrictions.like("conceptoDesc", objDao.getConceptoDesc(),MatchMode.ANYWHERE).ignoreCase());
		}		
		if ( !"".equals(objDao.getAuditoriaid()+"") &&  objDao.getAuditoriaid()!=null) {
			criteria.add(Restrictions.eq("auditoriaid", objDao.getAuditoriaid()));
		}
		if (objDao.getUsuario()!=null && !"".equals(objDao.getUsuario())) {
			criteria.add(Restrictions.like("usuario", objDao.getUsuario(),MatchMode.ANYWHERE).ignoreCase());
		}
		if ( objDao.getTableidvalue()!=null) {
			criteria.add(Restrictions.eq("tableidvalue", objDao.getTableidvalue()));
		}	
		if ( objDao.getTipo()!=null && !"".equals(objDao.getTipo())) {
			criteria.add(Restrictions.eq("tipo", objDao.getTipo()));
		}		
		if ( objDao.getIpClient()!=null && !"".equals(objDao.getIpClient())) {
			criteria.add(Restrictions.like("ipClient", objDao.getIpClient(),MatchMode.ANYWHERE).ignoreCase());			
		}
		if ( objDao.getPrimarykeydata()!=null && !"".equals(objDao.getPrimarykeydata())) {
			criteria.add(Restrictions.eq("primarykeydata", objDao.getPrimarykeydata()));
		}
		if (objDao.getUpdatedate()!=null ) {
			try{
				if("RANGO".equals(objDao.getFlagConsultaEntGlobal())){
					//Conjunction and = Restrictions.conjunction();
					// mayor igual que
					String fechaIniStr = Utiles.printDate("yyyyMMdd",objDao.getUpdatedate()); 
					Date fechaIni = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaIniStr+"00:00:00");
					criteria.add( Restrictions.ge("updatedate",fechaIni) );							
					if (objDao.getFechaAccionEntGlobal()!=null ) {
						// menor que
						String fechaFinStr = Utiles.printDate("yyyyMMdd",objDao.getFechaAccionEntGlobal()); 
						Date fechaFin = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaFinStr+"23:59:59");
						criteria.add( Restrictions.lt("updatedate",fechaFin) ); 							    					   
					}				
				}else{					
					String fechaIniStr = Utiles.printDate("yyyyMMdd",objDao.getUpdatedate()); 
					String fechaFinStr = Utiles.printDate("yyyyMMdd",Utiles.fechaMasNumeroDias(objDao.getUpdatedate(),1));
					Date fechaIni = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaIniStr+"00:00:00");					
					Date fechaFin = Utiles.getDateFormat("yyyyMMddhh:mm:ss",fechaFinStr+"00:00:00");
					criteria.add( Restrictions.ge("updatedate",fechaIni) );
					criteria.add( Restrictions.lt("updatedate", fechaFin));				
				}					
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}		
		criteria.setProjection(Projections.rowCount());			
		return Integer.parseInt(criteria.uniqueResult().toString());	
	}	

}
