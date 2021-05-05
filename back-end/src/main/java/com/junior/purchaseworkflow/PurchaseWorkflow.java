package com.junior.purchaseworkflow;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/server")
public class PurchaseWorkflow extends ResourceConfig {

	public PurchaseWorkflow() {
		packages("com.junior.purchaseworkflow.rest");
	}

	private static EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory("PurchaseDB");

	public static EntityManagerFactory getEntityManagerFactory()
	{
		return entityManagerFactory;
	}
}
