package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.*;
import erp.realcoresystems.pe.model.domain.*;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;
import erp.realcoresystems.pe.model.domain.vista.VwSsperiodoformulario;
import erp.realcoresystems.pe.model.util.Constant;
import erp.realcoresystems.pe.service.*;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("ssControlperiodoService")
@Transactional(readOnly = true)
public class SsControlperiodoServiceImpl extends AbstractServiceImpl implements SsControlperiodoService {

	@Autowired
	SsControlperiodoDao ssControlperiodoDao;

	@Autowired
	SsCargainicialDao ssCargainicialDao;

	@Autowired
	CompaniaOwnerDao companiaOwnerDao;

	@Override
	public SsControlperiodo buscar(SsControlperiodo filtro) {
		try {
			return ssControlperiodoDao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsControlperiodoServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SsControlperiodo> listar(SsControlperiodo filtro, boolean pagina) {
		try {
			return ssControlperiodoDao.listar(filtro, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwControlperiodo> listarVista(VwControlperiodo filtro, boolean pagina) {
		try {
			return ssControlperiodoDao.listarVista(filtro, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo filtro, boolean pagina) {
		SsControlperiodo vistaAlterno = new SsControlperiodo();

		List<VwControlperiodo> objPeriodoNull = new ArrayList<>();
		List<VwControlperiodo> objPeriodoCont = new ArrayList<>();
		List<VwControlperiodo> objPeriodoSend = new ArrayList<>();
		List<Companyowner> objCompan = new ArrayList<>();
		Companyowner objEnt = new Companyowner();
		objEnt.setString1("00000000");
		objEnt.setNumeroFilas(filtro.getNumeroFilas());

		int random=50;

		SsControlperiodo objVwp = new SsControlperiodo();
		SsControlperiodo objBucar = new SsControlperiodo();
		VwControlperiodo objEnviar = new VwControlperiodo();
		VwControlperiodo objEnviarNull = new VwControlperiodo();
		try {
			//objCompan = companiaOwnerDao.listados(objEnt,pagina);
			int contador=1;
			objEnviarNull = new VwControlperiodo();
			filtro.setString10("NULL");
			objPeriodoNull = ssControlperiodoDao.listarVistaGrupos(filtro, pagina);
			//Map<String, List<VwControlperiodo>> groupByPriceMap = objPeriodoNull.stream().collect(Collectors.groupingBy(VwControlperiodo::getCompanyowner));
			filtro.setString10("");
			objPeriodoCont = ssControlperiodoDao.listarVista(filtro, false);

			for (VwControlperiodo objVista : objPeriodoNull){
				objEnviar = new VwControlperiodo();
				VwControlperiodo objBuscarData = objPeriodoCont.stream() // Convert to steam
						.filter(x -> objVista.getCompanyowner().equals(x.getCompanyowner()))
						.findAny()
						.orElse(null);
				if (objBuscarData!=null){
					objEnviar = objBuscarData;
				}else{
					objEnviar = objVista;
				}
				objEnviar.setIdcontador(contador);
				objPeriodoSend.add(objEnviar);
				contador++;
			}
			return objPeriodoSend;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public int registrarVista(List<VwControlperiodo> filtroRegistro,VwControlperiodo filtro, boolean pagina) {
		Integer retorno=0;
		Integer retornoVal=0;
		Integer annno= filtro.getInteger1()-1;
		SsControlperiodo registraEnt = new SsControlperiodo();
		SsCargainicial regsEnt = new SsCargainicial();
		List<SsCargainicial> registraList = new ArrayList<>();
		try {
			if (filtro.getInt_3()==2){
				for(VwControlperiodo obj : filtroRegistro){
					SsControlperiodo veriReg = new SsControlperiodo();
					registraEnt = new SsControlperiodo();
					registraEnt.setCompanyowner(obj.getCompanyowner());
					registraEnt.setTipooperacion("CARGAINICIAL");
					registraEnt.setFormularioid(0);
					registraEnt.setAnno(filtro.getInteger1());
					registraEnt.setFlagmodocargainicial(1);
					registraEnt.setEstadodocumento(2);
					veriReg = ssControlperiodoDao.buscar(registraEnt);
					if (veriReg==null){
						registraEnt.setEstado("A");
						retorno=ssControlperiodoDao.guardar(registraEnt);
						retorno=3;
					}
				}
			}
			if (filtro.getInt_3()==3){
				for(VwControlperiodo obj : filtroRegistro){
					regsEnt = new SsCargainicial();
					regsEnt.setCompanyowner(obj.getCompanyowner());
					regsEnt.setAnno(annno);
					regsEnt.setEstadodocumento(4);
					registraList = ssCargainicialDao.listar(regsEnt,false);
					if (registraList.size()>0){
						for(SsCargainicial objRegs : registraList){
							objRegs.setAnno(filtro.getInteger1());
							objRegs.setEstadodocumento(3);
							SsCargainicial objSiguient= new SsCargainicial();
							objSiguient = ssCargainicialDao.buscar(objRegs);
							if (objSiguient==null){
								objRegs.setEstado("A");
								retorno = ssCargainicialDao.guardar(objRegs);
								retorno=3;
							}
						}
					}else{

					}
				}
			}



		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return retorno;
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(SsControlperiodo objDao) {
		try {

			return ssControlperiodoDao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SsControlperiodo objDao) {
		try {

			return ssControlperiodoDao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SsControlperiodo objDao) {
		try {

			return ssControlperiodoDao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public int contar(SsControlperiodo filtro) {
		return ssControlperiodoDao.contar(filtro);
	}

	@Override
	public int contarVista(VwControlperiodo filtro) {
		return ssControlperiodoDao.contarVista(filtro);
	}

	@Override
	public int contarVistaGrupo(VwControlperiodo filtro) {
		filtro.setString10("NULL");
		return ssControlperiodoDao.contarVistaGrupo(filtro);
	}
}