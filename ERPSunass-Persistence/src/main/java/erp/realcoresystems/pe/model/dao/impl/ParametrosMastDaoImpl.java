package erp.realcoresystems.pe.model.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.ParametrosMastDao;
import erp.realcoresystems.pe.model.domain.ParametrosMast;
import erp.realcoresystems.pe.model.domain.ParametrosMastPK;

@Repository
public class ParametrosMastDaoImpl extends AbstractDaoImpl<ParametrosMast, ParametrosMastPK>implements ParametrosMastDao {

	protected ParametrosMastDaoImpl() {
		super(ParametrosMast.class);
	}

	@Override
	public ParametrosMast buscarPorID(ParametrosMastPK id) {
		Criteria cq = getCurrentSession().createCriteria(ParametrosMast.class);
		cq.add(Restrictions.idEq(id));
		Object result = cq.uniqueResult();		
		return (result!=null?(ParametrosMast)result:null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParametrosMast> listarPorPag(ParametrosMast filter) {
		Criteria cq = getCurrentSession().createCriteria(ParametrosMast.class);
		if(filter.getId().getAplicacioncodigo() != null && !"".equals(filter.getId().getAplicacioncodigo())){
			cq.add(Restrictions.eq("id.aplicacioncodigo", filter.getId().getAplicacioncodigo()));
		}
		if(filter.getId().getCompaniacodigo() != null && !"".equals(filter.getId().getCompaniacodigo())){
			cq.add(Restrictions.eq("id.companiacodigo", filter.getId().getCompaniacodigo()));
		}
		if(filter.getId().getParametroclave() != null && !"".equals(filter.getId().getParametroclave())){
			cq.add(Restrictions.ilike("id.parametroclave", filter.getId().getParametroclave(), MatchMode.ANYWHERE));
		}
		if(filter.getDescripcionparametro() != null && !"".equals(filter.getDescripcionparametro())){
			cq.add(Restrictions.ilike("descripcionparametro", filter.getDescripcionparametro(), MatchMode.ANYWHERE));
		}
		if(filter.getEstado() != null && !"".equals(filter.getEstado())){
			cq.add(Restrictions.eq("estado", filter.getEstado()));
		}
		
		cq.addOrder(Order.asc("id.parametroclave"));
		
		cq.setFirstResult(filter.getInicio());
		cq.setMaxResults(filter.getNumeroFilas());
		cq.setFetchSize(filter.getNumeroFilas());
		return (List<ParametrosMast>) cq.list();
	}
	
	@Override
	public int contadorPag(ParametrosMast filter){
		Criteria cq = getCurrentSession().createCriteria(ParametrosMast.class);
		if(filter.getId().getAplicacioncodigo() != null && !"".equals(filter.getId().getAplicacioncodigo())){
			cq.add(Restrictions.eq("id.aplicacioncodigo", filter.getId().getAplicacioncodigo()));
		}
		if(filter.getId().getCompaniacodigo() != null && !"".equals(filter.getId().getCompaniacodigo())){
			cq.add(Restrictions.eq("id.companiacodigo", filter.getId().getCompaniacodigo()));
		}
		if(filter.getId().getParametroclave() != null && !"".equals(filter.getId().getParametroclave())){
			cq.add(Restrictions.ilike("id.parametroclave", filter.getId().getParametroclave(), MatchMode.ANYWHERE));
		}
		if(filter.getDescripcionparametro() != null && !"".equals(filter.getDescripcionparametro())){
			cq.add(Restrictions.ilike("descripcionparametro", filter.getDescripcionparametro(), MatchMode.ANYWHERE));
		}
		if(filter.getEstado() != null && !"".equals(filter.getEstado())){
			cq.add(Restrictions.eq("estado", filter.getEstado()));
		}		
		cq.setProjection(Projections.rowCount());
		return Integer.parseInt(cq.uniqueResult().toString());
	}


	@Override
	public void registrarParametro(ParametrosMast parametrosMast){
		getCurrentSession().save(parametrosMast);
	}
	
	@Override
	public void actualizarParametro(ParametrosMast parametrosMast) {
		update(parametrosMast);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> listarParametroPorNegocio(String appCodigo, String companiaCodigo) {
		Criteria criteria = getCurrentSession().createCriteria(ParametrosMast.class);
		criteria.add(Restrictions.eq("id.aplicacioncodigo", appCodigo));
		criteria.add(Restrictions.in("id.companiacodigo", new String[]{"999999",companiaCodigo}));
		List<ParametrosMast> lista =  (List<ParametrosMast>) criteria.list();
		Map<String, String> mapParametros = new HashMap<String, String>();
		for(ParametrosMast parametro : lista){
			if(parametro.getTipodedatoflag().equals("T")){
				mapParametros.put(parametro.getId().getParametroclave().trim(), parametro.getTexto().trim());
			}else if (parametro.getTipodedatoflag().equals("N")) {
				mapParametros.put(parametro.getId().getParametroclave().trim(), parametro.getNumero().toString());
			}else if (parametro.getTipodedatoflag().equals("D")) {
				mapParametros.put(parametro.getId().getParametroclave().trim(), parametro.getFecha().toString());
			}
		}
		return mapParametros;
	}

	@Override
	public int guardar(ParametrosMast objSave) {
		save(objSave);
		return 1;
	}

	@Override
	public int actualizar(ParametrosMast objSave) {
		update(objSave);
		return 1;
	}

	@Override
	public int eliminar(ParametrosMast objSave) {
		delete(objSave);
		return 1;
	}

}
