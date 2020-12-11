package com.onwan.dietapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.log.Log;
import com.onwan.dietapp.entities.Food;
import com.onwan.dietapp.services.FoodService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost4212" })
public class FoodController {

	@Autowired
	private FoodService foodSvc;
	
	@GetMapping("foods")
	public List<Food> listAllFoods(HttpServletResponse resp) {
		List<Food> foods = foodSvc.listAllFood();
		if (foods == null) {
			resp.setStatus(404);
		}
		return foods;
	}

	@GetMapping("food")
	public List<Food> listAllMyFood(HttpServletResponse resp, Principal principal) {
		List<Food> foods = foodSvc.findAllFoodByEmail(principal.getName());
		if (foods != null && foods.size() == 0) {
			resp.setStatus(204);
		}
		if (foods == null) {
			resp.setStatus(404);
		}
		return foods;
	}

	@GetMapping("foods/{foodId}")
	public Food show(@PathVariable("foodId") int id, HttpServletRequest req, HttpServletResponse resp) {
		Food food = foodSvc.findFood(id);
		if (food == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}
		return food;
	}

	@PostMapping("food/user")
	public Food create(@RequestBody Food food, Principal principal, HttpServletRequest req, HttpServletResponse res) {
		try {
			food = foodSvc.addFood(principal.getName(), food);
			if (food == null) {
				res.setStatus(401);
			} else {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(food.getId());
				res.addHeader("Location", url.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(500);
			food = null;
		}
		return food;
	}
//	@PutMapping("food/user/{foodId")
//	public Food updateFood(@PathVariable int foodId, @RequestBody Food food, Principal principal, HttpServletRequest req, HttpServletResponse resp) {
//		try {
//			food = foodSvc.updateFood(principal.getName(), foodId, food);
//			if(food == null) {
//				resp.setStatus(404);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			resp.setStatus(400);
//			food = null;
//		}
//		return food;
//	}
}