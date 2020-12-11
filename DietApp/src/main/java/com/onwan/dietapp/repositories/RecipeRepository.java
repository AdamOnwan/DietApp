package com.onwan.dietapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onwan.dietapp.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	
}