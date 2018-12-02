package erp.realcoresystems.pe.commons.service.impl;

import org.jboss.logging.Logger;

import erp.realcoresystems.pe.commons.service.LogService;

public class JbossLogService implements LogService {

	private static final Logger LOGGER = Logger.getLogger(JbossLogService.class);

	@Override
	public void debug(Object message) {
		LOGGER.debug(message);
	}

	@Override
	public void debug(Object message, Throwable throwable) {
		LOGGER.debug(message);
	}

	@Override
	public void info(Object message) {
		LOGGER.info(message);
	}

	@Override
	public void info(Object message, Throwable throwable) {
		LOGGER.info(message, throwable);
	}

	@Override
	public void warn(Object message) {
		LOGGER.warn(message);
	}

	@Override
	public void warn(Object message, Throwable throwable) {
		LOGGER.warn(message, throwable);
	}

	@Override
	public void error(Object message) {
		LOGGER.error(message);
	}

	@Override
	public void error(Object message, Throwable throwable) {
		LOGGER.error(message, throwable);
	}

	@Override
	public void fatal(Object message) {
		LOGGER.fatal(message);
	}

	@Override
	public void fatal(Object message, Throwable throwable) {
		LOGGER.fatal(message, throwable);
	}
	
}
