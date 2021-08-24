package com.spring.spring5recipeapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.spring5recipeapp.domain.Category;
import com.spring.spring5recipeapp.domain.UnitOfMeasure;
import com.spring.spring5recipeapp.repositories.CategoryRepository;
import com.spring.spring5recipeapp.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
		
	@Autowired
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"","/","/index"})
	
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByCategoryName("Mexican");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Ounce");
		
		System.out.println(categoryOptional.get().getId());
		System.out.println(unitOfMeasureOptional.get().getId());
		
		return "index";
	}
	

}
