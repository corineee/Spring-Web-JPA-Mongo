package com.bharath.springdata.mongodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.springdata.mongodb.model.Product;
import com.bharath.springdata.mongodb.repos.ProductRepository;

@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProductRepository repos;
	
	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Mac Book Pro");
		product.setPrice(2000f);
		Product saveProduct = repos.save(product);
		assertNotNull(saveProduct);
	}
	
	@Test
	void testFindAll() {
		List<Product> products = repos.findAll();
		assertEquals(1, products.size());
	}
	 
	@Test
	void testDelete() {
		repos.deleteById("62886b8255e8562900c5b2a1");
		Optional<Product> product = repos.findById("62886b8255e8562900c5b2a1");
		assertEquals(Optional.empty(), product);
	}

}
