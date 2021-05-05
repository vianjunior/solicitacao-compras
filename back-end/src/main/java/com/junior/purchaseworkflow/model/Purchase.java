package com.junior.purchaseworkflow.model;

import javax.persistence.*;

@Entity
@Table(name="Purchase")
public class Purchase
{
	private long purchaseId;
	private String requesterName;
	private Product product;
	private String position;
	private String approval;
	private String startDate;
	private String finishDate;

	public Purchase()
	{
	}

	public Purchase(long purchaseId, String requesterName, Product product, String position,
		String approval, String startDate, String finishDate)
	{
		this.purchaseId = purchaseId;
		this.requesterName = requesterName;
		this.product = product;
		this.position = position;
		this.approval = approval;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="purchaseId")
	public long getPurchaseId()
	{
		return purchaseId;
	}

	public void setPurchaseId(long purchaseId)
	{
		this.purchaseId = purchaseId;
	}

	@Column(name="requesterName")
	public String getRequesterName()
	{
		return requesterName;
	}

	public void setRequesterName(String requesterName)
	{
		this.requesterName = requesterName;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="productId")
	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	@Column(name="position")
	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	@Column(name="approval")
	public String getApproval()
	{
		return approval;
	}

	public void setApproval(String approval)
	{
		this.approval = approval;
	}

	@Column(name="startDate")
	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	@Column(name="finishDate")
	public String getFinishDate()
	{
		return finishDate;
	}

	public void setFinishDate(String finishDate)
	{
		this.finishDate = finishDate;
	}
}