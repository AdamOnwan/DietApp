package com.onwan.dietapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onwan.dietapp.entities.Recipe;
import com.onwan.dietapp.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	@Override
	public List<Recipe> listAllRecipes() {
		return recipeRepo.findAll();
	}
	
	@Override
	public Recipe findRecipe(int id) {
		Recipe recipe = null;
		Optional<Recipe> opt = recipeRepo.findById(id);
		if(opt.isPresent()) {
			recipe = opt.get();
		}
		return recipe;
	}
}
