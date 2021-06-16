package com.cognizant;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.Product;
import com.cognizant.repository.ProductRepository;
import com.cognizant.service.ProductService;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductApplicationTests {
	
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllProductsTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new Product("P101","Pants", "Pants", 2500, 5 ),
				new Product("P102","Shirt", "Shirt", 3000, 4 )).collect(Collectors.toList()));
		
		assertEquals(2,service.getAllProducts().size());
		
	}
	
	
	
//	@Test
//	public void getProductByIdTest() 
//	{
//		
//		System.out.println("Entering into id test");
//		when(repository.findAll()).thenReturn(Stream.of(new Product("P101","Pants", "Pants", 2500, 5 )).collect(Collectors.toList()));
//		
//		// System.out.println(service.getProductById("P101"));
//		System.out.println(service.getProductById("P101"));
//		//System.out.println(service.getProductById("P101").getId());
//		//assertEquals("P101",service.getProductById("P101").getId());
//		
//	}

	
	

}
