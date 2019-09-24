package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stockmarket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
