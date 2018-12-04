package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaTablasauditoriaDao;
import erp.realcoresystems.pe.model.domain.SaTablasauditoria;
import erp.realcoresystems.pe.model.domain.SaTablasauditoriaPK;


@Repository
public class SaTablasauditoriaDaoImpl extends AbstractDaoImpl<SaTablasauditoria, SaTablasauditoriaPK>  implements SaTablasauditoriaDao{

	protected SaTablasauditoriaDaoImpl() {
		super(SaTablasauditoria.class);
	}
	
	@Override
	public SaTablasauditoria obtenerPorID(SaTablasauditoria objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasauditoria.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));			
		criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));					
		criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));					
		Object result =criteria.uniqueResult();
		return  result!=null?((SaTablasauditoria)result):null;
	}

	@Override
	public List<SaTablasauditoria> listarElementos(SaTablasauditoria objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasauditoria.class);
		/*
		if (objDao.getTablename()!=null && !"".equals(objDao.get)) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}*/
		if ( !"".equals(objDao.getAplicacioncodigo()+"") &&  objDao.getAplicacioncodigo()!=null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}					
		if ( !"".equals(objDao.getGrupo()+"") &&   objDao.getGrupo()!=null) {
			criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		}					
		if ( !"".equals(objDao.getConcepto()+"") &&  objDao.getConcepto()!=null) {
			criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		}					
		if ( !"".equals(objDao.getEstado()+"") &&  objDao.getEstado()!=null) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}			
		/**PARA AUDIT***/
		setParametrosAuditoriaTrace(objDao,null,"");
		/****************/
		return (List<SaTablasauditoria>) criteria.list();
	}

	@Override
	public int guardar(SaTablasauditoria objDao) {
		//save(objDao);			
		saveOrUpdate(objDao);
		return 1;	
	}

	@Override
	public int eliminar(SaTablasauditoria objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaTablasauditoria objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablasauditoria objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasauditoria.class);
		/*
		if (objDao.getTablename()!=null && !"".equals(objDao.get)) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}*/
		if ( !"".equals(objDao.getAplicacioncodigo()+"") &&  objDao.getAplicacioncodigo()!=null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}					
		if ( !"".equals(objDao.getGrupo()+"") &&  objDao.getGrupo() !=null) {
			criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		}					
		if ( !"".equals(objDao.getConcepto()+"") &&  objDao.getConcepto()!=null) {
			criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		}					
		if ( !"".equals(objDao.getEstado()+"") &&  objDao.getEstado()!=null) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}			
		criteria.setProjection(Projections.rowCount());			
		return Integer.parseInt(criteria.uniqueResult().toString());	
	}

	@Override
	public List<SaTablasauditoria> listarElementosPag(SaTablasauditoria objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasauditoria.class);
		/*
		if (objDao.getTablename()!=null && !"".equals(objDao.get)) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}*/
		if ( !"".equals(objDao.getAplicacioncodigo()+"") &&  objDao.getAplicacioncodigo()!=null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}					
		if ( !"".equals(objDao.getGrupo()+"") &&   objDao.getGrupo()!=null) {
			criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		}					
		if ( !"".equals(objDao.getConcepto()+"") &&  objDao.getConcepto()!=null) {
			criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		}					
		if ( !"".equals(objDao.getEstado()+"") &&  objDao.getEstado()!=null) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}		
		criteria.setFirstResult(objDao.getInicio());
		criteria.setMaxResults(objDao.getNumeroFilas());
		criteria.setFetchSize(objDao.getNumeroFilas());
		/**PARA AUDIT***/
		setParametrosAuditoriaTrace(objDao,null,"");
		/****************/
		return (List<SaTablasauditoria>) criteria.list();
	}

}
