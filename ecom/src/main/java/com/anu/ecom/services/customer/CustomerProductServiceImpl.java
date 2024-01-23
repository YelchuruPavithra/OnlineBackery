package com.anu.ecom.services.customer;

import lombok. RequiredArgsConstructor;

import org. springframework.stereotype. Service;

import com.anu.ecom.dto.ProductDetailDto;
import com.anu.ecom.dto.ProductDto;
import com.anu.ecom.entity.FAQ;
import com.anu.ecom.entity.Product;
import com.anu.ecom.repository.FAQRepository;
import com.anu.ecom.repository.ProductRepository;
import com.anu.ecom.repository.ReviewRepository;
import com.anu.ecom.entity.Review;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService
{

	private ProductRepository productRepository;
	private FAQRepository faqRepository;
	private ReviewRepository reviewRepository;
	
	public List<ProductDto> getAllProducts()
	{
		List<Product> products = productRepository. findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	public List<ProductDto> searchProductByTitle(String name)
	{
		List<Product> products = productRepository.findAllByNameContaining(name);
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	public ProductDetailDto getProductDetailById(Long productId){
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct. isPresent()){
			List<FAQ> faqList = faqRepository.findAllByProductId(productId);
			List<Review> reviewsList = reviewRepository.findAllByProductId(productId);
			
			ProductDetailDto productDetailDto = new ProductDetailDto();

			productDetailDto.setProductDto(optionalProduct.get().getDto());
			productDetailDto.setFaqDtoList(faqList.stream().map(FAQ :: getFAQDto). collect(Collectors.toList()));
			productDetailDto.setReviewDtoList(reviewsList.stream().map(Review::getDto).collect(Collectors.toList()));

			return productDetailDto;
		}
		return null;
	}
}