package erp.realcoresystems.pe.util;

import erp.realcoresystems.pe.model.domain.ParametrosMast;
import erp.realcoresystems.pe.model.util.Constant;

import java.math.BigDecimal;
import java.util.Date;



public class ParametroMastUtil {
	
	public static final String PARAMETRO_TIPO_DATO_TEXTO = "T";
	public static final String PARAMETRO_TIPO_DATO_NUMERO = "N";
	public static final String PARAMETRO_TIPO_DATO_FECHA = "D";
	
	private static boolean esVacio(String value){
		return value == null || value.trim().isEmpty() ? true: false;
	}
	
	private static boolean esVacio(BigDecimal value){
		return value == null ? true : false;
	}
	
	private static boolean esVacio(Date value){
		return value == null ? true : false;
	}

	public static boolean aplicaParametro(ParametrosMast parametro){
		if(parametro == null 
				|| esVacio(parametro.getEstado()) 
				|| parametro.getEstado().equalsIgnoreCase(Constant.INACTIVO)){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean aplicaParametroValorTexto(ParametrosMast parametro){
		return aplicaParametro(parametro) && aplicaValorTexto(parametro); 
	}
	
	public static boolean aplicaParametroValorNumero(ParametrosMast parametro){
		return aplicaParametro(parametro) && aplicaValorNumero(parametro); 
	}
	
	public static boolean aplicaParametroValorFecha(ParametrosMast parametro){
		return aplicaParametro(parametro) && aplicaValorFecha(parametro); 
	}
	
	public static boolean aplicaValorTexto(ParametrosMast parametro){
		return esVacio(parametro.getTipodedatoflag()) 
				|| (parametro.getTipodedatoflag().equalsIgnoreCase(PARAMETRO_TIPO_DATO_TEXTO) && esVacio(parametro.getTexto())) ? false : true;	
	}
	
	public static boolean noAplicaValorTexto(ParametrosMast parametro){
		return !aplicaValorTexto(parametro);
	}
	
	public static boolean aplicaValorNumero(ParametrosMast parametro){
		return esVacio(parametro.getTipodedatoflag()) 
				|| (parametro.getTipodedatoflag().equalsIgnoreCase(PARAMETRO_TIPO_DATO_NUMERO) && esVacio(parametro.getNumero())) ? false : true;	
	}
	
	public static boolean noAplicaValorNumero(ParametrosMast parametro){
		return !aplicaValorNumero(parametro);
	}
	
	public static boolean aplicaValorFecha(ParametrosMast parametro){
		return esVacio(parametro.getTipodedatoflag()) 
				|| (parametro.getTipodedatoflag().equalsIgnoreCase(PARAMETRO_TIPO_DATO_FECHA) && esVacio(parametro.getFecha())) ? false : true;	
	}
	
	public static boolean noAplicaValorFecha(ParametrosMast parametro){
		return !aplicaValorFecha(parametro);
	}
}
