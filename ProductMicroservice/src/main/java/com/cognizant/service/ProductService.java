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

	public Product getProductById(String id) 
	{
		return productRepository.findById(id).get();
	}

	public Product getProductByName(String name) 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> { if(product.getName().compareToIgnoreCase(name) == 0) {products.add(product); } });
		return products.get(0);
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