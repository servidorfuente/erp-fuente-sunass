package erp.realcoresystems.pe.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SaTurnoDao;
import erp.realcoresystems.pe.model.domain.SaTurno;
import erp.realcoresystems.pe.model.domain.SaTurnoPK;

@Repository
public class SaTurnoDaoImpl extends AbstractDaoImpl<SaTurno, SaTurnoPK> implements SaTurnoDao {

	protected SaTurnoDaoImpl() {
		super(SaTurno.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SaTurno> listarTodos(SaTurno filtro) {
		Criteria cq = getCurrentSession().createCriteria(SaTurno.class);
		cq.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
		if(UtilesCommons.noEsVacio(filtro.getTurestado())){
			cq.add(Restrictions.eq("turestado", filtro.getTurestado()));
		}
		if(UtilesCommons.sonCadenasIguales("ORDER_BY_HORA_INICIO", filtro.getString10())) {
			setOrdenableAtrib(cq, ORDER_ASC, "turhorainicio");
		}
		return (List<SaTurno>) cq.list();
	}
	
	@Override
	public SaTurno obtenerTurno(SaTurno pk) {
		Criteria cq = getCurrentSession().createCriteria(SaTurno.class);
		cq.add(Restrictions.eq("uneunegocioid", pk.getUneunegocioid()));
		cq.add(Restrictions.eq("turturnoid", pk.getTurturnoid()));		
		return (SaTurno) cq.uniqueResult();	
	}
	
	@Override
	public int guardar(SaTurno filtro) {
		if (UtilesCommons.esVacio(filtro.getTurturnoid())) {
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.max("turturnoid"));
			Criteria criteria = getCurrentSession().createCriteria(SaTurno.class);
			criteria.setProjection(proj);
			Object result = criteria.uniqueResult();
			int valorMax = 0;
			if (result != null) {
				valorMax = Integer.parseInt(result.toString());
			}
			filtro.setTurturnoid(valorMax + 1);
			save(filtro);
		}else{
			actualizar(filtro);
		}
		return 1;
	}

	@Override
	public int eliminar(SaTurno filtro) {
		delete(filtro);
		return 1;
	}

	@Override
	public List<SaTurno> validate(SaTurno filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaTurno.class);

		if (filtro.getTurcodigo() != null) {
			criteria.add(Restrictions.eq("turcodigo", filtro.getTurcodigo()));
		}
		
		return (List<SaTurno>) criteria.list();
	}

	@Override
	public int actualizar(SaTurno filtro) {
		update(filtro);
		return 1;
	}

	@Override
	public int contador(SaTurno filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaTurno.class);
		criteria.setProjection(Projections.rowCount());

		if (filtro.getUneunegocioid() != null && filtro.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
		}
		if (filtro.getTurturnoid() != null) {
			criteria.add(Restrictions.eq("turturnoid", filtro.getTurturnoid()));
		}
		if (filtro.getTurcodigo() != null) {
			criteria.add(Restrictions.like("turcodigo", filtro.getTurcodigo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (filtro.getTurdescripcion() != null) {
			criteria.add(Restrictions.like("turdescripcion", filtro.getTurdescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (filtro.getTurestado()!= null  && filtro.getTurestado() != 0) {
			criteria.add(Restrictions.eq("turestado", filtro.getTurestado()));
		}

		return Integer.parseInt(criteria.uniqueResult().toString());

	}

	@Override
	public List<SaTurno> listar(SaTurno filtro) {
		Criteria criteria = getCurrentSession().createCriteria(SaTurno.class);
		criteria.setFirstResult(filtro.getInicio());
		criteria.setMaxResults(filtro.getNumeroFilas());
		criteria.setFetchSize(filtro.getNumeroFilas());
		if (filtro.getUneunegocioid() != null && filtro.getUneunegocioid() > 0) {
			criteria.add(Restrictions.eq("uneunegocioid", filtro.getUneunegocioid()));
		}
		if (filtro.getTurturnoid() != null) {
			criteria.add(Restrictions.eq("turturnoid", filtro.getTurturnoid()));
		}
		if (filtro.getTurcodigo() != null) {
			criteria.add(Restrictions.like("turcodigo", filtro.getTurcodigo(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (filtro.getTurdescripcion() != null) {
			criteria.add(Restrictions.like("turdescripcion", filtro.getTurdescripcion(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if (filtro.getTurestado()!= null  && filtro.getTurestado() != 0) {
			criteria.add(Restrictions.eq("turestado", filtro.getTurestado()));
		}
		return (List<SaTurno>) criteria.list();
	}

}
