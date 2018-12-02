package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadGrupoDao;
import erp.realcoresystems.pe.model.dao.SeguridadPerfilUsuarioDao;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;
import erp.realcoresystems.pe.model.domain.Seguridadperfilusuario;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.util.Utiles;

import java.util.List;

/**
 * Created by mamania on 22/12/2015.
 */
@Repository
public class SeguridadPerfilUsuarioDaoImpl extends AbstractDaoImpl<Seguridadperfilusuario, String>
		implements SeguridadPerfilUsuarioDao {
	protected SeguridadPerfilUsuarioDaoImpl() {
		super(Seguridadperfilusuario.class);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public List<Seguridadperfilusuario> SeguridadperfilusuarioListar(Seguridadperfilusuario seguridadperfilusuario) {
		Criteria criteria = getCurrentSession().createCriteria(Seguridadperfilusuario.class);

		if (UtilesCommons.noEsVacio(seguridadperfilusuario.getEstado())) {
			 	criteria.add(Restrictions.eq("estado",seguridadperfilusuario.getEstado()));
		 }
		 if (UtilesCommons.noEsVacio(seguridadperfilusuario.getUsuario())) {
			criteria.add(Restrictions.eq("usuario", seguridadperfilusuario.getUsuario()));
		}
		if (UtilesCommons.noEsVacio(seguridadperfilusuario.getPerfil())) {
			criteria.add(Restrictions.eq("perfil", seguridadperfilusuario.getPerfil()));
		}
		// criteria.setFirstResult(seguridadperfilusuario.getInicio());
		// criteria.setMaxResults(seguridadperfilusuario.getNumeroFilas());

		return (List<Seguridadperfilusuario>) criteria.list();
	}

	@Override
	public Seguridadperfilusuario SeguridadGrupoBuscar(Seguridadperfilusuario objPersonaMast) {
		return null;
	}

	@Override
	public void guardar(Seguridadperfilusuario seguridadperfilusuario) {

		saveOrUpdate(seguridadperfilusuario);

	}

	public void eliminar(Seguridadperfilusuario seguridadperfilusuario) {
		delete(seguridadperfilusuario);
	}

	@Override
	public void actualizar(Seguridadperfilusuario seguridadperfilusuario) {

		update(seguridadperfilusuario);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Seguridadperfilusuario> obtenerTodosPerfiles(Seguridadperfilusuario perfilUsuario){
		Criteria criteria = getCurrentSession().createCriteria(Seguridadperfilusuario.class);
		if(perfilUsuario.getEstado() != null && !"".equals(perfilUsuario.getEstado())) {
			criteria.add(Restrictions.eq("estado",perfilUsuario.getEstado()));
		}
		if(perfilUsuario.getUsuario() != null && !"".equals(perfilUsuario.getUsuario())) {
			criteria.add(Restrictions.eq("usuario", perfilUsuario.getUsuario()));
		}
		if(perfilUsuario.getPerfil() != null && !"".equals(perfilUsuario.getPerfil())){
			criteria.add(Restrictions.eq("perfil", perfilUsuario.getPerfil()));
		}
		return (List<Seguridadperfilusuario>) criteria.list();
	}
}
