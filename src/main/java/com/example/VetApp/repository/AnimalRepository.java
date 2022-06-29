package com.example.VetApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.VetApp.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	@Query(value="SELECT * FROM animal WHERE name LIKE %:text%", nativeQuery=true)
	List<Animal> findBySearchText(@Param("text") String text);
}
