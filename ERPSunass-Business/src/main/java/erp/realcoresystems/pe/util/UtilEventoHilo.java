package erp.realcoresystems.pe.util;



public class UtilEventoHilo  extends Thread{

	// Evento seleccion PREGUNTA
	public AccionEventoHilo accionEventoHilo;
	private String codigoHilo;
	private boolean eventoHecho;
	
    public UtilEventoHilo(String codigoHilo,AccionEventoHilo accionEventoHilo)
    {
        this.codigoHilo = codigoHilo;
        this.accionEventoHilo = accionEventoHilo;
        this.eventoHecho = false;
    }
	
    public void run()
    {
        //ACCION
    	if(accionEventoHilo!=null){
    		accionEventoHilo.retornoEvento(codigoHilo,this);	
    	}    	
    }
    
    
    /********/
	public interface AccionEventoHilo {
		public void retornoEvento(String codigoHilo, UtilEventoHilo hiloSelf);
	}


	public AccionEventoHilo getAccionEventoHilo() {
		return accionEventoHilo;
	}

	public void setAccionEventoHilo(AccionEventoHilo accionEventoHilo) {
		this.accionEventoHilo = accionEventoHilo;
	}

	public String getCodigoHilo() {
		return codigoHilo;
	}

	public void setCodigoHilo(String codigoHilo) {
		this.codigoHilo = codigoHilo;
	}

	public boolean isEventoHecho() {
		return eventoHecho;
	}

	public void setEventoHecho(boolean eventoHecho) {
		this.eventoHecho = eventoHecho;
	}
	
}
