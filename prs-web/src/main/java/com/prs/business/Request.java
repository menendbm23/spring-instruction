package com.prs.business;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	@ManyToOne
	@JoinColumn(name = "UserID")
	private User user;
	private String description;
	private String justification;
	private String dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	private String submittedDate;
	private String rejectionReason;
	public Request() {
		super();
	}
	public Request(int id, User user, String description, String justification, String dateNeeded, String deliveryMode,
			String status, double total, String submittedDate, String rejectionReason) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.justification = justification;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = deliveryMode;
		this.status = status;
		this.total = total;
		this.submittedDate = submittedDate;
		this.rejectionReason = rejectionReason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(String dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

}