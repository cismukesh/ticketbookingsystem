package com.cinematicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinematicket.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

	@Query(value = "Select * from user where email=:email and password=:password", nativeQuery = true)
	User findByEmailAndPassword(@Param(value = "email") String email,@Param(value = "password") String password);
	
	@Query(value = "Select MD5(:password )", nativeQuery = true)
	public String encryptPassword(@Param(value = "password") String password);
}
