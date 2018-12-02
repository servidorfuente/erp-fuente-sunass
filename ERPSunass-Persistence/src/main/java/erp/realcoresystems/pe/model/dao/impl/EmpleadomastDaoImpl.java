package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.EmpleadomastDao;
import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.SaDependencias;
import erp.realcoresystems.pe.model.domain.vista.VwEmpleado;
import erp.realcoresystems.pe.model.util.Utiles;

import java.util.List;

@Repository
public class EmpleadomastDaoImpl extends AbstractDaoImpl<Empleadomast, Integer>  implements EmpleadomastDao {

	protected EmpleadomastDaoImpl() {
		super(Empleadomast.class);
	}

	@Override
	public Empleadomast obtenerPorId(int empleadoId) {
		Criteria criteria = getCurrentSession().createCriteria(Empleadomast.class);
		criteria.add(Restrictions.eq("empleado", empleadoId));
		return (Empleadomast) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleadomast> listar(Empleadomast empleado) {
		Criteria criteria = getCurrentSession().createCriteria(Empleadomast.class);
        if (empleado.getUneunegocioid() != null && empleado.getUneunegocioid() != 0){
        	criteria.add(Restrictions.like("uneunegocioid", empleado.getUneunegocioid()));
        }
		criteria.setFirstResult(empleado.getInicio());
		criteria.setMaxResults(empleado.getNumeroFilas());
		criteria.setFetchSize(empleado.getNumeroFilas());
		return (List<Empleadomast>) criteria.list();
	}

	@Override
	public int guardar(Empleadomast empleado) {
		save(empleado);
		return empleado.getEmpleado();	
	}

	@Override
	public int actualizar(Empleadomast empleado) {
		update(empleado);
		return 1;
	}

	@Override
	public int eliminar(Empleadomast empleado) {
		delete(empleado);
		return 1;
	}

	@Override
	public int contador(Empleadomast empleado) {
		Criteria criteria = getCurrentSession().createCriteria(Empleadomast.class);
        if (empleado.getUneunegocioid() != null && empleado.getUneunegocioid() != 0){
        	criteria.add(Restrictions.like("uneunegocioid", empleado.getUneunegocioid()));
        }
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleadomast> obtenerPorDependencia(SaDependencias dependencia){
		Criteria criteria = getCurrentSession().createCriteria(Empleadomast.class);
		if(dependencia.getUneunegocioid() != null && dependencia.getUneunegocioid() > 0 ){
			criteria.add(Restrictions.eq("uneunegocioid", dependencia.getUneunegocioid()));
		}
		if(dependencia.getNidedep() != null && dependencia.getNidedep() > 0){
			criteria.add(Restrictions.eq("posicionorganigrama", dependencia.getNidedep()));
		}
		return (List<Empleadomast>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VwEmpleado> listar(VwEmpleado filtro, boolean paginable){
		Criteria criteria = getCurrentSession().createCriteria(VwEmpleado.class);
		if(filtro.getUneunegocioid() != null && filtro.getUneunegocioid() > 0){
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
		}
		if(!Utiles.vacio(filtro.getEstado())){
			criteria.add(Restrictions.eq("estado", filtro.getEstado()));
		}
		if(filtro.getNidedep() != null && filtro.getNidedep() > 0){
			criteria.add(Restrictions.eq("nidedep", filtro.getNidedep()));
		}
		if(!Utiles.vacio(filtro.getFlagsmf())){
			criteria.add(Restrictions.eq("flagsmf", filtro.getFlagsmf()));
		}
		if(paginable){
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}
		return (List<VwEmpleado>) criteria.list();
	}
}
