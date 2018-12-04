package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.SaTablaEstadoDao;
import erp.realcoresystems.pe.model.domain.SaTablaEstado;

@Repository
public class SaTablaEstadoDaoImpl extends AbstractDaoImpl<SaTablaEstado, String>  implements SaTablaEstadoDao{

	protected SaTablaEstadoDaoImpl() {
		super(SaTablaEstado.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaTablaEstado> listarEstadosPorTabla(int id_Tabla) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablaEstado.class);
		criteria.add(Restrictions.eq("tabtablaid", id_Tabla));
		criteria.add(Restrictions.eq("tbsestado", 1));/** INDICA ACTIVO **/
		return (List<SaTablaEstado>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaTablaEstado> listarEstadoEn(int id_Tabla, Integer[] en) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablaEstado.class);
		criteria.add(Restrictions.eq("tabtablaid", id_Tabla));
		if(en != null && en.length > 0){
			criteria.add(Restrictions.eq("tbsestadoenlaceid", en));
		}
		criteria.add(Restrictions.eq("tbsestado", 1));/** INDICA ACTIVO **/
		return (List<SaTablaEstado>) criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaTablaEstado> listarEstados(int id_Tabla, Integer[] en) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablaEstado.class);
		criteria.add(Restrictions.eq("tabtablaid", id_Tabla));
		if(en != null && en.length > 0){
			criteria.add(Restrictions.in("tbsestadoenlaceid", en));
		}
		criteria.add(Restrictions.eq("tbsestado", 1));/** INDICA ACTIVO **/
		return (List<SaTablaEstado>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaTablaEstado> listarEstadoNoIgualA(int id_Tabla, Integer[] fuera) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablaEstado.class);
		criteria.add(Restrictions.eq("tabtablaid", id_Tabla));
		if(fuera != null && fuera.length > 0){
			criteria.add(Restrictions.eq("tbsestadoenlaceid", fuera));
		}
		criteria.add(Restrictions.eq("tbsestado", 1));/** INDICA ACTIVO **/
		return (List<SaTablaEstado>) criteria.list();
	}

	@Override
	public SaTablaEstado obtenerPorId(int id_estado) {
		Criteria criteria = getCurrentSession().createCriteria(SaTablaEstado.class);
		criteria.add(Restrictions.eq("tbsestadoenlaceid", id_estado));
		criteria.add(Restrictions.eq("tbsestado", 1));/** INDICA ACTIVO **/
		return (SaTablaEstado) criteria.uniqueResult();
	}

}
