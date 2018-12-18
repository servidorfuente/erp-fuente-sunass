package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsFormcom07ADao;
import erp.realcoresystems.pe.model.domain.SsFormcom07A;
import erp.realcoresystems.pe.model.domain.SsFormcom07APK;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SsFormcom07ADaoImpl extends AbstractDaoImpl<SsFormcom07A, SsFormcom07APK> implements SsFormcom07ADao {

    protected SsFormcom07ADaoImpl() { super(SsFormcom07A.class);}

    @Override
    public SsFormcom07A buscar(SsFormcom07A objSsFormcom07A) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom07A.class);
        filtrarCritera(criteria, objSsFormcom07A);
        setOrdenable(criteria, ORDER_ASC, objSsFormcom07A.getListaAtributoOrdenacion());
        return (SsFormcom07A) criteria.uniqueResult();
    }

    @Override
    public List<SsFormcom07A> listar(SsFormcom07A objSsFormcom07A, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom07A.class);
        if (pagina){
            objSsFormcom07A.setPaginable(true);
            setPaginable(objSsFormcom07A, criteria);
        }
        filtrarCritera(criteria, objSsFormcom07A);
        setOrdenable(criteria, objSsFormcom07A.getTipoOrdenacion(), objSsFormcom07A.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SsFormcom07A objSsFormcom07A) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom07A.class);
        filtrarCritera(criteria, objSsFormcom07A);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SsFormcom07A objSsFormcom07A) {
        Criteria criteria = getCurrentSession().createCriteria(SsFormcom07A.class);
        ProjectionList proj = Projections.projectionList();
        proj.add(Projections.max("secuencia"));
        criteria.setProjection(proj);
        Object result = criteria.uniqueResult();
        Integer valorMax=0;
        if(result!=null){
            valorMax = Integer.parseInt(result.toString());
        }
        objSsFormcom07A.setSecuencia(valorMax+1);
        save(objSsFormcom07A);
        return 1;
    }

    @Override
    public int actualizar(SsFormcom07A objSsFormcom07A) {
        update(objSsFormcom07A);
        return 1;
    }

    @Override
    public int eliminar(SsFormcom07A objSsFormcom07A) {
        delete(objSsFormcom07A);
        return 1;
    }

    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SsFormcom07A){
            SsFormcom07A  objDao = (SsFormcom07A)objFiltro;
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
