package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Food;
import com.onwan.dietapp.entities.User;
import com.onwan.dietapp.repositories.FoodRepository;
import com.onwan.dietapp.repositories.UserRepository;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Food> listAllFood() {
		return foodRepo.findAll();
	}
	
	@Override
	public List<Food> findAllFoodByEmail(String email) {
		User user = userRepo.findFoodByEmail(email);
		List<Food> food;
		food = foodRepo.findByUsersId(user.getId());
		return food;
	}
	@Override
	public Food findFood(int id) {
		Food food = null;
		Optional<Food> opt = foodRepo.findById(id);
		if(opt.isPresent()) {
			food = opt.get();
		}
		return food;
	}
	@Override
	public Food addFood(String email, Food food) {
		User user = userRepo.findUserByEmail(email);
		if (user != null) {
			food.addUser(user);
			foodRepo.saveAndFlush(food);
		} else {
			food = null;
		}
		return food;
	}
	
//	@Override
//	public Food updateFood(String email, int foodId, Food food) {
//		Food updateFood = foodRepo.findByUser_EmailAndId(email, foodId);
//		if(updateFood != null) {
//			updateFood.setName(food.getName());
//			updateFood.setDescription(food.getDescription());
//			updateFood.setPortionSize(food.getPortionSize());
//			updateFood.setPortionType(food.getPortionType());
//			updateFood.setCalorie(food.getCalorie());
//			updateFood.setFat(food.getFat());
//			updateFood.setCholestrol(food.getCholestrol());
//			updateFood.setSodium(food.getSodium());
//			updateFood.setCarbohydrate(food.getCarbohydrate());
//			updateFood.setFiber(food.getFiber());
//			updateFood.setSugar(food.getSugar());
//			updateFood.setProtein(food.getProtein());
//			foodRepo.saveAndFlush(updateFood);
//		}
//		return updateFood;
//	}
}
