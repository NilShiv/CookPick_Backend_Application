package com.nil.service;

import java.util.List;

import com.nil.dto.ProductDTO;
import com.nil.exception.CookPickException;

public interface ProductService {

	public String greet();
	public String addProduct(ProductDTO productDTO) throws CookPickException;
	public ProductDTO getProduct(Integer productId) throws CookPickException;
	public List<ProductDTO> getProducts(String productName) throws CookPickException;
	public List<ProductDTO> getProducts(String productName, String productVendor) throws CookPickException;
	public void deleteProduct(Integer productId) throws CookPickException;
}
