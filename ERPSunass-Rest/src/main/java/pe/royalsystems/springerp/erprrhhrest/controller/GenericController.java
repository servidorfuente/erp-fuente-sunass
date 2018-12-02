package erp.realcoresystems.pe.erprrhhrest.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import erp.realcoresystems.pe.commons.UtilesCommons;

import java.util.Arrays;
import java.util.Date;

public class GenericController {

	public final static String COD_ERROR_HEAD = "HEAD_ERROR";
	public final static String COD_WARN_HEAD = "HEAD_WARN";
	public final static String COD_INFO_HEAD = "HEAD_INFO";
	
	public final static String COD_WARN_NO_RESULT_OK = "no-result-ok";
	public final static String COD_ERROR_NO_RESULT_OK = "no-result-ok";
	public final static String COD_ERROR_EXCEPTION = "error-ex";
	
	
	private MultiValueMap<String,String> mapHeaderResult;
	
	protected void setMapHeaderError(String CodigoError, String msjError){
		mapHeaderResult = new LinkedMultiValueMap<String,String> ();		
		mapHeaderResult.put(COD_ERROR_HEAD,Arrays.asList(CodigoError,msjError));
	}
	
	protected void setMapHeaderWarning(String CodigoWarn, String msjWarn){
		mapHeaderResult = new LinkedMultiValueMap<String,String> ();					
		mapHeaderResult.put(COD_WARN_HEAD,Arrays.asList(CodigoWarn,msjWarn));		
	}
	
	protected void setMapHeaderInfo(String CodigoInfo, String msjInfo){
		mapHeaderResult = new LinkedMultiValueMap<String,String> ();	
		mapHeaderResult.put(COD_INFO_HEAD,Arrays.asList(CodigoInfo,msjInfo));	
	}
	

	protected MultiValueMap<String,String> getMapHeaderResult(String codHeader){
		if(mapHeaderResult == null){
			mapHeaderResult = new LinkedMultiValueMap<String,String> ();	
			setMapHeaderInfo(codHeader,UtilesCommons.printDate("dd/MM/yyyy - HH:mm:ss", new Date()));
		}
		return mapHeaderResult;
	}
	
	protected MultiValueMap<String,String> getMapHeaderResult(){
		if(mapHeaderResult == null){
			mapHeaderResult = new LinkedMultiValueMap<String,String> ();	
			setMapHeaderInfo(COD_INFO_HEAD,UtilesCommons.printDate("dd/MM/yyyy - HH:mm:ss", new Date()));
		}
		return mapHeaderResult;
	}
	
}
