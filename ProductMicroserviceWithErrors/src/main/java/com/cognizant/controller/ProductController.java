package com.cognizant.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/searchProductById/{id}")
	private List<Product> getProduct(@PathVariable("id") String id) 
	{
		return productService.getProductById(id);
	}

	@GetMapping("/searchProductByName/{name}")
	private List<Product> getProducts(@PathVariable("name") String name) 
	{
		return productService.getProductByName(name);
	}
	
	@PostMapping("/product")
	private String saveProduct(@RequestBody Product product) 
	{
		productService.saveOrUpdate(product);
		return product.getId();
	}
	
	@RequestMapping(value = "/addProductRating", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("id") String id, @RequestParam("rating") int rating)
    {
		productService.saveOrUpdate(id,rating);
        return id;
    }
}
