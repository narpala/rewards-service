package com.sample.rewards.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.rewards.model.UserTransactions;
import com.sample.rewards.model.Users;

@Service
public class RewardsServiceMock {

	private static List<UserTransactions> transactions = new ArrayList<UserTransactions>();
	private static long index;

	static {

		transactions.add(new UserTransactions(index++, new Users(1, "Pradeep"), 100.0, "Item 1", new Date()));
		transactions.add(new UserTransactions(index++, new Users(2, "Reddy"), 50.0, "Item 2", new Date()));
		transactions.add(new UserTransactions(index++, new Users(3, "Narpala"), 120.0, "Item 3", new Date()));

	}

	public List<UserTransactions> getAll() {
		return transactions;
	}

}