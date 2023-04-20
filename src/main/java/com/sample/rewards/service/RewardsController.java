package com.sample.rewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rewards.model.Users;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RewardsController {

	@Autowired
	private RewardsService rewardsService;

	@GetMapping("/users")
	public List<Users> findUsersAll() {
		return rewardsService.getUsers();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getUser(@PathVariable Integer id) {
		Users user = rewardsService.getUserById(id);
		if (user == null)
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

}
