package erp.realcoresystems.pe.commons.service.impl;

import erp.realcoresystems.pe.commons.service.LogService;

public class ConsoleLogService implements LogService {
	
	private static final String INFO = "INFO";
	private static final String DEBUG = "DEBUG";
	private static final String ERROR = "ERROR";
	private static final String WARN = "WARN";
	private static final String FATAL = "FATAL";
	
	@Override
	public void debug(Object message) {
		System.out.println(DEBUG+": "+message);
	}

	@Override
	public void debug(Object message, Throwable throwable) {
		debug(message);
		throwable.printStackTrace();
	}

	@Override
	public void info(Object message) {
		System.out.println(INFO+": "+message);
	}

	@Override
	public void info(Object message, Throwable throwable) {
		info(message);
		throwable.printStackTrace();
	}

	@Override
	public void warn(Object message) {
		System.out.println(WARN+": "+message);
	}

	@Override
	public void warn(Object message, Throwable throwable) {
		warn(message);
		throwable.printStackTrace();
	}

	@Override
	public void error(Object message) {
		System.out.println(ERROR+": "+message);
	}

	@Override
	public void error(Object message, Throwable throwable) {
		error(message);
		throwable.printStackTrace();
	}

	@Override
	public void fatal(Object message) {
		System.out.println(FATAL+": "+message);
	}

	@Override
	public void fatal(Object message, Throwable throwable) {
		fatal(message);
		throwable.printStackTrace();
	}

}
