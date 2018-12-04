package erp.realcoresystems.pe.model.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import erp.realcoresystems.pe.commons.UtilesCommons;

public class Utiles {

	public static ResourceBundle propiedadesService= ResourceBundle.getBundle("parametrosService");
	
	/**Obtener el recurso del propertie*/
	public static String getPropertyService(String prop){
		if(propiedadesService.containsKey(prop)){
			return propiedadesService.getString(prop);	
		}else{
			return "";
		}				
	}
	
	
	/***/
	public static final String FLAG_DOCENTE_db = "DOC";
	public static final String SI_db = "S";
	public static final String NO_db = "N";
	public static final int INT_SI = 1;
	public static final int INT_NO = 2;
	public static int ESTADO_ADMISION_ELIMINADO = 21;
	public static final int TIPO_PRODUCTO_PROGRAMA = 1;
	public static final int TIPO_PRODUCTO_CURSO_LIBRE = 3;
	public static final String PRODUCTO_PROGRAMA = "PROGRAMA";
	public static final String PRODUCTO_CURSO_LIBRE = "CURSO LIBRE";
	public static final String YES_db = "Y";
	
	public static String obtenerCodigoString(int codigo, int longitud){		
		return String.format("%0"+ longitud +"d", codigo);
	}
	
    /**Devuelve la fecha desplazada  tantos d_as (S_lo  d_as, no Horas...)*/
    public static Date fechaMasNumeroDias(Date fecha,int dias){
    	//fecha.getDay()
    	try{
    		///FALLA  CUANDO SE LE A_ADE M_S DE 24 D_as de golpe  (Tener cuidado)
        	if(fecha!=null ){
        		int signo =1;
        		if(dias<0){
        			signo=-1;
        		}
        		int diasAux = Math.abs(dias);
        		while(diasAux>=24){
            		Date fechaAux = getDateFormat("yyyyMMdd",printDate("yyyyMMdd", fecha));
            	    long time =fechaAux.getTime();        	    
            	    time = time+86400000*20*signo;  ////equivalente a un dia = 86400000 ms 
            	    Date fechaAux2 = new Date(time);    				        		
            		//return fechaAux2;
            		diasAux=diasAux-20;
            		fecha = fechaAux2;
            		dias = diasAux;
        		}
        		//long  fecha1 = Integer.parseInt( printDate("yyyyMMdd", fecha));
        		Date fechaAux = getDateFormat("yyyyMMdd",printDate("yyyyMMdd", fecha));
        	    long time =fechaAux.getTime();        	    
        	    time = time+86400000*diasAux*signo;  ////equivalente a un dia = 86400000 ms 
        	    Date fechaAux2 = new Date(time);    				        		
        		return fechaAux2;
        	}    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    /***/
    public static String  printDate(String pattern,Date valor){
    	if(valor!=null){
          	 SimpleDateFormat sdf = new SimpleDateFormat(pattern);          	
    		return sdf.format(valor);	        		
    	}else{
    		return null;
    	}    	
    }
    public static Date getDateFormat(String pattern,String valor){
    	try{
    		if(valor!=null){
    			SimpleDateFormat sdf = new SimpleDateFormat(pattern);    			    				
        		return sdf.parse(valor);		        		    			
    		}
    	}catch(Exception e){
    		e.printStackTrace();    		
    	}
    	return null;
    }
    
    public static boolean vacio(String str){
    	if(str == null || str.equals("")){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public static <T> boolean esVacio(List<T> list){
    	if(list == null || list.isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public static ProjectionList groupByMasivo(String... property){
		ProjectionList list = Projections.projectionList();
		if(property.length>0){			
			ProjectionList listgroup = Projections.projectionList();
			for (String string : property) {
				listgroup.add(Projections.groupProperty(string),string);
			}
			list.add(listgroup);			
		}		
		return list;
	} 
    
    public static ProjectionList groupByMasivo(List<String> liststring){
		ProjectionList list = Projections.projectionList();
		if(UtilesCommons.noEsVacio(liststring)){
			ProjectionList listgroup = Projections.projectionList();
			for (String string : liststring) {
				listgroup.add(Projections.groupProperty(string),string);
			}
			list.add(listgroup);
		}		
		return list;
	} 
    
    public static ProjectionList countMasivo(Class<?> c, String propertyCount, String... property){
		ProjectionList list = Projections.projectionList();
		if(property.length>0){				
			ProjectionList listgroup = Projections.projectionList();
			for (String string : property) {				
				listgroup.add(Projections.groupProperty(string),string);
			}
			list.add(listgroup);
			list.add(Projections.rowCount(),propertyCount);
		}
		return list;		
	} 
    
	public static Long crearLong(Object obj){
		try{
			Long value = new Long(obj.toString());
			return value;
		}catch(NullPointerException ex){
			return new Long(0);
		}catch(NumberFormatException ex){
			return new Long(0);
		}
	}
}
