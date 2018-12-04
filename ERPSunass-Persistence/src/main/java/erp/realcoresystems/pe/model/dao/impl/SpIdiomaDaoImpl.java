package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SpIdiomaDao;
import erp.realcoresystems.pe.model.domain.SpIdioma;

@Repository
public class SpIdiomaDaoImpl extends AbstractDaoImpl<SpIdioma, Long> implements SpIdiomaDao {

	protected SpIdiomaDaoImpl() {
		super(SpIdioma.class);		
	}

	@Override
	public SpIdioma obtenerPorID(Long id) {
		Object resull = findById(id);
		return resull!=null?(SpIdioma)resull:null;	
	}

	@Override
	public List<SpIdioma> listarElementos(SpIdioma filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SpIdioma.class);
		if (UtilesCommons.noEsVacio(filtro.getIdiidiomaid())) {
			criteria.add(Restrictions.eq("idiidiomaid", filtro.getIdiidiomaid()));
		}		
		if (UtilesCommons.noEsVacio(filtro.getIdiestado())){
			criteria.add(Restrictions.eq("idiestado", filtro.getIdiestado()));		
		}	
		if (UtilesCommons.noEsVacio(filtro.getIdidescripcion())) {
			criteria.add(Restrictions.like("ididescripcion", filtro.getIdidescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}	
		return criteria.list();
	}

	@Override
	public List<SpIdioma> listarElementosPag(SpIdioma filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SpIdioma.class);
		if (filtro.getIdiidiomaid()!= null) {
			criteria.add(Restrictions.eq("idiidiomaid", filtro.getIdiidiomaid()));
		}		
		if (filtro.getIdiestado()!= null) {			
			if(filtro.getIdiestado() != 0 ){
				//System.out.println("Ingreso");
				criteria.add(Restrictions.eq("idiestado", filtro.getIdiestado()));
			}			
		}	
		if (filtro.getIdidescripcion()!= null && !(filtro.getIdidescripcion()+"").isEmpty() ) {
			criteria.add(Restrictions.like("ididescripcion", filtro.getIdidescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}	
		criteria.setFirstResult(filtro.getInicio());
		criteria.setMaxResults(filtro.getNumeroFilas());
		criteria.setFetchSize(filtro.getNumeroFilas());			
		return criteria.list();
	}

	@Override
	public long guardar(SpIdioma filtro) {		/*Obtener MAX insertado**/
		Criteria criteria = getCurrentSession().createCriteria(SpIdioma.class);
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("idiidiomaid"));																
		criteria.setProjection(proj);		
		Object result = criteria.uniqueResult();
		long valorMax=0;		
		if(result!=null){		
			valorMax = Integer.parseInt(result.toString());	
		}				
		filtro.setIdiidiomaid(valorMax+1);		
		save(filtro);
		return  (valorMax+1);				
	}

	@Override
	public int eliminar(SpIdioma filtro) {
		delete(filtro);
		return 1;
	}

	@Override
	public int actualizar(SpIdioma filtro) {
		update(filtro);
		return 1;
	}

	@Override
	public int contadorlistarElementos(SpIdioma filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SpIdioma.class);
		if (filtro.getIdiidiomaid()!= null) {
			criteria.add(Restrictions.eq("idiidiomaid", filtro.getIdiidiomaid()));
		}		
		if (filtro.getIdiestado()!= null ) {
			if(filtro.getIdiestado() != 0 ){
				criteria.add(Restrictions.eq("idiestado", filtro.getIdiestado()));
			}
		}	
		if (filtro.getIdidescripcion()!= null && !(filtro.getIdidescripcion()+"").isEmpty() ) {
			criteria.add(Restrictions.like("ididescripcion", filtro.getIdidescripcion(), MatchMode.ANYWHERE).ignoreCase());
		}			
		criteria.setProjection(Projections.rowCount());
		String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";		
		return Integer.parseInt(obj);
	}

	

}
