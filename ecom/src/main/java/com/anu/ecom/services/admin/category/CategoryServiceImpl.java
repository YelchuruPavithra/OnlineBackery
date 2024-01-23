package com.anu.ecom.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anu.ecom.dto.CategoryDto;
import com.anu.ecom.entity.Category;
import com.anu.ecom.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	public Category createcategory(CategoryDto categoryDto)
	{
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAll();
	}
	
}
