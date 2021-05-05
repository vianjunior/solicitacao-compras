package com.junior.purchaseworkflow.dao;

import com.junior.purchaseworkflow.PurchaseEntityManager;
import com.junior.purchaseworkflow.model.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PurchaseDAO
{

	private static EntityManager em = PurchaseEntityManager.getEntityManager();

	public static void create(Purchase object) {
		try {
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public static void update(Purchase object) {
		try {
			em.getTransaction().begin();
			em.merge(object);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public static Purchase getById(long id)
	{
		Purchase purchase = em.find(Purchase.class, id);
		return purchase;
	}

	public static List<Purchase> getTasksByFilter(TypedQuery<Purchase> typedQuery)
	{
		List<Purchase> purchases = typedQuery.getResultList();
		return purchases;
	}
}
