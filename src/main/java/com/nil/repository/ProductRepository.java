package com.nil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nil.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	public List<Product> findByProductName(String ProductName);
	
	public List<Product> findByProductNameAndProductVendor(String productName, String productVendor);
}
