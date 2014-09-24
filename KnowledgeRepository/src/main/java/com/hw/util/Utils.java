package com.hw.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hw.repository.ProductRepository;
import com.hw.vo.Product;

public class Utils {
	
	private static Utils utils = new Utils();
	private Utils(){}
	
	public static Utils getMenuUtils(){
		return utils;
	}
	public String getMenuString(){
		StringBuilder menuString = new StringBuilder();
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductRepository productRepository = (ProductRepository) ac.getBean("productDAO");
		List<Product> products = productRepository.getAllProducts();
		menuString.append("<nav> <ul class='nav'>");
		for (Product product : products) {
			menuString.append(getMenu(product));
		}
		menuString.append("</ul></nav>");
		return menuString.toString();
	}
	
	private StringBuilder getMenu(Product product){
		StringBuilder menu = new StringBuilder();
		menu.append("<li><a href='#'>");
		menu.append(product.getProductName());
		menu.append("</a>");
		
		List<Product> childs = product.getChildProducts();
		if(!childs.isEmpty())  menu.append("<ul>");
		for (Product child : childs) {
			menu.append(getMenu(child));
		}
		if(!childs.isEmpty())  menu.append("</ul>");
		menu.append("</li>");
		return menu;
	}
}
