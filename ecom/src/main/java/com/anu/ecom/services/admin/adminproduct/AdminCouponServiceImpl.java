package com.anu.ecom.services.admin.adminproduct;


import java.util.List;

import org.springframework.stereotype.Service;

import com.anu.ecom.entity.Coupon;
import com.anu.ecom.exceptions.ValidationException;
import com.anu.ecom.repository.CouponRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class AdminCouponServiceImpl implements AdminCouponService {
	
	private CouponRepository couponRepository;
	
	public Coupon createCoupon(Coupon coupon) {
		if(couponRepository.existsBycode(coupon.getCode())) {
			throw new ValidationException("Coupon code already exists.");
			
		}
		return couponRepository.save(coupon);
		}
	public List<Coupon> getAllCoupons()
	{
		return couponRepository.findAll();
	}
	
}