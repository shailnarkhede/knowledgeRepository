package com.hw.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hw.vo.Product;

public class ProductRowMapper implements RowMapper<Product>{
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("ID"));
		product.setProductName(rs.getString("PRODUCT_NAME"));
		return product;
	}
}
