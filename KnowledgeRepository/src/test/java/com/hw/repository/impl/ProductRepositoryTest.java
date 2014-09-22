package com.hw.repository.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hw.repository.ProductRepository;
import com.hw.vo.Product;


public class ProductRepositoryTest extends Assert{
	
	
	ProductRepository productRepository = new ProductRepositoryImpl();
	ApplicationContext ac;
	
	@Before
	public void startUp(){
		ac = new ClassPathXmlApplicationContext("file:src/main/resources/applicationContext.xml");
		productRepository = (ProductRepository) ac.getBean("productDAO");
	}
	
	@Test
	public void testGetAllProducts(){
		List<Product> products = productRepository.getAllProducts();
		System.out.println(products);
	}
}
