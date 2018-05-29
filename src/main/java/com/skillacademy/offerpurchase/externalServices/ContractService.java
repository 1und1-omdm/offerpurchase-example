package com.skillacademy.offerpurchase.externalServices;

import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.skillacademy.offerpurchase.Contract;

@Stateless
public class ContractService {

	@PersistenceContext
	private EntityManager entitManager;

	public Contract createNewContract(String customerId, String productId){
		Contract contract = new Contract(customerId, productId);
		if(productId.equals("P004")){
			contract.setId("INVALID");
		}else{
			String id = generateId();
			contract.setId(id);
		}


		entitManager.persist(contract);
		return contract;
	}


	public Contract find(int id){
		return entitManager.find(Contract.class, id);
	}

	public String generateId(){
		return "V" + (new Random().nextInt(900) + 100);
	}


}
