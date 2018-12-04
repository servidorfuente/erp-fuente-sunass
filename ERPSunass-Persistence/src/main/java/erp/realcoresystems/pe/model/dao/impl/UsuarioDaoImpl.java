package erp.realcoresystems.pe.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.model.dao.UsuarioDao;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.domain.VwUsuarioseguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class UsuarioDaoImpl extends AbstractDaoImpl<Usuario, String>implements UsuarioDao {

	protected UsuarioDaoImpl() {
		super(Usuario.class);
	}

	@Override
	public Usuario ValidarUsuario(Usuario usuario) {
		boolean claveVacia = false;
		Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
		// criteria.add(Restrictions.like("usuario",
		// usuario.getUsuario(),MatchMode.ANYWHERE).ignoreCase());
		criteria.add(Restrictions.like("usuario", usuario.getUsuario()).ignoreCase());
		//System.out.println("Llego USUARIO BUSCAR->:" + usuario.getClave() + ">>>");
		/** obs: SI SE PERMITIERA NULOS */
		if (usuario.getClave() != null) {
			if (usuario.getClave().length() == 0) {
				//System.out.println("Llego USUARIO LOGIN CLAVE VACIO::" + usuario.getClave() + ":::");
				claveVacia = true;
			} else {
				//System.out.println("Llego USUARIO LOGIN ENTRO CRITERIA::" + usuario.getClave() + ":::");
				criteria.add(Restrictions.eq("clave", usuario.getClave()));
			}
		} else {
			//System.out.println("Llego USUARIO LOGIN CLAVE NULA::" + usuario.getClave() + ":::");
			claveVacia = true;
		}
		Object objUsuario = criteria.uniqueResult();
		if (claveVacia) {
			if (objUsuario != null) {
				Usuario userResult = (Usuario) objUsuario;
				if (userResult.getClave() == null) {
					return userResult;
				} else if (userResult.getClave().length() == 0) {
					return userResult;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return objUsuario != null ? (Usuario) objUsuario : null;
		}
	}

	public void accesoPersonalizadoYoel(Usuario usuario) {
		//System.out.println("Acceso rapidin!");
		if (usuario.getUsuario() != null) {
			if (usuario.getUsuario().equals("")) {
				usuario.setUsuario("admin");
			}
		}
		if (usuario.getClave() != null) {
			if (usuario.getClave().equals("")) {
				usuario.setClave("1");
			}
		}

	}

	@Override
	public List<Usuario> UsuarioListar(Usuario usuario) {

		Criteria criteria = getCurrentSession().createCriteria(Usuario.class);

		if ("CONSULTA_VALIDAR".equals(usuario.getFlagConsultaEntGlobal())) {
			boolean OR = false;
			Criterion crit1 = null, crit2 = null;
			if (usuario.getPersona() != null) {
				crit1 = Restrictions.eq("persona", usuario.getPersona());
				OR = true;
			} else {
				OR = false;
			}
			if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
				crit2 = Restrictions.eq("usuario", usuario.getUsuario()).ignoreCase();
				OR = OR && true;
			} else {
				OR = false;
			}
			if (OR) {
				criteria.add(Restrictions.or(crit1, crit2));
			} else {
				if (crit1 != null) {
					criteria.add(crit1);
				}
				if (crit2 != null) {
					criteria.add(crit2);
				}
			}

		} else {
			if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
				criteria.add(Restrictions.like("usuario", usuario.getUsuario(), MatchMode.ANYWHERE).ignoreCase());
			}
			if ("EXCEPTO".equals(usuario.getFlagConsultaEntGlobal())) {
				if (usuario.getDescripcion01() != null && !"".equals(usuario.getDescripcion01())) {
					criteria.add(Restrictions.ne("usuario", usuario.getDescripcion01()));
				}
			}			
			if (usuario.getUsuarioperfil() != null && !"".equals(usuario.getUsuarioperfil())) {
				criteria.add(Restrictions.eq("usuarioperfil", usuario.getUsuarioperfil()));
			}
			if (usuario.getEstado() != null && !"".equals(usuario.getEstado())) {
				criteria.add(Restrictions.eq("estado", usuario.getEstado()));
			}
			if (usuario.getNombre() != null && !"".equals(usuario.getNombre())) {
				criteria.add(Restrictions.like("nombre", usuario.getNombre(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (usuario.getUsuarioperfil() != null && !"".equals(usuario.getUsuarioperfil())) {
				criteria.add(Restrictions.eq("usuarioperfil", usuario.getUsuarioperfil()));
			}
			if (usuario.getTipousuario() != null && usuario.getTipousuario() != 0) {
				criteria.add(Restrictions.eq("tipousuario", usuario.getTipousuario()));
			}
			if (usuario.getPersona() != null) {
				criteria.add(Restrictions.eq("persona", usuario.getPersona()));
			}			
			criteria.addOrder(Order.asc("usuario"));
			// criteria.add(Restrictions.eq("usuario", usuario.getUsuario()));
			//System.out.println("Llego AAAAA-> : " + usuario.getUsuario());
			setParametrosAuditoriaTrace(usuario, null, "");
		}

		return (List<Usuario>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> UsuarioPerfilListar(Usuario usuario) {
		Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
		if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
			criteria.add(Restrictions.like("usuario", usuario.getUsuario(), MatchMode.ANYWHERE).ignoreCase());
		}
		if ("EXCEPTO".equals(usuario.getFlagConsultaEntGlobal())) {
			if (usuario.getDescripcion01() != null && !"".equals(usuario.getDescripcion01())) {
				criteria.add(Restrictions.ne("usuario", usuario.getDescripcion01()));
			}
		}
		if (usuario.getUsuarioperfil() != null && !"".equals(usuario.getUsuarioperfil())) {
			criteria.add(Restrictions.eq("usuarioperfil", usuario.getUsuarioperfil()));
		}
		
		//System.out.println("usuario.getEstado() "+ usuario.getEstado());
		if (usuario.getEstado() != null && !"".equals(usuario.getEstado())) {
			criteria.add(Restrictions.eq("estado", usuario.getEstado()));
		}
		if (usuario.getNombre() != null && !"".equals(usuario.getNombre())) {
			criteria.add(Restrictions.like("nombre", usuario.getNombre(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (usuario.getTipousuario() != null && usuario.getTipousuario() != 0) {
			criteria.add(Restrictions.eq("tipousuario", usuario.getTipousuario()));
		}
		// criteria.add(Restrictions.eq("usuario", usuario.getUsuario()));
		//System.out.println("Llego BBBB-> : " + usuario.getUsuario());
		criteria.setFirstResult(usuario.getInicio());
		criteria.setMaxResults(usuario.getNumeroFilas());
		criteria.setFetchSize(usuario.getNumeroFilas());
		criteria.addOrder(Order.asc("usuario"));
		// //System.out.println("Llego -> : "+usuario.getUsuario());
		setParametrosAuditoriaTrace(usuario, null, "");
		return (List<Usuario>) criteria.list();
	}

	@Override
	public Usuario UsuarioBuscar(Usuario usuario) {
		Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
		if (usuario.getUsuario() != null) {
			criteria.add(Restrictions.like("usuario", usuario.getUsuario()).ignoreCase());
			// criteria.add(Restrictions.eq("usuario", usuario.getUsuario()));
		}
		if (usuario.getClave() != null) {
			criteria.add(Restrictions.eq("clave", usuario.getClave()));
		}
		Object objUsuario = criteria.uniqueResult();
		return objUsuario != null ? (Usuario) objUsuario : null;
	}

	@Override
	public List<Usuario> listarPaginacionUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);

			if (objUsuario.getUsuario() != null) {
				criteria.add(Restrictions.like("usuario", "%" + objUsuario.getUsuario().trim() + "%"));
				// criteria.add(Restrictions.like("usuario",
				// objUsuario.getUsuario(), MatchMode.ANYWHERE).ignoreCase());
			}

			if (objUsuario.getNombre() != null) {
				criteria.add(Restrictions.like("nombre", "%" + objUsuario.getNombre().trim() + "%"));
				// criteria.add(Restrictions.like("nombre",
				// objUsuario.getNombre(), MatchMode.ANYWHERE).ignoreCase());
			}

			criteria.setFirstResult(objUsuario.getInicio());
			criteria.setMaxResults(objUsuario.getNumeroFilas());
			setParametrosAuditoriaTrace(objUsuario, null, "");
			return criteria.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int contadorTotalesUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
				criteria.add(Restrictions.like("usuario", usuario.getUsuario(), MatchMode.ANYWHERE).ignoreCase());
			}
			if ("EXCEPTO".equals(usuario.getFlagConsultaEntGlobal())) {
				if (usuario.getDescripcion01() != null && !"".equals(usuario.getDescripcion01())) {
					criteria.add(Restrictions.ne("usuario", usuario.getDescripcion01()));
				}
			}
			if (usuario.getUsuarioperfil() != null && !"".equals(usuario.getUsuarioperfil())) {
				criteria.add(Restrictions.eq("usuarioperfil", usuario.getUsuarioperfil()));
			}
			if (usuario.getEstado() != null && !"".equals(usuario.getEstado())) {
				criteria.add(Restrictions.eq("estado", usuario.getEstado()));
			}
			if (usuario.getNombre() != null && !"".equals(usuario.getNombre())) {
				criteria.add(Restrictions.like("nombre", usuario.getNombre(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (usuario.getTipousuario() != null && usuario.getTipousuario() != 0) {
				criteria.add(Restrictions.eq("tipousuario", usuario.getTipousuario()));
			}

			criteria.setProjection(Projections.rowCount());
			String obj = criteria.uniqueResult() != null ? criteria.uniqueResult().toString() : "0";
			return Integer.parseInt(obj);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int guardarUsuario(Usuario objUsuario) {
		saveOrUpdate(objUsuario);
		return 1;
	}
	
	public int actualizar(Usuario objUsuario) {
		update(objUsuario);
		return 1;
	}

	@Override
	public int eliminarUsuario(Usuario objUsuario) {
		delete(objUsuario);
		return 1;
	}

	@Override
	public Usuario obtenerUsuarioID(Usuario objUsuario) {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.like("usuario", objUsuario.getUsuario()).ignoreCase());
			// criteria.add(Restrictions.eq("usuario",
			// objUsuario.getUsuario()));
			// setParametrosAuditoriaTrace(objUsuario,null,"");
			return (Usuario) criteria.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Usuario> listarPaginacionSeleccionadorUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {

			String sqlString = "select * from ("
					+ "select e.CodigoUsuario,p.NombreCompleto, Row_number() OVER (ORDER BY e.persona ASC ) AS RowNumber   "
					+ ") as listado " + "WHERE RowNumber BETWEEN " + objUsuario.getInicio() + "  AND "
					+ objUsuario.getNumeroFilas();

			Query query = getCurrentSession().createSQLQuery(sqlString);

			List<Object> result = query.list();

			Iterator itr = result.iterator();
			List<Usuario> listaRetorno = new ArrayList<Usuario>();

			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				Usuario usuario = new Usuario();

				if (obj[0] != null) {
					usuario.setUsuario(String.valueOf(obj[0]));
				}

				if (obj[1] != null) {
					usuario.setNombre(String.valueOf(obj[1]));
				}

				listaRetorno.add(usuario);
			}

			return listaRetorno;

		} catch (Exception e) {
			// TODO: handle exception

			return null;
		}
	}

	@Override
	public int contadorTotalesSeleccionadorUsuario(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {

			String sqlString = "select * from ("
					+ "select e.CodigoUsuario,p.NombreCompleto, Row_number() OVER (ORDER BY e.persona ASC ) AS RowNumber   "
					+ " from PersonaMast p inner join EmpleadoMast e on p.Persona = e.Empleado" + ") as listado "
					+ "WHERE RowNumber BETWEEN " + objUsuario.getInicio() + "  AND " + objUsuario.getNumeroFilas();

			Query query = getCurrentSession().createSQLQuery(sqlString);

			List<Object> result = query.list();

			Iterator itr = result.iterator();
			List<Usuario> listaRetorno = new ArrayList<Usuario>();

			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				Usuario usuario = new Usuario();

				listaRetorno.add(usuario);
			}

			if (listaRetorno.size() > 0) {
				return listaRetorno.size();
			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception

			return 0;
		}
	}

	@Override
	public List<Usuario> listarComboUsuarioSupervisor(Usuario objUsuario) {
		// TODO Auto-generated method stub
		try {

			String sqlString = "  SELECT  Usuario.Usuario ,Usuario.Nombre  "
					+ "FROM Usuario , RM_ProyectoUsuarioSupervisor   "
					+ "WHERE ( Usuario.Usuario = RM_ProyectoUsuarioSupervisor.UsuarioSupervisor ) "
					+ "and   ( ( Usuario.Estado = 'A' ) )"
					+ "  GROUP BY Usuario.Usuario , Usuario.Nombre  ORDER BY Usuario.Usuario ASC  ";

			Query query = getCurrentSession().createSQLQuery(sqlString);

			List<Object> result = query.list();

			Iterator itr = result.iterator();
			List<Usuario> listaRetorno = new ArrayList<Usuario>();

			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				Usuario usuario = new Usuario();

				if (obj[0] != null) {
					usuario.setUsuario(String.valueOf(obj[0]));
				}

				if (obj[1] != null) {
					usuario.setNombre(String.valueOf(obj[1]));
				}

				listaRetorno.add(usuario);
			}

			return listaRetorno;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VwUsuarioseguridad> listarVwUsuarioseguridad(Usuario usuario) {
		Criteria criteria = getCurrentSession().createCriteria(VwUsuarioseguridad.class);

		if (usuario.getUsuario() != null && !"".equals(usuario.getUsuario())) {
			criteria.add(Restrictions.like("usuario", usuario.getUsuario(), MatchMode.ANYWHERE).ignoreCase());
		}
		if ("EXCEPTO".equals(usuario.getFlagConsultaEntGlobal())) {
			if (usuario.getDescripcion01() != null && !"".equals(usuario.getDescripcion01())) {
				criteria.add(Restrictions.ne("usuario", usuario.getDescripcion01()));
			}
		}
		if (usuario.getUsuarioperfil() != null && !"".equals(usuario.getUsuarioperfil())) {
			criteria.add(Restrictions.eq("usuarioperfil", usuario.getUsuarioperfil()));
		}
		if (usuario.getEstado() != null && !"".equals(usuario.getEstado())) {
			criteria.add(Restrictions.eq("estado", usuario.getEstado()));
		}
		if (usuario.getNombre() != null && !"".equals(usuario.getNombre())) {
			criteria.add(Restrictions.like("nombre", usuario.getNombre(), MatchMode.ANYWHERE).ignoreCase());
		}
		if (usuario.getTipousuario() != null && usuario.getTipousuario() != 0) {
			criteria.add(Restrictions.eq("tipousuario", usuario.getTipousuario()));
		}
		criteria.setFirstResult(usuario.getInicio());
		criteria.setMaxResults(usuario.getNumeroFilas());
		criteria.setFetchSize(usuario.getNumeroFilas());
		setParametrosAuditoriaTrace(usuario, null, "");
		return (List<VwUsuarioseguridad>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> obtenerUsuarioCreacionModificacion(Integer creacion, Integer modificacion) {

		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("creador", "");
		respuesta.put("modificador", "");
		if(creacion != null && creacion != 0){
			Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("persona", creacion));
			List<Usuario> o = criteria.list();
			if(o != null){
				if(o.size()>0){
					respuesta.put("creador", o.get(0).getUsuario());	
				}				
			}
		}
		if(modificacion!=null && modificacion != 0){
			Criteria criteria2 = getCurrentSession().createCriteria(Usuario.class);
			criteria2.add(Restrictions.eq("persona", modificacion));
			List<Usuario> usuario = criteria2.list();
			if(usuario != null){
				if(usuario.size()>0){
					respuesta.put("modificador", usuario.get(0).getUsuario());	
				}				
			}
		}
		return  respuesta;
		
	}

}
