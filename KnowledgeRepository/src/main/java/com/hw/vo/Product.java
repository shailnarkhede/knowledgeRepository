package com.hw.vo;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;
	private String productName;
	private String folderPath;
	List<Product> childProducts = new ArrayList<Product>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<Product> getChildProducts() {
		return childProducts;
	}
	public void setChildProducts(List<Product> childProducts) {
		this.childProducts = childProducts;
	}
	
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
}
