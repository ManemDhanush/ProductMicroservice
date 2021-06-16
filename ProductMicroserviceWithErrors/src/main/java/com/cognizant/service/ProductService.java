package com.cognizant.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.model.Product;
import com.cognizant.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;
	public List<Product> getAllProducts() 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}

	public List<Product> getProductById(String id) 
	{
		List<Product> products = new ArrayList<Product>();
		products.add(productRepository.findById(id).get());
		return products;
	}

	public List<Product> getProductByName(String name) 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> { if(product.getName().compareToIgnoreCase(name) == 0) {products.add(product); } });
		return products;
	}
	
	public void saveOrUpdate(Product product) 
	{
		productRepository.save(product);
	}
	
	public void saveOrUpdate(String id, int rating) 
	{
		Product product = productRepository.findById(id).get();
		product.setRating(rating);
		productRepository.save(product);
	}

}