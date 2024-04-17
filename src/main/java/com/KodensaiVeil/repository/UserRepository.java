package com.KodensaiVeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KodensaiVeil.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByEmail(String username);
}
