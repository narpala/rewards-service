package com.sample.rewards.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.rewards.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
