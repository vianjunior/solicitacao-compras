package com.junior.purchaseworkflow.rest;

import com.junior.purchaseworkflow.model.Purchase;
import com.junior.purchaseworkflow.service.PurchaseWorkflowService;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("rest")
public class PurchaseWorkflowREST
{
	private static final PurchaseWorkflowService service = new PurchaseWorkflowService();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response create(String purchase) {

		JSONObject retorno = new JSONObject();
		try
		{
			retorno.put("retorno", service.create(purchase));
			return Response.ok(retorno.toString()).build();
		}
		catch (Exception e)
		{
			return Response.serverError().status(500).build();
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response update(String purchase) {

		JSONObject retorno = new JSONObject();
		try
		{
			retorno.put("retorno", service.update(purchase));
			return Response.ok(retorno.toString()).build();
		}
		catch (Exception e)
		{
			return Response.serverError().status(500).build();
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTasks")
	public List<Purchase> getPendingTasks(String filterParams) {

		List purchases = service.getTasks(filterParams);
		return purchases;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTaskById")
	public Purchase getTaskById(@QueryParam("id") Long id) {

		Purchase purchase = service.getTaskById(id);
		return purchase;

	}

}
