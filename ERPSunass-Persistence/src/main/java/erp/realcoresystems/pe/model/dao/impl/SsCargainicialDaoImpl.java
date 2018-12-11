package erp.realcoresystems.pe.model.dao.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SsCargainicialDao;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.SsCargainicialPK;

import erp.realcoresystems.pe.model.domain.vista.VwCargainicial;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class SsCargainicialDaoImpl extends AbstractDaoImpl<SsCargainicial, String> implements SsCargainicialDao {

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
    public SsCargainicial verificar(SsCargainicial objDao) {
        Integer anno=0;
        anno=objDao.getAnno();
        SsCargainicial objOrinal = new SsCargainicial();
        objOrinal = objDao ;
        objDao.setAnno(anno-1);
        Criteria criteria = getCurrentSession().createCriteria(SsCargainicial.class);
        filtrarCritera(criteria, objDao);
        if (objDao.getFuenteid()==1){ // FUENTE DE AGUA
            criteria.setProjection(Projections.max("capacActualLps"));
            BigDecimal capacidadProduc = (BigDecimal) criteria.uniqueResult();
            criteria.setProjection(Projections.max("caudalcaptadodirectoLps"));
            BigDecimal caudalCaptacion = (BigDecimal) criteria.uniqueResult();
            if (capacidadProduc!=null)
              objOrinal.setValidFuente01Valor01(capacidadProduc);
            if (caudalCaptacion!=null)
               objOrinal.setValidFuente01Valor02(caudalCaptacion);
            objDao.setAnno(anno);
            objOrinal.setAnno(anno);
            return objOrinal;
        }
        if (objDao.getFuenteid()==2){


        }
        return null;
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
    public List<VwCargainicial> listarVista(VwCargainicial vista, SsCargainicial entidad, boolean pagina) {
        Criteria criteria = getCurrentSession().createCriteria(VwCargainicial.class);
        if (pagina){
            vista.setPaginable(true);
            setPaginable(vista, criteria);
        }
        filtrarCriteraVista(criteria, vista);
        setOrdenable(criteria, vista.getTipoOrdenacion(), vista.getListaAtributoOrdenacion());
       // List<VwCargainicial> valor = (List<VwCargainicial>) criteria.list();
        //int a=0;
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
    public int contarVista(VwCargainicial objDao) {
        Criteria criteria = getCurrentSession().createCriteria(VwCargainicial.class);
        filtrarCriteraVista(criteria, objDao);
        criteria.setProjection(Projections.rowCount());
        String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
        return Integer.parseInt(obj);
    }
    @Override
    public int guardar(SsCargainicial objDao) {
        Criteria criteria = getCurrentSession().createCriteria(SsCargainicial.class);
        ProjectionList proj = Projections.projectionList();
        proj.add(Projections.max("cargainicialid"));
        criteria.setProjection(proj);
        Object result = criteria.uniqueResult();
        Integer valorMax=0;
        if(result!=null){
            valorMax = Integer.parseInt(result.toString());
        }
        objDao.setCargainicialid(valorMax+1);
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
            if(UtilesCommons.noEsVacio(objDao.getFuenteid())){
                criteria.add(Restrictions.eq("fuenteid",objDao.getFuenteid()));
            }
            if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
                criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
            }
            if(UtilesCommons.noEsVacio(objDao.getSucursal())){
                criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
            }
            if(UtilesCommons.noEsVacio(objDao.getAnno())){
                criteria.add(Restrictions.eq("anno",objDao.getAnno()));
            }
            if(UtilesCommons.noEsVacio(objDao.getEstadodocumento())){
                criteria.add(Restrictions.eq("estadodocumento",objDao.getEstadodocumento()));
            }
            if(UtilesCommons.noEsVacio(objDao.getProyectoid())){
                criteria.add(Restrictions.eq("proyectoid",objDao.getProyectoid()));
            }

        }else {
        }
    }
    public void filtrarCriteraVista(Criteria criteria, Object objFiltro){
        if(objFiltro instanceof VwCargainicial){
            VwCargainicial  objDao = (VwCargainicial)objFiltro;
            if(UtilesCommons.noEsVacio(objDao.getFuenteid())){
                criteria.add(Restrictions.eq("fuenteid",objDao.getFuenteid()));
            }
            if(UtilesCommons.noEsVacio(objDao.getCompanyowner())){
                criteria.add(Restrictions.eq("companyowner",objDao.getCompanyowner()));
            }
            if(UtilesCommons.noEsVacio(objDao.getSucursal())){
                criteria.add(Restrictions.eq("sucursal",objDao.getSucursal()));
            }
            if(UtilesCommons.noEsVacio(objDao.getProyectoid())){
                criteria.add(Restrictions.eq("proyectoid",objDao.getProyectoid()));
            }
            if(UtilesCommons.noEsVacio(objDao.getAnno())){
                criteria.add(Restrictions.eq("anno",objDao.getAnno()));
            }
        }else {
        }
    }
}