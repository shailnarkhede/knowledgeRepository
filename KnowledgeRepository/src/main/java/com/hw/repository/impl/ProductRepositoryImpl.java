package com.hw.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hw.repository.ProductRepository;
import com.hw.vo.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public List<Product> getAllProducts() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM PRODUCT where PARENT_ID is null";
	 
		List<Product> products = new ArrayList<Product>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Product product = new Product();
			product.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			product.setProductName((String)row.get("PRODUCT_NAME"));
			product.setFolderPath((String)row.get("FOLDER_PATH"));
			products.add(product);	
		}
	 
		for (Product product : products) {
			product = getChlids(product);
		}
		return products;
	}	

	
	public Product getChlids(Product srcProduct){
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM PRODUCT where PARENT_ID = "+srcProduct.getId();
		List<Product> products = new ArrayList<Product>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Product product = new Product();
			product.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			product.setProductName((String)row.get("PRODUCT_NAME"));
			product.setFolderPath((String)row.get("FOLDER_PATH"));
			products.add(product);	
			getChlids(product);
		}
		srcProduct.setChildProducts(products);
		return srcProduct;
	}
}
