package erp.realcoresystems.pe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.SeguridadConceptoDao;
import erp.realcoresystems.pe.model.dao.SeguridadautorizacionesDao;
import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;
import erp.realcoresystems.pe.service.SeguridadConceptoService;
import erp.realcoresystems.pe.util.Log;

@Service("seguridadConceptoService")
@Transactional(readOnly = true)
public class SeguridadConceptoServiceImpl implements SeguridadConceptoService {

	@Autowired
	private SeguridadConceptoDao seguridadConceptoDao;

	@Autowired
	private SeguridadautorizacionesDao seguridadautorizacionesDao;
	
	@Override
	public List<Seguridadconcepto> SeguridadConceptoLista(Seguridadautorizaciones seguridadAutorizaciones) {
		try {
			return seguridadConceptoDao.SeguridadConceptoLista(seguridadAutorizaciones);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public Seguridadconcepto SeguridadConceptoBuscar(Seguridadconcepto seguridadConcepto) {
		try{return seguridadConceptoDao.SeguridadConceptoBuscar(seguridadConcepto);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
		}

	@Override
	public Seguridadconcepto obtenerPorId(Seguridadconcepto seguridadconcepto) {
		try {
			return seguridadConceptoDao.obtenerPorId(seguridadconcepto);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public List<Seguridadconcepto> listar(Seguridadconcepto seguridadconcepto) {
		try {
			return seguridadConceptoDao.listar(seguridadconcepto);

		} catch (Exception e) {
			//System.out.println("Horrror");
			Log.logger.error(Log.getStackTrace(e));
			return null;
		}
	}

	@Override
	public int contarTotal(Seguridadconcepto seguridadconcepto) {
		try {
			return seguridadConceptoDao.contar(seguridadconcepto);

		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(Seguridadconcepto seguridadconcepto) {
		try {
			if(UtilesCommons.noEsVacio(seguridadconcepto.getConcepto())){
				seguridadConceptoDao.save(seguridadconcepto);
				return 1;
			}else{
				return seguridadConceptoDao.guardar(seguridadconcepto);	
			}			
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(Seguridadconcepto seguridadconcepto) {
		try {
			/**Verificar si es padre*/

			eliminarConceptoAutorzacionesYConceptosHijos(seguridadconcepto);
						
			return 1;			
		} catch (Exception e) {
			Log.logger.error(Log.getStackTrace(e));
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}		

	}
	
	/** Eliminar Recursivamente las autorizaciones del Concepto y los conceptos hijos (Si tuviere)
	 * @param seguridadconcepto
	 * @param hijos
	 * @return
	 */
	public int eliminarConceptoAutorzacionesYConceptosHijos(Seguridadconcepto seguridadconcepto) {
		int result =0; 
		if(seguridadconcepto!=null){
			Seguridadconcepto conceptoFiltro = new Seguridadconcepto();
			conceptoFiltro.setAplicacioncodigo(seguridadconcepto.getAplicacioncodigo());
			conceptoFiltro.setGrupo(seguridadconcepto.getGrupo());
			conceptoFiltro.setConceptopadre(seguridadconcepto.getConcepto());
			List<Seguridadconcepto> listaConceptosHijo =  seguridadConceptoDao.listarElementos(conceptoFiltro,false);
			
			if(UtilesCommons.noEsVacio(listaConceptosHijo)){
				for(Seguridadconcepto objConceptoDel :  listaConceptosHijo){
					eliminarConceptoAutorzacionesYConceptosHijos(objConceptoDel);
				}
			}	
			
			//ELiminar autorizaciones otorgadas de este PERMISO, si hubieren
			Seguridadautorizaciones seguridadAutoriza = new Seguridadautorizaciones();
			seguridadAutoriza.setAplicacioncodigo(seguridadconcepto.getAplicacioncodigo());
			seguridadAutoriza.setGrupo(seguridadconcepto.getGrupo());
			seguridadAutoriza.setConcepto(seguridadconcepto.getConcepto());
			
			List<Seguridadautorizaciones> listaDelete = seguridadautorizacionesDao.listarElementos(seguridadAutoriza);
			if(UtilesCommons.noEsVacio(listaDelete)){
				for(Seguridadautorizaciones objDel : listaDelete ){
					seguridadautorizacionesDao.eliminar(objDel)	;
				}
			}
			
			//Eliminar concepto de seguridad	
			seguridadConceptoDao.delete(seguridadconcepto);
			
		}
	
		return result ;		
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(Seguridadconcepto seguridadconcepto) {
		seguridadConceptoDao.update(seguridadconcepto);
		return 1;
	}

	@Override
	public Seguridadgrupo obtenerPorId(Seguridadgrupo pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seguridadgrupo> listar(Seguridadgrupo seguridadgrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarTotal(Seguridadgrupo seguridadgrupo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int guardar(Seguridadgrupo seguridadgrupo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(Seguridadgrupo seguridadgrupo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Seguridadgrupo seguridadgrupo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}