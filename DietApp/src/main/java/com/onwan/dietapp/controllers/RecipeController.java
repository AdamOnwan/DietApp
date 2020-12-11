package com.onwan.dietapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onwan.dietapp.entities.Recipe;
import com.onwan.dietapp.services.RecipeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4212"})
public class RecipeController {
	
	@Autowired
	private RecipeService recipeSvc;
	
	@GetMapping("recipes")
	public List<Recipe> listAllRecipes(HttpServletResponse resp) {
		List<Recipe> recipes = recipeSvc.listAllRecipes();
		if (recipes == null) {
			resp.setStatus(404);
		}
		return recipes;
	}
	
	@GetMapping("recipes/{recipeId}")
	public Recipe show(@PathVariable("recipeId") int id, HttpServletRequest req, HttpServletResponse resp) {
		Recipe recipe = recipeSvc.findRecipe(id);
		if (recipe == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}
		return recipe;
	}
}
