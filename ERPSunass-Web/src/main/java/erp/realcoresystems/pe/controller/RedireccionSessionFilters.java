package erp.realcoresystems.pe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PreDestroy;

import javax.faces.context.FacesContext;

import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



public class RedireccionSessionFilters implements Serializable,HttpSessionBindingListener,HttpSessionListener  {
	

 	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
			//System.out.println("[SYS INFO::LOG: ]"+chain);
		    HttpServletRequest req=(HttpServletRequest)request;
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(false);
		    
		    if(session != null && !session.isNew()) {
		    	//System.out.println("[SYS INFO::LOG:AAAAAAAAAAA ]");
		    	chain.doFilter(request, response);
		    }else{
		    	//System.out.println("[SYS INFO::LOG:BBBBBBBBBB ]");
		    	req.getRequestDispatcher("/login.xhtml").forward(request, response);
		    }
		    /*
		    //check if "role" attribute is null
		    if(req.getSession().getAttribute("role")==null) {
		        //forward request to login.jsp
		        req.getRequestDispatcher("/login.xhtml").forward(request, response);
		    } else {
		        chain.doFilter(request, response);
		    }*/	
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
		//System.out.println("[INFO SYS :AAAAAAAAAAAAAAA::SESSION valueBound]"+event);
	}
	 public void registerSession() {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "sessionBindingListener", this  );
	        //System.out.println("[INFO SYS :BBBBBBBBBBBB::SESSION registerSession]");
	 }
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//System.out.println("[INFO SYS :CCCCCCCCCCCCC::SESSION valueUnbound]"+event.getSession().getId());
		
		
	}

    @PreDestroy  
    public void destroy(){
    	//System.out.println("[INFO SYS :XXXXXXXXXXXXX::SESSION destroy]");
    } 
    
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		try{
			//System.out.println("[INFO SYS :MMMMMMMMMMMM::SESSION PRE sessionCreated]"+se.getSession().getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		try{
			//System.out.println("[INFO SYS :NNNNNNNNNNNN::SESSION PRE sessionDestroyed]"+se);
			//Utiles.CURRENT_CONTEXTAUX.execute("parent.PrimeFaces.closeDialog({pfdlgcid:'" + pfdlgcid + "'});");		
			HttpSession session = se.getSession();		 
			/*if(Utiles.CURRENT_CONTEXTAUX!=null){
				Utiles.CURRENT_CONTEXTAUX.execute("dialog.hide();");
				//System.out.println("[INFO SYS :NNNNNNNNNNNN::SESSION POST sessionDestroyed]"+se);
			}*/
		}catch(Exception ex){
			ex.printStackTrace();
		}		
	}


}
