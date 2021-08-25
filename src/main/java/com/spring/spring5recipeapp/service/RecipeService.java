package com.spring.spring5recipeapp.service;

import java.util.Set;

import com.spring.spring5recipeapp.domain.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();
}
