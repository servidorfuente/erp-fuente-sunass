package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaMiscelaneosHeaderDao;
import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosheader;

@Repository
public class SaMiscelaneosHeaderDaoImpl extends AbstractDaoImpl<MaMiscelaneosheader, String> implements SaMiscelaneosHeaderDao {

	protected SaMiscelaneosHeaderDaoImpl() {
		super(MaMiscelaneosheader.class);
	}

	@Override
	public MaMiscelaneosheader obtenerPorID(MaMiscelaneosheader obj) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosheader.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", obj.getAplicacioncodigo()));
		criteria.add(Restrictions.eq("codigotabla", obj.getCodigotabla()));
		criteria.add(Restrictions.eq("compania", obj.getCompania()));
		return (MaMiscelaneosheader) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaMiscelaneosheader> listarElementos(MaMiscelaneosheader filtro) {
		Criteria criteria  = getCurrentSession().createCriteria(MaMiscelaneosheader.class);
		filtrarEntidad(criteria,filtro); 
		criteria.addOrder(Order.asc("descripcionlocal"));
		return (List<MaMiscelaneosheader>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaMiscelaneosheader> listar(MaMiscelaneosheader filtro, boolean paginable) {
		Criteria criteria  = createCriteria(MaMiscelaneosheader.class);
		filtrarEntidad(criteria,filtro);
		filtro.setPaginable(paginable);
		setPaginable(filtro, criteria);
		criteria.addOrder(Order.asc("descripcionlocal"));
		return (List<MaMiscelaneosheader>) criteria.list();
	}
	
	@Override
	public int contar(MaMiscelaneosheader filtro) {
		Criteria criteria  = getCurrentSession().createCriteria(MaMiscelaneosheader.class);
		filtrarEntidad(criteria,filtro);
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());
	}
	
	public <V extends Entidad> void filtrarEntidad(Criteria criteria, V entidad){
		if(UtilesCommons.esInstancia(entidad, MaMiscelaneosheader.class)){
			MaMiscelaneosheader filtro = (MaMiscelaneosheader) entidad;
			if(UtilesCommons.noEsVacio(filtro.getAplicacioncodigo())){
				criteria.add(Restrictions.eq("aplicacioncodigo", filtro.getAplicacioncodigo()));
			}
			if(UtilesCommons.noEsVacio(filtro.getCompania())){
				criteria.add(Restrictions.eq("compania", filtro.getCompania()));
			}
			if(UtilesCommons.noEsVacio(filtro.getCodigotabla())){
				criteria.add(Restrictions.like("codigotabla", filtro.getCodigotabla(),MatchMode.ANYWHERE).ignoreCase());
			}
			if(UtilesCommons.noEsVacio(filtro.getDescripcionlocal())){
				criteria.add(Restrictions.like("descripcionlocal", filtro.getDescripcionlocal(),MatchMode.ANYWHERE).ignoreCase());
			}
			if(UtilesCommons.noEsVacio(filtro.getEstado())){
				criteria.add(Restrictions.eq("estado", filtro.getEstado()));
			}
		}
	}

	@Override
	public int guardar(MaMiscelaneosheader obj) {
		save(obj);
		return 1;
	}
	
	@Override
	public int actualizar(MaMiscelaneosheader obj) {
		update(obj);
		return 1;
	}
	
	@Override
	public int eliminar(MaMiscelaneosheader obj) {
		delete(obj);
		return 1;
	}



}
