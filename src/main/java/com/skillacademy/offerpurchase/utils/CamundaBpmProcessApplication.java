package com.skillacademy.offerpurchase.utils;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInterface;
import org.camunda.bpm.application.impl.EjbProcessApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;

/*
 * This class is used for bootstrapping the container managed process engine
 * and automatic deployment of BPMN2.0 resources.
 */
@Singleton
@Startup
@ProcessApplication() // defines the default folder for the *.bpmn file
@Local(ProcessApplicationInterface.class)
public class CamundaBpmProcessApplication extends EjbProcessApplication {
	protected Map<String, String> properties = new HashMap();

	public CamundaBpmProcessApplication() {
		// this property is need so that ":app" in the form-key can be correctly resolved.
		properties.put("servletContextPath","/offerpurchase-example/");
	}

	@PostConstruct
	public void start() {
		this.deploy();
	}

	@PreDestroy
	public void stop() {
		this.undeploy();
	}

	public Map<String, String> getProperties() {
		return this.properties;
	}
}