package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTipofuenteDao;
import erp.realcoresystems.pe.model.domain.SaTipofuente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsTipofuenteDaoImpl extends AbstractDaoImpl<SaTipofuente, String> implements SaTipofuenteDao {

    protected SsTipofuenteDaoImpl() {
        super(SaTipofuente.class);
    }
    @Override
    public SaTipofuente buscar(SaTipofuente objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SaTipofuente.class);
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, ORDER_ASC, objDao.getListaAtributoOrdenacion());
        return (SaTipofuente) criteria.uniqueResult();
    }

    @Override
    public List<SaTipofuente> listar(SaTipofuente objDao, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SaTipofuente.class);
        if (pagina){
            objDao.setPaginable(true);
            setPaginable(objDao, criteria);
        }
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SaTipofuente objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SaTipofuente.class);
        filtrarCritera(criteria, objDao);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SaTipofuente objDao) {
        save(objDao);
        return 1;
    }

    @Override
    public int actualizar(SaTipofuente objDao) {
        update(objDao);
        return 1;
    }

    @Override
    public int eliminar(SaTipofuente objDao) {
        delete(objDao);
        return 1;
    }

    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SaTipofuente){
            SaTipofuente  objDao = (SaTipofuente)objFiltro;
            if(UtilesCommons.noEsVacio(objDao.getEstado())){
                criteria.add(Restrictions.eq("estado",objDao.getEstado()));
            }


        }else {
        }
    }
}