package com.anu.ecom.services.customer;

import java.util.List;

import com.anu.ecom.dto.WishlistDto;

public interface WishlistService {
	
	WishlistDto addProductToWishlist(WishlistDto wishlistDto);
	List<WishlistDto> getWishlistByUserId(Long userId);
}