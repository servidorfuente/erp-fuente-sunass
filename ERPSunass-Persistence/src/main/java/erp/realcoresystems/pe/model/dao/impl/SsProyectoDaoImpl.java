package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsProyectoDao;
import erp.realcoresystems.pe.model.domain.SsProyecto;
import erp.realcoresystems.pe.model.domain.SsProyectoPK;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SsProyectoDaoImpl extends AbstractDaoImpl<SsProyecto, String> implements SsProyectoDao {

    protected SsProyectoDaoImpl() {
        super(SsProyecto.class);
    }
    @Override
    public SsProyecto buscar(SsProyecto objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsProyecto.class);
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, ORDER_ASC, objDao.getListaAtributoOrdenacion());
        return (SsProyecto) criteria.uniqueResult();
    }

    @Override
    public List<SsProyecto> listar(SsProyecto objDao, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(SsProyecto.class);
        if (pagina){
            objDao.setPaginable(true);
            setPaginable(objDao, criteria);
        }
        filtrarCritera(criteria, objDao);
        setOrdenable(criteria, objDao.getTipoOrdenacion(), objDao.getListaAtributoOrdenacion());
        return criteria.list();
    }

    @Override
    public int contar(SsProyecto objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsProyecto.class);
        filtrarCritera(criteria, objDao);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }

    @Override
    public int guardar(SsProyecto objDao) {
        save(objDao);
        return 1;
    }

    @Override
    public int actualizar(SsProyecto objDao) {
        update(objDao);
        return 1;
    }

    @Override
    public int eliminar(SsProyecto objDao) {
        delete(objDao);
        return 1;
    }

    public void filtrarCritera(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof SsProyecto){
            SsProyecto  objDao = (SsProyecto)objFiltro;
            if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
                criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
            }
            if(UtilesCommons.noEsVacio(objDao.getSucursal())){
                criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
            }


        }else {
        }
    }
}