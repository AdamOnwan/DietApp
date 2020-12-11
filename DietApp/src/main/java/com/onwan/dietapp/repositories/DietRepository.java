package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Diet;

public interface DietRepository extends JpaRepository<Diet, Integer> {

	Diet findByUsersId(int id);
	
	List<Diet> findByUsersEmail(String email);
}