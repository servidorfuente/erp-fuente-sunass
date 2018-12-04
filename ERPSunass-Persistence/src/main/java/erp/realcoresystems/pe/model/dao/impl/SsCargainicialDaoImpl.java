package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsCargainicialDao;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.SsCargainicialPK;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SsCargainicialDaoImpl extends AbstractDaoImpl<SsCargainicial, SsCargainicialPK> implements SsCargainicialDao {

    protected SsCargainicialDaoImpl() {
        super(SsCargainicial.class);
    }
    @Override
    public SsCargainicial buscar(SsCargainicial objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsCargainicial.class);
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, ORDER_ASC, objDao.getListaAtributoOrdenacion());
        return (SsCargainicial) criteria.uniqueResult();
    }

    @Override
    public List<SsCargainicial> listar(SsCargainicial objDao, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SsCargainicial.class);
        if (pagina){
            objDao.setPaginable(true);
            setPaginable(objDao, criteria);
        }
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SsCargainicial objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsCargainicial.class);
        filtrarCritera(criteria, objDao);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SsCargainicial objDao) {
        save(objDao);
        return 1;
    }

    @Override
    public int actualizar(SsCargainicial objDao) {
        update(objDao);
        return 1;
    }

    @Override
    public int eliminar(SsCargainicial objDao) {
        delete(objDao);
        return 1;
    }

    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SsCargainicial){
            SsCargainicial  objDao = (SsCargainicial)objFiltro;
            if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
                criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
            }
            if(UtilesCommons.noEsVacio(objDao.getAnno())){
                criteria.add(Restrictions.eq("anno",objDao.getAnno()));
            }
            if(UtilesCommons.noEsVacio(objDao.getSucursal())){
                criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
            }
            if(UtilesCommons.noEsVacio(objDao.getFuenteid())){
                criteria.add(Restrictions.eq("fuenteid",objDao.getFuenteid()));
            }

        }else {
        }
    }
}