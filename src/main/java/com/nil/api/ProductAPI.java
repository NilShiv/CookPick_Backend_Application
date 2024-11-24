package com.nil.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nil.dto.ProductDTO;
import com.nil.exception.CookPickException;
import com.nil.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "/CookPick")
public class ProductAPI {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/greet")
	public ResponseEntity<String> greet(){
		String m = productServiceImpl.greet();
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
	
	@PostMapping(value = "/product")
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) throws CookPickException{
		productServiceImpl.addProduct(productDTO);
		String message = environment.getProperty("Product.Added_Success");
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/product/{productId}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId) throws CookPickException{
		ProductDTO productDTO = productServiceImpl.getProduct(productId);
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/products/{productName}")
	public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String productName) throws CookPickException{
		List<ProductDTO> productDTOs= productServiceImpl.getProducts(productName);
		return new ResponseEntity<List<ProductDTO>>(productDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/productss")
	public ResponseEntity<List<ProductDTO>> getProductByNameAndVendor(@RequestParam(value = "productName") String productName , @RequestParam(value = "productVendor") String productVendor) throws CookPickException{
		List<ProductDTO> productDTOs= productServiceImpl.getProducts(productName, productVendor);
		return new ResponseEntity<List<ProductDTO>>(productDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId) throws CookPickException{
		productServiceImpl.deleteProduct(productId);
		String success = environment.getProperty("Product.Deleted_Success");
		return new ResponseEntity<String>(success, HttpStatus.OK);
	}
}
