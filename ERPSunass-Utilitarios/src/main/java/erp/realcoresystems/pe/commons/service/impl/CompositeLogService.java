package erp.realcoresystems.pe.commons.service.impl;

import java.util.ArrayList;
import java.util.List;

import erp.realcoresystems.pe.commons.service.LogService;

public class CompositeLogService implements LogService {
	
	private List<LogService> list;
	
	public CompositeLogService() {
		list = new ArrayList<LogService>();
	}
	
	public CompositeLogService(List<LogService> list) {
		this.list = list;
	}
	
	public void setList(List<LogService> list) {
		this.list = list;
	}

	@Override
	public void debug(Object message) {
		for(LogService log : list){
			log.debug(message);
		}
	}

	@Override
	public void debug(Object message, Throwable throwable) {
		for(LogService log : list){
			log.debug(message, throwable);
		}
	}

	@Override
	public void info(Object message) {
		for(LogService log : list){
			log.info(message);
		}
	}

	@Override
	public void info(Object message, Throwable throwable) {
		for(LogService log : list){
			log.info(message, throwable);
		}
	}

	@Override
	public void warn(Object message) {
		for(LogService log : list){
			log.warn(message);
		}
	}

	@Override
	public void warn(Object message, Throwable throwable) {
		for(LogService log : list){
			log.warn(message, throwable);
		}
	}

	@Override
	public void error(Object message) {
		for(LogService log : list){
			log.error(message);
		}
	}

	@Override
	public void error(Object message, Throwable throwable) {
		for(LogService log : list){
			log.error(message, throwable);
		}
	}

	@Override
	public void fatal(Object message) {
		for(LogService log : list){
			log.fatal(message);
		}
	}

	@Override
	public void fatal(Object message, Throwable throwable) {
		for(LogService log : list){
			log.fatal(message, throwable);
		}
	}

}
