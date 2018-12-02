package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SeguridadautorizacionesDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;


@Repository
public class SeguridadautorizacionesDaoImpl extends AbstractDaoImpl<Seguridadautorizaciones, String>   implements SeguridadautorizacionesDao{

	protected SeguridadautorizacionesDaoImpl() {
		super(Seguridadautorizaciones.class);
	}

	@Override
	public Seguridadautorizaciones obtenerPorID(Seguridadautorizaciones objDao) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadautorizaciones.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));				
		criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		criteria.add(Restrictions.eq("usuario", objDao.getUsuario()));
		/**PARA AUDIT***/
		setParametrosAuditoriaTrace(objDao,null,"");
		/****************/
		return  (Seguridadautorizaciones) criteria.uniqueResult();
	}

	@Override
	public List<Seguridadautorizaciones> listarElementos(Seguridadautorizaciones objDao) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadautorizaciones.class);
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
		if ( !"".equals(objDao.getUsuario()+"") &&  objDao.getUsuario()!=null) {
			criteria.add(Restrictions.eq("usuario", objDao.getUsuario()));
		}		
		/**PARA AUDIT***/
		//setParametrosAuditoriaTrace(objDao,null,"");
		/****************/
		return (List<Seguridadautorizaciones>) criteria.list();
	}

	@Override
	public int guardar(Seguridadautorizaciones objDao) {		
		saveOrUpdate(objDao);			
		return 1;	
	}

	@Override
	public int eliminar(Seguridadautorizaciones objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int contadorTotaleslistarElementos(Seguridadautorizaciones objDao) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadautorizaciones.class);
		/*
		if (objDao.getTablename()!=null && !"".equals(objDao.get)) {
			criteria.add(Restrictions.like("tablename", objDao.getTablename(),MatchMode.ANYWHERE).ignoreCase());
		}*/
		if ( !"".equals(objDao.getAplicacioncodigo()+"") &&  objDao.getAplicacioncodigo()!=null) {
			criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		}					
		if ( !"".equals(objDao.getGrupo()+"") &&  Long.valueOf( objDao.getGrupo())!=null) {
			criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		}					
		if ( !"".equals(objDao.getConcepto()+"") &&  objDao.getConcepto()!=null) {
			criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		}					
		if ( !"".equals(objDao.getUsuario()+"") &&  objDao.getUsuario()!=null) {
			criteria.add(Restrictions.eq("usuario", objDao.getUsuario()));
		}			
		criteria.setProjection(Projections.rowCount());			
		return Integer.parseInt(criteria.uniqueResult().toString());	
	}

	@Override
	public int actualizar(Seguridadautorizaciones objDao) {	
		update(objDao);			
		return 1;
	}

}
