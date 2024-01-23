package com.anu.ecom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.ecom.dto.CategoryDto;
import com.anu.ecom.entity.Category;
import com.anu.ecom.services.admin.category.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class AdminCategoryController 
{
	private CategoryService categoryService;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto)
	{
		Category category = categoryService.createcategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories()
	{
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
}
