package com.cognizant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.Product;
import com.cognizant.repository.ProductRepository;
import com.cognizant.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ProductApplicationTests {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private ProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void getAllProductTest() throws JSONException
	{
		//when(repository.findAll()).thenReturn(Stream.of(new Product("P101","Pants", "Pants", 2500, 5 ),
			//	new Product("P102","Shirt", "Shirt", 3000, 4 )).collect(Collectors.toList()));
		List<Product> test = new ArrayList<>();
		test.add(new Product("P101","Shirt", "Shirt", 3000, 4 ));
		
		String head = "{\"id\": \"P101\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(head, headers);
		System.err.println( restTemplate.exchange("/getVendorDetails/P101", HttpMethod.GET, entity,  new ParameterizedTypeReference<List<Product>>() {}).getClass());
        // List<Product> result=response.getBody();
		
		// assertEquals(test.get(0).getId(),result.get(0).getId());
		
	}
	
	@Test
	public void getAllProductsTest() 
	{
		when(repository.findAll()).thenReturn(Stream.of(new Product("P101","Pants", "Pants", 2500, 5 ),
				new Product("P102","Shirt", "Shirt", 3000, 4 )).collect(Collectors.toList()));
		
		assertEquals(2,service.getAllProducts().size());
		
	}
	
	
	
	@Test
	public void getProductByIdTest() 
	{
		String id = "P101";
		Product p = new Product();
		p.setId("P101");
		p.setName("Pants");
		p.setDescription("Pants");
		p.setPrice(2500);
		p.setRating(5);
		Optional<Product> product = Optional.of(p); 
		when(repository.findById(id)).thenReturn(product);
		
		assertEquals(1,service.getProductById("P101").size());
		
	}
	
	@Test
	public void getProductByNameTest() 
	{
		String id = "P101";
		Product p = new Product();
		p.setId("P101");
		p.setName("Pants");
		p.setDescription("Pants");
		p.setPrice(2500);
		p.setRating(5);
		Optional<Product> product = Optional.of(p); 
		when(repository.findById(id)).thenReturn(product);
		
		assertEquals(0,service.getProductByName("Shirt").size());
		
	}
	
	@Test
	public void mainTest() 
	{
		String[] st = new String[1];
		st[0] = "";
		ProductApplication.main(st);
	}
	
	@Test
	public void setAndgetProductTest() 
	{
		Product p = new Product();
		p.setId("P101");
		p.setName("Pants");
		p.setDescription("Pants");
		p.setPrice(2500);
		p.setRating(5);
		Product copy = new Product();
		copy.setId(p.getId());
		copy.setDescription(p.getDescription());
		copy.setName(p.getName());
		copy.setPrice(p.getPrice());
		copy.setRating(p.getRating());
		// assertEquals(p.toString().length(),copy.toString().length());
		
	}

	
	

}
