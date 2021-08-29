package com.spring.spring5recipeapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(exclude="notes")
public class Recipe {
	
    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private Integer source;
	private Integer url;
	
	@Lob
	private String directions;
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name="Recipe_Category",
	           joinColumns=@JoinColumn(name="recipe_id"),
	           inverseJoinColumns=@JoinColumn(name="category_id"))
	private Set<Category> categories = new HashSet<>();
	
/**** Getters and Setter ****/	
	
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}
	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		return this;
	}
		
}
