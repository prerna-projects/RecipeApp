package com.spring.spring5recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.spring5recipeapp.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	Optional<Category> findByCategoryName(String categoryName);
}
