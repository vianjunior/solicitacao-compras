package com.junior.purchaseworkflow;

import javax.persistence.EntityManager;

public class PurchaseEntityManager
{
	private static EntityManager entityManager = PurchaseWorkflow
		.getEntityManagerFactory().createEntityManager();

	public static EntityManager getEntityManager()
	{
		return entityManager;
	}
}
