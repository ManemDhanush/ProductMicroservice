package com.cognizant.repository;
import org.springframework.data.repository.CrudRepository;
import com.cognizant.model.Product;
public interface ProductRepository extends CrudRepository<Product, String>
{
}
