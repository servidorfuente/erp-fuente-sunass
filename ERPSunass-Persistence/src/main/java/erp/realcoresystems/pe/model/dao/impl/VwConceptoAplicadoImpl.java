package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.VwConceptoAplicadoDao;
import erp.realcoresystems.pe.model.domain.vista.VwConceptoAplicado;

@Repository
public class VwConceptoAplicadoImpl extends AbstractDaoImpl<VwConceptoAplicado, Integer> implements VwConceptoAplicadoDao {

	protected VwConceptoAplicadoImpl() {
		super(VwConceptoAplicado.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<VwConceptoAplicado> listarElementos(VwConceptoAplicado filtro, boolean paginable) {

		Criteria criteria = getCurrentSession().createCriteria(VwConceptoAplicado.class);
		
		if (UtilesCommons.noEsVacio(filtro.getIndice())) {
			criteria.add(Restrictions.eq("indice", filtro.getIndice()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getAlualumnoid())) {
			criteria.add(Restrictions.eq("alualumnoid", filtro.getAlualumnoid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCrrcarreraid())) {
			criteria.add(Restrictions.eq("crrcarreraid", filtro.getCrrcarreraid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));		
		}	
		if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCurcursoid())) {
			criteria.add(Restrictions.eq("curcursoid", filtro.getCurcursoid()));		
		}
		
		if (UtilesCommons.noEsVacio(filtro.getPersona())) {
			criteria.add(Restrictions.eq("persona", filtro.getPersona()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getOblestado())) {
			criteria.add(Restrictions.eq("oblestado", filtro.getOblestado()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getPeobestado())) {
			criteria.add(Restrictions.eq("peobestado", filtro.getPeobestado()));		
		}
		
		if (UtilesCommons.noEsVacio(filtro.getPaconcpagoconceptoid())) {
			criteria.add(Restrictions.eq("paconcpagoconceptoid", filtro.getPaconcpagoconceptoid()));		
		}
		// Tipo documento ne NC
		if (UtilesCommons.noEsVacio(filtro.getString1())) {
			criteria.add(Restrictions.ne("tipodocumento", filtro.getString1()));		
		}
		
		setOrdenable(criteria, ORDER_ASC, filtro.getListaAtributoOrdenacion());
		
		if(paginable){
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());		
		}
		return criteria.list();
	
	}
	


	@Override
	public List<VwConceptoAplicado> validate(VwConceptoAplicado filtro) {
		Criteria criteria = getCurrentSession().createCriteria(VwConceptoAplicado.class);

//		if (filtro.getTurcodigo() != null) {
//			criteria.add(Restrictions.eq("turcodigo", filtro.getTurcodigo()));
//		}
		
		return (List<VwConceptoAplicado>) criteria.list();
	}

	

	@Override
	public int contador(VwConceptoAplicado filtro) {
		Criteria criteria = getCurrentSession().createCriteria(VwConceptoAplicado.class);
		
		if (UtilesCommons.noEsVacio(filtro.getIndice())) {
			criteria.add(Restrictions.eq("indice", filtro.getIndice()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getAlualumnoid())) {
			criteria.add(Restrictions.eq("alualumnoid", filtro.getAlualumnoid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCrrcarreraid())) {
			criteria.add(Restrictions.eq("crrcarreraid", filtro.getCrrcarreraid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));		
		}	
		if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCurcursoid())) {
			criteria.add(Restrictions.eq("curcursoid", filtro.getCurcursoid()));		
		}
		
		if (UtilesCommons.noEsVacio(filtro.getPersona())) {
			criteria.add(Restrictions.eq("persona", filtro.getPersona()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getOblestado())) {
			criteria.add(Restrictions.eq("oblestado", filtro.getOblestado()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getPeobestado())) {
			criteria.add(Restrictions.eq("peobestado", filtro.getPeobestado()));		
		}
		criteria.setProjection(Projections.rowCount());
		Object objRes= criteria.uniqueResult(); 
		return Integer.parseInt(objRes != null ? objRes.toString() : "0");	
	}

	@Override
	public VwConceptoAplicado obtenerPorId(VwConceptoAplicado filtro) {
		Criteria criteria = getCurrentSession().createCriteria(VwConceptoAplicado.class);

		if (UtilesCommons.noEsVacio(filtro.getIndice())) {
			criteria.add(Restrictions.eq("indice", filtro.getIndice()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getAlualumnoid())) {
			criteria.add(Restrictions.eq("alualumnoid", filtro.getAlualumnoid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCrrcarreraid())) {
			criteria.add(Restrictions.eq("crrcarreraid", filtro.getCrrcarreraid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));		
		}	
		if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));		
		}
		if (UtilesCommons.noEsVacio(filtro.getCurcursoid())) {
			criteria.add(Restrictions.eq("curcursoid", filtro.getCurcursoid()));		
		}
		
		
		return (criteria.uniqueResult() != null ? (VwConceptoAplicado) criteria.uniqueResult() : null);
	}

}
