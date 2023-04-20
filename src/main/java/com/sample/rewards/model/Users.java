package com.sample.rewards.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserTransactions> transactions;
	@JsonInclude
	@Transient
	private Long rewardPoints;
	@JsonInclude
	@Transient
	private Double totalPurchases;

	public Users() {
		super();
	}

	public Users(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserTransactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<UserTransactions> transactions) {
		this.transactions = transactions;
	}

	public Long getRewardPoints() {
		if (transactions == null || transactions.isEmpty())
			return 0l;

		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a, b) -> a + b).longValue();
	}

	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty())
			return 0d;

		return transactions.stream().map(x -> x.getTotal_amount().doubleValue()).reduce(0d, (a, b) -> a + b).doubleValue();
	}

}
