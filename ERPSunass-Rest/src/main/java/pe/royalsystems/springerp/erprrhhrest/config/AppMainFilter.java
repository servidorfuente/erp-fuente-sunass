package erp.realcoresystems.pe.erprrhhrest.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppMainFilter /*implements Filter*/ {

    //@Value("${frontend.server}")
    private String frontendServer = "localhost";

    //@Value("${frontend.port}")
    private String frontendPort = "8102";
    
    private List<String> allowedOrigins = null;
    private String mode = "DENY";
    
    
	//@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//@Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

//        String port = (frontendPort!=null && !frontendPort.equals("")) ?   ":" + frontendPort : "";
//
//        String frontendUrl = "http://" + frontendServer + port;
//
//        //this.allowedOrigins = Arrays.asList( frontendUrl,   "http://localhost:4200");
//
//        // Lets make sure that we are working with HTTP (that is, against HttpServletRequest and HttpServletResponse objects)
//        if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
//            HttpServletRequest request = (HttpServletRequest) req;
//            HttpServletResponse response = (HttpServletResponse) res;            
//            System.out.println("#######localname::::"+req.getLocalName());
//            System.out.println("#######getMethod::::"+request.getMethod());
//            System.out.println("#######getLocalAddr::::"+request.getLocalAddr());
//            
//
//            response.setHeader("Access-Control-Allow-Origin", frontendUrl);
//
//            
//            response.setHeader("Vary", "Origin");
//            response.setHeader("X-FRAME-OPTIONS", mode );
//            //response.setHeader(" X-Frame-Options", mode );
//           
//            // Access-Control-Max-Age
//            response.setHeader("Access-Control-Max-Age", "3600");
//
//            // Access-Control-Allow-Credentials
//            response.setHeader("Access-Control-Allow-Credentials", "true");
//
//            // Access-Control-Allow-Methods
//            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//
//            // Access-Control-Allow-Headers
//            response.setHeader("Access-Control-Allow-Headers",
//                    "Origin, Authorization, X-Requested-With, Content-Type, Accept");
//
//            if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//                response.setStatus(HttpServletResponse.SC_OK);
//            } else {
//                chain.doFilter(req, res);
//            }                        
        //}
	
		chain.doFilter(req, res);

    }

	//@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
