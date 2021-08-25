package com.spring.spring5recipeapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.spring5recipeapp.domain.Recipe;
import com.spring.spring5recipeapp.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		
		Set<Recipe> recipeSet = new HashSet<Recipe>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
	
	
	
}
