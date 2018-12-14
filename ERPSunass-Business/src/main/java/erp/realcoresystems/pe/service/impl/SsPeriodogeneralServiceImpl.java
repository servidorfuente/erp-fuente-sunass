package erp.realcoresystems.pe.service.impl;

import erp.realcoresystems.pe.model.dao.CompaniaOwnerDao;
import erp.realcoresystems.pe.model.dao.SsCargainicialDao;
import erp.realcoresystems.pe.model.dao.SsPeriodogeneralDao;
import erp.realcoresystems.pe.model.dao.SsPeriodogeneralDao;
import erp.realcoresystems.pe.model.domain.Companyowner;
import erp.realcoresystems.pe.model.domain.SsCargainicial;
import erp.realcoresystems.pe.model.domain.SsPeriodogeneral;
import erp.realcoresystems.pe.model.domain.vista.VwControlperiodo;
import erp.realcoresystems.pe.service.SsPeriodogeneralService;
import erp.realcoresystems.pe.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ssPeriodogeneralService")
@Transactional(readOnly = true)
public class SsPeriodogeneralServiceImpl extends AbstractServiceImpl implements SsPeriodogeneralService {

	@Autowired
    SsPeriodogeneralDao ssPeriodogeneralDao;

	@Autowired
	SsCargainicialDao ssCargainicialDao;

	@Autowired
	CompaniaOwnerDao companiaOwnerDao;

	@Override
	public SsPeriodogeneral buscar(SsPeriodogeneral filtro) {
		try {
			return ssPeriodogeneralDao.buscar(filtro);
		} catch (Exception e) {
			Log.error(e,"SsPeriodogeneralServiceImpl : buscar : ");
			return null;
		}
	}

	@Override
	public List<SsPeriodogeneral> listar(SsPeriodogeneral filtro, boolean pagina) {
		try {
			return ssPeriodogeneralDao.listar(filtro, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwControlperiodo> listarVista(VwControlperiodo filtro, boolean pagina) {
		try {
			return ssPeriodogeneralDao.listarVista(filtro, pagina);
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.error(Log.getStackTrace(e));
		}
		return null;
	}

	@Override
	public List<VwControlperiodo> listarVistaGrupos(VwControlperiodo filtro, boolean pagina) {
		SsPeriodogeneral vistaAlterno = new SsPeriodogeneral();

		List<VwControlperiodo> objPeriodoNull = new ArrayList<>();
		List<VwControlperiodo> objPeriodoCont = new ArrayList<>();
		List<VwControlperiodo> objPeriodoSend = new ArrayList<>();
		List<Companyowner> objCompan = new ArrayList<>();
		Companyowner objEnt = new Companyowner();
		objEnt.setString1("00000000");
		objEnt.setNumeroFilas(filtro.getNumeroFilas());

		int random=50;

		SsPeriodogeneral objVwp = new SsPeriodogeneral();
		SsPeriodogeneral objBucar = new SsPeriodogeneral();
		VwControlperiodo objEnviar = new VwControlperiodo();
		VwControlperiodo objEnviarNull = new VwControlperiodo();
		try {
			//objCompan = companiaOwnerDao.listados(objEnt,pagina);
			int contador=1;
			objEnviarNull = new VwControlperiodo();
			filtro.setString10("NULL");
			objPeriodoNull = ssPeriodogeneralDao.listarVistaGrupos(filtro, pagina);
			//Map<String, List<VwControlperiodo>> groupByPriceMap = objPeriodoNull.stream().collect(Collectors.groupingBy(VwControlperiodo::getCompanyowner));
			filtro.setString10("");
			objPeriodoCont = ssPeriodogeneralDao.listarVista(filtro, false);

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
		SsPeriodogeneral registraEnt = new SsPeriodogeneral();
		SsCargainicial regsEnt = new SsCargainicial();
		List<SsCargainicial> registraList = new ArrayList<>();
		try {
			if (filtro.getInt_3()==2){
				for(VwControlperiodo obj : filtroRegistro){
					SsPeriodogeneral veriReg = new SsPeriodogeneral();
					registraEnt = new SsPeriodogeneral();
					registraEnt.setCompanyowner(obj.getCompanyowner());
					registraEnt.setTipooperacion("CARGAINICIAL");
					registraEnt.setFormularioid(0);
					registraEnt.setAnno(filtro.getInteger1());
					registraEnt.setFlagmodocargainicial(1);
					registraEnt.setEstadodocumento(2);
					veriReg = ssPeriodogeneralDao.buscar(registraEnt);
					if (veriReg==null){
						registraEnt.setEstado("A");
						retorno=ssPeriodogeneralDao.guardar(registraEnt);
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
	public int guardar(SsPeriodogeneral objDao) {
		try {

			return ssPeriodogeneralDao.guardar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(SsPeriodogeneral objDao) {
		try {

			return ssPeriodogeneralDao.actualizar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(SsPeriodogeneral objDao) {
		try {

			return ssPeriodogeneralDao.eliminar(objDao);
		} catch (Exception ex) {
			rollback(ex);
			Log.logger.error(Log.getStackTrace(ex));
		}
		return 1;
	}

	@Override
	public int contar(SsPeriodogeneral filtro) {
		return ssPeriodogeneralDao.contar(filtro);
	}

	@Override
	public int contarVista(VwControlperiodo filtro) {
		return ssPeriodogeneralDao.contarVista(filtro);
	}

	@Override
	public int contarVistaGrupo(VwControlperiodo filtro) {
		filtro.setString10("NULL");
		return ssPeriodogeneralDao.contarVistaGrupo(filtro);
	}
}