package com.skillacademy.offerpurchase.utils;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import javax.inject.Named;


@Named
public class VariableResolver {

	public boolean getBool(final DelegateExecution execution, final String variableName){
		return (Boolean)execution.getVariable(variableName);
	}

}
