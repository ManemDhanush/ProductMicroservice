package com.cognizant.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.model.Product;
import com.cognizant.repository.ProductRepository;

@Service
public class ProductService 
{
//	private static ProductService service;
//	
//	private ProductService()
//	{
//		
//	}
//	
//	public static ProductService getInstance()
//	{
//		if(service == null)
//			service = new ProductService();
//		return service;
//	}
	
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
		productRepository.findAll().forEach(product -> products.add(product));
		return products.stream().filter(c -> (c.getId().toLowerCase()).contains(id.toLowerCase())).collect(Collectors.toList());
	}

	public List<Product> getProductByName(String name) 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products.stream().filter(c -> (c.getName().toLowerCase()).contains(name.toLowerCase())).collect(Collectors.toList());
	}
	
//	public void saveOrUpdate(Product product) 
//	{
//		productRepository.save(product);
//	}
	
	public void saveOrUpdate(String id, int rating) 
	{
		Product product = productRepository.findById(id).get();
		product.setRating(rating);
		productRepository.save(product);
	}

}
