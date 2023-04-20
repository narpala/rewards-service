package com.sample.rewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.rewards.model.Users;

@Service
public class RewardsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	
	public Users getUserById(Integer userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
}
