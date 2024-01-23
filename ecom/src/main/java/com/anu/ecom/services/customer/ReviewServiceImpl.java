package com.anu.ecom.services.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anu.ecom.dto.OrderedProductsResponseDto;
import com.anu.ecom.dto.ProductDto;
import com.anu.ecom.dto.ReviewDto;
import com.anu.ecom.entity.CartItems;
import com.anu.ecom.entity.Order;
import com.anu.ecom.entity.Product;
import com.anu.ecom.entity.Review;
import com.anu.ecom.entity.User;
import com.anu.ecom.repository.OrderRepository;
import com.anu.ecom.repository.ProductRepository;
import com.anu.ecom.repository.ReviewRepository;
import com.anu.ecom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
	
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	private UserRepository userRepository;
	
	private ReviewRepository reviewRepository;
	
	public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId){
	Optional<Order> optionalOrder = orderRepository.findById(orderId);
	OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
	if(optionalOrder. isPresent()){
		orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

	List<ProductDto> productDtoList = new ArrayList<>();
	for (CartItems cartItems: optionalOrder.get().getCartItems()){
	ProductDto productDto = new ProductDto();

	productDto.setId(cartItems.getProduct().getId());
	productDto.setName(cartItems.getProduct().getName());
	productDto.setPrice(cartItems.getPrice());
	productDto.setQuantity(cartItems.getQuantity());
	productDto.setByteimg(cartItems.getProduct().getImg());
	
	productDtoList.add(productDto);
	}

	orderedProductsResponseDto.setProductDtoList(productDtoList);
	}

	return orderedProductsResponseDto;
	}
	
	public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());

		if(optionalProduct.isPresent() && optionalUser.isPresent()){
		Review review = new Review();

		review.setRating(reviewDto.getRating());
		review.setDescription(reviewDto.getDescription());
		review.setUser(optionalUser.get());
		review.setProduct(optionalProduct.get());
		review.setImg(reviewDto.getImg().getBytes());

		return reviewRepository.save(review).getDto();
		}

		return null;

		}
	
	}