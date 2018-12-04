package erp.realcoresystems.pe.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.MaCategoriaMiscelaneosdetDao;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdet;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdetPK;
import erp.realcoresystems.pe.service.MaCategoriaMiscelaneosdetService;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.util.Log;

@Service("maCategoriaMiscelaneosdetService")
@Transactional(readOnly = true)
public class MaCategoriaMiscelaneosdetServiceImpl implements MaCategoriaMiscelaneosdetService {

	@Autowired
	MaCategoriaMiscelaneosdetDao maCategoriaMiscaleneosdetDao;
	
	@Override
	public MaCategoriaMiscelaneosdet obtenerPorId(MaCategoriaMiscelaneosdetPK id) {		
		return maCategoriaMiscaleneosdetDao.findById(id);
	}

	@Override
	public List<MaCategoriaMiscelaneosdet> listarElementos(MaCategoriaMiscelaneosdet objDao, boolean paginable) {		
		return maCategoriaMiscaleneosdetDao.listarElementos(objDao, paginable);
	}

	@Override
	public int contarElementos(MaCategoriaMiscelaneosdet objDao) {
		try{
			return maCategoriaMiscaleneosdetDao.contarElementos(objDao);
		}catch(Exception e){
			Log.error(e, "contarElementos");
			return 0;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(MaCategoriaMiscelaneosdet objDao) {
		int result = 0;
		try{			
			//guardar
			result =  maCategoriaMiscaleneosdetDao.guardar(objDao);
			//actualizar padre
			if(UtilesCommons.noEsVacio(objDao.getCategSecuenciaPadre())){
				actualizarCategoriaPadreDefault(objDao,objDao.getCategSecuenciaPadre());
			}
			
			//GUARDAR TABLA : SA_AUDITORIA
			if(objDao.isBool_1()) {
				maCategoriaMiscaleneosdetDao.guardarAuditoria(objDao, objDao.getString1());
			}
			
		}catch(Exception e){
			Log.error(e, "guardar");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result =  0;
		}
		return result;
		
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MaCategoriaMiscelaneosdet objDao) {
		int result = 0;
		try{		
			//get id  padre original
			//En el caso que el padre cambiase....
			Integer idPadreOriginal = objDao.getInt_1();//AUX; 				
			//guardar
			result =  maCategoriaMiscaleneosdetDao.actualizar(objDao);
			//actualizar padre
			if(UtilesCommons.noEsVacio(objDao.getCategSecuenciaPadre())){
				actualizarCategoriaPadreDefault(objDao,idPadreOriginal);
			}
			
			//GUARDAR TABLA : SA_AUDITORIA
			if(objDao.isBool_1()) {
				maCategoriaMiscaleneosdetDao.guardarAuditoria(objDao, objDao.getString1());
			}
			
		}catch(Exception e){
			Log.error(e, "actualizar");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result =  0;
		}
		return result;		
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MaCategoriaMiscelaneosdet objDao) {
		int result = 0;
		try{			
			//guardar
			result =  eliminarIncuidoHijos(objDao);
			//actualizar padre
			if(UtilesCommons.noEsVacio(objDao.getCategSecuenciaPadre())){
				actualizarCategoriaPadreDefault(objDao,objDao.getCategSecuenciaPadre());
			}
			
			//GUARDAR TABLA : SA_AUDITORIA
			if(objDao.isBool_1()) {
				maCategoriaMiscaleneosdetDao.guardarAuditoria(objDao, objDao.getString1());
			}
			
			result = 1;
		}catch(Exception e){
			Log.error(e, "eliminar");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result =  0;
		}
		return result;					
	}

	@Override
	public String getDesripcionTotal(String appCode, String codeCategTabla,Integer categSecuencia, Integer nivel) {
		//Armar recursivamente cadena ...
		try{
			MaCategoriaMiscelaneosdetPK id = new MaCategoriaMiscelaneosdetPK();
			id.setAplicacioncodigo(appCode);
			id.setCodigotablaCateg(codeCategTabla);
			id.setCategSecuencia(categSecuencia);
			
			//Por seguridad limitar a un numero finito (evitar errores en la recursividad)
			MaCategoriaMiscelaneosdet filtroCota = new MaCategoriaMiscelaneosdet();
			filtroCota.setId(id);
			//limite sera el numero de elementos total del arbol
			int limiteBusqueda = maCategoriaMiscaleneosdetDao.contarElementos(filtroCota);
			//comenzamos con el mismo elemento
			MaCategoriaMiscelaneosdet objCateg =  maCategoriaMiscaleneosdetDao.findById(id);
			String nombreFull = getDescripcionCategoriaRecursiva(objCateg, limiteBusqueda);
			return nombreFull;
		}catch(Exception e){			
			Log.error(e, "getDesripcionTotal");
			return "error";
		}	
	}
	
	
	/**UTILES CATEGORIAS**/
	public String getDescripcionCategoriaRecursiva(MaCategoriaMiscelaneosdet objCateg,int limite){
		if(objCateg!=null && limite >= 0){
			//la nueva categ secuencia a buscar es el padre
			objCateg.getId().setCategSecuencia(objCateg.getCategSecuenciaPadre());
			MaCategoriaMiscelaneosdet objCategSigte =  maCategoriaMiscaleneosdetDao.findById(objCateg.getId());
			return getDescripcionCategoriaRecursiva(objCategSigte, limite-1)+"/"+objCateg.getNombre();
		}else{
			return "";
				
		}				
	}
	
	
	public int actualizarCategoriaPadreDefault(MaCategoriaMiscelaneosdet objDao, Integer idCategPadre){
		int result = 0;
		MaCategoriaMiscelaneosdetPK objPk = new MaCategoriaMiscelaneosdetPK();
		objPk.setAplicacioncodigo(objDao.getId().getAplicacioncodigo());
		objPk.setCodigotablaCateg(objDao.getId().getCodigotablaCateg());
		objPk.setCategSecuencia(idCategPadre);
		
		MaCategoriaMiscelaneosdet objPadreSave = maCategoriaMiscaleneosdetDao.findById(objPk);
		if(objPadreSave!=null){
			//Verificar hijos
			MaCategoriaMiscelaneosdet objFiltro = new MaCategoriaMiscelaneosdet();
			objFiltro.getId().setAplicacioncodigo(objPadreSave.getId().getAplicacioncodigo());
			objFiltro.getId().setCodigotablaCateg(objPadreSave.getId().getCodigotablaCateg());
			objFiltro.setCategSecuenciaPadre(objPadreSave.getId().getCategSecuencia());
			List<MaCategoriaMiscelaneosdet> listaHijos =  maCategoriaMiscaleneosdetDao.listarElementos(objFiltro,false);
			if(UtilesCommons.noEsVacio(listaHijos)){
				//Si tiene hijos
				objPadreSave.setTipoNivel(Constant.TIPO_TREE_PADRE_CARPETA_db);
				objPadreSave.setAtributoImage(Constant.CATEG_ICON_PADRE);
				objPadreSave.setAtributoColor(Constant.CATEG_COLOR_PADRE);
				objPadreSave.setUltimafechamodif(new Date());
				objPadreSave.setUltimousuario(objDao.getUltimousuario());
				result = maCategoriaMiscaleneosdetDao.actualizar(objPadreSave);				
			}else{
				//Si no tiene hijos
				objPadreSave.setTipoNivel(Constant.TIPO_TREE_ITEM_ARCHIVO_db);
				objPadreSave.setAtributoImage(Constant.CATEG_ICON_ITEM);
				objPadreSave.setAtributoColor(Constant.CATEG_COLOR_ITEM);
				objPadreSave.setUltimafechamodif(new Date());
				objPadreSave.setUltimousuario(objDao.getUltimousuario());
				result = maCategoriaMiscaleneosdetDao.actualizar(objPadreSave);				
			}				
		}
		return result;
	}

	/** Eliminar Recursivamente las categorias hijos (Si tuviere)
	 * @param objDaoDel	
	 * @return
	 */
	public int eliminarIncuidoHijos(MaCategoriaMiscelaneosdet objDaoDel) {
		int result =0; 
		if(objDaoDel!=null){
			MaCategoriaMiscelaneosdet objFiltro = new MaCategoriaMiscelaneosdet();
			objFiltro.getId().setAplicacioncodigo(objDaoDel.getId().getAplicacioncodigo());
			objFiltro.getId().setCodigotablaCateg(objDaoDel.getId().getCodigotablaCateg());
			objFiltro.setCategSecuenciaPadre(objDaoDel.getId().getCategSecuencia());
			List<MaCategoriaMiscelaneosdet> listaHijos =  maCategoriaMiscaleneosdetDao.listarElementos(objFiltro,false);
			
			if(UtilesCommons.noEsVacio(listaHijos)){
				for(MaCategoriaMiscelaneosdet objConceptoDel :  listaHijos){
					eliminarIncuidoHijos(objConceptoDel);
				}
			}						
			//Eliminar concepto de seguridad	
			maCategoriaMiscaleneosdetDao.delete(objDaoDel);			
		}
	
		return result ;		
	}


}
