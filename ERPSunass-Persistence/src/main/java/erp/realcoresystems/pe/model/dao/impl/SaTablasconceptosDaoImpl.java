package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaTablasconceptosDao;
import erp.realcoresystems.pe.model.domain.SaTablasconceptos;
import erp.realcoresystems.pe.model.domain.SaTablasconceptosPK;

@Repository
public class SaTablasconceptosDaoImpl extends AbstractDaoImpl<SaTablasconceptos, SaTablasconceptosPK>   implements SaTablasconceptosDao {

	protected SaTablasconceptosDaoImpl() {
		super(SaTablasconceptos.class);		
	}

	@Override
	public SaTablasconceptos obtenerPorID(SaTablasconceptos objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasconceptos.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));				
		criteria.add(Restrictions.eq("grupo", objDao.getGrupo()));
		criteria.add(Restrictions.eq("concepto", objDao.getConcepto()));
		criteria.add(Restrictions.eq("idtabla", objDao.getIdtabla()));		
		return  (SaTablasconceptos) criteria.uniqueResult();
	}

	@Override
	public List<SaTablasconceptos> listarElementos(SaTablasconceptos objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasconceptos.class);
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
		if ( !"".equals(objDao.getIdtabla()+"") &&  objDao.getIdtabla()!=null) {
			criteria.add(Restrictions.eq("idtabla", objDao.getIdtabla()));
		}							
		return (List<SaTablasconceptos>) criteria.list();
	}

	@Override
	public int guardar(SaTablasconceptos objDao) {
		saveOrUpdate(objDao);			
		return 1;
	}

	@Override
	public int eliminar(SaTablasconceptos objDao) {
		delete(objDao);
		return 1;
	}

	@Override
	public int actualizar(SaTablasconceptos objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablasconceptos objDao) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablasconceptos.class);
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
		if ( !"".equals(objDao.getIdtabla()+"") &&  objDao.getIdtabla()!=null) {
			criteria.add(Restrictions.eq("idtabla", objDao.getIdtabla()));
		}			
		criteria.setProjection(Projections.rowCount());			
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

}
