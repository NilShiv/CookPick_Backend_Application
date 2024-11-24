package com.nil.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nil.dto.ProductDTO;
import com.nil.entity.Product;
import com.nil.exception.CookPickException;
import com.nil.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Environment environment;
	
	@Override
	public String greet() {
		LocalDate date = LocalDate.now();
		String day = date.getDayOfWeek().toString().toLowerCase();
		String message = ("Welcome to "+ day+" sale");
		return message;
	}

	@Override
	public String addProduct(ProductDTO productDTO) throws CookPickException {
		Optional<Product> list= productRepository.findById(productDTO.getProductId());
		if(list.isPresent()) {
			throw new CookPickException("Product.Already_Present");
		}
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setProductVendor(productDTO.getProductVendor());
		product.setProductInStock(productDTO.getProductInStock());
		productRepository.save(product);
		return environment.getProperty("Product.Added_Success");
	}

	@Override
	public ProductDTO getProduct(Integer productId) throws CookPickException {
		Optional<Product> list= productRepository.findById(productId);
		Product product= list.orElseThrow(() -> new CookPickException("Product.Product_Id_Not_Avaliable"));
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductPrice(product.getProductPrice());	
		productDTO.setProductVendor(product.getProductVendor());
		productDTO.setProductInStock(product.getProductInStock());
		
		return productDTO;
	}

	@Override
	public List<ProductDTO> getProducts(String productName) throws CookPickException {
		List<Product> products= productRepository.findByProductName(productName);
		if(products.isEmpty()) {
			throw new CookPickException("Product.Product_Name_Not_Present");
		}
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product Product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(Product.getProductId());
			productDTO.setProductName(Product.getProductName());
			productDTO.setProductPrice(Product.getProductPrice());	
			productDTO.setProductVendor(Product.getProductVendor());
			productDTO.setProductInStock(Product.getProductInStock());
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProducts(String productName, String productVendor) throws CookPickException {
		List<Product> products= productRepository.findByProductNameAndProductVendor(productName, productVendor);
		if(products.isEmpty()) {
			throw new CookPickException("Product.Product_Name_And_Vendor_Not_Present");
		}
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product Product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(Product.getProductId());
			productDTO.setProductName(Product.getProductName());
			productDTO.setProductPrice(Product.getProductPrice());	
			productDTO.setProductVendor(Product.getProductVendor());
			productDTO.setProductInStock(Product.getProductInStock());
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public void deleteProduct(Integer productId) throws CookPickException {
		Optional<Product> list= productRepository.findById(productId);
		if(list.isEmpty()) {
			throw new CookPickException("Product.Product_Not_Found");
		}
		productRepository.deleteById(productId);
	}

}
