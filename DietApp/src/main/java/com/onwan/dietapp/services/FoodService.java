package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Food;

public interface FoodService {

	List<Food> listAllFood();

	List<Food> findAllFoodByEmail(String email);

	Food findFood(int id);

	Food addFood(String email, Food food);

//	Food updateFood(String email, int foodId, Food food);

}
