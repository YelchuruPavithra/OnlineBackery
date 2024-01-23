package com.anu.ecom.services.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anu.ecom.dto.WishlistDto;
import com.anu.ecom.entity.Product;
import com.anu.ecom.entity.User;
import com.anu.ecom.entity.Wishlist;
import com.anu.ecom.repository.ProductRepository;
import com.anu.ecom.repository.UserRepository;
import com.anu.ecom.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	
	
	private UserRepository userRepository;

	private ProductRepository productRepository;

	
	private WishlistRepository wishlistRepository;

	
	public WishlistDto addProductToWishlist(WishlistDto wishlistDto){
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());

	if(optionalProduct.isPresent() && optionalUser.isPresent()){
		Wishlist wishlist = new Wishlist();
		wishlist.setProduct(optionalProduct.get());
		wishlist.setUser(optionalUser.get());

		return wishlistRepository.save(wishlist).getWishlistDto();
	}
	return null;
	}

	public List<WishlistDto> getWishlistByUserId(Long userId)
	{
		return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());)
	}
}