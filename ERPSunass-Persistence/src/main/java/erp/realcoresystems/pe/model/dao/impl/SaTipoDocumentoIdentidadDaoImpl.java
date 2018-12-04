package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTipoDocumentoIdentidadDao;
import erp.realcoresystems.pe.model.domain.SaTipoDocumentoIdentidad;

@Repository
public class SaTipoDocumentoIdentidadDaoImpl extends AbstractDaoImpl<SaTipoDocumentoIdentidad, Integer> implements SaTipoDocumentoIdentidadDao{

	protected SaTipoDocumentoIdentidadDaoImpl() {
		super(SaTipoDocumentoIdentidad.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaTipoDocumentoIdentidad> listar(Integer[] arrayString) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipoDocumentoIdentidad.class);
		if(UtilesCommons.noEsVacio(arrayString)){
			criteria.add(Restrictions.in("tditipodocid", arrayString));
		}		
		criteria.addOrder(Order.asc("tdicodigo"));
		return (List<SaTipoDocumentoIdentidad>) criteria.list();
	}



	
	@Override
	public int guardar(SaTipoDocumentoIdentidad filtro) {
		if (UtilesCommons.esVacio(filtro.getTditipodocid())) {
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("tditipodocid"));
			Criteria criteria = getCurrentSession().createCriteria(SaTipoDocumentoIdentidad.class);
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();
			int valorMax = 0;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			filtro.setTditipodocid(valorMax + 1);
			save(filtro);
		}else{
			actualizar(filtro);
		}
		return 1;
	}

	@Override
	public int eliminar(SaTipoDocumentoIdentidad filtro) {
		delete(filtro);
		return 1;
	}

	@Override
	public List<SaTipoDocumentoIdentidad> validate(SaTipoDocumentoIdentidad filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipoDocumentoIdentidad.class);

		if (filtro.getTdicodigo() != null) {
			criteria.add(Restrictions.eq("tdicodigo", filtro.getTdicodigo()));
		}
		
		return (List<SaTipoDocumentoIdentidad>) criteria.list();
	}

	@Override
	public int actualizar(SaTipoDocumentoIdentidad filtro) {
		update(filtro);
		return 1;
	}

	@Override
	public int contador(SaTipoDocumentoIdentidad filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipoDocumentoIdentidad.class);
		criteria.setProjection(Projections.rowCount());


		if (UtilesCommons.noEsVacio(filtro.getTditipodocid())) {
			criteria.add(Restrictions.eq("tditipodocid", filtro.getTditipodocid()));
		}
		if (UtilesCommons.noEsVacio(filtro.getTdicodigo())) {
			criteria.add(Restrictions.like("tdicodigo", filtro.getTdicodigo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getTdidescripcion())) {
			criteria.add(Restrictions.like("tdidescripcion", filtro.getTdidescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getTdiestado())) {
			criteria.add(Restrictions.eq("tdiestado", filtro.getTdiestado()));
		}

		return Integer.parseInt(criteria.uniqueResult().toString());

	}

	@Override
	public List<SaTipoDocumentoIdentidad> listarTodos(SaTipoDocumentoIdentidad filtro,boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(SaTipoDocumentoIdentidad.class);

		if (UtilesCommons.noEsVacio(filtro.getTditipodocid())) {
			criteria.add(Restrictions.eq("tditipodocid", filtro.getTditipodocid()));
		}
		if (UtilesCommons.noEsVacio(filtro.getTdicodigo())) {
			criteria.add(Restrictions.like("tdicodigo", filtro.getTdicodigo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getTdidescripcion())) {
			criteria.add(Restrictions.like("tdidescripcion", filtro.getTdidescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getTdiestado())) {
			criteria.add(Restrictions.eq("tdiestado", filtro.getTdiestado()));
		}
		if(paginable){
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}
		
		return (List<SaTipoDocumentoIdentidad>) criteria.list();
	}

	
}
