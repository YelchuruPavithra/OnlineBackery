package com.anu.ecom.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anu.ecom.dto.OrderDto;
import com.anu.ecom.services.customer.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class TrackingController {
	
	private CartService cartService;
	
	
	@GetMapping("/order/{trackingId}")
	public ResponseEntity<OrderDto> searchOrderByTrackingId(@PathVariable UUID trackingId){
		OrderDto orderDto = cartService.searchOrderByTrackingId(trackingId);
		if(orderDto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(orderDto);
	}
}