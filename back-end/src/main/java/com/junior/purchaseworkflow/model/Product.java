package com.junior.purchaseworkflow.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product
{
	private long productId;
	private String description;
	private BigDecimal price;

	public Product()
	{
	}

	public Product(long productId, String description, BigDecimal price)
	{
		this.productId = productId;
		this.description = description;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	@Column(name="description")
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Column(name="price")
	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
}
