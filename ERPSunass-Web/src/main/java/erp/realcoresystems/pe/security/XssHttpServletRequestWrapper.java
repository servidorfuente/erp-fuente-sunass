package erp.realcoresystems.pe.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.FacesUtil;

/**
 * Aquiles MH:
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if(values == null) {
			return null;
		}
		int count = values.length;
		String[] encodeValues = new String[count];
		for(int i=0; i < count; i++){
			encodeValues[i] = cleanXss(values[i]);
		}
		return encodeValues;
	}
	
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(null == value) {
			return null;
		}
		return cleanXss(value);
	}
	
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if(null == value) {
			return null;
		}
		return cleanXss(value);
	}

	private String cleanXss(String value) {
		boolean aplicaFiltroXss = true;
		String conceptoEvitarFiltXss = FacesUtil.getPropertyParametros("PAR_FORM_EVITAR_FILTROSXSS_01");
		String seleccionActual = "";
		if(EntityGlobal.getInstance()!=null){				
			seleccionActual = ""+EntityGlobal.getInstance().getGrupoActual()+
					"-"+EntityGlobal.getInstance().getConceptoActual()
					;			
			if(seleccionActual.equals(conceptoEvitarFiltXss)){
				aplicaFiltroXss=false;
			}			
		}		
		if(aplicaFiltroXss){
			value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");  
	        //value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");  
	        value = value.replaceAll("'", "& #39;");
			value = value.replaceAll("--", "");
			value = value.replaceAll("%", "");
			value = value.replaceAll(";", "");
	        value = value.replaceAll("eval\\((.*)\\)", "");
	        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");  
	        value = value.replaceAll("script", "");




  /*

   * This signature first looks out for the = sign or its hex equivalent (%3D).
   * It then allows for zero or more non-newline characters,
   * and then it checks for the single-quote, the double-dash or the semi-colon.
   * Detect either the hex equivalent of the single-quote, the single-quote itself or
   * the presence of the double-dash. These are SQL characters for MS SQL Server and Oracle,
   * which denote the beginning of a comment, and everything that follows is ignored.
   * See more info at
   * http://www.symantec.com/connect/articles/detection-sql-injection-and-cross-site-scripting-attacks
   * Regex for detecting SQL Injection meta-characters
   */

			value = value.replaceAll("/((\\%3D)|(=))[^\\n]*((\\%27)|(\')|(\\-\\-)|(\\%3B)|(;))/i","");



  /*

   * Regex for detecting SQL Injection with the UNION keyword
   *
   * (\%27)|(\') - the single-quote and its hex equivalent
   union - the keyword union
   */

			value = value.replaceAll("/((\\%27)|(\'))union/ix","");

  /*

   *

   * A typical SQL injection attempt of course revolves around the use of the single quote
   * to manipulate the original query so that it always results in a true value.
   *  Most of the examples that discuss this attack use the string 1'or'1'='1.
   *  However, detection of this string can be easily evaded by supplying a value
   *  such as 1'or2>1--. Thus the only part that is constant in this is the initial
   *  alphanumeric value, followed by a single-quote, and then followed by the word 'or'.
   *  The Boolean logic that comes after this may be varied to an extent where a generic pattern
   *  is either very complex or does not cover all the variants. Thus these attacks can be detected to a fair
   *  degree of accuracy by using the next regular expression
   *
   *  Regex for typical SQL Injection attack

   *  /\w*((\%27)|(\'))((\%6F)|o|(\%4F))((\%72)|r|(\%52))/ix

   */

			value = value.replaceAll("/\\w*((\\%27)|(\\'))((\\%6F)|o|(\\%4F))((\\%72)|r|(\\%52))/ix","");



			//checking for the keywords and a combination of quotes with conjunctions and quotes with double pipe (||)

			value = value.replaceAll("insert|update|delete|having|drop|(\'|%27).(and|or).(\'|%27)|(\'|%27).%7C{0,2}|%7C{2}","");



			//Regex for "<img src" CSS attack

			value = value.replaceAll("/((\\%3C)|<)((\\%69)|i|(\\%49))((\\%6D)|m|(\\%4D))((\\%67)|g|(\\%47))[^\n]+((\\%3E)|>)/I","");



		}	 
		return value;
	}

}
