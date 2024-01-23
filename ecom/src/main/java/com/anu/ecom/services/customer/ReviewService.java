package com.anu.ecom.services.customer;

import java.io.IOException;

import com.anu.ecom.dto.OrderedProductsResponseDto;
import com.anu.ecom.dto.ReviewDto;

public interface ReviewService 
{

	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
	ReviewDto giveReview(ReviewDto reviewDto) throws IOException ;
}