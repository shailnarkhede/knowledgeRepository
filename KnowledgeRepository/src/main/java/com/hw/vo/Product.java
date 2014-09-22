package com.hw.vo;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;
	private String productName;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childProducts == null) ? 0 : childProducts.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (childProducts == null) {
			if (other.childProducts != null)
				return false;
		} else if (!childProducts.equals(other.childProducts))
			return false;
		if (id != other.id)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}
}
