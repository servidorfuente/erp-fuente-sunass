package erp.realcoresystems.pe.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.EmpleadomastDao;
import erp.realcoresystems.pe.model.dao.PersonamastDao;
import erp.realcoresystems.pe.model.dao.ProveedormastDao;

import erp.realcoresystems.pe.model.dao.SaHcAnamnesisApDao;
import erp.realcoresystems.pe.model.dao.SaPersonaRelacionesDao;
import erp.realcoresystems.pe.model.dao.SeguridadPerfilUsuarioDao;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.Proveedormast;

import erp.realcoresystems.pe.model.domain.SaHcAnamnesisAp;
import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;

import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;
import erp.realcoresystems.pe.service.EncriptaKeyService;
import erp.realcoresystems.pe.service.PersonamastService;
import erp.realcoresystems.pe.service.SySeguridadAutorizacionService;
import erp.realcoresystems.pe.service.UsuarioService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("personamastService")
@Transactional(readOnly = true)
public class PersonamastServiceImpl implements PersonamastService {

	@Autowired
	SeguridadPerfilUsuarioDao seguridadPerfilDao;


	@Autowired
	private UsuarioService usuarioService;

//	@Autowired
//	private UsuarioDao usuarioDao;

	@Autowired
	private PersonamastDao personamastDao;



	@Autowired
	private EmpleadomastDao empleadomastDao;

	@Autowired
	private ProveedormastDao proveedorDao;

	@Autowired
	private SySeguridadAutorizacionService sySeguridadAutorizacionService;

	@Autowired
	private EncriptaKeyService encriptaKeyService;


	@Autowired
	private SaPersonaRelacionesDao saPersonaRelacionesDao;

	@Autowired
	private SaHcAnamnesisApDao saHcAnamnesisApDao;
	


	@Override
	@Transactional(readOnly = true)
	public List<Personamast> PersonamastListar(Personamast objeto) {
		try {
			return personamastDao.PersonamastListar(objeto);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : PersonamastListar : ");
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Personamast PersonaContacto(Personamast objeto) {
		try {
			return personamastDao.PersonaContacto(objeto);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : PersonaContacto : ");
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int guardarProveedor(Personamast persona, Proveedormast proveedor) {
		int resultado = 0;

		try {

			int personaId = personamastDao.guardar(persona);
			proveedor.setProveedor(personaId);
			proveedor.setSaPersona(null);
			resultado = proveedorDao.guardar(proveedor);

		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : guardarProveedor : ");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}

		return resultado;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizarProveedor(Personamast persona, Proveedormast proveedor) {
		try {
			personamastDao.forzarActualizar(persona);
			proveedorDao.actualizar(proveedor);
			return 1;
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : actualizarProveedor : ");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}


	@Override
	@Transactional(readOnly = true)
	public int contadorTotalesPersona(Personamast objeto) {
		try {
			return personamastDao.contadorTotalesPersona(objeto);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : contadorTotalesPersona : ");
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personamast> obtenerPersonaPorDocumento(int tipodocumento, String documento) {
		try {
			return personamastDao.obtenerPorDocumento(tipodocumento, documento);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : obtenerPersonaPorDocumento : ");
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personamast> obtenerPersonaYEmpleado(Personamast objeto) {
		try {
			return null;
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : obtenerPersonaYEmpleado : ");
			return null;
		}
	}


	@Override
	@Transactional(readOnly = true)
	public Personamast obtenerPorId(int personaId) {
		try {
			return personamastDao.obtenerPorId(personaId);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : obtenerPorId : ");
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizarEstadoPersona(Personamast _persona, String _modificador, String _ip) {
		try {
			Personamast personamast = personamastDao.obtenerPorId(_persona.getPersona());
			personamast.setEstado(_persona.getEstado());
			personamast.setUltimafechamodif(new Date());
			personamast.setUltimousuario(_modificador);
			return personamastDao.actualizarPersona(personamast);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : actualizarEstadoPersona : ");
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personamast> listarElementos(Personamast objPersonaMast) {
		try {
			return personamastDao.listarElementos(objPersonaMast);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : listarElementos : ");
			return null;
		}
	}

	@Override
	public int eliminar(Personamast objSave) {
		return 0;
	}


	@Override
	@Transactional(readOnly = false)
	public int guardar(Personamast persona) {
		try {
			int result = personamastDao.guardar(persona);
			return result;
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : guardar : ");
			return 0;
		}
	}


	@Override
	@Transactional(readOnly = true)
	public List<Personamast> validate(Personamast filtro) {
		try {
			return personamastDao.validate(filtro);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : validate : ");
			return null;
		}
	}


	@Override
	public String obtenerDocumentoAutogenerado() {
		String autogenerado = "";		
		String patronTime = UtilesCommons.printDate("yyyyMMddHHmmss",new Date());
		Integer patronRandom = UtilesCommons.getIntRandomLongitud(5);
		autogenerado =patronTime+"-"+patronRandom;//total 20 
		return autogenerado;
	}
	
	
	
	/*****************UTILES***************/
	
	public int guardarPersonaDatosMedicos(Integer personaId ,SaHcAnamnesisAp anamAntPersonales, boolean esNuevo,
			String _creador){
		/**actualizar DATOS MEDICOS*/
		int result = 0;
		if(esNuevo){
			if(anamAntPersonales!=null){
				anamAntPersonales.getId().setPersona(personaId);
				anamAntPersonales.setUsuariocreacion(_creador);
				anamAntPersonales.setFechacreacion(new Date());
				saHcAnamnesisApDao.guardar(anamAntPersonales);	
			}
			result = 1;
		}else{
			if(anamAntPersonales!=null 
					&& UtilesCommons.noEsVacio(anamAntPersonales.getId().getPersona())
					&& UtilesCommons.noEsVacio(anamAntPersonales.getId().getEpisodioclinicoid())){
				anamAntPersonales.getId().setPersona(personaId);
				anamAntPersonales.setUsuariomodificacion(_creador);
				anamAntPersonales.setFechamodificacion(new Date());
				saHcAnamnesisApDao.actualizar(anamAntPersonales);
				result = 1;
			}else{
				anamAntPersonales.getId().setPersona(personaId);
				anamAntPersonales.setUsuariocreacion(_creador);
				anamAntPersonales.setFechacreacion(new Date());
				saHcAnamnesisApDao.guardar(anamAntPersonales);
				result = 1;
			}			
		}
		return result;
	}
	
	/**Guardar Relaciones empresa*/
	public int guardarPersonaRelaciones(Integer personaId, String usuario ,List<SaPersonaRelaciones> listaPersonaRelacion
			,boolean indicaRegistrarEnBecaConvenios){
		int result =0;
		if(UtilesCommons.noEsVacio(listaPersonaRelacion)){
			for(SaPersonaRelaciones objPersRelSave :  listaPersonaRelacion){
				objPersRelSave.setPrelpersonaRelacionDe(personaId);
				if(Constant.INSERT_db.equals(objPersRelSave.getAccion())){
					objPersRelSave.setPrelfechacreacion(new Date());						
					saPersonaRelacionesDao.guardar(objPersRelSave);					
				}else if(Constant.UPDATE_db.equals(objPersRelSave.getAccion())){
					objPersRelSave.setPrelultimafechamodif(new Date());
					objPersRelSave.setPrelultimousuario(usuario);
					saPersonaRelacionesDao.actualizar(objPersRelSave);			
				}else if(Constant.DELETE_db.equals(objPersRelSave.getAccion())){
					saPersonaRelacionesDao.eliminar(objPersRelSave);			
				}				
						
			}								
		}
		return result;
	}
	


	@Override
	public List<VwPersonaGeneral> listar(VwPersonaGeneral filtro, boolean paginable) {
		try {
			return personamastDao.listar(filtro, paginable);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : listar : ");
			return UtilesCommons.getNewList();
		}
	}

	@Override
	public int contar(VwPersonaGeneral filtro) {
		try {
			return personamastDao.contar(filtro);
		} catch (Exception e) {
			Log.error(e, "PersonamastServiceImpl : contar : ");
			return 0;
		}
	}

}