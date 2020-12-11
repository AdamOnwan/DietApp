package com.onwan.dietapp.services;

import java.util.List;

import com.onwan.dietapp.entities.Recipe;

public interface RecipeService {

	List<Recipe> listAllRecipes();

	Recipe findRecipe(int id);

}
