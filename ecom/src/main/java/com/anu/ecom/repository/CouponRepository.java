package com.anu.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.ecom.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long>
{
	boolean existsBycode(String code);
	
	Optional<Coupon> findByCode(String code);
}
