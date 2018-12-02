package erp.realcoresystems.pe.commons.service;

public interface LogService {

	public void debug(Object message);
	public void debug(Object message, Throwable throwable);
	
	public void info(Object message);
	public void info(Object message, Throwable throwable);
	
	public void warn(Object message);
	public void warn(Object message, Throwable throwable);
	
	public void error(Object message);
	public void error(Object message, Throwable throwable);
	
	public void fatal(Object message);
	public void fatal(Object message, Throwable throwable);
	
	
}
