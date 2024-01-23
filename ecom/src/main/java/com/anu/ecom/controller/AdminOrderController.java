package com.anu.ecom.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org. springframework.web.bind.annotation. RestController;

import com.anu.ecom.dto.AnalyticsResponse;
import com.anu.ecom.dto.OrderDto;
import com.anu.ecom.services.admin.adminproduct.AdminOrderService;

import lombok.RequiredArgsConstructor;

import java.util. List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200/")
public class AdminOrderController 
{

	private AdminOrderService adminOrderService;

	@GetMapping("/placedOrders")
	public ResponseEntity<List<OrderDto>> getAllPlacedOrders(){
		return ResponseEntity.ok(adminOrderService.getAllPlacedOrders());
	}
	
	@GetMapping("/order/{orderId}/{status}")
	public ResponseEntity <?> changeOrderStatus(@PathVariable Long orderId, @PathVariable String status){
		OrderDto orderDto = adminOrderService.changeOrderStatus(orderId, status);
		if(orderDto == null)
			return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.OK).body(orderDto);

	}
	
	
@GetMapping("/order/analytics")
public ResponseEntity<AnalyticsResponse> getAnalytics()
{
return ResponseEntity.ok(adminOrderService.calculateAnalytics());
}


}