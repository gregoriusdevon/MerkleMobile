package com.merkle.Data.Model.Users;

public class User {
	private String password;
	private Address address;
	private String phone;
	private Name name;
	private int id;
	private String email;
	private String username;
	private String token;

	public String getPassword(){
		return password;
	}

	public Address getAddress(){
		return address;
	}

	public String getPhone(){
		return phone;
	}

	public Name getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String getToken() {
		return token;
	}
}
