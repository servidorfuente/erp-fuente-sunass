package erp.realcoresystems.pe.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.PersonamastDao;
import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;

@Repository
public class PersonamastDaoImpl extends AbstractDaoImpl<Personamast, Integer>implements PersonamastDao {

	protected PersonamastDaoImpl() {
		super(Personamast.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personamast> PersonamastListar(Personamast personamast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);

		if (personamast.isEscliente()) {
			criteria.add(Restrictions.eq("escliente", personamast.isEscliente()));
		}
		if (personamast.isEsempleado()) {
			criteria.add(Restrictions.eq("esempleado", personamast.isEsempleado()));
		}
		if (personamast.isEsproveedor()) {
			criteria.add(Restrictions.eq("esproveedor", personamast.isEsproveedor()));
		}
		if (personamast.isEscontacto()) {
			criteria.add(Restrictions.eq("escontacto", personamast.isEscontacto()));
		}
		 
		if("MULTI_PERSONA".equals(personamast.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if (personamast.getNombrecompleto() != null && !personamast.getNombrecompleto().isEmpty()) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}			
			if (personamast.getEstado() != null && !personamast.getEstado().isEmpty()) {
				criteria.add(Restrictions.eq("estado", personamast.getEstado()));
			}			
			if(personamast.getDescripcion01()!=null){
				String[] vector =    personamast.getDescripcion01().split("/");
				//System.out.println("TEST PERSONA::"+vector.length);
				if(vector.length>0){
					try{
						Integer[] ids = new Integer[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								ids[i] = Integer.parseInt(vector[i]);
								//System.out.println("TEST TABLAS:PERSIS:IDXXXXXXXX:"+ids[i]);
							}
						}	
						criteria.add(Restrictions.in("persona", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}				
			}	
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("persona",null));
			}
		}else{
			if (personamast.getNombrecompleto() != null && !personamast.getNombrecompleto().isEmpty()) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}
			if (personamast.getDocumento() != null) {
				criteria.add(Restrictions.like("documento", personamast.getDocumento(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (personamast.getEstado() != null && !personamast.getEstado().isEmpty()) {
				//System.out.println("String persona"+ personamast.getEstado());
				criteria.add(Restrictions.eq("estado", personamast.getEstado()));
			}
			if (personamast.getIngresousuario() != null) {
				criteria.add(Restrictions.eq("ingresousuario", personamast.getIngresousuario()).ignoreCase());
			}
			if (personamast.isEsproveedor()) {
				criteria.add(Restrictions.eq("esproveedor", personamast.isEsproveedor()));
			}	
			if(personamast.getTipopersona() != null && !"".equals(personamast.getTipopersona())){
				criteria.add(Restrictions.eq("tipopersona", personamast.getTipopersona()));
			}
			if(personamast.isEsempleado()){
				criteria.add(Restrictions.eq("esempleado", personamast.isEsempleado()));
			}
			if (personamast.getFlagConsultaEntGlobal() != null && personamast.getFlagConsultaEntGlobal().equalsIgnoreCase("CONSULTA_ESPECIAL_SIN_PERSONA_CLASIFICACION")){
				criteria.add(Restrictions.isNull("personaclasificacion"));
			}
		}

		criteria.addOrder(Property.forName("apellidopaterno").asc());
		criteria.addOrder(Property.forName("nombres").asc());
		criteria.setFirstResult(personamast.getInicio());
		criteria.setMaxResults(personamast.getNumeroFilas());
		criteria.setFetchSize(personamast.getNumeroFilas());
		List<Personamast> objLista = new ArrayList<>();
		objLista =  (List<Personamast>) criteria.list();
		int a= 0;
		return objLista;
	}

	@Override
	public Personamast PersonaContacto(Personamast personamast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);
		if (personamast.getNombrecompleto() != null)
			criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
					.ignoreCase());
		return (Personamast) criteria.uniqueResult();
	}

	@Override
	public int contadorTotalesPersona(Personamast personamast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);

		criteria.setProjection(Projections.rowCount());

		/*
		 * if (personamast.isEscliente()){
		 * criteria.add(Restrictions.eq("escliente",
		 * personamast.isEscliente())); } if (personamast.isEsempleado()){
		 * criteria.add(Restrictions.eq("esempleado",
		 * personamast.isEsempleado())); } if (personamast.isEsproveedor()){
		 * criteria.add(Restrictions.eq("esproveedor",
		 * personamast.isEsproveedor())); } if (personamast.isEscontacto()){
		 * criteria.add(Restrictions.eq("escontacto",
		 * personamast.isEscontacto())); }
		 */
		if("MULTI_PERSONA".equals(personamast.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if (personamast.getNombrecompleto() != null && !personamast.getNombrecompleto().isEmpty()) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}			
			if (personamast.getEstado() != null && !personamast.getEstado().isEmpty()) {
				criteria.add(Restrictions.eq("estado", personamast.getEstado()));
			}							
			if(personamast.getDescripcion01()!=null){
				String[] vector =    personamast.getDescripcion01().split("/");
				//System.out.println("TEST PERSONA::"+vector.length);
				if(vector.length>0){
					try{
						Integer[] ids = new Integer[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								ids[i] = Integer.parseInt(vector[i]);
								//System.out.println("TEST TABLAS:PERSIS:IDXXXXXXXX:"+ids[i]);
							}
						}	
						criteria.add(Restrictions.in("persona", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}	
				
			}	
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("persona",null));
			}
		}else{
			if (personamast.getNombrecompleto() != null) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}
			if (personamast.getDocumento() != null) {
				criteria.add(Restrictions.like("documento", personamast.getDocumento(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (personamast.getEstado() != null && !personamast.getEstado().isEmpty()) {
				criteria.add(Restrictions.eq("estado", personamast.getEstado()).ignoreCase());
			}
			if (personamast.getIngresousuario() != null) {
				criteria.add(Restrictions.eq("ingresousuario", personamast.getIngresousuario()).ignoreCase());
			}
			if (personamast.isEsproveedor()) {
				criteria.add(Restrictions.eq("esproveedor", personamast.isEsproveedor()));
			}	
			if(personamast.getTipopersona() != null && !"".equals(personamast.getTipopersona())){
				criteria.add(Restrictions.eq("tipopersona", personamast.getTipopersona()));
			}
			if(personamast.isEsempleado()){
				criteria.add(Restrictions.eq("esempleado", personamast.isEsempleado()));
			}
			if (personamast.getFlagConsultaEntGlobal() != null &&  personamast.getFlagConsultaEntGlobal().equalsIgnoreCase("CONSULTA_ESPECIAL_SIN_PERSONA_CLASIFICACION")){
				criteria.add(Restrictions.isNull("personaclasificacion"));
			}
		}

		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public int guardar(Personamast objPersonaMast) {
		if(objPersonaMast.getPersona()==null){
			Criteria criteria = getCurrentSession().createCriteria(Personamast.class).setProjection(Projections.max("persona"));
			Object o = criteria.uniqueResult();
			int id = o == null ? 1 : 1 + (int) o;
			objPersonaMast.setPersona(id);
		}
		saveOrUpdate(objPersonaMast);
		return objPersonaMast.getPersona();
	}
	
	@Override
	public int guardarPersona(Personamast objPersonaMast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class).setProjection(Projections.max("persona"));
		Object o = criteria.uniqueResult();
		int id = o == null ? 1 : 1 + (int) o;
		objPersonaMast.setPersona(id);
		save(objPersonaMast);
		return objPersonaMast.getPersona();
	}

	@Override
	public int actualizarPersona(Personamast objPersonaMast) {
		update(objPersonaMast);
		return objPersonaMast.getPersona();
	}
	
	@Override
	public int forzarActualizar(Personamast personamast){
		merge(personamast);
		return 1;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Personamast> obtenerPorDocumento(int tipo, String documento) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);
		if (tipo != 0) {
			criteria.add(Restrictions.eq("tipodocumento", tipo));
		}
		criteria.add(Restrictions.like("documento", documento).ignoreCase());
		return (List<Personamast>) criteria.list();
	}

	@Override
	public Personamast obtenerPorId(int personaId) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);
		criteria.add(Restrictions.eq("persona", personaId));
		return (criteria.uniqueResult() != null ? (Personamast) criteria.uniqueResult() : null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personamast> listarElementos(Personamast personamast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);
		/*
		 * if (personamast.isEscontacto()){
		 * criteria.add(Restrictions.eq("escontacto",
		 * personamast.isEscontacto())); } if (personamast.isEsempleado()){
		 * criteria.add(Restrictions.eq("esempleado",
		 * personamast.isEsempleado())); }
		 */
		if("MULTI_PERSONA".equals(personamast.getFlagConsultaEntGlobal())){
			boolean filtrosHallados=false;
			if (personamast.getNombrecompleto() != null && !personamast.getNombrecompleto().isEmpty()) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}								
			if (personamast.getEstado() != null && !"".equals(personamast.getEstado())) {
				criteria.add(Restrictions.eq("estado", personamast.getEstado()).ignoreCase());
			}			
			if(personamast.getDescripcion01()!=null){
				//System.out.println("[INFO DAO MULTI SHOW XXX:]"+personamast.getDescripcion01());
				String[] vector =    personamast.getDescripcion01().split("/");
				//System.out.println("[INFO DAO MULTI XXX:]"+vector.length);
				if(vector.length>0){
					try{
						Integer[] ids = new Integer[vector.length]; 
						for(int i=0;i< vector.length;i++){					
							if(vector[i].length()>0){
								if(!(vector[i]).toUpperCase().equals("NULL")){
									ids[i] = Integer.parseInt(vector[i]);	
								}																
							}
						}	
						criteria.add(Restrictions.in("persona", ids));
						filtrosHallados=true;
					}catch(Exception ex){
						ex.printStackTrace();
					}										
				}		
				
			}	
			if(!filtrosHallados){
				criteria.add(Restrictions.eq("persona",null));
			}
		}else{
			if (personamast.getNombrecompleto() != null && !"".equals(personamast.getNombrecompleto())) {
				criteria.add(Restrictions.like("nombrecompleto", personamast.getNombrecompleto(), MatchMode.ANYWHERE)
						.ignoreCase());
			}
			if (personamast.getDocumento() != null && !"".equals(personamast.getDocumento())) {
				criteria.add(Restrictions.eq("documento", personamast.getDocumento()));
			}
			if (personamast.getEstado() != null && !personamast.getEstado().isEmpty()) {
				criteria.add(Restrictions.eq("estado", personamast.getEstado()).ignoreCase());
			}
			if (personamast.getCorreoinstitucional() != null && !personamast.getCorreoinstitucional().isEmpty()) {
				criteria.add(Restrictions.eq("correoinstitucional", personamast.getCorreoinstitucional()).ignoreCase());
			}
			if(personamast.getTipopersona() != null && !"".equals(personamast.getTipopersona())){
				criteria.add(Restrictions.eq("tipopersona", personamast.getTipopersona()));
			}
			if (personamast.getListaInteger() != null && !personamast.getListaInteger().isEmpty()) {
				criteria.add(Restrictions.in("persona", personamast.getListaInteger()));
			}
			if (personamast.getPersona() !=null  ) {
				criteria.add(Restrictions.eq("persona", personamast.getPersona()));
			}
		}
		List<Personamast> obj= new ArrayList<>();
		obj = (List<Personamast>) criteria.list();
		int ab=0;
		return (List<Personamast>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Personamast> validate(Personamast objPersonaMast) {
		Criteria criteria = getCurrentSession().createCriteria(Personamast.class);
		if (objPersonaMast.getDocumento()!=null && UtilesCommons.noEsVacio(objPersonaMast.getDocumento())){
			criteria.add(Restrictions.eq("documento",objPersonaMast.getDocumento()));
		}
		return (List<Personamast>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VwPersonaGeneral> listar(VwPersonaGeneral filtro, boolean paginable) {
		Criteria criteria = createCriteria(VwPersonaGeneral.class); 
		filtrarEntidad(filtro, criteria);
		if (paginable) {
			criteria.setFirstResult(filtro.getInicio());
			criteria.setMaxResults(filtro.getNumeroFilas());
			criteria.setFetchSize(filtro.getNumeroFilas());
		}
		return (List<VwPersonaGeneral>)criteria.list();
	}
	 
	@Override
	public int contar(VwPersonaGeneral filtro) {
		Criteria criteria = createCriteria(VwPersonaGeneral.class); 
		filtrarEntidad(filtro, criteria);		
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		return UtilesCommons.esNulo(result) ? 0 : Integer.parseInt(result.toString());		 
	}

	public <V extends Entidad> void filtrarEntidad(V entidad, Criteria criteria){
		if(UtilesCommons.esInstancia(entidad, VwPersonaGeneral.class)) {
			VwPersonaGeneral filtro = (VwPersonaGeneral) entidad;
			if (UtilesCommons.noEsVacio(filtro.getNombrecompleto())) {
				criteria.add(Restrictions.like("nombrecompleto", filtro.getNombrecompleto(), MatchMode.ANYWHERE).ignoreCase());
			}
			if (UtilesCommons.noEsVacio(filtro.getDocumento())) {
				criteria.add(Restrictions.eq("documento", filtro.getDocumento()));
			}
			if (UtilesCommons.noEsVacio(filtro.getEstado())) {
				criteria.add(Restrictions.eq("estado", filtro.getEstado()).ignoreCase());
			}
			if (UtilesCommons.noEsVacio(filtro.getCorreoinstitucional())) {
				criteria.add(Restrictions.eq("correoinstitucional", filtro.getCorreoinstitucional()).ignoreCase());
			}
			if(UtilesCommons.noEsVacio(filtro.getTipopersona())){
				criteria.add(Restrictions.eq("tipopersona", filtro.getTipopersona()));
			}
			if (UtilesCommons.noEsVacio(filtro.getPersona())) {
				criteria.add(Restrictions.eq("persona", filtro.getPersona()));
			}
			if(UtilesCommons.noEsVacio(filtro.getEscliente())) {
				criteria.add(Restrictions.eq("escliente", filtro.getEscliente()));
			}
			if(UtilesCommons.noEsVacio(filtro.getEsempleado())) {
				criteria.add(Restrictions.eq("esempleado", filtro.getEsempleado()));
			}
			if(UtilesCommons.noEsVacio(filtro.getEscontacto())) {
				criteria.add(Restrictions.eq("escontacto", filtro.getEscontacto()));
			}
			if(UtilesCommons.noEsVacio(filtro.getEsproveedor())) {
				criteria.add(Restrictions.eq("esproveedor", filtro.getEsproveedor()));
			}			
		}
	}
	
	
}
