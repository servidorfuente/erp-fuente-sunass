package erp.realcoresystems.pe.controller.configuracion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.model.util.FacesUtil;

import erp.realcoresystems.pe.model.util.Utiles;

@ManagedBean(name = "dashboardPrincipalBean")
@ViewScoped
public class DashboardPrincipalBean  implements Serializable {



	
	
	private String valorShowVentaDia;
	private String valorShowRemesaDia;
	private String valorShowCobranzaDia;
	
	private String simboloMoneda;
	
	@PostConstruct
	public void inicializar() {	
		cargarDashboardVenta();
	}
	
	/**CARGAR DATOS DASHBOARD**/
	
	public void cargarDashboardVenta(){
		try{
			BigDecimal valorVentaDia =BigDecimal.ZERO; 
			BigDecimal valorRemesaDia =BigDecimal.ZERO;
			simboloMoneda = "";
			//SI EXISTE UN CAJERO PRECARGADO (POR LOGIN o POR AUTORIZACIÓN DIRECTA)
	
				valorShowVentaDia = Utiles.getNumeroFormat(FacesUtil.getPropertyLabels("PATTERN_NUM_2DEC"), 
						valorVentaDia.doubleValue());		
				valorShowRemesaDia = Utiles.getNumeroFormat(FacesUtil.getPropertyLabels("PATTERN_NUM_2DEC"), 
						valorRemesaDia.doubleValue());					
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public String getValorShowVentaDia() {
		return valorShowVentaDia;
	}

	public void setValorShowVentaDia(String valorShowVentaDia) {
		this.valorShowVentaDia = valorShowVentaDia;
	}

	public String getValorShowRemesaDia() {
		return valorShowRemesaDia;
	}

	public void setValorShowRemesaDia(String valorShowRemesaDia) {
		this.valorShowRemesaDia = valorShowRemesaDia;
	}

	public String getValorShowCobranzaDia() {
		return valorShowCobranzaDia;
	}

	public void setValorShowCobranzaDia(String valorShowCobranzaDia) {
		this.valorShowCobranzaDia = valorShowCobranzaDia;
	}

	public String getSimboloMoneda() {
		return simboloMoneda;
	}

	public void setSimboloMoneda(String simboloMoneda) {
		this.simboloMoneda = simboloMoneda;
	}

}
