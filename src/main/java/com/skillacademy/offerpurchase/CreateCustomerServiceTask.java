package com.skillacademy.offerpurchase;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.ejb.EJB;
import javax.inject.Named;
import java.util.Random;
import java.util.logging.Logger;

import com.skillacademy.offerpurchase.externalServices.CustomerService;

@Named
public class CreateCustomerServiceTask implements JavaDelegate {

	private static final Logger LOGGER = Logger.getLogger(CreateCustomerServiceTask.class.getSimpleName());

	@EJB
	private CustomerService customerService;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("processing " + CreateCustomerServiceTask.class.getSimpleName());

		// get INPUT from variables
		String name = (String)execution.getVariable("customer.name");
		String firstName = (String)execution.getVariable("customer.firstname");

		LOGGER.info("creating: " + firstName + " "  + name);

		// create customer by calling external service
		Customer customerResult = customerService.createNewCustomer(firstName, name);
		LOGGER.info("created customer with id " + customerResult.getId() + ": " + customerResult.toString());

		// persist customer to OUTPUT variable
		execution.setVariable("customer", (customerResult));

	}



}
