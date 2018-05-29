package com.skillacademy.offerpurchase;

import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.skillacademy.offerpurchase.externalServices.CustomerService;

@Named
public class ReadCustomerServiceTask implements JavaDelegate {

	private static final Logger LOGGER = Logger.getLogger(ReadCustomerServiceTask.class.getSimpleName());

	@EJB
	private CustomerService customerService;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("processing " + ReadCustomerServiceTask.class.getSimpleName());

		// get INPUT from variables
		String customerId = (String)execution.getVariable("customer.id");
		LOGGER.info("reading customer with id " + customerId);

		// create customer by calling external service
		Customer customer = customerService.readExistingCustomer(customerId);;
		LOGGER.info("read customer with id  " + customerId + ": " +  customer );

		// persist customer to OUTPUT variable
		execution.setVariable("customer", (customer));

	}


	public String generateId(){
		// TODO improve id generation
		return "K" + (new Random().nextInt(900) + 100);
	}
}
