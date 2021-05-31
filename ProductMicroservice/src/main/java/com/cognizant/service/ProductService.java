package com.cognizant.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.model.Product;
import com.cognizant.repository.ProductRepository;
//defining the business logic
@Service
public class ProductService 
{
@Autowired
	ProductRepository productRepository;
//getting all product records
	public List<Product> getAllProducts() 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> products.add(product));
		return products;
	}
	//getting a specific record with id
	public Product getProductById(String id) 
	{
		return productRepository.findById(id).get();
	}
	//getting a specific record by name
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
	//deleting a specific record
	public void delete(String id)
	{
		productRepository.deleteById(id);
	}
}