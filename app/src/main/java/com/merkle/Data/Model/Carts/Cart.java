package com.merkle.Data.Model.Carts;

import java.util.List;

public class Cart{
	private String date;
	private int id;
	private int userId;
	private List<ProductsItem> products;

	public String getDate(){
		return date;
	}

	public int getId(){
		return id;
	}

	public int getUserId(){
		return userId;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}