package erp.realcoresystems.pe.model.dao.impl;


import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsFormcal11CDao;
import erp.realcoresystems.pe.model.dao.SsFormcal11CDao;
import erp.realcoresystems.pe.model.domain.SsFormcal11C;
import erp.realcoresystems.pe.model.domain.SsFormcal11CPK;
import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsFormcal11CDaoImpl extends AbstractDaoImpl<SsFormcal11C, SsFormcal11CPK> implements SsFormcal11CDao {

    protected SsFormcal11CDaoImpl() {
            super(SsFormcal11C.class);
     }
    @Override
    public SsFormcal11C buscar(SsFormcal11C filtro) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcal11C.class);
        filtrarCritera(criteria, filtro);
        setOrdenable(criteria, ORDER_ASC, filtro.getListaAtributoOrdenacion());
        return (SsFormcal11C) criteria.uniqueResult();
    }

    @Override
    public List<SsFormcal11C> listar(SsFormcal11C filtro, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcal11C.class);
        if (pagina){
            filtro.setPaginable(true);
            setPaginable(filtro, criteria);
        }
        filtrarCritera(criteria, filtro);
        setOrdenable(criteria, filtro.getTipoOrdenacion(), filtro.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SsFormcal11C filtro) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcal11C.class);
        filtrarCritera(criteria, filtro);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SsFormcal11C objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcal11C.class);
        ProjectionList proj = Projections.projectionList();
        proj.add(Projections.max("secuencia"));
        criteria.setProjection(proj);
        Object result = criteria.uniqueResult();
        Integer valorMax=0;
        if(result!=null){
            valorMax = Integer.parseInt(result.toString());
        }
        objDao.setSecuencia(valorMax+1);
        save(objDao);
        return 1;

    }

    @Override
    public int actualizar(SsFormcal11C objDao) {
        update(objDao);
        return 1;
    }

    @Override
    public int eliminar(SsFormcal11C objDao) {
        delete(objDao);
        return 1;
    }
    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SsFormcal11C){
            SsFormcal11C  objDao = (SsFormcal11C)objFiltro;
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
