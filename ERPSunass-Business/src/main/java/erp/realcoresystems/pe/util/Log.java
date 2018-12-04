package erp.realcoresystems.pe.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.jboss.logging.Logger;

public class Log {
	
	public static final Logger logger = Logger.getLogger(Log.class);

	public static String getStackTrace(Exception e) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		e.printStackTrace(pWriter);
		return sWriter.toString();
	}
	
	public static String printStackTrace(Throwable e) {
		try {
			StringWriter sWriter = new StringWriter();
			PrintWriter pWriter = new PrintWriter(sWriter);
			e.printStackTrace(pWriter);
			return sWriter.toString();
		} catch (Exception e2) {
			return "";
		}
	}
	
	public static void error(Exception e, String metodo) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		e.printStackTrace();
		if(metodo != null){
			logger.error(metodo);
		}
		e.printStackTrace(pWriter);
		logger.error(sWriter.toString());
	}
	
	public static void info(Exception e, String metodo) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		if(metodo != null){
			logger.error(metodo);
		}
		e.printStackTrace(pWriter);
		logger.error(sWriter.toString());
	}
	
	public static void debug(Exception e, String metodo) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		if(metodo != null){
			logger.error(metodo);
		}
		e.printStackTrace(pWriter);
		logger.error(sWriter.toString());
	}
	
}
