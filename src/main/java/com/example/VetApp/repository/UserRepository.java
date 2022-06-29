package com.example.VetApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.VetApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value="SELECT * FROM user WHERE name LIKE %:textUser%", nativeQuery=true)
	List<User> findBySearchTextUser(@Param("textUser") String textUser);
}