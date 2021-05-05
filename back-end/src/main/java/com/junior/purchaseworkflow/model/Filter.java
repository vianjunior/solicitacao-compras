package com.junior.purchaseworkflow.model;

public class Filter
{
	private String requesterName;
	private String product;
	private String position;
	private String approved;

	public String getRequesterName()
	{
		return requesterName;
	}

	public void setRequesterName(String requesterName)
	{
		this.requesterName = requesterName;
	}

	public String getProduct()
	{
		return product;
	}

	public void setProduct(String product)
	{
		this.product = product;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String status)
	{
		this.position = status;
	}

	public String getApproved()
	{
		return approved;
	}

	public void setApproved(String approved)
	{
		this.approved = approved;
	}
}
