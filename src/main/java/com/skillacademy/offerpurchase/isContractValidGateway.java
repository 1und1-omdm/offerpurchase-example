package com.skillacademy.offerpurchase;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class isContractValidGateway implements JavaDelegate{

	private final static Logger LOGGER = Logger.getLogger(isContractValidGateway.class.getSimpleName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("processing gateway " + isContractValidGateway.class.getSimpleName());
		Contract contract = (Contract) execution.getVariable("contract");
		LOGGER.info("provided contract: " + contract);
		boolean result;
		if( contract != null && contract.getId() != null && !contract.getId().contains("INVALID") ){
			result = true;
		}else{
			result = false;
		}
		execution.setVariable("contractValidResult", result);
	}
}
