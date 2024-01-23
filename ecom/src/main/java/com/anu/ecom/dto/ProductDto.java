package com.anu.ecom.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDto 
{
	
	private Long id;
	private String name;
	private Long price;
	
	
	private String description;
		
	private Long categoryId;
	private String categoryName;
	
	private byte[] byteimg;
	private MultipartFile img;
	private Long quantity;
	

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public byte[] getImg() {
		return byteimg;
	}

	public void setImg(byte[] img) {
		this.byteimg = img;
	}

	public Long getCategoryId() 
	{
		return categoryId;
	}

	public void setCategoryId(Long categoryId) 
	{
		this.categoryId = categoryId;
	}

	public byte[] getByteimg() 
	{
		return byteimg;
	}

	public void setByteimg(byte[] byteimg) 
	{
		this.byteimg = byteimg;
	}

	public void setImg(MultipartFile img) 
	{
		this.img = img;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
