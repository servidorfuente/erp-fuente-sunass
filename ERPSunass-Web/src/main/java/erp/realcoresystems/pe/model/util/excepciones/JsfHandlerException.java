package erp.realcoresystems.pe.model.util.excepciones;

import erp.realcoresystems.pe.service.NegocioExcepciones;
import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Log;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.io.IOException;
import java.util.Iterator;

public class JsfHandlerException extends ExceptionHandlerWrapper{

	private ExceptionHandler wrapped;
	//private static Log log = LogFactory.getLog(JsfHandlerException.class);
	
	public JsfHandlerException(ExceptionHandler wrapped){
		this.wrapped = wrapped;
	}
	
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		
		Iterator<ExceptionQueuedEvent> eventos = getUnhandledExceptionQueuedEvents().iterator();
		while(eventos.hasNext()){
			ExceptionQueuedEvent evento = eventos.next();
			ExceptionQueuedEventContext contexto = (ExceptionQueuedEventContext)evento.getSource();
			
			Throwable excepcion = contexto.getException();
			
			NegocioExcepciones negocioExcepciones = getNegocioExcepciones(excepcion);
			
			boolean handled = false;
			
			try {
				if(excepcion instanceof ViewExpiredException){
					handled = true;
					redireccionar("/");
				}else if(negocioExcepciones!=null){
					handled = true;
					//Log .error("Error del sistema: " + excepcion.getMessage(), excepcion);
					Log.logger.info("TIPO ERROR ********* " + excepcion.getMessage() + " **************");
					Log.logger.info("" + excepcion);
					Log.logger.info(Log.printStackTrace(excepcion));
					FacesUtil.adicionarMensajeError(negocioExcepciones.getMessage());
				}else{
					handled = true;
					//log.error("Error del sistema: " + excepcion.getMessage(), excepcion);
					Log.logger.info("TIPO ERROR ********* " + excepcion.getMessage() + " **************");
					Log.logger.info("" + excepcion);
					Log.logger.info(Log.printStackTrace(excepcion));
					redireccionar("/excepciones/error.xhtml");
				}
			} finally {
				if(handled){
					eventos.remove();
				}
				
			}
		}
		getWrapped().handle();
	}
	
	private NegocioExcepciones getNegocioExcepciones(Throwable excepcion){
		if(excepcion instanceof NegocioExcepciones){
			return (NegocioExcepciones)excepcion;
		}else if(excepcion.getCause()!=null){
			return getNegocioExcepciones(excepcion.getCause());
		}
		return null;
	}
	
	private void redireccionar(String pagina){
		try{
			FacesContext facesContexto = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContexto.getExternalContext();
			String contextoPath = externalContext.getRequestContextPath();
			
			externalContext.redirect(contextoPath + pagina);
			facesContexto.responseComplete();
		}catch(IOException e){
			throw new FacesException(e);
		}
	}
	
}
