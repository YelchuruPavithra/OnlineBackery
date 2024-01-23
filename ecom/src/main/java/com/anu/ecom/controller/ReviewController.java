package com.anu.ecom.controller;


import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.ecom.dto.OrderedProductsResponseDto;
import com.anu.ecom.dto.ReviewDto;
import com.anu.ecom.services.customer.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
@CrossOrigin(origins="http://localhost:4200/")
public class ReviewController {
	
	
	private ReviewService reviewService;

	
	@GetMapping("/ordered-products/{orderId}")
	public ResponseEntity<OrderedProductsResponseDto> getOrderedProductsDetailsByOrderId(@PathVariable Long orderId){
	return ResponseEntity.ok(reviewService.getOrderedProductsDetailsByOrderId(orderId));
	}
	
	@PostMapping("/review")
	public ResponseEntity <? > giveReview(@ModelAttribute ReviewDto reviewDto) throws IOException {
	ReviewDto reviewDto1 = reviewService.giveReview(reviewDto);
	if(reviewDto1 == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
	return ResponseEntity.status(HttpStatus.CREATED).body(reviewDto1);

}

}