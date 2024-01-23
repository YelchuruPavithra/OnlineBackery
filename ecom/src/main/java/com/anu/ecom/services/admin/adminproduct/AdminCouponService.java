package com.anu.ecom.services.admin.adminproduct;

import java.util.List;

import com.anu.ecom.entity.Coupon;

public interface AdminCouponService 
{
	Coupon createCoupon(Coupon coupon);

	List<Coupon> getAllCoupons();

	

}
