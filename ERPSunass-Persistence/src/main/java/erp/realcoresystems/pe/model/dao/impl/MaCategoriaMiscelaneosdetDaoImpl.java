package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaCategoriaMiscelaneosdetDao;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdet;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdetPK;
import erp.realcoresystems.pe.model.util.FieldAuditoria;

@Repository
public class MaCategoriaMiscelaneosdetDaoImpl  extends AbstractDaoImpl<MaCategoriaMiscelaneosdet, MaCategoriaMiscelaneosdetPK> implements MaCategoriaMiscelaneosdetDao {

	protected MaCategoriaMiscelaneosdetDaoImpl() {
		super(MaCategoriaMiscelaneosdet.class);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaCategoriaMiscelaneosdet> listarElementos(MaCategoriaMiscelaneosdet objDao, boolean paginable) {
		Criteria criteria = getCurrentSession().createCriteria(MaCategoriaMiscelaneosdet.class);
		
		if (UtilesCommons.noEsVacio(objDao.getId().getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("id.aplicacioncodigo", objDao.getId().getAplicacioncodigo()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getId().getCodigotablaCateg())) {
			criteria.add(Restrictions.eq("id.codigotablaCateg", objDao.getId().getCodigotablaCateg()));		
		}		
		
		if (UtilesCommons.noEsVacio(objDao.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));		
		}
		
		if (UtilesCommons.noEsVacio(objDao.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));		
		}
		
		if (UtilesCommons.noEsVacio(objDao.getCategSecuenciaPadre())) {
			criteria.add(Restrictions.eq("categSecuenciaPadre", objDao.getCategSecuenciaPadre()));		
		}			
		if (UtilesCommons.noEsVacio(objDao.getTipoNivel())) {
			criteria.add(Restrictions.eq("tipoNivel", objDao.getTipoNivel()));		
		}	
		
		if (UtilesCommons.noEsVacio(objDao.getNombre())) {
			criteria.add(Restrictions.like("nombre", objDao.getNombre(),MatchMode.ANYWHERE).ignoreCase());		
		}		
		if (UtilesCommons.noEsVacio(objDao.getEstado())) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if("NO_IN_CATEG".equals(objDao.getFlagConsultaEntGlobal())){
			if(UtilesCommons.noEsVacio(objDao.getListaInteger()) && UtilesCommons.noEsVacio(objDao.getAtributoList())){
				criteria.add(Restrictions.not(
						Restrictions.in(objDao.getAtributoList(), objDao.getListaInteger())
						)
					);
			}							
		}else{
			if(UtilesCommons.noEsVacio(objDao.getListaInteger()) && UtilesCommons.noEsVacio(objDao.getAtributoList())){
				criteria.add(Restrictions.in(objDao.getAtributoList(), objDao.getListaInteger()));
			}			
		}
		
		if(paginable){
			criteria.setFirstResult(objDao.getInicio());
			criteria.setMaxResults(objDao.getNumeroFilas());
			criteria.setFetchSize(objDao.getNumeroFilas());		
		}
		return criteria.list();
	}

	@Override
	public int contarElementos(MaCategoriaMiscelaneosdet objDao) {
		Criteria criteria = getCurrentSession().createCriteria(MaCategoriaMiscelaneosdet.class);
		
		if (UtilesCommons.noEsVacio(objDao.getId().getAplicacioncodigo())) {
			criteria.add(Restrictions.eq("id.aplicacioncodigo", objDao.getId().getAplicacioncodigo()));		
		}		
		if (UtilesCommons.noEsVacio(objDao.getId().getCodigotablaCateg())) {
			criteria.add(Restrictions.eq("id.codigotablaCateg", objDao.getId().getCodigotablaCateg()));		
		}	
		if (UtilesCommons.noEsVacio(objDao.getUneunegocioid())) {
			criteria.add(Restrictions.eq("uneunegocioid", objDao.getUneunegocioid()));		
		}
		
		if (UtilesCommons.noEsVacio(objDao.getMoemestudioid())) {
			criteria.add(Restrictions.eq("moemestudioid", objDao.getMoemestudioid()));		
		}
		
		if (UtilesCommons.noEsVacio(objDao.getCategSecuenciaPadre())) {
			criteria.add(Restrictions.eq("categSecuenciaPadre", objDao.getCategSecuenciaPadre()));		
		}
		if (UtilesCommons.noEsVacio(objDao.getTipoNivel())) {
			criteria.add(Restrictions.eq("tipoNivel", objDao.getTipoNivel()));		
		}	
		
		if (UtilesCommons.noEsVacio(objDao.getNombre())) {
			criteria.add(Restrictions.like("nombre", objDao.getNombre(),MatchMode.ANYWHERE).ignoreCase());		
		}		
		if (UtilesCommons.noEsVacio(objDao.getEstado())) {
			criteria.add(Restrictions.eq("estado", objDao.getEstado()));
		}
		if("NO_IN_CATEG".equals(objDao.getFlagConsultaEntGlobal())){
			if(UtilesCommons.noEsVacio(objDao.getListaInteger()) && UtilesCommons.noEsVacio(objDao.getAtributoList())){
				criteria.add(Restrictions.not(
						Restrictions.in(objDao.getAtributoList(), objDao.getListaInteger())
						)
					);
			}							
		}else{
			if(UtilesCommons.noEsVacio(objDao.getListaInteger()) && UtilesCommons.noEsVacio(objDao.getAtributoList())){
				criteria.add(Restrictions.in(objDao.getAtributoList(), objDao.getListaInteger()));
			}			
		}
		
		criteria.setProjection(Projections.rowCount());
		Object objRes= criteria.uniqueResult(); 
		return Integer.parseInt(objRes != null ? objRes.toString() : "0");	
	}

	@Override
	public int guardar(MaCategoriaMiscelaneosdet objDao) {
		/*Obtener MAX insertado**/
		int valorMax=0;	
		if(UtilesCommons.noEsVacio(objDao.getId().getAplicacioncodigo()) &&
			UtilesCommons.noEsVacio(objDao.getId().getCodigotablaCateg())){
			Criteria criteria = getCurrentSession().createCriteria(MaCategoriaMiscelaneosdet.class);
			criteria.add(Restrictions.eq("id.aplicacioncodigo", objDao.getId().getAplicacioncodigo()));
			criteria.add(Restrictions.eq("id.codigotablaCateg", objDao.getId().getCodigotablaCateg()));
			
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("id.categSecuencia"));																
			criteria.setProjection(proj);		
			Object result = criteria.uniqueResult();
				
			if(result!=null){		
				valorMax = Integer.parseInt(result.toString());	
			}		
			valorMax++;
			objDao.getId().setCategSecuencia(valorMax);		
			save(objDao);

		}		
		return  (valorMax);
	}

	@Override
	public int actualizar(MaCategoriaMiscelaneosdet objDao) {
		update(objDao);
		return 1;
	}

	@Override
	public int eliminar(MaCategoriaMiscelaneosdet objDao) {
		delete(objDao);
		return 1;
	}
	
	@Override
	public int guardarAuditoria(MaCategoriaMiscelaneosdet obj, String tipoTransaccion) {
		String primaryKeyData = FieldAuditoria.getPrimaryKeyData(obj);
		iniciarAuditoriaTrace(obj, tipoTransaccion, primaryKeyData);
		return 1;
	}


}
