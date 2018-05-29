package com.skillacademy.offerpurchase.externalServices;

import java.util.Random;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.camunda.bpm.engine.delegate.BpmnError;

import com.skillacademy.offerpurchase.Customer;

@Stateless
public class CustomerService {

	@PersistenceContext
	private EntityManager entitManager;

	public Customer createNewCustomer(String firstName, String name){
		Customer customer = new Customer(firstName, name);
		entitManager.persist(customer);
		String id = generateId();
		customer.setId(id);
		return customer;
	}

	public Customer readExistingCustomer(String id) throws Exception {
		if(id.equals("007")){
			throw new RuntimeException("couldn't find customer with id: " + id);
		}
		Customer customer = new Customer("Max", "Mustermann");
		customer.setId(id);
		entitManager.persist(customer);
		return customer;
	}

	public String generateId(){
		return "K" + (new Random().nextInt(900) + 100);
	}

}
