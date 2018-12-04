package erp.realcoresystems.pe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.model.dao.SaTablasDao;
import erp.realcoresystems.pe.model.dao.SaTablasauditoriaDao;
import erp.realcoresystems.pe.model.dao.SaTablasconceptosDao;
import erp.realcoresystems.pe.model.domain.SaTablas;
import erp.realcoresystems.pe.model.domain.SaTablasauditoria;
import erp.realcoresystems.pe.model.domain.SaTablasconceptos;
import erp.realcoresystems.pe.service.SaTablasauditoriaService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("saTablasauditoriaService")
@Transactional(readOnly = true)
public class SaTablasauditoriaServiceImpl implements SaTablasauditoriaService {

	@Autowired
	private SaTablasauditoriaDao saTablasauditoriaDao;

	@Autowired
	private SaTablasDao saTablasDao;

	@Autowired
	private SaTablasconceptosDao saTablasconceptosDao;

	@Override
	public SaTablasauditoria obtenerPorID(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.obtenerPorID(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
		}		
		return null;
	}

	@Override	
	@Transactional
	public List<SaTablasauditoria> listarElementos(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.listarElementos(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
		}
		return null;	
	}

	@Override
	@Transactional
	public int guardar(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.guardar(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;	
	}

	@Override
	@Transactional
	public int actualizar(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.actualizar(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;
	}
	
	@Override
	@Transactional
	public int eliminar(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.eliminar(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;	
	}

	@Override
	public int contadorTotaleslistarElementos(SaTablasauditoria objService) {
		try{			
			return saTablasauditoriaDao.contadorTotaleslistarElementos(objService);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
		}
		return 0;	
	}

	@Override
	@Transactional
	public int guardarMasivo(List<SaTablasauditoria> listaService) {
		try{	
			int result=1; 
			for(SaTablasauditoria objService: listaService){
				if(Constant.DELETE_db.equals(objService.getAccion()) ){
					result = saTablasauditoriaDao.eliminar(objService);						
				}else if(Constant.UPDATE_db.equals(objService.getAccion()) ){
					result = saTablasauditoriaDao.actualizar(objService);						
				}else{
					result = saTablasauditoriaDao.guardar(objService);
				}																		
			}	
			return result;
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return 0;	
	}

	@Override
	public List<SaTablas> listarElementos_SaTablas(SaTablasauditoria objDao) {
		try{	
			List<SaTablasconceptos>  listTabConceptos = new ArrayList<SaTablasconceptos>();			
			SaTablasconceptos  objTabConceptos= new SaTablasconceptos();					
			objTabConceptos.setAplicacioncodigo(objDao.getAplicacioncodigo());
			objTabConceptos.setGrupo(objDao.getGrupo());
			objTabConceptos.setConcepto(objDao.getConcepto());			
			listTabConceptos = saTablasconceptosDao.listarElementos(objTabConceptos);
			Log.logger.info("TEST TABLAS:BUSINES :: "+listTabConceptos.size());
			if(listTabConceptos!=null){
				if(listTabConceptos.size()>0){
					String idTablas = "";
					for(SaTablasconceptos objTabConResult : listTabConceptos ){
						idTablas = idTablas + "|"+objTabConResult.getIdtabla();
					}
					if(idTablas.length()>0){
						idTablas = idTablas.substring(1, idTablas.length());
						SaTablas obj = new SaTablas();
						
						obj.setFlagConsultaEntGlobal("MULTI");
						obj.setDescripcion02(idTablas);
						obj.setNombretabla(objDao.getDescripcion01());
						obj.setInicio(objDao.getInicio());
						obj.setNumeroFilas(objDao.getNumeroFilas());
						
						Log.logger.info("TEST TABLAS:BUSINES:AAAaaa ID : "+idTablas);
						return saTablasDao.listarElementosPag(obj)	;
					}
				}								
			}

		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
		}
		return null;
	}

	@Override
	@Transactional
	public List<SaTablasauditoria> listarElementosPag(SaTablasauditoria objDao) {
		try{			
			return saTablasauditoriaDao.listarElementosPag(objDao);							
		}catch(Exception e){
			Log.logger.error(Log.getStackTrace(e));	
		}
		return null;
	}
}
