package com.prs.business;

import javax.persistence.*;

@Entity
@Table(name = "LineItems")
public class LineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="requestID")
	private Request request;
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;
	private int quantity;
	
	public LineItem() {
		super();
	}

	public LineItem(int id, Request request, Product product, int quantity) {
		super();
		this.id = id;
		this.request = request;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}