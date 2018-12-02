package erp.realcoresystems.pe.service.impl;

import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


public abstract class AbstractServiceImpl{
	
	public void rollback(){
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	
	public void exception(Throwable error){
		error.printStackTrace();
	}
	
	public void rollback(Throwable error){
		exception(error);
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	
	public <E> List<E> getNewList(){
		return UtilesCommons.getNewList();
	}
}
