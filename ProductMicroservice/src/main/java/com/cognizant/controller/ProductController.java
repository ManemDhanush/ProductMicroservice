package com.cognizant.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.model.Product;
import com.cognizant.service.ProductService;

@RestController
public class ProductController 
{

	@Autowired
	ProductService productService;

	@GetMapping("/product")
	private List<Product> getAllProducts() 
	{
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	private Product getProduct(@PathVariable("id") String id) 
	{
		return productService.getProductById(id);
	}

	@GetMapping("/products/{name}")
	private Product getProducts(@PathVariable("name") String name) 
	{
		return productService.getProductByName(name);
	}

	@DeleteMapping("/product/{id}")
	private void deleteProduct(@PathVariable("id") String id) 
	{
		productService.delete(id);
	}
 
	@PostMapping("/product")
	private String saveProduct(@RequestBody Product product) 
	{
		productService.saveOrUpdate(product);
		return product.getId();
	}
}
