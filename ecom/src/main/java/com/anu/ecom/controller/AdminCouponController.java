package com.anu.ecom.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.ecom.entity.Coupon;
import com.anu.ecom.exceptions.ValidationException;
import com.anu.ecom.services.admin.adminproduct.AdminCouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/coupons")
@CrossOrigin(origins="http://localhost:4200/")
@RequiredArgsConstructor
public class AdminCouponController {
	
	private AdminCouponService adminCouponService;
	
	public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon){
		try {
			Coupon createdCoupon = adminCouponService.createCoupon(coupon);
			return ResponseEntity.ok(createdCoupon);
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Coupon>> getAllCoupons()
	{
		return ResponseEntity.ok(adminCouponService.getAllCoupons());
	}
	
}