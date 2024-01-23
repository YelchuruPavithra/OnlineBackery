package com.anu.ecom.services.customer;

import java.util.List;

import com.anu.ecom.dto.ProductDetailDto;
import com.anu.ecom.dto.ProductDto;

public interface CustomerProductService 
{
	List<ProductDto> searchProductByTitle(String title);
	List<ProductDto> getAllProducts();
	ProductDetailDto getProductDetailById(Long productId);
		
}
