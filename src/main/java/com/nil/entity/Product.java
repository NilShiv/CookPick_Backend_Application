package com.nil.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Override
	public int hashCode() {
		return Objects.hash(ProductId, ProductInStock, ProductName, ProductPrice, ProductVendor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(ProductId, other.ProductId) && Objects.equals(ProductInStock, other.ProductInStock)
				&& Objects.equals(ProductName, other.ProductName) && Objects.equals(ProductPrice, other.ProductPrice)
				&& Objects.equals(ProductVendor, other.ProductVendor);
	}
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductVendor=" + ProductVendor
				+ ", ProductPrice=" + ProductPrice + ", ProductInStock=" + ProductInStock + "]";
	}
	
	
}
