package erp.realcoresystems.pe.model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;

import erp.realcoresystems.pe.commons.UtilesCommons;
import erp.realcoresystems.pe.model.dao.AbstractDao;
import erp.realcoresystems.pe.model.domain.Entidad;
import erp.realcoresystems.pe.model.domain.SaAuditoria;
import erp.realcoresystems.pe.model.domain.SaTablas;
import erp.realcoresystems.pe.model.util.Utiles;


public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E,I> {

    public static final String ORDER_ASC  = "ASC";
    public static final String ORDER_DESC = "DESC";
    private Class<E> entityClass;

    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
//        iniciarAuditoriaTrace(e,"IoU","");
    }
    
    @Override
    public void update(E e) {    	
        getCurrentSession().update(e);
//        iniciarAuditoriaTrace(e,"U","");
    }

    @Override
    public void save(E e) {    	
        getCurrentSession().save(e);
//        iniciarAuditoriaTrace(e,"I","");
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
//        iniciarAuditoriaTrace(e,"D","");
    }
    
    public void merge(E e) {    	
        getCurrentSession().merge(e);
//        iniciarAuditoriaTrace(e,"U","");
    }
    
    @Override
    public void flush(){
    	getCurrentSession().flush();
    	getCurrentSession().clear();
    }
    
    @Override
    public <T> T getMaxColumn(String columna, Class<T> clazz) {
    	Criteria cq = createCriteria();
    	cq.setProjection(Projections.max(columna));
    	Object result = cq.uniqueResult();
    	if(result == null){
    		return null;
    	}else{
    		T resultCast = clazz.cast(result);
    		return resultCast;
    	}
    }
    
    public <T> Criteria createCriteria(Class<T> clazz){
    	Criteria criteria = getCurrentSession().createCriteria(clazz);
    	return criteria;
    }
    
    public Criteria createCriteria(){
    	return createCriteria(entityClass);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }
    
    public void setParametrosAuditoriaTrace(E e,I id,String tipo) {
        //OBS tipo por defecto L  (...)    	    
    	iniciarAuditoriaTrace(e, "L", "");    	    	    	    	
    }
    
    /*********TRATAMIENTO AUDITOR_A******/
    public void  iniciarAuditoriaTrace(Object objTrace, String typeTrace,String primKeyData){
    	try{
    		if(objTrace!=null){        		
            	/**consultar tabla SA_TABLASAUDITORIA para verificar si PROCESO (CONCEPTO) est_ activo para AUDITOR_A*/
            	boolean  validoParaAuditoria = false;
            	boolean  esTransaccion= true;
            	String  nombreEntidad = null;
        		Entidad objPadre=null;
        		if(objTrace instanceof Entidad){
        			objPadre = (Entidad)objTrace;
        		}		
        		/**VALIDACI_N AUDITORIA SIN NECEIDAD DE CONSULTA*/
        		if("S".equals(objPadre.getFlagAuditoriaEntGlobal())){
        			validoParaAuditoria=true;
        		}
        		/**REDEFINIR TIPO TRACE***/
        		if("IoU".equals(typeTrace)){
        			if(objPadre.getObjetoAntiguo()!=null){
        				typeTrace="U";
            		}else{
            			typeTrace="I";
            		}	
        		}
        		else if("D".equals(typeTrace)) {
        			typeTrace="D";
        		}
        		else if("L".equals(typeTrace) || "R".equals(typeTrace) || "P".equals(typeTrace)){        			        			
        			esTransaccion=false;        			
        		}            		
        		if(Utiles.SI_db.equals(objPadre.getFlagAuditSoloTransactEntGlobal()) && !esTransaccion){
        			validoParaAuditoria=false;
        		}
        		
        		/**PREPARAR EL TRACE AUDITOR_A SI EST_ PERMITIDO****/
        		if(validoParaAuditoria){        			            		
            		nombreEntidad = objTrace.getClass().getSimpleName();
            		SaTablas objTab = null;
            		List<SaTablas> listaTab = null;
            		//objTab.setClassname(classname);
            		/**BUSQUEDA DE LA TABLA(POR CLASSNAME) PARA OBTENER EL ID Y ATRIBUTOS NECESARIOS... */
            		Criteria criteriaTab = getCurrentSession().createCriteria(SaTablas.class);
            		criteriaTab.add(Restrictions.eq("classname", nombreEntidad));
            		listaTab = criteriaTab.list();
            		if(listaTab!=null){
                		if(listaTab.size()==1){
                			objTab = listaTab.get(0);                			
                		}else{
                			if(listaTab.size()==1){
                    			//TRATAMIENTO POR DEFECTO
                    			objTab = listaTab.get(0);	
                			}                			
                		}                 			
            		}
            		/**COMENZAR EL TRACE AUDITOR_A SI EST_ PERMITIDO****/
        			setObjetoAuditoriaTrace(objTrace, typeTrace, primKeyData,objTab,esTransaccion);
        		}				
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}    	
    }
    
    
	public void  setObjetoAuditoriaTrace(Object objTrace, String typeTrace,
			String primKeyData,SaTablas objTab, boolean esTransaccion) {
		try 
		{
			if(objTrace!=null){			
				String simbSeparador="//";
				String nombreEntidad="";
				//String nombreTabla="";				
				//String tablaIdValue="";								
				String oldData="";
				String newData="";				
				String vistaData="";
				Class<?> claseAuditoria = SaAuditoria.class;														
				/**UPCASTING*/				
				Entidad objPadre=null;
				if(objTrace instanceof Entidad){
					objPadre = (Entidad)objTrace;
				}
				/**SET EL OBJ TRACE (objAuditoria) DE AUDITOR_A*/
				SaAuditoria  objAuditoriaTemp = new SaAuditoria();
				Object  objAuditoriaSave = null;
							
				/**OBTENER NOMBRE DE CLASE  DEL OBJETO*/
				nombreEntidad = objTrace.getClass().getSimpleName();
				
				Object objTraceOld=null;
				Class<?> claseEntidadObjOld=null;
				boolean indicaValidoSetOldAntiugo =false;
            	if(objPadre!=null){
            		/**OBTENER  OBJETO ANTIG_O*/
            		objTraceOld = objPadre.getObjetoAntiguo();					
					if(objTraceOld!=null){	
						claseEntidadObjOld = objTraceOld.getClass();
						if(claseEntidadObjOld.getSimpleName().equals(nombreEntidad)){
							indicaValidoSetOldAntiugo=true;							
						}												
					}					
					/*******SET VALORES GENERALES DE LA AUDITOR_A**********************/
					objAuditoriaTemp.setAplicacioncodigo(objPadre.getAppCodigoEntGlobal());
					objAuditoriaTemp.setGrupo(objPadre.getModuloEntGlobal());
					objAuditoriaTemp.setConcepto(objPadre.getConceptoEntGlobal());
					objAuditoriaTemp.setHostname(objPadre.getHostEntGlobal());
					objAuditoriaTemp.setUsuario(objPadre.getUsuarioEntGlobal());
					objAuditoriaTemp.setTipo(typeTrace);
					objAuditoriaTemp.setTablename(nombreEntidad);//POR DEFECTO ENTIDAD
					objAuditoriaTemp.setTableidvalue((long)0);//POR DEFECTO 0
					objAuditoriaTemp.setPrimarykeydata(primKeyData);
					objAuditoriaTemp.setUpdatedate(objPadre.getFechaAccionEntGlobal());						
					objAuditoriaTemp.setSessiondate(objPadre.getFechaSessionEntGlobal());			
					objAuditoriaTemp.setUsuariodb(objPadre.getUsuarioDbEntGlobal());					
					objAuditoriaTemp.setDirmacClient(objPadre.getMacClienteEntGlobal());
					objAuditoriaTemp.setIpClient(objPadre.getIpEntGlobal());					
					objAuditoriaTemp.setPcName(objPadre.getPcNameClienteEntGlobal());
					objAuditoriaTemp.setFlagExito((long)(1));  //1=_XITO
					objAuditoriaTemp.setSysVersion(objPadre.getSysVersionEntGlobal());
					objAuditoriaTemp.setSysUrl(objPadre.getSysUrlEntGlobal());					
					objAuditoriaTemp.setObservacion(objPadre.getMotivoObservacionAuditEntGlobal());										
					/****************************************************************/
					//OBTENER VALORES DEL OBJETO TABLA (SI LO HUBIERA)
					if(objTab!=null){
						objAuditoriaTemp.setTablename(objTab.getNombretabla());	
						objAuditoriaTemp.setTableidvalue(objTab.getIdtabla().longValue());
					}										
            	}	
            	/**OBTENER ARIBUTOS Y VALORES DEL OBJETO */
				Field[] fields = objTrace.getClass().getDeclaredFields();
            	if(esTransaccion){								
    				for(Field field : fields) {
    	                try {
    	                	String fieldName = field.getName();
    	                	field.setAccessible(true);
    	                	Object fieldValue = field.get(objTrace);
    	                	if(indicaValidoSetOldAntiugo){	                		    					
    	    					/**OBTENER ARIBUTOS Y VALORES DEL OBJETO ANTIG_O  (SOLO COLOCA DATA DIFERENTE)*/
    							Field fieldOld =  claseEntidadObjOld.getDeclaredField(fieldName);
    							fieldOld.setAccessible(true);
    							Object fieldValueOld = fieldOld.get(objTraceOld);
    							if(!sonIguales(fieldValue, fieldValueOld)){    								
    								if(fieldValue instanceof Date){
    									Date fechaA = (Date)fieldValue;
    									String  auxA= printDate("dd/MM/yyyy HH:mm:ss", fechaA);
    									/*if(auxA.contains(".")){
    										auxA = auxA.substring(0, auxA.indexOf("."));  
    									} */      									
    									fieldValue = auxA;
    								}
    								if(fieldValueOld instanceof Date){
    									Date fechaB = (Date)fieldValueOld;
    									String  auxB= printDate("dd/MM/yyyy HH:mm:ss", fechaB);
    									/*if(auxB.contains(".")){
    										auxB = auxB.substring(0, auxB.indexOf("."));  
    									}*/    										
    									fieldValueOld = auxB;    									
    								}    								
    								newData =newData+ fieldName +"="+ (fieldValue!=null?fieldValue:"") + simbSeparador;
    								oldData =oldData+ fieldName +"="+ (fieldValueOld!=null?fieldValueOld:"") + simbSeparador;
    							}    							
    	                	}else{
    	                		if(fieldValue instanceof Date){
									Date fechaA = (Date)fieldValue;
									String  auxA= printDate("dd/MM/yyyy HH:mm:ss", fechaA);									      								
									fieldValue = auxA;
								} /*else if(fieldValue instanceof Entidad){
									
								}*/
    	                		
    	                		newData =newData+ fieldName +"="+ (fieldValue!=null?fieldValue:"") + simbSeparador;	
    	                	}	                							
    					} catch (IllegalArgumentException  e) {
    						e.printStackTrace();
    					} catch(Exception ex){
    						ex.printStackTrace();
    					}
    				}
            	}else{
                	/**OBTENER ARIBUTOS Y VALORES DEL OBJETO (SOLO COLOCA DATA FILTRO (no nula)*/    											
    				for(Field field : fields) {
    	                try {
    	                	String fieldName = field.getName();
    	                	field.setAccessible(true);
    	                	Object fieldValue = field.get(objTrace);
    	                	if(fieldValue!=null){
    	                		newData =newData+ fieldName +"="+ (fieldValue!=null?fieldValue:"") + simbSeparador;	
    	                	}
    	                	                							
    					} catch (IllegalArgumentException  e) {
    						e.printStackTrace();
    					}	catch(Exception ex){
    						ex.printStackTrace();
    					}
    				}
            	}


				/**OBTENER ARIBUTOS Y VALORES DEL OBJETO ANTIG_O (OLD DATA COMPLETA) */
				/*				 
				if(objPadre!=null){
					Object objTraceOld = objPadre.getObjetoAntiguo();					
					if(objTraceOld!=null){												
						nombreEntidad = objTraceOld.getClass().getSimpleName();							
						Field[] fieldsOld = objTraceOld.getClass().getDeclaredFields();
						for(Field field : fieldsOld) {
			                try {
			                	String fieldName = field.getName();
			                	field.setAccessible(true);
			                	Object fieldValue = field.get(objTraceOld);
			                	oldData =oldData+ fieldName +"="+ (fieldValue!=null?fieldValue:"") + simbSeparador;						
							} catch (IllegalArgumentException  e) {								
								e.printStackTrace();
							}				                
						}								
					}					
					
				}*/										
				objAuditoriaTemp.setOlddata(oldData);
				objAuditoriaTemp.setNewdata(newData);	
				objAuditoriaTemp.setVistadata(vistaData);
				//objAuditoria.setAplicacioncodigo(aplicacioncodigo);
				
				/**Obtener la clase y el objeto de Auditor_a, si es NULO tomar_ por defecto (SaAuditoria)*/
				objAuditoriaSave = objAuditoriaTemp;
				if(objPadre!=null){
					if(objPadre.getClaseTablaAudit()!=null){
						claseAuditoria = objPadre.getClaseTablaAudit();
						objAuditoriaSave =  getNuevoObjetoGenerico(objAuditoriaTemp, claseAuditoria) ;
					}					
				}							
				//showObjeto(objAuditoriaSave);				
				/**PERSISTENT  OBJETO TRACE (objAuditoria)*/
				//Obtener  Max Id ingresado
				//DetachedCriteria maxDateQuery = DetachedCriteria.forClass(SaAuditoria.class);
				//proj.add(Projections.groupProperty("connectionid"));
				//maxDateQuery.setProjection(proj);
				//criteria.add(Subqueries.propertiesEq(new String[] {"auditoriaid"}, maxDateQuery));				
				Criteria criteria = getCurrentSession().createCriteria(claseAuditoria);
				ProjectionList proj = Projections.projectionList();
				proj.add(Projections.max("auditoriaid"));																
				criteria.setProjection(proj);
				Object result = criteria.uniqueResult();
				long valorMax=0;
				if(result!=null){
					valorMax = Integer.parseInt(result.toString());	
				}				
				//SET ID MAX+1 (Din_mico)
				Field fieldAudit = objAuditoriaSave.getClass().getDeclaredField("auditoriaid");
				if(fieldAudit!=null){
					fieldAudit.setAccessible(true);            	            	
					fieldAudit.set(objAuditoriaSave,(valorMax+1));
					//objAuditoriaTemp.setAuditoriaid(valorMax+1);					
					getCurrentSession().saveOrUpdate(objAuditoriaSave);					
				}
				/*******/
				//getCurrentSession().saveOrUpdate(objAuditoria);				
			}					
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
    private static String PARAM_DB_USERNAME = "userName";
    private static String PARAM_DB_URL = "url";
    private static String PARAM_DB_PRODUCTNAME = "databaseProductName";
    private static String PARAM_DB_SCHEMA= "schemaTerm";
    private static String PARAM_DB_SQLKey= "SQLKeywords";
	
	/**Obtener par_metros de la Conexi_n*/
	public String getParametroConectionDataBase(String parametro){
		  String result ="";		  
		  SessionFactoryImplementor sfi = (SessionFactoryImplementor) sessionFactory;				  
		  @SuppressWarnings("deprecation")
		ConnectionProvider connectionProvider = sfi.getJdbcServices().getConnectionProvider();		  
		  try {			  
			  	if(connectionProvider!=null){
			  		Connection connection = connectionProvider.getConnection();
			        DatabaseMetaData databaseMetaData = connection.getMetaData();			        
			        if(PARAM_DB_USERNAME.equals(parametro)){
			        	result = databaseMetaData.getUserName();
			        }else if(PARAM_DB_URL.equals(parametro)){
			        	result = databaseMetaData.getURL();	
			        }else if(PARAM_DB_PRODUCTNAME.equals(parametro)){
			        	result = databaseMetaData.getDatabaseProductName();	
			        }else if(PARAM_DB_SCHEMA.equals(parametro)){
			        	result = databaseMetaData.getSchemaTerm();	
			        }else if(PARAM_DB_SQLKey.equals(parametro)){
			        	result = databaseMetaData.getSQLKeywords();	
			        }			        			        			        			        
			        //DatasourceConnectionProviderImpl coneProImpl = (DatasourceConnectionProviderImpl) connectionProvider;			        			       
			  	}		        		       		       
		  } catch (Exception e) {
			  e.printStackTrace();		      
		  }
		  return result;
	}
	/***/
	public static boolean sonIguales(Object objetoA,Object objetoB){
		boolean result = false;
		if(objetoA ==null && objetoB == null){
			result=true;
		}else {
			if(objetoA !=null && objetoB != null){
				String claseA = objetoA.getClass().getName();//OBS
				String claseB = objetoB.getClass().getName();
				if(claseA.equals(claseB)){											
					if(objetoA instanceof Date ){								
						Date fechaA = (Date)objetoA;
						Date fechaB = (Date)objetoB;
						if(printDate("yyyyMMdd-hhmmss", fechaA).equals(printDate("yyyyMMdd-hhmmss", fechaB))){
							result=true;
						}												
					}else{
						if((""+objetoA).equals(""+objetoB)){
							result=true;
						}
					}
				}else if( (objetoA instanceof Date ||  objetoA instanceof java.sql.Timestamp)
						&&
						(objetoB instanceof Date ||  objetoB instanceof java.sql.Timestamp)
					){							
						Date fechaA = (Date)objetoA;
						Date fechaB = (Date)objetoB;
						if(printDate("yyyyMMdd-hhmmss", fechaA).equals(printDate("yyyyMMdd-hhmmss", fechaB))){
							result=true;
						}						
						
					}else{
						result=false;	
					} 									
			}else{
				result=false;					
			}
		}
		return result;
	}

	/**Construye dinamicamente un nuevo objetode Una clase determinada a partir del objeto Original*/
    public static Object getNuevoObjetoGenerico(Object objetoOrigen, Class<?> claseNuevoObjeto){
		try{			
			Object objNuevo=null;
			if(objetoOrigen!=null && claseNuevoObjeto!=null){				
				String type = claseNuevoObjeto.getName();				
				objNuevo =  Class.forName(type).newInstance();
				////obtener los valores del objetoOrigen y set a objNuevo
				Field[] fields = objetoOrigen.getClass().getDeclaredFields();
				for(Field field : fields) {
	                try {
	                	if((field.getModifiers() & java.lang.reflect.Modifier.FINAL) == java.lang.reflect.Modifier.FINAL){	                	    
		                	//ES FINAL	                		
	                	}else{
		                	String fieldName = field.getName();
		                	field.setAccessible(true);
		                	Object fieldValue = field.get(objetoOrigen);
		                	//Object fieldValue = field.get(objAntiguo);
		                	Field fieldNuevo = claseNuevoObjeto.getDeclaredField(fieldName);
		                	if(fieldNuevo!=null){
		                		fieldNuevo.setAccessible(true);
		                		fieldNuevo.set(objNuevo,fieldValue);	
		                	}
	                	}	               
					} catch (IllegalArgumentException  e) {						
						e.printStackTrace();
					}	
				}									
			}
			return objNuevo;
		}catch(Exception ex){			
			ex.printStackTrace();
		}
		return null;
    }	
	public static void  showObjeto(Object objShow) {
		try{
			
			if(objShow!=null){
				//System.out.println("[INFO SYS ] INICIO SHOW CLASS::"+objShow.getClass().getSimpleName());
				Field[] fields = objShow.getClass().getDeclaredFields();
				for(Field field : fields) {
		            try {
		            	String fieldName = field.getName();
		            	field.setAccessible(true);
		            	Object fieldValue = field.get(objShow);
						//System.out.println("[INFO SYS ]  ATRIBUTO::"+fieldName +" || VALOR::"+fieldValue);
					} catch (IllegalArgumentException  e) {
						e.printStackTrace();
					}
				}
				//System.out.println("[INFO SYS ]  FIN SHOW CLASS::"+objShow.getClass().getSimpleName());
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/**Utiles fecha*/
    public static String  printDate(String pattern,Date valor){
    	if(valor!=null){
          	 SimpleDateFormat sdf = new SimpleDateFormat(pattern);          	
    		return sdf.format(valor);	        		
    	}else{
    		return null;
    	}    	
    }   
    
    
    public void setPaginable(Entidad entidad, Criteria criteria){
        if(entidad.isPaginable()){
            criteria.setFirstResult(entidad.getInicio());
            criteria.setMaxResults(entidad.getNumeroFilas());
            criteria.setFetchSize(entidad.getNumeroFilas());
        }
    }
    
    
    
    
    public void setOrdenableAsc(Entidad entidad, Criteria criteria){
        if(entidad.isOrdernable()){
            criteria.addOrder(Order.asc(entidad.getAtributoOrdenacion()));
        }
    }

    public void setOrdenableDesc(Entidad entidad, Criteria criteria){
        if(entidad.isOrdernable()){
            criteria.addOrder(Order.desc(entidad.getAtributoOrdenacion()));
        }
    }

    public void setOrdenableAtrib(Criteria criteria, String order, String ... columns){
        if(columns != null && columns.length > 0){
            List<String> list = Arrays.asList(columns);
            for(String column : list){
                if(order.equalsIgnoreCase(ORDER_ASC)){
                    criteria.addOrder(Order.asc(column));
                }else{
                    criteria.addOrder(Order.desc(column));
                }
            }
        }
    }

    public void setOrdenable(Criteria criteria, String order, List<String> list){
        if(UtilesCommons.noEsVacio(list)){
            for(String column : list){
                if(order.equalsIgnoreCase(ORDER_ASC)){
                    criteria.addOrder(Order.asc(column));
                }else{
                    criteria.addOrder(Order.desc(column));
                }
            }
        }
    }
}
