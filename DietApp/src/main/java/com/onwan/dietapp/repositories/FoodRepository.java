package com.onwan.dietapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> findByUsersId(int id);

//	Food findByUsersId_Users_FoodIdAndId(String email, int foodId);
	
}