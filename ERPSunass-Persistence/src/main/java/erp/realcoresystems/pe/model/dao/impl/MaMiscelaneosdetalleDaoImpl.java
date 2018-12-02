package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaMiscelaneosdetalleDao;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.util.ValorRetorno;

@Repository
public class MaMiscelaneosdetalleDaoImpl extends AbstractDaoImpl<MaMiscelaneosdetalle, String>
		implements MaMiscelaneosdetalleDao {

	protected MaMiscelaneosdetalleDaoImpl() {
		super(MaMiscelaneosdetalle.class);
	}

	@Override
	public MaMiscelaneosdetalle obtenerPorID(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		if (maMiscelaneosdetalle.getAplicacioncodigo() != null && !"".equals(maMiscelaneosdetalle.getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("aplicacioncodigo", maMiscelaneosdetalle.getAplicacioncodigo()));
		}
		if (maMiscelaneosdetalle.getCompania() != null && !"".equals(maMiscelaneosdetalle.getCompania())) {
			criteria.add(Restrictions.eq("compania", maMiscelaneosdetalle.getCompania()));
		}
		if (maMiscelaneosdetalle.getCodigotabla() != null && !"".equals(maMiscelaneosdetalle.getCodigotabla())) {
			criteria.add(Restrictions.eq("codigotabla", maMiscelaneosdetalle.getCodigotabla()));
		}
		if (maMiscelaneosdetalle.getCodigoelemento() != null && !"".equals(maMiscelaneosdetalle.getCodigoelemento())) {
			criteria.add(Restrictions.eq("codigoelemento", maMiscelaneosdetalle.getCodigoelemento()));
		}
		if (criteria.uniqueResult() != null) {
			return (MaMiscelaneosdetalle) criteria.uniqueResult();
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaMiscelaneosdetalle> listarElementos(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);

		if (maMiscelaneosdetalle.getAplicacioncodigo() != null && !"".equals(maMiscelaneosdetalle.getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("aplicacioncodigo", maMiscelaneosdetalle.getAplicacioncodigo()));
		}
		if (maMiscelaneosdetalle.getCompania() != null && !"".equals(maMiscelaneosdetalle.getCompania())) {
			criteria.add(Restrictions.eq("compania", maMiscelaneosdetalle.getCompania()));
		}
		if (maMiscelaneosdetalle.getCodigotabla() != null && !"".equals(maMiscelaneosdetalle.getCodigotabla())) {
			criteria.add(Restrictions.eq("codigotabla", maMiscelaneosdetalle.getCodigotabla()));
		}
		if (maMiscelaneosdetalle.getCodigoelemento() != null && !"".equals(maMiscelaneosdetalle.getCodigoelemento())) {
			criteria.add(Restrictions.eq("codigoelemento", maMiscelaneosdetalle.getCodigoelemento()));
		}
		if (maMiscelaneosdetalle.getEstado() != null && !"".equals(maMiscelaneosdetalle.getEstado())) {
			criteria.add(Restrictions.eq("estado", maMiscelaneosdetalle.getEstado()));
		}
		if (maMiscelaneosdetalle.getValorcodigo1() != null && !"".equals(maMiscelaneosdetalle.getValorcodigo1())) {
			criteria.add(Restrictions.eq("valorcodigo1", maMiscelaneosdetalle.getValorcodigo1()));
			criteria.addOrder(Order.desc("ultimafechamodif"));
		}
		if (maMiscelaneosdetalle.getValorcodigo2() != null && !"".equals(maMiscelaneosdetalle.getValorcodigo2())) {
			criteria.add(Restrictions.eq("valorcodigo2", maMiscelaneosdetalle.getValorcodigo2()));
		}
		if(maMiscelaneosdetalle.getValorentero1() != null && maMiscelaneosdetalle.getValorentero1() > 0){
			criteria.add(Restrictions.eq("valorentero1", maMiscelaneosdetalle.getValorentero1()));
		}
		if(maMiscelaneosdetalle.getValorentero2() != null && maMiscelaneosdetalle.getValorentero2() > 0){
			criteria.add(Restrictions.eq("valorentero2", maMiscelaneosdetalle.getValorentero2()));
			criteria.addOrder(Order.asc("valorentero3"));
		}
		if(maMiscelaneosdetalle.getValorentero3() != null && maMiscelaneosdetalle.getValorentero3() > 0){
			criteria.add(Restrictions.eq("valorentero3", maMiscelaneosdetalle.getValorentero3()));
		}

		////ORDEN POR FLAG O POR DEFAULT
		if("ORDEN_ESPECIAL".equals(maMiscelaneosdetalle.getFlagConsultaEntGlobal()) && maMiscelaneosdetalle.getString10()!=null){
			criteria.addOrder(Order.asc(maMiscelaneosdetalle.getString10()));
		}else if("ORDEN_PERIODOS".equals(maMiscelaneosdetalle.getFlagConsultaEntGlobal())){
			criteria.addOrder(Order.desc("descripcionlocal"));
		}else{
			criteria.addOrder(Order.asc("descripcionlocal"));
		}

		return (List<MaMiscelaneosdetalle>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaMiscelaneosdetalle> listarElementosPag(MaMiscelaneosdetalle filtro) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		criteria.setFirstResult(filtro.getInicio());
		criteria.setMaxResults(filtro.getNumeroFilas());
		criteria.setFetchSize(filtro.getNumeroFilas());

		if (UtilesCommons.noEsVacio(filtro.getCodigotabla())) {
			criteria.add(Restrictions.eq("codigotabla", filtro.getCodigotabla()));
		}
		if (UtilesCommons.noEsVacio(filtro.getCodigoelemento())) {
			criteria.add(Restrictions.like("codigoelemento", filtro.getCodigoelemento(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getDescripcionlocal())) {
			criteria.add(Restrictions.like("descripcionlocal", filtro.getDescripcionlocal(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo1())) {
			criteria.add(Restrictions.like("valorcodigo1", filtro.getValorcodigo1(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo2())) {
			criteria.add(Restrictions.like("valorcodigo2", filtro.getValorcodigo2(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo3())) {
			criteria.add(Restrictions.like("valorcodigo3", filtro.getValorcodigo3(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo4())) {
			criteria.add(Restrictions.like("valorcodigo4", filtro.getValorcodigo4(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo5())) {
			criteria.add(Restrictions.like("valorcodigo5", filtro.getValorcodigo5(), MatchMode.ANYWHERE).ignoreCase());
		}		
		if (UtilesCommons.noEsVacio(filtro.getEstado())) {
			criteria.add(Restrictions.eq("estado", filtro.getEstado()));
		}
		criteria.addOrder(Order.asc("descripcionlocal").ignoreCase());
		return (List<MaMiscelaneosdetalle>) criteria.list();
	}

	@Override
	public int guardar(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		saveOrUpdate(maMiscelaneosdetalle);
		return ValorRetorno.GUARDO;
	}

	@Override
	public int crear(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		getCurrentSession().save(maMiscelaneosdetalle);
		return ValorRetorno.GUARDO;
	}

	@Override
	public int actualizar(MaMiscelaneosdetalle maMiscelaneosdetalle) {
		update(maMiscelaneosdetalle);
		return ValorRetorno.GUARDO;
	}

	@Override
	public int contadorTotaleslistarElementos(MaMiscelaneosdetalle filtro) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		criteria.setProjection(Projections.rowCount());

		if (UtilesCommons.noEsVacio(filtro.getCodigotabla())) {
			criteria.add(Restrictions.like("codigotabla", filtro.getCodigotabla(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getCodigoelemento())) {
			criteria.add(Restrictions.like("codigoelemento", filtro.getCodigoelemento(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getDescripcionlocal())) {
			criteria.add(Restrictions.like("descripcionlocal", filtro.getDescripcionlocal(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo1())) {
			criteria.add(Restrictions.like("valorcodigo1", filtro.getValorcodigo1(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo2())) {
			criteria.add(Restrictions.like("valorcodigo2", filtro.getValorcodigo2(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo3())) {
			criteria.add(Restrictions.like("valorcodigo3", filtro.getValorcodigo3(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo4())) {
			criteria.add(Restrictions.like("valorcodigo4", filtro.getValorcodigo4(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getValorcodigo5())) {
			criteria.add(Restrictions.like("valorcodigo5", filtro.getValorcodigo5(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (UtilesCommons.noEsVacio(filtro.getEstado())) {
			criteria.add(Restrictions.eq("estado", filtro.getEstado()));
		}

		Object result = criteria.uniqueResult();
		if(result == null){
			return 0;
		}else{
			return Integer.parseInt(result.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaMiscelaneosdetalle> listarTipoReservaPorArea(MaMiscelaneosdetalle maMiscelaneosdetalle){
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		
		if (maMiscelaneosdetalle.getAplicacioncodigo() != null && !"".equals(maMiscelaneosdetalle.getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("aplicacioncodigo", maMiscelaneosdetalle.getAplicacioncodigo()));
		}
		if (maMiscelaneosdetalle.getCompania() != null && !"".equals(maMiscelaneosdetalle.getCompania())) {
			criteria.add(Restrictions.eq("compania", maMiscelaneosdetalle.getCompania()));
		}
		if (maMiscelaneosdetalle.getCodigotabla() != null && !"".equals(maMiscelaneosdetalle.getCodigotabla())) {
			criteria.add(Restrictions.eq("codigotabla", maMiscelaneosdetalle.getCodigotabla()));
		}
		if (maMiscelaneosdetalle.getEstado() != null && !"".equals(maMiscelaneosdetalle.getEstado())) {
			criteria.add(Restrictions.eq("estado", maMiscelaneosdetalle.getEstado()));
		}
		if(maMiscelaneosdetalle.getValorentero2() != null && maMiscelaneosdetalle.getValorentero2() > 0){
			criteria.add(Restrictions.or(Restrictions.eq("valorentero2", maMiscelaneosdetalle.getValorentero2()), Restrictions.isNull("valorentero2")));
		}
		if(maMiscelaneosdetalle.getValorcodigo2()!= null && !"".equals(maMiscelaneosdetalle.getValorcodigo2())){
			criteria.add(Restrictions.or(Restrictions.eq("valorcodigo2", maMiscelaneosdetalle.getValorcodigo2()), Restrictions.isNull("valorcodigo2")));
		}
		return (List<MaMiscelaneosdetalle>) criteria.list(); 
	}

	@Override
	public int guardarCorrelativo(MaMiscelaneosdetalle objDao) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class).setProjection(Projections.max("codigoelemento"));
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		criteria.add(Restrictions.eq("codigotabla", objDao.getCodigotabla()));
		criteria.add(Restrictions.eq("compania", objDao.getCompania()));
		Object o = criteria.uniqueResult();
		int id = o == null ? 1 : 1 + Integer.parseInt(o.toString());
		objDao.setCodigoelemento(String.valueOf(id));
		save(objDao);
		return ValorRetorno.GUARDO;
	}

	@Override
	public int actualizarCorrelativo(MaMiscelaneosdetalle objDao) {
		update(objDao);
		return ValorRetorno.GUARDO;
	}
	
	@Override
	public int eliminarCorrelativo(MaMiscelaneosdetalle objDao) {
		delete(objDao);
		return ValorRetorno.GUARDO;
	}

	@Override
	public boolean verificarDuplicidad(MaMiscelaneosdetalle objDao) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		criteria.add(Restrictions.eq("codigotabla", objDao.getCodigotabla()));
		criteria.add(Restrictions.eq("compania", objDao.getCompania()));
		criteria.add(Restrictions.like("descripcionlocal", objDao.getDescripcionlocal(),MatchMode.ANYWHERE).ignoreCase());
		if(objDao.getCodigoelemento() != null && !"".equals(objDao.getCodigoelemento().trim())){
			criteria.add(Restrictions.ne("codigoelemento", objDao.getCodigoelemento()));
		}
		return criteria.list().isEmpty(); 
	}
	
	@Override
	public List<MaMiscelaneosdetalle> busquedaDuplicidad(MaMiscelaneosdetalle objDao) {
		Criteria criteria = getCurrentSession().createCriteria(MaMiscelaneosdetalle.class);
		criteria.add(Restrictions.eq("aplicacioncodigo", objDao.getAplicacioncodigo()));
		criteria.add(Restrictions.eq("codigotabla", objDao.getCodigotabla()));
		criteria.add(Restrictions.eq("compania", objDao.getCompania()));
		criteria.add(Restrictions.like("descripcionlocal", objDao.getDescripcionlocal(),MatchMode.ANYWHERE).ignoreCase());
		if(objDao.getCodigoelemento() != null && !"".equals(objDao.getCodigoelemento().trim())){
			criteria.add(Restrictions.ne("codigoelemento", objDao.getCodigoelemento()));
		}
		return criteria.list(); 
	}



}
