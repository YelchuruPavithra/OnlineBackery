package com.anu.ecom.services.admin.category;

import java.util.List;

import com.anu.ecom.dto.CategoryDto;
import com.anu.ecom.entity.Category;

public interface CategoryService {
	
	Category createcategory(CategoryDto categoryDto);
	List<Category> getAllCategories();

}
