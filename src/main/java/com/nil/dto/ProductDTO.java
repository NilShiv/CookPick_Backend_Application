package com.nil.dto;

public class ProductDTO {

	private Integer ProductId;
	private String ProductName;
	private String ProductVendor;
	private Double ProductPrice;
	private Integer ProductInStock;
	public Integer getProductId() {
		return ProductId;
	}
	public void setProductId(Integer productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductVendor() {
		return ProductVendor;
	}
	public void setProductVendor(String productVendor) {
		ProductVendor = productVendor;
	}
	public Double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}
	public Integer getProductInStock() {
		return ProductInStock;
	}
	public void setProductInStock(Integer productInStock) {
		ProductInStock = productInStock;
	}
	
	
}
