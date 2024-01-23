package com.anu.ecom.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderedProductsResponseDto {

	
	private List<ProductDto> productDtoList;
	private Long orderAmount;
	public List<ProductDto> getProductDtoList() {
		return productDtoList;
	}
	public void setProductDtoList(List<ProductDto> productDtoList) {
		this.productDtoList = productDtoList;
	}
	public Long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}