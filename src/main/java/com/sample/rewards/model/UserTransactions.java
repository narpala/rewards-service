package com.sample.rewards.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserTransactions extends Reward {
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Users user;
	private Double total_amount;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transaction_date;

	public UserTransactions() {
		super();
	}

	public UserTransactions(Long id, Users user, Double total, String description, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.total_amount = total;
		this.description = description;
		this.transaction_date = date;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Long getPoints() {
		this.points = 0l;

		if (this.total_amount > 50 && this.total_amount <= 100) {
			this.points += (this.total_amount.intValue() - 50) * 1;

		}

		if (this.total_amount > 100) {
			// 2 points for every dollar spent over $100
			this.points += (this.total_amount.intValue() - 100) * 2;
			// 1 point for every dollar spent over $50
			this.points += 50;
		}

		return this.points;
	}

	@Override
	public String toString() {
		return String.format("UserTransactions [id=%s, user=%s, total=%s, description=%s, transaction_date=%s]", id, user,
				total_amount, description, transaction_date);
	}

}
