package com.skillacademy.offerpurchase;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class isNewCustomerGateway implements JavaDelegate{

	private final static Logger LOGGER = Logger.getLogger(isNewCustomerGateway.class.getSimpleName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("processing gateway " + isNewCustomerGateway.class.getSimpleName());
		String customerId = (String) execution.getVariable("customer.id");
		LOGGER.info("provided customer-id: " + customerId);
		boolean result;
		if( customerId == null || customerId.trim().isEmpty() ){
			result = true;
		}else{
			result = false;
		}
		execution.setVariable("newCustomerResult", result);
	}
}
