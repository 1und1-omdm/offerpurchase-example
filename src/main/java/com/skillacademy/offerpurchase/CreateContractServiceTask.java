package com.skillacademy.offerpurchase;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.skillacademy.offerpurchase.externalServices.ContractService;

@Named
public class CreateContractServiceTask implements JavaDelegate {

	private static final Logger LOGGER = Logger.getLogger(CreateContractServiceTask.class.getSimpleName());

	@EJB
	private ContractService contractService;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("processing " + CreateContractServiceTask.class.getSimpleName());

		// get INPUT from variables
		String productId = (String)execution.getVariable("productId");
		Customer customer = (Customer) execution.getVariable("customer");

		LOGGER.info("creating contract for customerId " + customer.getId() + " and prodcutId " + productId);

		// create contract by calling external service
		Contract contract = contractService.createNewContract(customer.getId(), productId);
		LOGGER.info("created contract with id " + contract.getId() + ": " + contract.toString());

		// persist contract to OUTPUT variable
		execution.setVariable("contract", contract);

	}



}
