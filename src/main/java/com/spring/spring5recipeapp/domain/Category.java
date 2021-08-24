package com.spring.spring5recipeapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String categoryName;
	
	@ManyToMany(mappedBy="categories")
	private Set<Recipe> recipes;
	
/**** Getters and Setters ****/
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
	
}
