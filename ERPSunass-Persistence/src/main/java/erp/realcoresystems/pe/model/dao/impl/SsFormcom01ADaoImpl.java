package erp.realcoresystems.pe.model.dao.impl;


import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsFormcom01ADao;

import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.model.domain.SsFormcom01APK;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsFormcom01ADaoImpl  extends AbstractDaoImpl<SsFormcom01A, SsFormcom01APK> implements SsFormcom01ADao {

    protected SsFormcom01ADaoImpl() {
            super(SsFormcom01A.class);
     }
    @Override
    public SsFormcom01A buscar(SsFormcom01A filtro) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom01A.class);
        filtrarCritera(criteria, filtro);
        setOrdenable(criteria, ORDER_ASC, filtro.getListaAtributoOrdenacion());
        return (SsFormcom01A) criteria.uniqueResult();
    }

    @Override
    public List<SsFormcom01A> listar(SsFormcom01A filtro, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom01A.class);
        if (pagina){
            filtro.setPaginable(true);
            setPaginable(filtro, criteria);
        }
        filtrarCritera(criteria, filtro);
        setOrdenable(criteria, filtro.getTipoOrdenacion(), filtro.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SsFormcom01A filtro) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom01A.class);
        filtrarCritera(criteria, filtro);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SsFormcom01A objDao) {
        save(objDao);
        return 1;
    }

    @Override
    public int actualizar(SsFormcom01A objDao) {
        update(objDao);
        return 1;
    }

    @Override
    public int eliminar(SsFormcom01A objDao) {
        delete(objDao);
        return 1;
    }
    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SsFormcom01A){
            SsFormcom01A  objDao = (SsFormcom01A)objFiltro;
            if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
                criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
            }
            if(UtilesCommons.noEsVacio(objDao.getPeriodo())){
                criteria.add(Restrictions.eq("periodo",objDao.getPeriodo()));
            }
            if(UtilesCommons.noEsVacio(objDao.getTipofrecuencia())){
                criteria.add(Restrictions.eq("tipofrecuencia",objDao.getTipofrecuencia()));
            }
        }else {
        }
    }
}
