package com.junior.purchaseworkflow.service;

import com.google.gson.Gson;
import com.junior.purchaseworkflow.PurchaseEntityManager;
import com.junior.purchaseworkflow.dao.PurchaseDAO;
import com.junior.purchaseworkflow.model.Filter;
import com.junior.purchaseworkflow.model.Product;
import com.junior.purchaseworkflow.model.Purchase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import org.json.JSONObject;

public class PurchaseWorkflowService
{

	private static EntityManager em = PurchaseEntityManager.getEntityManager();
	public static PurchaseDAO purchaseDAO = new PurchaseDAO();

	public static JSONObject create(String purchaseJson) {

		Gson gson = new Gson();
		Purchase purchase = gson.fromJson(purchaseJson, Purchase.class);

		purchaseDAO.create(purchase);

		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "OK");

		return retorno;
	}

	public static JSONObject update(String purchaseJson) {

		Gson gson = new Gson();
		Purchase purchase = gson.fromJson(purchaseJson, Purchase.class);

		purchaseDAO.update(purchase);

		JSONObject retorno = new JSONObject();
		retorno.put("retorno", "OK");

		return retorno;
	}

	public static List<Purchase> getTasks(String filterParams) {

		CriteriaQuery<Purchase> criteriaQuery = createQuery(filterParams);

		TypedQuery<Purchase> typedQuery = em.createQuery(criteriaQuery);
		List<Purchase> purchases = purchaseDAO.getTasksByFilter(typedQuery);

		return purchases;
	}

	public static Purchase getTaskById(Long id) {

		return purchaseDAO.getById(id);
	}

	/**
	 * Método que monta o filtro para realizar a consulta de registros no banco
	 */
	private static CriteriaQuery<Purchase> createQuery(String filterParams) {
		Gson gson = new Gson();
		Filter filter = gson.fromJson(filterParams, Filter.class);
		String requesterName = filter.getRequesterName();
		String product = filter.getProduct();
		String position = filter.getPosition();
		String approval = filter.getApproved();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);
		Predicate predicate = criteriaBuilder.and();
		Root<Purchase> root = criteriaQuery.from(Purchase.class);
		criteriaQuery.select(root);

		if (!requesterName.isBlank() && !requesterName.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
				criteriaBuilder.lower(root.get("requesterName")),
				"%"+requesterName+"%"));
		}

		if (!product.isBlank() && !product.isEmpty()) {
			Join<Purchase, Product> join = root.join("product");
			Path<String> description = join.get("description");

			predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
				criteriaBuilder.lower(description), "%"+product+"%"));
		}

		if (!position.isBlank() && !position.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(
				root.get("position"), position));
		}

		if (!approval.isBlank() && !approval.isEmpty()) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(
				root.get("approval"), approval));
		}

		criteriaQuery.where(predicate);

		return criteriaQuery;
	}
}