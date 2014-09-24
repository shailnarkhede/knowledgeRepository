package com.hw.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hw.repository.ProductRepository;

public class UtilsTest extends Assert{
	ProductRepository productRepository;
	
	@Before
	public void startUp(){
	}
	
	@Test
	public void testGetMenuString(){
		String menuString = Utils.getMenuUtils().getMenuString();
		System.out.println(menuString);
	}
}
