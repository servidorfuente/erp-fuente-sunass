package erp.realcoresystems.pe.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Aquiles MH:
 *
 */
public class XssFilter implements Filter {
	
	FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)rep;

		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()){
			String paraName = (String) enu.nextElement();
			String value = request.getParameter(paraName);
		}		
		chain.doFilter(new XssHttpServletRequestWrapper(request), response);

	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}


	

}
