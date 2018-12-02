package erp.realcoresystems.pe.commons.service;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import erp.realcoresystems.pe.commons.model.Email;

//@Local(IEmailServlet.class)  
//@Singleton 
//@Startup 
public class EmailServiceJB{
	
    public static final Logger log = Logger.getLogger(EmailServiceJB.class.getName());  
    public static final String EMAIL_SESSION_JNDI_PATH = "java:/Mail";  
      
      
    @Resource(name = "java:/Mail")  
    private Session mailSession;  
  
  
 @Resource(name = "java:/OtherMailSession")  
    private Session otherSession;  
      
      
    @PostConstruct  
    public void start() throws Exception {  
    }  
  
    @PreDestroy  
    public void destroy(){  
    }  
      
    //*****************[interface methods]***************/		   
     
    public boolean sendMail(Email email){  
        try{  
        	MimeMessage m = new MimeMessage(getEmailSession());
        	
        	////System.out.println("ETST EMAIL::"+mailSession.getProperties());
        	if(email!=null){
            	/*String Correo = correos[0];
                InternetAddress[] to = new InternetAddress[] {  
                        new InternetAddress(Correo),  
                        new InternetAddress("araucovillar@gmail.com")//备份一份！  
                };*/  
        		String[] correos = email.getTotalCorreoDestinos();
        		if(correos!=null){
                	InternetAddress[] to = new InternetAddress[correos.length] ;
                    for(int i=0;i< correos.length;i++){
                    	to[i] = new InternetAddress(correos[i]);
                    }                    
                    m.setRecipients(Message.RecipientType.TO, to);  
                    m.setSubject(email.getSubject());  
                    m.setSentDate(email.getCorreoFecha());  
                    m.setText(email.getBody(), "utf-8", "html");                    
                    
                    //  
                    Transport.send(m);  
                    //  
                    return true;  	        			
        		}
        	}
        }catch(Exception e){  
            e.printStackTrace();  
            return false;  
        }  
        return false;  
    }        
    /*private Session getEmailSession() throws Exception{  
        return mailSession;  
    } */   
    private Session getEmailSession() throws Exception{  
        InitialContext context = new InitialContext();  
        return (Session) context.lookup(EMAIL_SESSION_JNDI_PATH);  
    }     
    
}
