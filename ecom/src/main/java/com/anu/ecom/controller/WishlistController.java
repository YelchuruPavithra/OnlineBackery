package com.anu.ecom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.ecom.dto.WishlistDto;
import com.anu.ecom.services.customer.WishlistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
@CrossOrigin(origins="http://localhost:4200/")
public class WishlistController {


private WishlistService wishlistService;


@PostMapping("/wishlist")
public ResponseEntity <?> addProductToWishlist(@RequestBody WishlistDto wishlistDto)
{
WishlistDto postedWishlistDto = wishlistService.addProductToWishlist(wishlistDto);
if(postedWishlistDto == null)
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
	return ResponseEntity.status(HttpStatus.CREATED).body(postedWishlistDto);
}


@GetMapping("/wishlist/{userId}")
public ResponseEntity<List<WishlistDto>> getWishlistByUserId(@PathVariable Long userId)
{
	return ResponseEntity.ok(wishlistService.getWishlistByUserId(userId));
}

}