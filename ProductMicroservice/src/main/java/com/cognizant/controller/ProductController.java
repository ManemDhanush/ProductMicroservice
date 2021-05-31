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
//creating RestController
@RestController
public class ProductController 
{
//autowired the StudentService class
@Autowired
ProductService productService;
//creating a get mapping that retrieves all the products detail from the database 
@GetMapping("/product")
private List<Product> getAllProducts() 
{
return productService.getAllProducts();
}
//creating a get mapping that retrieves the detail of a specific product by id
@GetMapping("/product/{id}")
private Product getProduct(@PathVariable("id") String id) 
{
return productService.getProductById(id);
}
//creating a get mapping that retrieves the detail of a specific product by name
@GetMapping("/products/{name}")
private Product getProducts(@PathVariable("name") String name) 
{
return productService.getProductByName(name);
}
//creating a delete mapping that deletes a specific product
@DeleteMapping("/product/{id}")
private void deleteProduct(@PathVariable("id") String id) 
{
productService.delete(id);
}
//creating post mapping that post the product detail in the database
@PostMapping("/product")
private String saveProduct(@RequestBody Product product) 
{
productService.saveOrUpdate(product);
return product.getId();
}
}
