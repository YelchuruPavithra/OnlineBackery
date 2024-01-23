package com.anu.ecom.repository;

import com.anu.ecom.entity.User;
import com.anu.ecom.enums.UserRole;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	Optional<User> findFirstByEmail(String email);
	
	User findByRole(UserRole userRole);
}
