package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaCalendarioDao;
import erp.realcoresystems.pe.model.domain.SaCalendario;
import erp.realcoresystems.pe.model.domain.vista.VwCalendario;

@Repository
public class SaCalendarioDaoImpl extends AbstractDaoImpl<SaCalendario, Integer>implements SaCalendarioDao {

	protected SaCalendarioDaoImpl() {
		super(SaCalendario.class);
	}

	@Override
	public SaCalendario obtenerPorID(Integer id) {
		Object result = findById(id);
		return UtilesCommons.esNulo(result) ? null : (SaCalendario) result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SaCalendario obtenerPorCodigoCalendario(String codigoelemento, SaCalendario filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaCalendario.class);
		filtro.setCalcodigocalendario(codigoelemento);
		filtrarEntidad(criteria, filtro);
		criteria.addOrder(Order.desc("calcalendarioid"));
		List<SaCalendario> list = (List<SaCalendario>) criteria.list();
		return UtilesCommons.noEsVacio(list) ? UtilesCommons.obtenerPrimerElementoLista(list) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VwCalendario> listar(VwCalendario filtro, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(VwCalendario.class);
		filtrarEntidad(criteria, filtro);
		if (paginable) {
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}
		criteria.addOrder(Order.asc("calfechadesde"));
		return criteria.list();
	}

	@Override
	public int contarTotal(VwCalendario filtro) {
		Criteria criteria = getCurrentSession().createCriteria(VwCalendario.class);
		filtrarEntidad(criteria, filtro);
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}

	public int obtenerMaxId() {
		Criteria criteria = getCurrentSession().createCriteria(SaCalendario.class);
		criteria.setProjection(Projections.max("calcalendarioid"));
		Object result = criteria.uniqueResult();
		return  UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}

	@Override
	public int guardar(SaCalendario objSave) {
		save(objSave);
		return 1;
	}
	
	@Override
	public int actualizar(SaCalendario objSave) {
		update(objSave);
		return 1;
	}

	@Override
	public int eliminar(SaCalendario objSave) {
		delete(objSave);
		return 1;
	}

	public <V> void filtrarEntidad(Criteria criteria, V entidad) {
		if (UtilesCommons.esInstancia(entidad, VwCalendario.class)) {
			VwCalendario filtro = (VwCalendario) entidad;
			if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
				criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
				criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getPerperiodoid())) {
				criteria.add(Restrictions.eq("perperiodoid", filtro.getPerperiodoid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCrrcarreraid())) {
				criteria.add(Restrictions.eq("crrcarreraid", filtro.getCrrcarreraid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCalcodigocalendario())) {
				criteria.add(Restrictions.eq("calcodigocalendario", filtro.getCalcodigocalendario()));
			}
			if (UtilesCommons.noEsVacio(filtro.getSecseccionid())) {
				criteria.add(Restrictions.eq("secseccionid", filtro.getSecseccionid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCurcursoid())) {
				criteria.add(Restrictions.eq("curcursoid", filtro.getCurcursoid()));
			}
			if (UtilesCommons.noEsVacio(filtro.getCalestado())) {
				criteria.add(Restrictions.eq("calestado", filtro.getCalestado()));
			}
		} else if (UtilesCommons.esInstancia(entidad, SaCalendario.class)) {
			SaCalendario filtro = (SaCalendario) entidad;
			if(UtilesCommons.sonCadenasIguales(filtro.getString10(), "CONSULTA_CODIGO_CALENDARIO")){
							
				if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
					criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
					criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getPerperiodoid())) {
					criteria.add(Restrictions.eq("perperiodoid", filtro.getPerperiodoid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getCalestado())) {
					criteria.add(Restrictions.eq("calestado", filtro.getCalestado()));
				}
				if (UtilesCommons.noEsVacio(filtro.getCalcodigocalendario())) {
					criteria.add(Restrictions.eq("calcodigocalendario", filtro.getCalcodigocalendario()));
				} 
				
				if(UtilesCommons.noEsVacio(filtro.getCrrcarreraid())){					
					Criterion c1 = Restrictions.eq("crrcarreraid", filtro.getCrrcarreraid());
					Criterion c2 = Restrictions.isNull("crrcarreraid");
					criteria.add(Restrictions.or(c1, c2));
				}else{
					Criterion c1 = Restrictions.isNull("crrcarreraid");
					criteria.add(c1);
				}
			}
			else{
				
				if (UtilesCommons.noEsVacio(filtro.getUneunegocioid())) {
					criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getMoemestudioid())) {
					criteria.add(Restrictions.eq("moemestudioid", filtro.getMoemestudioid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getPerperiodoid())) {
					criteria.add(Restrictions.eq("perperiodoid", filtro.getPerperiodoid()));
				}
				if (UtilesCommons.noEsVacio(filtro.getCalestado())) {
					criteria.add(Restrictions.eq("calestado", filtro.getCalestado()));
				}
				if (UtilesCommons.noEsVacio(filtro.getCalcodigocalendario())) {
					criteria.add(Restrictions.eq("calcodigocalendario", filtro.getCalcodigocalendario()));
				} 
			}
		}
	}

}
